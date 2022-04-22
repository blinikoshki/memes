package com.memes.plus.p040ui.home.routing;

import android.content.Intent;
import android.os.Bundle;
import com.memes.chat.routing.ChatRouting;
import com.memes.commons.activity.BaseActivity;
import com.memes.plus.p040ui.home.HomeActivity;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\"\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u0004H\u0002¨\u0006\u0010"}, mo26107d2 = {"Lcom/memes/plus/ui/home/routing/HomeRoutingActivity;", "Lcom/memes/commons/activity/BaseActivity;", "()V", "navigateToHome", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "startChatStartup", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.home.routing.HomeRoutingActivity */
/* compiled from: HomeRoutingActivity.kt */
public final class HomeRoutingActivity extends BaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int RC_CHAT_STARTUP = 87489;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/plus/ui/home/routing/HomeRoutingActivity$Companion;", "", "()V", "RC_CHAT_STARTUP", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.home.routing.HomeRoutingActivity$Companion */
    /* compiled from: HomeRoutingActivity.kt */
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
        startChatStartup();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != RC_CHAT_STARTUP) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            navigateToHome();
        } else {
            finish();
        }
    }

    private final void startChatStartup() {
        startActivityForResult(ChatRouting.INSTANCE.getChatStartupIntent(this), RC_CHAT_STARTUP);
    }

    private final void navigateToHome() {
        Intent intent = getIntent();
        Intent intent2 = new Intent(this, HomeActivity.class);
        intent2.putExtras(intent);
        startActivity(intent2);
        finish();
    }
}
