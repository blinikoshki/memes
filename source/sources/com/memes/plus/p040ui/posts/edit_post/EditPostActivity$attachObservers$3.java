package com.memes.plus.p040ui.posts.edit_post;

import androidx.lifecycle.Observer;
import com.memes.commons.recycleradapter.AdapterUpdate;
import com.memes.plus.p040ui.explore_search.people_search.CatalogueSearchResult;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "update", "Lcom/memes/commons/recycleradapter/AdapterUpdate;", "Lcom/memes/plus/ui/explore_search/people_search/CatalogueSearchResult;", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.edit_post.EditPostActivity$attachObservers$3 */
/* compiled from: EditPostActivity.kt */
final class EditPostActivity$attachObservers$3<T> implements Observer<AdapterUpdate<CatalogueSearchResult>> {
    final /* synthetic */ EditPostActivity this$0;

    EditPostActivity$attachObservers$3(EditPostActivity editPostActivity) {
        this.this$0 = editPostActivity;
    }

    public final void onChanged(AdapterUpdate<CatalogueSearchResult> adapterUpdate) {
        this.this$0.showPeopleSuggestions(adapterUpdate != null ? adapterUpdate.getItems() : null);
    }
}
