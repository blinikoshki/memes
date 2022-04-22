package com.memes.plus.integrations.facebook;

import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.plus.p040ui.posts.Post;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/integrations/facebook/FacebookIntegrationViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "facebookContext", "Lcom/memes/plus/integrations/facebook/FacebookContext;", "(Lcom/memes/plus/integrations/facebook/FacebookContext;)V", "sharePost", "", "post", "Lcom/memes/plus/ui/posts/Post;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FacebookIntegrationViewModel.kt */
public final class FacebookIntegrationViewModel extends BaseViewModel {
    private final FacebookContext facebookContext;

    public FacebookIntegrationViewModel(FacebookContext facebookContext2) {
        Intrinsics.checkNotNullParameter(facebookContext2, "facebookContext");
        this.facebookContext = facebookContext2;
    }

    public final void sharePost(Post post) {
        Intrinsics.checkNotNullParameter(post, "post");
        String shareLink = post.getShareLink();
        CharSequence charSequence = shareLink;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            this.facebookContext.shareLink(shareLink);
        }
    }
}
