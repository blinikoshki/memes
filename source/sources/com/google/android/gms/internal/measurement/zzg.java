package com.google.android.gms.internal.measurement;

import android.app.job.JobScheduler;
import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
public final class zzg {
    private static final Method zzb;
    private static final Method zzc;
    private final JobScheduler zza;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    static {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 6
            r2 = 0
            r3 = 24
            java.lang.String r4 = "JobSchedulerCompat"
            r5 = 0
            if (r0 < r3) goto L_0x0036
            r0 = 4
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ NoSuchMethodException -> 0x002a }
            java.lang.Class<android.app.job.JobInfo> r6 = android.app.job.JobInfo.class
            r0[r2] = r6     // Catch:{ NoSuchMethodException -> 0x002a }
            r6 = 1
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r0[r6] = r7     // Catch:{ NoSuchMethodException -> 0x002a }
            r6 = 2
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x002a }
            r0[r6] = r7     // Catch:{ NoSuchMethodException -> 0x002a }
            r6 = 3
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r0[r6] = r7     // Catch:{ NoSuchMethodException -> 0x002a }
            java.lang.Class<android.app.job.JobScheduler> r6 = android.app.job.JobScheduler.class
            java.lang.String r7 = "scheduleAsPackage"
            java.lang.reflect.Method r0 = r6.getDeclaredMethod(r7, r0)     // Catch:{ NoSuchMethodException -> 0x002a }
            goto L_0x0037
        L_0x002a:
            boolean r0 = android.util.Log.isLoggable(r4, r1)
            if (r0 == 0) goto L_0x0036
            java.lang.String r0 = "No scheduleAsPackage method available, falling back to schedule"
            android.util.Log.e(r4, r0)
        L_0x0036:
            r0 = r5
        L_0x0037:
            zzb = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r3) goto L_0x0054
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            java.lang.String r3 = "myUserId"
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x0048 }
            java.lang.reflect.Method r5 = r0.getDeclaredMethod(r3, r2)     // Catch:{ NoSuchMethodException -> 0x0048 }
            goto L_0x0054
        L_0x0048:
            boolean r0 = android.util.Log.isLoggable(r4, r1)
            if (r0 == 0) goto L_0x0054
            java.lang.String r0 = "No myUserId method available"
            android.util.Log.e(r4, r0)
        L_0x0054:
            zzc = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzg.<clinit>():void");
    }

    public zzg(JobScheduler jobScheduler) {
        this.zza = jobScheduler;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004d A[SYNTHETIC, Splitter:B:18:0x004d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(android.content.Context r6, android.app.job.JobInfo r7, java.lang.String r8, java.lang.String r9) {
        /*
            java.lang.String r8 = "jobscheduler"
            java.lang.Object r8 = r6.getSystemService(r8)
            android.app.job.JobScheduler r8 = (android.app.job.JobScheduler) r8
            java.util.Objects.requireNonNull(r8)
            java.lang.reflect.Method r9 = zzb
            if (r9 == 0) goto L_0x007d
            java.lang.String r9 = "android.permission.UPDATE_DEVICE_STATS"
            int r6 = r6.checkSelfPermission(r9)
            if (r6 == 0) goto L_0x0018
            goto L_0x007d
        L_0x0018:
            com.google.android.gms.internal.measurement.zzg r6 = new com.google.android.gms.internal.measurement.zzg
            r6.<init>(r8)
            java.lang.reflect.Method r8 = zzc
            r9 = 0
            if (r8 == 0) goto L_0x0044
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            java.lang.Object[] r1 = new java.lang.Object[r9]     // Catch:{ IllegalAccessException -> 0x0035, InvocationTargetException -> 0x0033 }
            java.lang.Object r8 = r8.invoke(r0, r1)     // Catch:{ IllegalAccessException -> 0x0035, InvocationTargetException -> 0x0033 }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ IllegalAccessException -> 0x0035, InvocationTargetException -> 0x0033 }
            if (r8 == 0) goto L_0x0044
            int r8 = r8.intValue()     // Catch:{ IllegalAccessException -> 0x0035, InvocationTargetException -> 0x0033 }
            goto L_0x0045
        L_0x0033:
            r8 = move-exception
            goto L_0x0036
        L_0x0035:
            r8 = move-exception
        L_0x0036:
            r0 = 6
            java.lang.String r1 = "JobSchedulerCompat"
            boolean r0 = android.util.Log.isLoggable(r1, r0)
            if (r0 == 0) goto L_0x0044
            java.lang.String r0 = "myUserId invocation illegal"
            android.util.Log.e(r1, r0, r8)
        L_0x0044:
            r8 = 0
        L_0x0045:
            java.lang.String r0 = "com.google.android.gms"
            java.lang.String r1 = "UploadAlarm"
            java.lang.reflect.Method r2 = zzb
            if (r2 == 0) goto L_0x0076
            android.app.job.JobScheduler r3 = r6.zza     // Catch:{ IllegalAccessException -> 0x0070, InvocationTargetException -> 0x006e }
            r4 = 4
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ IllegalAccessException -> 0x0070, InvocationTargetException -> 0x006e }
            r4[r9] = r7     // Catch:{ IllegalAccessException -> 0x0070, InvocationTargetException -> 0x006e }
            r5 = 1
            r4[r5] = r0     // Catch:{ IllegalAccessException -> 0x0070, InvocationTargetException -> 0x006e }
            r0 = 2
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ IllegalAccessException -> 0x0070, InvocationTargetException -> 0x006e }
            r4[r0] = r8     // Catch:{ IllegalAccessException -> 0x0070, InvocationTargetException -> 0x006e }
            r8 = 3
            r4[r8] = r1     // Catch:{ IllegalAccessException -> 0x0070, InvocationTargetException -> 0x006e }
            java.lang.Object r8 = r2.invoke(r3, r4)     // Catch:{ IllegalAccessException -> 0x0070, InvocationTargetException -> 0x006e }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ IllegalAccessException -> 0x0070, InvocationTargetException -> 0x006e }
            if (r8 == 0) goto L_0x007c
            int r9 = r8.intValue()     // Catch:{ IllegalAccessException -> 0x0070, InvocationTargetException -> 0x006e }
            goto L_0x007c
        L_0x006e:
            r8 = move-exception
            goto L_0x0071
        L_0x0070:
            r8 = move-exception
        L_0x0071:
            java.lang.String r9 = "error calling scheduleAsPackage"
            android.util.Log.e(r1, r9, r8)
        L_0x0076:
            android.app.job.JobScheduler r6 = r6.zza
            int r9 = r6.schedule(r7)
        L_0x007c:
            return r9
        L_0x007d:
            int r6 = r8.schedule(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzg.zza(android.content.Context, android.app.job.JobInfo, java.lang.String, java.lang.String):int");
    }
}
