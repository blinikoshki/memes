package editor.tools.videotrim;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Build;
import java.util.ArrayList;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, mo26107d2 = {"<anonymous>", "", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.tools.videotrim.VideoThumbnailRetriever$retrieve$2", mo26808f = "VideoThumbnailRetriever.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: VideoThumbnailRetriever.kt */
final class VideoThumbnailRetriever$retrieve$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Bitmap>>, Object> {
    final /* synthetic */ int $thumbnailCount;
    final /* synthetic */ int $thumbnailSize;
    int label;
    final /* synthetic */ VideoThumbnailRetriever this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoThumbnailRetriever$retrieve$2(VideoThumbnailRetriever videoThumbnailRetriever, int i, int i2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = videoThumbnailRetriever;
        this.$thumbnailCount = i;
        this.$thumbnailSize = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new VideoThumbnailRetriever$retrieve$2(this.this$0, this.$thumbnailCount, this.$thumbnailSize, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((VideoThumbnailRetriever$retrieve$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Bitmap bitmap;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CharSequence access$getFilePath$p = this.this$0.filePath;
            if (access$getFilePath$p == null || StringsKt.isBlank(access$getFilePath$p)) {
                return null;
            }
            this.this$0.getMediaMetadataRetriever().setDataSource(this.this$0.filePath);
            String extractMetadata = this.this$0.getMediaMetadataRetriever().extractMetadata(9);
            Intrinsics.checkNotNullExpressionValue(extractMetadata, "mediaMetadataRetriever.e…METADATA_KEY_DURATION\n\t\t)");
            Long longOrNull = StringsKt.toLongOrNull(extractMetadata);
            if (longOrNull == null) {
                Timber.m300d("Unable to retrieve video duration", new Object[0]);
                return null;
            }
            long longValue = (longOrNull.longValue() * 1000) / ((long) this.$thumbnailCount);
            List arrayList = new ArrayList();
            int i = this.$thumbnailCount;
            for (int i2 = 0; i2 < i; i2++) {
                if (Build.VERSION.SDK_INT >= 27) {
                    int i3 = this.$thumbnailSize;
                    bitmap = this.this$0.getMediaMetadataRetriever().getScaledFrameAtTime(((long) i2) * longValue, 3, i3, i3);
                } else {
                    bitmap = this.this$0.getMediaMetadataRetriever().getFrameAtTime(((long) i2) * longValue, 3);
                }
                if (bitmap != null) {
                    int i4 = this.$thumbnailSize;
                    bitmap = ThumbnailUtils.extractThumbnail(bitmap, i4, i4);
                }
                if (bitmap != null) {
                    arrayList.add(bitmap);
                }
            }
            this.this$0.getMediaMetadataRetriever().release();
            return arrayList;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
