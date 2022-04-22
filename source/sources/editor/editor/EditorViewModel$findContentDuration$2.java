package editor.editor;

import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.editor.EditorViewModel$findContentDuration$2", mo26808f = "EditorViewModel.kt", mo26809i = {}, mo26810l = {267}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: EditorViewModel.kt */
final class EditorViewModel$findContentDuration$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    final /* synthetic */ File $contentFile;
    final /* synthetic */ int $contentType;
    int label;
    final /* synthetic */ EditorViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditorViewModel$findContentDuration$2(EditorViewModel editorViewModel, int i, File file, Continuation continuation) {
        super(2, continuation);
        this.this$0 = editorViewModel;
        this.$contentType = i;
        this.$contentFile = file;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new EditorViewModel$findContentDuration$2(this.this$0, this.$contentType, this.$contentFile, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((EditorViewModel$findContentDuration$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        if (r6 != 1237) goto L_0x0085;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0019
            if (r1 != r4) goto L_0x0011
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x006d
        L_0x0011:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0019:
            kotlin.ResultKt.throwOnFailure(r6)
            int r6 = r5.$contentType
            r1 = 1232(0x4d0, float:1.726E-42)
            if (r6 == r1) goto L_0x005c
            r1 = 1235(0x4d3, float:1.73E-42)
            if (r6 == r1) goto L_0x002b
            r1 = 1237(0x4d5, float:1.733E-42)
            if (r6 == r1) goto L_0x005c
            goto L_0x0085
        L_0x002b:
            java.io.File r6 = r5.$contentFile
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r6)
            java.io.InputStream r0 = (java.io.InputStream) r0
            android.graphics.Movie r6 = android.graphics.Movie.decodeStream(r0)
            int r0 = r6.width()
            if (r0 <= 0) goto L_0x0045
            int r0 = r6.height()
            if (r0 <= 0) goto L_0x0045
            goto L_0x0046
        L_0x0045:
            r4 = 0
        L_0x0046:
            if (r4 == 0) goto L_0x004e
            int r6 = r6.duration()
            long r2 = (long) r6
            goto L_0x0085
        L_0x004e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "Failed to decode GIF."
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            throw r6
        L_0x005c:
            editor.editor.EditorViewModel r6 = r5.this$0
            editor.util.FfmpegCommandUtil r6 = r6.getCommandUtil()
            java.io.File r1 = r5.$contentFile
            r5.label = r4
            java.lang.Object r6 = r6.executeMetadataRetrievalCommand(r1, r5)
            if (r6 != r0) goto L_0x006d
            return r0
        L_0x006d:
            editor.ffmpeg.core.info.DataPacket r6 = (editor.ffmpeg.core.info.DataPacket) r6
            if (r6 == 0) goto L_0x0085
            editor.ffmpeg.core.info.InputMetadata r6 = r6.getInputMetadata()
            if (r6 == 0) goto L_0x0085
            long r0 = r6.getDurationMillis()
            java.lang.Long r6 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r0)
            if (r6 == 0) goto L_0x0085
            long r2 = r6.longValue()
        L_0x0085:
            java.lang.Long r6 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.editor.EditorViewModel$findContentDuration$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
