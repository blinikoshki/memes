package com.downloader;

import android.content.Context;
import com.downloader.core.Core;
import com.downloader.internal.ComponentHolder;
import com.downloader.internal.DownloadRequestQueue;
import com.downloader.request.DownloadRequestBuilder;
import com.downloader.utils.Utils;

public class PRDownloader {
    private PRDownloader() {
    }

    public static void initialize(Context context) {
        initialize(context, PRDownloaderConfig.newBuilder().build());
    }

    public static void initialize(Context context, PRDownloaderConfig pRDownloaderConfig) {
        ComponentHolder.getInstance().init(context, pRDownloaderConfig);
        DownloadRequestQueue.initialize();
    }

    public static DownloadRequestBuilder download(String str, String str2, String str3) {
        return new DownloadRequestBuilder(str, str2, str3);
    }

    public static void pause(int i) {
        DownloadRequestQueue.getInstance().pause(i);
    }

    public static void resume(int i) {
        DownloadRequestQueue.getInstance().resume(i);
    }

    public static void cancel(int i) {
        DownloadRequestQueue.getInstance().cancel(i);
    }

    public static void cancel(Object obj) {
        DownloadRequestQueue.getInstance().cancel(obj);
    }

    public static void cancelAll() {
        DownloadRequestQueue.getInstance().cancelAll();
    }

    public static Status getStatus(int i) {
        return DownloadRequestQueue.getInstance().getStatus(i);
    }

    public static void cleanUp(int i) {
        Utils.deleteUnwantedModelsAndTempFiles(i);
    }

    public static void shutDown() {
        Core.shutDown();
    }
}
