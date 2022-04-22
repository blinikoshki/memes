package com.memes.uritool.source;

import android.content.Context;
import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo26107d2 = {"Lcom/memes/uritool/source/InputStreamUriSource;", "Lcom/memes/uritool/source/UriSource;", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "outputFile", "Ljava/io/File;", "(Landroid/content/Context;Landroid/net/Uri;Ljava/io/File;)V", "dumpInputStreamToFile", "inputStream", "Ljava/io/InputStream;", "isSupportedUri", "", "resolve", "Lcom/memes/uritool/resolve/UriResolveResult;", "uritool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: InputStreamUriSource.kt */
public final class InputStreamUriSource implements UriSource {
    private final Context context;
    private File outputFile;
    private final Uri uri;

    public InputStreamUriSource(Context context2, Uri uri2, File file) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
        Intrinsics.checkNotNullParameter(file, "outputFile");
        this.context = context2;
        this.uri = uri2;
        this.outputFile = file;
    }

    public boolean isSupportedUri() {
        return this.uri.getAuthority() != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004a, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004b, code lost:
        kotlin.p017io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004e, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.memes.uritool.resolve.UriResolveResult resolve() {
        /*
            r4 = this;
            android.net.Uri r0 = r4.uri
            java.lang.String r0 = r0.getAuthority()
            if (r0 != 0) goto L_0x0011
            com.memes.uritool.resolve.UriResolveResult$Companion r0 = com.memes.uritool.resolve.UriResolveResult.Companion
            java.lang.String r1 = "Uri doesn't have an authority"
            com.memes.uritool.resolve.UriResolveResult r0 = r0.error(r1)
            return r0
        L_0x0011:
            android.content.Context r0 = r4.context
            android.content.ContentResolver r0 = r0.getContentResolver()
            android.net.Uri r1 = r4.uri
            java.io.InputStream r0 = r0.openInputStream(r1)
            if (r0 == 0) goto L_0x004f
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = 0
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            r2 = r0
            java.io.InputStream r2 = (java.io.InputStream) r2     // Catch:{ all -> 0x0048 }
            java.io.File r3 = r4.outputFile     // Catch:{ all -> 0x0048 }
            java.io.File r2 = r4.dumpInputStreamToFile(r2, r3)     // Catch:{ all -> 0x0048 }
            kotlin.p017io.CloseableKt.closeFinally(r0, r1)
            if (r2 == 0) goto L_0x004f
            boolean r0 = r2.exists()
            if (r0 != 0) goto L_0x0041
            com.memes.uritool.resolve.UriResolveResult$Companion r0 = com.memes.uritool.resolve.UriResolveResult.Companion
            java.lang.String r1 = "File doesn't exist."
            com.memes.uritool.resolve.UriResolveResult r0 = r0.error(r1)
            return r0
        L_0x0041:
            com.memes.uritool.resolve.UriResolveResult$Companion r0 = com.memes.uritool.resolve.UriResolveResult.Companion
            com.memes.uritool.resolve.UriResolveResult r0 = r0.mo61174of(r2)
            return r0
        L_0x0048:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x004a }
        L_0x004a:
            r2 = move-exception
            kotlin.p017io.CloseableKt.closeFinally(r0, r1)
            throw r2
        L_0x004f:
            com.memes.uritool.resolve.UriResolveResult$Companion r0 = com.memes.uritool.resolve.UriResolveResult.Companion
            java.lang.String r1 = "File is null"
            com.memes.uritool.resolve.UriResolveResult r0 = r0.error(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.uritool.source.InputStreamUriSource.resolve():com.memes.uritool.resolve.UriResolveResult");
    }

    private final File dumpInputStreamToFile(InputStream inputStream, File file) throws IOException {
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[8192];
        OutputStream fileOutputStream = new FileOutputStream(file);
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                break;
            }
            fileOutputStream.write(bArr, 0, read);
        }
        fileOutputStream.flush();
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
