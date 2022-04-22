package p015io.getstream.chat.android.livedata.usecase;

import java.io.File;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.models.Attachment;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J]\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2.\b\u0002\u0010\u000b\u001a(\u0012\u0004\u0012\u00020\r\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\f¢\u0006\u0002\b\u0012H§\u0002¨\u0006\u0013"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/usecase/SendMessageWithAttachments;", "", "invoke", "Lio/getstream/chat/android/client/call/Call;", "Lio/getstream/chat/android/client/models/Message;", "cid", "", "message", "files", "", "Ljava/io/File;", "attachmentTransformer", "Lkotlin/Function2;", "Lio/getstream/chat/android/client/models/Attachment;", "Lkotlin/ParameterName;", "name", "file", "", "Lkotlin/ExtensionFunctionType;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
@Deprecated(level = DeprecationLevel.ERROR, message = "Use sendMessage() and attachment.upload instead of this useCase")
/* renamed from: io.getstream.chat.android.livedata.usecase.SendMessageWithAttachments */
/* compiled from: SendMessageWithAttachmentsImpl.kt */
public interface SendMessageWithAttachments {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use sendMessage() and attachment.upload instead of this useCase")
    Call<Message> invoke(String str, Message message, List<? extends File> list, Function2<? super Attachment, ? super File, Unit> function2);

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.livedata.usecase.SendMessageWithAttachments$DefaultImpls */
    /* compiled from: SendMessageWithAttachmentsImpl.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Call invoke$default(SendMessageWithAttachments sendMessageWithAttachments, String str, Message message, List list, Function2 function2, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    function2 = SendMessageWithAttachments$invoke$1.INSTANCE;
                }
                return sendMessageWithAttachments.invoke(str, message, list, function2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
        }
    }
}
