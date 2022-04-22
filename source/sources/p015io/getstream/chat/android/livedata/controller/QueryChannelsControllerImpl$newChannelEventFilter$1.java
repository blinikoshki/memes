package p015io.getstream.chat.android.livedata.controller;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.utils.FilterObject;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lio/getstream/chat/android/client/models/Channel;", "<anonymous parameter 1>", "Lio/getstream/chat/android/client/utils/FilterObject;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl$newChannelEventFilter$1 */
/* compiled from: QueryChannelsControllerImpl.kt */
final class QueryChannelsControllerImpl$newChannelEventFilter$1 extends Lambda implements Function2<Channel, FilterObject, Boolean> {
    public static final QueryChannelsControllerImpl$newChannelEventFilter$1 INSTANCE = new QueryChannelsControllerImpl$newChannelEventFilter$1();

    QueryChannelsControllerImpl$newChannelEventFilter$1() {
        super(2);
    }

    public final boolean invoke(Channel channel, FilterObject filterObject) {
        Intrinsics.checkNotNullParameter(channel, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(filterObject, "<anonymous parameter 1>");
        return true;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return Boolean.valueOf(invoke((Channel) obj, (FilterObject) obj2));
    }
}
