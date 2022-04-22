package com.memes.plus.p040ui.profile;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.memes.plus.C4199R;
import com.memes.plus.databinding.ProfileOptionsBottomSheetBinding;
import com.memes.plus.p040ui.profile.user_profile.UserProfile;
import com.memes.plus.util.StyledAlertDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\u001a\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\b\u0010\u0019\u001a\u00020\fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo26107d2 = {"Lcom/memes/plus/ui/profile/ProfileOptionsDialog;", "Landroidx/fragment/app/DialogFragment;", "callback", "Lcom/memes/plus/ui/profile/ProfileOptionsDialog$Callback;", "(Lcom/memes/plus/ui/profile/ProfileOptionsDialog$Callback;)V", "binding", "Lcom/memes/plus/databinding/ProfileOptionsBottomSheetBinding;", "getCallback", "()Lcom/memes/plus/ui/profile/ProfileOptionsDialog$Callback;", "profile", "Lcom/memes/plus/ui/profile/user_profile/UserProfile;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onPause", "onViewCreated", "view", "setProfile", "showBlockConfirmationDialog", "Callback", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.ProfileOptionsDialog */
/* compiled from: ProfileOptionsDialog.kt */
public final class ProfileOptionsDialog extends DialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "ProfileShareDialog";
    private ProfileOptionsBottomSheetBinding binding;
    private final Callback callback;
    /* access modifiers changed from: private */
    public UserProfile profile;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/plus/ui/profile/ProfileOptionsDialog$Callback;", "", "onBlockTapped", "", "onShareProfileTap", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.profile.ProfileOptionsDialog$Callback */
    /* compiled from: ProfileOptionsDialog.kt */
    public interface Callback {
        void onBlockTapped();

        void onShareProfileTap();
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public ProfileOptionsDialog(Callback callback2) {
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.callback = callback2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/plus/ui/profile/ProfileOptionsDialog$Companion;", "", "()V", "TAG", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.profile.ProfileOptionsDialog$Companion */
    /* compiled from: ProfileOptionsDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, C4199R.C4207style.CustomBottomSheetDialogTheme);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ProfileOptionsBottomSheetBinding inflate = ProfileOptionsBottomSheetBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "ProfileOptionsBottomShee…ter, container, false\n\t\t)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return inflate.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        ProfileOptionsBottomSheetBinding profileOptionsBottomSheetBinding = this.binding;
        if (profileOptionsBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        profileOptionsBottomSheetBinding.blockUserTextView.setOnClickListener(new ProfileOptionsDialog$onViewCreated$1(this));
        ProfileOptionsBottomSheetBinding profileOptionsBottomSheetBinding2 = this.binding;
        if (profileOptionsBottomSheetBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        profileOptionsBottomSheetBinding2.shareProfileTextView.setOnClickListener(new ProfileOptionsDialog$onViewCreated$2(this));
        ProfileOptionsBottomSheetBinding profileOptionsBottomSheetBinding3 = this.binding;
        if (profileOptionsBottomSheetBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        profileOptionsBottomSheetBinding3.cancelTextView.setOnClickListener(new ProfileOptionsDialog$onViewCreated$3(this));
        UserProfile userProfile = this.profile;
        if (userProfile != null) {
            ProfileOptionsBottomSheetBinding profileOptionsBottomSheetBinding4 = this.binding;
            if (profileOptionsBottomSheetBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView = profileOptionsBottomSheetBinding4.blockUserTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.blockUserTextView");
            textView.setText(getString(!userProfile.getBlocked() ? C4199R.string.block_user : C4199R.string.unblock_user));
            ProfileOptionsBottomSheetBinding profileOptionsBottomSheetBinding5 = this.binding;
            if (profileOptionsBottomSheetBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView2 = profileOptionsBottomSheetBinding5.blockUserTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.blockUserTextView");
            textView2.setVisibility(0);
            ProfileOptionsBottomSheetBinding profileOptionsBottomSheetBinding6 = this.binding;
            if (profileOptionsBottomSheetBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            View view2 = profileOptionsBottomSheetBinding6.viewDividerOne;
            Intrinsics.checkNotNullExpressionValue(view2, "binding.viewDividerOne");
            view2.setVisibility(0);
            return;
        }
        ProfileOptionsBottomSheetBinding profileOptionsBottomSheetBinding7 = this.binding;
        if (profileOptionsBottomSheetBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView3 = profileOptionsBottomSheetBinding7.blockUserTextView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.blockUserTextView");
        textView3.setVisibility(8);
        ProfileOptionsBottomSheetBinding profileOptionsBottomSheetBinding8 = this.binding;
        if (profileOptionsBottomSheetBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View view3 = profileOptionsBottomSheetBinding8.viewDividerOne;
        Intrinsics.checkNotNullExpressionValue(view3, "binding.viewDividerOne");
        view3.setVisibility(8);
    }

    public final void setProfile(UserProfile userProfile) {
        this.profile = userProfile;
    }

    /* access modifiers changed from: private */
    public final void showBlockConfirmationDialog() {
        StyledAlertDialog styledAlertDialog = StyledAlertDialog.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        AlertDialog.Builder builder = styledAlertDialog.builder(requireContext);
        StringBuilder sb = new StringBuilder();
        sb.append("Block ");
        UserProfile userProfile = this.profile;
        sb.append(userProfile != null ? userProfile.getUsername() : null);
        sb.append('?');
        builder.setTitle(sb.toString()).setMessage(C4199R.string.blockMessage).setCancelable(false).setPositiveButton(C4199R.string.yes, new ProfileOptionsDialog$showBlockConfirmationDialog$1(this)).setNegativeButton(C4199R.string.f999no, (DialogInterface.OnClickListener) null).show();
    }

    public void onPause() {
        super.onPause();
        dismiss();
    }
}
