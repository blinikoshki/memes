package p015io.getstream.chat.android.livedata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Member;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/call/Call;", "Lio/getstream/chat/android/client/models/Channel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.ChatDomainImpl$createChannel$runnable$1 */
/* compiled from: ChatDomainImpl.kt */
final class ChatDomainImpl$createChannel$runnable$1 extends Lambda implements Function0<Call<Channel>> {

    /* renamed from: $c */
    final /* synthetic */ Channel f1463$c;
    final /* synthetic */ ChatDomainImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatDomainImpl$createChannel$runnable$1(ChatDomainImpl chatDomainImpl, Channel channel) {
        super(0);
        this.this$0 = chatDomainImpl;
        this.f1463$c = channel;
    }

    public final Call<Channel> invoke() {
        Iterable<Member> members = this.f1463$c.getMembers();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(members, 10));
        for (Member userId : members) {
            arrayList.add(userId.getUserId());
        }
        return this.this$0.getClient$stream_chat_android_offline_release().createChannel(this.f1463$c.getType(), this.f1463$c.getId(), (List) arrayList, this.f1463$c.getExtraData());
    }
}
