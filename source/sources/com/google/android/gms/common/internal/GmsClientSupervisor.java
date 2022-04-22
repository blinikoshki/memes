package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public abstract class GmsClientSupervisor {
    private static int zzef = 129;
    private static final Object zzeg = new Object();
    private static GmsClientSupervisor zzeh;

    /* access modifiers changed from: protected */
    public abstract boolean zza(zza zza2, ServiceConnection serviceConnection, String str);

    /* access modifiers changed from: protected */
    public abstract void zzb(zza zza2, ServiceConnection serviceConnection, String str);

    /* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
    protected static final class zza {
        private static final Uri zzee = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();
        private final ComponentName componentName;
        private final String packageName;
        private final String zzeb;
        private final int zzec;
        private final boolean zzed;

        public zza(String str, int i) {
            this(str, "com.google.android.gms", i);
        }

        private zza(String str, String str2, int i) {
            this(str, str2, i, false);
        }

        public zza(String str, String str2, int i, boolean z) {
            this.zzeb = Preconditions.checkNotEmpty(str);
            this.packageName = Preconditions.checkNotEmpty(str2);
            this.componentName = null;
            this.zzec = i;
            this.zzed = z;
        }

        public zza(ComponentName componentName2, int i) {
            this.zzeb = null;
            this.packageName = null;
            this.componentName = (ComponentName) Preconditions.checkNotNull(componentName2);
            this.zzec = i;
            this.zzed = false;
        }

        public final String toString() {
            String str = this.zzeb;
            if (str != null) {
                return str;
            }
            Preconditions.checkNotNull(this.componentName);
            return this.componentName.flattenToString();
        }

        public final String getPackage() {
            return this.packageName;
        }

        public final ComponentName getComponentName() {
            return this.componentName;
        }

        public final int zzq() {
            return this.zzec;
        }

        public final Intent zzb(Context context) {
            if (this.zzeb == null) {
                return new Intent().setComponent(this.componentName);
            }
            Intent zzc = this.zzed ? zzc(context) : null;
            if (zzc == null) {
                return new Intent(this.zzeb).setPackage(this.packageName);
            }
            return zzc;
        }

        /* JADX WARNING: type inference failed for: r6v6, types: [android.os.Parcelable] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final android.content.Intent zzc(android.content.Context r6) {
            /*
                r5 = this;
                java.lang.String r0 = "ConnectionStatusConfig"
                android.os.Bundle r1 = new android.os.Bundle
                r1.<init>()
                java.lang.String r2 = r5.zzeb
                java.lang.String r3 = "serviceActionBundleKey"
                r1.putString(r3, r2)
                r2 = 0
                android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ IllegalArgumentException -> 0x001c }
                android.net.Uri r3 = zzee     // Catch:{ IllegalArgumentException -> 0x001c }
                java.lang.String r4 = "serviceIntentCall"
                android.os.Bundle r6 = r6.call(r3, r4, r2, r1)     // Catch:{ IllegalArgumentException -> 0x001c }
                goto L_0x0040
            L_0x001c:
                r6 = move-exception
                java.lang.String r6 = java.lang.String.valueOf(r6)
                java.lang.String r1 = java.lang.String.valueOf(r6)
                int r1 = r1.length()
                int r1 = r1 + 34
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>(r1)
                java.lang.String r1 = "Dynamic intent resolution failed: "
                r3.append(r1)
                r3.append(r6)
                java.lang.String r6 = r3.toString()
                android.util.Log.w(r0, r6)
                r6 = r2
            L_0x0040:
                if (r6 != 0) goto L_0x0043
                goto L_0x004c
            L_0x0043:
                java.lang.String r1 = "serviceResponseIntentKey"
                android.os.Parcelable r6 = r6.getParcelable(r1)
                r2 = r6
                android.content.Intent r2 = (android.content.Intent) r2
            L_0x004c:
                if (r2 != 0) goto L_0x006a
                java.lang.String r6 = "Dynamic lookup for intent failed for action: "
                java.lang.String r1 = r5.zzeb
                java.lang.String r1 = java.lang.String.valueOf(r1)
                int r3 = r1.length()
                if (r3 == 0) goto L_0x0061
                java.lang.String r6 = r6.concat(r1)
                goto L_0x0067
            L_0x0061:
                java.lang.String r1 = new java.lang.String
                r1.<init>(r6)
                r6 = r1
            L_0x0067:
                android.util.Log.w(r0, r6)
            L_0x006a:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.GmsClientSupervisor.zza.zzc(android.content.Context):android.content.Intent");
        }

        public final int hashCode() {
            return Objects.hashCode(this.zzeb, this.packageName, this.componentName, Integer.valueOf(this.zzec), Boolean.valueOf(this.zzed));
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            return Objects.equal(this.zzeb, zza.zzeb) && Objects.equal(this.packageName, zza.packageName) && Objects.equal(this.componentName, zza.componentName) && this.zzec == zza.zzec && this.zzed == zza.zzed;
        }
    }

    public static int getDefaultBindFlags() {
        return zzef;
    }

    public static GmsClientSupervisor getInstance(Context context) {
        synchronized (zzeg) {
            if (zzeh == null) {
                zzeh = new zzf(context.getApplicationContext());
            }
        }
        return zzeh;
    }

    public boolean bindService(String str, ServiceConnection serviceConnection, String str2) {
        return zza(new zza(str, getDefaultBindFlags()), serviceConnection, str2);
    }

    public boolean bindService(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return zza(new zza(componentName, getDefaultBindFlags()), serviceConnection, str);
    }

    public void unbindService(String str, ServiceConnection serviceConnection, String str2) {
        zzb(new zza(str, getDefaultBindFlags()), serviceConnection, str2);
    }

    public final void zza(String str, String str2, int i, ServiceConnection serviceConnection, String str3, boolean z) {
        zzb(new zza(str, str2, i, z), serviceConnection, str3);
    }

    public void unbindService(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        zzb(new zza(componentName, getDefaultBindFlags()), serviceConnection, str);
    }
}
