package com.downloader.request;

import com.downloader.Priority;

public interface RequestBuilder {
    RequestBuilder setConnectTimeout(int i);

    RequestBuilder setHeader(String str, String str2);

    RequestBuilder setPriority(Priority priority);

    RequestBuilder setReadTimeout(int i);

    RequestBuilder setTag(Object obj);

    RequestBuilder setUserAgent(String str);
}
