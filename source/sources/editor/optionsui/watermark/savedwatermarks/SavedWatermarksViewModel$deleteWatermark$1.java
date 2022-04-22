package editor.optionsui.watermark.savedwatermarks;

import com.memes.commons.output.OutputTarget;
import editor.custom.liveevent.LiveEvent;
import editor.optionsui.watermark.PhotoWatermark;
import editor.optionsui.watermark.TextWatermark;
import editor.optionsui.watermark.Watermark;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.optionsui.watermark.savedwatermarks.SavedWatermarksViewModel$deleteWatermark$1", mo26808f = "SavedWatermarksViewModel.kt", mo26809i = {}, mo26810l = {154}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: SavedWatermarksViewModel.kt */
final class SavedWatermarksViewModel$deleteWatermark$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Watermark $watermark;
    int label;
    final /* synthetic */ SavedWatermarksViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SavedWatermarksViewModel$deleteWatermark$1(SavedWatermarksViewModel savedWatermarksViewModel, Watermark watermark, Continuation continuation) {
        super(2, continuation);
        this.this$0 = savedWatermarksViewModel;
        this.$watermark = watermark;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new SavedWatermarksViewModel$deleteWatermark$1(this.this$0, this.$watermark, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SavedWatermarksViewModel$deleteWatermark$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getIO(), new C49011(this, (Continuation) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.availableWatermarks.remove(this.$watermark);
        this.this$0._watermarkDeleted.setValue(new LiveEvent(this.$watermark));
        return Unit.INSTANCE;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
    @DebugMetadata(mo26807c = "editor.optionsui.watermark.savedwatermarks.SavedWatermarksViewModel$deleteWatermark$1$1", mo26808f = "SavedWatermarksViewModel.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
    /* renamed from: editor.optionsui.watermark.savedwatermarks.SavedWatermarksViewModel$deleteWatermark$1$1 */
    /* compiled from: SavedWatermarksViewModel.kt */
    static final class C49011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SavedWatermarksViewModel$deleteWatermark$1 this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new C49011(this.this$0, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((C49011) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                String uid = this.this$0.$watermark.getUid();
                if (!this.this$0.this$0.getPortUtil().deleteFolder(OutputTarget.FOLDER_WATERMARKS + '/' + uid)) {
                    Timber.m303e("Unable to delete watermark directory: " + uid, new Object[0]);
                }
                Watermark watermark = this.this$0.$watermark;
                if (watermark instanceof TextWatermark) {
                    this.this$0.this$0.savedWatermarksDao.deleteTextWatermarkById(uid);
                } else if (watermark instanceof PhotoWatermark) {
                    this.this$0.this$0.savedWatermarksDao.deletePhotoWatermarkById(uid);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
