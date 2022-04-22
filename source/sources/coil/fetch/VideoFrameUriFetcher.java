package coil.fetch;

import android.content.Context;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0014\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\b\u001a\u00020\u0002H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo26107d2 = {"Lcoil/fetch/VideoFrameUriFetcher;", "Lcoil/fetch/VideoFrameFetcher;", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "handles", "", "data", "key", "", "setDataSource", "", "Landroid/media/MediaMetadataRetriever;", "coil-video_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: VideoFrameFetcher.kt */
public final class VideoFrameUriFetcher extends VideoFrameFetcher<Uri> {
    private final Context context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoFrameUriFetcher(Context context2) {
        super(context2);
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public String key(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "data");
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "data.toString()");
        return uri2;
    }

    public boolean handles(Uri uri) {
        boolean z;
        Intrinsics.checkNotNullParameter(uri, "data");
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return false;
        }
        String[] strArr = VideoFrameFetcher.SUPPORTED_FILE_EXTENSIONS;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (StringsKt.endsWith(lastPathSegment, strArr[i], true)) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x007e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x007f, code lost:
        kotlin.p017io.CloseableKt.closeFinally(r11, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0082, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setDataSource(android.media.MediaMetadataRetriever r10, android.net.Uri r11) {
        /*
            r9 = this;
            java.lang.String r0 = "$this$setDataSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = r11.getScheme()
            java.lang.String r1 = "file"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x0083
            java.util.List r0 = r11.getPathSegments()
            java.lang.String r1 = "data.pathSegments"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = "android_asset"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x0083
            java.util.List r11 = r11.getPathSegments()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r1)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            r0 = 1
            java.util.List r11 = kotlin.collections.CollectionsKt.drop(r11, r0)
            r0 = r11
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.lang.String r11 = "/"
            r1 = r11
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 62
            r8 = 0
            java.lang.String r11 = kotlin.collections.CollectionsKt.joinToString$default(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            android.content.Context r0 = r9.context
            android.content.res.AssetManager r0 = r0.getAssets()
            android.content.res.AssetFileDescriptor r11 = r0.openFd(r11)
            java.io.Closeable r11 = (java.io.Closeable) r11
            r0 = 0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r1 = r11
            android.content.res.AssetFileDescriptor r1 = (android.content.res.AssetFileDescriptor) r1     // Catch:{ all -> 0x007c }
            java.lang.String r2 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ all -> 0x007c }
            java.io.FileDescriptor r4 = r1.getFileDescriptor()     // Catch:{ all -> 0x007c }
            long r5 = r1.getStartOffset()     // Catch:{ all -> 0x007c }
            long r7 = r1.getLength()     // Catch:{ all -> 0x007c }
            r3 = r10
            r3.setDataSource(r4, r5, r7)     // Catch:{ all -> 0x007c }
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x007c }
            kotlin.p017io.CloseableKt.closeFinally(r11, r0)
            goto L_0x0088
        L_0x007c:
            r10 = move-exception
            throw r10     // Catch:{ all -> 0x007e }
        L_0x007e:
            r0 = move-exception
            kotlin.p017io.CloseableKt.closeFinally(r11, r10)
            throw r0
        L_0x0083:
            android.content.Context r0 = r9.context
            r10.setDataSource(r0, r11)
        L_0x0088:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.fetch.VideoFrameUriFetcher.setDataSource(android.media.MediaMetadataRetriever, android.net.Uri):void");
    }
}
