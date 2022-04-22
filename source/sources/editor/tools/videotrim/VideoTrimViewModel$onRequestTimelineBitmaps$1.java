package editor.tools.videotrim;

import java.io.File;
import java.util.List;
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
@DebugMetadata(mo26807c = "editor.tools.videotrim.VideoTrimViewModel$onRequestTimelineBitmaps$1", mo26808f = "VideoTrimViewModel.kt", mo26809i = {}, mo26810l = {333}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: VideoTrimViewModel.kt */
final class VideoTrimViewModel$onRequestTimelineBitmaps$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $count;
    final /* synthetic */ File $file;
    final /* synthetic */ int $size;
    int label;
    final /* synthetic */ VideoTrimViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoTrimViewModel$onRequestTimelineBitmaps$1(VideoTrimViewModel videoTrimViewModel, File file, int i, int i2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = videoTrimViewModel;
        this.$file = file;
        this.$count = i;
        this.$size = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new VideoTrimViewModel$onRequestTimelineBitmaps$1(this.this$0, this.$file, this.$count, this.$size, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((VideoTrimViewModel$onRequestTimelineBitmaps$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            VideoThumbnailRetriever access$getThumbnailRetriever$p = this.this$0.thumbnailRetriever;
            String absolutePath = this.$file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
            VideoThumbnailRetriever videoFilePath = access$getThumbnailRetriever$p.setVideoFilePath(absolutePath);
            int i2 = this.$count;
            int i3 = this.$size;
            this.label = 1;
            obj = videoFilePath.retrieve(i2, i3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0._timelineBitmapsLiveData.setValue((List) obj);
        return Unit.INSTANCE;
    }
}
