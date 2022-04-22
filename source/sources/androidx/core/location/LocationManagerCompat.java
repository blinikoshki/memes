package androidx.core.location;

import android.location.LocationManager;
import android.os.Build;
import com.appsflyer.ServerParameters;

public final class LocationManagerCompat {
    public static boolean isLocationEnabled(LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return locationManager.isLocationEnabled();
        }
        return locationManager.isProviderEnabled(ServerParameters.NETWORK) || locationManager.isProviderEnabled("gps");
    }

    private LocationManagerCompat() {
    }
}
