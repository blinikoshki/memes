package editor.gpu.command;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0001R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\f\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, mo26107d2 = {"Leditor/gpu/command/GpuFramework;", "Leditor/gpu/command/GpuFrameworkProgressCallback;", "()V", "imageCommandExecutor", "Leditor/gpu/command/GpuImageCommandExecutor;", "getImageCommandExecutor", "()Leditor/gpu/command/GpuImageCommandExecutor;", "imageCommandExecutor$delegate", "Lkotlin/Lazy;", "onProgressListener", "videoCommandExecutor", "Leditor/gpu/command/GpuVideoCommandExecutor;", "getVideoCommandExecutor", "()Leditor/gpu/command/GpuVideoCommandExecutor;", "videoCommandExecutor$delegate", "execute", "Leditor/gpu/command/GpuFrameworkCommandResult;", "command", "Leditor/gpu/command/GpuImageCommand;", "(Leditor/gpu/command/GpuImageCommand;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Leditor/gpu/command/GpuVideoCommand;", "(Leditor/gpu/command/GpuVideoCommand;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onGpuFrameworkProgressAvailable", "", "progress", "", "setOnProgressListener", "listener", "gputool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GpuFramework.kt */
public final class GpuFramework implements GpuFrameworkProgressCallback {
    private final Lazy imageCommandExecutor$delegate = LazyKt.lazy(GpuFramework$imageCommandExecutor$2.INSTANCE);
    private GpuFrameworkProgressCallback onProgressListener;
    private final Lazy videoCommandExecutor$delegate = LazyKt.lazy(new GpuFramework$videoCommandExecutor$2(this));

    private final GpuImageCommandExecutor getImageCommandExecutor() {
        return (GpuImageCommandExecutor) this.imageCommandExecutor$delegate.getValue();
    }

    private final GpuVideoCommandExecutor getVideoCommandExecutor() {
        return (GpuVideoCommandExecutor) this.videoCommandExecutor$delegate.getValue();
    }

    public final void setOnProgressListener(GpuFrameworkProgressCallback gpuFrameworkProgressCallback) {
        Intrinsics.checkNotNullParameter(gpuFrameworkProgressCallback, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onProgressListener = gpuFrameworkProgressCallback;
    }

    public final Object execute(GpuImageCommand gpuImageCommand, Continuation<? super GpuFrameworkCommandResult> continuation) {
        return getImageCommandExecutor().execute(gpuImageCommand);
    }

    public final Object execute(GpuVideoCommand gpuVideoCommand, Continuation<? super GpuFrameworkCommandResult> continuation) {
        return getVideoCommandExecutor().execute(gpuVideoCommand, continuation);
    }

    public void onGpuFrameworkProgressAvailable(int i) {
        GpuFrameworkProgressCallback gpuFrameworkProgressCallback = this.onProgressListener;
        if (gpuFrameworkProgressCallback != null) {
            gpuFrameworkProgressCallback.onGpuFrameworkProgressAvailable(i);
        }
    }
}
