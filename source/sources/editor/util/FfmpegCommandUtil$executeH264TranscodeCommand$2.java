package editor.util;

import editor.ffmpeg.core.MultimediaFramework;
import editor.ffmpeg.core.command.MultimediaCommand;
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

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.util.FfmpegCommandUtil$executeH264TranscodeCommand$2", mo26808f = "FfmpegCommandUtil.kt", mo26809i = {}, mo26810l = {204}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: FfmpegCommandUtil.kt */
final class FfmpegCommandUtil$executeH264TranscodeCommand$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ File $inputFile;
    final /* synthetic */ File $outputFile;
    int label;
    final /* synthetic */ FfmpegCommandUtil this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FfmpegCommandUtil$executeH264TranscodeCommand$2(FfmpegCommandUtil ffmpegCommandUtil, File file, File file2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = ffmpegCommandUtil;
        this.$inputFile = file;
        this.$outputFile = file2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new FfmpegCommandUtil$executeH264TranscodeCommand$2(this.this$0, this.$inputFile, this.$outputFile, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FfmpegCommandUtil$executeH264TranscodeCommand$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.ffmpegFramework.loadIfNeeded();
            MultimediaCommand createH264TranscodeCommand = FfmpegCommandUtil.Command.INSTANCE.createH264TranscodeCommand(this.$inputFile, this.$outputFile);
            MultimediaFramework access$getFfmpegFramework$p = this.this$0.ffmpegFramework;
            this.label = 1;
            obj = access$getFfmpegFramework$p.execute(createH264TranscodeCommand, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!((MultimediaCommandResult) obj).getSuccess()) {
            return null;
        }
        return this.$outputFile;
    }
}
