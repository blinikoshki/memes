package com.memes.plus.p040ui.create_post;

import java.util.Collection;
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
@DebugMetadata(mo26807c = "com.memes.plus.ui.create_post.ExportPostViewModel$fetchSavedHashTags$1", mo26808f = "ExportPostViewModel.kt", mo26809i = {}, mo26810l = {250}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.memes.plus.ui.create_post.ExportPostViewModel$fetchSavedHashTags$1 */
/* compiled from: ExportPostViewModel.kt */
final class ExportPostViewModel$fetchSavedHashTags$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ExportPostViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExportPostViewModel$fetchSavedHashTags$1(ExportPostViewModel exportPostViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = exportPostViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new ExportPostViewModel$fetchSavedHashTags$1(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ExportPostViewModel$fetchSavedHashTags$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new ExportPostViewModel$fetchSavedHashTags$1$tagsList$1(this, (Continuation) null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List list = (List) obj;
        Collection collection = list;
        if (collection != null && !collection.isEmpty()) {
            z = false;
        }
        if (!z) {
            this.this$0._savedTags.setValue(list);
        }
        return Unit.INSTANCE;
    }
}
