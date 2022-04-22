package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
final class zze implements ServiceConnection {
    private ComponentName mComponentName;
    private int mState = 2;
    private IBinder zzdk;
    private final Map<ServiceConnection, ServiceConnection> zzei = new HashMap();
    private boolean zzej;
    private final GmsClientSupervisor.zza zzek;
    private final /* synthetic */ zzf zzel;

    public zze(zzf zzf, GmsClientSupervisor.zza zza) {
        this.zzel = zzf;
        this.zzek = zza;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.zzel.zzem) {
            this.zzel.handler.removeMessages(1, this.zzek);
            this.zzdk = iBinder;
            this.mComponentName = componentName;
            for (ServiceConnection onServiceConnected : this.zzei.values()) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.mState = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.zzel.zzem) {
            this.zzel.handler.removeMessages(1, this.zzek);
            this.zzdk = null;
            this.mComponentName = componentName;
            for (ServiceConnection onServiceDisconnected : this.zzei.values()) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.mState = 2;
        }
    }

    public final void zze(String str) {
        this.mState = 3;
        boolean zza = this.zzel.zzeo.zza(this.zzel.zzen, str, this.zzek.zzb(this.zzel.zzen), this, this.zzek.zzq());
        this.zzej = zza;
        if (zza) {
            this.zzel.handler.sendMessageDelayed(this.zzel.handler.obtainMessage(1, this.zzek), this.zzel.zzeq);
            return;
        }
        this.mState = 2;
        try {
            this.zzel.zzeo.unbindService(this.zzel.zzen, this);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final void zzf(String str) {
        this.zzel.handler.removeMessages(1, this.zzek);
        this.zzel.zzeo.unbindService(this.zzel.zzen, this);
        this.zzej = false;
        this.mState = 2;
    }

    public final void zza(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        ConnectionTracker unused = this.zzel.zzeo;
        Context unused2 = this.zzel.zzen;
        this.zzek.zzb(this.zzel.zzen);
        this.zzei.put(serviceConnection, serviceConnection2);
    }

    public final void zza(ServiceConnection serviceConnection, String str) {
        ConnectionTracker unused = this.zzel.zzeo;
        Context unused2 = this.zzel.zzen;
        this.zzei.remove(serviceConnection);
    }

    public final boolean isBound() {
        return this.zzej;
    }

    public final int getState() {
        return this.mState;
    }

    public final boolean zza(ServiceConnection serviceConnection) {
        return this.zzei.containsKey(serviceConnection);
    }

    public final boolean zzr() {
        return this.zzei.isEmpty();
    }

    public final IBinder getBinder() {
        return this.zzdk;
    }

    public final ComponentName getComponentName() {
        return this.mComponentName;
    }
}
