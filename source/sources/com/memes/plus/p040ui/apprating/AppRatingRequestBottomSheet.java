package com.memes.plus.p040ui.apprating;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.share.internal.ShareConstants;
import com.memes.commons.util.ExtensionsKt;
import com.memes.plus.C4199R;
import com.memes.plus.base.BaseBottomSheetDialogFragment;
import com.memes.plus.custom.UserAvatarView;
import com.memes.plus.databinding.AppRatingRequestBottomSheetBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo26107d2 = {"Lcom/memes/plus/ui/apprating/AppRatingRequestBottomSheet;", "Lcom/memes/plus/base/BaseBottomSheetDialogFragment;", "Lcom/memes/plus/databinding/AppRatingRequestBottomSheetBinding;", "request", "Lcom/memes/plus/ui/apprating/AppRatingRequest;", "onAppRatingConfirmed", "Lkotlin/Function0;", "", "(Lcom/memes/plus/ui/apprating/AppRatingRequest;Lkotlin/jvm/functions/Function0;)V", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onBindingComplete", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.apprating.AppRatingRequestBottomSheet */
/* compiled from: AppRatingRequestBottomSheet.kt */
public final class AppRatingRequestBottomSheet extends BaseBottomSheetDialogFragment<AppRatingRequestBottomSheetBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "AppRatingRequestBottomSheet";
    /* access modifiers changed from: private */
    public final Function0<Unit> onAppRatingConfirmed;
    private final AppRatingRequest request;

    public AppRatingRequestBottomSheet(AppRatingRequest appRatingRequest, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(appRatingRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Intrinsics.checkNotNullParameter(function0, "onAppRatingConfirmed");
        this.request = appRatingRequest;
        this.onAppRatingConfirmed = function0;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/plus/ui/apprating/AppRatingRequestBottomSheet$Companion;", "", "()V", "TAG", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.apprating.AppRatingRequestBottomSheet$Companion */
    /* compiled from: AppRatingRequestBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AppRatingRequestBottomSheetBinding createBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        AppRatingRequestBottomSheetBinding inflate = AppRatingRequestBottomSheetBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "AppRatingRequestBottomSh…flater, container, false)");
        return inflate;
    }

    public void onBindingComplete(Bundle bundle) {
        UserAvatarView.loadUrl$default(((AppRatingRequestBottomSheetBinding) getBinding()).includedLayout.profileImageView, this.request.getProfilePic(), C4199R.C4202drawable.placeholder_profile, (Integer) null, 4, (Object) null);
        TextView textView = ((AppRatingRequestBottomSheetBinding) getBinding()).includedLayout.reviewHeadingTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.includedLayout.reviewHeadingTextView");
        textView.setText(ExtensionsKt.encode(this.request.getMemerText()));
        ((AppRatingRequestBottomSheetBinding) getBinding()).includedLayout.addReviewButton.setOnClickListener(new AppRatingRequestBottomSheet$onBindingComplete$1(this));
    }

    public void onPause() {
        super.onPause();
        dismiss();
    }
}
