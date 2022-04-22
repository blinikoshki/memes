package com.snapchat.kit.sdk.creative.models;

import com.snapchat.kit.sdk.creative.media.SnapVideoFile;
import java.io.File;

public final class SnapVideoContent extends SnapContent {

    /* renamed from: b */
    private SnapVideoFile f1302b;

    public final String getDeeplinkUrlPath() {
        return "preview";
    }

    public final String getIntentType() {
        return "snapvideo/*";
    }

    public SnapVideoContent(SnapVideoFile snapVideoFile) {
        this.f1302b = snapVideoFile;
    }

    public final File getMediaFile() {
        return this.f1302b.getVideoFile();
    }
}
