package com.memes.chat.util.extensions;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, mo26107d2 = {"getErrorMessage", "", "", "chat_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: Extensions.kt */
public final class ExtensionsKt {
    public static final String getErrorMessage(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "$this$getErrorMessage");
        if ((th instanceof UnknownHostException) || (th instanceof SocketTimeoutException)) {
            return "Internet is not available.";
        }
        String message = th.getMessage();
        CharSequence charSequence = message;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            return message;
        }
        return "Something went wrong: " + th.getClass().getSimpleName();
    }
}
