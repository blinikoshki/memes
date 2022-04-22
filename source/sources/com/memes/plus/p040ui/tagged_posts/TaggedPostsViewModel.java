package com.memes.plus.p040ui.tagged_posts;

import androidx.lifecycle.MutableLiveData;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import com.memes.commons.recycleradapter.AdapterUpdate;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.plus.base.BaseRxJavaViewModel;
import com.memes.plus.data.mapped_response.PageBasedPaginationInfo;
import com.memes.plus.data.source.memes.MemesRepository;
import com.memes.plus.p040ui.posts.Post;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.reactivex.android.schedulers.AndroidSchedulers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0018\u001a\u00020\u0019R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, mo26107d2 = {"Lcom/memes/plus/ui/tagged_posts/TaggedPostsViewModel;", "Lcom/memes/plus/base/BaseRxJavaViewModel;", "repository", "Lcom/memes/plus/data/source/memes/MemesRepository;", "(Lcom/memes/plus/data/source/memes/MemesRepository;)V", "contentVisibilityLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "getContentVisibilityLiveData", "()Landroidx/lifecycle/MutableLiveData;", "hashTag", "", "getHashTag", "()Ljava/lang/String;", "setHashTag", "(Ljava/lang/String;)V", "postsPaginationInfo", "Lcom/memes/plus/data/mapped_response/PageBasedPaginationInfo;", "taggedPostsLiveData", "Lcom/memes/commons/util/SingleLiveEvent;", "Lcom/memes/commons/recycleradapter/AdapterUpdate;", "Lcom/memes/plus/ui/posts/Post;", "getTaggedPostsLiveData", "()Lcom/memes/commons/util/SingleLiveEvent;", "fetchTaggedPosts", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.tagged_posts.TaggedPostsViewModel */
/* compiled from: TaggedPostsViewModel.kt */
public final class TaggedPostsViewModel extends BaseRxJavaViewModel {
    private final MutableLiveData<ContentVisibilityAction> contentVisibilityLiveData = new MutableLiveData<>();
    private String hashTag;
    /* access modifiers changed from: private */
    public PageBasedPaginationInfo postsPaginationInfo;
    private final MemesRepository repository;
    private final SingleLiveEvent<AdapterUpdate<Post>> taggedPostsLiveData = new SingleLiveEvent<>();

    public TaggedPostsViewModel(MemesRepository memesRepository) {
        Intrinsics.checkNotNullParameter(memesRepository, "repository");
        this.repository = memesRepository;
    }

    public final String getHashTag() {
        return this.hashTag;
    }

    public final void setHashTag(String str) {
        this.hashTag = str;
    }

    public final SingleLiveEvent<AdapterUpdate<Post>> getTaggedPostsLiveData() {
        return this.taggedPostsLiveData;
    }

    public final MutableLiveData<ContentVisibilityAction> getContentVisibilityLiveData() {
        return this.contentVisibilityLiveData;
    }

    public final void fetchTaggedPosts() {
        if (this.hashTag == null) {
            showError(this.contentVisibilityLiveData, "HashTag not available!");
            return;
        }
        PageBasedPaginationInfo pageBasedPaginationInfo = this.postsPaginationInfo;
        if (pageBasedPaginationInfo == null || pageBasedPaginationInfo.canFetchNextPage()) {
            PageBasedPaginationInfo pageBasedPaginationInfo2 = this.postsPaginationInfo;
            int currentPage = pageBasedPaginationInfo2 != null ? pageBasedPaginationInfo2.getCurrentPage() : 0;
            if (currentPage == 0) {
                BaseViewModel.showProgress$default(this, this.contentVisibilityLiveData, (String) null, 2, (Object) null);
            }
            MemesRepository memesRepository = this.repository;
            String str = this.hashTag;
            Intrinsics.checkNotNull(str);
            memesRepository.searchPostsByTag(str, currentPage + 1).observeOn(AndroidSchedulers.mainThread()).subscribe(new TaggedPostsViewModel$fetchTaggedPosts$1(this, currentPage));
        }
    }
}
