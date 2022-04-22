package p015io.getstream.chat.android.livedata;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import p015io.getstream.chat.android.client.events.ChatEvent;
import p015io.getstream.chat.android.client.events.ConnectedEvent;
import p015io.getstream.chat.android.client.events.DisconnectedEvent;
import p015io.getstream.chat.android.client.events.HealthEvent;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.TaggedLogger;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.Reaction;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0000¢\u0006\u0002\b\u000eJ\u001b\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0000¢\u0006\u0002\b\u0015J\u001f\u0010\u0016\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J!\u0010\u0018\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\fH@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0017J\u001e\u0010\u001a\u001a\u00020\n*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u001c\u0010 \u001a\u00020\n*\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/EventHandlerImpl;", "", "domainImpl", "Lio/getstream/chat/android/livedata/ChatDomainImpl;", "(Lio/getstream/chat/android/livedata/ChatDomainImpl;)V", "firstConnect", "", "logger", "Lio/getstream/chat/android/client/logger/TaggedLogger;", "handleConnectEvents", "", "sortedEvents", "", "Lio/getstream/chat/android/client/events/ChatEvent;", "handleConnectEvents$stream_chat_android_offline_release", "handleEvent", "event", "handleEvent$stream_chat_android_offline_release", "(Lio/getstream/chat/android/client/events/ChatEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleEvents", "events", "handleEvents$stream_chat_android_offline_release", "handleEventsInternal", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateOfflineStorageFromEvents", "updateOfflineStorageFromEvents$stream_chat_android_offline_release", "enrichWithOwnReactions", "Lio/getstream/chat/android/client/models/Message;", "batch", "Lio/getstream/chat/android/livedata/EventBatchUpdate;", "user", "Lio/getstream/chat/android/client/models/User;", "incrementUnreadCountIfNecessary", "cid", "", "message", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.EventHandlerImpl */
/* compiled from: EventHandlerImpl.kt */
public final class EventHandlerImpl {
    /* access modifiers changed from: private */
    public final ChatDomainImpl domainImpl;
    /* access modifiers changed from: private */
    public boolean firstConnect = true;
    private TaggedLogger logger = ChatLogger.Companion.get("EventHandler");

    public EventHandlerImpl(ChatDomainImpl chatDomainImpl) {
        Intrinsics.checkNotNullParameter(chatDomainImpl, "domainImpl");
        this.domainImpl = chatDomainImpl;
    }

    public final void handleEvents$stream_chat_android_offline_release(List<? extends ChatEvent> list) {
        Intrinsics.checkNotNullParameter(list, "events");
        handleConnectEvents$stream_chat_android_offline_release(list);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.domainImpl.getScope$stream_chat_android_offline_release(), (CoroutineContext) null, (CoroutineStart) null, new EventHandlerImpl$handleEvents$1(this, list, (Continuation) null), 3, (Object) null);
    }

    public final void handleConnectEvents$stream_chat_android_offline_release(List<? extends ChatEvent> list) {
        Intrinsics.checkNotNullParameter(list, "sortedEvents");
        for (ChatEvent chatEvent : list) {
            if (chatEvent instanceof DisconnectedEvent) {
                this.domainImpl.setOffline$stream_chat_android_offline_release();
            } else if (chatEvent instanceof ConnectedEvent) {
                this.logger.logI("Received ConnectedEvent, marking the domain as online and initialized");
                this.domainImpl.isInitialized();
                this.domainImpl.setOnline$stream_chat_android_offline_release();
                this.domainImpl.setInitialized$stream_chat_android_offline_release();
                Job unused = BuildersKt__Builders_commonKt.launch$default(this.domainImpl.getScope$stream_chat_android_offline_release(), (CoroutineContext) null, (CoroutineStart) null, new EventHandlerImpl$handleConnectEvents$1(this, (Continuation) null), 3, (Object) null);
            } else if (chatEvent instanceof HealthEvent) {
                Job unused2 = BuildersKt__Builders_commonKt.launch$default(this.domainImpl.getScope$stream_chat_android_offline_release(), (CoroutineContext) null, (CoroutineStart) null, new EventHandlerImpl$handleConnectEvents$2(this, (Continuation) null), 3, (Object) null);
            }
        }
    }

    public final Object handleEvent$stream_chat_android_offline_release(ChatEvent chatEvent, Continuation<? super Unit> continuation) {
        handleConnectEvents$stream_chat_android_offline_release(CollectionsKt.listOf(chatEvent));
        Object handleEventsInternal = handleEventsInternal(CollectionsKt.listOf(chatEvent), continuation);
        if (handleEventsInternal == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return handleEventsInternal;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:176:0x03b5, code lost:
        r15 = r5;
        r5 = (p015io.getstream.chat.android.livedata.EventBatchUpdate) r2;
        r2 = r1;
        r1 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x03c3, code lost:
        if (r1.hasNext() == false) goto L_0x0992;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x03c5, code lost:
        r9 = (p015io.getstream.chat.android.client.events.ChatEvent) r1.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x03cd, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.NewMessageEvent) == false) goto L_0x0408;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x03cf, code lost:
        r9 = (p015io.getstream.chat.android.client.events.NewMessageEvent) r9;
        p015io.getstream.chat.android.client.extensions.MessageExtensionsKt.enrichWithCid(r9.getMessage(), r9.getCid());
        r15.enrichWithOwnReactions(r9.getMessage(), r5, r9.getUser());
        r10 = r9.getTotalUnreadCount();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x03eb, code lost:
        if (r10 == null) goto L_0x03fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x03ed, code lost:
        r15.domainImpl.setTotalUnreadCount(r10.intValue());
        r10 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x03fa, code lost:
        r5.addMessageData(r9.getCid(), r9.getMessage(), true);
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x040a, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.MessageDeletedEvent) == false) goto L_0x0436;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x040c, code lost:
        r9 = (p015io.getstream.chat.android.client.events.MessageDeletedEvent) r9;
        p015io.getstream.chat.android.client.extensions.MessageExtensionsKt.enrichWithCid(r9.getMessage(), r9.getCid());
        r15.enrichWithOwnReactions(r9.getMessage(), r5, r9.getUser());
        p015io.getstream.chat.android.livedata.EventBatchUpdate.addMessageData$default(r5, r9.getCid(), r9.getMessage(), false, 4, (java.lang.Object) null);
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0438, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.MessageUpdatedEvent) == false) goto L_0x0465;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x043a, code lost:
        r9 = (p015io.getstream.chat.android.client.events.MessageUpdatedEvent) r9;
        p015io.getstream.chat.android.client.extensions.MessageExtensionsKt.enrichWithCid(r9.getMessage(), r9.getCid());
        r15.enrichWithOwnReactions(r9.getMessage(), r5, r9.getUser());
        p015io.getstream.chat.android.livedata.EventBatchUpdate.addMessageData$default(r5, r9.getCid(), r9.getMessage(), false, 4, (java.lang.Object) null);
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0467, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.NotificationMessageNewEvent) == false) goto L_0x0498;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0469, code lost:
        r9 = (p015io.getstream.chat.android.client.events.NotificationMessageNewEvent) r9;
        p015io.getstream.chat.android.client.extensions.MessageExtensionsKt.enrichWithCid(r9.getMessage(), r9.getCid());
        r10 = r9.getTotalUnreadCount();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x047a, code lost:
        if (r10 == null) goto L_0x0489;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x047c, code lost:
        r15.domainImpl.setTotalUnreadCount(r10.intValue());
        r10 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0489, code lost:
        r5.addMessageData(r9.getCid(), r9.getMessage(), true);
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x049a, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.NotificationAddedToChannelEvent) == false) goto L_0x04a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x049c, code lost:
        r5.addChannel(((p015io.getstream.chat.android.client.events.NotificationAddedToChannelEvent) r9).getChannel());
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x04ab, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.NotificationInvitedEvent) == false) goto L_0x04bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x04ad, code lost:
        r9 = ((p015io.getstream.chat.android.client.events.NotificationInvitedEvent) r9).getUser();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x04b3, code lost:
        if (r9 == null) goto L_0x03bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x04b5, code lost:
        r5.addUser(r9);
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x04be, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.NotificationInviteAcceptedEvent) == false) goto L_0x04cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x04c0, code lost:
        r9 = ((p015io.getstream.chat.android.client.events.NotificationInviteAcceptedEvent) r9).getUser();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x04c6, code lost:
        if (r9 == null) goto L_0x03bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x04c8, code lost:
        r5.addUser(r9);
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x04d1, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.ChannelHiddenEvent) == false) goto L_0x0505;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x04d3, code lost:
        r10 = (p015io.getstream.chat.android.client.events.ChannelHiddenEvent) r9;
        r11 = r5.getCurrentChannel(r10.getCid());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x04de, code lost:
        if (r11 == null) goto L_0x03bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x04e0, code lost:
        r11.setHidden(kotlin.coroutines.jvm.internal.Boxing.boxBoolean(true));
        r9 = r9.getCreatedAt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x04f7, code lost:
        if (kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10.getClearHistory()).booleanValue() == false) goto L_0x04fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x04fa, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x04fb, code lost:
        r11.setHiddenMessagesBefore(r9);
        r5.addChannel(r11);
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0508, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.ChannelVisibleEvent) == false) goto L_0x0526;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x050a, code lost:
        r9 = r5.getCurrentChannel(((p015io.getstream.chat.android.client.events.ChannelVisibleEvent) r9).getCid());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x0514, code lost:
        if (r9 == null) goto L_0x03bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x0516, code lost:
        r9.setHidden(kotlin.coroutines.jvm.internal.Boxing.boxBoolean(false));
        r10 = kotlin.Unit.INSTANCE;
        r5.addChannel(r9);
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x0528, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.NotificationMutesUpdatedEvent) == false) goto L_0x054e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x052a, code lost:
        r10 = r15.domainImpl;
        r9 = ((p015io.getstream.chat.android.client.events.NotificationMutesUpdatedEvent) r9).getMe();
        r3.L$0 = r15;
        r3.L$1 = r2;
        r3.L$2 = r5;
        r3.L$3 = r1;
        r3.L$4 = null;
        r3.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x0543, code lost:
        if (r10.updateCurrentUser$stream_chat_android_offline_release(r9, r3) != r4) goto L_0x0546;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0545, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x0546, code lost:
        r9 = r2;
        r10 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x0548, code lost:
        r2 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x054a, code lost:
        r2 = r9;
        r15 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x0550, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.ConnectedEvent) == false) goto L_0x0573;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x0552, code lost:
        r10 = r15.domainImpl;
        r9 = ((p015io.getstream.chat.android.client.events.ConnectedEvent) r9).getMe();
        r3.L$0 = r15;
        r3.L$1 = r2;
        r3.L$2 = r5;
        r3.L$3 = r1;
        r3.L$4 = null;
        r3.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x056b, code lost:
        if (r10.updateCurrentUser$stream_chat_android_offline_release(r9, r3) != r4) goto L_0x056e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x056d, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x056e, code lost:
        r9 = r2;
        r10 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0570, code lost:
        r2 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x0575, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.ReactionNewEvent) == false) goto L_0x059a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0577, code lost:
        r9 = (p015io.getstream.chat.android.client.events.ReactionNewEvent) r9;
        p015io.getstream.chat.android.client.extensions.MessageExtensionsKt.enrichWithCid(r9.getMessage(), r9.getCid());
        r15.enrichWithOwnReactions(r9.getMessage(), r5, r9.getUser());
        r5.addMessage(r9.getMessage());
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x059c, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.ReactionDeletedEvent) == false) goto L_0x05c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x059e, code lost:
        r9 = (p015io.getstream.chat.android.client.events.ReactionDeletedEvent) r9;
        p015io.getstream.chat.android.client.extensions.MessageExtensionsKt.enrichWithCid(r9.getMessage(), r9.getCid());
        r15.enrichWithOwnReactions(r9.getMessage(), r5, r9.getUser());
        r5.addMessage(r9.getMessage());
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x05c3, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.ReactionUpdateEvent) == false) goto L_0x05e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x05c5, code lost:
        r9 = (p015io.getstream.chat.android.client.events.ReactionUpdateEvent) r9;
        p015io.getstream.chat.android.client.extensions.MessageExtensionsKt.enrichWithCid(r9.getMessage(), r9.getCid());
        r15.enrichWithOwnReactions(r9.getMessage(), r5, r9.getUser());
        r5.addMessage(r9.getMessage());
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x05ea, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.MemberAddedEvent) == false) goto L_0x0614;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x05ec, code lost:
        r9 = (p015io.getstream.chat.android.client.events.MemberAddedEvent) r9;
        r10 = r5.getCurrentChannel(r9.getCid());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x05f6, code lost:
        if (r10 == null) goto L_0x03bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x05f8, code lost:
        p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.setMember(r10, r9.getMember().getUser().getId(), r9.getMember());
        r9 = kotlin.Unit.INSTANCE;
        r5.addChannel(r10);
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x0616, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.MemberUpdatedEvent) == false) goto L_0x0640;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x0618, code lost:
        r9 = (p015io.getstream.chat.android.client.events.MemberUpdatedEvent) r9;
        r10 = r5.getCurrentChannel(r9.getCid());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x0622, code lost:
        if (r10 == null) goto L_0x03bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x0624, code lost:
        p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.setMember(r10, r9.getMember().getUser().getId(), r9.getMember());
        r9 = kotlin.Unit.INSTANCE;
        r5.addChannel(r10);
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x0642, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.MemberRemovedEvent) == false) goto L_0x0664;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x0644, code lost:
        r9 = (p015io.getstream.chat.android.client.events.MemberRemovedEvent) r9;
        r10 = r5.getCurrentChannel(r9.getCid());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x064e, code lost:
        if (r10 == null) goto L_0x03bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x0650, code lost:
        p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.setMember(r10, r9.getUser().getId(), (p015io.getstream.chat.android.client.models.Member) null);
        r9 = kotlin.Unit.INSTANCE;
        r5.addChannel(r10);
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x0666, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.NotificationRemovedFromChannelEvent) == false) goto L_0x068a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x0668, code lost:
        r9 = (p015io.getstream.chat.android.client.events.NotificationRemovedFromChannelEvent) r9;
        r10 = r5.getCurrentChannel(r9.getCid());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x0672, code lost:
        if (r10 == null) goto L_0x03bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:0x0674, code lost:
        r9 = r9.getUser();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:0x0678, code lost:
        if (r9 == null) goto L_0x0683;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:268:0x067a, code lost:
        p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.setMember(r10, r9.getId(), (p015io.getstream.chat.android.client.models.Member) null);
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x0683, code lost:
        r5.addChannel(r10);
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x068c, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.ChannelUpdatedEvent) == false) goto L_0x069b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x068e, code lost:
        r5.addChannel(((p015io.getstream.chat.android.client.events.ChannelUpdatedEvent) r9).getChannel());
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x069d, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.ChannelUpdatedByUserEvent) == false) goto L_0x06ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x069f, code lost:
        r5.addChannel(((p015io.getstream.chat.android.client.events.ChannelUpdatedByUserEvent) r9).getChannel());
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x06ae, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.ChannelDeletedEvent) == false) goto L_0x06bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x06b0, code lost:
        r5.addChannel(((p015io.getstream.chat.android.client.events.ChannelDeletedEvent) r9).getChannel());
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x06bf, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.ChannelCreatedEvent) == false) goto L_0x06ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x06c1, code lost:
        r5.addChannel(((p015io.getstream.chat.android.client.events.ChannelCreatedEvent) r9).getChannel());
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x06d0, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.ChannelMuteEvent) == false) goto L_0x06e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:284:0x06d2, code lost:
        r5.addChannel(((p015io.getstream.chat.android.client.events.ChannelMuteEvent) r9).getChannelMute().getChannel());
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x06e5, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.ChannelsMuteEvent) == false) goto L_0x070b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x06e7, code lost:
        r9 = ((p015io.getstream.chat.android.client.events.ChannelsMuteEvent) r9).getChannelsMute().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x06f7, code lost:
        if (r9.hasNext() == false) goto L_0x0707;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:290:0x06f9, code lost:
        r5.addChannel(((p015io.getstream.chat.android.client.models.ChannelMute) r9.next()).getChannel());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x0707, code lost:
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x070d, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.ChannelUnmuteEvent) == false) goto L_0x0720;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:294:0x070f, code lost:
        r5.addChannel(((p015io.getstream.chat.android.client.events.ChannelUnmuteEvent) r9).getChannelMute().getChannel());
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x0722, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.ChannelsUnmuteEvent) == false) goto L_0x0748;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x0724, code lost:
        r9 = ((p015io.getstream.chat.android.client.events.ChannelsUnmuteEvent) r9).getChannelsMute().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x0734, code lost:
        if (r9.hasNext() == false) goto L_0x0744;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x0736, code lost:
        r5.addChannel(((p015io.getstream.chat.android.client.models.ChannelMute) r9.next()).getChannel());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x0744, code lost:
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x074a, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.ChannelTruncatedEvent) == false) goto L_0x0759;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:304:0x074c, code lost:
        r5.addChannel(((p015io.getstream.chat.android.client.events.ChannelTruncatedEvent) r9).getChannel());
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x075b, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.NotificationChannelDeletedEvent) == false) goto L_0x0773;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x075d, code lost:
        r9 = (p015io.getstream.chat.android.client.events.NotificationChannelDeletedEvent) r9;
        r5.addChannel(r9.getChannel());
        r9 = r9.getUser();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x076a, code lost:
        if (r9 == null) goto L_0x03bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:309:0x076c, code lost:
        r5.addUser(r9);
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:311:0x0775, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.NotificationChannelMutesUpdatedEvent) == false) goto L_0x0799;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:312:0x0777, code lost:
        r10 = r15.domainImpl;
        r9 = ((p015io.getstream.chat.android.client.events.NotificationChannelMutesUpdatedEvent) r9).getMe();
        r3.L$0 = r15;
        r3.L$1 = r2;
        r3.L$2 = r5;
        r3.L$3 = r1;
        r3.L$4 = null;
        r3.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:313:0x0790, code lost:
        if (r10.updateCurrentUser$stream_chat_android_offline_release(r9, r3) != r4) goto L_0x0793;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:314:0x0792, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:315:0x0793, code lost:
        r9 = r2;
        r10 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x0795, code lost:
        r2 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:318:0x079b, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.NotificationChannelTruncatedEvent) == false) goto L_0x07aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:319:0x079d, code lost:
        r5.addChannel(((p015io.getstream.chat.android.client.events.NotificationChannelTruncatedEvent) r9).getChannel());
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:321:0x07ac, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.MarkAllReadEvent) == false) goto L_0x085c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:322:0x07ae, code lost:
        r10 = (p015io.getstream.chat.android.client.events.MarkAllReadEvent) r9;
        r15.domainImpl.setTotalUnreadCount(kotlin.coroutines.jvm.internal.Boxing.boxInt(r10.getTotalUnreadCount()).intValue());
        r15.domainImpl.setChannelUnreadCount(kotlin.coroutines.jvm.internal.Boxing.boxInt(r10.getUnreadChannels()).intValue());
        r11 = r15.domainImpl.getRepos$stream_chat_android_offline_release();
        r10 = r10.getUser().getId();
        r3.L$0 = r15;
        r3.L$1 = r2;
        r3.L$2 = r5;
        r3.L$3 = r9;
        r3.L$4 = r1;
        r3.label = 5;
        r10 = r11.selectSyncState(r10, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:323:0x07f6, code lost:
        if (r10 != r4) goto L_0x07f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x07f8, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:325:0x07f9, code lost:
        r24 = r10;
        r10 = r2;
        r2 = r24;
        r25 = r9;
        r9 = r5;
        r5 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:326:0x0803, code lost:
        r16 = (p015io.getstream.chat.android.livedata.model.SyncState) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:327:0x0807, code lost:
        if (r16 == null) goto L_0x0858;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:329:0x080d, code lost:
        if (r16.getMarkedAllReadAt() == null) goto L_0x0821;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:331:0x081b, code lost:
        if (r16.getMarkedAllReadAt().before(r5.getCreatedAt()) == false) goto L_0x081e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:332:0x081e, code lost:
        r5 = r9;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:333:0x0821, code lost:
        r2 = r15.domainImpl.getRepos$stream_chat_android_offline_release();
        r5 = p015io.getstream.chat.android.livedata.model.SyncState.copy$default(r16, (java.lang.String) null, (java.util.List) null, (java.util.List) null, (java.util.Date) null, r5.getCreatedAt(), 15, (java.lang.Object) null);
        r3.L$0 = r15;
        r3.L$1 = r10;
        r3.L$2 = r9;
        r3.L$3 = r1;
        r3.L$4 = null;
        r3.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:334:0x084c, code lost:
        if (r2.insertSyncState(r5, r3) != r4) goto L_0x084f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:335:0x084e, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:336:0x084f, code lost:
        r5 = r9;
        r9 = r10;
        r10 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:337:0x0852, code lost:
        r2 = r9;
        r15 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:338:0x0854, code lost:
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:339:0x0858, code lost:
        r5 = r9;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:341:0x085e, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.MessageReadEvent) == false) goto L_0x088e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:342:0x0860, code lost:
        r10 = (p015io.getstream.chat.android.client.events.MessageReadEvent) r9;
        r11 = r5.getCurrentChannel(r10.getCid());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:343:0x086b, code lost:
        if (r11 == null) goto L_0x03bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:344:0x086d, code lost:
        p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.updateReads(r11, new p015io.getstream.chat.android.client.models.ChannelUserRead(r10.getUser(), r9.getCreatedAt(), 0, 4, (kotlin.jvm.internal.DefaultConstructorMarker) null));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:345:0x0885, code lost:
        if (r11 == null) goto L_0x03bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:346:0x0887, code lost:
        r5.addChannel(r11);
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:348:0x0890, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.NotificationMarkReadEvent) == false) goto L_0x08d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:349:0x0892, code lost:
        r10 = (p015io.getstream.chat.android.client.events.NotificationMarkReadEvent) r9;
        r11 = r10.getTotalUnreadCount();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:350:0x0899, code lost:
        if (r11 == null) goto L_0x08a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:351:0x089b, code lost:
        r15.domainImpl.setTotalUnreadCount(r11.intValue());
        r11 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:352:0x08a8, code lost:
        r11 = r5.getCurrentChannel(r10.getCid());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:353:0x08b0, code lost:
        if (r11 == null) goto L_0x03bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:354:0x08b2, code lost:
        p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.updateReads(r11, new p015io.getstream.chat.android.client.models.ChannelUserRead(r10.getUser(), r9.getCreatedAt(), 0, 4, (kotlin.jvm.internal.DefaultConstructorMarker) null));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:355:0x08ca, code lost:
        if (r11 == null) goto L_0x03bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:356:0x08cc, code lost:
        r5.addChannel(r11);
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:358:0x08d5, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.UserMutedEvent) == false) goto L_0x08e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:0x08d7, code lost:
        r5.addUser(((p015io.getstream.chat.android.client.events.UserMutedEvent) r9).getTargetUser());
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:0x08e6, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.UsersMutedEvent) == false) goto L_0x08f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:362:0x08e8, code lost:
        r5.addUsers(((p015io.getstream.chat.android.client.events.UsersMutedEvent) r9).getTargetUsers());
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:364:0x08f7, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.UserUnmutedEvent) == false) goto L_0x0906;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:0x08f9, code lost:
        r5.addUser(((p015io.getstream.chat.android.client.events.UserUnmutedEvent) r9).getTargetUser());
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:0x0908, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.UsersUnmutedEvent) == false) goto L_0x0917;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:368:0x090a, code lost:
        r5.addUsers(((p015io.getstream.chat.android.client.events.UsersUnmutedEvent) r9).getTargetUsers());
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:370:0x0919, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.GlobalUserBannedEvent) == false) goto L_0x092d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:0x091b, code lost:
        r9 = ((p015io.getstream.chat.android.client.events.GlobalUserBannedEvent) r9).getUser();
        r9.setBanned(true);
        r10 = kotlin.Unit.INSTANCE;
        r5.addUser(r9);
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:373:0x092f, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.GlobalUserUnbannedEvent) == false) goto L_0x0943;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:374:0x0931, code lost:
        r9 = ((p015io.getstream.chat.android.client.events.GlobalUserUnbannedEvent) r9).getUser();
        r9.setBanned(false);
        r10 = kotlin.Unit.INSTANCE;
        r5.addUser(r9);
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:0x0945, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.TypingStartEvent) == false) goto L_0x0948;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:378:0x094a, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.TypingStopEvent) == false) goto L_0x094d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:380:0x094f, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.HealthEvent) == false) goto L_0x0952;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:382:0x0954, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.ConnectingEvent) == false) goto L_0x0957;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:384:0x0959, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.DisconnectedEvent) == false) goto L_0x095c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:386:0x095e, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.ErrorEvent) == false) goto L_0x0961;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:388:0x0963, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.UnknownEvent) == false) goto L_0x0966;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:390:0x0968, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.ChannelUserBannedEvent) == false) goto L_0x096b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:392:0x096d, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.ChannelUserUnbannedEvent) == false) goto L_0x0970;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:394:0x0972, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.UserUpdatedEvent) == false) goto L_0x0975;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:396:0x0977, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.UserDeletedEvent) == false) goto L_0x097a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:398:0x097c, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.UserPresenceChangedEvent) == false) goto L_0x097f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:400:0x0981, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.UserStartWatchingEvent) == false) goto L_0x0984;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:402:0x0986, code lost:
        if ((r9 instanceof p015io.getstream.chat.android.client.events.UserStopWatchingEvent) == false) goto L_0x098c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:403:0x0988, code lost:
        r9 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:405:0x0991, code lost:
        throw new kotlin.NoWhenBranchMatchedException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:406:0x0992, code lost:
        r3.L$0 = r15;
        r3.L$1 = r2;
        r3.L$2 = null;
        r3.L$3 = null;
        r3.L$4 = null;
        r3.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:407:0x09a3, code lost:
        if (r5.execute(r3) != r4) goto L_0x09a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:408:0x09a5, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:409:0x09a6, code lost:
        r1 = r2;
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:410:0x09a8, code lost:
        r1 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:412:0x09b0, code lost:
        if (r1.hasNext() == false) goto L_0x0a46;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:413:0x09b2, code lost:
        r2 = (p015io.getstream.chat.android.client.events.ChatEvent) r1.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:414:0x09ba, code lost:
        if ((r2 instanceof p015io.getstream.chat.android.client.events.NotificationChannelTruncatedEvent) == false) goto L_0x09dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:415:0x09bc, code lost:
        r7 = r5.domainImpl.getRepos$stream_chat_android_offline_release();
        r9 = ((p015io.getstream.chat.android.client.events.NotificationChannelTruncatedEvent) r2).getCid();
        r2 = r2.getCreatedAt();
        r3.L$0 = r5;
        r3.L$1 = r1;
        r3.label = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:416:0x09d9, code lost:
        if (r7.deleteChannelMessagesBefore(r9, r2, r3) != r4) goto L_0x09ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:417:0x09db, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:419:0x09de, code lost:
        if ((r2 instanceof p015io.getstream.chat.android.client.events.ChannelTruncatedEvent) == false) goto L_0x0a00;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:420:0x09e0, code lost:
        r7 = r5.domainImpl.getRepos$stream_chat_android_offline_release();
        r9 = ((p015io.getstream.chat.android.client.events.ChannelTruncatedEvent) r2).getCid();
        r2 = r2.getCreatedAt();
        r3.L$0 = r5;
        r3.L$1 = r1;
        r3.label = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:421:0x09fd, code lost:
        if (r7.deleteChannelMessagesBefore(r9, r2, r3) != r4) goto L_0x09ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:422:0x09ff, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:424:0x0a02, code lost:
        if ((r2 instanceof p015io.getstream.chat.android.client.events.ChannelDeletedEvent) == false) goto L_0x09ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:425:0x0a04, code lost:
        r7 = r5.domainImpl.getRepos$stream_chat_android_offline_release();
        r9 = ((p015io.getstream.chat.android.client.events.ChannelDeletedEvent) r2).getCid();
        r10 = r2.getCreatedAt();
        r3.L$0 = r5;
        r3.L$1 = r2;
        r3.L$2 = r1;
        r3.label = 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:426:0x0a21, code lost:
        if (r7.deleteChannelMessagesBefore(r9, r10, r3) != r4) goto L_0x0a24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:427:0x0a23, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:428:0x0a24, code lost:
        r7 = r5.domainImpl.getRepos$stream_chat_android_offline_release();
        r9 = ((p015io.getstream.chat.android.client.events.ChannelDeletedEvent) r2).getCid();
        r2 = r2.getCreatedAt();
        r3.L$0 = r5;
        r3.L$1 = r1;
        r3.L$2 = null;
        r3.label = 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:429:0x0a43, code lost:
        if (r7.setChannelDeletedAt(r9, r2, r3) != r4) goto L_0x09ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:430:0x0a45, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:432:0x0a48, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* renamed from: updateOfflineStorageFromEvents$stream_chat_android_offline_release */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object mo69172xbc9d7433(java.util.List<? extends p015io.getstream.chat.android.client.events.ChatEvent> r27, kotlin.coroutines.Continuation<? super kotlin.Unit> r28) {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            r2 = r28
            boolean r3 = r2 instanceof p015io.getstream.chat.android.livedata.EventHandlerImpl$updateOfflineStorageFromEvents$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            io.getstream.chat.android.livedata.EventHandlerImpl$updateOfflineStorageFromEvents$1 r3 = (p015io.getstream.chat.android.livedata.EventHandlerImpl$updateOfflineStorageFromEvents$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            io.getstream.chat.android.livedata.EventHandlerImpl$updateOfflineStorageFromEvents$1 r3 = new io.getstream.chat.android.livedata.EventHandlerImpl$updateOfflineStorageFromEvents$1
            r3.<init>(r0, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 10
            r7 = 1
            r8 = 0
            switch(r5) {
                case 0: goto L_0x00de;
                case 1: goto L_0x00d1;
                case 2: goto L_0x00bc;
                case 3: goto L_0x00a7;
                case 4: goto L_0x0092;
                case 5: goto L_0x0078;
                case 6: goto L_0x0063;
                case 7: goto L_0x0056;
                case 8: goto L_0x0049;
                case 9: goto L_0x0049;
                case 10: goto L_0x0036;
                case 11: goto L_0x0049;
                default: goto L_0x002e;
            }
        L_0x002e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0036:
            java.lang.Object r1 = r3.L$2
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r5 = r3.L$1
            io.getstream.chat.android.client.events.ChatEvent r5 = (p015io.getstream.chat.android.client.events.ChatEvent) r5
            java.lang.Object r7 = r3.L$0
            io.getstream.chat.android.livedata.EventHandlerImpl r7 = (p015io.getstream.chat.android.livedata.EventHandlerImpl) r7
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r5
            r5 = r7
            goto L_0x0a24
        L_0x0049:
            java.lang.Object r1 = r3.L$1
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r5 = r3.L$0
            io.getstream.chat.android.livedata.EventHandlerImpl r5 = (p015io.getstream.chat.android.livedata.EventHandlerImpl) r5
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x09ac
        L_0x0056:
            java.lang.Object r1 = r3.L$1
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r5 = r3.L$0
            io.getstream.chat.android.livedata.EventHandlerImpl r5 = (p015io.getstream.chat.android.livedata.EventHandlerImpl) r5
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x09a8
        L_0x0063:
            java.lang.Object r1 = r3.L$3
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r5 = r3.L$2
            io.getstream.chat.android.livedata.EventBatchUpdate r5 = (p015io.getstream.chat.android.livedata.EventBatchUpdate) r5
            java.lang.Object r9 = r3.L$1
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r10 = r3.L$0
            io.getstream.chat.android.livedata.EventHandlerImpl r10 = (p015io.getstream.chat.android.livedata.EventHandlerImpl) r10
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0852
        L_0x0078:
            java.lang.Object r1 = r3.L$4
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r5 = r3.L$3
            io.getstream.chat.android.client.events.ChatEvent r5 = (p015io.getstream.chat.android.client.events.ChatEvent) r5
            java.lang.Object r9 = r3.L$2
            io.getstream.chat.android.livedata.EventBatchUpdate r9 = (p015io.getstream.chat.android.livedata.EventBatchUpdate) r9
            java.lang.Object r10 = r3.L$1
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r11 = r3.L$0
            io.getstream.chat.android.livedata.EventHandlerImpl r11 = (p015io.getstream.chat.android.livedata.EventHandlerImpl) r11
            kotlin.ResultKt.throwOnFailure(r2)
            r15 = r11
            goto L_0x0803
        L_0x0092:
            java.lang.Object r1 = r3.L$3
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r5 = r3.L$2
            io.getstream.chat.android.livedata.EventBatchUpdate r5 = (p015io.getstream.chat.android.livedata.EventBatchUpdate) r5
            java.lang.Object r9 = r3.L$1
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r10 = r3.L$0
            io.getstream.chat.android.livedata.EventHandlerImpl r10 = (p015io.getstream.chat.android.livedata.EventHandlerImpl) r10
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0795
        L_0x00a7:
            java.lang.Object r1 = r3.L$3
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r5 = r3.L$2
            io.getstream.chat.android.livedata.EventBatchUpdate r5 = (p015io.getstream.chat.android.livedata.EventBatchUpdate) r5
            java.lang.Object r9 = r3.L$1
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r10 = r3.L$0
            io.getstream.chat.android.livedata.EventHandlerImpl r10 = (p015io.getstream.chat.android.livedata.EventHandlerImpl) r10
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0570
        L_0x00bc:
            java.lang.Object r1 = r3.L$3
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r5 = r3.L$2
            io.getstream.chat.android.livedata.EventBatchUpdate r5 = (p015io.getstream.chat.android.livedata.EventBatchUpdate) r5
            java.lang.Object r9 = r3.L$1
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r10 = r3.L$0
            io.getstream.chat.android.livedata.EventHandlerImpl r10 = (p015io.getstream.chat.android.livedata.EventHandlerImpl) r10
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0548
        L_0x00d1:
            java.lang.Object r1 = r3.L$1
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r5 = r3.L$0
            io.getstream.chat.android.livedata.EventHandlerImpl r5 = (p015io.getstream.chat.android.livedata.EventHandlerImpl) r5
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x03b5
        L_0x00de:
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r1
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            io.getstream.chat.android.livedata.EventHandlerImpl$updateOfflineStorageFromEvents$$inlined$sortedBy$1 r5 = new io.getstream.chat.android.livedata.EventHandlerImpl$updateOfflineStorageFromEvents$$inlined$sortedBy$1
            r5.<init>()
            java.util.Comparator r5 = (java.util.Comparator) r5
            kotlin.collections.CollectionsKt.sortedWith(r2, r5)
            io.getstream.chat.android.livedata.EventBatchUpdate$Builder r5 = new io.getstream.chat.android.livedata.EventBatchUpdate$Builder
            r5.<init>()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Collection r9 = (java.util.Collection) r9
            java.util.Iterator r10 = r2.iterator()
        L_0x00fe:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0110
            java.lang.Object r11 = r10.next()
            boolean r12 = r11 instanceof p015io.getstream.chat.android.client.events.CidEvent
            if (r12 == 0) goto L_0x00fe
            r9.add(r11)
            goto L_0x00fe
        L_0x0110:
            java.util.List r9 = (java.util.List) r9
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r10 = new java.util.ArrayList
            int r11 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r9, r6)
            r10.<init>(r11)
            java.util.Collection r10 = (java.util.Collection) r10
            java.util.Iterator r9 = r9.iterator()
        L_0x0123:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x0137
            java.lang.Object r11 = r9.next()
            io.getstream.chat.android.client.events.CidEvent r11 = (p015io.getstream.chat.android.client.events.CidEvent) r11
            java.lang.String r11 = r11.getCid()
            r10.add(r11)
            goto L_0x0123
        L_0x0137:
            java.util.List r10 = (java.util.List) r10
            r5.addToFetchChannels((java.util.List<java.lang.String>) r10)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Collection r9 = (java.util.Collection) r9
            java.util.Iterator r2 = r2.iterator()
        L_0x0147:
            boolean r10 = r2.hasNext()
            if (r10 == 0) goto L_0x0159
            java.lang.Object r10 = r2.next()
            boolean r11 = r10 instanceof p015io.getstream.chat.android.client.events.UserEvent
            if (r11 == 0) goto L_0x0147
            r9.add(r10)
            goto L_0x0147
        L_0x0159:
            java.util.List r9 = (java.util.List) r9
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r9 = r9.iterator()
        L_0x0168:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x017e
            java.lang.Object r10 = r9.next()
            io.getstream.chat.android.client.events.UserEvent r10 = (p015io.getstream.chat.android.client.events.UserEvent) r10
            io.getstream.chat.android.client.models.User r10 = r10.getUser()
            if (r10 == 0) goto L_0x0168
            r2.add(r10)
            goto L_0x0168
        L_0x017e:
            java.util.List r2 = (java.util.List) r2
            r5.addUsers(r2)
            java.util.Iterator r2 = r27.iterator()
        L_0x0187:
            boolean r9 = r2.hasNext()
            if (r9 == 0) goto L_0x03a5
            java.lang.Object r9 = r2.next()
            io.getstream.chat.android.client.events.ChatEvent r9 = (p015io.getstream.chat.android.client.events.ChatEvent) r9
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.MessageReadEvent
            if (r10 == 0) goto L_0x0199
            goto L_0x027e
        L_0x0199:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.MemberAddedEvent
            if (r10 == 0) goto L_0x019f
            goto L_0x027e
        L_0x019f:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.MemberRemovedEvent
            if (r10 == 0) goto L_0x01a5
            goto L_0x027e
        L_0x01a5:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.NotificationRemovedFromChannelEvent
            if (r10 == 0) goto L_0x01ab
            goto L_0x027e
        L_0x01ab:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.MemberUpdatedEvent
            if (r10 == 0) goto L_0x01b1
            goto L_0x027e
        L_0x01b1:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ChannelUpdatedEvent
            if (r10 == 0) goto L_0x01b7
            goto L_0x027e
        L_0x01b7:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ChannelUpdatedByUserEvent
            if (r10 == 0) goto L_0x01bd
            goto L_0x027e
        L_0x01bd:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ChannelDeletedEvent
            if (r10 == 0) goto L_0x01c3
            goto L_0x027e
        L_0x01c3:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ChannelHiddenEvent
            if (r10 == 0) goto L_0x01c9
            goto L_0x027e
        L_0x01c9:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ChannelVisibleEvent
            if (r10 == 0) goto L_0x01cf
            goto L_0x027e
        L_0x01cf:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.NotificationAddedToChannelEvent
            if (r10 == 0) goto L_0x01d5
            goto L_0x027e
        L_0x01d5:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.NotificationInvitedEvent
            if (r10 == 0) goto L_0x01db
            goto L_0x027e
        L_0x01db:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.NotificationInviteAcceptedEvent
            if (r10 == 0) goto L_0x01e1
            goto L_0x027e
        L_0x01e1:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ChannelTruncatedEvent
            if (r10 == 0) goto L_0x01e7
            goto L_0x027e
        L_0x01e7:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ChannelCreatedEvent
            if (r10 == 0) goto L_0x01ed
            goto L_0x027e
        L_0x01ed:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.HealthEvent
            if (r10 == 0) goto L_0x01f3
            goto L_0x027e
        L_0x01f3:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.NotificationMutesUpdatedEvent
            if (r10 == 0) goto L_0x01f9
            goto L_0x027e
        L_0x01f9:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.GlobalUserBannedEvent
            if (r10 == 0) goto L_0x01ff
            goto L_0x027e
        L_0x01ff:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.UserDeletedEvent
            if (r10 == 0) goto L_0x0205
            goto L_0x027e
        L_0x0205:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.UserMutedEvent
            if (r10 == 0) goto L_0x020b
            goto L_0x027e
        L_0x020b:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.UsersMutedEvent
            if (r10 == 0) goto L_0x0211
            goto L_0x027e
        L_0x0211:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.UserPresenceChangedEvent
            if (r10 == 0) goto L_0x0217
            goto L_0x027e
        L_0x0217:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.GlobalUserUnbannedEvent
            if (r10 == 0) goto L_0x021d
            goto L_0x027e
        L_0x021d:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.UserUnmutedEvent
            if (r10 == 0) goto L_0x0223
            goto L_0x027e
        L_0x0223:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.UsersUnmutedEvent
            if (r10 == 0) goto L_0x0229
            goto L_0x027e
        L_0x0229:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.UserUpdatedEvent
            if (r10 == 0) goto L_0x022f
            goto L_0x027e
        L_0x022f:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.NotificationChannelMutesUpdatedEvent
            if (r10 == 0) goto L_0x0234
            goto L_0x027e
        L_0x0234:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ConnectedEvent
            if (r10 == 0) goto L_0x0239
            goto L_0x027e
        L_0x0239:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ConnectingEvent
            if (r10 == 0) goto L_0x023e
            goto L_0x027e
        L_0x023e:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.DisconnectedEvent
            if (r10 == 0) goto L_0x0243
            goto L_0x027e
        L_0x0243:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ErrorEvent
            if (r10 == 0) goto L_0x0248
            goto L_0x027e
        L_0x0248:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.UnknownEvent
            if (r10 == 0) goto L_0x024d
            goto L_0x027e
        L_0x024d:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.NotificationChannelDeletedEvent
            if (r10 == 0) goto L_0x0252
            goto L_0x027e
        L_0x0252:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.NotificationChannelTruncatedEvent
            if (r10 == 0) goto L_0x0257
            goto L_0x027e
        L_0x0257:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.NotificationMarkReadEvent
            if (r10 == 0) goto L_0x025c
            goto L_0x027e
        L_0x025c:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.TypingStartEvent
            if (r10 == 0) goto L_0x0261
            goto L_0x027e
        L_0x0261:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.TypingStopEvent
            if (r10 == 0) goto L_0x0266
            goto L_0x027e
        L_0x0266:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ChannelUserBannedEvent
            if (r10 == 0) goto L_0x026b
            goto L_0x027e
        L_0x026b:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.UserStartWatchingEvent
            if (r10 == 0) goto L_0x0270
            goto L_0x027e
        L_0x0270:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.UserStopWatchingEvent
            if (r10 == 0) goto L_0x0275
            goto L_0x027e
        L_0x0275:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ChannelUserUnbannedEvent
            if (r10 == 0) goto L_0x027a
            goto L_0x027e
        L_0x027a:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.MarkAllReadEvent
            if (r10 == 0) goto L_0x0282
        L_0x027e:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x0187
        L_0x0282:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ReactionNewEvent
            if (r10 == 0) goto L_0x0297
            io.getstream.chat.android.client.events.ReactionNewEvent r9 = (p015io.getstream.chat.android.client.events.ReactionNewEvent) r9
            io.getstream.chat.android.client.models.Reaction r9 = r9.getReaction()
            java.lang.String r9 = r9.getMessageId()
            r5.addToFetchMessages((java.lang.String) r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x0187
        L_0x0297:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ReactionDeletedEvent
            if (r10 == 0) goto L_0x02ac
            io.getstream.chat.android.client.events.ReactionDeletedEvent r9 = (p015io.getstream.chat.android.client.events.ReactionDeletedEvent) r9
            io.getstream.chat.android.client.models.Reaction r9 = r9.getReaction()
            java.lang.String r9 = r9.getMessageId()
            r5.addToFetchMessages((java.lang.String) r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x0187
        L_0x02ac:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ChannelMuteEvent
            if (r10 == 0) goto L_0x02c5
            io.getstream.chat.android.client.events.ChannelMuteEvent r9 = (p015io.getstream.chat.android.client.events.ChannelMuteEvent) r9
            io.getstream.chat.android.client.models.ChannelMute r9 = r9.getChannelMute()
            io.getstream.chat.android.client.models.Channel r9 = r9.getChannel()
            java.lang.String r9 = r9.getCid()
            r5.addToFetchChannels((java.lang.String) r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x0187
        L_0x02c5:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ChannelsMuteEvent
            if (r10 == 0) goto L_0x02f1
            io.getstream.chat.android.client.events.ChannelsMuteEvent r9 = (p015io.getstream.chat.android.client.events.ChannelsMuteEvent) r9
            java.util.List r9 = r9.getChannelsMute()
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x02d5:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x02ed
            java.lang.Object r10 = r9.next()
            io.getstream.chat.android.client.models.ChannelMute r10 = (p015io.getstream.chat.android.client.models.ChannelMute) r10
            io.getstream.chat.android.client.models.Channel r10 = r10.getChannel()
            java.lang.String r10 = r10.getCid()
            r5.addToFetchChannels((java.lang.String) r10)
            goto L_0x02d5
        L_0x02ed:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x0187
        L_0x02f1:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ChannelUnmuteEvent
            if (r10 == 0) goto L_0x030a
            io.getstream.chat.android.client.events.ChannelUnmuteEvent r9 = (p015io.getstream.chat.android.client.events.ChannelUnmuteEvent) r9
            io.getstream.chat.android.client.models.ChannelMute r9 = r9.getChannelMute()
            io.getstream.chat.android.client.models.Channel r9 = r9.getChannel()
            java.lang.String r9 = r9.getCid()
            r5.addToFetchChannels((java.lang.String) r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x0187
        L_0x030a:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ChannelsUnmuteEvent
            if (r10 == 0) goto L_0x0336
            io.getstream.chat.android.client.events.ChannelsUnmuteEvent r9 = (p015io.getstream.chat.android.client.events.ChannelsUnmuteEvent) r9
            java.util.List r9 = r9.getChannelsMute()
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x031a:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x0332
            java.lang.Object r10 = r9.next()
            io.getstream.chat.android.client.models.ChannelMute r10 = (p015io.getstream.chat.android.client.models.ChannelMute) r10
            io.getstream.chat.android.client.models.Channel r10 = r10.getChannel()
            java.lang.String r10 = r10.getCid()
            r5.addToFetchChannels((java.lang.String) r10)
            goto L_0x031a
        L_0x0332:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x0187
        L_0x0336:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.MessageDeletedEvent
            if (r10 == 0) goto L_0x034b
            io.getstream.chat.android.client.events.MessageDeletedEvent r9 = (p015io.getstream.chat.android.client.events.MessageDeletedEvent) r9
            io.getstream.chat.android.client.models.Message r9 = r9.getMessage()
            java.lang.String r9 = r9.getId()
            r5.addToFetchMessages((java.lang.String) r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x0187
        L_0x034b:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.MessageUpdatedEvent
            if (r10 == 0) goto L_0x0360
            io.getstream.chat.android.client.events.MessageUpdatedEvent r9 = (p015io.getstream.chat.android.client.events.MessageUpdatedEvent) r9
            io.getstream.chat.android.client.models.Message r9 = r9.getMessage()
            java.lang.String r9 = r9.getId()
            r5.addToFetchMessages((java.lang.String) r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x0187
        L_0x0360:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.NewMessageEvent
            if (r10 == 0) goto L_0x0375
            io.getstream.chat.android.client.events.NewMessageEvent r9 = (p015io.getstream.chat.android.client.events.NewMessageEvent) r9
            io.getstream.chat.android.client.models.Message r9 = r9.getMessage()
            java.lang.String r9 = r9.getId()
            r5.addToFetchMessages((java.lang.String) r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x0187
        L_0x0375:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.NotificationMessageNewEvent
            if (r10 == 0) goto L_0x038a
            io.getstream.chat.android.client.events.NotificationMessageNewEvent r9 = (p015io.getstream.chat.android.client.events.NotificationMessageNewEvent) r9
            io.getstream.chat.android.client.models.Message r9 = r9.getMessage()
            java.lang.String r9 = r9.getId()
            r5.addToFetchMessages((java.lang.String) r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x0187
        L_0x038a:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ReactionUpdateEvent
            if (r10 == 0) goto L_0x039f
            io.getstream.chat.android.client.events.ReactionUpdateEvent r9 = (p015io.getstream.chat.android.client.events.ReactionUpdateEvent) r9
            io.getstream.chat.android.client.models.Message r9 = r9.getMessage()
            java.lang.String r9 = r9.getId()
            r5.addToFetchMessages((java.lang.String) r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x0187
        L_0x039f:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        L_0x03a5:
            io.getstream.chat.android.livedata.ChatDomainImpl r2 = r0.domainImpl
            r3.L$0 = r0
            r3.L$1 = r1
            r3.label = r7
            java.lang.Object r2 = r5.build(r2, r3)
            if (r2 != r4) goto L_0x03b4
            return r4
        L_0x03b4:
            r5 = r0
        L_0x03b5:
            io.getstream.chat.android.livedata.EventBatchUpdate r2 = (p015io.getstream.chat.android.livedata.EventBatchUpdate) r2
            java.util.Iterator r9 = r1.iterator()
            r15 = r5
            r5 = r2
            r2 = r1
            r1 = r9
        L_0x03bf:
            boolean r9 = r1.hasNext()
            if (r9 == 0) goto L_0x0992
            java.lang.Object r9 = r1.next()
            io.getstream.chat.android.client.events.ChatEvent r9 = (p015io.getstream.chat.android.client.events.ChatEvent) r9
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.NewMessageEvent
            if (r10 == 0) goto L_0x0408
            io.getstream.chat.android.client.events.NewMessageEvent r9 = (p015io.getstream.chat.android.client.events.NewMessageEvent) r9
            io.getstream.chat.android.client.models.Message r10 = r9.getMessage()
            java.lang.String r11 = r9.getCid()
            p015io.getstream.chat.android.client.extensions.MessageExtensionsKt.enrichWithCid(r10, r11)
            io.getstream.chat.android.client.models.Message r10 = r9.getMessage()
            io.getstream.chat.android.client.models.User r11 = r9.getUser()
            r15.enrichWithOwnReactions(r10, r5, r11)
            java.lang.Integer r10 = r9.getTotalUnreadCount()
            if (r10 == 0) goto L_0x03fa
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            io.getstream.chat.android.livedata.ChatDomainImpl r11 = r15.domainImpl
            r11.setTotalUnreadCount(r10)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
        L_0x03fa:
            java.lang.String r10 = r9.getCid()
            io.getstream.chat.android.client.models.Message r9 = r9.getMessage()
            r5.addMessageData(r10, r9, r7)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x0408:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.MessageDeletedEvent
            if (r10 == 0) goto L_0x0436
            io.getstream.chat.android.client.events.MessageDeletedEvent r9 = (p015io.getstream.chat.android.client.events.MessageDeletedEvent) r9
            io.getstream.chat.android.client.models.Message r10 = r9.getMessage()
            java.lang.String r11 = r9.getCid()
            p015io.getstream.chat.android.client.extensions.MessageExtensionsKt.enrichWithCid(r10, r11)
            io.getstream.chat.android.client.models.Message r10 = r9.getMessage()
            io.getstream.chat.android.client.models.User r11 = r9.getUser()
            r15.enrichWithOwnReactions(r10, r5, r11)
            java.lang.String r10 = r9.getCid()
            io.getstream.chat.android.client.models.Message r11 = r9.getMessage()
            r12 = 0
            r13 = 4
            r14 = 0
            r9 = r5
            p015io.getstream.chat.android.livedata.EventBatchUpdate.addMessageData$default(r9, r10, r11, r12, r13, r14)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x0436:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.MessageUpdatedEvent
            if (r10 == 0) goto L_0x0465
            io.getstream.chat.android.client.events.MessageUpdatedEvent r9 = (p015io.getstream.chat.android.client.events.MessageUpdatedEvent) r9
            io.getstream.chat.android.client.models.Message r10 = r9.getMessage()
            java.lang.String r11 = r9.getCid()
            p015io.getstream.chat.android.client.extensions.MessageExtensionsKt.enrichWithCid(r10, r11)
            io.getstream.chat.android.client.models.Message r10 = r9.getMessage()
            io.getstream.chat.android.client.models.User r11 = r9.getUser()
            r15.enrichWithOwnReactions(r10, r5, r11)
            java.lang.String r10 = r9.getCid()
            io.getstream.chat.android.client.models.Message r11 = r9.getMessage()
            r12 = 0
            r13 = 4
            r14 = 0
            r9 = r5
            p015io.getstream.chat.android.livedata.EventBatchUpdate.addMessageData$default(r9, r10, r11, r12, r13, r14)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x0465:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.NotificationMessageNewEvent
            if (r10 == 0) goto L_0x0498
            io.getstream.chat.android.client.events.NotificationMessageNewEvent r9 = (p015io.getstream.chat.android.client.events.NotificationMessageNewEvent) r9
            io.getstream.chat.android.client.models.Message r10 = r9.getMessage()
            java.lang.String r11 = r9.getCid()
            p015io.getstream.chat.android.client.extensions.MessageExtensionsKt.enrichWithCid(r10, r11)
            java.lang.Integer r10 = r9.getTotalUnreadCount()
            if (r10 == 0) goto L_0x0489
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            io.getstream.chat.android.livedata.ChatDomainImpl r11 = r15.domainImpl
            r11.setTotalUnreadCount(r10)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
        L_0x0489:
            java.lang.String r10 = r9.getCid()
            io.getstream.chat.android.client.models.Message r9 = r9.getMessage()
            r5.addMessageData(r10, r9, r7)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x0498:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.NotificationAddedToChannelEvent
            if (r10 == 0) goto L_0x04a9
            io.getstream.chat.android.client.events.NotificationAddedToChannelEvent r9 = (p015io.getstream.chat.android.client.events.NotificationAddedToChannelEvent) r9
            io.getstream.chat.android.client.models.Channel r9 = r9.getChannel()
            r5.addChannel(r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x04a9:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.NotificationInvitedEvent
            if (r10 == 0) goto L_0x04bc
            io.getstream.chat.android.client.events.NotificationInvitedEvent r9 = (p015io.getstream.chat.android.client.events.NotificationInvitedEvent) r9
            io.getstream.chat.android.client.models.User r9 = r9.getUser()
            if (r9 == 0) goto L_0x03bf
            r5.addUser(r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x04bc:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.NotificationInviteAcceptedEvent
            if (r10 == 0) goto L_0x04cf
            io.getstream.chat.android.client.events.NotificationInviteAcceptedEvent r9 = (p015io.getstream.chat.android.client.events.NotificationInviteAcceptedEvent) r9
            io.getstream.chat.android.client.models.User r9 = r9.getUser()
            if (r9 == 0) goto L_0x03bf
            r5.addUser(r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x04cf:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ChannelHiddenEvent
            if (r10 == 0) goto L_0x0505
            r10 = r9
            io.getstream.chat.android.client.events.ChannelHiddenEvent r10 = (p015io.getstream.chat.android.client.events.ChannelHiddenEvent) r10
            java.lang.String r11 = r10.getCid()
            io.getstream.chat.android.client.models.Channel r11 = r5.getCurrentChannel(r11)
            if (r11 == 0) goto L_0x03bf
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            r11.setHidden(r12)
            java.util.Date r9 = r9.getCreatedAt()
            boolean r10 = r10.getClearHistory()
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x04fa
            goto L_0x04fb
        L_0x04fa:
            r9 = r8
        L_0x04fb:
            r11.setHiddenMessagesBefore(r9)
            r5.addChannel(r11)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x0505:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ChannelVisibleEvent
            r11 = 0
            if (r10 == 0) goto L_0x0526
            io.getstream.chat.android.client.events.ChannelVisibleEvent r9 = (p015io.getstream.chat.android.client.events.ChannelVisibleEvent) r9
            java.lang.String r9 = r9.getCid()
            io.getstream.chat.android.client.models.Channel r9 = r5.getCurrentChannel(r9)
            if (r9 == 0) goto L_0x03bf
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r11)
            r9.setHidden(r10)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            r5.addChannel(r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x0526:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.NotificationMutesUpdatedEvent
            if (r10 == 0) goto L_0x054e
            io.getstream.chat.android.livedata.ChatDomainImpl r10 = r15.domainImpl
            io.getstream.chat.android.client.events.NotificationMutesUpdatedEvent r9 = (p015io.getstream.chat.android.client.events.NotificationMutesUpdatedEvent) r9
            io.getstream.chat.android.client.models.User r9 = r9.getMe()
            r3.L$0 = r15
            r3.L$1 = r2
            r3.L$2 = r5
            r3.L$3 = r1
            r3.L$4 = r8
            r11 = 2
            r3.label = r11
            java.lang.Object r9 = r10.updateCurrentUser$stream_chat_android_offline_release(r9, r3)
            if (r9 != r4) goto L_0x0546
            return r4
        L_0x0546:
            r9 = r2
            r10 = r15
        L_0x0548:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x054a:
            r2 = r9
            r15 = r10
            goto L_0x03bf
        L_0x054e:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ConnectedEvent
            if (r10 == 0) goto L_0x0573
            io.getstream.chat.android.livedata.ChatDomainImpl r10 = r15.domainImpl
            io.getstream.chat.android.client.events.ConnectedEvent r9 = (p015io.getstream.chat.android.client.events.ConnectedEvent) r9
            io.getstream.chat.android.client.models.User r9 = r9.getMe()
            r3.L$0 = r15
            r3.L$1 = r2
            r3.L$2 = r5
            r3.L$3 = r1
            r3.L$4 = r8
            r11 = 3
            r3.label = r11
            java.lang.Object r9 = r10.updateCurrentUser$stream_chat_android_offline_release(r9, r3)
            if (r9 != r4) goto L_0x056e
            return r4
        L_0x056e:
            r9 = r2
            r10 = r15
        L_0x0570:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            goto L_0x054a
        L_0x0573:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ReactionNewEvent
            if (r10 == 0) goto L_0x059a
            io.getstream.chat.android.client.events.ReactionNewEvent r9 = (p015io.getstream.chat.android.client.events.ReactionNewEvent) r9
            io.getstream.chat.android.client.models.Message r10 = r9.getMessage()
            java.lang.String r11 = r9.getCid()
            p015io.getstream.chat.android.client.extensions.MessageExtensionsKt.enrichWithCid(r10, r11)
            io.getstream.chat.android.client.models.Message r10 = r9.getMessage()
            io.getstream.chat.android.client.models.User r11 = r9.getUser()
            r15.enrichWithOwnReactions(r10, r5, r11)
            io.getstream.chat.android.client.models.Message r9 = r9.getMessage()
            r5.addMessage(r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x059a:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ReactionDeletedEvent
            if (r10 == 0) goto L_0x05c1
            io.getstream.chat.android.client.events.ReactionDeletedEvent r9 = (p015io.getstream.chat.android.client.events.ReactionDeletedEvent) r9
            io.getstream.chat.android.client.models.Message r10 = r9.getMessage()
            java.lang.String r11 = r9.getCid()
            p015io.getstream.chat.android.client.extensions.MessageExtensionsKt.enrichWithCid(r10, r11)
            io.getstream.chat.android.client.models.Message r10 = r9.getMessage()
            io.getstream.chat.android.client.models.User r11 = r9.getUser()
            r15.enrichWithOwnReactions(r10, r5, r11)
            io.getstream.chat.android.client.models.Message r9 = r9.getMessage()
            r5.addMessage(r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x05c1:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ReactionUpdateEvent
            if (r10 == 0) goto L_0x05e8
            io.getstream.chat.android.client.events.ReactionUpdateEvent r9 = (p015io.getstream.chat.android.client.events.ReactionUpdateEvent) r9
            io.getstream.chat.android.client.models.Message r10 = r9.getMessage()
            java.lang.String r11 = r9.getCid()
            p015io.getstream.chat.android.client.extensions.MessageExtensionsKt.enrichWithCid(r10, r11)
            io.getstream.chat.android.client.models.Message r10 = r9.getMessage()
            io.getstream.chat.android.client.models.User r11 = r9.getUser()
            r15.enrichWithOwnReactions(r10, r5, r11)
            io.getstream.chat.android.client.models.Message r9 = r9.getMessage()
            r5.addMessage(r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x05e8:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.MemberAddedEvent
            if (r10 == 0) goto L_0x0614
            io.getstream.chat.android.client.events.MemberAddedEvent r9 = (p015io.getstream.chat.android.client.events.MemberAddedEvent) r9
            java.lang.String r10 = r9.getCid()
            io.getstream.chat.android.client.models.Channel r10 = r5.getCurrentChannel(r10)
            if (r10 == 0) goto L_0x03bf
            io.getstream.chat.android.client.models.Member r11 = r9.getMember()
            io.getstream.chat.android.client.models.User r11 = r11.getUser()
            java.lang.String r11 = r11.getId()
            io.getstream.chat.android.client.models.Member r9 = r9.getMember()
            p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.setMember(r10, r11, r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            r5.addChannel(r10)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x0614:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.MemberUpdatedEvent
            if (r10 == 0) goto L_0x0640
            io.getstream.chat.android.client.events.MemberUpdatedEvent r9 = (p015io.getstream.chat.android.client.events.MemberUpdatedEvent) r9
            java.lang.String r10 = r9.getCid()
            io.getstream.chat.android.client.models.Channel r10 = r5.getCurrentChannel(r10)
            if (r10 == 0) goto L_0x03bf
            io.getstream.chat.android.client.models.Member r11 = r9.getMember()
            io.getstream.chat.android.client.models.User r11 = r11.getUser()
            java.lang.String r11 = r11.getId()
            io.getstream.chat.android.client.models.Member r9 = r9.getMember()
            p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.setMember(r10, r11, r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            r5.addChannel(r10)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x0640:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.MemberRemovedEvent
            if (r10 == 0) goto L_0x0664
            io.getstream.chat.android.client.events.MemberRemovedEvent r9 = (p015io.getstream.chat.android.client.events.MemberRemovedEvent) r9
            java.lang.String r10 = r9.getCid()
            io.getstream.chat.android.client.models.Channel r10 = r5.getCurrentChannel(r10)
            if (r10 == 0) goto L_0x03bf
            io.getstream.chat.android.client.models.User r9 = r9.getUser()
            java.lang.String r9 = r9.getId()
            p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.setMember(r10, r9, r8)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            r5.addChannel(r10)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x0664:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.NotificationRemovedFromChannelEvent
            if (r10 == 0) goto L_0x068a
            io.getstream.chat.android.client.events.NotificationRemovedFromChannelEvent r9 = (p015io.getstream.chat.android.client.events.NotificationRemovedFromChannelEvent) r9
            java.lang.String r10 = r9.getCid()
            io.getstream.chat.android.client.models.Channel r10 = r5.getCurrentChannel(r10)
            if (r10 == 0) goto L_0x03bf
            io.getstream.chat.android.client.models.User r9 = r9.getUser()
            if (r9 == 0) goto L_0x0683
            java.lang.String r9 = r9.getId()
            p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.setMember(r10, r9, r8)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
        L_0x0683:
            r5.addChannel(r10)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x068a:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ChannelUpdatedEvent
            if (r10 == 0) goto L_0x069b
            io.getstream.chat.android.client.events.ChannelUpdatedEvent r9 = (p015io.getstream.chat.android.client.events.ChannelUpdatedEvent) r9
            io.getstream.chat.android.client.models.Channel r9 = r9.getChannel()
            r5.addChannel(r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x069b:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ChannelUpdatedByUserEvent
            if (r10 == 0) goto L_0x06ac
            io.getstream.chat.android.client.events.ChannelUpdatedByUserEvent r9 = (p015io.getstream.chat.android.client.events.ChannelUpdatedByUserEvent) r9
            io.getstream.chat.android.client.models.Channel r9 = r9.getChannel()
            r5.addChannel(r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x06ac:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ChannelDeletedEvent
            if (r10 == 0) goto L_0x06bd
            io.getstream.chat.android.client.events.ChannelDeletedEvent r9 = (p015io.getstream.chat.android.client.events.ChannelDeletedEvent) r9
            io.getstream.chat.android.client.models.Channel r9 = r9.getChannel()
            r5.addChannel(r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x06bd:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ChannelCreatedEvent
            if (r10 == 0) goto L_0x06ce
            io.getstream.chat.android.client.events.ChannelCreatedEvent r9 = (p015io.getstream.chat.android.client.events.ChannelCreatedEvent) r9
            io.getstream.chat.android.client.models.Channel r9 = r9.getChannel()
            r5.addChannel(r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x06ce:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ChannelMuteEvent
            if (r10 == 0) goto L_0x06e3
            io.getstream.chat.android.client.events.ChannelMuteEvent r9 = (p015io.getstream.chat.android.client.events.ChannelMuteEvent) r9
            io.getstream.chat.android.client.models.ChannelMute r9 = r9.getChannelMute()
            io.getstream.chat.android.client.models.Channel r9 = r9.getChannel()
            r5.addChannel(r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x06e3:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ChannelsMuteEvent
            if (r10 == 0) goto L_0x070b
            io.getstream.chat.android.client.events.ChannelsMuteEvent r9 = (p015io.getstream.chat.android.client.events.ChannelsMuteEvent) r9
            java.util.List r9 = r9.getChannelsMute()
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x06f3:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x0707
            java.lang.Object r10 = r9.next()
            io.getstream.chat.android.client.models.ChannelMute r10 = (p015io.getstream.chat.android.client.models.ChannelMute) r10
            io.getstream.chat.android.client.models.Channel r10 = r10.getChannel()
            r5.addChannel(r10)
            goto L_0x06f3
        L_0x0707:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x070b:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ChannelUnmuteEvent
            if (r10 == 0) goto L_0x0720
            io.getstream.chat.android.client.events.ChannelUnmuteEvent r9 = (p015io.getstream.chat.android.client.events.ChannelUnmuteEvent) r9
            io.getstream.chat.android.client.models.ChannelMute r9 = r9.getChannelMute()
            io.getstream.chat.android.client.models.Channel r9 = r9.getChannel()
            r5.addChannel(r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x0720:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ChannelsUnmuteEvent
            if (r10 == 0) goto L_0x0748
            io.getstream.chat.android.client.events.ChannelsUnmuteEvent r9 = (p015io.getstream.chat.android.client.events.ChannelsUnmuteEvent) r9
            java.util.List r9 = r9.getChannelsMute()
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x0730:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x0744
            java.lang.Object r10 = r9.next()
            io.getstream.chat.android.client.models.ChannelMute r10 = (p015io.getstream.chat.android.client.models.ChannelMute) r10
            io.getstream.chat.android.client.models.Channel r10 = r10.getChannel()
            r5.addChannel(r10)
            goto L_0x0730
        L_0x0744:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x0748:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ChannelTruncatedEvent
            if (r10 == 0) goto L_0x0759
            io.getstream.chat.android.client.events.ChannelTruncatedEvent r9 = (p015io.getstream.chat.android.client.events.ChannelTruncatedEvent) r9
            io.getstream.chat.android.client.models.Channel r9 = r9.getChannel()
            r5.addChannel(r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x0759:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.NotificationChannelDeletedEvent
            if (r10 == 0) goto L_0x0773
            io.getstream.chat.android.client.events.NotificationChannelDeletedEvent r9 = (p015io.getstream.chat.android.client.events.NotificationChannelDeletedEvent) r9
            io.getstream.chat.android.client.models.Channel r10 = r9.getChannel()
            r5.addChannel(r10)
            io.getstream.chat.android.client.models.User r9 = r9.getUser()
            if (r9 == 0) goto L_0x03bf
            r5.addUser(r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x0773:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.NotificationChannelMutesUpdatedEvent
            if (r10 == 0) goto L_0x0799
            io.getstream.chat.android.livedata.ChatDomainImpl r10 = r15.domainImpl
            io.getstream.chat.android.client.events.NotificationChannelMutesUpdatedEvent r9 = (p015io.getstream.chat.android.client.events.NotificationChannelMutesUpdatedEvent) r9
            io.getstream.chat.android.client.models.User r9 = r9.getMe()
            r3.L$0 = r15
            r3.L$1 = r2
            r3.L$2 = r5
            r3.L$3 = r1
            r3.L$4 = r8
            r11 = 4
            r3.label = r11
            java.lang.Object r9 = r10.updateCurrentUser$stream_chat_android_offline_release(r9, r3)
            if (r9 != r4) goto L_0x0793
            return r4
        L_0x0793:
            r9 = r2
            r10 = r15
        L_0x0795:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            goto L_0x054a
        L_0x0799:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.NotificationChannelTruncatedEvent
            if (r10 == 0) goto L_0x07aa
            io.getstream.chat.android.client.events.NotificationChannelTruncatedEvent r9 = (p015io.getstream.chat.android.client.events.NotificationChannelTruncatedEvent) r9
            io.getstream.chat.android.client.models.Channel r9 = r9.getChannel()
            r5.addChannel(r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x07aa:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.MarkAllReadEvent
            if (r10 == 0) goto L_0x085c
            r10 = r9
            io.getstream.chat.android.client.events.MarkAllReadEvent r10 = (p015io.getstream.chat.android.client.events.MarkAllReadEvent) r10
            int r11 = r10.getTotalUnreadCount()
            java.lang.Integer r11 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r11)
            io.getstream.chat.android.livedata.ChatDomainImpl r12 = r15.domainImpl
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            r12.setTotalUnreadCount(r11)
            int r11 = r10.getUnreadChannels()
            java.lang.Integer r11 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r11)
            io.getstream.chat.android.livedata.ChatDomainImpl r12 = r15.domainImpl
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            r12.setChannelUnreadCount(r11)
            io.getstream.chat.android.livedata.ChatDomainImpl r11 = r15.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r11 = r11.getRepos$stream_chat_android_offline_release()
            io.getstream.chat.android.client.models.User r10 = r10.getUser()
            java.lang.String r10 = r10.getId()
            r3.L$0 = r15
            r3.L$1 = r2
            r3.L$2 = r5
            r3.L$3 = r9
            r3.L$4 = r1
            r12 = 5
            r3.label = r12
            java.lang.Object r10 = r11.selectSyncState(r10, r3)
            if (r10 != r4) goto L_0x07f9
            return r4
        L_0x07f9:
            r24 = r10
            r10 = r2
            r2 = r24
            r25 = r9
            r9 = r5
            r5 = r25
        L_0x0803:
            r16 = r2
            io.getstream.chat.android.livedata.model.SyncState r16 = (p015io.getstream.chat.android.livedata.model.SyncState) r16
            if (r16 == 0) goto L_0x0858
            java.util.Date r2 = r16.getMarkedAllReadAt()
            if (r2 == 0) goto L_0x0821
            java.util.Date r2 = r16.getMarkedAllReadAt()
            java.util.Date r11 = r5.getCreatedAt()
            boolean r2 = r2.before(r11)
            if (r2 == 0) goto L_0x081e
            goto L_0x0821
        L_0x081e:
            r5 = r9
            r2 = r10
            goto L_0x0854
        L_0x0821:
            io.getstream.chat.android.livedata.ChatDomainImpl r2 = r15.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r2 = r2.getRepos$stream_chat_android_offline_release()
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            java.util.Date r21 = r5.getCreatedAt()
            r22 = 15
            r23 = 0
            io.getstream.chat.android.livedata.model.SyncState r5 = p015io.getstream.chat.android.livedata.model.SyncState.copy$default(r16, r17, r18, r19, r20, r21, r22, r23)
            r3.L$0 = r15
            r3.L$1 = r10
            r3.L$2 = r9
            r3.L$3 = r1
            r3.L$4 = r8
            r11 = 6
            r3.label = r11
            java.lang.Object r2 = r2.insertSyncState(r5, r3)
            if (r2 != r4) goto L_0x084f
            return r4
        L_0x084f:
            r5 = r9
            r9 = r10
            r10 = r15
        L_0x0852:
            r2 = r9
            r15 = r10
        L_0x0854:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x0858:
            r5 = r9
            r2 = r10
            goto L_0x03bf
        L_0x085c:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.MessageReadEvent
            if (r10 == 0) goto L_0x088e
            r10 = r9
            io.getstream.chat.android.client.events.MessageReadEvent r10 = (p015io.getstream.chat.android.client.events.MessageReadEvent) r10
            java.lang.String r11 = r10.getCid()
            io.getstream.chat.android.client.models.Channel r11 = r5.getCurrentChannel(r11)
            if (r11 == 0) goto L_0x03bf
            io.getstream.chat.android.client.models.ChannelUserRead r12 = new io.getstream.chat.android.client.models.ChannelUserRead
            io.getstream.chat.android.client.models.User r17 = r10.getUser()
            java.util.Date r18 = r9.getCreatedAt()
            r19 = 0
            r20 = 4
            r21 = 0
            r16 = r12
            r16.<init>(r17, r18, r19, r20, r21)
            p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.updateReads(r11, r12)
            if (r11 == 0) goto L_0x03bf
            r5.addChannel(r11)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x088e:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.NotificationMarkReadEvent
            if (r10 == 0) goto L_0x08d3
            r10 = r9
            io.getstream.chat.android.client.events.NotificationMarkReadEvent r10 = (p015io.getstream.chat.android.client.events.NotificationMarkReadEvent) r10
            java.lang.Integer r11 = r10.getTotalUnreadCount()
            if (r11 == 0) goto L_0x08a8
            io.getstream.chat.android.livedata.ChatDomainImpl r12 = r15.domainImpl
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            r12.setTotalUnreadCount(r11)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
        L_0x08a8:
            java.lang.String r11 = r10.getCid()
            io.getstream.chat.android.client.models.Channel r11 = r5.getCurrentChannel(r11)
            if (r11 == 0) goto L_0x03bf
            io.getstream.chat.android.client.models.ChannelUserRead r12 = new io.getstream.chat.android.client.models.ChannelUserRead
            io.getstream.chat.android.client.models.User r17 = r10.getUser()
            java.util.Date r18 = r9.getCreatedAt()
            r19 = 0
            r20 = 4
            r21 = 0
            r16 = r12
            r16.<init>(r17, r18, r19, r20, r21)
            p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.updateReads(r11, r12)
            if (r11 == 0) goto L_0x03bf
            r5.addChannel(r11)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x08d3:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.UserMutedEvent
            if (r10 == 0) goto L_0x08e4
            io.getstream.chat.android.client.events.UserMutedEvent r9 = (p015io.getstream.chat.android.client.events.UserMutedEvent) r9
            io.getstream.chat.android.client.models.User r9 = r9.getTargetUser()
            r5.addUser(r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x08e4:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.UsersMutedEvent
            if (r10 == 0) goto L_0x08f5
            io.getstream.chat.android.client.events.UsersMutedEvent r9 = (p015io.getstream.chat.android.client.events.UsersMutedEvent) r9
            java.util.List r9 = r9.getTargetUsers()
            r5.addUsers(r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x08f5:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.UserUnmutedEvent
            if (r10 == 0) goto L_0x0906
            io.getstream.chat.android.client.events.UserUnmutedEvent r9 = (p015io.getstream.chat.android.client.events.UserUnmutedEvent) r9
            io.getstream.chat.android.client.models.User r9 = r9.getTargetUser()
            r5.addUser(r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x0906:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.UsersUnmutedEvent
            if (r10 == 0) goto L_0x0917
            io.getstream.chat.android.client.events.UsersUnmutedEvent r9 = (p015io.getstream.chat.android.client.events.UsersUnmutedEvent) r9
            java.util.List r9 = r9.getTargetUsers()
            r5.addUsers(r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x0917:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.GlobalUserBannedEvent
            if (r10 == 0) goto L_0x092d
            io.getstream.chat.android.client.events.GlobalUserBannedEvent r9 = (p015io.getstream.chat.android.client.events.GlobalUserBannedEvent) r9
            io.getstream.chat.android.client.models.User r9 = r9.getUser()
            r9.setBanned(r7)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            r5.addUser(r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x092d:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.GlobalUserUnbannedEvent
            if (r10 == 0) goto L_0x0943
            io.getstream.chat.android.client.events.GlobalUserUnbannedEvent r9 = (p015io.getstream.chat.android.client.events.GlobalUserUnbannedEvent) r9
            io.getstream.chat.android.client.models.User r9 = r9.getUser()
            r9.setBanned(r11)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            r5.addUser(r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x0943:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.TypingStartEvent
            if (r10 == 0) goto L_0x0948
            goto L_0x0988
        L_0x0948:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.TypingStopEvent
            if (r10 == 0) goto L_0x094d
            goto L_0x0988
        L_0x094d:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.HealthEvent
            if (r10 == 0) goto L_0x0952
            goto L_0x0988
        L_0x0952:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ConnectingEvent
            if (r10 == 0) goto L_0x0957
            goto L_0x0988
        L_0x0957:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.DisconnectedEvent
            if (r10 == 0) goto L_0x095c
            goto L_0x0988
        L_0x095c:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ErrorEvent
            if (r10 == 0) goto L_0x0961
            goto L_0x0988
        L_0x0961:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.UnknownEvent
            if (r10 == 0) goto L_0x0966
            goto L_0x0988
        L_0x0966:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ChannelUserBannedEvent
            if (r10 == 0) goto L_0x096b
            goto L_0x0988
        L_0x096b:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.ChannelUserUnbannedEvent
            if (r10 == 0) goto L_0x0970
            goto L_0x0988
        L_0x0970:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.UserUpdatedEvent
            if (r10 == 0) goto L_0x0975
            goto L_0x0988
        L_0x0975:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.UserDeletedEvent
            if (r10 == 0) goto L_0x097a
            goto L_0x0988
        L_0x097a:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.UserPresenceChangedEvent
            if (r10 == 0) goto L_0x097f
            goto L_0x0988
        L_0x097f:
            boolean r10 = r9 instanceof p015io.getstream.chat.android.client.events.UserStartWatchingEvent
            if (r10 == 0) goto L_0x0984
            goto L_0x0988
        L_0x0984:
            boolean r9 = r9 instanceof p015io.getstream.chat.android.client.events.UserStopWatchingEvent
            if (r9 == 0) goto L_0x098c
        L_0x0988:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x03bf
        L_0x098c:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        L_0x0992:
            r3.L$0 = r15
            r3.L$1 = r2
            r3.L$2 = r8
            r3.L$3 = r8
            r3.L$4 = r8
            r1 = 7
            r3.label = r1
            java.lang.Object r1 = r5.execute(r3)
            if (r1 != r4) goto L_0x09a6
            return r4
        L_0x09a6:
            r1 = r2
            r5 = r15
        L_0x09a8:
            java.util.Iterator r1 = r1.iterator()
        L_0x09ac:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0a46
            java.lang.Object r2 = r1.next()
            io.getstream.chat.android.client.events.ChatEvent r2 = (p015io.getstream.chat.android.client.events.ChatEvent) r2
            boolean r7 = r2 instanceof p015io.getstream.chat.android.client.events.NotificationChannelTruncatedEvent
            if (r7 == 0) goto L_0x09dc
            io.getstream.chat.android.livedata.ChatDomainImpl r7 = r5.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r7 = r7.getRepos$stream_chat_android_offline_release()
            r9 = r2
            io.getstream.chat.android.client.events.NotificationChannelTruncatedEvent r9 = (p015io.getstream.chat.android.client.events.NotificationChannelTruncatedEvent) r9
            java.lang.String r9 = r9.getCid()
            java.util.Date r2 = r2.getCreatedAt()
            r3.L$0 = r5
            r3.L$1 = r1
            r10 = 8
            r3.label = r10
            java.lang.Object r2 = r7.deleteChannelMessagesBefore(r9, r2, r3)
            if (r2 != r4) goto L_0x09ac
            return r4
        L_0x09dc:
            boolean r7 = r2 instanceof p015io.getstream.chat.android.client.events.ChannelTruncatedEvent
            if (r7 == 0) goto L_0x0a00
            io.getstream.chat.android.livedata.ChatDomainImpl r7 = r5.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r7 = r7.getRepos$stream_chat_android_offline_release()
            r9 = r2
            io.getstream.chat.android.client.events.ChannelTruncatedEvent r9 = (p015io.getstream.chat.android.client.events.ChannelTruncatedEvent) r9
            java.lang.String r9 = r9.getCid()
            java.util.Date r2 = r2.getCreatedAt()
            r3.L$0 = r5
            r3.L$1 = r1
            r10 = 9
            r3.label = r10
            java.lang.Object r2 = r7.deleteChannelMessagesBefore(r9, r2, r3)
            if (r2 != r4) goto L_0x09ac
            return r4
        L_0x0a00:
            boolean r7 = r2 instanceof p015io.getstream.chat.android.client.events.ChannelDeletedEvent
            if (r7 == 0) goto L_0x09ac
            io.getstream.chat.android.livedata.ChatDomainImpl r7 = r5.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r7 = r7.getRepos$stream_chat_android_offline_release()
            r9 = r2
            io.getstream.chat.android.client.events.ChannelDeletedEvent r9 = (p015io.getstream.chat.android.client.events.ChannelDeletedEvent) r9
            java.lang.String r9 = r9.getCid()
            java.util.Date r10 = r2.getCreatedAt()
            r3.L$0 = r5
            r3.L$1 = r2
            r3.L$2 = r1
            r3.label = r6
            java.lang.Object r7 = r7.deleteChannelMessagesBefore(r9, r10, r3)
            if (r7 != r4) goto L_0x0a24
            return r4
        L_0x0a24:
            io.getstream.chat.android.livedata.ChatDomainImpl r7 = r5.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r7 = r7.getRepos$stream_chat_android_offline_release()
            r9 = r2
            io.getstream.chat.android.client.events.ChannelDeletedEvent r9 = (p015io.getstream.chat.android.client.events.ChannelDeletedEvent) r9
            java.lang.String r9 = r9.getCid()
            java.util.Date r2 = r2.getCreatedAt()
            r3.L$0 = r5
            r3.L$1 = r1
            r3.L$2 = r8
            r10 = 11
            r3.label = r10
            java.lang.Object r2 = r7.setChannelDeletedAt(r9, r2, r3)
            if (r2 != r4) goto L_0x09ac
            return r4
        L_0x0a46:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.EventHandlerImpl.mo69172xbc9d7433(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void incrementUnreadCountIfNecessary(EventBatchUpdate eventBatchUpdate, String str, Message message) {
        String id = this.domainImpl.getCurrentUser().getId();
        Channel currentChannel = eventBatchUpdate.getCurrentChannel(str);
        if (currentChannel != null && ClientExtensionsKt.shouldIncrementUnreadCount(message, id)) {
            ClientExtensionsKt.incrementUnreadCount(currentChannel, id);
            Unit unit = Unit.INSTANCE;
            eventBatchUpdate.addChannel(currentChannel);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object handleEventsInternal(java.util.List<? extends p015io.getstream.chat.android.client.events.ChatEvent> r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof p015io.getstream.chat.android.livedata.EventHandlerImpl$handleEventsInternal$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            io.getstream.chat.android.livedata.EventHandlerImpl$handleEventsInternal$1 r0 = (p015io.getstream.chat.android.livedata.EventHandlerImpl$handleEventsInternal$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.EventHandlerImpl$handleEventsInternal$1 r0 = new io.getstream.chat.android.livedata.EventHandlerImpl$handleEventsInternal$1
            r0.<init>(r10, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0076
            if (r2 == r6) goto L_0x006a
            if (r2 == r5) goto L_0x0059
            if (r2 == r4) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            java.lang.Object r11 = r0.L$1
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r2 = r0.L$0
            java.util.List r2 = (java.util.List) r2
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x018e
        L_0x003c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0044:
            java.lang.Object r11 = r0.L$3
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r2 = r0.L$2
            io.getstream.chat.android.client.events.MarkAllReadEvent r2 = (p015io.getstream.chat.android.client.events.MarkAllReadEvent) r2
            java.lang.Object r5 = r0.L$1
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r6 = r0.L$0
            io.getstream.chat.android.livedata.EventHandlerImpl r6 = (p015io.getstream.chat.android.livedata.EventHandlerImpl) r6
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0163
        L_0x0059:
            java.lang.Object r11 = r0.L$2
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r2 = r0.L$1
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r6 = r0.L$0
            io.getstream.chat.android.livedata.EventHandlerImpl r6 = (p015io.getstream.chat.android.livedata.EventHandlerImpl) r6
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00f5
        L_0x006a:
            java.lang.Object r11 = r0.L$1
            java.util.List r11 = (java.util.List) r11
            java.lang.Object r2 = r0.L$0
            io.getstream.chat.android.livedata.EventHandlerImpl r2 = (p015io.getstream.chat.android.livedata.EventHandlerImpl) r2
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0094
        L_0x0076:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            io.getstream.chat.android.livedata.EventHandlerImpl$handleEventsInternal$$inlined$sortedBy$1 r12 = new io.getstream.chat.android.livedata.EventHandlerImpl$handleEventsInternal$$inlined$sortedBy$1
            r12.<init>()
            java.util.Comparator r12 = (java.util.Comparator) r12
            java.util.List r11 = kotlin.collections.CollectionsKt.sortedWith(r11, r12)
            r0.L$0 = r10
            r0.L$1 = r11
            r0.label = r6
            java.lang.Object r12 = r10.mo69172xbc9d7433(r11, r0)
            if (r12 != r1) goto L_0x0093
            return r1
        L_0x0093:
            r2 = r10
        L_0x0094:
            r12 = r11
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r12 = r12.iterator()
        L_0x00a2:
            boolean r7 = r12.hasNext()
            if (r7 == 0) goto L_0x00b4
            java.lang.Object r7 = r12.next()
            boolean r8 = r7 instanceof p015io.getstream.chat.android.client.events.CidEvent
            if (r8 == 0) goto L_0x00a2
            r6.add(r7)
            goto L_0x00a2
        L_0x00b4:
            java.util.List r6 = (java.util.List) r6
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.LinkedHashMap r12 = new java.util.LinkedHashMap
            r12.<init>()
            java.util.Map r12 = (java.util.Map) r12
            java.util.Iterator r6 = r6.iterator()
        L_0x00c3:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00ea
            java.lang.Object r7 = r6.next()
            r8 = r7
            io.getstream.chat.android.client.events.CidEvent r8 = (p015io.getstream.chat.android.client.events.CidEvent) r8
            java.lang.String r8 = r8.getCid()
            java.lang.Object r9 = r12.get(r8)
            if (r9 != 0) goto L_0x00e4
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.List r9 = (java.util.List) r9
            r12.put(r8, r9)
        L_0x00e4:
            java.util.List r9 = (java.util.List) r9
            r9.add(r7)
            goto L_0x00c3
        L_0x00ea:
            java.util.Set r12 = r12.entrySet()
            java.util.Iterator r12 = r12.iterator()
            r6 = r2
            r2 = r11
            r11 = r12
        L_0x00f5:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x012a
            java.lang.Object r12 = r11.next()
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12
            java.lang.Object r7 = r12.getKey()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r12 = r12.getValue()
            java.util.List r12 = (java.util.List) r12
            io.getstream.chat.android.livedata.ChatDomainImpl r8 = r6.domainImpl
            boolean r8 = r8.isActiveChannel(r7)
            if (r8 == 0) goto L_0x00f5
            io.getstream.chat.android.livedata.ChatDomainImpl r8 = r6.domainImpl
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r7 = r8.channel$stream_chat_android_offline_release((java.lang.String) r7)
            r0.L$0 = r6
            r0.L$1 = r2
            r0.L$2 = r11
            r0.label = r5
            java.lang.Object r12 = r7.handleEvents$stream_chat_android_offline_release(r12, r0)
            if (r12 != r1) goto L_0x00f5
            return r1
        L_0x012a:
            r11 = r2
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.Collection r12 = (java.util.Collection) r12
            java.util.Iterator r11 = r11.iterator()
        L_0x0138:
            boolean r5 = r11.hasNext()
            if (r5 == 0) goto L_0x014a
            java.lang.Object r5 = r11.next()
            boolean r7 = r5 instanceof p015io.getstream.chat.android.client.events.MarkAllReadEvent
            if (r7 == 0) goto L_0x0138
            r12.add(r5)
            goto L_0x0138
        L_0x014a:
            java.util.List r12 = (java.util.List) r12
            java.lang.Object r11 = kotlin.collections.CollectionsKt.firstOrNull(r12)
            io.getstream.chat.android.client.events.MarkAllReadEvent r11 = (p015io.getstream.chat.android.client.events.MarkAllReadEvent) r11
            if (r11 == 0) goto L_0x0184
            io.getstream.chat.android.livedata.ChatDomainImpl r12 = r6.domainImpl
            java.util.List r12 = r12.allActiveChannels$stream_chat_android_offline_release()
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.Iterator r12 = r12.iterator()
            r5 = r2
            r2 = r11
            r11 = r12
        L_0x0163:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x0183
            java.lang.Object r12 = r11.next()
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r12 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r12
            r7 = r2
            io.getstream.chat.android.client.events.ChatEvent r7 = (p015io.getstream.chat.android.client.events.ChatEvent) r7
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r2
            r0.L$3 = r11
            r0.label = r4
            java.lang.Object r12 = r12.handleEvent$stream_chat_android_offline_release(r7, r0)
            if (r12 != r1) goto L_0x0163
            return r1
        L_0x0183:
            r2 = r5
        L_0x0184:
            io.getstream.chat.android.livedata.ChatDomainImpl r11 = r6.domainImpl
            java.util.List r11 = r11.getActiveQueries()
            java.util.Iterator r11 = r11.iterator()
        L_0x018e:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x01ac
            java.lang.Object r12 = r11.next()
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl r12 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl) r12
            r0.L$0 = r2
            r0.L$1 = r11
            r4 = 0
            r0.L$2 = r4
            r0.L$3 = r4
            r0.label = r3
            java.lang.Object r12 = r12.handleEvents$stream_chat_android_offline_release(r2, r0)
            if (r12 != r1) goto L_0x018e
            return r1
        L_0x01ac:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.EventHandlerImpl.handleEventsInternal(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void enrichWithOwnReactions(Message message, EventBatchUpdate eventBatchUpdate, User user) {
        List<Reaction> list;
        if (user != null && (!Intrinsics.areEqual((Object) this.domainImpl.getCurrentUser().getId(), (Object) user.getId()))) {
            Message currentMessage = eventBatchUpdate.getCurrentMessage(message.getId());
            if (currentMessage == null || (list = currentMessage.getOwnReactions()) == null) {
                list = new ArrayList<>();
            }
            message.setOwnReactions(list);
        }
    }
}
