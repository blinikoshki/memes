package p015io.getstream.chat.android.client.p049di;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.parser2.MoshiChatParser;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/parser2/MoshiChatParser;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.di.BaseChatModule$moshiParser$2 */
/* compiled from: BaseChatModule.kt */
final class BaseChatModule$moshiParser$2 extends Lambda implements Function0<MoshiChatParser> {
    public static final BaseChatModule$moshiParser$2 INSTANCE = new BaseChatModule$moshiParser$2();

    BaseChatModule$moshiParser$2() {
        super(0);
    }

    public final MoshiChatParser invoke() {
        return new MoshiChatParser();
    }
}
