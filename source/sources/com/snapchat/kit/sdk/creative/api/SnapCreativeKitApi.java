package com.snapchat.kit.sdk.creative.api;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.snapchat.kit.sdk.core.metrics.MetricQueue;
import com.snapchat.kit.sdk.core.metrics.model.ServerEvent;
import com.snapchat.kit.sdk.creative.C4460R;
import com.snapchat.kit.sdk.creative.models.SnapContent;
import com.snapchat.kit.sdk.creative.p044a.C4469a;
import com.snapchat.kit.sdk.creative.p045b.C4470a;
import com.snapchat.kit.sdk.creative.p045b.C4472c;
import com.snapchat.kit.sdk.util.SnapUtils;
import javax.inject.Inject;
import javax.inject.Named;

public class SnapCreativeKitApi {
    private static final String CLIENT_ID_EXTRA = "CLIENT_ID";
    private static final String DEEP_LINK_INTENT_EXTRA = "deep_link_intent";
    private static final String KIT_REDIRECT_URL_EXTRA = "KIT_REDIRECT_URL";
    private static final String KIT_VERSION_CODE_EXTRA = "KIT_VERSION_CODE";
    private static final String KIT_VERSION_EXTRA = "KIT_VERSION";
    private static final int REQUEST_CODE = 17;
    private static final String RESULT_INTENT_EXTRA = "RESULT_INTENT";
    private static final String TAG = "SnapCreativeKitApi";
    private final String mClientId;
    private final Context mContext;
    private final C4470a mEventFactory;
    private final MetricQueue<ServerEvent> mEventQueue;
    private C4472c mOpMetricsManager;
    private String mRedirectUrl;

    @Inject
    SnapCreativeKitApi(Context context, @Named("client_id") String str, @Named("redirect_url") String str2, C4472c cVar, MetricQueue<ServerEvent> metricQueue, C4470a aVar) {
        this.mContext = context;
        this.mClientId = str;
        this.mRedirectUrl = str2;
        this.mOpMetricsManager = cVar;
        this.mEventQueue = metricQueue;
        this.mEventFactory = aVar;
    }

    public void send(SnapContent snapContent) {
        sendWithCompletionHandler(snapContent, (SnapCreativeKitCompletionCallback) null);
    }

    public void sendWithCompletionHandler(SnapContent snapContent, SnapCreativeKitCompletionCallback snapCreativeKitCompletionCallback) {
        long currentTimeMillis = System.currentTimeMillis();
        C4469a aVar = new C4469a(this.mClientId, snapContent);
        PackageManager packageManager = this.mContext.getPackageManager();
        if (!SnapUtils.isSnapchatInstalled(packageManager, "com.snapchat.android")) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("https://play.google.com/store/apps/details?id=%s", new Object[]{"com.snapchat.android"})));
            intent.setFlags(268435456);
            this.mContext.startActivity(intent);
            this.mOpMetricsManager.mo61749a("sendToPlayStore");
            if (snapCreativeKitCompletionCallback != null) {
                snapCreativeKitCompletionCallback.onSendFailed(SnapCreativeKitSendError.SNAPCHAT_NOT_INSTALLED);
                return;
            }
            return;
        }
        this.mOpMetricsManager.mo61749a("sendIntentToApp");
        Intent a = aVar.mo61743a(this.mContext);
        a.setPackage("com.snapchat.android");
        a.putExtra(CLIENT_ID_EXTRA, this.mClientId);
        a.putExtra(KIT_VERSION_EXTRA, "1.6.8");
        a.putExtra(KIT_VERSION_CODE_EXTRA, 40);
        a.putExtra(DEEP_LINK_INTENT_EXTRA, true);
        if (!TextUtils.isEmpty(this.mRedirectUrl)) {
            a.putExtra(KIT_REDIRECT_URL_EXTRA, this.mRedirectUrl);
        }
        a.putExtra(RESULT_INTENT_EXTRA, PendingIntent.getBroadcast(this.mContext, 17, new Intent(), 1073741824));
        a.setFlags(335544320);
        if (a.resolveActivity(packageManager) != null) {
            this.mEventQueue.push(this.mEventFactory.mo61748a());
            this.mContext.startActivity(a);
            this.mOpMetricsManager.mo61750a("sendLatency", System.currentTimeMillis() - currentTimeMillis);
            if (snapCreativeKitCompletionCallback != null) {
                snapCreativeKitCompletionCallback.onSendSuccess();
                return;
            }
            return;
        }
        this.mOpMetricsManager.mo61749a("cannotShareContent");
        Toast.makeText(this.mContext, C4460R.string.snap_connect_snap_error_cannot_share_content, 0).show();
        if (snapCreativeKitCompletionCallback != null) {
            snapCreativeKitCompletionCallback.onSendFailed(SnapCreativeKitSendError.SNAPCHAT_CANNOT_SHARE_CONTENT);
        }
    }
}
