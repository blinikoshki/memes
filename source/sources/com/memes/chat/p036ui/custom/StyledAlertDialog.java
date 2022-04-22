package com.memes.chat.p036ui.custom;

import android.content.Context;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.memes.chat.C4059R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, mo26107d2 = {"Lcom/memes/chat/ui/custom/StyledAlertDialog;", "", "()V", "getDangerDialogBuilder", "Landroidx/appcompat/app/AlertDialog$Builder;", "context", "Landroid/content/Context;", "getDefaultBuilder", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.custom.StyledAlertDialog */
/* compiled from: StyledAlertDialog.kt */
public final class StyledAlertDialog {
    public static final StyledAlertDialog INSTANCE = new StyledAlertDialog();

    private StyledAlertDialog() {
    }

    public final AlertDialog.Builder getDefaultBuilder(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new MaterialAlertDialogBuilder(context);
    }

    public final AlertDialog.Builder getDangerDialogBuilder(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new MaterialAlertDialogBuilder(context, C4059R.C4067style.ChatAlertDialog_Danger);
    }
}
