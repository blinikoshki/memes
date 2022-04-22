package com.memes.plus.p040ui.explore;

import androidx.lifecycle.Observer;
import com.memes.plus.p040ui.posts.post_basics.post_report.PostReportResult;
import com.memes.plus.util.DialogUtil;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "result", "Lcom/memes/plus/ui/posts/post_basics/post_report/PostReportResult;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.explore.ExploreTabFragment$attachPostOperationsObservers$4 */
/* compiled from: ExploreTabFragment.kt */
final class ExploreTabFragment$attachPostOperationsObservers$4<T> implements Observer<PostReportResult> {
    final /* synthetic */ ExploreTabFragment this$0;

    ExploreTabFragment$attachPostOperationsObservers$4(ExploreTabFragment exploreTabFragment) {
        this.this$0 = exploreTabFragment;
    }

    public final void onChanged(PostReportResult postReportResult) {
        DialogUtil.showInformation$default(DialogUtil.INSTANCE, this.this$0.getContext(), postReportResult.getMessage(), false, 4, (Object) null);
    }
}
