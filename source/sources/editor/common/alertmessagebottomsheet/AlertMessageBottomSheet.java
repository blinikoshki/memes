package editor.common.alertmessagebottomsheet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NAlertMessageBottomSheetBinding;
import editor.util.ExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\u001a\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo26107d2 = {"Leditor/common/alertmessagebottomsheet/AlertMessageBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "binding", "Lcom/memes/editor/databinding/NAlertMessageBottomSheetBinding;", "config", "Leditor/common/alertmessagebottomsheet/AlertMessageConfig;", "positiveCallback", "Lkotlin/Function0;", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onPause", "onViewCreated", "view", "show", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AlertMessageBottomSheet.kt */
public final class AlertMessageBottomSheet extends BottomSheetDialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "AlertMessageBottomSheet";
    private NAlertMessageBottomSheetBinding binding;
    private AlertMessageConfig config;
    /* access modifiers changed from: private */
    public Function0<Unit> positiveCallback;

    public static final /* synthetic */ Function0 access$getPositiveCallback$p(AlertMessageBottomSheet alertMessageBottomSheet) {
        Function0<Unit> function0 = alertMessageBottomSheet.positiveCallback;
        if (function0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("positiveCallback");
        }
        return function0;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Leditor/common/alertmessagebottomsheet/AlertMessageBottomSheet$Companion;", "", "()V", "TAG", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: AlertMessageBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, C4175R.C4183style.TransparentBottomSheet);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        NAlertMessageBottomSheetBinding inflate = NAlertMessageBottomSheetBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NAlertMessageBottomSheet…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        inflate.positiveButton.setOnClickListener(new AlertMessageBottomSheet$onCreateView$1(this));
        NAlertMessageBottomSheetBinding nAlertMessageBottomSheetBinding = this.binding;
        if (nAlertMessageBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nAlertMessageBottomSheetBinding.negativeButton.setOnClickListener(new AlertMessageBottomSheet$onCreateView$2(this));
        NAlertMessageBottomSheetBinding nAlertMessageBottomSheetBinding2 = this.binding;
        if (nAlertMessageBottomSheetBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nAlertMessageBottomSheetBinding2.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        AlertMessageConfig alertMessageConfig = this.config;
        if (alertMessageConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
        }
        CharSequence title = alertMessageConfig.getTitle();
        if (!StringsKt.isBlank(title)) {
            NAlertMessageBottomSheetBinding nAlertMessageBottomSheetBinding = this.binding;
            if (nAlertMessageBottomSheetBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView = nAlertMessageBottomSheetBinding.titleTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleTextView");
            textView.setText(title);
            AlertMessageConfig alertMessageConfig2 = this.config;
            if (alertMessageConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("config");
            }
            CharSequence message = alertMessageConfig2.getMessage();
            if (!StringsKt.isBlank(message)) {
                NAlertMessageBottomSheetBinding nAlertMessageBottomSheetBinding2 = this.binding;
                if (nAlertMessageBottomSheetBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                TextView textView2 = nAlertMessageBottomSheetBinding2.messageTextView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.messageTextView");
                textView2.setText(message);
                AlertMessageConfig alertMessageConfig3 = this.config;
                if (alertMessageConfig3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("config");
                }
                CharSequence positiveActionText = alertMessageConfig3.getPositiveActionText();
                boolean z = true;
                if (positiveActionText == null || StringsKt.isBlank(positiveActionText)) {
                    NAlertMessageBottomSheetBinding nAlertMessageBottomSheetBinding3 = this.binding;
                    if (nAlertMessageBottomSheetBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    MaterialButton materialButton = nAlertMessageBottomSheetBinding3.positiveButton;
                    Intrinsics.checkNotNullExpressionValue(materialButton, "binding.positiveButton");
                    materialButton.setVisibility(8);
                } else {
                    NAlertMessageBottomSheetBinding nAlertMessageBottomSheetBinding4 = this.binding;
                    if (nAlertMessageBottomSheetBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    MaterialButton materialButton2 = nAlertMessageBottomSheetBinding4.positiveButton;
                    Intrinsics.checkNotNullExpressionValue(materialButton2, "binding.positiveButton");
                    materialButton2.setText(positiveActionText);
                    NAlertMessageBottomSheetBinding nAlertMessageBottomSheetBinding5 = this.binding;
                    if (nAlertMessageBottomSheetBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    MaterialButton materialButton3 = nAlertMessageBottomSheetBinding5.positiveButton;
                    Intrinsics.checkNotNullExpressionValue(materialButton3, "binding.positiveButton");
                    materialButton3.setVisibility(0);
                }
                AlertMessageConfig alertMessageConfig4 = this.config;
                if (alertMessageConfig4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("config");
                }
                CharSequence negativeActionText = alertMessageConfig4.getNegativeActionText();
                if (negativeActionText != null && !StringsKt.isBlank(negativeActionText)) {
                    z = false;
                }
                if (z) {
                    NAlertMessageBottomSheetBinding nAlertMessageBottomSheetBinding6 = this.binding;
                    if (nAlertMessageBottomSheetBinding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    MaterialButton materialButton4 = nAlertMessageBottomSheetBinding6.negativeButton;
                    Intrinsics.checkNotNullExpressionValue(materialButton4, "binding.negativeButton");
                    materialButton4.setVisibility(8);
                    return;
                }
                NAlertMessageBottomSheetBinding nAlertMessageBottomSheetBinding7 = this.binding;
                if (nAlertMessageBottomSheetBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                MaterialButton materialButton5 = nAlertMessageBottomSheetBinding7.negativeButton;
                Intrinsics.checkNotNullExpressionValue(materialButton5, "binding.negativeButton");
                materialButton5.setText(negativeActionText);
                NAlertMessageBottomSheetBinding nAlertMessageBottomSheetBinding8 = this.binding;
                if (nAlertMessageBottomSheetBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                MaterialButton materialButton6 = nAlertMessageBottomSheetBinding8.negativeButton;
                Intrinsics.checkNotNullExpressionValue(materialButton6, "binding.negativeButton");
                materialButton6.setVisibility(0);
                return;
            }
            throw new RuntimeException("Message cannot be empty.");
        }
        throw new RuntimeException("Title cannot be empty.");
    }

    public void onPause() {
        super.onPause();
        dismiss();
    }

    public final void show(FragmentManager fragmentManager, AlertMessageConfig alertMessageConfig, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(alertMessageConfig, "config");
        Intrinsics.checkNotNullParameter(function0, "positiveCallback");
        if (ExtKt.fragmentTagExists(fragmentManager, TAG)) {
            fragmentManager.popBackStackImmediate(TAG, 1);
        }
        this.config = alertMessageConfig;
        this.positiveCallback = function0;
        show(fragmentManager, TAG);
    }
}
