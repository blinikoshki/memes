package com.memes.uritool.source;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import com.facebook.share.internal.ShareConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo26107d2 = {"Lcom/memes/uritool/source/DocumentsUriSource;", "Lcom/memes/uritool/source/UriSource;", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "(Landroid/content/Context;Landroid/net/Uri;)V", "isDownloadsDocument", "", "isExternalStorageDocument", "isMediaDocument", "isSupportedUri", "resolve", "Lcom/memes/uritool/resolve/UriResolveResult;", "tryFilePath", "Ljava/io/File;", "filePath", "", "uritool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: DocumentsUriSource.kt */
public final class DocumentsUriSource implements UriSource {
    private final Context context;
    private final Uri uri;

    public DocumentsUriSource(Context context2, Uri uri2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
        this.context = context2;
        this.uri = uri2;
    }

    public boolean isSupportedUri() {
        return DocumentsContract.isDocumentUri(this.context, this.uri) || isDownloadsDocument(this.uri) || isExternalStorageDocument(this.uri) || isMediaDocument(this.uri);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0151, code lost:
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0153, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0154, code lost:
        timber.log.Timber.m300d("Unable to retrieve document information with uri; uri=" + r15.uri + ", exception=" + r0, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x017a, code lost:
        return com.memes.uritool.resolve.UriResolveResult.Companion.error("Unable to retrieve document information with uri.");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[ExcHandler: NumberFormatException (unused java.lang.NumberFormatException), SYNTHETIC, Splitter:B:25:0x00df] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0153 A[ExcHandler: Exception (r0v45 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:22:0x00d2] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x029c  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02c5  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.memes.uritool.resolve.UriResolveResult resolve() {
        /*
            r15 = this;
            java.lang.String r0 = " failed for uri="
            java.lang.String r1 = "ContentUriPrefix="
            java.lang.String r2 = ", exception="
            r3 = 0
            r4 = r3
            java.lang.String r4 = (java.lang.String) r4
            android.net.Uri r5 = r15.uri
            boolean r5 = r15.isExternalStorageDocument(r5)
            java.lang.String r6 = "null cannot be cast to non-null type kotlin.Array<T>"
            java.lang.String r7 = ":"
            java.lang.String r8 = "docId"
            r9 = 1
            r10 = 0
            if (r5 == 0) goto L_0x00c3
            java.lang.Object[] r0 = new java.lang.Object[r10]
            java.lang.String r1 = "It's a uri from DocumentProvider"
            timber.log.Timber.m300d(r1, r0)
            android.net.Uri r0 = r15.uri
            java.lang.String r0 = android.provider.DocumentsContract.getDocumentId(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r8)
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            kotlin.text.Regex r2 = new kotlin.text.Regex
            r2.<init>((java.lang.String) r7)
            java.util.List r1 = r2.split(r1, r10)
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x0069
            int r2 = r1.size()
            java.util.ListIterator r2 = r1.listIterator(r2)
        L_0x0044:
            boolean r3 = r2.hasPrevious()
            if (r3 == 0) goto L_0x0069
            java.lang.Object r3 = r2.previous()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 != 0) goto L_0x005a
            r3 = 1
            goto L_0x005b
        L_0x005a:
            r3 = 0
        L_0x005b:
            if (r3 != 0) goto L_0x0044
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            int r2 = r2.nextIndex()
            int r2 = r2 + r9
            java.util.List r1 = kotlin.collections.CollectionsKt.take(r1, r2)
            goto L_0x006d
        L_0x0069:
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
        L_0x006d:
            java.util.Collection r1 = (java.util.Collection) r1
            java.lang.String[] r2 = new java.lang.String[r10]
            java.lang.Object[] r1 = r1.toArray(r2)
            java.util.Objects.requireNonNull(r1, r6)
            java.lang.String[] r1 = (java.lang.String[]) r1
            r2 = r1[r10]
            java.lang.String r3 = "primary"
            boolean r2 = kotlin.text.StringsKt.equals(r3, r2, r9)
            if (r2 == 0) goto L_0x00a4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r2 = r2.toString()
            r0.append(r2)
            java.lang.String r2 = "/"
            r0.append(r2)
            r1 = r1[r9]
            r0.append(r1)
            java.lang.String r4 = r0.toString()
            goto L_0x02b6
        L_0x00a4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Document is not stored in primary storage; docId="
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.Object[] r1 = new java.lang.Object[r10]
            timber.log.Timber.m300d(r0, r1)
            com.memes.uritool.resolve.UriResolveResult$Companion r0 = com.memes.uritool.resolve.UriResolveResult.Companion
            java.lang.String r1 = "Document is not stored in primary storage."
            com.memes.uritool.resolve.UriResolveResult r0 = r0.error(r1)
            return r0
        L_0x00c3:
            android.net.Uri r5 = r15.uri
            boolean r5 = r15.isDownloadsDocument(r5)
            if (r5 == 0) goto L_0x0207
            java.lang.Object[] r5 = new java.lang.Object[r10]
            java.lang.String r6 = "It's a uri from DownloadsProvider"
            timber.log.Timber.m300d(r6, r5)
            android.net.Uri r5 = r15.uri     // Catch:{ NumberFormatException -> 0x017b, Exception -> 0x0153 }
            java.lang.String r5 = android.provider.DocumentsContract.getDocumentId(r5)     // Catch:{ NumberFormatException -> 0x017b, Exception -> 0x0153 }
            r6 = 3
            java.lang.String r7 = "content://downloads/public_downloads"
            java.lang.String r8 = "content://downloads/my_downloads"
            java.lang.String r11 = "content://downloads/all_downloads"
            java.lang.String[] r7 = new java.lang.String[]{r7, r8, r11}     // Catch:{ NumberFormatException -> 0x0151, Exception -> 0x0153 }
            r8 = 0
        L_0x00e4:
            if (r8 >= r6) goto L_0x02b6
            r11 = r7[r8]     // Catch:{ NumberFormatException -> 0x0151, Exception -> 0x0153 }
            android.net.Uri r12 = android.net.Uri.parse(r11)     // Catch:{ Exception -> 0x012b, NumberFormatException -> 0x0151 }
            java.lang.String r13 = "id"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r13)     // Catch:{ Exception -> 0x012b, NumberFormatException -> 0x0151 }
            long r13 = java.lang.Long.parseLong(r5)     // Catch:{ Exception -> 0x012b, NumberFormatException -> 0x0151 }
            android.net.Uri r12 = android.content.ContentUris.withAppendedId(r12, r13)     // Catch:{ Exception -> 0x012b, NumberFormatException -> 0x0151 }
            com.memes.uritool.util.ContentResolverUtil r13 = com.memes.uritool.util.ContentResolverUtil.INSTANCE     // Catch:{ Exception -> 0x012b, NumberFormatException -> 0x0151 }
            android.content.Context r14 = r15.context     // Catch:{ Exception -> 0x012b, NumberFormatException -> 0x0151 }
            java.lang.String r4 = r13.dataColumn(r14, r12, r3, r3)     // Catch:{ Exception -> 0x012b, NumberFormatException -> 0x0151 }
            java.io.File r12 = r15.tryFilePath(r4)     // Catch:{ Exception -> 0x012b, NumberFormatException -> 0x0151 }
            if (r12 == 0) goto L_0x010e
            com.memes.uritool.resolve.UriResolveResult$Companion r13 = com.memes.uritool.resolve.UriResolveResult.Companion     // Catch:{ Exception -> 0x012b, NumberFormatException -> 0x0151 }
            com.memes.uritool.resolve.UriResolveResult r0 = r13.mo61174of(r12)     // Catch:{ Exception -> 0x012b, NumberFormatException -> 0x0151 }
            return r0
        L_0x010e:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012b, NumberFormatException -> 0x0151 }
            r12.<init>()     // Catch:{ Exception -> 0x012b, NumberFormatException -> 0x0151 }
            r12.append(r1)     // Catch:{ Exception -> 0x012b, NumberFormatException -> 0x0151 }
            r12.append(r11)     // Catch:{ Exception -> 0x012b, NumberFormatException -> 0x0151 }
            r12.append(r0)     // Catch:{ Exception -> 0x012b, NumberFormatException -> 0x0151 }
            android.net.Uri r13 = r15.uri     // Catch:{ Exception -> 0x012b, NumberFormatException -> 0x0151 }
            r12.append(r13)     // Catch:{ Exception -> 0x012b, NumberFormatException -> 0x0151 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x012b, NumberFormatException -> 0x0151 }
            java.lang.Object[] r13 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x012b, NumberFormatException -> 0x0151 }
            timber.log.Timber.m312w(r12, r13)     // Catch:{ Exception -> 0x012b, NumberFormatException -> 0x0151 }
            goto L_0x014e
        L_0x012b:
            r12 = move-exception
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0151, Exception -> 0x0153 }
            r13.<init>()     // Catch:{ NumberFormatException -> 0x0151, Exception -> 0x0153 }
            r13.append(r1)     // Catch:{ NumberFormatException -> 0x0151, Exception -> 0x0153 }
            r13.append(r11)     // Catch:{ NumberFormatException -> 0x0151, Exception -> 0x0153 }
            r13.append(r0)     // Catch:{ NumberFormatException -> 0x0151, Exception -> 0x0153 }
            android.net.Uri r11 = r15.uri     // Catch:{ NumberFormatException -> 0x0151, Exception -> 0x0153 }
            r13.append(r11)     // Catch:{ NumberFormatException -> 0x0151, Exception -> 0x0153 }
            r13.append(r2)     // Catch:{ NumberFormatException -> 0x0151, Exception -> 0x0153 }
            r13.append(r12)     // Catch:{ NumberFormatException -> 0x0151, Exception -> 0x0153 }
            java.lang.String r11 = r13.toString()     // Catch:{ NumberFormatException -> 0x0151, Exception -> 0x0153 }
            java.lang.Object[] r12 = new java.lang.Object[r10]     // Catch:{ NumberFormatException -> 0x0151, Exception -> 0x0153 }
            timber.log.Timber.m312w(r11, r12)     // Catch:{ NumberFormatException -> 0x0151, Exception -> 0x0153 }
        L_0x014e:
            int r8 = r8 + 1
            goto L_0x00e4
        L_0x0151:
            r4 = r5
            goto L_0x017c
        L_0x0153:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Unable to retrieve document information with uri; uri="
            r1.append(r3)
            android.net.Uri r3 = r15.uri
            r1.append(r3)
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.Object[] r1 = new java.lang.Object[r10]
            timber.log.Timber.m300d(r0, r1)
            com.memes.uritool.resolve.UriResolveResult$Companion r0 = com.memes.uritool.resolve.UriResolveResult.Companion
            java.lang.String r1 = "Unable to retrieve document information with uri."
            com.memes.uritool.resolve.UriResolveResult r0 = r0.error(r1)
            return r0
        L_0x017b:
        L_0x017c:
            r0 = 2
            if (r4 == 0) goto L_0x01a8
            java.lang.String r1 = "msf:"
            boolean r1 = kotlin.text.StringsKt.startsWith$default(r4, r1, r10, r0, r3)
            if (r1 != r9) goto L_0x01a8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "No knowledge on how to reconstruct the file path. uri="
            r0.append(r1)
            android.net.Uri r1 = r15.uri
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r10]
            timber.log.Timber.m312w(r0, r1)
            com.memes.uritool.resolve.UriResolveResult$Companion r0 = com.memes.uritool.resolve.UriResolveResult.Companion
            java.lang.String r1 = "No knowledge on how to reconstruct the file path."
            com.memes.uritool.resolve.UriResolveResult r0 = r0.error(r1)
            return r0
        L_0x01a8:
            if (r4 == 0) goto L_0x01e8
            java.lang.String r1 = "raw:/"
            boolean r0 = kotlin.text.StringsKt.startsWith$default(r4, r1, r10, r0, r3)
            if (r0 != r9) goto L_0x01e8
            r0 = 5
            java.lang.String r4 = r4.substring(r0)
            java.lang.String r0 = "(this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            boolean r0 = r0.exists()
            if (r0 == 0) goto L_0x01c9
            goto L_0x02b6
        L_0x01c9:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Document file at raw path doesn't exist; rawPath="
            r0.append(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r10]
            timber.log.Timber.m300d(r0, r1)
            com.memes.uritool.resolve.UriResolveResult$Companion r0 = com.memes.uritool.resolve.UriResolveResult.Companion
            java.lang.String r1 = "Document file at raw path doesn't exist."
            com.memes.uritool.resolve.UriResolveResult r0 = r0.error(r1)
            return r0
        L_0x01e8:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to get document ID as a number; id="
            r0.append(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r10]
            timber.log.Timber.m300d(r0, r1)
            com.memes.uritool.resolve.UriResolveResult$Companion r0 = com.memes.uritool.resolve.UriResolveResult.Companion
            java.lang.String r1 = "Failed to get document ID as a number."
            com.memes.uritool.resolve.UriResolveResult r0 = r0.error(r1)
            return r0
        L_0x0207:
            android.net.Uri r0 = r15.uri
            boolean r0 = r15.isMediaDocument(r0)
            if (r0 == 0) goto L_0x02b6
            java.lang.Object[] r0 = new java.lang.Object[r10]
            java.lang.String r1 = "It's a uri from MediaProvider"
            timber.log.Timber.m300d(r1, r0)
            android.net.Uri r0 = r15.uri
            java.lang.String r0 = android.provider.DocumentsContract.getDocumentId(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r8)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            kotlin.text.Regex r1 = new kotlin.text.Regex
            r1.<init>((java.lang.String) r7)
            java.util.List r0 = r1.split(r0, r10)
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x025d
            int r1 = r0.size()
            java.util.ListIterator r1 = r0.listIterator(r1)
        L_0x0238:
            boolean r2 = r1.hasPrevious()
            if (r2 == 0) goto L_0x025d
            java.lang.Object r2 = r1.previous()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 != 0) goto L_0x024e
            r2 = 1
            goto L_0x024f
        L_0x024e:
            r2 = 0
        L_0x024f:
            if (r2 != 0) goto L_0x0238
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            int r1 = r1.nextIndex()
            int r1 = r1 + r9
            java.util.List r0 = kotlin.collections.CollectionsKt.take(r0, r1)
            goto L_0x0261
        L_0x025d:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0261:
            java.util.Collection r0 = (java.util.Collection) r0
            java.lang.String[] r1 = new java.lang.String[r10]
            java.lang.Object[] r0 = r0.toArray(r1)
            java.util.Objects.requireNonNull(r0, r6)
            java.lang.String[] r0 = (java.lang.String[]) r0
            r1 = r0[r10]
            android.net.Uri r3 = (android.net.Uri) r3
            int r2 = r1.hashCode()
            r4 = 93166550(0x58d9bd6, float:1.3316821E-35)
            if (r2 == r4) goto L_0x029c
            r4 = 100313435(0x5faa95b, float:2.3572098E-35)
            if (r2 == r4) goto L_0x0291
            r4 = 112202875(0x6b0147b, float:6.6233935E-35)
            if (r2 == r4) goto L_0x0286
            goto L_0x02a6
        L_0x0286:
            java.lang.String r2 = "video"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x02a6
            android.net.Uri r3 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI
            goto L_0x02a6
        L_0x0291:
            java.lang.String r2 = "image"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x02a6
            android.net.Uri r3 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            goto L_0x02a6
        L_0x029c:
            java.lang.String r2 = "audio"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x02a6
            android.net.Uri r3 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        L_0x02a6:
            java.lang.String[] r1 = new java.lang.String[r9]
            r0 = r0[r9]
            r1[r10] = r0
            com.memes.uritool.util.ContentResolverUtil r0 = com.memes.uritool.util.ContentResolverUtil.INSTANCE
            android.content.Context r2 = r15.context
            java.lang.String r4 = "_id=?"
            java.lang.String r4 = r0.dataColumn(r2, r3, r4, r1)
        L_0x02b6:
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x02c3
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L_0x02c2
            goto L_0x02c3
        L_0x02c2:
            r9 = 0
        L_0x02c3:
            if (r9 == 0) goto L_0x02ce
            com.memes.uritool.resolve.UriResolveResult$Companion r0 = com.memes.uritool.resolve.UriResolveResult.Companion
            java.lang.String r1 = "File path is null"
            com.memes.uritool.resolve.UriResolveResult r0 = r0.error(r1)
            return r0
        L_0x02ce:
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x02f8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "File doesn't exist; file="
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.Object[] r1 = new java.lang.Object[r10]
            timber.log.Timber.m300d(r0, r1)
            com.memes.uritool.resolve.UriResolveResult$Companion r0 = com.memes.uritool.resolve.UriResolveResult.Companion
            java.lang.String r1 = "File doesn't exist."
            com.memes.uritool.resolve.UriResolveResult r0 = r0.error(r1)
            return r0
        L_0x02f8:
            com.memes.uritool.resolve.UriResolveResult$Companion r1 = com.memes.uritool.resolve.UriResolveResult.Companion
            com.memes.uritool.resolve.UriResolveResult r0 = r1.mo61174of(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.uritool.source.DocumentsUriSource.resolve():com.memes.uritool.resolve.UriResolveResult");
    }

    private final File tryFilePath(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        return file;
    }

    private final boolean isExternalStorageDocument(Uri uri2) {
        return Intrinsics.areEqual((Object) "com.android.externalstorage.documents", (Object) uri2.getAuthority());
    }

    private final boolean isDownloadsDocument(Uri uri2) {
        return Intrinsics.areEqual((Object) "com.android.providers.downloads.documents", (Object) uri2.getAuthority());
    }

    private final boolean isMediaDocument(Uri uri2) {
        return Intrinsics.areEqual((Object) "com.android.providers.media.documents", (Object) uri2.getAuthority());
    }
}
