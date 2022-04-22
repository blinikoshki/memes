package com.memes.chat.p036ui.channel.messages;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelLazy;
import com.getstream.sdk.chat.view.MessageListView;
import com.getstream.sdk.chat.view.MessageListViewModelBinding;
import com.getstream.sdk.chat.view.messageinput.MessageInputView;
import com.getstream.sdk.chat.viewmodel.MessageInputViewModel;
import com.getstream.sdk.chat.viewmodel.MessageInputViewModelBinding;
import com.getstream.sdk.chat.viewmodel.factory.ChannelViewModelFactory;
import com.getstream.sdk.chat.viewmodel.messages.MessageListViewModel;
import com.memes.chat.C4059R;
import com.memes.chat.base.BaseChatActivity;
import com.memes.chat.databinding.ChannelMessagesActivityBinding;
import com.memes.chat.p036ui.channel.events.ChannelEventsViewModel;
import com.memes.chat.p036ui.custom.ChatUserAvatarView;
import com.memes.chat.routing.ChatRouting;
import com.memes.chat.util.extensions.ChannelExtKt;
import com.memes.chat.util.usecases.channelaccess.ChannelAccessResult;
import com.memes.commons.contentlayout.ContentLayout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.ContentUtils;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001FB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002J\"\u00101\u001a\u00020.2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\b\u00105\u001a\u0004\u0018\u000106H\u0014J\b\u00107\u001a\u00020.H\u0002J\u0018\u00108\u001a\u00020.2\u0006\u00109\u001a\u0002032\u0006\u0010:\u001a\u000203H\u0016J\u0012\u0010;\u001a\u00020.2\b\u0010<\u001a\u0004\u0018\u00010=H\u0014J\b\u0010>\u001a\u00020.H\u0014J\b\u0010?\u001a\u00020.H\u0002J\b\u0010@\u001a\u00020.H\u0002J\u0010\u0010A\u001a\u00020.2\u0006\u0010B\u001a\u00020\u0012H\u0002J\u0010\u0010C\u001a\u00020.2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010C\u001a\u00020.2\u0006\u0010D\u001a\u00020EH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\t\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010\u00128BX\u0002¢\u0006\f\n\u0004\b\"\u0010\t\u001a\u0004\b!\u0010\u0014R\u001b\u0010#\u001a\u00020$8BX\u0002¢\u0006\f\n\u0004\b'\u0010\t\u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\u00020)8BX\u0002¢\u0006\f\n\u0004\b,\u0010\t\u001a\u0004\b*\u0010+¨\u0006G"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/messages/ChannelMessagesActivity;", "Lcom/memes/chat/base/BaseChatActivity;", "Lcom/memes/commons/contentlayout/ContentLayout$Callback;", "()V", "binding", "Lcom/memes/chat/databinding/ChannelMessagesActivityBinding;", "getBinding", "()Lcom/memes/chat/databinding/ChannelMessagesActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "channel", "Lio/getstream/chat/android/client/models/Channel;", "channelEventsViewModel", "Lcom/memes/chat/ui/channel/events/ChannelEventsViewModel;", "getChannelEventsViewModel", "()Lcom/memes/chat/ui/channel/events/ChannelEventsViewModel;", "channelEventsViewModel$delegate", "channelId", "", "getChannelId", "()Ljava/lang/String;", "channelId$delegate", "channelMessagesViewModel", "Lcom/memes/chat/ui/channel/messages/ChannelMessagesViewModel;", "getChannelMessagesViewModel", "()Lcom/memes/chat/ui/channel/messages/ChannelMessagesViewModel;", "channelMessagesViewModel$delegate", "channelViewModelFactory", "Lcom/getstream/sdk/chat/viewmodel/factory/ChannelViewModelFactory;", "getChannelViewModelFactory", "()Lcom/getstream/sdk/chat/viewmodel/factory/ChannelViewModelFactory;", "channelViewModelFactory$delegate", "focusedMessageId", "getFocusedMessageId", "focusedMessageId$delegate", "messageInputViewModel", "Lcom/getstream/sdk/chat/viewmodel/MessageInputViewModel;", "getMessageInputViewModel", "()Lcom/getstream/sdk/chat/viewmodel/MessageInputViewModel;", "messageInputViewModel$delegate", "messageListViewModel", "Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel;", "getMessageListViewModel", "()Lcom/getstream/sdk/chat/viewmodel/messages/MessageListViewModel;", "messageListViewModel$delegate", "handleChannelAccessResult", "", "result", "Lcom/memes/chat/util/usecases/channelaccess/ChannelAccessResult;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onChannelTitleTapped", "onContentLayoutErrorResolutionButtonTapped", "who", "why", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "setupChannel", "showChannelInfo", "showUserProfile", "targetUserId", "updateTitleBar", "user", "Lio/getstream/chat/android/client/models/User;", "Companion", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.messages.ChannelMessagesActivity */
/* compiled from: ChannelMessagesActivity.kt */
public final class ChannelMessagesActivity extends BaseChatActivity implements ContentLayout.Callback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int RC_CHANNEL_INFO_RESULT = 4564;
    private final Lazy binding$delegate = LazyKt.lazy(new ChannelMessagesActivity$binding$2(this));
    /* access modifiers changed from: private */
    public Channel channel;
    private final Lazy channelEventsViewModel$delegate = LazyKt.lazy(new ChannelMessagesActivity$channelEventsViewModel$2(this));
    private final Lazy channelId$delegate = LazyKt.lazy(new ChannelMessagesActivity$channelId$2(this));
    private final Lazy channelMessagesViewModel$delegate = LazyKt.lazy(new ChannelMessagesActivity$channelMessagesViewModel$2(this));
    private final Lazy channelViewModelFactory$delegate = LazyKt.lazy(new ChannelMessagesActivity$channelViewModelFactory$2(this));
    private final Lazy focusedMessageId$delegate = LazyKt.lazy(new ChannelMessagesActivity$focusedMessageId$2(this));
    private final Lazy messageInputViewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(MessageInputViewModel.class), new ChannelMessagesActivity$$special$$inlined$viewModels$4(this), new ChannelMessagesActivity$messageInputViewModel$2(this));
    private final Lazy messageListViewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(MessageListViewModel.class), new ChannelMessagesActivity$$special$$inlined$viewModels$2(this), new ChannelMessagesActivity$messageListViewModel$2(this));

    private final ChannelMessagesActivityBinding getBinding() {
        return (ChannelMessagesActivityBinding) this.binding$delegate.getValue();
    }

    private final ChannelEventsViewModel getChannelEventsViewModel() {
        return (ChannelEventsViewModel) this.channelEventsViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final String getChannelId() {
        return (String) this.channelId$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ChannelMessagesViewModel getChannelMessagesViewModel() {
        return (ChannelMessagesViewModel) this.channelMessagesViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ChannelViewModelFactory getChannelViewModelFactory() {
        return (ChannelViewModelFactory) this.channelViewModelFactory$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final String getFocusedMessageId() {
        return (String) this.focusedMessageId$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final MessageInputViewModel getMessageInputViewModel() {
        return (MessageInputViewModel) this.messageInputViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final MessageListViewModel getMessageListViewModel() {
        return (MessageListViewModel) this.messageListViewModel$delegate.getValue();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/messages/ChannelMessagesActivity$Companion;", "", "()V", "RC_CHANNEL_INFO_RESULT", "", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.channel.messages.ChannelMessagesActivity$Companion */
    /* compiled from: ChannelMessagesActivity.kt */
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
        ChannelMessagesActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        TextView textView = getBinding().titleTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleTextView");
        textView.setSelected(true);
        getBinding().backImageView.setOnClickListener(new ChannelMessagesActivity$onCreate$1(this));
        getBinding().titleContainer.setOnClickListener(new ChannelMessagesActivity$onCreate$2(this));
        getBinding().channelInfoView.setOnClickListener(new ChannelMessagesActivity$onCreate$3(this));
        getBinding().channelAccessContentLayout.setCallback(this);
        registerViewModels(getChannelMessagesViewModel(), getChannelEventsViewModel());
        setupChannel();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        getChannelMessagesViewModel().getChannelAccessValidator().validateAccess(getChannelId());
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == RC_CHANNEL_INFO_RESULT && i2 == -1 && intent != null) {
            CharSequence stringExtra = intent.getStringExtra(ChatRouting.EXTRA_CHANNEL_NAME_CHANGED);
            boolean z = true;
            if (!(stringExtra == null || StringsKt.isBlank(stringExtra))) {
                TextView textView = getBinding().titleTextView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.titleTextView");
                textView.setText(stringExtra);
            }
            if (intent.hasExtra(ChatRouting.EXTRA_CHANNEL_IMAGE_CHANGED)) {
                String stringExtra2 = intent.getStringExtra(ChatRouting.EXTRA_CHANNEL_IMAGE_CHANGED);
                CharSequence charSequence = stringExtra2;
                if (charSequence != null && !StringsKt.isBlank(charSequence)) {
                    z = false;
                }
                if (z) {
                    ChatUserAvatarView chatUserAvatarView = getBinding().titleAvatarView;
                    Intrinsics.checkNotNullExpressionValue(chatUserAvatarView, "binding.titleAvatarView");
                    chatUserAvatarView.setVisibility(8);
                } else {
                    getBinding().titleAvatarView.loadUrl(stringExtra2, C4059R.C4062drawable.chat_group_avatar_placeholder_thumb);
                    ChatUserAvatarView chatUserAvatarView2 = getBinding().titleAvatarView;
                    Intrinsics.checkNotNullExpressionValue(chatUserAvatarView2, "binding.titleAvatarView");
                    chatUserAvatarView2.setVisibility(0);
                }
            }
            if (intent.getBooleanExtra(ChatRouting.EXTRA_CHANNEL_LEFT, false)) {
                finish();
            }
            if (intent.getBooleanExtra(ChatRouting.EXTRA_CHANNEL_DELETED, false)) {
                finish();
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    private final void setupChannel() {
        LifecycleOwner lifecycleOwner = this;
        getChannelMessagesViewModel().getChannelAccessValidator().channelAccessResult().observe(lifecycleOwner, new ChannelMessagesActivity$setupChannel$1(this));
        getChannelMessagesViewModel().otherUser().observe(lifecycleOwner, new ChannelMessagesActivity$setupChannel$2(this));
        getMessageListViewModel().getChannel().observe(lifecycleOwner, new ChannelMessagesActivity$setupChannel$3(this));
        MessageListViewModel messageListViewModel = getMessageListViewModel();
        MessageListView messageListView = getBinding().messageListView;
        Intrinsics.checkNotNullExpressionValue(messageListView, "binding.messageListView");
        MessageListViewModelBinding.bind(messageListViewModel, messageListView, lifecycleOwner);
        MessageInputViewModel messageInputViewModel = getMessageInputViewModel();
        MessageInputView messageInputView = getBinding().messageInputView;
        Intrinsics.checkNotNullExpressionValue(messageInputView, "binding.messageInputView");
        MessageInputViewModelBinding.bind(messageInputViewModel, messageInputView, lifecycleOwner);
        getMessageListViewModel().getMode().observe(lifecycleOwner, new ChannelMessagesActivity$setupChannel$4(this));
        getBinding().messageListView.setOnMessageEditHandler(new ChannelMessagesActivity$setupChannel$5(this));
        getBinding().messageListView.setUserClickListener(new ChannelMessagesActivity$setupChannel$6(this));
        getMessageListViewModel().getState().observe(lifecycleOwner, new ChannelMessagesActivity$setupChannel$7(this));
        getChannelEventsViewModel().setChannelId(getChannelId());
        getChannelEventsViewModel().removedCurrentUserFromChannelEvent().observe(lifecycleOwner, new ChannelMessagesActivity$setupChannel$8(this));
        getChannelEventsViewModel().channelDeletedEvent().observe(lifecycleOwner, new ChannelMessagesActivity$setupChannel$9(this));
    }

    /* access modifiers changed from: private */
    public final void handleChannelAccessResult(ChannelAccessResult channelAccessResult) {
        ContentLayout contentLayout = getBinding().channelAccessContentLayout;
        Intrinsics.checkNotNullExpressionValue(contentLayout, "binding.channelAccessContentLayout");
        if (channelAccessResult instanceof ChannelAccessResult.Loading) {
            ContentLayout.showProgress$default(contentLayout, (String) null, 1, (Object) null);
        } else if (channelAccessResult instanceof ChannelAccessResult.Success) {
            contentLayout.showContent();
        } else if (channelAccessResult instanceof ChannelAccessResult.Failure) {
            ChannelAccessResult.Failure failure = (ChannelAccessResult.Failure) channelAccessResult;
            if (failure.getCanRetry()) {
                contentLayout.showError(failure.getError());
            } else {
                contentLayout.showContentNotAvailable(failure.getError());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateTitleBar(Channel channel2) {
        TextView textView = getBinding().titleTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleTextView");
        textView.setText(ChannelExtKt.channelName(channel2));
        String image = ContentUtils.getImage(channel2);
        if (StringsKt.isBlank(image)) {
            ChatUserAvatarView chatUserAvatarView = getBinding().titleAvatarView;
            Intrinsics.checkNotNullExpressionValue(chatUserAvatarView, "binding.titleAvatarView");
            chatUserAvatarView.setVisibility(8);
            return;
        }
        getBinding().titleAvatarView.loadUrl(image, C4059R.C4062drawable.chat_group_avatar_placeholder_thumb);
        ChatUserAvatarView chatUserAvatarView2 = getBinding().titleAvatarView;
        Intrinsics.checkNotNullExpressionValue(chatUserAvatarView2, "binding.titleAvatarView");
        chatUserAvatarView2.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void updateTitleBar(User user) {
        ChatUserAvatarView.PresenceIndicatorState presenceIndicatorState;
        TextView textView = getBinding().titleTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleTextView");
        textView.setText(ContentUtils.getName(user));
        getBinding().titleAvatarView.loadUrl(ContentUtils.getImage(user), C4059R.C4062drawable.chat_user_avatar_placeholder_rounded);
        ChatUserAvatarView chatUserAvatarView = getBinding().titleAvatarView;
        if (user.getOnline()) {
            presenceIndicatorState = ChatUserAvatarView.PresenceIndicatorState.ONLINE;
        } else {
            presenceIndicatorState = ChatUserAvatarView.PresenceIndicatorState.OFFLINE;
        }
        chatUserAvatarView.setPresenceIndicatorState(presenceIndicatorState);
        ChatUserAvatarView chatUserAvatarView2 = getBinding().titleAvatarView;
        Intrinsics.checkNotNullExpressionValue(chatUserAvatarView2, "binding.titleAvatarView");
        chatUserAvatarView2.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void onChannelTitleTapped() {
        Channel channel2 = this.channel;
        if (channel2 == null) {
            return;
        }
        if (ChannelExtKt.isDirectMessagingScope(channel2)) {
            showUserProfile(((User) CollectionsKt.first(ChannelExtKt.getUsers$default(channel2, false, 1, (Object) null))).getId());
        } else {
            showChannelInfo();
        }
    }

    private final void showUserProfile(String str) {
        startActivity(ChatRouting.INSTANCE.getUserProfileIntent(this, str));
    }

    /* access modifiers changed from: private */
    public final void showChannelInfo() {
        startActivityForResult(ChatRouting.INSTANCE.getChannelInfoIntent((Context) this, getChannelId()), RC_CHANNEL_INFO_RESULT);
    }

    public void onContentLayoutErrorResolutionButtonTapped(int i, int i2) {
        ContentLayout contentLayout = getBinding().channelAccessContentLayout;
        Intrinsics.checkNotNullExpressionValue(contentLayout, "binding.channelAccessContentLayout");
        if (contentLayout.getId() == i && i2 == 1211) {
            getChannelMessagesViewModel().getChannelAccessValidator().validateAccess(getChannelId());
            return;
        }
        throw new RuntimeException("Unable to resolve content-layout error resolution: " + i + ' ' + i2);
    }
}
