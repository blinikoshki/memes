package com.downloader.internal;

import android.content.Context;
import com.downloader.Constants;
import com.downloader.PRDownloader;
import com.downloader.PRDownloaderConfig;
import com.downloader.database.AppDbHelper;
import com.downloader.database.DbHelper;
import com.downloader.database.NoOpsDbHelper;
import com.downloader.httpclient.DefaultHttpClient;
import com.downloader.httpclient.HttpClient;

public class ComponentHolder {
    private static final ComponentHolder INSTANCE = new ComponentHolder();
    private int connectTimeout;
    private DbHelper dbHelper;
    private HttpClient httpClient;
    private int readTimeout;
    private String userAgent;

    public static ComponentHolder getInstance() {
        return INSTANCE;
    }

    public void init(Context context, PRDownloaderConfig pRDownloaderConfig) {
        this.readTimeout = pRDownloaderConfig.getReadTimeout();
        this.connectTimeout = pRDownloaderConfig.getConnectTimeout();
        this.userAgent = pRDownloaderConfig.getUserAgent();
        this.httpClient = pRDownloaderConfig.getHttpClient();
        this.dbHelper = pRDownloaderConfig.isDatabaseEnabled() ? new AppDbHelper(context) : new NoOpsDbHelper();
        if (pRDownloaderConfig.isDatabaseEnabled()) {
            PRDownloader.cleanUp(30);
        }
    }

    public int getReadTimeout() {
        if (this.readTimeout == 0) {
            synchronized (ComponentHolder.class) {
                if (this.readTimeout == 0) {
                    this.readTimeout = 20000;
                }
            }
        }
        return this.readTimeout;
    }

    public int getConnectTimeout() {
        if (this.connectTimeout == 0) {
            synchronized (ComponentHolder.class) {
                if (this.connectTimeout == 0) {
                    this.connectTimeout = 20000;
                }
            }
        }
        return this.connectTimeout;
    }

    public String getUserAgent() {
        if (this.userAgent == null) {
            synchronized (ComponentHolder.class) {
                if (this.userAgent == null) {
                    this.userAgent = Constants.DEFAULT_USER_AGENT;
                }
            }
        }
        return this.userAgent;
    }

    public DbHelper getDbHelper() {
        if (this.dbHelper == null) {
            synchronized (ComponentHolder.class) {
                if (this.dbHelper == null) {
                    this.dbHelper = new NoOpsDbHelper();
                }
            }
        }
        return this.dbHelper;
    }

    public HttpClient getHttpClient() {
        if (this.httpClient == null) {
            synchronized (ComponentHolder.class) {
                if (this.httpClient == null) {
                    this.httpClient = new DefaultHttpClient();
                }
            }
        }
        return this.httpClient.clone();
    }
}
