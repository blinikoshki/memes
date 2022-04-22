package p015io.getstream.chat.android.client.api2;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.messaging.Constants;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api.ChatApi;
import p015io.getstream.chat.android.client.api.models.CompletableResponse;
import p015io.getstream.chat.android.client.api.models.QueryChannelRequest;
import p015io.getstream.chat.android.client.api.models.QueryChannelsRequest;
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.client.api.models.QueryUsersRequest;
import p015io.getstream.chat.android.client.api.models.SearchMessagesRequest;
import p015io.getstream.chat.android.client.api.models.SendActionRequest;
import p015io.getstream.chat.android.client.api.models.UpdateChannelRequest;
import p015io.getstream.chat.android.client.api2.mapping.MessageMappingKt;
import p015io.getstream.chat.android.client.api2.model.requests.MessageRequest;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.call.CallKt;
import p015io.getstream.chat.android.client.events.ChatEvent;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Device;
import p015io.getstream.chat.android.client.models.Flag;
import p015io.getstream.chat.android.client.models.GuestUser;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.ModelFields;
import p015io.getstream.chat.android.client.models.Mute;
import p015io.getstream.chat.android.client.models.Reaction;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.FilterObject;
import p015io.getstream.chat.android.client.utils.ProgressCallback;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J)\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0001J\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\u0006\u0010\u0012\u001a\u00020\u0003H\u0001J-\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015H\u0001JH\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000b2\u0006\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\u0010\u001eJ\u001f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0001J\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\u0006\u0010\u0012\u001a\u00020\u0003H\u0001J'\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003H\u0001J'\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003H\u0001J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u000b2\u0006\u0010&\u001a\u00020\u0003H\u0016J\u001f\u0010'\u001a\b\u0012\u0004\u0012\u00020%0\u000b2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003H\u0001J\u001f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0001J'\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u001aH\u0001J\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u000b2\u0006\u0010&\u001a\u00020\u0003H\u0001J\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u000b2\u0006\u0010\t\u001a\u00020\u0003H\u0001J\u0015\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u00150\u000bH\u0001J\u001f\u00101\u001a\b\u0012\u0004\u0012\u0002020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u0003H\u0001J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00020%0\u000b2\u0006\u0010&\u001a\u00020\u0003H\u0016J-\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060\u00150\u000b2\u0006\u0010&\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\u001aH\u0001J%\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00150\u000b2\u0006\u0010&\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u001aH\u0001J-\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00150\u000b2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u001aH\u0001J+\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0\u00150\u000b2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00030\u00152\u0006\u0010?\u001a\u00020@H\u0001J'\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u001dH\u0001J\u000f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bH\u0001J)\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u0003H\u0001J\u001f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0001J\u000f\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u000bH\u0001J\u0017\u0010H\u001a\b\u0012\u0004\u0012\u00020G0\u000b2\u0006\u0010\t\u001a\u00020\u0003H\u0001J)\u0010I\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\u0006\u0010J\u001a\u00020KH\u0001J\u001d\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00150\u000b2\u0006\u0010J\u001a\u00020MH\u0001JY\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020O0\u00150\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\u001a2\u0006\u0010P\u001a\u00020Q2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020O0S2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020O0\u0015H\u0001J\u001d\u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020U0\u00150\u000b2\u0006\u0010T\u001a\u00020VH\u0001J\u001f\u0010W\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0001J-\u0010X\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015H\u0001J\u001d\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00150\u000b2\u0006\u0010Z\u001a\u00020[H\u0001J\u0017\u0010\\\u001a\b\u0012\u0004\u0012\u00020%0\u000b2\u0006\u0010Z\u001a\u00020]H\u0001J;\u0010^\u001a\b\u0012\u0004\u0012\u00020=0\u000b2\u0006\u0010_\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0012\u0010`\u001a\u000e\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020b0aH\u0001J3\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010d\u001a\u00020e2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010gH\u0001J3\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010d\u001a\u00020e2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010gH\u0001J&\u0010i\u001a\b\u0012\u0004\u0012\u00020%0\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020%H\u0016J\u001f\u0010j\u001a\b\u0012\u0004\u0012\u0002060\u000b2\u0006\u0010k\u001a\u0002062\u0006\u0010l\u001a\u00020\u001dH\u0001J'\u0010j\u001a\b\u0012\u0004\u0012\u0002060\u000b2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00032\u0006\u0010l\u001a\u00020\u001dH\u0001J\u0018\u0010m\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u001f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0001J\u001f\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0001J\u001f\u0010p\u001a\b\u0012\u0004\u0012\u00020%0\u000b2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010q\u001a\u00020\u0003H\u0001J/\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00170\u000b2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0001J\u001f\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0001J\u000f\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bH\u0001J\u0017\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\u0006\u0010\t\u001a\u00020\u0003H\u0001J'\u0010v\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010Z\u001a\u00020wH\u0001J\u0016\u0010x\u001a\b\u0012\u0004\u0012\u00020%0\u000b2\u0006\u0010\u000f\u001a\u00020%H\u0016J#\u0010y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020U0\u00150\u000b2\f\u0010z\u001a\b\u0012\u0004\u0012\u00020U0\u0015H\u0001J\t\u0010{\u001a\u00020\u0011H\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006|"}, mo26107d2 = {"Lio/getstream/chat/android/client/api2/MoshiChatApi;", "Lio/getstream/chat/android/client/api/ChatApi;", "apiKey", "", "legacyApiDelegate", "messageApi", "Lio/getstream/chat/android/client/api2/MessageApi;", "(Ljava/lang/String;Lio/getstream/chat/android/client/api/ChatApi;Lio/getstream/chat/android/client/api2/MessageApi;)V", "connectionId", "userId", "acceptInvite", "Lio/getstream/chat/android/client/call/Call;", "Lio/getstream/chat/android/client/models/Channel;", "channelType", "channelId", "message", "addDevice", "", "firebaseToken", "addMembers", "members", "", "banUser", "Lio/getstream/chat/android/client/api/models/CompletableResponse;", "targetId", "timeout", "", "reason", "shadow", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lio/getstream/chat/android/client/call/Call;", "deleteChannel", "deleteDevice", "deleteFile", "url", "deleteImage", "deleteMessage", "Lio/getstream/chat/android/client/models/Message;", "messageId", "deleteReaction", "reactionType", "disableSlowMode", "enableSlowMode", "cooldownTimeInSeconds", "flagMessage", "Lio/getstream/chat/android/client/models/Flag;", "flagUser", "getDevices", "Lio/getstream/chat/android/client/models/Device;", "getGuestUser", "Lio/getstream/chat/android/client/models/GuestUser;", "userName", "getMessage", "getReactions", "Lio/getstream/chat/android/client/models/Reaction;", "offset", "limit", "getReplies", "getRepliesMore", "firstId", "getSyncHistory", "Lio/getstream/chat/android/client/events/ChatEvent;", "channelIds", "lastSyncAt", "Ljava/util/Date;", "hideChannel", "clearHistory", "markAllRead", "markRead", "muteChannel", "muteCurrentUser", "Lio/getstream/chat/android/client/models/Mute;", "muteUser", "queryChannel", "query", "Lio/getstream/chat/android/client/api/models/QueryChannelRequest;", "queryChannels", "Lio/getstream/chat/android/client/api/models/QueryChannelsRequest;", "queryMembers", "Lio/getstream/chat/android/client/models/Member;", "filter", "Lio/getstream/chat/android/client/utils/FilterObject;", "sort", "Lio/getstream/chat/android/client/api/models/QuerySort;", "queryUsers", "Lio/getstream/chat/android/client/models/User;", "Lio/getstream/chat/android/client/api/models/QueryUsersRequest;", "rejectInvite", "removeMembers", "searchMessages", "request", "Lio/getstream/chat/android/client/api/models/SearchMessagesRequest;", "sendAction", "Lio/getstream/chat/android/client/api/models/SendActionRequest;", "sendEvent", "eventType", "extraData", "", "", "sendFile", "file", "Ljava/io/File;", "callback", "Lio/getstream/chat/android/client/utils/ProgressCallback;", "sendImage", "sendMessage", "sendReaction", "reaction", "enforceUnique", "setConnection", "showChannel", "stopWatching", "translate", "language", "unBanUser", "unMuteChannel", "unmuteCurrentUser", "unmuteUser", "updateChannel", "Lio/getstream/chat/android/client/api/models/UpdateChannelRequest;", "updateMessage", "updateUsers", "users", "warmUp", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api2.MoshiChatApi */
/* compiled from: MoshiChatApi.kt */
public final class MoshiChatApi implements ChatApi {
    private final String apiKey;
    private String connectionId;
    private final ChatApi legacyApiDelegate;
    private final MessageApi messageApi;
    private String userId;

    public Call<Channel> acceptInvite(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return this.legacyApiDelegate.acceptInvite(str, str2, str3);
    }

    public Call<Unit> addDevice(String str) {
        Intrinsics.checkNotNullParameter(str, "firebaseToken");
        return this.legacyApiDelegate.addDevice(str);
    }

    public Call<Channel> addMembers(String str, String str2, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(list, ModelFields.MEMBERS);
        return this.legacyApiDelegate.addMembers(str, str2, list);
    }

    public Call<CompletableResponse> banUser(String str, Integer num, String str2, String str3, String str4, boolean z) {
        Intrinsics.checkNotNullParameter(str, "targetId");
        Intrinsics.checkNotNullParameter(str3, "channelType");
        Intrinsics.checkNotNullParameter(str4, "channelId");
        return this.legacyApiDelegate.banUser(str, num, str2, str3, str4, z);
    }

    public Call<Channel> deleteChannel(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return this.legacyApiDelegate.deleteChannel(str, str2);
    }

    public Call<Unit> deleteDevice(String str) {
        Intrinsics.checkNotNullParameter(str, "firebaseToken");
        return this.legacyApiDelegate.deleteDevice(str);
    }

    public Call<Unit> deleteFile(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, "url");
        return this.legacyApiDelegate.deleteFile(str, str2, str3);
    }

    public Call<Unit> deleteImage(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, "url");
        return this.legacyApiDelegate.deleteImage(str, str2, str3);
    }

    public Call<Message> deleteReaction(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        Intrinsics.checkNotNullParameter(str2, "reactionType");
        return this.legacyApiDelegate.deleteReaction(str, str2);
    }

    public Call<Channel> disableSlowMode(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return this.legacyApiDelegate.disableSlowMode(str, str2);
    }

    public Call<Channel> enableSlowMode(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return this.legacyApiDelegate.enableSlowMode(str, str2, i);
    }

    public Call<Flag> flagMessage(String str) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        return this.legacyApiDelegate.flagMessage(str);
    }

    public Call<Flag> flagUser(String str) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        return this.legacyApiDelegate.flagUser(str);
    }

    public Call<List<Device>> getDevices() {
        return this.legacyApiDelegate.getDevices();
    }

    public Call<GuestUser> getGuestUser(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        Intrinsics.checkNotNullParameter(str2, TagPeopleActivity.USER_NAME);
        return this.legacyApiDelegate.getGuestUser(str, str2);
    }

    public Call<List<Reaction>> getReactions(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        return this.legacyApiDelegate.getReactions(str, i, i2);
    }

    public Call<List<Message>> getReplies(String str, int i) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        return this.legacyApiDelegate.getReplies(str, i);
    }

    public Call<List<Message>> getRepliesMore(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        Intrinsics.checkNotNullParameter(str2, "firstId");
        return this.legacyApiDelegate.getRepliesMore(str, str2, i);
    }

    public Call<List<ChatEvent>> getSyncHistory(List<String> list, Date date) {
        Intrinsics.checkNotNullParameter(list, "channelIds");
        Intrinsics.checkNotNullParameter(date, "lastSyncAt");
        return this.legacyApiDelegate.getSyncHistory(list, date);
    }

    public Call<Unit> hideChannel(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return this.legacyApiDelegate.hideChannel(str, str2, z);
    }

    public Call<Unit> markAllRead() {
        return this.legacyApiDelegate.markAllRead();
    }

    public Call<Unit> markRead(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        return this.legacyApiDelegate.markRead(str, str2, str3);
    }

    public Call<Unit> muteChannel(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return this.legacyApiDelegate.muteChannel(str, str2);
    }

    public Call<Mute> muteCurrentUser() {
        return this.legacyApiDelegate.muteCurrentUser();
    }

    public Call<Mute> muteUser(String str) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        return this.legacyApiDelegate.muteUser(str);
    }

    public Call<Channel> queryChannel(String str, String str2, QueryChannelRequest queryChannelRequest) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(queryChannelRequest, SearchIntents.EXTRA_QUERY);
        return this.legacyApiDelegate.queryChannel(str, str2, queryChannelRequest);
    }

    public Call<List<Channel>> queryChannels(QueryChannelsRequest queryChannelsRequest) {
        Intrinsics.checkNotNullParameter(queryChannelsRequest, SearchIntents.EXTRA_QUERY);
        return this.legacyApiDelegate.queryChannels(queryChannelsRequest);
    }

    public Call<List<Member>> queryMembers(String str, String str2, int i, int i2, FilterObject filterObject, QuerySort<Member> querySort, List<Member> list) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(filterObject, "filter");
        Intrinsics.checkNotNullParameter(querySort, "sort");
        List<Member> list2 = list;
        Intrinsics.checkNotNullParameter(list2, ModelFields.MEMBERS);
        return this.legacyApiDelegate.queryMembers(str, str2, i, i2, filterObject, querySort, list2);
    }

    public Call<List<User>> queryUsers(QueryUsersRequest queryUsersRequest) {
        Intrinsics.checkNotNullParameter(queryUsersRequest, "queryUsers");
        return this.legacyApiDelegate.queryUsers(queryUsersRequest);
    }

    public Call<Channel> rejectInvite(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return this.legacyApiDelegate.rejectInvite(str, str2);
    }

    public Call<Channel> removeMembers(String str, String str2, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(list, ModelFields.MEMBERS);
        return this.legacyApiDelegate.removeMembers(str, str2, list);
    }

    public Call<List<Message>> searchMessages(SearchMessagesRequest searchMessagesRequest) {
        Intrinsics.checkNotNullParameter(searchMessagesRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        return this.legacyApiDelegate.searchMessages(searchMessagesRequest);
    }

    public Call<Message> sendAction(SendActionRequest sendActionRequest) {
        Intrinsics.checkNotNullParameter(sendActionRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        return this.legacyApiDelegate.sendAction(sendActionRequest);
    }

    public Call<ChatEvent> sendEvent(String str, String str2, String str3, Map<Object, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "eventType");
        Intrinsics.checkNotNullParameter(str2, "channelType");
        Intrinsics.checkNotNullParameter(str3, "channelId");
        Intrinsics.checkNotNullParameter(map, "extraData");
        return this.legacyApiDelegate.sendEvent(str, str2, str3, map);
    }

    public Call<String> sendFile(String str, String str2, File file, ProgressCallback progressCallback) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(file, "file");
        return this.legacyApiDelegate.sendFile(str, str2, file, progressCallback);
    }

    public Call<String> sendImage(String str, String str2, File file, ProgressCallback progressCallback) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(file, "file");
        return this.legacyApiDelegate.sendImage(str, str2, file, progressCallback);
    }

    public Call<Reaction> sendReaction(Reaction reaction, boolean z) {
        Intrinsics.checkNotNullParameter(reaction, "reaction");
        return this.legacyApiDelegate.sendReaction(reaction, z);
    }

    public Call<Reaction> sendReaction(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        Intrinsics.checkNotNullParameter(str2, "reactionType");
        return this.legacyApiDelegate.sendReaction(str, str2, z);
    }

    public Call<Unit> showChannel(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return this.legacyApiDelegate.showChannel(str, str2);
    }

    public Call<Unit> stopWatching(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return this.legacyApiDelegate.stopWatching(str, str2);
    }

    public Call<Message> translate(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        Intrinsics.checkNotNullParameter(str2, "language");
        return this.legacyApiDelegate.translate(str, str2);
    }

    public Call<CompletableResponse> unBanUser(String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "targetId");
        Intrinsics.checkNotNullParameter(str2, "channelType");
        Intrinsics.checkNotNullParameter(str3, "channelId");
        return this.legacyApiDelegate.unBanUser(str, str2, str3, z);
    }

    public Call<Unit> unMuteChannel(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return this.legacyApiDelegate.unMuteChannel(str, str2);
    }

    public Call<Unit> unmuteCurrentUser() {
        return this.legacyApiDelegate.unmuteCurrentUser();
    }

    public Call<Unit> unmuteUser(String str) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        return this.legacyApiDelegate.unmuteUser(str);
    }

    public Call<Channel> updateChannel(String str, String str2, UpdateChannelRequest updateChannelRequest) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(updateChannelRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        return this.legacyApiDelegate.updateChannel(str, str2, updateChannelRequest);
    }

    public Call<List<User>> updateUsers(List<User> list) {
        Intrinsics.checkNotNullParameter(list, "users");
        return this.legacyApiDelegate.updateUsers(list);
    }

    public void warmUp() {
        this.legacyApiDelegate.warmUp();
    }

    public MoshiChatApi(String str, ChatApi chatApi, MessageApi messageApi2) {
        Intrinsics.checkNotNullParameter(str, "apiKey");
        Intrinsics.checkNotNullParameter(chatApi, "legacyApiDelegate");
        Intrinsics.checkNotNullParameter(messageApi2, "messageApi");
        this.apiKey = str;
        this.legacyApiDelegate = chatApi;
        this.messageApi = messageApi2;
    }

    public void setConnection(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "connectionId");
        this.userId = str;
        this.connectionId = str2;
    }

    public Call<Message> sendMessage(String str, String str2, Message message) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        MessageApi messageApi2 = this.messageApi;
        String str3 = this.apiKey;
        String str4 = this.userId;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(TagPeopleActivity.USER_ID);
        }
        String str5 = this.connectionId;
        if (str5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionId");
        }
        return CallKt.map(messageApi2.sendMessage(str, str2, str3, str4, str5, new MessageRequest(MessageMappingKt.toDto(message))), MoshiChatApi$sendMessage$1.INSTANCE);
    }

    public Call<Message> updateMessage(Message message) {
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        MessageApi messageApi2 = this.messageApi;
        String id = message.getId();
        String str = this.apiKey;
        String str2 = this.userId;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(TagPeopleActivity.USER_ID);
        }
        String str3 = this.connectionId;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionId");
        }
        return CallKt.map(messageApi2.updateMessage(id, str, str2, str3, new MessageRequest(MessageMappingKt.toDto(message))), MoshiChatApi$updateMessage$1.INSTANCE);
    }

    public Call<Message> getMessage(String str) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        MessageApi messageApi2 = this.messageApi;
        String str2 = this.apiKey;
        String str3 = this.userId;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(TagPeopleActivity.USER_ID);
        }
        String str4 = this.connectionId;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionId");
        }
        return CallKt.map(messageApi2.getMessage(str, str2, str3, str4), MoshiChatApi$getMessage$1.INSTANCE);
    }

    public Call<Message> deleteMessage(String str) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        MessageApi messageApi2 = this.messageApi;
        String str2 = this.apiKey;
        String str3 = this.userId;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(TagPeopleActivity.USER_ID);
        }
        String str4 = this.connectionId;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionId");
        }
        return CallKt.map(messageApi2.deleteMessage(str, str2, str3, str4), MoshiChatApi$deleteMessage$1.INSTANCE);
    }
}
