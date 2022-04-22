package com.snapchat.kit.sdk;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.snapchat.kit.sdk.core.controller.LoginStateController;
import com.snapchat.kit.sdk.core.networking.FetchCodeVerifierCallback;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

public abstract class SnapCFSActivity extends Activity {
    @Inject

    /* renamed from: a */
    C4475d f1037a;
    @Inject

    /* renamed from: b */
    LoginStateController f1038b;

    /* renamed from: c */
    LoginStateController.OnLoginStateChangedListener f1039c = new C4377b(this);

    /* access modifiers changed from: protected */
    public abstract ConnectFromSnapchatHandler getConnectFromSnapchatHandler();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null || intent.getData() == null) {
            finish();
            return;
        }
        SnapKitComponent component = SnapKit.getComponent(this);
        if (component == null) {
            finish();
            return;
        }
        component.inject(this);
        String queryParameter = intent.getData().getQueryParameter("code");
        String queryParameter2 = intent.getData().getQueryParameter("state");
        if (TextUtils.isEmpty(queryParameter) || TextUtils.isEmpty(queryParameter2)) {
            finish();
            return;
        }
        ConnectFromSnapchatHandler connectFromSnapchatHandler = getConnectFromSnapchatHandler();
        if (connectFromSnapchatHandler.needsLoginRedirect()) {
            finish();
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("CFS_PENDING_INTENT");
        if (pendingIntent == null || !"com.snapchat.android".equals(pendingIntent.getCreatorPackage())) {
            finish();
        } else {
            connectFromSnapchatHandler.fetchCodeVerifier(queryParameter2, new C4374a(this, intent.getData()));
        }
    }

    /* renamed from: com.snapchat.kit.sdk.SnapCFSActivity$a */
    private static final class C4374a implements FetchCodeVerifierCallback {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final Uri f1040a;

        /* renamed from: b */
        private WeakReference<SnapCFSActivity> f1041b;

        C4374a(SnapCFSActivity snapCFSActivity, Uri uri) {
            this.f1041b = new WeakReference<>(snapCFSActivity);
            this.f1040a = uri;
        }

        public final void onCodeVerifierFetchedSuccessfully(final String str) {
            final SnapCFSActivity snapCFSActivity = (SnapCFSActivity) this.f1041b.get();
            if (snapCFSActivity != null) {
                snapCFSActivity.runOnUiThread(new Runnable() {
                    public final void run() {
                        SnapCFSActivity.m805a(snapCFSActivity, C4374a.this.f1040a, str);
                    }
                });
            }
        }

        public final void onCodeVerifierFetchFailed(Throwable th) {
            final Activity activity = (Activity) this.f1041b.get();
            if (activity != null) {
                activity.runOnUiThread(new Runnable() {
                    public final void run() {
                        activity.finish();
                    }
                });
            }
        }
    }

    /* renamed from: com.snapchat.kit.sdk.SnapCFSActivity$b */
    private static final class C4377b implements LoginStateController.OnLoginStateChangedListener {

        /* renamed from: a */
        private WeakReference<SnapCFSActivity> f1047a;

        public final void onLogout() {
        }

        C4377b(SnapCFSActivity snapCFSActivity) {
            this.f1047a = new WeakReference<>(snapCFSActivity);
        }

        public final void onLoginSucceeded() {
            final SnapCFSActivity snapCFSActivity = (SnapCFSActivity) this.f1047a.get();
            if (snapCFSActivity != null) {
                snapCFSActivity.runOnUiThread(new Runnable() {
                    public final void run() {
                        SnapCFSActivity.m804a(snapCFSActivity);
                        snapCFSActivity.finish();
                    }
                });
            }
        }

        public final void onLoginFailed() {
            final SnapCFSActivity snapCFSActivity = (SnapCFSActivity) this.f1047a.get();
            if (snapCFSActivity != null) {
                snapCFSActivity.runOnUiThread(new Runnable() {
                    public final void run() {
                        SnapCFSActivity.m804a(snapCFSActivity);
                    }
                });
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m805a(SnapCFSActivity snapCFSActivity, Uri uri, String str) {
        snapCFSActivity.f1038b.addOnLoginStateChangedListener(snapCFSActivity.f1039c);
        snapCFSActivity.f1037a.mo61787a(uri, str);
    }

    /* renamed from: a */
    static /* synthetic */ void m804a(SnapCFSActivity snapCFSActivity) {
        snapCFSActivity.f1038b.removeOnLoginStateChangedListener(snapCFSActivity.f1039c);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("snapchat://cfs"));
        intent.setPackage("com.snapchat.android");
        intent.setFlags(268435456);
        if (intent.resolveActivity(snapCFSActivity.getPackageManager()) != null) {
            snapCFSActivity.startActivity(intent);
        }
    }
}
