package com.memes.plus.p040ui.auth.signup.stages;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.textfield.TextInputEditText;
import com.memes.commons.util.ExtensionsKt;
import com.memes.commons.util.SoftKeyboardUtil;
import com.memes.plus.custom.picasso_plus.CircleTransformation;
import com.memes.plus.databinding.AuthSignUpCompleteFragmentBinding;
import com.memes.plus.p040ui.auth.signup.SignUpActivityHandle;
import com.memes.plus.p040ui.auth.signup.SignUpViewModel;
import com.memes.plus.p040ui.auth.signup.selectbirthday.SelectBirthdayDatePicker;
import com.memes.plus.util.picasso.PicassoExtKt;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Transformation;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0013H\u0016J\u001a\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010¨\u0006$"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/signup/stages/CompleteEmailSignUpFragment;", "Landroidx/fragment/app/Fragment;", "()V", "activityHandle", "Lcom/memes/plus/ui/auth/signup/SignUpActivityHandle;", "binding", "Lcom/memes/plus/databinding/AuthSignUpCompleteFragmentBinding;", "birthdayDatePicker", "Lcom/memes/plus/ui/auth/signup/selectbirthday/SelectBirthdayDatePicker;", "getBirthdayDatePicker", "()Lcom/memes/plus/ui/auth/signup/selectbirthday/SelectBirthdayDatePicker;", "birthdayDatePicker$delegate", "Lkotlin/Lazy;", "signUpViewModel", "Lcom/memes/plus/ui/auth/signup/SignUpViewModel;", "getSignUpViewModel", "()Lcom/memes/plus/ui/auth/signup/SignUpViewModel;", "signUpViewModel$delegate", "loadProfilePicture", "", "filePath", "", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "view", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signup.stages.CompleteEmailSignUpFragment */
/* compiled from: CompleteEmailSignUpFragment.kt */
public final class CompleteEmailSignUpFragment extends Fragment {
    /* access modifiers changed from: private */
    public SignUpActivityHandle activityHandle;
    /* access modifiers changed from: private */
    public AuthSignUpCompleteFragmentBinding binding;
    private final Lazy birthdayDatePicker$delegate = LazyKt.lazy(new CompleteEmailSignUpFragment$birthdayDatePicker$2(this));
    private final Lazy signUpViewModel$delegate = LazyKt.lazy(new CompleteEmailSignUpFragment$signUpViewModel$2(this));

    /* access modifiers changed from: private */
    public final SelectBirthdayDatePicker getBirthdayDatePicker() {
        return (SelectBirthdayDatePicker) this.birthdayDatePicker$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final SignUpViewModel getSignUpViewModel() {
        return (SignUpViewModel) this.signUpViewModel$delegate.getValue();
    }

    public static final /* synthetic */ SignUpActivityHandle access$getActivityHandle$p(CompleteEmailSignUpFragment completeEmailSignUpFragment) {
        SignUpActivityHandle signUpActivityHandle = completeEmailSignUpFragment.activityHandle;
        if (signUpActivityHandle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityHandle");
        }
        return signUpActivityHandle;
    }

    public static final /* synthetic */ AuthSignUpCompleteFragmentBinding access$getBinding$p(CompleteEmailSignUpFragment completeEmailSignUpFragment) {
        AuthSignUpCompleteFragmentBinding authSignUpCompleteFragmentBinding = completeEmailSignUpFragment.binding;
        if (authSignUpCompleteFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return authSignUpCompleteFragmentBinding;
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.activityHandle = (SignUpActivityHandle) context;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        AuthSignUpCompleteFragmentBinding inflate = AuthSignUpCompleteFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "AuthSignUpCompleteFragme…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return inflate.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        AuthSignUpCompleteFragmentBinding authSignUpCompleteFragmentBinding = this.binding;
        if (authSignUpCompleteFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        authSignUpCompleteFragmentBinding.backImageView.setOnClickListener(new CompleteEmailSignUpFragment$onViewCreated$1(this));
        AuthSignUpCompleteFragmentBinding authSignUpCompleteFragmentBinding2 = this.binding;
        if (authSignUpCompleteFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        authSignUpCompleteFragmentBinding2.profilePictureImageView.setOnClickListener(new CompleteEmailSignUpFragment$onViewCreated$2(this));
        AuthSignUpCompleteFragmentBinding authSignUpCompleteFragmentBinding3 = this.binding;
        if (authSignUpCompleteFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputEditText textInputEditText = authSignUpCompleteFragmentBinding3.nameEditText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText, "binding.nameEditText");
        textInputEditText.addTextChangedListener(new C4230xe8bbb62b(this));
        AuthSignUpCompleteFragmentBinding authSignUpCompleteFragmentBinding4 = this.binding;
        if (authSignUpCompleteFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        authSignUpCompleteFragmentBinding4.genderTextView.setOnClickListener(new CompleteEmailSignUpFragment$onViewCreated$4(this));
        AuthSignUpCompleteFragmentBinding authSignUpCompleteFragmentBinding5 = this.binding;
        if (authSignUpCompleteFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        authSignUpCompleteFragmentBinding5.birthdayTextView.setOnClickListener(new CompleteEmailSignUpFragment$onViewCreated$5(this));
        AuthSignUpCompleteFragmentBinding authSignUpCompleteFragmentBinding6 = this.binding;
        if (authSignUpCompleteFragmentBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        authSignUpCompleteFragmentBinding6.submitButton.setOnClickListener(new CompleteEmailSignUpFragment$onViewCreated$6(this));
        getSignUpViewModel().onGenderSelected().observe(getViewLifecycleOwner(), new CompleteEmailSignUpFragment$onViewCreated$7(this));
        getSignUpViewModel().onProfilePictureSelected().observe(getViewLifecycleOwner(), new CompleteEmailSignUpFragment$onViewCreated$8(this));
    }

    public void onResume() {
        super.onResume();
        AuthSignUpCompleteFragmentBinding authSignUpCompleteFragmentBinding = this.binding;
        if (authSignUpCompleteFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputEditText textInputEditText = authSignUpCompleteFragmentBinding.nameEditText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText, "binding.nameEditText");
        CharSequence text = textInputEditText.getText();
        if (text == null || StringsKt.isBlank(text)) {
            SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
            AuthSignUpCompleteFragmentBinding authSignUpCompleteFragmentBinding2 = this.binding;
            if (authSignUpCompleteFragmentBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextInputEditText textInputEditText2 = authSignUpCompleteFragmentBinding2.nameEditText;
            Intrinsics.checkNotNullExpressionValue(textInputEditText2, "binding.nameEditText");
            softKeyboardUtil.showKeyboard(textInputEditText2);
        }
    }

    /* access modifiers changed from: private */
    public final void loadProfilePicture(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            Context context = getContext();
            if (context != null) {
                ExtensionsKt.toast(context, "Failed to retrieve profile picture from device.");
            }
            AuthSignUpCompleteFragmentBinding authSignUpCompleteFragmentBinding = this.binding;
            if (authSignUpCompleteFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            authSignUpCompleteFragmentBinding.profilePictureImageView.setImageResource(0);
            AuthSignUpCompleteFragmentBinding authSignUpCompleteFragmentBinding2 = this.binding;
            if (authSignUpCompleteFragmentBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ImageView imageView = authSignUpCompleteFragmentBinding2.profilePicturePlaceholderView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.profilePicturePlaceholderView");
            imageView.setVisibility(0);
            return;
        }
        AuthSignUpCompleteFragmentBinding authSignUpCompleteFragmentBinding3 = this.binding;
        if (authSignUpCompleteFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView2 = authSignUpCompleteFragmentBinding3.profilePicturePlaceholderView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.profilePicturePlaceholderView");
        imageView2.setVisibility(8);
        Picasso picasso = Picasso.get();
        Intrinsics.checkNotNullExpressionValue(picasso, "Picasso.get()");
        RequestCreator transform = PicassoExtKt.log$default(picasso, (Object) this, str, (String) null, 4, (Object) null).load(new File(str)).fit().transform((Transformation) new CircleTransformation());
        AuthSignUpCompleteFragmentBinding authSignUpCompleteFragmentBinding4 = this.binding;
        if (authSignUpCompleteFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        transform.into(authSignUpCompleteFragmentBinding4.profilePictureImageView);
    }
}
