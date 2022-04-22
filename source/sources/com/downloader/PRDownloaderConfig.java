package com.downloader;

import com.downloader.httpclient.DefaultHttpClient;
import com.downloader.httpclient.HttpClient;

public class PRDownloaderConfig {
    private int connectTimeout;
    private boolean databaseEnabled;
    private HttpClient httpClient;
    private int readTimeout;
    private String userAgent;

    private PRDownloaderConfig(Builder builder) {
        this.readTimeout = builder.readTimeout;
        this.connectTimeout = builder.connectTimeout;
        this.userAgent = builder.userAgent;
        this.httpClient = builder.httpClient;
        this.databaseEnabled = builder.databaseEnabled;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public void setReadTimeout(int i) {
        this.readTimeout = i;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public void setConnectTimeout(int i) {
        this.connectTimeout = i;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }

    public HttpClient getHttpClient() {
        return this.httpClient;
    }

    public void setHttpClient(HttpClient httpClient2) {
        this.httpClient = httpClient2;
    }

    public boolean isDatabaseEnabled() {
        return this.databaseEnabled;
    }

    public void setDatabaseEnabled(boolean z) {
        this.databaseEnabled = z;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        int connectTimeout = 20000;
        boolean databaseEnabled = false;
        HttpClient httpClient = new DefaultHttpClient();
        int readTimeout = 20000;
        String userAgent = Constants.DEFAULT_USER_AGENT;

        public Builder setReadTimeout(int i) {
            this.readTimeout = i;
            return this;
        }

        public Builder setConnectTimeout(int i) {
            this.connectTimeout = i;
            return this;
        }

        public Builder setUserAgent(String str) {
            this.userAgent = str;
            return this;
        }

        public Builder setHttpClient(HttpClient httpClient2) {
            this.httpClient = httpClient2;
            return this;
        }

        public Builder setDatabaseEnabled(boolean z) {
            this.databaseEnabled = z;
            return this;
        }

        public PRDownloaderConfig build() {
            return new PRDownloaderConfig(this);
        }
    }
}
