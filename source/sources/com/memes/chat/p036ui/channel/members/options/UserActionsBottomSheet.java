package com.memes.chat.p036ui.channel.members.options;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.memes.chat.C4059R;
import com.memes.chat.databinding.UserActionsBottomSheetBinding;
import com.memes.chat.p036ui.custom.ChatUserAvatarView;
import com.memes.chat.routing.ChatRouting;
import com.memes.commons.bottomsheet.BaseBottomSheetDialogFragment;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.ContentUtils;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00014B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u001a\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010+\u001a\u00020#2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0012\u0010.\u001a\u00020#2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010/\u001a\u00020#H\u0016J\u001e\u00100\u001a\u00020#2\u0006\u00101\u001a\u0002022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\u000bJ\b\u00103\u001a\u00020#H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\r\u0010\u0007R\u001b\u0010\u000f\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0010\u0010\u0007R\u001b\u0010\u0012\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0013\u0010\u0007R\u001b\u0010\u0015\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0016\u0010\u0007R\u001b\u0010\u0018\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u0019\u0010\u0007R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\t\u001a\u0004\b\u001f\u0010 ¨\u00065"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/members/options/UserActionsBottomSheet;", "Lcom/memes/commons/bottomsheet/BaseBottomSheetDialogFragment;", "Lcom/memes/chat/databinding/UserActionsBottomSheetBinding;", "()V", "banUserClickListener", "Landroid/view/View$OnClickListener;", "getBanUserClickListener", "()Landroid/view/View$OnClickListener;", "banUserClickListener$delegate", "Lkotlin/Lazy;", "channel", "Lio/getstream/chat/android/client/models/Channel;", "muteUserClickListener", "getMuteUserClickListener", "muteUserClickListener$delegate", "reportUserClickListener", "getReportUserClickListener", "reportUserClickListener$delegate", "sendMessageClickListener", "getSendMessageClickListener", "sendMessageClickListener$delegate", "unbanUserClickListener", "getUnbanUserClickListener", "unbanUserClickListener$delegate", "unmuteUserClickListener", "getUnmuteUserClickListener", "unmuteUserClickListener$delegate", "user", "Lio/getstream/chat/android/client/models/User;", "viewModel", "Lcom/memes/chat/ui/channel/members/options/UserActionsViewModel;", "getViewModel", "()Lcom/memes/chat/ui/channel/members/options/UserActionsViewModel;", "viewModel$delegate", "applyState", "", "state", "Lcom/memes/chat/ui/channel/members/options/UserActionState;", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onBindingComplete", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onPause", "show", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "showUserProfile", "Companion", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.members.options.UserActionsBottomSheet */
/* compiled from: UserActionsBottomSheet.kt */
public final class UserActionsBottomSheet extends BaseBottomSheetDialogFragment<UserActionsBottomSheetBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "user_actions_bottom_sheet";
    private final Lazy banUserClickListener$delegate = LazyKt.lazy(new UserActionsBottomSheet$banUserClickListener$2(this));
    private Channel channel;
    private final Lazy muteUserClickListener$delegate = LazyKt.lazy(new UserActionsBottomSheet$muteUserClickListener$2(this));
    private final Lazy reportUserClickListener$delegate = LazyKt.lazy(new UserActionsBottomSheet$reportUserClickListener$2(this));
    private final Lazy sendMessageClickListener$delegate = LazyKt.lazy(new UserActionsBottomSheet$sendMessageClickListener$2(this));
    private final Lazy unbanUserClickListener$delegate = LazyKt.lazy(new UserActionsBottomSheet$unbanUserClickListener$2(this));
    private final Lazy unmuteUserClickListener$delegate = LazyKt.lazy(new UserActionsBottomSheet$unmuteUserClickListener$2(this));
    /* access modifiers changed from: private */
    public User user;
    private final Lazy viewModel$delegate = LazyKt.lazy(new UserActionsBottomSheet$viewModel$2(this));

    private final View.OnClickListener getBanUserClickListener() {
        return (View.OnClickListener) this.banUserClickListener$delegate.getValue();
    }

    private final View.OnClickListener getMuteUserClickListener() {
        return (View.OnClickListener) this.muteUserClickListener$delegate.getValue();
    }

    private final View.OnClickListener getReportUserClickListener() {
        return (View.OnClickListener) this.reportUserClickListener$delegate.getValue();
    }

    private final View.OnClickListener getSendMessageClickListener() {
        return (View.OnClickListener) this.sendMessageClickListener$delegate.getValue();
    }

    private final View.OnClickListener getUnbanUserClickListener() {
        return (View.OnClickListener) this.unbanUserClickListener$delegate.getValue();
    }

    private final View.OnClickListener getUnmuteUserClickListener() {
        return (View.OnClickListener) this.unmuteUserClickListener$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final UserActionsViewModel getViewModel() {
        return (UserActionsViewModel) this.viewModel$delegate.getValue();
    }

    public static final /* synthetic */ UserActionsBottomSheetBinding access$getBinding$p(UserActionsBottomSheet userActionsBottomSheet) {
        return (UserActionsBottomSheetBinding) userActionsBottomSheet.getBinding();
    }

    public static final /* synthetic */ User access$getUser$p(UserActionsBottomSheet userActionsBottomSheet) {
        User user2 = userActionsBottomSheet.user;
        if (user2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("user");
        }
        return user2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/members/options/UserActionsBottomSheet$Companion;", "", "()V", "TAG", "", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.channel.members.options.UserActionsBottomSheet$Companion */
    /* compiled from: UserActionsBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, C4059R.C4067style.Theme_ChatApp_TransparentBottomSheet);
    }

    public UserActionsBottomSheetBinding createBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        UserActionsBottomSheetBinding inflate = UserActionsBottomSheetBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "UserActionsBottomSheetBi…flater, container, false)");
        return inflate;
    }

    public void onBindingComplete(Bundle bundle) {
        registerViewModels(getViewModel());
        UserActionsViewModel viewModel = getViewModel();
        User user2 = this.user;
        if (user2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("user");
        }
        Channel channel2 = this.channel;
        if (channel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
        }
        viewModel.setUserAndChannel(user2, channel2);
        ChatUserAvatarView chatUserAvatarView = ((UserActionsBottomSheetBinding) getBinding()).avatarView;
        User user3 = this.user;
        if (user3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("user");
        }
        chatUserAvatarView.loadUrl(ContentUtils.getImage(user3), C4059R.C4062drawable.chat_user_avatar_placeholder_rounded);
        TextView textView = ((UserActionsBottomSheetBinding) getBinding()).avatarLabelView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.avatarLabelView");
        User user4 = this.user;
        if (user4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("user");
        }
        textView.setText(ContentUtils.getName(user4));
        ((UserActionsBottomSheetBinding) getBinding()).viewProfileView.setOnClickListener(new UserActionsBottomSheet$onBindingComplete$1(this));
        getViewModel().messageUserOnline().observe(getViewLifecycleOwner(), new UserActionsBottomSheet$onBindingComplete$2(this));
        getViewModel().messageUserActionState().observe(getViewLifecycleOwner(), new UserActionsBottomSheet$onBindingComplete$3(this));
    }

    public void onPause() {
        super.onPause();
        dismiss();
    }

    /* access modifiers changed from: private */
    public final void applyState(UserActionState userActionState) {
        if (userActionState.getCanSendMessage()) {
            LinearLayout linearLayout = ((UserActionsBottomSheetBinding) getBinding()).sendMessageView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.sendMessageView");
            linearLayout.setVisibility(0);
            ((UserActionsBottomSheetBinding) getBinding()).sendMessageView.setOnClickListener(getSendMessageClickListener());
        } else {
            LinearLayout linearLayout2 = ((UserActionsBottomSheetBinding) getBinding()).sendMessageView;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.sendMessageView");
            linearLayout2.setVisibility(8);
            ((UserActionsBottomSheetBinding) getBinding()).sendMessageView.setOnClickListener((View.OnClickListener) null);
        }
        if (userActionState.getCanMute()) {
            if (userActionState.isMuted()) {
                ((UserActionsBottomSheetBinding) getBinding()).muteUserLabelView.setText(C4059R.string.chat_unmute_user);
                ((UserActionsBottomSheetBinding) getBinding()).muteUserView.setOnClickListener(getUnmuteUserClickListener());
            } else {
                ((UserActionsBottomSheetBinding) getBinding()).muteUserLabelView.setText(C4059R.string.chat_mute_user);
                ((UserActionsBottomSheetBinding) getBinding()).muteUserView.setOnClickListener(getMuteUserClickListener());
            }
            LinearLayout linearLayout3 = ((UserActionsBottomSheetBinding) getBinding()).muteUserView;
            Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.muteUserView");
            linearLayout3.setVisibility(0);
        } else {
            LinearLayout linearLayout4 = ((UserActionsBottomSheetBinding) getBinding()).muteUserView;
            Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.muteUserView");
            linearLayout4.setVisibility(8);
            ((UserActionsBottomSheetBinding) getBinding()).muteUserView.setOnClickListener((View.OnClickListener) null);
        }
        if (userActionState.getCanBan()) {
            if (userActionState.isBanned()) {
                ((UserActionsBottomSheetBinding) getBinding()).banUserLabelView.setText(C4059R.string.chat_unban_user);
                ((UserActionsBottomSheetBinding) getBinding()).banUserView.setOnClickListener(getUnbanUserClickListener());
            } else {
                ((UserActionsBottomSheetBinding) getBinding()).banUserLabelView.setText(C4059R.string.chat_ban_user);
                ((UserActionsBottomSheetBinding) getBinding()).banUserView.setOnClickListener(getBanUserClickListener());
            }
            LinearLayout linearLayout5 = ((UserActionsBottomSheetBinding) getBinding()).banUserView;
            Intrinsics.checkNotNullExpressionValue(linearLayout5, "binding.banUserView");
            linearLayout5.setVisibility(0);
        } else {
            LinearLayout linearLayout6 = ((UserActionsBottomSheetBinding) getBinding()).banUserView;
            Intrinsics.checkNotNullExpressionValue(linearLayout6, "binding.banUserView");
            linearLayout6.setVisibility(8);
            ((UserActionsBottomSheetBinding) getBinding()).banUserView.setOnClickListener((View.OnClickListener) null);
        }
        if (!userActionState.getCanReport() || userActionState.isReported()) {
            LinearLayout linearLayout7 = ((UserActionsBottomSheetBinding) getBinding()).reportUserView;
            Intrinsics.checkNotNullExpressionValue(linearLayout7, "binding.reportUserView");
            linearLayout7.setVisibility(8);
            ((UserActionsBottomSheetBinding) getBinding()).reportUserView.setOnClickListener((View.OnClickListener) null);
            return;
        }
        LinearLayout linearLayout8 = ((UserActionsBottomSheetBinding) getBinding()).reportUserView;
        Intrinsics.checkNotNullExpressionValue(linearLayout8, "binding.reportUserView");
        linearLayout8.setVisibility(0);
        ((UserActionsBottomSheetBinding) getBinding()).reportUserView.setOnClickListener(getReportUserClickListener());
    }

    /* access modifiers changed from: private */
    public final void showUserProfile() {
        ChatRouting chatRouting = ChatRouting.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        User user2 = this.user;
        if (user2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("user");
        }
        startActivity(chatRouting.getUserProfileIntent(requireContext, user2.getId()));
    }

    public final void show(FragmentManager fragmentManager, User user2, Channel channel2) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(channel2, "channel");
        if (fragmentManager.findFragmentByTag(TAG) == null) {
            this.user = user2;
            this.channel = channel2;
            show(fragmentManager, TAG);
        }
    }
}
