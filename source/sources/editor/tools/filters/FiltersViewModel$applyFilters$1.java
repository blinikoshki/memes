package editor.tools.filters;

import editor.gpu.gpuimage.GPUImageView;
import editor.tools.filters.conflation.FilterRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.tools.filters.FiltersViewModel$applyFilters$1", mo26808f = "FiltersViewModel.kt", mo26809i = {0, 0, 1, 1}, mo26810l = {74, 83}, mo26811m = "invokeSuspend", mo26812n = {"content", "filter", "content", "filter"}, mo26813s = {"L$0", "L$1", "L$0", "L$1"})
/* compiled from: FiltersViewModel.kt */
final class FiltersViewModel$applyFilters$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GPUImageView $gpuImageView;
    final /* synthetic */ FilterRequest $request;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ FiltersViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FiltersViewModel$applyFilters$1(FiltersViewModel filtersViewModel, FilterRequest filterRequest, GPUImageView gPUImageView, Continuation continuation) {
        super(2, continuation);
        this.this$0 = filtersViewModel;
        this.$request = filterRequest;
        this.$gpuImageView = gPUImageView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new FiltersViewModel$applyFilters$1(this.this$0, this.$request, this.$gpuImageView, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FiltersViewModel$applyFilters$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x002f
            if (r1 == r3) goto L_0x0023
            if (r1 != r2) goto L_0x001b
            java.lang.Object r0 = r11.L$1
            editor.tools.filters.MediaFilter r0 = (editor.tools.filters.MediaFilter) r0
            java.lang.Object r1 = r11.L$0
            com.memes.commons.media.MediaContent r1 = (com.memes.commons.media.MediaContent) r1
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00a0
        L_0x001b:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0023:
            java.lang.Object r0 = r11.L$1
            editor.tools.filters.MediaFilter r0 = (editor.tools.filters.MediaFilter) r0
            java.lang.Object r1 = r11.L$0
            com.memes.commons.media.MediaContent r1 = (com.memes.commons.media.MediaContent) r1
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0062
        L_0x002f:
            kotlin.ResultKt.throwOnFailure(r12)
            editor.tools.filters.FiltersViewModel r12 = r11.this$0
            java.lang.String r1 = "Applying Filters..."
            r12.showBlockingProgress(r1)
            editor.tools.filters.conflation.FilterRequest r12 = r11.$request
            com.memes.commons.media.MediaContent r1 = r12.getContent()
            editor.tools.filters.conflation.FilterRequest r12 = r11.$request
            editor.tools.filters.MediaFilter r12 = r12.getFilter()
            java.io.File r4 = r1.asFile()
            boolean r5 = r1.isPhoto()
            if (r5 == 0) goto L_0x007d
            editor.tools.filters.FiltersViewModel r2 = r11.this$0
            editor.gpu.gpuimage.GPUImageView r4 = r11.$gpuImageView
            r11.L$0 = r1
            r11.L$1 = r12
            r11.label = r3
            java.lang.Object r2 = r2.writeImageEffects(r4, r11)
            if (r2 != r0) goto L_0x0060
            return r0
        L_0x0060:
            r0 = r12
            r12 = r2
        L_0x0062:
            com.memes.commons.media.MediaFile r12 = (com.memes.commons.media.MediaFile) r12
            if (r12 == 0) goto L_0x007a
            boolean r2 = r12.exists()
            if (r2 == 0) goto L_0x007a
            int r2 = r12.getWidth()
            r1.width(r2)
            int r2 = r12.getHeight()
            r1.height(r2)
        L_0x007a:
            java.io.File r12 = (java.io.File) r12
            goto L_0x00a2
        L_0x007d:
            boolean r3 = r1.isVideo()
            if (r3 != 0) goto L_0x008f
            boolean r3 = r1.isGifVideo()
            if (r3 == 0) goto L_0x008a
            goto L_0x008f
        L_0x008a:
            r0 = 0
            r10 = r0
            r0 = r12
            r12 = r10
            goto L_0x00a2
        L_0x008f:
            editor.tools.filters.FiltersViewModel r3 = r11.this$0
            r11.L$0 = r1
            r11.L$1 = r12
            r11.label = r2
            java.lang.Object r2 = r3.writeVideoEffects(r4, r12, r11)
            if (r2 != r0) goto L_0x009e
            return r0
        L_0x009e:
            r0 = r12
            r12 = r2
        L_0x00a0:
            java.io.File r12 = (java.io.File) r12
        L_0x00a2:
            editor.tools.filters.FiltersViewModel r2 = r11.this$0
            r2.hideBlockingProgress()
            if (r12 != 0) goto L_0x00b7
            editor.tools.filters.FiltersViewModel r12 = r11.this$0
            androidx.lifecycle.MutableLiveData r12 = r12._filterError
            java.lang.String r0 = "Failed to apply filter effects."
            r12.setValue(r0)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x00b7:
            boolean r2 = r12.exists()
            if (r2 != 0) goto L_0x00cb
            editor.tools.filters.FiltersViewModel r12 = r11.this$0
            androidx.lifecycle.MutableLiveData r12 = r12._filterError
            java.lang.String r0 = "Failed to find filter-output file"
            r12.setValue(r0)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x00cb:
            editor.tools.filters.conflation.FilterResult r8 = new editor.tools.filters.conflation.FilterResult
            editor.tools.filters.conflation.FilterRequest r2 = r11.$request
            java.lang.String r9 = r2.getIdentifier()
            r2 = 0
            java.lang.String r3 = r12.getAbsolutePath()
            java.lang.String r12 = "filterOutputFile.absolutePath"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r12)
            r4 = 0
            r5 = 0
            r6 = 13
            r7 = 0
            com.memes.commons.media.MediaContent r12 = com.memes.commons.media.MediaContent.copy$default(r1, r2, r3, r4, r5, r6, r7)
            r8.<init>(r9, r12, r0)
            editor.tools.filters.FiltersViewModel r12 = r11.this$0
            androidx.lifecycle.MutableLiveData r12 = r12._filterOutput
            r12.setValue(r8)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.tools.filters.FiltersViewModel$applyFilters$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
