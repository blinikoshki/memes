package editor.gpu.command;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H@"}, mo26107d2 = {"execute", "", "command", "Leditor/gpu/command/GpuVideoCommand;", "continuation", "Lkotlin/coroutines/Continuation;", "Leditor/gpu/command/GpuFrameworkCommandResult;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.gpu.command.GpuVideoCommandExecutor", mo26808f = "GpuVideoCommandExecutor.kt", mo26809i = {0}, mo26810l = {75}, mo26811m = "execute", mo26812n = {"command"}, mo26813s = {"L$0"})
/* compiled from: GpuVideoCommandExecutor.kt */
final class GpuVideoCommandExecutor$execute$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GpuVideoCommandExecutor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GpuVideoCommandExecutor$execute$1(GpuVideoCommandExecutor gpuVideoCommandExecutor, Continuation continuation) {
        super(continuation);
        this.this$0 = gpuVideoCommandExecutor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute((GpuVideoCommand) null, this);
    }
}
