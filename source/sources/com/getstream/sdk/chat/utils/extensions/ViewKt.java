package com.getstream.sdk.chat.utils.extensions;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\" \u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo26107d2 = {"activity", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View;", "getActivity$annotations", "(Landroid/view/View;)V", "getActivity", "(Landroid/view/View;)Landroidx/appcompat/app/AppCompatActivity;", "stream-chat-android-ui-common_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: View.kt */
public final class ViewKt {
    @InternalStreamChatApi
    public static /* synthetic */ void getActivity$annotations(View view) {
    }

    public static final AppCompatActivity getActivity(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$activity");
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof AppCompatActivity) {
                return (AppCompatActivity) context;
            }
        }
        return null;
    }
}
