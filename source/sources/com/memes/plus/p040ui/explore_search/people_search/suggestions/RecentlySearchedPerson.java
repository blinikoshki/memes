package com.memes.plus.p040ui.explore_search.people_search.suggestions;

import com.memes.plus.p040ui.explore_search.people_search.PeopleSearchResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, mo26107d2 = {"Lcom/memes/plus/ui/explore_search/people_search/suggestions/RecentlySearchedPerson;", "Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResult;", "()V", "equals", "", "other", "", "hashCode", "", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.explore_search.people_search.suggestions.RecentlySearchedPerson */
/* compiled from: RecentlySearchedPerson.kt */
public final class RecentlySearchedPerson extends PeopleSearchResult {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/ui/explore_search/people_search/suggestions/RecentlySearchedPerson$Companion;", "", "()V", "from", "Lcom/memes/plus/ui/explore_search/people_search/suggestions/RecentlySearchedPerson;", "peopleSearchResult", "Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResult;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.explore_search.people_search.suggestions.RecentlySearchedPerson$Companion */
    /* compiled from: RecentlySearchedPerson.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RecentlySearchedPerson from(PeopleSearchResult peopleSearchResult) {
            Intrinsics.checkNotNullParameter(peopleSearchResult, "peopleSearchResult");
            RecentlySearchedPerson recentlySearchedPerson = new RecentlySearchedPerson();
            recentlySearchedPerson.setId(peopleSearchResult.getId());
            recentlySearchedPerson.setFollowersCount(peopleSearchResult.getFollowersCount());
            recentlySearchedPerson.setFullName(peopleSearchResult.getFullName());
            recentlySearchedPerson.setUserName(peopleSearchResult.getUserName());
            recentlySearchedPerson.setProfileImageThumbUrl(peopleSearchResult.getProfileImageThumbUrl());
            recentlySearchedPerson.setProfileImageUrl(peopleSearchResult.getProfileImageUrl());
            recentlySearchedPerson.setProUser(peopleSearchResult.isProUser());
            return recentlySearchedPerson;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) && (obj instanceof RecentlySearchedPerson) && !(!Intrinsics.areEqual((Object) getId(), (Object) ((RecentlySearchedPerson) obj).getId()))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return getClass().hashCode();
    }
}
