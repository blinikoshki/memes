package com.memes.plus.p040ui.create_post.catalogueselection;

import android.app.Activity;
import android.content.Intent;
import com.memes.commons.util.SoftKeyboardUtil;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import com.memes.plus.p040ui.explore_search.people_search.PeopleSearchResult;
import com.memes.plus.p040ui.explore_search.people_search.PeopleSearchResultsFragment;
import com.memes.plus.p040ui.explore_search.people_search.suggestions.CatalogueSuggestedPerson;
import com.memes.plus.p040ui.explore_search.people_search.suggestions.RecentlySearchedPerson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/ui/create_post/catalogueselection/ExportPeopleSelectionFragment;", "Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResultsFragment;", "()V", "afterViewCreated", "", "onObserversRequested", "onPeopleSearchResultTapped", "peopleSearchResult", "Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResult;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.create_post.catalogueselection.ExportPeopleSelectionFragment */
/* compiled from: ExportPeopleSelectionFragment.kt */
public final class ExportPeopleSelectionFragment extends PeopleSearchResultsFragment {
    public void afterViewCreated() {
    }

    public void onObserversRequested() {
        super.onObserversRequested();
        getViewModel().disableSuggestedUsers();
    }

    public void onPeopleSearchResultTapped(PeopleSearchResult peopleSearchResult) {
        Intrinsics.checkNotNullParameter(peopleSearchResult, "peopleSearchResult");
        if (!(peopleSearchResult instanceof RecentlySearchedPerson) && !(peopleSearchResult instanceof CatalogueSuggestedPerson)) {
            SoftKeyboardUtil.INSTANCE.hideKeyboard((Activity) requireActivity());
            Intent intent = new Intent();
            intent.putExtra(TagPeopleActivity.FULL_NAME, peopleSearchResult.getFullName());
            intent.putExtra(TagPeopleActivity.USER_NAME, peopleSearchResult.getUserName());
            intent.putExtra(TagPeopleActivity.IMAGE_URL, peopleSearchResult.getProfileImageThumbUrl());
            intent.putExtra(TagPeopleActivity.USER_ID, peopleSearchResult.getId());
            intent.putExtra(TagPeopleActivity.IS_PRO_USER, peopleSearchResult.isProUser());
            requireActivity().setResult(-1, intent);
            requireActivity().finish();
        }
    }
}
