package com.memes.plus.p040ui.posts.post;

import androidx.lifecycle.MutableLiveData;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.plus.base.BaseRxJavaViewModel;
import com.memes.plus.data.source.memes.MemesRepository;
import com.memes.plus.p040ui.posts.Post;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p015io.reactivex.android.schedulers.AndroidSchedulers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0011\u001a\u00020\u0012R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post/PostViewModel;", "Lcom/memes/plus/base/BaseRxJavaViewModel;", "postId", "", "repository", "Lcom/memes/plus/data/source/memes/MemesRepository;", "(Ljava/lang/String;Lcom/memes/plus/data/source/memes/MemesRepository;)V", "contentVisibilityLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "getContentVisibilityLiveData", "()Landroidx/lifecycle/MutableLiveData;", "postLiveData", "Lcom/memes/commons/util/SingleLiveEvent;", "Lcom/memes/plus/ui/posts/Post;", "getPostLiveData", "()Lcom/memes/commons/util/SingleLiveEvent;", "fetchPost", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.post.PostViewModel */
/* compiled from: PostViewModel.kt */
public final class PostViewModel extends BaseRxJavaViewModel {
    private final MutableLiveData<ContentVisibilityAction> contentVisibilityLiveData = new MutableLiveData<>();
    private final String postId;
    private final SingleLiveEvent<Post> postLiveData = new SingleLiveEvent<>();
    private final MemesRepository repository;

    public PostViewModel(String str, MemesRepository memesRepository) {
        Intrinsics.checkNotNullParameter(memesRepository, "repository");
        this.postId = str;
        this.repository = memesRepository;
    }

    public final SingleLiveEvent<Post> getPostLiveData() {
        return this.postLiveData;
    }

    public final MutableLiveData<ContentVisibilityAction> getContentVisibilityLiveData() {
        return this.contentVisibilityLiveData;
    }

    public final void fetchPost() {
        CharSequence charSequence = this.postId;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            MutableLiveData<ContentVisibilityAction> mutableLiveData = this.contentVisibilityLiveData;
            showError(mutableLiveData, "Unable to find post. #" + this.postId);
            return;
        }
        BaseViewModel.showProgress$default(this, this.contentVisibilityLiveData, (String) null, 2, (Object) null);
        this.repository.fetchPost(new PostRequest(this.postId)).observeOn(AndroidSchedulers.mainThread()).subscribe(new PostViewModel$fetchPost$1(this));
    }
}
