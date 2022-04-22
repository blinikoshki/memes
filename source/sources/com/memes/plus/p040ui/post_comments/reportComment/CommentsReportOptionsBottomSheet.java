package com.memes.plus.p040ui.post_comments.reportComment;

import androidx.fragment.app.FragmentManager;
import com.memes.commons.choices.Choice;
import com.memes.commons.choices.ChoicesBottomSheet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0002\r\u000eB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Lcom/memes/plus/ui/post_comments/reportComment/CommentsReportOptionsBottomSheet;", "Lcom/memes/commons/choices/ChoicesBottomSheet;", "Lcom/memes/commons/choices/ChoicesBottomSheet$Callback;", "()V", "callback", "Lcom/memes/plus/ui/post_comments/reportComment/CommentsReportOptionsBottomSheet$Callback;", "onChoiceSelected", "", "choice", "Lcom/memes/commons/choices/Choice;", "show", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "Callback", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.reportComment.CommentsReportOptionsBottomSheet */
/* compiled from: CommentsReportOptionsBottomSheet.kt */
public final class CommentsReportOptionsBottomSheet extends ChoicesBottomSheet implements ChoicesBottomSheet.Callback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Choice REPORT_INAPPROPRIATE = Choice.Companion.create$default(Choice.Companion, "channel-abusive-content", "Abusive Content", false, Choice.HighlightType.DANGER, 4, (Object) null);
    private static final Choice REPORT_SPAM = Choice.Companion.create$default(Choice.Companion, "channel-span-scam", ReportType.SPAM, false, Choice.HighlightType.DANGER, 4, (Object) null);
    private Callback callback;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/plus/ui/post_comments/reportComment/CommentsReportOptionsBottomSheet$Callback;", "", "onReportInappropriate", "", "onReportSpam", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.post_comments.reportComment.CommentsReportOptionsBottomSheet$Callback */
    /* compiled from: CommentsReportOptionsBottomSheet.kt */
    public interface Callback {
        void onReportInappropriate();

        void onReportSpam();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/plus/ui/post_comments/reportComment/CommentsReportOptionsBottomSheet$Companion;", "", "()V", "REPORT_INAPPROPRIATE", "Lcom/memes/commons/choices/Choice;", "REPORT_SPAM", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.post_comments.reportComment.CommentsReportOptionsBottomSheet$Companion */
    /* compiled from: CommentsReportOptionsBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void show(FragmentManager fragmentManager, Callback callback2) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        List mutableListOf = CollectionsKt.mutableListOf(REPORT_SPAM, REPORT_INAPPROPRIATE);
        this.callback = callback2;
        show(fragmentManager, mutableListOf, this);
    }

    public void onChoiceSelected(Choice choice) {
        Callback callback2;
        Intrinsics.checkNotNullParameter(choice, "choice");
        String id = choice.getId();
        if (Intrinsics.areEqual((Object) id, (Object) REPORT_SPAM.getId())) {
            Callback callback3 = this.callback;
            if (callback3 != null) {
                callback3.onReportSpam();
            }
        } else if (Intrinsics.areEqual((Object) id, (Object) REPORT_INAPPROPRIATE.getId()) && (callback2 = this.callback) != null) {
            callback2.onReportInappropriate();
        }
    }
}
