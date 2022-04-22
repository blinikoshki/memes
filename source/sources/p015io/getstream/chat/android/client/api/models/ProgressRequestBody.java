package p015io.getstream.chat.android.client.api.models;

import android.os.Handler;
import android.os.Looper;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.p017io.CloseableKt;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import p015io.getstream.chat.android.client.extensions.FileExtensionsKt;
import p015io.getstream.chat.android.client.utils.ProgressCallback;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/ProgressRequestBody;", "Lokhttp3/RequestBody;", "file", "Ljava/io/File;", "callback", "Lio/getstream/chat/android/client/utils/ProgressCallback;", "(Ljava/io/File;Lio/getstream/chat/android/client/utils/ProgressCallback;)V", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "writeTo", "", "sink", "Lokio/BufferedSink;", "Companion", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.ProgressRequestBody */
/* compiled from: ProgressRequestBody.kt */
public final class ProgressRequestBody extends RequestBody {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DEFAULT_BUFFER_SIZE = 2048;
    /* access modifiers changed from: private */
    public final ProgressCallback callback;
    private final File file;

    public ProgressRequestBody(File file2, ProgressCallback progressCallback) {
        Intrinsics.checkNotNullParameter(file2, "file");
        Intrinsics.checkNotNullParameter(progressCallback, "callback");
        this.file = file2;
        this.callback = progressCallback;
    }

    public MediaType contentType() {
        return FileExtensionsKt.getMediaType(this.file);
    }

    public long contentLength() {
        return this.file.length();
    }

    public void writeTo(BufferedSink bufferedSink) {
        Throwable th;
        BufferedSink bufferedSink2 = bufferedSink;
        Intrinsics.checkNotNullParameter(bufferedSink2, "sink");
        long length = this.file.length();
        byte[] bArr = new byte[2048];
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = 0;
        Closeable fileInputStream = new FileInputStream(this.file);
        Throwable th2 = null;
        try {
            FileInputStream fileInputStream2 = (FileInputStream) fileInputStream;
            Handler handler = new Handler(Looper.getMainLooper());
            while (true) {
                int read = fileInputStream2.read(bArr);
                if (read != -1) {
                    int i = read;
                    long j = length;
                    long j2 = length;
                    Handler handler2 = handler;
                    handler2.post(new ProgressRequestBody$writeTo$$inlined$use$lambda$1(this, bArr, longRef, j, bufferedSink));
                    longRef.element += (long) i;
                    bufferedSink2.write(bArr, 0, i);
                    handler = handler2;
                    length = j2;
                } else {
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileInputStream, th2);
                    return;
                }
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            CloseableKt.closeFinally(fileInputStream, th);
            throw th4;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/ProgressRequestBody$Companion;", "", "()V", "DEFAULT_BUFFER_SIZE", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.api.models.ProgressRequestBody$Companion */
    /* compiled from: ProgressRequestBody.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
