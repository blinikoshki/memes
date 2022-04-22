package com.memes.plus.util;

import android.content.Context;
import android.content.Intent;
import com.getstream.sdk.chat.model.ModelType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/plus/util/LocalIntents;", "", "()V", "getAppInviteIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "getInviteFriendsIntent", "getShareProfileIntent", "username", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: LocalIntents.kt */
public final class LocalIntents {
    public static final LocalIntents INSTANCE = new LocalIntents();

    private LocalIntents() {
    }

    public final Intent getShareProfileIntent(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "username");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(ModelType.attach_mime_txt);
        intent.putExtra("android.intent.extra.TEXT", "https://memes.com/u/" + str);
        if (Intent.createChooser(intent, "Share Profile to").resolveActivity(context.getPackageManager()) != null) {
            return intent;
        }
        return null;
    }

    public final Intent getAppInviteIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(ModelType.attach_mime_txt);
        intent.putExtra("android.intent.extra.TEXT", "Check out my memes on the Memes app by tapping this link \n https://memes.onelink.me/8OHE/Invite");
        if (Intent.createChooser(intent, "Share to").resolveActivity(context.getPackageManager()) != null) {
            return intent;
        }
        return null;
    }

    public final Intent getInviteFriendsIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(ModelType.attach_mime_txt);
        intent.putExtra("android.intent.extra.TEXT", "Check out my memes on the Memes app by tapping this link \n https://memes.onelink.me/8OHE/InviteFriends");
        if (Intent.createChooser(intent, "Share to").resolveActivity(context.getPackageManager()) != null) {
            return intent;
        }
        return null;
    }
}
