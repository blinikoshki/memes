package com.getstream.sdk.chat.view.messageinput;

import android.content.Context;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.enums.MessageInputType;
import com.getstream.sdk.chat.model.AttachmentMetaData;
import com.getstream.sdk.chat.utils.StorageHelper;
import java.util.Set;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import p015io.getstream.chat.android.core.internal.coroutines.DispatcherProvider;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.getstream.sdk.chat.view.messageinput.AttachmentsController$fillTotalMediaAttachmentsView$1", mo26808f = "AttachmentsController.kt", mo26809i = {}, mo26810l = {48}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: AttachmentsController.kt */
final class AttachmentsController$fillTotalMediaAttachmentsView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MessageInputType $messageInputType;
    Object L$0;
    int label;
    final /* synthetic */ AttachmentsController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AttachmentsController$fillTotalMediaAttachmentsView$1(AttachmentsController attachmentsController, MessageInputType messageInputType, Continuation continuation) {
        super(2, continuation);
        this.this$0 = attachmentsController;
        this.$messageInputType = messageInputType;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new AttachmentsController$fillTotalMediaAttachmentsView$1(this.this$0, this.$messageInputType, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((AttachmentsController$fillTotalMediaAttachmentsView$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        AttachmentsController attachmentsController;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.view.showLoadingTotalAttachments$stream_chat_android_release(true);
            AttachmentsController attachmentsController2 = this.this$0;
            this.L$0 = attachmentsController2;
            this.label = 1;
            Object withContext = BuildersKt.withContext(DispatcherProvider.INSTANCE.getIO(), new C17481(this, (Continuation) null), this);
            if (withContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            attachmentsController = attachmentsController2;
            obj = withContext;
        } else if (i == 1) {
            attachmentsController = (AttachmentsController) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        attachmentsController.totalAttachments = (Set) obj;
        if (this.this$0.totalAttachments.isEmpty()) {
            this.this$0.view.showMessage(C1673R.string.stream_no_media_error);
            this.this$0.onClickCloseAttachmentSelectionMenu$stream_chat_android_release();
        } else {
            AttachmentsController attachmentsController3 = this.this$0;
            attachmentsController3.setTotalMediaAttachmentAdapter(CollectionsKt.toList(attachmentsController3.totalAttachments), CollectionsKt.toList(this.this$0.getSelectedAttachments$stream_chat_android_release()), this.$messageInputType);
        }
        this.this$0.setSelectedMediaAttachmentAdapter(this.$messageInputType);
        this.this$0.view.showLoadingTotalAttachments$stream_chat_android_release(false);
        return Unit.INSTANCE;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, mo26107d2 = {"<anonymous>", "", "Lcom/getstream/sdk/chat/model/AttachmentMetaData;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
    @DebugMetadata(mo26807c = "com.getstream.sdk.chat.view.messageinput.AttachmentsController$fillTotalMediaAttachmentsView$1$1", mo26808f = "AttachmentsController.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
    /* renamed from: com.getstream.sdk.chat.view.messageinput.AttachmentsController$fillTotalMediaAttachmentsView$1$1 */
    /* compiled from: AttachmentsController.kt */
    static final class C17481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Set<? extends AttachmentMetaData>>, Object> {
        int label;
        final /* synthetic */ AttachmentsController$fillTotalMediaAttachmentsView$1 this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new C17481(this.this$0, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((C17481) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                StorageHelper access$getStorageHelper$p = this.this$0.this$0.storageHelper;
                Context context = this.this$0.this$0.view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "view.context");
                return CollectionsKt.toSet(access$getStorageHelper$p.getMediaAttachments(context));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
