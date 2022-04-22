package coil.request;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import coil.decode.Decoder;
import coil.fetch.Fetcher;
import coil.memory.MemoryCache;
import coil.request.ImageResult;
import coil.request.Parameters;
import coil.size.DisplaySizeResolver;
import coil.size.OriginalSize;
import coil.size.PixelSize;
import coil.size.Precision;
import coil.size.Scale;
import coil.size.Size;
import coil.size.SizeResolver;
import coil.size.ViewSizeResolver;
import coil.target.ImageViewTarget;
import coil.target.Target;
import coil.target.ViewTarget;
import coil.transform.Transformation;
import coil.transition.CrossfadeTransition;
import coil.transition.Transition;
import coil.util.Contexts;
import coil.util.Extensions;
import coil.util.Requests;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import okhttp3.Headers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002~BÃ\u0002\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u001c\u0010\u000e\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011\u0018\u00010\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u001e\u0012\u0006\u0010\u001f\u001a\u00020 \u0012\u0006\u0010!\u001a\u00020\"\u0012\u0006\u0010#\u001a\u00020$\u0012\u0006\u0010%\u001a\u00020&\u0012\u0006\u0010'\u001a\u00020(\u0012\u0006\u0010)\u001a\u00020*\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010,\u001a\u00020*\u0012\u0006\u0010-\u001a\u00020.\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u00100\u001a\u00020.\u0012\b\u00101\u001a\u0004\u0018\u000102\u0012\b\u00103\u001a\u0004\u0018\u000104\u0012\b\u00105\u001a\u0004\u0018\u000102\u0012\b\u00106\u001a\u0004\u0018\u000104\u0012\b\u00107\u001a\u0004\u0018\u000102\u0012\b\u00108\u001a\u0004\u0018\u000104\u0012\u0006\u00109\u001a\u00020:\u0012\u0006\u0010;\u001a\u00020<¢\u0006\u0002\u0010=J\u0013\u0010w\u001a\u00020*2\b\u0010x\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010y\u001a\u000202H\u0016J\u0012\u0010z\u001a\u00020{2\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007J\b\u0010|\u001a\u00020}H\u0016R\u0011\u0010)\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0011\u0010+\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\b@\u0010?R\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0011\u0010;\u001a\u00020<¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0011\u00109\u001a\u00020:¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0011\u0010/\u001a\u00020.¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0013\u0010S\u001a\u0004\u0018\u0001048F¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0010\u00106\u001a\u0004\u0018\u000104X\u0004¢\u0006\u0002\n\u0000R\u0012\u00105\u001a\u0004\u0018\u000102X\u0004¢\u0006\u0004\n\u0002\u0010VR\u0013\u0010W\u001a\u0004\u0018\u0001048F¢\u0006\u0006\u001a\u0004\bX\u0010UR\u0010\u00108\u001a\u0004\u0018\u000104X\u0004¢\u0006\u0002\n\u0000R\u0012\u00107\u001a\u0004\u0018\u000102X\u0004¢\u0006\u0004\n\u0002\u0010VR'\u0010\u000e\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b_\u0010`R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\ba\u0010bR\u0011\u0010-\u001a\u00020.¢\u0006\b\n\u0000\u001a\u0004\bc\u0010PR\u0011\u00100\u001a\u00020.¢\u0006\b\n\u0000\u001a\u0004\bd\u0010PR\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR\u0013\u0010g\u001a\u0004\u0018\u0001048F¢\u0006\u0006\u001a\u0004\bh\u0010UR\u0010\u00103\u001a\u0004\u0018\u000104X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bi\u0010bR\u0012\u00101\u001a\u0004\u0018\u000102X\u0004¢\u0006\u0004\n\u0002\u0010VR\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u0011\u0010,\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\bl\u0010?R\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\bm\u0010nR\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\bo\u0010pR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bq\u0010rR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\bs\u0010tR\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\bu\u0010v¨\u0006\u0001"}, mo26107d2 = {"Lcoil/request/ImageRequest;", "", "context", "Landroid/content/Context;", "data", "target", "Lcoil/target/Target;", "listener", "Lcoil/request/ImageRequest$Listener;", "memoryCacheKey", "Lcoil/memory/MemoryCache$Key;", "placeholderMemoryCacheKey", "colorSpace", "Landroid/graphics/ColorSpace;", "fetcher", "Lkotlin/Pair;", "Lcoil/fetch/Fetcher;", "Ljava/lang/Class;", "decoder", "Lcoil/decode/Decoder;", "transformations", "", "Lcoil/transform/Transformation;", "headers", "Lokhttp3/Headers;", "parameters", "Lcoil/request/Parameters;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "sizeResolver", "Lcoil/size/SizeResolver;", "scale", "Lcoil/size/Scale;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "transition", "Lcoil/transition/Transition;", "precision", "Lcoil/size/Precision;", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "allowHardware", "", "allowRgb565", "premultipliedAlpha", "memoryCachePolicy", "Lcoil/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "placeholderResId", "", "placeholderDrawable", "Landroid/graphics/drawable/Drawable;", "errorResId", "errorDrawable", "fallbackResId", "fallbackDrawable", "defined", "Lcoil/request/DefinedRequestOptions;", "defaults", "Lcoil/request/DefaultRequestOptions;", "(Landroid/content/Context;Ljava/lang/Object;Lcoil/target/Target;Lcoil/request/ImageRequest$Listener;Lcoil/memory/MemoryCache$Key;Lcoil/memory/MemoryCache$Key;Landroid/graphics/ColorSpace;Lkotlin/Pair;Lcoil/decode/Decoder;Ljava/util/List;Lokhttp3/Headers;Lcoil/request/Parameters;Landroidx/lifecycle/Lifecycle;Lcoil/size/SizeResolver;Lcoil/size/Scale;Lkotlinx/coroutines/CoroutineDispatcher;Lcoil/transition/Transition;Lcoil/size/Precision;Landroid/graphics/Bitmap$Config;ZZZLcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Lcoil/request/DefinedRequestOptions;Lcoil/request/DefaultRequestOptions;)V", "getAllowHardware", "()Z", "getAllowRgb565", "getBitmapConfig", "()Landroid/graphics/Bitmap$Config;", "getColorSpace", "()Landroid/graphics/ColorSpace;", "getContext", "()Landroid/content/Context;", "getData", "()Ljava/lang/Object;", "getDecoder", "()Lcoil/decode/Decoder;", "getDefaults", "()Lcoil/request/DefaultRequestOptions;", "getDefined", "()Lcoil/request/DefinedRequestOptions;", "getDiskCachePolicy", "()Lcoil/request/CachePolicy;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "error", "getError", "()Landroid/graphics/drawable/Drawable;", "Ljava/lang/Integer;", "fallback", "getFallback", "getFetcher", "()Lkotlin/Pair;", "getHeaders", "()Lokhttp3/Headers;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "getListener", "()Lcoil/request/ImageRequest$Listener;", "getMemoryCacheKey", "()Lcoil/memory/MemoryCache$Key;", "getMemoryCachePolicy", "getNetworkCachePolicy", "getParameters", "()Lcoil/request/Parameters;", "placeholder", "getPlaceholder", "getPlaceholderMemoryCacheKey", "getPrecision", "()Lcoil/size/Precision;", "getPremultipliedAlpha", "getScale", "()Lcoil/size/Scale;", "getSizeResolver", "()Lcoil/size/SizeResolver;", "getTarget", "()Lcoil/target/Target;", "getTransformations", "()Ljava/util/List;", "getTransition", "()Lcoil/transition/Transition;", "equals", "other", "hashCode", "newBuilder", "Lcoil/request/ImageRequest$Builder;", "toString", "", "Builder", "Listener", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: ImageRequest.kt */
public final class ImageRequest {
    private final boolean allowHardware;
    private final boolean allowRgb565;
    private final Bitmap.Config bitmapConfig;
    private final ColorSpace colorSpace;
    private final Context context;
    private final Object data;
    private final Decoder decoder;
    private final DefaultRequestOptions defaults;
    private final DefinedRequestOptions defined;
    private final CachePolicy diskCachePolicy;
    private final CoroutineDispatcher dispatcher;
    /* access modifiers changed from: private */
    public final Drawable errorDrawable;
    /* access modifiers changed from: private */
    public final Integer errorResId;
    /* access modifiers changed from: private */
    public final Drawable fallbackDrawable;
    /* access modifiers changed from: private */
    public final Integer fallbackResId;
    private final Pair<Fetcher<?>, Class<?>> fetcher;
    private final Headers headers;
    private final Lifecycle lifecycle;
    private final Listener listener;
    private final MemoryCache.Key memoryCacheKey;
    private final CachePolicy memoryCachePolicy;
    private final CachePolicy networkCachePolicy;
    private final Parameters parameters;
    /* access modifiers changed from: private */
    public final Drawable placeholderDrawable;
    private final MemoryCache.Key placeholderMemoryCacheKey;
    /* access modifiers changed from: private */
    public final Integer placeholderResId;
    private final Precision precision;
    private final boolean premultipliedAlpha;
    private final Scale scale;
    private final SizeResolver sizeResolver;
    private final Target target;
    private final List<Transformation> transformations;
    private final Transition transition;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0017J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0017¨\u0006\r"}, mo26107d2 = {"Lcoil/request/ImageRequest$Listener;", "", "onCancel", "", "request", "Lcoil/request/ImageRequest;", "onError", "throwable", "", "onStart", "onSuccess", "metadata", "Lcoil/request/ImageResult$Metadata;", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: ImageRequest.kt */
    public interface Listener {

        @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 1})
        /* compiled from: ImageRequest.kt */
        public static final class DefaultImpls {
            public static void onCancel(Listener listener, ImageRequest imageRequest) {
                Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            }

            public static void onError(Listener listener, ImageRequest imageRequest, Throwable th) {
                Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
                Intrinsics.checkNotNullParameter(th, "throwable");
            }

            public static void onStart(Listener listener, ImageRequest imageRequest) {
                Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            }

            public static void onSuccess(Listener listener, ImageRequest imageRequest, ImageResult.Metadata metadata) {
                Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
                Intrinsics.checkNotNullParameter(metadata, TtmlNode.TAG_METADATA);
            }
        }

        void onCancel(ImageRequest imageRequest);

        void onError(ImageRequest imageRequest, Throwable th);

        void onStart(ImageRequest imageRequest);

        void onSuccess(ImageRequest imageRequest, ImageResult.Metadata metadata);
    }

    public final Builder newBuilder() {
        return newBuilder$default(this, (Context) null, 1, (Object) null);
    }

    private ImageRequest(Context context2, Object obj, Target target2, Listener listener2, MemoryCache.Key key, MemoryCache.Key key2, ColorSpace colorSpace2, Pair<? extends Fetcher<?>, ? extends Class<?>> pair, Decoder decoder2, List<? extends Transformation> list, Headers headers2, Parameters parameters2, Lifecycle lifecycle2, SizeResolver sizeResolver2, Scale scale2, CoroutineDispatcher coroutineDispatcher, Transition transition2, Precision precision2, Bitmap.Config config, boolean z, boolean z2, boolean z3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Integer num, Drawable drawable, Integer num2, Drawable drawable2, Integer num3, Drawable drawable3, DefinedRequestOptions definedRequestOptions, DefaultRequestOptions defaultRequestOptions) {
        this.context = context2;
        this.data = obj;
        this.target = target2;
        this.listener = listener2;
        this.memoryCacheKey = key;
        this.placeholderMemoryCacheKey = key2;
        this.colorSpace = colorSpace2;
        this.fetcher = pair;
        this.decoder = decoder2;
        this.transformations = list;
        this.headers = headers2;
        this.parameters = parameters2;
        this.lifecycle = lifecycle2;
        this.sizeResolver = sizeResolver2;
        this.scale = scale2;
        this.dispatcher = coroutineDispatcher;
        this.transition = transition2;
        this.precision = precision2;
        this.bitmapConfig = config;
        this.allowHardware = z;
        this.allowRgb565 = z2;
        this.premultipliedAlpha = z3;
        this.memoryCachePolicy = cachePolicy;
        this.diskCachePolicy = cachePolicy2;
        this.networkCachePolicy = cachePolicy3;
        this.placeholderResId = num;
        this.placeholderDrawable = drawable;
        this.errorResId = num2;
        this.errorDrawable = drawable2;
        this.fallbackResId = num3;
        this.fallbackDrawable = drawable3;
        this.defined = definedRequestOptions;
        this.defaults = defaultRequestOptions;
    }

    public /* synthetic */ ImageRequest(Context context2, Object obj, Target target2, Listener listener2, MemoryCache.Key key, MemoryCache.Key key2, ColorSpace colorSpace2, Pair pair, Decoder decoder2, List list, Headers headers2, Parameters parameters2, Lifecycle lifecycle2, SizeResolver sizeResolver2, Scale scale2, CoroutineDispatcher coroutineDispatcher, Transition transition2, Precision precision2, Bitmap.Config config, boolean z, boolean z2, boolean z3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Integer num, Drawable drawable, Integer num2, Drawable drawable2, Integer num3, Drawable drawable3, DefinedRequestOptions definedRequestOptions, DefaultRequestOptions defaultRequestOptions, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, obj, target2, listener2, key, key2, colorSpace2, pair, decoder2, list, headers2, parameters2, lifecycle2, sizeResolver2, scale2, coroutineDispatcher, transition2, precision2, config, z, z2, z3, cachePolicy, cachePolicy2, cachePolicy3, num, drawable, num2, drawable2, num3, drawable3, definedRequestOptions, defaultRequestOptions);
    }

    public final Context getContext() {
        return this.context;
    }

    public final Object getData() {
        return this.data;
    }

    public final Target getTarget() {
        return this.target;
    }

    public final Listener getListener() {
        return this.listener;
    }

    public final MemoryCache.Key getMemoryCacheKey() {
        return this.memoryCacheKey;
    }

    public final MemoryCache.Key getPlaceholderMemoryCacheKey() {
        return this.placeholderMemoryCacheKey;
    }

    public final ColorSpace getColorSpace() {
        return this.colorSpace;
    }

    public final Pair<Fetcher<?>, Class<?>> getFetcher() {
        return this.fetcher;
    }

    public final Decoder getDecoder() {
        return this.decoder;
    }

    public final List<Transformation> getTransformations() {
        return this.transformations;
    }

    public final Headers getHeaders() {
        return this.headers;
    }

    public final Parameters getParameters() {
        return this.parameters;
    }

    public final Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    public final SizeResolver getSizeResolver() {
        return this.sizeResolver;
    }

    public final Scale getScale() {
        return this.scale;
    }

    public final CoroutineDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final Transition getTransition() {
        return this.transition;
    }

    public final Precision getPrecision() {
        return this.precision;
    }

    public final Bitmap.Config getBitmapConfig() {
        return this.bitmapConfig;
    }

    public final boolean getAllowHardware() {
        return this.allowHardware;
    }

    public final boolean getAllowRgb565() {
        return this.allowRgb565;
    }

    public final boolean getPremultipliedAlpha() {
        return this.premultipliedAlpha;
    }

    public final CachePolicy getMemoryCachePolicy() {
        return this.memoryCachePolicy;
    }

    public final CachePolicy getDiskCachePolicy() {
        return this.diskCachePolicy;
    }

    public final CachePolicy getNetworkCachePolicy() {
        return this.networkCachePolicy;
    }

    public final DefinedRequestOptions getDefined() {
        return this.defined;
    }

    public final DefaultRequestOptions getDefaults() {
        return this.defaults;
    }

    public final Drawable getPlaceholder() {
        return Requests.getDrawableCompat(this, this.placeholderDrawable, this.placeholderResId, this.defaults.getPlaceholder());
    }

    public final Drawable getError() {
        return Requests.getDrawableCompat(this, this.errorDrawable, this.errorResId, this.defaults.getError());
    }

    public final Drawable getFallback() {
        return Requests.getDrawableCompat(this, this.fallbackDrawable, this.fallbackResId, this.defaults.getFallback());
    }

    public static /* synthetic */ Builder newBuilder$default(ImageRequest imageRequest, Context context2, int i, Object obj) {
        if ((i & 1) != 0) {
            context2 = imageRequest.context;
        }
        return imageRequest.newBuilder(context2);
    }

    public final Builder newBuilder(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        return new Builder(this, context2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (!Intrinsics.areEqual((Object) this.context, (Object) imageRequest.context) || !Intrinsics.areEqual(this.data, imageRequest.data) || !Intrinsics.areEqual((Object) this.target, (Object) imageRequest.target) || !Intrinsics.areEqual((Object) this.listener, (Object) imageRequest.listener) || !Intrinsics.areEqual((Object) this.memoryCacheKey, (Object) imageRequest.memoryCacheKey) || !Intrinsics.areEqual((Object) this.placeholderMemoryCacheKey, (Object) imageRequest.placeholderMemoryCacheKey) || !Intrinsics.areEqual((Object) this.colorSpace, (Object) imageRequest.colorSpace) || !Intrinsics.areEqual((Object) this.fetcher, (Object) imageRequest.fetcher) || !Intrinsics.areEqual((Object) this.decoder, (Object) imageRequest.decoder) || !Intrinsics.areEqual((Object) this.transformations, (Object) imageRequest.transformations) || !Intrinsics.areEqual((Object) this.headers, (Object) imageRequest.headers) || !Intrinsics.areEqual((Object) this.parameters, (Object) imageRequest.parameters) || !Intrinsics.areEqual((Object) this.lifecycle, (Object) imageRequest.lifecycle) || !Intrinsics.areEqual((Object) this.sizeResolver, (Object) imageRequest.sizeResolver) || this.scale != imageRequest.scale || !Intrinsics.areEqual((Object) this.dispatcher, (Object) imageRequest.dispatcher) || !Intrinsics.areEqual((Object) this.transition, (Object) imageRequest.transition) || this.precision != imageRequest.precision || this.bitmapConfig != imageRequest.bitmapConfig || this.allowHardware != imageRequest.allowHardware || this.allowRgb565 != imageRequest.allowRgb565 || this.premultipliedAlpha != imageRequest.premultipliedAlpha || this.memoryCachePolicy != imageRequest.memoryCachePolicy || this.diskCachePolicy != imageRequest.diskCachePolicy || this.networkCachePolicy != imageRequest.networkCachePolicy || !Intrinsics.areEqual((Object) this.placeholderResId, (Object) imageRequest.placeholderResId) || !Intrinsics.areEqual((Object) this.placeholderDrawable, (Object) imageRequest.placeholderDrawable) || !Intrinsics.areEqual((Object) this.errorResId, (Object) imageRequest.errorResId) || !Intrinsics.areEqual((Object) this.errorDrawable, (Object) imageRequest.errorDrawable) || !Intrinsics.areEqual((Object) this.fallbackResId, (Object) imageRequest.fallbackResId) || !Intrinsics.areEqual((Object) this.fallbackDrawable, (Object) imageRequest.fallbackDrawable) || !Intrinsics.areEqual((Object) this.defined, (Object) imageRequest.defined) || !Intrinsics.areEqual((Object) this.defaults, (Object) imageRequest.defaults)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.context.hashCode() * 31) + this.data.hashCode()) * 31;
        Target target2 = this.target;
        int i = 0;
        int hashCode2 = (hashCode + (target2 != null ? target2.hashCode() : 0)) * 31;
        Listener listener2 = this.listener;
        int hashCode3 = (hashCode2 + (listener2 != null ? listener2.hashCode() : 0)) * 31;
        MemoryCache.Key key = this.memoryCacheKey;
        int hashCode4 = (hashCode3 + (key != null ? key.hashCode() : 0)) * 31;
        MemoryCache.Key key2 = this.placeholderMemoryCacheKey;
        int hashCode5 = (hashCode4 + (key2 != null ? key2.hashCode() : 0)) * 31;
        ColorSpace colorSpace2 = this.colorSpace;
        int hashCode6 = (hashCode5 + (colorSpace2 != null ? colorSpace2.hashCode() : 0)) * 31;
        Pair<Fetcher<?>, Class<?>> pair = this.fetcher;
        int hashCode7 = (hashCode6 + (pair != null ? pair.hashCode() : 0)) * 31;
        Decoder decoder2 = this.decoder;
        int hashCode8 = (((((((((((((((((((((((((((((((((hashCode7 + (decoder2 != null ? decoder2.hashCode() : 0)) * 31) + this.transformations.hashCode()) * 31) + this.headers.hashCode()) * 31) + this.parameters.hashCode()) * 31) + this.lifecycle.hashCode()) * 31) + this.sizeResolver.hashCode()) * 31) + this.scale.hashCode()) * 31) + this.dispatcher.hashCode()) * 31) + this.transition.hashCode()) * 31) + this.precision.hashCode()) * 31) + this.bitmapConfig.hashCode()) * 31) + C$r8$backportedMethods$utility$Boolean$1$hashCode.hashCode(this.allowHardware)) * 31) + C$r8$backportedMethods$utility$Boolean$1$hashCode.hashCode(this.allowRgb565)) * 31) + C$r8$backportedMethods$utility$Boolean$1$hashCode.hashCode(this.premultipliedAlpha)) * 31) + this.memoryCachePolicy.hashCode()) * 31) + this.diskCachePolicy.hashCode()) * 31) + this.networkCachePolicy.hashCode()) * 31;
        Integer num = this.placeholderResId;
        int intValue = (hashCode8 + (num != null ? num.intValue() : 0)) * 31;
        Drawable drawable = this.placeholderDrawable;
        int hashCode9 = (intValue + (drawable != null ? drawable.hashCode() : 0)) * 31;
        Integer num2 = this.errorResId;
        int intValue2 = (hashCode9 + (num2 != null ? num2.intValue() : 0)) * 31;
        Drawable drawable2 = this.errorDrawable;
        int hashCode10 = (intValue2 + (drawable2 != null ? drawable2.hashCode() : 0)) * 31;
        Integer num3 = this.fallbackResId;
        int intValue3 = (hashCode10 + (num3 != null ? num3.intValue() : 0)) * 31;
        Drawable drawable3 = this.fallbackDrawable;
        if (drawable3 != null) {
            i = drawable3.hashCode();
        }
        return ((((intValue3 + i) * 31) + this.defined.hashCode()) * 31) + this.defaults.hashCode();
    }

    public String toString() {
        return "ImageRequest(context=" + this.context + ", data=" + this.data + ", target=" + this.target + ", listener=" + this.listener + ", " + "memoryCacheKey=" + this.memoryCacheKey + ", placeholderMemoryCacheKey=" + this.placeholderMemoryCacheKey + ", " + "colorSpace=" + this.colorSpace + ", fetcher=" + this.fetcher + ", decoder=" + this.decoder + ", transformations=" + this.transformations + ", " + "headers=" + this.headers + ", parameters=" + this.parameters + ", lifecycle=" + this.lifecycle + ", sizeResolver=" + this.sizeResolver + ", " + "scale=" + this.scale + ", dispatcher=" + this.dispatcher + ", transition=" + this.transition + ", precision=" + this.precision + ", " + "bitmapConfig=" + this.bitmapConfig + ", allowHardware=" + this.allowHardware + ", allowRgb565=" + this.allowRgb565 + ", " + "premultipliedAlpha=" + this.premultipliedAlpha + ", memoryCachePolicy=" + this.memoryCachePolicy + ", " + "diskCachePolicy=" + this.diskCachePolicy + ", networkCachePolicy=" + this.networkCachePolicy + ", " + "placeholderResId=" + this.placeholderResId + ", placeholderDrawable=" + this.placeholderDrawable + ", errorResId=" + this.errorResId + ", " + "errorDrawable=" + this.errorDrawable + ", fallbackResId=" + this.fallbackResId + ", fallbackDrawable=" + this.fallbackDrawable + ", " + "defined=" + this.defined + ", defaults=" + this.defaults + ')';
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0016\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020FJ\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010I\u001a\u00020\rJ\u0006\u0010J\u001a\u00020\u0006J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u000e\u0010K\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\tJ\u000e\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u001cJ\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010N\u001a\u00020\u00002\b\u0010O\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010N\u001a\u00020\u00002\b\b\u0001\u0010P\u001a\u00020\u001cJ\u0010\u0010Q\u001a\u00020\u00002\b\u0010O\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010Q\u001a\u00020\u00002\b\b\u0001\u0010P\u001a\u00020\u001cJ#\u0010 \u001a\u00020\u0000\"\n\b\u0000\u0010R\u0018\u0001*\u00020\u00012\f\u0010 \u001a\b\u0012\u0004\u0012\u0002HR0\"H\bJ.\u0010 \u001a\u00020\u0000\"\b\b\u0000\u0010R*\u00020\u00012\f\u0010 \u001a\b\u0012\u0004\u0012\u0002HR0\"2\f\u0010S\u001a\b\u0012\u0004\u0012\u0002HR0#H\u0001J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010$\u001a\u00020TJ\u0010\u0010&\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010'J\u0010\u0010&\u001a\u00020\u00002\b\u0010U\u001a\u0004\u0018\u00010VJÊ\u0001\u0010(\u001a\u00020\u00002#\b\u0006\u0010W\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\bY\u0012\b\bE\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020Z0X2#\b\u0006\u0010[\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\bY\u0012\b\bE\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020Z0X28\b\u0006\u0010\\\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\bY\u0012\b\bE\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110^¢\u0006\f\bY\u0012\b\bE\u0012\u0004\b\b(_\u0012\u0004\u0012\u00020Z0]28\b\u0006\u0010`\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\bY\u0012\b\bE\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110a¢\u0006\f\bY\u0012\b\bE\u0012\u0004\b\b(b\u0012\u0004\u0012\u00020Z0]H\bø\u0001\u0000J\u0010\u0010(\u001a\u00020\u00002\b\u0010(\u001a\u0004\u0018\u00010)J\u0010\u0010*\u001a\u00020\u00002\b\u0010c\u001a\u0004\u0018\u00010+J\u0010\u0010*\u001a\u00020\u00002\b\u0010c\u001a\u0004\u0018\u00010FJ\u000e\u0010,\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u0016J\u000e\u0010-\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u0016J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010.\u001a\u00020dJ\u0010\u0010e\u001a\u00020\u00002\b\u0010O\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010e\u001a\u00020\u00002\b\b\u0001\u0010P\u001a\u00020\u001cJ\u0010\u00101\u001a\u00020\u00002\b\u0010c\u001a\u0004\u0018\u00010+J\u0010\u00101\u001a\u00020\u00002\b\u0010c\u001a\u0004\u0018\u00010FJ\u000e\u00103\u001a\u00020\u00002\u0006\u00103\u001a\u000204J\u000e\u00105\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\tJ\u000e\u0010f\u001a\u00020\u00002\u0006\u0010E\u001a\u00020FJ\u000e\u0010g\u001a\u00020\u00002\u0006\u0010c\u001a\u00020FJ\b\u0010h\u001a\u00020ZH\u0002J\b\u0010i\u001a\u00020ZH\u0002J\b\u0010j\u001a\u00020'H\u0002J\b\u0010k\u001a\u000208H\u0002J\b\u0010l\u001a\u00020:H\u0002J\u000e\u0010;\u001a\u00020\u00002\u0006\u0010;\u001a\u000208J\u0016\u0010m\u001a\u00020\u00002\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020FJ&\u0010n\u001a\u00020\u00002\u0006\u0010c\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010o\u001a\u0004\u0018\u00010FH\u0007J\u000e\u0010p\u001a\u00020\u00002\u0006\u0010p\u001a\u00020qJ\u000e\u0010p\u001a\u00020\u00002\u0006\u0010r\u001a\u00020:J\u0010\u0010p\u001a\u00020\u00002\b\b\u0001\u0010p\u001a\u00020\u001cJ\u001a\u0010p\u001a\u00020\u00002\b\b\u0001\u0010s\u001a\u00020\u001c2\b\b\u0001\u0010t\u001a\u00020\u001cJ\u0010=\u001a\u00020\u00002%\b\u0006\u0010W\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001a¢\u0006\f\bY\u0012\b\bE\u0012\u0004\b\b(e\u0012\u0004\u0012\u00020Z0X2%\b\u0006\u0010\\\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001a¢\u0006\f\bY\u0012\b\bE\u0012\u0004\b\b(N\u0012\u0004\u0012\u00020Z0X2#\b\u0006\u0010`\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\bY\u0012\b\bE\u0012\u0004\b\b(u\u0012\u0004\u0012\u00020Z0XH\bø\u0001\u0000J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010v\u001a\u00020wJ\u0010\u0010=\u001a\u00020\u00002\b\u0010=\u001a\u0004\u0018\u00010>J\u001f\u0010?\u001a\u00020\u00002\u0012\u0010?\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0x\"\u00020A¢\u0006\u0002\u0010yJ\u0014\u0010?\u001a\u00020\u00002\f\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@J\u0010\u0010B\u001a\u00020\u00002\u0006\u0010B\u001a\u00020CH\u0007R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0012\u0010\u000b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0004\n\u0002\u0010\u001dR$\u0010 \u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030#\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0016\u00102\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006z"}, mo26107d2 = {"Lcoil/request/ImageRequest$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "request", "Lcoil/request/ImageRequest;", "(Lcoil/request/ImageRequest;Landroid/content/Context;)V", "allowHardware", "", "Ljava/lang/Boolean;", "allowRgb565", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "colorSpace", "Landroid/graphics/ColorSpace;", "data", "decoder", "Lcoil/decode/Decoder;", "defaults", "Lcoil/request/DefaultRequestOptions;", "diskCachePolicy", "Lcoil/request/CachePolicy;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "errorDrawable", "Landroid/graphics/drawable/Drawable;", "errorResId", "", "Ljava/lang/Integer;", "fallbackDrawable", "fallbackResId", "fetcher", "Lkotlin/Pair;", "Lcoil/fetch/Fetcher;", "Ljava/lang/Class;", "headers", "Lokhttp3/Headers$Builder;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "listener", "Lcoil/request/ImageRequest$Listener;", "memoryCacheKey", "Lcoil/memory/MemoryCache$Key;", "memoryCachePolicy", "networkCachePolicy", "parameters", "Lcoil/request/Parameters$Builder;", "placeholderDrawable", "placeholderMemoryCacheKey", "placeholderResId", "precision", "Lcoil/size/Precision;", "premultipliedAlpha", "resolvedLifecycle", "resolvedScale", "Lcoil/size/Scale;", "resolvedSizeResolver", "Lcoil/size/SizeResolver;", "scale", "sizeResolver", "target", "Lcoil/target/Target;", "transformations", "", "Lcoil/transform/Transformation;", "transition", "Lcoil/transition/Transition;", "addHeader", "name", "", "value", "enable", "config", "build", "crossfade", "durationMillis", "policy", "error", "drawable", "drawableResId", "fallback", "T", "type", "Lokhttp3/Headers;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStart", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "", "onCancel", "onError", "Lkotlin/Function2;", "", "throwable", "onSuccess", "Lcoil/request/ImageResult$Metadata;", "metadata", "key", "Lcoil/request/Parameters;", "placeholder", "removeHeader", "removeParameter", "resetResolvedScale", "resetResolvedValues", "resolveLifecycle", "resolveScale", "resolveSizeResolver", "setHeader", "setParameter", "cacheKey", "size", "Lcoil/size/Size;", "resolver", "width", "height", "result", "imageView", "Landroid/widget/ImageView;", "", "([Lcoil/transform/Transformation;)Lcoil/request/ImageRequest$Builder;", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: ImageRequest.kt */
    public static final class Builder {
        private Boolean allowHardware;
        private Boolean allowRgb565;
        private Bitmap.Config bitmapConfig;
        private ColorSpace colorSpace;
        private final Context context;
        private Object data;
        private Decoder decoder;
        private DefaultRequestOptions defaults;
        private CachePolicy diskCachePolicy;
        private CoroutineDispatcher dispatcher;
        private Drawable errorDrawable;
        private Integer errorResId;
        private Drawable fallbackDrawable;
        private Integer fallbackResId;
        private Pair<? extends Fetcher<?>, ? extends Class<?>> fetcher;
        private Headers.Builder headers;
        private Lifecycle lifecycle;
        private Listener listener;
        private MemoryCache.Key memoryCacheKey;
        private CachePolicy memoryCachePolicy;
        private CachePolicy networkCachePolicy;
        private Parameters.Builder parameters;
        private Drawable placeholderDrawable;
        private MemoryCache.Key placeholderMemoryCacheKey;
        private Integer placeholderResId;
        private Precision precision;
        private boolean premultipliedAlpha;
        private Lifecycle resolvedLifecycle;
        private Scale resolvedScale;
        private SizeResolver resolvedSizeResolver;
        private Scale scale;
        private SizeResolver sizeResolver;
        private Target target;
        private List<? extends Transformation> transformations;
        private Transition transition;

        public Builder(ImageRequest imageRequest) {
            this(imageRequest, (Context) null, 2, (DefaultConstructorMarker) null);
        }

        public final Builder setParameter(String str, Object obj) {
            return setParameter$default(this, str, obj, (String) null, 4, (Object) null);
        }

        public Builder(Context context2) {
            Intrinsics.checkNotNullParameter(context2, "context");
            this.context = context2;
            this.defaults = DefaultRequestOptions.INSTANCE;
            this.data = null;
            this.target = null;
            this.listener = null;
            MemoryCache.Key key = null;
            this.memoryCacheKey = key;
            this.placeholderMemoryCacheKey = key;
            if (Build.VERSION.SDK_INT >= 26) {
                this.colorSpace = null;
            }
            this.fetcher = null;
            this.decoder = null;
            this.transformations = CollectionsKt.emptyList();
            this.headers = null;
            this.parameters = null;
            Lifecycle lifecycle2 = null;
            this.lifecycle = lifecycle2;
            SizeResolver sizeResolver2 = null;
            this.sizeResolver = sizeResolver2;
            Scale scale2 = null;
            this.scale = scale2;
            this.dispatcher = null;
            this.transition = null;
            this.precision = null;
            this.bitmapConfig = null;
            Boolean bool = null;
            this.allowHardware = bool;
            this.allowRgb565 = bool;
            this.premultipliedAlpha = true;
            CachePolicy cachePolicy = null;
            this.memoryCachePolicy = cachePolicy;
            this.diskCachePolicy = cachePolicy;
            this.networkCachePolicy = cachePolicy;
            Integer num = null;
            this.placeholderResId = num;
            Drawable drawable = null;
            this.placeholderDrawable = drawable;
            this.errorResId = num;
            this.errorDrawable = drawable;
            this.fallbackResId = num;
            this.fallbackDrawable = drawable;
            this.resolvedLifecycle = lifecycle2;
            this.resolvedSizeResolver = sizeResolver2;
            this.resolvedScale = scale2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(ImageRequest imageRequest, Context context2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(imageRequest, (i & 2) != 0 ? imageRequest.getContext() : context2);
        }

        public Builder(ImageRequest imageRequest, Context context2) {
            Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            Intrinsics.checkNotNullParameter(context2, "context");
            this.context = context2;
            this.defaults = imageRequest.getDefaults();
            this.data = imageRequest.getData();
            this.target = imageRequest.getTarget();
            this.listener = imageRequest.getListener();
            this.memoryCacheKey = imageRequest.getMemoryCacheKey();
            this.placeholderMemoryCacheKey = imageRequest.getPlaceholderMemoryCacheKey();
            if (Build.VERSION.SDK_INT >= 26) {
                this.colorSpace = imageRequest.getColorSpace();
            }
            this.fetcher = imageRequest.getFetcher();
            this.decoder = imageRequest.getDecoder();
            this.transformations = imageRequest.getTransformations();
            this.headers = imageRequest.getHeaders().newBuilder();
            this.parameters = imageRequest.getParameters().newBuilder();
            this.lifecycle = imageRequest.getDefined().getLifecycle();
            this.sizeResolver = imageRequest.getDefined().getSizeResolver();
            this.scale = imageRequest.getDefined().getScale();
            this.dispatcher = imageRequest.getDefined().getDispatcher();
            this.transition = imageRequest.getDefined().getTransition();
            this.precision = imageRequest.getDefined().getPrecision();
            this.bitmapConfig = imageRequest.getDefined().getBitmapConfig();
            this.allowHardware = imageRequest.getDefined().getAllowHardware();
            this.allowRgb565 = imageRequest.getDefined().getAllowRgb565();
            this.premultipliedAlpha = imageRequest.getPremultipliedAlpha();
            this.memoryCachePolicy = imageRequest.getDefined().getMemoryCachePolicy();
            this.diskCachePolicy = imageRequest.getDefined().getDiskCachePolicy();
            this.networkCachePolicy = imageRequest.getDefined().getNetworkCachePolicy();
            this.placeholderResId = imageRequest.placeholderResId;
            this.placeholderDrawable = imageRequest.placeholderDrawable;
            this.errorResId = imageRequest.errorResId;
            this.errorDrawable = imageRequest.errorDrawable;
            this.fallbackResId = imageRequest.fallbackResId;
            this.fallbackDrawable = imageRequest.fallbackDrawable;
            if (imageRequest.getContext() == context2) {
                this.resolvedLifecycle = imageRequest.getLifecycle();
                this.resolvedSizeResolver = imageRequest.getSizeResolver();
                this.resolvedScale = imageRequest.getScale();
                return;
            }
            this.resolvedLifecycle = null;
            this.resolvedSizeResolver = null;
            this.resolvedScale = null;
        }

        public final Builder data(Object obj) {
            Builder builder = this;
            builder.data = obj;
            return builder;
        }

        public final Builder memoryCacheKey(String str) {
            return memoryCacheKey(str != null ? MemoryCache.Key.Companion.create(str) : null);
        }

        public final Builder memoryCacheKey(MemoryCache.Key key) {
            Builder builder = this;
            builder.memoryCacheKey = key;
            return builder;
        }

        public static /* synthetic */ Builder listener$default(Builder builder, Function1 function1, Function1 function12, Function2 function2, Function2 function22, int i, Object obj) {
            if ((i & 1) != 0) {
                function1 = ImageRequest$Builder$listener$1.INSTANCE;
            }
            if ((i & 2) != 0) {
                function12 = ImageRequest$Builder$listener$2.INSTANCE;
            }
            if ((i & 4) != 0) {
                function2 = ImageRequest$Builder$listener$3.INSTANCE;
            }
            if ((i & 8) != 0) {
                function22 = ImageRequest$Builder$listener$4.INSTANCE;
            }
            Intrinsics.checkNotNullParameter(function1, "onStart");
            Intrinsics.checkNotNullParameter(function12, "onCancel");
            Intrinsics.checkNotNullParameter(function2, "onError");
            Intrinsics.checkNotNullParameter(function22, "onSuccess");
            return builder.listener(new ImageRequest$Builder$listener$5(function1, function12, function2, function22));
        }

        public final Builder listener(Function1<? super ImageRequest, Unit> function1, Function1<? super ImageRequest, Unit> function12, Function2<? super ImageRequest, ? super Throwable, Unit> function2, Function2<? super ImageRequest, ? super ImageResult.Metadata, Unit> function22) {
            Intrinsics.checkNotNullParameter(function1, "onStart");
            Intrinsics.checkNotNullParameter(function12, "onCancel");
            Intrinsics.checkNotNullParameter(function2, "onError");
            Intrinsics.checkNotNullParameter(function22, "onSuccess");
            return listener(new ImageRequest$Builder$listener$5(function1, function12, function2, function22));
        }

        public final Builder listener(Listener listener2) {
            Builder builder = this;
            builder.listener = listener2;
            return builder;
        }

        public final Builder dispatcher(CoroutineDispatcher coroutineDispatcher) {
            Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
            Builder builder = this;
            builder.dispatcher = coroutineDispatcher;
            return builder;
        }

        public final Builder transformations(Transformation... transformationArr) {
            Intrinsics.checkNotNullParameter(transformationArr, "transformations");
            return transformations((List<? extends Transformation>) ArraysKt.toList((T[]) transformationArr));
        }

        public final Builder transformations(List<? extends Transformation> list) {
            Intrinsics.checkNotNullParameter(list, "transformations");
            Builder builder = this;
            builder.transformations = CollectionsKt.toList(list);
            return builder;
        }

        public final Builder bitmapConfig(Bitmap.Config config) {
            Intrinsics.checkNotNullParameter(config, "config");
            Builder builder = this;
            builder.bitmapConfig = config;
            return builder;
        }

        public final Builder colorSpace(ColorSpace colorSpace2) {
            Intrinsics.checkNotNullParameter(colorSpace2, "colorSpace");
            Builder builder = this;
            builder.colorSpace = colorSpace2;
            return builder;
        }

        public final Builder size(int i) {
            return size(i, i);
        }

        public final Builder size(int i, int i2) {
            return size((Size) new PixelSize(i, i2));
        }

        public final Builder size(Size size) {
            Intrinsics.checkNotNullParameter(size, "size");
            return size(SizeResolver.Companion.create(size));
        }

        public final Builder size(SizeResolver sizeResolver2) {
            Intrinsics.checkNotNullParameter(sizeResolver2, "resolver");
            Builder builder = this;
            builder.sizeResolver = sizeResolver2;
            builder.resetResolvedValues();
            return builder;
        }

        public final Builder scale(Scale scale2) {
            Intrinsics.checkNotNullParameter(scale2, "scale");
            Builder builder = this;
            builder.scale = scale2;
            return builder;
        }

        public final Builder precision(Precision precision2) {
            Intrinsics.checkNotNullParameter(precision2, "precision");
            Builder builder = this;
            builder.precision = precision2;
            return builder;
        }

        public final /* synthetic */ <T> Builder fetcher(Fetcher<T> fetcher2) {
            Intrinsics.checkNotNullParameter(fetcher2, "fetcher");
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return fetcher(fetcher2, Object.class);
        }

        public final <T> Builder fetcher(Fetcher<T> fetcher2, Class<T> cls) {
            Intrinsics.checkNotNullParameter(fetcher2, "fetcher");
            Intrinsics.checkNotNullParameter(cls, "type");
            Builder builder = this;
            builder.fetcher = TuplesKt.m181to(fetcher2, cls);
            return builder;
        }

        public final Builder decoder(Decoder decoder2) {
            Intrinsics.checkNotNullParameter(decoder2, "decoder");
            Builder builder = this;
            builder.decoder = decoder2;
            return builder;
        }

        public final Builder allowHardware(boolean z) {
            Builder builder = this;
            builder.allowHardware = Boolean.valueOf(z);
            return builder;
        }

        public final Builder allowRgb565(boolean z) {
            Builder builder = this;
            builder.allowRgb565 = Boolean.valueOf(z);
            return builder;
        }

        public final Builder premultipliedAlpha(boolean z) {
            Builder builder = this;
            builder.premultipliedAlpha = z;
            return builder;
        }

        public final Builder memoryCachePolicy(CachePolicy cachePolicy) {
            Intrinsics.checkNotNullParameter(cachePolicy, "policy");
            Builder builder = this;
            builder.memoryCachePolicy = cachePolicy;
            return builder;
        }

        public final Builder diskCachePolicy(CachePolicy cachePolicy) {
            Intrinsics.checkNotNullParameter(cachePolicy, "policy");
            Builder builder = this;
            builder.diskCachePolicy = cachePolicy;
            return builder;
        }

        public final Builder networkCachePolicy(CachePolicy cachePolicy) {
            Intrinsics.checkNotNullParameter(cachePolicy, "policy");
            Builder builder = this;
            builder.networkCachePolicy = cachePolicy;
            return builder;
        }

        public final Builder headers(Headers headers2) {
            Intrinsics.checkNotNullParameter(headers2, "headers");
            Builder builder = this;
            builder.headers = headers2.newBuilder();
            return builder;
        }

        public final Builder addHeader(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "value");
            Builder builder = this;
            Headers.Builder builder2 = builder.headers;
            if (builder2 == null) {
                builder2 = new Headers.Builder();
            }
            builder.headers = builder2.add(str, str2);
            return builder;
        }

        public final Builder setHeader(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "value");
            Builder builder = this;
            Headers.Builder builder2 = builder.headers;
            if (builder2 == null) {
                builder2 = new Headers.Builder();
            }
            builder.headers = builder2.set(str, str2);
            return builder;
        }

        public final Builder removeHeader(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            Builder builder = this;
            Headers.Builder builder2 = builder.headers;
            builder.headers = builder2 != null ? builder2.removeAll(str) : null;
            return builder;
        }

        public final Builder parameters(Parameters parameters2) {
            Intrinsics.checkNotNullParameter(parameters2, "parameters");
            Builder builder = this;
            builder.parameters = parameters2.newBuilder();
            return builder;
        }

        public static /* synthetic */ Builder setParameter$default(Builder builder, String str, Object obj, String str2, int i, Object obj2) {
            if ((i & 4) != 0) {
                str2 = obj != null ? obj.toString() : null;
            }
            return builder.setParameter(str, obj, str2);
        }

        public final Builder setParameter(String str, Object obj, String str2) {
            Intrinsics.checkNotNullParameter(str, "key");
            Builder builder = this;
            Parameters.Builder builder2 = builder.parameters;
            if (builder2 == null) {
                builder2 = new Parameters.Builder();
            }
            builder2.set(str, obj, str2);
            Unit unit = Unit.INSTANCE;
            builder.parameters = builder2;
            return builder;
        }

        public final Builder removeParameter(String str) {
            Intrinsics.checkNotNullParameter(str, "key");
            Builder builder = this;
            Parameters.Builder builder2 = builder.parameters;
            if (builder2 != null) {
                builder2.remove(str);
            }
            return builder;
        }

        public final Builder placeholderMemoryCacheKey(String str) {
            return placeholderMemoryCacheKey(str != null ? MemoryCache.Key.Companion.create(str) : null);
        }

        public final Builder placeholderMemoryCacheKey(MemoryCache.Key key) {
            Builder builder = this;
            builder.placeholderMemoryCacheKey = key;
            return builder;
        }

        public final Builder placeholder(int i) {
            Builder builder = this;
            builder.placeholderResId = Integer.valueOf(i);
            builder.placeholderDrawable = null;
            return builder;
        }

        public final Builder placeholder(Drawable drawable) {
            Builder builder = this;
            builder.placeholderDrawable = drawable;
            builder.placeholderResId = 0;
            return builder;
        }

        public final Builder error(int i) {
            Builder builder = this;
            builder.errorResId = Integer.valueOf(i);
            builder.errorDrawable = null;
            return builder;
        }

        public final Builder error(Drawable drawable) {
            Builder builder = this;
            builder.errorDrawable = drawable;
            builder.errorResId = 0;
            return builder;
        }

        public final Builder fallback(int i) {
            Builder builder = this;
            builder.fallbackResId = Integer.valueOf(i);
            builder.fallbackDrawable = null;
            return builder;
        }

        public final Builder fallback(Drawable drawable) {
            Builder builder = this;
            builder.fallbackDrawable = drawable;
            builder.fallbackResId = 0;
            return builder;
        }

        public final Builder target(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            return target((Target) new ImageViewTarget(imageView));
        }

        public static /* synthetic */ Builder target$default(Builder builder, Function1 function1, Function1 function12, Function1 function13, int i, Object obj) {
            if ((i & 1) != 0) {
                function1 = ImageRequest$Builder$target$1.INSTANCE;
            }
            if ((i & 2) != 0) {
                function12 = ImageRequest$Builder$target$2.INSTANCE;
            }
            if ((i & 4) != 0) {
                function13 = ImageRequest$Builder$target$3.INSTANCE;
            }
            Intrinsics.checkNotNullParameter(function1, "onStart");
            Intrinsics.checkNotNullParameter(function12, "onError");
            Intrinsics.checkNotNullParameter(function13, "onSuccess");
            return builder.target((Target) new ImageRequest$Builder$target$4(function1, function12, function13));
        }

        public final Builder target(Function1<? super Drawable, Unit> function1, Function1<? super Drawable, Unit> function12, Function1<? super Drawable, Unit> function13) {
            Intrinsics.checkNotNullParameter(function1, "onStart");
            Intrinsics.checkNotNullParameter(function12, "onError");
            Intrinsics.checkNotNullParameter(function13, "onSuccess");
            return target((Target) new ImageRequest$Builder$target$4(function1, function12, function13));
        }

        public final Builder target(Target target2) {
            Builder builder = this;
            builder.target = target2;
            builder.resetResolvedValues();
            return builder;
        }

        public final Builder crossfade(boolean z) {
            return crossfade(z ? 100 : 0);
        }

        public final Builder crossfade(int i) {
            return transition(i > 0 ? new CrossfadeTransition(i, false, 2, (DefaultConstructorMarker) null) : Transition.NONE);
        }

        public final Builder transition(Transition transition2) {
            Intrinsics.checkNotNullParameter(transition2, "transition");
            Builder builder = this;
            builder.transition = transition2;
            return builder;
        }

        public final Builder lifecycle(LifecycleOwner lifecycleOwner) {
            return lifecycle(lifecycleOwner != null ? lifecycleOwner.getLifecycle() : null);
        }

        public final Builder lifecycle(Lifecycle lifecycle2) {
            Builder builder = this;
            builder.lifecycle = lifecycle2;
            return builder;
        }

        public final Builder defaults(DefaultRequestOptions defaultRequestOptions) {
            Intrinsics.checkNotNullParameter(defaultRequestOptions, RemoteConfigComponent.DEFAULTS_FILE_NAME);
            Builder builder = this;
            builder.defaults = defaultRequestOptions;
            builder.resetResolvedScale();
            return builder;
        }

        public final ImageRequest build() {
            Context context2 = this.context;
            Object obj = this.data;
            if (obj == null) {
                obj = NullRequestData.INSTANCE;
            }
            Object obj2 = obj;
            Target target2 = this.target;
            Listener listener2 = this.listener;
            MemoryCache.Key key = this.memoryCacheKey;
            MemoryCache.Key key2 = this.placeholderMemoryCacheKey;
            ColorSpace colorSpace2 = this.colorSpace;
            Pair<? extends Fetcher<?>, ? extends Class<?>> pair = this.fetcher;
            Decoder decoder2 = this.decoder;
            List<? extends Transformation> list = this.transformations;
            Headers.Builder builder = this.headers;
            Parameters parameters2 = null;
            Headers orEmpty = Extensions.orEmpty(builder != null ? builder.build() : null);
            Intrinsics.checkNotNullExpressionValue(orEmpty, "headers?.build().orEmpty()");
            Parameters.Builder builder2 = this.parameters;
            if (builder2 != null) {
                parameters2 = builder2.build();
            }
            Parameters orEmpty2 = Extensions.orEmpty(parameters2);
            Lifecycle lifecycle2 = this.lifecycle;
            if (lifecycle2 == null) {
                lifecycle2 = this.resolvedLifecycle;
            }
            if (lifecycle2 == null) {
                lifecycle2 = resolveLifecycle();
            }
            Lifecycle lifecycle3 = lifecycle2;
            SizeResolver sizeResolver2 = this.sizeResolver;
            if (sizeResolver2 == null) {
                sizeResolver2 = this.resolvedSizeResolver;
            }
            if (sizeResolver2 == null) {
                sizeResolver2 = resolveSizeResolver();
            }
            SizeResolver sizeResolver3 = sizeResolver2;
            Scale scale2 = this.scale;
            if (scale2 == null) {
                scale2 = this.resolvedScale;
            }
            if (scale2 == null) {
                scale2 = resolveScale();
            }
            Scale scale3 = scale2;
            CoroutineDispatcher coroutineDispatcher = this.dispatcher;
            if (coroutineDispatcher == null) {
                coroutineDispatcher = this.defaults.getDispatcher();
            }
            CoroutineDispatcher coroutineDispatcher2 = coroutineDispatcher;
            Transition transition2 = this.transition;
            if (transition2 == null) {
                transition2 = this.defaults.getTransition();
            }
            Transition transition3 = transition2;
            Precision precision2 = this.precision;
            if (precision2 == null) {
                precision2 = this.defaults.getPrecision();
            }
            Precision precision3 = precision2;
            Bitmap.Config config = this.bitmapConfig;
            if (config == null) {
                config = this.defaults.getBitmapConfig();
            }
            Bitmap.Config config2 = config;
            Boolean bool = this.allowHardware;
            boolean booleanValue = bool != null ? bool.booleanValue() : this.defaults.getAllowHardware();
            Boolean bool2 = this.allowRgb565;
            boolean booleanValue2 = bool2 != null ? bool2.booleanValue() : this.defaults.getAllowRgb565();
            boolean z = this.premultipliedAlpha;
            CachePolicy cachePolicy = this.memoryCachePolicy;
            if (cachePolicy == null) {
                cachePolicy = this.defaults.getMemoryCachePolicy();
            }
            CachePolicy cachePolicy2 = cachePolicy;
            CachePolicy cachePolicy3 = this.diskCachePolicy;
            if (cachePolicy3 == null) {
                cachePolicy3 = this.defaults.getDiskCachePolicy();
            }
            CachePolicy cachePolicy4 = cachePolicy3;
            CachePolicy cachePolicy5 = this.networkCachePolicy;
            if (cachePolicy5 == null) {
                cachePolicy5 = this.defaults.getNetworkCachePolicy();
            }
            CachePolicy cachePolicy6 = cachePolicy5;
            DefinedRequestOptions definedRequestOptions = r37;
            boolean z2 = z;
            Lifecycle lifecycle4 = lifecycle3;
            Parameters parameters3 = orEmpty2;
            Headers headers2 = orEmpty;
            List<? extends Transformation> list2 = list;
            Decoder decoder3 = decoder2;
            Pair<? extends Fetcher<?>, ? extends Class<?>> pair2 = pair;
            ColorSpace colorSpace3 = colorSpace2;
            MemoryCache.Key key3 = key2;
            MemoryCache.Key key4 = key;
            DefinedRequestOptions definedRequestOptions2 = new DefinedRequestOptions(this.lifecycle, this.sizeResolver, this.scale, this.dispatcher, this.transition, this.precision, this.bitmapConfig, this.allowHardware, this.allowRgb565, this.memoryCachePolicy, this.diskCachePolicy, this.networkCachePolicy);
            return new ImageRequest(context2, obj2, target2, listener2, key4, key3, colorSpace3, pair2, decoder3, list2, headers2, parameters3, lifecycle4, sizeResolver3, scale3, coroutineDispatcher2, transition3, precision3, config2, booleanValue, booleanValue2, z2, cachePolicy2, cachePolicy4, cachePolicy6, this.placeholderResId, this.placeholderDrawable, this.errorResId, this.errorDrawable, this.fallbackResId, this.fallbackDrawable, definedRequestOptions, this.defaults, (DefaultConstructorMarker) null);
        }

        private final void resetResolvedValues() {
            this.resolvedLifecycle = null;
            this.resolvedSizeResolver = null;
            this.resolvedScale = null;
        }

        private final void resetResolvedScale() {
            this.resolvedScale = null;
        }

        private final Lifecycle resolveLifecycle() {
            Target target2 = this.target;
            Lifecycle lifecycle2 = Contexts.getLifecycle(target2 instanceof ViewTarget ? ((ViewTarget) target2).getView().getContext() : this.context);
            return lifecycle2 != null ? lifecycle2 : GlobalLifecycle.INSTANCE;
        }

        private final SizeResolver resolveSizeResolver() {
            Target target2 = this.target;
            if (!(target2 instanceof ViewTarget)) {
                return new DisplaySizeResolver(this.context);
            }
            View view = ((ViewTarget) target2).getView();
            if (view instanceof ImageView) {
                ImageView.ScaleType scaleType = ((ImageView) view).getScaleType();
                if (scaleType == ImageView.ScaleType.CENTER || scaleType == ImageView.ScaleType.MATRIX) {
                    return SizeResolver.Companion.create(OriginalSize.INSTANCE);
                }
            }
            return ViewSizeResolver.Companion.create$default(ViewSizeResolver.Companion, view, false, 2, (Object) null);
        }

        private final Scale resolveScale() {
            SizeResolver sizeResolver2 = this.sizeResolver;
            if (sizeResolver2 instanceof ViewSizeResolver) {
                View view = ((ViewSizeResolver) sizeResolver2).getView();
                if (view instanceof ImageView) {
                    return Extensions.getScale((ImageView) view);
                }
            }
            Target target2 = this.target;
            if (target2 instanceof ViewTarget) {
                View view2 = ((ViewTarget) target2).getView();
                if (view2 instanceof ImageView) {
                    return Extensions.getScale((ImageView) view2);
                }
            }
            return Scale.FILL;
        }
    }
}
