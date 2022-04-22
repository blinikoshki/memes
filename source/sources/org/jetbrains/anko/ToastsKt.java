package org.jetbrains.anko;

import android.app.Fragment;
import android.content.Context;
import android.widget.Toast;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 1}, mo26106d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0005H\b\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u0003\u001a\u00020\u0005H\b\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\b\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0005H\b\u001a\u0019\u0010\b\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0019\u0010\b\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u0003\u001a\u00020\u0005H\b¨\u0006\t"}, mo26107d2 = {"longToast", "Landroid/widget/Toast;", "Landroid/app/Fragment;", "message", "", "", "Landroid/content/Context;", "Lorg/jetbrains/anko/AnkoContext;", "toast", "commons_release"}, mo26108k = 2, mo26109mv = {1, 1, 5})
/* compiled from: Toasts.kt */
public final class ToastsKt {
    public static final Toast toast(AnkoContext<?> ankoContext, int i) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        Toast makeText = Toast.makeText(ankoContext.getCtx(), i, 0);
        Toast toast = makeText;
        toast.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return toast;
    }

    public static final Toast toast(Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Toast makeText = Toast.makeText(fragment.getActivity(), i, 0);
        Toast toast = makeText;
        toast.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return toast;
    }

    public static final Toast toast(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Toast makeText = Toast.makeText(context, i, 0);
        Toast toast = makeText;
        toast.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return toast;
    }

    public static final Toast toast(AnkoContext<?> ankoContext, CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Toast makeText = Toast.makeText(ankoContext.getCtx(), charSequence, 0);
        Toast toast = makeText;
        toast.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return toast;
    }

    public static final Toast toast(Fragment fragment, CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Toast makeText = Toast.makeText(fragment.getActivity(), charSequence, 0);
        Toast toast = makeText;
        toast.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return toast;
    }

    public static final Toast toast(Context context, CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Toast makeText = Toast.makeText(context, charSequence, 0);
        Toast toast = makeText;
        toast.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return toast;
    }

    public static final Toast longToast(AnkoContext<?> ankoContext, int i) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        Toast makeText = Toast.makeText(ankoContext.getCtx(), i, 1);
        Toast toast = makeText;
        toast.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return toast;
    }

    public static final Toast longToast(Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Toast makeText = Toast.makeText(fragment.getActivity(), i, 1);
        Toast toast = makeText;
        toast.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return toast;
    }

    public static final Toast longToast(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Toast makeText = Toast.makeText(context, i, 1);
        Toast toast = makeText;
        toast.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return toast;
    }

    public static final Toast longToast(AnkoContext<?> ankoContext, CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Toast makeText = Toast.makeText(ankoContext.getCtx(), charSequence, 1);
        Toast toast = makeText;
        toast.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return toast;
    }

    public static final Toast longToast(Fragment fragment, CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Toast makeText = Toast.makeText(fragment.getActivity(), charSequence, 1);
        Toast toast = makeText;
        toast.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return toast;
    }

    public static final Toast longToast(Context context, CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Toast makeText = Toast.makeText(context, charSequence, 1);
        Toast toast = makeText;
        toast.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        return toast;
    }
}
