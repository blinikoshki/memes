package com.moczul.ok2curl;

import com.moczul.ok2curl.modifier.HeaderModifier;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import okio.Sink;
import org.apache.commons.lang3.StringUtils;

public class CurlBuilder {
    protected static final String CONTENT_TYPE = "Content-Type";
    protected static final String FORMAT_BODY = "-d '%1$s'";
    protected static final String FORMAT_HEADER = "-H \"%1$s:%2$s\"";
    protected static final String FORMAT_METHOD = "-X %1$s";
    protected static final String FORMAT_URL = "\"%1$s\"";
    protected final String body;
    protected final String contentType;
    protected final String delimiter;
    protected final List<Header> headers;
    protected final String method;
    protected final List<String> options;
    protected final String url;

    public CurlBuilder(Request request) {
        this(request, -1, Collections.emptyList(), Options.EMPTY);
    }

    public CurlBuilder(Request request, long j, List<HeaderModifier> list, Options options2) {
        this(request, j, list, options2, StringUtils.SPACE);
    }

    public CurlBuilder(Request request, long j, List<HeaderModifier> list, Options options2, String str) {
        this.url = request.url().toString();
        this.method = request.method();
        this.options = Collections.unmodifiableList(options2.list());
        this.delimiter = str;
        RequestBody body2 = request.body();
        if (body2 != null) {
            this.contentType = getContentType(body2);
            this.body = getBodyAsString(body2, j);
        } else {
            this.contentType = null;
            this.body = null;
        }
        Headers headers2 = request.headers();
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < headers2.size(); i++) {
            Header modifyHeader = modifyHeader(new Header(headers2.name(i), headers2.value(i)), list);
            if (modifyHeader != null) {
                linkedList.add(modifyHeader);
            }
        }
        this.headers = Collections.unmodifiableList(linkedList);
    }

    private Header modifyHeader(Header header, List<HeaderModifier> list) {
        for (HeaderModifier next : list) {
            if (next.matches(header)) {
                return next.modify(header);
            }
        }
        return header;
    }

    private String getContentType(RequestBody requestBody) {
        MediaType contentType2 = requestBody.contentType();
        if (contentType2 != null) {
            return contentType2.toString();
        }
        return null;
    }

    private String getBodyAsString(RequestBody requestBody, long j) {
        try {
            Buffer buffer = new Buffer();
            Charset charset = getCharset(requestBody.contentType());
            if (j > 0) {
                BufferedSink buffer2 = Okio.buffer((Sink) new LimitedSink(buffer, j));
                requestBody.writeTo(buffer2);
                buffer2.flush();
            } else {
                requestBody.writeTo(buffer);
            }
            return buffer.readString(charset);
        } catch (IOException e) {
            return "Error while reading body: " + e.toString();
        }
    }

    private Charset getCharset(MediaType mediaType) {
        if (mediaType != null) {
            return mediaType.charset(Charset.defaultCharset());
        }
        return Charset.defaultCharset();
    }

    public String build() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("curl");
        arrayList.addAll(this.options);
        arrayList.add(String.format(FORMAT_METHOD, new Object[]{this.method.toUpperCase()}));
        for (Header next : this.headers) {
            arrayList.add(String.format(FORMAT_HEADER, new Object[]{next.name(), next.value()}));
        }
        if (this.contentType != null && !containsName("Content-Type", this.headers)) {
            arrayList.add(String.format(FORMAT_HEADER, new Object[]{"Content-Type", this.contentType}));
        }
        String str = this.body;
        if (str != null) {
            arrayList.add(String.format(FORMAT_BODY, new Object[]{str}));
        }
        arrayList.add(String.format(FORMAT_URL, new Object[]{this.url}));
        return StringUtil.join(this.delimiter, arrayList);
    }

    /* access modifiers changed from: protected */
    public boolean containsName(String str, List<Header> list) {
        for (Header name : list) {
            if (name.name().equals(str)) {
                return true;
            }
        }
        return false;
    }
}
