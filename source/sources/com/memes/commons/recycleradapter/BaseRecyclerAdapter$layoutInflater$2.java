package com.memes.commons.recycleradapter;

import android.view.LayoutInflater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0003\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "ITEM", "HOLDER", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: BaseRecyclerAdapter.kt */
final class BaseRecyclerAdapter$layoutInflater$2 extends Lambda implements Function0<LayoutInflater> {
    final /* synthetic */ BaseRecyclerAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseRecyclerAdapter$layoutInflater$2(BaseRecyclerAdapter baseRecyclerAdapter) {
        super(0);
        this.this$0 = baseRecyclerAdapter;
    }

    public final LayoutInflater invoke() {
        return LayoutInflater.from(this.this$0.context);
    }
}
