package com.memes.plus.integrations.facebook;

import androidx.fragment.app.Fragment;
import com.facebook.share.widget.ShareDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/integrations/facebook/FacebookFragmentContext;", "Lcom/memes/plus/integrations/facebook/FacebookContext;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "createShareDialog", "Lcom/facebook/share/widget/ShareDialog;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FacebookFragmentContext.kt */
public final class FacebookFragmentContext extends FacebookContext {
    private final Fragment fragment;

    public FacebookFragmentContext(Fragment fragment2) {
        Intrinsics.checkNotNullParameter(fragment2, "fragment");
        this.fragment = fragment2;
    }

    /* access modifiers changed from: protected */
    public ShareDialog createShareDialog() {
        return new ShareDialog(this.fragment);
    }
}
