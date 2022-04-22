package com.facebook.referrals;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.Validate;

public class ReferralManager {
    private static volatile ReferralManager instance;
    private ReferralLogger logger;

    ReferralManager() {
        Validate.sdkInitialized();
    }

    public static ReferralManager getInstance() {
        if (instance == null) {
            synchronized (ReferralManager.class) {
                if (instance == null) {
                    instance = new ReferralManager();
                }
            }
        }
        return instance;
    }

    public void startReferral(Activity activity) {
        startReferralImpl(new ActivityStartActivityDelegate(activity));
    }

    public void startReferral(Fragment fragment) {
        startReferralImpl(new FragmentStartActivityDelegate(new FragmentWrapper(fragment)));
    }

    public void startReferral(android.app.Fragment fragment) {
        startReferralImpl(new FragmentStartActivityDelegate(new FragmentWrapper(fragment)));
    }

    public void startReferral(FragmentWrapper fragmentWrapper) {
        startReferralImpl(new FragmentStartActivityDelegate(fragmentWrapper));
    }

    public void registerCallback(CallbackManager callbackManager, final FacebookCallback<ReferralResult> facebookCallback) {
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).registerCallback(ReferralClient.getReferralRequestCode(), new CallbackManagerImpl.Callback() {
                public boolean onActivityResult(int i, Intent intent) {
                    return ReferralManager.this.onActivityResult(i, intent, facebookCallback);
                }
            });
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    private void startReferralImpl(StartActivityDelegate startActivityDelegate) {
        ReferralLogger logger2 = getLogger(startActivityDelegate.getActivityContext());
        if (logger2 != null) {
            logger2.logStartReferral();
        }
        if (!tryFacebookActivity(startActivityDelegate)) {
            FacebookException facebookException = new FacebookException("Failed to open Referral dialog: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            if (logger2 != null) {
                logger2.logError(facebookException);
            }
            throw facebookException;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onActivityResult(int r5, android.content.Intent r6, com.facebook.FacebookCallback<com.facebook.referrals.ReferralResult> r7) {
        /*
            r4 = this;
            java.lang.String r0 = "error_message"
            java.lang.String r1 = "fb_referral_codes"
            r2 = -1
            r3 = 0
            if (r5 != r2) goto L_0x0032
            if (r6 == 0) goto L_0x0032
            android.os.Bundle r2 = r6.getExtras()     // Catch:{ JSONException -> 0x0060 }
            if (r2 == 0) goto L_0x0032
            android.os.Bundle r2 = r6.getExtras()     // Catch:{ JSONException -> 0x0060 }
            boolean r2 = r2.containsKey(r1)     // Catch:{ JSONException -> 0x0060 }
            if (r2 == 0) goto L_0x0032
            android.os.Bundle r5 = r6.getExtras()     // Catch:{ JSONException -> 0x0060 }
            java.lang.String r5 = r5.getString(r1)     // Catch:{ JSONException -> 0x0060 }
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0060 }
            r6.<init>(r5)     // Catch:{ JSONException -> 0x0060 }
            java.util.List r5 = com.facebook.internal.Utility.convertJSONArrayToList(r6)     // Catch:{ JSONException -> 0x0060 }
            com.facebook.referrals.ReferralResult r6 = new com.facebook.referrals.ReferralResult     // Catch:{ JSONException -> 0x0060 }
            r6.<init>(r5)     // Catch:{ JSONException -> 0x0060 }
            r5 = r3
            goto L_0x0068
        L_0x0032:
            if (r5 != 0) goto L_0x0057
            if (r6 == 0) goto L_0x0054
            android.os.Bundle r5 = r6.getExtras()     // Catch:{ JSONException -> 0x0060 }
            if (r5 == 0) goto L_0x0054
            android.os.Bundle r5 = r6.getExtras()     // Catch:{ JSONException -> 0x0060 }
            boolean r5 = r5.containsKey(r0)     // Catch:{ JSONException -> 0x0060 }
            if (r5 == 0) goto L_0x0054
            android.os.Bundle r5 = r6.getExtras()     // Catch:{ JSONException -> 0x0060 }
            java.lang.String r5 = r5.getString(r0)     // Catch:{ JSONException -> 0x0060 }
            com.facebook.FacebookException r6 = new com.facebook.FacebookException     // Catch:{ JSONException -> 0x0060 }
            r6.<init>((java.lang.String) r5)     // Catch:{ JSONException -> 0x0060 }
            goto L_0x005e
        L_0x0054:
            r5 = r3
            r6 = r5
            goto L_0x0068
        L_0x0057:
            com.facebook.FacebookException r6 = new com.facebook.FacebookException     // Catch:{ JSONException -> 0x0060 }
            java.lang.String r5 = "Unexpected call to ReferralManager.onActivityResult"
            r6.<init>((java.lang.String) r5)     // Catch:{ JSONException -> 0x0060 }
        L_0x005e:
            r5 = r6
            goto L_0x0067
        L_0x0060:
            com.facebook.FacebookException r5 = new com.facebook.FacebookException
            java.lang.String r6 = "Unable to parse referral codes from response"
            r5.<init>((java.lang.String) r6)
        L_0x0067:
            r6 = r3
        L_0x0068:
            com.facebook.referrals.ReferralLogger r0 = r4.getLogger(r3)
            if (r0 == 0) goto L_0x007d
            if (r6 == 0) goto L_0x0074
            r0.logSuccess()
            goto L_0x007d
        L_0x0074:
            if (r5 == 0) goto L_0x007a
            r0.logError(r5)
            goto L_0x007d
        L_0x007a:
            r0.logCancel()
        L_0x007d:
            if (r6 == 0) goto L_0x0083
            r7.onSuccess(r6)
            goto L_0x008c
        L_0x0083:
            if (r5 == 0) goto L_0x0089
            r7.onError(r5)
            goto L_0x008c
        L_0x0089:
            r7.onCancel()
        L_0x008c:
            r5 = 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.referrals.ReferralManager.onActivityResult(int, android.content.Intent, com.facebook.FacebookCallback):boolean");
    }

    private boolean tryFacebookActivity(StartActivityDelegate startActivityDelegate) {
        Intent intent = new Intent();
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(ReferralFragment.TAG);
        if (!resolveIntent(intent)) {
            return false;
        }
        try {
            startActivityDelegate.startActivityForResult(intent, CallbackManagerImpl.RequestCodeOffset.Referral.toRequestCode());
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    private ReferralLogger getLogger(Context context) {
        if (context == null) {
            context = FacebookSdk.getApplicationContext();
        }
        if (context == null) {
            return null;
        }
        if (this.logger == null) {
            this.logger = new ReferralLogger(context, FacebookSdk.getApplicationId());
        }
        return this.logger;
    }

    private static boolean resolveIntent(Intent intent) {
        return FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(intent, 0) != null;
    }

    private static class ActivityStartActivityDelegate implements StartActivityDelegate {
        private final Activity activity;

        ActivityStartActivityDelegate(Activity activity2) {
            Validate.notNull(activity2, "activity");
            this.activity = activity2;
        }

        public void startActivityForResult(Intent intent, int i) {
            this.activity.startActivityForResult(intent, i);
        }

        public Activity getActivityContext() {
            return this.activity;
        }
    }

    private static class FragmentStartActivityDelegate implements StartActivityDelegate {
        private final FragmentWrapper fragment;

        FragmentStartActivityDelegate(FragmentWrapper fragmentWrapper) {
            Validate.notNull(fragmentWrapper, "fragment");
            this.fragment = fragmentWrapper;
        }

        public void startActivityForResult(Intent intent, int i) {
            this.fragment.startActivityForResult(intent, i);
        }

        public Activity getActivityContext() {
            return this.fragment.getActivity();
        }
    }
}
