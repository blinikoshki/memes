package com.memes.plus.integrations.facebook;

import android.net.Uri;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H$J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/integrations/facebook/FacebookContext;", "", "()V", "createShareDialog", "Lcom/facebook/share/widget/ShareDialog;", "shareLink", "", "link", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FacebookContext.kt */
public abstract class FacebookContext {
    /* access modifiers changed from: protected */
    public abstract ShareDialog createShareDialog();

    public final void shareLink(String str) {
        Intrinsics.checkNotNullParameter(str, "link");
        createShareDialog().show((ShareContent) ((ShareLinkContent.Builder) new ShareLinkContent.Builder().setContentUrl(Uri.parse(str))).build(), ShareDialog.Mode.AUTOMATIC);
    }
}
