package coil.memory;

import android.graphics.Bitmap;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import coil.request.ImageResult;
import coil.util.Extensions;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import editor.ffmpeg.api.FfmpegCommand;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0007J\b\u0010\u001e\u001a\u00020\nH\u0003J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0017J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0017J\u001c\u0010#\u001a\u0004\u0018\u00010\u00062\u0006\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010&\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u000eH\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\u000e@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, mo26107d2 = {"Lcoil/memory/ViewTargetRequestManager;", "Landroid/view/View$OnAttachStateChangeListener;", "()V", "bitmaps", "Landroidx/collection/SimpleArrayMap;", "", "Landroid/graphics/Bitmap;", "currentRequest", "Lcoil/memory/ViewTargetRequestDelegate;", "<set-?>", "Ljava/util/UUID;", "currentRequestId", "getCurrentRequestId", "()Ljava/util/UUID;", "Lkotlinx/coroutines/Job;", "currentRequestJob", "getCurrentRequestJob", "()Lkotlinx/coroutines/Job;", "isRestart", "", "metadata", "Lcoil/request/ImageResult$Metadata;", "getMetadata", "()Lcoil/request/ImageResult$Metadata;", "setMetadata", "(Lcoil/request/ImageResult$Metadata;)V", "pendingClear", "skipAttach", "clearCurrentRequest", "", "newRequestId", "onViewAttachedToWindow", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "put", "tag", "bitmap", "setCurrentRequest", "request", "setCurrentRequestJob", "job", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: ViewTargetRequestManager.kt */
public final class ViewTargetRequestManager implements View.OnAttachStateChangeListener {
    private final SimpleArrayMap<Object, Bitmap> bitmaps = new SimpleArrayMap<>();
    private ViewTargetRequestDelegate currentRequest;
    private volatile UUID currentRequestId;
    private volatile Job currentRequestJob;
    private boolean isRestart;
    private volatile ImageResult.Metadata metadata;
    private volatile Job pendingClear;
    private boolean skipAttach = true;

    public final UUID getCurrentRequestId() {
        return this.currentRequestId;
    }

    public final Job getCurrentRequestJob() {
        return this.currentRequestJob;
    }

    public final ImageResult.Metadata getMetadata() {
        return this.metadata;
    }

    public final void setMetadata(ImageResult.Metadata metadata2) {
        this.metadata = metadata2;
    }

    public final Bitmap put(Object obj, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(obj, ViewHierarchyConstants.TAG_KEY);
        if (bitmap != null) {
            return this.bitmaps.put(obj, bitmap);
        }
        return this.bitmaps.remove(obj);
    }

    public final void setCurrentRequest(ViewTargetRequestDelegate viewTargetRequestDelegate) {
        if (this.isRestart) {
            this.isRestart = false;
        } else {
            Job job = this.pendingClear;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.pendingClear = null;
        }
        ViewTargetRequestDelegate viewTargetRequestDelegate2 = this.currentRequest;
        if (viewTargetRequestDelegate2 != null) {
            viewTargetRequestDelegate2.dispose();
        }
        this.currentRequest = viewTargetRequestDelegate;
        this.skipAttach = true;
    }

    public final UUID setCurrentRequestJob(Job job) {
        Intrinsics.checkNotNullParameter(job, "job");
        UUID newRequestId = newRequestId();
        this.currentRequestId = newRequestId;
        this.currentRequestJob = job;
        return newRequestId;
    }

    public final void clearCurrentRequest() {
        this.currentRequestId = null;
        this.currentRequestJob = null;
        Job job = this.pendingClear;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.pendingClear = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), (CoroutineStart) null, new ViewTargetRequestManager$clearCurrentRequest$1(this, (Continuation) null), 2, (Object) null);
    }

    public void onViewAttachedToWindow(View view) {
        Intrinsics.checkNotNullParameter(view, FfmpegCommand.VIDEO_STREAM);
        if (this.skipAttach) {
            this.skipAttach = false;
            return;
        }
        ViewTargetRequestDelegate viewTargetRequestDelegate = this.currentRequest;
        if (viewTargetRequestDelegate != null) {
            this.isRestart = true;
            viewTargetRequestDelegate.restart();
        }
    }

    public void onViewDetachedFromWindow(View view) {
        Intrinsics.checkNotNullParameter(view, FfmpegCommand.VIDEO_STREAM);
        this.skipAttach = false;
        ViewTargetRequestDelegate viewTargetRequestDelegate = this.currentRequest;
        if (viewTargetRequestDelegate != null) {
            viewTargetRequestDelegate.dispose();
        }
    }

    private final UUID newRequestId() {
        UUID uuid = this.currentRequestId;
        if (uuid != null && this.isRestart && Extensions.isMainThread()) {
            return uuid;
        }
        UUID randomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(randomUUID, "UUID.randomUUID()");
        return randomUUID;
    }
}
