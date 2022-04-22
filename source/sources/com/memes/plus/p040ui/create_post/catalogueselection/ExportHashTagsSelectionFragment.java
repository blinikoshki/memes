package com.memes.plus.p040ui.create_post.catalogueselection;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.memes.commons.util.SoftKeyboardUtil;
import com.memes.plus.p040ui.explore_search.tag_search.TagSearchResult;
import com.memes.plus.p040ui.explore_search.tag_search.TagSearchResultsFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/ui/create_post/catalogueselection/ExportHashTagsSelectionFragment;", "Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResultsFragment;", "()V", "onTagSearchResultTapped", "", "tagSearchResult", "Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResult;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.create_post.catalogueselection.ExportHashTagsSelectionFragment */
/* compiled from: ExportHashTagsSelectionFragment.kt */
public final class ExportHashTagsSelectionFragment extends TagSearchResultsFragment {
    public void onTagSearchResultTapped(TagSearchResult tagSearchResult) {
        Intrinsics.checkNotNullParameter(tagSearchResult, "tagSearchResult");
        getViewModel().storeTagToLocal(tagSearchResult.getTagName());
        FragmentActivity activity = getActivity();
        if (activity != null) {
            SoftKeyboardUtil.INSTANCE.hideKeyboard((Activity) activity);
            Intent intent = new Intent();
            intent.putExtra("android.intent.extra.TEXT", tagSearchResult.getTagName());
            activity.setResult(-1, intent);
            activity.finish();
        }
    }
}
