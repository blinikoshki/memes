package com.memes.plus.p040ui.posts.edit_post;

import androidx.lifecycle.Observer;
import com.memes.commons.recycleradapter.AdapterUpdate;
import com.memes.plus.p040ui.explore_search.tag_search.TagSearchResult;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "update", "Lcom/memes/commons/recycleradapter/AdapterUpdate;", "Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResult;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.edit_post.EditPostActivity$attachObservers$4 */
/* compiled from: EditPostActivity.kt */
final class EditPostActivity$attachObservers$4<T> implements Observer<AdapterUpdate<TagSearchResult>> {
    final /* synthetic */ EditPostActivity this$0;

    EditPostActivity$attachObservers$4(EditPostActivity editPostActivity) {
        this.this$0 = editPostActivity;
    }

    public final void onChanged(AdapterUpdate<TagSearchResult> adapterUpdate) {
        this.this$0.showHashTagSuggestions(adapterUpdate.getItems());
    }
}
