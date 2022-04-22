package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.common.zzi;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
final class zzf extends GmsClientSupervisor implements Handler.Callback {
    /* access modifiers changed from: private */
    public final Handler handler;
    /* access modifiers changed from: private */
    public final HashMap<GmsClientSupervisor.zza, zze> zzem = new HashMap<>();
    /* access modifiers changed from: private */
    public final Context zzen;
    /* access modifiers changed from: private */
    public final ConnectionTracker zzeo;
    private final long zzep;
    /* access modifiers changed from: private */
    public final long zzeq;

    zzf(Context context) {
        this.zzen = context.getApplicationContext();
        this.handler = new zzi(context.getMainLooper(), this);
        this.zzeo = ConnectionTracker.getInstance();
        this.zzep = 5000;
        this.zzeq = 300000;
    }

    /* access modifiers changed from: protected */
    public final boolean zza(GmsClientSupervisor.zza zza, ServiceConnection serviceConnection, String str) {
        boolean isBound;
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzem) {
            zze zze = this.zzem.get(zza);
            if (zze == null) {
                zze = new zze(this, zza);
                zze.zza(serviceConnection, serviceConnection, str);
                zze.zze(str);
                this.zzem.put(zza, zze);
            } else {
                this.handler.removeMessages(0, zza);
                if (!zze.zza(serviceConnection)) {
                    zze.zza(serviceConnection, serviceConnection, str);
                    int state = zze.getState();
                    if (state == 1) {
                        serviceConnection.onServiceConnected(zze.getComponentName(), zze.getBinder());
                    } else if (state == 2) {
                        zze.zze(str);
                    }
                } else {
                    String valueOf = String.valueOf(zza);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            }
            isBound = zze.isBound();
        }
        return isBound;
    }

    /* access modifiers changed from: protected */
    public final void zzb(GmsClientSupervisor.zza zza, ServiceConnection serviceConnection, String str) {
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzem) {
            zze zze = this.zzem.get(zza);
            if (zze == null) {
                String valueOf = String.valueOf(zza);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            } else if (zze.zza(serviceConnection)) {
                zze.zza(serviceConnection, str);
                if (zze.zzr()) {
                    this.handler.sendMessageDelayed(this.handler.obtainMessage(0, zza), this.zzep);
                }
            } else {
                String valueOf2 = String.valueOf(zza);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.zzem) {
                GmsClientSupervisor.zza zza = (GmsClientSupervisor.zza) message.obj;
                zze zze = this.zzem.get(zza);
                if (zze != null && zze.zzr()) {
                    if (zze.isBound()) {
                        zze.zzf("GmsClientSupervisor");
                    }
                    this.zzem.remove(zza);
                }
            }
            return true;
        } else if (i != 1) {
            return false;
        } else {
            synchronized (this.zzem) {
                GmsClientSupervisor.zza zza2 = (GmsClientSupervisor.zza) message.obj;
                zze zze2 = this.zzem.get(zza2);
                if (zze2 != null && zze2.getState() == 3) {
                    String valueOf = String.valueOf(zza2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Timeout waiting for ServiceConnection callback ");
                    sb.append(valueOf);
                    Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                    ComponentName componentName = zze2.getComponentName();
                    if (componentName == null) {
                        componentName = zza2.getComponentName();
                    }
                    if (componentName == null) {
                        componentName = new ComponentName(zza2.getPackage(), "unknown");
                    }
                    zze2.onServiceDisconnected(componentName);
                }
            }
            return true;
        }
    }
}
