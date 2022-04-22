package com.snapchat.kit.sdk.creative.models;

import com.snapchat.kit.sdk.creative.media.SnapLensLaunchData;
import com.snapchat.kit.sdk.creative.media.SnapSticker;
import java.io.File;

public final class SnapLensContent extends SnapContent {

    /* renamed from: b */
    private String f1299b;

    /* renamed from: c */
    private SnapLensLaunchData f1300c;

    public final String getDeeplinkUrlPath() {
        return "camera";
    }

    public final String getIntentType() {
        return "*/*";
    }

    public final File getMediaFile() {
        return null;
    }

    public SnapLensContent(String str, SnapLensLaunchData snapLensLaunchData) {
        this.f1299b = str;
        this.f1300c = snapLensLaunchData;
    }

    public SnapLensContent(String str) {
        this.f1299b = str;
        this.f1300c = null;
    }

    public final void setLensId(String str) {
        this.f1299b = str;
    }

    public final void setSnapLensLaunchData(SnapLensLaunchData snapLensLaunchData) {
        this.f1300c = snapLensLaunchData;
    }

    public final SnapLensLaunchData getSnapLensLaunchData() {
        return this.f1300c;
    }

    public final String getLensId() {
        return this.f1299b;
    }

    public final String getSnapLensLaunchDataString() {
        SnapLensLaunchData snapLensLaunchData = this.f1300c;
        if (snapLensLaunchData != null) {
            return snapLensLaunchData.getLensLaunchData();
        }
        return null;
    }

    public final void setSnapSticker(SnapSticker snapSticker) {
        this.f1296a = null;
    }
}
