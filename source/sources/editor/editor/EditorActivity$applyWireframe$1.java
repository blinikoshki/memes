package editor.editor;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.editor.EditorActivity$applyWireframe$1", mo26808f = "EditorActivity.kt", mo26809i = {}, mo26810l = {465, 467}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: EditorActivity.kt */
final class EditorActivity$applyWireframe$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $wireframeId;
    int label;
    final /* synthetic */ EditorActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditorActivity$applyWireframe$1(EditorActivity editorActivity, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = editorActivity;
        this.$wireframeId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new EditorActivity$applyWireframe$1(this.this$0, this.$wireframeId, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((EditorActivity$applyWireframe$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x003d
        L_0x0012:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x002c
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r7)
            r4 = 500(0x1f4, double:2.47E-321)
            r6.label = r3
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r4, r6)
            if (r7 != r0) goto L_0x002c
            return r0
        L_0x002c:
            editor.editor.EditorActivity r7 = r6.this$0
            editor.optionsui.layout.wireframes.WireframesViewModel r7 = r7.getWireframesViewModel()
            java.lang.String r1 = r6.$wireframeId
            r6.label = r2
            java.lang.Object r7 = r7.getWireframeById(r1, r6)
            if (r7 != r0) goto L_0x003d
            return r0
        L_0x003d:
            wireframe.language.Wireframe r7 = (wireframe.language.Wireframe) r7
            if (r7 == 0) goto L_0x004a
            editor.editor.EditorActivity r0 = r6.this$0
            editor.editor.editorframehost.frame.EditorFrame r0 = r0.getFrame()
            r0.applyWireframe(r7)
        L_0x004a:
            editor.editor.EditorActivity r7 = r6.this$0
            r7.showFrameTabsPage()
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.editor.EditorActivity$applyWireframe$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
