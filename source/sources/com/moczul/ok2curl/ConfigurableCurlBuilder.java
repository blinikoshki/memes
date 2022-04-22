package com.moczul.ok2curl;

import com.google.common.net.HttpHeaders;
import com.moczul.ok2curl.modifier.HeaderModifier;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Request;

public class ConfigurableCurlBuilder extends CurlBuilder {
    protected static final int[] DEFAULT_PARTS_ORDER = {0, 1, 2, 3, 4, 5, 6};
    public static final int PART_BODY = 5;
    public static final int PART_CONTENT_TYPE = 4;
    public static final int PART_CURL = 0;
    public static final int PART_HEADERS = 3;
    public static final int PART_METHOD = 2;
    public static final int PART_OPTIONS = 1;
    public static final int PART_URL = 6;
    protected final int[] partsOrder;

    public ConfigurableCurlBuilder(Request request, long j, List<HeaderModifier> list, Options options, String str) {
        this(request, j, list, options, str, DEFAULT_PARTS_ORDER);
    }

    public ConfigurableCurlBuilder(Request request, long j, List<HeaderModifier> list, Options options, String str, int[] iArr) {
        super(request, j, list, options, str);
        this.partsOrder = iArr;
    }

    public String build() {
        ArrayList arrayList = new ArrayList();
        for (int i : this.partsOrder) {
            switch (i) {
                case 0:
                    addCurl(arrayList);
                    break;
                case 1:
                    addOptions(arrayList);
                    break;
                case 2:
                    addMethod(arrayList);
                    break;
                case 3:
                    addHeaders(arrayList);
                    break;
                case 4:
                    addContentType(arrayList);
                    break;
                case 5:
                    addBody(arrayList);
                    break;
                case 6:
                    addUrl(arrayList);
                    break;
            }
        }
        return StringUtil.join(this.delimiter, arrayList);
    }

    private void addCurl(List<String> list) {
        list.add("curl");
    }

    private void addOptions(List<String> list) {
        list.addAll(this.options);
    }

    private void addMethod(List<String> list) {
        list.add(String.format("-X %1$s", new Object[]{this.method.toUpperCase()}));
    }

    private void addHeaders(List<String> list) {
        for (Header header : this.headers) {
            list.add(String.format("-H \"%1$s:%2$s\"", new Object[]{header.name(), header.value()}));
        }
    }

    private void addContentType(List<String> list) {
        if (this.contentType != null && !containsName(HttpHeaders.CONTENT_TYPE, this.headers)) {
            list.add(String.format("-H \"%1$s:%2$s\"", new Object[]{HttpHeaders.CONTENT_TYPE, this.contentType}));
        }
    }

    private void addBody(List<String> list) {
        if (this.body != null) {
            list.add(String.format("-d '%1$s'", new Object[]{this.body}));
        }
    }

    private void addUrl(List<String> list) {
        list.add(String.format("\"%1$s\"", new Object[]{this.url}));
    }
}
