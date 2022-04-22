package p015io.getstream.chat.android.livedata.usecase;

import com.facebook.share.internal.ShareConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.models.Attachment;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0002JQ\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u000428\u0010\u0006\u001a4\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H§\u0002¨\u0006\u000e"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/usecase/SendMessage;", "", "invoke", "Lio/getstream/chat/android/client/call/Call;", "Lio/getstream/chat/android/client/models/Message;", "message", "attachmentTransformer", "Lkotlin/Function2;", "Lio/getstream/chat/android/client/models/Attachment;", "Lkotlin/ParameterName;", "name", "at", "Ljava/io/File;", "file", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.usecase.SendMessage */
/* compiled from: SendMessageImpl.kt */
public interface SendMessage {
    Call<Message> invoke(Message message);

    Call<Message> invoke(Message message, Function2<? super Attachment, ? super File, Attachment> function2);

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.livedata.usecase.SendMessage$DefaultImpls */
    /* compiled from: SendMessageImpl.kt */
    public static final class DefaultImpls {
        public static Call<Message> invoke(SendMessage sendMessage, Message message) {
            Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            return sendMessage.invoke(message, (Function2<? super Attachment, ? super File, Attachment>) null);
        }
    }
}
