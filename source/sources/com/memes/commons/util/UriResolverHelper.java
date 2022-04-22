package com.memes.commons.util;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.memes.commons.media.MediaContent;
import com.memes.commons.media.MediaContentDownloader;
import com.memes.commons.media.MediaType;
import com.memes.commons.output.OutputExtension;
import com.memes.commons.output.OutputTargetGenerator;
import com.memes.uritool.UriResolver;
import com.memes.uritool.resolve.UriResolveResult;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001 B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014J\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00142\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nJ&\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nJ \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0014H\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0005H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, mo26107d2 = {"Lcom/memes/commons/util/UriResolverHelper;", "", "context", "Landroid/content/Context;", "outputRelativePath", "", "outputTargetGenerator", "Lcom/memes/commons/output/OutputTargetGenerator;", "(Landroid/content/Context;Ljava/lang/String;Lcom/memes/commons/output/OutputTargetGenerator;)V", "callback", "Lcom/memes/commons/util/UriResolverHelper$Callback;", "uriResolver", "Lcom/memes/uritool/UriResolver;", "canReadFile", "", "file", "Ljava/io/File;", "createMediaContent", "Lcom/memes/commons/media/MediaContent;", "type", "", "import", "", "contentUri", "Landroid/net/Uri;", "contentType", "contentMime", "extension", "processPhotoFromFile", "processVideoFromMediaMetadata", "reportError", "error", "Callback", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: UriResolverHelper.kt */
public final class UriResolverHelper {
    /* access modifiers changed from: private */
    public Callback callback;
    private final String outputRelativePath;
    private final OutputTargetGenerator outputTargetGenerator;
    private final UriResolver uriResolver;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, mo26107d2 = {"Lcom/memes/commons/util/UriResolverHelper$Callback;", "", "onUriResolveError", "", "error", "", "onUriResolved", "content", "Lcom/memes/commons/media/MediaContent;", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: UriResolverHelper.kt */
    public interface Callback {
        void onUriResolveError(String str);

        void onUriResolved(MediaContent mediaContent);
    }

    public UriResolverHelper(Context context, String str, OutputTargetGenerator outputTargetGenerator2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "outputRelativePath");
        this.outputRelativePath = str;
        UriResolver.Companion companion = UriResolver.Companion;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.uriResolver = companion.from(applicationContext);
        this.outputTargetGenerator = outputTargetGenerator2 == null ? OutputTargetGenerator.Companion.fromCacheDirectory(context) : outputTargetGenerator2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UriResolverHelper(Context context, String str, OutputTargetGenerator outputTargetGenerator2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i & 4) != 0 ? null : outputTargetGenerator2);
    }

    public static /* synthetic */ void import$default(UriResolverHelper uriResolverHelper, Uri uri, String str, Callback callback2, int i, Object obj) {
        if ((i & 4) != 0) {
            callback2 = null;
        }
        uriResolverHelper.m2573import(uri, str, callback2);
    }

    /* renamed from: import  reason: not valid java name */
    public final void m2573import(Uri uri, String str, Callback callback2) {
        this.callback = callback2;
        if (uri == null) {
            reportError("Content Uri is null");
        } else if (Intrinsics.areEqual((Object) uri, (Object) Uri.EMPTY)) {
            reportError("Content Uri is empty");
        } else {
            CharSequence charSequence = str;
            int i = 0;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                reportError("Content mime type is either empty or null.");
                return;
            }
            if (StringsKt.startsWith$default(str, "image/", false, 2, (Object) null)) {
                i = MediaType.PHOTO;
            } else if (StringsKt.startsWith$default(str, "video/", false, 2, (Object) null)) {
                i = MediaType.VIDEO;
            }
            if (i == 0) {
                reportError("Content mime type doesn't belong to an image or video");
            } else {
                m2572import(uri, i, callback2);
            }
        }
    }

    public static /* synthetic */ void import$default(UriResolverHelper uriResolverHelper, Uri uri, int i, Callback callback2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            callback2 = null;
        }
        uriResolverHelper.m2572import(uri, i, callback2);
    }

    /* renamed from: import  reason: not valid java name */
    public final void m2572import(Uri uri, int i, Callback callback2) {
        Intrinsics.checkNotNullParameter(uri, "contentUri");
        this.callback = callback2;
        String str = i != 1231 ? i != 1232 ? i != 1235 ? OutputExtension.UNKNOWN : OutputExtension.GIF : OutputExtension.MP4 : OutputExtension.JPG;
        File outputFile = OutputTargetGenerator.setDefaultOutputDestination$default(this.outputTargetGenerator, this.outputRelativePath, (String) null, str, false, false, 26, (Object) null).getOutputFile();
        UriResolveResult createResolve$default = UriResolver.createResolve$default(this.uriResolver.setUri(uri), outputFile, (List) null, 2, (Object) null);
        if (!createResolve$default.hasFile()) {
            reportError("Failed to resolve Uri; error=" + createResolve$default.getError());
            return;
        }
        File file = createResolve$default.getFile();
        if (!canReadFile(file)) {
            reportError("File access is private & it can't be read.");
            return;
        }
        if (!Intrinsics.areEqual((Object) file.getAbsolutePath(), (Object) outputFile.getAbsolutePath())) {
            outputFile.delete();
        }
        Timber.m300d("Uri resolved to file=" + file, new Object[0]);
        if (this.outputTargetGenerator.existsInRootDirectory(file)) {
            MediaContent createMediaContent = createMediaContent(file, i);
            if (callback2 != null) {
                callback2.onUriResolved(createMediaContent);
                return;
            }
            return;
        }
        m2571import(file, str, i);
    }

    private final boolean canReadFile(File file) {
        try {
            return file.canRead();
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: import  reason: not valid java name */
    private final void m2571import(File file, String str, int i) {
        MediaContentDownloader.Companion.get().storeAt(OutputTargetGenerator.setDefaultOutputDestination$default(this.outputTargetGenerator, this.outputRelativePath, (String) null, (String) null, false, false, 14, (Object) null).getOutputDirectory(), str).callback(new UriResolverHelper$import$1(this, i)).download(file);
    }

    public final MediaContent createMediaContent(File file, int i) {
        MediaContent mediaContent;
        Intrinsics.checkNotNullParameter(file, "file");
        if (i != 1231) {
            mediaContent = i != 1232 ? null : processVideoFromMediaMetadata(file);
        } else {
            mediaContent = processPhotoFromFile(file);
        }
        if (mediaContent != null) {
            return mediaContent;
        }
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
        return new MediaContent(i, absolutePath, (Integer) null, (Integer) null, 12, (DefaultConstructorMarker) null);
    }

    private final MediaContent processPhotoFromFile(File file) {
        Integer num = null;
        if (!file.exists()) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(fileInputStream, (Rect) null, options);
        fileInputStream.close();
        String attribute = new ExifInterface(file.getAbsolutePath()).getAttribute(ExifInterface.TAG_ORIENTATION);
        if (attribute != null) {
            num = StringsKt.toIntOrNull(attribute);
        }
        Integer[] numArr = ((num != null && num.intValue() == 6) || (num != null && num.intValue() == 8)) ? new Integer[]{Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth)} : new Integer[]{Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight)};
        int intValue = numArr[0].intValue();
        int intValue2 = numArr[1].intValue();
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
        return new MediaContent(MediaType.PHOTO, absolutePath, Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0064, code lost:
        if (r5.intValue() == 270) goto L_0x0066;
     */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.memes.commons.media.MediaContent processVideoFromMediaMetadata(java.io.File r12) {
        /*
            r11 = this;
            boolean r0 = r12.exists()
            r1 = 0
            if (r0 == 0) goto L_0x00b8
            r0 = r1
            android.media.MediaMetadataRetriever r0 = (android.media.MediaMetadataRetriever) r0
            r2 = r1
            java.io.FileInputStream r2 = (java.io.FileInputStream) r2
            android.media.MediaMetadataRetriever r3 = new android.media.MediaMetadataRetriever     // Catch:{ Exception -> 0x009c }
            r3.<init>()     // Catch:{ Exception -> 0x009c }
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0097, all -> 0x0094 }
            java.lang.String r4 = r12.getAbsolutePath()     // Catch:{ Exception -> 0x0097, all -> 0x0094 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x0097, all -> 0x0094 }
            java.io.FileDescriptor r2 = r0.getFD()     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r3.setDataSource(r2)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r2 = 18
            java.lang.String r2 = r3.extractMetadata(r2)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            if (r2 == 0) goto L_0x002f
            java.lang.Integer r2 = kotlin.text.StringsKt.toIntOrNull(r2)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            goto L_0x0030
        L_0x002f:
            r2 = r1
        L_0x0030:
            r4 = 19
            java.lang.String r4 = r3.extractMetadata(r4)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            if (r4 == 0) goto L_0x003d
            java.lang.Integer r4 = kotlin.text.StringsKt.toIntOrNull(r4)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            goto L_0x003e
        L_0x003d:
            r4 = r1
        L_0x003e:
            r5 = 24
            java.lang.String r5 = r3.extractMetadata(r5)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            if (r5 == 0) goto L_0x004b
            java.lang.Integer r5 = kotlin.text.StringsKt.toIntOrNull(r5)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            goto L_0x004c
        L_0x004b:
            r5 = r1
        L_0x004c:
            r6 = 2
            r7 = 1
            r8 = 0
            if (r5 != 0) goto L_0x0052
            goto L_0x005b
        L_0x0052:
            int r9 = r5.intValue()     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r10 = 90
            if (r9 != r10) goto L_0x005b
            goto L_0x0066
        L_0x005b:
            if (r5 != 0) goto L_0x005e
            goto L_0x006d
        L_0x005e:
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r9 = 270(0x10e, float:3.78E-43)
            if (r5 != r9) goto L_0x006d
        L_0x0066:
            java.lang.Integer[] r5 = new java.lang.Integer[r6]     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r5[r8] = r4     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r5[r7] = r2     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            goto L_0x0073
        L_0x006d:
            java.lang.Integer[] r5 = new java.lang.Integer[r6]     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r5[r8] = r2     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r5[r7] = r4     // Catch:{ Exception -> 0x0091, all -> 0x008e }
        L_0x0073:
            r2 = r5[r8]     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r4 = r5[r7]     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            com.memes.commons.media.MediaContent r5 = new com.memes.commons.media.MediaContent     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r6 = 1232(0x4d0, float:1.726E-42)
            java.lang.String r12 = r12.getAbsolutePath()     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            java.lang.String r7 = "file.absolutePath"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r7)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r5.<init>(r6, r12, r2, r4)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r3.release()
            r0.close()
            return r5
        L_0x008e:
            r12 = move-exception
            r2 = r0
            goto L_0x0095
        L_0x0091:
            r12 = move-exception
            r2 = r0
            goto L_0x0098
        L_0x0094:
            r12 = move-exception
        L_0x0095:
            r0 = r3
            goto L_0x00ad
        L_0x0097:
            r12 = move-exception
        L_0x0098:
            r0 = r3
            goto L_0x009d
        L_0x009a:
            r12 = move-exception
            goto L_0x00ad
        L_0x009c:
            r12 = move-exception
        L_0x009d:
            java.lang.Throwable r12 = (java.lang.Throwable) r12     // Catch:{ all -> 0x009a }
            timber.log.Timber.m304e(r12)     // Catch:{ all -> 0x009a }
            if (r0 == 0) goto L_0x00a7
            r0.release()
        L_0x00a7:
            if (r2 == 0) goto L_0x00b8
            r2.close()
            goto L_0x00b8
        L_0x00ad:
            if (r0 == 0) goto L_0x00b2
            r0.release()
        L_0x00b2:
            if (r2 == 0) goto L_0x00b7
            r2.close()
        L_0x00b7:
            throw r12
        L_0x00b8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.commons.util.UriResolverHelper.processVideoFromMediaMetadata(java.io.File):com.memes.commons.media.MediaContent");
    }

    /* access modifiers changed from: private */
    public final void reportError(String str) {
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onUriResolveError(str);
        }
    }
}
