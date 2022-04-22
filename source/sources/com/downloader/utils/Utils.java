package com.downloader.utils;

import com.downloader.core.Core;
import com.downloader.database.DownloadModel;
import com.downloader.httpclient.HttpClient;
import com.downloader.internal.ComponentHolder;
import com.downloader.request.DownloadRequest;
import com.google.common.net.HttpHeaders;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public final class Utils {
    private static final int MAX_REDIRECTION = 10;

    private static boolean isRedirection(int i) {
        return i == 301 || i == 302 || i == 303 || i == 300 || i == 307 || i == 308;
    }

    private Utils() {
    }

    public static String getPath(String str, String str2) {
        return str + File.separator + str2;
    }

    public static String getTempPath(String str, String str2) {
        return getPath(str, str2) + ".temp";
    }

    public static void renameFileName(String str, String str2) throws IOException {
        File file = new File(str);
        try {
            file = new File(str2);
            if (r2) {
                if (!file.delete()) {
                    throw new IOException("Deletion Failed");
                }
            }
            if (!file.renameTo(file)) {
                throw new IOException("Rename Failed");
            } else if (file.exists()) {
                file.delete();
            }
        } finally {
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static void deleteTempFileAndDatabaseEntryInBackground(final String str, final int i) {
        Core.getInstance().getExecutorSupplier().forBackgroundTasks().execute(new Runnable() {
            public void run() {
                ComponentHolder.getInstance().getDbHelper().remove(i);
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
            }
        });
    }

    public static void deleteUnwantedModelsAndTempFiles(final int i) {
        Core.getInstance().getExecutorSupplier().forBackgroundTasks().execute(new Runnable() {
            public void run() {
                List<DownloadModel> unwantedModels = ComponentHolder.getInstance().getDbHelper().getUnwantedModels(i);
                if (unwantedModels != null) {
                    for (DownloadModel next : unwantedModels) {
                        String tempPath = Utils.getTempPath(next.getDirPath(), next.getFileName());
                        ComponentHolder.getInstance().getDbHelper().remove(next.getId());
                        File file = new File(tempPath);
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                }
            }
        });
    }

    public static int getUniqueId(String str, String str2, String str3) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest((str + File.separator + str2 + File.separator + str3).getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                byte b2 = b & 255;
                if (b2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(b2));
            }
            return sb.toString().hashCode();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("NoSuchAlgorithmException", e);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UnsupportedEncodingException", e2);
        }
    }

    public static HttpClient getRedirectedConnectionIfAny(HttpClient httpClient, DownloadRequest downloadRequest) throws IOException, IllegalAccessException {
        int responseCode = httpClient.getResponseCode();
        String responseHeader = httpClient.getResponseHeader(HttpHeaders.LOCATION);
        int i = 0;
        while (isRedirection(responseCode)) {
            if (responseHeader != null) {
                httpClient.close();
                downloadRequest.setUrl(responseHeader);
                httpClient = ComponentHolder.getInstance().getHttpClient();
                httpClient.connect(downloadRequest);
                responseCode = httpClient.getResponseCode();
                responseHeader = httpClient.getResponseHeader(HttpHeaders.LOCATION);
                i++;
                if (i >= 10) {
                    throw new IllegalAccessException("Max redirection done");
                }
            } else {
                throw new IllegalAccessException("Location is null");
            }
        }
        return httpClient;
    }
}
