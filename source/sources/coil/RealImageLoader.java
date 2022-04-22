package coil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import coil.EventListener;
import coil.bitmap.BitmapPool;
import coil.bitmap.BitmapReferenceCounter;
import coil.decode.BitmapFactoryDecoder;
import coil.decode.DataSource;
import coil.decode.Decoder;
import coil.decode.DrawableDecoderService;
import coil.fetch.AssetUriFetcher;
import coil.fetch.BitmapFetcher;
import coil.fetch.ContentUriFetcher;
import coil.fetch.DrawableFetcher;
import coil.fetch.FileFetcher;
import coil.fetch.HttpUriFetcher;
import coil.fetch.HttpUrlFetcher;
import coil.fetch.ResourceUriFetcher;
import coil.intercept.EngineInterceptor;
import coil.intercept.Interceptor;
import coil.intercept.RealInterceptorChain;
import coil.map.FileUriMapper;
import coil.map.ResourceIntMapper;
import coil.map.ResourceUriMapper;
import coil.map.StringMapper;
import coil.memory.DelegateService;
import coil.memory.MemoryCacheService;
import coil.memory.RealMemoryCache;
import coil.memory.RequestService;
import coil.memory.StrongMemoryCache;
import coil.memory.TargetDelegate;
import coil.memory.ViewTargetRequestManager;
import coil.memory.WeakMemoryCache;
import coil.request.BaseTargetDisposable;
import coil.request.DefaultRequestOptions;
import coil.request.Disposable;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.SuccessResult;
import coil.request.ViewTargetDisposable;
import coil.size.Size;
import coil.target.ViewTarget;
import coil.util.Extensions;
import coil.util.Logger;
import coil.util.SystemCallbacks;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.io.File;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.Call;
import okhttp3.HttpUrl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 X2\u00020\u0001:\u0001XBg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\u0019J\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0016J\u0019\u0010:\u001a\u00020;2\u0006\u00108\u001a\u000209H@ø\u0001\u0000¢\u0006\u0002\u0010<J;\u0010=\u001a\u00020;2\u0006\u00108\u001a\u0002092\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020EHHø\u0001\u0000¢\u0006\u0002\u0010FJ!\u0010G\u001a\u00020;2\u0006\u0010H\u001a\u0002092\u0006\u0010>\u001a\u00020?H@ø\u0001\u0000¢\u0006\u0002\u0010IJ\u0018\u0010J\u001a\u00020K2\u0006\u00108\u001a\u0002092\u0006\u0010D\u001a\u00020EH\u0002J)\u0010L\u001a\u00020K2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\u0006\u0010D\u001a\u00020EHHø\u0001\u0000¢\u0006\u0002\u0010QJ)\u0010R\u001a\u00020K2\u0006\u0010M\u001a\u00020S2\u0006\u0010O\u001a\u00020P2\u0006\u0010D\u001a\u00020EHHø\u0001\u0000¢\u0006\u0002\u0010TJ\u000e\u0010U\u001a\u00020K2\u0006\u0010V\u001a\u00020?J\b\u0010W\u001a\u00020KH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020*X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006Y"}, mo26107d2 = {"Lcoil/RealImageLoader;", "Lcoil/ImageLoader;", "context", "Landroid/content/Context;", "defaults", "Lcoil/request/DefaultRequestOptions;", "bitmapPool", "Lcoil/bitmap/BitmapPool;", "referenceCounter", "Lcoil/bitmap/BitmapReferenceCounter;", "strongMemoryCache", "Lcoil/memory/StrongMemoryCache;", "weakMemoryCache", "Lcoil/memory/WeakMemoryCache;", "callFactory", "Lokhttp3/Call$Factory;", "eventListenerFactory", "Lcoil/EventListener$Factory;", "componentRegistry", "Lcoil/ComponentRegistry;", "addLastModifiedToFileCacheKey", "", "launchInterceptorChainOnMainThread", "logger", "Lcoil/util/Logger;", "(Landroid/content/Context;Lcoil/request/DefaultRequestOptions;Lcoil/bitmap/BitmapPool;Lcoil/bitmap/BitmapReferenceCounter;Lcoil/memory/StrongMemoryCache;Lcoil/memory/WeakMemoryCache;Lokhttp3/Call$Factory;Lcoil/EventListener$Factory;Lcoil/ComponentRegistry;ZZLcoil/util/Logger;)V", "getBitmapPool", "()Lcoil/bitmap/BitmapPool;", "getDefaults", "()Lcoil/request/DefaultRequestOptions;", "delegateService", "Lcoil/memory/DelegateService;", "drawableDecoder", "Lcoil/decode/DrawableDecoderService;", "interceptors", "", "Lcoil/intercept/Interceptor;", "isShutdown", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getLogger", "()Lcoil/util/Logger;", "memoryCache", "Lcoil/memory/RealMemoryCache;", "getMemoryCache", "()Lcoil/memory/RealMemoryCache;", "memoryCacheService", "Lcoil/memory/MemoryCacheService;", "registry", "requestService", "Lcoil/memory/RequestService;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "systemCallbacks", "Lcoil/util/SystemCallbacks;", "enqueue", "Lcoil/request/Disposable;", "request", "Lcoil/request/ImageRequest;", "execute", "Lcoil/request/ImageResult;", "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeChain", "type", "", "size", "Lcoil/size/Size;", "cached", "Landroid/graphics/Bitmap;", "eventListener", "Lcoil/EventListener;", "(Lcoil/request/ImageRequest;ILcoil/size/Size;Landroid/graphics/Bitmap;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeMain", "initialRequest", "(Lcoil/request/ImageRequest;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCancel", "", "onError", "result", "Lcoil/request/ErrorResult;", "targetDelegate", "Lcoil/memory/TargetDelegate;", "(Lcoil/request/ErrorResult;Lcoil/memory/TargetDelegate;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSuccess", "Lcoil/request/SuccessResult;", "(Lcoil/request/SuccessResult;Lcoil/memory/TargetDelegate;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onTrimMemory", "level", "shutdown", "Companion", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: RealImageLoader.kt */
public final class RealImageLoader implements ImageLoader {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "RealImageLoader";
    private final BitmapPool bitmapPool;
    private final DefaultRequestOptions defaults;
    private final DelegateService delegateService;
    private final DrawableDecoderService drawableDecoder;
    private final EventListener.Factory eventListenerFactory;
    /* access modifiers changed from: private */
    public final List<Interceptor> interceptors;
    private final AtomicBoolean isShutdown;
    /* access modifiers changed from: private */
    public final boolean launchInterceptorChainOnMainThread;
    private final Logger logger;
    private final RealMemoryCache memoryCache;
    private final MemoryCacheService memoryCacheService;
    /* access modifiers changed from: private */
    public final BitmapReferenceCounter referenceCounter;
    private final ComponentRegistry registry;
    private final RequestService requestService;
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()).plus(new RealImageLoader$$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, this)));
    private final StrongMemoryCache strongMemoryCache;
    private final SystemCallbacks systemCallbacks;
    private final WeakMemoryCache weakMemoryCache;

    public RealImageLoader(Context context, DefaultRequestOptions defaultRequestOptions, BitmapPool bitmapPool2, BitmapReferenceCounter bitmapReferenceCounter, StrongMemoryCache strongMemoryCache2, WeakMemoryCache weakMemoryCache2, Call.Factory factory, EventListener.Factory factory2, ComponentRegistry componentRegistry, boolean z, boolean z2, Logger logger2) {
        Context context2 = context;
        DefaultRequestOptions defaultRequestOptions2 = defaultRequestOptions;
        BitmapPool bitmapPool3 = bitmapPool2;
        BitmapReferenceCounter bitmapReferenceCounter2 = bitmapReferenceCounter;
        StrongMemoryCache strongMemoryCache3 = strongMemoryCache2;
        WeakMemoryCache weakMemoryCache3 = weakMemoryCache2;
        Call.Factory factory3 = factory;
        EventListener.Factory factory4 = factory2;
        Logger logger3 = logger2;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(defaultRequestOptions2, RemoteConfigComponent.DEFAULTS_FILE_NAME);
        Intrinsics.checkNotNullParameter(bitmapPool3, "bitmapPool");
        Intrinsics.checkNotNullParameter(bitmapReferenceCounter2, "referenceCounter");
        Intrinsics.checkNotNullParameter(strongMemoryCache3, "strongMemoryCache");
        Intrinsics.checkNotNullParameter(weakMemoryCache3, "weakMemoryCache");
        Intrinsics.checkNotNullParameter(factory3, "callFactory");
        Intrinsics.checkNotNullParameter(factory4, "eventListenerFactory");
        Intrinsics.checkNotNullParameter(componentRegistry, "componentRegistry");
        this.defaults = defaultRequestOptions2;
        this.bitmapPool = bitmapPool3;
        this.referenceCounter = bitmapReferenceCounter2;
        this.strongMemoryCache = strongMemoryCache3;
        this.weakMemoryCache = weakMemoryCache3;
        this.eventListenerFactory = factory4;
        this.launchInterceptorChainOnMainThread = z2;
        this.logger = logger3;
        this.delegateService = new DelegateService(this, bitmapReferenceCounter2, logger3);
        MemoryCacheService memoryCacheService2 = new MemoryCacheService(bitmapReferenceCounter2, strongMemoryCache3, weakMemoryCache3);
        this.memoryCacheService = memoryCacheService2;
        RequestService requestService2 = new RequestService(logger3);
        this.requestService = requestService2;
        this.memoryCache = new RealMemoryCache(strongMemoryCache3, weakMemoryCache3, bitmapReferenceCounter2);
        DrawableDecoderService drawableDecoderService = new DrawableDecoderService(getBitmapPool());
        this.drawableDecoder = drawableDecoderService;
        SystemCallbacks systemCallbacks2 = new SystemCallbacks(this, context2);
        this.systemCallbacks = systemCallbacks2;
        ComponentRegistry build = componentRegistry.newBuilder().add(new StringMapper(), String.class).add(new FileUriMapper(), Uri.class).add(new ResourceUriMapper(context2), Uri.class).add(new ResourceIntMapper(context2), Integer.class).add(new HttpUriFetcher(factory3), Uri.class).add(new HttpUrlFetcher(factory3), HttpUrl.class).add(new FileFetcher(z), File.class).add(new AssetUriFetcher(context2), Uri.class).add(new ContentUriFetcher(context2), Uri.class).add(new ResourceUriFetcher(context2, drawableDecoderService), Uri.class).add(new DrawableFetcher(drawableDecoderService), Drawable.class).add(new BitmapFetcher(), Bitmap.class).add((Decoder) new BitmapFactoryDecoder(context2)).build();
        this.registry = build;
        this.interceptors = CollectionsKt.plus(build.getInterceptors$coil_base_release(), new EngineInterceptor(build, getBitmapPool(), bitmapReferenceCounter2, strongMemoryCache3, memoryCacheService2, requestService2, systemCallbacks2, drawableDecoderService, logger3));
        this.isShutdown = new AtomicBoolean(false);
    }

    public DefaultRequestOptions getDefaults() {
        return this.defaults;
    }

    public BitmapPool getBitmapPool() {
        return this.bitmapPool;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    public RealMemoryCache getMemoryCache() {
        return this.memoryCache;
    }

    public Disposable enqueue(ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Job launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new RealImageLoader$enqueue$job$1(this, imageRequest, (Continuation) null), 3, (Object) null);
        if (imageRequest.getTarget() instanceof ViewTarget) {
            return new ViewTargetDisposable(Extensions.getRequestManager(((ViewTarget) imageRequest.getTarget()).getView()).setCurrentRequestJob(launch$default), (ViewTarget) imageRequest.getTarget());
        }
        return new BaseTargetDisposable(launch$default);
    }

    public Object execute(ImageRequest imageRequest, Continuation<? super ImageResult> continuation) {
        if (imageRequest.getTarget() instanceof ViewTarget) {
            ViewTargetRequestManager requestManager = Extensions.getRequestManager(((ViewTarget) imageRequest.getTarget()).getView());
            CoroutineContext.Element element = continuation.getContext().get(Job.Key);
            Intrinsics.checkNotNull(element);
            requestManager.setCurrentRequestJob((Job) element);
        }
        return BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new RealImageLoader$execute$2(this, imageRequest, (Continuation) null), continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v24, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v17, resolved type: coil.memory.TargetDelegate} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v30, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v16, resolved type: coil.request.ImageRequest} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v31, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v17, resolved type: coil.RealImageLoader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v32, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v19, resolved type: coil.memory.TargetDelegate} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v23, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v18, resolved type: coil.request.ImageRequest} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v24, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v19, resolved type: coil.RealImageLoader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v51, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v36, resolved type: coil.memory.RequestDelegate} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v52, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v21, resolved type: coil.memory.TargetDelegate} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v53, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v31, resolved type: coil.EventListener} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v54, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v20, resolved type: coil.request.ImageRequest} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v55, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v21, resolved type: coil.RealImageLoader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v56, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v38, resolved type: coil.memory.RequestDelegate} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v57, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v23, resolved type: coil.memory.TargetDelegate} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v58, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v33, resolved type: coil.EventListener} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v59, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v22, resolved type: coil.request.ImageRequest} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v60, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v23, resolved type: coil.RealImageLoader} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:101:?, code lost:
        r0 = ((coil.request.SuccessResult) r5).getRequest();
        r2 = ((coil.request.SuccessResult) r5).getMetadata();
        r9 = r2.getDataSource();
        r10 = r15.getLogger();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x02b3, code lost:
        if (r10 == null) goto L_0x02ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02b9, code lost:
        r16 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x02bc, code lost:
        if (r10.getLevel() > 4) goto L_0x02eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
        r10.log(TAG, 4, coil.util.Extensions.getEmoji(r9) + " Successful (" + r9.name() + ") - " + r0.getData(), (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02eb, code lost:
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02ee, code lost:
        r16 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x02f0, code lost:
        coil.util.Extensions.setMetadata(r12, r2);
        r3.L$0 = r15;
        r3.L$1 = r14;
        r3.L$2 = r13;
        r3.L$3 = r12;
        r3.L$4 = r11;
        r3.L$5 = r5;
        r3.L$6 = r15;
        r3.L$7 = r0;
        r3.L$8 = r2;
        r3.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x030f, code lost:
        if (r12.success((coil.request.SuccessResult) r5, r3) != r4) goto L_0x0312;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0311, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0312, code lost:
        r9 = r14;
        r10 = r15;
        r14 = r12;
        r12 = r5;
        r15 = r13;
        r5 = r0;
        r0 = r2;
        r13 = r11;
        r11 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:?, code lost:
        r15.onSuccess(r5, r0);
        r1 = r5.getListener();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0322, code lost:
        if (r1 == null) goto L_0x0329;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0324, code lost:
        r1.onSuccess(r5, r0);
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:?, code lost:
        r0 = access$getReferenceCounter$p(r11);
        r1 = ((coil.request.SuccessResult) r12).getDrawable();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0334, code lost:
        if (r1 == null) goto L_0x0349;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0338, code lost:
        if ((r1 instanceof android.graphics.drawable.BitmapDrawable) == false) goto L_0x0349;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x033a, code lost:
        r1 = ((android.graphics.drawable.BitmapDrawable) r1).getBitmap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0340, code lost:
        if (r1 == null) goto L_0x0349;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0342, code lost:
        kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0.decrement(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0349, code lost:
        r5 = r12;
        r11 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x034d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x034e, code lost:
        r5 = r13;
        r12 = r14;
        r6 = r16;
        r14 = r9;
        r9 = r15;
        r15 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0357, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x035a, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x035c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x035d, code lost:
        r16 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x035f, code lost:
        r1 = r13;
        r9 = r14;
        r13 = r11;
        r14 = r12;
        r11 = r15;
        r12 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x038e, code lost:
        r16 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0392, code lost:
        if ((r5 instanceof coil.request.ErrorResult) == false) goto L_0x0415;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0394, code lost:
        r0 = ((coil.request.ErrorResult) r5).getRequest();
        r1 = r15.getLogger();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x039f, code lost:
        if (r1 == null) goto L_0x03d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x03a6, code lost:
        if (r1.getLevel() > 4) goto L_0x03d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x03a8, code lost:
        r2 = new java.lang.StringBuilder();
        r2.append("🚨 Failed - ");
        r2.append(r0.getData());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x03b7, code lost:
        r6 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:?, code lost:
        r2.append(r6);
        r2.append(((coil.request.ErrorResult) r5).getThrowable());
        r1.log(TAG, 4, r2.toString(), (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x03d0, code lost:
        r6 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03d2, code lost:
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03d5, code lost:
        r6 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03d7, code lost:
        coil.util.Extensions.setMetadata(r12, (coil.request.ImageResult.Metadata) null);
        r3.L$0 = r15;
        r3.L$1 = r14;
        r3.L$2 = r13;
        r3.L$3 = r12;
        r3.L$4 = r11;
        r3.L$5 = r5;
        r3.L$6 = r0;
        r3.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03f6, code lost:
        if (r12.error((coil.request.ErrorResult) r5, r3) != r4) goto L_0x03f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03f8, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03f9, code lost:
        r13.onError(r0, ((coil.request.ErrorResult) r5).getThrowable());
        r1 = r0.getListener();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0407, code lost:
        if (r1 == null) goto L_0x0415;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0409, code lost:
        r1.onError(r0, ((coil.request.ErrorResult) r5).getThrowable());
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0415, code lost:
        r11.complete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0418, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0419, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x041a, code lost:
        r6 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x041e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:?, code lost:
        r1 = r15.referenceCounter;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0421, code lost:
        if (r5 != null) goto L_0x0423;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0423, code lost:
        r1.decrement(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0426, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0427, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0073, code lost:
        r5 = r11;
        r9 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01b0, code lost:
        r2 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        r5 = r15.memoryCacheService.get(r14.getPlaceholderMemoryCacheKey());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01c1, code lost:
        if (r5 == null) goto L_0x01c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01c3, code lost:
        r5 = r5.getBitmap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01c8, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        coil.util.Extensions.setMetadata(r12, (coil.request.ImageResult.Metadata) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01d0, code lost:
        if (r5 == null) goto L_0x01e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01d2, code lost:
        r10 = r14.getContext().getResources();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, "context.resources");
        r11 = new android.graphics.drawable.BitmapDrawable(r10, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01e7, code lost:
        r11 = r14.getPlaceholder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01eb, code lost:
        r12.start(r11, r5);
        r9.onStart(r14);
        r10 = r14.getListener();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01f5, code lost:
        if (r10 == null) goto L_0x01fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01f7, code lost:
        r10.onStart(r14);
        r10 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        r10 = r15.referenceCounter;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01fe, code lost:
        if (r5 == null) goto L_0x0203;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0200, code lost:
        r10.decrement(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0203, code lost:
        r9.resolveSizeStart(r14);
        r10 = r14.getSizeResolver();
        r3.L$0 = r15;
        r3.L$1 = r14;
        r3.L$2 = r9;
        r3.L$3 = r12;
        r3.L$4 = r2;
        r3.L$5 = r5;
        r3.I$0 = r0;
        r3.label = 2;
        r10 = r10.size(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x021f, code lost:
        if (r10 != r4) goto L_0x0222;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0221, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0222, code lost:
        r18 = r0;
        r23 = r5;
        r5 = r2;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
        r0 = (coil.size.Size) r2;
        r9.resolveSizeEnd(r14, r0);
        r2 = new kotlin.jvm.internal.Ref.ObjectRef();
        r2.element = new coil.intercept.RealInterceptorChain(r14, r18, access$getInterceptors$p(r15), 0, r14, r0, r23, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x024e, code lost:
        if (access$getLaunchInterceptorChainOnMainThread$p(r15) == false) goto L_0x0271;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0250, code lost:
        r3.L$0 = r15;
        r3.L$1 = r14;
        r3.L$2 = r9;
        r3.L$3 = r12;
        r3.L$4 = r5;
        r3.L$5 = null;
        r3.label = 3;
        r2 = r2.element.proceed(r14, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0268, code lost:
        if (r2 != r4) goto L_0x026b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x026a, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x026b, code lost:
        r2 = (coil.request.ImageResult) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x026d, code lost:
        r11 = r5;
        r13 = r9;
        r5 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0271, code lost:
        r3.L$0 = r15;
        r3.L$1 = r14;
        r3.L$2 = r9;
        r3.L$3 = r12;
        r3.L$4 = r5;
        r3.L$5 = null;
        r3.label = 4;
        r2 = kotlinx.coroutines.BuildersKt.withContext(r14.getDispatcher(), new coil.RealImageLoader$executeChain$2(r2, r14, (kotlin.coroutines.Continuation) null), r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0293, code lost:
        if (r2 != r4) goto L_0x0296;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0295, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0296, code lost:
        r2 = (coil.request.ImageResult) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x029b, code lost:
        if ((r5 instanceof coil.request.SuccessResult) == false) goto L_0x038e;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0439 A[Catch:{ all -> 0x004e }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x04b5 A[SYNTHETIC, Splitter:B:201:0x04b5] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object executeMain(coil.request.ImageRequest r26, int r27, kotlin.coroutines.Continuation<? super coil.request.ImageResult> r28) {
        /*
            r25 = this;
            r1 = r25
            r0 = r27
            r2 = r28
            boolean r3 = r2 instanceof coil.RealImageLoader$executeMain$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            coil.RealImageLoader$executeMain$1 r3 = (coil.RealImageLoader$executeMain$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            coil.RealImageLoader$executeMain$1 r3 = new coil.RealImageLoader$executeMain$1
            r3.<init>(r1, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            java.lang.String r6 = " - "
            java.lang.String r7 = "🚨 Failed - "
            java.lang.String r8 = "RealImageLoader"
            switch(r5) {
                case 0: goto L_0x0133;
                case 1: goto L_0x0112;
                case 2: goto L_0x00e5;
                case 3: goto L_0x00c7;
                case 4: goto L_0x00a9;
                case 5: goto L_0x0077;
                case 6: goto L_0x0051;
                case 7: goto L_0x0039;
                default: goto L_0x0031;
            }
        L_0x0031:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0039:
            java.lang.Object r0 = r3.L$3
            coil.request.ImageRequest r0 = (coil.request.ImageRequest) r0
            java.lang.Object r4 = r3.L$2
            coil.request.ErrorResult r4 = (coil.request.ErrorResult) r4
            java.lang.Object r5 = r3.L$1
            coil.memory.RequestDelegate r5 = (coil.memory.RequestDelegate) r5
            java.lang.Object r3 = r3.L$0
            coil.EventListener r3 = (coil.EventListener) r3
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x004e }
            goto L_0x049b
        L_0x004e:
            r0 = move-exception
            goto L_0x04b9
        L_0x0051:
            java.lang.Object r0 = r3.L$6
            coil.request.ImageRequest r0 = (coil.request.ImageRequest) r0
            java.lang.Object r5 = r3.L$5
            coil.request.ImageResult r5 = (coil.request.ImageResult) r5
            java.lang.Object r11 = r3.L$4
            coil.memory.RequestDelegate r11 = (coil.memory.RequestDelegate) r11
            java.lang.Object r12 = r3.L$3
            coil.memory.TargetDelegate r12 = (coil.memory.TargetDelegate) r12
            java.lang.Object r13 = r3.L$2
            coil.EventListener r13 = (coil.EventListener) r13
            java.lang.Object r14 = r3.L$1
            coil.request.ImageRequest r14 = (coil.request.ImageRequest) r14
            java.lang.Object r15 = r3.L$0
            coil.RealImageLoader r15 = (coil.RealImageLoader) r15
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0072 }
            goto L_0x03f9
        L_0x0072:
            r0 = move-exception
        L_0x0073:
            r5 = r11
            r9 = r13
            goto L_0x0435
        L_0x0077:
            java.lang.Object r0 = r3.L$8
            coil.request.ImageResult$Metadata r0 = (coil.request.ImageResult.Metadata) r0
            java.lang.Object r5 = r3.L$7
            coil.request.ImageRequest r5 = (coil.request.ImageRequest) r5
            java.lang.Object r11 = r3.L$6
            coil.RealImageLoader r11 = (coil.RealImageLoader) r11
            java.lang.Object r12 = r3.L$5
            coil.request.ImageResult r12 = (coil.request.ImageResult) r12
            java.lang.Object r13 = r3.L$4
            coil.memory.RequestDelegate r13 = (coil.memory.RequestDelegate) r13
            java.lang.Object r14 = r3.L$3
            coil.memory.TargetDelegate r14 = (coil.memory.TargetDelegate) r14
            java.lang.Object r15 = r3.L$2
            coil.EventListener r15 = (coil.EventListener) r15
            java.lang.Object r9 = r3.L$1
            coil.request.ImageRequest r9 = (coil.request.ImageRequest) r9
            java.lang.Object r10 = r3.L$0
            coil.RealImageLoader r10 = (coil.RealImageLoader) r10
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x00a2 }
            r16 = r6
            goto L_0x031b
        L_0x00a2:
            r0 = move-exception
            r16 = r6
        L_0x00a5:
            r1 = r15
            r15 = r10
            goto L_0x0365
        L_0x00a9:
            java.lang.Object r0 = r3.L$4
            r5 = r0
            coil.memory.RequestDelegate r5 = (coil.memory.RequestDelegate) r5
            java.lang.Object r0 = r3.L$3
            r12 = r0
            coil.memory.TargetDelegate r12 = (coil.memory.TargetDelegate) r12
            java.lang.Object r0 = r3.L$2
            r9 = r0
            coil.EventListener r9 = (coil.EventListener) r9
            java.lang.Object r0 = r3.L$1
            r14 = r0
            coil.request.ImageRequest r14 = (coil.request.ImageRequest) r14
            java.lang.Object r0 = r3.L$0
            r15 = r0
            coil.RealImageLoader r15 = (coil.RealImageLoader) r15
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0130 }
            goto L_0x0296
        L_0x00c7:
            java.lang.Object r0 = r3.L$4
            r5 = r0
            coil.memory.RequestDelegate r5 = (coil.memory.RequestDelegate) r5
            java.lang.Object r0 = r3.L$3
            r12 = r0
            coil.memory.TargetDelegate r12 = (coil.memory.TargetDelegate) r12
            java.lang.Object r0 = r3.L$2
            r9 = r0
            coil.EventListener r9 = (coil.EventListener) r9
            java.lang.Object r0 = r3.L$1
            r14 = r0
            coil.request.ImageRequest r14 = (coil.request.ImageRequest) r14
            java.lang.Object r0 = r3.L$0
            r15 = r0
            coil.RealImageLoader r15 = (coil.RealImageLoader) r15
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0130 }
            goto L_0x026b
        L_0x00e5:
            int r0 = r3.I$0
            java.lang.Object r5 = r3.L$5
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            java.lang.Object r9 = r3.L$4
            coil.memory.RequestDelegate r9 = (coil.memory.RequestDelegate) r9
            java.lang.Object r10 = r3.L$3
            r12 = r10
            coil.memory.TargetDelegate r12 = (coil.memory.TargetDelegate) r12
            java.lang.Object r10 = r3.L$2
            coil.EventListener r10 = (coil.EventListener) r10
            java.lang.Object r11 = r3.L$1
            r14 = r11
            coil.request.ImageRequest r14 = (coil.request.ImageRequest) r14
            java.lang.Object r11 = r3.L$0
            r15 = r11
            coil.RealImageLoader r15 = (coil.RealImageLoader) r15
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x010d }
            r18 = r0
            r23 = r5
            r5 = r9
            r9 = r10
            goto L_0x0228
        L_0x010d:
            r0 = move-exception
            r5 = r9
            r9 = r10
            goto L_0x0435
        L_0x0112:
            int r0 = r3.I$0
            java.lang.Object r5 = r3.L$4
            coil.memory.RequestDelegate r5 = (coil.memory.RequestDelegate) r5
            java.lang.Object r9 = r3.L$3
            r12 = r9
            coil.memory.TargetDelegate r12 = (coil.memory.TargetDelegate) r12
            java.lang.Object r9 = r3.L$2
            coil.EventListener r9 = (coil.EventListener) r9
            java.lang.Object r10 = r3.L$1
            r14 = r10
            coil.request.ImageRequest r14 = (coil.request.ImageRequest) r14
            java.lang.Object r10 = r3.L$0
            r15 = r10
            coil.RealImageLoader r15 = (coil.RealImageLoader) r15
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0130 }
            goto L_0x01b0
        L_0x0130:
            r0 = move-exception
            goto L_0x0435
        L_0x0133:
            kotlin.ResultKt.throwOnFailure(r2)
            java.util.concurrent.atomic.AtomicBoolean r2 = r1.isShutdown
            boolean r2 = r2.get()
            r5 = 1
            r2 = r2 ^ r5
            if (r2 == 0) goto L_0x04bd
            r2 = r26
            r9 = 0
            coil.request.ImageRequest$Builder r2 = coil.request.ImageRequest.newBuilder$default(r2, r9, r5, r9)
            coil.request.DefaultRequestOptions r9 = r25.getDefaults()
            coil.request.ImageRequest$Builder r2 = r2.defaults(r9)
            coil.request.ImageRequest r14 = r2.build()
            coil.EventListener$Factory r2 = r1.eventListenerFactory
            coil.EventListener r9 = r2.create(r14)
            coil.memory.DelegateService r2 = r1.delegateService
            coil.target.Target r10 = r14.getTarget()
            coil.memory.TargetDelegate r12 = r2.createTargetDelegate(r10, r0, r9)
            coil.memory.DelegateService r2 = r1.delegateService
            kotlin.coroutines.CoroutineContext r10 = r3.getContext()
            kotlinx.coroutines.Job$Key r11 = kotlinx.coroutines.Job.Key
            kotlin.coroutines.CoroutineContext$Key r11 = (kotlin.coroutines.CoroutineContext.Key) r11
            kotlin.coroutines.CoroutineContext$Element r10 = r10.get(r11)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            kotlinx.coroutines.Job r10 = (kotlinx.coroutines.Job) r10
            coil.memory.RequestDelegate r2 = r2.createRequestDelegate(r14, r12, r10)
            java.lang.Object r10 = r14.getData()     // Catch:{ all -> 0x0431 }
            coil.request.NullRequestData r11 = coil.request.NullRequestData.INSTANCE     // Catch:{ all -> 0x0431 }
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)     // Catch:{ all -> 0x0431 }
            if (r10 != 0) goto L_0x0429
            if (r0 != 0) goto L_0x01b6
            androidx.lifecycle.Lifecycle r10 = r14.getLifecycle()     // Catch:{ all -> 0x01b2 }
            androidx.lifecycle.Lifecycle$State r11 = r10.getCurrentState()     // Catch:{ all -> 0x01b2 }
            androidx.lifecycle.Lifecycle$State r13 = androidx.lifecycle.Lifecycle.State.STARTED     // Catch:{ all -> 0x01b2 }
            boolean r11 = r11.isAtLeast(r13)     // Catch:{ all -> 0x01b2 }
            if (r11 == 0) goto L_0x0199
            goto L_0x01b6
        L_0x0199:
            r3.L$0 = r1     // Catch:{ all -> 0x01b2 }
            r3.L$1 = r14     // Catch:{ all -> 0x01b2 }
            r3.L$2 = r9     // Catch:{ all -> 0x01b2 }
            r3.L$3 = r12     // Catch:{ all -> 0x01b2 }
            r3.L$4 = r2     // Catch:{ all -> 0x01b2 }
            r3.I$0 = r0     // Catch:{ all -> 0x01b2 }
            r3.label = r5     // Catch:{ all -> 0x01b2 }
            java.lang.Object r5 = coil.util.Lifecycles.observeStarted(r10, r3)     // Catch:{ all -> 0x01b2 }
            if (r5 != r4) goto L_0x01ae
            return r4
        L_0x01ae:
            r15 = r1
            r5 = r2
        L_0x01b0:
            r2 = r5
            goto L_0x01b7
        L_0x01b2:
            r0 = move-exception
            r15 = r1
            goto L_0x0434
        L_0x01b6:
            r15 = r1
        L_0x01b7:
            coil.memory.MemoryCacheService r5 = r15.memoryCacheService     // Catch:{ all -> 0x0427 }
            coil.memory.MemoryCache$Key r10 = r14.getPlaceholderMemoryCacheKey()     // Catch:{ all -> 0x0427 }
            coil.memory.RealMemoryCache$Value r5 = r5.get(r10)     // Catch:{ all -> 0x0427 }
            if (r5 == 0) goto L_0x01c8
            android.graphics.Bitmap r5 = r5.getBitmap()     // Catch:{ all -> 0x0427 }
            goto L_0x01c9
        L_0x01c8:
            r5 = 0
        L_0x01c9:
            r10 = 0
            r11 = r10
            coil.request.ImageResult$Metadata r11 = (coil.request.ImageResult.Metadata) r11     // Catch:{ all -> 0x041e }
            coil.util.Extensions.setMetadata(r12, r11)     // Catch:{ all -> 0x041e }
            if (r5 == 0) goto L_0x01e7
            android.content.Context r10 = r14.getContext()     // Catch:{ all -> 0x041e }
            android.content.res.Resources r10 = r10.getResources()     // Catch:{ all -> 0x041e }
            java.lang.String r11 = "context.resources"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)     // Catch:{ all -> 0x041e }
            android.graphics.drawable.BitmapDrawable r11 = new android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x041e }
            r11.<init>(r10, r5)     // Catch:{ all -> 0x041e }
            android.graphics.drawable.Drawable r11 = (android.graphics.drawable.Drawable) r11     // Catch:{ all -> 0x041e }
            goto L_0x01eb
        L_0x01e7:
            android.graphics.drawable.Drawable r11 = r14.getPlaceholder()     // Catch:{ all -> 0x041e }
        L_0x01eb:
            r12.start(r11, r5)     // Catch:{ all -> 0x041e }
            r9.onStart(r14)     // Catch:{ all -> 0x041e }
            coil.request.ImageRequest$Listener r10 = r14.getListener()     // Catch:{ all -> 0x041e }
            if (r10 == 0) goto L_0x01fc
            r10.onStart(r14)     // Catch:{ all -> 0x041e }
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x041e }
        L_0x01fc:
            coil.bitmap.BitmapReferenceCounter r10 = r15.referenceCounter     // Catch:{ all -> 0x0427 }
            if (r5 == 0) goto L_0x0203
            r10.decrement(r5)     // Catch:{ all -> 0x0427 }
        L_0x0203:
            r9.resolveSizeStart(r14)     // Catch:{ all -> 0x0427 }
            coil.size.SizeResolver r10 = r14.getSizeResolver()     // Catch:{ all -> 0x0427 }
            r3.L$0 = r15     // Catch:{ all -> 0x0427 }
            r3.L$1 = r14     // Catch:{ all -> 0x0427 }
            r3.L$2 = r9     // Catch:{ all -> 0x0427 }
            r3.L$3 = r12     // Catch:{ all -> 0x0427 }
            r3.L$4 = r2     // Catch:{ all -> 0x0427 }
            r3.L$5 = r5     // Catch:{ all -> 0x0427 }
            r3.I$0 = r0     // Catch:{ all -> 0x0427 }
            r11 = 2
            r3.label = r11     // Catch:{ all -> 0x0427 }
            java.lang.Object r10 = r10.size(r3)     // Catch:{ all -> 0x0427 }
            if (r10 != r4) goto L_0x0222
            return r4
        L_0x0222:
            r18 = r0
            r23 = r5
            r5 = r2
            r2 = r10
        L_0x0228:
            r0 = r2
            coil.size.Size r0 = (coil.size.Size) r0     // Catch:{ all -> 0x0130 }
            r9.resolveSizeEnd(r14, r0)     // Catch:{ all -> 0x0130 }
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ all -> 0x0130 }
            r2.<init>()     // Catch:{ all -> 0x0130 }
            coil.intercept.RealInterceptorChain r10 = new coil.intercept.RealInterceptorChain     // Catch:{ all -> 0x0130 }
            java.util.List r19 = r15.interceptors     // Catch:{ all -> 0x0130 }
            r20 = 0
            r16 = r10
            r17 = r14
            r21 = r14
            r22 = r0
            r24 = r9
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ all -> 0x0130 }
            r2.element = r10     // Catch:{ all -> 0x0130 }
            boolean r0 = r15.launchInterceptorChainOnMainThread     // Catch:{ all -> 0x0130 }
            if (r0 == 0) goto L_0x0271
            T r0 = r2.element     // Catch:{ all -> 0x0130 }
            coil.intercept.RealInterceptorChain r0 = (coil.intercept.RealInterceptorChain) r0     // Catch:{ all -> 0x0130 }
            r3.L$0 = r15     // Catch:{ all -> 0x0130 }
            r3.L$1 = r14     // Catch:{ all -> 0x0130 }
            r3.L$2 = r9     // Catch:{ all -> 0x0130 }
            r3.L$3 = r12     // Catch:{ all -> 0x0130 }
            r3.L$4 = r5     // Catch:{ all -> 0x0130 }
            r2 = 0
            r3.L$5 = r2     // Catch:{ all -> 0x0130 }
            r2 = 3
            r3.label = r2     // Catch:{ all -> 0x0130 }
            java.lang.Object r2 = r0.proceed(r14, r3)     // Catch:{ all -> 0x0130 }
            if (r2 != r4) goto L_0x026b
            return r4
        L_0x026b:
            coil.request.ImageResult r2 = (coil.request.ImageResult) r2     // Catch:{ all -> 0x0130 }
        L_0x026d:
            r11 = r5
            r13 = r9
            r5 = r2
            goto L_0x0299
        L_0x0271:
            kotlinx.coroutines.CoroutineDispatcher r0 = r14.getDispatcher()     // Catch:{ all -> 0x0130 }
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0     // Catch:{ all -> 0x0130 }
            coil.RealImageLoader$executeChain$2 r10 = new coil.RealImageLoader$executeChain$2     // Catch:{ all -> 0x0130 }
            r11 = 0
            r10.<init>(r2, r14, r11)     // Catch:{ all -> 0x0130 }
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10     // Catch:{ all -> 0x0130 }
            r3.L$0 = r15     // Catch:{ all -> 0x0130 }
            r3.L$1 = r14     // Catch:{ all -> 0x0130 }
            r3.L$2 = r9     // Catch:{ all -> 0x0130 }
            r3.L$3 = r12     // Catch:{ all -> 0x0130 }
            r3.L$4 = r5     // Catch:{ all -> 0x0130 }
            r2 = 0
            r3.L$5 = r2     // Catch:{ all -> 0x0130 }
            r2 = 4
            r3.label = r2     // Catch:{ all -> 0x0130 }
            java.lang.Object r2 = kotlinx.coroutines.BuildersKt.withContext(r0, r10, r3)     // Catch:{ all -> 0x0130 }
            if (r2 != r4) goto L_0x0296
            return r4
        L_0x0296:
            coil.request.ImageResult r2 = (coil.request.ImageResult) r2     // Catch:{ all -> 0x0130 }
            goto L_0x026d
        L_0x0299:
            boolean r0 = r5 instanceof coil.request.SuccessResult     // Catch:{ all -> 0x0072 }
            if (r0 == 0) goto L_0x038e
            r0 = r5
            coil.request.SuccessResult r0 = (coil.request.SuccessResult) r0     // Catch:{ all -> 0x035c }
            coil.request.ImageRequest r0 = r0.getRequest()     // Catch:{ all -> 0x035c }
            r2 = r5
            coil.request.SuccessResult r2 = (coil.request.SuccessResult) r2     // Catch:{ all -> 0x035c }
            coil.request.ImageResult$Metadata r2 = r2.getMetadata()     // Catch:{ all -> 0x035c }
            coil.decode.DataSource r9 = r2.getDataSource()     // Catch:{ all -> 0x035c }
            coil.util.Logger r10 = r15.getLogger()     // Catch:{ all -> 0x035c }
            if (r10 == 0) goto L_0x02ee
            int r1 = r10.getLevel()     // Catch:{ all -> 0x035c }
            r16 = r6
            r6 = 4
            if (r1 > r6) goto L_0x02eb
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x035a }
            r1.<init>()     // Catch:{ all -> 0x035a }
            java.lang.String r6 = coil.util.Extensions.getEmoji(r9)     // Catch:{ all -> 0x035a }
            r1.append(r6)     // Catch:{ all -> 0x035a }
            java.lang.String r6 = " Successful ("
            r1.append(r6)     // Catch:{ all -> 0x035a }
            java.lang.String r6 = r9.name()     // Catch:{ all -> 0x035a }
            r1.append(r6)     // Catch:{ all -> 0x035a }
            java.lang.String r6 = ") - "
            r1.append(r6)     // Catch:{ all -> 0x035a }
            java.lang.Object r6 = r0.getData()     // Catch:{ all -> 0x035a }
            r1.append(r6)     // Catch:{ all -> 0x035a }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x035a }
            r6 = 4
            r9 = 0
            r10.log(r8, r6, r1, r9)     // Catch:{ all -> 0x035a }
        L_0x02eb:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x035a }
            goto L_0x02f0
        L_0x02ee:
            r16 = r6
        L_0x02f0:
            coil.util.Extensions.setMetadata(r12, r2)     // Catch:{ all -> 0x035a }
            r1 = r5
            coil.request.SuccessResult r1 = (coil.request.SuccessResult) r1     // Catch:{ all -> 0x035a }
            r3.L$0 = r15     // Catch:{ all -> 0x035a }
            r3.L$1 = r14     // Catch:{ all -> 0x035a }
            r3.L$2 = r13     // Catch:{ all -> 0x035a }
            r3.L$3 = r12     // Catch:{ all -> 0x035a }
            r3.L$4 = r11     // Catch:{ all -> 0x035a }
            r3.L$5 = r5     // Catch:{ all -> 0x035a }
            r3.L$6 = r15     // Catch:{ all -> 0x035a }
            r3.L$7 = r0     // Catch:{ all -> 0x035a }
            r3.L$8 = r2     // Catch:{ all -> 0x035a }
            r6 = 5
            r3.label = r6     // Catch:{ all -> 0x035a }
            java.lang.Object r1 = r12.success(r1, r3)     // Catch:{ all -> 0x035a }
            if (r1 != r4) goto L_0x0312
            return r4
        L_0x0312:
            r9 = r14
            r10 = r15
            r14 = r12
            r12 = r5
            r15 = r13
            r5 = r0
            r0 = r2
            r13 = r11
            r11 = r10
        L_0x031b:
            r15.onSuccess(r5, r0)     // Catch:{ all -> 0x0357 }
            coil.request.ImageRequest$Listener r1 = r5.getListener()     // Catch:{ all -> 0x0357 }
            if (r1 == 0) goto L_0x0329
            r1.onSuccess(r5, r0)     // Catch:{ all -> 0x0357 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0357 }
        L_0x0329:
            coil.bitmap.BitmapReferenceCounter r0 = r11.referenceCounter     // Catch:{ all -> 0x034d }
            r1 = r12
            coil.request.SuccessResult r1 = (coil.request.SuccessResult) r1     // Catch:{ all -> 0x034d }
            android.graphics.drawable.Drawable r1 = r1.getDrawable()     // Catch:{ all -> 0x034d }
            if (r1 == 0) goto L_0x0349
            boolean r2 = r1 instanceof android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x034d }
            if (r2 == 0) goto L_0x0349
            android.graphics.drawable.BitmapDrawable r1 = (android.graphics.drawable.BitmapDrawable) r1     // Catch:{ all -> 0x034d }
            android.graphics.Bitmap r1 = r1.getBitmap()     // Catch:{ all -> 0x034d }
            if (r1 == 0) goto L_0x0349
            boolean r0 = r0.decrement(r1)     // Catch:{ all -> 0x034d }
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)     // Catch:{ all -> 0x034d }
        L_0x0349:
            r5 = r12
            r11 = r13
            goto L_0x0415
        L_0x034d:
            r0 = move-exception
            r5 = r13
            r12 = r14
            r6 = r16
            r14 = r9
            r9 = r15
            r15 = r10
            goto L_0x0435
        L_0x0357:
            r0 = move-exception
            goto L_0x00a5
        L_0x035a:
            r0 = move-exception
            goto L_0x035f
        L_0x035c:
            r0 = move-exception
            r16 = r6
        L_0x035f:
            r1 = r13
            r9 = r14
            r13 = r11
            r14 = r12
            r11 = r15
            r12 = r5
        L_0x0365:
            coil.bitmap.BitmapReferenceCounter r2 = r11.referenceCounter     // Catch:{ all -> 0x0385 }
            coil.request.SuccessResult r12 = (coil.request.SuccessResult) r12     // Catch:{ all -> 0x0385 }
            android.graphics.drawable.Drawable r5 = r12.getDrawable()     // Catch:{ all -> 0x0385 }
            if (r5 == 0) goto L_0x0384
            boolean r6 = r5 instanceof android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x0385 }
            if (r6 == 0) goto L_0x0384
            android.graphics.drawable.BitmapDrawable r5 = (android.graphics.drawable.BitmapDrawable) r5     // Catch:{ all -> 0x0385 }
            android.graphics.Bitmap r5 = r5.getBitmap()     // Catch:{ all -> 0x0385 }
            if (r5 == 0) goto L_0x0384
            boolean r2 = r2.decrement(r5)     // Catch:{ all -> 0x0385 }
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)     // Catch:{ all -> 0x0385 }
        L_0x0384:
            throw r0     // Catch:{ all -> 0x0385 }
        L_0x0385:
            r0 = move-exception
            r5 = r13
            r12 = r14
            r6 = r16
            r14 = r9
            r9 = r1
            goto L_0x0435
        L_0x038e:
            r16 = r6
            boolean r0 = r5 instanceof coil.request.ErrorResult     // Catch:{ all -> 0x0419 }
            if (r0 == 0) goto L_0x0415
            r0 = r5
            coil.request.ErrorResult r0 = (coil.request.ErrorResult) r0     // Catch:{ all -> 0x0419 }
            coil.request.ImageRequest r0 = r0.getRequest()     // Catch:{ all -> 0x0419 }
            coil.util.Logger r1 = r15.getLogger()     // Catch:{ all -> 0x0419 }
            if (r1 == 0) goto L_0x03d5
            int r2 = r1.getLevel()     // Catch:{ all -> 0x0419 }
            r6 = 4
            if (r2 > r6) goto L_0x03d0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0419 }
            r2.<init>()     // Catch:{ all -> 0x0419 }
            r2.append(r7)     // Catch:{ all -> 0x0419 }
            java.lang.Object r6 = r0.getData()     // Catch:{ all -> 0x0419 }
            r2.append(r6)     // Catch:{ all -> 0x0419 }
            r6 = r16
            r2.append(r6)     // Catch:{ all -> 0x0072 }
            r9 = r5
            coil.request.ErrorResult r9 = (coil.request.ErrorResult) r9     // Catch:{ all -> 0x0072 }
            java.lang.Throwable r9 = r9.getThrowable()     // Catch:{ all -> 0x0072 }
            r2.append(r9)     // Catch:{ all -> 0x0072 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0072 }
            r9 = 4
            r10 = 0
            r1.log(r8, r9, r2, r10)     // Catch:{ all -> 0x0072 }
            goto L_0x03d2
        L_0x03d0:
            r6 = r16
        L_0x03d2:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0072 }
            goto L_0x03d7
        L_0x03d5:
            r6 = r16
        L_0x03d7:
            r1 = 0
            r10 = r1
            coil.request.ImageResult$Metadata r10 = (coil.request.ImageResult.Metadata) r10     // Catch:{ all -> 0x0072 }
            coil.util.Extensions.setMetadata(r12, r10)     // Catch:{ all -> 0x0072 }
            r1 = r5
            coil.request.ErrorResult r1 = (coil.request.ErrorResult) r1     // Catch:{ all -> 0x0072 }
            r3.L$0 = r15     // Catch:{ all -> 0x0072 }
            r3.L$1 = r14     // Catch:{ all -> 0x0072 }
            r3.L$2 = r13     // Catch:{ all -> 0x0072 }
            r3.L$3 = r12     // Catch:{ all -> 0x0072 }
            r3.L$4 = r11     // Catch:{ all -> 0x0072 }
            r3.L$5 = r5     // Catch:{ all -> 0x0072 }
            r3.L$6 = r0     // Catch:{ all -> 0x0072 }
            r2 = 6
            r3.label = r2     // Catch:{ all -> 0x0072 }
            java.lang.Object r1 = r12.error(r1, r3)     // Catch:{ all -> 0x0072 }
            if (r1 != r4) goto L_0x03f9
            return r4
        L_0x03f9:
            r1 = r5
            coil.request.ErrorResult r1 = (coil.request.ErrorResult) r1     // Catch:{ all -> 0x0072 }
            java.lang.Throwable r1 = r1.getThrowable()     // Catch:{ all -> 0x0072 }
            r13.onError(r0, r1)     // Catch:{ all -> 0x0072 }
            coil.request.ImageRequest$Listener r1 = r0.getListener()     // Catch:{ all -> 0x0072 }
            if (r1 == 0) goto L_0x0415
            r2 = r5
            coil.request.ErrorResult r2 = (coil.request.ErrorResult) r2     // Catch:{ all -> 0x0072 }
            java.lang.Throwable r2 = r2.getThrowable()     // Catch:{ all -> 0x0072 }
            r1.onError(r0, r2)     // Catch:{ all -> 0x0072 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0072 }
        L_0x0415:
            r11.complete()
            return r5
        L_0x0419:
            r0 = move-exception
            r6 = r16
            goto L_0x0073
        L_0x041e:
            r0 = move-exception
            coil.bitmap.BitmapReferenceCounter r1 = r15.referenceCounter     // Catch:{ all -> 0x0427 }
            if (r5 == 0) goto L_0x0426
            r1.decrement(r5)     // Catch:{ all -> 0x0427 }
        L_0x0426:
            throw r0     // Catch:{ all -> 0x0427 }
        L_0x0427:
            r0 = move-exception
            goto L_0x0434
        L_0x0429:
            coil.request.NullRequestDataException r0 = new coil.request.NullRequestDataException     // Catch:{ all -> 0x0431 }
            r0.<init>()     // Catch:{ all -> 0x0431 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x0431 }
            throw r0     // Catch:{ all -> 0x0431 }
        L_0x0431:
            r0 = move-exception
            r15 = r25
        L_0x0434:
            r5 = r2
        L_0x0435:
            boolean r1 = r0 instanceof java.util.concurrent.CancellationException     // Catch:{ all -> 0x004e }
            if (r1 != 0) goto L_0x04b5
            coil.memory.RequestService r1 = r15.requestService     // Catch:{ all -> 0x004e }
            coil.request.ErrorResult r0 = r1.errorResult(r14, r0)     // Catch:{ all -> 0x004e }
            coil.request.ImageRequest r1 = r0.getRequest()     // Catch:{ all -> 0x004e }
            coil.util.Logger r2 = r15.getLogger()     // Catch:{ all -> 0x004e }
            if (r2 == 0) goto L_0x0474
            int r10 = r2.getLevel()     // Catch:{ all -> 0x004e }
            r11 = 4
            if (r10 > r11) goto L_0x0472
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x004e }
            r10.<init>()     // Catch:{ all -> 0x004e }
            r10.append(r7)     // Catch:{ all -> 0x004e }
            java.lang.Object r7 = r1.getData()     // Catch:{ all -> 0x004e }
            r10.append(r7)     // Catch:{ all -> 0x004e }
            r10.append(r6)     // Catch:{ all -> 0x004e }
            java.lang.Throwable r6 = r0.getThrowable()     // Catch:{ all -> 0x004e }
            r10.append(r6)     // Catch:{ all -> 0x004e }
            java.lang.String r6 = r10.toString()     // Catch:{ all -> 0x004e }
            r7 = 4
            r10 = 0
            r2.log(r8, r7, r6, r10)     // Catch:{ all -> 0x004e }
        L_0x0472:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004e }
        L_0x0474:
            r2 = 0
            r10 = r2
            coil.request.ImageResult$Metadata r10 = (coil.request.ImageResult.Metadata) r10     // Catch:{ all -> 0x004e }
            coil.util.Extensions.setMetadata(r12, r10)     // Catch:{ all -> 0x004e }
            r3.L$0 = r9     // Catch:{ all -> 0x004e }
            r3.L$1 = r5     // Catch:{ all -> 0x004e }
            r3.L$2 = r0     // Catch:{ all -> 0x004e }
            r3.L$3 = r1     // Catch:{ all -> 0x004e }
            r2 = 0
            r3.L$4 = r2     // Catch:{ all -> 0x004e }
            r3.L$5 = r2     // Catch:{ all -> 0x004e }
            r3.L$6 = r2     // Catch:{ all -> 0x004e }
            r3.L$7 = r2     // Catch:{ all -> 0x004e }
            r3.L$8 = r2     // Catch:{ all -> 0x004e }
            r2 = 7
            r3.label = r2     // Catch:{ all -> 0x004e }
            java.lang.Object r2 = r12.error(r0, r3)     // Catch:{ all -> 0x004e }
            if (r2 != r4) goto L_0x0498
            return r4
        L_0x0498:
            r4 = r0
            r0 = r1
            r3 = r9
        L_0x049b:
            java.lang.Throwable r1 = r4.getThrowable()     // Catch:{ all -> 0x004e }
            r3.onError(r0, r1)     // Catch:{ all -> 0x004e }
            coil.request.ImageRequest$Listener r1 = r0.getListener()     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x04b1
            java.lang.Throwable r2 = r4.getThrowable()     // Catch:{ all -> 0x004e }
            r1.onError(r0, r2)     // Catch:{ all -> 0x004e }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004e }
        L_0x04b1:
            r5.complete()
            return r4
        L_0x04b5:
            r15.onCancel(r14, r9)     // Catch:{ all -> 0x004e }
            throw r0     // Catch:{ all -> 0x004e }
        L_0x04b9:
            r5.complete()
            throw r0
        L_0x04bd:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "The image loader is shutdown."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.RealImageLoader.executeMain(coil.request.ImageRequest, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void onTrimMemory(int i) {
        this.strongMemoryCache.trimMemory(i);
        this.weakMemoryCache.trimMemory(i);
        getBitmapPool().trimMemory(i);
    }

    public void shutdown() {
        if (!this.isShutdown.getAndSet(true)) {
            CoroutineScopeKt.cancel$default(this.scope, (CancellationException) null, 1, (Object) null);
            this.systemCallbacks.shutdown();
            this.strongMemoryCache.clearMemory();
            this.weakMemoryCache.clearMemory();
            getBitmapPool().clear();
        }
    }

    private final /* synthetic */ Object executeChain(ImageRequest imageRequest, int i, Size size, Bitmap bitmap, EventListener eventListener, Continuation<? super ImageResult> continuation) {
        ImageRequest imageRequest2 = imageRequest;
        Continuation<? super ImageResult> continuation2 = continuation;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new RealInterceptorChain(imageRequest, i, this.interceptors, 0, imageRequest, size, bitmap, eventListener);
        if (this.launchInterceptorChainOnMainThread) {
            InlineMarker.mark(0);
            Object proceed = ((RealInterceptorChain) objectRef.element).proceed(imageRequest, continuation2);
            InlineMarker.mark(1);
            return (ImageResult) proceed;
        }
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(imageRequest.getDispatcher(), new RealImageLoader$executeChain$2(objectRef, imageRequest, (Continuation) null), continuation2);
        InlineMarker.mark(1);
        return (ImageResult) withContext;
    }

    /* JADX INFO: finally extract failed */
    private final /* synthetic */ Object onSuccess(SuccessResult successResult, TargetDelegate targetDelegate, EventListener eventListener, Continuation<? super Unit> continuation) {
        Bitmap bitmap;
        Bitmap bitmap2;
        try {
            ImageRequest request = successResult.getRequest();
            ImageResult.Metadata metadata = successResult.getMetadata();
            DataSource dataSource = metadata.getDataSource();
            Logger logger2 = getLogger();
            if (logger2 != null && logger2.getLevel() <= 4) {
                logger2.log(TAG, 4, Extensions.getEmoji(dataSource) + " Successful (" + dataSource.name() + ") - " + request.getData(), (Throwable) null);
            }
            Extensions.setMetadata(targetDelegate, metadata);
            InlineMarker.mark(0);
            targetDelegate.success(successResult, continuation);
            InlineMarker.mark(2);
            InlineMarker.mark(1);
            eventListener.onSuccess(request, metadata);
            ImageRequest.Listener listener = request.getListener();
            if (listener != null) {
                listener.onSuccess(request, metadata);
            }
            InlineMarker.finallyStart(1);
            BitmapReferenceCounter access$getReferenceCounter$p = this.referenceCounter;
            Drawable drawable = successResult.getDrawable();
            if (!(drawable == null || !(drawable instanceof BitmapDrawable) || (bitmap2 = ((BitmapDrawable) drawable).getBitmap()) == null)) {
                access$getReferenceCounter$p.decrement(bitmap2);
            }
            InlineMarker.finallyEnd(1);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            BitmapReferenceCounter access$getReferenceCounter$p2 = this.referenceCounter;
            Drawable drawable2 = successResult.getDrawable();
            if (!(drawable2 == null || !(drawable2 instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) drawable2).getBitmap()) == null)) {
                access$getReferenceCounter$p2.decrement(bitmap);
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    private final /* synthetic */ Object onError(ErrorResult errorResult, TargetDelegate targetDelegate, EventListener eventListener, Continuation<? super Unit> continuation) {
        ImageRequest request = errorResult.getRequest();
        Logger logger2 = getLogger();
        if (logger2 != null && logger2.getLevel() <= 4) {
            logger2.log(TAG, 4, "🚨 Failed - " + request.getData() + " - " + errorResult.getThrowable(), (Throwable) null);
        }
        Extensions.setMetadata(targetDelegate, (ImageResult.Metadata) null);
        InlineMarker.mark(0);
        targetDelegate.error(errorResult, continuation);
        InlineMarker.mark(2);
        InlineMarker.mark(1);
        eventListener.onError(request, errorResult.getThrowable());
        ImageRequest.Listener listener = request.getListener();
        if (listener != null) {
            listener.onError(request, errorResult.getThrowable());
        }
        return Unit.INSTANCE;
    }

    private final void onCancel(ImageRequest imageRequest, EventListener eventListener) {
        Logger logger2 = this.logger;
        if (logger2 != null && logger2.getLevel() <= 4) {
            logger2.log(TAG, 4, "🏗  Cancelled - " + imageRequest.getData(), (Throwable) null);
        }
        eventListener.onCancel(imageRequest);
        ImageRequest.Listener listener = imageRequest.getListener();
        if (listener != null) {
            listener.onCancel(imageRequest);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcoil/RealImageLoader$Companion;", "", "()V", "TAG", "", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: RealImageLoader.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
