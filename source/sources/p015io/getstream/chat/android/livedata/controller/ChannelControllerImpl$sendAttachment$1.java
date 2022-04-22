package p015io.getstream.chat.android.livedata.controller;

import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import p015io.getstream.chat.android.client.models.Attachment;
import p015io.getstream.chat.android.client.uploader.ProgressTracker;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000528\u0010\u0006\u001a4\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH@"}, mo26107d2 = {"sendAttachment", "", "attachment", "Lio/getstream/chat/android/client/models/Attachment;", "attachmentProgress", "Lio/getstream/chat/android/client/uploader/ProgressTracker;", "attachmentTransformer", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "at", "Ljava/io/File;", "file", "continuation", "Lkotlin/coroutines/Continuation;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.controller.ChannelControllerImpl", mo26808f = "ChannelControllerImpl.kt", mo26809i = {0, 0}, mo26810l = {674}, mo26811m = "sendAttachment", mo26812n = {"attachmentProgress", "newAttachment"}, mo26813s = {"L$0", "L$1"})
/* renamed from: io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendAttachment$1 */
/* compiled from: ChannelControllerImpl.kt */
final class ChannelControllerImpl$sendAttachment$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChannelControllerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelControllerImpl$sendAttachment$1(ChannelControllerImpl channelControllerImpl, Continuation continuation) {
        super(continuation);
        this.this$0 = channelControllerImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.sendAttachment((Attachment) null, (ProgressTracker) null, (Function2<? super Attachment, ? super File, Attachment>) null, this);
    }
}
