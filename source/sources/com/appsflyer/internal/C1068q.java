package com.appsflyer.internal;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.appsflyer.AndroidUtils;
import com.appsflyer.ServerParameters;
import com.google.firebase.analytics.FirebaseAnalytics;

/* renamed from: com.appsflyer.internal.q */
public final class C1068q {

    /* renamed from: com.appsflyer.internal.q$d */
    public static final class C1069d {
        public static final C1068q valueOf = new C1068q();
    }

    C1068q() {
    }

    private static boolean $$a(Context context, String[] strArr) {
        for (String isPermissionAvailable : strArr) {
            if (AndroidUtils.isPermissionAvailable(context, isPermissionAvailable)) {
                return true;
            }
        }
        return false;
    }

    public final Location $$a(Context context) {
        Location location;
        Location location2;
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION);
            if ($$a(context, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"})) {
                location = locationManager.getLastKnownLocation(ServerParameters.NETWORK);
            } else {
                location = null;
            }
            if ($$a(context, new String[]{"android.permission.ACCESS_FINE_LOCATION"})) {
                location2 = locationManager.getLastKnownLocation("gps");
            } else {
                location2 = null;
            }
            if (location2 == null && location == null) {
                location = null;
            } else if (location2 != null || location == null) {
                if ((location == null && location2 != null) || 60000 >= location.getTime() - location2.getTime()) {
                    location = location2;
                }
            }
            if (location != null) {
                return location;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
