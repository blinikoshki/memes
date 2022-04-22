package com.memes.plus.p040ui.profile.self_profile;

import androidx.lifecycle.MutableLiveData;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import com.memes.commons.output.OutputTargetGenerator;
import com.memes.commons.recycleradapter.AdapterUpdate;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.network.memes.MemesSession;
import com.memes.plus.App;
import com.memes.plus.data.mapped_response.UniversalResult;
import com.memes.plus.data.source.memes.MemesRepository;
import com.memes.plus.data.storage.StorageRepository;
import com.memes.plus.p040ui.posts.Post;
import com.memes.plus.p040ui.posts.post_basics.PostBasicsViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.reactivex.Single;
import p015io.reactivex.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010%J\u0006\u0010&\u001a\u00020#J\u0010\u0010'\u001a\u00020#2\b\b\u0002\u0010(\u001a\u00020\u001fJ\b\u0010)\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020\u001fH\u0002R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR&\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0013¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0010\u0010!\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, mo26107d2 = {"Lcom/memes/plus/ui/profile/self_profile/SelfProfileViewModel;", "Lcom/memes/plus/ui/posts/post_basics/PostBasicsViewModel;", "memesRepository", "Lcom/memes/plus/data/source/memes/MemesRepository;", "storageRepository", "Lcom/memes/plus/data/storage/StorageRepository;", "outputTargetGenerator", "Lcom/memes/commons/output/OutputTargetGenerator;", "(Lcom/memes/plus/data/source/memes/MemesRepository;Lcom/memes/plus/data/storage/StorageRepository;Lcom/memes/commons/output/OutputTargetGenerator;)V", "currentSelectedTabPosition", "", "fullPageContentLayoutLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "getFullPageContentLayoutLiveData", "()Landroidx/lifecycle/MutableLiveData;", "postsContentLayoutLiveData", "getPostsContentLayoutLiveData", "postsLiveData", "Lcom/memes/commons/util/SingleLiveEvent;", "Lcom/memes/commons/recycleradapter/AdapterUpdate;", "Lcom/memes/plus/ui/posts/Post;", "getPostsLiveData", "()Lcom/memes/commons/util/SingleLiveEvent;", "setPostsLiveData", "(Lcom/memes/commons/util/SingleLiveEvent;)V", "profileLiveData", "Lcom/memes/plus/ui/profile/self_profile/SelfProfile;", "getProfileLiveData", "setProfileLiveData", "seeAllPostsButtonVisibility", "", "getSeeAllPostsButtonVisibility", "selfProfile", "currentSelectedTabChanged", "", "newSelectedTabPosition", "(Ljava/lang/Integer;)V", "fetchPosts", "fetchProfile", "forceRefresh", "getProfile", "setSeeMoreButtonVisibility", "visible", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.self_profile.SelfProfileViewModel */
/* compiled from: SelfProfileViewModel.kt */
public final class SelfProfileViewModel extends PostBasicsViewModel {
    private int currentSelectedTabPosition;
    private final MutableLiveData<ContentVisibilityAction> fullPageContentLayoutLiveData = new MutableLiveData<>();
    private final MemesRepository memesRepository;
    private final MutableLiveData<ContentVisibilityAction> postsContentLayoutLiveData = new MutableLiveData<>();
    private SingleLiveEvent<AdapterUpdate<Post>> postsLiveData = new SingleLiveEvent<>();
    private SingleLiveEvent<SelfProfile> profileLiveData = new SingleLiveEvent<>();
    private final SingleLiveEvent<Boolean> seeAllPostsButtonVisibility = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public SelfProfile selfProfile;
    /* access modifiers changed from: private */
    public final StorageRepository storageRepository;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelfProfileViewModel(MemesRepository memesRepository2, StorageRepository storageRepository2, OutputTargetGenerator outputTargetGenerator) {
        super(memesRepository2, outputTargetGenerator);
        Intrinsics.checkNotNullParameter(memesRepository2, "memesRepository");
        Intrinsics.checkNotNullParameter(storageRepository2, "storageRepository");
        Intrinsics.checkNotNullParameter(outputTargetGenerator, "outputTargetGenerator");
        this.memesRepository = memesRepository2;
        this.storageRepository = storageRepository2;
        setSeeMoreButtonVisibility(false);
    }

    public final SingleLiveEvent<SelfProfile> getProfileLiveData() {
        return this.profileLiveData;
    }

    public final void setProfileLiveData(SingleLiveEvent<SelfProfile> singleLiveEvent) {
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

    public final void currentSelectedTabChanged(Integer num) {
        if (num != null && num.intValue() == 0) {
            App.Companion.trackingManager().onProfilePostsTabTapped(MemesSession.INSTANCE.getUserId());
        } else if (num != null && num.intValue() == 1) {
            App.Companion.trackingManager().onProfileSavedPostsTabTapped(MemesSession.INSTANCE.getUserId());
        } else if (num != null && num.intValue() == 2) {
            App.Companion.trackingManager().onProfileTaggedPostsTapped(MemesSession.INSTANCE.getUserId());
        }
        if (num != null && this.currentSelectedTabPosition != num.intValue()) {
            this.currentSelectedTabPosition = num.intValue();
            fetchPosts();
        }
    }

    public final SelfProfile getProfile() {
        return this.selfProfile;
    }

    public static /* synthetic */ void fetchProfile$default(SelfProfileViewModel selfProfileViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        selfProfileViewModel.fetchProfile(z);
    }

    public final void fetchProfile(boolean z) {
        if (z || this.profileLiveData.getValue() == null) {
            BaseViewModel.showProgress$default(this, this.fullPageContentLayoutLiveData, (String) null, 2, (Object) null);
            this.memesRepository.fetchSelfProfile().observeOn(AndroidSchedulers.mainThread()).subscribe(new SelfProfileViewModel$fetchProfile$1(this));
        } else if (this.postsLiveData.getValue() == null) {
            fetchPosts();
        }
    }

    public final void fetchPosts() {
        setSeeMoreButtonVisibility(false);
        Single<UniversalResult<Post>> single = null;
        BaseViewModel.showProgress$default(this, this.postsContentLayoutLiveData, (String) null, 2, (Object) null);
        int i = this.currentSelectedTabPosition;
        if (i == 0) {
            single = this.memesRepository.fetchSelfPosts(1);
        } else if (i == 1) {
            single = this.memesRepository.fetchSelfSavedPosts(1);
        } else if (i != 2) {
            Timber.m300d("Unknown Tab Selected: " + this.currentSelectedTabPosition, new Object[0]);
        } else {
            single = this.memesRepository.fetchSelfTaggedPosts(1);
        }
        if (single != null) {
            single.observeOn(AndroidSchedulers.mainThread()).subscribe(new SelfProfileViewModel$fetchPosts$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final void setSeeMoreButtonVisibility(boolean z) {
        this.seeAllPostsButtonVisibility.setValue(Boolean.valueOf(z));
    }
}
