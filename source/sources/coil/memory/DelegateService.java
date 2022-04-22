package coil.memory;

import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import coil.EventListener;
import coil.ImageLoader;
import coil.bitmap.BitmapReferenceCounter;
import coil.request.ImageRequest;
import coil.target.PoolableViewTarget;
import coil.target.Target;
import coil.target.ViewTarget;
import coil.util.Extensions;
import coil.util.Logger;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\"\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo26107d2 = {"Lcoil/memory/DelegateService;", "", "imageLoader", "Lcoil/ImageLoader;", "referenceCounter", "Lcoil/bitmap/BitmapReferenceCounter;", "logger", "Lcoil/util/Logger;", "(Lcoil/ImageLoader;Lcoil/bitmap/BitmapReferenceCounter;Lcoil/util/Logger;)V", "createRequestDelegate", "Lcoil/memory/RequestDelegate;", "request", "Lcoil/request/ImageRequest;", "targetDelegate", "Lcoil/memory/TargetDelegate;", "job", "Lkotlinx/coroutines/Job;", "createTargetDelegate", "target", "Lcoil/target/Target;", "type", "", "eventListener", "Lcoil/EventListener;", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: DelegateService.kt */
public final class DelegateService {
    private final ImageLoader imageLoader;
    private final Logger logger;
    private final BitmapReferenceCounter referenceCounter;

    public DelegateService(ImageLoader imageLoader2, BitmapReferenceCounter bitmapReferenceCounter, Logger logger2) {
        Intrinsics.checkNotNullParameter(imageLoader2, "imageLoader");
        Intrinsics.checkNotNullParameter(bitmapReferenceCounter, "referenceCounter");
        this.imageLoader = imageLoader2;
        this.referenceCounter = bitmapReferenceCounter;
        this.logger = logger2;
    }

    public final TargetDelegate createTargetDelegate(Target target, int i, EventListener eventListener) {
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("Invalid type.".toString());
            } else if (target == null) {
                return new InvalidatableEmptyTargetDelegate(this.referenceCounter);
            } else {
                return new InvalidatableTargetDelegate(target, this.referenceCounter, eventListener, this.logger);
            }
        } else if (target == null) {
            return EmptyTargetDelegate.INSTANCE;
        } else {
            if (target instanceof PoolableViewTarget) {
                return new PoolableTargetDelegate((PoolableViewTarget) target, this.referenceCounter, eventListener, this.logger);
            }
            return new InvalidatableTargetDelegate(target, this.referenceCounter, eventListener, this.logger);
        }
    }

    public final RequestDelegate createRequestDelegate(ImageRequest imageRequest, TargetDelegate targetDelegate, Job job) {
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Intrinsics.checkNotNullParameter(targetDelegate, "targetDelegate");
        Intrinsics.checkNotNullParameter(job, "job");
        Lifecycle lifecycle = imageRequest.getLifecycle();
        Target target = imageRequest.getTarget();
        if (target instanceof ViewTarget) {
            RequestDelegate viewTargetRequestDelegate = new ViewTargetRequestDelegate(this.imageLoader, imageRequest, targetDelegate, job);
            lifecycle.addObserver(viewTargetRequestDelegate);
            if (target instanceof LifecycleObserver) {
                LifecycleObserver lifecycleObserver = (LifecycleObserver) target;
                lifecycle.removeObserver(lifecycleObserver);
                lifecycle.addObserver(lifecycleObserver);
            }
            ViewTarget viewTarget = (ViewTarget) target;
            Extensions.getRequestManager(viewTarget.getView()).setCurrentRequest((ViewTargetRequestDelegate) viewTargetRequestDelegate);
            if (ViewCompat.isAttachedToWindow(viewTarget.getView())) {
                return viewTargetRequestDelegate;
            }
            Extensions.getRequestManager(viewTarget.getView()).onViewDetachedFromWindow(viewTarget.getView());
            return viewTargetRequestDelegate;
        }
        RequestDelegate baseRequestDelegate = new BaseRequestDelegate(lifecycle, job);
        lifecycle.addObserver(baseRequestDelegate);
        return baseRequestDelegate;
    }
}
