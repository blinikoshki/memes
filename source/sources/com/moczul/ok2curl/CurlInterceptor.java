package com.moczul.ok2curl;

import com.moczul.ok2curl.logger.Loggable;
import com.moczul.ok2curl.modifier.HeaderModifier;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class CurlInterceptor implements Interceptor {
    private static final String DEFAULT_DELIMITER = " ";
    private static final long DEFAULT_LIMIT = 1048576;
    protected final String delimiter;
    protected final List<HeaderModifier> headerModifiers;
    protected final long limit;
    protected final Loggable logger;
    protected final Options options;

    public CurlInterceptor(Loggable loggable) {
        this(loggable, 1048576, Collections.emptyList(), Options.EMPTY, " ");
    }

    public CurlInterceptor(Loggable loggable, Options options2) {
        this(loggable, 1048576, Collections.emptyList(), options2, " ");
    }

    public CurlInterceptor(Loggable loggable, List<HeaderModifier> list) {
        this(loggable, 1048576, list, Options.EMPTY, " ");
    }

    public CurlInterceptor(Loggable loggable, long j) {
        this(loggable, j, Collections.emptyList(), Options.EMPTY, " ");
    }

    public CurlInterceptor(Loggable loggable, long j, List<HeaderModifier> list, Options options2) {
        this(loggable, j, list, options2, " ");
    }

    public CurlInterceptor(Loggable loggable, long j, List<HeaderModifier> list, Options options2, String str) {
        ArrayList arrayList = new ArrayList();
        this.headerModifiers = arrayList;
        this.logger = loggable;
        this.limit = j;
        arrayList.addAll(list);
        this.options = options2;
        this.delimiter = str;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        this.logger.log(getCurlBuilder(request.newBuilder().build()).build());
        return chain.proceed(request);
    }

    /* access modifiers changed from: protected */
    public CurlBuilder getCurlBuilder(Request request) {
        return new CurlBuilder(request, this.limit, this.headerModifiers, this.options, this.delimiter);
    }
}
