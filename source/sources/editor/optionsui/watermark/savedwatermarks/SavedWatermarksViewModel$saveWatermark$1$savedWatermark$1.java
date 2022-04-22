package editor.optionsui.watermark.savedwatermarks;

import editor.contentport.watermark.EditorWatermarkExporter;
import editor.editor.equipment.core.CoreEntity;
import editor.editor.equipment.media.MediaEntity;
import editor.editor.equipment.text.TextEntity;
import editor.optionsui.watermark.PhotoWatermark;
import editor.optionsui.watermark.TextWatermark;
import editor.optionsui.watermark.Watermark;
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

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Leditor/optionsui/watermark/Watermark;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.optionsui.watermark.savedwatermarks.SavedWatermarksViewModel$saveWatermark$1$savedWatermark$1", mo26808f = "SavedWatermarksViewModel.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: SavedWatermarksViewModel.kt */
final class SavedWatermarksViewModel$saveWatermark$1$savedWatermark$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Watermark>, Object> {
    int label;
    final /* synthetic */ SavedWatermarksViewModel$saveWatermark$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SavedWatermarksViewModel$saveWatermark$1$savedWatermark$1(SavedWatermarksViewModel$saveWatermark$1 savedWatermarksViewModel$saveWatermark$1, Continuation continuation) {
        super(2, continuation);
        this.this$0 = savedWatermarksViewModel$saveWatermark$1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new SavedWatermarksViewModel$saveWatermark$1$savedWatermark$1(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SavedWatermarksViewModel$saveWatermark$1$savedWatermark$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            EditorWatermarkExporter editorWatermarkExporter = new EditorWatermarkExporter(this.this$0.$frameEntity, this.this$0.this$0.getPortUtil());
            CoreEntity coreEntity = this.this$0.$entity;
            if (coreEntity instanceof TextEntity) {
                TextWatermark export = editorWatermarkExporter.export((TextEntity) this.this$0.$entity);
                this.this$0.this$0.savedWatermarksDao.insert(export);
                return export;
            } else if (coreEntity instanceof MediaEntity) {
                PhotoWatermark export2 = editorWatermarkExporter.export((MediaEntity) this.this$0.$entity);
                this.this$0.this$0.savedWatermarksDao.insert(export2);
                return export2;
            } else {
                throw new RuntimeException("Unknown entity to save as Watermark.");
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
