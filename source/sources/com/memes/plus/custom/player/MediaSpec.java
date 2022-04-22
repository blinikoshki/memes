package com.memes.plus.custom.player;

import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\n"}, mo26107d2 = {"Lcom/memes/plus/custom/player/MediaSpec;", "", "()V", "isM3uMedia", "", "uri", "Landroid/net/Uri;", "isMp3Media", "isMp3OrMp4Media", "isMp4Media", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaSpec.kt */
public final class MediaSpec {
    public static final MediaSpec INSTANCE = new MediaSpec();

    private MediaSpec() {
    }

    public final boolean isMp3OrMp4Media(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        return isMp3Media(uri) || isMp4Media(uri);
    }

    public final boolean isMp3Media(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment != null) {
            return StringsKt.contains$default((CharSequence) lastPathSegment, (CharSequence) "mp3", false, 2, (Object) null);
        }
        return false;
    }

    public final boolean isM3uMedia(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment != null) {
            return StringsKt.contains$default((CharSequence) lastPathSegment, (CharSequence) "m3u8", false, 2, (Object) null);
        }
        return false;
    }

    public final boolean isMp4Media(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment != null) {
            return StringsKt.contains$default((CharSequence) lastPathSegment, (CharSequence) "mp4", false, 2, (Object) null);
        }
        return false;
    }
}
