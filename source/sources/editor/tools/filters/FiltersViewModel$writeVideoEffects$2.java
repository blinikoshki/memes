package editor.tools.filters;

import com.memes.commons.output.OutputExtension;
import com.memes.commons.output.OutputTarget;
import com.memes.commons.output.OutputTargetGenerator;
import editor.gpu.command.GpuFramework;
import editor.gpu.command.GpuFrameworkCommandResult;
import editor.gpu.command.GpuVideoCommand;
import editor.gpu.conflation.GlConflatedFilter;
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
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.tools.filters.FiltersViewModel$writeVideoEffects$2", mo26808f = "FiltersViewModel.kt", mo26809i = {}, mo26810l = {184}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: FiltersViewModel.kt */
final class FiltersViewModel$writeVideoEffects$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ MediaFilter $filter;
    final /* synthetic */ File $inputFile;
    int label;
    final /* synthetic */ FiltersViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FiltersViewModel$writeVideoEffects$2(FiltersViewModel filtersViewModel, File file, MediaFilter mediaFilter, Continuation continuation) {
        super(2, continuation);
        this.this$0 = filtersViewModel;
        this.$inputFile = file;
        this.$filter = mediaFilter;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new FiltersViewModel$writeVideoEffects$2(this.this$0, this.$inputFile, this.$filter, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FiltersViewModel$writeVideoEffects$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            GpuVideoCommand gpuVideoCommand = new GpuVideoCommand(this.$inputFile, OutputTargetGenerator.setDefaultOutputDestination$default(this.this$0.outputTargetGenerator, OutputTarget.FOLDER_EDITOR_CACHE, (String) null, OutputExtension.MP4, false, false, 26, (Object) null).getOutputFile());
            GlConflatedFilter appliedConflatedFilter = this.$filter.getAppliedConflatedFilter();
            if (appliedConflatedFilter != null) {
                gpuVideoCommand.setConflatedFilter(appliedConflatedFilter);
            } else {
                gpuVideoCommand.brightnessPercentage(MathKt.roundToInt(this.$filter.getAppliedBrightness()));
                gpuVideoCommand.contrastPercentage(MathKt.roundToInt(this.$filter.getAppliedContrast()));
                gpuVideoCommand.saturationPercentage(MathKt.roundToInt(this.$filter.getAppliedSaturation()));
                gpuVideoCommand.pixelationPercentage(MathKt.roundToInt(this.$filter.getAppliedPixelation()));
                gpuVideoCommand.sharpnessPercentage(MathKt.roundToInt(this.$filter.getAppliedSharpness()));
            }
            GpuFramework access$getGpuFramework$p = this.this$0.gpuFramework;
            this.label = 1;
            obj = access$getGpuFramework$p.execute(gpuVideoCommand, (Continuation<? super GpuFrameworkCommandResult>) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        GpuFrameworkCommandResult gpuFrameworkCommandResult = (GpuFrameworkCommandResult) obj;
        if (gpuFrameworkCommandResult.getSuccess()) {
            return gpuFrameworkCommandResult.getResultFile();
        }
        Timber.m300d("writeVideoEffects() ==> result.failure(" + gpuFrameworkCommandResult.getMessage() + ')', new Object[0]);
        return null;
    }
}
