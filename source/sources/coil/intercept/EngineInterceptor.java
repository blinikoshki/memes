package coil.intercept;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.ComponentRegistry;
import coil.EventListener;
import coil.bitmap.BitmapPool;
import coil.bitmap.BitmapReferenceCounter;
import coil.decode.DataSource;
import coil.decode.DecodeUtils;
import coil.decode.DrawableDecoderService;
import coil.decode.Options;
import coil.fetch.DrawableResult;
import coil.fetch.Fetcher;
import coil.memory.MemoryCache;
import coil.memory.MemoryCacheService;
import coil.memory.RealMemoryCache;
import coil.memory.RequestService;
import coil.memory.StrongMemoryCache;
import coil.request.ImageRequest;
import coil.request.Parameters;
import coil.size.OriginalSize;
import coil.size.PixelSize;
import coil.size.Size;
import coil.transform.Transformation;
import coil.util.Bitmaps;
import coil.util.Logger;
import coil.util.Requests;
import coil.util.SystemCallbacks;
import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 A2\u00020\u0001:\u0001ABO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J;\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fHHø\u0001\u0000¢\u0006\u0004\b \u0010!J5\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0'2\u0006\u0010\u001a\u001a\u00020\u001bH\u0001¢\u0006\u0002\b(JG\u0010)\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0'2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010*\u001a\u00020+2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fHHø\u0001\u0000¢\u0006\u0002\u0010,J\u0019\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H@ø\u0001\u0000¢\u0006\u0002\u00101J\u0010\u00102\u001a\u0002032\u0006\u0010$\u001a\u00020%H\u0002J/\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010#2\u0006\u00107\u001a\u0002082\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0001¢\u0006\u0002\b9J*\u0010:\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010#2\u0006\u00107\u001a\u0002082\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010;\u001a\u0002032\u0006\u0010<\u001a\u00020=H\u0002J*\u0010>\u001a\u0002052\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010?\u001a\u0004\u0018\u00010#2\u0006\u0010<\u001a\u00020=2\u0006\u0010@\u001a\u000205H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006B"}, mo26107d2 = {"Lcoil/intercept/EngineInterceptor;", "Lcoil/intercept/Interceptor;", "registry", "Lcoil/ComponentRegistry;", "bitmapPool", "Lcoil/bitmap/BitmapPool;", "referenceCounter", "Lcoil/bitmap/BitmapReferenceCounter;", "strongMemoryCache", "Lcoil/memory/StrongMemoryCache;", "memoryCacheService", "Lcoil/memory/MemoryCacheService;", "requestService", "Lcoil/memory/RequestService;", "systemCallbacks", "Lcoil/util/SystemCallbacks;", "drawableDecoder", "Lcoil/decode/DrawableDecoderService;", "logger", "Lcoil/util/Logger;", "(Lcoil/ComponentRegistry;Lcoil/bitmap/BitmapPool;Lcoil/bitmap/BitmapReferenceCounter;Lcoil/memory/StrongMemoryCache;Lcoil/memory/MemoryCacheService;Lcoil/memory/RequestService;Lcoil/util/SystemCallbacks;Lcoil/decode/DrawableDecoderService;Lcoil/util/Logger;)V", "applyTransformations", "Lcoil/fetch/DrawableResult;", "result", "request", "Lcoil/request/ImageRequest;", "size", "Lcoil/size/Size;", "options", "Lcoil/decode/Options;", "eventListener", "Lcoil/EventListener;", "applyTransformations$coil_base_release", "(Lcoil/fetch/DrawableResult;Lcoil/request/ImageRequest;Lcoil/size/Size;Lcoil/decode/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeMemoryCacheKey", "Lcoil/memory/MemoryCache$Key;", "data", "", "fetcher", "Lcoil/fetch/Fetcher;", "computeMemoryCacheKey$coil_base_release", "execute", "type", "", "(Ljava/lang/Object;Lcoil/fetch/Fetcher;Lcoil/request/ImageRequest;ILcoil/size/Size;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "intercept", "Lcoil/request/ImageResult;", "chain", "Lcoil/intercept/Interceptor$Chain;", "(Lcoil/intercept/Interceptor$Chain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invalidateData", "", "isCachedValueValid", "", "cacheKey", "cacheValue", "Lcoil/memory/RealMemoryCache$Value;", "isCachedValueValid$coil_base_release", "isSizeValid", "validateDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "writeToMemoryCache", "key", "isSampled", "Companion", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: EngineInterceptor.kt */
public final class EngineInterceptor implements Interceptor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "EngineInterceptor";
    /* access modifiers changed from: private */
    public final BitmapPool bitmapPool;
    /* access modifiers changed from: private */
    public final DrawableDecoderService drawableDecoder;
    /* access modifiers changed from: private */
    public final Logger logger;
    private final MemoryCacheService memoryCacheService;
    /* access modifiers changed from: private */
    public final BitmapReferenceCounter referenceCounter;
    /* access modifiers changed from: private */
    public final ComponentRegistry registry;
    /* access modifiers changed from: private */
    public final RequestService requestService;
    private final StrongMemoryCache strongMemoryCache;
    /* access modifiers changed from: private */
    public final SystemCallbacks systemCallbacks;

    public EngineInterceptor(ComponentRegistry componentRegistry, BitmapPool bitmapPool2, BitmapReferenceCounter bitmapReferenceCounter, StrongMemoryCache strongMemoryCache2, MemoryCacheService memoryCacheService2, RequestService requestService2, SystemCallbacks systemCallbacks2, DrawableDecoderService drawableDecoderService, Logger logger2) {
        Intrinsics.checkNotNullParameter(componentRegistry, "registry");
        Intrinsics.checkNotNullParameter(bitmapPool2, "bitmapPool");
        Intrinsics.checkNotNullParameter(bitmapReferenceCounter, "referenceCounter");
        Intrinsics.checkNotNullParameter(strongMemoryCache2, "strongMemoryCache");
        Intrinsics.checkNotNullParameter(memoryCacheService2, "memoryCacheService");
        Intrinsics.checkNotNullParameter(requestService2, "requestService");
        Intrinsics.checkNotNullParameter(systemCallbacks2, "systemCallbacks");
        Intrinsics.checkNotNullParameter(drawableDecoderService, "drawableDecoder");
        this.registry = componentRegistry;
        this.bitmapPool = bitmapPool2;
        this.referenceCounter = bitmapReferenceCounter;
        this.strongMemoryCache = strongMemoryCache2;
        this.memoryCacheService = memoryCacheService2;
        this.requestService = requestService2;
        this.systemCallbacks = systemCallbacks2;
        this.drawableDecoder = drawableDecoderService;
        this.logger = logger2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: coil.intercept.EngineInterceptor} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x015d A[Catch:{ all -> 0x01d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x019c A[Catch:{ all -> 0x01d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object intercept(coil.intercept.Interceptor.Chain r18, kotlin.coroutines.Continuation<? super coil.request.ImageResult> r19) {
        /*
            r17 = this;
            r12 = r17
            r13 = r18
            r0 = r19
            boolean r1 = r0 instanceof coil.intercept.EngineInterceptor$intercept$1
            if (r1 == 0) goto L_0x001a
            r1 = r0
            coil.intercept.EngineInterceptor$intercept$1 r1 = (coil.intercept.EngineInterceptor$intercept$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x001a
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001f
        L_0x001a:
            coil.intercept.EngineInterceptor$intercept$1 r1 = new coil.intercept.EngineInterceptor$intercept$1
            r1.<init>(r12, r0)
        L_0x001f:
            r0 = r1
            java.lang.Object r1 = r0.result
            java.lang.Object r14 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r15 = 1
            if (r2 == 0) goto L_0x0047
            if (r2 != r15) goto L_0x003f
            java.lang.Object r2 = r0.L$1
            coil.intercept.Interceptor$Chain r2 = (coil.intercept.Interceptor.Chain) r2
            java.lang.Object r0 = r0.L$0
            r3 = r0
            coil.intercept.EngineInterceptor r3 = (coil.intercept.EngineInterceptor) r3
            kotlin.ResultKt.throwOnFailure(r1)     // Catch:{ all -> 0x003b }
            goto L_0x01c4
        L_0x003b:
            r0 = move-exception
            r13 = r2
            goto L_0x01d5
        L_0x003f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r1)
            boolean r1 = r13 instanceof coil.intercept.RealInterceptorChain     // Catch:{ all -> 0x01d3 }
            if (r1 == 0) goto L_0x01c5
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ all -> 0x01d3 }
            r3.<init>()     // Catch:{ all -> 0x01d3 }
            coil.request.ImageRequest r1 = r18.getRequest()     // Catch:{ all -> 0x01d3 }
            r3.element = r1     // Catch:{ all -> 0x01d3 }
            T r1 = r3.element     // Catch:{ all -> 0x01d3 }
            coil.request.ImageRequest r1 = (coil.request.ImageRequest) r1     // Catch:{ all -> 0x01d3 }
            android.content.Context r1 = r1.getContext()     // Catch:{ all -> 0x01d3 }
            T r2 = r3.element     // Catch:{ all -> 0x01d3 }
            coil.request.ImageRequest r2 = (coil.request.ImageRequest) r2     // Catch:{ all -> 0x01d3 }
            java.lang.Object r2 = r2.getData()     // Catch:{ all -> 0x01d3 }
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ all -> 0x01d3 }
            r8.<init>()     // Catch:{ all -> 0x01d3 }
            coil.size.Size r4 = r18.getSize()     // Catch:{ all -> 0x01d3 }
            r8.element = r4     // Catch:{ all -> 0x01d3 }
            kotlin.jvm.internal.Ref$ObjectRef r9 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ all -> 0x01d3 }
            r9.<init>()     // Catch:{ all -> 0x01d3 }
            r4 = r13
            coil.intercept.RealInterceptorChain r4 = (coil.intercept.RealInterceptorChain) r4     // Catch:{ all -> 0x01d3 }
            coil.EventListener r4 = r4.getEventListener()     // Catch:{ all -> 0x01d3 }
            r9.element = r4     // Catch:{ all -> 0x01d3 }
            T r4 = r9.element     // Catch:{ all -> 0x01d3 }
            coil.EventListener r4 = (coil.EventListener) r4     // Catch:{ all -> 0x01d3 }
            T r5 = r3.element     // Catch:{ all -> 0x01d3 }
            coil.request.ImageRequest r5 = (coil.request.ImageRequest) r5     // Catch:{ all -> 0x01d3 }
            r4.mapStart(r5, r2)     // Catch:{ all -> 0x01d3 }
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ all -> 0x01d3 }
            r5.<init>()     // Catch:{ all -> 0x01d3 }
            coil.ComponentRegistry r4 = r12.registry     // Catch:{ all -> 0x01d3 }
            java.lang.Object r2 = coil.util.ComponentRegistries.mapData(r4, r2)     // Catch:{ all -> 0x01d3 }
            r5.element = r2     // Catch:{ all -> 0x01d3 }
            T r2 = r9.element     // Catch:{ all -> 0x01d3 }
            coil.EventListener r2 = (coil.EventListener) r2     // Catch:{ all -> 0x01d3 }
            T r4 = r3.element     // Catch:{ all -> 0x01d3 }
            coil.request.ImageRequest r4 = (coil.request.ImageRequest) r4     // Catch:{ all -> 0x01d3 }
            T r6 = r5.element     // Catch:{ all -> 0x01d3 }
            r2.mapEnd(r4, r6)     // Catch:{ all -> 0x01d3 }
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ all -> 0x01d3 }
            r6.<init>()     // Catch:{ all -> 0x01d3 }
            T r2 = r3.element     // Catch:{ all -> 0x01d3 }
            coil.request.ImageRequest r2 = (coil.request.ImageRequest) r2     // Catch:{ all -> 0x01d3 }
            T r4 = r5.element     // Catch:{ all -> 0x01d3 }
            coil.fetch.Fetcher r2 = coil.util.Requests.fetcher(r2, r4)     // Catch:{ all -> 0x01d3 }
            if (r2 == 0) goto L_0x00b9
            goto L_0x00c1
        L_0x00b9:
            coil.ComponentRegistry r2 = r12.registry     // Catch:{ all -> 0x01d3 }
            T r4 = r5.element     // Catch:{ all -> 0x01d3 }
            coil.fetch.Fetcher r2 = coil.util.ComponentRegistries.requireFetcher(r2, r4)     // Catch:{ all -> 0x01d3 }
        L_0x00c1:
            r6.element = r2     // Catch:{ all -> 0x01d3 }
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ all -> 0x01d3 }
            r10.<init>()     // Catch:{ all -> 0x01d3 }
            T r2 = r3.element     // Catch:{ all -> 0x01d3 }
            coil.request.ImageRequest r2 = (coil.request.ImageRequest) r2     // Catch:{ all -> 0x01d3 }
            coil.memory.MemoryCache$Key r2 = r2.getMemoryCacheKey()     // Catch:{ all -> 0x01d3 }
            if (r2 == 0) goto L_0x00d3
            goto L_0x00e5
        L_0x00d3:
            T r2 = r3.element     // Catch:{ all -> 0x01d3 }
            coil.request.ImageRequest r2 = (coil.request.ImageRequest) r2     // Catch:{ all -> 0x01d3 }
            T r4 = r5.element     // Catch:{ all -> 0x01d3 }
            T r7 = r6.element     // Catch:{ all -> 0x01d3 }
            coil.fetch.Fetcher r7 = (coil.fetch.Fetcher) r7     // Catch:{ all -> 0x01d3 }
            T r11 = r8.element     // Catch:{ all -> 0x01d3 }
            coil.size.Size r11 = (coil.size.Size) r11     // Catch:{ all -> 0x01d3 }
            coil.memory.MemoryCache$Key r2 = r12.computeMemoryCacheKey$coil_base_release(r2, r4, r7, r11)     // Catch:{ all -> 0x01d3 }
        L_0x00e5:
            r10.element = r2     // Catch:{ all -> 0x01d3 }
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ all -> 0x01d3 }
            r4.<init>()     // Catch:{ all -> 0x01d3 }
            T r2 = r3.element     // Catch:{ all -> 0x01d3 }
            coil.request.ImageRequest r2 = (coil.request.ImageRequest) r2     // Catch:{ all -> 0x01d3 }
            coil.request.CachePolicy r2 = r2.getMemoryCachePolicy()     // Catch:{ all -> 0x01d3 }
            boolean r2 = r2.getReadEnabled()     // Catch:{ all -> 0x01d3 }
            if (r2 == 0) goto L_0x0105
            coil.memory.MemoryCacheService r2 = r12.memoryCacheService     // Catch:{ all -> 0x01d3 }
            T r11 = r10.element     // Catch:{ all -> 0x01d3 }
            coil.memory.MemoryCache$Key r11 = (coil.memory.MemoryCache.Key) r11     // Catch:{ all -> 0x01d3 }
            coil.memory.RealMemoryCache$Value r2 = r2.get(r11)     // Catch:{ all -> 0x01d3 }
            goto L_0x0106
        L_0x0105:
            r2 = 0
        L_0x0106:
            r4.element = r2     // Catch:{ all -> 0x01d3 }
            T r2 = r4.element     // Catch:{ all -> 0x01d3 }
            coil.memory.RealMemoryCache$Value r2 = (coil.memory.RealMemoryCache.Value) r2     // Catch:{ all -> 0x01d3 }
            java.lang.String r11 = "context.resources"
            if (r2 == 0) goto L_0x0142
            android.graphics.Bitmap r2 = r2.getBitmap()     // Catch:{ all -> 0x01d3 }
            if (r2 == 0) goto L_0x0142
            coil.memory.RequestService r7 = r12.requestService     // Catch:{ all -> 0x01d3 }
            T r15 = r3.element     // Catch:{ all -> 0x01d3 }
            coil.request.ImageRequest r15 = (coil.request.ImageRequest) r15     // Catch:{ all -> 0x01d3 }
            r16 = r14
            android.graphics.Bitmap$Config r14 = coil.util.Bitmaps.getSafeConfig(r2)     // Catch:{ all -> 0x01d3 }
            boolean r7 = r7.isConfigValidForHardware(r15, r14)     // Catch:{ all -> 0x01d3 }
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)     // Catch:{ all -> 0x01d3 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x01d3 }
            if (r7 == 0) goto L_0x0131
            goto L_0x0132
        L_0x0131:
            r2 = 0
        L_0x0132:
            if (r2 == 0) goto L_0x0144
            android.content.res.Resources r7 = r1.getResources()     // Catch:{ all -> 0x01d3 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r11)     // Catch:{ all -> 0x01d3 }
            android.graphics.drawable.BitmapDrawable r14 = new android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x01d3 }
            r14.<init>(r7, r2)     // Catch:{ all -> 0x01d3 }
            r7 = r14
            goto L_0x0145
        L_0x0142:
            r16 = r14
        L_0x0144:
            r7 = 0
        L_0x0145:
            if (r7 == 0) goto L_0x019c
            T r2 = r10.element     // Catch:{ all -> 0x01d3 }
            coil.memory.MemoryCache$Key r2 = (coil.memory.MemoryCache.Key) r2     // Catch:{ all -> 0x01d3 }
            T r7 = r4.element     // Catch:{ all -> 0x01d3 }
            coil.memory.RealMemoryCache$Value r7 = (coil.memory.RealMemoryCache.Value) r7     // Catch:{ all -> 0x01d3 }
            T r14 = r3.element     // Catch:{ all -> 0x01d3 }
            coil.request.ImageRequest r14 = (coil.request.ImageRequest) r14     // Catch:{ all -> 0x01d3 }
            T r15 = r8.element     // Catch:{ all -> 0x01d3 }
            coil.size.Size r15 = (coil.size.Size) r15     // Catch:{ all -> 0x01d3 }
            boolean r2 = r12.isCachedValueValid$coil_base_release(r2, r7, r14, r15)     // Catch:{ all -> 0x01d3 }
            if (r2 == 0) goto L_0x019c
            coil.request.SuccessResult r0 = new coil.request.SuccessResult     // Catch:{ all -> 0x01d3 }
            T r2 = r4.element     // Catch:{ all -> 0x01d3 }
            coil.memory.RealMemoryCache$Value r2 = (coil.memory.RealMemoryCache.Value) r2     // Catch:{ all -> 0x01d3 }
            android.graphics.Bitmap r2 = r2.getBitmap()     // Catch:{ all -> 0x01d3 }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ all -> 0x01d3 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r11)     // Catch:{ all -> 0x01d3 }
            android.graphics.drawable.BitmapDrawable r5 = new android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x01d3 }
            r5.<init>(r1, r2)     // Catch:{ all -> 0x01d3 }
            android.graphics.drawable.Drawable r5 = (android.graphics.drawable.Drawable) r5     // Catch:{ all -> 0x01d3 }
            T r1 = r3.element     // Catch:{ all -> 0x01d3 }
            coil.request.ImageRequest r1 = (coil.request.ImageRequest) r1     // Catch:{ all -> 0x01d3 }
            coil.request.ImageResult$Metadata r2 = new coil.request.ImageResult$Metadata     // Catch:{ all -> 0x01d3 }
            T r3 = r10.element     // Catch:{ all -> 0x01d3 }
            coil.memory.MemoryCache$Key r3 = (coil.memory.MemoryCache.Key) r3     // Catch:{ all -> 0x01d3 }
            T r4 = r4.element     // Catch:{ all -> 0x01d3 }
            coil.memory.RealMemoryCache$Value r4 = (coil.memory.RealMemoryCache.Value) r4     // Catch:{ all -> 0x01d3 }
            boolean r4 = r4.isSampled()     // Catch:{ all -> 0x01d3 }
            coil.decode.DataSource r6 = coil.decode.DataSource.MEMORY_CACHE     // Catch:{ all -> 0x01d3 }
            r7 = r13
            coil.intercept.RealInterceptorChain r7 = (coil.intercept.RealInterceptorChain) r7     // Catch:{ all -> 0x01d3 }
            android.graphics.Bitmap r7 = r7.getCached()     // Catch:{ all -> 0x01d3 }
            if (r7 == 0) goto L_0x0194
            r15 = 1
            goto L_0x0195
        L_0x0194:
            r15 = 0
        L_0x0195:
            r2.<init>(r3, r4, r6, r15)     // Catch:{ all -> 0x01d3 }
            r0.<init>(r5, r1, r2)     // Catch:{ all -> 0x01d3 }
            return r0
        L_0x019c:
            T r1 = r3.element     // Catch:{ all -> 0x01d3 }
            coil.request.ImageRequest r1 = (coil.request.ImageRequest) r1     // Catch:{ all -> 0x01d3 }
            kotlinx.coroutines.CoroutineDispatcher r1 = r1.getDispatcher()     // Catch:{ all -> 0x01d3 }
            r14 = r1
            kotlin.coroutines.CoroutineContext r14 = (kotlin.coroutines.CoroutineContext) r14     // Catch:{ all -> 0x01d3 }
            coil.intercept.EngineInterceptor$intercept$2 r15 = new coil.intercept.EngineInterceptor$intercept$2     // Catch:{ all -> 0x01d3 }
            r11 = 0
            r1 = r15
            r2 = r17
            r7 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x01d3 }
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15     // Catch:{ all -> 0x01d3 }
            r0.L$0 = r12     // Catch:{ all -> 0x01d3 }
            r0.L$1 = r13     // Catch:{ all -> 0x01d3 }
            r1 = 1
            r0.label = r1     // Catch:{ all -> 0x01d3 }
            java.lang.Object r1 = kotlinx.coroutines.BuildersKt.withContext(r14, r15, r0)     // Catch:{ all -> 0x01d3 }
            r0 = r16
            if (r1 != r0) goto L_0x01c4
            return r0
        L_0x01c4:
            return r1
        L_0x01c5:
            java.lang.String r0 = "Check failed."
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x01d3 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01d3 }
            r1.<init>(r0)     // Catch:{ all -> 0x01d3 }
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x01d3 }
            throw r1     // Catch:{ all -> 0x01d3 }
        L_0x01d3:
            r0 = move-exception
            r3 = r12
        L_0x01d5:
            boolean r1 = r0 instanceof java.util.concurrent.CancellationException
            if (r1 != 0) goto L_0x01e4
            coil.memory.RequestService r1 = r3.requestService
            coil.request.ImageRequest r2 = r13.getRequest()
            coil.request.ErrorResult r0 = r1.errorResult(r2, r0)
            return r0
        L_0x01e4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.intercept(coil.intercept.Interceptor$Chain, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final MemoryCache.Key computeMemoryCacheKey$coil_base_release(ImageRequest imageRequest, Object obj, Fetcher<Object> fetcher, Size size) {
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Intrinsics.checkNotNullParameter(obj, "data");
        Intrinsics.checkNotNullParameter(fetcher, "fetcher");
        Intrinsics.checkNotNullParameter(size, "size");
        String key = fetcher.key(obj);
        if (key == null) {
            return null;
        }
        if (imageRequest.getTransformations().isEmpty()) {
            MemoryCache.Key.Companion companion = MemoryCache.Key.Companion;
            return new MemoryCache.Key.Complex(key, CollectionsKt.emptyList(), (Size) null, imageRequest.getParameters().cacheKeys());
        }
        MemoryCache.Key.Companion companion2 = MemoryCache.Key.Companion;
        List<Transformation> transformations = imageRequest.getTransformations();
        Parameters parameters = imageRequest.getParameters();
        ArrayList arrayList = new ArrayList(transformations.size());
        int size2 = transformations.size();
        for (int i = 0; i < size2; i++) {
            arrayList.add(transformations.get(i).key());
        }
        return new MemoryCache.Key.Complex(key, arrayList, size, parameters.cacheKeys());
    }

    public final boolean isCachedValueValid$coil_base_release(MemoryCache.Key key, RealMemoryCache.Value value, ImageRequest imageRequest, Size size) {
        Intrinsics.checkNotNullParameter(value, "cacheValue");
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Intrinsics.checkNotNullParameter(size, "size");
        if (!isSizeValid(key, value, imageRequest, size)) {
            return false;
        }
        if (this.requestService.isConfigValidForHardware(imageRequest, Bitmaps.getSafeConfig(value.getBitmap()))) {
            return true;
        }
        Logger logger2 = this.logger;
        if (logger2 != null && logger2.getLevel() <= 3) {
            logger2.log(TAG, 3, imageRequest.getData() + ": Cached bitmap is hardware-backed, which is incompatible with the request.", (Throwable) null);
        }
        return false;
    }

    private final boolean isSizeValid(MemoryCache.Key key, RealMemoryCache.Value value, ImageRequest imageRequest, Size size) {
        int i;
        int i2;
        Size size2 = size;
        if (size2 instanceof OriginalSize) {
            if (!value.isSampled()) {
                return true;
            }
            Logger logger2 = this.logger;
            if (logger2 != null && logger2.getLevel() <= 3) {
                logger2.log(TAG, 3, imageRequest.getData() + ": Requested original size, but cached image is sampled.", (Throwable) null);
            }
            return false;
        } else if (!(size2 instanceof PixelSize)) {
            return true;
        } else {
            MemoryCache.Key key2 = key;
            if (!(key2 instanceof MemoryCache.Key.Complex)) {
                key2 = null;
            }
            MemoryCache.Key.Complex complex = (MemoryCache.Key.Complex) key2;
            Size size3 = complex != null ? complex.getSize() : null;
            if (size3 instanceof PixelSize) {
                PixelSize pixelSize = (PixelSize) size3;
                i = pixelSize.getWidth();
                i2 = pixelSize.getHeight();
            } else if (!Intrinsics.areEqual((Object) size3, (Object) OriginalSize.INSTANCE) && size3 != null) {
                throw new NoWhenBranchMatchedException();
            } else {
                Bitmap bitmap = value.getBitmap();
                i = bitmap.getWidth();
                i2 = bitmap.getHeight();
            }
            PixelSize pixelSize2 = (PixelSize) size2;
            if (Math.abs(i - pixelSize2.getWidth()) <= 1 && Math.abs(i2 - pixelSize2.getHeight()) <= 1) {
                return true;
            }
            double computeSizeMultiplier = DecodeUtils.computeSizeMultiplier(i, i2, pixelSize2.getWidth(), pixelSize2.getHeight(), imageRequest.getScale());
            if (computeSizeMultiplier != 1.0d && !Requests.getAllowInexactSize(imageRequest)) {
                Logger logger3 = this.logger;
                if (logger3 != null && logger3.getLevel() <= 3) {
                    logger3.log(TAG, 3, imageRequest.getData() + ": Cached image's request size (" + i + ", " + i2 + ") " + "does not exactly match the requested size (" + pixelSize2.getWidth() + ", " + pixelSize2.getHeight() + ", " + imageRequest.getScale() + ").", (Throwable) null);
                }
                return false;
            } else if (computeSizeMultiplier <= 1.0d || !value.isSampled()) {
                return true;
            } else {
                Logger logger4 = this.logger;
                if (logger4 != null && logger4.getLevel() <= 3) {
                    logger4.log(TAG, 3, imageRequest.getData() + ": Cached image's request size (" + i + ", " + i2 + ") " + "is smaller than the requested size (" + pixelSize2.getWidth() + ", " + pixelSize2.getHeight() + ", " + imageRequest.getScale() + ").", (Throwable) null);
                }
                return false;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void invalidateData(Object obj) {
        if (obj instanceof BitmapDrawable) {
            BitmapReferenceCounter bitmapReferenceCounter = this.referenceCounter;
            Bitmap bitmap = ((BitmapDrawable) obj).getBitmap();
            if (bitmap != null) {
                bitmapReferenceCounter.setValid(bitmap, false);
            }
        } else if (obj instanceof Bitmap) {
            this.referenceCounter.setValid((Bitmap) obj, false);
        }
    }

    /* access modifiers changed from: private */
    public final void validateDrawable(Drawable drawable) {
        Bitmap bitmap = null;
        if (!(drawable instanceof BitmapDrawable)) {
            drawable = null;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        if (bitmapDrawable != null) {
            bitmap = bitmapDrawable.getBitmap();
        }
        if (bitmap != null) {
            this.referenceCounter.setValid(bitmap, true);
            this.referenceCounter.increment(bitmap);
        }
    }

    /* JADX WARNING: type inference failed for: r14v0, types: [java.lang.Throwable, kotlin.coroutines.Continuation] */
    /* JADX WARNING: type inference failed for: r14v1 */
    /* JADX WARNING: type inference failed for: r14v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final /* synthetic */ java.lang.Object execute(java.lang.Object r17, coil.fetch.Fetcher<java.lang.Object> r18, coil.request.ImageRequest r19, int r20, coil.size.Size r21, coil.EventListener r22, kotlin.coroutines.Continuation<? super coil.fetch.DrawableResult> r23) {
        /*
            r16 = this;
            r0 = r18
            r7 = r19
            r8 = r21
            r9 = r22
            coil.memory.RequestService r1 = r16.requestService
            coil.util.SystemCallbacks r2 = r16.systemCallbacks
            boolean r2 = r2.isOnline()
            coil.decode.Options r10 = r1.options(r7, r8, r2)
            r9.fetchStart(r7, r0, r10)
            coil.bitmap.BitmapPool r2 = r16.bitmapPool
            r11 = 0
            kotlin.jvm.internal.InlineMarker.mark((int) r11)
            r1 = r18
            r3 = r17
            r4 = r21
            r5 = r10
            r6 = r23
            java.lang.Object r1 = r1.fetch(r2, r3, r4, r5, r6)
            r6 = 1
            kotlin.jvm.internal.InlineMarker.mark((int) r6)
            r12 = r1
            coil.fetch.FetchResult r12 = (coil.fetch.FetchResult) r12
            r9.fetchEnd(r7, r0, r10, r12)
            boolean r0 = r12 instanceof coil.fetch.SourceResult
            r13 = 3
            r14 = 0
            if (r0 == 0) goto L_0x00cd
            kotlin.jvm.internal.InlineMarker.mark((int) r13)     // Catch:{ all -> 0x00c0 }
            kotlin.coroutines.CoroutineContext r0 = r14.getContext()     // Catch:{ all -> 0x00c0 }
            kotlinx.coroutines.JobKt.ensureActive((kotlin.coroutines.CoroutineContext) r0)     // Catch:{ all -> 0x00c0 }
            if (r20 != 0) goto L_0x005e
            coil.target.Target r0 = r19.getTarget()     // Catch:{ all -> 0x00c0 }
            if (r0 != 0) goto L_0x005e
            coil.request.CachePolicy r0 = r19.getMemoryCachePolicy()     // Catch:{ all -> 0x00c0 }
            boolean r0 = r0.getWriteEnabled()     // Catch:{ all -> 0x00c0 }
            if (r0 != 0) goto L_0x005e
            r0 = 1
            goto L_0x005f
        L_0x005e:
            r0 = 0
        L_0x005f:
            if (r0 == 0) goto L_0x0066
            coil.decode.EmptyDecoder r0 = coil.decode.EmptyDecoder.INSTANCE     // Catch:{ all -> 0x00c0 }
            coil.decode.Decoder r0 = (coil.decode.Decoder) r0     // Catch:{ all -> 0x00c0 }
            goto L_0x006c
        L_0x0066:
            coil.decode.Decoder r0 = r19.getDecoder()     // Catch:{ all -> 0x00c0 }
            if (r0 == 0) goto L_0x006e
        L_0x006c:
            r15 = r0
            goto L_0x0089
        L_0x006e:
            coil.ComponentRegistry r0 = r16.registry     // Catch:{ all -> 0x00c0 }
            java.lang.Object r1 = r19.getData()     // Catch:{ all -> 0x00c0 }
            r2 = r12
            coil.fetch.SourceResult r2 = (coil.fetch.SourceResult) r2     // Catch:{ all -> 0x00c0 }
            okio.BufferedSource r2 = r2.getSource()     // Catch:{ all -> 0x00c0 }
            r3 = r12
            coil.fetch.SourceResult r3 = (coil.fetch.SourceResult) r3     // Catch:{ all -> 0x00c0 }
            java.lang.String r3 = r3.getMimeType()     // Catch:{ all -> 0x00c0 }
            coil.decode.Decoder r0 = coil.util.ComponentRegistries.requireDecoder(r0, r1, r2, r3)     // Catch:{ all -> 0x00c0 }
            goto L_0x006c
        L_0x0089:
            r9.decodeStart(r7, r15, r10)     // Catch:{ all -> 0x00c0 }
            coil.bitmap.BitmapPool r1 = r16.bitmapPool     // Catch:{ all -> 0x00c0 }
            r0 = r12
            coil.fetch.SourceResult r0 = (coil.fetch.SourceResult) r0     // Catch:{ all -> 0x00c0 }
            okio.BufferedSource r2 = r0.getSource()     // Catch:{ all -> 0x00c0 }
            kotlin.jvm.internal.InlineMarker.mark((int) r11)     // Catch:{ all -> 0x00c0 }
            r0 = r15
            r3 = r21
            r4 = r10
            r5 = r23
            java.lang.Object r0 = r0.decode(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00c0 }
            kotlin.jvm.internal.InlineMarker.mark((int) r6)     // Catch:{ all -> 0x00c0 }
            coil.decode.DecodeResult r0 = (coil.decode.DecodeResult) r0     // Catch:{ all -> 0x00c0 }
            r9.decodeEnd(r7, r15, r10, r0)     // Catch:{ all -> 0x00c0 }
            coil.fetch.DrawableResult r1 = new coil.fetch.DrawableResult
            android.graphics.drawable.Drawable r2 = r0.getDrawable()
            boolean r0 = r0.isSampled()
            coil.fetch.SourceResult r12 = (coil.fetch.SourceResult) r12
            coil.decode.DataSource r3 = r12.getDataSource()
            r1.<init>(r2, r0, r3)
            goto L_0x00d4
        L_0x00c0:
            r0 = move-exception
            coil.fetch.SourceResult r12 = (coil.fetch.SourceResult) r12
            okio.BufferedSource r1 = r12.getSource()
            java.io.Closeable r1 = (java.io.Closeable) r1
            coil.util.Extensions.closeQuietly(r1)
            throw r0
        L_0x00cd:
            boolean r0 = r12 instanceof coil.fetch.DrawableResult
            if (r0 == 0) goto L_0x022c
            r1 = r12
            coil.fetch.DrawableResult r1 = (coil.fetch.DrawableResult) r1
        L_0x00d4:
            r12 = r1
            kotlin.jvm.internal.InlineMarker.mark((int) r13)
            kotlin.coroutines.CoroutineContext r0 = r14.getContext()
            kotlinx.coroutines.JobKt.ensureActive((kotlin.coroutines.CoroutineContext) r0)
            java.util.List r15 = r19.getTransformations()
            boolean r0 = r15.isEmpty()
            if (r0 == 0) goto L_0x00eb
            goto L_0x0214
        L_0x00eb:
            android.graphics.drawable.Drawable r0 = r12.getDrawable()
            boolean r0 = r0 instanceof android.graphics.drawable.BitmapDrawable
            java.lang.String r1 = " to apply transformations: "
            r2 = 4
            java.lang.String r3 = "EngineInterceptor"
            if (r0 == 0) goto L_0x015a
            android.graphics.drawable.Drawable r0 = r12.getDrawable()
            android.graphics.drawable.BitmapDrawable r0 = (android.graphics.drawable.BitmapDrawable) r0
            android.graphics.Bitmap r0 = r0.getBitmap()
            android.graphics.Bitmap$Config[] r4 = coil.memory.RequestService.VALID_TRANSFORMATION_CONFIGS
            java.lang.String r5 = "resultBitmap"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            android.graphics.Bitmap$Config r5 = coil.util.Bitmaps.getSafeConfig(r0)
            boolean r4 = kotlin.collections.ArraysKt.contains((T[]) r4, r5)
            if (r4 == 0) goto L_0x0115
            goto L_0x01a6
        L_0x0115:
            coil.util.Logger r4 = r16.logger
            if (r4 == 0) goto L_0x013f
            int r5 = r4.getLevel()
            if (r5 > r2) goto L_0x013f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r13 = "Converting bitmap with config "
            r5.append(r13)
            android.graphics.Bitmap$Config r0 = coil.util.Bitmaps.getSafeConfig(r0)
            r5.append(r0)
            r5.append(r1)
            r5.append(r15)
            java.lang.String r0 = r5.toString()
            r4.log(r3, r2, r0, r14)
        L_0x013f:
            coil.decode.DrawableDecoderService r0 = r16.drawableDecoder
            android.graphics.drawable.Drawable r1 = r12.getDrawable()
            android.graphics.Bitmap$Config r2 = r10.getConfig()
            coil.size.Scale r4 = r10.getScale()
            boolean r5 = r10.getAllowInexactSize()
            r3 = r21
            android.graphics.Bitmap r0 = r0.convert(r1, r2, r3, r4, r5)
            goto L_0x01a6
        L_0x015a:
            coil.util.Logger r0 = r16.logger
            if (r0 == 0) goto L_0x018c
            int r4 = r0.getLevel()
            if (r4 > r2) goto L_0x018c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Converting drawable of type "
            r4.append(r5)
            android.graphics.drawable.Drawable r5 = r12.getDrawable()
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getCanonicalName()
            r4.append(r5)
            r4.append(r1)
            r4.append(r15)
            java.lang.String r1 = r4.toString()
            r0.log(r3, r2, r1, r14)
        L_0x018c:
            coil.decode.DrawableDecoderService r0 = r16.drawableDecoder
            android.graphics.drawable.Drawable r1 = r12.getDrawable()
            android.graphics.Bitmap$Config r2 = r10.getConfig()
            coil.size.Scale r4 = r10.getScale()
            boolean r5 = r10.getAllowInexactSize()
            r3 = r21
            android.graphics.Bitmap r0 = r0.convert(r1, r2, r3, r4, r5)
        L_0x01a6:
            java.lang.String r1 = "input"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r9.transformStart(r7, r0)
            r1 = r15
            java.util.Collection r1 = (java.util.Collection) r1
            int r1 = r1.size()
            r2 = 0
        L_0x01b6:
            if (r2 >= r1) goto L_0x01e3
            java.lang.Object r3 = r15.get(r2)
            coil.transform.Transformation r3 = (coil.transform.Transformation) r3
            coil.bitmap.BitmapPool r4 = r16.bitmapPool
            java.lang.String r5 = "bitmap"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            kotlin.jvm.internal.InlineMarker.mark((int) r11)
            r5 = r23
            java.lang.Object r0 = r3.transform(r4, r0, r8, r5)
            kotlin.jvm.internal.InlineMarker.mark((int) r6)
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            r3 = 3
            kotlin.jvm.internal.InlineMarker.mark((int) r3)
            kotlin.coroutines.CoroutineContext r4 = r14.getContext()
            kotlinx.coroutines.JobKt.ensureActive((kotlin.coroutines.CoroutineContext) r4)
            int r2 = r2 + 1
            goto L_0x01b6
        L_0x01e3:
            java.lang.String r1 = "output"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r9.transformEnd(r7, r0)
            android.content.Context r1 = r19.getContext()
            android.content.res.Resources r1 = r1.getResources()
            java.lang.String r2 = "context.resources"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            android.graphics.drawable.BitmapDrawable r2 = new android.graphics.drawable.BitmapDrawable
            r2.<init>(r1, r0)
            r0 = r2
            android.graphics.drawable.Drawable r0 = (android.graphics.drawable.Drawable) r0
            r1 = 0
            r2 = 0
            r3 = 6
            r4 = 0
            r17 = r12
            r18 = r0
            r19 = r1
            r20 = r2
            r21 = r3
            r22 = r4
            coil.fetch.DrawableResult r12 = coil.fetch.DrawableResult.copy$default(r17, r18, r19, r20, r21, r22)
        L_0x0214:
            android.graphics.drawable.Drawable r0 = r12.getDrawable()
            boolean r1 = r0 instanceof android.graphics.drawable.BitmapDrawable
            if (r1 != 0) goto L_0x021d
            goto L_0x021e
        L_0x021d:
            r14 = r0
        L_0x021e:
            android.graphics.drawable.BitmapDrawable r14 = (android.graphics.drawable.BitmapDrawable) r14
            if (r14 == 0) goto L_0x022b
            android.graphics.Bitmap r0 = r14.getBitmap()
            if (r0 == 0) goto L_0x022b
            r0.prepareToDraw()
        L_0x022b:
            return r12
        L_0x022c:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.execute(java.lang.Object, coil.fetch.Fetcher, coil.request.ImageRequest, int, coil.size.Size, coil.EventListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object applyTransformations$coil_base_release(coil.fetch.DrawableResult r20, coil.request.ImageRequest r21, coil.size.Size r22, coil.decode.Options r23, coil.EventListener r24, kotlin.coroutines.Continuation<? super coil.fetch.DrawableResult> r25) {
        /*
            r19 = this;
            r0 = r25
            boolean r1 = r0 instanceof coil.intercept.EngineInterceptor$applyTransformations$1
            if (r1 == 0) goto L_0x0018
            r1 = r0
            coil.intercept.EngineInterceptor$applyTransformations$1 r1 = (coil.intercept.EngineInterceptor$applyTransformations$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0018
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r2 = r19
            goto L_0x001f
        L_0x0018:
            coil.intercept.EngineInterceptor$applyTransformations$1 r1 = new coil.intercept.EngineInterceptor$applyTransformations$1
            r2 = r19
            r1.<init>(r2, r0)
        L_0x001f:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 1
            if (r4 == 0) goto L_0x0061
            if (r4 != r5) goto L_0x0059
            int r4 = r1.I$1
            int r6 = r1.I$0
            java.lang.Object r7 = r1.L$5
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r1.L$4
            coil.EventListener r8 = (coil.EventListener) r8
            java.lang.Object r9 = r1.L$3
            coil.size.Size r9 = (coil.size.Size) r9
            java.lang.Object r10 = r1.L$2
            coil.request.ImageRequest r10 = (coil.request.ImageRequest) r10
            java.lang.Object r11 = r1.L$1
            coil.fetch.DrawableResult r11 = (coil.fetch.DrawableResult) r11
            java.lang.Object r12 = r1.L$0
            coil.intercept.EngineInterceptor r12 = (coil.intercept.EngineInterceptor) r12
            kotlin.ResultKt.throwOnFailure(r0)
            r17 = r3
            r3 = r1
            r1 = r9
            r9 = r4
            r4 = r17
            r18 = r8
            r8 = r7
            r7 = r18
            goto L_0x017e
        L_0x0059:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0061:
            kotlin.ResultKt.throwOnFailure(r0)
            java.util.List r0 = r21.getTransformations()
            boolean r4 = r0.isEmpty()
            if (r4 == 0) goto L_0x006f
            return r20
        L_0x006f:
            android.graphics.drawable.Drawable r4 = r20.getDrawable()
            boolean r4 = r4 instanceof android.graphics.drawable.BitmapDrawable
            r6 = 0
            java.lang.String r7 = " to apply transformations: "
            r8 = 4
            java.lang.String r9 = "EngineInterceptor"
            if (r4 == 0) goto L_0x00df
            android.graphics.drawable.Drawable r4 = r20.getDrawable()
            android.graphics.drawable.BitmapDrawable r4 = (android.graphics.drawable.BitmapDrawable) r4
            android.graphics.Bitmap r4 = r4.getBitmap()
            android.graphics.Bitmap$Config[] r10 = coil.memory.RequestService.VALID_TRANSFORMATION_CONFIGS
            java.lang.String r11 = "resultBitmap"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r11)
            android.graphics.Bitmap$Config r11 = coil.util.Bitmaps.getSafeConfig(r4)
            boolean r10 = kotlin.collections.ArraysKt.contains((T[]) r10, r11)
            if (r10 == 0) goto L_0x009a
            goto L_0x012b
        L_0x009a:
            coil.util.Logger r10 = r19.logger
            if (r10 == 0) goto L_0x00c4
            int r11 = r10.getLevel()
            if (r11 > r8) goto L_0x00c4
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Converting bitmap with config "
            r11.append(r12)
            android.graphics.Bitmap$Config r4 = coil.util.Bitmaps.getSafeConfig(r4)
            r11.append(r4)
            r11.append(r7)
            r11.append(r0)
            java.lang.String r4 = r11.toString()
            r10.log(r9, r8, r4, r6)
        L_0x00c4:
            coil.decode.DrawableDecoderService r11 = r19.drawableDecoder
            android.graphics.drawable.Drawable r12 = r20.getDrawable()
            android.graphics.Bitmap$Config r13 = r23.getConfig()
            coil.size.Scale r15 = r23.getScale()
            boolean r16 = r23.getAllowInexactSize()
            r14 = r22
            android.graphics.Bitmap r4 = r11.convert(r12, r13, r14, r15, r16)
            goto L_0x012b
        L_0x00df:
            coil.util.Logger r4 = r19.logger
            if (r4 == 0) goto L_0x0111
            int r10 = r4.getLevel()
            if (r10 > r8) goto L_0x0111
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Converting drawable of type "
            r10.append(r11)
            android.graphics.drawable.Drawable r11 = r20.getDrawable()
            java.lang.Class r11 = r11.getClass()
            java.lang.String r11 = r11.getCanonicalName()
            r10.append(r11)
            r10.append(r7)
            r10.append(r0)
            java.lang.String r7 = r10.toString()
            r4.log(r9, r8, r7, r6)
        L_0x0111:
            coil.decode.DrawableDecoderService r10 = r19.drawableDecoder
            android.graphics.drawable.Drawable r11 = r20.getDrawable()
            android.graphics.Bitmap$Config r12 = r23.getConfig()
            coil.size.Scale r14 = r23.getScale()
            boolean r15 = r23.getAllowInexactSize()
            r13 = r22
            android.graphics.Bitmap r4 = r10.convert(r11, r12, r13, r14, r15)
        L_0x012b:
            java.lang.String r6 = "input"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            r6 = r21
            r7 = r24
            r7.transformStart(r6, r4)
            r8 = 0
            r9 = r0
            java.util.Collection r9 = (java.util.Collection) r9
            int r9 = r9.size()
            r11 = r0
            r12 = r2
            r8 = r4
            r10 = 0
            r0 = r20
            r4 = r3
            r3 = r1
            r1 = r22
        L_0x0149:
            if (r10 >= r9) goto L_0x0194
            java.lang.Object r13 = r11.get(r10)
            coil.transform.Transformation r13 = (coil.transform.Transformation) r13
            coil.bitmap.BitmapPool r14 = r12.bitmapPool
            java.lang.String r15 = "bitmap"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r15)
            r3.L$0 = r12
            r3.L$1 = r0
            r3.L$2 = r6
            r3.L$3 = r1
            r3.L$4 = r7
            r3.L$5 = r11
            r3.I$0 = r10
            r3.I$1 = r9
            r3.label = r5
            java.lang.Object r8 = r13.transform(r14, r8, r1, r3)
            if (r8 != r4) goto L_0x0173
            return r4
        L_0x0173:
            r17 = r11
            r11 = r0
            r0 = r8
            r8 = r17
            r18 = r10
            r10 = r6
            r6 = r18
        L_0x017e:
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            kotlin.coroutines.CoroutineContext r13 = r3.getContext()
            kotlinx.coroutines.JobKt.ensureActive((kotlin.coroutines.CoroutineContext) r13)
            int r6 = r6 + r5
            r17 = r8
            r8 = r0
            r0 = r11
            r11 = r17
            r18 = r10
            r10 = r6
            r6 = r18
            goto L_0x0149
        L_0x0194:
            java.lang.String r1 = "output"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)
            r7.transformEnd(r6, r8)
            android.content.Context r1 = r6.getContext()
            android.content.res.Resources r1 = r1.getResources()
            java.lang.String r3 = "context.resources"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            android.graphics.drawable.BitmapDrawable r3 = new android.graphics.drawable.BitmapDrawable
            r3.<init>(r1, r8)
            r1 = r3
            android.graphics.drawable.Drawable r1 = (android.graphics.drawable.Drawable) r1
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            r20 = r0
            r21 = r1
            r22 = r3
            r23 = r4
            r24 = r5
            r25 = r6
            coil.fetch.DrawableResult r0 = coil.fetch.DrawableResult.copy$default(r20, r21, r22, r23, r24, r25)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.applyTransformations$coil_base_release(coil.fetch.DrawableResult, coil.request.ImageRequest, coil.size.Size, coil.decode.Options, coil.EventListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [java.lang.Throwable, kotlin.coroutines.Continuation] */
    private final Object applyTransformations$coil_base_release$$forInline(DrawableResult drawableResult, ImageRequest imageRequest, Size size, Options options, EventListener eventListener, Continuation continuation) {
        Bitmap bitmap;
        ImageRequest imageRequest2 = imageRequest;
        EventListener eventListener2 = eventListener;
        List<Transformation> transformations = imageRequest.getTransformations();
        if (transformations.isEmpty()) {
            return drawableResult;
        }
        ? r7 = 0;
        if (drawableResult.getDrawable() instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawableResult.getDrawable()).getBitmap();
            Bitmap.Config[] configArr = RequestService.VALID_TRANSFORMATION_CONFIGS;
            Intrinsics.checkNotNullExpressionValue(bitmap, "resultBitmap");
            if (!ArraysKt.contains((T[]) configArr, Bitmaps.getSafeConfig(bitmap))) {
                Logger access$getLogger$p = this.logger;
                if (access$getLogger$p != null && access$getLogger$p.getLevel() <= 4) {
                    access$getLogger$p.log(TAG, 4, "Converting bitmap with config " + Bitmaps.getSafeConfig(bitmap) + " to apply transformations: " + transformations, r7);
                }
                bitmap = this.drawableDecoder.convert(drawableResult.getDrawable(), options.getConfig(), size, options.getScale(), options.getAllowInexactSize());
            }
        } else {
            Logger access$getLogger$p2 = this.logger;
            if (access$getLogger$p2 != null && access$getLogger$p2.getLevel() <= 4) {
                access$getLogger$p2.log(TAG, 4, "Converting drawable of type " + drawableResult.getDrawable().getClass().getCanonicalName() + " to apply transformations: " + transformations, r7);
            }
            bitmap = this.drawableDecoder.convert(drawableResult.getDrawable(), options.getConfig(), size, options.getScale(), options.getAllowInexactSize());
        }
        Intrinsics.checkNotNullExpressionValue(bitmap, "input");
        eventListener2.transformStart(imageRequest2, bitmap);
        int size2 = transformations.size();
        for (int i = 0; i < size2; i++) {
            BitmapPool access$getBitmapPool$p = this.bitmapPool;
            Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
            InlineMarker.mark(0);
            Object transform = transformations.get(i).transform(access$getBitmapPool$p, bitmap, size, continuation);
            InlineMarker.mark(1);
            bitmap = (Bitmap) transform;
            InlineMarker.mark(3);
            JobKt.ensureActive(r7.getContext());
        }
        Intrinsics.checkNotNullExpressionValue(bitmap, "output");
        eventListener2.transformEnd(imageRequest2, bitmap);
        Resources resources = imageRequest.getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        return DrawableResult.copy$default(drawableResult, new BitmapDrawable(resources, bitmap), false, (DataSource) null, 6, (Object) null);
    }

    /* access modifiers changed from: private */
    public final boolean writeToMemoryCache(ImageRequest imageRequest, MemoryCache.Key key, Drawable drawable, boolean z) {
        if (imageRequest.getMemoryCachePolicy().getWriteEnabled() && key != null) {
            Bitmap bitmap = null;
            if (!(drawable instanceof BitmapDrawable)) {
                drawable = null;
            }
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable != null) {
                bitmap = bitmapDrawable.getBitmap();
            }
            if (bitmap != null) {
                this.strongMemoryCache.set(key, bitmap, z);
                return true;
            }
        }
        return false;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcoil/intercept/EngineInterceptor$Companion;", "", "()V", "TAG", "", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: EngineInterceptor.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
