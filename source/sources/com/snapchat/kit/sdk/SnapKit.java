package com.snapchat.kit.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.snapchat.kit.sdk.core.metrics.model.SnapKitInitType;
import java.util.Arrays;

public class SnapKit {

    /* renamed from: a */
    private static SnapKit f1053a;

    /* renamed from: b */
    private final SnapKitComponent f1054b;

    private SnapKit(Context context, SnapKitInitType snapKitInitType) throws IllegalStateException {
        String[] strArr;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                String string = bundle.getString("com.snapchat.kit.sdk.clientId");
                String string2 = bundle.getString("com.snapchat.kit.sdk.redirectUrl", "");
                int i = bundle.getInt("com.snapchat.kit.sdk.scopes", 0);
                if (i == 0) {
                    strArr = new String[0];
                } else {
                    strArr = context.getResources().getStringArray(i);
                }
                if (!TextUtils.isEmpty(string)) {
                    SnapKitComponent a = C4384c.m827a().mo61303a(new C4488g(context, string, string2, Arrays.asList(strArr), snapKitInitType)).mo61302a();
                    this.f1054b = a;
                    ProcessLifecycleOwner.get().getLifecycle().addObserver(a.snapKitAppLifecycleObserver());
                    return;
                }
                throw new IllegalStateException("client id must be set!");
            }
            throw new IllegalStateException("No metadata for the current app!");
        } catch (PackageManager.NameNotFoundException unused) {
            throw new IllegalStateException("Could not get metadata for current package");
        }
    }

    /* renamed from: a */
    private static synchronized SnapKit m808a(Context context, SnapKitInitType snapKitInitType) {
        SnapKit snapKit;
        synchronized (SnapKit.class) {
            if (f1053a == null) {
                f1053a = new SnapKit(context.getApplicationContext(), snapKitInitType);
            }
            snapKit = f1053a;
        }
        return snapKit;
    }

    static SnapKitComponent getComponent(Context context) {
        return m808a(context, SnapKitInitType.INIT_TYPE_FEATURE).f1054b;
    }

    /* renamed from: a */
    protected static void m809a(Context context) {
        m808a(context, SnapKitInitType.INIT_TYPE_AUTO);
    }

    public static void initSDK(Context context) {
        m808a(context, SnapKitInitType.INIT_TYPE_DEFERRED);
    }

    public static synchronized void deInitialize() {
        synchronized (SnapKit.class) {
            if (f1053a != null) {
                ProcessLifecycleOwner.get().getLifecycle().removeObserver(f1053a.f1054b.snapKitAppLifecycleObserver());
                f1053a = null;
            }
        }
    }
}
