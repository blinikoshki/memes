package com.giphy.sdk.p013ui.drawables;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, mo26107d2 = {"Lcom/giphy/sdk/ui/drawables/MimeType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "VIDEO_MP4", "IMAGE_GIF", "IMAGE_MP4", "IMAGE_WEBP", "IMAGE_JPG", "IMAGE_JPEG", "IMAGE_PNG", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.drawables.MimeType */
/* compiled from: MimeType.kt */
public enum MimeType {
    VIDEO_MP4("video/mp4"),
    IMAGE_GIF("video/mp4"),
    IMAGE_MP4("video/mp4"),
    IMAGE_WEBP("video/mp4"),
    IMAGE_JPG("video/mp4"),
    IMAGE_JPEG("video/mp4"),
    IMAGE_PNG("video/mp4");
    
    private final String value;

    private MimeType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
