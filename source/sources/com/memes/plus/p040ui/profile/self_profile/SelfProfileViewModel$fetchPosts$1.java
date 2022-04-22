package com.memes.plus.p040ui.profile.self_profile;

import com.facebook.share.internal.ShareConstants;
import com.memes.commons.recycleradapter.AdapterUpdate;
import com.memes.plus.data.mapped_response.UniversalResult;
import com.memes.plus.p040ui.posts.Post;
import com.memes.plus.util.SmartSingleObserver;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.reactivex.disposables.Disposable;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u000f"}, mo26107d2 = {"com/memes/plus/ui/profile/self_profile/SelfProfileViewModel$fetchPosts$1", "Lcom/memes/plus/util/SmartSingleObserver;", "Lcom/memes/plus/data/mapped_response/UniversalResult;", "Lcom/memes/plus/ui/posts/Post;", "onError", "", "message", "", "throwable", "", "onSubscribe", "d", "Lio/reactivex/disposables/Disposable;", "onSuccess", "universalResult", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.self_profile.SelfProfileViewModel$fetchPosts$1 */
/* compiled from: SelfProfileViewModel.kt */
public final class SelfProfileViewModel$fetchPosts$1 extends SmartSingleObserver<UniversalResult<Post>> {
    final /* synthetic */ SelfProfileViewModel this$0;

    SelfProfileViewModel$fetchPosts$1(SelfProfileViewModel selfProfileViewModel) {
        this.this$0 = selfProfileViewModel;
    }

    public void onSubscribe(Disposable disposable) {
        Intrinsics.checkNotNullParameter(disposable, "d");
        this.this$0.addDisposable(disposable);
    }

    public void onSuccess(UniversalResult<Post> universalResult) {
        Intrinsics.checkNotNullParameter(universalResult, "universalResult");
        boolean z = false;
        if (universalResult.isError()) {
            if (universalResult.isSessionExpired()) {
                SelfProfileViewModel selfProfileViewModel = this.this$0;
                selfProfileViewModel.showLoginError(selfProfileViewModel.getFullPageContentLayoutLiveData(), universalResult.getMessage());
                return;
            }
            SelfProfileViewModel selfProfileViewModel2 = this.this$0;
            selfProfileViewModel2.showError(selfProfileViewModel2.getPostsContentLayoutLiveData(), universalResult.getMessage());
            this.this$0.setSeeMoreButtonVisibility(false);
        } else if (universalResult.hasNoItems()) {
            SelfProfileViewModel selfProfileViewModel3 = this.this$0;
            selfProfileViewModel3.showContentNotAvailable(selfProfileViewModel3.getPostsContentLayoutLiveData(), "No posts found");
            this.this$0.setSeeMoreButtonVisibility(false);
        } else {
            List<Post> requireItems = universalResult.requireItems();
            this.this$0.getPostsLiveData().setValue(new AdapterUpdate(0, requireItems));
            SelfProfileViewModel selfProfileViewModel4 = this.this$0;
            selfProfileViewModel4.showContent(selfProfileViewModel4.getPostsContentLayoutLiveData());
            SelfProfileViewModel selfProfileViewModel5 = this.this$0;
            if (requireItems.size() >= 8) {
                z = true;
            }
            selfProfileViewModel5.setSeeMoreButtonVisibility(z);
        }
    }

    public void onError(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(th, "throwable");
        SelfProfileViewModel selfProfileViewModel = this.this$0;
        selfProfileViewModel.showError(selfProfileViewModel.getPostsContentLayoutLiveData(), str);
        this.this$0.setSeeMoreButtonVisibility(false);
    }
}
