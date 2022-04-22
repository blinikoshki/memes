package com.memes.plus.p040ui.create_post;

import com.memes.commons.media.MediaContent;
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
import kotlin.p017io.FilesKt;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.plus.ui.create_post.ExportPostViewModel$saveFile$2", mo26808f = "ExportPostViewModel.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.memes.plus.ui.create_post.ExportPostViewModel$saveFile$2 */
/* compiled from: ExportPostViewModel.kt */
final class ExportPostViewModel$saveFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ MediaContent $content;
    int label;
    final /* synthetic */ ExportPostViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExportPostViewModel$saveFile$2(ExportPostViewModel exportPostViewModel, MediaContent mediaContent, Continuation continuation) {
        super(2, continuation);
        this.this$0 = exportPostViewModel;
        this.$content = mediaContent;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new ExportPostViewModel$saveFile$2(this.this$0, this.$content, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ExportPostViewModel$saveFile$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            File access$getOutputTargetFile = this.this$0.getOutputTargetFile();
            if (access$getOutputTargetFile.exists()) {
                return access$getOutputTargetFile;
            }
            File asFile = this.$content.asFile();
            if (asFile == null || !asFile.exists()) {
                throw new RuntimeException("source file doesn't exist");
            }
            File access$getOutputTargetFile2 = this.this$0.getOutputTargetFile();
            FilesKt.copyTo$default(asFile, access$getOutputTargetFile2, true, 0, 4, (Object) null);
            StringBuilder sb = new StringBuilder();
            sb.append("Saved successfully at ");
            File parentFile = access$getOutputTargetFile2.getParentFile();
            if (parentFile == null || (str = parentFile.getAbsolutePath()) == null) {
                str = access$getOutputTargetFile2.getAbsolutePath();
            }
            sb.append(str);
            Timber.m300d(sb.toString(), new Object[0]);
            return access$getOutputTargetFile2;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
