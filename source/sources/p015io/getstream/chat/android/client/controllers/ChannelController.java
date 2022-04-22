package p015io.getstream.chat.android.client.controllers;

import androidx.lifecycle.LifecycleOwner;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import p015io.getstream.chat.android.client.api.models.QueryChannelRequest;
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.client.api.models.SendActionRequest;
import p015io.getstream.chat.android.client.api.models.WatchChannelRequest;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.events.ChatEvent;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.Mute;
import p015io.getstream.chat.android.client.models.Reaction;
import p015io.getstream.chat.android.client.utils.FilterObject;
import p015io.getstream.chat.android.client.utils.ProgressCallback;
import p015io.getstream.chat.android.client.utils.observable.ChatObservable;
import p015io.getstream.chat.android.client.utils.observable.Disposable;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0003H'J'\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0010\"\u00020\u0003H'¢\u0006\u0002\u0010\u0011J/\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H'¢\u0006\u0002\u0010\u0018J2\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b2\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u001dH'J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u001dH'J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH'J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u000b2\u0006\u0010!\u001a\u00020\u0003H'J\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u000b2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003H'J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH'J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010&\u001a\u00020\u0017H'J\b\u0010'\u001a\u00020(H'J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020 0\u000b2\u0006\u0010!\u001a\u00020\u0003H'J,\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\u001b0\u000b2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u0017H'J,\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001b0\u000b2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0017H'J\u0018\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\b\b\u0002\u00100\u001a\u000201H'J\u000e\u00102\u001a\b\u0012\u0004\u0012\u0002030\u000bH'J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010!\u001a\u00020\u0003H'J\u000e\u00105\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bH'J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bH'J\u000e\u00107\u001a\b\u0012\u0004\u0012\u0002080\u000bH'J\u0016\u00109\u001a\b\u0012\u0004\u0012\u0002080\u000b2\u0006\u0010:\u001a\u00020\u0003H'J\u0016\u0010;\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010<\u001a\u00020=H'JL\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u001b0\u000b2\u0006\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u00172\u0006\u0010@\u001a\u00020A2\u000e\b\u0002\u0010B\u001a\b\u0012\u0004\u0012\u00020?0C2\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020?0\u001bH'J\u000e\u0010D\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH'J'\u0010E\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0010\"\u00020\u0003H'¢\u0006\u0002\u0010\u0011J\u0016\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010\u0014\u001a\u00020\u0003H'J\u0016\u0010G\u001a\b\u0012\u0004\u0012\u00020 0\u000b2\u0006\u0010<\u001a\u00020HH'J\u0016\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010J\u001a\u00020KH'J\u001e\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MH'J\u0016\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010J\u001a\u00020KH'J\u001e\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MH'J\u0016\u0010O\u001a\b\u0012\u0004\u0012\u00020 0\u000b2\u0006\u0010\r\u001a\u00020 H'J \u0010P\u001a\b\u0012\u0004\u0012\u00020+0\u000b2\u0006\u0010Q\u001a\u00020+2\b\b\u0002\u0010R\u001a\u000201H'J/\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H'¢\u0006\u0002\u0010\u0018J\u000e\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bH'J\u000e\u0010U\u001a\b\u0012\u0004\u0012\u0002030\u000bH'J\u000e\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bH'J\u001c\u0010W\u001a\u00020X2\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u00130ZH&J\\\u0010[\u001a\u00020X2\u0006\u0010\\\u001a\u00020]2\"\u0010^\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u0002030_0\u0010\"\n\u0012\u0006\b\u0001\u0012\u0002030_2!\u0010Y\u001a\u001d\u0012\u0013\u0012\u001103¢\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(b\u0012\u0004\u0012\u00020\u00130ZH&¢\u0006\u0002\u0010cJL\u0010[\u001a\u00020X2\u0006\u0010\\\u001a\u00020]2\u0012\u0010^\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0010\"\u00020\u00032!\u0010Y\u001a\u001d\u0012\u0013\u0012\u001103¢\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(b\u0012\u0004\u0012\u00020\u00130ZH&¢\u0006\u0002\u0010dJT\u0010[\u001a\u00020X2\"\u0010^\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u0002030_0\u0010\"\n\u0012\u0006\b\u0001\u0012\u0002030_2!\u0010Y\u001a\u001d\u0012\u0013\u0012\u001103¢\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(b\u0012\u0004\u0012\u00020\u00130ZH&¢\u0006\u0002\u0010eJ5\u0010[\u001a\u00020X2\u0012\u0010^\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0010\"\u00020\u00032\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u00130ZH&¢\u0006\u0002\u0010fJC\u0010g\u001a\u00020X\"\b\b\u0000\u0010h*\u0002032\f\u0010i\u001a\b\u0012\u0004\u0012\u0002Hh0_2!\u0010Y\u001a\u001d\u0012\u0013\u0012\u0011Hh¢\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(b\u0012\u0004\u0012\u00020\u00130ZH&J3\u0010g\u001a\u00020X2\u0006\u0010i\u001a\u00020\u00032!\u0010Y\u001a\u001d\u0012\u0013\u0012\u001103¢\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(b\u0012\u0004\u0012\u00020\u00130ZH&J\u0016\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010\u0014\u001a\u00020\u0003H'J\u000e\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bH'J\u000e\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bH'J\u0016\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010:\u001a\u00020\u0003H'J0\u0010n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010 2\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u001dH'J\u0016\u0010o\u001a\b\u0012\u0004\u0012\u00020 0\u000b2\u0006\u0010\r\u001a\u00020 H'J\u000e\u0010p\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH'J\u0016\u0010p\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010<\u001a\u00020qH'J\"\u0010p\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u001dH'R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005¨\u0006s"}, mo26107d2 = {"Lio/getstream/chat/android/client/controllers/ChannelController;", "", "channelId", "", "getChannelId", "()Ljava/lang/String;", "channelType", "getChannelType", "cid", "getCid", "acceptInvite", "Lio/getstream/chat/android/client/call/Call;", "Lio/getstream/chat/android/client/models/Channel;", "message", "addMembers", "userIds", "", "([Ljava/lang/String;)Lio/getstream/chat/android/client/call/Call;", "banUser", "", "targetId", "reason", "timeout", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lio/getstream/chat/android/client/call/Call;", "create", "members", "", "extraData", "", "delete", "deleteMessage", "Lio/getstream/chat/android/client/models/Message;", "messageId", "deleteReaction", "reactionType", "disableSlowMode", "enableSlowMode", "cooldownTimeInSeconds", "events", "Lio/getstream/chat/android/client/utils/observable/ChatObservable;", "getMessage", "getReactions", "Lio/getstream/chat/android/client/models/Reaction;", "offset", "limit", "firstReactionId", "hide", "clearHistory", "", "keystroke", "Lio/getstream/chat/android/client/events/ChatEvent;", "markMessageRead", "markRead", "mute", "muteCurrentUser", "Lio/getstream/chat/android/client/models/Mute;", "muteUser", "userId", "query", "request", "Lio/getstream/chat/android/client/api/models/QueryChannelRequest;", "queryMembers", "Lio/getstream/chat/android/client/models/Member;", "filter", "Lio/getstream/chat/android/client/utils/FilterObject;", "sort", "Lio/getstream/chat/android/client/api/models/QuerySort;", "rejectInvite", "removeMembers", "removeShadowBan", "sendAction", "Lio/getstream/chat/android/client/api/models/SendActionRequest;", "sendFile", "file", "Ljava/io/File;", "callback", "Lio/getstream/chat/android/client/utils/ProgressCallback;", "sendImage", "sendMessage", "sendReaction", "reaction", "enforceUnique", "shadowBanUser", "show", "stopTyping", "stopWatching", "subscribe", "Lio/getstream/chat/android/client/utils/observable/Disposable;", "listener", "Lkotlin/Function1;", "subscribeFor", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "eventTypes", "Ljava/lang/Class;", "Lkotlin/ParameterName;", "name", "event", "(Landroidx/lifecycle/LifecycleOwner;[Ljava/lang/Class;Lkotlin/jvm/functions/Function1;)Lio/getstream/chat/android/client/utils/observable/Disposable;", "(Landroidx/lifecycle/LifecycleOwner;[Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lio/getstream/chat/android/client/utils/observable/Disposable;", "([Ljava/lang/Class;Lkotlin/jvm/functions/Function1;)Lio/getstream/chat/android/client/utils/observable/Disposable;", "([Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lio/getstream/chat/android/client/utils/observable/Disposable;", "subscribeForSingle", "T", "eventType", "unBanUser", "unmute", "unmuteCurrentUser", "unmuteUser", "update", "updateMessage", "watch", "Lio/getstream/chat/android/client/api/models/WatchChannelRequest;", "data", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
@Deprecated(level = DeprecationLevel.ERROR, message = "The ChannelController has been replaced by ChannelClient", replaceWith = @ReplaceWith(expression = "ChannelClient", imports = {}))
/* renamed from: io.getstream.chat.android.client.controllers.ChannelController */
/* compiled from: ChannelController.kt */
public interface ChannelController {
    Call<Channel> acceptInvite(String str);

    Call<Channel> addMembers(String... strArr);

    Call<Unit> banUser(String str, String str2, Integer num);

    Call<Channel> create(List<String> list, Map<String, ? extends Object> map);

    Call<Channel> create(Map<String, ? extends Object> map);

    Call<Channel> delete();

    Call<Message> deleteMessage(String str);

    Call<Message> deleteReaction(String str, String str2);

    Call<Channel> disableSlowMode();

    Call<Channel> enableSlowMode(int i);

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use subscribe() on the controller directly instead")
    ChatObservable events();

    String getChannelId();

    String getChannelType();

    String getCid();

    Call<Message> getMessage(String str);

    Call<List<Reaction>> getReactions(String str, int i, int i2);

    Call<List<Message>> getReactions(String str, String str2, int i);

    Call<Unit> hide(boolean z);

    Call<ChatEvent> keystroke();

    Call<Unit> markMessageRead(String str);

    Call<Unit> markRead();

    Call<Unit> mute();

    Call<Mute> muteCurrentUser();

    Call<Mute> muteUser(String str);

    Call<Channel> query(QueryChannelRequest queryChannelRequest);

    Call<List<Member>> queryMembers(int i, int i2, FilterObject filterObject, QuerySort<Member> querySort, List<Member> list);

    Call<Channel> rejectInvite();

    Call<Channel> removeMembers(String... strArr);

    Call<Unit> removeShadowBan(String str);

    Call<Message> sendAction(SendActionRequest sendActionRequest);

    Call<String> sendFile(File file);

    Call<String> sendFile(File file, ProgressCallback progressCallback);

    Call<String> sendImage(File file);

    Call<String> sendImage(File file, ProgressCallback progressCallback);

    Call<Message> sendMessage(Message message);

    Call<Reaction> sendReaction(Reaction reaction, boolean z);

    Call<Unit> shadowBanUser(String str, String str2, Integer num);

    Call<Unit> show();

    Call<ChatEvent> stopTyping();

    Call<Unit> stopWatching();

    Disposable subscribe(Function1<? super ChatEvent, Unit> function1);

    Disposable subscribeFor(LifecycleOwner lifecycleOwner, Class<? extends ChatEvent>[] clsArr, Function1<? super ChatEvent, Unit> function1);

    Disposable subscribeFor(LifecycleOwner lifecycleOwner, String[] strArr, Function1<? super ChatEvent, Unit> function1);

    Disposable subscribeFor(Class<? extends ChatEvent>[] clsArr, Function1<? super ChatEvent, Unit> function1);

    Disposable subscribeFor(String[] strArr, Function1<? super ChatEvent, Unit> function1);

    <T extends ChatEvent> Disposable subscribeForSingle(Class<T> cls, Function1<? super T, Unit> function1);

    Disposable subscribeForSingle(String str, Function1<? super ChatEvent, Unit> function1);

    Call<Unit> unBanUser(String str);

    Call<Unit> unmute();

    Call<Unit> unmuteCurrentUser();

    Call<Unit> unmuteUser(String str);

    Call<Channel> update(Message message, Map<String, ? extends Object> map);

    Call<Message> updateMessage(Message message);

    Call<Channel> watch();

    Call<Channel> watch(WatchChannelRequest watchChannelRequest);

    Call<Channel> watch(Map<String, ? extends Object> map);

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.controllers.ChannelController$DefaultImpls */
    /* compiled from: ChannelController.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Call create$default(ChannelController channelController, Map map, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    map = MapsKt.emptyMap();
                }
                return channelController.create(map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: create");
        }

        public static /* synthetic */ Call create$default(ChannelController channelController, List list, Map map, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    map = MapsKt.emptyMap();
                }
                return channelController.create(list, map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: create");
        }

        public static /* synthetic */ Call hide$default(ChannelController channelController, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                return channelController.hide(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hide");
        }

        public static /* synthetic */ Call sendReaction$default(ChannelController channelController, Reaction reaction, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return channelController.sendReaction(reaction, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendReaction");
        }

        public static /* synthetic */ Call update$default(ChannelController channelController, Message message, Map map, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    message = null;
                }
                if ((i & 2) != 0) {
                    map = MapsKt.emptyMap();
                }
                return channelController.update(message, map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update");
        }

        public static /* synthetic */ Call queryMembers$default(ChannelController channelController, int i, int i2, FilterObject filterObject, QuerySort querySort, List list, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    querySort = new QuerySort();
                }
                QuerySort querySort2 = querySort;
                if ((i3 & 16) != 0) {
                    list = CollectionsKt.emptyList();
                }
                return channelController.queryMembers(i, i2, filterObject, querySort2, list);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryMembers");
        }
    }
}
