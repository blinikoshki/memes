package com.downloader.internal;

import com.downloader.Error;
import com.downloader.Progress;
import com.downloader.Response;
import com.downloader.Status;
import com.downloader.database.DownloadModel;
import com.downloader.handler.ProgressHandler;
import com.downloader.httpclient.HttpClient;
import com.downloader.internal.stream.FileDownloadOutputStream;
import com.downloader.internal.stream.FileDownloadRandomAccessFile;
import com.downloader.request.DownloadRequest;
import com.downloader.utils.Utils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class DownloadTask {
    private static final int BUFFER_SIZE = 4096;
    private static final long MIN_BYTES_FOR_SYNC = 65536;
    private static final long TIME_GAP_FOR_SYNC = 2000;
    private String eTag;
    private HttpClient httpClient;
    private InputStream inputStream;
    private boolean isResumeSupported;
    private long lastSyncBytes;
    private long lastSyncTime;
    private FileDownloadOutputStream outputStream;
    private ProgressHandler progressHandler;
    private final DownloadRequest request;
    private int responseCode;
    private String tempPath;
    private long totalBytes;

    private DownloadTask(DownloadRequest downloadRequest) {
        this.request = downloadRequest;
    }

    static DownloadTask create(DownloadRequest downloadRequest) {
        return new DownloadTask(downloadRequest);
    }

    /* access modifiers changed from: package-private */
    public Response run() {
        Response response = new Response();
        if (this.request.getStatus() == Status.CANCELLED) {
            response.setCancelled(true);
            return response;
        } else if (this.request.getStatus() == Status.PAUSED) {
            response.setPaused(true);
            return response;
        } else {
            try {
                if (this.request.getOnProgressListener() != null) {
                    this.progressHandler = new ProgressHandler(this.request.getOnProgressListener());
                }
                this.tempPath = Utils.getTempPath(this.request.getDirPath(), this.request.getFileName());
                File file = new File(this.tempPath);
                DownloadModel downloadModelIfAlreadyPresentInDatabase = getDownloadModelIfAlreadyPresentInDatabase();
                DownloadModel downloadModel = null;
                if (downloadModelIfAlreadyPresentInDatabase != null) {
                    if (file.exists()) {
                        this.request.setTotalBytes(downloadModelIfAlreadyPresentInDatabase.getTotalBytes());
                        this.request.setDownloadedBytes(downloadModelIfAlreadyPresentInDatabase.getDownloadedBytes());
                    } else {
                        removeNoMoreNeededModelFromDatabase();
                        this.request.setDownloadedBytes(0);
                        this.request.setTotalBytes(0);
                        downloadModelIfAlreadyPresentInDatabase = null;
                    }
                }
                HttpClient httpClient2 = ComponentHolder.getInstance().getHttpClient();
                this.httpClient = httpClient2;
                httpClient2.connect(this.request);
                if (this.request.getStatus() != Status.CANCELLED) {
                    if (this.request.getStatus() != Status.PAUSED) {
                        HttpClient redirectedConnectionIfAny = Utils.getRedirectedConnectionIfAny(this.httpClient, this.request);
                        this.httpClient = redirectedConnectionIfAny;
                        this.responseCode = redirectedConnectionIfAny.getResponseCode();
                        this.eTag = this.httpClient.getResponseHeader("ETag");
                        if (!checkIfFreshStartRequiredAndStart(downloadModelIfAlreadyPresentInDatabase)) {
                            downloadModel = downloadModelIfAlreadyPresentInDatabase;
                        }
                        if (isSuccessful()) {
                            setResumeSupportedOrNot();
                            this.totalBytes = this.request.getTotalBytes();
                            if (!this.isResumeSupported) {
                                deleteTempFile();
                            }
                            if (this.totalBytes == 0) {
                                long contentLength = this.httpClient.getContentLength();
                                this.totalBytes = contentLength;
                                this.request.setTotalBytes(contentLength);
                            }
                            if (this.isResumeSupported && downloadModel == null) {
                                createAndInsertNewModel();
                            }
                            if (this.request.getStatus() != Status.CANCELLED) {
                                if (this.request.getStatus() != Status.PAUSED) {
                                    this.request.deliverStartEvent();
                                    this.inputStream = this.httpClient.getInputStream();
                                    byte[] bArr = new byte[4096];
                                    if (!file.exists()) {
                                        if (file.getParentFile() == null || file.getParentFile().exists()) {
                                            file.createNewFile();
                                        } else if (file.getParentFile().mkdirs()) {
                                            file.createNewFile();
                                        }
                                    }
                                    this.outputStream = FileDownloadRandomAccessFile.create(file);
                                    if (this.isResumeSupported && this.request.getDownloadedBytes() != 0) {
                                        this.outputStream.seek(this.request.getDownloadedBytes());
                                    }
                                    if (this.request.getStatus() != Status.CANCELLED) {
                                        if (this.request.getStatus() != Status.PAUSED) {
                                            while (true) {
                                                int read = this.inputStream.read(bArr, 0, 4096);
                                                if (read != -1) {
                                                    this.outputStream.write(bArr, 0, read);
                                                    DownloadRequest downloadRequest = this.request;
                                                    downloadRequest.setDownloadedBytes(downloadRequest.getDownloadedBytes() + ((long) read));
                                                    sendProgress();
                                                    syncIfRequired(this.outputStream);
                                                    if (this.request.getStatus() != Status.CANCELLED) {
                                                        if (this.request.getStatus() == Status.PAUSED) {
                                                            sync(this.outputStream);
                                                            response.setPaused(true);
                                                            break;
                                                        }
                                                    } else {
                                                        response.setCancelled(true);
                                                        break;
                                                    }
                                                } else {
                                                    Utils.renameFileName(this.tempPath, Utils.getPath(this.request.getDirPath(), this.request.getFileName()));
                                                    response.setSuccessful(true);
                                                    if (this.isResumeSupported) {
                                                        removeNoMoreNeededModelFromDatabase();
                                                    }
                                                }
                                            }
                                        } else {
                                            response.setPaused(true);
                                        }
                                    } else {
                                        response.setCancelled(true);
                                    }
                                } else {
                                    response.setPaused(true);
                                }
                            } else {
                                response.setCancelled(true);
                            }
                        } else {
                            Error error = new Error();
                            error.setServerError(true);
                            error.setServerErrorMessage(convertStreamToString(this.httpClient.getErrorStream()));
                            error.setHeaderFields(this.httpClient.getHeaderFields());
                            error.setResponseCode(this.responseCode);
                            response.setError(error);
                        }
                    } else {
                        response.setPaused(true);
                    }
                } else {
                    response.setCancelled(true);
                }
                closeAllSafely(this.outputStream);
                return response;
            } catch (IOException | IllegalAccessException e) {
                if (!this.isResumeSupported) {
                    deleteTempFile();
                }
                Error error2 = new Error();
                error2.setConnectionError(true);
                error2.setConnectionException(e);
                response.setError(error2);
            } catch (Throwable th) {
                closeAllSafely(this.outputStream);
                throw th;
            }
        }
        closeAllSafely(this.outputStream);
        return response;
    }

    private void deleteTempFile() {
        File file = new File(this.tempPath);
        if (file.exists()) {
            file.delete();
        }
    }

    private boolean isSuccessful() {
        int i = this.responseCode;
        return i >= 200 && i < 300;
    }

    private void setResumeSupportedOrNot() {
        this.isResumeSupported = this.responseCode == 206;
    }

    private boolean checkIfFreshStartRequiredAndStart(DownloadModel downloadModel) throws IOException, IllegalAccessException {
        if (this.responseCode != 416 && !isETagChanged(downloadModel)) {
            return false;
        }
        if (downloadModel != null) {
            removeNoMoreNeededModelFromDatabase();
        }
        deleteTempFile();
        this.request.setDownloadedBytes(0);
        this.request.setTotalBytes(0);
        HttpClient httpClient2 = ComponentHolder.getInstance().getHttpClient();
        this.httpClient = httpClient2;
        httpClient2.connect(this.request);
        HttpClient redirectedConnectionIfAny = Utils.getRedirectedConnectionIfAny(this.httpClient, this.request);
        this.httpClient = redirectedConnectionIfAny;
        this.responseCode = redirectedConnectionIfAny.getResponseCode();
        return true;
    }

    private boolean isETagChanged(DownloadModel downloadModel) {
        return (this.eTag == null || downloadModel == null || downloadModel.getETag() == null || downloadModel.getETag().equals(this.eTag)) ? false : true;
    }

    private DownloadModel getDownloadModelIfAlreadyPresentInDatabase() {
        return ComponentHolder.getInstance().getDbHelper().find(this.request.getDownloadId());
    }

    private void createAndInsertNewModel() {
        DownloadModel downloadModel = new DownloadModel();
        downloadModel.setId(this.request.getDownloadId());
        downloadModel.setUrl(this.request.getUrl());
        downloadModel.setETag(this.eTag);
        downloadModel.setDirPath(this.request.getDirPath());
        downloadModel.setFileName(this.request.getFileName());
        downloadModel.setDownloadedBytes(this.request.getDownloadedBytes());
        downloadModel.setTotalBytes(this.totalBytes);
        downloadModel.setLastModifiedAt(System.currentTimeMillis());
        ComponentHolder.getInstance().getDbHelper().insert(downloadModel);
    }

    private void removeNoMoreNeededModelFromDatabase() {
        ComponentHolder.getInstance().getDbHelper().remove(this.request.getDownloadId());
    }

    private void sendProgress() {
        ProgressHandler progressHandler2;
        if (this.request.getStatus() != Status.CANCELLED && (progressHandler2 = this.progressHandler) != null) {
            progressHandler2.obtainMessage(1, new Progress(this.request.getDownloadedBytes(), this.totalBytes)).sendToTarget();
        }
    }

    private void syncIfRequired(FileDownloadOutputStream fileDownloadOutputStream) {
        long downloadedBytes = this.request.getDownloadedBytes();
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.lastSyncTime;
        if (downloadedBytes - this.lastSyncBytes > 65536 && j > TIME_GAP_FOR_SYNC) {
            sync(fileDownloadOutputStream);
            this.lastSyncBytes = downloadedBytes;
            this.lastSyncTime = currentTimeMillis;
        }
    }

    private void sync(FileDownloadOutputStream fileDownloadOutputStream) {
        boolean z;
        try {
            fileDownloadOutputStream.flushAndSync();
            z = true;
        } catch (IOException e) {
            e.printStackTrace();
            z = false;
        }
        if (z && this.isResumeSupported) {
            ComponentHolder.getInstance().getDbHelper().updateProgress(this.request.getDownloadId(), this.request.getDownloadedBytes(), System.currentTimeMillis());
        }
    }

    private void closeAllSafely(FileDownloadOutputStream fileDownloadOutputStream) {
        HttpClient httpClient2 = this.httpClient;
        if (httpClient2 != null) {
            try {
                httpClient2.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        InputStream inputStream2 = this.inputStream;
        if (inputStream2 != null) {
            try {
                inputStream2.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        if (fileDownloadOutputStream != null) {
            try {
                sync(fileDownloadOutputStream);
            } catch (Exception e3) {
                e3.printStackTrace();
            } catch (Throwable th) {
                if (fileDownloadOutputStream != null) {
                    try {
                        fileDownloadOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
        if (fileDownloadOutputStream != null) {
            try {
                fileDownloadOutputStream.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0028 A[SYNTHETIC, Splitter:B:17:0x0028] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x002e A[SYNTHETIC, Splitter:B:23:0x002e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String convertStreamToString(java.io.InputStream r5) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            if (r5 == 0) goto L_0x0031
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x002c, all -> 0x0025 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x002c, all -> 0x0025 }
            r3.<init>(r5)     // Catch:{ IOException -> 0x002c, all -> 0x0025 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x002c, all -> 0x0025 }
        L_0x0012:
            java.lang.String r5 = r2.readLine()     // Catch:{ IOException -> 0x0023, all -> 0x0020 }
            if (r5 == 0) goto L_0x001c
            r0.append(r5)     // Catch:{ IOException -> 0x0023, all -> 0x0020 }
            goto L_0x0012
        L_0x001c:
            r2.close()     // Catch:{ IOException | NullPointerException -> 0x0031 }
            goto L_0x0031
        L_0x0020:
            r5 = move-exception
            r1 = r2
            goto L_0x0026
        L_0x0023:
            r1 = r2
            goto L_0x002c
        L_0x0025:
            r5 = move-exception
        L_0x0026:
            if (r1 == 0) goto L_0x002b
            r1.close()     // Catch:{ IOException | NullPointerException -> 0x002b }
        L_0x002b:
            throw r5
        L_0x002c:
            if (r1 == 0) goto L_0x0031
            r1.close()     // Catch:{ IOException | NullPointerException -> 0x0031 }
        L_0x0031:
            java.lang.String r5 = r0.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.downloader.internal.DownloadTask.convertStreamToString(java.io.InputStream):java.lang.String");
    }
}
