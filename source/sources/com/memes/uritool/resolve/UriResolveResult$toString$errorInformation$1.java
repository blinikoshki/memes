package com.memes.uritool.resolve;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: UriResolveResult.kt */
final /* synthetic */ class UriResolveResult$toString$errorInformation$1 extends MutablePropertyReference0Impl {
    UriResolveResult$toString$errorInformation$1(UriResolveResult uriResolveResult) {
        super(uriResolveResult, UriResolveResult.class, "error", "getError()Ljava/lang/String;", 0);
    }

    public Object get() {
        return UriResolveResult.access$getError$p((UriResolveResult) this.receiver);
    }

    public void set(Object obj) {
        ((UriResolveResult) this.receiver).error = (String) obj;
    }
}
