package com.memes.plus.integrations.facebook;

import android.app.Activity;
import com.facebook.share.widget.ShareDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/integrations/facebook/FacebookActivityContext;", "Lcom/memes/plus/integrations/facebook/FacebookContext;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "createShareDialog", "Lcom/facebook/share/widget/ShareDialog;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FacebookActivityContext.kt */
public final class FacebookActivityContext extends FacebookContext {
    private final Activity activity;

    public FacebookActivityContext(Activity activity2) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.activity = activity2;
    }

    /* access modifiers changed from: protected */
    public ShareDialog createShareDialog() {
        return new ShareDialog(this.activity);
    }
}
