package com.downloader.httpclient;

import com.downloader.request.DownloadRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface HttpClient extends Cloneable {
    HttpClient clone();

    void close();

    void connect(DownloadRequest downloadRequest) throws IOException;

    long getContentLength();

    InputStream getErrorStream() throws IOException;

    Map<String, List<String>> getHeaderFields();

    InputStream getInputStream() throws IOException;

    int getResponseCode() throws IOException;

    String getResponseHeader(String str);
}
