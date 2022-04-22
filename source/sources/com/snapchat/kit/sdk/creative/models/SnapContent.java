package com.snapchat.kit.sdk.creative.models;

import com.snapchat.kit.sdk.creative.media.SnapSticker;
import java.io.File;

public abstract class SnapContent {

    /* renamed from: a */
    protected SnapSticker f1296a;

    /* renamed from: b */
    private String f1297b;

    /* renamed from: c */
    private String f1298c;

    public abstract String getDeeplinkUrlPath();

    public abstract String getIntentType();

    public abstract File getMediaFile();

    public void setSnapSticker(SnapSticker snapSticker) {
        this.f1296a = snapSticker;
    }

    public SnapSticker getSnapSticker() {
        return this.f1296a;
    }

    public void setAttachmentUrl(String str) {
        this.f1297b = str;
    }

    public String getAttachmentUrl() {
        return this.f1297b;
    }

    public void setCaptionText(String str) {
        this.f1298c = str;
    }

    public String getCaptionText() {
        return this.f1298c;
    }
}
