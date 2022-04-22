package editor.tools.filters;

import android.graphics.Bitmap;
import com.memes.commons.media.MediaFile;
import com.memes.commons.media.MediaType;
import com.memes.commons.output.OutputExtension;
import com.memes.commons.output.OutputTarget;
import com.memes.commons.output.OutputTargetGenerator;
import editor.gpu.command.GpuFramework;
import editor.gpu.command.GpuFrameworkCommandResult;
import editor.gpu.command.GpuImageCommand;
import editor.gpu.gpuimage.GPUImage;
import editor.gpu.gpuimage.GPUImageView;
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
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Lcom/memes/commons/media/MediaFile;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.tools.filters.FiltersViewModel$writeImageEffects$2", mo26808f = "FiltersViewModel.kt", mo26809i = {0}, mo26810l = {136}, mo26811m = "invokeSuspend", mo26812n = {"bitmap"}, mo26813s = {"L$0"})
/* compiled from: FiltersViewModel.kt */
final class FiltersViewModel$writeImageEffects$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MediaFile>, Object> {
    final /* synthetic */ GPUImageView $gpuImageView;
    Object L$0;
    int label;
    final /* synthetic */ FiltersViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FiltersViewModel$writeImageEffects$2(FiltersViewModel filtersViewModel, GPUImageView gPUImageView, Continuation continuation) {
        super(2, continuation);
        this.this$0 = filtersViewModel;
        this.$gpuImageView = gPUImageView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new FiltersViewModel$writeImageEffects$2(this.this$0, this.$gpuImageView, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FiltersViewModel$writeImageEffects$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Bitmap bitmap;
        File resultFile;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            GPUImage gPUImage = this.$gpuImageView.getGPUImage();
            Intrinsics.checkNotNullExpressionValue(gPUImage, "gpuImageView.gpuImage");
            Bitmap bitmapWithFilterApplied = gPUImage.getBitmapWithFilterApplied();
            if (bitmapWithFilterApplied == null) {
                Timber.m303e("writeImageEffects() ==> failed to generate bitmap with effects", new Object[0]);
                return null;
            }
            GpuImageCommand gpuImageCommand = new GpuImageCommand(bitmapWithFilterApplied, OutputTargetGenerator.setDefaultOutputDestination$default(this.this$0.outputTargetGenerator, OutputTarget.FOLDER_EDITOR_CACHE, (String) null, OutputExtension.JPG, false, false, 26, (Object) null).getOutputFile());
            GpuFramework access$getGpuFramework$p = this.this$0.gpuFramework;
            this.L$0 = bitmapWithFilterApplied;
            this.label = 1;
            Object execute = access$getGpuFramework$p.execute(gpuImageCommand, (Continuation<? super GpuFrameworkCommandResult>) this);
            if (execute == coroutine_suspended) {
                return coroutine_suspended;
            }
            bitmap = bitmapWithFilterApplied;
            obj = execute;
        } else if (i == 1) {
            bitmap = (Bitmap) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        GpuFrameworkCommandResult gpuFrameworkCommandResult = (GpuFrameworkCommandResult) obj;
        if (!gpuFrameworkCommandResult.getSuccess() || (resultFile = gpuFrameworkCommandResult.getResultFile()) == null || !resultFile.exists()) {
            Timber.m303e("writeImageEffects() ==> result.failure(" + gpuFrameworkCommandResult.getMessage() + ')', new Object[0]);
            return null;
        }
        String absolutePath = resultFile.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
        return new MediaFile(absolutePath, bitmap.getWidth(), bitmap.getHeight(), MediaType.PHOTO);
    }
}
