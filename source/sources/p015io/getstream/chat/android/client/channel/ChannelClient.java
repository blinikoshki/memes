package p015io.getstream.chat.android.client.channel;

import androidx.lifecycle.LifecycleOwner;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.ChatEventListener;
import p015io.getstream.chat.android.client.api.models.QueryChannelRequest;
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.client.api.models.SendActionRequest;
import p015io.getstream.chat.android.client.api.models.WatchChannelRequest;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.controllers.ChannelController;
import p015io.getstream.chat.android.client.events.ChannelCreatedEvent;
import p015io.getstream.chat.android.client.events.ChannelDeletedEvent;
import p015io.getstream.chat.android.client.events.ChannelHiddenEvent;
import p015io.getstream.chat.android.client.events.ChannelMuteEvent;
import p015io.getstream.chat.android.client.events.ChannelTruncatedEvent;
import p015io.getstream.chat.android.client.events.ChannelUnmuteEvent;
import p015io.getstream.chat.android.client.events.ChannelUpdatedByUserEvent;
import p015io.getstream.chat.android.client.events.ChannelUpdatedEvent;
import p015io.getstream.chat.android.client.events.ChannelUserBannedEvent;
import p015io.getstream.chat.android.client.events.ChannelUserUnbannedEvent;
import p015io.getstream.chat.android.client.events.ChannelVisibleEvent;
import p015io.getstream.chat.android.client.events.ChannelsMuteEvent;
import p015io.getstream.chat.android.client.events.ChannelsUnmuteEvent;
import p015io.getstream.chat.android.client.events.ChatEvent;
import p015io.getstream.chat.android.client.events.ConnectedEvent;
import p015io.getstream.chat.android.client.events.ConnectingEvent;
import p015io.getstream.chat.android.client.events.DisconnectedEvent;
import p015io.getstream.chat.android.client.events.ErrorEvent;
import p015io.getstream.chat.android.client.events.GlobalUserBannedEvent;
import p015io.getstream.chat.android.client.events.GlobalUserUnbannedEvent;
import p015io.getstream.chat.android.client.events.HealthEvent;
import p015io.getstream.chat.android.client.events.MarkAllReadEvent;
import p015io.getstream.chat.android.client.events.MemberAddedEvent;
import p015io.getstream.chat.android.client.events.MemberRemovedEvent;
import p015io.getstream.chat.android.client.events.MemberUpdatedEvent;
import p015io.getstream.chat.android.client.events.MessageDeletedEvent;
import p015io.getstream.chat.android.client.events.MessageReadEvent;
import p015io.getstream.chat.android.client.events.MessageUpdatedEvent;
import p015io.getstream.chat.android.client.events.NewMessageEvent;
import p015io.getstream.chat.android.client.events.NotificationAddedToChannelEvent;
import p015io.getstream.chat.android.client.events.NotificationChannelDeletedEvent;
import p015io.getstream.chat.android.client.events.NotificationChannelMutesUpdatedEvent;
import p015io.getstream.chat.android.client.events.NotificationChannelTruncatedEvent;
import p015io.getstream.chat.android.client.events.NotificationInviteAcceptedEvent;
import p015io.getstream.chat.android.client.events.NotificationInvitedEvent;
import p015io.getstream.chat.android.client.events.NotificationMarkReadEvent;
import p015io.getstream.chat.android.client.events.NotificationMessageNewEvent;
import p015io.getstream.chat.android.client.events.NotificationMutesUpdatedEvent;
import p015io.getstream.chat.android.client.events.NotificationRemovedFromChannelEvent;
import p015io.getstream.chat.android.client.events.ReactionDeletedEvent;
import p015io.getstream.chat.android.client.events.ReactionNewEvent;
import p015io.getstream.chat.android.client.events.ReactionUpdateEvent;
import p015io.getstream.chat.android.client.events.TypingStartEvent;
import p015io.getstream.chat.android.client.events.TypingStopEvent;
import p015io.getstream.chat.android.client.events.UnknownEvent;
import p015io.getstream.chat.android.client.events.UserDeletedEvent;
import p015io.getstream.chat.android.client.events.UserMutedEvent;
import p015io.getstream.chat.android.client.events.UserPresenceChangedEvent;
import p015io.getstream.chat.android.client.events.UserStartWatchingEvent;
import p015io.getstream.chat.android.client.events.UserStopWatchingEvent;
import p015io.getstream.chat.android.client.events.UserUnmutedEvent;
import p015io.getstream.chat.android.client.events.UserUpdatedEvent;
import p015io.getstream.chat.android.client.events.UsersMutedEvent;
import p015io.getstream.chat.android.client.events.UsersUnmutedEvent;
import p015io.getstream.chat.android.client.models.Attachment;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.ChannelMute;
import p015io.getstream.chat.android.client.models.EventType;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.ModelFields;
import p015io.getstream.chat.android.client.models.Mute;
import p015io.getstream.chat.android.client.models.Reaction;
import p015io.getstream.chat.android.client.utils.FilterObject;
import p015io.getstream.chat.android.client.utils.ProgressCallback;
import p015io.getstream.chat.android.client.utils.observable.ChatObservable;
import p015io.getstream.chat.android.client.utils.observable.Disposable;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0017J'\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0013\"\u00020\u0003H\u0017¢\u0006\u0002\u0010\u0014J/\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e2\u0006\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0017¢\u0006\u0002\u0010\u001bJ0\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020!0 H\u0017J\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020!0 H\u0017J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0017J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u000e2\u0006\u0010%\u001a\u00020\u0003H\u0017J\u001e\u0010&\u001a\b\u0012\u0004\u0012\u00020$0\u000e2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003H\u0017J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0017J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010*\u001a\u00020\u001aH\u0017J\b\u0010+\u001a\u00020,H\u0016J&\u0010-\u001a\b\u0012\u0004\u0012\u0002H/0.\"\b\b\u0000\u0010/*\u0002002\f\u00101\u001a\b\u0012\u0004\u0012\u0002H/0.H\u0002J$\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u001e0\u000e2\u0006\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u001aH\u0007J$\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u001e0\u000e2\u0006\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u001aH\u0007J\u0016\u00107\u001a\b\u0012\u0004\u0012\u00020$0\u000e2\u0006\u0010%\u001a\u00020\u0003H\u0017J,\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001e0\u000e2\u0006\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u001a2\u0006\u00109\u001a\u00020\u0003H\u0007J,\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0\u001e0\u000e2\u0006\u0010%\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u001aH\u0017J,\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001e0\u000e2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u001aH\u0017J\u0016\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e2\u0006\u0010>\u001a\u00020?H\u0017J\u0010\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u000200H\u0002J\u000e\u0010B\u001a\b\u0012\u0004\u0012\u0002000\u000eH\u0017J\u0014\u0010B\u001a\b\u0012\u0004\u0012\u0002000\u000e2\u0006\u0010C\u001a\u00020\u0003J\u0016\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e2\u0006\u0010%\u001a\u00020\u0003H\u0017J\u000e\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00160\u000eH\u0017J\u000e\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00160\u000eH\u0017J\u000e\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\u000eH\u0017J\u0016\u0010I\u001a\b\u0012\u0004\u0012\u00020H0\u000e2\u0006\u0010J\u001a\u00020\u0003H\u0017J \u0010K\u001a\b\u0012\u0004\u0012\u00020$0\u000e2\u0006\u0010\u0010\u001a\u00020$2\b\u0010L\u001a\u0004\u0018\u00010MH\u0007J\u001e\u0010K\u001a\b\u0012\u0004\u0012\u00020$0\u000e2\u0006\u0010\u0010\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u0016\u0010N\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010O\u001a\u00020PH\u0017JH\u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020R0\u001e0\u000e2\u0006\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u001a2\u0006\u0010S\u001a\u00020T2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020R0V2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020R0\u001eH\u0017J\u000e\u0010W\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0017J'\u0010X\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0013\"\u00020\u0003H\u0017¢\u0006\u0002\u0010\u0014J\u0016\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e2\u0006\u0010\u0017\u001a\u00020\u0003H\u0017J\u0016\u0010Z\u001a\b\u0012\u0004\u0012\u00020$0\u000e2\u0006\u0010O\u001a\u00020[H\u0017J\u0016\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010]\u001a\u00020^H\u0017J\u001e\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020`H\u0017J\u0016\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010]\u001a\u00020^H\u0017J\u001e\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020`H\u0017J\u0016\u0010b\u001a\b\u0012\u0004\u0012\u00020$0\u000e2\u0006\u0010\u0010\u001a\u00020$H\u0017J\u001e\u0010c\u001a\b\u0012\u0004\u0012\u00020;0\u000e2\u0006\u0010d\u001a\u00020;2\u0006\u0010e\u001a\u00020?H\u0017J/\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e2\u0006\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0017¢\u0006\u0002\u0010\u001bJ\u000e\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00160\u000eH\u0017J\u000e\u0010h\u001a\b\u0012\u0004\u0012\u0002000\u000eH\u0017J\u0014\u0010h\u001a\b\u0012\u0004\u0012\u0002000\u000e2\u0006\u0010C\u001a\u00020\u0003J\u000e\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00160\u000eH\u0017J+\u0010j\u001a\u00020k2!\u00101\u001a\u001d\u0012\u0013\u0012\u001100¢\u0006\f\bm\u0012\b\bn\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020\u00160lH\u0017J\u0014\u0010j\u001a\u00020k2\f\u00101\u001a\b\u0012\u0004\u0012\u0002000.J\\\u0010o\u001a\u00020k2\u0006\u0010p\u001a\u00020q2\"\u0010r\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u0002000s0\u0013\"\n\u0012\u0006\b\u0001\u0012\u0002000s2!\u00101\u001a\u001d\u0012\u0013\u0012\u001100¢\u0006\f\bm\u0012\b\bn\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020\u00160lH\u0017¢\u0006\u0002\u0010tJE\u0010o\u001a\u00020k2\u0006\u0010p\u001a\u00020q2\"\u0010r\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u0002000s0\u0013\"\n\u0012\u0006\b\u0001\u0012\u0002000s2\f\u00101\u001a\b\u0012\u0004\u0012\u0002000.¢\u0006\u0002\u0010uJL\u0010o\u001a\u00020k2\u0006\u0010p\u001a\u00020q2\u0012\u0010r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0013\"\u00020\u00032!\u00101\u001a\u001d\u0012\u0013\u0012\u001100¢\u0006\f\bm\u0012\b\bn\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020\u00160lH\u0017¢\u0006\u0002\u0010vJ5\u0010o\u001a\u00020k2\u0006\u0010p\u001a\u00020q2\u0012\u0010r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0013\"\u00020\u00032\f\u00101\u001a\b\u0012\u0004\u0012\u0002000.¢\u0006\u0002\u0010wJT\u0010o\u001a\u00020k2\"\u0010r\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u0002000s0\u0013\"\n\u0012\u0006\b\u0001\u0012\u0002000s2!\u00101\u001a\u001d\u0012\u0013\u0012\u001100¢\u0006\f\bm\u0012\b\bn\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020\u00160lH\u0017¢\u0006\u0002\u0010xJ=\u0010o\u001a\u00020k2\"\u0010r\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u0002000s0\u0013\"\n\u0012\u0006\b\u0001\u0012\u0002000s2\f\u00101\u001a\b\u0012\u0004\u0012\u0002000.¢\u0006\u0002\u0010yJD\u0010o\u001a\u00020k2\u0012\u0010r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0013\"\u00020\u00032!\u00101\u001a\u001d\u0012\u0013\u0012\u001100¢\u0006\f\bm\u0012\b\bn\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020\u00160lH\u0017¢\u0006\u0002\u0010zJ-\u0010o\u001a\u00020k2\u0012\u0010r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0013\"\u00020\u00032\f\u00101\u001a\b\u0012\u0004\u0012\u0002000.¢\u0006\u0002\u0010{JC\u0010|\u001a\u00020k\"\b\b\u0000\u0010/*\u0002002\f\u0010}\u001a\b\u0012\u0004\u0012\u0002H/0s2!\u00101\u001a\u001d\u0012\u0013\u0012\u0011H/¢\u0006\f\bm\u0012\b\bn\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020\u00160lH\u0017J,\u0010|\u001a\u00020k\"\b\b\u0000\u0010/*\u0002002\f\u0010}\u001a\b\u0012\u0004\u0012\u0002H/0s2\f\u00101\u001a\b\u0012\u0004\u0012\u0002H/0.J3\u0010|\u001a\u00020k2\u0006\u0010}\u001a\u00020\u00032!\u00101\u001a\u001d\u0012\u0013\u0012\u001100¢\u0006\f\bm\u0012\b\bn\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020\u00160lH\u0017J\u001c\u0010|\u001a\u00020k2\u0006\u0010}\u001a\u00020\u00032\f\u00101\u001a\b\u0012\u0004\u0012\u0002000.J\u0016\u0010~\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e2\u0006\u0010\u0017\u001a\u00020\u0003H\u0017J\u000e\u0010\u001a\b\u0012\u0004\u0012\u00020\u00160\u000eH\u0017J\u000f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160\u000eH\u0017J\u0017\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e2\u0006\u0010J\u001a\u00020\u0003H\u0017J\u0017\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020$0\u000e2\u0006\u0010\u0010\u001a\u00020$H\u0007J-\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010$2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020!0 H\u0017J\u0017\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020$0\u000e2\u0006\u0010\u0010\u001a\u00020$H\u0017J\u000f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0017J\u0018\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0007\u0010O\u001a\u00030\u0001H\u0017J$\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0013\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020!0 H\u0017R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, mo26107d2 = {"Lio/getstream/chat/android/client/channel/ChannelClient;", "Lio/getstream/chat/android/client/controllers/ChannelController;", "channelType", "", "channelId", "client", "Lio/getstream/chat/android/client/ChatClient;", "(Ljava/lang/String;Ljava/lang/String;Lio/getstream/chat/android/client/ChatClient;)V", "getChannelId", "()Ljava/lang/String;", "getChannelType", "cid", "getCid", "acceptInvite", "Lio/getstream/chat/android/client/call/Call;", "Lio/getstream/chat/android/client/models/Channel;", "message", "addMembers", "userIds", "", "([Ljava/lang/String;)Lio/getstream/chat/android/client/call/Call;", "banUser", "", "targetId", "reason", "timeout", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lio/getstream/chat/android/client/call/Call;", "create", "members", "", "extraData", "", "", "delete", "deleteMessage", "Lio/getstream/chat/android/client/models/Message;", "messageId", "deleteReaction", "reactionType", "disableSlowMode", "enableSlowMode", "cooldownTimeInSeconds", "events", "Lio/getstream/chat/android/client/utils/observable/ChatObservable;", "filterRelevantEvents", "Lio/getstream/chat/android/client/ChatEventListener;", "T", "Lio/getstream/chat/android/client/events/ChatEvent;", "listener", "getFileAttachments", "Lio/getstream/chat/android/client/models/Attachment;", "offset", "limit", "getImageAttachments", "getMessage", "getMessagesWithAttachments", "type", "getReactions", "Lio/getstream/chat/android/client/models/Reaction;", "firstReactionId", "hide", "clearHistory", "", "isRelevantForChannel", "event", "keystroke", "parentId", "markMessageRead", "markRead", "mute", "muteCurrentUser", "Lio/getstream/chat/android/client/models/Mute;", "muteUser", "userId", "pinMessage", "expirationDate", "Ljava/util/Date;", "query", "request", "Lio/getstream/chat/android/client/api/models/QueryChannelRequest;", "queryMembers", "Lio/getstream/chat/android/client/models/Member;", "filter", "Lio/getstream/chat/android/client/utils/FilterObject;", "sort", "Lio/getstream/chat/android/client/api/models/QuerySort;", "rejectInvite", "removeMembers", "removeShadowBan", "sendAction", "Lio/getstream/chat/android/client/api/models/SendActionRequest;", "sendFile", "file", "Ljava/io/File;", "callback", "Lio/getstream/chat/android/client/utils/ProgressCallback;", "sendImage", "sendMessage", "sendReaction", "reaction", "enforceUnique", "shadowBanUser", "show", "stopTyping", "stopWatching", "subscribe", "Lio/getstream/chat/android/client/utils/observable/Disposable;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "subscribeFor", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "eventTypes", "Ljava/lang/Class;", "(Landroidx/lifecycle/LifecycleOwner;[Ljava/lang/Class;Lkotlin/jvm/functions/Function1;)Lio/getstream/chat/android/client/utils/observable/Disposable;", "(Landroidx/lifecycle/LifecycleOwner;[Ljava/lang/Class;Lio/getstream/chat/android/client/ChatEventListener;)Lio/getstream/chat/android/client/utils/observable/Disposable;", "(Landroidx/lifecycle/LifecycleOwner;[Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lio/getstream/chat/android/client/utils/observable/Disposable;", "(Landroidx/lifecycle/LifecycleOwner;[Ljava/lang/String;Lio/getstream/chat/android/client/ChatEventListener;)Lio/getstream/chat/android/client/utils/observable/Disposable;", "([Ljava/lang/Class;Lkotlin/jvm/functions/Function1;)Lio/getstream/chat/android/client/utils/observable/Disposable;", "([Ljava/lang/Class;Lio/getstream/chat/android/client/ChatEventListener;)Lio/getstream/chat/android/client/utils/observable/Disposable;", "([Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lio/getstream/chat/android/client/utils/observable/Disposable;", "([Ljava/lang/String;Lio/getstream/chat/android/client/ChatEventListener;)Lio/getstream/chat/android/client/utils/observable/Disposable;", "subscribeForSingle", "eventType", "unBanUser", "unmute", "unmuteCurrentUser", "unmuteUser", "unpinMessage", "update", "updateMessage", "watch", "Lio/getstream/chat/android/client/api/models/WatchChannelRequest;", "data", "Companion", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.channel.ChannelClient */
/* compiled from: ChannelClient.kt */
public final class ChannelClient implements ChannelController {
    @Deprecated
    private static final String ARG_TYPING_PARENT_ID = "parent_id";
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String channelId;
    private final String channelType;
    private final String cid = (getChannelType() + ':' + getChannelId());
    private final ChatClient client;

    public ChannelClient(String str, String str2, ChatClient chatClient) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(chatClient, "client");
        this.channelType = str;
        this.channelId = str2;
        this.client = chatClient;
    }

    public String getChannelType() {
        return this.channelType;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public String getCid() {
        return this.cid;
    }

    public Call<Channel> create(List<String> list, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(list, ModelFields.MEMBERS);
        Intrinsics.checkNotNullParameter(map, "extraData");
        return this.client.createChannel(getChannelType(), getChannelId(), list, map);
    }

    public Call<Channel> create(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "extraData");
        return this.client.createChannel(getChannelType(), getChannelId(), (List<String>) CollectionsKt.emptyList());
    }

    public ChatObservable events() {
        return this.client.events().filter((Function1<? super ChatEvent, Boolean>) new ChannelClient$events$1(this));
    }

    @Deprecated(message = "Use subscribe with ChatEventListener")
    public Disposable subscribe(Function1<? super ChatEvent, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return this.client.subscribe((ChatEventListener<ChatEvent>) filterRelevantEvents(new C4949xeaeac4be(function1)));
    }

    public final Disposable subscribe(ChatEventListener<ChatEvent> chatEventListener) {
        Intrinsics.checkNotNullParameter(chatEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return this.client.subscribe((ChatEventListener<ChatEvent>) filterRelevantEvents(chatEventListener));
    }

    @Deprecated(message = "Use subscribeFor with ChatEventListener")
    public Disposable subscribeFor(String[] strArr, Function1<? super ChatEvent, Unit> function1) {
        Intrinsics.checkNotNullParameter(strArr, "eventTypes");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return this.client.subscribeFor((String[]) Arrays.copyOf(strArr, strArr.length), (ChatEventListener<ChatEvent>) filterRelevantEvents(new C4949xeaeac4be(function1)));
    }

    public final Disposable subscribeFor(String[] strArr, ChatEventListener<ChatEvent> chatEventListener) {
        Intrinsics.checkNotNullParameter(strArr, "eventTypes");
        Intrinsics.checkNotNullParameter(chatEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return this.client.subscribeFor((String[]) Arrays.copyOf(strArr, strArr.length), (ChatEventListener<ChatEvent>) filterRelevantEvents(chatEventListener));
    }

    @Deprecated(message = "Use subscribeFor with ChatEventListener")
    public Disposable subscribeFor(LifecycleOwner lifecycleOwner, String[] strArr, Function1<? super ChatEvent, Unit> function1) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(strArr, "eventTypes");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return this.client.subscribeFor(lifecycleOwner, (String[]) Arrays.copyOf(strArr, strArr.length), (ChatEventListener<ChatEvent>) filterRelevantEvents(new C4949xeaeac4be(function1)));
    }

    public final Disposable subscribeFor(LifecycleOwner lifecycleOwner, String[] strArr, ChatEventListener<ChatEvent> chatEventListener) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(strArr, "eventTypes");
        Intrinsics.checkNotNullParameter(chatEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return this.client.subscribeFor(lifecycleOwner, (String[]) Arrays.copyOf(strArr, strArr.length), (ChatEventListener<ChatEvent>) filterRelevantEvents(chatEventListener));
    }

    @Deprecated(message = "Use subscribeFor with ChatEventListener")
    public Disposable subscribeFor(Class<? extends ChatEvent>[] clsArr, Function1<? super ChatEvent, Unit> function1) {
        Intrinsics.checkNotNullParameter(clsArr, "eventTypes");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return this.client.subscribeFor((Class<? extends ChatEvent>[]) (Class[]) Arrays.copyOf(clsArr, clsArr.length), (ChatEventListener<ChatEvent>) filterRelevantEvents(new C4949xeaeac4be(function1)));
    }

    public final Disposable subscribeFor(Class<? extends ChatEvent>[] clsArr, ChatEventListener<ChatEvent> chatEventListener) {
        Intrinsics.checkNotNullParameter(clsArr, "eventTypes");
        Intrinsics.checkNotNullParameter(chatEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return this.client.subscribeFor((Class<? extends ChatEvent>[]) (Class[]) Arrays.copyOf(clsArr, clsArr.length), (ChatEventListener<ChatEvent>) filterRelevantEvents(chatEventListener));
    }

    @Deprecated(message = "Use subscribeFor with ChatEventListener")
    public Disposable subscribeFor(LifecycleOwner lifecycleOwner, Class<? extends ChatEvent>[] clsArr, Function1<? super ChatEvent, Unit> function1) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(clsArr, "eventTypes");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return this.client.subscribeFor(lifecycleOwner, (Class<? extends ChatEvent>[]) (Class[]) Arrays.copyOf(clsArr, clsArr.length), (ChatEventListener<ChatEvent>) filterRelevantEvents(new C4949xeaeac4be(function1)));
    }

    public final Disposable subscribeFor(LifecycleOwner lifecycleOwner, Class<? extends ChatEvent>[] clsArr, ChatEventListener<ChatEvent> chatEventListener) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(clsArr, "eventTypes");
        Intrinsics.checkNotNullParameter(chatEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return this.client.subscribeFor(lifecycleOwner, (Class<? extends ChatEvent>[]) (Class[]) Arrays.copyOf(clsArr, clsArr.length), (ChatEventListener<ChatEvent>) filterRelevantEvents(chatEventListener));
    }

    @Deprecated(message = "Use subscribeForSingle with ChatEventListener")
    public Disposable subscribeForSingle(String str, Function1<? super ChatEvent, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "eventType");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return this.client.subscribeForSingle(str, (ChatEventListener<ChatEvent>) filterRelevantEvents(new C4949xeaeac4be(function1)));
    }

    public final Disposable subscribeForSingle(String str, ChatEventListener<ChatEvent> chatEventListener) {
        Intrinsics.checkNotNullParameter(str, "eventType");
        Intrinsics.checkNotNullParameter(chatEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return this.client.subscribeForSingle(str, (ChatEventListener<ChatEvent>) filterRelevantEvents(chatEventListener));
    }

    @Deprecated(message = "Use subscribeForSingle with ChatEventListener")
    public <T extends ChatEvent> Disposable subscribeForSingle(Class<T> cls, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(cls, "eventType");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return this.client.subscribeForSingle(cls, filterRelevantEvents(new C4949xeaeac4be(function1)));
    }

    public final <T extends ChatEvent> Disposable subscribeForSingle(Class<T> cls, ChatEventListener<T> chatEventListener) {
        Intrinsics.checkNotNullParameter(cls, "eventType");
        Intrinsics.checkNotNullParameter(chatEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return this.client.subscribeForSingle(cls, filterRelevantEvents(chatEventListener));
    }

    private final <T extends ChatEvent> ChatEventListener<T> filterRelevantEvents(ChatEventListener<T> chatEventListener) {
        return new ChannelClient$filterRelevantEvents$1<>(this, chatEventListener);
    }

    /* access modifiers changed from: private */
    public final boolean isRelevantForChannel(ChatEvent chatEvent) {
        if (chatEvent instanceof ChannelCreatedEvent) {
            return Intrinsics.areEqual((Object) ((ChannelCreatedEvent) chatEvent).getCid(), (Object) getCid());
        }
        if (chatEvent instanceof ChannelDeletedEvent) {
            return Intrinsics.areEqual((Object) ((ChannelDeletedEvent) chatEvent).getCid(), (Object) getCid());
        }
        if (chatEvent instanceof ChannelHiddenEvent) {
            return Intrinsics.areEqual((Object) ((ChannelHiddenEvent) chatEvent).getCid(), (Object) getCid());
        }
        if (chatEvent instanceof ChannelMuteEvent) {
            return Intrinsics.areEqual((Object) ((ChannelMuteEvent) chatEvent).getChannelMute().getChannel().getCid(), (Object) getCid());
        }
        if (chatEvent instanceof ChannelsMuteEvent) {
            Iterable<ChannelMute> channelsMute = ((ChannelsMuteEvent) chatEvent).getChannelsMute();
            if (!(channelsMute instanceof Collection) || !((Collection) channelsMute).isEmpty()) {
                for (ChannelMute channel : channelsMute) {
                    if (Intrinsics.areEqual((Object) channel.getChannel().getCid(), (Object) getCid())) {
                        return true;
                    }
                }
            }
        } else if (chatEvent instanceof ChannelTruncatedEvent) {
            return Intrinsics.areEqual((Object) ((ChannelTruncatedEvent) chatEvent).getCid(), (Object) getCid());
        } else {
            if (chatEvent instanceof ChannelUnmuteEvent) {
                return Intrinsics.areEqual((Object) ((ChannelUnmuteEvent) chatEvent).getChannelMute().getChannel().getCid(), (Object) getCid());
            }
            if (chatEvent instanceof ChannelsUnmuteEvent) {
                Iterable<ChannelMute> channelsMute2 = ((ChannelsUnmuteEvent) chatEvent).getChannelsMute();
                if (!(channelsMute2 instanceof Collection) || !((Collection) channelsMute2).isEmpty()) {
                    for (ChannelMute channel2 : channelsMute2) {
                        if (Intrinsics.areEqual((Object) channel2.getChannel().getCid(), (Object) getCid())) {
                            return true;
                        }
                    }
                }
            } else if (chatEvent instanceof ChannelUpdatedEvent) {
                return Intrinsics.areEqual((Object) ((ChannelUpdatedEvent) chatEvent).getCid(), (Object) getCid());
            } else {
                if (chatEvent instanceof ChannelUpdatedByUserEvent) {
                    return Intrinsics.areEqual((Object) ((ChannelUpdatedByUserEvent) chatEvent).getCid(), (Object) getCid());
                }
                if (chatEvent instanceof ChannelVisibleEvent) {
                    return Intrinsics.areEqual((Object) ((ChannelVisibleEvent) chatEvent).getCid(), (Object) getCid());
                }
                if (chatEvent instanceof MemberAddedEvent) {
                    return Intrinsics.areEqual((Object) ((MemberAddedEvent) chatEvent).getCid(), (Object) getCid());
                }
                if (chatEvent instanceof MemberRemovedEvent) {
                    return Intrinsics.areEqual((Object) ((MemberRemovedEvent) chatEvent).getCid(), (Object) getCid());
                }
                if (chatEvent instanceof MemberUpdatedEvent) {
                    return Intrinsics.areEqual((Object) ((MemberUpdatedEvent) chatEvent).getCid(), (Object) getCid());
                }
                if (chatEvent instanceof MessageDeletedEvent) {
                    return Intrinsics.areEqual((Object) ((MessageDeletedEvent) chatEvent).getCid(), (Object) getCid());
                }
                if (chatEvent instanceof MessageReadEvent) {
                    return Intrinsics.areEqual((Object) ((MessageReadEvent) chatEvent).getCid(), (Object) getCid());
                }
                if (chatEvent instanceof MessageUpdatedEvent) {
                    return Intrinsics.areEqual((Object) ((MessageUpdatedEvent) chatEvent).getCid(), (Object) getCid());
                }
                if (chatEvent instanceof NewMessageEvent) {
                    return Intrinsics.areEqual((Object) ((NewMessageEvent) chatEvent).getCid(), (Object) getCid());
                }
                if (chatEvent instanceof NotificationAddedToChannelEvent) {
                    return Intrinsics.areEqual((Object) ((NotificationAddedToChannelEvent) chatEvent).getCid(), (Object) getCid());
                }
                if (chatEvent instanceof NotificationChannelDeletedEvent) {
                    return Intrinsics.areEqual((Object) ((NotificationChannelDeletedEvent) chatEvent).getCid(), (Object) getCid());
                }
                if (chatEvent instanceof NotificationChannelTruncatedEvent) {
                    return Intrinsics.areEqual((Object) ((NotificationChannelTruncatedEvent) chatEvent).getCid(), (Object) getCid());
                }
                if (chatEvent instanceof NotificationInviteAcceptedEvent) {
                    return Intrinsics.areEqual((Object) ((NotificationInviteAcceptedEvent) chatEvent).getCid(), (Object) getCid());
                }
                if (chatEvent instanceof NotificationInvitedEvent) {
                    return Intrinsics.areEqual((Object) ((NotificationInvitedEvent) chatEvent).getCid(), (Object) getCid());
                }
                if (chatEvent instanceof NotificationMarkReadEvent) {
                    return Intrinsics.areEqual((Object) ((NotificationMarkReadEvent) chatEvent).getCid(), (Object) getCid());
                }
                if (chatEvent instanceof NotificationMessageNewEvent) {
                    return Intrinsics.areEqual((Object) ((NotificationMessageNewEvent) chatEvent).getCid(), (Object) getCid());
                }
                if (chatEvent instanceof NotificationRemovedFromChannelEvent) {
                    return Intrinsics.areEqual((Object) ((NotificationRemovedFromChannelEvent) chatEvent).getCid(), (Object) getCid());
                }
                if (chatEvent instanceof ReactionDeletedEvent) {
                    return Intrinsics.areEqual((Object) ((ReactionDeletedEvent) chatEvent).getCid(), (Object) getCid());
                }
                if (chatEvent instanceof ReactionNewEvent) {
                    return Intrinsics.areEqual((Object) ((ReactionNewEvent) chatEvent).getCid(), (Object) getCid());
                }
                if (chatEvent instanceof ReactionUpdateEvent) {
                    return Intrinsics.areEqual((Object) ((ReactionUpdateEvent) chatEvent).getCid(), (Object) getCid());
                }
                if (chatEvent instanceof TypingStartEvent) {
                    return Intrinsics.areEqual((Object) ((TypingStartEvent) chatEvent).getCid(), (Object) getCid());
                }
                if (chatEvent instanceof TypingStopEvent) {
                    return Intrinsics.areEqual((Object) ((TypingStopEvent) chatEvent).getCid(), (Object) getCid());
                }
                if (chatEvent instanceof ChannelUserBannedEvent) {
                    return Intrinsics.areEqual((Object) ((ChannelUserBannedEvent) chatEvent).getCid(), (Object) getCid());
                }
                if (chatEvent instanceof UserStartWatchingEvent) {
                    return Intrinsics.areEqual((Object) ((UserStartWatchingEvent) chatEvent).getCid(), (Object) getCid());
                }
                if (chatEvent instanceof UserStopWatchingEvent) {
                    return Intrinsics.areEqual((Object) ((UserStopWatchingEvent) chatEvent).getCid(), (Object) getCid());
                }
                if (chatEvent instanceof ChannelUserUnbannedEvent) {
                    return Intrinsics.areEqual((Object) ((ChannelUserUnbannedEvent) chatEvent).getCid(), (Object) getCid());
                }
                if (chatEvent instanceof UnknownEvent) {
                    return Intrinsics.areEqual((Object) ((UnknownEvent) chatEvent).getRawData().get("cid"), (Object) getCid());
                }
                if (!(chatEvent instanceof HealthEvent) && !(chatEvent instanceof NotificationChannelMutesUpdatedEvent) && !(chatEvent instanceof NotificationMutesUpdatedEvent) && !(chatEvent instanceof GlobalUserBannedEvent) && !(chatEvent instanceof UserDeletedEvent) && !(chatEvent instanceof UserMutedEvent) && !(chatEvent instanceof UsersMutedEvent) && !(chatEvent instanceof UserPresenceChangedEvent) && !(chatEvent instanceof GlobalUserUnbannedEvent) && !(chatEvent instanceof UserUnmutedEvent) && !(chatEvent instanceof UsersUnmutedEvent) && !(chatEvent instanceof UserUpdatedEvent) && !(chatEvent instanceof ConnectedEvent) && !(chatEvent instanceof ConnectingEvent) && !(chatEvent instanceof DisconnectedEvent) && !(chatEvent instanceof ErrorEvent) && !(chatEvent instanceof MarkAllReadEvent)) {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        return false;
    }

    public Call<Channel> query(QueryChannelRequest queryChannelRequest) {
        Intrinsics.checkNotNullParameter(queryChannelRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        return this.client.queryChannel(getChannelType(), getChannelId(), queryChannelRequest);
    }

    public Call<Channel> watch(WatchChannelRequest watchChannelRequest) {
        Intrinsics.checkNotNullParameter(watchChannelRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        return this.client.queryChannel(getChannelType(), getChannelId(), watchChannelRequest);
    }

    public Call<Channel> watch(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "data");
        WatchChannelRequest watchChannelRequest = new WatchChannelRequest();
        watchChannelRequest.getData().putAll(map);
        return watch(watchChannelRequest);
    }

    public Call<Channel> watch() {
        return this.client.queryChannel(getChannelType(), getChannelId(), new WatchChannelRequest());
    }

    public Call<Unit> stopWatching() {
        return this.client.stopWatching(getChannelType(), getChannelId());
    }

    public Call<Message> getMessage(String str) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        return this.client.getMessage(str);
    }

    public Call<Message> updateMessage(Message message) {
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return this.client.updateMessage(message);
    }

    public Call<Message> deleteMessage(String str) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        return this.client.deleteMessage(str);
    }

    public Call<Message> sendMessage(Message message) {
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return this.client.sendMessage(getChannelType(), getChannelId(), message);
    }

    public Call<Unit> banUser(String str, String str2, Integer num) {
        Intrinsics.checkNotNullParameter(str, "targetId");
        return this.client.banUser(str, getChannelType(), getChannelId(), str2, num);
    }

    public Call<Unit> unBanUser(String str) {
        Intrinsics.checkNotNullParameter(str, "targetId");
        return this.client.unBanUser(str, getChannelType(), getChannelId());
    }

    public Call<Unit> shadowBanUser(String str, String str2, Integer num) {
        Intrinsics.checkNotNullParameter(str, "targetId");
        return this.client.shadowBanUser(str, getChannelType(), getChannelId(), str2, num);
    }

    public Call<Unit> removeShadowBan(String str) {
        Intrinsics.checkNotNullParameter(str, "targetId");
        return this.client.removeShadowBan(str, getChannelType(), getChannelId());
    }

    public Call<Unit> markMessageRead(String str) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        return this.client.markMessageRead(getChannelType(), getChannelId(), str);
    }

    public Call<Unit> markRead() {
        return this.client.markRead(getChannelType(), getChannelId());
    }

    public Call<Channel> delete() {
        return this.client.deleteChannel(getChannelType(), getChannelId());
    }

    public Call<Unit> show() {
        return this.client.showChannel(getChannelType(), getChannelId());
    }

    public Call<Unit> hide(boolean z) {
        return this.client.hideChannel(getChannelType(), getChannelId(), z);
    }

    public Call<String> sendFile(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return ChatClient.sendFile$default(this.client, getChannelType(), getChannelId(), file, (ProgressCallback) null, 8, (Object) null);
    }

    public Call<String> sendImage(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return ChatClient.sendImage$default(this.client, getChannelType(), getChannelId(), file, (ProgressCallback) null, 8, (Object) null);
    }

    public Call<String> sendFile(File file, ProgressCallback progressCallback) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(progressCallback, "callback");
        return ChatClient.sendFile$default(this.client, getChannelType(), getChannelId(), file, (ProgressCallback) null, 8, (Object) null);
    }

    public Call<String> sendImage(File file, ProgressCallback progressCallback) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(progressCallback, "callback");
        return ChatClient.sendImage$default(this.client, getChannelType(), getChannelId(), file, (ProgressCallback) null, 8, (Object) null);
    }

    public Call<Reaction> sendReaction(Reaction reaction, boolean z) {
        Intrinsics.checkNotNullParameter(reaction, "reaction");
        return this.client.sendReaction(reaction, z);
    }

    public Call<Message> sendAction(SendActionRequest sendActionRequest) {
        Intrinsics.checkNotNullParameter(sendActionRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        return this.client.sendAction(sendActionRequest);
    }

    public Call<Message> deleteReaction(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        Intrinsics.checkNotNullParameter(str2, "reactionType");
        return this.client.deleteReaction(str, str2);
    }

    public Call<List<Reaction>> getReactions(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        return this.client.getReactions(str, i, i2);
    }

    public Call<List<Message>> getReactions(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        Intrinsics.checkNotNullParameter(str2, "firstReactionId");
        return this.client.getRepliesMore(str, str2, i);
    }

    public Call<Channel> update(Message message, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "extraData");
        return this.client.updateChannel(getChannelType(), getChannelId(), message, map);
    }

    public Call<Channel> enableSlowMode(int i) {
        return this.client.enableSlowMode(getChannelType(), getChannelId(), i);
    }

    public Call<Channel> disableSlowMode() {
        return this.client.disableSlowMode(getChannelType(), getChannelId());
    }

    public Call<Channel> addMembers(String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "userIds");
        return this.client.addMembers(getChannelType(), getChannelId(), ArraysKt.toList((T[]) strArr));
    }

    public Call<Channel> removeMembers(String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "userIds");
        return this.client.removeMembers(getChannelType(), getChannelId(), ArraysKt.toList((T[]) strArr));
    }

    public Call<Channel> acceptInvite(String str) {
        return this.client.acceptInvite(getChannelType(), getChannelId(), str);
    }

    public Call<Channel> rejectInvite() {
        return this.client.rejectInvite(getChannelType(), getChannelId());
    }

    public Call<Mute> muteCurrentUser() {
        return this.client.muteCurrentUser();
    }

    public Call<Unit> mute() {
        return this.client.muteChannel(getChannelType(), getChannelId());
    }

    public Call<Unit> unmute() {
        return this.client.unMuteChannel(getChannelType(), getChannelId());
    }

    public Call<Mute> muteUser(String str) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        return this.client.muteUser(str);
    }

    public Call<Unit> unmuteUser(String str) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        return this.client.unmuteUser(str);
    }

    public Call<Unit> unmuteCurrentUser() {
        return this.client.unmuteCurrentUser();
    }

    public Call<ChatEvent> keystroke() {
        return ChatClient.sendEvent$default(this.client, EventType.TYPING_START, getChannelType(), getChannelId(), (Map) null, 8, (Object) null);
    }

    public final Call<ChatEvent> keystroke(String str) {
        Intrinsics.checkNotNullParameter(str, "parentId");
        return this.client.sendEvent(EventType.TYPING_START, getChannelType(), getChannelId(), MapsKt.mapOf(TuplesKt.m181to(ARG_TYPING_PARENT_ID, str)));
    }

    public Call<ChatEvent> stopTyping() {
        return ChatClient.sendEvent$default(this.client, EventType.TYPING_STOP, getChannelType(), getChannelId(), (Map) null, 8, (Object) null);
    }

    public final Call<ChatEvent> stopTyping(String str) {
        Intrinsics.checkNotNullParameter(str, "parentId");
        return this.client.sendEvent(EventType.TYPING_STOP, getChannelType(), getChannelId(), MapsKt.mapOf(TuplesKt.m181to(ARG_TYPING_PARENT_ID, str)));
    }

    public Call<List<Member>> queryMembers(int i, int i2, FilterObject filterObject, QuerySort<Member> querySort, List<Member> list) {
        Intrinsics.checkNotNullParameter(filterObject, "filter");
        Intrinsics.checkNotNullParameter(querySort, "sort");
        Intrinsics.checkNotNullParameter(list, ModelFields.MEMBERS);
        return this.client.queryMembers(getChannelType(), getChannelId(), i, i2, filterObject, querySort, list);
    }

    public final Call<List<Attachment>> getFileAttachments(int i, int i2) {
        return this.client.getFileAttachments(getChannelType(), getChannelId(), i, i2);
    }

    public final Call<List<Attachment>> getImageAttachments(int i, int i2) {
        return this.client.getImageAttachments(getChannelType(), getChannelId(), i, i2);
    }

    public final Call<List<Message>> getMessagesWithAttachments(int i, int i2, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        return this.client.getMessagesWithAttachments(getChannelType(), getChannelId(), i, i2, str);
    }

    public final Call<Message> pinMessage(Message message, Date date) {
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return this.client.pinMessage(message, date);
    }

    public final Call<Message> pinMessage(Message message, int i) {
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return this.client.pinMessage(message, i);
    }

    public final Call<Message> unpinMessage(Message message) {
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return this.client.unpinMessage(message);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lio/getstream/chat/android/client/channel/ChannelClient$Companion;", "", "()V", "ARG_TYPING_PARENT_ID", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.channel.ChannelClient$Companion */
    /* compiled from: ChannelClient.kt */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
