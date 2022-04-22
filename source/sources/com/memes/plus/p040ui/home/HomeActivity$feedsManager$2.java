package com.memes.plus.p040ui.home;

import com.memes.plus.databinding.HomeActivityBinding;
import com.memes.plus.p040ui.home.feeds.HomeFeedsManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/ui/home/feeds/HomeFeedsManager;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.home.HomeActivity$feedsManager$2 */
/* compiled from: HomeActivity.kt */
final class HomeActivity$feedsManager$2 extends Lambda implements Function0<HomeFeedsManager> {
    final /* synthetic */ HomeActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeActivity$feedsManager$2(HomeActivity homeActivity) {
        super(0);
        this.this$0 = homeActivity;
    }

    public final HomeFeedsManager invoke() {
        HomeActivity homeActivity = this.this$0;
        HomeActivityBinding access$getBinding$p = homeActivity.getBinding();
        Intrinsics.checkNotNullExpressionValue(access$getBinding$p, "binding");
        return new HomeFeedsManager(homeActivity, access$getBinding$p);
    }
}
