package com.memes.commons.media;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo26107d2 = {"Lcom/memes/commons/media/MediaType;", "", "()V", "GIF", "", "GIFV", "NETWORK_GIF", "NETWORK_GIFV", "NETWORK_PHOTO", "NETWORK_VIDEO", "PHOTO", "UNKNOWN", "VIDEO", "isGif", "", "type", "isGifVideo", "isPhoto", "isVideo", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaType.kt */
public final class MediaType {
    public static final int GIF = 1235;
    public static final int GIFV = 1237;
    public static final MediaType INSTANCE = new MediaType();
    public static final int NETWORK_GIF = 1236;
    public static final int NETWORK_GIFV = 1238;
    public static final int NETWORK_PHOTO = 1233;
    public static final int NETWORK_VIDEO = 1234;
    public static final int PHOTO = 1231;
    public static final int UNKNOWN = 0;
    public static final int VIDEO = 1232;

    public final boolean isGif(int i) {
        return i == 1235 || i == 1236;
    }

    public final boolean isGifVideo(int i) {
        return i == 1237 || i == 1238;
    }

    public final boolean isPhoto(int i) {
        return i == 1231 || i == 1233;
    }

    public final boolean isVideo(int i) {
        return i == 1232 || i == 1234;
    }

    private MediaType() {
    }
}
