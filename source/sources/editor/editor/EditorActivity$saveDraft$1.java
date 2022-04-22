package editor.editor;

import com.memes.commons.media.MediaFile;
import editor.editor.dashboard.drafts.EditorDraftsViewModel;
import editor.editor.editorframehost.frame.EditorFrame;
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

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.editor.EditorActivity$saveDraft$1", mo26808f = "EditorActivity.kt", mo26809i = {}, mo26810l = {553, 555}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: EditorActivity.kt */
final class EditorActivity$saveDraft$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ EditorActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditorActivity$saveDraft$1(EditorActivity editorActivity, Continuation continuation) {
        super(2, continuation);
        this.this$0 = editorActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new EditorActivity$saveDraft$1(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((EditorActivity$saveDraft$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getGeneratorViewModel().showBlockingProgress("Creating Thumbnail...");
            EditorActivity editorActivity = this.this$0;
            this.label = 1;
            obj = EditorActivity.createExportCommandSource$default(editorActivity, false, this, 1, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getGeneratorViewModel().hideBlockingProgress();
            EditorDraftsViewModel access$getDraftsViewModel$p = this.this$0.getDraftsViewModel();
            String value = EditorSession.INSTANCE.getValue();
            EditorFrame access$getFrame = this.this$0.getFrame();
            String absolutePath = ((MediaFile) obj).getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "draftThumbnailFile.absolutePath");
            access$getDraftsViewModel$p.saveDraft(value, access$getFrame, absolutePath);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        EditorViewModel access$getGeneratorViewModel$p = this.this$0.getGeneratorViewModel();
        this.label = 2;
        obj = access$getGeneratorViewModel$p.createExportThumbnail((ExportCommandSource) obj, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.this$0.getGeneratorViewModel().hideBlockingProgress();
        EditorDraftsViewModel access$getDraftsViewModel$p2 = this.this$0.getDraftsViewModel();
        String value2 = EditorSession.INSTANCE.getValue();
        EditorFrame access$getFrame2 = this.this$0.getFrame();
        String absolutePath2 = ((MediaFile) obj).getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath2, "draftThumbnailFile.absolutePath");
        access$getDraftsViewModel$p2.saveDraft(value2, access$getFrame2, absolutePath2);
        return Unit.INSTANCE;
    }
}
