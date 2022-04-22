package com.google.android.exoplayer2.offline;

import java.io.File;
import java.io.IOException;

public final class ActionFileUpgradeUtil {

    public interface DownloadIdProvider {
        String getId(DownloadRequest downloadRequest);
    }

    private ActionFileUpgradeUtil() {
    }

    public static void upgradeAndDelete(File file, DownloadIdProvider downloadIdProvider, DefaultDownloadIndex defaultDownloadIndex, boolean z, boolean z2) throws IOException {
        ActionFile actionFile = new ActionFile(file);
        if (actionFile.exists()) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                for (DownloadRequest downloadRequest : actionFile.load()) {
                    if (downloadIdProvider != null) {
                        downloadRequest = downloadRequest.copyWithId(downloadIdProvider.getId(downloadRequest));
                    }
                    mergeRequest(downloadRequest, defaultDownloadIndex, z2, currentTimeMillis);
                }
                actionFile.delete();
            } catch (Throwable th) {
                if (z) {
                    actionFile.delete();
                }
                throw th;
            }
        }
    }

    static void mergeRequest(DownloadRequest downloadRequest, DefaultDownloadIndex defaultDownloadIndex, boolean z, long j) throws IOException {
        Download download;
        DefaultDownloadIndex defaultDownloadIndex2 = defaultDownloadIndex;
        Download download2 = defaultDownloadIndex.getDownload(downloadRequest.f525id);
        if (download2 != null) {
            download = DownloadManager.mergeRequest(download2, downloadRequest, download2.stopReason, j);
        } else {
            long j2 = j;
            download = new Download(downloadRequest, z ? 3 : 0, j, j, -1, 0, 0);
        }
        defaultDownloadIndex.putDownload(download);
    }
}
