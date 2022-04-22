package p015io.getstream.chat.android.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.models.Attachment;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "Lio/getstream/chat/android/client/models/Attachment;", "messages", "Lio/getstream/chat/android/client/models/Message;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.ChatClient$getAttachments$1 */
/* compiled from: ChatClient.kt */
final class ChatClient$getAttachments$1 extends Lambda implements Function1<List<? extends Message>, List<? extends Attachment>> {
    final /* synthetic */ String $type;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatClient$getAttachments$1(String str) {
        super(1);
        this.$type = str;
    }

    public final List<Attachment> invoke(List<Message> list) {
        Intrinsics.checkNotNullParameter(list, "messages");
        Collection arrayList = new ArrayList();
        for (Message attachments : list) {
            Collection arrayList2 = new ArrayList();
            for (Object next : attachments.getAttachments()) {
                if (Intrinsics.areEqual((Object) ((Attachment) next).getType(), (Object) this.$type)) {
                    arrayList2.add(next);
                }
            }
            CollectionsKt.addAll(arrayList, (List) arrayList2);
        }
        return (List) arrayList;
    }
}
