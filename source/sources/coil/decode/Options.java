package coil.decode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import coil.request.CachePolicy;
import coil.request.Parameters;
import coil.size.Scale;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001Ba\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0012¢\u0006\u0002\u0010\u0015B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0012¢\u0006\u0002\u0010\u0017J\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0012Jx\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0012H\u0007J\u0013\u0010-\u001a\u00020\u000b2\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u000202H\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0013\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0011\u0010\u0014\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0016\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u00063"}, mo26107d2 = {"Lcoil/decode/Options;", "", "context", "Landroid/content/Context;", "config", "Landroid/graphics/Bitmap$Config;", "colorSpace", "Landroid/graphics/ColorSpace;", "scale", "Lcoil/size/Scale;", "allowInexactSize", "", "allowRgb565", "headers", "Lokhttp3/Headers;", "parameters", "Lcoil/request/Parameters;", "memoryCachePolicy", "Lcoil/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "(Landroid/content/Context;Landroid/graphics/Bitmap$Config;Landroid/graphics/ColorSpace;Lcoil/size/Scale;ZZLokhttp3/Headers;Lcoil/request/Parameters;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;)V", "premultipliedAlpha", "(Landroid/content/Context;Landroid/graphics/Bitmap$Config;Landroid/graphics/ColorSpace;Lcoil/size/Scale;ZZZLokhttp3/Headers;Lcoil/request/Parameters;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;)V", "getAllowInexactSize", "()Z", "getAllowRgb565", "getColorSpace", "()Landroid/graphics/ColorSpace;", "getConfig", "()Landroid/graphics/Bitmap$Config;", "getContext", "()Landroid/content/Context;", "getDiskCachePolicy", "()Lcoil/request/CachePolicy;", "getHeaders", "()Lokhttp3/Headers;", "getMemoryCachePolicy", "getNetworkCachePolicy", "getParameters", "()Lcoil/request/Parameters;", "getPremultipliedAlpha", "getScale", "()Lcoil/size/Scale;", "copy", "equals", "other", "hashCode", "", "toString", "", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: Options.kt */
public final class Options {
    private final boolean allowInexactSize;
    private final boolean allowRgb565;
    private final ColorSpace colorSpace;
    private final Bitmap.Config config;
    private final Context context;
    private final CachePolicy diskCachePolicy;
    private final Headers headers;
    private final CachePolicy memoryCachePolicy;
    private final CachePolicy networkCachePolicy;
    private final Parameters parameters;
    private final boolean premultipliedAlpha;
    private final Scale scale;

    public Options(Context context2, Bitmap.Config config2, ColorSpace colorSpace2, Scale scale2, boolean z, boolean z2, boolean z3, Headers headers2, Parameters parameters2, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(config2, "config");
        Intrinsics.checkNotNullParameter(scale2, "scale");
        Intrinsics.checkNotNullParameter(headers2, "headers");
        Intrinsics.checkNotNullParameter(parameters2, "parameters");
        Intrinsics.checkNotNullParameter(cachePolicy, "memoryCachePolicy");
        Intrinsics.checkNotNullParameter(cachePolicy2, "diskCachePolicy");
        Intrinsics.checkNotNullParameter(cachePolicy3, "networkCachePolicy");
        this.context = context2;
        this.config = config2;
        this.colorSpace = colorSpace2;
        this.scale = scale2;
        this.allowInexactSize = z;
        this.allowRgb565 = z2;
        this.premultipliedAlpha = z3;
        this.headers = headers2;
        this.parameters = parameters2;
        this.memoryCachePolicy = cachePolicy;
        this.diskCachePolicy = cachePolicy2;
        this.networkCachePolicy = cachePolicy3;
    }

    public final Context getContext() {
        return this.context;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Options(android.content.Context r12, android.graphics.Bitmap.Config r13, android.graphics.ColorSpace r14, coil.size.Scale r15, boolean r16, boolean r17, boolean r18, okhttp3.Headers r19, coil.request.Parameters r20, coil.request.CachePolicy r21, coil.request.CachePolicy r22, coil.request.CachePolicy r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r11 = this;
            r0 = r24
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0009
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888
            goto L_0x000a
        L_0x0009:
            r1 = r13
        L_0x000a:
            r2 = r0 & 4
            if (r2 == 0) goto L_0x0013
            android.graphics.ColorSpace r2 = coil.util.Extensions.getNULL_COLOR_SPACE()
            goto L_0x0014
        L_0x0013:
            r2 = r14
        L_0x0014:
            r3 = r0 & 8
            if (r3 == 0) goto L_0x001b
            coil.size.Scale r3 = coil.size.Scale.FIT
            goto L_0x001c
        L_0x001b:
            r3 = r15
        L_0x001c:
            r4 = r0 & 16
            r5 = 0
            if (r4 == 0) goto L_0x0023
            r4 = 0
            goto L_0x0025
        L_0x0023:
            r4 = r16
        L_0x0025:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x002a
            goto L_0x002c
        L_0x002a:
            r5 = r17
        L_0x002c:
            r6 = r0 & 64
            if (r6 == 0) goto L_0x0032
            r6 = 1
            goto L_0x0034
        L_0x0032:
            r6 = r18
        L_0x0034:
            r7 = r0 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x0042
            okhttp3.Headers r7 = coil.util.Extensions.getEMPTY_HEADERS()
            java.lang.String r8 = "EMPTY_HEADERS"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            goto L_0x0044
        L_0x0042:
            r7 = r19
        L_0x0044:
            r8 = r0 & 256(0x100, float:3.59E-43)
            if (r8 == 0) goto L_0x004b
            coil.request.Parameters r8 = coil.request.Parameters.EMPTY
            goto L_0x004d
        L_0x004b:
            r8 = r20
        L_0x004d:
            r9 = r0 & 512(0x200, float:7.175E-43)
            if (r9 == 0) goto L_0x0054
            coil.request.CachePolicy r9 = coil.request.CachePolicy.ENABLED
            goto L_0x0056
        L_0x0054:
            r9 = r21
        L_0x0056:
            r10 = r0 & 1024(0x400, float:1.435E-42)
            if (r10 == 0) goto L_0x005d
            coil.request.CachePolicy r10 = coil.request.CachePolicy.ENABLED
            goto L_0x005f
        L_0x005d:
            r10 = r22
        L_0x005f:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0066
            coil.request.CachePolicy r0 = coil.request.CachePolicy.ENABLED
            goto L_0x0068
        L_0x0066:
            r0 = r23
        L_0x0068:
            r13 = r11
            r14 = r12
            r15 = r1
            r16 = r2
            r17 = r3
            r18 = r4
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r8
            r23 = r9
            r24 = r10
            r25 = r0
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.decode.Options.<init>(android.content.Context, android.graphics.Bitmap$Config, android.graphics.ColorSpace, coil.size.Scale, boolean, boolean, boolean, okhttp3.Headers, coil.request.Parameters, coil.request.CachePolicy, coil.request.CachePolicy, coil.request.CachePolicy, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Bitmap.Config getConfig() {
        return this.config;
    }

    public final ColorSpace getColorSpace() {
        return this.colorSpace;
    }

    public final Scale getScale() {
        return this.scale;
    }

    public final boolean getAllowInexactSize() {
        return this.allowInexactSize;
    }

    public final boolean getAllowRgb565() {
        return this.allowRgb565;
    }

    public final boolean getPremultipliedAlpha() {
        return this.premultipliedAlpha;
    }

    public final Headers getHeaders() {
        return this.headers;
    }

    public final Parameters getParameters() {
        return this.parameters;
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

    public static /* synthetic */ Options copy$default(Options options, Context context2, Bitmap.Config config2, ColorSpace colorSpace2, Scale scale2, boolean z, boolean z2, boolean z3, Headers headers2, Parameters parameters2, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, int i, Object obj) {
        Options options2 = options;
        int i2 = i;
        return options.copy((i2 & 1) != 0 ? options2.context : context2, (i2 & 2) != 0 ? options2.config : config2, (i2 & 4) != 0 ? options2.colorSpace : colorSpace2, (i2 & 8) != 0 ? options2.scale : scale2, (i2 & 16) != 0 ? options2.allowInexactSize : z, (i2 & 32) != 0 ? options2.allowRgb565 : z2, (i2 & 64) != 0 ? options2.premultipliedAlpha : z3, (i2 & 128) != 0 ? options2.headers : headers2, (i2 & 256) != 0 ? options2.parameters : parameters2, (i2 & 512) != 0 ? options2.memoryCachePolicy : cachePolicy, (i2 & 1024) != 0 ? options2.diskCachePolicy : cachePolicy2, (i2 & 2048) != 0 ? options2.networkCachePolicy : cachePolicy3);
    }

    public final Options copy(Context context2, Bitmap.Config config2, ColorSpace colorSpace2, Scale scale2, boolean z, boolean z2, boolean z3, Headers headers2, Parameters parameters2, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Bitmap.Config config3 = config2;
        Intrinsics.checkNotNullParameter(config3, "config");
        Scale scale3 = scale2;
        Intrinsics.checkNotNullParameter(scale3, "scale");
        Headers headers3 = headers2;
        Intrinsics.checkNotNullParameter(headers3, "headers");
        Parameters parameters3 = parameters2;
        Intrinsics.checkNotNullParameter(parameters3, "parameters");
        CachePolicy cachePolicy4 = cachePolicy;
        Intrinsics.checkNotNullParameter(cachePolicy4, "memoryCachePolicy");
        CachePolicy cachePolicy5 = cachePolicy2;
        Intrinsics.checkNotNullParameter(cachePolicy5, "diskCachePolicy");
        CachePolicy cachePolicy6 = cachePolicy3;
        Intrinsics.checkNotNullParameter(cachePolicy6, "networkCachePolicy");
        return new Options(context2, config3, colorSpace2, scale3, z, z2, z3, headers3, parameters3, cachePolicy4, cachePolicy5, cachePolicy6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Options) {
            Options options = (Options) obj;
            if (Intrinsics.areEqual((Object) this.context, (Object) options.context) && this.config == options.config && Intrinsics.areEqual((Object) this.colorSpace, (Object) options.colorSpace) && this.scale == options.scale && this.allowInexactSize == options.allowInexactSize && this.allowRgb565 == options.allowRgb565 && this.premultipliedAlpha == options.premultipliedAlpha && Intrinsics.areEqual((Object) this.headers, (Object) options.headers) && Intrinsics.areEqual((Object) this.parameters, (Object) options.parameters) && this.memoryCachePolicy == options.memoryCachePolicy && this.diskCachePolicy == options.diskCachePolicy && this.networkCachePolicy == options.networkCachePolicy) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.context.hashCode() * 31) + this.config.hashCode()) * 31;
        ColorSpace colorSpace2 = this.colorSpace;
        return ((((((((((((((((((hashCode + (colorSpace2 != null ? colorSpace2.hashCode() : 0)) * 31) + this.scale.hashCode()) * 31) + C$r8$backportedMethods$utility$Boolean$1$hashCode.hashCode(this.allowInexactSize)) * 31) + C$r8$backportedMethods$utility$Boolean$1$hashCode.hashCode(this.allowRgb565)) * 31) + C$r8$backportedMethods$utility$Boolean$1$hashCode.hashCode(this.premultipliedAlpha)) * 31) + this.headers.hashCode()) * 31) + this.parameters.hashCode()) * 31) + this.memoryCachePolicy.hashCode()) * 31) + this.diskCachePolicy.hashCode()) * 31) + this.networkCachePolicy.hashCode();
    }

    public String toString() {
        return "Options(context=" + this.context + ", config=" + this.config + ", colorSpace=" + this.colorSpace + ", scale=" + this.scale + ", " + "allowInexactSize=" + this.allowInexactSize + ", allowRgb565=" + this.allowRgb565 + ", premultipliedAlpha=" + this.premultipliedAlpha + ", " + "headers=" + this.headers + ", parameters=" + this.parameters + ", memoryCachePolicy=" + this.memoryCachePolicy + ", " + "diskCachePolicy=" + this.diskCachePolicy + ", networkCachePolicy=" + this.networkCachePolicy + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Options(android.content.Context r17, android.graphics.Bitmap.Config r18, android.graphics.ColorSpace r19, coil.size.Scale r20, boolean r21, boolean r22, okhttp3.Headers r23, coil.request.Parameters r24, coil.request.CachePolicy r25, coil.request.CachePolicy r26, coil.request.CachePolicy r27) {
        /*
            r16 = this;
            java.lang.String r0 = "context"
            r2 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "config"
            r3 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "scale"
            r5 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "headers"
            r9 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "parameters"
            r10 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "memoryCachePolicy"
            r11 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "diskCachePolicy"
            r12 = r26
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "networkCachePolicy"
            r13 = r27
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r8 = 0
            r14 = 64
            r15 = 0
            r1 = r16
            r4 = r19
            r6 = r21
            r7 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.decode.Options.<init>(android.content.Context, android.graphics.Bitmap$Config, android.graphics.ColorSpace, coil.size.Scale, boolean, boolean, okhttp3.Headers, coil.request.Parameters, coil.request.CachePolicy, coil.request.CachePolicy, coil.request.CachePolicy):void");
    }

    public static /* synthetic */ Options copy$default(Options options, Context context2, Bitmap.Config config2, ColorSpace colorSpace2, Scale scale2, boolean z, boolean z2, Headers headers2, Parameters parameters2, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, int i, Object obj) {
        Options options2 = options;
        int i2 = i;
        return options.copy((i2 & 1) != 0 ? options2.context : context2, (i2 & 2) != 0 ? options2.config : config2, (i2 & 4) != 0 ? options2.colorSpace : colorSpace2, (i2 & 8) != 0 ? options2.scale : scale2, (i2 & 16) != 0 ? options2.allowInexactSize : z, (i2 & 32) != 0 ? options2.allowRgb565 : z2, (i2 & 64) != 0 ? options2.headers : headers2, (i2 & 128) != 0 ? options2.parameters : parameters2, (i2 & 256) != 0 ? options2.memoryCachePolicy : cachePolicy, (i2 & 512) != 0 ? options2.diskCachePolicy : cachePolicy2, (i2 & 1024) != 0 ? options2.networkCachePolicy : cachePolicy3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    public final /* synthetic */ Options copy(Context context2, Bitmap.Config config2, ColorSpace colorSpace2, Scale scale2, boolean z, boolean z2, Headers headers2, Parameters parameters2, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Bitmap.Config config3 = config2;
        Intrinsics.checkNotNullParameter(config3, "config");
        Scale scale3 = scale2;
        Intrinsics.checkNotNullParameter(scale3, "scale");
        Headers headers3 = headers2;
        Intrinsics.checkNotNullParameter(headers3, "headers");
        Parameters parameters3 = parameters2;
        Intrinsics.checkNotNullParameter(parameters3, "parameters");
        CachePolicy cachePolicy4 = cachePolicy;
        Intrinsics.checkNotNullParameter(cachePolicy4, "memoryCachePolicy");
        CachePolicy cachePolicy5 = cachePolicy2;
        Intrinsics.checkNotNullParameter(cachePolicy5, "diskCachePolicy");
        CachePolicy cachePolicy6 = cachePolicy3;
        Intrinsics.checkNotNullParameter(cachePolicy6, "networkCachePolicy");
        return copy(context2, config3, colorSpace2, scale3, z, z2, this.premultipliedAlpha, headers3, parameters3, cachePolicy4, cachePolicy5, cachePolicy6);
    }
}
