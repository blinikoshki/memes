package com.memes.commons.media;

import java.io.File;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0003\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0004"}, mo26107d2 = {"delete", "", "Lcom/memes/commons/media/MediaContent;", "exists", "commons_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: MediaContent.kt */
public final class MediaContentKt {
    public static final boolean delete(MediaContent mediaContent) {
        if (mediaContent == null) {
            return false;
        }
        File asFile = mediaContent.asFile();
        if (asFile.exists()) {
            return asFile.delete();
        }
        return false;
    }

    public static final boolean exists(MediaContent mediaContent) {
        if (mediaContent == null) {
            return false;
        }
        return mediaContent.asFile().exists();
    }
}
