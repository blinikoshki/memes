package p015io.getstream.chat.android.client.api;

import com.google.common.net.HttpHeaders;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.Interceptor;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.TaggedLogger;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\bR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/HttpLoggingInterceptor;", "Lokhttp3/Interceptor;", "()V", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "headersToRedact", "", "", "logger", "Lio/getstream/chat/android/client/logger/TaggedLogger;", "bodyHasUnknownEncoding", "", "headers", "Lokhttp3/Headers;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "logHeader", "", "i", "", "redactHeader", "name", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.HttpLoggingInterceptor */
/* compiled from: HttpLoggingInterceptor.kt */
public final class HttpLoggingInterceptor implements Interceptor {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private volatile Set<String> headersToRedact = SetsKt.emptySet();
    private final TaggedLogger logger = ChatLogger.Companion.get("Http");

    public final void redactHeader(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        TreeSet treeSet = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        Collection collection = treeSet;
        CollectionsKt.addAll(collection, this.headersToRedact);
        collection.add(str);
        this.headersToRedact = treeSet;
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0283 A[LOOP:1: B:56:0x0281->B:57:0x0283, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0298  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r18) throws java.io.IOException {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            java.lang.String r2 = "chain"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            io.getstream.chat.android.client.logger.TaggedLogger r2 = r1.logger
            io.getstream.chat.android.client.logger.ChatLogLevel r2 = r2.getLevel()
            okhttp3.Request r3 = r18.request()
            io.getstream.chat.android.client.logger.ChatLogLevel r4 = p015io.getstream.chat.android.client.logger.ChatLogLevel.NOTHING
            if (r2 != r4) goto L_0x001c
            okhttp3.Response r0 = r0.proceed(r3)
            return r0
        L_0x001c:
            okhttp3.RequestBody r2 = r3.body()
            okhttp3.Connection r4 = r18.connection()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "--> "
            r5.append(r6)
            java.lang.String r6 = r3.method()
            r5.append(r6)
            r6 = 32
            r5.append(r6)
            okhttp3.HttpUrl r7 = r3.url()
            r5.append(r7)
            java.lang.String r7 = ""
            if (r4 == 0) goto L_0x005b
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = " "
            r8.append(r9)
            okhttp3.Protocol r4 = r4.protocol()
            r8.append(r4)
            java.lang.String r4 = r8.toString()
            goto L_0x005c
        L_0x005b:
            r4 = r7
        L_0x005c:
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            io.getstream.chat.android.client.logger.TaggedLogger r5 = r1.logger
            r5.logI(r4)
            okhttp3.Headers r4 = r3.headers()
            r8 = -1
            if (r2 == 0) goto L_0x00be
            okhttp3.MediaType r5 = r2.contentType()
            if (r5 == 0) goto L_0x0094
            java.lang.String r10 = "Content-Type"
            java.lang.String r10 = r4.get(r10)
            if (r10 != 0) goto L_0x0094
            io.getstream.chat.android.client.logger.TaggedLogger r10 = r1.logger
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Content-Type: "
            r11.append(r12)
            r11.append(r5)
            java.lang.String r5 = r11.toString()
            r10.logI(r5)
        L_0x0094:
            long r10 = r2.contentLength()
            int r5 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r5 == 0) goto L_0x00be
            java.lang.String r5 = "Content-Length"
            java.lang.String r5 = r4.get(r5)
            if (r5 != 0) goto L_0x00be
            io.getstream.chat.android.client.logger.TaggedLogger r5 = r1.logger
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Content-Length: "
            r10.append(r11)
            long r11 = r2.contentLength()
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r5.logI(r10)
        L_0x00be:
            int r5 = r4.size()
            r11 = 0
        L_0x00c3:
            if (r11 >= r5) goto L_0x00cb
            r1.logHeader(r4, r11)
            int r11 = r11 + 1
            goto L_0x00c3
        L_0x00cb:
            java.lang.String r4 = "-byte body)"
            java.lang.String r5 = " ("
            java.lang.String r11 = "-byte body omitted)"
            java.lang.String r12 = "StandardCharsets.UTF_8"
            java.lang.String r13 = "--> END "
            if (r2 != 0) goto L_0x00f3
            io.getstream.chat.android.client.logger.TaggedLogger r2 = r1.logger
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r13)
            java.lang.String r13 = r3.method()
            r14.append(r13)
            java.lang.String r13 = r14.toString()
            r2.logI(r13)
        L_0x00ef:
            r16 = r7
            goto L_0x01e7
        L_0x00f3:
            okhttp3.Headers r14 = r3.headers()
            boolean r14 = r1.bodyHasUnknownEncoding(r14)
            if (r14 == 0) goto L_0x011b
            io.getstream.chat.android.client.logger.TaggedLogger r2 = r1.logger
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r13)
            java.lang.String r13 = r3.method()
            r14.append(r13)
            java.lang.String r13 = " (encoded body omitted)"
            r14.append(r13)
            java.lang.String r13 = r14.toString()
            r2.logI(r13)
            goto L_0x00ef
        L_0x011b:
            boolean r14 = r2.isDuplex()
            if (r14 == 0) goto L_0x013f
            io.getstream.chat.android.client.logger.TaggedLogger r2 = r1.logger
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r13)
            java.lang.String r13 = r3.method()
            r14.append(r13)
            java.lang.String r13 = " (duplex request body omitted)"
            r14.append(r13)
            java.lang.String r13 = r14.toString()
            r2.logI(r13)
            goto L_0x00ef
        L_0x013f:
            boolean r14 = r2.isOneShot()
            if (r14 == 0) goto L_0x0163
            io.getstream.chat.android.client.logger.TaggedLogger r2 = r1.logger
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r13)
            java.lang.String r13 = r3.method()
            r14.append(r13)
            java.lang.String r13 = " (one-shot body omitted)"
            r14.append(r13)
            java.lang.String r13 = r14.toString()
            r2.logI(r13)
            goto L_0x00ef
        L_0x0163:
            okio.Buffer r14 = new okio.Buffer
            r14.<init>()
            r15 = r14
            okio.BufferedSink r15 = (okio.BufferedSink) r15
            r2.writeTo(r15)
            okhttp3.MediaType r15 = r2.contentType()
            if (r15 == 0) goto L_0x017d
            java.nio.charset.Charset r10 = java.nio.charset.StandardCharsets.UTF_8
            java.nio.charset.Charset r10 = r15.charset(r10)
            if (r10 == 0) goto L_0x017d
            goto L_0x0182
        L_0x017d:
            java.nio.charset.Charset r10 = java.nio.charset.StandardCharsets.UTF_8
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r12)
        L_0x0182:
            io.getstream.chat.android.client.logger.TaggedLogger r15 = r1.logger
            r15.logI(r7)
            boolean r15 = p015io.getstream.chat.android.client.api.HttpLoggingInterceptorKt.isProbablyUtf8(r14)
            if (r15 == 0) goto L_0x01be
            io.getstream.chat.android.client.logger.TaggedLogger r15 = r1.logger
            java.lang.String r10 = r14.readString(r10)
            r15.logI(r10)
            io.getstream.chat.android.client.logger.TaggedLogger r10 = r1.logger
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r13)
            java.lang.String r13 = r3.method()
            r14.append(r13)
            r14.append(r5)
            r16 = r7
            long r6 = r2.contentLength()
            r14.append(r6)
            r14.append(r4)
            java.lang.String r2 = r14.toString()
            r10.logI(r2)
            goto L_0x01e7
        L_0x01be:
            r16 = r7
            io.getstream.chat.android.client.logger.TaggedLogger r6 = r1.logger
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r13)
            java.lang.String r10 = r3.method()
            r7.append(r10)
            java.lang.String r10 = " (binary "
            r7.append(r10)
            long r13 = r2.contentLength()
            r7.append(r13)
            r7.append(r11)
            java.lang.String r2 = r7.toString()
            r6.logI(r2)
        L_0x01e7:
            long r6 = java.lang.System.nanoTime()
            okhttp3.Response r0 = r0.proceed(r3)     // Catch:{ Exception -> 0x03b0 }
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r13 = java.lang.System.nanoTime()
            long r13 = r13 - r6
            long r2 = r2.toMillis(r13)
            okhttp3.ResponseBody r6 = r0.body()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            long r13 = r6.contentLength()
            int r7 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            io.getstream.chat.android.client.logger.TaggedLogger r7 = r1.logger
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "<-- "
            r8.append(r9)
            int r9 = r0.code()
            r8.append(r9)
            java.lang.String r9 = r0.message()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            int r9 = r9.length()
            if (r9 != 0) goto L_0x0228
            r9 = 1
            goto L_0x0229
        L_0x0228:
            r9 = 0
        L_0x0229:
            if (r9 == 0) goto L_0x0230
            r9 = r16
            r18 = 32
            goto L_0x0249
        L_0x0230:
            java.lang.String r9 = r0.message()
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r18 = 32
            java.lang.String r10 = java.lang.String.valueOf(r18)
            r15.append(r10)
            r15.append(r9)
            java.lang.String r9 = r15.toString()
        L_0x0249:
            r8.append(r9)
            r9 = 32
            r8.append(r9)
            okhttp3.Request r9 = r0.request()
            okhttp3.HttpUrl r9 = r9.url()
            r8.append(r9)
            r8.append(r5)
            r8.append(r2)
            java.lang.String r2 = "ms"
            r8.append(r2)
            r2 = r16
            r8.append(r2)
            r3 = 41
            r8.append(r3)
            java.lang.String r3 = r8.toString()
            r7.logI(r3)
            okhttp3.Headers r3 = r0.headers()
            int r5 = r3.size()
            r10 = 0
        L_0x0281:
            if (r10 >= r5) goto L_0x0289
            r1.logHeader(r3, r10)
            int r10 = r10 + 1
            goto L_0x0281
        L_0x0289:
            boolean r5 = okhttp3.internal.http.HttpHeaders.promisesBody(r0)
            if (r5 != 0) goto L_0x0298
            io.getstream.chat.android.client.logger.TaggedLogger r2 = r1.logger
            java.lang.String r3 = "<-- END HTTP"
            r2.logI(r3)
            goto L_0x03af
        L_0x0298:
            okhttp3.Headers r5 = r0.headers()
            boolean r5 = r1.bodyHasUnknownEncoding(r5)
            if (r5 == 0) goto L_0x02ab
            io.getstream.chat.android.client.logger.TaggedLogger r2 = r1.logger
            java.lang.String r3 = "<-- END HTTP (encoded body omitted)"
            r2.logI(r3)
            goto L_0x03af
        L_0x02ab:
            okio.BufferedSource r5 = r6.source()
            r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r5.request(r7)
            okio.Buffer r5 = r5.getBuffer()
            r7 = 0
            r8 = r7
            java.lang.Long r8 = (java.lang.Long) r8
            java.lang.String r9 = "Content-Encoding"
            java.lang.String r3 = r3.get(r9)
            java.lang.String r9 = "gzip"
            r10 = 1
            boolean r3 = kotlin.text.StringsKt.equals(r9, r3, r10)
            if (r3 == 0) goto L_0x0300
            long r8 = r5.size()
            java.lang.Long r8 = java.lang.Long.valueOf(r8)
            okio.GzipSource r3 = new okio.GzipSource
            okio.Buffer r5 = r5.clone()
            okio.Source r5 = (okio.Source) r5
            r3.<init>(r5)
            java.io.Closeable r3 = (java.io.Closeable) r3
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            r5 = r3
            okio.GzipSource r5 = (okio.GzipSource) r5     // Catch:{ all -> 0x02f7 }
            okio.Buffer r9 = new okio.Buffer     // Catch:{ all -> 0x02f7 }
            r9.<init>()     // Catch:{ all -> 0x02f7 }
            okio.Source r5 = (okio.Source) r5     // Catch:{ all -> 0x02f7 }
            r9.writeAll(r5)     // Catch:{ all -> 0x02f7 }
            kotlin.p017io.CloseableKt.closeFinally(r3, r7)
            r5 = r9
            goto L_0x0300
        L_0x02f7:
            r0 = move-exception
            r2 = r0
            throw r2     // Catch:{ all -> 0x02fa }
        L_0x02fa:
            r0 = move-exception
            r4 = r0
            kotlin.p017io.CloseableKt.closeFinally(r3, r2)
            throw r4
        L_0x0300:
            okhttp3.MediaType r3 = r6.contentType()
            if (r3 == 0) goto L_0x030f
            java.nio.charset.Charset r6 = java.nio.charset.StandardCharsets.UTF_8
            java.nio.charset.Charset r3 = r3.charset(r6)
            if (r3 == 0) goto L_0x030f
            goto L_0x0314
        L_0x030f:
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r12)
        L_0x0314:
            boolean r6 = p015io.getstream.chat.android.client.api.HttpLoggingInterceptorKt.isProbablyUtf8(r5)
            if (r6 != 0) goto L_0x033d
            io.getstream.chat.android.client.logger.TaggedLogger r3 = r1.logger
            r3.logI(r2)
            io.getstream.chat.android.client.logger.TaggedLogger r2 = r1.logger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "<-- END HTTP (binary "
            r3.append(r4)
            long r4 = r5.size()
            r3.append(r4)
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r2.logI(r3)
            return r0
        L_0x033d:
            r6 = 0
            int r9 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r9 == 0) goto L_0x036a
            io.getstream.chat.android.client.logger.TaggedLogger r6 = r1.logger
            r6.logI(r2)
            okio.Buffer r2 = r5.clone()
            java.lang.String r2 = r2.readString(r3)
            com.google.gson.JsonElement r3 = com.google.gson.JsonParser.parseString(r2)     // Catch:{ JSONException -> 0x0365 }
            io.getstream.chat.android.client.logger.TaggedLogger r6 = r1.logger     // Catch:{ JSONException -> 0x0365 }
            com.google.gson.Gson r7 = r1.gson     // Catch:{ JSONException -> 0x0365 }
            java.lang.String r3 = r7.toJson((com.google.gson.JsonElement) r3)     // Catch:{ JSONException -> 0x0365 }
            java.lang.String r7 = "gson.toJson(json)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)     // Catch:{ JSONException -> 0x0365 }
            r6.logI(r3)     // Catch:{ JSONException -> 0x0365 }
            goto L_0x036a
        L_0x0365:
            io.getstream.chat.android.client.logger.TaggedLogger r3 = r1.logger
            r3.logI(r2)
        L_0x036a:
            java.lang.String r2 = "<-- END HTTP ("
            if (r8 == 0) goto L_0x0394
            io.getstream.chat.android.client.logger.TaggedLogger r3 = r1.logger
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            long r5 = r5.size()
            r4.append(r5)
            java.lang.String r2 = "-byte, "
            r4.append(r2)
            r4.append(r8)
            java.lang.String r2 = "-gzipped-byte body)"
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r3.logI(r2)
            goto L_0x03af
        L_0x0394:
            io.getstream.chat.android.client.logger.TaggedLogger r3 = r1.logger
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            long r7 = r5.size()
            r6.append(r7)
            r6.append(r4)
            java.lang.String r2 = r6.toString()
            r3.logI(r2)
        L_0x03af:
            return r0
        L_0x03b0:
            r0 = move-exception
            r2 = r0
            io.getstream.chat.android.client.logger.TaggedLogger r0 = r1.logger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "<-- HTTP FAILED: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            r0.logI(r3)
            r0 = r2
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.client.api.HttpLoggingInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    private final void logHeader(Headers headers, int i) {
        String value = this.headersToRedact.contains(headers.name(i)) ? "██" : headers.value(i);
        TaggedLogger taggedLogger = this.logger;
        taggedLogger.logI(headers.name(i) + ": " + value);
    }

    private final boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get(HttpHeaders.CONTENT_ENCODING);
        if (str == null || StringsKt.equals(str, "identity", true) || StringsKt.equals(str, "gzip", true)) {
            return false;
        }
        return true;
    }
}
