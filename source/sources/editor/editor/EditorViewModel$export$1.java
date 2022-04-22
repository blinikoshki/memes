package editor.editor;

import editor.editor.export.command.ExportCommandSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.editor.EditorViewModel$export$1", mo26808f = "EditorViewModel.kt", mo26809i = {0}, mo26810l = {74, 78}, mo26811m = "invokeSuspend", mo26812n = {"mediaType"}, mo26813s = {"I$0"})
/* compiled from: EditorViewModel.kt */
final class EditorViewModel$export$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ExportCommandSource $commandSource;
    int I$0;
    int label;
    final /* synthetic */ EditorViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditorViewModel$export$1(EditorViewModel editorViewModel, ExportCommandSource exportCommandSource, Continuation continuation) {
        super(2, continuation);
        this.this$0 = editorViewModel;
        this.$commandSource = exportCommandSource;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new EditorViewModel$export$1(this.this$0, this.$commandSource, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((EditorViewModel$export$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0020
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0061
        L_0x0012:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001a:
            int r1 = r6.I$0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0054
        L_0x0020:
            kotlin.ResultKt.throwOnFailure(r7)
            editor.editor.export.command.ExportCommandSource r7 = r6.$commandSource
            boolean r7 = r7.isImageOutput()
            if (r7 == 0) goto L_0x0030
            r7 = 1231(0x4cf, float:1.725E-42)
            r1 = 1231(0x4cf, float:1.725E-42)
            goto L_0x0034
        L_0x0030:
            r7 = 1232(0x4d0, float:1.726E-42)
            r1 = 1232(0x4d0, float:1.726E-42)
        L_0x0034:
            editor.editor.EditorViewModel r7 = r6.this$0
            java.lang.String r4 = "Creating meme.."
            r7.showBlockingProgress(r4)
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
            editor.editor.EditorViewModel$export$1$1 r4 = new editor.editor.EditorViewModel$export$1$1
            r5 = 0
            r4.<init>(r6, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r6.I$0 = r1
            r6.label = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r4, r6)
            if (r7 != r0) goto L_0x0054
            return r0
        L_0x0054:
            editor.editor.EditorViewModel r7 = r6.this$0
            editor.editor.export.command.ExportCommandSource r3 = r6.$commandSource
            r6.label = r2
            java.lang.Object r7 = r7.executeFrameCommand(r3, r1, r6)
            if (r7 != r0) goto L_0x0061
            return r0
        L_0x0061:
            com.memes.commons.media.MediaFile r7 = (com.memes.commons.media.MediaFile) r7
            boolean r0 = r7.exists()
            if (r0 == 0) goto L_0x007a
            editor.editor.EditorViewModel r0 = r6.this$0
            r0.hideBlockingProgress()
            editor.editor.EditorViewModel r0 = r6.this$0
            com.memes.commons.util.SingleLiveEvent r0 = r0._exported
            r0.setValue(r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x007a:
            java.lang.RuntimeException r7 = new java.lang.RuntimeException
            java.lang.String r0 = "Completed successfully, but output doesn't exist."
            r7.<init>(r0)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.editor.EditorViewModel$export$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
