package com.memes.plus.p040ui.update;

import android.content.DialogInterface;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo26107d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.update.CheckUpdateActivity$showAppUpdateDialog$1 */
/* compiled from: CheckUpdateActivity.kt */
final class CheckUpdateActivity$showAppUpdateDialog$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ CheckUpdateActivity this$0;

    CheckUpdateActivity$showAppUpdateDialog$1(CheckUpdateActivity checkUpdateActivity) {
        this.this$0 = checkUpdateActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.this$0.getViewModel().skipForceUpdate();
    }
}
