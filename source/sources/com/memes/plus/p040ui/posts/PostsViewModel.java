package com.memes.plus.p040ui.posts;

import androidx.lifecycle.MutableLiveData;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import com.memes.commons.recycleradapter.AdapterUpdate;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.plus.base.BaseRxJavaViewModel;
import com.memes.plus.data.mapped_response.PageBasedPaginationInfo;
import com.memes.plus.data.source.memes.MemesRepository;
import com.memes.plus.data.storage.StorageRepository;
import com.memes.plus.p040ui.apprating.AppRatingRequest;
import com.memes.plus.p040ui.home.feeds.HomeFeedType;
import com.memes.plus.p040ui.posts.PostBox;
import com.memes.plus.p040ui.posts.suggestions.SuggestedUsersRequest;
import com.memes.plus.p040ui.suggestions.SuggestedProfile;
import com.memes.plus.p040ui.suggestions.SuggestedProfileBox;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.reactivex.android.schedulers.AndroidSchedulers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 /2\u00020\u0001:\u0001/B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\u001fJ\u0006\u0010%\u001a\u00020\"J\u000e\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u001fJ\u000e\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u000fJ \u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020\b2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-H\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010\r¨\u00060"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostsViewModel;", "Lcom/memes/plus/base/BaseRxJavaViewModel;", "repository", "Lcom/memes/plus/data/source/memes/MemesRepository;", "storageRepository", "Lcom/memes/plus/data/storage/StorageRepository;", "(Lcom/memes/plus/data/source/memes/MemesRepository;Lcom/memes/plus/data/storage/StorageRepository;)V", "appRatingRequestIndex", "", "contentVisibilityLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "getContentVisibilityLiveData", "()Landroidx/lifecycle/MutableLiveData;", "feedType", "Lcom/memes/plus/ui/home/feeds/HomeFeedType;", "inviteBoxIndex", "nextSuggestIndex", "offset", "postsLiveData", "Lcom/memes/commons/util/SingleLiveEvent;", "Lcom/memes/commons/recycleradapter/AdapterUpdate;", "Lcom/memes/plus/ui/posts/PostBox;", "getPostsLiveData", "()Lcom/memes/commons/util/SingleLiveEvent;", "postsPaginationInfo", "Lcom/memes/plus/data/mapped_response/PageBasedPaginationInfo;", "suggestedProfiles", "", "Lcom/memes/plus/ui/suggestions/SuggestedProfile;", "swipeRefreshLayoutLiveData", "", "getSwipeRefreshLayoutLiveData", "closeInvite", "", "fetchPosts", "forceRefresh", "fetchSuggestedProfiles", "setAppRatingConfirmed", "confirmed", "setFeedType", "type", "showPosts", "page", "posts", "", "Lcom/memes/plus/ui/posts/Post;", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.PostsViewModel */
/* compiled from: PostsViewModel.kt */
public final class PostsViewModel extends BaseRxJavaViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static boolean isInviteClosed;
    private final int appRatingRequestIndex = 12;
    private final MutableLiveData<ContentVisibilityAction> contentVisibilityLiveData = new MutableLiveData<>();
    private HomeFeedType feedType = HomeFeedType.FOLLOWING;
    private final int inviteBoxIndex = 3;
    private int nextSuggestIndex = 5;
    private final int offset = 11;
    private final SingleLiveEvent<AdapterUpdate<PostBox>> postsLiveData = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public PageBasedPaginationInfo postsPaginationInfo;
    private final MemesRepository repository;
    private final StorageRepository storageRepository;
    /* access modifiers changed from: private */
    public List<SuggestedProfile> suggestedProfiles;
    private final MutableLiveData<Boolean> swipeRefreshLayoutLiveData = new MutableLiveData<>();

    public PostsViewModel(MemesRepository memesRepository, StorageRepository storageRepository2) {
        Intrinsics.checkNotNullParameter(memesRepository, "repository");
        Intrinsics.checkNotNullParameter(storageRepository2, "storageRepository");
        this.repository = memesRepository;
        this.storageRepository = storageRepository2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostsViewModel$Companion;", "", "()V", "isInviteClosed", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostsViewModel$Companion */
    /* compiled from: PostsViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final SingleLiveEvent<AdapterUpdate<PostBox>> getPostsLiveData() {
        return this.postsLiveData;
    }

    public final MutableLiveData<ContentVisibilityAction> getContentVisibilityLiveData() {
        return this.contentVisibilityLiveData;
    }

    public final MutableLiveData<Boolean> getSwipeRefreshLayoutLiveData() {
        return this.swipeRefreshLayoutLiveData;
    }

    public final void setFeedType(HomeFeedType homeFeedType) {
        Intrinsics.checkNotNullParameter(homeFeedType, "type");
        this.feedType = homeFeedType;
    }

    public static /* synthetic */ void fetchPosts$default(PostsViewModel postsViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        postsViewModel.fetchPosts(z);
    }

    public final void fetchPosts(boolean z) {
        if (z) {
            this.postsPaginationInfo = null;
            this.nextSuggestIndex = 5;
        }
        PageBasedPaginationInfo pageBasedPaginationInfo = this.postsPaginationInfo;
        if (pageBasedPaginationInfo == null || pageBasedPaginationInfo.canFetchNextPage()) {
            PageBasedPaginationInfo pageBasedPaginationInfo2 = this.postsPaginationInfo;
            int currentPage = pageBasedPaginationInfo2 != null ? pageBasedPaginationInfo2.getCurrentPage() : 0;
            if (currentPage == 0 && !z) {
                BaseViewModel.showProgress$default(this, this.contentVisibilityLiveData, (String) null, 2, (Object) null);
            }
            this.repository.fetchPosts(currentPage + 1, this.feedType).observeOn(AndroidSchedulers.mainThread()).subscribe(new PostsViewModel$fetchPosts$1(this, currentPage));
        }
    }

    public final void setAppRatingConfirmed(boolean z) {
        this.storageRepository.setAppRatingConfirmed(z);
    }

    public final void fetchSuggestedProfiles() {
        SuggestedUsersRequest suggestedUsersRequest = new SuggestedUsersRequest();
        suggestedUsersRequest.setPage(1);
        suggestedUsersRequest.setNewPage(1);
        this.repository.fetchSuggestedProfiles(suggestedUsersRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new PostsViewModel$fetchSuggestedProfiles$1(this));
    }

    public final void closeInvite() {
        isInviteClosed = true;
    }

    /* access modifiers changed from: private */
    public final void showPosts(int i, List<? extends Post> list) {
        List arrayList = new ArrayList();
        Collection collection = list;
        if (!(collection == null || collection.isEmpty())) {
            int i2 = 0;
            for (Post post : list) {
                if (i == 0 && i2 == this.inviteBoxIndex && !isInviteClosed) {
                    arrayList.add(PostBox.InviteItem.INSTANCE);
                }
                if (!this.storageRepository.appRatingConfirmed() && i == 0 && i2 == this.appRatingRequestIndex) {
                    arrayList.add(new PostBox.AppRatingItem(new AppRatingRequest("Hey " + this.storageRepository.name() + " thanks for being an \nawesome MEMER 😀", this.storageRepository.profilePic())));
                }
                if (i2 == this.nextSuggestIndex) {
                    List<SuggestedProfile> list2 = this.suggestedProfiles;
                    Collection collection2 = list2;
                    if (!(collection2 == null || collection2.isEmpty())) {
                        arrayList.add(new PostBox.SuggestedUsersItem(new SuggestedProfileBox(list2)));
                        this.nextSuggestIndex += this.offset;
                    }
                }
                arrayList.add(new PostBox.PostItem(post));
                i2++;
            }
            this.nextSuggestIndex -= list.size();
            this.postsLiveData.setValue(new AdapterUpdate(i, arrayList));
        }
    }
}
