package com.getstream.sdk.chat.view.messageinput;

import android.content.Context;
import com.getstream.sdk.chat.model.AttachmentMetaData;
import com.getstream.sdk.chat.utils.StorageHelper;
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

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, mo26107d2 = {"<anonymous>", "", "Lcom/getstream/sdk/chat/model/AttachmentMetaData;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.getstream.sdk.chat.view.messageinput.AttachmentsController$selectAttachmentsFromUriList$1$attachments$1", mo26808f = "AttachmentsController.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.getstream.sdk.chat.view.messageinput.AttachmentsController$selectAttachmentsFromUriList$1$attachments$1 */
/* compiled from: AttachmentsController.kt */
final class C1749x612fa22a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends AttachmentMetaData>>, Object> {
    int label;
    final /* synthetic */ AttachmentsController$selectAttachmentsFromUriList$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1749x612fa22a(AttachmentsController$selectAttachmentsFromUriList$1 attachmentsController$selectAttachmentsFromUriList$1, Continuation continuation) {
        super(2, continuation);
        this.this$0 = attachmentsController$selectAttachmentsFromUriList$1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new C1749x612fa22a(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((C1749x612fa22a) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            StorageHelper access$getStorageHelper$p = this.this$0.this$0.storageHelper;
            Context context = this.this$0.this$0.view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            return access$getStorageHelper$p.getAttachmentsFromUriList(context, this.this$0.$uriList);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
