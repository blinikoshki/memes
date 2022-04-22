package editor.optionsui.addcontent.contentpicker;

import com.memes.commons.media.MediaContent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.optionsui.addcontent.contentpicker.ContentPickerViewModel$download$1", mo26808f = "ContentPickerViewModel.kt", mo26809i = {}, mo26810l = {78, 90}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: ContentPickerViewModel.kt */
final class ContentPickerViewModel$download$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MediaContent $content;
    int label;
    final /* synthetic */ ContentPickerViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContentPickerViewModel$download$1(ContentPickerViewModel contentPickerViewModel, MediaContent mediaContent, Continuation continuation) {
        super(2, continuation);
        this.this$0 = contentPickerViewModel;
        this.$content = mediaContent;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new ContentPickerViewModel$download$1(this.this$0, this.$content, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ContentPickerViewModel$download$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0090  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x007e
        L_0x0012:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0051
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r13)
            com.memes.commons.output.OutputExtension r13 = com.memes.commons.output.OutputExtension.INSTANCE
            com.memes.commons.media.MediaContent r1 = r12.$content
            int r1 = r1.contentType()
            java.lang.String r13 = r13.fromMediaType(r1)
            editor.optionsui.addcontent.contentpicker.ContentPickerViewModel r1 = r12.this$0
            com.memes.commons.output.OutputTargetGenerator r4 = r1.outputTargetGenerator
            r6 = 0
            r8 = 0
            r9 = 0
            r10 = 26
            r11 = 0
            java.lang.String r5 = "editor/source"
            r7 = r13
            com.memes.commons.output.OutputTargetGenerator r1 = com.memes.commons.output.OutputTargetGenerator.setDefaultOutputDestination$default(r4, r5, r6, r7, r8, r9, r10, r11)
            java.io.File r1 = r1.getOutputFile()
            editor.optionsui.addcontent.contentpicker.ContentPickerViewModel r4 = r12.this$0
            com.memes.commons.media.MediaContent r5 = r12.$content
            r12.label = r3
            java.lang.Object r13 = r4.download(r5, r1, r13, r12)
            if (r13 != r0) goto L_0x0051
            return r0
        L_0x0051:
            com.memes.commons.media.MediaContent r13 = (com.memes.commons.media.MediaContent) r13
            if (r13 != 0) goto L_0x005d
            editor.optionsui.addcontent.contentpicker.ContentPickerViewModel r0 = r12.this$0
            r0.notifyDownloadComplete(r13)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x005d:
            int r1 = r13.contentType()
            r3 = 1235(0x4d3, float:1.73E-42)
            if (r1 == r3) goto L_0x0073
            editor.optionsui.addcontent.contentpicker.ContentPickerViewModel r0 = r12.this$0
            com.memes.commons.media.MediaContent r13 = r0.processFinalMediaContent(r13)
            editor.optionsui.addcontent.contentpicker.ContentPickerViewModel r0 = r12.this$0
            r0.notifyDownloadComplete(r13)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x0073:
            editor.optionsui.addcontent.contentpicker.ContentPickerViewModel r1 = r12.this$0
            r12.label = r2
            java.lang.Object r13 = r1.convertGifToVideo(r13, r12)
            if (r13 != r0) goto L_0x007e
            return r0
        L_0x007e:
            com.memes.commons.media.MediaContent r13 = (com.memes.commons.media.MediaContent) r13
            if (r13 == 0) goto L_0x0090
            editor.optionsui.addcontent.contentpicker.ContentPickerViewModel r0 = r12.this$0
            com.memes.commons.media.MediaContent r13 = r0.processFinalMediaContent(r13)
            editor.optionsui.addcontent.contentpicker.ContentPickerViewModel r0 = r12.this$0
            r0.notifyDownloadComplete(r13)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x0090:
            editor.optionsui.addcontent.contentpicker.ContentPickerViewModel r13 = r12.this$0
            r0 = 0
            r13.notifyDownloadComplete(r0)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.optionsui.addcontent.contentpicker.ContentPickerViewModel$download$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
