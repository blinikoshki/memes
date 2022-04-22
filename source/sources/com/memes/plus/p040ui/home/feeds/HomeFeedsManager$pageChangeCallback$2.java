package com.memes.plus.p040ui.home.feeds;

import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, mo26107d2 = {"<anonymous>", "com/memes/plus/ui/home/feeds/HomeFeedsManager$pageChangeCallback$2$1", "invoke", "()Lcom/memes/plus/ui/home/feeds/HomeFeedsManager$pageChangeCallback$2$1;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.home.feeds.HomeFeedsManager$pageChangeCallback$2 */
/* compiled from: HomeFeedsManager.kt */
final class HomeFeedsManager$pageChangeCallback$2 extends Lambda implements Function0<C42701> {
    final /* synthetic */ HomeFeedsManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeFeedsManager$pageChangeCallback$2(HomeFeedsManager homeFeedsManager) {
        super(0);
        this.this$0 = homeFeedsManager;
    }

    public final C42701 invoke() {
        return new ViewPager2.OnPageChangeCallback(this) {
            final /* synthetic */ HomeFeedsManager$pageChangeCallback$2 this$0;

            {
                this.this$0 = r1;
            }

            public void onPageSelected(int i) {
                this.this$0.this$0.expandAppBarLayout();
                super.onPageSelected(i);
            }
        };
    }
}
