package p015io.getstream.chat.android.client.api;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import okio.Buffer;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0004H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"logBody", "", "logHeaders", "isProbablyUtf8", "Lokio/Buffer;", "stream-chat-android-client_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.HttpLoggingInterceptorKt */
/* compiled from: HttpLoggingInterceptor.kt */
public final class HttpLoggingInterceptorKt {
    private static final boolean logBody = true;
    private static final boolean logHeaders = true;

    /* access modifiers changed from: private */
    public static final boolean isProbablyUtf8(Buffer buffer) {
        try {
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0, RangesKt.coerceAtMost(buffer.size(), 64));
            for (int i = 0; i < 16; i++) {
                if (buffer2.exhausted()) {
                    return true;
                }
                int readUtf8CodePoint = buffer2.readUtf8CodePoint();
                if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
