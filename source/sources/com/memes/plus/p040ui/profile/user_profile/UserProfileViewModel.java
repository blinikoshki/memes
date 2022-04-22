package com.memes.plus.p040ui.profile.user_profile;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import com.memes.commons.output.OutputTargetGenerator;
import com.memes.commons.recycleradapter.AdapterUpdate;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.plus.App;
import com.memes.plus.data.mapped_response.UniversalResult;
import com.memes.plus.data.source.memes.MemesRepository;
import com.memes.plus.events.UserFollowEvent;
import com.memes.plus.p040ui.posts.Post;
import com.memes.plus.p040ui.posts.post_basics.PostBasicsViewModel;
import com.memes.plus.p040ui.posts.post_basics.follow_user.FollowUserRequest;
import com.memes.plus.p040ui.posts.post_basics.follow_user.FollowUserResult;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import p015io.reactivex.Single;
import p015io.reactivex.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010.\u001a\u00020/J\u0015\u00100\u001a\u00020/2\b\u00101\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u00102J\u0006\u00103\u001a\u00020/J\u0010\u00104\u001a\u00020/2\b\b\u0002\u00105\u001a\u00020\fJ\b\u00106\u001a\u0004\u0018\u00010-J\u000e\u00107\u001a\u00020/2\u0006\u00108\u001a\u000209J\u0010\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020\fH\u0002J\u0006\u0010<\u001a\u00020/R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR&\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010#R \u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u000e\"\u0004\b'\u0010#R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u000eR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000¨\u0006="}, mo26107d2 = {"Lcom/memes/plus/ui/profile/user_profile/UserProfileViewModel;", "Lcom/memes/plus/ui/posts/post_basics/PostBasicsViewModel;", "targetUserId", "", "targetUserName", "memesRepository", "Lcom/memes/plus/data/source/memes/MemesRepository;", "outputTargetGenerator", "Lcom/memes/commons/output/OutputTargetGenerator;", "(Ljava/lang/String;Ljava/lang/String;Lcom/memes/plus/data/source/memes/MemesRepository;Lcom/memes/commons/output/OutputTargetGenerator;)V", "blockUnblockLiveData", "Lcom/memes/commons/util/SingleLiveEvent;", "", "getBlockUnblockLiveData", "()Lcom/memes/commons/util/SingleLiveEvent;", "blockUserExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getBlockUserExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "blockUserExceptionHandler$delegate", "Lkotlin/Lazy;", "currentSelectedTabPosition", "", "fullPageContentLayoutLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "getFullPageContentLayoutLiveData", "()Landroidx/lifecycle/MutableLiveData;", "postsContentLayoutLiveData", "getPostsContentLayoutLiveData", "postsLiveData", "Lcom/memes/commons/recycleradapter/AdapterUpdate;", "Lcom/memes/plus/ui/posts/Post;", "getPostsLiveData", "setPostsLiveData", "(Lcom/memes/commons/util/SingleLiveEvent;)V", "profileLiveData", "Lcom/memes/plus/ui/profile/user_profile/UserProfileResponse;", "getProfileLiveData", "setProfileLiveData", "profileRequest", "Lcom/memes/plus/ui/profile/user_profile/UserProfileRequest;", "seeAllPostsButtonVisibility", "getSeeAllPostsButtonVisibility", "userProfile", "Lcom/memes/plus/ui/profile/user_profile/UserProfile;", "blockUnblockUser", "", "currentSelectedTabChanged", "newSelectedTabPosition", "(Ljava/lang/Integer;)V", "fetchPosts", "fetchProfile", "forceRefresh", "getProfile", "onUserFollowEventReceived", "event", "Lcom/memes/plus/events/UserFollowEvent;", "setSeeMoreButtonVisibility", "visible", "toggleFollowUser", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.user_profile.UserProfileViewModel */
/* compiled from: UserProfileViewModel.kt */
public final class UserProfileViewModel extends PostBasicsViewModel {
    private final SingleLiveEvent<Boolean> blockUnblockLiveData = new SingleLiveEvent<>();
    private final Lazy blockUserExceptionHandler$delegate;
    private int currentSelectedTabPosition;
    private final MutableLiveData<ContentVisibilityAction> fullPageContentLayoutLiveData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MemesRepository memesRepository;
    private final MutableLiveData<ContentVisibilityAction> postsContentLayoutLiveData = new MutableLiveData<>();
    private SingleLiveEvent<AdapterUpdate<Post>> postsLiveData = new SingleLiveEvent<>();
    private SingleLiveEvent<UserProfileResponse> profileLiveData = new SingleLiveEvent<>();
    private final UserProfileRequest profileRequest;
    private final SingleLiveEvent<Boolean> seeAllPostsButtonVisibility = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final String targetUserId;
    private final String targetUserName;
    /* access modifiers changed from: private */
    public UserProfile userProfile;

    private final CoroutineExceptionHandler getBlockUserExceptionHandler() {
        return (CoroutineExceptionHandler) this.blockUserExceptionHandler$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserProfileViewModel(String str, String str2, MemesRepository memesRepository2, OutputTargetGenerator outputTargetGenerator) {
        super(memesRepository2, outputTargetGenerator);
        Intrinsics.checkNotNullParameter(memesRepository2, "memesRepository");
        Intrinsics.checkNotNullParameter(outputTargetGenerator, "outputTargetGenerator");
        this.targetUserId = str;
        this.targetUserName = str2;
        this.memesRepository = memesRepository2;
        UserProfileRequest userProfileRequest = new UserProfileRequest();
        userProfileRequest.setTargetUserId(str);
        userProfileRequest.setTargetUserName(str2);
        Unit unit = Unit.INSTANCE;
        this.profileRequest = userProfileRequest;
        this.blockUserExceptionHandler$delegate = LazyKt.lazy(new UserProfileViewModel$blockUserExceptionHandler$2(this));
        setSeeMoreButtonVisibility(false);
    }

    public final SingleLiveEvent<UserProfileResponse> getProfileLiveData() {
        return this.profileLiveData;
    }

    public final void setProfileLiveData(SingleLiveEvent<UserProfileResponse> singleLiveEvent) {
        Intrinsics.checkNotNullParameter(singleLiveEvent, "<set-?>");
        this.profileLiveData = singleLiveEvent;
    }

    public final SingleLiveEvent<AdapterUpdate<Post>> getPostsLiveData() {
        return this.postsLiveData;
    }

    public final void setPostsLiveData(SingleLiveEvent<AdapterUpdate<Post>> singleLiveEvent) {
        Intrinsics.checkNotNullParameter(singleLiveEvent, "<set-?>");
        this.postsLiveData = singleLiveEvent;
    }

    public final MutableLiveData<ContentVisibilityAction> getFullPageContentLayoutLiveData() {
        return this.fullPageContentLayoutLiveData;
    }

    public final MutableLiveData<ContentVisibilityAction> getPostsContentLayoutLiveData() {
        return this.postsContentLayoutLiveData;
    }

    public final SingleLiveEvent<Boolean> getSeeAllPostsButtonVisibility() {
        return this.seeAllPostsButtonVisibility;
    }

    public final SingleLiveEvent<Boolean> getBlockUnblockLiveData() {
        return this.blockUnblockLiveData;
    }

    public final void currentSelectedTabChanged(Integer num) {
        if (num != null && num.intValue() == 0) {
            App.Companion.trackingManager().onProfilePostsTabTapped(this.targetUserId);
        } else if (num != null && num.intValue() == 2) {
            App.Companion.trackingManager().onProfileTaggedPostsTapped(this.targetUserId);
        }
        if (num != null && this.currentSelectedTabPosition != num.intValue()) {
            this.currentSelectedTabPosition = num.intValue();
            fetchPosts();
        }
    }

    public final UserProfile getProfile() {
        return this.userProfile;
    }

    public static /* synthetic */ void fetchProfile$default(UserProfileViewModel userProfileViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        userProfileViewModel.fetchProfile(z);
    }

    public final void fetchProfile(boolean z) {
        if (z || this.profileLiveData.getValue() == null) {
            BaseViewModel.showBlockingProgressDialog$default(this, (String) null, 1, (Object) null);
            this.profileRequest.setPage(1);
            this.memesRepository.fetchUserProfile(this.profileRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new UserProfileViewModel$fetchProfile$1(this));
        } else if (this.postsLiveData.getValue() == null) {
            fetchPosts();
        }
    }

    public final void fetchPosts() {
        Single<UniversalResult<Post>> single = null;
        BaseViewModel.showProgress$default(this, this.postsContentLayoutLiveData, (String) null, 2, (Object) null);
        this.profileRequest.setPage(1);
        int i = this.currentSelectedTabPosition;
        if (i == 0) {
            single = this.memesRepository.fetchUserPosts(this.profileRequest);
        } else if (i != 1) {
            Timber.m300d("Unknown Tab Selected: " + this.currentSelectedTabPosition, new Object[0]);
        } else {
            single = this.memesRepository.fetchUserTaggedPosts(this.profileRequest);
        }
        if (single != null) {
            single.observeOn(AndroidSchedulers.mainThread()).subscribe(new UserProfileViewModel$fetchPosts$1(this));
        }
    }

    public final void toggleFollowUser() {
        UserProfile userProfile2 = this.userProfile;
        if (userProfile2 != null) {
            FollowUserRequest followUserRequest = new FollowUserRequest();
            followUserRequest.setTargetUserId(userProfile2.getUserId());
            followUserRequest.setType(userProfile2.getFollowed() ? FollowUserRequest.UNFOLLOW : FollowUserRequest.FOLLOW);
            BaseViewModel.showBlockingProgressDialog$default(this, (String) null, 1, (Object) null);
            this.memesRepository.toggleFollowUser(followUserRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new UserProfileViewModel$toggleFollowUser$1(this, userProfile2));
        }
    }

    public final void onUserFollowEventReceived(UserFollowEvent userFollowEvent) {
        Intrinsics.checkNotNullParameter(userFollowEvent, "event");
        UserProfile userProfile2 = this.userProfile;
        if (userProfile2 != null && !(!Intrinsics.areEqual((Object) userProfile2.getUserId(), (Object) userFollowEvent.getUserId()))) {
            UserProfile userProfile3 = this.userProfile;
            if (userProfile3 != null) {
                userProfile3.setFollowed(userFollowEvent.getFollowed());
            }
            UserProfile userProfile4 = this.userProfile;
            if (userProfile4 != null) {
                userProfile4.setFollower(userFollowEvent.getFollowerCount());
            }
            getUserFollowLiveData().setValue(new FollowUserResult(userFollowEvent.getUserId(), userFollowEvent.getFollowed(), userFollowEvent.getFollowerCount()));
        }
    }

    public final void blockUnblockUser() {
        CharSequence charSequence = this.targetUserId;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            toast("Target User ID is not found.");
            return;
        }
        BaseViewModel.showBlockingProgressDialog$default(this, (String) null, 1, (Object) null);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), getBlockUserExceptionHandler(), (CoroutineStart) null, new UserProfileViewModel$blockUnblockUser$1(this, (Continuation) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void setSeeMoreButtonVisibility(boolean z) {
        this.seeAllPostsButtonVisibility.setValue(Boolean.valueOf(z));
    }
}
