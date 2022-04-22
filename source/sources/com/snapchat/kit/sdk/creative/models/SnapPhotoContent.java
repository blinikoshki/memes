package com.snapchat.kit.sdk.creative.models;

import com.snapchat.kit.sdk.creative.media.SnapPhotoFile;
import java.io.File;

public final class SnapPhotoContent extends SnapContent {

    /* renamed from: b */
    private SnapPhotoFile f1301b;

    public final String getDeeplinkUrlPath() {
        return "preview";
    }

    public final String getIntentType() {
        return "image/*";
    }

    public SnapPhotoContent(SnapPhotoFile snapPhotoFile) {
        this.f1301b = snapPhotoFile;
    }

    public final File getMediaFile() {
        return this.f1301b.getPhotoFile();
    }
}
