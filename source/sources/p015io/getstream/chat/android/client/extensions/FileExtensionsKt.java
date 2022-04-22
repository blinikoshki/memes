package p015io.getstream.chat.android.client.extensions;

import android.webkit.MimeTypeMap;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p017io.FilesKt;
import okhttp3.MediaType;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0000¨\u0006\u0005"}, mo26107d2 = {"getMediaType", "Lokhttp3/MediaType;", "Ljava/io/File;", "getMimeType", "", "stream-chat-android-client_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.extensions.FileExtensionsKt */
/* compiled from: FileExtensions.kt */
public final class FileExtensionsKt {
    public static final String getMimeType(File file) {
        Intrinsics.checkNotNullParameter(file, "$this$getMimeType");
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(FilesKt.getExtension(file));
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    public static final MediaType getMediaType(File file) {
        Intrinsics.checkNotNullParameter(file, "$this$getMediaType");
        return MediaType.Companion.get(getMimeType(file));
    }
}
