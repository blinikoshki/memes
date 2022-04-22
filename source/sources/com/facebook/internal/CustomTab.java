package com.facebook.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsIntent;
import com.facebook.FacebookSdk;
import com.facebook.login.CustomTabPrefetchHelper;

public class CustomTab {
    private Uri uri;

    public CustomTab(String str, Bundle bundle) {
        this.uri = getURIForAction(str, bundle == null ? new Bundle() : bundle);
    }

    public static Uri getURIForAction(String str, Bundle bundle) {
        String dialogAuthority = ServerProtocol.getDialogAuthority();
        return Utility.buildUri(dialogAuthority, FacebookSdk.getGraphApiVersion() + "/" + ServerProtocol.DIALOG_PATH + str, bundle);
    }

    public boolean openCustomTab(Activity activity, String str) {
        CustomTabsIntent build = new CustomTabsIntent.Builder(CustomTabPrefetchHelper.getPreparedSessionOnce()).build();
        build.intent.setPackage(str);
        build.intent.addFlags(1073741824);
        try {
            build.launchUrl(activity, this.uri);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }
}
