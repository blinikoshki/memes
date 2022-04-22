package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public class Response<T extends Result> {
    private T zzba;

    public Response() {
    }

    protected Response(T t) {
        this.zzba = t;
    }

    /* access modifiers changed from: protected */
    public T getResult() {
        return this.zzba;
    }

    public void setResult(T t) {
        this.zzba = t;
    }
}
