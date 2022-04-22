package p015io.getstream.chat.android.livedata;

import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.text.Regex;
import p015io.getstream.chat.android.client.parser.StreamGson;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, mo26107d2 = {"CHANNEL_CID_REGEX", "Lkotlin/text/Regex;", "CHANNEL_LIMIT", "", "INITIAL_CHANNEL_OFFSET", "MEMBER_LIMIT", "MESSAGE_LIMIT", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "stream-chat-android-offline_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.ChatDomainImplKt */
/* compiled from: ChatDomainImpl.kt */
public final class ChatDomainImplKt {
    /* access modifiers changed from: private */
    public static final Regex CHANNEL_CID_REGEX = new Regex("^!?[\\w-]+:!?[\\w-]+$");
    private static final int CHANNEL_LIMIT = 30;
    private static final int INITIAL_CHANNEL_OFFSET = 0;
    private static final int MEMBER_LIMIT = 30;
    private static final int MESSAGE_LIMIT = 30;
    private static final Gson gson = StreamGson.INSTANCE.getGson();

    public static final Gson getGson() {
        return gson;
    }
}
