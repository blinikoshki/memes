package coil.request;

import android.graphics.Bitmap;
import androidx.lifecycle.Lifecycle;
import coil.size.Precision;
import coil.size.Scale;
import coil.size.SizeResolver;
import coil.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B}\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0017J\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\u00112\b\u00101\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u000205H\u0016R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u00066"}, mo26107d2 = {"Lcoil/request/DefinedRequestOptions;", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "sizeResolver", "Lcoil/size/SizeResolver;", "scale", "Lcoil/size/Scale;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "transition", "Lcoil/transition/Transition;", "precision", "Lcoil/size/Precision;", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "allowHardware", "", "allowRgb565", "memoryCachePolicy", "Lcoil/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "(Landroidx/lifecycle/Lifecycle;Lcoil/size/SizeResolver;Lcoil/size/Scale;Lkotlinx/coroutines/CoroutineDispatcher;Lcoil/transition/Transition;Lcoil/size/Precision;Landroid/graphics/Bitmap$Config;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;)V", "getAllowHardware", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAllowRgb565", "getBitmapConfig", "()Landroid/graphics/Bitmap$Config;", "getDiskCachePolicy", "()Lcoil/request/CachePolicy;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "getMemoryCachePolicy", "getNetworkCachePolicy", "getPrecision", "()Lcoil/size/Precision;", "getScale", "()Lcoil/size/Scale;", "getSizeResolver", "()Lcoil/size/SizeResolver;", "getTransition", "()Lcoil/transition/Transition;", "copy", "(Landroidx/lifecycle/Lifecycle;Lcoil/size/SizeResolver;Lcoil/size/Scale;Lkotlinx/coroutines/CoroutineDispatcher;Lcoil/transition/Transition;Lcoil/size/Precision;Landroid/graphics/Bitmap$Config;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;)Lcoil/request/DefinedRequestOptions;", "equals", "other", "hashCode", "", "toString", "", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: DefinedRequestOptions.kt */
public final class DefinedRequestOptions {
    private final Boolean allowHardware;
    private final Boolean allowRgb565;
    private final Bitmap.Config bitmapConfig;
    private final CachePolicy diskCachePolicy;
    private final CoroutineDispatcher dispatcher;
    private final Lifecycle lifecycle;
    private final CachePolicy memoryCachePolicy;
    private final CachePolicy networkCachePolicy;
    private final Precision precision;
    private final Scale scale;
    private final SizeResolver sizeResolver;
    private final Transition transition;

    public DefinedRequestOptions(Lifecycle lifecycle2, SizeResolver sizeResolver2, Scale scale2, CoroutineDispatcher coroutineDispatcher, Transition transition2, Precision precision2, Bitmap.Config config, Boolean bool, Boolean bool2, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3) {
        this.lifecycle = lifecycle2;
        this.sizeResolver = sizeResolver2;
        this.scale = scale2;
        this.dispatcher = coroutineDispatcher;
        this.transition = transition2;
        this.precision = precision2;
        this.bitmapConfig = config;
        this.allowHardware = bool;
        this.allowRgb565 = bool2;
        this.memoryCachePolicy = cachePolicy;
        this.diskCachePolicy = cachePolicy2;
        this.networkCachePolicy = cachePolicy3;
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

    public final Boolean getAllowHardware() {
        return this.allowHardware;
    }

    public final Boolean getAllowRgb565() {
        return this.allowRgb565;
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

    public static /* synthetic */ DefinedRequestOptions copy$default(DefinedRequestOptions definedRequestOptions, Lifecycle lifecycle2, SizeResolver sizeResolver2, Scale scale2, CoroutineDispatcher coroutineDispatcher, Transition transition2, Precision precision2, Bitmap.Config config, Boolean bool, Boolean bool2, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, int i, Object obj) {
        DefinedRequestOptions definedRequestOptions2 = definedRequestOptions;
        int i2 = i;
        return definedRequestOptions.copy((i2 & 1) != 0 ? definedRequestOptions2.lifecycle : lifecycle2, (i2 & 2) != 0 ? definedRequestOptions2.sizeResolver : sizeResolver2, (i2 & 4) != 0 ? definedRequestOptions2.scale : scale2, (i2 & 8) != 0 ? definedRequestOptions2.dispatcher : coroutineDispatcher, (i2 & 16) != 0 ? definedRequestOptions2.transition : transition2, (i2 & 32) != 0 ? definedRequestOptions2.precision : precision2, (i2 & 64) != 0 ? definedRequestOptions2.bitmapConfig : config, (i2 & 128) != 0 ? definedRequestOptions2.allowHardware : bool, (i2 & 256) != 0 ? definedRequestOptions2.allowRgb565 : bool2, (i2 & 512) != 0 ? definedRequestOptions2.memoryCachePolicy : cachePolicy, (i2 & 1024) != 0 ? definedRequestOptions2.diskCachePolicy : cachePolicy2, (i2 & 2048) != 0 ? definedRequestOptions2.networkCachePolicy : cachePolicy3);
    }

    public final DefinedRequestOptions copy(Lifecycle lifecycle2, SizeResolver sizeResolver2, Scale scale2, CoroutineDispatcher coroutineDispatcher, Transition transition2, Precision precision2, Bitmap.Config config, Boolean bool, Boolean bool2, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3) {
        return new DefinedRequestOptions(lifecycle2, sizeResolver2, scale2, coroutineDispatcher, transition2, precision2, config, bool, bool2, cachePolicy, cachePolicy2, cachePolicy3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefinedRequestOptions) {
            DefinedRequestOptions definedRequestOptions = (DefinedRequestOptions) obj;
            if (!Intrinsics.areEqual((Object) this.lifecycle, (Object) definedRequestOptions.lifecycle) || !Intrinsics.areEqual((Object) this.sizeResolver, (Object) definedRequestOptions.sizeResolver) || this.scale != definedRequestOptions.scale || !Intrinsics.areEqual((Object) this.dispatcher, (Object) definedRequestOptions.dispatcher) || !Intrinsics.areEqual((Object) this.transition, (Object) definedRequestOptions.transition) || this.precision != definedRequestOptions.precision || this.bitmapConfig != definedRequestOptions.bitmapConfig || !Intrinsics.areEqual((Object) this.allowHardware, (Object) definedRequestOptions.allowHardware) || !Intrinsics.areEqual((Object) this.allowRgb565, (Object) definedRequestOptions.allowRgb565) || this.memoryCachePolicy != definedRequestOptions.memoryCachePolicy || this.diskCachePolicy != definedRequestOptions.diskCachePolicy || this.networkCachePolicy != definedRequestOptions.networkCachePolicy) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        Lifecycle lifecycle2 = this.lifecycle;
        int i = 0;
        int hashCode = (lifecycle2 != null ? lifecycle2.hashCode() : 0) * 31;
        SizeResolver sizeResolver2 = this.sizeResolver;
        int hashCode2 = (hashCode + (sizeResolver2 != null ? sizeResolver2.hashCode() : 0)) * 31;
        Scale scale2 = this.scale;
        int hashCode3 = (hashCode2 + (scale2 != null ? scale2.hashCode() : 0)) * 31;
        CoroutineDispatcher coroutineDispatcher = this.dispatcher;
        int hashCode4 = (hashCode3 + (coroutineDispatcher != null ? coroutineDispatcher.hashCode() : 0)) * 31;
        Transition transition2 = this.transition;
        int hashCode5 = (hashCode4 + (transition2 != null ? transition2.hashCode() : 0)) * 31;
        Precision precision2 = this.precision;
        int hashCode6 = (hashCode5 + (precision2 != null ? precision2.hashCode() : 0)) * 31;
        Bitmap.Config config = this.bitmapConfig;
        int hashCode7 = (hashCode6 + (config != null ? config.hashCode() : 0)) * 31;
        Boolean bool = this.allowHardware;
        int hashCode8 = (hashCode7 + (bool != null ? C$r8$backportedMethods$utility$Boolean$1$hashCode.hashCode(bool.booleanValue()) : 0)) * 31;
        Boolean bool2 = this.allowRgb565;
        int hashCode9 = (hashCode8 + (bool2 != null ? C$r8$backportedMethods$utility$Boolean$1$hashCode.hashCode(bool2.booleanValue()) : 0)) * 31;
        CachePolicy cachePolicy = this.memoryCachePolicy;
        int hashCode10 = (hashCode9 + (cachePolicy != null ? cachePolicy.hashCode() : 0)) * 31;
        CachePolicy cachePolicy2 = this.diskCachePolicy;
        int hashCode11 = (hashCode10 + (cachePolicy2 != null ? cachePolicy2.hashCode() : 0)) * 31;
        CachePolicy cachePolicy3 = this.networkCachePolicy;
        if (cachePolicy3 != null) {
            i = cachePolicy3.hashCode();
        }
        return hashCode11 + i;
    }

    public String toString() {
        return "DefinedRequestOptions(lifecycle=" + this.lifecycle + ", sizeResolver=" + this.sizeResolver + ", scale=" + this.scale + ", " + "dispatcher=" + this.dispatcher + ", transition=" + this.transition + ", precision=" + this.precision + ", bitmapConfig=" + this.bitmapConfig + ", " + "allowHardware=" + this.allowHardware + ", allowRgb565=" + this.allowRgb565 + ", memoryCachePolicy=" + this.memoryCachePolicy + ", " + "diskCachePolicy=" + this.diskCachePolicy + ", networkCachePolicy=" + this.networkCachePolicy + ')';
    }
}
