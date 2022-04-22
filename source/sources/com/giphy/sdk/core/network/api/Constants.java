package com.giphy.sdk.core.network.api;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\n¨\u0006\u0014"}, mo26107d2 = {"Lcom/giphy/sdk/core/network/api/Constants;", "", "()V", "API_KEY", "", "getAPI_KEY", "()Ljava/lang/String;", "MOBILE_API_URL", "Landroid/net/Uri;", "getMOBILE_API_URL", "()Landroid/net/Uri;", "OM_API_URL", "getOM_API_URL", "OM_PARTNER_NAME", "getOM_PARTNER_NAME", "OM_VERSION", "getOM_VERSION", "SERVER_URL", "getSERVER_URL", "Paths", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: Constants.kt */
public final class Constants {
    private static final String API_KEY = "api_key";
    public static final Constants INSTANCE = new Constants();
    private static final Uri MOBILE_API_URL;
    private static final String OM_API_URL = OM_API_URL;
    private static final String OM_PARTNER_NAME = OM_PARTNER_NAME;
    private static final String OM_VERSION = OM_VERSION;
    private static final Uri SERVER_URL;

    static {
        Uri parse = Uri.parse("https://api.giphy.com");
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(\"https://api.giphy.com\")");
        SERVER_URL = parse;
        Uri parse2 = Uri.parse("https://x.giphy.com");
        Intrinsics.checkExpressionValueIsNotNull(parse2, "Uri.parse(\"https://x.giphy.com\")");
        MOBILE_API_URL = parse2;
    }

    private Constants() {
    }

    public final Uri getSERVER_URL() {
        return SERVER_URL;
    }

    public final Uri getMOBILE_API_URL() {
        return MOBILE_API_URL;
    }

    public final String getAPI_KEY() {
        return API_KEY;
    }

    public final String getOM_API_URL() {
        return OM_API_URL;
    }

    public final String getOM_PARTNER_NAME() {
        return OM_PARTNER_NAME;
    }

    public final String getOM_VERSION() {
        return OM_VERSION;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u0017"}, mo26107d2 = {"Lcom/giphy/sdk/core/network/api/Constants$Paths;", "", "()V", "EMOJI", "", "getEMOJI", "()Ljava/lang/String;", "GIFS_BY_CHANNEL_ID", "getGIFS_BY_CHANNEL_ID", "GIF_BY_ID", "getGIF_BY_ID", "GIF_BY_IDS", "getGIF_BY_IDS", "RANDOM", "getRANDOM", "SEARCH", "getSEARCH", "STICKERS_BY_PACK_ID", "getSTICKERS_BY_PACK_ID", "STICKER_PACKS", "getSTICKER_PACKS", "TRENDING", "getTRENDING", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* compiled from: Constants.kt */
    public static final class Paths {
        private static final String EMOJI = EMOJI;
        private static final String GIFS_BY_CHANNEL_ID = GIFS_BY_CHANNEL_ID;
        private static final String GIF_BY_ID = GIF_BY_ID;
        private static final String GIF_BY_IDS = GIF_BY_IDS;
        public static final Paths INSTANCE = new Paths();
        private static final String RANDOM = RANDOM;
        private static final String SEARCH = SEARCH;
        private static final String STICKERS_BY_PACK_ID = STICKERS_BY_PACK_ID;
        private static final String STICKER_PACKS = STICKER_PACKS;
        private static final String TRENDING = TRENDING;

        private Paths() {
        }

        public final String getSEARCH() {
            return SEARCH;
        }

        public final String getTRENDING() {
            return TRENDING;
        }

        public final String getRANDOM() {
            return RANDOM;
        }

        public final String getGIF_BY_ID() {
            return GIF_BY_ID;
        }

        public final String getGIF_BY_IDS() {
            return GIF_BY_IDS;
        }

        public final String getSTICKER_PACKS() {
            return STICKER_PACKS;
        }

        public final String getSTICKERS_BY_PACK_ID() {
            return STICKERS_BY_PACK_ID;
        }

        public final String getGIFS_BY_CHANNEL_ID() {
            return GIFS_BY_CHANNEL_ID;
        }

        public final String getEMOJI() {
            return EMOJI;
        }
    }
}
