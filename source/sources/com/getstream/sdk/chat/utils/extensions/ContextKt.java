package com.getstream.sdk.chat.utils.extensions;

import android.content.Context;
import android.view.LayoutInflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo26107d2 = {"inflater", "Landroid/view/LayoutInflater;", "Landroid/content/Context;", "getInflater$annotations", "(Landroid/content/Context;)V", "getInflater", "(Landroid/content/Context;)Landroid/view/LayoutInflater;", "stream-chat-android-ui-common_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: Context.kt */
public final class ContextKt {
    @InternalStreamChatApi
    public static /* synthetic */ void getInflater$annotations(Context context) {
    }

    public static final LayoutInflater getInflater(Context context) {
        Intrinsics.checkNotNullParameter(context, "$this$inflater");
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(this)");
        return from;
    }
}
