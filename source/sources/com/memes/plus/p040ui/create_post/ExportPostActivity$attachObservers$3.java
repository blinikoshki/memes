package com.memes.plus.p040ui.create_post;

import androidx.lifecycle.Observer;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "tagsList", "", "", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.create_post.ExportPostActivity$attachObservers$3 */
/* compiled from: ExportPostActivity.kt */
final class ExportPostActivity$attachObservers$3<T> implements Observer<List<String>> {
    final /* synthetic */ ExportPostActivity this$0;

    ExportPostActivity$attachObservers$3(ExportPostActivity exportPostActivity) {
        this.this$0 = exportPostActivity;
    }

    public final void onChanged(List<String> list) {
        this.this$0.getSavedHashTagsAdapter().setItems(list);
    }
}
