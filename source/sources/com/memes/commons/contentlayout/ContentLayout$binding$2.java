package com.memes.commons.contentlayout;

import android.content.Context;
import android.view.LayoutInflater;
import com.memes.commons.databinding.ContentLayoutBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/commons/databinding/ContentLayoutBinding;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ContentLayout.kt */
final class ContentLayout$binding$2 extends Lambda implements Function0<ContentLayoutBinding> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ContentLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContentLayout$binding$2(ContentLayout contentLayout, Context context) {
        super(0);
        this.this$0 = contentLayout;
        this.$context = context;
    }

    public final ContentLayoutBinding invoke() {
        ContentLayoutBinding inflate = ContentLayoutBinding.inflate(LayoutInflater.from(this.$context), this.this$0);
        Intrinsics.checkNotNullExpressionValue(inflate, "ContentLayoutBinding.inf…ater.from(context), this)");
        return inflate;
    }
}
