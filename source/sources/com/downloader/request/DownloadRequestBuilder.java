package com.downloader.request;

import com.downloader.Priority;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DownloadRequestBuilder implements RequestBuilder {
    int connectTimeout;
    String dirPath;
    String fileName;
    HashMap<String, List<String>> headerMap;
    Priority priority = Priority.MEDIUM;
    int readTimeout;
    Object tag;
    String url;
    String userAgent;

    public DownloadRequestBuilder(String str, String str2, String str3) {
        this.url = str;
        this.dirPath = str2;
        this.fileName = str3;
    }

    public DownloadRequestBuilder setHeader(String str, String str2) {
        if (this.headerMap == null) {
            this.headerMap = new HashMap<>();
        }
        List list = this.headerMap.get(str);
        if (list == null) {
            list = new ArrayList();
            this.headerMap.put(str, list);
        }
        if (!list.contains(str2)) {
            list.add(str2);
        }
        return this;
    }

    public DownloadRequestBuilder setPriority(Priority priority2) {
        this.priority = priority2;
        return this;
    }

    public DownloadRequestBuilder setTag(Object obj) {
        this.tag = obj;
        return this;
    }

    public DownloadRequestBuilder setReadTimeout(int i) {
        this.readTimeout = i;
        return this;
    }

    public DownloadRequestBuilder setConnectTimeout(int i) {
        this.connectTimeout = i;
        return this;
    }

    public DownloadRequestBuilder setUserAgent(String str) {
        this.userAgent = str;
        return this;
    }

    public DownloadRequest build() {
        return new DownloadRequest(this);
    }
}
