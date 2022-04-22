package p015io.getstream.chat.android.client.api;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import p015io.getstream.chat.android.client.api.models.CompletableResponse;
import p015io.getstream.chat.android.client.api.models.QueryChannelRequest;
import p015io.getstream.chat.android.client.api.models.QueryChannelsRequest;
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.client.api.models.QueryUsersRequest;
import p015io.getstream.chat.android.client.api.models.SearchMessagesRequest;
import p015io.getstream.chat.android.client.api.models.SendActionRequest;
import p015io.getstream.chat.android.client.api.models.UpdateChannelRequest;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.events.ChatEvent;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Device;
import p015io.getstream.chat.android.client.models.Flag;
import p015io.getstream.chat.android.client.models.GuestUser;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.Mute;
import p015io.getstream.chat.android.client.models.Reaction;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.FilterObject;
import p015io.getstream.chat.android.client.utils.ProgressCallback;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H'J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u000b\u001a\u00020\u0006H'J,\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH'JG\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H'¢\u0006\u0002\u0010\u0017J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H'J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u000b\u001a\u00020\u0006H'J&\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H'J&\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H'J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\u0006\u0010\u001f\u001a\u00020\u0006H'J\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H'J\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H'J&\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0013H'J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00032\u0006\u0010\u001f\u001a\u00020\u0006H'J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u00032\u0006\u0010(\u001a\u00020\u0006H'J\u0014\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u000e0\u0003H'J\u001e\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u00032\u0006\u0010(\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H'J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\u0006\u0010\u001f\u001a\u00020\u0006H'J,\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u000e0\u00032\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u0013H'J$\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u000e0\u00032\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0013H'J,\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u000e0\u00032\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0013H'J*\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002070\u000e0\u00032\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\u0006\u00109\u001a\u00020:H'J&\u0010;\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u0016H'J\u000e\u0010=\u001a\b\u0012\u0004\u0012\u00020\n0\u0003H'J(\u0010>\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020\u0006H'J\u001e\u0010?\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H'J\u000e\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u0003H'J\u0016\u0010B\u001a\b\u0012\u0004\u0012\u00020A0\u00032\u0006\u0010(\u001a\u00020\u0006H'J(\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010D\u001a\u00020EH&J\u001c\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000e0\u00032\u0006\u0010D\u001a\u00020GH'JX\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0\u000e0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u00132\u0006\u0010J\u001a\u00020K2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020I0M2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020I0\u000eH'J\u001c\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020O0\u000e0\u00032\u0006\u0010N\u001a\u00020PH'J\u001e\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H'J,\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH'J\u001c\u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u000e0\u00032\u0006\u0010T\u001a\u00020UH'J\u0016\u0010V\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\u0006\u0010T\u001a\u00020WH'J:\u0010X\u001a\b\u0012\u0004\u0012\u0002070\u00032\u0006\u0010Y\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010Z\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010[H'J2\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010]\u001a\u00020^2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010`H'J2\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010]\u001a\u00020^2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010`H'J&\u0010b\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u001eH'J\u001e\u0010c\u001a\b\u0012\u0004\u0012\u0002000\u00032\u0006\u0010d\u001a\u0002002\u0006\u0010e\u001a\u00020\u0016H'J&\u0010c\u001a\b\u0012\u0004\u0012\u0002000\u00032\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\u0016H'J\u0018\u0010f\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010g\u001a\u00020\u0006H&J\u001e\u0010h\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H'J\u001e\u0010i\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H'J\u001e\u0010j\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010k\u001a\u00020\u0006H'J.\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H'J\u001e\u0010m\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H'J\u000e\u0010n\u001a\b\u0012\u0004\u0012\u00020\n0\u0003H'J\u0016\u0010o\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010(\u001a\u00020\u0006H'J&\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010T\u001a\u00020qH'J\u0016\u0010r\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\u0006\u0010\b\u001a\u00020\u001eH'J\"\u0010s\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020O0\u000e0\u00032\f\u0010t\u001a\b\u0012\u0004\u0012\u00020O0\u000eH'J\b\u0010u\u001a\u00020\nH&¨\u0006v"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/ChatApi;", "", "acceptInvite", "Lio/getstream/chat/android/client/call/Call;", "Lio/getstream/chat/android/client/models/Channel;", "channelType", "", "channelId", "message", "addDevice", "", "firebaseToken", "addMembers", "members", "", "banUser", "Lio/getstream/chat/android/client/api/models/CompletableResponse;", "targetId", "timeout", "", "reason", "shadow", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lio/getstream/chat/android/client/call/Call;", "deleteChannel", "deleteDevice", "deleteFile", "url", "deleteImage", "deleteMessage", "Lio/getstream/chat/android/client/models/Message;", "messageId", "deleteReaction", "reactionType", "disableSlowMode", "enableSlowMode", "cooldownTimeInSeconds", "flagMessage", "Lio/getstream/chat/android/client/models/Flag;", "flagUser", "userId", "getDevices", "Lio/getstream/chat/android/client/models/Device;", "getGuestUser", "Lio/getstream/chat/android/client/models/GuestUser;", "userName", "getMessage", "getReactions", "Lio/getstream/chat/android/client/models/Reaction;", "offset", "limit", "getReplies", "getRepliesMore", "firstId", "getSyncHistory", "Lio/getstream/chat/android/client/events/ChatEvent;", "channelIds", "lastSyncAt", "Ljava/util/Date;", "hideChannel", "clearHistory", "markAllRead", "markRead", "muteChannel", "muteCurrentUser", "Lio/getstream/chat/android/client/models/Mute;", "muteUser", "queryChannel", "query", "Lio/getstream/chat/android/client/api/models/QueryChannelRequest;", "queryChannels", "Lio/getstream/chat/android/client/api/models/QueryChannelsRequest;", "queryMembers", "Lio/getstream/chat/android/client/models/Member;", "filter", "Lio/getstream/chat/android/client/utils/FilterObject;", "sort", "Lio/getstream/chat/android/client/api/models/QuerySort;", "queryUsers", "Lio/getstream/chat/android/client/models/User;", "Lio/getstream/chat/android/client/api/models/QueryUsersRequest;", "rejectInvite", "removeMembers", "searchMessages", "request", "Lio/getstream/chat/android/client/api/models/SearchMessagesRequest;", "sendAction", "Lio/getstream/chat/android/client/api/models/SendActionRequest;", "sendEvent", "eventType", "extraData", "", "sendFile", "file", "Ljava/io/File;", "callback", "Lio/getstream/chat/android/client/utils/ProgressCallback;", "sendImage", "sendMessage", "sendReaction", "reaction", "enforceUnique", "setConnection", "connectionId", "showChannel", "stopWatching", "translate", "language", "unBanUser", "unMuteChannel", "unmuteCurrentUser", "unmuteUser", "updateChannel", "Lio/getstream/chat/android/client/api/models/UpdateChannelRequest;", "updateMessage", "updateUsers", "users", "warmUp", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.ChatApi */
/* compiled from: ChatApi.kt */
public interface ChatApi {
    Call<Channel> acceptInvite(String str, String str2, String str3);

    Call<Unit> addDevice(String str);

    Call<Channel> addMembers(String str, String str2, List<String> list);

    Call<CompletableResponse> banUser(String str, Integer num, String str2, String str3, String str4, boolean z);

    Call<Channel> deleteChannel(String str, String str2);

    Call<Unit> deleteDevice(String str);

    Call<Unit> deleteFile(String str, String str2, String str3);

    Call<Unit> deleteImage(String str, String str2, String str3);

    Call<Message> deleteMessage(String str);

    Call<Message> deleteReaction(String str, String str2);

    Call<Channel> disableSlowMode(String str, String str2);

    Call<Channel> enableSlowMode(String str, String str2, int i);

    Call<Flag> flagMessage(String str);

    Call<Flag> flagUser(String str);

    Call<List<Device>> getDevices();

    Call<GuestUser> getGuestUser(String str, String str2);

    Call<Message> getMessage(String str);

    Call<List<Reaction>> getReactions(String str, int i, int i2);

    Call<List<Message>> getReplies(String str, int i);

    Call<List<Message>> getRepliesMore(String str, String str2, int i);

    Call<List<ChatEvent>> getSyncHistory(List<String> list, Date date);

    Call<Unit> hideChannel(String str, String str2, boolean z);

    Call<Unit> markAllRead();

    Call<Unit> markRead(String str, String str2, String str3);

    Call<Unit> muteChannel(String str, String str2);

    Call<Mute> muteCurrentUser();

    Call<Mute> muteUser(String str);

    Call<Channel> queryChannel(String str, String str2, QueryChannelRequest queryChannelRequest);

    Call<List<Channel>> queryChannels(QueryChannelsRequest queryChannelsRequest);

    Call<List<Member>> queryMembers(String str, String str2, int i, int i2, FilterObject filterObject, QuerySort<Member> querySort, List<Member> list);

    Call<List<User>> queryUsers(QueryUsersRequest queryUsersRequest);

    Call<Channel> rejectInvite(String str, String str2);

    Call<Channel> removeMembers(String str, String str2, List<String> list);

    Call<List<Message>> searchMessages(SearchMessagesRequest searchMessagesRequest);

    Call<Message> sendAction(SendActionRequest sendActionRequest);

    Call<ChatEvent> sendEvent(String str, String str2, String str3, Map<Object, ? extends Object> map);

    Call<String> sendFile(String str, String str2, File file, ProgressCallback progressCallback);

    Call<String> sendImage(String str, String str2, File file, ProgressCallback progressCallback);

    Call<Message> sendMessage(String str, String str2, Message message);

    Call<Reaction> sendReaction(Reaction reaction, boolean z);

    Call<Reaction> sendReaction(String str, String str2, boolean z);

    void setConnection(String str, String str2);

    Call<Unit> showChannel(String str, String str2);

    Call<Unit> stopWatching(String str, String str2);

    Call<Message> translate(String str, String str2);

    Call<CompletableResponse> unBanUser(String str, String str2, String str3, boolean z);

    Call<Unit> unMuteChannel(String str, String str2);

    Call<Unit> unmuteCurrentUser();

    Call<Unit> unmuteUser(String str);

    Call<Channel> updateChannel(String str, String str2, UpdateChannelRequest updateChannelRequest);

    Call<Message> updateMessage(Message message);

    Call<List<User>> updateUsers(List<User> list);

    void warmUp();

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.api.ChatApi$DefaultImpls */
    /* compiled from: ChatApi.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Call sendFile$default(ChatApi chatApi, String str, String str2, File file, ProgressCallback progressCallback, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    progressCallback = null;
                }
                return chatApi.sendFile(str, str2, file, progressCallback);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendFile");
        }

        public static /* synthetic */ Call sendImage$default(ChatApi chatApi, String str, String str2, File file, ProgressCallback progressCallback, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    progressCallback = null;
                }
                return chatApi.sendImage(str, str2, file, progressCallback);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendImage");
        }

        public static /* synthetic */ Call queryChannel$default(ChatApi chatApi, String str, String str2, QueryChannelRequest queryChannelRequest, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = "";
                }
                return chatApi.queryChannel(str, str2, queryChannelRequest);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryChannel");
        }

        public static /* synthetic */ Call markRead$default(ChatApi chatApi, String str, String str2, String str3, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str3 = "";
                }
                return chatApi.markRead(str, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: markRead");
        }
    }
}
