package com.memes.plus.p040ui.auth.signup.selectgender;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.memes.plus.databinding.AuthSelectGenderBottomSheetBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0002\u0018\u0019B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/signup/selectgender/SelectGenderBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "binding", "Lcom/memes/plus/databinding/AuthSelectGenderBottomSheetBinding;", "callback", "Lcom/memes/plus/ui/auth/signup/selectgender/SelectGenderBottomSheet$Callback;", "selectedGender", "Lcom/memes/plus/ui/auth/signup/selectgender/Gender;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "", "onViewCreated", "view", "selectGender", "setCallback", "setSelectedGender", "Callback", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signup.selectgender.SelectGenderBottomSheet */
/* compiled from: SelectGenderBottomSheet.kt */
public final class SelectGenderBottomSheet extends BottomSheetDialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "select-gender-sheet";
    private AuthSelectGenderBottomSheetBinding binding;
    /* access modifiers changed from: private */
    public Callback callback;
    /* access modifiers changed from: private */
    public Gender selectedGender = Gender.NONE;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/signup/selectgender/SelectGenderBottomSheet$Callback;", "", "onGenderSelected", "", "gender", "Lcom/memes/plus/ui/auth/signup/selectgender/Gender;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.auth.signup.selectgender.SelectGenderBottomSheet$Callback */
    /* compiled from: SelectGenderBottomSheet.kt */
    public interface Callback {
        void onGenderSelected(Gender gender);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/signup/selectgender/SelectGenderBottomSheet$Companion;", "", "()V", "TAG", "", "show", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "selectedGender", "Lcom/memes/plus/ui/auth/signup/selectgender/Gender;", "callback", "Lcom/memes/plus/ui/auth/signup/selectgender/SelectGenderBottomSheet$Callback;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.auth.signup.selectgender.SelectGenderBottomSheet$Companion */
    /* compiled from: SelectGenderBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, Gender gender, Callback callback, int i, Object obj) {
            if ((i & 2) != 0) {
                gender = Gender.NONE;
            }
            companion.show(fragmentManager, gender, callback);
        }

        public final void show(FragmentManager fragmentManager, Gender gender, Callback callback) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(gender, "selectedGender");
            Intrinsics.checkNotNullParameter(callback, "callback");
            SelectGenderBottomSheet selectGenderBottomSheet = new SelectGenderBottomSheet();
            selectGenderBottomSheet.setSelectedGender(gender);
            selectGenderBottomSheet.setCallback(callback);
            selectGenderBottomSheet.show(fragmentManager, SelectGenderBottomSheet.TAG);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        AuthSelectGenderBottomSheetBinding inflate = AuthSelectGenderBottomSheetBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "AuthSelectGenderBottomSh…ter, container, false\n\t\t)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return inflate.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        AuthSelectGenderBottomSheetBinding authSelectGenderBottomSheetBinding = this.binding;
        if (authSelectGenderBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        authSelectGenderBottomSheetBinding.noneGenderTextView.setOnClickListener(new SelectGenderBottomSheet$onViewCreated$1(this));
        AuthSelectGenderBottomSheetBinding authSelectGenderBottomSheetBinding2 = this.binding;
        if (authSelectGenderBottomSheetBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        authSelectGenderBottomSheetBinding2.maleGenderTextView.setOnClickListener(new SelectGenderBottomSheet$onViewCreated$2(this));
        AuthSelectGenderBottomSheetBinding authSelectGenderBottomSheetBinding3 = this.binding;
        if (authSelectGenderBottomSheetBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        authSelectGenderBottomSheetBinding3.femaleGenderTextView.setOnClickListener(new SelectGenderBottomSheet$onViewCreated$3(this));
        AuthSelectGenderBottomSheetBinding authSelectGenderBottomSheetBinding4 = this.binding;
        if (authSelectGenderBottomSheetBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        authSelectGenderBottomSheetBinding4.unspecifiedGenderTextView.setOnClickListener(new SelectGenderBottomSheet$onViewCreated$4(this));
        AuthSelectGenderBottomSheetBinding authSelectGenderBottomSheetBinding5 = this.binding;
        if (authSelectGenderBottomSheetBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        authSelectGenderBottomSheetBinding5.doneTextView.setOnClickListener(new SelectGenderBottomSheet$onViewCreated$5(this));
        selectGender(this.selectedGender);
    }

    public void onPause() {
        super.onPause();
        dismiss();
    }

    public final void setSelectedGender(Gender gender) {
        Intrinsics.checkNotNullParameter(gender, "selectedGender");
        this.selectedGender = gender;
    }

    public final void setCallback(Callback callback2) {
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.callback = callback2;
    }

    /* access modifiers changed from: private */
    public final void selectGender(Gender gender) {
        AuthSelectGenderBottomSheetBinding authSelectGenderBottomSheetBinding = this.binding;
        if (authSelectGenderBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = authSelectGenderBottomSheetBinding.noneGenderTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.noneGenderTextView");
        boolean z = true;
        textView.setSelected(gender == Gender.NONE);
        AuthSelectGenderBottomSheetBinding authSelectGenderBottomSheetBinding2 = this.binding;
        if (authSelectGenderBottomSheetBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView2 = authSelectGenderBottomSheetBinding2.maleGenderTextView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.maleGenderTextView");
        textView2.setSelected(gender == Gender.MALE);
        AuthSelectGenderBottomSheetBinding authSelectGenderBottomSheetBinding3 = this.binding;
        if (authSelectGenderBottomSheetBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView3 = authSelectGenderBottomSheetBinding3.femaleGenderTextView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.femaleGenderTextView");
        textView3.setSelected(gender == Gender.FEMALE);
        AuthSelectGenderBottomSheetBinding authSelectGenderBottomSheetBinding4 = this.binding;
        if (authSelectGenderBottomSheetBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView4 = authSelectGenderBottomSheetBinding4.unspecifiedGenderTextView;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.unspecifiedGenderTextView");
        if (gender != Gender.UNSPECIFIED) {
            z = false;
        }
        textView4.setSelected(z);
        this.selectedGender = gender;
    }
}
