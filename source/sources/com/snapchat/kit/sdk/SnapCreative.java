package com.snapchat.kit.sdk;

import android.content.Context;
import com.snapchat.kit.sdk.creative.C4466a;
import com.snapchat.kit.sdk.creative.CreativeComponent;
import com.snapchat.kit.sdk.creative.api.SnapCreativeKitApi;
import com.snapchat.kit.sdk.creative.media.SnapMediaFactory;

public class SnapCreative {

    /* renamed from: a */
    static CreativeComponent f1052a;

    /* renamed from: a */
    private static synchronized CreativeComponent m807a(Context context) {
        CreativeComponent creativeComponent;
        synchronized (SnapCreative.class) {
            if (f1052a == null) {
                f1052a = C4466a.m919a().mo61742a(SnapKit.getComponent(context)).mo61741a();
            }
            creativeComponent = f1052a;
        }
        return creativeComponent;
    }

    public static SnapCreativeKitApi getApi(Context context) {
        return m807a(context).getApi();
    }

    public static SnapMediaFactory getMediaFactory(Context context) {
        return m807a(context).getMediaFactory();
    }
}
