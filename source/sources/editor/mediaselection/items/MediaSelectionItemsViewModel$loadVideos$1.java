package editor.mediaselection.items;

import androidx.lifecycle.MutableLiveData;
import editor.mediaselection.localmedia.LocalMedia;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.mediaselection.items.MediaSelectionItemsViewModel$loadVideos$1", mo26808f = "MediaSelectionItemsViewModel.kt", mo26809i = {}, mo26810l = {157}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: MediaSelectionItemsViewModel.kt */
final class MediaSelectionItemsViewModel$loadVideos$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ MediaSelectionItemsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MediaSelectionItemsViewModel$loadVideos$1(MediaSelectionItemsViewModel mediaSelectionItemsViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = mediaSelectionItemsViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new MediaSelectionItemsViewModel$loadVideos$1(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((MediaSelectionItemsViewModel$loadVideos$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        MutableLiveData mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableLiveData access$get_videos$p = this.this$0._videos;
            this.L$0 = access$get_videos$p;
            this.label = 1;
            Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new C48241(this, (Continuation) null), this);
            if (withContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData = access$get_videos$p;
            obj = withContext;
        } else if (i == 1) {
            mutableLiveData = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        mutableLiveData.setValue(obj);
        return Unit.INSTANCE;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, mo26107d2 = {"<anonymous>", "", "Leditor/mediaselection/localmedia/LocalMedia;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
    @DebugMetadata(mo26807c = "editor.mediaselection.items.MediaSelectionItemsViewModel$loadVideos$1$1", mo26808f = "MediaSelectionItemsViewModel.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
    /* renamed from: editor.mediaselection.items.MediaSelectionItemsViewModel$loadVideos$1$1 */
    /* compiled from: MediaSelectionItemsViewModel.kt */
    static final class C48241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends LocalMedia>>, Object> {
        int label;
        final /* synthetic */ MediaSelectionItemsViewModel$loadVideos$1 this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new C48241(this.this$0, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((C48241) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return this.this$0.this$0.mediaProvider.fetchVideos(20);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
