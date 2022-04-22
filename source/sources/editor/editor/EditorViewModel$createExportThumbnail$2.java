package editor.editor;

import com.memes.commons.media.MediaFile;
import com.memes.commons.media.MediaType;
import editor.editor.export.command.ExportCommandSource;
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

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Lcom/memes/commons/media/MediaFile;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.editor.EditorViewModel$createExportThumbnail$2", mo26808f = "EditorViewModel.kt", mo26809i = {}, mo26810l = {90}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: EditorViewModel.kt */
final class EditorViewModel$createExportThumbnail$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MediaFile>, Object> {
    final /* synthetic */ ExportCommandSource $commandSource;
    int label;
    final /* synthetic */ EditorViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditorViewModel$createExportThumbnail$2(EditorViewModel editorViewModel, ExportCommandSource exportCommandSource, Continuation continuation) {
        super(2, continuation);
        this.this$0 = editorViewModel;
        this.$commandSource = exportCommandSource;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new EditorViewModel$createExportThumbnail$2(this.this$0, this.$commandSource, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((EditorViewModel$createExportThumbnail$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.$commandSource.setImageOutput(true);
            EditorViewModel editorViewModel = this.this$0;
            ExportCommandSource exportCommandSource = this.$commandSource;
            this.label = 1;
            obj = editorViewModel.executeFrameCommand(exportCommandSource, MediaType.PHOTO, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        MediaFile mediaFile = (MediaFile) obj;
        if (mediaFile.exists()) {
            return mediaFile;
        }
        throw new RuntimeException("Completed successfully, but output doesn't exist.");
    }
}
