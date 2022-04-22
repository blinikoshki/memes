package com.google.android.gms.common.api.internal;

import android.content.DialogInterface;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zal implements Runnable {
    private final zam zadk;
    final /* synthetic */ zak zadl;

    zal(zak zak, zam zam) {
        this.zadl = zak;
        this.zadk = zam;
    }

    public final void run() {
        if (this.zadl.zadh) {
            ConnectionResult connectionResult = this.zadk.getConnectionResult();
            if (connectionResult.hasResolution()) {
                this.zadl.mLifecycleFragment.startActivityForResult(GoogleApiActivity.zaa(this.zadl.getActivity(), connectionResult.getResolution(), this.zadk.zap(), false), 1);
            } else if (this.zadl.zace.isUserResolvableError(connectionResult.getErrorCode())) {
                this.zadl.zace.zaa(this.zadl.getActivity(), this.zadl.mLifecycleFragment, connectionResult.getErrorCode(), 2, this.zadl);
            } else if (connectionResult.getErrorCode() == 18) {
                this.zadl.zace.zaa(this.zadl.getActivity().getApplicationContext(), (zabp) new zan(this, GoogleApiAvailability.zaa(this.zadl.getActivity(), (DialogInterface.OnCancelListener) this.zadl)));
            } else {
                this.zadl.zaa(connectionResult, this.zadk.zap());
            }
        }
    }
}
