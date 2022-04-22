package editor.gpu.command;

import editor.gpu.command.GpuCommandResult;
import editor.gpu.gpuvideo.composer.GPUMp4Composer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u0005\u001a\u00020\u00032\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f¸\u0006\u0000"}, mo26107d2 = {"editor/gpu/command/GpuVideoCommandExecutor$executeInternal$2$callback$1", "Leditor/gpu/gpuvideo/composer/GPUMp4Composer$Listener;", "onCanceled", "", "onCompleted", "onFailed", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onProgress", "progress", "", "gputool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: editor.gpu.command.GpuVideoCommandExecutor$executeInternal$$inlined$suspendCoroutine$lambda$1 */
/* compiled from: GpuVideoCommandExecutor.kt */
public final class C4741x3243d386 implements GPUMp4Composer.Listener {
    final /* synthetic */ GPUMp4Composer $composer$inlined;
    final /* synthetic */ Continuation $continuation;
    final /* synthetic */ GpuVideoCommandExecutor this$0;

    C4741x3243d386(Continuation continuation, GpuVideoCommandExecutor gpuVideoCommandExecutor, GPUMp4Composer gPUMp4Composer) {
        this.$continuation = continuation;
        this.this$0 = gpuVideoCommandExecutor;
        this.$composer$inlined = gPUMp4Composer;
    }

    public void onProgress(double d) {
        this.this$0.callback.onGpuFrameworkProgressAvailable((int) (d * ((double) 100.0f)));
    }

    public void onCompleted() {
        this.this$0.callback.onGpuFrameworkProgressAvailable(100);
        Continuation continuation = this.$continuation;
        GpuCommandResult.Success success = GpuCommandResult.Success.INSTANCE;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m1029constructorimpl(success));
    }

    public void onFailed(Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append("Gpu Composing Failed. ");
        sb.append(exc != null ? exc.getMessage() : null);
        String sb2 = sb.toString();
        Continuation continuation = this.$continuation;
        GpuCommandResult.Failure failure = new GpuCommandResult.Failure(sb2);
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m1029constructorimpl(failure));
    }

    public void onCanceled() {
        Continuation continuation = this.$continuation;
        GpuCommandResult.Failure failure = new GpuCommandResult.Failure("Gpu Composing Cancelled.");
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m1029constructorimpl(failure));
    }
}
