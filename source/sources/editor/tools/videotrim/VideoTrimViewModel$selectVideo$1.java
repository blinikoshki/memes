package editor.tools.videotrim;

import com.memes.commons.output.OutputExtension;
import com.memes.commons.output.OutputTarget;
import com.memes.commons.output.OutputTargetGenerator;
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

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.tools.videotrim.VideoTrimViewModel$selectVideo$1", mo26808f = "VideoTrimViewModel.kt", mo26809i = {}, mo26810l = {150}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: VideoTrimViewModel.kt */
final class VideoTrimViewModel$selectVideo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VideoTrimViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoTrimViewModel$selectVideo$1(VideoTrimViewModel videoTrimViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = videoTrimViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new VideoTrimViewModel$selectVideo$1(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((VideoTrimViewModel$selectVideo$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            File access$getInputFile$p = this.this$0.inputFile;
            if (access$getInputFile$p == null) {
                this.this$0._trimmerErrorLiveData.setValue("Failed to import this file. Reason: Input video doesn't exist.");
                return Unit.INSTANCE;
            }
            this.this$0.showBlockingProgress("Importing Video...");
            File outputFile = OutputTargetGenerator.setDefaultOutputDestination$default(this.this$0.outputTargetGenerator, OutputTarget.FOLDER_CACHE, (String) null, OutputExtension.MP4, false, false, 26, (Object) null).getOutputFile();
            FfmpegCommandUtil access$getCommandUtil$p = this.this$0.getCommandUtil();
            this.label = 1;
            obj = access$getCommandUtil$p.executeH264TranscodeCommand(access$getInputFile$p, outputFile, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        File file = (File) obj;
        this.this$0.hideBlockingProgress();
        if (file == null || !file.exists()) {
            this.this$0._trimmerErrorLiveData.setValue("Failed to import this file. Reason: Processed video doesn't exist.");
            return Unit.INSTANCE;
        }
        this.this$0._trimmerOutputLiveData.setValue(file);
        return Unit.INSTANCE;
    }
}
