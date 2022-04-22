package com.appsflyer;

import com.appsflyer.internal.model.event.BackgroundEvent;
import java.net.HttpURLConnection;

public class BackgroundHttpTask {
    private final BackgroundEvent $$a;

    public BackgroundHttpTask(BackgroundEvent backgroundEvent) {
        this.$$a = backgroundEvent;
    }

    public void execute() {
        new Thread(new Runnable() {
            public final void run() {
                HttpURLConnection doInBackground = BackgroundHttpTask.this.doInBackground();
                if (doInBackground != null) {
                    doInBackground.disconnect();
                }
            }
        }).start();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0191  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.net.HttpURLConnection doInBackground() {
        /*
            r19 = this;
            r1 = r19
            java.lang.String r0 = "AFDateFormat"
            java.lang.String r2 = ""
            com.appsflyer.internal.model.event.BackgroundEvent r3 = r1.$$a
            java.lang.String r3 = r3.urlString()
            com.appsflyer.internal.model.event.BackgroundEvent r4 = r1.$$a
            java.lang.String r4 = r4.body()
            com.appsflyer.internal.model.event.BackgroundEvent r5 = r1.$$a
            boolean r5 = r5.trackingStopped()
            com.appsflyer.internal.model.event.BackgroundEvent r6 = r1.$$a
            boolean r6 = r6.readResponse()
            com.appsflyer.internal.model.event.BackgroundEvent r7 = r1.$$a
            boolean r7 = r7.proxyMode()
            com.appsflyer.internal.model.event.BackgroundEvent r8 = r1.$$a
            boolean r8 = r8.isEncrypt()
            byte[] r9 = r4.getBytes()
            r10 = 0
            if (r5 == 0) goto L_0x0032
            return r10
        L_0x0032:
            r5 = 1
            r11 = 0
            java.net.URL r12 = new java.net.URL     // Catch:{ all -> 0x0175 }
            r12.<init>(r3)     // Catch:{ all -> 0x0175 }
            if (r7 == 0) goto L_0x0087
            com.appsflyer.internal.ac r13 = com.appsflyer.internal.C1048ac.AFDateFormat()     // Catch:{ all -> 0x0083 }
            java.lang.String r14 = r12.toString()     // Catch:{ all -> 0x0083 }
            java.lang.String r15 = "server_request"
            java.lang.String[] r10 = new java.lang.String[r5]     // Catch:{ all -> 0x0083 }
            r10[r11] = r4     // Catch:{ all -> 0x0083 }
            r13.AFDateFormat(r15, r14, r10)     // Catch:{ all -> 0x0083 }
            java.lang.String r10 = "UTF-8"
            byte[] r10 = r4.getBytes(r10)     // Catch:{ all -> 0x0083 }
            int r10 = r10.length     // Catch:{ all -> 0x0083 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0083 }
            java.lang.String r14 = "call = "
            r13.<init>(r14)     // Catch:{ all -> 0x0083 }
            r13.append(r12)     // Catch:{ all -> 0x0083 }
            java.lang.String r14 = "; size = "
            r13.append(r14)     // Catch:{ all -> 0x0083 }
            r13.append(r10)     // Catch:{ all -> 0x0083 }
            java.lang.String r14 = " byte"
            r13.append(r14)     // Catch:{ all -> 0x0083 }
            if (r10 <= r5) goto L_0x006f
            java.lang.String r10 = "s"
            goto L_0x0070
        L_0x006f:
            r10 = r2
        L_0x0070:
            r13.append(r10)     // Catch:{ all -> 0x0083 }
            java.lang.String r10 = "; body = "
            r13.append(r10)     // Catch:{ all -> 0x0083 }
            r13.append(r4)     // Catch:{ all -> 0x0083 }
            java.lang.String r4 = r13.toString()     // Catch:{ all -> 0x0083 }
            com.appsflyer.internal.C1084w.valueOf(r4)     // Catch:{ all -> 0x0083 }
            goto L_0x0087
        L_0x0083:
            r0 = move-exception
            r10 = 0
            goto L_0x0177
        L_0x0087:
            java.lang.String r4 = "AppsFlyer"
            int r4 = r4.hashCode()     // Catch:{ all -> 0x0171 }
            android.net.TrafficStats.setThreadStatsTag(r4)     // Catch:{ all -> 0x0171 }
            java.net.URLConnection r4 = r12.openConnection()     // Catch:{ all -> 0x0171 }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ all -> 0x0171 }
            r10 = 30000(0x7530, float:4.2039E-41)
            r4.setReadTimeout(r10)     // Catch:{ all -> 0x016e }
            r4.setConnectTimeout(r10)     // Catch:{ all -> 0x016e }
            java.lang.String r10 = "POST"
            r4.setRequestMethod(r10)     // Catch:{ all -> 0x016e }
            r4.setDoInput(r5)     // Catch:{ all -> 0x016e }
            r4.setDoOutput(r5)     // Catch:{ all -> 0x016e }
            java.lang.String r10 = "Content-Type"
            if (r8 == 0) goto L_0x00b0
            java.lang.String r13 = "application/octet-stream"
            goto L_0x00b2
        L_0x00b0:
            java.lang.String r13 = "application/json"
        L_0x00b2:
            r4.setRequestProperty(r10, r13)     // Catch:{ all -> 0x016e }
            java.io.OutputStream r10 = r4.getOutputStream()     // Catch:{ all -> 0x016e }
            if (r8 == 0) goto L_0x0132
            com.appsflyer.internal.model.event.BackgroundEvent r8 = r1.$$a     // Catch:{ all -> 0x016e }
            java.lang.String r8 = r8.key()     // Catch:{ all -> 0x016e }
            java.lang.Object[] r13 = new java.lang.Object[r5]     // Catch:{ all -> 0x0129 }
            r13[r11] = r8     // Catch:{ all -> 0x0129 }
            int r8 = android.view.View.resolveSize(r11, r11)     // Catch:{ all -> 0x0129 }
            char r8 = (char) r8     // Catch:{ all -> 0x0129 }
            long r14 = android.widget.ExpandableListView.getPackedPositionForGroup(r11)     // Catch:{ all -> 0x0129 }
            r16 = 0
            int r18 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            int r14 = r18 + 24
            int r15 = android.widget.ExpandableListView.getPackedPositionChild(r16)     // Catch:{ all -> 0x0129 }
            int r15 = 23 - r15
            java.lang.Object r8 = com.appsflyer.internal.C1053b.$$b(r8, r14, r15)     // Catch:{ all -> 0x0129 }
            java.lang.Class r8 = (java.lang.Class) r8     // Catch:{ all -> 0x0129 }
            java.lang.Class[] r14 = new java.lang.Class[r5]     // Catch:{ all -> 0x0129 }
            java.lang.Class<java.lang.String> r15 = java.lang.String.class
            r14[r11] = r15     // Catch:{ all -> 0x0129 }
            java.lang.reflect.Method r8 = r8.getMethod(r0, r14)     // Catch:{ all -> 0x0129 }
            r14 = 0
            java.lang.Object r8 = r8.invoke(r14, r13)     // Catch:{ all -> 0x0129 }
            java.lang.Object[] r13 = new java.lang.Object[r5]     // Catch:{ all -> 0x0120 }
            r13[r11] = r9     // Catch:{ all -> 0x0120 }
            r9 = 48
            int r14 = android.text.TextUtils.indexOf(r2, r9, r11)     // Catch:{ all -> 0x0120 }
            int r14 = -1 - r14
            char r14 = (char) r14     // Catch:{ all -> 0x0120 }
            int r15 = android.widget.ExpandableListView.getPackedPositionChild(r16)     // Catch:{ all -> 0x0120 }
            int r15 = 23 - r15
            int r9 = android.text.TextUtils.lastIndexOf(r2, r9)     // Catch:{ all -> 0x0120 }
            int r9 = r9 + 25
            java.lang.Object r9 = com.appsflyer.internal.C1053b.$$b(r14, r15, r9)     // Catch:{ all -> 0x0120 }
            java.lang.Class r9 = (java.lang.Class) r9     // Catch:{ all -> 0x0120 }
            java.lang.Class[] r14 = new java.lang.Class[r5]     // Catch:{ all -> 0x0120 }
            java.lang.Class<byte[]> r15 = byte[].class
            r14[r11] = r15     // Catch:{ all -> 0x0120 }
            java.lang.reflect.Method r0 = r9.getMethod(r0, r14)     // Catch:{ all -> 0x0120 }
            java.lang.Object r0 = r0.invoke(r8, r13)     // Catch:{ all -> 0x0120 }
            r9 = r0
            byte[] r9 = (byte[]) r9     // Catch:{ all -> 0x0120 }
            goto L_0x0132
        L_0x0120:
            r0 = move-exception
            java.lang.Throwable r6 = r0.getCause()     // Catch:{ all -> 0x016e }
            if (r6 == 0) goto L_0x0128
            throw r6     // Catch:{ all -> 0x016e }
        L_0x0128:
            throw r0     // Catch:{ all -> 0x016e }
        L_0x0129:
            r0 = move-exception
            java.lang.Throwable r6 = r0.getCause()     // Catch:{ all -> 0x016e }
            if (r6 == 0) goto L_0x0131
            throw r6     // Catch:{ all -> 0x016e }
        L_0x0131:
            throw r0     // Catch:{ all -> 0x016e }
        L_0x0132:
            r10.write(r9)     // Catch:{ all -> 0x016e }
            r10.close()     // Catch:{ all -> 0x016e }
            r4.connect()     // Catch:{ all -> 0x016e }
            int r0 = r4.getResponseCode()     // Catch:{ all -> 0x016e }
            if (r6 == 0) goto L_0x0149
            com.appsflyer.AppsFlyerLibCore r6 = com.appsflyer.AppsFlyerLibCore.getInstance()     // Catch:{ all -> 0x016e }
            java.lang.String r2 = r6.readServerResponse(r4)     // Catch:{ all -> 0x016e }
        L_0x0149:
            if (r7 == 0) goto L_0x0163
            com.appsflyer.internal.ac r6 = com.appsflyer.internal.C1048ac.AFDateFormat()     // Catch:{ all -> 0x016e }
            java.lang.String r7 = r12.toString()     // Catch:{ all -> 0x016e }
            java.lang.String r8 = "server_response"
            r9 = 2
            java.lang.String[] r9 = new java.lang.String[r9]     // Catch:{ all -> 0x016e }
            java.lang.String r10 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x016e }
            r9[r11] = r10     // Catch:{ all -> 0x016e }
            r9[r5] = r2     // Catch:{ all -> 0x016e }
            r6.AFDateFormat(r8, r7, r9)     // Catch:{ all -> 0x016e }
        L_0x0163:
            r6 = 200(0xc8, float:2.8E-43)
            if (r0 != r6) goto L_0x0185
            java.lang.String r0 = "Status 200 ok"
            com.appsflyer.AFLogger.afInfoLog(r0)     // Catch:{ all -> 0x016e }
            r5 = 0
            goto L_0x0185
        L_0x016e:
            r0 = move-exception
            r10 = r4
            goto L_0x0177
        L_0x0171:
            r0 = move-exception
            r14 = 0
            r10 = r14
            goto L_0x0177
        L_0x0175:
            r0 = move-exception
            r14 = r10
        L_0x0177:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "Error while calling "
            java.lang.String r3 = r4.concat(r3)
            com.appsflyer.AFLogger.afErrorLog(r3, r0)
            r4 = r10
        L_0x0185:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "Connection "
            r0.<init>(r3)
            if (r5 == 0) goto L_0x0191
            java.lang.String r3 = "error"
            goto L_0x0193
        L_0x0191:
            java.lang.String r3 = "call succeeded"
        L_0x0193:
            r0.append(r3)
            java.lang.String r3 = ": "
            r0.append(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afInfoLog(r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.BackgroundHttpTask.doInBackground():java.net.HttpURLConnection");
    }
}
