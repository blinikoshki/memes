package coil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import coil.ComponentRegistry;
import coil.EventListener;
import coil.bitmap.BitmapPool;
import coil.bitmap.BitmapPoolStrategy;
import coil.bitmap.BitmapReferenceCounter;
import coil.bitmap.EmptyBitmapReferenceCounter;
import coil.bitmap.RealBitmapPool;
import coil.bitmap.RealBitmapReferenceCounter;
import coil.memory.EmptyWeakMemoryCache;
import coil.memory.MemoryCache;
import coil.memory.RealWeakMemoryCache;
import coil.memory.StrongMemoryCache;
import coil.memory.WeakMemoryCache;
import coil.request.CachePolicy;
import coil.request.DefaultRequestOptions;
import coil.request.Disposable;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.size.Precision;
import coil.transition.CrossfadeTransition;
import coil.transition.Transition;
import coil.util.Contexts;
import coil.util.Extensions;
import coil.util.Logger;
import coil.util.Utils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import okhttp3.Call;
import okhttp3.OkHttpClient;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00182\u00020\u0001:\u0002\u0017\u0018J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0016H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, mo26107d2 = {"Lcoil/ImageLoader;", "", "bitmapPool", "Lcoil/bitmap/BitmapPool;", "getBitmapPool", "()Lcoil/bitmap/BitmapPool;", "defaults", "Lcoil/request/DefaultRequestOptions;", "getDefaults", "()Lcoil/request/DefaultRequestOptions;", "memoryCache", "Lcoil/memory/MemoryCache;", "getMemoryCache", "()Lcoil/memory/MemoryCache;", "enqueue", "Lcoil/request/Disposable;", "request", "Lcoil/request/ImageRequest;", "execute", "Lcoil/request/ImageResult;", "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shutdown", "", "Builder", "Companion", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: ImageLoader.kt */
public interface ImageLoader {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* renamed from: coil.ImageLoader$-CC  reason: invalid class name */
    /* compiled from: ImageLoader.kt */
    public final /* synthetic */ class CC {
        @JvmStatic
        public static ImageLoader create(Context context) {
            return ImageLoader.Companion.create(context);
        }
    }

    Disposable enqueue(ImageRequest imageRequest);

    Object execute(ImageRequest imageRequest, Continuation<? super ImageResult> continuation);

    BitmapPool getBitmapPool();

    DefaultRequestOptions getDefaults();

    MemoryCache getMemoryCache();

    void shutdown();

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\u00002\b\b\u0001\u0010\u001c\u001a\u00020\nJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u000b\u001a\u00020\u00002\b\b\u0001\u0010\u001c\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0006J\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\u000eH\u0002J\u0014\u0010\r\u001a\u00020\u00002\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0#J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010$\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J%\u0010$\u001a\u00020\u00002\u0017\u0010%\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0&¢\u0006\u0002\b)H\bø\u0001\u0000J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020\u00002\u0006\u00100\u001a\u000201J\u0010\u00102\u001a\u00020\u00002\b\u00103\u001a\u0004\u0018\u000104J\u0010\u00102\u001a\u00020\u00002\b\b\u0001\u00105\u001a\u00020,J\u000e\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u000208J\u000e\u00106\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0012J\u0010\u0010:\u001a\u00020\u00002\b\u00103\u001a\u0004\u0018\u000104J\u0010\u0010:\u001a\u00020\u00002\b\b\u0001\u00105\u001a\u00020,J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0006J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u000e\u0010;\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/J\u0014\u0010=\u001a\u00020\u00002\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020>0#J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>J\u0010\u0010?\u001a\u00020\u00002\b\u00103\u001a\u0004\u0018\u000104J\u0010\u0010?\u001a\u00020\u00002\b\b\u0001\u00105\u001a\u00020,J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010@\u001a\u00020AJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0006J\u0010\u0010B\u001a\u00020\u00002\u0006\u0010B\u001a\u00020CH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006D"}, mo26107d2 = {"Lcoil/ImageLoader$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "addLastModifiedToFileCacheKey", "", "applicationContext", "kotlin.jvm.PlatformType", "availableMemoryPercentage", "", "bitmapPoolPercentage", "bitmapPoolingEnabled", "callFactory", "Lokhttp3/Call$Factory;", "defaults", "Lcoil/request/DefaultRequestOptions;", "eventListenerFactory", "Lcoil/EventListener$Factory;", "launchInterceptorChainOnMainThread", "logger", "Lcoil/util/Logger;", "registry", "Lcoil/ComponentRegistry;", "trackWeakReferences", "enable", "allowHardware", "allowRgb565", "percent", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "build", "Lcoil/ImageLoader;", "buildDefaultCallFactory", "initializer", "Lkotlin/Function0;", "componentRegistry", "builder", "Lkotlin/Function1;", "Lcoil/ComponentRegistry$Builder;", "", "Lkotlin/ExtensionFunctionType;", "crossfade", "durationMillis", "", "diskCachePolicy", "policy", "Lcoil/request/CachePolicy;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "error", "drawable", "Landroid/graphics/drawable/Drawable;", "drawableResId", "eventListener", "listener", "Lcoil/EventListener;", "factory", "fallback", "memoryCachePolicy", "networkCachePolicy", "okHttpClient", "Lokhttp3/OkHttpClient;", "placeholder", "precision", "Lcoil/size/Precision;", "transition", "Lcoil/transition/Transition;", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: ImageLoader.kt */
    public static final class Builder {
        private boolean addLastModifiedToFileCacheKey;
        /* access modifiers changed from: private */
        public final Context applicationContext;
        private double availableMemoryPercentage;
        private double bitmapPoolPercentage;
        private boolean bitmapPoolingEnabled;
        private Call.Factory callFactory;
        private DefaultRequestOptions defaults = DefaultRequestOptions.INSTANCE;
        private EventListener.Factory eventListenerFactory;
        private boolean launchInterceptorChainOnMainThread;
        private Logger logger;
        private ComponentRegistry registry;
        private boolean trackWeakReferences;

        public Builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Context applicationContext2 = context.getApplicationContext();
            this.applicationContext = applicationContext2;
            Utils utils = Utils.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "applicationContext");
            this.availableMemoryPercentage = utils.getDefaultAvailableMemoryPercentage(applicationContext2);
            this.bitmapPoolPercentage = Utils.INSTANCE.getDefaultBitmapPoolPercentage();
            this.addLastModifiedToFileCacheKey = true;
            this.bitmapPoolingEnabled = true;
            this.launchInterceptorChainOnMainThread = true;
            this.trackWeakReferences = true;
        }

        public final Builder okHttpClient(OkHttpClient okHttpClient) {
            Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
            return callFactory((Call.Factory) okHttpClient);
        }

        public final Builder okHttpClient(Function0<? extends OkHttpClient> function0) {
            Intrinsics.checkNotNullParameter(function0, "initializer");
            return callFactory((Function0<? extends Call.Factory>) function0);
        }

        public final Builder callFactory(Call.Factory factory) {
            Intrinsics.checkNotNullParameter(factory, "callFactory");
            Builder builder = this;
            builder.callFactory = factory;
            return builder;
        }

        public final Builder callFactory(Function0<? extends Call.Factory> function0) {
            Intrinsics.checkNotNullParameter(function0, "initializer");
            Builder builder = this;
            builder.callFactory = Extensions.lazyCallFactory(function0);
            return builder;
        }

        public final /* synthetic */ Builder componentRegistry(Function1<? super ComponentRegistry.Builder, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "builder");
            ComponentRegistry.Builder builder = new ComponentRegistry.Builder();
            function1.invoke(builder);
            return componentRegistry(builder.build());
        }

        public final Builder componentRegistry(ComponentRegistry componentRegistry) {
            Intrinsics.checkNotNullParameter(componentRegistry, "registry");
            Builder builder = this;
            builder.registry = componentRegistry;
            return builder;
        }

        public final Builder availableMemoryPercentage(double d) {
            Builder builder = this;
            if (d >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d <= 1.0d) {
                builder.availableMemoryPercentage = d;
                return builder;
            }
            throw new IllegalArgumentException("Percent must be in the range [0.0, 1.0].".toString());
        }

        public final Builder bitmapPoolPercentage(double d) {
            Builder builder = this;
            if (d >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d <= 1.0d) {
                builder.bitmapPoolPercentage = d;
                return builder;
            }
            throw new IllegalArgumentException("Percent must be in the range [0.0, 1.0].".toString());
        }

        public final Builder dispatcher(CoroutineDispatcher coroutineDispatcher) {
            CoroutineDispatcher coroutineDispatcher2 = coroutineDispatcher;
            Intrinsics.checkNotNullParameter(coroutineDispatcher2, "dispatcher");
            Builder builder = this;
            builder.defaults = DefaultRequestOptions.copy$default(builder.defaults, coroutineDispatcher2, (Transition) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 4094, (Object) null);
            return builder;
        }

        public final Builder allowHardware(boolean z) {
            Builder builder = this;
            builder.defaults = DefaultRequestOptions.copy$default(builder.defaults, (CoroutineDispatcher) null, (Transition) null, (Precision) null, (Bitmap.Config) null, z, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 4079, (Object) null);
            return builder;
        }

        public final Builder allowRgb565(boolean z) {
            Builder builder = this;
            builder.defaults = DefaultRequestOptions.copy$default(builder.defaults, (CoroutineDispatcher) null, (Transition) null, (Precision) null, (Bitmap.Config) null, false, z, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 4063, (Object) null);
            return builder;
        }

        public final Builder addLastModifiedToFileCacheKey(boolean z) {
            Builder builder = this;
            builder.addLastModifiedToFileCacheKey = z;
            return builder;
        }

        public final Builder bitmapPoolingEnabled(boolean z) {
            Builder builder = this;
            builder.bitmapPoolingEnabled = z;
            return builder;
        }

        public final Builder launchInterceptorChainOnMainThread(boolean z) {
            Builder builder = this;
            builder.launchInterceptorChainOnMainThread = z;
            return builder;
        }

        public final Builder trackWeakReferences(boolean z) {
            Builder builder = this;
            builder.trackWeakReferences = z;
            return builder;
        }

        public final Builder eventListener(EventListener eventListener) {
            Intrinsics.checkNotNullParameter(eventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            return eventListener(EventListener.Factory.Companion.create(eventListener));
        }

        public final Builder eventListener(EventListener.Factory factory) {
            Intrinsics.checkNotNullParameter(factory, "factory");
            Builder builder = this;
            builder.eventListenerFactory = factory;
            return builder;
        }

        public final Builder crossfade(boolean z) {
            return crossfade(z ? 100 : 0);
        }

        public final Builder crossfade(int i) {
            return transition(i > 0 ? new CrossfadeTransition(i, false, 2, (DefaultConstructorMarker) null) : Transition.NONE);
        }

        public final Builder transition(Transition transition) {
            Transition transition2 = transition;
            Intrinsics.checkNotNullParameter(transition2, "transition");
            Builder builder = this;
            builder.defaults = DefaultRequestOptions.copy$default(builder.defaults, (CoroutineDispatcher) null, transition2, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 4093, (Object) null);
            return builder;
        }

        public final Builder precision(Precision precision) {
            Precision precision2 = precision;
            Intrinsics.checkNotNullParameter(precision2, "precision");
            Builder builder = this;
            builder.defaults = DefaultRequestOptions.copy$default(builder.defaults, (CoroutineDispatcher) null, (Transition) null, precision2, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 4091, (Object) null);
            return builder;
        }

        public final Builder bitmapConfig(Bitmap.Config config) {
            Bitmap.Config config2 = config;
            Intrinsics.checkNotNullParameter(config2, "bitmapConfig");
            Builder builder = this;
            builder.defaults = DefaultRequestOptions.copy$default(builder.defaults, (CoroutineDispatcher) null, (Transition) null, (Precision) null, config2, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 4087, (Object) null);
            return builder;
        }

        public final Builder placeholder(int i) {
            Builder builder = this;
            DefaultRequestOptions defaultRequestOptions = builder.defaults;
            Context context = builder.applicationContext;
            Intrinsics.checkNotNullExpressionValue(context, "applicationContext");
            builder.defaults = DefaultRequestOptions.copy$default(defaultRequestOptions, (CoroutineDispatcher) null, (Transition) null, (Precision) null, (Bitmap.Config) null, false, false, Contexts.getDrawableCompat(context, i), (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 4031, (Object) null);
            return builder;
        }

        public final Builder placeholder(Drawable drawable) {
            Builder builder = this;
            builder.defaults = DefaultRequestOptions.copy$default(builder.defaults, (CoroutineDispatcher) null, (Transition) null, (Precision) null, (Bitmap.Config) null, false, false, drawable, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 4031, (Object) null);
            return builder;
        }

        public final Builder error(int i) {
            Builder builder = this;
            DefaultRequestOptions defaultRequestOptions = builder.defaults;
            Context context = builder.applicationContext;
            Intrinsics.checkNotNullExpressionValue(context, "applicationContext");
            builder.defaults = DefaultRequestOptions.copy$default(defaultRequestOptions, (CoroutineDispatcher) null, (Transition) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, Contexts.getDrawableCompat(context, i), (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 3967, (Object) null);
            return builder;
        }

        public final Builder error(Drawable drawable) {
            Builder builder = this;
            builder.defaults = DefaultRequestOptions.copy$default(builder.defaults, (CoroutineDispatcher) null, (Transition) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, drawable, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 3967, (Object) null);
            return builder;
        }

        public final Builder fallback(int i) {
            Builder builder = this;
            DefaultRequestOptions defaultRequestOptions = builder.defaults;
            Context context = builder.applicationContext;
            Intrinsics.checkNotNullExpressionValue(context, "applicationContext");
            builder.defaults = DefaultRequestOptions.copy$default(defaultRequestOptions, (CoroutineDispatcher) null, (Transition) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, Contexts.getDrawableCompat(context, i), (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 3967, (Object) null);
            return builder;
        }

        public final Builder fallback(Drawable drawable) {
            Builder builder = this;
            builder.defaults = DefaultRequestOptions.copy$default(builder.defaults, (CoroutineDispatcher) null, (Transition) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, drawable, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 3967, (Object) null);
            return builder;
        }

        public final Builder memoryCachePolicy(CachePolicy cachePolicy) {
            CachePolicy cachePolicy2 = cachePolicy;
            Intrinsics.checkNotNullParameter(cachePolicy2, "policy");
            Builder builder = this;
            builder.defaults = DefaultRequestOptions.copy$default(builder.defaults, (CoroutineDispatcher) null, (Transition) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, cachePolicy2, (CachePolicy) null, (CachePolicy) null, 3583, (Object) null);
            return builder;
        }

        public final Builder diskCachePolicy(CachePolicy cachePolicy) {
            CachePolicy cachePolicy2 = cachePolicy;
            Intrinsics.checkNotNullParameter(cachePolicy2, "policy");
            Builder builder = this;
            builder.defaults = DefaultRequestOptions.copy$default(builder.defaults, (CoroutineDispatcher) null, (Transition) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, cachePolicy2, (CachePolicy) null, 3071, (Object) null);
            return builder;
        }

        public final Builder networkCachePolicy(CachePolicy cachePolicy) {
            CachePolicy cachePolicy2 = cachePolicy;
            Intrinsics.checkNotNullParameter(cachePolicy2, "policy");
            Builder builder = this;
            builder.defaults = DefaultRequestOptions.copy$default(builder.defaults, (CoroutineDispatcher) null, (Transition) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, cachePolicy2, 2047, (Object) null);
            return builder;
        }

        public final Builder logger(Logger logger2) {
            Builder builder = this;
            builder.logger = logger2;
            return builder;
        }

        public final ImageLoader build() {
            WeakMemoryCache weakMemoryCache;
            BitmapReferenceCounter bitmapReferenceCounter;
            Utils utils = Utils.INSTANCE;
            Context context = this.applicationContext;
            Intrinsics.checkNotNullExpressionValue(context, "applicationContext");
            long calculateAvailableMemorySize = utils.calculateAvailableMemorySize(context, this.availableMemoryPercentage);
            int i = (int) ((this.bitmapPoolingEnabled ? this.bitmapPoolPercentage : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) * ((double) calculateAvailableMemorySize));
            int i2 = (int) (calculateAvailableMemorySize - ((long) i));
            RealBitmapPool realBitmapPool = new RealBitmapPool(i, (Set) null, (BitmapPoolStrategy) null, this.logger, 6, (DefaultConstructorMarker) null);
            if (this.trackWeakReferences) {
                weakMemoryCache = new RealWeakMemoryCache(this.logger);
            } else {
                weakMemoryCache = EmptyWeakMemoryCache.INSTANCE;
            }
            WeakMemoryCache weakMemoryCache2 = weakMemoryCache;
            if (this.bitmapPoolingEnabled) {
                bitmapReferenceCounter = new RealBitmapReferenceCounter(weakMemoryCache2, realBitmapPool, this.logger);
            } else {
                bitmapReferenceCounter = EmptyBitmapReferenceCounter.INSTANCE;
            }
            BitmapReferenceCounter bitmapReferenceCounter2 = bitmapReferenceCounter;
            StrongMemoryCache invoke = StrongMemoryCache.Companion.invoke(weakMemoryCache2, bitmapReferenceCounter2, i2, this.logger);
            Context context2 = this.applicationContext;
            Intrinsics.checkNotNullExpressionValue(context2, "applicationContext");
            DefaultRequestOptions defaultRequestOptions = this.defaults;
            BitmapPool bitmapPool = realBitmapPool;
            Call.Factory factory = this.callFactory;
            if (factory == null) {
                factory = buildDefaultCallFactory();
            }
            Call.Factory factory2 = factory;
            EventListener.Factory factory3 = this.eventListenerFactory;
            if (factory3 == null) {
                factory3 = EventListener.Factory.NONE;
            }
            EventListener.Factory factory4 = factory3;
            ComponentRegistry componentRegistry = this.registry;
            if (componentRegistry == null) {
                componentRegistry = new ComponentRegistry();
            }
            return new RealImageLoader(context2, defaultRequestOptions, bitmapPool, bitmapReferenceCounter2, invoke, weakMemoryCache2, factory2, factory4, componentRegistry, this.addLastModifiedToFileCacheKey, this.launchInterceptorChainOnMainThread, this.logger);
        }

        private final Call.Factory buildDefaultCallFactory() {
            return Extensions.lazyCallFactory(new ImageLoader$Builder$buildDefaultCallFactory$1(this));
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\u0007¨\u0006\b"}, mo26107d2 = {"Lcoil/ImageLoader$Companion;", "", "()V", "invoke", "Lcoil/ImageLoader;", "context", "Landroid/content/Context;", "create", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: ImageLoader.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @JvmStatic
        public final ImageLoader create(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Builder(context).build();
        }
    }
}
