package com.getstream.sdk.chat.utils;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.getstream.sdk.chat.model.AttachmentMetaData;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;

@InternalStreamChatApi
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\nJ\u001a\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u0011\u001a\u00020\u0012J \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0002J\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0012\u0010\u001f\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010 \u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010!\u001a\u00020\"2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010#\u001a\u00020\"2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006%"}, mo26107d2 = {"Lcom/getstream/sdk/chat/utils/StorageHelper;", "", "()V", "dateFormat", "Ljava/text/SimpleDateFormat;", "projection", "", "", "[Ljava/lang/String;", "getAttachmentFromCursor", "Lcom/getstream/sdk/chat/model/AttachmentMetaData;", "cursor", "Landroid/database/Cursor;", "contentUri", "Landroid/net/Uri;", "getAttachmentsFromUriList", "", "context", "Landroid/content/Context;", "uriList", "getCachedFileFromUri", "Ljava/io/File;", "attachmentMetaData", "getContentUri", "mimeType", "id", "", "getFileAttachments", "getFilteredAttachments", "selection", "getMediaAttachments", "getModelType", "getUniqueCacheFolder", "isImage", "", "isVideo", "Companion", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: StorageHelper.kt */
public final class StorageHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String FILE_NAME_PREFIX = "STREAM_";
    public static final String TIME_FORMAT = "HHmmssSSS";
    private final SimpleDateFormat dateFormat = new SimpleDateFormat(TIME_FORMAT, Locale.US);
    private final String[] projection = {"_id", "_display_name", "mime_type", "_size", "duration"};

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0090, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        kotlin.p017io.CloseableKt.closeFinally(r3, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0094, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0097, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0098, code lost:
        kotlin.p017io.CloseableKt.closeFinally(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009b, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.io.File getCachedFileFromUri(android.content.Context r9, com.getstream.sdk.chat.model.AttachmentMetaData r10) {
        /*
            r8 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "attachmentMetaData"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.io.File r0 = r10.getFile()
            if (r0 != 0) goto L_0x0035
            android.net.Uri r0 = r10.getUri()
            if (r0 == 0) goto L_0x0017
            goto L_0x0035
        L_0x0017:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unable to create cache file for attachment: "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r10 = ". Either file or URI cannot be null."
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            r9.<init>(r10)
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            throw r9
        L_0x0035:
            java.io.File r0 = r10.getFile()
            if (r0 == 0) goto L_0x0043
            java.io.File r9 = r10.getFile()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            return r9
        L_0x0043:
            java.io.File r0 = new java.io.File
            java.io.File r1 = r8.getUniqueCacheFolder(r9)
            java.lang.String r2 = com.getstream.sdk.chat.utils.StorageHelperKt.getTitleWithExtension(r10)
            r0.<init>(r1, r2)
            android.content.ContentResolver r9 = r9.getContentResolver()
            android.net.Uri r10 = r10.getUri()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            java.io.InputStream r9 = r9.openInputStream(r10)
            if (r9 == 0) goto L_0x009c
            java.io.Closeable r9 = (java.io.Closeable) r9
            r10 = 0
            r1 = r10
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            r2 = r9
            java.io.InputStream r2 = (java.io.InputStream) r2     // Catch:{ all -> 0x0095 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x0095 }
            r3.<init>(r0)     // Catch:{ all -> 0x0095 }
            java.io.Closeable r3 = (java.io.Closeable) r3     // Catch:{ all -> 0x0095 }
            r4 = r10
            java.lang.Throwable r4 = (java.lang.Throwable) r4     // Catch:{ all -> 0x0095 }
            r5 = r3
            java.io.FileOutputStream r5 = (java.io.FileOutputStream) r5     // Catch:{ all -> 0x008e }
            java.lang.String r6 = "inputStream"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)     // Catch:{ all -> 0x008e }
            java.io.OutputStream r5 = (java.io.OutputStream) r5     // Catch:{ all -> 0x008e }
            r6 = 0
            r7 = 2
            long r5 = kotlin.p017io.ByteStreamsKt.copyTo$default(r2, r5, r6, r7, r10)     // Catch:{ all -> 0x008e }
            kotlin.p017io.CloseableKt.closeFinally(r3, r4)     // Catch:{ all -> 0x0095 }
            java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0095 }
            kotlin.p017io.CloseableKt.closeFinally(r9, r1)
            goto L_0x009c
        L_0x008e:
            r10 = move-exception
            throw r10     // Catch:{ all -> 0x0090 }
        L_0x0090:
            r0 = move-exception
            kotlin.p017io.CloseableKt.closeFinally(r3, r10)     // Catch:{ all -> 0x0095 }
            throw r0     // Catch:{ all -> 0x0095 }
        L_0x0095:
            r10 = move-exception
            throw r10     // Catch:{ all -> 0x0097 }
        L_0x0097:
            r0 = move-exception
            kotlin.p017io.CloseableKt.closeFinally(r9, r10)
            throw r0
        L_0x009c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.utils.StorageHelper.getCachedFileFromUri(android.content.Context, com.getstream.sdk.chat.model.AttachmentMetaData):java.io.File");
    }

    public final List<AttachmentMetaData> getFileAttachments(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getFilteredAttachments(context, (String) null);
    }

    public final List<AttachmentMetaData> getMediaAttachments(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getFilteredAttachments(context, "media_type=1 OR media_type=3");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0041, code lost:
        kotlin.p017io.CloseableKt.closeFinally(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<com.getstream.sdk.chat.model.AttachmentMetaData> getFilteredAttachments(android.content.Context r7, java.lang.String r8) {
        /*
            r6 = this;
            android.content.ContentResolver r0 = r7.getContentResolver()
            java.lang.String r7 = "external"
            android.net.Uri r1 = android.provider.MediaStore.Files.getContentUri(r7)
            java.lang.String[] r2 = r6.projection
            r4 = 0
            java.lang.String r5 = "date_added DESC"
            r3 = r8
            android.database.Cursor r7 = r0.query(r1, r2, r3, r4, r5)
            if (r7 == 0) goto L_0x0045
            java.io.Closeable r7 = (java.io.Closeable) r7
            r8 = 0
            r0 = r8
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r1 = r7
            android.database.Cursor r1 = (android.database.Cursor) r1     // Catch:{ all -> 0x003e }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x003e }
            r2.<init>()     // Catch:{ all -> 0x003e }
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x003e }
        L_0x0026:
            boolean r3 = r1.moveToNext()     // Catch:{ all -> 0x003e }
            if (r3 == 0) goto L_0x003a
            java.lang.String r3 = "cursor"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)     // Catch:{ all -> 0x003e }
            r3 = 2
            com.getstream.sdk.chat.model.AttachmentMetaData r3 = getAttachmentFromCursor$default(r6, r1, r8, r3, r8)     // Catch:{ all -> 0x003e }
            r2.add(r3)     // Catch:{ all -> 0x003e }
            goto L_0x0026
        L_0x003a:
            kotlin.p017io.CloseableKt.closeFinally(r7, r0)
            return r2
        L_0x003e:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x0040 }
        L_0x0040:
            r0 = move-exception
            kotlin.p017io.CloseableKt.closeFinally(r7, r8)
            throw r0
        L_0x0045:
            java.util.List r7 = kotlin.collections.CollectionsKt.emptyList()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.utils.StorageHelper.getFilteredAttachments(android.content.Context, java.lang.String):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004f, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0050, code lost:
        kotlin.p017io.CloseableKt.closeFinally(r2, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0053, code lost:
        throw r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.getstream.sdk.chat.model.AttachmentMetaData> getAttachmentsFromUriList(android.content.Context r9, java.util.List<? extends android.net.Uri> r10) {
        /*
            r8 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "uriList"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r10 = r10.iterator()
        L_0x0018:
            boolean r1 = r10.hasNext()
            if (r1 == 0) goto L_0x005a
            java.lang.Object r1 = r10.next()
            android.net.Uri r1 = (android.net.Uri) r1
            android.content.ContentResolver r2 = r9.getContentResolver()
            java.lang.String[] r4 = r8.projection
            r5 = 0
            r6 = 0
            r7 = 0
            r3 = r1
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7)
            r3 = 0
            if (r2 == 0) goto L_0x0054
            java.io.Closeable r2 = (java.io.Closeable) r2
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            r4 = r2
            android.database.Cursor r4 = (android.database.Cursor) r4     // Catch:{ all -> 0x004d }
            r4.moveToFirst()     // Catch:{ all -> 0x004d }
            java.lang.String r5 = "cursor"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ all -> 0x004d }
            com.getstream.sdk.chat.model.AttachmentMetaData r1 = r8.getAttachmentFromCursor(r4, r1)     // Catch:{ all -> 0x004d }
            kotlin.p017io.CloseableKt.closeFinally(r2, r3)
            r3 = r1
            goto L_0x0054
        L_0x004d:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x004f }
        L_0x004f:
            r10 = move-exception
            kotlin.p017io.CloseableKt.closeFinally(r2, r9)
            throw r10
        L_0x0054:
            if (r3 == 0) goto L_0x0018
            r0.add(r3)
            goto L_0x0018
        L_0x005a:
            java.util.List r0 = (java.util.List) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.utils.StorageHelper.getAttachmentsFromUriList(android.content.Context, java.util.List):java.util.List");
    }

    static /* synthetic */ AttachmentMetaData getAttachmentFromCursor$default(StorageHelper storageHelper, Cursor cursor, Uri uri, int i, Object obj) {
        if ((i & 2) != 0) {
            uri = null;
        }
        return storageHelper.getAttachmentFromCursor(cursor, uri);
    }

    private final AttachmentMetaData getAttachmentFromCursor(Cursor cursor, Uri uri) {
        Cursor cursor2 = cursor;
        long j = cursor2.getLong(cursor2.getColumnIndex("_id"));
        String string = cursor2.getString(cursor2.getColumnIndex("mime_type"));
        String string2 = cursor2.getString(cursor2.getColumnIndex("_display_name"));
        long j2 = cursor2.getLong(cursor2.getColumnIndex("_size"));
        int columnIndex = cursor2.getColumnIndex("duration");
        Long valueOf = cursor2.isNull(columnIndex) ? null : Long.valueOf(cursor2.getLong(columnIndex));
        long longValue = valueOf != null ? valueOf.longValue() : 0;
        AttachmentMetaData attachmentMetaData = new AttachmentMetaData(uri != null ? uri : getContentUri(string, j), (String) null, string, (String) null, (File) null, 26, (DefaultConstructorMarker) null);
        attachmentMetaData.setType(getModelType(string));
        attachmentMetaData.setSize(j2);
        attachmentMetaData.setTitle(string2);
        attachmentMetaData.setVideoLength(longValue / ((long) 1000));
        return attachmentMetaData;
    }

    private final Uri getContentUri(String str, long j) {
        Uri uri;
        if (isImage(str)) {
            uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            Intrinsics.checkNotNullExpressionValue(uri, "MediaStore.Images.Media.EXTERNAL_CONTENT_URI");
        } else if (isVideo(str)) {
            uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            Intrinsics.checkNotNullExpressionValue(uri, "MediaStore.Video.Media.EXTERNAL_CONTENT_URI");
        } else {
            uri = MediaStore.Files.getContentUri("external");
            Intrinsics.checkNotNullExpressionValue(uri, "MediaStore.Files.getContentUri(\"external\")");
        }
        Uri withAppendedId = ContentUris.withAppendedId(uri, j);
        Intrinsics.checkNotNullExpressionValue(withAppendedId, "ContentUris.withAppendedId(contentUri, id)");
        return withAppendedId;
    }

    private final String getModelType(String str) {
        if (isImage(str)) {
            return "image";
        }
        return isVideo(str) ? "video" : "file";
    }

    private final boolean isImage(String str) {
        if (str != null) {
            return StringsKt.startsWith$default(str, "image", false, 2, (Object) null);
        }
        return false;
    }

    private final boolean isVideo(String str) {
        if (str != null) {
            return StringsKt.startsWith$default(str, "video", false, 2, (Object) null);
        }
        return false;
    }

    private final File getUniqueCacheFolder(Context context) {
        File cacheDir = context.getCacheDir();
        File file = new File(cacheDir, FILE_NAME_PREFIX + this.dateFormat.format(Long.valueOf(new Date().getTime())));
        file.mkdirs();
        return file;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Lcom/getstream/sdk/chat/utils/StorageHelper$Companion;", "", "()V", "FILE_NAME_PREFIX", "", "TIME_FORMAT", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: StorageHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
