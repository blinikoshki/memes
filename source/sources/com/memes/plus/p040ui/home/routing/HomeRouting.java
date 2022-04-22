package com.memes.plus.p040ui.home.routing;

import android.content.Context;
import android.content.Intent;
import com.memes.plus.firebase.PushMessage;
import com.memes.plus.p040ui.home.HomeActivity;
import com.memes.plus.p040ui.home.feeds.HomeFeedType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Lcom/memes/plus/ui/home/routing/HomeRouting;", "", "()V", "EXTRA_CURRENT_FEED_TYPE", "", "EXTRA_PUSH_MESSAGE", "getDirectIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "getIntent", "pushMessage", "Lcom/memes/plus/firebase/PushMessage;", "feedType", "Lcom/memes/plus/ui/home/feeds/HomeFeedType;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.home.routing.HomeRouting */
/* compiled from: HomeRouting.kt */
public final class HomeRouting {
    public static final String EXTRA_CURRENT_FEED_TYPE = "intent_extra_current_feed_type";
    public static final String EXTRA_PUSH_MESSAGE = "intent_extra_push_message";
    public static final HomeRouting INSTANCE = new HomeRouting();

    private HomeRouting() {
    }

    public final Intent getIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new Intent(context, HomeRoutingActivity.class);
    }

    public final Intent getDirectIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new Intent(context, HomeActivity.class);
    }

    public final Intent getIntent(Context context, PushMessage pushMessage) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pushMessage, "pushMessage");
        Intent intent = new Intent(context, HomeRoutingActivity.class);
        intent.putExtra(EXTRA_PUSH_MESSAGE, pushMessage);
        return intent;
    }

    public final Intent getIntent(Context context, HomeFeedType homeFeedType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(homeFeedType, "feedType");
        Intent intent = new Intent(context, HomeActivity.class);
        intent.putExtra(EXTRA_CURRENT_FEED_TYPE, homeFeedType);
        return intent;
    }
}
