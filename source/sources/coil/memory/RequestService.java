package coil.memory;

import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import androidx.core.view.ViewCompat;
import coil.decode.Options;
import coil.request.CachePolicy;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.NullRequestDataException;
import coil.size.Size;
import coil.target.Target;
import coil.target.ViewTarget;
import coil.util.Bitmaps;
import coil.util.Logger;
import coil.util.Requests;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0003J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000eH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo26107d2 = {"Lcoil/memory/RequestService;", "", "logger", "Lcoil/util/Logger;", "(Lcoil/util/Logger;)V", "hardwareBitmapService", "Lcoil/memory/HardwareBitmapService;", "errorResult", "Lcoil/request/ErrorResult;", "request", "Lcoil/request/ImageRequest;", "throwable", "", "isConfigValidForHardware", "", "requestedConfig", "Landroid/graphics/Bitmap$Config;", "isConfigValidForHardwareAllocation", "size", "Lcoil/size/Size;", "isConfigValidForTransformations", "options", "Lcoil/decode/Options;", "isOnline", "Companion", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: RequestService.kt */
public final class RequestService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final Bitmap.Config[] VALID_TRANSFORMATION_CONFIGS = (Build.VERSION.SDK_INT >= 26 ? new Bitmap.Config[]{Bitmap.Config.ARGB_8888, Bitmap.Config.RGBA_F16} : new Bitmap.Config[]{Bitmap.Config.ARGB_8888});
    private final HardwareBitmapService hardwareBitmapService = HardwareBitmapService.Companion.invoke();
    private final Logger logger;

    public RequestService(Logger logger2) {
        this.logger = logger2;
    }

    public final ErrorResult errorResult(ImageRequest imageRequest, Throwable th) {
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Intrinsics.checkNotNullParameter(th, "throwable");
        return new ErrorResult(th instanceof NullRequestDataException ? imageRequest.getFallback() : imageRequest.getError(), imageRequest, th);
    }

    public final Options options(ImageRequest imageRequest, Size size, boolean z) {
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Intrinsics.checkNotNullParameter(size, "size");
        Bitmap.Config bitmapConfig = isConfigValidForTransformations(imageRequest) && isConfigValidForHardwareAllocation(imageRequest, size) ? imageRequest.getBitmapConfig() : Bitmap.Config.ARGB_8888;
        return new Options(imageRequest.getContext(), bitmapConfig, imageRequest.getColorSpace(), imageRequest.getScale(), Requests.getAllowInexactSize(imageRequest), imageRequest.getAllowRgb565() && imageRequest.getTransformations().isEmpty() && bitmapConfig != Bitmap.Config.ALPHA_8, imageRequest.getPremultipliedAlpha(), imageRequest.getHeaders(), imageRequest.getParameters(), imageRequest.getMemoryCachePolicy(), imageRequest.getDiskCachePolicy(), z ? imageRequest.getNetworkCachePolicy() : CachePolicy.DISABLED);
    }

    public final boolean isConfigValidForHardware(ImageRequest imageRequest, Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Intrinsics.checkNotNullParameter(config, "requestedConfig");
        if (!Bitmaps.isHardware(config)) {
            return true;
        }
        if (!imageRequest.getAllowHardware()) {
            return false;
        }
        Target target = imageRequest.getTarget();
        if (target instanceof ViewTarget) {
            View view = ((ViewTarget) target).getView();
            if (ViewCompat.isAttachedToWindow(view) && !view.isHardwareAccelerated()) {
                return false;
            }
        }
        return true;
    }

    private final boolean isConfigValidForHardwareAllocation(ImageRequest imageRequest, Size size) {
        return isConfigValidForHardware(imageRequest, imageRequest.getBitmapConfig()) && this.hardwareBitmapService.allowHardware(size, this.logger);
    }

    private final boolean isConfigValidForTransformations(ImageRequest imageRequest) {
        return imageRequest.getTransformations().isEmpty() || ArraysKt.contains((T[]) VALID_TRANSFORMATION_CONFIGS, imageRequest.getBitmapConfig());
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcoil/memory/RequestService$Companion;", "", "()V", "VALID_TRANSFORMATION_CONFIGS", "", "Landroid/graphics/Bitmap$Config;", "[Landroid/graphics/Bitmap$Config;", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: RequestService.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
