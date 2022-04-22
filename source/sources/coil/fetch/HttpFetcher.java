package coil.fetch;

import android.webkit.MimeTypeMap;
import coil.bitmap.BitmapPool;
import coil.decode.Options;
import coil.fetch.Fetcher;
import coil.size.Size;
import coil.util.Extensions;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u0000 \u0019*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0019B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J1\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u001f\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0001¢\u0006\u0002\b\u0016J\u0011\u0010\u0017\u001a\u00020\u0013*\u00028\u0000H&¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, mo26107d2 = {"Lcoil/fetch/HttpFetcher;", "T", "", "Lcoil/fetch/Fetcher;", "callFactory", "Lokhttp3/Call$Factory;", "(Lokhttp3/Call$Factory;)V", "fetch", "Lcoil/fetch/FetchResult;", "pool", "Lcoil/bitmap/BitmapPool;", "data", "size", "Lcoil/size/Size;", "options", "Lcoil/decode/Options;", "(Lcoil/bitmap/BitmapPool;Ljava/lang/Object;Lcoil/size/Size;Lcoil/decode/Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMimeType", "", "Lokhttp3/HttpUrl;", "body", "Lokhttp3/ResponseBody;", "getMimeType$coil_base_release", "toHttpUrl", "(Ljava/lang/Object;)Lokhttp3/HttpUrl;", "Companion", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: HttpFetcher.kt */
public abstract class HttpFetcher<T> implements Fetcher<T> {
    private static final CacheControl CACHE_CONTROL_FORCE_NETWORK_NO_CACHE = new CacheControl.Builder().noCache().noStore().build();
    private static final CacheControl CACHE_CONTROL_NO_NETWORK_NO_CACHE = new CacheControl.Builder().noCache().onlyIfCached().build();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String MIME_TYPE_TEXT_PLAIN = "text/plain";
    private final Call.Factory callFactory;

    public Object fetch(BitmapPool bitmapPool, T t, Size size, Options options, Continuation<? super FetchResult> continuation) {
        return fetch$suspendImpl(this, bitmapPool, t, size, options, continuation);
    }

    public abstract HttpUrl toHttpUrl(T t);

    public HttpFetcher(Call.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "callFactory");
        this.callFactory = factory;
    }

    public boolean handles(T t) {
        Intrinsics.checkNotNullParameter(t, "data");
        return Fetcher.DefaultImpls.handles(this, t);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object fetch$suspendImpl(coil.fetch.HttpFetcher r3, coil.bitmap.BitmapPool r4, java.lang.Object r5, coil.size.Size r6, coil.decode.Options r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r4 = r8 instanceof coil.fetch.HttpFetcher$fetch$1
            if (r4 == 0) goto L_0x0014
            r4 = r8
            coil.fetch.HttpFetcher$fetch$1 r4 = (coil.fetch.HttpFetcher$fetch$1) r4
            int r6 = r4.label
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r6 & r0
            if (r6 == 0) goto L_0x0014
            int r6 = r4.label
            int r6 = r6 - r0
            r4.label = r6
            goto L_0x0019
        L_0x0014:
            coil.fetch.HttpFetcher$fetch$1 r4 = new coil.fetch.HttpFetcher$fetch$1
            r4.<init>(r3, r8)
        L_0x0019:
            java.lang.Object r6 = r4.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r4.label
            r1 = 1
            if (r0 == 0) goto L_0x0041
            if (r0 != r1) goto L_0x0039
            java.lang.Object r3 = r4.L$2
            okhttp3.Call r3 = (okhttp3.Call) r3
            java.lang.Object r3 = r4.L$1
            okhttp3.HttpUrl r3 = (okhttp3.HttpUrl) r3
            java.lang.Object r4 = r4.L$0
            coil.fetch.HttpFetcher r4 = (coil.fetch.HttpFetcher) r4
            kotlin.ResultKt.throwOnFailure(r6)
            r5 = r3
            r3 = r4
            goto L_0x0105
        L_0x0039:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r6)
            okhttp3.HttpUrl r5 = r3.toHttpUrl(r5)
            okhttp3.Request$Builder r6 = new okhttp3.Request$Builder
            r6.<init>()
            okhttp3.Request$Builder r6 = r6.url((okhttp3.HttpUrl) r5)
            okhttp3.Headers r0 = r7.getHeaders()
            okhttp3.Request$Builder r6 = r6.headers(r0)
            coil.request.CachePolicy r0 = r7.getNetworkCachePolicy()
            boolean r0 = r0.getReadEnabled()
            coil.request.CachePolicy r2 = r7.getDiskCachePolicy()
            boolean r2 = r2.getReadEnabled()
            if (r0 != 0) goto L_0x0073
            if (r2 == 0) goto L_0x0073
            okhttp3.CacheControl r7 = okhttp3.CacheControl.FORCE_CACHE
            r6.cacheControl(r7)
            goto L_0x0096
        L_0x0073:
            if (r0 == 0) goto L_0x008d
            if (r2 != 0) goto L_0x008d
            coil.request.CachePolicy r7 = r7.getDiskCachePolicy()
            boolean r7 = r7.getWriteEnabled()
            if (r7 == 0) goto L_0x0087
            okhttp3.CacheControl r7 = okhttp3.CacheControl.FORCE_NETWORK
            r6.cacheControl(r7)
            goto L_0x0096
        L_0x0087:
            okhttp3.CacheControl r7 = CACHE_CONTROL_FORCE_NETWORK_NO_CACHE
            r6.cacheControl(r7)
            goto L_0x0096
        L_0x008d:
            if (r0 != 0) goto L_0x0096
            if (r2 != 0) goto L_0x0096
            okhttp3.CacheControl r7 = CACHE_CONTROL_NO_NETWORK_NO_CACHE
            r6.cacheControl(r7)
        L_0x0096:
            kotlin.coroutines.CoroutineContext r7 = r4.getContext()
            kotlinx.coroutines.CoroutineDispatcher$Key r2 = kotlinx.coroutines.CoroutineDispatcher.Key
            kotlin.coroutines.CoroutineContext$Key r2 = (kotlin.coroutines.CoroutineContext.Key) r2
            kotlin.coroutines.CoroutineContext$Element r7 = r7.get(r2)
            boolean r7 = r7 instanceof kotlinx.coroutines.MainCoroutineDispatcher
            if (r7 == 0) goto L_0x00bf
            if (r0 != 0) goto L_0x00b7
            okhttp3.Call$Factory r4 = r3.callFactory
            okhttp3.Request r6 = r6.build()
            okhttp3.Call r4 = r4.newCall(r6)
            okhttp3.Response r4 = r4.execute()
            goto L_0x0108
        L_0x00b7:
            android.os.NetworkOnMainThreadException r3 = new android.os.NetworkOnMainThreadException
            r3.<init>()
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            throw r3
        L_0x00bf:
            okhttp3.Call$Factory r7 = r3.callFactory
            okhttp3.Request r6 = r6.build()
            okhttp3.Call r6 = r7.newCall(r6)
            java.lang.String r7 = "callFactory.newCall(request.build())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            r4.L$0 = r3
            r4.L$1 = r5
            r4.L$2 = r6
            r4.label = r1
            kotlinx.coroutines.CancellableContinuationImpl r7 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r4)
            r7.<init>(r0, r1)
            r7.initCancellability()
            r0 = r7
            kotlinx.coroutines.CancellableContinuation r0 = (kotlinx.coroutines.CancellableContinuation) r0
            coil.util.ContinuationCallback r1 = new coil.util.ContinuationCallback
            r1.<init>(r6, r0)
            r2 = r1
            okhttp3.Callback r2 = (okhttp3.Callback) r2
            r6.enqueue(r2)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r0.invokeOnCancellation(r1)
            java.lang.Object r6 = r7.getResult()
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r6 != r7) goto L_0x0102
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r4)
        L_0x0102:
            if (r6 != r8) goto L_0x0105
            return r8
        L_0x0105:
            r4 = r6
            okhttp3.Response r4 = (okhttp3.Response) r4
        L_0x0108:
            java.lang.String r6 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            boolean r6 = r4.isSuccessful()
            if (r6 != 0) goto L_0x0124
            okhttp3.ResponseBody r3 = r4.body()
            if (r3 == 0) goto L_0x011c
            r3.close()
        L_0x011c:
            coil.network.HttpException r3 = new coil.network.HttpException
            r3.<init>(r4)
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            throw r3
        L_0x0124:
            okhttp3.ResponseBody r6 = r4.body()
            if (r6 == 0) goto L_0x0148
            coil.fetch.SourceResult r7 = new coil.fetch.SourceResult
            okio.BufferedSource r8 = r6.source()
            java.lang.String r0 = "body.source()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            java.lang.String r3 = r3.getMimeType$coil_base_release(r5, r6)
            okhttp3.Response r4 = r4.cacheResponse()
            if (r4 == 0) goto L_0x0142
            coil.decode.DataSource r4 = coil.decode.DataSource.DISK
            goto L_0x0144
        L_0x0142:
            coil.decode.DataSource r4 = coil.decode.DataSource.NETWORK
        L_0x0144:
            r7.<init>(r8, r3, r4)
            return r7
        L_0x0148:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Null response body!"
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.fetch.HttpFetcher.fetch$suspendImpl(coil.fetch.HttpFetcher, coil.bitmap.BitmapPool, java.lang.Object, coil.size.Size, coil.decode.Options, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String getMimeType$coil_base_release(HttpUrl httpUrl, ResponseBody responseBody) {
        Intrinsics.checkNotNullParameter(httpUrl, "data");
        Intrinsics.checkNotNullParameter(responseBody, TtmlNode.TAG_BODY);
        MediaType contentType = responseBody.contentType();
        String mediaType = contentType != null ? contentType.toString() : null;
        if (mediaType == null || StringsKt.startsWith$default(mediaType, "text/plain", false, 2, (Object) null)) {
            MimeTypeMap singleton = MimeTypeMap.getSingleton();
            Intrinsics.checkNotNullExpressionValue(singleton, "MimeTypeMap.getSingleton()");
            String mimeTypeFromUrl = Extensions.getMimeTypeFromUrl(singleton, httpUrl.toString());
            if (mimeTypeFromUrl != null) {
                return mimeTypeFromUrl;
            }
        }
        if (mediaType != null) {
            return StringsKt.substringBefore$default(mediaType, ';', (String) null, 2, (Object) null);
        }
        return null;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lcoil/fetch/HttpFetcher$Companion;", "", "()V", "CACHE_CONTROL_FORCE_NETWORK_NO_CACHE", "Lokhttp3/CacheControl;", "kotlin.jvm.PlatformType", "CACHE_CONTROL_NO_NETWORK_NO_CACHE", "MIME_TYPE_TEXT_PLAIN", "", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: HttpFetcher.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
