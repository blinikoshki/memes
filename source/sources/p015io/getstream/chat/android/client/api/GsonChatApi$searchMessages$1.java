package p015io.getstream.chat.android.client.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import p015io.getstream.chat.android.client.api.models.MessageResponse;
import p015io.getstream.chat.android.client.api.models.SearchMessagesResponse;
import p015io.getstream.chat.android.client.extensions.MessageExtensionsKt;
import p015io.getstream.chat.android.client.models.ChannelInfo;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "Lio/getstream/chat/android/client/models/Message;", "it", "Lio/getstream/chat/android/client/api/models/SearchMessagesResponse;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.GsonChatApi$searchMessages$1 */
/* compiled from: GsonChatApi.kt */
final class GsonChatApi$searchMessages$1 extends Lambda implements Function1<SearchMessagesResponse, List<? extends Message>> {
    public static final GsonChatApi$searchMessages$1 INSTANCE = new GsonChatApi$searchMessages$1();

    GsonChatApi$searchMessages$1() {
        super(1);
    }

    public final List<Message> invoke(SearchMessagesResponse searchMessagesResponse) {
        Intrinsics.checkNotNullParameter(searchMessagesResponse, "it");
        Iterable<MessageResponse> results = searchMessagesResponse.getResults();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(results, 10));
        for (MessageResponse message : results) {
            Message message2 = message.getMessage();
            String cid = message2.getCid();
            String str = null;
            if (StringsKt.isBlank(cid)) {
                cid = null;
            }
            if (cid != null) {
                str = cid;
            } else {
                ChannelInfo channelInfo = message2.getChannelInfo();
                if (channelInfo != null) {
                    str = channelInfo.getCid();
                }
            }
            if (str != null) {
                MessageExtensionsKt.enrichWithCid(message2, str);
            }
            arrayList.add(message2);
        }
        return (List) arrayList;
    }
}
