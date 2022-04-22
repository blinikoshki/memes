package com.getstream.sdk.chat.adapter.viewholder.message.configurators;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ReplyConfigurator.kt */
final class ReplyConfigurator$sam$android_view_View_OnClickListener$0 implements View.OnClickListener {
    private final /* synthetic */ Function1 function;

    ReplyConfigurator$sam$android_view_View_OnClickListener$0(Function1 function1) {
        this.function = function1;
    }

    public final /* synthetic */ void onClick(View view) {
        Intrinsics.checkNotNullExpressionValue(this.function.invoke(view), "invoke(...)");
    }
}
