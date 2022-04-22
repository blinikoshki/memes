package com.giphy.sdk.analytics.network.api;

import android.net.Uri;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0019\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\f0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0013"}, mo26107d2 = {"Lcom/giphy/sdk/analytics/network/api/Constants;", "", "()V", "API_KEY", "", "getAPI_KEY", "()Ljava/lang/String;", "CONTENT_TYPE", "getCONTENT_TYPE", "PINGBACK_ID", "getPINGBACK_ID", "PINGBACK_SERVER_URL", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "getPINGBACK_SERVER_URL", "()Landroid/net/Uri;", "SERVER_URL", "getSERVER_URL", "Paths", "giphy-android-sdk-analytics_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: Constants.kt */
public final class Constants {
    private static final String API_KEY = "api_key";
    private static final String CONTENT_TYPE = "Content-Type";
    public static final Constants INSTANCE = new Constants();
    private static final String PINGBACK_ID = PINGBACK_ID;
    private static final Uri PINGBACK_SERVER_URL = Uri.parse("https://pingback.giphy.com");
    private static final Uri SERVER_URL = Uri.parse("https://api.giphy.com");

    private Constants() {
    }

    public final Uri getPINGBACK_SERVER_URL() {
        return PINGBACK_SERVER_URL;
    }

    public final Uri getSERVER_URL() {
        return SERVER_URL;
    }

    public final String getAPI_KEY() {
        return API_KEY;
    }

    public final String getPINGBACK_ID() {
        return PINGBACK_ID;
    }

    public final String getCONTENT_TYPE() {
        return CONTENT_TYPE;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, mo26107d2 = {"Lcom/giphy/sdk/analytics/network/api/Constants$Paths;", "", "()V", "PINGBACK", "", "getPINGBACK", "()Ljava/lang/String;", "RANDOM_ID", "getRANDOM_ID", "giphy-android-sdk-analytics_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* compiled from: Constants.kt */
    public static final class Paths {
        public static final Paths INSTANCE = new Paths();
        private static final String PINGBACK = PINGBACK;
        private static final String RANDOM_ID = RANDOM_ID;

        private Paths() {
        }

        public final String getPINGBACK() {
            return PINGBACK;
        }

        public final String getRANDOM_ID() {
            return RANDOM_ID;
        }
    }
}
