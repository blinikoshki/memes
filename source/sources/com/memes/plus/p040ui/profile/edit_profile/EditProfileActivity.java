package com.memes.plus.p040ui.profile.edit_profile;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import androidx.lifecycle.LifecycleOwner;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.commons.imageselection.ImageContent;
import com.memes.commons.imageselection.ImageSelector;
import com.memes.commons.provider.SimpleFileProvider;
import com.memes.commons.util.ExtensionsKt;
import com.memes.commons.util.Intents;
import com.memes.plus.AppConfig;
import com.memes.plus.AppVersion;
import com.memes.plus.C4199R;
import com.memes.plus.base.BaseActivity;
import com.memes.plus.custom.UserAvatarView;
import com.memes.plus.databinding.EditProfileActivityBinding;
import com.memes.plus.util.picasso.PicassoExtKt;
import com.squareup.picasso.Picasso;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001!B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0002J\b\u0010 \u001a\u00020\u0013H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u000f\u0010\u0010¨\u0006\""}, mo26107d2 = {"Lcom/memes/plus/ui/profile/edit_profile/EditProfileActivity;", "Lcom/memes/plus/base/BaseActivity;", "Lcom/memes/commons/contentlayout/ContentLayout$Callback;", "Lcom/memes/commons/imageselection/ImageSelector$Callback;", "()V", "binding", "Lcom/memes/plus/databinding/EditProfileActivityBinding;", "getBinding", "()Lcom/memes/plus/databinding/EditProfileActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "imageSelector", "Lcom/memes/commons/imageselection/ImageSelector;", "viewModel", "Lcom/memes/plus/ui/profile/edit_profile/EditProfileViewModel;", "getViewModel", "()Lcom/memes/plus/ui/profile/edit_profile/EditProfileViewModel;", "viewModel$delegate", "animateCover", "", "onContentLayoutErrorResolutionButtonTapped", "who", "", "why", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onImageFileSelected", "requestIdentifier", "imageContent", "Lcom/memes/commons/imageselection/ImageContent;", "openSupportEmailClient", "rateApp", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.edit_profile.EditProfileActivity */
/* compiled from: EditProfileActivity.kt */
public final class EditProfileActivity extends BaseActivity implements ContentLayout.Callback, ImageSelector.Callback {
    public static final int COVER_IMAGE = 1357;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int PROFILE_IMAGE = 1356;
    public static final int RC_EDIT_PROFILE = 35614;
    public static final String TAG = "EditProfileActivity";
    private final Lazy binding$delegate = LazyKt.lazy(new EditProfileActivity$binding$2(this));
    /* access modifiers changed from: private */
    public final ImageSelector imageSelector = new ImageSelector(this, SimpleFileProvider.NAME);
    private final Lazy viewModel$delegate = LazyKt.lazy(new EditProfileActivity$viewModel$2(this));

    /* access modifiers changed from: private */
    public final EditProfileActivityBinding getBinding() {
        return (EditProfileActivityBinding) this.binding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final EditProfileViewModel getViewModel() {
        return (EditProfileViewModel) this.viewModel$delegate.getValue();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Lcom/memes/plus/ui/profile/edit_profile/EditProfileActivity$Companion;", "", "()V", "COVER_IMAGE", "", "PROFILE_IMAGE", "RC_EDIT_PROFILE", "TAG", "", "getStartIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.profile.edit_profile.EditProfileActivity$Companion */
    /* compiled from: EditProfileActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent getStartIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, EditProfileActivity.class);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EditProfileActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        registerViewModel(getViewModel());
        getBinding().contentLayout.setCallback(this);
        getBinding().topBarBackImageView.setOnClickListener(new EditProfileActivity$onCreate$1(this));
        getBinding().profilePicImageView.setOnClickListener(new EditProfileActivity$onCreate$2(this));
        getBinding().coverImageView.setOnClickListener(new EditProfileActivity$onCreate$3(this));
        getBinding().topBarSaveButton.setOnClickListener(new EditProfileActivity$onCreate$4(this));
        getBinding().nameEditText.setOnFocusChangeListener(EditProfileActivity$onCreate$5.INSTANCE);
        EditText editText = getBinding().nameEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.nameEditText");
        editText.addTextChangedListener(new EditProfileActivity$onCreate$$inlined$addTextChangedListener$1(this));
        getBinding().usernameEditText.setOnFocusChangeListener(EditProfileActivity$onCreate$7.INSTANCE);
        EditText editText2 = getBinding().usernameEditText;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.usernameEditText");
        editText2.addTextChangedListener(new EditProfileActivity$onCreate$$inlined$addTextChangedListener$2(this));
        getBinding().locationEditText.setOnFocusChangeListener(EditProfileActivity$onCreate$9.INSTANCE);
        EditText editText3 = getBinding().locationEditText;
        Intrinsics.checkNotNullExpressionValue(editText3, "binding.locationEditText");
        editText3.addTextChangedListener(new EditProfileActivity$onCreate$$inlined$addTextChangedListener$3(this));
        getBinding().bioEditText.setOnFocusChangeListener(EditProfileActivity$onCreate$11.INSTANCE);
        EditText editText4 = getBinding().bioEditText;
        Intrinsics.checkNotNullExpressionValue(editText4, "binding.bioEditText");
        editText4.addTextChangedListener(new EditProfileActivity$onCreate$$inlined$addTextChangedListener$4(this));
        getBinding().supportTextView.setOnClickListener(new EditProfileActivity$onCreate$13(this));
        getBinding().rateAppTextView.setOnClickListener(new EditProfileActivity$onCreate$14(this));
        getBinding().notificationSettingsTextView.setOnClickListener(new EditProfileActivity$onCreate$15(this));
        getBinding().privacyPolicyTextView.setOnClickListener(new EditProfileActivity$onCreate$16(this));
        getBinding().termsConditionsTextView.setOnClickListener(new EditProfileActivity$onCreate$17(this));
        getBinding().restorePurchasesTextView.setOnClickListener(EditProfileActivity$onCreate$18.INSTANCE);
        getBinding().storeTextView.setOnClickListener(EditProfileActivity$onCreate$19.INSTANCE);
        getBinding().logoutTextView.setOnClickListener(new EditProfileActivity$onCreate$20(this));
        LifecycleOwner lifecycleOwner = this;
        getViewModel().getProfilePicLiveData().observe(lifecycleOwner, new EditProfileActivity$onCreate$21(this));
        getViewModel().getCoverImageLiveData().observe(lifecycleOwner, new EditProfileActivity$onCreate$22(this));
        getViewModel().getNameLiveData().observe(lifecycleOwner, new EditProfileActivity$onCreate$23(this));
        getViewModel().getUserNameLiveData().observe(lifecycleOwner, new EditProfileActivity$onCreate$24(this));
        getViewModel().getLocationLiveData().observe(lifecycleOwner, new EditProfileActivity$onCreate$25(this));
        getViewModel().getBioLiveData().observe(lifecycleOwner, new EditProfileActivity$onCreate$26(this));
        getViewModel().getProfileSavedLiveData().observe(lifecycleOwner, new EditProfileActivity$onCreate$27(this));
        getViewModel().getLogoutLiveData().observe(lifecycleOwner, new EditProfileActivity$onCreate$28(this));
        animateCover();
    }

    /* access modifiers changed from: private */
    public final void openSupportEmailClient() {
        StringBuilder sb = new StringBuilder();
        sb.append("App Version : " + AppVersion.INSTANCE.getPackageVersionName());
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        sb.append("Device: '" + Build.MANUFACTURER + ' ' + Build.MODEL + ' ' + Build.BRAND + ' ' + Build.DEVICE + '\'');
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        sb.append("Add your message below this line:");
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder()\n\t\t\t.appe…pendLine()\n\t\t\t.toString()");
        String string = getString(C4199R.string.support_email_subject);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.support_email_subject)");
        Intent emailIntent = Intents.INSTANCE.getEmailIntent(this, AppConfig.SUPPORT_EMAIL, string, sb2);
        if (emailIntent == null) {
            ExtensionsKt.toast((Context) this, getString(C4199R.string.support_email_fallback_msg, new Object[]{AppConfig.SUPPORT_EMAIL}));
            return;
        }
        startActivity(emailIntent);
    }

    /* access modifiers changed from: private */
    public final void rateApp() {
        Intent playStoreIntent$default = Intents.getPlayStoreIntent$default(Intents.INSTANCE, this, (String) null, 2, (Object) null);
        if (playStoreIntent$default == null) {
            ExtensionsKt.toast((Context) this, (int) C4199R.string.error_rate_app);
        } else {
            startActivity(playStoreIntent$default);
        }
    }

    private final void animateCover() {
        getBinding().coverImageView.startAnimation(AnimationUtils.loadAnimation(this, C4199R.anim.zoom_in));
    }

    public void onImageFileSelected(int i, ImageContent imageContent) {
        Intrinsics.checkNotNullParameter(imageContent, "imageContent");
        if (i == 1356) {
            UserAvatarView.loadUrl$default(getBinding().profilePicImageView, imageContent.getFile().getThumbnail(), C4199R.C4202drawable.placeholder_profile, (Integer) null, 4, (Object) null);
            getViewModel().profilePicChanged(imageContent.getFile().getAbsolutePath());
        } else if (i == 1357) {
            Picasso picasso = Picasso.get();
            Intrinsics.checkNotNullExpressionValue(picasso, "Picasso.get()");
            PicassoExtKt.log(picasso, (Object) this, imageContent.getFile().getAbsolutePath(), "binding.coverImageView").load((File) imageContent.getFile()).placeholder((int) C4199R.C4201color.MemeBackgroundcolor).error((int) C4199R.C4201color.MemeBackgroundcolor).fit().centerCrop().into(getBinding().coverImageView);
            getViewModel().coverImageChanged(imageContent.getFile().getAbsolutePath());
        }
    }

    public void onContentLayoutErrorResolutionButtonTapped(int i, int i2) {
        ContentLayout contentLayout = getBinding().contentLayout;
        Intrinsics.checkNotNullExpressionValue(contentLayout, "binding.contentLayout");
        if (i != contentLayout.getId() || i2 != 1211) {
            super.onContentLayoutErrorResolutionButtonTapped(i, i2);
        }
    }
}
