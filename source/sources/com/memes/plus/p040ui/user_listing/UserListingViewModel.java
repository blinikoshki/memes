package com.memes.plus.p040ui.user_listing;

import androidx.lifecycle.MutableLiveData;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import com.memes.commons.recycleradapter.AdapterUpdate;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.plus.base.BaseRxJavaViewModel;
import com.memes.plus.data.mapped_response.PageBasedPaginationInfo;
import com.memes.plus.data.mapped_response.UniversalResult;
import com.memes.plus.data.source.memes.MemesRepository;
import com.memes.plus.p040ui.posts.post_basics.follow_user.FollowUserRequest;
import com.memes.plus.p040ui.posts.suggestions.SuggestedUsersRequest;
import com.memes.plus.p040ui.user_listing.UserListingTarget;
import com.memes.plus.p040ui.user_listing.followers.FollowersRequest;
import com.memes.plus.p040ui.user_listing.followings.FollowingsRequest;
import com.memes.plus.p040ui.user_listing.post_likes.PostLikeUsersRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p015io.reactivex.Single;
import p015io.reactivex.android.schedulers.AndroidSchedulers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u001d\u001a\u00020\u001eJ\u001c\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0!0 2\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020#H\u0016J\u0006\u0010'\u001a\u00020\u001eJ\u0010\u0010(\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010*\u001a\u00020\u001e2\b\u0010+\u001a\u0004\u0018\u00010\u0016J\u000e\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\bR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00130\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000¨\u0006."}, mo26107d2 = {"Lcom/memes/plus/ui/user_listing/UserListingViewModel;", "Lcom/memes/plus/base/BaseRxJavaViewModel;", "Lcom/memes/commons/contentlayout/ContentLayout$Callback;", "repository", "Lcom/memes/plus/data/source/memes/MemesRepository;", "(Lcom/memes/plus/data/source/memes/MemesRepository;)V", "cachedListedUsers", "", "Lcom/memes/plus/ui/user_listing/ListedUser;", "contentVisibilityLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "getContentVisibilityLiveData", "()Landroidx/lifecycle/MutableLiveData;", "currentSearchQuery", "", "followToggleLiveData", "getFollowToggleLiveData", "listedUsersLiveData", "Lcom/memes/commons/recycleradapter/AdapterUpdate;", "getListedUsersLiveData", "userListingTarget", "Lcom/memes/plus/ui/user_listing/UserListingTarget;", "userListingTargetLiveData", "Lcom/memes/commons/util/SingleLiveEvent;", "getUserListingTargetLiveData", "()Lcom/memes/commons/util/SingleLiveEvent;", "usersPaginationInfo", "Lcom/memes/plus/data/mapped_response/PageBasedPaginationInfo;", "fetchUserListing", "", "getUserListingSingle", "Lio/reactivex/Single;", "Lcom/memes/plus/data/mapped_response/UniversalResult;", "currentPage", "", "onContentLayoutErrorResolutionButtonTapped", "who", "why", "refresh", "search", "query", "setUserListingTarget", "target", "toggleFollowUser", "user", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.user_listing.UserListingViewModel */
/* compiled from: UserListingViewModel.kt */
public final class UserListingViewModel extends BaseRxJavaViewModel implements ContentLayout.Callback {
    /* access modifiers changed from: private */
    public final List<ListedUser> cachedListedUsers = new ArrayList();
    private final MutableLiveData<ContentVisibilityAction> contentVisibilityLiveData = new MutableLiveData<>();
    private String currentSearchQuery;
    private final MutableLiveData<ListedUser> followToggleLiveData = new MutableLiveData<>();
    private final MutableLiveData<AdapterUpdate<ListedUser>> listedUsersLiveData = new MutableLiveData<>();
    private final MemesRepository repository;
    private UserListingTarget userListingTarget;
    private final SingleLiveEvent<UserListingTarget> userListingTargetLiveData = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public PageBasedPaginationInfo usersPaginationInfo;

    public UserListingViewModel(MemesRepository memesRepository) {
        Intrinsics.checkNotNullParameter(memesRepository, "repository");
        this.repository = memesRepository;
    }

    public final SingleLiveEvent<UserListingTarget> getUserListingTargetLiveData() {
        return this.userListingTargetLiveData;
    }

    public final MutableLiveData<AdapterUpdate<ListedUser>> getListedUsersLiveData() {
        return this.listedUsersLiveData;
    }

    public final MutableLiveData<ContentVisibilityAction> getContentVisibilityLiveData() {
        return this.contentVisibilityLiveData;
    }

    public final MutableLiveData<ListedUser> getFollowToggleLiveData() {
        return this.followToggleLiveData;
    }

    public final void setUserListingTarget(UserListingTarget userListingTarget2) {
        this.userListingTarget = userListingTarget2;
        SingleLiveEvent<UserListingTarget> singleLiveEvent = this.userListingTargetLiveData;
        if (userListingTarget2 != null) {
            singleLiveEvent.setValue(userListingTarget2);
            CharSequence charSequence = this.currentSearchQuery;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                this.cachedListedUsers.clear();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void search(String str) {
        String fullName;
        if (!Intrinsics.areEqual((Object) this.currentSearchQuery, (Object) str)) {
            this.currentSearchQuery = str;
            this.usersPaginationInfo = null;
            CharSequence charSequence = str;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                fetchUserListing();
            } else if (this.cachedListedUsers.isEmpty()) {
                MutableLiveData<ContentVisibilityAction> mutableLiveData = this.contentVisibilityLiveData;
                showContentNotAvailable(mutableLiveData, "No results found for '" + str + '\'');
            } else {
                Collection arrayList = new ArrayList();
                for (Object next : this.cachedListedUsers) {
                    ListedUser listedUser = (ListedUser) next;
                    String username = listedUser.getUsername();
                    if ((username != null && StringsKt.contains((CharSequence) username, charSequence, true)) || ((fullName = listedUser.getFullName()) != null && StringsKt.contains((CharSequence) fullName, charSequence, true))) {
                        arrayList.add(next);
                    }
                }
                List list = (List) arrayList;
                if (list.isEmpty()) {
                    MutableLiveData<ContentVisibilityAction> mutableLiveData2 = this.contentVisibilityLiveData;
                    showContentNotAvailable(mutableLiveData2, "No results found for '" + str + '\'');
                    return;
                }
                this.listedUsersLiveData.setValue(new AdapterUpdate(0, list));
                showContent(this.contentVisibilityLiveData);
            }
        }
    }

    public final void fetchUserListing() {
        CharSequence charSequence = this.currentSearchQuery;
        int i = 0;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            if (this.usersPaginationInfo == null) {
                this.cachedListedUsers.clear();
            }
            PageBasedPaginationInfo pageBasedPaginationInfo = this.usersPaginationInfo;
            if (pageBasedPaginationInfo == null || pageBasedPaginationInfo.canFetchNextPage()) {
                PageBasedPaginationInfo pageBasedPaginationInfo2 = this.usersPaginationInfo;
                if (pageBasedPaginationInfo2 != null) {
                    i = pageBasedPaginationInfo2.getCurrentPage();
                }
                if (i == 0) {
                    BaseViewModel.showProgress$default(this, this.contentVisibilityLiveData, (String) null, 2, (Object) null);
                }
                getUserListingSingle(i).observeOn(AndroidSchedulers.mainThread()).subscribe(new UserListingViewModel$fetchUserListing$1(this, i));
            }
        }
    }

    public final void toggleFollowUser(ListedUser listedUser) {
        Intrinsics.checkNotNullParameter(listedUser, "user");
        FollowUserRequest followUserRequest = new FollowUserRequest();
        followUserRequest.setTargetUserId(listedUser.getUserId());
        followUserRequest.setType(listedUser.getIamfollowing() ? FollowUserRequest.UNFOLLOW : FollowUserRequest.FOLLOW);
        BaseViewModel.showBlockingProgressDialog$default(this, (String) null, 1, (Object) null);
        this.repository.toggleFollowUser(followUserRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new UserListingViewModel$toggleFollowUser$1(this, listedUser));
    }

    public final void refresh() {
        this.usersPaginationInfo = null;
        this.currentSearchQuery = null;
        this.cachedListedUsers.clear();
        fetchUserListing();
    }

    private final Single<UniversalResult<ListedUser>> getUserListingSingle(int i) {
        UserListingTarget userListingTarget2 = this.userListingTarget;
        if (userListingTarget2 instanceof UserListingTarget.Likes) {
            PostLikeUsersRequest postLikeUsersRequest = new PostLikeUsersRequest();
            postLikeUsersRequest.setPostId(((UserListingTarget.Likes) userListingTarget2).getPostId());
            postLikeUsersRequest.setPage(i + 1);
            return this.repository.fetchPostLikeUsers(postLikeUsersRequest);
        } else if (userListingTarget2 instanceof UserListingTarget.Followers) {
            FollowersRequest followersRequest = new FollowersRequest();
            followersRequest.setTargetUserId(((UserListingTarget.Followers) userListingTarget2).getTargetUserId());
            int i2 = i + 1;
            followersRequest.setPage(i2);
            followersRequest.setNewPage(Integer.valueOf(i2));
            return this.repository.fetchFollowers(followersRequest);
        } else if (userListingTarget2 instanceof UserListingTarget.Followings) {
            FollowingsRequest followingsRequest = new FollowingsRequest();
            followingsRequest.setTargetUserId(((UserListingTarget.Followings) userListingTarget2).getTargetUserId());
            int i3 = i + 1;
            followingsRequest.setPage(i3);
            followingsRequest.setNewPage(Integer.valueOf(i3));
            return this.repository.fetchFollowings(followingsRequest);
        } else if (userListingTarget2 instanceof UserListingTarget.Suggestions) {
            SuggestedUsersRequest suggestedUsersRequest = new SuggestedUsersRequest();
            int i4 = i + 1;
            suggestedUsersRequest.setPage(i4);
            suggestedUsersRequest.setNewPage(Integer.valueOf(i4));
            Single<R> map = this.repository.fetchSuggestedProfiles(suggestedUsersRequest).map(UserListingViewModel$getUserListingSingle$1.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(map, "response.map { result ->…  result.pagination)\n\t\t\t}");
            return map;
        } else {
            throw new RuntimeException("Unknown target selection for listing users");
        }
    }

    public void onContentLayoutErrorResolutionButtonTapped(int i, int i2) {
        refresh();
    }
}
