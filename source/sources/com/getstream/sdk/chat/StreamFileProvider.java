package com.getstream.sdk.chat;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import androidx.core.content.FileProvider;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo26107d2 = {"Lcom/getstream/sdk/chat/StreamFileProvider;", "Landroidx/core/content/FileProvider;", "()V", "Companion", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: StreamFileProvider.kt */
public final class StreamFileProvider extends FileProvider {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @InternalStreamChatApi
    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, mo26107d2 = {"Lcom/getstream/sdk/chat/StreamFileProvider$Companion;", "", "()V", "getFileProviderAuthority", "", "context", "Landroid/content/Context;", "getUriForFile", "Landroid/net/Uri;", "file", "Ljava/io/File;", "writeImageToSharableFile", "bitmap", "Landroid/graphics/Bitmap;", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: StreamFileProvider.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String getFileProviderAuthority(Context context) {
            String str = context.getPackageManager().getProviderInfo(new ComponentName(context, StreamFileProvider.class.getName()), 0).authority;
            Intrinsics.checkNotNullExpressionValue(str, "providerInfo.authority");
            return str;
        }

        public final Uri getUriForFile(Context context, File file) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(file, "file");
            Uri uriForFile = FileProvider.getUriForFile(context, getFileProviderAuthority(context), file);
            Intrinsics.checkNotNullExpressionValue(uriForFile, "getUriForFile(context, g…Authority(context), file)");
            return uriForFile;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0061, code lost:
            r10 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            kotlin.p017io.CloseableKt.closeFinally(r2, r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0065, code lost:
            throw r10;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final android.net.Uri writeImageToSharableFile(android.content.Context r9, android.graphics.Bitmap r10) {
            /*
                r8 = this;
                java.lang.String r0 = "context"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                java.lang.String r0 = "bitmap"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                r0 = 0
                java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x0066 }
                java.lang.String r2 = android.os.Environment.DIRECTORY_PICTURES     // Catch:{ IOException -> 0x0066 }
                java.io.File r2 = r9.getExternalFilesDir(r2)     // Catch:{ IOException -> 0x0066 }
                if (r2 == 0) goto L_0x0016
                goto L_0x001a
            L_0x0016:
                java.io.File r2 = r9.getCacheDir()     // Catch:{ IOException -> 0x0066 }
            L_0x001a:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0066 }
                r3.<init>()     // Catch:{ IOException -> 0x0066 }
                java.lang.String r4 = "share_image_"
                r3.append(r4)     // Catch:{ IOException -> 0x0066 }
                long r4 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0066 }
                r3.append(r4)     // Catch:{ IOException -> 0x0066 }
                java.lang.String r4 = ".png"
                r3.append(r4)     // Catch:{ IOException -> 0x0066 }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x0066 }
                r1.<init>(r2, r3)     // Catch:{ IOException -> 0x0066 }
                java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0066 }
                r2.<init>(r1)     // Catch:{ IOException -> 0x0066 }
                java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ IOException -> 0x0066 }
                r3 = r0
                java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch:{ IOException -> 0x0066 }
                r4 = r2
                java.io.FileOutputStream r4 = (java.io.FileOutputStream) r4     // Catch:{ all -> 0x005f }
                android.graphics.Bitmap$CompressFormat r5 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ all -> 0x005f }
                r6 = 90
                r7 = r4
                java.io.OutputStream r7 = (java.io.OutputStream) r7     // Catch:{ all -> 0x005f }
                r10.compress(r5, r6, r7)     // Catch:{ all -> 0x005f }
                r4.flush()     // Catch:{ all -> 0x005f }
                kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005f }
                kotlin.p017io.CloseableKt.closeFinally(r2, r3)     // Catch:{ IOException -> 0x0066 }
                r10 = r8
                com.getstream.sdk.chat.StreamFileProvider$Companion r10 = (com.getstream.sdk.chat.StreamFileProvider.Companion) r10     // Catch:{ IOException -> 0x0066 }
                android.net.Uri r0 = r10.getUriForFile(r9, r1)     // Catch:{ IOException -> 0x0066 }
                goto L_0x006a
            L_0x005f:
                r9 = move-exception
                throw r9     // Catch:{ all -> 0x0061 }
            L_0x0061:
                r10 = move-exception
                kotlin.p017io.CloseableKt.closeFinally(r2, r9)     // Catch:{ IOException -> 0x0066 }
                throw r10     // Catch:{ IOException -> 0x0066 }
            L_0x0066:
                r9 = move-exception
                r9.printStackTrace()
            L_0x006a:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.StreamFileProvider.Companion.writeImageToSharableFile(android.content.Context, android.graphics.Bitmap):android.net.Uri");
        }
    }
}
