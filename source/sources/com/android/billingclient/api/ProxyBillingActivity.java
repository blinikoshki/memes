package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zza;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
public class ProxyBillingActivity extends Activity {
    private ResultReceiver zza;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        PendingIntent pendingIntent;
        super.onCreate(bundle);
        if (bundle == null) {
            zza.zza("ProxyBillingActivity", "Launching Play Store billing flow");
            if (getIntent().hasExtra("BUY_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
            } else if (getIntent().hasExtra("SUBS_MANAGEMENT_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("SUBS_MANAGEMENT_INTENT");
                this.zza = (ResultReceiver) getIntent().getParcelableExtra("result_receiver");
            } else {
                pendingIntent = null;
            }
            try {
                startIntentSenderForResult(pendingIntent.getIntentSender(), 100, new Intent(), 0, 0, 0);
            } catch (IntentSender.SendIntentException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 53);
                sb.append("Got exception while trying to start a purchase flow: ");
                sb.append(valueOf);
                zza.zzb("ProxyBillingActivity", sb.toString());
                ResultReceiver resultReceiver = this.zza;
                if (resultReceiver != null) {
                    resultReceiver.send(6, (Bundle) null);
                } else {
                    Intent zza2 = zza();
                    zza2.putExtra("RESPONSE_CODE", 6);
                    zza2.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                    sendBroadcast(zza2);
                }
                finish();
            }
        } else {
            zza.zza("ProxyBillingActivity", "Launching Play Store billing flow from savedInstanceState");
            if (bundle.containsKey("result_receiver")) {
                this.zza = (ResultReceiver) bundle.getParcelable("result_receiver");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        ResultReceiver resultReceiver = this.zza;
        if (resultReceiver != null) {
            bundle.putParcelable("result_receiver", resultReceiver);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        Bundle bundle;
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            int zza2 = zza.zza(intent, "ProxyBillingActivity");
            if (!(i2 == -1 && zza2 == 0)) {
                StringBuilder sb = new StringBuilder(85);
                sb.append("Activity finished with resultCode ");
                sb.append(i2);
                sb.append(" and billing's responseCode: ");
                sb.append(zza2);
                zza.zzb("ProxyBillingActivity", sb.toString());
            }
            ResultReceiver resultReceiver = this.zza;
            if (resultReceiver != null) {
                if (intent == null) {
                    bundle = null;
                } else {
                    bundle = intent.getExtras();
                }
                resultReceiver.send(zza2, bundle);
            } else {
                Intent zza3 = zza();
                if (intent != null) {
                    zza3.putExtras(intent.getExtras());
                }
                sendBroadcast(zza3);
            }
        } else {
            StringBuilder sb2 = new StringBuilder(69);
            sb2.append("Got onActivityResult with wrong requestCode: ");
            sb2.append(i);
            sb2.append("; skipping...");
            zza.zzb("ProxyBillingActivity", sb2.toString());
        }
        finish();
    }

    private final Intent zza() {
        Intent intent = new Intent("com.android.vending.billing.PURCHASES_UPDATED");
        intent.setPackage(getApplicationContext().getPackageName());
        return intent;
    }
}
