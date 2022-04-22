package com.memes.plus.p040ui.profile.profile_posts;

import androidx.lifecycle.MutableLiveData;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import com.memes.commons.recycleradapter.AdapterUpdate;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.network.memes.MemesSession;
import com.memes.plus.base.BaseRxJavaViewModel;
import com.memes.plus.data.mapped_response.PageBasedPaginationInfo;
import com.memes.plus.data.mapped_response.UniversalResult;
import com.memes.plus.data.source.memes.MemesRepository;
import com.memes.plus.p040ui.posts.Post;
import com.memes.plus.p040ui.profile.user_profile.UserProfileRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import p015io.reactivex.Single;
import p015io.reactivex.android.schedulers.AndroidSchedulers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R&\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000e¨\u0006\""}, mo26107d2 = {"Lcom/memes/plus/ui/profile/profile_posts/ProfilePostsViewModel;", "Lcom/memes/plus/base/BaseRxJavaViewModel;", "targetUserId", "", "targetUserName", "targetTabPosition", "", "memesRepository", "Lcom/memes/plus/data/source/memes/MemesRepository;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/memes/plus/data/source/memes/MemesRepository;)V", "contentVisibilityLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "getContentVisibilityLiveData", "()Landroidx/lifecycle/MutableLiveData;", "postsLiveData", "Lcom/memes/commons/util/SingleLiveEvent;", "Lcom/memes/commons/recycleradapter/AdapterUpdate;", "Lcom/memes/plus/ui/posts/Post;", "getPostsLiveData", "()Lcom/memes/commons/util/SingleLiveEvent;", "setPostsLiveData", "(Lcom/memes/commons/util/SingleLiveEvent;)V", "postsPaginationInfo", "Lcom/memes/plus/data/mapped_response/PageBasedPaginationInfo;", "profileRequest", "Lcom/memes/plus/ui/profile/user_profile/UserProfileRequest;", "Ljava/lang/Integer;", "topBarTitleLiveData", "getTopBarTitleLiveData", "fetchPosts", "", "forceRefresh", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.profile_posts.ProfilePostsViewModel */
/* compiled from: ProfilePostsViewModel.kt */
public final class ProfilePostsViewModel extends BaseRxJavaViewModel {
    private final MutableLiveData<ContentVisibilityAction> contentVisibilityLiveData = new MutableLiveData<>();
    private final MemesRepository memesRepository;
    private SingleLiveEvent<AdapterUpdate<Post>> postsLiveData = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public PageBasedPaginationInfo postsPaginationInfo;
    private final UserProfileRequest profileRequest;
    private final Integer targetTabPosition;
    private final String targetUserId;
    private final String targetUserName;
    private final MutableLiveData<String> topBarTitleLiveData;

    public ProfilePostsViewModel(String str, String str2, Integer num, MemesRepository memesRepository2) {
        Intrinsics.checkNotNullParameter(memesRepository2, "memesRepository");
        this.targetUserId = str;
        this.targetUserName = str2;
        this.targetTabPosition = num;
        this.memesRepository = memesRepository2;
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this.topBarTitleLiveData = mutableLiveData;
        UserProfileRequest userProfileRequest = new UserProfileRequest();
        userProfileRequest.setTargetUserId(str);
        userProfileRequest.setTargetUserName(str2);
        Unit unit = Unit.INSTANCE;
        this.profileRequest = userProfileRequest;
        mutableLiveData.setValue(str2);
    }

    public final MutableLiveData<String> getTopBarTitleLiveData() {
        return this.topBarTitleLiveData;
    }

    public final SingleLiveEvent<AdapterUpdate<Post>> getPostsLiveData() {
        return this.postsLiveData;
    }

    public final void setPostsLiveData(SingleLiveEvent<AdapterUpdate<Post>> singleLiveEvent) {
        Intrinsics.checkNotNullParameter(singleLiveEvent, "<set-?>");
        this.postsLiveData = singleLiveEvent;
    }

    public final MutableLiveData<ContentVisibilityAction> getContentVisibilityLiveData() {
        return this.contentVisibilityLiveData;
    }

    public static /* synthetic */ void fetchPosts$default(ProfilePostsViewModel profilePostsViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        profilePostsViewModel.fetchPosts(z);
    }

    public final void fetchPosts(boolean z) {
        Single<UniversalResult<Post>> single = null;
        if (z) {
            this.postsPaginationInfo = null;
        }
        PageBasedPaginationInfo pageBasedPaginationInfo = this.postsPaginationInfo;
        if (pageBasedPaginationInfo == null || pageBasedPaginationInfo.canFetchNextPage()) {
            PageBasedPaginationInfo pageBasedPaginationInfo2 = this.postsPaginationInfo;
            boolean z2 = false;
            int currentPage = pageBasedPaginationInfo2 != null ? pageBasedPaginationInfo2.getCurrentPage() : 0;
            if (currentPage == 0) {
                BaseViewModel.showProgress$default(this, this.contentVisibilityLiveData, (String) null, 2, (Object) null);
            }
            this.profileRequest.setPage(currentPage + 1);
            if (MemesSession.INSTANCE.isOf(this.targetUserId) || MemesSession.INSTANCE.isOf(this.targetUserName)) {
                z2 = true;
            }
            if (z2) {
                Integer num = this.targetTabPosition;
                if (num != null && num.intValue() == 0) {
                    single = this.memesRepository.fetchSelfPosts(this.profileRequest.getPage());
                } else if (num != null && num.intValue() == 1) {
                    single = this.memesRepository.fetchSelfSavedPosts(this.profileRequest.getPage());
                } else if (num != null && num.intValue() == 2) {
                    single = this.memesRepository.fetchSelfTaggedPosts(this.profileRequest.getPage());
                }
            } else {
                Integer num2 = this.targetTabPosition;
                if (num2 != null && num2.intValue() == 0) {
                    single = this.memesRepository.fetchUserPosts(this.profileRequest);
                } else if (num2 != null && num2.intValue() == 1) {
                    single = this.memesRepository.fetchUserTaggedPosts(this.profileRequest);
                }
            }
            if (single != null) {
                single.observeOn(AndroidSchedulers.mainThread()).subscribe(new ProfilePostsViewModel$fetchPosts$1(this, currentPage));
                return;
            }
            throw new RuntimeException("Unknown Tab Source for fetching profile posts");
        }
    }
}
