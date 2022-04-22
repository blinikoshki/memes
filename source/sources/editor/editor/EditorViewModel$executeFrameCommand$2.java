package editor.editor;

import com.memes.commons.media.MediaFile;
import editor.editor.export.command.ExportCommandSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Lcom/memes/commons/media/MediaFile;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.editor.EditorViewModel$executeFrameCommand$2", mo26808f = "EditorViewModel.kt", mo26809i = {0, 1, 1}, mo26810l = {123, 134, 143}, mo26811m = "invokeSuspend", mo26812n = {"exportCommandOutputFile", "outputFile", "loopInputFile"}, mo26813s = {"L$0", "L$0", "L$1"})
/* compiled from: EditorViewModel.kt */
final class EditorViewModel$executeFrameCommand$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MediaFile>, Object> {
    final /* synthetic */ ExportCommandSource $commandSource;
    final /* synthetic */ int $mediaType;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ EditorViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditorViewModel$executeFrameCommand$2(EditorViewModel editorViewModel, int i, ExportCommandSource exportCommandSource, Continuation continuation) {
        super(2, continuation);
        this.this$0 = editorViewModel;
        this.$mediaType = i;
        this.$commandSource = exportCommandSource;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new EditorViewModel$executeFrameCommand$2(this.this$0, this.$mediaType, this.$commandSource, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((EditorViewModel$executeFrameCommand$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00db A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            r18 = this;
            r8 = r18
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r8.label
            r1 = 1232(0x4d0, float:1.726E-42)
            r2 = 3
            r3 = 2
            r4 = 1
            if (r0 == 0) goto L_0x003f
            if (r0 == r4) goto L_0x0035
            if (r0 == r3) goto L_0x0024
            if (r0 != r2) goto L_0x001c
            kotlin.ResultKt.throwOnFailure(r19)
            r0 = r19
            goto L_0x00dc
        L_0x001c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0024:
            java.lang.Object r0 = r8.L$1
            java.io.File r0 = (java.io.File) r0
            java.lang.Object r1 = r8.L$0
            java.io.File r1 = (java.io.File) r1
            kotlin.ResultKt.throwOnFailure(r19)
            r3 = r0
            r0 = r1
            r1 = r19
            goto L_0x00b0
        L_0x0035:
            java.lang.Object r0 = r8.L$0
            java.io.File r0 = (java.io.File) r0
            kotlin.ResultKt.throwOnFailure(r19)
            r4 = r19
            goto L_0x0094
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r19)
            editor.editor.EditorViewModel r0 = r8.this$0
            editor.ffmpeg.core.MultimediaFramework r0 = r0.ffmpegFramework
            r0.loadIfNeeded()
            editor.editor.EditorViewModel r0 = r8.this$0
            com.memes.commons.output.OutputTargetGenerator r10 = r0.outputTargetGenerator
            r12 = 0
            int r0 = r8.$mediaType
            r5 = 1231(0x4cf, float:1.725E-42)
            java.lang.String r6 = ".mp4"
            if (r0 == r5) goto L_0x005c
            r13 = r6
            goto L_0x005f
        L_0x005c:
            java.lang.String r0 = ".jpg"
            r13 = r0
        L_0x005f:
            r14 = 0
            r15 = 0
            r16 = 26
            r17 = 0
            java.lang.String r11 = "editor/output"
            com.memes.commons.output.OutputTargetGenerator r0 = com.memes.commons.output.OutputTargetGenerator.setDefaultOutputDestination$default(r10, r11, r12, r13, r14, r15, r16, r17)
            java.io.File r0 = r0.getOutputFile()
            editor.editor.export.command.ExportCommand r5 = new editor.editor.export.command.ExportCommand
            editor.editor.export.command.ExportCommandSource r6 = r8.$commandSource
            java.lang.String r7 = r0.getAbsolutePath()
            java.lang.String r10 = "exportCommandOutputFile.absolutePath"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r10)
            r5.<init>(r6, r7)
            editor.ffmpeg.core.command.MultimediaCommand r5 = r5.create()
            editor.editor.EditorViewModel r6 = r8.this$0
            editor.ffmpeg.core.MultimediaFramework r6 = r6.ffmpegFramework
            r8.L$0 = r0
            r8.label = r4
            java.lang.Object r4 = r6.execute(r5, r8)
            if (r4 != r9) goto L_0x0094
            return r9
        L_0x0094:
            editor.ffmpeg.core.command.MultimediaCommandResult r4 = (editor.ffmpeg.core.command.MultimediaCommandResult) r4
            boolean r5 = r4.getSuccess()
            if (r5 == 0) goto L_0x0103
            int r4 = r8.$mediaType
            if (r4 != r1) goto L_0x00de
            editor.editor.EditorViewModel r1 = r8.this$0
            r8.L$0 = r0
            r8.L$1 = r0
            r8.label = r3
            java.lang.Object r1 = r1.findContentDuration(r4, r0, r8)
            if (r1 != r9) goto L_0x00af
            return r9
        L_0x00af:
            r3 = r0
        L_0x00b0:
            java.lang.Number r1 = (java.lang.Number) r1
            long r4 = r1.longValue()
            r6 = 3500(0xdac, double:1.729E-320)
            r10 = 1
            int r1 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r1 <= 0) goto L_0x00bf
            goto L_0x00de
        L_0x00bf:
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 < 0) goto L_0x00de
            editor.editor.EditorViewModel r0 = r8.this$0
            int r1 = r8.$mediaType
            r6 = 3500(0xdac, double:1.729E-320)
            r10 = 0
            r8.L$0 = r10
            r8.L$1 = r10
            r8.label = r2
            r2 = r3
            r3 = r4
            r5 = r6
            r7 = r18
            java.lang.Object r0 = r0.loopVideoIfRequired(r1, r2, r3, r5, r7)
            if (r0 != r9) goto L_0x00dc
            return r9
        L_0x00dc:
            java.io.File r0 = (java.io.File) r0
        L_0x00de:
            com.memes.commons.media.MediaFile r1 = new com.memes.commons.media.MediaFile
            java.lang.String r0 = r0.getPath()
            java.lang.String r2 = "outputFile.path"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            editor.editor.export.command.ExportCommandSource r2 = r8.$commandSource
            editor.editor.export.regions.FileRegion r2 = r2.getContainer()
            int r2 = r2.getWidth()
            editor.editor.export.command.ExportCommandSource r3 = r8.$commandSource
            editor.editor.export.regions.FileRegion r3 = r3.getContainer()
            int r3 = r3.getHeight()
            int r4 = r8.$mediaType
            r1.<init>(r0, r2, r3, r4)
            return r1
        L_0x0103:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Framework Error. "
            r1.append(r2)
            java.lang.String r2 = r4.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.editor.EditorViewModel$executeFrameCommand$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
