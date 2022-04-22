package editor.mediaselection;

import com.memes.commons.media.MediaContent;
import com.memes.commons.output.OutputExtension;
import com.memes.commons.output.OutputTarget;
import com.memes.commons.output.OutputTargetGenerator;
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

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Lcom/memes/commons/media/MediaContent;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.mediaselection.MediaImportViewModel$download$2", mo26808f = "MediaImportViewModel.kt", mo26809i = {}, mo26810l = {160, 161}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: MediaImportViewModel.kt */
final class MediaImportViewModel$download$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MediaContent>, Object> {
    final /* synthetic */ MediaContent $content;
    int label;
    final /* synthetic */ MediaImportViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MediaImportViewModel$download$2(MediaImportViewModel mediaImportViewModel, MediaContent mediaContent, Continuation continuation) {
        super(2, continuation);
        this.this$0 = mediaImportViewModel;
        this.$content = mediaContent;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new MediaImportViewModel$download$2(this.this$0, this.$content, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((MediaImportViewModel$download$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String fromMediaType = OutputExtension.INSTANCE.fromMediaType(this.$content.contentType());
            File outputFile = OutputTargetGenerator.setDefaultOutputDestination$default(this.this$0.outputTargetGenerator, OutputTarget.FOLDER_EDITOR_SOURCE, (String) null, fromMediaType, false, false, 26, (Object) null).getOutputFile();
            MediaImportViewModel mediaImportViewModel = this.this$0;
            MediaContent mediaContent = this.$content;
            this.label = 1;
            obj = mediaImportViewModel.download(mediaContent, outputFile, fromMediaType, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return (MediaContent) obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        MediaImportViewModel mediaImportViewModel2 = this.this$0;
        this.label = 2;
        obj = mediaImportViewModel2.processDownloadedContent((MediaContent) obj, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        return (MediaContent) obj;
    }
}
