package com.memes.plus.util;

import android.content.Context;
import android.content.DialogInterface;
import com.memes.plus.C4199R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\rJ>\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000fJ$\u0010\u0010\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000bJ:\u0010\u0010\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¨\u0006\u0014"}, mo26107d2 = {"Lcom/memes/plus/util/DialogUtil;", "", "()V", "askConfirmation", "", "context", "Landroid/content/Context;", "title", "", "message", "cancellable", "", "onConfirmed", "Lkotlin/Function0;", "callback", "Lcom/memes/plus/util/DialogUtil$Callback;", "showInformation", "listener", "Landroid/content/DialogInterface$OnClickListener;", "Callback", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: DialogUtil.kt */
public final class DialogUtil {
    public static final DialogUtil INSTANCE = new DialogUtil();

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/util/DialogUtil$Callback;", "T", "", "onResult", "", "result", "(Ljava/lang/Object;)V", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: DialogUtil.kt */
    public interface Callback<T> {
        void onResult(T t);
    }

    private DialogUtil() {
    }

    public static /* synthetic */ void showInformation$default(DialogUtil dialogUtil, Context context, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        dialogUtil.showInformation(context, str, z);
    }

    public final void showInformation(Context context, String str, boolean z) {
        if (context != null) {
            showInformation$default(this, context, context.getString(C4199R.string.success), str, z, (DialogInterface.OnClickListener) null, 16, (Object) null);
        }
    }

    public static /* synthetic */ void showInformation$default(DialogUtil dialogUtil, Context context, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener, int i, Object obj) {
        boolean z2 = (i & 8) != 0 ? false : z;
        if ((i & 16) != 0) {
            onClickListener = null;
        }
        dialogUtil.showInformation(context, str, str2, z2, onClickListener);
    }

    public final void showInformation(Context context, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        if (context != null) {
            CharSequence charSequence = str2;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                StyledAlertDialog.INSTANCE.builder(context).setTitle(str).setMessage(charSequence).setCancelable(z).setPositiveButton(C4199R.string.f1000ok, onClickListener).show();
            }
        }
    }

    public static /* synthetic */ void askConfirmation$default(DialogUtil dialogUtil, Context context, String str, String str2, boolean z, Callback callback, int i, Object obj) {
        dialogUtil.askConfirmation(context, str, str2, (i & 8) != 0 ? false : z, (Callback<Boolean>) callback);
    }

    public final void askConfirmation(Context context, String str, String str2, boolean z, Callback<Boolean> callback) {
        if (context != null) {
            CharSequence charSequence = str2;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                StyledAlertDialog.INSTANCE.builder(context).setTitle(str).setMessage(charSequence).setCancelable(z).setPositiveButton(C4199R.string.yes, new DialogUtil$askConfirmation$1(callback)).setNegativeButton(C4199R.string.cancel, new DialogUtil$askConfirmation$2(callback)).show();
            }
        }
    }

    public static /* synthetic */ void askConfirmation$default(DialogUtil dialogUtil, Context context, String str, String str2, boolean z, Function0 function0, int i, Object obj) {
        dialogUtil.askConfirmation(context, str, str2, (i & 8) != 0 ? false : z, (Function0<Unit>) function0);
    }

    public final void askConfirmation(Context context, String str, String str2, boolean z, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onConfirmed");
        if (context != null) {
            CharSequence charSequence = str2;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                StyledAlertDialog.INSTANCE.builder(context).setTitle(str).setMessage(charSequence).setCancelable(z).setPositiveButton(C4199R.string.yes, new DialogUtil$askConfirmation$3(function0)).setNegativeButton(C4199R.string.cancel, (DialogInterface.OnClickListener) null).show();
            }
        }
    }
}
