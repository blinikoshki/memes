package com.downloader.httpclient;

import com.downloader.request.DownloadRequest;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class DefaultHttpClient implements HttpClient {
    private URLConnection connection;

    public void close() {
    }

    public HttpClient clone() {
        return new DefaultHttpClient();
    }

    public void connect(DownloadRequest downloadRequest) throws IOException {
        URLConnection openConnection = new URL(downloadRequest.getUrl()).openConnection();
        this.connection = openConnection;
        openConnection.setReadTimeout(downloadRequest.getReadTimeout());
        this.connection.setConnectTimeout(downloadRequest.getConnectTimeout());
        this.connection.addRequestProperty("Range", String.format(Locale.ENGLISH, "bytes=%d-", new Object[]{Long.valueOf(downloadRequest.getDownloadedBytes())}));
        this.connection.addRequestProperty("User-Agent", downloadRequest.getUserAgent());
        addHeaders(downloadRequest);
        this.connection.connect();
    }

    public int getResponseCode() throws IOException {
        URLConnection uRLConnection = this.connection;
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        }
        return 0;
    }

    public InputStream getInputStream() throws IOException {
        return this.connection.getInputStream();
    }

    public long getContentLength() {
        try {
            return Long.parseLong(this.connection.getHeaderField(HttpHeaders.CONTENT_LENGTH));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public String getResponseHeader(String str) {
        return this.connection.getHeaderField(str);
    }

    public Map<String, List<String>> getHeaderFields() {
        return this.connection.getHeaderFields();
    }

    public InputStream getErrorStream() {
        URLConnection uRLConnection = this.connection;
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getErrorStream();
        }
        return null;
    }

    private void addHeaders(DownloadRequest downloadRequest) {
        HashMap<String, List<String>> headers = downloadRequest.getHeaders();
        if (headers != null) {
            for (Map.Entry next : headers.entrySet()) {
                String str = (String) next.getKey();
                List<String> list = (List) next.getValue();
                if (list != null) {
                    for (String addRequestProperty : list) {
                        this.connection.addRequestProperty(str, addRequestProperty);
                    }
                }
            }
        }
    }
}
