package com.getstream.sdk.chat.utils.strings;

import android.content.Context;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J-\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\n\"\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Lcom/getstream/sdk/chat/utils/strings/ChatStringsImpl;", "Lcom/getstream/sdk/chat/utils/strings/ChatStrings;", "appContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "get", "", "resId", "", "formatArgs", "", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChatStringsImpl.kt */
public final class ChatStringsImpl implements ChatStrings {
    private final Context appContext;

    public ChatStringsImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "appContext");
        this.appContext = context;
    }

    public String get(int i) {
        String string = this.appContext.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "appContext.getString(resId)");
        return string;
    }

    public String get(int i, Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "formatArgs");
        String string = this.appContext.getString(i, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(string, "appContext.getString(resId, *formatArgs)");
        return string;
    }
}
