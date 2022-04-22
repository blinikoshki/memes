package editor.util;

import com.memes.commons.media.MediaType;
import com.memes.commons.output.OutputExtension;
import com.memes.commons.output.OutputTargetGenerator;
import editor.ffmpeg.core.MultimediaFramework;
import editor.ffmpeg.core.command.MultimediaCommand;
import editor.ffmpeg.core.command.MultimediaCommandResult;
import editor.tools.crop.CropBounds;
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
@DebugMetadata(mo26807c = "editor.util.FfmpegCommandUtil$executeCropCommand$2", mo26808f = "FfmpegCommandUtil.kt", mo26809i = {0}, mo26810l = {177}, mo26811m = "invokeSuspend", mo26812n = {"outputFile"}, mo26813s = {"L$0"})
/* compiled from: FfmpegCommandUtil.kt */
final class FfmpegCommandUtil$executeCropCommand$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ CropBounds $cropBounds;
    final /* synthetic */ File $inputFile;
    final /* synthetic */ int $mediaType;
    Object L$0;
    int label;
    final /* synthetic */ FfmpegCommandUtil this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FfmpegCommandUtil$executeCropCommand$2(FfmpegCommandUtil ffmpegCommandUtil, int i, File file, CropBounds cropBounds, Continuation continuation) {
        super(2, continuation);
        this.this$0 = ffmpegCommandUtil;
        this.$mediaType = i;
        this.$inputFile = file;
        this.$cropBounds = cropBounds;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new FfmpegCommandUtil$executeCropCommand$2(this.this$0, this.$mediaType, this.$inputFile, this.$cropBounds, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FfmpegCommandUtil$executeCropCommand$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        File file;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.ffmpegFramework.loadIfNeeded();
            if (MediaType.INSTANCE.isPhoto(this.$mediaType)) {
                str = OutputExtension.PNG;
            } else if (MediaType.INSTANCE.isGif(this.$mediaType)) {
                str = OutputExtension.GIF;
            } else if (MediaType.INSTANCE.isVideo(this.$mediaType) || MediaType.INSTANCE.isGifVideo(this.$mediaType)) {
                str = OutputExtension.MP4;
            } else {
                throw new RuntimeException("Unable to determine crop-output extension for mediatype=" + this.$mediaType);
            }
            File outputFile = OutputTargetGenerator.setDefaultOutputDestination$default(this.this$0.outputTargetGenerator, this.this$0.getOutputFolder(), (String) null, str, false, false, 26, (Object) null).getOutputFile();
            MultimediaCommand createCropMediaCommand = FfmpegCommandUtil.Command.INSTANCE.createCropMediaCommand(this.$inputFile, this.$cropBounds, outputFile);
            MultimediaFramework access$getFfmpegFramework$p = this.this$0.ffmpegFramework;
            this.L$0 = outputFile;
            this.label = 1;
            Object execute = access$getFfmpegFramework$p.execute(createCropMediaCommand, this);
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
        return !((MultimediaCommandResult) obj).getSuccess() ? this.$inputFile : file;
    }
}
