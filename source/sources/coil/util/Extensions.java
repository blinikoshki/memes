package coil.util;

import android.app.ActivityManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.StatFs;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import coil.base.C0920R;
import coil.bitmap.BitmapReferenceCounter;
import coil.decode.DataSource;
import coil.memory.MemoryCache;
import coil.memory.TargetDelegate;
import coil.memory.ViewTargetRequestManager;
import coil.request.ImageResult;
import coil.request.Parameters;
import coil.size.Scale;
import coil.size.Size;
import coil.target.Target;
import coil.target.ViewTarget;
import coil.transform.Transformation;
import com.facebook.internal.NativeProtocol;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;
import okhttp3.Call;
import okhttp3.Headers;
import org.apache.commons.lang3.ClassUtils;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000ì\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\b\u0010J\u001a\u00020&H\u0000\u001a\u0016\u0010K\u001a\u00020L2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020L0NH\u0000\u001a\f\u0010O\u001a\u00020P*\u00020QH\u0000\u001a\u0017\u0010R\u001a\u00020P*\u00020S2\b\u0010T\u001a\u0004\u0018\u00010UH\b\u001a\u0017\u0010R\u001a\u00020P*\u00020S2\b\u0010V\u001a\u0004\u0018\u00010\u001eH\b\u001a\u0018\u0010W\u001a\u0004\u0018\u00010\u0014*\u00020X2\b\u0010Y\u001a\u0004\u0018\u00010\u0014H\u0000\u001a\u001d\u0010Z\u001a\u00020[*\u00020\\2\u0006\u0010]\u001a\u00020\u00142\u0006\u0010^\u001a\u00020_H\n\u001a3\u0010Z\u001a\u00020[*\u00020\\2\u0006\u0010]\u001a\u00020\u00142\f\u0010`\u001a\b\u0012\u0004\u0012\u00020b0a2\u0006\u0010c\u001a\u00020d2\u0006\u0010^\u001a\u00020_H\n\u001a$\u0010e\u001a\u00020P*\u00020f2\u0012\u0010g\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020P0hH\bø\u0001\u0000\u001a\u000e\u0010i\u001a\u00020_*\u0004\u0018\u00010_H\u0000\u001a\u0016\u0010i\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u0004\u0018\u00010\u0001H\u0000\u001a\u001f\u0010j\u001a\u00020P*\u00020S2\b\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010k\u001a\u00020&H\b\"\u001c\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u001f\u0010\t\u001a\u00020\n*\u00020\u000b8À\u0002X\u0004¢\u0006\f\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u001f\u0010\u0010\u001a\u00020\n*\u00020\u000b8À\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000f\"\u0018\u0010\u0013\u001a\u00020\u0014*\u00020\u00158@X\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u0014*\u00020\u00198@X\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\"\u0018\u0010\u001c\u001a\u00020\u001d*\u00020\u001e8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \"\u0019\u0010!\u001a\u00020\u001d*\u00020\"8À\u0002X\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$\"\u0019\u0010%\u001a\u00020&*\u00020'8À\u0002X\u0004¢\u0006\u0006\u001a\u0004\b%\u0010(\"\u0019\u0010)\u001a\u00020&*\u00020*8À\u0002X\u0004¢\u0006\u0006\u001a\u0004\b)\u0010+\"\u0018\u0010,\u001a\u00020&*\u00020\u001e8@X\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-\"\u0019\u0010.\u001a\u00020/*\u0002008À\u0002X\u0004¢\u0006\u0006\u001a\u0004\b1\u00102\",\u00105\u001a\u0004\u0018\u000104*\u0002062\b\u00103\u001a\u0004\u0018\u0001048@@@X\u000e¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:\"\u0018\u0010;\u001a\u00020\u001d*\u00020<8@X\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>\"\u0018\u0010?\u001a\u00020@*\u00020'8@X\u0004¢\u0006\u0006\u001a\u0004\bA\u0010B\"\u0018\u0010C\u001a\u00020D*\u00020E8@X\u0004¢\u0006\u0006\u001a\u0004\bF\u0010G\"\u0018\u0010H\u001a\u00020\u001d*\u00020\u001e8@X\u0004¢\u0006\u0006\u001a\u0004\bI\u0010 \u0002\u0007\n\u0005\b20\u0001¨\u0006l"}, mo26107d2 = {"EMPTY_HEADERS", "Lokhttp3/Headers;", "kotlin.jvm.PlatformType", "getEMPTY_HEADERS", "()Lokhttp3/Headers;", "NULL_COLOR_SPACE", "Landroid/graphics/ColorSpace;", "getNULL_COLOR_SPACE", "()Landroid/graphics/ColorSpace;", "blockCountCompat", "", "Landroid/os/StatFs;", "getBlockCountCompat$annotations", "(Landroid/os/StatFs;)V", "getBlockCountCompat", "(Landroid/os/StatFs;)J", "blockSizeCompat", "getBlockSizeCompat$annotations", "getBlockSizeCompat", "emoji", "", "Lcoil/decode/DataSource;", "getEmoji", "(Lcoil/decode/DataSource;)Ljava/lang/String;", "firstPathSegment", "Landroid/net/Uri;", "getFirstPathSegment", "(Landroid/net/Uri;)Ljava/lang/String;", "height", "", "Landroid/graphics/drawable/Drawable;", "getHeight", "(Landroid/graphics/drawable/Drawable;)I", "identityHashCode", "", "getIdentityHashCode", "(Ljava/lang/Object;)I", "isAttachedToWindowCompat", "", "Landroid/view/View;", "(Landroid/view/View;)Z", "isLowRamDeviceCompat", "Landroid/app/ActivityManager;", "(Landroid/app/ActivityManager;)Z", "isVector", "(Landroid/graphics/drawable/Drawable;)Z", "job", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext;", "getJob", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Job;", "value", "Lcoil/request/ImageResult$Metadata;", "metadata", "Lcoil/memory/TargetDelegate;", "getMetadata", "(Lcoil/memory/TargetDelegate;)Lcoil/request/ImageResult$Metadata;", "setMetadata", "(Lcoil/memory/TargetDelegate;Lcoil/request/ImageResult$Metadata;)V", "nightMode", "Landroid/content/res/Configuration;", "getNightMode", "(Landroid/content/res/Configuration;)I", "requestManager", "Lcoil/memory/ViewTargetRequestManager;", "getRequestManager", "(Landroid/view/View;)Lcoil/memory/ViewTargetRequestManager;", "scale", "Lcoil/size/Scale;", "Landroid/widget/ImageView;", "getScale", "(Landroid/widget/ImageView;)Lcoil/size/Scale;", "width", "getWidth", "isMainThread", "lazyCallFactory", "Lokhttp3/Call$Factory;", "initializer", "Lkotlin/Function0;", "closeQuietly", "", "Ljava/io/Closeable;", "decrement", "Lcoil/bitmap/BitmapReferenceCounter;", "bitmap", "Landroid/graphics/Bitmap;", "drawable", "getMimeTypeFromUrl", "Landroid/webkit/MimeTypeMap;", "url", "invoke", "Lcoil/memory/MemoryCache$Key;", "Lcoil/memory/MemoryCache$Key$Companion;", "base", "parameters", "Lcoil/request/Parameters;", "transformations", "", "Lcoil/transform/Transformation;", "size", "Lcoil/size/Size;", "loop", "Ljava/util/concurrent/atomic/AtomicInteger;", "action", "Lkotlin/Function1;", "orEmpty", "setValid", "isValid", "coil-base_release"}, mo26108k = 2, mo26109mv = {1, 4, 1})
/* renamed from: coil.util.-Extensions  reason: invalid class name */
/* compiled from: Extensions.kt */
public final class Extensions {
    private static final Headers EMPTY_HEADERS = new Headers.Builder().build();
    private static final ColorSpace NULL_COLOR_SPACE = null;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 1})
    /* renamed from: coil.util.-Extensions$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DataSource.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[DataSource.MEMORY_CACHE.ordinal()] = 1;
            iArr[DataSource.MEMORY.ordinal()] = 2;
            iArr[DataSource.DISK.ordinal()] = 3;
            iArr[DataSource.NETWORK.ordinal()] = 4;
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ImageView.ScaleType.FIT_START.ordinal()] = 1;
            iArr2[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
            iArr2[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            iArr2[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 4;
        }
    }

    public static /* synthetic */ void getBlockCountCompat$annotations(StatFs statFs) {
    }

    public static /* synthetic */ void getBlockSizeCompat$annotations(StatFs statFs) {
    }

    public static final boolean isLowRamDeviceCompat(ActivityManager activityManager) {
        Intrinsics.checkNotNullParameter(activityManager, "$this$isLowRamDeviceCompat");
        return Build.VERSION.SDK_INT < 19 || activityManager.isLowRamDevice();
    }

    public static final long getBlockCountCompat(StatFs statFs) {
        Intrinsics.checkNotNullParameter(statFs, "$this$blockCountCompat");
        return Build.VERSION.SDK_INT >= 18 ? statFs.getBlockCountLong() : (long) statFs.getBlockCount();
    }

    public static final long getBlockSizeCompat(StatFs statFs) {
        Intrinsics.checkNotNullParameter(statFs, "$this$blockSizeCompat");
        return Build.VERSION.SDK_INT >= 18 ? statFs.getBlockSizeLong() : (long) statFs.getBlockSize();
    }

    public static final ViewTargetRequestManager getRequestManager(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$requestManager");
        Object tag = view.getTag(C0920R.C0923id.coil_request_manager);
        Object obj = null;
        if (!(tag instanceof ViewTargetRequestManager)) {
            tag = null;
        }
        ViewTargetRequestManager viewTargetRequestManager = (ViewTargetRequestManager) tag;
        if (viewTargetRequestManager == null) {
            synchronized (view) {
                Object tag2 = view.getTag(C0920R.C0923id.coil_request_manager);
                if (tag2 instanceof ViewTargetRequestManager) {
                    obj = tag2;
                }
                ViewTargetRequestManager viewTargetRequestManager2 = (ViewTargetRequestManager) obj;
                if (viewTargetRequestManager2 != null) {
                    viewTargetRequestManager = viewTargetRequestManager2;
                } else {
                    viewTargetRequestManager = new ViewTargetRequestManager();
                    view.addOnAttachStateChangeListener(viewTargetRequestManager);
                    view.setTag(C0920R.C0923id.coil_request_manager, viewTargetRequestManager);
                }
            }
        }
        return viewTargetRequestManager;
    }

    public static final boolean isAttachedToWindowCompat(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$isAttachedToWindowCompat");
        return ViewCompat.isAttachedToWindow(view);
    }

    public static final String getEmoji(DataSource dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "$this$emoji");
        int i = WhenMappings.$EnumSwitchMapping$0[dataSource.ordinal()];
        if (i == 1 || i == 2) {
            return Emoji.BRAIN;
        }
        if (i == 3) {
            return Emoji.FLOPPY;
        }
        if (i == 4) {
            return Emoji.CLOUD;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final int getWidth(Drawable drawable) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(drawable, "$this$width");
        BitmapDrawable bitmapDrawable = (BitmapDrawable) (!(drawable instanceof BitmapDrawable) ? null : drawable);
        return (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) ? drawable.getIntrinsicWidth() : bitmap.getWidth();
    }

    public static final int getHeight(Drawable drawable) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(drawable, "$this$height");
        BitmapDrawable bitmapDrawable = (BitmapDrawable) (!(drawable instanceof BitmapDrawable) ? null : drawable);
        return (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) ? drawable.getIntrinsicHeight() : bitmap.getHeight();
    }

    public static final boolean isVector(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "$this$isVector");
        return (drawable instanceof VectorDrawableCompat) || (Build.VERSION.SDK_INT > 21 && (drawable instanceof VectorDrawable));
    }

    public static final void closeQuietly(Closeable closeable) {
        Intrinsics.checkNotNullParameter(closeable, "$this$closeQuietly");
        try {
            closeable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final Scale getScale(ImageView imageView) {
        int i;
        Intrinsics.checkNotNullParameter(imageView, "$this$scale");
        ImageView.ScaleType scaleType = imageView.getScaleType();
        if (scaleType != null && ((i = WhenMappings.$EnumSwitchMapping$1[scaleType.ordinal()]) == 1 || i == 2 || i == 3 || i == 4)) {
            return Scale.FIT;
        }
        return Scale.FILL;
    }

    public static final Call.Factory lazyCallFactory(Function0<? extends Call.Factory> function0) {
        Intrinsics.checkNotNullParameter(function0, "initializer");
        return new Extensions$lazyCallFactory$1(LazyKt.lazy(function0));
    }

    public static final String getMimeTypeFromUrl(MimeTypeMap mimeTypeMap, String str) {
        Intrinsics.checkNotNullParameter(mimeTypeMap, "$this$getMimeTypeFromUrl");
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return null;
        }
        return mimeTypeMap.getMimeTypeFromExtension(StringsKt.substringAfterLast(StringsKt.substringAfterLast$default(StringsKt.substringBeforeLast$default(StringsKt.substringBeforeLast$default(str, '#', (String) null, 2, (Object) null), '?', (String) null, 2, (Object) null), '/', (String) null, 2, (Object) null), (char) ClassUtils.PACKAGE_SEPARATOR_CHAR, ""));
    }

    public static final String getFirstPathSegment(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "$this$firstPathSegment");
        List<String> pathSegments = uri.getPathSegments();
        Intrinsics.checkNotNullExpressionValue(pathSegments, "pathSegments");
        return (String) CollectionsKt.firstOrNull(pathSegments);
    }

    public static final int getNightMode(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "$this$nightMode");
        return configuration.uiMode & 48;
    }

    public static final ColorSpace getNULL_COLOR_SPACE() {
        return NULL_COLOR_SPACE;
    }

    public static final Headers getEMPTY_HEADERS() {
        return EMPTY_HEADERS;
    }

    public static final Headers orEmpty(Headers headers) {
        return headers != null ? headers : EMPTY_HEADERS;
    }

    public static final Parameters orEmpty(Parameters parameters) {
        return parameters != null ? parameters : Parameters.EMPTY;
    }

    public static final boolean isMainThread() {
        return Intrinsics.areEqual((Object) Looper.myLooper(), (Object) Looper.getMainLooper());
    }

    public static final int getIdentityHashCode(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "$this$identityHashCode");
        return System.identityHashCode(obj);
    }

    public static final void loop(AtomicInteger atomicInteger, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(atomicInteger, "$this$loop");
        Intrinsics.checkNotNullParameter(function1, NativeProtocol.WEB_DIALOG_ACTION);
        while (true) {
            function1.invoke(Integer.valueOf(atomicInteger.get()));
        }
    }

    public static final Job getJob(CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineContext, "$this$job");
        CoroutineContext.Element element = coroutineContext.get(Job.Key);
        Intrinsics.checkNotNull(element);
        return (Job) element;
    }

    public static final ImageResult.Metadata getMetadata(TargetDelegate targetDelegate) {
        View view;
        ViewTargetRequestManager requestManager;
        Intrinsics.checkNotNullParameter(targetDelegate, "$this$metadata");
        Target target = targetDelegate.getTarget();
        if (!(target instanceof ViewTarget)) {
            target = null;
        }
        ViewTarget viewTarget = (ViewTarget) target;
        if (viewTarget == null || (view = viewTarget.getView()) == null || (requestManager = getRequestManager(view)) == null) {
            return null;
        }
        return requestManager.getMetadata();
    }

    public static final void setMetadata(TargetDelegate targetDelegate, ImageResult.Metadata metadata) {
        View view;
        ViewTargetRequestManager requestManager;
        Intrinsics.checkNotNullParameter(targetDelegate, "$this$metadata");
        Target target = targetDelegate.getTarget();
        if (!(target instanceof ViewTarget)) {
            target = null;
        }
        ViewTarget viewTarget = (ViewTarget) target;
        if (viewTarget != null && (view = viewTarget.getView()) != null && (requestManager = getRequestManager(view)) != null) {
            requestManager.setMetadata(metadata);
        }
    }

    public static final MemoryCache.Key invoke(MemoryCache.Key.Companion companion, String str, Parameters parameters) {
        Intrinsics.checkNotNullParameter(companion, "$this$invoke");
        Intrinsics.checkNotNullParameter(str, TtmlNode.RUBY_BASE);
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return new MemoryCache.Key.Complex(str, CollectionsKt.emptyList(), (Size) null, parameters.cacheKeys());
    }

    public static final void decrement(BitmapReferenceCounter bitmapReferenceCounter, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmapReferenceCounter, "$this$decrement");
        if (bitmap != null) {
            bitmapReferenceCounter.decrement(bitmap);
        }
    }

    public static final void decrement(BitmapReferenceCounter bitmapReferenceCounter, Drawable drawable) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(bitmapReferenceCounter, "$this$decrement");
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
            bitmapReferenceCounter.decrement(bitmap);
        }
    }

    public static final void setValid(BitmapReferenceCounter bitmapReferenceCounter, Bitmap bitmap, boolean z) {
        Intrinsics.checkNotNullParameter(bitmapReferenceCounter, "$this$setValid");
        if (bitmap != null) {
            bitmapReferenceCounter.setValid(bitmap, z);
        }
    }

    public static final MemoryCache.Key invoke(MemoryCache.Key.Companion companion, String str, List<? extends Transformation> list, Size size, Parameters parameters) {
        Intrinsics.checkNotNullParameter(companion, "$this$invoke");
        Intrinsics.checkNotNullParameter(str, TtmlNode.RUBY_BASE);
        Intrinsics.checkNotNullParameter(list, "transformations");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        ArrayList arrayList = new ArrayList(list.size());
        int size2 = list.size();
        for (int i = 0; i < size2; i++) {
            arrayList.add(((Transformation) list.get(i)).key());
        }
        return new MemoryCache.Key.Complex(str, arrayList, size, parameters.cacheKeys());
    }
}
