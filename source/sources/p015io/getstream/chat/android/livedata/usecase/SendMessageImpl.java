package p015io.getstream.chat.android.livedata.usecase;

import com.facebook.share.internal.ShareConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.call.CoroutineCall;
import p015io.getstream.chat.android.client.models.Attachment;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.ContentUtils;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.livedata.ChatDomainImpl;
import p015io.getstream.chat.android.livedata.usecase.SendMessage;
import p015io.getstream.chat.android.livedata.utils.ValidationKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JQ\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u000728\u0010\t\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/usecase/SendMessageImpl;", "Lio/getstream/chat/android/livedata/usecase/SendMessage;", "domainImpl", "Lio/getstream/chat/android/livedata/ChatDomainImpl;", "(Lio/getstream/chat/android/livedata/ChatDomainImpl;)V", "invoke", "Lio/getstream/chat/android/client/call/Call;", "Lio/getstream/chat/android/client/models/Message;", "message", "attachmentTransformer", "Lkotlin/Function2;", "Lio/getstream/chat/android/client/models/Attachment;", "Lkotlin/ParameterName;", "name", "at", "Ljava/io/File;", "file", "populateMentions", "", "channel", "Lio/getstream/chat/android/client/models/Channel;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.usecase.SendMessageImpl */
/* compiled from: SendMessageImpl.kt */
public final class SendMessageImpl implements SendMessage {
    /* access modifiers changed from: private */
    public final ChatDomainImpl domainImpl;

    public SendMessageImpl(ChatDomainImpl chatDomainImpl) {
        Intrinsics.checkNotNullParameter(chatDomainImpl, "domainImpl");
        this.domainImpl = chatDomainImpl;
    }

    public Call<Message> invoke(Message message) {
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return SendMessage.DefaultImpls.invoke(this, message);
    }

    public Call<Message> invoke(Message message, Function2<? super Attachment, ? super File, Attachment> function2) {
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        String cid = message.getCid();
        ValidationKt.validateCid(cid);
        return new CoroutineCall<>(this.domainImpl.getScope$stream_chat_android_offline_release(), new SendMessageImpl$invoke$1(this, cid, message, function2, (Continuation) null));
    }

    /* access modifiers changed from: private */
    public final void populateMentions(Message message, Channel channel) {
        if (StringsKt.contains$default((CharSequence) message.getText(), '@', false, 2, (Object) null)) {
            String text = message.getText();
            Objects.requireNonNull(text, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = text.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            Collection arrayList = new ArrayList();
            for (Member member : channel.getMembers()) {
                StringBuilder sb = new StringBuilder();
                sb.append('@');
                String name = ContentUtils.getName(member.getUser());
                Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
                String lowerCase2 = name.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
                sb.append(lowerCase2);
                String id = StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) sb.toString(), false, 2, (Object) null) ? member.getUser().getId() : null;
                if (id != null) {
                    arrayList.add(id);
                }
            }
            message.setMentionedUsersIds((List) arrayList);
        }
    }
}
