package editor.tools.crop;

import com.memes.commons.media.MediaContent;
import editor.util.FfmpegCommandUtil;
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
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.tools.crop.CropViewModel$notifyVideoSource$1", mo26808f = "CropViewModel.kt", mo26809i = {}, mo26810l = {145}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: CropViewModel.kt */
final class CropViewModel$notifyVideoSource$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MediaContent $content;
    int label;
    final /* synthetic */ CropViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CropViewModel$notifyVideoSource$1(CropViewModel cropViewModel, MediaContent mediaContent, Continuation continuation) {
        super(2, continuation);
        this.this$0 = cropViewModel;
        this.$content = mediaContent;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new CropViewModel$notifyVideoSource$1(this.this$0, this.$content, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CropViewModel$notifyVideoSource$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.showBlockingProgress("Retrieving Thumbnail...");
            FfmpegCommandUtil access$getCommandUtil$p = this.this$0.getCommandUtil();
            File asFile = this.$content.asFile();
            this.label = 1;
            obj = access$getCommandUtil$p.executeThumbnailRetrievalCommand(asFile, "temp_video_thumbnail", this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        File file = (File) obj;
        this.this$0.hideBlockingProgress();
        if (file == null || !file.exists()) {
            this.this$0._cropError.setValue("Failed to retrieve thumbnail for cropping this media.");
            return Unit.INSTANCE;
        }
        this.this$0._imageSourceChanged.setValue(file);
        return Unit.INSTANCE;
    }
}
