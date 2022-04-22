package com.giphy.sdk.core.network.api;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J!\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00018\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\b¨\u0006\t"}, mo26107d2 = {"Lcom/giphy/sdk/core/network/api/CompletionHandler;", "T", "", "onComplete", "", "result", "e", "", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: CompletionHandler.kt */
public interface CompletionHandler<T> {
    void onComplete(T t, Throwable th);
}
