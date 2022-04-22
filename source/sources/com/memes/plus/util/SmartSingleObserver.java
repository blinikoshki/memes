package com.memes.plus.util;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.reactivex.SingleObserver;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, mo26107d2 = {"Lcom/memes/plus/util/SmartSingleObserver;", "T", "Lio/reactivex/SingleObserver;", "()V", "onError", "", "message", "", "throwable", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: SmartSingleObserver.kt */
public abstract class SmartSingleObserver<T> implements SingleObserver<T> {
    public abstract void onError(String str, Throwable th);

    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        if ((th instanceof UnknownHostException) || (th instanceof SocketTimeoutException)) {
            onError("Internet is not available.", th);
            return;
        }
        String message = th.getMessage();
        if (message == null) {
            message = Constants.UNUSUAL_ERROR;
        }
        onError(message, th);
    }
}
