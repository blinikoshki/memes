package com.memes.chat.p036ui.directmessaging;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.memes.chat.routing.ChatRouting;
import com.memes.commons.activity.BaseActivity;
import com.memes.commons.util.ExtensionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p015io.getstream.chat.android.client.models.Channel;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, mo26107d2 = {"Lcom/memes/chat/ui/directmessaging/DirectMessagingActivity;", "Lcom/memes/commons/activity/BaseActivity;", "()V", "directMessagingViewModel", "Lcom/memes/chat/ui/directmessaging/DirectMessagingViewModel;", "getDirectMessagingViewModel", "()Lcom/memes/chat/ui/directmessaging/DirectMessagingViewModel;", "directMessagingViewModel$delegate", "Lkotlin/Lazy;", "finish", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showChannel", "channel", "Lio/getstream/chat/android/client/models/Channel;", "Companion", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.directmessaging.DirectMessagingActivity */
/* compiled from: DirectMessagingActivity.kt */
public final class DirectMessagingActivity extends BaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_TARGET_USER_ID = "intent_extra_target_user_id";
    private final Lazy directMessagingViewModel$delegate = LazyKt.lazy(new DirectMessagingActivity$directMessagingViewModel$2(this));

    private final DirectMessagingViewModel getDirectMessagingViewModel() {
        return (DirectMessagingViewModel) this.directMessagingViewModel$delegate.getValue();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Lcom/memes/chat/ui/directmessaging/DirectMessagingActivity$Companion;", "", "()V", "EXTRA_TARGET_USER_ID", "", "getStartIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "targetUserId", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.directmessaging.DirectMessagingActivity$Companion */
    /* compiled from: DirectMessagingActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent getStartIntent(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "targetUserId");
            Intent intent = new Intent(context, DirectMessagingActivity.class);
            intent.putExtra(DirectMessagingActivity.EXTRA_TARGET_USER_ID, str);
            return intent;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean z = true;
        registerViewModels(getDirectMessagingViewModel());
        getDirectMessagingViewModel().channelCreation().observe(this, new DirectMessagingActivity$onCreate$1(this));
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra(EXTRA_TARGET_USER_ID) : null;
        CharSequence charSequence = stringExtra;
        if (charSequence != null && !StringsKt.isBlank(charSequence)) {
            z = false;
        }
        if (z) {
            ExtensionsKt.toast((Context) this, "Unable to find target user ID");
            finish();
            return;
        }
        getDirectMessagingViewModel().createChannel(stringExtra);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    /* access modifiers changed from: private */
    public final void showChannel(Channel channel) {
        startActivity(ChatRouting.INSTANCE.getChannelIntent(this, channel));
    }
}
