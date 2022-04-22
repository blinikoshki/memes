package com.memes.chat.p036ui.channel.info;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.memes.chat.C4059R;
import com.memes.chat.base.BaseChatActivity;
import com.memes.chat.databinding.ChannelInfoActivityBinding;
import com.memes.chat.p036ui.channel.events.ChannelEventsViewModel;
import com.memes.chat.p036ui.channel.members.ChannelMembersAdapter;
import com.memes.chat.p036ui.channel.members.ChannelMembersShowAllAdapter;
import com.memes.chat.p036ui.channel.members.options.UserActionsBottomSheet;
import com.memes.chat.p036ui.channel.options.ChannelMuteStatus;
import com.memes.chat.p036ui.channel.settings.ChannelSettingsViewModel;
import com.memes.chat.p036ui.custom.StyledAlertDialog;
import com.memes.chat.routing.ChatRouting;
import com.memes.chat.util.extensions.ChannelExtKt;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.commons.imageselection.ImageContent;
import com.memes.commons.imageselection.ImageSelector;
import com.memes.commons.imageselection.choices.ChoicesBasedImageSelectorWithRemovePhotoOption;
import com.memes.commons.media.MediaFile;
import com.memes.commons.provider.SimpleFileProvider;
import java.io.File;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.ContentUtils;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 T2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001TB\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020.2\u0006\u00102\u001a\u000203H\u0002J\"\u00104\u001a\u00020.2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u00010,H\u0014J\b\u00109\u001a\u00020.H\u0016J\b\u0010:\u001a\u00020.H\u0002J\u0010\u0010;\u001a\u00020.2\u0006\u0010<\u001a\u00020=H\u0016J\u0018\u0010>\u001a\u00020.2\u0006\u0010?\u001a\u0002062\u0006\u0010@\u001a\u000206H\u0016J\u0012\u0010A\u001a\u00020.2\b\u0010B\u001a\u0004\u0018\u00010CH\u0014J\b\u0010D\u001a\u00020.H\u0002J\u0018\u0010E\u001a\u00020.2\u0006\u0010F\u001a\u0002062\u0006\u0010G\u001a\u00020HH\u0016J\b\u0010I\u001a\u00020.H\u0002J\u0010\u0010J\u001a\u00020.2\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010K\u001a\u00020.H\u0016J\b\u0010L\u001a\u00020.H\u0014J\b\u0010M\u001a\u00020.H\u0016J\b\u0010N\u001a\u00020.H\u0002J\u0010\u0010O\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002J \u0010P\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020RH\u0002R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\r\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b*\u0010\r\u001a\u0004\b(\u0010)R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000¨\u0006U"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/info/ChannelInfoActivity;", "Lcom/memes/chat/base/BaseChatActivity;", "Lcom/memes/chat/ui/channel/members/ChannelMembersAdapter$Callback;", "Lcom/memes/chat/ui/channel/members/ChannelMembersShowAllAdapter$Callback;", "Lcom/memes/commons/imageselection/ImageSelector$Callback;", "Lcom/memes/commons/imageselection/choices/ChoicesBasedImageSelectorWithRemovePhotoOption$RemovePhotoOptionSelectedListener;", "Lcom/memes/commons/contentlayout/ContentLayout$Callback;", "()V", "binding", "Lcom/memes/chat/databinding/ChannelInfoActivityBinding;", "getBinding", "()Lcom/memes/chat/databinding/ChannelInfoActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "channelEventsViewModel", "Lcom/memes/chat/ui/channel/events/ChannelEventsViewModel;", "getChannelEventsViewModel", "()Lcom/memes/chat/ui/channel/events/ChannelEventsViewModel;", "channelEventsViewModel$delegate", "channelId", "", "channelImageSelector", "Lcom/memes/commons/imageselection/choices/ChoicesBasedImageSelectorWithRemovePhotoOption;", "channelInfoViewModel", "Lcom/memes/chat/ui/channel/info/ChannelInfoViewModel;", "getChannelInfoViewModel", "()Lcom/memes/chat/ui/channel/info/ChannelInfoViewModel;", "channelInfoViewModel$delegate", "channelMembersAdapter", "Lcom/memes/chat/ui/channel/members/ChannelMembersAdapter;", "getChannelMembersAdapter", "()Lcom/memes/chat/ui/channel/members/ChannelMembersAdapter;", "channelMembersAdapter$delegate", "channelMembersShowAllAdapter", "Lcom/memes/chat/ui/channel/members/ChannelMembersShowAllAdapter;", "getChannelMembersShowAllAdapter", "()Lcom/memes/chat/ui/channel/members/ChannelMembersShowAllAdapter;", "channelMembersShowAllAdapter$delegate", "channelSettingsViewModel", "Lcom/memes/chat/ui/channel/settings/ChannelSettingsViewModel;", "getChannelSettingsViewModel", "()Lcom/memes/chat/ui/channel/settings/ChannelSettingsViewModel;", "channelSettingsViewModel$delegate", "resultIntent", "Landroid/content/Intent;", "applyChannelDetails", "", "channel", "Lio/getstream/chat/android/client/models/Channel;", "handleChannelMuteStatus", "status", "Lcom/memes/chat/ui/channel/options/ChannelMuteStatus;", "onActivityResult", "requestCode", "", "resultCode", "data", "onBackPressed", "onChangeChannelAvatarViewTapped", "onChannelMemberViewTapped", "channelMember", "Lio/getstream/chat/android/client/models/Member;", "onContentLayoutErrorResolutionButtonTapped", "who", "why", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteChannelViewTapped", "onImageFileSelected", "requestIdentifier", "imageContent", "Lcom/memes/commons/imageselection/ImageContent;", "onLeaveChannelViewTapped", "onRemoveChannelMemberViewTapped", "onRemovePhotoOptionSelected", "onResume", "onShowAllMembersTapped", "setupChannel", "showChannelImage", "showChannelMembers", "channelOwner", "Lio/getstream/chat/android/client/models/User;", "currentUser", "Companion", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.info.ChannelInfoActivity */
/* compiled from: ChannelInfoActivity.kt */
public final class ChannelInfoActivity extends BaseChatActivity implements ChannelMembersAdapter.Callback, ChannelMembersShowAllAdapter.Callback, ImageSelector.Callback, ChoicesBasedImageSelectorWithRemovePhotoOption.RemovePhotoOptionSelectedListener, ContentLayout.Callback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int RC_CHOOSE_PHOTO = 5644;
    private static final int RC_UPDATE_CHANNEL = 46545;
    private final Lazy binding$delegate = LazyKt.lazy(new ChannelInfoActivity$binding$2(this));
    private final Lazy channelEventsViewModel$delegate = LazyKt.lazy(new ChannelInfoActivity$channelEventsViewModel$2(this));
    /* access modifiers changed from: private */
    public String channelId;
    private final ChoicesBasedImageSelectorWithRemovePhotoOption channelImageSelector = new ChoicesBasedImageSelectorWithRemovePhotoOption(this, SimpleFileProvider.NAME);
    private final Lazy channelInfoViewModel$delegate = LazyKt.lazy(new ChannelInfoActivity$channelInfoViewModel$2(this));
    private final Lazy channelMembersAdapter$delegate = LazyKt.lazy(new ChannelInfoActivity$channelMembersAdapter$2(this));
    private final Lazy channelMembersShowAllAdapter$delegate = LazyKt.lazy(new ChannelInfoActivity$channelMembersShowAllAdapter$2(this));
    private final Lazy channelSettingsViewModel$delegate = LazyKt.lazy(new ChannelInfoActivity$channelSettingsViewModel$2(this));
    /* access modifiers changed from: private */
    public final Intent resultIntent = new Intent();

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.channel.info.ChannelInfoActivity$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ChannelMuteStatus.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ChannelMuteStatus.MUTED.ordinal()] = 1;
            iArr[ChannelMuteStatus.UNMUTED.ordinal()] = 2;
            iArr[ChannelMuteStatus.UNKNOWN.ordinal()] = 3;
        }
    }

    /* access modifiers changed from: private */
    public final ChannelInfoActivityBinding getBinding() {
        return (ChannelInfoActivityBinding) this.binding$delegate.getValue();
    }

    private final ChannelEventsViewModel getChannelEventsViewModel() {
        return (ChannelEventsViewModel) this.channelEventsViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ChannelInfoViewModel getChannelInfoViewModel() {
        return (ChannelInfoViewModel) this.channelInfoViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ChannelMembersAdapter getChannelMembersAdapter() {
        return (ChannelMembersAdapter) this.channelMembersAdapter$delegate.getValue();
    }

    private final ChannelMembersShowAllAdapter getChannelMembersShowAllAdapter() {
        return (ChannelMembersShowAllAdapter) this.channelMembersShowAllAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ChannelSettingsViewModel getChannelSettingsViewModel() {
        return (ChannelSettingsViewModel) this.channelSettingsViewModel$delegate.getValue();
    }

    public static final /* synthetic */ String access$getChannelId$p(ChannelInfoActivity channelInfoActivity) {
        String str = channelInfoActivity.channelId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelId");
        }
        return str;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/info/ChannelInfoActivity$Companion;", "", "()V", "RC_CHOOSE_PHOTO", "", "RC_UPDATE_CHANNEL", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.channel.info.ChannelInfoActivity$Companion */
    /* compiled from: ChannelInfoActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ChannelInfoActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        registerViewModels(getChannelInfoViewModel(), getChannelSettingsViewModel(), getChannelEventsViewModel());
        getBinding().channelInfoContentLayout.setCallback(this);
        getBinding().backImageView.setOnClickListener(new ChannelInfoActivity$onCreate$1(this));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = getBinding().channelMembersRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.channelMembersRecyclerView");
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView2 = getBinding().channelMembersRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.channelMembersRecyclerView");
        recyclerView2.setAdapter(new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{getChannelMembersAdapter(), getChannelMembersShowAllAdapter()}));
        getBinding().saveChannelInfoTextView.setOnClickListener(new ChannelInfoActivity$onCreate$2(this));
        EditText editText = getBinding().multiUserChannelNameEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.multiUserChannelNameEditText");
        editText.addTextChangedListener(new ChannelInfoActivity$onCreate$$inlined$addTextChangedListener$1(this));
        getBinding().channelPicImageView.setOnClickListener(new ChannelInfoActivity$onCreate$4(this));
        getBinding().changeChannelPicImageView.setOnClickListener(new ChannelInfoActivity$onCreate$5(this));
        getBinding().addChannelMembersTextView.setOnClickListener(new ChannelInfoActivity$onCreate$6(this));
        getBinding().toggleMuteChannelSwitch.setOnCheckedChangeListener(new ChannelInfoActivity$onCreate$7(this));
        getBinding().leaveChannelTextView.setOnClickListener(new ChannelInfoActivity$onCreate$8(this));
        getBinding().deleteChannelTextView.setOnClickListener(new ChannelInfoActivity$onCreate$9(this));
        setupChannel();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        getChannelInfoViewModel().ensureChannelAccess();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == RC_UPDATE_CHANNEL && i2 == -1 && intent != null) {
            if (intent.getBooleanExtra(ChatRouting.EXTRA_CHANNEL_LEFT, false)) {
                this.resultIntent.putExtras(intent);
                setResult(-1, this.resultIntent);
                finish();
                return;
            } else if (intent.getBooleanExtra(ChatRouting.EXTRA_CHANNEL_DELETED, false)) {
                this.resultIntent.putExtras(intent);
                setResult(-1, this.resultIntent);
                finish();
                return;
            } else if (intent.getBooleanExtra(ChatRouting.EXTRA_CHANNEL_MEMBERS_UPDATED, false)) {
                getChannelInfoViewModel().refreshChannel();
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (getChannelSettingsViewModel().hasUnsavedChanges()) {
            StyledAlertDialog.INSTANCE.getDangerDialogBuilder(this).setTitle(C4059R.string.chat_exit_when_unsaved_changes_title).setMessage(C4059R.string.chat_exit_when_unsaved_changes_msg).setPositiveButton(C4059R.string.chat_exit_when_unsaved_changes_positive_action, (DialogInterface.OnClickListener) new ChannelInfoActivity$onBackPressed$1(this)).setNegativeButton(C4059R.string.chat_exit_when_unsaved_changes_negative_action, (DialogInterface.OnClickListener) null).show();
        } else {
            super.onBackPressed();
        }
    }

    private final void setupChannel() {
        String stringExtra = getIntent().getStringExtra(ChatRouting.EXTRA_CHANNEL_ID);
        if (stringExtra != null) {
            this.channelId = stringExtra;
            LifecycleOwner lifecycleOwner = this;
            getChannelInfoViewModel().channel().observe(lifecycleOwner, new ChannelInfoActivity$setupChannel$2(this));
            getChannelInfoViewModel().channelContentVisibilityChanged().observe(lifecycleOwner, new ChannelInfoActivity$setupChannel$3(this));
            getChannelInfoViewModel().channelMuteStatus().observe(lifecycleOwner, new ChannelInfoActivity$setupChannel$4(this));
            getChannelInfoViewModel().channelMemberRemoved().observe(lifecycleOwner, new ChannelInfoActivity$setupChannel$5(this));
            getChannelInfoViewModel().channelLeft().observe(lifecycleOwner, new ChannelInfoActivity$setupChannel$6(this));
            getChannelInfoViewModel().channelDeleted().observe(lifecycleOwner, new ChannelInfoActivity$setupChannel$7(this));
            ChannelInfoViewModel channelInfoViewModel = getChannelInfoViewModel();
            String str = this.channelId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelId");
            }
            channelInfoViewModel.fetchChannel(str);
            getChannelSettingsViewModel().unsavedChangesAvailable().observe(lifecycleOwner, new ChannelInfoActivity$setupChannel$8(this));
            getChannelSettingsViewModel().channelUpdated().observe(lifecycleOwner, new ChannelInfoActivity$setupChannel$9(this));
            ChannelEventsViewModel channelEventsViewModel = getChannelEventsViewModel();
            String str2 = this.channelId;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelId");
            }
            channelEventsViewModel.setChannelId(str2);
            getChannelEventsViewModel().addedChannelMemberEvent().observe(lifecycleOwner, new ChannelInfoActivity$setupChannel$10(this));
            getChannelEventsViewModel().removedChannelMemberEvent().observe(lifecycleOwner, new ChannelInfoActivity$setupChannel$11(this));
            getChannelEventsViewModel().removedCurrentUserFromChannelEvent().observe(lifecycleOwner, new ChannelInfoActivity$setupChannel$12(this));
            getChannelEventsViewModel().channelDeletedEvent().observe(lifecycleOwner, new ChannelInfoActivity$setupChannel$13(this));
            return;
        }
        throw new IllegalStateException("Specifying a channel id is required when showing channel-info".toString());
    }

    /* access modifiers changed from: private */
    public final void onChangeChannelAvatarViewTapped() {
        this.channelImageSelector.setHasImageInput(getChannelSettingsViewModel().hasChannelImageInput()).setRemovePhotoOptionSelectedListener(this).requestIdentifier(5644).enableCrop(ImageSelector.Companion.getCROP_SQUARE()).callback(this).start();
    }

    /* access modifiers changed from: private */
    public final void onLeaveChannelViewTapped() {
        StyledAlertDialog.INSTANCE.getDangerDialogBuilder(this).setTitle(C4059R.string.chat_leave_channel_title).setMessage(C4059R.string.chat_leave_channel_msg).setPositiveButton(C4059R.string.chat_leave_channel_positive_action, (DialogInterface.OnClickListener) new ChannelInfoActivity$onLeaveChannelViewTapped$1(this)).setNegativeButton(C4059R.string.chat_leave_channel_negative_action, (DialogInterface.OnClickListener) null).show();
    }

    /* access modifiers changed from: private */
    public final void onDeleteChannelViewTapped() {
        StyledAlertDialog.INSTANCE.getDangerDialogBuilder(this).setTitle(C4059R.string.chat_delete_channel_title).setMessage(C4059R.string.chat_delete_channel_msg).setPositiveButton(C4059R.string.chat_delete_channel_positive_action, (DialogInterface.OnClickListener) new ChannelInfoActivity$onDeleteChannelViewTapped$1(this)).setNegativeButton(C4059R.string.chat_delete_channel_negative_action, (DialogInterface.OnClickListener) null).show();
    }

    /* access modifiers changed from: private */
    public final void applyChannelDetails(Channel channel) {
        boolean z;
        User requireCurrentUser = getChannelInfoViewModel().requireCurrentUser();
        User owner = ChannelExtKt.owner(channel);
        boolean areEqual = Intrinsics.areEqual((Object) requireCurrentUser.getId(), (Object) owner.getId());
        boolean isDirectMessaging = ChannelExtKt.isDirectMessaging(channel);
        showChannelImage(channel);
        if (!areEqual || isDirectMessaging) {
            ImageView imageView = getBinding().changeChannelPicImageView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.changeChannelPicImageView");
            imageView.setVisibility(8);
        } else {
            ImageView imageView2 = getBinding().changeChannelPicImageView;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.changeChannelPicImageView");
            imageView2.setVisibility(0);
        }
        boolean z2 = true;
        if (isDirectMessaging) {
            LinearLayout linearLayout = getBinding().multiUserChannelNameContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.multiUserChannelNameContainer");
            linearLayout.setVisibility(8);
        } else {
            getBinding().multiUserChannelNameEditText.setText(ChannelExtKt.channelName(channel));
            LinearLayout linearLayout2 = getBinding().multiUserChannelNameContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.multiUserChannelNameContainer");
            linearLayout2.setVisibility(0);
            if (areEqual) {
                EditText editText = getBinding().multiUserChannelNameEditText;
                Intrinsics.checkNotNullExpressionValue(editText, "binding.multiUserChannelNameEditText");
                editText.setInputType(524289);
                EditText editText2 = getBinding().multiUserChannelNameEditText;
                Intrinsics.checkNotNullExpressionValue(editText2, "binding.multiUserChannelNameEditText");
                editText2.setEnabled(true);
            } else {
                EditText editText3 = getBinding().multiUserChannelNameEditText;
                Intrinsics.checkNotNullExpressionValue(editText3, "binding.multiUserChannelNameEditText");
                editText3.setInputType(0);
                EditText editText4 = getBinding().multiUserChannelNameEditText;
                Intrinsics.checkNotNullExpressionValue(editText4, "binding.multiUserChannelNameEditText");
                editText4.setEnabled(false);
            }
        }
        if (!areEqual || isDirectMessaging) {
            TextView textView = getBinding().addChannelMembersTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.addChannelMembersTextView");
            textView.setVisibility(8);
        } else {
            TextView textView2 = getBinding().addChannelMembersTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.addChannelMembersTextView");
            textView2.setVisibility(0);
        }
        if (areEqual || isDirectMessaging) {
            TextView textView3 = getBinding().leaveChannelTextView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.leaveChannelTextView");
            textView3.setVisibility(8);
            z = false;
        } else {
            TextView textView4 = getBinding().leaveChannelTextView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.leaveChannelTextView");
            textView4.setVisibility(0);
            z = true;
        }
        if (areEqual) {
            TextView textView5 = getBinding().deleteChannelTextView;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.deleteChannelTextView");
            textView5.setVisibility(0);
        } else {
            TextView textView6 = getBinding().deleteChannelTextView;
            Intrinsics.checkNotNullExpressionValue(textView6, "binding.deleteChannelTextView");
            textView6.setVisibility(8);
            z2 = false;
        }
        if (ChannelExtKt.isGlobal(channel)) {
            LinearLayout linearLayout3 = getBinding().channelOptionsContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.channelOptionsContainer");
            linearLayout3.setVisibility(8);
        } else if (z || z2) {
            LinearLayout linearLayout4 = getBinding().channelOptionsContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.channelOptionsContainer");
            linearLayout4.setVisibility(0);
        } else {
            LinearLayout linearLayout5 = getBinding().channelOptionsContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout5, "binding.channelOptionsContainer");
            linearLayout5.setVisibility(8);
        }
        showChannelMembers(channel, owner, requireCurrentUser);
    }

    private final void showChannelImage(Channel channel) {
        int i;
        String channelImage = ChannelExtKt.channelImage(channel);
        if (ChannelExtKt.isDirectMessaging(channel)) {
            i = C4059R.C4062drawable.chat_user_avatar_placeholder;
        } else {
            i = C4059R.C4062drawable.chat_group_avatar_placeholder_thumb;
        }
        CharSequence charSequence = channelImage;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            getBinding().channelPicImageView.setImageResource(i);
        } else {
            ((RequestBuilder) ((RequestBuilder) Glide.with((FragmentActivity) this).load(channelImage).placeholder(i)).error(i)).into(getBinding().channelPicImageView);
        }
    }

    private final void showChannelMembers(Channel channel, User user, User user2) {
        CharSequence charSequence;
        int memberCount = channel.getMemberCount();
        List<Member> members = channel.getMembers();
        if (!ChannelExtKt.isDirectMessaging(channel)) {
            getChannelMembersAdapter().setOwnerAndCurrentUser(user, user2);
        }
        TextView textView = getBinding().channelMembersLabel;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.channelMembersLabel");
        boolean z = true;
        if (ChannelExtKt.isDirectMessaging(channel) || memberCount <= 0) {
            charSequence = getString(C4059R.string.chat_members);
        } else {
            charSequence = getString(C4059R.string.chat_members_label_count_format, new Object[]{Integer.valueOf(memberCount)});
        }
        textView.setText(charSequence);
        if (memberCount > 0) {
            getChannelMembersAdapter().setItems(members);
            if (members.size() >= memberCount && !getChannelMembersAdapter().isItemCountLimitInEffect()) {
                z = false;
            }
            getChannelMembersShowAllAdapter().setShowlAllItemVisible(z);
            ConstraintLayout constraintLayout = getBinding().channelMembersContainer;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.channelMembersContainer");
            constraintLayout.setVisibility(0);
            return;
        }
        getChannelMembersAdapter().clear();
        getChannelMembersShowAllAdapter().setShowlAllItemVisible(false);
        ConstraintLayout constraintLayout2 = getBinding().channelMembersContainer;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "binding.channelMembersContainer");
        constraintLayout2.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void handleChannelMuteStatus(ChannelMuteStatus channelMuteStatus) {
        int i = WhenMappings.$EnumSwitchMapping$0[channelMuteStatus.ordinal()];
        if (i == 1) {
            SwitchMaterial switchMaterial = getBinding().toggleMuteChannelSwitch;
            Intrinsics.checkNotNullExpressionValue(switchMaterial, "binding.toggleMuteChannelSwitch");
            switchMaterial.setEnabled(true);
            SwitchMaterial switchMaterial2 = getBinding().toggleMuteChannelSwitch;
            Intrinsics.checkNotNullExpressionValue(switchMaterial2, "binding.toggleMuteChannelSwitch");
            switchMaterial2.setChecked(true);
        } else if (i == 2) {
            SwitchMaterial switchMaterial3 = getBinding().toggleMuteChannelSwitch;
            Intrinsics.checkNotNullExpressionValue(switchMaterial3, "binding.toggleMuteChannelSwitch");
            switchMaterial3.setEnabled(true);
            SwitchMaterial switchMaterial4 = getBinding().toggleMuteChannelSwitch;
            Intrinsics.checkNotNullExpressionValue(switchMaterial4, "binding.toggleMuteChannelSwitch");
            switchMaterial4.setChecked(false);
        } else if (i == 3) {
            SwitchMaterial switchMaterial5 = getBinding().toggleMuteChannelSwitch;
            Intrinsics.checkNotNullExpressionValue(switchMaterial5, "binding.toggleMuteChannelSwitch");
            switchMaterial5.setEnabled(false);
            SwitchMaterial switchMaterial6 = getBinding().toggleMuteChannelSwitch;
            Intrinsics.checkNotNullExpressionValue(switchMaterial6, "binding.toggleMuteChannelSwitch");
            switchMaterial6.setChecked(false);
        }
    }

    public void onChannelMemberViewTapped(Member member) {
        Intrinsics.checkNotNullParameter(member, "channelMember");
        Channel value = getChannelInfoViewModel().channel().getValue();
        if (value != null) {
            UserActionsBottomSheet userActionsBottomSheet = new UserActionsBottomSheet();
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            userActionsBottomSheet.show(supportFragmentManager, member.getUser(), value);
        }
    }

    public void onRemoveChannelMemberViewTapped(Member member) {
        Intrinsics.checkNotNullParameter(member, "channelMember");
        String string = getString(C4059R.string.chat_remove_channel_member_msg, new Object[]{ContentUtils.getName(member.getUser())});
        Intrinsics.checkNotNullExpressionValue(string, "getString(\n\t\t\tR.string.c…annelMember.user.name\n\t\t)");
        StyledAlertDialog.INSTANCE.getDangerDialogBuilder(this).setTitle(C4059R.string.chat_remove_channel_member_title).setMessage((CharSequence) string).setPositiveButton(C4059R.string.chat_remove_channel_member_positive_action, (DialogInterface.OnClickListener) new ChannelInfoActivity$onRemoveChannelMemberViewTapped$1(this, member)).setNegativeButton(C4059R.string.chat_remove_channel_member_negative_action, (DialogInterface.OnClickListener) null).show();
    }

    public void onShowAllMembersTapped() {
        Channel value = getChannelInfoViewModel().channel().getValue();
        if (value != null) {
            startActivityForResult(ChatRouting.INSTANCE.getChannelMembersIntent(this, value.getCid()), RC_UPDATE_CHANNEL);
        }
    }

    public void onImageFileSelected(int i, ImageContent imageContent) {
        Intrinsics.checkNotNullParameter(imageContent, "imageContent");
        if (i == 5644) {
            MediaFile file = imageContent.getFile();
            Glide.with((FragmentActivity) this).load((File) file).into(getBinding().channelPicImageView);
            getChannelSettingsViewModel().channelImageChanged(file.getAbsolutePath());
        }
    }

    public void onRemovePhotoOptionSelected() {
        getChannelSettingsViewModel().channelImageChanged("");
        getBinding().channelPicImageView.setImageResource(C4059R.C4062drawable.chat_group_avatar_placeholder);
    }

    public void onContentLayoutErrorResolutionButtonTapped(int i, int i2) {
        ContentLayout contentLayout = getBinding().channelInfoContentLayout;
        Intrinsics.checkNotNullExpressionValue(contentLayout, "binding.channelInfoContentLayout");
        if (contentLayout.getId() == i && i2 == 1211) {
            getChannelInfoViewModel().refreshChannel();
            return;
        }
        throw new RuntimeException("Unable to resolve content-layout error resolution: " + i + ' ' + i2);
    }
}
