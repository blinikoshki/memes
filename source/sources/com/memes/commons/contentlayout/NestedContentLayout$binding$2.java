package com.memes.commons.contentlayout;

import android.content.Context;
import android.view.LayoutInflater;
import com.memes.commons.databinding.NestedContentLayoutBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/commons/databinding/NestedContentLayoutBinding;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: NestedContentLayout.kt */
final class NestedContentLayout$binding$2 extends Lambda implements Function0<NestedContentLayoutBinding> {
    final /* synthetic */ Context $context;
    final /* synthetic */ NestedContentLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NestedContentLayout$binding$2(NestedContentLayout nestedContentLayout, Context context) {
        super(0);
        this.this$0 = nestedContentLayout;
        this.$context = context;
    }

    public final NestedContentLayoutBinding invoke() {
        NestedContentLayoutBinding inflate = NestedContentLayoutBinding.inflate(LayoutInflater.from(this.$context), this.this$0);
        Intrinsics.checkNotNullExpressionValue(inflate, "NestedContentLayoutBindi…ater.from(context), this)");
        return inflate;
    }
}
