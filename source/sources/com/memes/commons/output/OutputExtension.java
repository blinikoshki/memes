package com.memes.commons.output;

import com.memes.commons.media.MediaType;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Lcom/memes/commons/output/OutputExtension;", "", "()V", "GIF", "", "JPG", "LOG", "MP4", "PNG", "UNKNOWN", "fromMediaType", "type", "", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: OutputExtension.kt */
public final class OutputExtension {
    public static final String GIF = ".gif";
    public static final OutputExtension INSTANCE = new OutputExtension();
    public static final String JPG = ".jpg";
    public static final String LOG = ".mlog";
    public static final String MP4 = ".mp4";
    public static final String PNG = ".png";
    public static final String UNKNOWN = ".whatfile";

    private OutputExtension() {
    }

    public final String fromMediaType(int i) {
        if (MediaType.INSTANCE.isPhoto(i)) {
            return JPG;
        }
        if (MediaType.INSTANCE.isGif(i)) {
            return GIF;
        }
        if (MediaType.INSTANCE.isVideo(i)) {
            return MP4;
        }
        boolean isGifVideo = MediaType.INSTANCE.isGifVideo(i);
        return MP4;
    }
}
