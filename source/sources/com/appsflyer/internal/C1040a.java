package com.appsflyer.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.hardware.SensorManager;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.PhoneNumberUtils;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.Base64;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.ExpandableListView;
import com.appsflyer.AFLogger;
import com.appsflyer.HashUtils;
import com.google.common.base.Ascii;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;

/* renamed from: com.appsflyer.internal.a */
public final class C1040a {
    private static int $$a = 30;
    private static char $$b = '晵';
    private static char AFDateFormat = '쮈';
    private static int AFDeepLinkManager = 1;
    private static int dateFormatUTC = 0;
    private static char valueOf = 'ﾻ';
    private static char values = '뭭';

    C1040a() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x02b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String AFDateFormat(android.content.Context r21, long r22) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            long r3 = android.os.SystemClock.currentThreadTimeMillis()
            r5 = -1
            r7 = 48
            r8 = 0
            java.lang.String r9 = ""
            r10 = 1
            r11 = 0
            java.lang.String r12 = "\u0000\u000f￉￿\u0004\n\r￿\t￼\r\u0000\u0002￼\t￼￨\u0014\t\n\u0003\u000b\u0000\u0007\u0000￯￉\u0014\t\n\u0003\u000b\u0000\u0007"
            int r13 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            int r3 = 132 - r13
            float r4 = android.media.AudioTrack.getMaxVolume()
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            int r4 = 11 - r4
            boolean r5 = android.view.WindowManager.LayoutParams.mayUseInputMethod(r11)
            int r6 = android.text.TextUtils.indexOf(r9, r7)
            int r6 = r6 + 35
            java.lang.String r3 = $$a(r3, r12, r4, r5, r6)
            java.lang.String r3 = r3.intern()
            boolean r3 = valueOf((java.lang.String) r3)
            if (r3 == 0) goto L_0x0044
            r3 = 0
            goto L_0x0045
        L_0x0044:
            r3 = 1
        L_0x0045:
            java.lang.String r4 = "\u0000"
            java.lang.String r5 = "ꉫ碾"
            if (r3 == 0) goto L_0x0068
            float r3 = android.media.AudioTrack.getMinVolume()
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            int r3 = r3 + 78
            int r6 = android.view.View.getDefaultSize(r11, r11)
            int r6 = r6 + r10
            boolean r12 = android.telephony.PhoneNumberUtils.isNonSeparator(r7)
            int r13 = android.text.AndroidCharacter.getEastAsianWidth(r7)
            int r13 = 5 - r13
            java.lang.String r3 = $$a(r3, r4, r6, r12, r13)
            goto L_0x006c
        L_0x0068:
            java.lang.String r3 = $$b(r5)
        L_0x006c:
            java.lang.String r3 = r3.intern()
            r1.append(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = r21.getPackageName()
            java.lang.String r12 = AFDateFormat((java.lang.String) r6)
            java.lang.String r13 = $$b(r5)
            java.lang.String r13 = r13.intern()
            r1.append(r13)
            r3.append(r12)
            java.lang.String r12 = AFDateFormat((android.content.Context) r21)
            if (r12 != 0) goto L_0x00ba
            float r12 = android.util.TypedValue.complexToFloat(r11)
            int r12 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            int r12 = 78 - r12
            float r13 = android.view.ViewConfiguration.getScrollFriction()
            int r13 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            boolean r14 = android.telephony.PhoneNumberUtils.isReallyDialable(r7)
            int r15 = android.graphics.drawable.Drawable.resolveOpacity(r11, r11)
            int r15 = r15 + r10
            java.lang.String r12 = $$a(r12, r4, r13, r14, r15)
            java.lang.String r12 = r12.intern()
            r1.append(r12)
            r3.append(r6)
            goto L_0x00c8
        L_0x00ba:
            java.lang.String r12 = $$b(r5)
            java.lang.String r12 = r12.intern()
            r1.append(r12)
            r3.append(r6)
        L_0x00c8:
            java.lang.String r12 = valueOf((android.content.Context) r21)
            if (r12 != 0) goto L_0x00d0
            r13 = 0
            goto L_0x00d1
        L_0x00d0:
            r13 = 1
        L_0x00d1:
            r14 = 2
            r15 = 0
            if (r13 == 0) goto L_0x00e7
            java.lang.String r13 = $$b(r5)
            java.lang.String r13 = r13.intern()
            r1.append(r13)
            r3.append(r12)
        L_0x00e4:
            r7 = r21
            goto L_0x0118
        L_0x00e7:
            int r12 = dateFormatUTC
            int r12 = r12 + 99
            int r13 = r12 % 128
            AFDeepLinkManager = r13
            int r12 = r12 % r14
            int r12 = android.text.TextUtils.indexOf(r9, r9, r11, r11)
            int r12 = 78 - r12
            float r13 = android.view.ViewConfiguration.getScrollFriction()
            int r13 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            boolean r17 = android.view.Gravity.isVertical(r11)
            r8 = r17 ^ 1
            long r18 = android.widget.ExpandableListView.getPackedPositionForChild(r11, r11)
            int r7 = (r18 > r15 ? 1 : (r18 == r15 ? 0 : -1))
            int r7 = -r7
            java.lang.String r7 = $$a(r12, r4, r13, r8, r7)
            java.lang.String r7 = r7.intern()
            r1.append(r7)
            r3.append(r6)
            goto L_0x00e4
        L_0x0118:
            java.lang.String r6 = $$b(r7, r6)
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            r0.append(r3)
            android.content.pm.PackageManager r3 = r21.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0315 }
            java.lang.String r6 = r21.getPackageName()     // Catch:{ NameNotFoundException -> 0x0315 }
            android.content.pm.PackageInfo r3 = r3.getPackageInfo(r6, r11)     // Catch:{ NameNotFoundException -> 0x0315 }
            long r6 = r3.firstInstallTime     // Catch:{ NameNotFoundException -> 0x0315 }
            int r3 = android.view.ViewConfiguration.getPressedStateDuration()     // Catch:{ NameNotFoundException -> 0x0315 }
            r8 = 16
            int r3 = r3 >> r8
            int r3 = 124 - r3
            java.lang.String r12 = "￼\u0015\u0015\u000f\u000f￪￪\u0001\u0006\u0006ￏ￯￯ￏ\u001b\u001b\u001b\u001b"
            int r13 = android.text.TextUtils.getOffsetBefore(r9, r11)     // Catch:{ NameNotFoundException -> 0x0315 }
            int r13 = r13 + 18
            java.lang.String r18 = "file://"
            boolean r10 = android.webkit.URLUtil.isFileUrl(r18)     // Catch:{ NameNotFoundException -> 0x0315 }
            int r18 = android.view.ViewConfiguration.getFadingEdgeLength()     // Catch:{ NameNotFoundException -> 0x0315 }
            int r18 = r18 >> 16
            int r8 = 18 - r18
            java.lang.String r3 = $$a(r3, r12, r13, r10, r8)     // Catch:{ NameNotFoundException -> 0x0315 }
            java.lang.String r3 = r3.intern()     // Catch:{ NameNotFoundException -> 0x0315 }
            java.text.SimpleDateFormat r3 = com.appsflyer.AFDateFormat.getDataFormatter(r3)     // Catch:{ NameNotFoundException -> 0x0315 }
            java.util.Date r8 = new java.util.Date     // Catch:{ NameNotFoundException -> 0x0315 }
            r8.<init>(r6)     // Catch:{ NameNotFoundException -> 0x0315 }
            java.lang.String r3 = r3.format(r8)     // Catch:{ NameNotFoundException -> 0x0315 }
            r0.append(r3)     // Catch:{ NameNotFoundException -> 0x0315 }
            r6 = r22
            r0.append(r6)
            java.lang.String r3 = "薪楮㢮퀣듍僉竺?㡱ᭉ㏃ౕㇱ䥰삐鬶?౺螸瞟ࣉ堏龄愃?౺"
            java.lang.String r3 = $$b(r3)
            java.lang.String r3 = r3.intern()
            boolean r3 = valueOf((java.lang.String) r3)
            if (r3 == 0) goto L_0x0194
            int r3 = dateFormatUTC
            int r3 = r3 + 57
            int r8 = r3 % 128
            AFDeepLinkManager = r8
            int r3 = r3 % r14
            java.lang.String r3 = $$b(r5)
            java.lang.String r3 = r3.intern()
            goto L_0x01c0
        L_0x0194:
            long r12 = android.view.ViewConfiguration.getZoomControlsTimeout()
            int r3 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            int r3 = 79 - r3
            long r12 = android.os.SystemClock.uptimeMillis()
            int r8 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            boolean r10 = android.text.TextUtils.isDigitsOnly(r9)
            long r12 = android.widget.ExpandableListView.getPackedPositionForGroup(r11)
            int r18 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            r12 = 1
            int r13 = r18 + 1
            java.lang.String r3 = $$a(r3, r4, r8, r10, r13)
            java.lang.String r3 = r3.intern()
            int r8 = AFDeepLinkManager
            int r8 = r8 + 85
            int r10 = r8 % 128
            dateFormatUTC = r10
            int r8 = r8 % r14
        L_0x01c0:
            r2.append(r3)
            java.lang.String r3 = "댻诜㢮퀣듍僉竺?헚嚐?䨈笇?활癨㐨灡㬔歍઼ꪱ"
            java.lang.String r3 = $$b(r3)
            java.lang.String r3 = r3.intern()
            boolean r3 = valueOf((java.lang.String) r3)
            r8 = 0
            if (r3 == 0) goto L_0x01da
            java.lang.String r3 = $$b(r5)
            goto L_0x01f7
        L_0x01da:
            int r3 = android.text.TextUtils.getOffsetBefore(r9, r11)
            int r3 = 78 - r3
            int r10 = android.graphics.Color.argb(r11, r11, r11, r11)
            r12 = 1
            int r10 = r10 + r12
            boolean r13 = android.webkit.URLUtil.isCookielessProxyUrl(r8)
            r13 = r13 ^ r12
            int r18 = android.os.Process.myPid()
            int r18 = r18 >> 22
            int r11 = 1 - r18
            java.lang.String r3 = $$a(r3, r4, r10, r13, r11)
        L_0x01f7:
            java.lang.String r3 = r3.intern()
            r2.append(r3)
            java.lang.String r3 = "⭄㢮퀣듍僉竺?㡱ᭉ㏃ౕ좄鿿쮎羈ᾰ睛᝜⇥ꐸ㽭"
            java.lang.String r3 = $$b(r3)
            java.lang.String r3 = r3.intern()
            boolean r3 = valueOf((java.lang.String) r3)
            java.lang.String r10 = "http://"
            if (r3 == 0) goto L_0x0239
            int r3 = AFDeepLinkManager
            int r3 = r3 + 5
            int r11 = r3 % 128
            dateFormatUTC = r11
            int r3 = r3 % r14
            r11 = 10
            if (r3 == 0) goto L_0x0221
            r3 = 10
            goto L_0x0223
        L_0x0221:
            r3 = 72
        L_0x0223:
            if (r3 == r11) goto L_0x022a
            java.lang.String r3 = $$b(r5)
            goto L_0x025a
        L_0x022a:
            java.lang.String r3 = $$b(r5)
            java.lang.String r3 = r3.intern()
            super.hashCode()     // Catch:{ all -> 0x0236 }
            goto L_0x025e
        L_0x0236:
            r0 = move-exception
            r1 = r0
            throw r1
        L_0x0239:
            long r11 = android.view.ViewConfiguration.getZoomControlsTimeout()
            int r3 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            int r3 = r3 + 77
            int r8 = android.widget.ExpandableListView.getPackedPositionType(r15)
            r11 = 1
            int r8 = 1 - r8
            boolean r12 = android.webkit.URLUtil.isNetworkUrl(r10)
            r13 = 0
            int r18 = android.os.Process.getThreadPriority(r13)
            int r18 = r18 + 20
            int r13 = r18 >> 6
            int r13 = r13 + r11
            java.lang.String r3 = $$a(r3, r4, r8, r12, r13)
        L_0x025a:
            java.lang.String r3 = r3.intern()
        L_0x025e:
            r2.append(r3)
            int r3 = android.widget.ExpandableListView.getPackedPositionChild(r15)
            int r3 = r3 + 128
            r8 = 0
            int r11 = android.graphics.Color.green(r8)
            int r8 = 4 - r11
            boolean r11 = android.telephony.PhoneNumberUtils.compare(r9, r9)
            r12 = 1
            r11 = r11 ^ r12
            long r12 = android.view.ViewConfiguration.getZoomControlsTimeout()
            java.lang.String r14 = "\u0011\u0003\r\u0000\b\u0011￴ￍ\u0013\u0004\rￍ\u0003\b\u000e"
            int r20 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            r12 = 16
            int r13 = 16 - r20
            java.lang.String r3 = $$a(r3, r14, r8, r11, r13)
            java.lang.String r3 = r3.intern()
            boolean r3 = valueOf((java.lang.String) r3)
            if (r3 == 0) goto L_0x0291
            r3 = 1
            r12 = 1
            goto L_0x0293
        L_0x0291:
            r3 = 1
            r12 = 0
        L_0x0293:
            if (r12 == r3) goto L_0x02b8
            int r5 = android.widget.ExpandableListView.getPackedPositionChild(r15)
            int r5 = r5 + 79
            r8 = 48
            r11 = 0
            int r8 = android.text.TextUtils.lastIndexOf(r9, r8, r11, r11)
            int r8 = -r8
            boolean r9 = android.webkit.URLUtil.isHttpUrl(r10)
            r10 = 0
            float r11 = android.graphics.PointF.length(r10, r10)
            int r10 = (r11 > r10 ? 1 : (r11 == r10 ? 0 : -1))
            int r10 = r10 + r3
            java.lang.String r3 = $$a(r5, r4, r8, r9, r10)
        L_0x02b3:
            java.lang.String r3 = r3.intern()
            goto L_0x02bd
        L_0x02b8:
            java.lang.String r3 = $$b(r5)
            goto L_0x02b3
        L_0x02bd:
            r2.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = com.appsflyer.HashUtils.toSha256(r0)
            java.lang.String r0 = com.appsflyer.HashUtils.toMD5(r0)
            java.lang.String r1 = r1.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            r0 = 17
            r4 = 2
            int r1 = java.lang.Integer.parseInt(r1, r4)
            r5 = 16
            java.lang.String r1 = java.lang.Integer.toString(r1, r5)
            r8 = 0
            char r1 = r1.charAt(r8)
            r3.setCharAt(r0, r1)
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = r2.toString()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            r0 = 27
            int r1 = java.lang.Integer.parseInt(r1, r4)
            java.lang.String r1 = java.lang.Integer.toString(r1, r5)
            char r1 = r1.charAt(r8)
            r2.setCharAt(r0, r1)
            java.lang.String r0 = r2.toString()
            java.lang.Long r1 = java.lang.Long.valueOf(r22)
            java.lang.String r0 = $$a(r0, r1)
            return r0
        L_0x0315:
            java.lang.String r0 = "?㈥Ñ랪Ⰴ徾춷⢭膌쓂杝惰ྰ콮挃ټᗆ볱쑩ᇎ邊ᇎ邊縳걳㢛䇨铗⁩枖荫㤐푍"
            java.lang.String r0 = $$b(r0)
            java.lang.String r0 = r0.intern()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1040a.AFDateFormat(android.content.Context, long):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        if ((r12 != null ? 'Y' : 'X') != 'Y') goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
        if ((r12 != null) != false) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String $$a(java.lang.String r12, java.lang.Long r13) {
        /*
            int r0 = dateFormatUTC
            int r0 = r0 + 93
            int r1 = r0 % 128
            AFDeepLinkManager = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x0010
            r0 = 0
            goto L_0x0011
        L_0x0010:
            r0 = 1
        L_0x0011:
            if (r0 == r3) goto L_0x0024
            r0 = 0
            int r0 = r0.length     // Catch:{ all -> 0x0022 }
            r0 = 89
            if (r12 == 0) goto L_0x001c
            r4 = 89
            goto L_0x001e
        L_0x001c:
            r4 = 88
        L_0x001e:
            if (r4 == r0) goto L_0x002b
            goto L_0x0121
        L_0x0022:
            r12 = move-exception
            throw r12
        L_0x0024:
            if (r12 == 0) goto L_0x0028
            r0 = 1
            goto L_0x0029
        L_0x0028:
            r0 = 0
        L_0x0029:
            if (r0 == 0) goto L_0x0121
        L_0x002b:
            if (r13 == 0) goto L_0x0121
            int r0 = r12.length()
            r4 = 32
            if (r0 != r4) goto L_0x0121
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r12)
            java.lang.String r12 = r13.toString()
            r13 = 0
            r5 = 0
        L_0x0040:
            int r6 = r12.length()
            if (r13 >= r6) goto L_0x0048
            r6 = 0
            goto L_0x0049
        L_0x0048:
            r6 = 1
        L_0x0049:
            if (r6 == r3) goto L_0x0060
            int r6 = AFDeepLinkManager
            int r6 = r6 + 81
            int r7 = r6 % 128
            dateFormatUTC = r7
            int r6 = r6 % r1
            char r6 = r12.charAt(r13)
            int r6 = java.lang.Character.getNumericValue(r6)
            int r5 = r5 + r6
            int r13 = r13 + 1
            goto L_0x0040
        L_0x0060:
            java.lang.String r12 = java.lang.Integer.toHexString(r5)
            int r13 = r12.length()
            r5 = 7
            int r13 = r13 + r5
            r0.replace(r5, r13, r12)
            r12 = 0
            r6 = r12
            r5 = 0
        L_0x0071:
            int r8 = r0.length()
            r9 = 87
            if (r5 >= r8) goto L_0x007c
            r8 = 79
            goto L_0x007e
        L_0x007c:
            r8 = 87
        L_0x007e:
            if (r8 == r9) goto L_0x008d
            char r8 = r0.charAt(r5)
            int r8 = java.lang.Character.getNumericValue(r8)
            long r8 = (long) r8
            long r6 = r6 + r8
            int r5 = r5 + 1
            goto L_0x0071
        L_0x008d:
            r5 = 94
            r8 = 100
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x0098
            r10 = 94
            goto L_0x009a
        L_0x0098:
            r10 = 32
        L_0x009a:
            if (r10 == r5) goto L_0x010a
            int r4 = (int) r6
            r5 = 23
            r0.insert(r5, r4)
            r8 = 10
            r4 = 40
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 >= 0) goto L_0x00ac
            r6 = 2
            goto L_0x00ae
        L_0x00ac:
            r6 = 40
        L_0x00ae:
            if (r6 == r4) goto L_0x0105
            int r4 = dateFormatUTC
            int r4 = r4 + 31
            int r6 = r4 % 128
            AFDeepLinkManager = r6
            int r4 = r4 % r1
            java.lang.String r1 = "javascript:"
            java.lang.String r6 = "\u0000"
            if (r4 != 0) goto L_0x00e4
            r2 = 77
            int r4 = android.view.ViewConfiguration.getScrollBarFadeDuration()
            int r4 = r4 >>> 42
            int r4 = 86 - r4
            int r12 = android.widget.ExpandableListView.getPackedPositionChild(r12)
            int r12 = -r12
            boolean r13 = android.webkit.URLUtil.isJavaScriptUrl(r1)
            int r1 = android.graphics.Color.green(r3)
            int r1 = r3 >> r1
            java.lang.String r12 = $$a(r4, r6, r12, r13, r1)
            java.lang.String r12 = r12.intern()
            r0.insert(r2, r12)
            goto L_0x0105
        L_0x00e4:
            int r4 = android.view.ViewConfiguration.getScrollBarFadeDuration()
            int r4 = r4 >> 16
            int r4 = r4 + 78
            int r12 = android.widget.ExpandableListView.getPackedPositionChild(r12)
            int r12 = -r12
            boolean r13 = android.webkit.URLUtil.isJavaScriptUrl(r1)
            int r1 = android.graphics.Color.green(r2)
            int r3 = r3 - r1
            java.lang.String r12 = $$a(r4, r6, r12, r13, r3)
            java.lang.String r12 = r12.intern()
            r0.insert(r5, r12)
        L_0x0105:
            java.lang.String r12 = r0.toString()
            return r12
        L_0x010a:
            int r5 = dateFormatUTC
            int r10 = r5 + 85
            int r11 = r10 % 128
            AFDeepLinkManager = r11
            int r10 = r10 % r1
            if (r10 != 0) goto L_0x0117
            long r6 = r6 + r8
            goto L_0x0118
        L_0x0117:
            long r6 = r6 % r8
        L_0x0118:
            int r5 = r5 + 49
            int r8 = r5 % 128
            AFDeepLinkManager = r8
            int r5 = r5 % r1
            goto L_0x008d
        L_0x0121:
            java.lang.String r12 = "?㈥Ñ랪Ⰴ徾춷⢭膌쓂杝惰ྰ콮挃ټᗆ볱쑩ᇎ邊ᇎ邊縳걳㢛䇨铗⁩枖荫㤐푍"
            java.lang.String r12 = $$b(r12)
            java.lang.String r12 = r12.intern()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1040a.$$a(java.lang.String, java.lang.Long):java.lang.String");
    }

    private static boolean valueOf(String str) {
        int i = dateFormatUTC + 37;
        AFDeepLinkManager = i % 128;
        int i2 = i % 2;
        try {
            Class.forName(str);
            int i3 = AFDeepLinkManager + 63;
            dateFormatUTC = i3 % 128;
            int i4 = i3 % 2;
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static String AFDateFormat(String str) {
        if ((!str.contains($$a((ViewConfiguration.getScrollDefaultDelay() >> 16) + 76, "\u0000", PhoneNumberUtils.toaFromString("") + -128, URLUtil.isFileUrl("file://"), 1 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))).intern()) ? (char) 22 : 16) != 22) {
            String[] split = str.split($$a(99 - ((Process.getThreadPriority(0) + 20) >> 6), "￩\u0017", (KeyEvent.getMaxKeyCode() >> 16) + 2, !Gravity.isHorizontal(0), 1 - TextUtils.lastIndexOf("", '0')).intern());
            int length = split.length;
            StringBuilder sb = new StringBuilder();
            int i = length - 1;
            sb.append(split[i]);
            sb.append($$a((ExpandableListView.getPackedPositionForGroup(0) > 0 ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0 ? 0 : -1)) + 76, "\u0000", 1 - (ViewConfiguration.getScrollDefaultDelay() >> 16), URLUtil.isNetworkUrl("http://"), (ViewConfiguration.getPressedStateDuration() >> 16) + 1).intern());
            int i2 = 1;
            while (true) {
                if (i2 >= i) {
                    sb.append(split[0]);
                    return sb.toString();
                }
                int i3 = dateFormatUTC + 119;
                AFDeepLinkManager = i3 % 128;
                int i4 = i3 % 2;
                sb.append(split[i2]);
                sb.append($$a(76 - TextUtils.getTrimmedLength(""), "\u0000", ExpandableListView.getPackedPositionGroup(0) + 1, PhoneNumberUtils.isISODigit('0'), PhoneNumberUtils.toaFromString("") - 128).intern());
                i2++;
            }
        } else {
            int i5 = AFDeepLinkManager;
            int i6 = i5 + 89;
            dateFormatUTC = i6 % 128;
            int i7 = i6 % 2;
            int i8 = i5 + 23;
            dateFormatUTC = i8 % 128;
            int i9 = i8 % 2;
            return str;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
        if ((java.lang.System.getProperties().containsKey($$b("聝䨢ἆ玹䱨ꡣꡚ짠ᇬ蚭쨷ᒇ濲첵").intern())) != false) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
        if (r0 != false) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String AFDateFormat(android.content.Context r7) {
        /*
            int r0 = AFDeepLinkManager
            int r0 = r0 + 53
            int r1 = r0 % 128
            dateFormatUTC = r1
            int r0 = r0 % 2
            r1 = 32
            if (r0 == 0) goto L_0x0011
            r0 = 69
            goto L_0x0013
        L_0x0011:
            r0 = 32
        L_0x0013:
            r2 = 0
            java.lang.String r3 = "聝䨢ἆ玹䱨ꡣꡚ짠ᇬ蚭쨷ᒇ濲첵"
            r4 = 1
            r5 = 0
            if (r0 == r1) goto L_0x0033
            java.util.Properties r0 = java.lang.System.getProperties()
            java.lang.String r1 = $$b(r3)
            java.lang.String r1 = r1.intern()
            boolean r0 = r0.containsKey(r1)
            super.hashCode()     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x00bd
            goto L_0x004a
        L_0x0031:
            r7 = move-exception
            throw r7
        L_0x0033:
            java.util.Properties r0 = java.lang.System.getProperties()
            java.lang.String r1 = $$b(r3)
            java.lang.String r1 = r1.intern()
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x0047
            r0 = 1
            goto L_0x0048
        L_0x0047:
            r0 = 0
        L_0x0048:
            if (r0 == 0) goto L_0x00bd
        L_0x004a:
            java.io.File r7 = r7.getCacheDir()     // Catch:{ Exception -> 0x008c }
            java.lang.String r7 = r7.getPath()     // Catch:{ Exception -> 0x008c }
            java.lang.String r0 = "諼䊏읬姃耚嶔廖"
            java.lang.String r0 = $$b(r0)     // Catch:{ Exception -> 0x008c }
            java.lang.String r0 = r0.intern()     // Catch:{ Exception -> 0x008c }
            java.lang.String r1 = ""
            java.lang.String r7 = r7.replace(r0, r1)     // Catch:{ Exception -> 0x008c }
            java.lang.String r0 = "貘䯮㌪흢莒鬓挋ᢨﶺ嘟铢"
            java.lang.String r0 = $$b(r0)     // Catch:{ Exception -> 0x008c }
            java.lang.String r0 = r0.intern()     // Catch:{ Exception -> 0x008c }
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)     // Catch:{ Exception -> 0x008c }
            java.util.regex.Matcher r7 = r0.matcher(r7)     // Catch:{ Exception -> 0x008c }
            boolean r0 = r7.find()     // Catch:{ Exception -> 0x008c }
            if (r0 == 0) goto L_0x0081
            java.lang.String r7 = r7.group(r4)     // Catch:{ Exception -> 0x008c }
            r5 = r7
        L_0x0081:
            int r7 = AFDeepLinkManager
            int r7 = r7 + 19
            int r0 = r7 % 128
            dateFormatUTC = r0
            int r7 = r7 % 2
            goto L_0x00bd
        L_0x008c:
            r7 = move-exception
            com.appsflyer.internal.ac r0 = com.appsflyer.internal.C1048ac.AFDateFormat()
            java.lang.String r1 = "೺夦셷ន皇ׂ⟭掑鰽囃ឩ窱彑攢ख़頴珫"
            java.lang.String r1 = $$b(r1)
            java.lang.String r1 = r1.intern()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = "ﵝ龸₊鷲ꮭ屑쐞悧庮ῇ׽滅?↟眰툒࿽룸셷ន﮻⃑௮એ刄₯蜸⩼腐쑉ᆜ탄ឩ窱彑攢ख़頴珫罾翛"
            java.lang.String r6 = $$b(r6)
            java.lang.String r6 = r6.intern()
            r3.append(r6)
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            java.lang.String[] r3 = new java.lang.String[r4]
            r3[r2] = r7
            r0.AFDateFormat(r5, r1, r3)
        L_0x00bd:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1040a.AFDateFormat(android.content.Context):java.lang.String");
    }

    private static String valueOf(Context context) {
        PackageManager packageManager;
        String packageName;
        int i = dateFormatUTC + 51;
        AFDeepLinkManager = i % 128;
        if ((i % 2 == 0 ? 'c' : '?') != '?') {
            try {
                packageManager = context.getPackageManager();
                packageName = context.getPackageName();
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        } else {
            packageManager = context.getPackageManager();
            packageName = context.getPackageName();
        }
        String str = packageManager.getPackageInfo(packageName, 0).packageName;
        int i2 = dateFormatUTC + 93;
        AFDeepLinkManager = i2 % 128;
        int i3 = i2 % 2;
        return str;
    }

    private static String $$b(Context context, String str) {
        boolean z;
        int i = dateFormatUTC + 9;
        AFDeepLinkManager = i % 128;
        int i2 = i % 2;
        try {
            Iterator it = ((List) PackageManager.class.getDeclaredMethod($$a((ViewConfiguration.getZoomControlsTimeout() > 0 ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0 ? 0 : -1)) + 133, "\u0004\u0001￻￹\f\u0001\u0007\u0006\u000b￿�\f￡\u0006\u000b\f￹\u0004\u0004�￼￙\b\b", (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 9, !TextUtils.isDigitsOnly(""), PhoneNumberUtils.toaFromString("") - 105).intern(), new Class[]{Integer.TYPE}).invoke(context.getPackageManager(), new Object[]{0})).iterator();
            do {
                if ((it.hasNext() ? (char) 19 : 12) == 12) {
                    return Boolean.FALSE.toString();
                }
                int i3 = AFDeepLinkManager + 111;
                dateFormatUTC = i3 % 128;
                int i4 = i3 % 2;
                if (((ApplicationInfo) it.next()).packageName.equals(str)) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
            } while (!z);
            int i5 = AFDeepLinkManager + 95;
            dateFormatUTC = i5 % 128;
            int i6 = i5 % 2;
            return Boolean.TRUE.toString();
        } catch (IllegalAccessException e) {
            C1048ac AFDateFormat2 = C1048ac.AFDateFormat();
            String intern = $$a(131 - TextUtils.indexOf("", '0'), "\b￝\u0002￿�\u0005\r\u000f\u0007￬￿\u0000\u0006￿�\u000e￟\u0012�￿\n\u000e\u0003\t", (ViewConfiguration.getDoubleTapTimeout() >> 16) + 1, !URLUtil.isHttpUrl("http://"), Drawable.resolveOpacity(0, 0) + 24).intern();
            StringBuilder sb = new StringBuilder();
            sb.append($$b("̢₊鷲ꮭ屑쐞悧梎攡莰궄뉓ۭ᳑⢕ꮭ屑啹ὲ䱾揶ꄩ?↟닼红쐞悧蜸⩼腐쑉ᆜ탄ឩ窱彑攢ख़頴珫罾翛").intern());
            sb.append(e);
            AFDateFormat2.AFDateFormat((String) null, intern, sb.toString());
        } catch (NoSuchMethodException e2) {
            C1048ac AFDateFormat3 = C1048ac.AFDateFormat();
            String intern2 = $$a(133 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0 ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0 ? 0 : -1)), "\b￝\u0002￿�\u0005\r\u000f\u0007￬￿\u0000\u0006￿�\u000e￟\u0012�￿\n\u000e\u0003\t", (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), !PhoneNumberUtils.is12Key('0'), 25 - (ViewConfiguration.getZoomControlsTimeout() > 0 ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0 ? 0 : -1))).intern();
            StringBuilder sb2 = new StringBuilder();
            sb2.append($$b("̢₊鷲ꮭ屑쐞悧梎攡莰궄뉓ۭ᳑⢕ꮭ屑啹ὲ䱾揶ꄩ?↟닼红쐞悧蜸⩼腐쑉ᆜ탄ឩ窱彑攢ख़頴珫罾翛").intern());
            sb2.append(e2);
            AFDateFormat3.AFDateFormat((String) null, intern2, sb2.toString());
        } catch (InvocationTargetException e3) {
            C1048ac AFDateFormat4 = C1048ac.AFDateFormat();
            String intern3 = $$a(AndroidCharacter.getMirror('0') + 'T', "\b￝\u0002￿�\u0005\r\u000f\u0007￬￿\u0000\u0006￿�\u000e￟\u0012�￿\n\u000e\u0003\t", (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), !WindowManager.LayoutParams.mayUseInputMethod(0), 24 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))).intern();
            StringBuilder sb3 = new StringBuilder();
            sb3.append($$b("̢₊鷲ꮭ屑쐞悧梎攡莰궄뉓ۭ᳑⢕ꮭ屑啹ὲ䱾揶ꄩ?↟닼红쐞悧蜸⩼腐쑉ᆜ탄ឩ窱彑攢ख़頴珫罾翛").intern());
            sb3.append(e3);
            AFDateFormat4.AFDateFormat((String) null, intern3, sb3.toString());
        }
    }

    /* renamed from: com.appsflyer.internal.a$a */
    public static class C1041a extends HashMap<String, Object> {
        private static char[] $$a = {'6', 's', 'z', 'q', 'n', 'u', 'o', 'j', 'i', 'p', 'u', 'r', '\'', 'N', 'W', 'P', 'J', 'I', 'G', 'I', '0', 'j', 'n', 'k', 'j', 'C', 'E', 'h', 'e', 'C', 'E', 'h', 'o', 'L', 'K', 'p', 'n', 'n', 'D', 'B', 'n', 'm', 'd', 'j', 'r', 'n', 'l', 'n', 'T', '-', 'C', 'c', 'e', 'j', 'h', 'd', 'B', 'C', 'f', 'i', 'i', 'k', 22, 'O', 'j', 'H', ',', 16, 'B', 'd', 'h', 'j', 'e', 'c', 'C', '-', 'T', 'n', 'l', 'n', 'r', 'j', 'd', 'm', 'n', 'B', 'D', 'n', 'n', 'p', 'K', 'B', 'm', 'p', 'f', 'k', 'K', 'C', 'e', 'h', 'E', 'C', 'j', 'k', 'n', 'j', 'i', 'k', 'i', 'i', 'f', '0', 'g', 'i', 'k', 'p', 'l', 'f', 'I', 'K', 'k', 'q', 'l', 'i', 'q', 'Q', 'G', 'b', 'k', 'n', 'l', 'n', 'N', '8', 'A', 'J', 'T', 'L', 'K', 'U', '\\', 'Q', 'E', 'D', 'G', 'J', 'F', 'D', 256, 260, 255, 246, 260, 259, 133, Ascii.MAX, 209, 'Y', 216, '3', 'K', 'P', 'P', 'P', 'Q', 'P', 'P', 'P', 'Q', '2', 'J', 'e', 'n', 'j', 'g'};
        private static int $$b = 283;
        private static boolean collectIntentsFromActivities = true;
        private static int dateFormatUTC = 0;
        private static boolean getDataFormatter = true;
        private static int getInstance = 1;
        private static char[] values = {381, 397, 380, 393, 383, 390, 384, 385, 340, 388, 398, 399, 359, 400, 382, 387, 351, 337, 329, 333, 331, 336, 335, 332, 339, 392, 395, 403, 321};
        private final Map<String, Object> AFDateFormat;
        private final Context valueOf;

        public C1041a(Map<String, Object> map, Context context) {
            this.AFDateFormat = map;
            this.valueOf = context;
            put(valueOf(), $$a());
        }

        private static StringBuilder values(String... strArr) throws Exception {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                if ((i < 3 ? 'b' : '5') == '5') {
                    break;
                }
                arrayList.add(Integer.valueOf(strArr[i].length()));
                i++;
            }
            Collections.sort(arrayList);
            int intValue = ((Integer) arrayList.get(0)).intValue();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < intValue; i2++) {
                int i3 = dateFormatUTC + 51;
                getInstance = i3 % 128;
                int i4 = i3 % 2;
                Integer num = null;
                for (int i5 = 0; i5 < 3; i5++) {
                    char charAt = strArr[i5].charAt(i2);
                    if ((num == null ? 'a' : 'G') == 'G') {
                        charAt ^= num.intValue();
                        int i6 = dateFormatUTC + 17;
                        getInstance = i6 % 128;
                        int i7 = i6 % 2;
                    }
                    num = Integer.valueOf(charAt);
                }
                sb.append(Integer.toHexString(num.intValue()));
            }
            return sb;
        }

        private String valueOf() {
            try {
                String num = Integer.toString(Build.VERSION.SDK_INT);
                String obj = this.AFDateFormat.get($$a(new int[]{0, 12, 7, 6}, "\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000", !URLUtil.isJavaScriptUrl("javascript:")).intern()).toString();
                String obj2 = this.AFDateFormat.get($$b((String) null, (int[]) null, (SystemClock.elapsedRealtime() > 0 ? 1 : (SystemClock.elapsedRealtime() == 0 ? 0 : -1)) + 126, "").intern()).toString();
                if ((obj2 == null ? '*' : 'a') != 'a') {
                    int i = dateFormatUTC + 111;
                    getInstance = i % 128;
                    obj2 = (i % 2 == 0 ? $$a(new int[]{12, 8, 0, 0}, "\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0000", URLUtil.isContentUrl("content:")) : $$a(new int[]{12, 8, 0, 0}, "\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0000", !URLUtil.isContentUrl("content:"))).intern();
                }
                StringBuilder sb = new StringBuilder(obj);
                sb.reverse();
                StringBuilder values2 = values(num, obj2, sb.toString());
                int length = values2.length();
                if ((length > 4 ? 9 : '8') != 9) {
                    while (true) {
                        if ((length < 4 ? Typography.amp : 'C') == 'C') {
                            break;
                        }
                        length++;
                        values2.append('1');
                    }
                } else {
                    int i2 = dateFormatUTC + 77;
                    getInstance = i2 % 128;
                    int i3 = i2 % 2;
                    values2.delete(4, length);
                }
                values2.insert(0, $$b((String) null, (int[]) null, 128 - (SystemClock.elapsedRealtime() > 0 ? 1 : (SystemClock.elapsedRealtime() == 0 ? 0 : -1)), "").intern());
                return values2.toString();
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append($$a(new int[]{20, 42, 0, 30}, "\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0000\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001", true ^ TextUtils.regionMatches("", 0, "", 0, 0)).intern());
                sb2.append(e);
                AFLogger.afRDLog(sb2.toString());
                return $$b((String) null, (int[]) null, (SystemClock.uptimeMillis() > 0 ? 1 : (SystemClock.uptimeMillis() == 0 ? 0 : -1)) + 126, "").intern();
            }
        }

        private String $$a() {
            String str;
            int i;
            try {
                String obj = this.AFDateFormat.get($$a(new int[]{0, 12, 7, 6}, "\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000", PhoneNumberUtils.compare("", "")).intern()).toString();
                String obj2 = this.AFDateFormat.get($$b((String) null, (int[]) null, 127 - ExpandableListView.getPackedPositionType(0), "").intern()).toString();
                String replaceAll = $$b((String) null, (int[]) null, 127 - TextUtils.getOffsetAfter("", 0), "").intern().replaceAll($$a(new int[]{62, 5, 0, 0}, "\u0001\u0001\u0001\u0001\u0000", URLUtil.isValidUrl((String) null)).intern(), "");
                StringBuilder sb = new StringBuilder();
                sb.append(obj);
                sb.append(obj2);
                sb.append(replaceAll);
                String sha256 = HashUtils.toSha256(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(sha256.substring(0, 16));
                str = sb2.toString();
            } catch (Exception e) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append($$a(new int[]{67, 44, 0, 7}, "\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0000\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000", URLUtil.isAboutUrl("about:")).intern());
                sb3.append(e);
                AFLogger.afRDLog(sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append("");
                sb4.append($$b((String) null, (int[]) null, 127 - (ViewConfiguration.getScrollBarSize() >> 8), "").intern());
                str = sb4.toString();
            }
            String str2 = str;
            try {
                Intent registerReceiver = this.valueOf.registerReceiver((BroadcastReceiver) null, new IntentFilter($$a(new int[]{111, 37, 0, 0}, "\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0001", !PhoneNumberUtils.isNonSeparator('0')).intern()));
                int i2 = -2700;
                if (registerReceiver != null) {
                    int i3 = getInstance + 27;
                    dateFormatUTC = i3 % 128;
                    i2 = i3 % 2 != 0 ? registerReceiver.getIntExtra($$b((String) null, (int[]) null, 125 >> (Process.myPid() * 99), "").intern(), 11394) : registerReceiver.getIntExtra($$b((String) null, (int[]) null, 127 - (Process.myPid() >> 22), "").intern(), -2700);
                }
                String str3 = this.valueOf.getApplicationInfo().nativeLibraryDir;
                if (str3 != null) {
                    if ((str3.contains($$b((String) null, (int[]) null, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 127, "").intern()) ? '%' : '4') != '4') {
                        int i4 = dateFormatUTC + 41;
                        getInstance = i4 % 128;
                        if (!(i4 % 2 == 0)) {
                            i = 1;
                            int size = ((SensorManager) this.valueOf.getSystemService($$a(new int[]{148, 6, 145, 5}, (String) null, URLUtil.isHttpUrl("http://")).intern())).getSensorList(-1).size();
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append($$a(new int[]{154, 1, 168, 0}, "\u0000", PhoneNumberUtils.isReallyDialable('0')).intern());
                            sb5.append(i2);
                            sb5.append($$a(new int[]{155, 2, 89, 1}, (String) null, PhoneNumberUtils.isReallyDialable('0')).intern());
                            sb5.append(i);
                            sb5.append($$b((String) null, (int[]) null, View.resolveSize(0, 0) + 127, "").intern());
                            sb5.append(size);
                            sb5.append($$a(new int[]{157, 2, 141, 0}, "\u0001\u0000", !URLUtil.isHttpUrl("http://")).intern());
                            sb5.append(this.AFDateFormat.size());
                            String obj3 = sb5.toString();
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append(str2);
                            sb6.append(C1042a.valueOf(C1042a.$$b(C1042a.$$b(obj3))));
                            return sb6.toString();
                        }
                    }
                }
                i = 0;
                int size2 = ((SensorManager) this.valueOf.getSystemService($$a(new int[]{148, 6, 145, 5}, (String) null, URLUtil.isHttpUrl("http://")).intern())).getSensorList(-1).size();
                StringBuilder sb52 = new StringBuilder();
                sb52.append($$a(new int[]{154, 1, 168, 0}, "\u0000", PhoneNumberUtils.isReallyDialable('0')).intern());
                sb52.append(i2);
                sb52.append($$a(new int[]{155, 2, 89, 1}, (String) null, PhoneNumberUtils.isReallyDialable('0')).intern());
                sb52.append(i);
                sb52.append($$b((String) null, (int[]) null, View.resolveSize(0, 0) + 127, "").intern());
                sb52.append(size2);
                sb52.append($$a(new int[]{157, 2, 141, 0}, "\u0001\u0000", !URLUtil.isHttpUrl("http://")).intern());
                sb52.append(this.AFDateFormat.size());
                String obj32 = sb52.toString();
                StringBuilder sb62 = new StringBuilder();
                sb62.append(str2);
                sb62.append(C1042a.valueOf(C1042a.$$b(C1042a.$$b(obj32))));
                return sb62.toString();
            } catch (Exception e2) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append($$a(new int[]{67, 44, 0, 7}, "\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0000\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000", !URLUtil.isCookielessProxyUrl((String) null)).intern());
                sb7.append(e2);
                AFLogger.afRDLog(sb7.toString());
                StringBuilder sb8 = new StringBuilder();
                sb8.append(str2);
                sb8.append($$a(new int[]{159, 16, 0, 0}, "\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0000", PhoneNumberUtils.compare("", "")).intern());
                return sb8.toString();
            }
        }

        /* renamed from: com.appsflyer.internal.a$a$a */
        public static class C1042a {
            public String $$b;
            public String AFDateFormat;
            private byte[] valueOf;
            public String values;

            C1042a() {
            }

            static byte[] $$b(String str) throws Exception {
                return str.getBytes();
            }

            static byte[] $$b(byte[] bArr) throws Exception {
                for (int i = 0; i < bArr.length; i++) {
                    bArr[i] = (byte) (bArr[i] ^ ((i % 2) + 42));
                }
                return bArr;
            }

            static String valueOf(byte[] bArr) throws Exception {
                StringBuilder sb = new StringBuilder();
                for (byte hexString : bArr) {
                    String hexString2 = Integer.toHexString(hexString);
                    if (hexString2.length() == 1) {
                        hexString2 = "0".concat(String.valueOf(hexString2));
                    }
                    sb.append(hexString2);
                }
                return sb.toString();
            }

            public C1042a(String str, byte[] bArr, String str2) {
                this.values = str;
                this.valueOf = bArr;
                this.$$b = str2;
            }

            C1042a(char[] cArr) {
                Scanner scanner = new Scanner(new String(cArr));
                int i = 0;
                int i2 = 0;
                while (scanner.hasNextLine()) {
                    String nextLine = scanner.nextLine();
                    if (nextLine.startsWith("url=")) {
                        this.values = nextLine.substring(4).trim();
                    } else if (nextLine.startsWith("version=")) {
                        this.$$b = nextLine.substring(8).trim();
                        Matcher matcher = Pattern.compile("^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?$").matcher(this.$$b);
                        if (matcher.matches()) {
                            i = Integer.parseInt(matcher.group(1));
                            i2 = Integer.parseInt(matcher.group(2));
                        }
                    } else if (nextLine.startsWith("data=")) {
                        String trim = nextLine.substring(5).trim();
                        this.valueOf = (i > 4 || i2 >= 11) ? Base64.decode(trim, 2) : trim.getBytes();
                    }
                }
                scanner.close();
            }

            public final byte[] $$a() {
                return this.valueOf;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v17, resolved type: byte[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v18, resolved type: java.lang.String} */
        /* JADX WARNING: Failed to insert additional move for type inference */
        /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r9v2, types: [char] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.lang.String $$a(int[] r11, java.lang.String r12, boolean r13) {
            /*
                if (r12 == 0) goto L_0x0008
                java.lang.String r0 = "ISO-8859-1"
                byte[] r12 = r12.getBytes(r0)
            L_0x0008:
                byte[] r12 = (byte[]) r12
                r0 = 0
                r1 = r11[r0]
                r2 = 1
                r3 = r11[r2]
                r4 = 2
                r5 = r11[r4]
                r6 = 3
                r6 = r11[r6]
                char[] r7 = $$a
                char[] r8 = new char[r3]
                java.lang.System.arraycopy(r7, r1, r8, r0, r3)
                if (r12 == 0) goto L_0x0048
                char[] r1 = new char[r3]
                r7 = 0
                r9 = 0
            L_0x0023:
                if (r7 >= r3) goto L_0x003e
                byte r10 = r12[r7]
                if (r10 != r2) goto L_0x0032
                char r10 = r8[r7]
                int r10 = r10 << r2
                int r10 = r10 + r2
                int r10 = r10 - r9
                char r9 = (char) r10
                r1[r7] = r9
                goto L_0x0039
            L_0x0032:
                char r10 = r8[r7]
                int r10 = r10 << r2
                int r10 = r10 - r9
                char r9 = (char) r10
                r1[r7] = r9
            L_0x0039:
                char r9 = r1[r7]
                int r7 = r7 + 1
                goto L_0x0023
            L_0x003e:
                int r12 = dateFormatUTC
                int r12 = r12 + 123
                int r7 = r12 % 128
                getInstance = r7
                int r12 = r12 % r4
                r8 = r1
            L_0x0048:
                if (r6 <= 0) goto L_0x0057
                char[] r12 = new char[r3]
                java.lang.System.arraycopy(r8, r0, r12, r0, r3)
                int r1 = r3 - r6
                java.lang.System.arraycopy(r12, r0, r8, r1, r6)
                java.lang.System.arraycopy(r12, r6, r8, r0, r1)
            L_0x0057:
                if (r13 == 0) goto L_0x005b
                r12 = 1
                goto L_0x005c
            L_0x005b:
                r12 = 0
            L_0x005c:
                if (r12 == 0) goto L_0x0085
                char[] r12 = new char[r3]
                r13 = 0
            L_0x0061:
                if (r13 >= r3) goto L_0x0065
                r1 = 1
                goto L_0x0066
            L_0x0065:
                r1 = 0
            L_0x0066:
                if (r1 == 0) goto L_0x007b
                int r1 = getInstance
                int r1 = r1 + 93
                int r6 = r1 % 128
                dateFormatUTC = r6
                int r1 = r1 % r4
                int r1 = r3 - r13
                int r1 = r1 - r2
                char r1 = r8[r1]
                r12[r13] = r1
                int r13 = r13 + 1
                goto L_0x0061
            L_0x007b:
                int r13 = getInstance
                int r13 = r13 + 85
                int r1 = r13 % 128
                dateFormatUTC = r1
                int r13 = r13 % r4
                r8 = r12
            L_0x0085:
                if (r5 <= 0) goto L_0x009d
            L_0x0087:
                if (r0 >= r3) goto L_0x009d
                int r12 = getInstance
                int r12 = r12 + 105
                int r13 = r12 % 128
                dateFormatUTC = r13
                int r12 = r12 % r4
                char r12 = r8[r0]
                r13 = r11[r4]
                int r12 = r12 - r13
                char r12 = (char) r12
                r8[r0] = r12
                int r0 = r0 + 1
                goto L_0x0087
            L_0x009d:
                java.lang.String r11 = new java.lang.String
                r11.<init>(r8)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1040a.C1041a.$$a(int[], java.lang.String, boolean):java.lang.String");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: char[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: char[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: byte[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: java.lang.String} */
        /* JADX WARNING: Failed to insert additional move for type inference */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.lang.String $$b(java.lang.String r6, int[] r7, int r8, java.lang.String r9) {
            /*
                if (r9 == 0) goto L_0x0012
                int r0 = dateFormatUTC
                int r0 = r0 + 49
                int r1 = r0 % 128
                getInstance = r1
                int r0 = r0 % 2
                java.lang.String r0 = "ISO-8859-1"
                byte[] r9 = r9.getBytes(r0)
            L_0x0012:
                byte[] r9 = (byte[]) r9
                r0 = 0
                if (r6 == 0) goto L_0x0039
                int r1 = getInstance
                int r1 = r1 + 91
                int r2 = r1 % 128
                dateFormatUTC = r2
                int r1 = r1 % 2
                r2 = 20
                if (r1 == 0) goto L_0x0028
                r1 = 43
                goto L_0x002a
            L_0x0028:
                r1 = 20
            L_0x002a:
                if (r1 == r2) goto L_0x0035
                char[] r6 = r6.toCharArray()
                r1 = 4
                int r1 = r1 / r0
                goto L_0x0039
            L_0x0033:
                r6 = move-exception
                throw r6
            L_0x0035:
                char[] r6 = r6.toCharArray()
            L_0x0039:
                char[] r6 = (char[]) r6
                char[] r1 = values
                int r2 = $$b
                boolean r3 = collectIntentsFromActivities
                if (r3 == 0) goto L_0x0064
                int r6 = r9.length
                char[] r7 = new char[r6]
                r3 = 0
            L_0x0047:
                r4 = 1
                if (r3 >= r6) goto L_0x004c
                r5 = 0
                goto L_0x004d
            L_0x004c:
                r5 = 1
            L_0x004d:
                if (r5 == r4) goto L_0x005e
                int r4 = r6 + -1
                int r4 = r4 - r3
                byte r4 = r9[r4]
                int r4 = r4 + r8
                char r4 = r1[r4]
                int r4 = r4 - r2
                char r4 = (char) r4
                r7[r3] = r4
                int r3 = r3 + 1
                goto L_0x0047
            L_0x005e:
                java.lang.String r6 = new java.lang.String
                r6.<init>(r7)
                return r6
            L_0x0064:
                boolean r9 = getDataFormatter
                if (r9 == 0) goto L_0x0082
                int r7 = r6.length
                char[] r9 = new char[r7]
            L_0x006b:
                if (r0 >= r7) goto L_0x007c
                int r3 = r7 + -1
                int r3 = r3 - r0
                char r3 = r6[r3]
                int r3 = r3 - r8
                char r3 = r1[r3]
                int r3 = r3 - r2
                char r3 = (char) r3
                r9[r0] = r3
                int r0 = r0 + 1
                goto L_0x006b
            L_0x007c:
                java.lang.String r6 = new java.lang.String
                r6.<init>(r9)
                return r6
            L_0x0082:
                int r6 = r7.length
                char[] r9 = new char[r6]
            L_0x0085:
                r3 = 44
                if (r0 >= r6) goto L_0x008c
                r4 = 75
                goto L_0x008e
            L_0x008c:
                r4 = 44
            L_0x008e:
                if (r4 == r3) goto L_0x00ba
                int r3 = dateFormatUTC
                int r3 = r3 + 13
                int r4 = r3 % 128
                getInstance = r4
                int r3 = r3 % 2
                if (r3 != 0) goto L_0x00ab
                int r3 = r6 % 1
                int r3 = r3 >> r0
                r3 = r7[r3]
                int r3 = r3 >> r8
                char r3 = r1[r3]
                int r3 = r3 << r2
                char r3 = (char) r3
                r9[r0] = r3
                int r0 = r0 + 18
                goto L_0x0085
            L_0x00ab:
                int r3 = r6 + -1
                int r3 = r3 - r0
                r3 = r7[r3]
                int r3 = r3 - r8
                char r3 = r1[r3]
                int r3 = r3 - r2
                char r3 = (char) r3
                r9[r0] = r3
                int r0 = r0 + 1
                goto L_0x0085
            L_0x00ba:
                java.lang.String r6 = new java.lang.String
                r6.<init>(r9)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1040a.C1041a.$$b(java.lang.String, int[], int, java.lang.String):java.lang.String");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String $$a(int r6, java.lang.String r7, int r8, boolean r9, int r10) {
        /*
            r0 = 0
            r1 = 1
            if (r7 == 0) goto L_0x0006
            r2 = 0
            goto L_0x0007
        L_0x0006:
            r2 = 1
        L_0x0007:
            if (r2 == 0) goto L_0x000a
            goto L_0x0018
        L_0x000a:
            char[] r7 = r7.toCharArray()
            int r2 = dateFormatUTC
            int r2 = r2 + 45
            int r3 = r2 % 128
            AFDeepLinkManager = r3
            int r2 = r2 % 2
        L_0x0018:
            char[] r7 = (char[]) r7
            char[] r2 = new char[r10]
            int r3 = dateFormatUTC
            int r3 = r3 + r1
            int r4 = r3 % 128
            AFDeepLinkManager = r4
            int r3 = r3 % 2
            r3 = 0
        L_0x0026:
            if (r3 >= r10) goto L_0x002a
            r4 = 1
            goto L_0x002b
        L_0x002a:
            r4 = 0
        L_0x002b:
            if (r4 == 0) goto L_0x0061
            int r4 = AFDeepLinkManager
            int r4 = r4 + 33
            int r5 = r4 % 128
            dateFormatUTC = r5
            int r4 = r4 % 2
            if (r4 == 0) goto L_0x003b
            r4 = 0
            goto L_0x003c
        L_0x003b:
            r4 = 1
        L_0x003c:
            if (r4 == r1) goto L_0x0050
            char r4 = r7[r3]
            int r4 = r6 >>> r4
            char r4 = (char) r4
            r2[r3] = r4
            char r4 = r2[r3]
            int r5 = $$a
            int r4 = r4 % r5
            char r4 = (char) r4
            r2[r3] = r4
            int r3 = r3 + 84
            goto L_0x0026
        L_0x0050:
            char r4 = r7[r3]
            int r4 = r4 + r6
            char r4 = (char) r4
            r2[r3] = r4
            char r4 = r2[r3]
            int r5 = $$a
            int r4 = r4 - r5
            char r4 = (char) r4
            r2[r3] = r4
            int r3 = r3 + 1
            goto L_0x0026
        L_0x0061:
            if (r8 <= 0) goto L_0x007a
            int r6 = AFDeepLinkManager
            int r6 = r6 + 55
            int r7 = r6 % 128
            dateFormatUTC = r7
            int r6 = r6 % 2
            char[] r6 = new char[r10]
            java.lang.System.arraycopy(r2, r0, r6, r0, r10)
            int r7 = r10 - r8
            java.lang.System.arraycopy(r6, r0, r2, r7, r8)
            java.lang.System.arraycopy(r6, r8, r2, r0, r7)
        L_0x007a:
            if (r9 == 0) goto L_0x007e
            r6 = 0
            goto L_0x007f
        L_0x007e:
            r6 = 1
        L_0x007f:
            if (r6 == r1) goto L_0x0090
            char[] r6 = new char[r10]
        L_0x0083:
            if (r0 >= r10) goto L_0x008f
            int r7 = r10 - r0
            int r7 = r7 - r1
            char r7 = r2[r7]
            r6[r0] = r7
            int r0 = r0 + 1
            goto L_0x0083
        L_0x008f:
            r2 = r6
        L_0x0090:
            java.lang.String r6 = new java.lang.String
            r6.<init>(r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1040a.$$a(int, java.lang.String, int, boolean, int):java.lang.String");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String $$b(java.lang.String r11) {
        /*
            r0 = 0
            r1 = 1
            if (r11 == 0) goto L_0x0006
            r2 = 0
            goto L_0x0007
        L_0x0006:
            r2 = 1
        L_0x0007:
            r3 = 2
            if (r2 == 0) goto L_0x000b
            goto L_0x002c
        L_0x000b:
            int r2 = dateFormatUTC
            int r2 = r2 + 63
            int r4 = r2 % 128
            AFDeepLinkManager = r4
            int r2 = r2 % r3
            if (r2 != 0) goto L_0x001f
            char[] r11 = r11.toCharArray()
            r2 = 0
            int r2 = r2.length     // Catch:{ all -> 0x001d }
            goto L_0x0023
        L_0x001d:
            r11 = move-exception
            throw r11
        L_0x001f:
            char[] r11 = r11.toCharArray()
        L_0x0023:
            int r2 = dateFormatUTC
            int r2 = r2 + 107
            int r4 = r2 % 128
            AFDeepLinkManager = r4
            int r2 = r2 % r3
        L_0x002c:
            char[] r11 = (char[]) r11
            int r2 = r11.length
            char[] r2 = new char[r2]
            char[] r4 = new char[r3]
            r5 = 0
        L_0x0034:
            int r6 = r11.length
            r7 = 27
            if (r5 >= r6) goto L_0x003c
            r6 = 18
            goto L_0x003e
        L_0x003c:
            r6 = 27
        L_0x003e:
            if (r6 == r7) goto L_0x0069
            int r6 = dateFormatUTC
            int r6 = r6 + 89
            int r7 = r6 % 128
            AFDeepLinkManager = r7
            int r6 = r6 % r3
            char r6 = r11[r5]
            r4[r0] = r6
            int r6 = r5 + 1
            char r7 = r11[r6]
            r4[r1] = r7
            char r7 = $$b
            char r8 = valueOf
            char r9 = values
            char r10 = AFDateFormat
            com.appsflyer.internal.C1050ae.values(r4, r7, r8, r9, r10)
            char r7 = r4[r0]
            r2[r5] = r7
            char r7 = r4[r1]
            r2[r6] = r7
            int r5 = r5 + 2
            goto L_0x0034
        L_0x0069:
            char r11 = r2[r0]
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2, r1, r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1040a.$$b(java.lang.String):java.lang.String");
    }
}
