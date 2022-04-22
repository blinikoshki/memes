package editor.util;

import com.memes.commons.output.OutputExtension;
import com.memes.commons.output.OutputTargetGenerator;
import editor.ffmpeg.api.FfmpegCommand;
import editor.ffmpeg.core.command.MultimediaCommandResult;
import editor.util.FfmpegCommandUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.util.FfmpegCommandUtil$executeReverseVideoCommand$2", mo26808f = "FfmpegCommandUtil.kt", mo26809i = {0}, mo26810l = {137}, mo26811m = "invokeSuspend", mo26812n = {"outputFile"}, mo26813s = {"L$0"})
/* compiled from: FfmpegCommandUtil.kt */
final class FfmpegCommandUtil$executeReverseVideoCommand$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ File $inputFile;
    Object L$0;
    int label;
    final /* synthetic */ FfmpegCommandUtil this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FfmpegCommandUtil$executeReverseVideoCommand$2(FfmpegCommandUtil ffmpegCommandUtil, File file, Continuation continuation) {
        super(2, continuation);
        this.this$0 = ffmpegCommandUtil;
        this.$inputFile = file;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new FfmpegCommandUtil$executeReverseVideoCommand$2(this.this$0, this.$inputFile, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FfmpegCommandUtil$executeReverseVideoCommand$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        File file;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.ffmpegFramework.loadIfNeeded();
            File outputFile = OutputTargetGenerator.setDefaultOutputDestination$default(this.this$0.outputTargetGenerator, this.this$0.getOutputFolder(), (String) null, OutputExtension.MP4, false, false, 26, (Object) null).getOutputFile();
            FfmpegCommand createReverseVideoCommand = FfmpegCommandUtil.Command.INSTANCE.createReverseVideoCommand(this.$inputFile, outputFile);
            this.L$0 = outputFile;
            this.label = 1;
            Object execute = this.this$0.ffmpegFramework.execute(createReverseVideoCommand, this);
            if (execute == coroutine_suspended) {
                return coroutine_suspended;
            }
            file = outputFile;
            obj = execute;
        } else if (i == 1) {
            file = (File) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        MultimediaCommandResult multimediaCommandResult = (MultimediaCommandResult) obj;
        if (multimediaCommandResult.getSuccess()) {
            return file;
        }
        throw new RuntimeException("Command Failed. " + multimediaCommandResult.getMessage());
    }
}
