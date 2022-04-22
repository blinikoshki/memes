package com.memes.plus.p040ui.home.bottomtabs;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/ui/home/bottomtabs/HomeBottomTabsAdapter;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.home.bottomtabs.HomeBottomTabsView$bottomTabsAdapter$2 */
/* compiled from: HomeBottomTabsView.kt */
final class HomeBottomTabsView$bottomTabsAdapter$2 extends Lambda implements Function0<HomeBottomTabsAdapter> {
    final /* synthetic */ Context $context;
    final /* synthetic */ HomeBottomTabsView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeBottomTabsView$bottomTabsAdapter$2(HomeBottomTabsView homeBottomTabsView, Context context) {
        super(0);
        this.this$0 = homeBottomTabsView;
        this.$context = context;
    }

    public final HomeBottomTabsAdapter invoke() {
        return new HomeBottomTabsAdapter(this.$context, this.this$0);
    }
}
