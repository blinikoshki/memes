package com.google.android.gms.common.api.internal;

import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zax implements OnCompleteListener<Map<ApiKey<?>, String>> {
    private final /* synthetic */ zav zafl;

    private zax(zav zav) {
        this.zafl = zav;
    }

    public final void onComplete(Task<Map<ApiKey<?>, String>> task) {
        this.zafl.zaer.lock();
        try {
            if (this.zafl.zafe) {
                if (task.isSuccessful()) {
                    zav zav = this.zafl;
                    Map unused = zav.zaff = new ArrayMap(zav.zaeu.size());
                    for (zaw apiKey : this.zafl.zaeu.values()) {
                        this.zafl.zaff.put(apiKey.getApiKey(), ConnectionResult.RESULT_SUCCESS);
                    }
                } else if (task.getException() instanceof AvailabilityException) {
                    AvailabilityException availabilityException = (AvailabilityException) task.getException();
                    if (this.zafl.zafc) {
                        zav zav2 = this.zafl;
                        Map unused2 = zav2.zaff = new ArrayMap(zav2.zaeu.size());
                        for (zaw zaw : this.zafl.zaeu.values()) {
                            ApiKey apiKey2 = zaw.getApiKey();
                            ConnectionResult connectionResult = availabilityException.getConnectionResult((GoogleApi<? extends Api.ApiOptions>) zaw);
                            if (this.zafl.zaa((zaw<?>) zaw, connectionResult)) {
                                this.zafl.zaff.put(apiKey2, new ConnectionResult(16));
                            } else {
                                this.zafl.zaff.put(apiKey2, connectionResult);
                            }
                        }
                    } else {
                        Map unused3 = this.zafl.zaff = availabilityException.zaj();
                    }
                    zav zav3 = this.zafl;
                    ConnectionResult unused4 = zav3.zafi = zav3.zaac();
                } else {
                    Log.e("ConnectionlessGAC", "Unexpected availability exception", task.getException());
                    Map unused5 = this.zafl.zaff = Collections.emptyMap();
                    ConnectionResult unused6 = this.zafl.zafi = new ConnectionResult(8);
                }
                if (this.zafl.zafg != null) {
                    this.zafl.zaff.putAll(this.zafl.zafg);
                    zav zav4 = this.zafl;
                    ConnectionResult unused7 = zav4.zafi = zav4.zaac();
                }
                if (this.zafl.zafi == null) {
                    this.zafl.zaaa();
                    this.zafl.zaab();
                } else {
                    boolean unused8 = this.zafl.zafe = false;
                    this.zafl.zaex.zac(this.zafl.zafi);
                }
                this.zafl.zaez.signalAll();
                this.zafl.zaer.unlock();
            }
        } finally {
            this.zafl.zaer.unlock();
        }
    }
}
