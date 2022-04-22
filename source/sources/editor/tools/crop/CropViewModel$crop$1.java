package editor.tools.crop;

import com.memes.commons.media.MediaContent;
import editor.editor.equipment.media.content.CropSpec;
import editor.util.FfmpegCommandUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.tools.crop.CropViewModel$crop$1", mo26808f = "CropViewModel.kt", mo26809i = {}, mo26810l = {201}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: CropViewModel.kt */
final class CropViewModel$crop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MediaContent $content;
    final /* synthetic */ CropBounds $cropBounds;
    final /* synthetic */ File $file;
    int label;
    final /* synthetic */ CropViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CropViewModel$crop$1(CropViewModel cropViewModel, File file, MediaContent mediaContent, CropBounds cropBounds, Continuation continuation) {
        super(2, continuation);
        this.this$0 = cropViewModel;
        this.$file = file;
        this.$content = mediaContent;
        this.$cropBounds = cropBounds;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new CropViewModel$crop$1(this.this$0, this.$file, this.$content, this.$cropBounds, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CropViewModel$crop$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.showBlockingProgress("Cropping...");
            FfmpegCommandUtil access$getCommandUtil$p = this.this$0.getCommandUtil();
            File file = this.$file;
            int contentType = this.$content.contentType();
            CropBounds cropBounds = this.$cropBounds;
            this.label = 1;
            obj = access$getCommandUtil$p.executeCropCommand(file, contentType, cropBounds, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        File file2 = (File) obj;
        this.this$0.hideBlockingProgress();
        if (!file2.exists()) {
            this.this$0._cropError.setValue("Failed to find crop-output file");
            return Unit.INSTANCE;
        }
        if (!(this.$cropBounds.getRotationDegrees() == 90 || this.$cropBounds.getRotationDegrees() == 270)) {
            z = false;
        }
        CropBounds cropBounds2 = this.$cropBounds;
        int cropHeight = z ? cropBounds2.cropHeight() : cropBounds2.cropWidth();
        CropBounds cropBounds3 = this.$cropBounds;
        int cropWidth = z ? cropBounds3.cropWidth() : cropBounds3.cropHeight();
        int contentType2 = this.$content.contentType();
        String path = file2.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "outputFile.path");
        this.this$0._cropOutput.setValue(new CropSpec(new MediaContent(contentType2, path, Boxing.boxInt(cropHeight), Boxing.boxInt(cropWidth)), this.$cropBounds));
        return Unit.INSTANCE;
    }
}
