package com.giphy.sdk.p013ui.drawables;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, mo26107d2 = {"Lcom/giphy/sdk/ui/drawables/ImageFormat;", "", "mimeType", "", "extension", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getExtension", "()Ljava/lang/String;", "getMimeType", "WEBP", "GIF", "MP4", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.drawables.ImageFormat */
/* compiled from: ImageFormat.kt */
public enum ImageFormat {
    WEBP(MimeType.IMAGE_WEBP.getValue(), "webp"),
    GIF(MimeType.IMAGE_GIF.getValue(), "gif"),
    MP4(MimeType.IMAGE_MP4.getValue(), "mp4");
    
    private final String extension;
    private final String mimeType;

    private ImageFormat(String str, String str2) {
        this.mimeType = str;
        this.extension = str2;
    }

    public final String getExtension() {
        return this.extension;
    }

    public final String getMimeType() {
        return this.mimeType;
    }
}
