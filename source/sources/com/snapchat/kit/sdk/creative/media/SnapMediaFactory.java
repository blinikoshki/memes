package com.snapchat.kit.sdk.creative.media;

import android.media.MediaMetadataRetriever;
import android.support.p003v4.media.session.PlaybackStateCompat;
import com.facebook.common.statfs.StatFsHelper;
import com.snapchat.kit.sdk.creative.exceptions.SnapMediaSizeException;
import com.snapchat.kit.sdk.creative.exceptions.SnapStickerSizeException;
import com.snapchat.kit.sdk.creative.exceptions.SnapVideoLengthException;
import com.snapchat.kit.sdk.creative.p045b.C4472c;
import java.io.File;
import javax.inject.Inject;

public class SnapMediaFactory {

    /* renamed from: a */
    private final C4472c f1283a;

    @Inject
    SnapMediaFactory(C4472c cVar) {
        this.f1283a = cVar;
    }

    public SnapVideoFile getSnapVideoFromFile(File file) throws SnapMediaSizeException, SnapVideoLengthException {
        long length = file.length();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(file.getPath());
        String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
        mediaMetadataRetriever.release();
        if (Integer.valueOf(extractMetadata).intValue() >= 60000) {
            this.f1283a.mo61749a("exceptionVideoLength");
            throw new SnapVideoLengthException("Video must be under 1 minute long");
        } else if (length < StatFsHelper.DEFAULT_DISK_RED_LEVEL_IN_BYTES) {
            this.f1283a.mo61750a("videoLength", Long.valueOf(extractMetadata).longValue());
            return new SnapVideoFile(file);
        } else {
            this.f1283a.mo61749a("exceptionMediaSize");
            throw new SnapMediaSizeException("Media file size should be under 100MB");
        }
    }

    public SnapPhotoFile getSnapPhotoFromFile(File file) throws SnapMediaSizeException {
        if (file.length() < StatFsHelper.DEFAULT_DISK_RED_LEVEL_IN_BYTES) {
            return new SnapPhotoFile(file);
        }
        this.f1283a.mo61749a("exceptionMediaSize");
        throw new SnapMediaSizeException("Media file size should be under 100MB");
    }

    public SnapSticker getSnapStickerFromFile(File file) throws SnapStickerSizeException {
        if (file.length() < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            return new SnapSticker(file);
        }
        this.f1283a.mo61749a("exceptionStickerSize");
        throw new SnapStickerSizeException("Sticker file size should be under 1MB");
    }
}
