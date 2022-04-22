package editor.common.mediapicker;

import android.graphics.BitmapFactory;
import android.graphics.Rect;
import androidx.exifinterface.media.ExifInterface;
import com.memes.commons.media.MediaContent;
import com.memes.commons.media.MediaType;
import java.io.File;
import java.io.FileInputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\r"}, mo26107d2 = {"Leditor/common/mediapicker/MediaResolverHelper;", "", "()V", "removeExifOrientation", "", "file", "Ljava/io/File;", "tryProcessGif", "Lcom/memes/commons/media/MediaContent;", "tryProcessPhoto", "contentType", "", "tryProcessVideo", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaResolverHelper.kt */
public final class MediaResolverHelper {
    public static final MediaResolverHelper INSTANCE = new MediaResolverHelper();

    private MediaResolverHelper() {
    }

    public final MediaContent tryProcessPhoto(int i, File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (!file.exists()) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(fileInputStream, (Rect) null, options);
        fileInputStream.close();
        Timber.m306i("tryProcessPhoto %d %s %d %d", Integer.valueOf(i), file.getAbsolutePath(), Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
        removeExifOrientation(file);
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
        return new MediaContent(i, absolutePath, Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
    }

    public final MediaContent tryProcessGif(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (!file.exists()) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(fileInputStream, (Rect) null, options);
        fileInputStream.close();
        Timber.m306i("tryProcessGif %s %d %d", file.getAbsolutePath(), Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
        return new MediaContent(MediaType.GIF, absolutePath, Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0085, code lost:
        if (r5.intValue() == 270) goto L_0x0087;
     */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.memes.commons.media.MediaContent tryProcessVideo(int r13, java.io.File r14) {
        /*
            r12 = this;
            java.lang.String r0 = "file"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            boolean r0 = r14.exists()
            r1 = 0
            if (r0 == 0) goto L_0x00d7
            r0 = r1
            android.media.MediaMetadataRetriever r0 = (android.media.MediaMetadataRetriever) r0
            r2 = r1
            java.io.FileInputStream r2 = (java.io.FileInputStream) r2
            android.media.MediaMetadataRetriever r3 = new android.media.MediaMetadataRetriever     // Catch:{ Exception -> 0x00bb }
            r3.<init>()     // Catch:{ Exception -> 0x00bb }
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            java.lang.String r4 = r14.getAbsolutePath()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            java.io.FileDescriptor r2 = r0.getFD()     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            r3.setDataSource(r2)     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            r2 = 18
            java.lang.String r2 = r3.extractMetadata(r2)     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            if (r2 == 0) goto L_0x0034
            java.lang.Integer r2 = kotlin.text.StringsKt.toIntOrNull(r2)     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            goto L_0x0035
        L_0x0034:
            r2 = r1
        L_0x0035:
            r4 = 19
            java.lang.String r4 = r3.extractMetadata(r4)     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            if (r4 == 0) goto L_0x0042
            java.lang.Integer r4 = kotlin.text.StringsKt.toIntOrNull(r4)     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            goto L_0x0043
        L_0x0042:
            r4 = r1
        L_0x0043:
            r5 = 24
            java.lang.String r5 = r3.extractMetadata(r5)     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            if (r5 == 0) goto L_0x0050
            java.lang.Integer r5 = kotlin.text.StringsKt.toIntOrNull(r5)     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            goto L_0x0051
        L_0x0050:
            r5 = r1
        L_0x0051:
            java.lang.String r6 = "tryProcessVideo %d %s %d %d %d"
            r7 = 5
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r13)     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            r9 = 0
            r7[r9] = r8     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            java.lang.String r8 = r14.getAbsolutePath()     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            r10 = 1
            r7[r10] = r8     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            r8 = 2
            r7[r8] = r2     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            r11 = 3
            r7[r11] = r4     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            r11 = 4
            r7[r11] = r5     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            timber.log.Timber.m306i(r6, r7)     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            if (r5 != 0) goto L_0x0073
            goto L_0x007c
        L_0x0073:
            int r6 = r5.intValue()     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            r7 = 90
            if (r6 != r7) goto L_0x007c
            goto L_0x0087
        L_0x007c:
            if (r5 != 0) goto L_0x007f
            goto L_0x008e
        L_0x007f:
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            r6 = 270(0x10e, float:3.78E-43)
            if (r5 != r6) goto L_0x008e
        L_0x0087:
            java.lang.Integer[] r5 = new java.lang.Integer[r8]     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            r5[r9] = r4     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            r5[r10] = r2     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            goto L_0x0094
        L_0x008e:
            java.lang.Integer[] r5 = new java.lang.Integer[r8]     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            r5[r9] = r2     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            r5[r10] = r4     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
        L_0x0094:
            r2 = r5[r9]     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            r4 = r5[r10]     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            com.memes.commons.media.MediaContent r5 = new com.memes.commons.media.MediaContent     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            java.lang.String r14 = r14.getAbsolutePath()     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            java.lang.String r6 = "file.absolutePath"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r6)     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            r5.<init>(r13, r14, r2, r4)     // Catch:{ Exception -> 0x00b0, all -> 0x00ad }
            r3.release()
            r0.close()
            return r5
        L_0x00ad:
            r13 = move-exception
            r2 = r0
            goto L_0x00b4
        L_0x00b0:
            r13 = move-exception
            r2 = r0
            goto L_0x00b7
        L_0x00b3:
            r13 = move-exception
        L_0x00b4:
            r0 = r3
            goto L_0x00cc
        L_0x00b6:
            r13 = move-exception
        L_0x00b7:
            r0 = r3
            goto L_0x00bc
        L_0x00b9:
            r13 = move-exception
            goto L_0x00cc
        L_0x00bb:
            r13 = move-exception
        L_0x00bc:
            java.lang.Throwable r13 = (java.lang.Throwable) r13     // Catch:{ all -> 0x00b9 }
            timber.log.Timber.m304e(r13)     // Catch:{ all -> 0x00b9 }
            if (r0 == 0) goto L_0x00c6
            r0.release()
        L_0x00c6:
            if (r2 == 0) goto L_0x00d7
            r2.close()
            goto L_0x00d7
        L_0x00cc:
            if (r0 == 0) goto L_0x00d1
            r0.release()
        L_0x00d1:
            if (r2 == 0) goto L_0x00d6
            r2.close()
        L_0x00d6:
            throw r13
        L_0x00d7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.common.mediapicker.MediaResolverHelper.tryProcessVideo(int, java.io.File):com.memes.commons.media.MediaContent");
    }

    private final void removeExifOrientation(File file) {
        try {
            ExifInterface exifInterface = new ExifInterface(file.getAbsolutePath());
            String attribute = exifInterface.getAttribute(ExifInterface.TAG_ORIENTATION);
            Integer intOrNull = attribute != null ? StringsKt.toIntOrNull(attribute) : null;
            if (intOrNull != null && intOrNull.intValue() != 1) {
                Timber.m303e("removeExifOrientation: removing orientation " + intOrNull + " from " + file.getAbsolutePath(), new Object[0]);
                exifInterface.setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(1));
                exifInterface.saveAttributes();
            }
        } catch (Exception e) {
            Timber.m303e("removeExifOrientation failed: " + e.getMessage(), new Object[0]);
        }
    }
}
