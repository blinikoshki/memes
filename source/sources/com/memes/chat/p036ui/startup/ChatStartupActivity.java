package com.memes.chat.p036ui.startup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.memes.chat.databinding.ChatStartupActivityBinding;
import com.memes.chat.p036ui.startup.ChatStartupState;
import com.memes.chat.push.ChatPushMessage;
import com.memes.chat.routing.ChatRouting;
import com.memes.commons.activity.BaseActivity;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J&\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0010H\u0002J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\r¨\u0006$"}, mo26107d2 = {"Lcom/memes/chat/ui/startup/ChatStartupActivity;", "Lcom/memes/commons/activity/BaseActivity;", "Lcom/memes/commons/contentlayout/ContentLayout$Callback;", "()V", "binding", "Lcom/memes/chat/databinding/ChatStartupActivityBinding;", "getBinding", "()Lcom/memes/chat/databinding/ChatStartupActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "chatStartupViewModel", "Lcom/memes/chat/ui/startup/ChatStartupViewModel;", "getChatStartupViewModel", "()Lcom/memes/chat/ui/startup/ChatStartupViewModel;", "chatStartupViewModel$delegate", "handleStartupComplete", "", "onBackPressed", "onContentLayoutErrorResolutionButtonTapped", "who", "", "why", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showChannel", "channelId", "", "messageId", "withChannelsStack", "", "showChannels", "showChatSignInState", "state", "Lcom/memes/chat/ui/startup/ChatStartupState;", "Companion", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.startup.ChatStartupActivity */
/* compiled from: ChatStartupActivity.kt */
public final class ChatStartupActivity extends BaseActivity implements ContentLayout.Callback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Lazy binding$delegate = LazyKt.lazy(new ChatStartupActivity$binding$2(this));
    private final Lazy chatStartupViewModel$delegate = LazyKt.lazy(new ChatStartupActivity$chatStartupViewModel$2(this));

    private final ChatStartupActivityBinding getBinding() {
        return (ChatStartupActivityBinding) this.binding$delegate.getValue();
    }

    private final ChatStartupViewModel getChatStartupViewModel() {
        return (ChatStartupViewModel) this.chatStartupViewModel$delegate.getValue();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/chat/ui/startup/ChatStartupActivity$Companion;", "", "()V", "getStartIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.startup.ChatStartupActivity$Companion */
    /* compiled from: ChatStartupActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent getStartIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, ChatStartupActivity.class);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ChatStartupActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        getBinding().chatStartupContentLayout.setCallback(this);
        getChatStartupViewModel().chatSignInState().observe(this, new ChatStartupActivity$onCreate$1(this));
        getChatStartupViewModel().beginStartup();
    }

    public void onBackPressed() {
        if (isStartedForResult()) {
            setResult(0);
        }
        super.onBackPressed();
    }

    private final void showChannels() {
        startActivity(ChatRouting.INSTANCE.getChannelsIntent(this));
        finish();
    }

    static /* synthetic */ void showChannel$default(ChatStartupActivity chatStartupActivity, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        chatStartupActivity.showChannel(str, str2, z);
    }

    private final void showChannel(String str, String str2, boolean z) {
        if (z) {
            startActivity(ChatRouting.INSTANCE.getChannelsIntent(this));
        }
        startActivity(ChatRouting.INSTANCE.getChannelIntent(this, str, str2));
        finish();
    }

    /* access modifiers changed from: private */
    public final void showChatSignInState(ChatStartupState chatStartupState) {
        if (chatStartupState instanceof ChatStartupState.Loaded) {
            handleStartupComplete();
        } else if (chatStartupState instanceof ChatStartupState.Loading) {
            getBinding().chatStartupContentLayout.apply(ContentVisibilityAction.Companion.progress(((ChatStartupState.Loading) chatStartupState).getMessage()));
        } else if (chatStartupState instanceof ChatStartupState.Failure) {
            getBinding().chatStartupContentLayout.apply(ContentVisibilityAction.Companion.error(((ChatStartupState.Failure) chatStartupState).getError()));
        }
    }

    private final void handleStartupComplete() {
        if (isStartedForResult()) {
            setResult(-1);
            finish();
            return;
        }
        ChatPushMessage.Companion companion = ChatPushMessage.Companion;
        Intent intent = getIntent();
        ChatPushMessage createFromBundle = companion.createFromBundle(intent != null ? intent.getExtras() : null);
        if (createFromBundle != null) {
            showChannel(createFromBundle.cid(), createFromBundle.getMessageId(), true);
        } else {
            showChannels();
        }
    }

    public void onContentLayoutErrorResolutionButtonTapped(int i, int i2) {
        ContentLayout contentLayout = getBinding().chatStartupContentLayout;
        Intrinsics.checkNotNullExpressionValue(contentLayout, "binding.chatStartupContentLayout");
        if (contentLayout.getId() == i && i2 == 1211) {
            getChatStartupViewModel().beginStartup();
            return;
        }
        throw new RuntimeException("Unable to resolve content-layout error resolution: " + i + ' ' + i2);
    }
}
