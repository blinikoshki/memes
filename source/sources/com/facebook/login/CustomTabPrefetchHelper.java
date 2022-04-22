package com.facebook.login;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import java.util.List;

public class CustomTabPrefetchHelper extends CustomTabsServiceConnection {
    private static CustomTabsClient client;
    private static CustomTabsSession session;

    public void onServiceDisconnected(ComponentName componentName) {
    }

    private static void prepareSession() {
        CustomTabsClient customTabsClient;
        if (session == null && (customTabsClient = client) != null) {
            session = customTabsClient.newSession((CustomTabsCallback) null);
        }
    }

    public static void mayLaunchUrl(Uri uri) {
        if (session == null) {
            prepareSession();
        }
        CustomTabsSession customTabsSession = session;
        if (customTabsSession != null) {
            customTabsSession.mayLaunchUrl(uri, (Bundle) null, (List<Bundle>) null);
        }
    }

    public static CustomTabsSession getPreparedSessionOnce() {
        CustomTabsSession customTabsSession = session;
        session = null;
        return customTabsSession;
    }

    public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        client = customTabsClient;
        customTabsClient.warmup(0);
        prepareSession();
    }
}
