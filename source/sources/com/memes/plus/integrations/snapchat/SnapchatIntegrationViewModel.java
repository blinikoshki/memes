package com.memes.plus.integrations.snapchat;

import androidx.lifecycle.ViewModelKt;
import com.memes.commons.output.OutputTargetGenerator;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.plus.integrations.screenshots.ScreenshotItem;
import com.memes.plus.p040ui.posts.Post;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\n\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0016\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo26107d2 = {"Lcom/memes/plus/integrations/snapchat/SnapchatIntegrationViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "snapchatContext", "Lcom/memes/plus/integrations/snapchat/SnapchatContext;", "outputTargetGenerator", "Lcom/memes/commons/output/OutputTargetGenerator;", "(Lcom/memes/plus/integrations/snapchat/SnapchatContext;Lcom/memes/commons/output/OutputTargetGenerator;)V", "_sharePostExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "_shareProfileExceptionHandler", "sharePost", "", "post", "Lcom/memes/plus/ui/posts/Post;", "screenshotItem", "Lcom/memes/plus/integrations/screenshots/ScreenshotItem;", "Lkotlinx/coroutines/Job;", "postId", "", "screenshotFile", "Ljava/io/File;", "shareProfile", "userProfileId", "profileId", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: SnapchatIntegrationViewModel.kt */
public final class SnapchatIntegrationViewModel extends BaseViewModel {
    private final CoroutineExceptionHandler _sharePostExceptionHandler = new C4216xb2c60741(CoroutineExceptionHandler.Key, this);
    private final CoroutineExceptionHandler _shareProfileExceptionHandler = new C4215xb2c60740(CoroutineExceptionHandler.Key, this);
    /* access modifiers changed from: private */
    public final OutputTargetGenerator outputTargetGenerator;
    /* access modifiers changed from: private */
    public final SnapchatContext snapchatContext;

    public SnapchatIntegrationViewModel(SnapchatContext snapchatContext2, OutputTargetGenerator outputTargetGenerator2) {
        Intrinsics.checkNotNullParameter(snapchatContext2, "snapchatContext");
        Intrinsics.checkNotNullParameter(outputTargetGenerator2, "outputTargetGenerator");
        this.snapchatContext = snapchatContext2;
        this.outputTargetGenerator = outputTargetGenerator2;
    }

    public final void shareProfile(String str, ScreenshotItem screenshotItem) {
        Intrinsics.checkNotNullParameter(str, "userProfileId");
        Intrinsics.checkNotNullParameter(screenshotItem, "screenshotItem");
        if (!StringsKt.isBlank(str)) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this._shareProfileExceptionHandler, (CoroutineStart) null, new SnapchatIntegrationViewModel$shareProfile$1(this, screenshotItem, str, (Continuation) null), 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final Job shareProfile(String str, File file) {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this._shareProfileExceptionHandler, (CoroutineStart) null, new SnapchatIntegrationViewModel$shareProfile$2(this, file, str, (Continuation) null), 2, (Object) null);
    }

    public final void sharePost(Post post, ScreenshotItem screenshotItem) {
        Intrinsics.checkNotNullParameter(post, "post");
        Intrinsics.checkNotNullParameter(screenshotItem, "screenshotItem");
        String postId = post.getPostId();
        CharSequence charSequence = postId;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this._sharePostExceptionHandler, (CoroutineStart) null, new SnapchatIntegrationViewModel$sharePost$1(this, postId, screenshotItem, (Continuation) null), 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final Job sharePost(String str, File file) {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this._shareProfileExceptionHandler, (CoroutineStart) null, new SnapchatIntegrationViewModel$sharePost$2(this, file, str, (Continuation) null), 2, (Object) null);
    }
}
