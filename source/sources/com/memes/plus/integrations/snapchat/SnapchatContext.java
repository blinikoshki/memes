package com.memes.plus.integrations.snapchat;

import android.content.Context;
import com.snapchat.kit.sdk.SnapCreative;
import com.snapchat.kit.sdk.creative.api.SnapCreativeKitApi;
import com.snapchat.kit.sdk.creative.media.SnapMediaFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/integrations/snapchat/SnapchatContext;", "", "applicationContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getCreativeKitApi", "Lcom/snapchat/kit/sdk/creative/api/SnapCreativeKitApi;", "getMediaFactory", "Lcom/snapchat/kit/sdk/creative/media/SnapMediaFactory;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: SnapchatContext.kt */
public final class SnapchatContext {
    private final Context applicationContext;

    public SnapchatContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        this.applicationContext = context;
    }

    public final SnapCreativeKitApi getCreativeKitApi() {
        SnapCreativeKitApi api = SnapCreative.getApi(this.applicationContext);
        Intrinsics.checkNotNullExpressionValue(api, "SnapCreative.getApi(applicationContext)");
        return api;
    }

    public final SnapMediaFactory getMediaFactory() {
        SnapMediaFactory mediaFactory = SnapCreative.getMediaFactory(this.applicationContext);
        Intrinsics.checkNotNullExpressionValue(mediaFactory, "SnapCreative.getMediaFactory(applicationContext)");
        return mediaFactory;
    }
}
