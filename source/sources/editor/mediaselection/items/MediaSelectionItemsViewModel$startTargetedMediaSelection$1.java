package editor.mediaselection.items;

import com.memes.editor.C4175R;
import editor.mediaselection.MediaSelectionConfig;
import editor.mediaselection.targetedmediabrowser.MediaSelectionTarget;
import editor.mediaselection.targetedmediabrowser.TargetedMediaSelectionConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.mediaselection.items.MediaSelectionItemsViewModel$startTargetedMediaSelection$1", mo26808f = "MediaSelectionItemsViewModel.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: MediaSelectionItemsViewModel.kt */
final class MediaSelectionItemsViewModel$startTargetedMediaSelection$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MediaSelectionTarget $target;
    int label;
    final /* synthetic */ MediaSelectionItemsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MediaSelectionItemsViewModel$startTargetedMediaSelection$1(MediaSelectionItemsViewModel mediaSelectionItemsViewModel, MediaSelectionTarget mediaSelectionTarget, Continuation continuation) {
        super(2, continuation);
        this.this$0 = mediaSelectionItemsViewModel;
        this.$target = mediaSelectionTarget;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new MediaSelectionItemsViewModel$startTargetedMediaSelection$1(this.this$0, this.$target, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((MediaSelectionItemsViewModel$startTargetedMediaSelection$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            int selectionCountLimit = this.this$0.config.getSelectionCountLimit();
            if (selectionCountLimit - this.this$0.selectedItemsList.size() <= 0) {
                this.this$0.toast(C4175R.string.media_selection_limit_reached);
                return Unit.INSTANCE;
            }
            Iterable<MediaSelectionItem> access$getSelectedItemsList$p = this.this$0.selectedItemsList;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(access$getSelectedItemsList$p, 10));
            for (MediaSelectionItem identifier : access$getSelectedItemsList$p) {
                arrayList.add(identifier.getIdentifier());
            }
            this.this$0._targetedMediaSelectionConfig.setValue(new TargetedMediaSelectionConfig(this.$target, new MediaSelectionConfig(selectionCountLimit, (List) arrayList, false, 4, (DefaultConstructorMarker) null)));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
