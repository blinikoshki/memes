package p015io.getstream.chat.android.livedata.usecase;

import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import p015io.getstream.chat.android.client.models.Attachment;
import p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052,\u0010\u0007\u001a(\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\b¢\u0006\u0002\b\u000e2\u0018\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\u00110\u0010H@"}, mo26107d2 = {"uploadFiles", "", "channelControllerImpl", "Lio/getstream/chat/android/livedata/controller/ChannelControllerImpl;", "files", "", "Ljava/io/File;", "attachmentTransformer", "Lkotlin/Function2;", "Lio/getstream/chat/android/client/models/Attachment;", "Lkotlin/ParameterName;", "name", "file", "", "Lkotlin/ExtensionFunctionType;", "continuation", "Lkotlin/coroutines/Continuation;", "Lio/getstream/chat/android/client/utils/Result;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.usecase.SendMessageWithAttachmentsImpl", mo26808f = "SendMessageWithAttachmentsImpl.kt", mo26809i = {0, 0, 0, 0, 0}, mo26810l = {68}, mo26811m = "uploadFiles", mo26812n = {"this", "channelControllerImpl", "attachmentTransformer", "file", "acc"}, mo26813s = {"L$0", "L$1", "L$2", "L$4", "L$5"})
/* renamed from: io.getstream.chat.android.livedata.usecase.SendMessageWithAttachmentsImpl$uploadFiles$1 */
/* compiled from: SendMessageWithAttachmentsImpl.kt */
final class SendMessageWithAttachmentsImpl$uploadFiles$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SendMessageWithAttachmentsImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SendMessageWithAttachmentsImpl$uploadFiles$1(SendMessageWithAttachmentsImpl sendMessageWithAttachmentsImpl, Continuation continuation) {
        super(continuation);
        this.this$0 = sendMessageWithAttachmentsImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.uploadFiles((ChannelControllerImpl) null, (List<? extends File>) null, (Function2<? super Attachment, ? super File, Unit>) null, this);
    }
}
