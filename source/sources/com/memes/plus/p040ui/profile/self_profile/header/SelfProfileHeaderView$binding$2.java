package com.memes.plus.p040ui.profile.self_profile.header;

import android.content.Context;
import android.view.LayoutInflater;
import com.memes.plus.databinding.SelfProfileHeaderViewBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/databinding/SelfProfileHeaderViewBinding;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.self_profile.header.SelfProfileHeaderView$binding$2 */
/* compiled from: SelfProfileHeaderView.kt */
final class SelfProfileHeaderView$binding$2 extends Lambda implements Function0<SelfProfileHeaderViewBinding> {
    final /* synthetic */ Context $context;
    final /* synthetic */ SelfProfileHeaderView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelfProfileHeaderView$binding$2(SelfProfileHeaderView selfProfileHeaderView, Context context) {
        super(0);
        this.this$0 = selfProfileHeaderView;
        this.$context = context;
    }

    public final SelfProfileHeaderViewBinding invoke() {
        SelfProfileHeaderViewBinding inflate = SelfProfileHeaderViewBinding.inflate(LayoutInflater.from(this.$context), this.this$0);
        Intrinsics.checkNotNullExpressionValue(inflate, "SelfProfileHeaderViewBin…rom(context),\n\t\t\tthis\n\t\t)");
        return inflate;
    }
}
