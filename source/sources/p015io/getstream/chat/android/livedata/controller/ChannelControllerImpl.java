package p015io.getstream.chat.android.livedata.controller;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import com.facebook.share.internal.ShareConstants;
import com.getstream.sdk.chat.model.ModelType;
import com.google.firebase.messaging.Constants;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.api.models.Pagination;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.call.CallKt;
import p015io.getstream.chat.android.client.channel.ChannelClient;
import p015io.getstream.chat.android.client.events.ChannelDeletedEvent;
import p015io.getstream.chat.android.client.events.ChannelHiddenEvent;
import p015io.getstream.chat.android.client.events.ChannelTruncatedEvent;
import p015io.getstream.chat.android.client.events.ChannelUpdatedByUserEvent;
import p015io.getstream.chat.android.client.events.ChannelUpdatedEvent;
import p015io.getstream.chat.android.client.events.ChannelVisibleEvent;
import p015io.getstream.chat.android.client.events.ChatEvent;
import p015io.getstream.chat.android.client.events.MarkAllReadEvent;
import p015io.getstream.chat.android.client.events.MemberAddedEvent;
import p015io.getstream.chat.android.client.events.MemberRemovedEvent;
import p015io.getstream.chat.android.client.events.MemberUpdatedEvent;
import p015io.getstream.chat.android.client.events.MessageDeletedEvent;
import p015io.getstream.chat.android.client.events.MessageReadEvent;
import p015io.getstream.chat.android.client.events.MessageUpdatedEvent;
import p015io.getstream.chat.android.client.events.NewMessageEvent;
import p015io.getstream.chat.android.client.events.NotificationAddedToChannelEvent;
import p015io.getstream.chat.android.client.events.NotificationChannelTruncatedEvent;
import p015io.getstream.chat.android.client.events.NotificationMarkReadEvent;
import p015io.getstream.chat.android.client.events.NotificationMessageNewEvent;
import p015io.getstream.chat.android.client.events.ReactionDeletedEvent;
import p015io.getstream.chat.android.client.events.ReactionNewEvent;
import p015io.getstream.chat.android.client.events.ReactionUpdateEvent;
import p015io.getstream.chat.android.client.events.TypingStartEvent;
import p015io.getstream.chat.android.client.events.TypingStopEvent;
import p015io.getstream.chat.android.client.events.UserPresenceChangedEvent;
import p015io.getstream.chat.android.client.events.UserStartWatchingEvent;
import p015io.getstream.chat.android.client.events.UserStopWatchingEvent;
import p015io.getstream.chat.android.client.events.UserUpdatedEvent;
import p015io.getstream.chat.android.client.helpers.AttachmentHelper;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.TaggedLogger;
import p015io.getstream.chat.android.client.models.Attachment;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.ChannelUserRead;
import p015io.getstream.chat.android.client.models.Config;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.ModelFields;
import p015io.getstream.chat.android.client.models.Reaction;
import p015io.getstream.chat.android.client.models.TypingEvent;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.ProgressCallback;
import p015io.getstream.chat.android.client.utils.Result;
import p015io.getstream.chat.android.livedata.ChannelData;
import p015io.getstream.chat.android.livedata.ChatDomainImpl;
import p015io.getstream.chat.android.livedata.controller.ChannelController;
import p015io.getstream.chat.android.livedata.controller.helper.MessageHelper;
import p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt;
import p015io.getstream.chat.android.livedata.extensions.MessageExtensionsKt;
import p015io.getstream.chat.android.livedata.request.QueryChannelPaginationRequest;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000¦\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u001e\n\u0002\b\u001a\b\u0000\u0018\u0000 \u00022\u00020\u0001:\u0002\u0002B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ!\u0010~\u001a\b\u0012\u0004\u0012\u00020\u000e02\u0007\u0010\u0001\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\n\u0010\u0001\u001a\u00030\u0001H\u0016J\u001a\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0003H\u0002J\"\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u001802\u0007\u0010\u0001\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J#\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u001802\b\u0010\u0001\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020(H\u0002J\"\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u001802\u0007\u0010\u0001\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u00020\u0003H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u0015\u0010\u0001\u001a\u0004\u0018\u00010\u00032\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0014\u0010\u0001\u001a\u0004\u0018\u00010\u00182\u0007\u0010\u0001\u001a\u00020\u0003H\u0016J\u0012\u0010\u0001\u001a\u00020\u00032\u0007\u0010\u0001\u001a\u00020\u0018H\u0002J\u0010\u0010\u0001\u001a\u00020o2\u0007\u0010\u0001\u001a\u00020\u0003J \u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020#H@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J&\u0010\u0001\u001a\u00030\u00012\r\u0010 \u0001\u001a\b\u0012\u0004\u0012\u00020#0UH@ø\u0001\u0000¢\u0006\u0006\b¡\u0001\u0010¢\u0001J1\u0010£\u0001\u001a\b\u0012\u0004\u0012\u00020\u001802\u0007\u0010\u0001\u001a\u00020\u00182\r\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180H@ø\u0001\u0000¢\u0006\u0003\u0010¥\u0001J(\u0010¦\u0001\u001a\b\u0012\u0004\u0012\u00020\u001802\r\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180H@ø\u0001\u0000¢\u0006\u0003\u0010§\u0001J#\u0010¨\u0001\u001a\t\u0012\u0005\u0012\u00030\u000102\u0007\u0010©\u0001\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0003\u0010ª\u0001J\u0013\u0010«\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0018H\u0002J\u0007\u0010¬\u0001\u001a\u00020\u000eJ\u0018\u0010­\u0001\u001a\b\u0012\u0004\u0012\u00020\u000e02\t\u0010®\u0001\u001a\u0004\u0018\u00010\u0003J\u001a\u0010¯\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J7\u0010°\u0001\u001a\b\u0012\u0004\u0012\u00020\u001802\u0007\u0010\u0001\u001a\u00020\u00032\u0007\u0010±\u0001\u001a\u00020%2\u0007\u0010²\u0001\u001a\u00020%H@ø\u0001\u0000¢\u0006\u0006\b³\u0001\u0010´\u0001J%\u0010µ\u0001\u001a\t\u0012\u0005\u0012\u00030¶\u000102\t\b\u0002\u0010·\u0001\u001a\u00020%H@ø\u0001\u0000¢\u0006\u0003\u0010¸\u0001J,\u0010µ\u0001\u001a\t\u0012\u0005\u0012\u00030¶\u000102\u0007\u0010\u0001\u001a\u00020\u00032\u0007\u0010·\u0001\u001a\u00020%H@ø\u0001\u0000¢\u0006\u0003\u0010¹\u0001J%\u0010º\u0001\u001a\t\u0012\u0005\u0012\u00030¶\u000102\t\b\u0002\u0010·\u0001\u001a\u00020%H@ø\u0001\u0000¢\u0006\u0003\u0010¸\u0001J,\u0010º\u0001\u001a\t\u0012\u0005\u0012\u00030¶\u000102\u0007\u0010\u0001\u001a\u00020\u00032\u0007\u0010·\u0001\u001a\u00020%H@ø\u0001\u0000¢\u0006\u0003\u0010¹\u0001J:\u0010»\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180U02\u0007\u0010\u0001\u001a\u00020\u00032\u0007\u0010·\u0001\u001a\u00020%2\u000b\b\u0002\u0010¼\u0001\u001a\u0004\u0018\u00010\u0018H\u0000¢\u0006\u0003\b½\u0001J\u000f\u0010¾\u0001\u001a\u00020\u000eH\u0000¢\u0006\u0003\b¿\u0001J/\u0010À\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180U0t2\u0018\u0010Y\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u00150\u000bH\u0002J#\u0010Á\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u00152\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00180UH\u0002J\u0013\u0010Â\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0018H\u0002J\u0013\u0010Ã\u0001\u001a\u00030\u00012\u0007\u0010Ä\u0001\u001a\u00020BH\u0002J\u001a\u0010Å\u0001\u001a\u00030\u00012\b\u0010j\u001a\u0004\u0018\u00010\u0018H\u0000¢\u0006\u0003\bÆ\u0001J$\u0010Ç\u0001\u001a\t\u0012\u0005\u0012\u00030¶\u000102\b\u0010È\u0001\u001a\u00030É\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010Ê\u0001J \u0010Ë\u0001\u001a\u0005\u0018\u00010¶\u00012\b\u0010È\u0001\u001a\u00030É\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010Ê\u0001J$\u0010Ì\u0001\u001a\t\u0012\u0005\u0012\u00030¶\u000102\b\u0010È\u0001\u001a\u00030É\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010Ê\u0001Jm\u0010Í\u0001\u001a\u00030Î\u00012\b\u0010Ï\u0001\u001a\u00030Î\u00012\b\u0010Ð\u0001\u001a\u00030Ñ\u00012C\u0010Ò\u0001\u001a>\u0012\u0017\u0012\u00150Î\u0001¢\u0006\u000f\bÔ\u0001\u0012\n\bÕ\u0001\u0012\u0005\b\b(Ö\u0001\u0012\u0017\u0012\u00150×\u0001¢\u0006\u000f\bÔ\u0001\u0012\n\bÕ\u0001\u0012\u0005\b\b(Ø\u0001\u0012\u0005\u0012\u00030Î\u0001\u0018\u00010Ó\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010Ù\u0001J#\u0010Ú\u0001\u001a\b\u0012\u0004\u0012\u00020\u000302\b\u0010Ø\u0001\u001a\u00030×\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010Û\u0001J-\u0010Ú\u0001\u001a\b\u0012\u0004\u0012\u00020\u000302\b\u0010Ø\u0001\u001a\u00030×\u00012\b\u0010Ü\u0001\u001a\u00030Ý\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010Þ\u0001J\"\u0010ß\u0001\u001a\b\u0012\u0004\u0012\u00020\u001802\u0007\u0010\u0001\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J#\u0010à\u0001\u001a\b\u0012\u0004\u0012\u00020\u000302\b\u0010Ø\u0001\u001a\u00030×\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010Û\u0001Ji\u0010á\u0001\u001a\b\u0012\u0004\u0012\u00020\u001802\u0007\u0010\u0001\u001a\u00020\u00182E\b\u0002\u0010Ò\u0001\u001a>\u0012\u0017\u0012\u00150Î\u0001¢\u0006\u000f\bÔ\u0001\u0012\n\bÕ\u0001\u0012\u0005\b\b(Ö\u0001\u0012\u0017\u0012\u00150×\u0001¢\u0006\u000f\bÔ\u0001\u0012\n\bÕ\u0001\u0012\u0005\b\b(Ø\u0001\u0012\u0005\u0012\u00030Î\u0001\u0018\u00010Ó\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010â\u0001J-\u0010ã\u0001\u001a\t\u0012\u0005\u0012\u00030\u000102\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010ä\u0001\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0003\u0010å\u0001J\u0012\u0010æ\u0001\u001a\u00030\u00012\u0006\u0010?\u001a\u00020\u000eH\u0002J\u0018\u0010ç\u0001\u001a\u00030\u00012\f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00160UH\u0002J\u001c\u0010è\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00032\t\u0010\u0001\u001a\u0004\u0018\u00010#J\u0012\u0010é\u0001\u001a\u00030\u00012\u0006\u0010z\u001a\u00020%H\u0002J\u0018\u0010ê\u0001\u001a\u00030\u00012\f\u0010|\u001a\b\u0012\u0004\u0012\u00020(0UH\u0002J\u001a\u0010ë\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\"\u0010ì\u0001\u001a\b\u0012\u0004\u0012\u00020\u001802\u0007\u0010\u0001\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\u000f\u0010í\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180UH\u0002J\u0018\u0010î\u0001\u001a\b\u0012\u0004\u0012\u00020\u000e02\t\u0010®\u0001\u001a\u0004\u0018\u00010\u0003J\n\u0010ï\u0001\u001a\u00030¶\u0001H\u0016J\u0014\u0010ð\u0001\u001a\u00030\u00012\b\u0010ñ\u0001\u001a\u00030¶\u0001H\u0002J\u001a\u0010ò\u0001\u001a\u00030\u00012\u000e\u0010ó\u0001\u001a\t\u0012\u0004\u0012\u00020\u00180ô\u0001H\u0002J\u0012\u0010õ\u0001\u001a\u00030\u00012\b\u0010ö\u0001\u001a\u00030¶\u0001J\u0014\u0010÷\u0001\u001a\u00030\u00012\b\u0010ø\u0001\u001a\u00030¶\u0001H\u0002J\u0014\u0010ù\u0001\u001a\u00030\u00012\b\u0010ö\u0001\u001a\u00030¶\u0001H\u0002J\u0014\u0010ú\u0001\u001a\u00030\u00012\b\u0010ø\u0001\u001a\u00030¶\u0001H\u0002J\u0012\u0010û\u0001\u001a\u00030\u00012\u0006\u0010a\u001a\u00020\u001fH\u0002J\u0018\u0010ü\u0001\u001a\u00030\u00012\f\u0010c\u001a\b\u0012\u0004\u0012\u00020\u001f0UH\u0002J|\u0010ý\u0001\u001a\t\u0012\u0005\u0012\u00030Î\u000102\b\u0010Ï\u0001\u001a\u00030Î\u00012E\b\u0002\u0010Ò\u0001\u001a>\u0012\u0017\u0012\u00150Î\u0001¢\u0006\u000f\bÔ\u0001\u0012\n\bÕ\u0001\u0012\u0005\b\b(Ö\u0001\u0012\u0017\u0012\u00150×\u0001¢\u0006\u000f\bÔ\u0001\u0012\n\bÕ\u0001\u0012\u0005\b\b(Ø\u0001\u0012\u0005\u0012\u00030Î\u0001\u0018\u00010Ó\u00012\f\b\u0002\u0010þ\u0001\u001a\u0005\u0018\u00010Ý\u0001H@ø\u0001\u0000¢\u0006\u0006\bÿ\u0001\u0010\u0002J\u0013\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0018H\u0002J\u0011\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0002\u001a\u00020\u0016J\u0016\u0010\u0002\u001a\u00030\u00012\f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00160UJ\u0019\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0018H\u0000¢\u0006\u0003\b\u0002J\u0018\u0010\u0002\u001a\u00030\u00012\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00180UH\u0002J\u0018\u0010\u0002\u001a\u00030\u00012\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00180UH\u0002J\u0013\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020(H\u0002J\u0013\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020(H\u0002J\u0013\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020(H\u0002J\u001f\u0010\u0002\u001a\u00030\u00012\t\b\u0002\u0010·\u0001\u001a\u00020%H@ø\u0001\u0000¢\u0006\u0003\u0010¸\u0001R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0004¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00160\u00150\u000bX\u0004¢\u0006\u0002\n\u0000R \u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u00150\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0004¢\u0006\u0002\n\u0000R \u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u00150\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u000bX\u0004¢\u0006\u0002\n\u0000R \u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001f0\u00150\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u000bX\u0004¢\u0006\u0002\n\u0000R \u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020#0\u00150\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u000bX\u0004¢\u0006\u0002\n\u0000R \u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020(0\u00150\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0,X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00100R\u0014\u00102\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00100R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u001a\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020:09X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000e0,X\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010.R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000e0,X\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010.R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000e0,X\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010.R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0010\u0010G\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010J\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010B0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020\u000e0,X\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010.R\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020\u000e0,X\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010.R\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\u000e0,X\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010.R\u000e\u0010R\u001a\u00020SX\u0004¢\u0006\u0002\n\u0000R \u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160U0,X\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010.R\u000e\u0010W\u001a\u00020XX\u0004¢\u0006\u0002\n\u0000R \u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180U0,X\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010.R\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020\u001b0,X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010.R\u001a\u0010]\u001a\b\u0012\u0004\u0012\u00020\u000e0,X\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010.R \u0010_\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180U0,X\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010.R\u001c\u0010a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0,X\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010.R \u0010c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0U0,X\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010.R\u001a\u0010e\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u001c\u0010j\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180,X\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010.R\u001a\u0010l\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180U0\u001aX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010m\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020o0nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010p\u001a\b\u0012\u0004\u0012\u00020q0,X\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010.R\u001d\u0010s\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180U0t¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR\u001c\u0010w\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0,X\u0004¢\u0006\b\n\u0000\u001a\u0004\bx\u0010.R\u0010\u0010y\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010z\u001a\b\u0012\u0004\u0012\u00020%0,X\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010.R \u0010|\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0U0,X\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010.\u0002\u0004\n\u0002\b\u0019¨\u0006\u0002"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/controller/ChannelControllerImpl;", "Lio/getstream/chat/android/livedata/controller/ChannelController;", "channelType", "", "channelId", "client", "Lio/getstream/chat/android/client/ChatClient;", "domainImpl", "Lio/getstream/chat/android/livedata/ChatDomainImpl;", "(Ljava/lang/String;Ljava/lang/String;Lio/getstream/chat/android/client/ChatClient;Lio/getstream/chat/android/livedata/ChatDomainImpl;)V", "_channelData", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lio/getstream/chat/android/livedata/ChannelData;", "_endOfNewerMessages", "", "_endOfOlderMessages", "_hidden", "_loading", "_loadingNewerMessages", "_loadingOlderMessages", "_members", "", "Lio/getstream/chat/android/client/models/Member;", "_messages", "Lio/getstream/chat/android/client/models/Message;", "_messagesState", "Lkotlinx/coroutines/flow/StateFlow;", "Lio/getstream/chat/android/livedata/controller/ChannelController$MessagesState;", "_muted", "_oldMessages", "_read", "Lio/getstream/chat/android/client/models/ChannelUserRead;", "_reads", "_repliedMessage", "_typing", "Lio/getstream/chat/android/client/events/ChatEvent;", "_unreadCount", "", "_watcherCount", "_watchers", "Lio/getstream/chat/android/client/models/User;", "channelClient", "Lio/getstream/chat/android/client/channel/ChannelClient;", "channelData", "Landroidx/lifecycle/LiveData;", "getChannelData", "()Landroidx/lifecycle/LiveData;", "getChannelId", "()Ljava/lang/String;", "getChannelType", "cid", "getCid", "getClient", "()Lio/getstream/chat/android/client/ChatClient;", "getDomainImpl", "()Lio/getstream/chat/android/livedata/ChatDomainImpl;", "editJobs", "", "Lkotlinx/coroutines/Job;", "endOfNewerMessages", "getEndOfNewerMessages", "endOfOlderMessages", "getEndOfOlderMessages", "hidden", "getHidden", "hideMessagesBefore", "Ljava/util/Date;", "getHideMessagesBefore$stream_chat_android_offline_release", "()Ljava/util/Date;", "setHideMessagesBefore$stream_chat_android_offline_release", "(Ljava/util/Date;)V", "keystrokeParentMessageId", "lastKeystrokeAt", "lastMarkReadEvent", "lastMessageAt", "lastStartTypingEvent", "loading", "getLoading", "loadingNewerMessages", "getLoadingNewerMessages", "loadingOlderMessages", "getLoadingOlderMessages", "logger", "Lio/getstream/chat/android/client/logger/TaggedLogger;", "members", "", "getMembers", "messageHelper", "Lio/getstream/chat/android/livedata/controller/helper/MessageHelper;", "messages", "getMessages", "messagesState", "getMessagesState", "muted", "getMuted", "oldMessages", "getOldMessages", "read", "getRead", "reads", "getReads", "recoveryNeeded", "getRecoveryNeeded", "()Z", "setRecoveryNeeded", "(Z)V", "repliedMessage", "getRepliedMessage", "sortedVisibleMessages", "threadControllerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lio/getstream/chat/android/livedata/controller/ThreadControllerImpl;", "typing", "Lio/getstream/chat/android/client/models/TypingEvent;", "getTyping", "unfilteredMessages", "Lkotlinx/coroutines/flow/Flow;", "getUnfilteredMessages", "()Lkotlinx/coroutines/flow/Flow;", "unreadCount", "getUnreadCount", "uploadStatusMessage", "watcherCount", "getWatcherCount", "watchers", "getWatchers", "cancelMessage", "Lio/getstream/chat/android/client/utils/Result;", "message", "(Lio/getstream/chat/android/client/models/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clean", "", "delete", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMember", "userId", "deleteMessage", "deleteReaction", "reaction", "Lio/getstream/chat/android/client/models/Reaction;", "(Lio/getstream/chat/android/client/models/Reaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteWatcher", "user", "editMessage", "generateUploadId", "getConfig", "Lio/getstream/chat/android/client/models/Config;", "getLoadMoreBaseMessageId", "direction", "Lio/getstream/chat/android/client/api/models/Pagination;", "getMessage", "messageId", "getMessageType", "getThread", "threadId", "handleEvent", "event", "handleEvent$stream_chat_android_offline_release", "(Lio/getstream/chat/android/client/events/ChatEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleEvents", "events", "handleEvents$stream_chat_android_offline_release", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleSendAttachmentFail", "result", "(Lio/getstream/chat/android/client/models/Message;Lio/getstream/chat/android/client/utils/Result;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleSendAttachmentSuccess", "(Lio/getstream/chat/android/client/utils/Result;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hide", "clearHistory", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "incrementUnreadCountIfNecessary", "isHidden", "keystroke", "parentId", "leave", "loadMessageById", "newerMessagesOffset", "olderMessagesOffset", "loadMessageById$stream_chat_android_offline_release", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadNewerMessages", "Lio/getstream/chat/android/client/models/Channel;", "limit", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadOlderMessages", "loadOlderThreadMessages", "firstMessage", "loadOlderThreadMessages$stream_chat_android_offline_release", "markRead", "markRead$stream_chat_android_offline_release", "messagesTransformation", "parseMessages", "removeLocalMessage", "removeMessagesBefore", "date", "replyMessage", "replyMessage$stream_chat_android_offline_release", "runChannelQuery", "pagination", "Lio/getstream/chat/android/livedata/request/QueryChannelPaginationRequest;", "(Lio/getstream/chat/android/livedata/request/QueryChannelPaginationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runChannelQueryOffline", "runChannelQueryOnline", "sendAttachment", "Lio/getstream/chat/android/client/models/Attachment;", "attachment", "attachmentProgress", "Lio/getstream/chat/android/client/uploader/ProgressTracker;", "attachmentTransformer", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "at", "Ljava/io/File;", "file", "(Lio/getstream/chat/android/client/models/Attachment;Lio/getstream/chat/android/client/uploader/ProgressTracker;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendFile", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callback", "Lio/getstream/chat/android/client/utils/ProgressCallback;", "(Ljava/io/File;Lio/getstream/chat/android/client/utils/ProgressCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendGiphy", "sendImage", "sendMessage", "(Lio/getstream/chat/android/client/models/Message;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendReaction", "enforceUnique", "(Lio/getstream/chat/android/client/models/Reaction;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setHidden", "setMembers", "setTyping", "setWatcherCount", "setWatchers", "show", "shuffleGiphy", "sortedMessages", "stopTyping", "toChannel", "updateChannelData", "channel", "updateLastMessageAtByNewMessages", "newMessages", "", "updateLiveDataFromChannel", "c", "updateLiveDataFromLocalChannel", "localChannel", "updateOldMessagesFromChannel", "updateOldMessagesFromLocalChannel", "updateRead", "updateReads", "uploadAttachment", "progressCallback", "uploadAttachment$stream_chat_android_offline_release", "(Lio/getstream/chat/android/client/models/Attachment;Lkotlin/jvm/functions/Function2;Lio/getstream/chat/android/client/utils/ProgressCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsertEventMessage", "upsertMember", "member", "upsertMembers", "upsertMessage", "upsertMessage$stream_chat_android_offline_release", "upsertMessages", "upsertOldMessages", "upsertUser", "upsertUserPresence", "upsertWatcher", "watch", "Companion", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.controller.ChannelControllerImpl */
/* compiled from: ChannelControllerImpl.kt */
public final class ChannelControllerImpl implements ChannelController {
    private static final Pattern COMMAND_PATTERN = Pattern.compile("^/[a-z]*$");
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TYPE_FILE = "file";
    private static final String TYPE_IMAGE = "image";
    private static final String TYPE_VIDEO = "video";
    private final MutableStateFlow<ChannelData> _channelData;
    private final MutableStateFlow<Boolean> _endOfNewerMessages;
    private final MutableStateFlow<Boolean> _endOfOlderMessages;
    private final MutableStateFlow<Boolean> _hidden;
    private final MutableStateFlow<Boolean> _loading;
    private final MutableStateFlow<Boolean> _loadingNewerMessages;
    private final MutableStateFlow<Boolean> _loadingOlderMessages;
    private final MutableStateFlow<Map<String, Member>> _members;
    private final MutableStateFlow<Map<String, Message>> _messages;
    private final StateFlow<ChannelController.MessagesState> _messagesState;
    private final MutableStateFlow<Boolean> _muted;
    private final MutableStateFlow<Map<String, Message>> _oldMessages;
    private final MutableStateFlow<ChannelUserRead> _read;
    private final MutableStateFlow<Map<String, ChannelUserRead>> _reads;
    private final MutableStateFlow<Message> _repliedMessage;
    private final MutableStateFlow<Map<String, ChatEvent>> _typing;
    private final MutableStateFlow<Integer> _unreadCount;
    private final MutableStateFlow<Integer> _watcherCount;
    private final MutableStateFlow<Map<String, User>> _watchers;
    /* access modifiers changed from: private */
    public final ChannelClient channelClient;
    private final LiveData<ChannelData> channelData;
    private final String channelId;
    private final String channelType;
    private final String cid;
    private final ChatClient client;
    private final ChatDomainImpl domainImpl;
    private final Map<String, Job> editJobs = new LinkedHashMap();
    private final LiveData<Boolean> endOfNewerMessages;
    private final LiveData<Boolean> endOfOlderMessages;
    private final LiveData<Boolean> hidden;
    private Date hideMessagesBefore;
    private String keystrokeParentMessageId;
    private Date lastKeystrokeAt;
    private Date lastMarkReadEvent;
    private final MutableStateFlow<Date> lastMessageAt;
    private Date lastStartTypingEvent;
    private final LiveData<Boolean> loading;
    private final LiveData<Boolean> loadingNewerMessages;
    private final LiveData<Boolean> loadingOlderMessages;
    private final TaggedLogger logger;
    private final LiveData<List<Member>> members;
    private final MessageHelper messageHelper;
    private final LiveData<List<Message>> messages;
    private final LiveData<ChannelController.MessagesState> messagesState;
    private final LiveData<Boolean> muted;
    private final LiveData<List<Message>> oldMessages;
    private final LiveData<ChannelUserRead> read;
    private final LiveData<List<ChannelUserRead>> reads;
    private boolean recoveryNeeded;
    private final LiveData<Message> repliedMessage;
    private final StateFlow<List<Message>> sortedVisibleMessages;
    private final ConcurrentHashMap<String, ThreadControllerImpl> threadControllerMap;
    private final LiveData<TypingEvent> typing;
    private final Flow<List<Message>> unfilteredMessages;
    private final LiveData<Integer> unreadCount;
    private Message uploadStatusMessage;
    private final LiveData<Integer> watcherCount;
    private final LiveData<List<User>> watchers;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.livedata.controller.ChannelControllerImpl$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Pagination.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Pagination.GREATER_THAN_OR_EQUAL.ordinal()] = 1;
            iArr[Pagination.GREATER_THAN.ordinal()] = 2;
            iArr[Pagination.LESS_THAN.ordinal()] = 3;
            iArr[Pagination.LESS_THAN_OR_EQUAL.ordinal()] = 4;
            int[] iArr2 = new int[Pagination.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[Pagination.GREATER_THAN.ordinal()] = 1;
            iArr2[Pagination.GREATER_THAN_OR_EQUAL.ordinal()] = 2;
            iArr2[Pagination.LESS_THAN.ordinal()] = 3;
            iArr2[Pagination.LESS_THAN_OR_EQUAL.ordinal()] = 4;
        }
    }

    public ChannelControllerImpl(String str, String str2, ChatClient chatClient, ChatDomainImpl chatDomainImpl) {
        String str3 = str;
        String str4 = str2;
        ChatClient chatClient2 = chatClient;
        ChatDomainImpl chatDomainImpl2 = chatDomainImpl;
        Intrinsics.checkNotNullParameter(str3, "channelType");
        Intrinsics.checkNotNullParameter(str4, "channelId");
        Intrinsics.checkNotNullParameter(chatClient2, "client");
        Intrinsics.checkNotNullParameter(chatDomainImpl2, "domainImpl");
        this.channelType = str3;
        this.channelId = str4;
        this.client = chatClient2;
        this.domainImpl = chatDomainImpl2;
        MutableStateFlow<Map<String, Message>> MutableStateFlow = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());
        this._messages = MutableStateFlow;
        MutableStateFlow<Integer> MutableStateFlow2 = StateFlowKt.MutableStateFlow(0);
        this._watcherCount = MutableStateFlow2;
        MutableStateFlow<Map<String, ChatEvent>> MutableStateFlow3 = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());
        this._typing = MutableStateFlow3;
        MutableStateFlow<Map<String, ChannelUserRead>> MutableStateFlow4 = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());
        this._reads = MutableStateFlow4;
        MutableStateFlow<ChannelUserRead> MutableStateFlow5 = StateFlowKt.MutableStateFlow(null);
        this._read = MutableStateFlow5;
        MutableStateFlow<Boolean> MutableStateFlow6 = StateFlowKt.MutableStateFlow(false);
        this._endOfNewerMessages = MutableStateFlow6;
        MutableStateFlow<Boolean> MutableStateFlow7 = StateFlowKt.MutableStateFlow(false);
        this._endOfOlderMessages = MutableStateFlow7;
        MutableStateFlow<Boolean> MutableStateFlow8 = StateFlowKt.MutableStateFlow(false);
        this._loading = MutableStateFlow8;
        MutableStateFlow<Boolean> MutableStateFlow9 = StateFlowKt.MutableStateFlow(false);
        this._hidden = MutableStateFlow9;
        MutableStateFlow<Boolean> MutableStateFlow10 = StateFlowKt.MutableStateFlow(false);
        this._muted = MutableStateFlow10;
        MutableStateFlow<Map<String, User>> MutableStateFlow11 = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());
        this._watchers = MutableStateFlow11;
        MutableStateFlow<Map<String, Member>> MutableStateFlow12 = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());
        this._members = MutableStateFlow12;
        MutableStateFlow<Boolean> MutableStateFlow13 = StateFlowKt.MutableStateFlow(false);
        this._loadingOlderMessages = MutableStateFlow13;
        MutableStateFlow<Boolean> MutableStateFlow14 = StateFlowKt.MutableStateFlow(false);
        this._loadingNewerMessages = MutableStateFlow14;
        MutableStateFlow<Boolean> mutableStateFlow = MutableStateFlow6;
        MutableStateFlow<ChannelData> MutableStateFlow15 = StateFlowKt.MutableStateFlow(null);
        this._channelData = MutableStateFlow15;
        MutableStateFlow<Boolean> mutableStateFlow2 = MutableStateFlow7;
        MutableStateFlow<Map<String, Message>> MutableStateFlow16 = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());
        this._oldMessages = MutableStateFlow16;
        MutableStateFlow<Boolean> mutableStateFlow3 = MutableStateFlow14;
        this.lastMessageAt = StateFlowKt.MutableStateFlow(null);
        MutableStateFlow<Message> MutableStateFlow17 = StateFlowKt.MutableStateFlow(null);
        this._repliedMessage = MutableStateFlow17;
        MutableStateFlow<Integer> MutableStateFlow18 = StateFlowKt.MutableStateFlow(0);
        this._unreadCount = MutableStateFlow18;
        this.repliedMessage = FlowLiveDataConversions.asLiveData$default((Flow) MutableStateFlow17, (CoroutineContext) null, 0, 3, (Object) null);
        this.unfilteredMessages = new ChannelControllerImpl$$special$$inlined$map$1(MutableStateFlow);
        StateFlow<List<Message>> stateIn = FlowKt.stateIn(messagesTransformation(MutableStateFlow), chatDomainImpl.getScope$stream_chat_android_offline_release(), SharingStarted.Companion.getEagerly(), CollectionsKt.emptyList());
        this.sortedVisibleMessages = stateIn;
        this.messages = FlowLiveDataConversions.asLiveData$default((Flow) stateIn, (CoroutineContext) null, 0, 3, (Object) null);
        StateFlow<ChannelController.MessagesState> stateIn2 = FlowKt.stateIn(FlowKt.flowCombine(MutableStateFlow8, stateIn, new ChannelControllerImpl$_messagesState$1((Continuation) null)), chatDomainImpl.getScope$stream_chat_android_offline_release(), SharingStarted.Companion.getEagerly(), ChannelController.MessagesState.NoQueryActive.INSTANCE);
        this._messagesState = stateIn2;
        this.messagesState = FlowLiveDataConversions.asLiveData$default((Flow) stateIn2, (CoroutineContext) null, 0, 3, (Object) null);
        this.oldMessages = FlowLiveDataConversions.asLiveData$default((Flow) messagesTransformation(MutableStateFlow16), (CoroutineContext) null, 0, 3, (Object) null);
        this.watcherCount = FlowLiveDataConversions.asLiveData$default((Flow) MutableStateFlow2, (CoroutineContext) null, 0, 3, (Object) null);
        this.watchers = FlowLiveDataConversions.asLiveData$default((Flow) new ChannelControllerImpl$$special$$inlined$map$2(MutableStateFlow11), (CoroutineContext) null, 0, 3, (Object) null);
        this.typing = FlowLiveDataConversions.asLiveData$default((Flow) new ChannelControllerImpl$$special$$inlined$map$3(MutableStateFlow3, this), (CoroutineContext) null, 0, 3, (Object) null);
        this.reads = FlowLiveDataConversions.asLiveData$default((Flow) new ChannelControllerImpl$$special$$inlined$map$4(MutableStateFlow4), (CoroutineContext) null, 0, 3, (Object) null);
        this.read = FlowLiveDataConversions.asLiveData$default((Flow) MutableStateFlow5, (CoroutineContext) null, 0, 3, (Object) null);
        this.unreadCount = FlowLiveDataConversions.asLiveData$default((Flow) MutableStateFlow18, (CoroutineContext) null, 0, 3, (Object) null);
        this.members = FlowLiveDataConversions.asLiveData$default((Flow) new ChannelControllerImpl$$special$$inlined$map$5(MutableStateFlow12), (CoroutineContext) null, 0, 3, (Object) null);
        this.channelData = FlowLiveDataConversions.asLiveData$default(FlowKt.filterNotNull(MutableStateFlow15), (CoroutineContext) null, 0, 3, (Object) null);
        this.hidden = FlowLiveDataConversions.asLiveData$default((Flow) MutableStateFlow9, (CoroutineContext) null, 0, 3, (Object) null);
        this.muted = FlowLiveDataConversions.asLiveData$default((Flow) MutableStateFlow10, (CoroutineContext) null, 0, 3, (Object) null);
        this.loading = FlowLiveDataConversions.asLiveData$default((Flow) MutableStateFlow8, (CoroutineContext) null, 0, 3, (Object) null);
        this.loadingOlderMessages = FlowLiveDataConversions.asLiveData$default((Flow) MutableStateFlow13, (CoroutineContext) null, 0, 3, (Object) null);
        this.loadingNewerMessages = FlowLiveDataConversions.asLiveData$default((Flow) mutableStateFlow3, (CoroutineContext) null, 0, 3, (Object) null);
        this.endOfOlderMessages = FlowLiveDataConversions.asLiveData$default((Flow) mutableStateFlow2, (CoroutineContext) null, 0, 3, (Object) null);
        this.endOfNewerMessages = FlowLiveDataConversions.asLiveData$default((Flow) mutableStateFlow, (CoroutineContext) null, 0, 3, (Object) null);
        this.channelClient = chatClient.channel(getChannelType(), getChannelId());
        String format = String.format("%s:%s", Arrays.copyOf(new Object[]{getChannelType(), getChannelId()}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(this, *args)");
        this.cid = format;
        this.logger = ChatLogger.Companion.get("ChatDomain ChannelController");
        this.threadControllerMap = new ConcurrentHashMap<>();
        this.messageHelper = new MessageHelper((AttachmentHelper) null, 1, (DefaultConstructorMarker) null);
    }

    public String getChannelType() {
        return this.channelType;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public final ChatClient getClient() {
        return this.client;
    }

    public final ChatDomainImpl getDomainImpl() {
        return this.domainImpl;
    }

    public LiveData<Message> getRepliedMessage() {
        return this.repliedMessage;
    }

    public final Date getHideMessagesBefore$stream_chat_android_offline_release() {
        return this.hideMessagesBefore;
    }

    public final void setHideMessagesBefore$stream_chat_android_offline_release(Date date) {
        this.hideMessagesBefore = date;
    }

    public final Flow<List<Message>> getUnfilteredMessages() {
        return this.unfilteredMessages;
    }

    public LiveData<List<Message>> getMessages() {
        return this.messages;
    }

    public LiveData<ChannelController.MessagesState> getMessagesState() {
        return this.messagesState;
    }

    public LiveData<List<Message>> getOldMessages() {
        return this.oldMessages;
    }

    private final Flow<List<Message>> messagesTransformation(MutableStateFlow<Map<String, Message>> mutableStateFlow) {
        return new ChannelControllerImpl$messagesTransformation$$inlined$map$1(mutableStateFlow, this);
    }

    public LiveData<Integer> getWatcherCount() {
        return this.watcherCount;
    }

    public LiveData<List<User>> getWatchers() {
        return this.watchers;
    }

    public LiveData<TypingEvent> getTyping() {
        return this.typing;
    }

    public LiveData<List<ChannelUserRead>> getReads() {
        return this.reads;
    }

    public LiveData<ChannelUserRead> getRead() {
        return this.read;
    }

    public LiveData<Integer> getUnreadCount() {
        return this.unreadCount;
    }

    public LiveData<List<Member>> getMembers() {
        return this.members;
    }

    public LiveData<ChannelData> getChannelData() {
        return this.channelData;
    }

    public LiveData<Boolean> getHidden() {
        return this.hidden;
    }

    public LiveData<Boolean> getMuted() {
        return this.muted;
    }

    public LiveData<Boolean> getLoading() {
        return this.loading;
    }

    public LiveData<Boolean> getLoadingOlderMessages() {
        return this.loadingOlderMessages;
    }

    public LiveData<Boolean> getLoadingNewerMessages() {
        return this.loadingNewerMessages;
    }

    public LiveData<Boolean> getEndOfOlderMessages() {
        return this.endOfOlderMessages;
    }

    public LiveData<Boolean> getEndOfNewerMessages() {
        return this.endOfNewerMessages;
    }

    public boolean getRecoveryNeeded() {
        return this.recoveryNeeded;
    }

    public void setRecoveryNeeded(boolean z) {
        this.recoveryNeeded = z;
    }

    public String getCid() {
        return this.cid;
    }

    public final ThreadControllerImpl getThread(String str) {
        Intrinsics.checkNotNullParameter(str, "threadId");
        ConcurrentMap concurrentMap = this.threadControllerMap;
        Object obj = concurrentMap.get(str);
        ThreadControllerImpl threadControllerImpl = obj;
        if (obj == null) {
            ThreadControllerImpl threadControllerImpl2 = new ThreadControllerImpl(str, this, this.client, this.domainImpl);
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.domainImpl.getScope$stream_chat_android_offline_release(), (CoroutineContext) null, (CoroutineStart) null, new ChannelControllerImpl$getThread$1$1$1(threadControllerImpl2, (Continuation) null), 3, (Object) null);
            Object putIfAbsent = concurrentMap.putIfAbsent(str, threadControllerImpl2);
            threadControllerImpl = threadControllerImpl2;
            if (putIfAbsent != null) {
                threadControllerImpl = putIfAbsent;
            }
        }
        Intrinsics.checkNotNullExpressionValue(threadControllerImpl, "threadControllerMap.getO…OlderMessages() } }\n    }");
        return (ThreadControllerImpl) threadControllerImpl;
    }

    private final Config getConfig() {
        return this.domainImpl.getChannelConfig(getChannelType());
    }

    public final Result<Boolean> keystroke(String str) {
        Call<ChatEvent> call;
        if (!getConfig().isTypingEvents()) {
            return new Result<>(false);
        }
        Date date = new Date();
        this.lastKeystrokeAt = date;
        if (this.lastStartTypingEvent != null) {
            Intrinsics.checkNotNull(date);
            long time = date.getTime();
            Date date2 = this.lastStartTypingEvent;
            Intrinsics.checkNotNull(date2);
            if (time - date2.getTime() <= ((long) 3000)) {
                return new Result<>(false);
            }
        }
        this.lastStartTypingEvent = this.lastKeystrokeAt;
        ChannelClient channel = this.client.channel(getChannelType(), getChannelId());
        if (str != null) {
            call = channel.keystroke(str);
        } else {
            call = channel.keystroke();
        }
        Result<ChatEvent> execute = call.execute();
        if (!execute.isSuccess()) {
            return new Result<>(execute.error());
        }
        this.keystrokeParentMessageId = str;
        return new Result<>(Boolean.valueOf(execute.isSuccess()));
    }

    public final Result<Boolean> stopTyping(String str) {
        Call<ChatEvent> call;
        if (!getConfig().isTypingEvents()) {
            return new Result<>(false);
        }
        if (this.lastStartTypingEvent == null) {
            return new Result<>(false);
        }
        Date date = null;
        this.lastStartTypingEvent = date;
        this.lastKeystrokeAt = date;
        ChannelClient channel = this.client.channel(getChannelType(), getChannelId());
        if (str != null) {
            call = channel.stopTyping(str);
        } else {
            call = channel.stopTyping();
        }
        Result<ChatEvent> execute = call.execute();
        if (!execute.isSuccess()) {
            return new Result<>(execute.error());
        }
        this.keystrokeParentMessageId = null;
        return new Result<>(Boolean.valueOf(execute.isSuccess()));
    }

    public final boolean markRead$stream_chat_android_offline_release() {
        if (!getConfig().isReadEvents()) {
            return false;
        }
        List<Message> sortedMessages = sortedMessages();
        if (sortedMessages.isEmpty()) {
            this.logger.logI("No messages; nothing to mark read.");
            return false;
        }
        Message message = (Message) CollectionsKt.last(sortedMessages);
        Date createdAt = message.getCreatedAt();
        if (createdAt == null) {
            createdAt = message.getCreatedLocallyAt();
        }
        Date date = this.lastMarkReadEvent;
        boolean z = true;
        if (date != null && (createdAt == null || !createdAt.after(date))) {
            z = false;
        }
        if (!z) {
            TaggedLogger taggedLogger = this.logger;
            taggedLogger.logI("Last message date [" + createdAt + "] is not after last read event [" + this.lastMarkReadEvent + "]; no need to update.");
            return false;
        }
        this.lastMarkReadEvent = createdAt;
        updateRead(new ChannelUserRead(this.domainImpl.getCurrentUser(), this.lastMarkReadEvent, 0, 4, (DefaultConstructorMarker) null));
        return z;
    }

    private final List<Message> sortedMessages() {
        CollectionsKt.emptyList();
        Collection arrayList = new ArrayList();
        for (Object next : CollectionsKt.sortedWith(this._messages.getValue().values(), new ChannelControllerImpl$$special$$inlined$sortedBy$2())) {
            Message message = (Message) next;
            Date date = this.hideMessagesBefore;
            if (date == null || MessageExtensionsKt.wasCreatedAfter(message, date)) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    private final void removeMessagesBefore(Date date) {
        this._messages.setValue(new LinkedHashMap());
        Collection arrayList = new ArrayList();
        for (Object next : this._messages.getValue().values()) {
            if (MessageExtensionsKt.wasCreatedAfter((Message) next, date)) {
                arrayList.add(next);
            }
        }
        upsertMessages((List) arrayList);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object hide(boolean r8, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<kotlin.Unit>> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$hide$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$hide$1 r0 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$hide$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$hide$1 r0 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$hide$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x004e
            if (r2 == r5) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            goto L_0x0035
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            io.getstream.chat.android.client.utils.Result r8 = (p015io.getstream.chat.android.client.utils.Result) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00a5
        L_0x003d:
            java.lang.Object r8 = r0.L$2
            java.util.Date r8 = (java.util.Date) r8
            java.lang.Object r2 = r0.L$1
            io.getstream.chat.android.client.utils.Result r2 = (p015io.getstream.chat.android.client.utils.Result) r2
            java.lang.Object r3 = r0.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r3 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r3
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = r2
            goto L_0x008a
        L_0x004e:
            kotlin.ResultKt.throwOnFailure(r9)
            r7.setHidden(r5)
            io.getstream.chat.android.client.channel.ChannelClient r9 = r7.channelClient
            io.getstream.chat.android.client.call.Call r9 = r9.hide(r8)
            io.getstream.chat.android.client.utils.Result r9 = r9.execute()
            boolean r2 = r9.isSuccess()
            if (r2 == 0) goto L_0x00bc
            if (r8 == 0) goto L_0x00a7
            java.util.Date r8 = new java.util.Date
            r8.<init>()
            r7.hideMessagesBefore = r8
            r7.removeMessagesBefore(r8)
            io.getstream.chat.android.livedata.ChatDomainImpl r2 = r7.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r2 = r2.getRepos$stream_chat_android_offline_release()
            java.lang.String r3 = r7.getCid()
            r0.L$0 = r7
            r0.L$1 = r9
            r0.L$2 = r8
            r0.label = r5
            java.lang.Object r2 = r2.deleteChannelMessagesBefore(r3, r8, r0)
            if (r2 != r1) goto L_0x0089
            return r1
        L_0x0089:
            r3 = r7
        L_0x008a:
            io.getstream.chat.android.livedata.ChatDomainImpl r2 = r3.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r2 = r2.getRepos$stream_chat_android_offline_release()
            java.lang.String r3 = r3.getCid()
            r0.L$0 = r9
            r6 = 0
            r0.L$1 = r6
            r0.L$2 = r6
            r0.label = r4
            java.lang.Object r8 = r2.setHiddenForChannel(r3, r5, r8, r0)
            if (r8 != r1) goto L_0x00a4
            return r1
        L_0x00a4:
            r8 = r9
        L_0x00a5:
            r9 = r8
            goto L_0x00bc
        L_0x00a7:
            io.getstream.chat.android.livedata.ChatDomainImpl r8 = r7.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r8 = r8.getRepos$stream_chat_android_offline_release()
            java.lang.String r2 = r7.getCid()
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r8 = r8.setHiddenForChannel(r2, r5, r0)
            if (r8 != r1) goto L_0x00a4
            return r1
        L_0x00bc:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl.hide(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object show(kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<kotlin.Unit>> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$show$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$show$1 r0 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$show$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$show$1 r0 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$show$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r0 = r0.L$0
            io.getstream.chat.android.client.utils.Result r0 = (p015io.getstream.chat.android.client.utils.Result) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0063
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = 0
            r6.setHidden(r7)
            io.getstream.chat.android.client.channel.ChannelClient r2 = r6.channelClient
            io.getstream.chat.android.client.call.Call r2 = r2.show()
            io.getstream.chat.android.client.utils.Result r2 = r2.execute()
            boolean r4 = r2.isSuccess()
            if (r4 == 0) goto L_0x0064
            io.getstream.chat.android.livedata.ChatDomainImpl r4 = r6.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r4 = r4.getRepos$stream_chat_android_offline_release()
            java.lang.String r5 = r6.getCid()
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r7 = r4.setHiddenForChannel(r5, r7, r0)
            if (r7 != r1) goto L_0x0062
            return r1
        L_0x0062:
            r0 = r2
        L_0x0063:
            r2 = r0
        L_0x0064:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl.show(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object leave(kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<kotlin.Unit>> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$leave$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$leave$1 r0 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$leave$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$leave$1 r0 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$leave$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r2 = r0.L$1
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r4 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r4
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0068
        L_0x0032:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r7)
            io.getstream.chat.android.client.channel.ChannelClient r7 = r6.channelClient
            java.lang.String[] r2 = new java.lang.String[r3]
            r4 = 0
            io.getstream.chat.android.livedata.ChatDomainImpl r5 = r6.domainImpl
            io.getstream.chat.android.client.models.User r5 = r5.getCurrentUser()
            java.lang.String r5 = r5.getId()
            r2[r4] = r5
            io.getstream.chat.android.client.call.Call r7 = r7.removeMembers(r2)
            io.getstream.chat.android.client.utils.Result r7 = r7.execute()
            boolean r2 = r7.isSuccess()
            if (r2 == 0) goto L_0x008d
            io.getstream.chat.android.livedata.ChatDomainImpl r7 = r6.domainImpl
            java.util.List r7 = r7.getActiveQueries()
            java.util.Iterator r7 = r7.iterator()
            r4 = r6
            r2 = r7
        L_0x0068:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x0085
            java.lang.Object r7 = r2.next()
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl r7 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl) r7
            java.lang.String r5 = r4.getCid()
            r0.L$0 = r4
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r7 = r7.removeChannel$stream_chat_android_offline_release(r5, r0)
            if (r7 != r1) goto L_0x0068
            return r1
        L_0x0085:
            io.getstream.chat.android.client.utils.Result r7 = new io.getstream.chat.android.client.utils.Result
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r7.<init>(r0)
            goto L_0x0097
        L_0x008d:
            io.getstream.chat.android.client.utils.Result r0 = new io.getstream.chat.android.client.utils.Result
            io.getstream.chat.android.client.errors.ChatError r7 = r7.error()
            r0.<init>((p015io.getstream.chat.android.client.errors.ChatError) r7)
            r7 = r0
        L_0x0097:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl.leave(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0099 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object delete(kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<kotlin.Unit>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$delete$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$delete$1 r0 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$delete$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$delete$1 r0 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$delete$1
            r0.<init>(r7, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x009a
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0035:
            java.lang.Object r2 = r0.L$1
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r5 = r0.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r5 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0060
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r8)
            io.getstream.chat.android.client.channel.ChannelClient r8 = r7.channelClient
            io.getstream.chat.android.client.call.Call r8 = r8.delete()
            io.getstream.chat.android.client.utils.Result r8 = r8.execute()
            boolean r2 = r8.isSuccess()
            if (r2 == 0) goto L_0x00a2
            io.getstream.chat.android.livedata.ChatDomainImpl r8 = r7.domainImpl
            java.util.List r8 = r8.getActiveQueries()
            java.util.Iterator r8 = r8.iterator()
            r5 = r7
            r2 = r8
        L_0x0060:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x007d
            java.lang.Object r8 = r2.next()
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl r8 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl) r8
            java.lang.String r6 = r5.getCid()
            r0.L$0 = r5
            r0.L$1 = r2
            r0.label = r4
            java.lang.Object r8 = r8.removeChannel$stream_chat_android_offline_release(r6, r0)
            if (r8 != r1) goto L_0x0060
            return r1
        L_0x007d:
            java.util.Date r8 = new java.util.Date
            r8.<init>()
            io.getstream.chat.android.livedata.ChatDomainImpl r2 = r5.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r2 = r2.getRepos$stream_chat_android_offline_release()
            java.lang.String r4 = r5.getCid()
            r5 = 0
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r8 = r2.deleteChannelMessagesBefore(r4, r8, r0)
            if (r8 != r1) goto L_0x009a
            return r1
        L_0x009a:
            io.getstream.chat.android.client.utils.Result r8 = new io.getstream.chat.android.client.utils.Result
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r8.<init>(r0)
            goto L_0x00ac
        L_0x00a2:
            io.getstream.chat.android.client.utils.Result r0 = new io.getstream.chat.android.client.utils.Result
            io.getstream.chat.android.client.errors.ChatError r8 = r8.error()
            r0.<init>((p015io.getstream.chat.android.client.errors.ChatError) r8)
            r8 = r0
        L_0x00ac:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl.delete(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object watch$default(ChannelControllerImpl channelControllerImpl, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 30;
        }
        return channelControllerImpl.watch(i, continuation);
    }

    public final Object watch(int i, Continuation<? super Unit> continuation) {
        if (this._loading.getValue().booleanValue()) {
            this.logger.logI("Another request to watch this channel is in progress. Ignoring this request.");
            return Unit.INSTANCE;
        }
        Object runChannelQuery = runChannelQuery(new QueryChannelPaginationRequest(i), continuation);
        if (runChannelQuery == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return runChannelQuery;
        }
        return Unit.INSTANCE;
    }

    private final String getLoadMoreBaseMessageId(Pagination pagination) {
        List<Message> sortedMessages = sortedMessages();
        if (!(!sortedMessages.isEmpty())) {
            return null;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[pagination.ordinal()];
        if (i == 1 || i == 2) {
            return ((Message) CollectionsKt.last(sortedMessages)).getId();
        }
        if (i == 3 || i == 4) {
            return ((Message) CollectionsKt.first(sortedMessages)).getId();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ Object loadOlderMessages$default(ChannelControllerImpl channelControllerImpl, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 30;
        }
        return channelControllerImpl.loadOlderMessages(i, continuation);
    }

    public final Object loadOlderMessages(int i, Continuation<? super Result<Channel>> continuation) {
        QueryChannelPaginationRequest queryChannelPaginationRequest = new QueryChannelPaginationRequest(i);
        String loadMoreBaseMessageId = getLoadMoreBaseMessageId(Pagination.LESS_THAN);
        if (loadMoreBaseMessageId != null) {
            queryChannelPaginationRequest.setMessageFilterDirection(Pagination.LESS_THAN);
            queryChannelPaginationRequest.setMessageFilterValue(loadMoreBaseMessageId);
        }
        Unit unit = Unit.INSTANCE;
        return runChannelQuery(queryChannelPaginationRequest, continuation);
    }

    public static /* synthetic */ Object loadNewerMessages$default(ChannelControllerImpl channelControllerImpl, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 30;
        }
        return channelControllerImpl.loadNewerMessages(i, continuation);
    }

    public final Object loadNewerMessages(int i, Continuation<? super Result<Channel>> continuation) {
        QueryChannelPaginationRequest queryChannelPaginationRequest = new QueryChannelPaginationRequest(i);
        String loadMoreBaseMessageId = getLoadMoreBaseMessageId(Pagination.GREATER_THAN);
        if (loadMoreBaseMessageId != null) {
            queryChannelPaginationRequest.setMessageFilterDirection(Pagination.GREATER_THAN);
            queryChannelPaginationRequest.setMessageFilterValue(loadMoreBaseMessageId);
        }
        Unit unit = Unit.INSTANCE;
        return runChannelQuery(queryChannelPaginationRequest, continuation);
    }

    public final Object loadOlderMessages(String str, int i, Continuation<? super Result<Channel>> continuation) {
        QueryChannelPaginationRequest queryChannelPaginationRequest = new QueryChannelPaginationRequest(i);
        queryChannelPaginationRequest.setMessageFilterDirection(Pagination.LESS_THAN);
        queryChannelPaginationRequest.setMessageFilterValue(str);
        Unit unit = Unit.INSTANCE;
        return runChannelQuery(queryChannelPaginationRequest, continuation);
    }

    public final Object loadNewerMessages(String str, int i, Continuation<? super Result<Channel>> continuation) {
        QueryChannelPaginationRequest queryChannelPaginationRequest = new QueryChannelPaginationRequest(i);
        queryChannelPaginationRequest.setMessageFilterDirection(Pagination.GREATER_THAN);
        queryChannelPaginationRequest.setMessageFilterValue(str);
        Unit unit = Unit.INSTANCE;
        return runChannelQuery(queryChannelPaginationRequest, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0123 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object runChannelQuery(p015io.getstream.chat.android.livedata.request.QueryChannelPaginationRequest r19, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<p015io.getstream.chat.android.client.models.Channel>> r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r2 instanceof p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$runChannelQuery$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$runChannelQuery$1 r3 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$runChannelQuery$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$runChannelQuery$1 r3 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$runChannelQuery$1
            r3.<init>(r0, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 0
            r7 = 2
            r8 = 1
            r9 = 0
            if (r5 == 0) goto L_0x0064
            if (r5 == r8) goto L_0x004a
            if (r5 != r7) goto L_0x0042
            java.lang.Object r1 = r3.L$2
            io.getstream.chat.android.client.models.Channel r1 = (p015io.getstream.chat.android.client.models.Channel) r1
            java.lang.Object r4 = r3.L$1
            kotlinx.coroutines.flow.MutableStateFlow r4 = (kotlinx.coroutines.flow.MutableStateFlow) r4
            java.lang.Object r3 = r3.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r3 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r3
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0126
        L_0x0042:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x004a:
            java.lang.Object r1 = r3.L$3
            kotlinx.coroutines.Deferred r1 = (kotlinx.coroutines.Deferred) r1
            java.lang.Object r5 = r3.L$2
            kotlinx.coroutines.flow.MutableStateFlow r5 = (kotlinx.coroutines.flow.MutableStateFlow) r5
            java.lang.Object r10 = r3.L$1
            io.getstream.chat.android.livedata.request.QueryChannelPaginationRequest r10 = (p015io.getstream.chat.android.livedata.request.QueryChannelPaginationRequest) r10
            java.lang.Object r11 = r3.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r11 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r11
            kotlin.ResultKt.throwOnFailure(r2)
            r17 = r10
            r10 = r1
            r1 = r17
            goto L_0x00f6
        L_0x0064:
            kotlin.ResultKt.throwOnFailure(r2)
            io.getstream.chat.android.client.api.models.Pagination r2 = r19.getMessageFilterDirection()
            if (r2 != 0) goto L_0x0070
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r2 = r0._loading
            goto L_0x008e
        L_0x0070:
            int[] r5 = p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl.WhenMappings.$EnumSwitchMapping$1
            int r2 = r2.ordinal()
            r2 = r5[r2]
            if (r2 == r8) goto L_0x008c
            if (r2 == r7) goto L_0x008c
            r5 = 3
            if (r2 == r5) goto L_0x0089
            r5 = 4
            if (r2 != r5) goto L_0x0083
            goto L_0x0089
        L_0x0083:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        L_0x0089:
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r2 = r0._loadingOlderMessages
            goto L_0x008e
        L_0x008c:
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r2 = r0._loadingNewerMessages
        L_0x008e:
            java.lang.Object r5 = r2.getValue()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x00ac
            io.getstream.chat.android.client.logger.TaggedLogger r1 = r0.logger
            java.lang.String r2 = "Another request to load messages is in progress. Ignoring this request."
            r1.logI(r2)
            io.getstream.chat.android.client.utils.Result r1 = new io.getstream.chat.android.client.utils.Result
            io.getstream.chat.android.client.errors.ChatError r3 = new io.getstream.chat.android.client.errors.ChatError
            r3.<init>(r2, r9, r7, r9)
            r1.<init>((p015io.getstream.chat.android.client.errors.ChatError) r3)
            return r1
        L_0x00ac:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
            r2.setValue(r5)
            io.getstream.chat.android.livedata.ChatDomainImpl r5 = r0.domainImpl
            kotlinx.coroutines.CoroutineScope r10 = r5.getScope$stream_chat_android_offline_release()
            r11 = 0
            r12 = 0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$runChannelQuery$queryOfflineJob$1 r5 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$runChannelQuery$queryOfflineJob$1
            r5.<init>(r0, r1, r9)
            r13 = r5
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r14 = 3
            r15 = 0
            kotlinx.coroutines.Deferred r5 = kotlinx.coroutines.BuildersKt__Builders_commonKt.async$default(r10, r11, r12, r13, r14, r15)
            io.getstream.chat.android.livedata.ChatDomainImpl r10 = r0.domainImpl
            kotlinx.coroutines.CoroutineScope r11 = r10.getScope$stream_chat_android_offline_release()
            r13 = 0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$runChannelQuery$queryOnlineJob$1 r10 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$runChannelQuery$queryOnlineJob$1
            r10.<init>(r0, r1, r9)
            r14 = r10
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r15 = 3
            r16 = 0
            kotlinx.coroutines.Deferred r10 = kotlinx.coroutines.BuildersKt__Builders_commonKt.async$default(r11, r12, r13, r14, r15, r16)
            r3.L$0 = r0
            r3.L$1 = r1
            r3.L$2 = r2
            r3.L$3 = r10
            r3.label = r8
            java.lang.Object r5 = r5.await(r3)
            if (r5 != r4) goto L_0x00f0
            return r4
        L_0x00f0:
            r11 = r0
            r17 = r5
            r5 = r2
            r2 = r17
        L_0x00f6:
            io.getstream.chat.android.client.models.Channel r2 = (p015io.getstream.chat.android.client.models.Channel) r2
            if (r2 == 0) goto L_0x0112
            io.getstream.chat.android.client.api.models.Pagination r1 = r1.getMessageFilterDirection()
            io.getstream.chat.android.client.api.models.Pagination r12 = p015io.getstream.chat.android.client.api.models.Pagination.LESS_THAN
            if (r1 != r12) goto L_0x0106
            r11.updateOldMessagesFromLocalChannel(r2)
            goto L_0x0109
        L_0x0106:
            r11.updateLiveDataFromLocalChannel(r2)
        L_0x0109:
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            r5.setValue(r1)
            r1 = r2
            goto L_0x0113
        L_0x0112:
            r1 = r9
        L_0x0113:
            r3.L$0 = r11
            r3.L$1 = r5
            r3.L$2 = r1
            r3.L$3 = r9
            r3.label = r7
            java.lang.Object r2 = r10.await(r3)
            if (r2 != r4) goto L_0x0124
            return r4
        L_0x0124:
            r4 = r5
            r3 = r11
        L_0x0126:
            io.getstream.chat.android.client.utils.Result r2 = (p015io.getstream.chat.android.client.utils.Result) r2
            boolean r5 = r2.isSuccess()
            if (r5 == 0) goto L_0x0138
            java.lang.Object r1 = r2.data()
            io.getstream.chat.android.client.models.Channel r1 = (p015io.getstream.chat.android.client.models.Channel) r1
            r3.updateLiveDataFromChannel(r1)
            goto L_0x0199
        L_0x0138:
            io.getstream.chat.android.client.errors.ChatError r5 = r2.error()
            boolean r5 = p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.isPermanent(r5)
            if (r5 == 0) goto L_0x0169
            io.getstream.chat.android.client.logger.TaggedLogger r5 = r3.logger
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Permanent failure calling channel.watch for channel "
            r7.append(r8)
            java.lang.String r3 = r3.getCid()
            r7.append(r3)
            java.lang.String r3 = ", with error "
            r7.append(r3)
            io.getstream.chat.android.client.errors.ChatError r3 = r2.error()
            r7.append(r3)
            java.lang.String r3 = r7.toString()
            r5.logW(r3)
            goto L_0x0192
        L_0x0169:
            io.getstream.chat.android.client.logger.TaggedLogger r5 = r3.logger
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = "Temporary failure calling channel.watch for channel "
            r7.append(r9)
            java.lang.String r9 = r3.getCid()
            r7.append(r9)
            java.lang.String r9 = ". Marking the channel as needing recovery. Error was "
            r7.append(r9)
            io.getstream.chat.android.client.errors.ChatError r9 = r2.error()
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            r5.logW(r7)
            r3.setRecoveryNeeded(r8)
        L_0x0192:
            if (r1 == 0) goto L_0x0199
            io.getstream.chat.android.client.utils.Result r2 = new io.getstream.chat.android.client.utils.Result
            r2.<init>(r1)
        L_0x0199:
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            r4.setValue(r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl.runChannelQuery(io.getstream.chat.android.livedata.request.QueryChannelPaginationRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object runChannelQueryOffline(p015io.getstream.chat.android.livedata.request.QueryChannelPaginationRequest r5, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.models.Channel> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$runChannelQueryOffline$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$runChannelQueryOffline$1 r0 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$runChannelQueryOffline$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$runChannelQueryOffline$1 r0 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$runChannelQueryOffline$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r5 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004b
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            io.getstream.chat.android.livedata.ChatDomainImpl r6 = r4.domainImpl
            java.lang.String r2 = r4.getCid()
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.selectAndEnrichChannel((java.lang.String) r2, (p015io.getstream.chat.android.livedata.request.QueryChannelPaginationRequest) r5, (kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.models.Channel>) r0)
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            r5 = r4
        L_0x004b:
            io.getstream.chat.android.client.models.Channel r6 = (p015io.getstream.chat.android.client.models.Channel) r6
            if (r6 == 0) goto L_0x007f
            io.getstream.chat.android.client.logger.TaggedLogger r5 = r5.logger
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Loaded channel "
            r0.append(r1)
            java.lang.String r1 = r6.getCid()
            r0.append(r1)
            java.lang.String r1 = " from offline storage with "
            r0.append(r1)
            java.util.List r1 = r6.getMessages()
            int r1 = r1.size()
            r0.append(r1)
            java.lang.String r1 = " messages"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.logI(r0)
            goto L_0x0080
        L_0x007f:
            r6 = 0
        L_0x0080:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl.runChannelQueryOffline(io.getstream.chat.android.livedata.request.QueryChannelPaginationRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00cd A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object runChannelQueryOnline(p015io.getstream.chat.android.livedata.request.QueryChannelPaginationRequest r9, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<p015io.getstream.chat.android.client.models.Channel>> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$runChannelQueryOnline$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$runChannelQueryOnline$1 r0 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$runChannelQueryOnline$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$runChannelQueryOnline$1 r0 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$runChannelQueryOnline$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004a
            if (r2 == r4) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r9 = r0.L$0
            io.getstream.chat.android.client.utils.Result r9 = (p015io.getstream.chat.android.client.utils.Result) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00cf
        L_0x0032:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003a:
            java.lang.Object r9 = r0.L$2
            io.getstream.chat.android.client.models.Channel r9 = (p015io.getstream.chat.android.client.models.Channel) r9
            java.lang.Object r2 = r0.L$1
            io.getstream.chat.android.client.utils.Result r2 = (p015io.getstream.chat.android.client.utils.Result) r2
            java.lang.Object r4 = r0.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r4 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r4
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00bc
        L_0x004a:
            kotlin.ResultKt.throwOnFailure(r10)
            io.getstream.chat.android.livedata.ChatDomainImpl r10 = r8.domainImpl
            boolean r10 = r10.getUserPresence()
            io.getstream.chat.android.client.api.models.WatchChannelRequest r10 = r9.toQueryChannelRequest(r10)
            io.getstream.chat.android.client.channel.ChannelClient r2 = r8.channelClient
            io.getstream.chat.android.client.call.Call r2 = r2.watch((p015io.getstream.chat.android.client.api.models.WatchChannelRequest) r10)
            io.getstream.chat.android.client.utils.Result r2 = r2.execute()
            boolean r5 = r2.isSuccess()
            if (r5 == 0) goto L_0x00d1
            r5 = 0
            r8.setRecoveryNeeded(r5)
            java.lang.Object r5 = r2.data()
            io.getstream.chat.android.client.models.Channel r5 = (p015io.getstream.chat.android.client.models.Channel) r5
            int r9 = r9.getMessageLimit()
            java.util.List r6 = r5.getMessages()
            int r6 = r6.size()
            if (r9 <= r6) goto L_0x0098
            boolean r9 = r10.isFilteringNewerMessages()
            if (r9 == 0) goto L_0x008f
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r9 = r8._endOfNewerMessages
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            r9.setValue(r10)
            goto L_0x0098
        L_0x008f:
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r9 = r8._endOfOlderMessages
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            r9.setValue(r10)
        L_0x0098:
            io.getstream.chat.android.livedata.ChatDomainImpl r9 = r8.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r9 = r9.getRepos$stream_chat_android_offline_release()
            io.getstream.chat.android.livedata.model.ChannelConfig r10 = new io.getstream.chat.android.livedata.model.ChannelConfig
            java.lang.String r6 = r5.getType()
            io.getstream.chat.android.client.models.Config r7 = r5.getConfig()
            r10.<init>(r6, r7)
            r0.L$0 = r8
            r0.L$1 = r2
            r0.L$2 = r5
            r0.label = r4
            java.lang.Object r9 = r9.insertChannelConfig(r10, r0)
            if (r9 != r1) goto L_0x00ba
            return r1
        L_0x00ba:
            r4 = r8
            r9 = r5
        L_0x00bc:
            io.getstream.chat.android.livedata.ChatDomainImpl r10 = r4.domainImpl
            r0.L$0 = r2
            r4 = 0
            r0.L$1 = r4
            r0.L$2 = r4
            r0.label = r3
            java.lang.Object r9 = r10.storeStateForChannel(r9, r0)
            if (r9 != r1) goto L_0x00ce
            return r1
        L_0x00ce:
            r9 = r2
        L_0x00cf:
            r2 = r9
            goto L_0x00dd
        L_0x00d1:
            r8.setRecoveryNeeded(r4)
            io.getstream.chat.android.livedata.ChatDomainImpl r9 = r8.domainImpl
            io.getstream.chat.android.client.errors.ChatError r10 = r2.error()
            r9.addError(r10)
        L_0x00dd:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl.runChannelQueryOnline(io.getstream.chat.android.livedata.request.QueryChannelPaginationRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: java.util.List} */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x03ac, code lost:
        r8.uploadStatusMessage = null;
        r8.logger.logI("Chat is offline, postponing send message with id " + r6.getId() + " and text " + r6.getText());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:?, code lost:
        return new p015io.getstream.chat.android.client.utils.Result(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
        return (p015io.getstream.chat.android.client.utils.Result) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:?, code lost:
        return (p015io.getstream.chat.android.client.utils.Result) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0249, code lost:
        r1 = r8.domainImpl.getRepos$stream_chat_android_offline_release();
        r10 = r6.getCid();
        r2.L$0 = r8;
        r2.L$1 = r7;
        r2.L$2 = r6;
        r2.L$3 = r5;
        r2.Z$0 = r4;
        r2.I$0 = r3;
        r2.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0266, code lost:
        if (r1.updateLastMessageForChannel$stream_chat_android_offline_release(r10, r6, r2) != r9) goto L_0x0269;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0268, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0269, code lost:
        if (r4 == false) goto L_0x03ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x026b, code lost:
        if (r3 == 0) goto L_0x0334;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x026d, code lost:
        r8.logger.logI("Uploading attachments for message with id " + r6.getId() + " and text " + r6.getText());
        r1 = r6.getAttachments();
        r4 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, 10));
        r3 = r6;
        r11 = 0;
        r6 = r1.iterator();
        r1 = r5;
        r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x02b2, code lost:
        if (r6.hasNext() == false) goto L_0x0301;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x02b4, code lost:
        r10 = r6.next();
        r14 = r11 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x02ba, code lost:
        if (r11 >= 0) goto L_0x02bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x02bc, code lost:
        kotlin.collections.CollectionsKt.throwIndexOverflow();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x02bf, code lost:
        r2.L$0 = r8;
        r2.L$1 = r7;
        r2.L$2 = r3;
        r2.L$3 = r1;
        r2.L$4 = r4;
        r2.L$5 = r6;
        r2.L$6 = r5;
        r2.L$7 = r4;
        r2.I$0 = r14;
        r2.label = 3;
        r10 = r8.sendAttachment((p015io.getstream.chat.android.client.models.Attachment) r10, (p015io.getstream.chat.android.client.uploader.ProgressTracker) r1.get(kotlin.coroutines.jvm.internal.Boxing.boxInt(r11).intValue()), r7, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x02ea, code lost:
        if (r10 != r9) goto L_0x02ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x02ec, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x02ed, code lost:
        r11 = r7;
        r7 = r4;
        r53 = r8;
        r8 = r1;
        r1 = r10;
        r10 = r14;
        r14 = r53;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x02f6, code lost:
        r4.add((p015io.getstream.chat.android.client.models.Attachment) r1);
        r4 = r7;
        r1 = r8;
        r7 = r11;
        r8 = r14;
        r11 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0301, code lost:
        r5.setAttachments(kotlin.collections.CollectionsKt.toMutableList((java.util.List) r4));
        r1 = r8.uploadStatusMessage;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x030e, code lost:
        if (r1 == null) goto L_0x032e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0310, code lost:
        r2.L$0 = r8;
        r2.L$1 = r3;
        r2.L$2 = null;
        r2.L$3 = null;
        r2.L$4 = null;
        r2.L$5 = null;
        r2.L$6 = null;
        r2.L$7 = null;
        r2.label = 4;
        r1 = r8.cancelMessage(r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0327, code lost:
        if (r1 != r9) goto L_0x032a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0329, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x032a, code lost:
        r4 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x032b, code lost:
        r1 = (p015io.getstream.chat.android.client.utils.Result) r1;
        r8 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x032e, code lost:
        r8.uploadStatusMessage = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0334, code lost:
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0335, code lost:
        r4 = r8;
        r3.setType(com.getstream.sdk.chat.model.ModelType.message_regular);
        r2.L$0 = r4;
        r2.L$1 = r3;
        r2.L$2 = null;
        r2.L$3 = null;
        r2.L$4 = null;
        r2.L$5 = null;
        r2.L$6 = null;
        r2.L$7 = null;
        r2.label = 5;
        r1 = r4.domainImpl.runAndRetry(new p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendMessage$result$1(r4, r3), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x035b, code lost:
        if (r1 != r9) goto L_0x035e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x035d, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x035e, code lost:
        r1 = (p015io.getstream.chat.android.client.utils.Result) r1;
        r4.logger.logI("Starting to send message with id " + r3.getId() + " and text " + r3.getText());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0388, code lost:
        if (r1.isSuccess() == false) goto L_0x039b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x038a, code lost:
        r2.L$0 = null;
        r2.L$1 = null;
        r2.label = 6;
        r1 = r4.handleSendAttachmentSuccess(r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0395, code lost:
        if (r1 != r9) goto L_0x0398;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0397, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x039b, code lost:
        r2.L$0 = null;
        r2.L$1 = null;
        r2.label = 7;
        r1 = r4.handleSendAttachmentFail(r3, r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x03a6, code lost:
        if (r1 != r9) goto L_0x03a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x03a8, code lost:
        return r9;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object sendMessage(p015io.getstream.chat.android.client.models.Message r55, kotlin.jvm.functions.Function2<? super p015io.getstream.chat.android.client.models.Attachment, ? super java.io.File, p015io.getstream.chat.android.client.models.Attachment> r56, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<p015io.getstream.chat.android.client.models.Message>> r57) {
        /*
            r54 = this;
            r0 = r54
            r1 = r57
            boolean r2 = r1 instanceof p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendMessage$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendMessage$1 r2 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendMessage$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendMessage$1 r2 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendMessage$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.label
            r10 = 10
            java.lang.String r12 = " and text "
            r13 = 0
            switch(r3) {
                case 0: goto L_0x00b7;
                case 1: goto L_0x009e;
                case 2: goto L_0x0085;
                case 3: goto L_0x0059;
                case 4: goto L_0x004c;
                case 5: goto L_0x003f;
                case 6: goto L_0x003a;
                case 7: goto L_0x0035;
                default: goto L_0x002d;
            }
        L_0x002d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x03a9
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0398
        L_0x003f:
            java.lang.Object r3 = r2.L$1
            io.getstream.chat.android.client.models.Message r3 = (p015io.getstream.chat.android.client.models.Message) r3
            java.lang.Object r4 = r2.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r4 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r4
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x035e
        L_0x004c:
            java.lang.Object r3 = r2.L$1
            io.getstream.chat.android.client.models.Message r3 = (p015io.getstream.chat.android.client.models.Message) r3
            java.lang.Object r4 = r2.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r4 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r4
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x032b
        L_0x0059:
            int r3 = r2.I$0
            java.lang.Object r4 = r2.L$7
            java.util.Collection r4 = (java.util.Collection) r4
            java.lang.Object r5 = r2.L$6
            io.getstream.chat.android.client.models.Message r5 = (p015io.getstream.chat.android.client.models.Message) r5
            java.lang.Object r6 = r2.L$5
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r7 = r2.L$4
            java.util.Collection r7 = (java.util.Collection) r7
            java.lang.Object r8 = r2.L$3
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r10 = r2.L$2
            io.getstream.chat.android.client.models.Message r10 = (p015io.getstream.chat.android.client.models.Message) r10
            java.lang.Object r11 = r2.L$1
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            java.lang.Object r14 = r2.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r14 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r14
            kotlin.ResultKt.throwOnFailure(r1)
            r53 = r10
            r10 = r3
            r3 = r53
            goto L_0x02f6
        L_0x0085:
            int r3 = r2.I$0
            boolean r4 = r2.Z$0
            java.lang.Object r5 = r2.L$3
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r6 = r2.L$2
            io.getstream.chat.android.client.models.Message r6 = (p015io.getstream.chat.android.client.models.Message) r6
            java.lang.Object r7 = r2.L$1
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r8 = r2.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r8 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r8
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0269
        L_0x009e:
            int r3 = r2.I$0
            boolean r4 = r2.Z$0
            java.lang.Object r5 = r2.L$3
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r6 = r2.L$2
            io.getstream.chat.android.client.models.Message r6 = (p015io.getstream.chat.android.client.models.Message) r6
            java.lang.Object r7 = r2.L$1
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r8 = r2.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r8 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r8
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0249
        L_0x00b7:
            kotlin.ResultKt.throwOnFailure(r1)
            io.getstream.chat.android.livedata.ChatDomainImpl r1 = r0.domainImpl
            boolean r1 = r1.isOnline()
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = -1
            r51 = 7
            r52 = 0
            r14 = r55
            io.getstream.chat.android.client.models.Message r14 = p015io.getstream.chat.android.client.models.Message.copy$default(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52)
            java.util.List r3 = r14.getAttachments()
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r4 = 1
            r15 = r3 ^ 1
            java.lang.String r3 = r14.getId()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 != 0) goto L_0x012c
            r3 = 1
            goto L_0x012d
        L_0x012c:
            r3 = 0
        L_0x012d:
            if (r3 == 0) goto L_0x0138
            io.getstream.chat.android.livedata.ChatDomainImpl r3 = r0.domainImpl
            java.lang.String r3 = r3.generateMessageId()
            r14.setId(r3)
        L_0x0138:
            java.lang.String r3 = r14.getCid()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0146
            r3 = 1
            goto L_0x0147
        L_0x0146:
            r3 = 0
        L_0x0147:
            if (r3 == 0) goto L_0x0150
            java.lang.String r3 = r54.getCid()
            p015io.getstream.chat.android.client.extensions.MessageExtensionsKt.enrichWithCid(r14, r3)
        L_0x0150:
            io.getstream.chat.android.livedata.ChatDomainImpl r3 = r0.domainImpl
            io.getstream.chat.android.client.models.User r3 = r3.getCurrentUser()
            r14.setUser(r3)
            java.util.List r3 = r14.getAttachments()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x0163:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x017e
            java.lang.Object r5 = r3.next()
            io.getstream.chat.android.client.models.Attachment r5 = (p015io.getstream.chat.android.client.models.Attachment) r5
            java.lang.String r6 = r54.generateUploadId()
            p015io.getstream.chat.android.client.extensions.AttachmentExtensionsKt.setUploadId(r5, r6)
            io.getstream.chat.android.client.models.Attachment$UploadState$InProgress r6 = p015io.getstream.chat.android.client.models.Attachment.UploadState.InProgress.INSTANCE
            io.getstream.chat.android.client.models.Attachment$UploadState r6 = (p015io.getstream.chat.android.client.models.Attachment.UploadState) r6
            r5.setUploadState(r6)
            goto L_0x0163
        L_0x017e:
            java.lang.String r3 = r54.getMessageType(r55)
            r14.setType(r3)
            java.util.Date r3 = r14.getCreatedAt()
            if (r3 == 0) goto L_0x018c
            goto L_0x0190
        L_0x018c:
            java.util.Date r3 = r14.getCreatedLocallyAt()
        L_0x0190:
            if (r3 == 0) goto L_0x0193
            goto L_0x0198
        L_0x0193:
            java.util.Date r3 = new java.util.Date
            r3.<init>()
        L_0x0198:
            r14.setCreatedLocallyAt(r3)
            io.getstream.chat.android.client.utils.SyncStatus r3 = p015io.getstream.chat.android.client.utils.SyncStatus.IN_PROGRESS
            r14.setSyncStatus(r3)
            if (r1 != 0) goto L_0x01a7
            io.getstream.chat.android.client.utils.SyncStatus r3 = p015io.getstream.chat.android.client.utils.SyncStatus.SYNC_NEEDED
            r14.setSyncStatus(r3)
        L_0x01a7:
            java.util.List r3 = r14.getAttachments()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r5 = new java.util.ArrayList
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r10)
            r5.<init>(r6)
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r3 = r3.iterator()
        L_0x01bc:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x01f7
            java.lang.Object r6 = r3.next()
            io.getstream.chat.android.client.models.Attachment r6 = (p015io.getstream.chat.android.client.models.Attachment) r6
            io.getstream.chat.android.client.uploader.ProgressTrackerFactory r7 = p015io.getstream.chat.android.client.uploader.ProgressTrackerFactory.INSTANCE
            java.lang.String r8 = p015io.getstream.chat.android.client.extensions.AttachmentExtensionsKt.getUploadId(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            io.getstream.chat.android.client.uploader.ProgressTracker r7 = r7.getOrCreate(r8)
            java.io.File r6 = r6.getUpload()
            if (r6 == 0) goto L_0x01ea
            long r16 = r6.length()
            java.lang.Long r6 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r16)
            if (r6 == 0) goto L_0x01ea
            long r16 = r6.longValue()
            goto L_0x01ec
        L_0x01ea:
            r16 = 0
        L_0x01ec:
            r10 = r16
            r7.setMaxValue(r10)
            r5.add(r7)
            r10 = 10
            goto L_0x01bc
        L_0x01f7:
            r10 = r5
            java.util.List r10 = (java.util.List) r10
            if (r15 == 0) goto L_0x01fe
            r0.uploadStatusMessage = r14
        L_0x01fe:
            r0.upsertMessage$stream_chat_android_offline_release(r14)
            io.getstream.chat.android.livedata.ChatDomainImpl r3 = r0.domainImpl
            java.util.List r3 = r3.getActiveQueries()
            java.util.Iterator r3 = r3.iterator()
        L_0x020b:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x021f
            java.lang.Object r5 = r3.next()
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl r5 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl) r5
            java.lang.String r6 = r54.getCid()
            r5.refreshChannel(r6)
            goto L_0x020b
        L_0x021f:
            io.getstream.chat.android.livedata.ChatDomainImpl r3 = r0.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r3 = r3.getRepos$stream_chat_android_offline_release()
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepository r3 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository) r3
            r5 = 0
            r7 = 2
            r8 = 0
            r2.L$0 = r0
            r11 = r56
            r2.L$1 = r11
            r2.L$2 = r14
            r2.L$3 = r10
            r2.Z$0 = r1
            r2.I$0 = r15
            r2.label = r4
            r4 = r14
            r6 = r2
            java.lang.Object r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository.DefaultImpls.insertMessage$default(r3, r4, r5, r6, r7, r8)
            if (r3 != r9) goto L_0x0243
            return r9
        L_0x0243:
            r8 = r0
            r4 = r1
            r5 = r10
            r7 = r11
            r6 = r14
            r3 = r15
        L_0x0249:
            io.getstream.chat.android.livedata.ChatDomainImpl r1 = r8.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r1 = r1.getRepos$stream_chat_android_offline_release()
            java.lang.String r10 = r6.getCid()
            r2.L$0 = r8
            r2.L$1 = r7
            r2.L$2 = r6
            r2.L$3 = r5
            r2.Z$0 = r4
            r2.I$0 = r3
            r11 = 2
            r2.label = r11
            java.lang.Object r1 = r1.updateLastMessageForChannel$stream_chat_android_offline_release(r10, r6, r2)
            if (r1 != r9) goto L_0x0269
            return r9
        L_0x0269:
            if (r4 == 0) goto L_0x03ac
            if (r3 == 0) goto L_0x0334
            io.getstream.chat.android.client.logger.TaggedLogger r1 = r8.logger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Uploading attachments for message with id "
            r3.append(r4)
            java.lang.String r4 = r6.getId()
            r3.append(r4)
            r3.append(r12)
            java.lang.String r4 = r6.getText()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.logI(r3)
            java.util.List r1 = r6.getAttachments()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r4)
            r3.<init>(r4)
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r1 = r1.iterator()
            r4 = r3
            r3 = r6
            r11 = 0
            r6 = r1
            r1 = r5
            r5 = r3
        L_0x02ae:
            boolean r10 = r6.hasNext()
            if (r10 == 0) goto L_0x0301
            java.lang.Object r10 = r6.next()
            int r14 = r11 + 1
            if (r11 >= 0) goto L_0x02bf
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x02bf:
            java.lang.Integer r11 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r11)
            io.getstream.chat.android.client.models.Attachment r10 = (p015io.getstream.chat.android.client.models.Attachment) r10
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            java.lang.Object r11 = r1.get(r11)
            io.getstream.chat.android.client.uploader.ProgressTracker r11 = (p015io.getstream.chat.android.client.uploader.ProgressTracker) r11
            r2.L$0 = r8
            r2.L$1 = r7
            r2.L$2 = r3
            r2.L$3 = r1
            r2.L$4 = r4
            r2.L$5 = r6
            r2.L$6 = r5
            r2.L$7 = r4
            r2.I$0 = r14
            r15 = 3
            r2.label = r15
            java.lang.Object r10 = r8.sendAttachment(r10, r11, r7, r2)
            if (r10 != r9) goto L_0x02ed
            return r9
        L_0x02ed:
            r11 = r7
            r7 = r4
            r53 = r8
            r8 = r1
            r1 = r10
            r10 = r14
            r14 = r53
        L_0x02f6:
            io.getstream.chat.android.client.models.Attachment r1 = (p015io.getstream.chat.android.client.models.Attachment) r1
            r4.add(r1)
            r4 = r7
            r1 = r8
            r7 = r11
            r8 = r14
            r11 = r10
            goto L_0x02ae
        L_0x0301:
            java.util.List r4 = (java.util.List) r4
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.List r1 = kotlin.collections.CollectionsKt.toMutableList(r4)
            r5.setAttachments(r1)
            io.getstream.chat.android.client.models.Message r1 = r8.uploadStatusMessage
            if (r1 == 0) goto L_0x032e
            r2.L$0 = r8
            r2.L$1 = r3
            r2.L$2 = r13
            r2.L$3 = r13
            r2.L$4 = r13
            r2.L$5 = r13
            r2.L$6 = r13
            r2.L$7 = r13
            r4 = 4
            r2.label = r4
            java.lang.Object r1 = r8.cancelMessage(r1, r2)
            if (r1 != r9) goto L_0x032a
            return r9
        L_0x032a:
            r4 = r8
        L_0x032b:
            io.getstream.chat.android.client.utils.Result r1 = (p015io.getstream.chat.android.client.utils.Result) r1
            r8 = r4
        L_0x032e:
            r1 = r13
            io.getstream.chat.android.client.models.Message r1 = (p015io.getstream.chat.android.client.models.Message) r1
            r8.uploadStatusMessage = r1
            goto L_0x0335
        L_0x0334:
            r3 = r6
        L_0x0335:
            r4 = r8
            java.lang.String r1 = "regular"
            r3.setType(r1)
            io.getstream.chat.android.livedata.ChatDomainImpl r1 = r4.domainImpl
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendMessage$result$1 r5 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendMessage$result$1
            r5.<init>(r4, r3)
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r2.L$0 = r4
            r2.L$1 = r3
            r2.L$2 = r13
            r2.L$3 = r13
            r2.L$4 = r13
            r2.L$5 = r13
            r2.L$6 = r13
            r2.L$7 = r13
            r6 = 5
            r2.label = r6
            java.lang.Object r1 = r1.runAndRetry(r5, r2)
            if (r1 != r9) goto L_0x035e
            return r9
        L_0x035e:
            io.getstream.chat.android.client.utils.Result r1 = (p015io.getstream.chat.android.client.utils.Result) r1
            io.getstream.chat.android.client.logger.TaggedLogger r5 = r4.logger
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Starting to send message with id "
            r6.append(r7)
            java.lang.String r7 = r3.getId()
            r6.append(r7)
            r6.append(r12)
            java.lang.String r7 = r3.getText()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.logI(r6)
            boolean r5 = r1.isSuccess()
            if (r5 == 0) goto L_0x039b
            r2.L$0 = r13
            r2.L$1 = r13
            r3 = 6
            r2.label = r3
            java.lang.Object r1 = r4.handleSendAttachmentSuccess(r1, r2)
            if (r1 != r9) goto L_0x0398
            return r9
        L_0x0398:
            io.getstream.chat.android.client.utils.Result r1 = (p015io.getstream.chat.android.client.utils.Result) r1
            goto L_0x03d9
        L_0x039b:
            r2.L$0 = r13
            r2.L$1 = r13
            r5 = 7
            r2.label = r5
            java.lang.Object r1 = r4.handleSendAttachmentFail(r3, r1, r2)
            if (r1 != r9) goto L_0x03a9
            return r9
        L_0x03a9:
            io.getstream.chat.android.client.utils.Result r1 = (p015io.getstream.chat.android.client.utils.Result) r1
            goto L_0x03d9
        L_0x03ac:
            io.getstream.chat.android.client.models.Message r13 = (p015io.getstream.chat.android.client.models.Message) r13
            r8.uploadStatusMessage = r13
            io.getstream.chat.android.client.logger.TaggedLogger r1 = r8.logger
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Chat is offline, postponing send message with id "
            r2.append(r3)
            java.lang.String r3 = r6.getId()
            r2.append(r3)
            r2.append(r12)
            java.lang.String r3 = r6.getText()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.logI(r2)
            io.getstream.chat.android.client.utils.Result r1 = new io.getstream.chat.android.client.utils.Result
            r1.<init>(r6)
        L_0x03d9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl.sendMessage(io.getstream.chat.android.client.models.Message, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object sendMessage$default(ChannelControllerImpl channelControllerImpl, Message message, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        return channelControllerImpl.sendMessage(message, function2, continuation);
    }

    private final String generateUploadId() {
        return "upload_id_" + UUID.randomUUID();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object sendAttachment(p015io.getstream.chat.android.client.models.Attachment r5, p015io.getstream.chat.android.client.uploader.ProgressTracker r6, kotlin.jvm.functions.Function2<? super p015io.getstream.chat.android.client.models.Attachment, ? super java.io.File, p015io.getstream.chat.android.client.models.Attachment> r7, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.models.Attachment> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendAttachment$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendAttachment$1 r0 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendAttachment$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendAttachment$1 r0 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendAttachment$1
            r0.<init>(r4, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r5 = r0.L$1
            io.getstream.chat.android.client.models.Attachment r5 = (p015io.getstream.chat.android.client.models.Attachment) r5
            java.lang.Object r6 = r0.L$0
            io.getstream.chat.android.client.uploader.ProgressTracker r6 = (p015io.getstream.chat.android.client.uploader.ProgressTracker) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0054
        L_0x0032:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r8)
            java.io.File r8 = r5.getUpload()
            if (r8 == 0) goto L_0x007f
            io.getstream.chat.android.client.utils.ProgressCallback r8 = p015io.getstream.chat.android.client.uploader.ProgressTrackerKt.toProgressCallback(r6)
            r0.L$0 = r6
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r8 = r4.uploadAttachment$stream_chat_android_offline_release(r5, r7, r8, r0)
            if (r8 != r1) goto L_0x0054
            return r1
        L_0x0054:
            io.getstream.chat.android.client.utils.Result r8 = (p015io.getstream.chat.android.client.utils.Result) r8
            boolean r7 = r8.isSuccess()
            if (r7 == 0) goto L_0x006d
            java.lang.Object r5 = r8.data()
            io.getstream.chat.android.client.models.Attachment r5 = (p015io.getstream.chat.android.client.models.Attachment) r5
            r6.setComplete(r3)
            io.getstream.chat.android.client.models.Attachment$UploadState$Success r6 = p015io.getstream.chat.android.client.models.Attachment.UploadState.Success.INSTANCE
            io.getstream.chat.android.client.models.Attachment$UploadState r6 = (p015io.getstream.chat.android.client.models.Attachment.UploadState) r6
            r5.setUploadState(r6)
            goto L_0x007f
        L_0x006d:
            r7 = 0
            r6.setComplete(r7)
            io.getstream.chat.android.client.models.Attachment$UploadState$Failed r6 = new io.getstream.chat.android.client.models.Attachment$UploadState$Failed
            io.getstream.chat.android.client.errors.ChatError r7 = r8.error()
            r6.<init>(r7)
            io.getstream.chat.android.client.models.Attachment$UploadState r6 = (p015io.getstream.chat.android.client.models.Attachment.UploadState) r6
            r5.setUploadState(r6)
        L_0x007f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl.sendAttachment(io.getstream.chat.android.client.models.Attachment, io.getstream.chat.android.client.uploader.ProgressTracker, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object handleSendAttachmentSuccess(p015io.getstream.chat.android.client.utils.Result<p015io.getstream.chat.android.client.models.Message> r8, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<p015io.getstream.chat.android.client.models.Message>> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$handleSendAttachmentSuccess$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$handleSendAttachmentSuccess$1 r0 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$handleSendAttachmentSuccess$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$handleSendAttachmentSuccess$1 r0 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$handleSendAttachmentSuccess$1
            r0.<init>(r7, r9)
        L_0x0019:
            r4 = r0
            java.lang.Object r9 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L_0x003f
            if (r1 != r2) goto L_0x0037
            java.lang.Object r8 = r4.L$2
            io.getstream.chat.android.client.models.Message r8 = (p015io.getstream.chat.android.client.models.Message) r8
            java.lang.Object r8 = r4.L$1
            io.getstream.chat.android.client.models.Message r8 = (p015io.getstream.chat.android.client.models.Message) r8
            java.lang.Object r0 = r4.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r0 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0071
        L_0x0037:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r8 = r8.data()
            io.getstream.chat.android.client.models.Message r8 = (p015io.getstream.chat.android.client.models.Message) r8
            java.lang.String r9 = r7.getCid()
            p015io.getstream.chat.android.client.extensions.MessageExtensionsKt.enrichWithCid(r8, r9)
            io.getstream.chat.android.client.utils.SyncStatus r9 = p015io.getstream.chat.android.client.utils.SyncStatus.COMPLETED
            r8.setSyncStatus(r9)
            io.getstream.chat.android.livedata.ChatDomainImpl r9 = r7.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r9 = r9.getRepos$stream_chat_android_offline_release()
            r1 = r9
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepository r1 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository) r1
            r3 = 0
            r5 = 2
            r6 = 0
            r4.L$0 = r7
            r4.L$1 = r8
            r4.L$2 = r8
            r4.label = r2
            r2 = r8
            java.lang.Object r9 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository.DefaultImpls.insertMessage$default(r1, r2, r3, r4, r5, r6)
            if (r9 != r0) goto L_0x0070
            return r0
        L_0x0070:
            r0 = r7
        L_0x0071:
            r0.upsertMessage$stream_chat_android_offline_release(r8)
            io.getstream.chat.android.client.utils.Result r9 = new io.getstream.chat.android.client.utils.Result
            r9.<init>(r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl.handleSendAttachmentSuccess(io.getstream.chat.android.client.utils.Result, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: io.getstream.chat.android.client.utils.Result<io.getstream.chat.android.client.models.Message>} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object handleSendAttachmentFail(p015io.getstream.chat.android.client.models.Message r8, p015io.getstream.chat.android.client.utils.Result<p015io.getstream.chat.android.client.models.Message> r9, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<p015io.getstream.chat.android.client.models.Message>> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$handleSendAttachmentFail$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$handleSendAttachmentFail$1 r0 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$handleSendAttachmentFail$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$handleSendAttachmentFail$1 r0 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$handleSendAttachmentFail$1
            r0.<init>(r7, r10)
        L_0x0019:
            r4 = r0
            java.lang.Object r10 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L_0x0038
            if (r1 != r2) goto L_0x0030
            java.lang.Object r8 = r4.L$0
            r9 = r8
            io.getstream.chat.android.client.utils.Result r9 = (p015io.getstream.chat.android.client.utils.Result) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00a1
        L_0x0030:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r10)
            io.getstream.chat.android.client.logger.TaggedLogger r10 = r7.logger
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Failed to send message with id "
            r1.append(r3)
            java.lang.String r3 = r8.getId()
            r1.append(r3)
            java.lang.String r3 = " and text "
            r1.append(r3)
            java.lang.String r3 = r8.getText()
            r1.append(r3)
            java.lang.String r3 = ": "
            r1.append(r3)
            io.getstream.chat.android.client.errors.ChatError r3 = r9.error()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            io.getstream.chat.android.client.errors.ChatError r3 = r9.error()
            r10.logE((java.lang.String) r1, (p015io.getstream.chat.android.client.errors.ChatError) r3)
            io.getstream.chat.android.client.errors.ChatError r10 = r9.error()
            boolean r10 = p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.isPermanent(r10)
            if (r10 == 0) goto L_0x0081
            io.getstream.chat.android.client.utils.SyncStatus r10 = p015io.getstream.chat.android.client.utils.SyncStatus.FAILED_PERMANENTLY
            r8.setSyncStatus(r10)
            goto L_0x0086
        L_0x0081:
            io.getstream.chat.android.client.utils.SyncStatus r10 = p015io.getstream.chat.android.client.utils.SyncStatus.SYNC_NEEDED
            r8.setSyncStatus(r10)
        L_0x0086:
            r7.upsertMessage$stream_chat_android_offline_release(r8)
            io.getstream.chat.android.livedata.ChatDomainImpl r10 = r7.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r10 = r10.getRepos$stream_chat_android_offline_release()
            r1 = r10
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepository r1 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository) r1
            r3 = 0
            r5 = 2
            r6 = 0
            r4.L$0 = r9
            r4.label = r2
            r2 = r8
            java.lang.Object r8 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository.DefaultImpls.insertMessage$default(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L_0x00a1
            return r0
        L_0x00a1:
            io.getstream.chat.android.client.utils.Result r8 = new io.getstream.chat.android.client.utils.Result
            io.getstream.chat.android.client.errors.ChatError r9 = r9.error()
            r8.<init>((p015io.getstream.chat.android.client.errors.ChatError) r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl.handleSendAttachmentFail(io.getstream.chat.android.client.models.Message, io.getstream.chat.android.client.utils.Result, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String getMessageType(Message message) {
        boolean z = true;
        boolean z2 = !message.getAttachments().isEmpty();
        Iterable attachments = message.getAttachments();
        if (!(attachments instanceof Collection) || !((Collection) attachments).isEmpty()) {
            Iterator it = attachments.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((Attachment) it.next()).getUploadState() instanceof Attachment.UploadState.InProgress) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z = false;
        return (COMMAND_PATTERN.matcher(message.getText()).find() || (z2 && z)) ? ModelType.message_ephemeral : ModelType.message_regular;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object uploadAttachment$stream_chat_android_offline_release(p015io.getstream.chat.android.client.models.Attachment r36, kotlin.jvm.functions.Function2<? super p015io.getstream.chat.android.client.models.Attachment, ? super java.io.File, p015io.getstream.chat.android.client.models.Attachment> r37, p015io.getstream.chat.android.client.utils.ProgressCallback r38, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<p015io.getstream.chat.android.client.models.Attachment>> r39) {
        /*
            r35 = this;
            r0 = r35
            r1 = r36
            r2 = r37
            r3 = r38
            r4 = r39
            boolean r5 = r4 instanceof p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$uploadAttachment$1
            if (r5 == 0) goto L_0x001e
            r5 = r4
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$uploadAttachment$1 r5 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$uploadAttachment$1) r5
            int r6 = r5.label
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r6 & r7
            if (r6 == 0) goto L_0x001e
            int r4 = r5.label
            int r4 = r4 - r7
            r5.label = r4
            goto L_0x0023
        L_0x001e:
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$uploadAttachment$1 r5 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$uploadAttachment$1
            r5.<init>(r0, r4)
        L_0x0023:
            java.lang.Object r4 = r5.result
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r7 = r5.label
            r8 = 3
            r9 = 2
            r10 = 1
            java.lang.String r11 = "image"
            if (r7 == 0) goto L_0x0096
            if (r7 == r10) goto L_0x007a
            if (r7 == r9) goto L_0x005d
            if (r7 != r8) goto L_0x0055
            java.lang.Object r1 = r5.L$4
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r5.L$3
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r5.L$2
            java.io.File r3 = (java.io.File) r3
            java.lang.Object r6 = r5.L$1
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            java.lang.Object r5 = r5.L$0
            io.getstream.chat.android.client.models.Attachment r5 = (p015io.getstream.chat.android.client.models.Attachment) r5
            kotlin.ResultKt.throwOnFailure(r4)
            r12 = r1
            r7 = r2
            r1 = r5
            r2 = r6
            goto L_0x0115
        L_0x0055:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x005d:
            java.lang.Object r1 = r5.L$4
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r5.L$3
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r5.L$2
            java.io.File r3 = (java.io.File) r3
            java.lang.Object r6 = r5.L$1
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            java.lang.Object r5 = r5.L$0
            io.getstream.chat.android.client.models.Attachment r5 = (p015io.getstream.chat.android.client.models.Attachment) r5
            kotlin.ResultKt.throwOnFailure(r4)
            r12 = r1
            r7 = r2
            r1 = r5
            r2 = r6
            goto L_0x00fa
        L_0x007a:
            java.lang.Object r1 = r5.L$4
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r5.L$3
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r5.L$2
            java.io.File r3 = (java.io.File) r3
            java.lang.Object r6 = r5.L$1
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            java.lang.Object r5 = r5.L$0
            io.getstream.chat.android.client.models.Attachment r5 = (p015io.getstream.chat.android.client.models.Attachment) r5
            kotlin.ResultKt.throwOnFailure(r4)
            r12 = r1
            r7 = r2
            r1 = r5
            r2 = r6
            goto L_0x00dc
        L_0x0096:
            kotlin.ResultKt.throwOnFailure(r4)
            java.io.File r4 = r36.getUpload()
            if (r4 == 0) goto L_0x01a1
            android.webkit.MimeTypeMap r7 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r12 = kotlin.p017io.FilesKt.getExtension(r4)
            java.lang.String r7 = r7.getMimeTypeFromExtension(r12)
            boolean r12 = p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.isImageMimetype(r7)
            if (r12 == 0) goto L_0x00b3
            r12 = r11
            goto L_0x00be
        L_0x00b3:
            boolean r12 = p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.isVideoMimetype(r7)
            if (r12 == 0) goto L_0x00bc
            java.lang.String r12 = "video"
            goto L_0x00be
        L_0x00bc:
            java.lang.String r12 = "file"
        L_0x00be:
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r11)
            if (r13 == 0) goto L_0x00e0
            r5.L$0 = r1
            r5.L$1 = r2
            r5.L$2 = r4
            r5.L$3 = r7
            r5.L$4 = r12
            r5.label = r10
            java.lang.Object r3 = r0.sendImage(r4, r5)
            if (r3 != r6) goto L_0x00d7
            return r6
        L_0x00d7:
            r34 = r4
            r4 = r3
            r3 = r34
        L_0x00dc:
            io.getstream.chat.android.client.utils.Result r4 = (p015io.getstream.chat.android.client.utils.Result) r4
        L_0x00de:
            r13 = r1
            goto L_0x0118
        L_0x00e0:
            if (r3 == 0) goto L_0x00fd
            r5.L$0 = r1
            r5.L$1 = r2
            r5.L$2 = r4
            r5.L$3 = r7
            r5.L$4 = r12
            r5.label = r9
            java.lang.Object r3 = r0.sendFile(r4, r3, r5)
            if (r3 != r6) goto L_0x00f5
            return r6
        L_0x00f5:
            r34 = r4
            r4 = r3
            r3 = r34
        L_0x00fa:
            io.getstream.chat.android.client.utils.Result r4 = (p015io.getstream.chat.android.client.utils.Result) r4
            goto L_0x00de
        L_0x00fd:
            r5.L$0 = r1
            r5.L$1 = r2
            r5.L$2 = r4
            r5.L$3 = r7
            r5.L$4 = r12
            r5.label = r8
            java.lang.Object r3 = r0.sendFile(r4, r5)
            if (r3 != r6) goto L_0x0110
            return r6
        L_0x0110:
            r34 = r4
            r4 = r3
            r3 = r34
        L_0x0115:
            io.getstream.chat.android.client.utils.Result r4 = (p015io.getstream.chat.android.client.utils.Result) r4
            goto L_0x00de
        L_0x0118:
            boolean r1 = r4.isError()
            if (r1 == 0) goto L_0x0120
            r1 = 0
            goto L_0x0126
        L_0x0120:
            java.lang.Object r1 = r4.data()
            java.lang.String r1 = (java.lang.String) r1
        L_0x0126:
            boolean r5 = r4.isError()
            if (r5 == 0) goto L_0x0136
            io.getstream.chat.android.client.models.Attachment$UploadState$Failed r5 = new io.getstream.chat.android.client.models.Attachment$UploadState$Failed
            io.getstream.chat.android.client.errors.ChatError r6 = r4.error()
            r5.<init>(r6)
            goto L_0x0138
        L_0x0136:
            io.getstream.chat.android.client.models.Attachment$UploadState$Success r5 = p015io.getstream.chat.android.client.models.Attachment.UploadState.Success.INSTANCE
        L_0x0138:
            io.getstream.chat.android.client.models.Attachment$UploadState r5 = (p015io.getstream.chat.android.client.models.Attachment.UploadState) r5
            r30 = r5
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            java.lang.String r27 = r3.getName()
            long r5 = r3.length()
            int r6 = (int) r5
            r22 = 0
            r23 = 0
            if (r7 == 0) goto L_0x0158
            r20 = r7
            goto L_0x015c
        L_0x0158:
            java.lang.String r5 = ""
            r20 = r5
        L_0x015c:
            r25 = 0
            r28 = 0
            r29 = 0
            r31 = 0
            r32 = 183103(0x2cb3f, float:2.56582E-40)
            r33 = 0
            r21 = r6
            r24 = r12
            r26 = r1
            io.getstream.chat.android.client.models.Attachment r5 = p015io.getstream.chat.android.client.models.Attachment.copy$default(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            if (r1 == 0) goto L_0x0182
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r11)
            if (r6 == 0) goto L_0x017f
            r5.setImageUrl(r1)
            goto L_0x0182
        L_0x017f:
            r5.setAssetUrl(r1)
        L_0x0182:
            if (r2 == 0) goto L_0x018b
            java.lang.Object r1 = r2.invoke(r5, r3)
            r5 = r1
            io.getstream.chat.android.client.models.Attachment r5 = (p015io.getstream.chat.android.client.models.Attachment) r5
        L_0x018b:
            boolean r1 = r4.isError()
            if (r1 != 0) goto L_0x0197
            io.getstream.chat.android.client.utils.Result r1 = new io.getstream.chat.android.client.utils.Result
            r1.<init>(r5)
            goto L_0x01a0
        L_0x0197:
            io.getstream.chat.android.client.utils.Result r1 = new io.getstream.chat.android.client.utils.Result
            io.getstream.chat.android.client.errors.ChatError r2 = r4.error()
            r1.<init>((p015io.getstream.chat.android.client.errors.ChatError) r2)
        L_0x01a0:
            return r1
        L_0x01a1:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "upload file shouldn't be called on attachment without a attachment.upload"
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl.uploadAttachment$stream_chat_android_offline_release(io.getstream.chat.android.client.models.Attachment, kotlin.jvm.functions.Function2, io.getstream.chat.android.client.utils.ProgressCallback, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object uploadAttachment$stream_chat_android_offline_release$default(ChannelControllerImpl channelControllerImpl, Attachment attachment, Function2 function2, ProgressCallback progressCallback, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            progressCallback = null;
        }
        return channelControllerImpl.uploadAttachment$stream_chat_android_offline_release(attachment, function2, progressCallback, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object cancelMessage(p015io.getstream.chat.android.client.models.Message r5, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<java.lang.Boolean>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$cancelMessage$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$cancelMessage$1 r0 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$cancelMessage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$cancelMessage$1 r0 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$cancelMessage$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r5 = r0.L$1
            io.getstream.chat.android.client.models.Message r5 = (p015io.getstream.chat.android.client.models.Message) r5
            java.lang.Object r0 = r0.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r0 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x005e
        L_0x0032:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.String r6 = r5.getType()
            java.lang.String r2 = "ephemeral"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r6)
            r6 = r6 ^ r3
            if (r6 != 0) goto L_0x006b
            io.getstream.chat.android.livedata.ChatDomainImpl r6 = r4.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r6 = r6.getRepos$stream_chat_android_offline_release()
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r6.deleteChannelMessage(r5, r0)
            if (r6 != r1) goto L_0x005d
            return r1
        L_0x005d:
            r0 = r4
        L_0x005e:
            r0.removeLocalMessage(r5)
            io.getstream.chat.android.client.utils.Result r5 = new io.getstream.chat.android.client.utils.Result
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            r5.<init>(r6)
            return r5
        L_0x006b:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Only ephemeral message can be canceled"
            r5.<init>(r6)
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl.cancelMessage(io.getstream.chat.android.client.models.Message, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object sendGiphy(p015io.getstream.chat.android.client.models.Message r9, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<p015io.getstream.chat.android.client.models.Message>> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendGiphy$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendGiphy$1 r0 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendGiphy$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendGiphy$1 r0 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendGiphy$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r9 = r0.L$1
            io.getstream.chat.android.client.models.Message r9 = (p015io.getstream.chat.android.client.models.Message) r9
            java.lang.Object r0 = r0.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r0 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0071
        L_0x0032:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r10)
            io.getstream.chat.android.client.api.models.SendActionRequest r10 = new io.getstream.chat.android.client.api.models.SendActionRequest
            java.lang.String r2 = r9.getCid()
            java.lang.String r4 = r9.getId()
            java.lang.String r5 = r9.getType()
            java.lang.String r6 = "image_action"
            java.lang.String r7 = "send"
            kotlin.Pair r6 = kotlin.TuplesKt.m181to(r6, r7)
            java.util.Map r6 = kotlin.collections.MapsKt.mapOf(r6)
            r10.<init>(r2, r4, r5, r6)
            io.getstream.chat.android.livedata.ChatDomainImpl r2 = r8.domainImpl
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendGiphy$result$1 r4 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendGiphy$result$1
            r4.<init>(r8, r10)
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r10 = r2.runAndRetry(r4, r0)
            if (r10 != r1) goto L_0x0070
            return r1
        L_0x0070:
            r0 = r8
        L_0x0071:
            io.getstream.chat.android.client.utils.Result r10 = (p015io.getstream.chat.android.client.utils.Result) r10
            r0.removeLocalMessage(r9)
            boolean r9 = r10.isSuccess()
            if (r9 == 0) goto L_0x0086
            io.getstream.chat.android.client.utils.Result r9 = new io.getstream.chat.android.client.utils.Result
            java.lang.Object r10 = r10.data()
            r9.<init>(r10)
            goto L_0x008f
        L_0x0086:
            io.getstream.chat.android.client.utils.Result r9 = new io.getstream.chat.android.client.utils.Result
            io.getstream.chat.android.client.errors.ChatError r10 = r10.error()
            r9.<init>((p015io.getstream.chat.android.client.errors.ChatError) r10)
        L_0x008f:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl.sendGiphy(io.getstream.chat.android.client.models.Message, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object shuffleGiphy(p015io.getstream.chat.android.client.models.Message r10, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<p015io.getstream.chat.android.client.models.Message>> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$shuffleGiphy$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$shuffleGiphy$1 r0 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$shuffleGiphy$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$shuffleGiphy$1 r0 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$shuffleGiphy$1
            r0.<init>(r9, r11)
        L_0x0019:
            r4 = r0
            java.lang.Object r11 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0050
            if (r1 == r3) goto L_0x0043
            if (r1 != r2) goto L_0x003b
            java.lang.Object r10 = r4.L$2
            io.getstream.chat.android.client.models.Message r10 = (p015io.getstream.chat.android.client.models.Message) r10
            java.lang.Object r10 = r4.L$1
            io.getstream.chat.android.client.models.Message r10 = (p015io.getstream.chat.android.client.models.Message) r10
            java.lang.Object r0 = r4.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r0 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00ba
        L_0x003b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0043:
            java.lang.Object r10 = r4.L$1
            io.getstream.chat.android.client.models.Message r10 = (p015io.getstream.chat.android.client.models.Message) r10
            java.lang.Object r1 = r4.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r1 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r1
            kotlin.ResultKt.throwOnFailure(r11)
            r7 = r1
            goto L_0x0087
        L_0x0050:
            kotlin.ResultKt.throwOnFailure(r11)
            io.getstream.chat.android.client.api.models.SendActionRequest r11 = new io.getstream.chat.android.client.api.models.SendActionRequest
            java.lang.String r1 = r10.getCid()
            java.lang.String r5 = r10.getId()
            java.lang.String r6 = r10.getType()
            java.lang.String r7 = "image_action"
            java.lang.String r8 = "shuffle"
            kotlin.Pair r7 = kotlin.TuplesKt.m181to(r7, r8)
            java.util.Map r7 = kotlin.collections.MapsKt.mapOf(r7)
            r11.<init>(r1, r5, r6, r7)
            io.getstream.chat.android.livedata.ChatDomainImpl r1 = r9.domainImpl
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$shuffleGiphy$result$1 r5 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$shuffleGiphy$result$1
            r5.<init>(r9, r11)
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r4.L$0 = r9
            r4.L$1 = r10
            r4.label = r3
            java.lang.Object r11 = r1.runAndRetry(r5, r4)
            if (r11 != r0) goto L_0x0086
            return r0
        L_0x0086:
            r7 = r9
        L_0x0087:
            io.getstream.chat.android.client.utils.Result r11 = (p015io.getstream.chat.android.client.utils.Result) r11
            r7.removeLocalMessage(r10)
            boolean r10 = r11.isSuccess()
            if (r10 == 0) goto L_0x00c3
            java.lang.Object r10 = r11.data()
            io.getstream.chat.android.client.models.Message r10 = (p015io.getstream.chat.android.client.models.Message) r10
            io.getstream.chat.android.client.utils.SyncStatus r11 = p015io.getstream.chat.android.client.utils.SyncStatus.COMPLETED
            r10.setSyncStatus(r11)
            io.getstream.chat.android.livedata.ChatDomainImpl r11 = r7.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r11 = r11.getRepos$stream_chat_android_offline_release()
            r1 = r11
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepository r1 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository) r1
            r3 = 0
            r5 = 2
            r6 = 0
            r4.L$0 = r7
            r4.L$1 = r10
            r4.L$2 = r10
            r4.label = r2
            r2 = r10
            java.lang.Object r11 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository.DefaultImpls.insertMessage$default(r1, r2, r3, r4, r5, r6)
            if (r11 != r0) goto L_0x00b9
            return r0
        L_0x00b9:
            r0 = r7
        L_0x00ba:
            r0.upsertMessage$stream_chat_android_offline_release(r10)
            io.getstream.chat.android.client.utils.Result r11 = new io.getstream.chat.android.client.utils.Result
            r11.<init>(r10)
            goto L_0x00cd
        L_0x00c3:
            io.getstream.chat.android.client.utils.Result r10 = new io.getstream.chat.android.client.utils.Result
            io.getstream.chat.android.client.errors.ChatError r11 = r11.error()
            r10.<init>((p015io.getstream.chat.android.client.errors.ChatError) r11)
            r11 = r10
        L_0x00cd:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl.shuffleGiphy(io.getstream.chat.android.client.models.Message, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object sendImage(File file, Continuation<? super Result<String>> continuation) {
        return CallKt.await(ChatClient.sendImage$default(this.client, getChannelType(), getChannelId(), file, (ProgressCallback) null, 8, (Object) null), continuation);
    }

    public final Object sendFile(File file, Continuation<? super Result<String>> continuation) {
        return CallKt.await(ChatClient.sendFile$default(this.client, getChannelType(), getChannelId(), file, (ProgressCallback) null, 8, (Object) null), continuation);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object sendFile(File file, ProgressCallback progressCallback, Continuation<? super Result<String>> continuation) {
        return CallKt.await(this.client.sendFile(getChannelType(), getChannelId(), file, progressCallback), continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0075, code lost:
        r13 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00dd, code lost:
        r3 = r6.domainImpl.getRepos$stream_chat_android_offline_release();
        r4.L$0 = r6;
        r4.L$1 = r1;
        r4.Z$0 = r2;
        r4.Z$1 = r5;
        r4.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00f2, code lost:
        if (r3.insertReaction(r1, r4) != r11) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00f4, code lost:
        return r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00f5, code lost:
        r3 = r1;
        r1 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00f9, code lost:
        r14 = r13.getMessage(r3.getMessageId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0101, code lost:
        if (r14 == null) goto L_0x0154;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0103, code lost:
        r6 = p015io.getstream.chat.android.client.models.Message.copy$default(r14, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null, (java.util.List) null, (java.util.List) null, (java.util.List) null, 0, (java.util.Map) null, (java.util.Map) null, (p015io.getstream.chat.android.client.utils.SyncStatus) null, (java.lang.String) null, (java.util.List) null, (java.util.List) null, (java.util.Date) null, (java.util.Date) null, (java.util.Date) null, (java.util.Date) null, (java.util.Date) null, (p015io.getstream.chat.android.client.models.User) null, (java.util.Map) null, false, false, (java.util.Map) null, false, (p015io.getstream.chat.android.client.models.ChannelInfo) null, (p015io.getstream.chat.android.client.models.Message) null, (java.lang.String) null, false, (java.util.Date) null, (java.util.Date) null, (p015io.getstream.chat.android.client.models.User) null, (java.util.List) null, -1, 7, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0154, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0155, code lost:
        if (r6 == null) goto L_0x0181;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0157, code lost:
        p015io.getstream.chat.android.livedata.extensions.MessageReactionExtensionsKt.addMyReaction(r6, r3, r2);
        r13.upsertMessage$stream_chat_android_offline_release(r6);
        r4.L$0 = r13;
        r4.L$1 = r3;
        r4.Z$0 = r2;
        r4.Z$1 = r1;
        r4.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0178, code lost:
        if (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository.DefaultImpls.insertMessage$default(r13.domainImpl.getRepos$stream_chat_android_offline_release(), r6, false, r4, 2, (java.lang.Object) null) != r11) goto L_0x017b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x017a, code lost:
        return r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x017b, code lost:
        r5 = r3;
        r6 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x017d, code lost:
        r3 = r5;
        r5 = r2;
        r2 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0181, code lost:
        r5 = r2;
        r2 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0183, code lost:
        if (r1 == false) goto L_0x022b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0185, code lost:
        r4.L$0 = r2;
        r4.L$1 = r3;
        r4.label = 4;
        r1 = r2.domainImpl.runAndRetry(new p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendReaction$result$1(r2, r3, r5), r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0199, code lost:
        if (r1 != r11) goto L_0x019c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x019b, code lost:
        return r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x019c, code lost:
        r53 = r3;
        r3 = r1;
        r1 = r53;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x01a1, code lost:
        r3 = (p015io.getstream.chat.android.client.utils.Result) r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01a7, code lost:
        if (r3.isSuccess() == false) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01a9, code lost:
        r1.setSyncStatus(p015io.getstream.chat.android.client.utils.SyncStatus.COMPLETED);
        r2 = r2.domainImpl.getRepos$stream_chat_android_offline_release();
        r4.L$0 = r3;
        r4.L$1 = null;
        r4.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x01bf, code lost:
        if (r2.insertReaction(r1, r4) != r11) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x01c1, code lost:
        return r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01c2, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01cd, code lost:
        r2.logger.logE("Failed to send reaction of type " + r1.getType() + " on messge " + r1.getMessageId(), r3.error());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01ff, code lost:
        if (p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.isPermanent(r3.error()) == false) goto L_0x0207;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0201, code lost:
        r1.setSyncStatus(p015io.getstream.chat.android.client.utils.SyncStatus.FAILED_PERMANENTLY);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0207, code lost:
        r1.setSyncStatus(p015io.getstream.chat.android.client.utils.SyncStatus.SYNC_NEEDED);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x020c, code lost:
        r2 = r2.domainImpl.getRepos$stream_chat_android_offline_release();
        r4.L$0 = r3;
        r4.L$1 = null;
        r4.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x021d, code lost:
        if (r2.insertReaction(r1, r4) != r11) goto L_0x0220;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x021f, code lost:
        return r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0220, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0230, code lost:
        return new p015io.getstream.chat.android.client.utils.Result(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        return new p015io.getstream.chat.android.client.utils.Result(r1.error());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        return new p015io.getstream.chat.android.client.utils.Result(r1.data());
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object sendReaction(p015io.getstream.chat.android.client.models.Reaction r55, boolean r56, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<p015io.getstream.chat.android.client.models.Reaction>> r57) {
        /*
            r54 = this;
            r0 = r54
            r1 = r55
            r2 = r56
            r3 = r57
            boolean r4 = r3 instanceof p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendReaction$1
            if (r4 == 0) goto L_0x001c
            r4 = r3
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendReaction$1 r4 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendReaction$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r5 & r6
            if (r5 == 0) goto L_0x001c
            int r3 = r4.label
            int r3 = r3 - r6
            r4.label = r3
            goto L_0x0021
        L_0x001c:
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendReaction$1 r4 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendReaction$1
            r4.<init>(r0, r3)
        L_0x0021:
            java.lang.Object r3 = r4.result
            java.lang.Object r11 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r4.label
            r12 = 0
            switch(r5) {
                case 0: goto L_0x008d;
                case 1: goto L_0x0078;
                case 2: goto L_0x0065;
                case 3: goto L_0x0054;
                case 4: goto L_0x0047;
                case 5: goto L_0x003e;
                case 6: goto L_0x0035;
                default: goto L_0x002d;
            }
        L_0x002d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0035:
            java.lang.Object r1 = r4.L$0
            io.getstream.chat.android.client.utils.Result r1 = (p015io.getstream.chat.android.client.utils.Result) r1
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x0221
        L_0x003e:
            java.lang.Object r1 = r4.L$0
            io.getstream.chat.android.client.utils.Result r1 = (p015io.getstream.chat.android.client.utils.Result) r1
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x01c3
        L_0x0047:
            java.lang.Object r1 = r4.L$1
            io.getstream.chat.android.client.models.Reaction r1 = (p015io.getstream.chat.android.client.models.Reaction) r1
            java.lang.Object r2 = r4.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r2 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r2
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x01a1
        L_0x0054:
            boolean r1 = r4.Z$1
            boolean r2 = r4.Z$0
            java.lang.Object r5 = r4.L$1
            io.getstream.chat.android.client.models.Reaction r5 = (p015io.getstream.chat.android.client.models.Reaction) r5
            java.lang.Object r6 = r4.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r6 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r6
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x017d
        L_0x0065:
            boolean r1 = r4.Z$1
            boolean r2 = r4.Z$0
            java.lang.Object r5 = r4.L$1
            io.getstream.chat.android.client.models.Reaction r5 = (p015io.getstream.chat.android.client.models.Reaction) r5
            java.lang.Object r6 = r4.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r6 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r6
            kotlin.ResultKt.throwOnFailure(r3)
            r3 = r5
        L_0x0075:
            r13 = r6
            goto L_0x00f9
        L_0x0078:
            boolean r1 = r4.Z$1
            boolean r2 = r4.Z$0
            java.lang.Object r5 = r4.L$1
            io.getstream.chat.android.client.models.Reaction r5 = (p015io.getstream.chat.android.client.models.Reaction) r5
            java.lang.Object r6 = r4.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r6 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r6
            kotlin.ResultKt.throwOnFailure(r3)
            r53 = r5
            r5 = r1
            r1 = r53
            goto L_0x00dd
        L_0x008d:
            kotlin.ResultKt.throwOnFailure(r3)
            io.getstream.chat.android.livedata.ChatDomainImpl r3 = r0.domainImpl
            io.getstream.chat.android.client.models.User r3 = r3.getCurrentUser()
            r1.setUser(r3)
            java.lang.String r5 = r3.getId()
            r1.setUserId(r5)
            io.getstream.chat.android.client.utils.SyncStatus r5 = p015io.getstream.chat.android.client.utils.SyncStatus.IN_PROGRESS
            r1.setSyncStatus(r5)
            r55.setEnforceUnique(r56)
            io.getstream.chat.android.livedata.ChatDomainImpl r5 = r0.domainImpl
            boolean r5 = r5.isOnline()
            if (r5 != 0) goto L_0x00b5
            io.getstream.chat.android.client.utils.SyncStatus r6 = p015io.getstream.chat.android.client.utils.SyncStatus.SYNC_NEEDED
            r1.setSyncStatus(r6)
        L_0x00b5:
            if (r2 == 0) goto L_0x00dc
            io.getstream.chat.android.livedata.ChatDomainImpl r6 = r0.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r6 = r6.getRepos$stream_chat_android_offline_release()
            java.lang.String r3 = r3.getId()
            java.lang.String r7 = r55.getMessageId()
            java.util.Date r8 = new java.util.Date
            r8.<init>()
            r4.L$0 = r0
            r4.L$1 = r1
            r4.Z$0 = r2
            r4.Z$1 = r5
            r9 = 1
            r4.label = r9
            java.lang.Object r3 = r6.updateReactionsForMessageByDeletedDate(r3, r7, r8, r4)
            if (r3 != r11) goto L_0x00dc
            return r11
        L_0x00dc:
            r6 = r0
        L_0x00dd:
            io.getstream.chat.android.livedata.ChatDomainImpl r3 = r6.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r3 = r3.getRepos$stream_chat_android_offline_release()
            r4.L$0 = r6
            r4.L$1 = r1
            r4.Z$0 = r2
            r4.Z$1 = r5
            r7 = 2
            r4.label = r7
            java.lang.Object r3 = r3.insertReaction(r1, r4)
            if (r3 != r11) goto L_0x00f5
            return r11
        L_0x00f5:
            r3 = r1
            r1 = r5
            goto L_0x0075
        L_0x00f9:
            java.lang.String r5 = r3.getMessageId()
            io.getstream.chat.android.client.models.Message r14 = r13.getMessage(r5)
            if (r14 == 0) goto L_0x0154
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = -1
            r51 = 7
            r52 = 0
            io.getstream.chat.android.client.models.Message r5 = p015io.getstream.chat.android.client.models.Message.copy$default(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52)
            r6 = r5
            goto L_0x0155
        L_0x0154:
            r6 = r12
        L_0x0155:
            if (r6 == 0) goto L_0x0181
            p015io.getstream.chat.android.livedata.extensions.MessageReactionExtensionsKt.addMyReaction(r6, r3, r2)
            r13.upsertMessage$stream_chat_android_offline_release(r6)
            io.getstream.chat.android.livedata.ChatDomainImpl r5 = r13.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r5 = r5.getRepos$stream_chat_android_offline_release()
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepository r5 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository) r5
            r7 = 0
            r9 = 2
            r10 = 0
            r4.L$0 = r13
            r4.L$1 = r3
            r4.Z$0 = r2
            r4.Z$1 = r1
            r8 = 3
            r4.label = r8
            r8 = r4
            java.lang.Object r5 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository.DefaultImpls.insertMessage$default(r5, r6, r7, r8, r9, r10)
            if (r5 != r11) goto L_0x017b
            return r11
        L_0x017b:
            r5 = r3
            r6 = r13
        L_0x017d:
            r3 = r5
            r5 = r2
            r2 = r6
            goto L_0x0183
        L_0x0181:
            r5 = r2
            r2 = r13
        L_0x0183:
            if (r1 == 0) goto L_0x022b
            io.getstream.chat.android.livedata.ChatDomainImpl r1 = r2.domainImpl
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendReaction$result$1 r6 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$sendReaction$result$1
            r6.<init>(r2, r3, r5)
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            r4.L$0 = r2
            r4.L$1 = r3
            r5 = 4
            r4.label = r5
            java.lang.Object r1 = r1.runAndRetry(r6, r4)
            if (r1 != r11) goto L_0x019c
            return r11
        L_0x019c:
            r53 = r3
            r3 = r1
            r1 = r53
        L_0x01a1:
            io.getstream.chat.android.client.utils.Result r3 = (p015io.getstream.chat.android.client.utils.Result) r3
            boolean r5 = r3.isSuccess()
            if (r5 == 0) goto L_0x01cd
            io.getstream.chat.android.client.utils.SyncStatus r5 = p015io.getstream.chat.android.client.utils.SyncStatus.COMPLETED
            r1.setSyncStatus(r5)
            io.getstream.chat.android.livedata.ChatDomainImpl r2 = r2.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r2 = r2.getRepos$stream_chat_android_offline_release()
            r4.L$0 = r3
            r4.L$1 = r12
            r5 = 5
            r4.label = r5
            java.lang.Object r1 = r2.insertReaction(r1, r4)
            if (r1 != r11) goto L_0x01c2
            return r11
        L_0x01c2:
            r1 = r3
        L_0x01c3:
            io.getstream.chat.android.client.utils.Result r2 = new io.getstream.chat.android.client.utils.Result
            java.lang.Object r1 = r1.data()
            r2.<init>(r1)
            goto L_0x022a
        L_0x01cd:
            io.getstream.chat.android.client.logger.TaggedLogger r5 = r2.logger
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Failed to send reaction of type "
            r6.append(r7)
            java.lang.String r7 = r1.getType()
            r6.append(r7)
            java.lang.String r7 = " on messge "
            r6.append(r7)
            java.lang.String r7 = r1.getMessageId()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            io.getstream.chat.android.client.errors.ChatError r7 = r3.error()
            r5.logE((java.lang.String) r6, (p015io.getstream.chat.android.client.errors.ChatError) r7)
            io.getstream.chat.android.client.errors.ChatError r5 = r3.error()
            boolean r5 = p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.isPermanent(r5)
            if (r5 == 0) goto L_0x0207
            io.getstream.chat.android.client.utils.SyncStatus r5 = p015io.getstream.chat.android.client.utils.SyncStatus.FAILED_PERMANENTLY
            r1.setSyncStatus(r5)
            goto L_0x020c
        L_0x0207:
            io.getstream.chat.android.client.utils.SyncStatus r5 = p015io.getstream.chat.android.client.utils.SyncStatus.SYNC_NEEDED
            r1.setSyncStatus(r5)
        L_0x020c:
            io.getstream.chat.android.livedata.ChatDomainImpl r2 = r2.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r2 = r2.getRepos$stream_chat_android_offline_release()
            r4.L$0 = r3
            r4.L$1 = r12
            r5 = 6
            r4.label = r5
            java.lang.Object r1 = r2.insertReaction(r1, r4)
            if (r1 != r11) goto L_0x0220
            return r11
        L_0x0220:
            r1 = r3
        L_0x0221:
            io.getstream.chat.android.client.utils.Result r2 = new io.getstream.chat.android.client.utils.Result
            io.getstream.chat.android.client.errors.ChatError r1 = r1.error()
            r2.<init>((p015io.getstream.chat.android.client.errors.ChatError) r1)
        L_0x022a:
            return r2
        L_0x022b:
            io.getstream.chat.android.client.utils.Result r1 = new io.getstream.chat.android.client.utils.Result
            r1.<init>(r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl.sendReaction(io.getstream.chat.android.client.models.Reaction, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object deleteReaction(p015io.getstream.chat.android.client.models.Reaction r56, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<p015io.getstream.chat.android.client.models.Message>> r57) {
        /*
            r55 = this;
            r0 = r55
            r1 = r56
            r2 = r57
            boolean r3 = r2 instanceof p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$deleteReaction$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$deleteReaction$1 r3 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$deleteReaction$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$deleteReaction$1 r3 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$deleteReaction$1
            r3.<init>(r0, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r3.label
            r11 = 5
            r12 = 4
            r13 = 3
            r5 = 1
            r14 = 2
            r15 = 0
            if (r4 == 0) goto L_0x0088
            if (r4 == r5) goto L_0x0077
            if (r4 == r14) goto L_0x0060
            if (r4 == r13) goto L_0x0053
            if (r4 == r12) goto L_0x004a
            if (r4 != r11) goto L_0x0042
            java.lang.Object r1 = r3.L$0
            io.getstream.chat.android.client.utils.Result r1 = (p015io.getstream.chat.android.client.utils.Result) r1
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x01df
        L_0x0042:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x004a:
            java.lang.Object r1 = r3.L$0
            io.getstream.chat.android.client.utils.Result r1 = (p015io.getstream.chat.android.client.utils.Result) r1
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x01ac
        L_0x0053:
            java.lang.Object r1 = r3.L$1
            io.getstream.chat.android.client.models.Reaction r1 = (p015io.getstream.chat.android.client.models.Reaction) r1
            java.lang.Object r4 = r3.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r4 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r4
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x018b
        L_0x0060:
            boolean r1 = r3.Z$0
            java.lang.Object r4 = r3.L$3
            io.getstream.chat.android.client.models.Message r4 = (p015io.getstream.chat.android.client.models.Message) r4
            java.lang.Object r4 = r3.L$2
            io.getstream.chat.android.client.models.Message r4 = (p015io.getstream.chat.android.client.models.Message) r4
            java.lang.Object r5 = r3.L$1
            io.getstream.chat.android.client.models.Reaction r5 = (p015io.getstream.chat.android.client.models.Reaction) r5
            java.lang.Object r6 = r3.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r6 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r6
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0162
        L_0x0077:
            boolean r1 = r3.Z$0
            java.lang.Object r4 = r3.L$1
            io.getstream.chat.android.client.models.Reaction r4 = (p015io.getstream.chat.android.client.models.Reaction) r4
            java.lang.Object r5 = r3.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r5 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r5
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r1
            r1 = r4
            r9 = r5
            goto L_0x00cb
        L_0x0088:
            kotlin.ResultKt.throwOnFailure(r2)
            io.getstream.chat.android.livedata.ChatDomainImpl r2 = r0.domainImpl
            boolean r2 = r2.isOnline()
            io.getstream.chat.android.livedata.ChatDomainImpl r4 = r0.domainImpl
            io.getstream.chat.android.client.models.User r4 = r4.getCurrentUser()
            r1.setUser(r4)
            java.lang.String r4 = r4.getId()
            r1.setUserId(r4)
            io.getstream.chat.android.client.utils.SyncStatus r4 = p015io.getstream.chat.android.client.utils.SyncStatus.IN_PROGRESS
            r1.setSyncStatus(r4)
            java.util.Date r4 = new java.util.Date
            r4.<init>()
            r1.setDeletedAt(r4)
            if (r2 != 0) goto L_0x00b5
            io.getstream.chat.android.client.utils.SyncStatus r4 = p015io.getstream.chat.android.client.utils.SyncStatus.SYNC_NEEDED
            r1.setSyncStatus(r4)
        L_0x00b5:
            io.getstream.chat.android.livedata.ChatDomainImpl r4 = r0.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r4 = r4.getRepos$stream_chat_android_offline_release()
            r3.L$0 = r0
            r3.L$1 = r1
            r3.Z$0 = r2
            r3.label = r5
            java.lang.Object r4 = r4.insertReaction(r1, r3)
            if (r4 != r10) goto L_0x00ca
            return r10
        L_0x00ca:
            r9 = r0
        L_0x00cb:
            java.lang.String r4 = r1.getMessageId()
            io.getstream.chat.android.client.models.Message r16 = r9.getMessage(r4)
            if (r16 == 0) goto L_0x0127
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r51 = 0
            r52 = -1
            r53 = 7
            r54 = 0
            io.getstream.chat.android.client.models.Message r4 = p015io.getstream.chat.android.client.models.Message.copy$default(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54)
            r8 = r4
            goto L_0x0128
        L_0x0127:
            r8 = r15
        L_0x0128:
            if (r8 == 0) goto L_0x0167
            p015io.getstream.chat.android.livedata.extensions.MessageReactionExtensionsKt.removeMyReaction(r8, r1)
            if (r8 == 0) goto L_0x0167
            r9.upsertMessage$stream_chat_android_offline_release(r8)
            io.getstream.chat.android.livedata.ChatDomainImpl r4 = r9.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r4 = r4.getRepos$stream_chat_android_offline_release()
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepository r4 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository) r4
            r6 = 0
            r16 = 2
            r17 = 0
            r3.L$0 = r9
            r3.L$1 = r1
            r3.L$2 = r8
            r3.L$3 = r8
            r3.Z$0 = r2
            r3.label = r14
            r5 = r8
            r7 = r3
            r18 = r8
            r8 = r16
            r16 = r9
            r9 = r17
            java.lang.Object r4 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository.DefaultImpls.insertMessage$default(r4, r5, r6, r7, r8, r9)
            if (r4 != r10) goto L_0x015c
            return r10
        L_0x015c:
            r5 = r1
            r1 = r2
            r6 = r16
            r4 = r18
        L_0x0162:
            r2 = r1
            r8 = r4
            r1 = r5
            r4 = r6
            goto L_0x016f
        L_0x0167:
            r18 = r8
            r16 = r9
            r4 = r16
            r8 = r18
        L_0x016f:
            if (r2 == 0) goto L_0x01e9
            io.getstream.chat.android.livedata.ChatDomainImpl r2 = r4.domainImpl
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$deleteReaction$result$1 r5 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$deleteReaction$result$1
            r5.<init>(r4, r1)
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r3.L$0 = r4
            r3.L$1 = r1
            r3.L$2 = r15
            r3.L$3 = r15
            r3.label = r13
            java.lang.Object r2 = r2.runAndRetry(r5, r3)
            if (r2 != r10) goto L_0x018b
            return r10
        L_0x018b:
            io.getstream.chat.android.client.utils.Result r2 = (p015io.getstream.chat.android.client.utils.Result) r2
            boolean r5 = r2.isSuccess()
            if (r5 == 0) goto L_0x01b6
            io.getstream.chat.android.client.utils.SyncStatus r5 = p015io.getstream.chat.android.client.utils.SyncStatus.COMPLETED
            r1.setSyncStatus(r5)
            io.getstream.chat.android.livedata.ChatDomainImpl r4 = r4.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r4 = r4.getRepos$stream_chat_android_offline_release()
            r3.L$0 = r2
            r3.L$1 = r15
            r3.label = r12
            java.lang.Object r1 = r4.insertReaction(r1, r3)
            if (r1 != r10) goto L_0x01ab
            return r10
        L_0x01ab:
            r1 = r2
        L_0x01ac:
            io.getstream.chat.android.client.utils.Result r2 = new io.getstream.chat.android.client.utils.Result
            java.lang.Object r1 = r1.data()
            r2.<init>(r1)
            goto L_0x01e8
        L_0x01b6:
            io.getstream.chat.android.client.errors.ChatError r5 = r2.error()
            boolean r5 = p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.isPermanent(r5)
            if (r5 == 0) goto L_0x01c6
            io.getstream.chat.android.client.utils.SyncStatus r5 = p015io.getstream.chat.android.client.utils.SyncStatus.FAILED_PERMANENTLY
            r1.setSyncStatus(r5)
            goto L_0x01cb
        L_0x01c6:
            io.getstream.chat.android.client.utils.SyncStatus r5 = p015io.getstream.chat.android.client.utils.SyncStatus.SYNC_NEEDED
            r1.setSyncStatus(r5)
        L_0x01cb:
            io.getstream.chat.android.livedata.ChatDomainImpl r4 = r4.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r4 = r4.getRepos$stream_chat_android_offline_release()
            r3.L$0 = r2
            r3.L$1 = r15
            r3.label = r11
            java.lang.Object r1 = r4.insertReaction(r1, r3)
            if (r1 != r10) goto L_0x01de
            return r10
        L_0x01de:
            r1 = r2
        L_0x01df:
            io.getstream.chat.android.client.utils.Result r2 = new io.getstream.chat.android.client.utils.Result
            io.getstream.chat.android.client.errors.ChatError r1 = r1.error()
            r2.<init>((p015io.getstream.chat.android.client.errors.ChatError) r1)
        L_0x01e8:
            return r2
        L_0x01e9:
            if (r8 == 0) goto L_0x01f1
            io.getstream.chat.android.client.utils.Result r1 = new io.getstream.chat.android.client.utils.Result
            r1.<init>(r8)
            goto L_0x01fd
        L_0x01f1:
            io.getstream.chat.android.client.utils.Result r1 = new io.getstream.chat.android.client.utils.Result
            io.getstream.chat.android.client.errors.ChatError r2 = new io.getstream.chat.android.client.errors.ChatError
            java.lang.String r3 = "Local message was not found"
            r2.<init>(r3, r15, r14, r15)
            r1.<init>((p015io.getstream.chat.android.client.errors.ChatError) r2)
        L_0x01fd:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl.deleteReaction(io.getstream.chat.android.client.models.Reaction, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void setWatcherCount(int i) {
        if (i != this._watcherCount.getValue().intValue()) {
            this._watcherCount.setValue(Integer.valueOf(i));
        }
    }

    public final void upsertMessage$stream_chat_android_offline_release(Message message) {
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        upsertMessages(CollectionsKt.listOf(message));
    }

    private final void upsertEventMessage(Message message) {
        Message message2 = getMessage(message.getId());
        if (message2 != null) {
            message.setOwnReactions(message2.getOwnReactions());
        }
        upsertMessages(CollectionsKt.listOf(message));
    }

    public Message getMessage(String str) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        Message message = (Message) this._messages.getValue().get(str);
        Date date = this.hideMessagesBefore;
        if (date == null || message == null || !MessageExtensionsKt.wasCreatedBeforeOrAt(message, date)) {
            return message;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0046, code lost:
        r9 = r6.getUpdatedLocallyAt();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.Map<java.lang.String, p015io.getstream.chat.android.client.models.Message> parseMessages(java.util.List<p015io.getstream.chat.android.client.models.Message> r46) {
        /*
            r45 = this;
            r0 = r45
            r1 = r46
            kotlinx.coroutines.flow.MutableStateFlow<java.util.Map<java.lang.String, io.getstream.chat.android.client.models.Message>> r2 = r0._messages
            java.lang.Object r2 = r2.getValue()
            java.util.Map r2 = (java.util.Map) r2
            io.getstream.chat.android.livedata.controller.helper.MessageHelper r3 = r0.messageHelper
            java.util.List r3 = r3.updateValidAttachmentsUrl((java.util.List<p015io.getstream.chat.android.client.models.Message>) r1, (java.util.Map<java.lang.String, p015io.getstream.chat.android.client.models.Message>) r2)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.List r4 = (java.util.List) r4
            java.util.Iterator r3 = r3.iterator()
        L_0x001d:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x00c4
            java.lang.Object r5 = r3.next()
            io.getstream.chat.android.client.models.Message r5 = (p015io.getstream.chat.android.client.models.Message) r5
            java.lang.String r6 = r5.getId()
            java.lang.Object r6 = r2.get(r6)
            io.getstream.chat.android.client.models.Message r6 = (p015io.getstream.chat.android.client.models.Message) r6
            r7 = 0
            r8 = 0
            if (r6 == 0) goto L_0x0088
            java.util.Date r9 = r6.getUpdatedAt()
            if (r9 == 0) goto L_0x0046
        L_0x003d:
            long r9 = r9.getTime()
            java.lang.Long r9 = java.lang.Long.valueOf(r9)
            goto L_0x004e
        L_0x0046:
            java.util.Date r9 = r6.getUpdatedLocallyAt()
            if (r9 == 0) goto L_0x004d
            goto L_0x003d
        L_0x004d:
            r9 = r8
        L_0x004e:
            if (r9 == 0) goto L_0x0055
            long r9 = r9.longValue()
            goto L_0x005d
        L_0x0055:
            java.util.Date r9 = p015io.getstream.chat.android.livedata.extensions.MessageExtensionsKt.getNEVER()
            long r9 = r9.getTime()
        L_0x005d:
            java.util.Date r11 = r5.getUpdatedAt()
            if (r11 == 0) goto L_0x006c
        L_0x0063:
            long r11 = r11.getTime()
            java.lang.Long r11 = java.lang.Long.valueOf(r11)
            goto L_0x0074
        L_0x006c:
            java.util.Date r11 = r5.getUpdatedLocallyAt()
            if (r11 == 0) goto L_0x0073
            goto L_0x0063
        L_0x0073:
            r11 = r8
        L_0x0074:
            if (r11 == 0) goto L_0x007b
            long r11 = r11.longValue()
            goto L_0x0083
        L_0x007b:
            java.util.Date r11 = p015io.getstream.chat.android.livedata.extensions.MessageExtensionsKt.getNEVER()
            long r11 = r11.getTime()
        L_0x0083:
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 <= 0) goto L_0x0088
            r7 = 1
        L_0x0088:
            if (r7 != 0) goto L_0x008e
            r4.add(r5)
            goto L_0x001d
        L_0x008e:
            if (r6 == 0) goto L_0x0094
            java.util.Date r8 = r6.getUpdatedAt()
        L_0x0094:
            io.getstream.chat.android.client.logger.TaggedLogger r6 = r0.logger
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = "Skipping outdated message update for message with text "
            r7.append(r9)
            java.lang.String r9 = r5.getText()
            r7.append(r9)
            java.lang.String r9 = ". Old message date is "
            r7.append(r9)
            r7.append(r8)
            java.lang.String r8 = " new message date id "
            r7.append(r8)
            java.util.Date r5 = r5.getUpdatedAt()
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.logW(r5)
            goto L_0x001d
        L_0x00c4:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r4)
            r3.<init>(r5)
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r1 = r1.iterator()
        L_0x00d7:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x012f
            java.lang.Object r5 = r1.next()
            r6 = r5
            io.getstream.chat.android.client.models.Message r6 = (p015io.getstream.chat.android.client.models.Message) r6
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = -1
            r43 = 7
            r44 = 0
            io.getstream.chat.android.client.models.Message r5 = p015io.getstream.chat.android.client.models.Message.copy$default(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44)
            r3.add(r5)
            goto L_0x00d7
        L_0x012f:
            java.util.List r3 = (java.util.List) r3
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r4)
            int r1 = kotlin.collections.MapsKt.mapCapacity(r1)
            r4 = 16
            int r1 = kotlin.ranges.RangesKt.coerceAtLeast((int) r1, (int) r4)
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
            r4.<init>(r1)
            java.util.Map r4 = (java.util.Map) r4
            java.util.Iterator r1 = r3.iterator()
        L_0x014c:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0161
            java.lang.Object r3 = r1.next()
            r5 = r3
            io.getstream.chat.android.client.models.Message r5 = (p015io.getstream.chat.android.client.models.Message) r5
            java.lang.String r5 = r5.getId()
            r4.put(r5, r3)
            goto L_0x014c
        L_0x0161:
            java.util.Map r1 = kotlin.collections.MapsKt.plus(r2, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl.parseMessages(java.util.List):java.util.Map");
    }

    private final void upsertMessages(List<Message> list) {
        Map<String, Message> parseMessages = parseMessages(list);
        updateLastMessageAtByNewMessages(parseMessages.values());
        this._messages.setValue(parseMessages);
    }

    private final void updateLastMessageAtByNewMessages(Collection<Message> collection) {
        Comparable comparable;
        Date date;
        if (!collection.isEmpty()) {
            Collection arrayList = new ArrayList();
            for (Message message : collection) {
                Date createdAt = message.getCreatedAt();
                if (createdAt == null) {
                    createdAt = message.getCreatedLocallyAt();
                }
                if (createdAt != null) {
                    arrayList.add(createdAt);
                }
            }
            Iterator it = ((List) arrayList).iterator();
            if (!it.hasNext()) {
                comparable = null;
            } else {
                Comparable valueOf = Long.valueOf(((Date) it.next()).getTime());
                while (it.hasNext()) {
                    Comparable valueOf2 = Long.valueOf(((Date) it.next()).getTime());
                    if (valueOf.compareTo(valueOf2) < 0) {
                        valueOf = valueOf2;
                    }
                }
                comparable = valueOf;
            }
            Long l = (Long) comparable;
            if (l != null) {
                long longValue = l.longValue();
                MutableStateFlow<Date> mutableStateFlow = this.lastMessageAt;
                Date value = mutableStateFlow.getValue();
                if (value == null) {
                    date = new Date(longValue);
                } else {
                    date = new Date(Math.max(value.getTime(), longValue));
                }
                mutableStateFlow.setValue(date);
            }
        }
    }

    private final void upsertOldMessages(List<Message> list) {
        this._oldMessages.setValue(parseMessages(list));
    }

    private final void removeLocalMessage(Message message) {
        MutableStateFlow<Map<String, Message>> mutableStateFlow = this._messages;
        mutableStateFlow.setValue(MapsKt.minus(mutableStateFlow.getValue(), message.getId()));
    }

    public void clean() {
        Date date = new Date();
        if (this.lastStartTypingEvent != null) {
            long time = date.getTime();
            Date date2 = this.lastStartTypingEvent;
            Intrinsics.checkNotNull(date2);
            if (time - date2.getTime() > ((long) 5000)) {
                stopTyping(this.keystrokeParentMessageId);
            }
        }
        Map value = this._typing.getValue();
        boolean z = false;
        Calendar instance = Calendar.getInstance();
        instance.add(13, -15);
        Intrinsics.checkNotNullExpressionValue(instance, "calendar");
        Date time2 = instance.getTime();
        for (Pair pair : MapsKt.toList(value)) {
            String str = (String) pair.component1();
            if (((ChatEvent) pair.component2()).getCreatedAt().before(time2)) {
                value = MapsKt.minus(value, str);
                z = true;
            }
        }
        if (z) {
            this._typing.setValue(value);
        }
    }

    public final void setTyping(String str, ChatEvent chatEvent) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        Map mutableMap = MapsKt.toMutableMap(this._typing.getValue());
        if (chatEvent == null) {
            mutableMap.remove(str);
        } else {
            mutableMap.put(str, chatEvent);
        }
        mutableMap.remove(this.domainImpl.getCurrentUser().getId());
        this._typing.setValue(MapsKt.toMap(mutableMap));
    }

    private final void setHidden(boolean z) {
        this._hidden.setValue(Boolean.valueOf(z));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object handleEvents$stream_chat_android_offline_release(java.util.List<? extends p015io.getstream.chat.android.client.events.ChatEvent> r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$handleEvents$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$handleEvents$1 r0 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$handleEvents$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$handleEvents$1 r0 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$handleEvents$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r5 = r0.L$1
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r2 = r0.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r2 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0042
        L_0x0032:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r6)
            java.util.Iterator r5 = r5.iterator()
            r2 = r4
        L_0x0042:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x005b
            java.lang.Object r6 = r5.next()
            io.getstream.chat.android.client.events.ChatEvent r6 = (p015io.getstream.chat.android.client.events.ChatEvent) r6
            r0.L$0 = r2
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r2.handleEvent$stream_chat_android_offline_release(r6, r0)
            if (r6 != r1) goto L_0x0042
            return r1
        L_0x005b:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl.handleEvents$stream_chat_android_offline_release(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean isHidden() {
        return this._hidden.getValue().booleanValue();
    }

    public final Object handleEvent$stream_chat_android_offline_release(ChatEvent chatEvent, Continuation<? super Unit> continuation) {
        if (chatEvent instanceof NewMessageEvent) {
            NewMessageEvent newMessageEvent = (NewMessageEvent) chatEvent;
            upsertEventMessage(newMessageEvent.getMessage());
            incrementUnreadCountIfNecessary(newMessageEvent.getMessage());
            setHidden(false);
        } else if (chatEvent instanceof MessageUpdatedEvent) {
            upsertEventMessage(((MessageUpdatedEvent) chatEvent).getMessage());
            setHidden(false);
        } else if (chatEvent instanceof MessageDeletedEvent) {
            upsertEventMessage(((MessageDeletedEvent) chatEvent).getMessage());
            setHidden(false);
        } else if (chatEvent instanceof NotificationMessageNewEvent) {
            NotificationMessageNewEvent notificationMessageNewEvent = (NotificationMessageNewEvent) chatEvent;
            upsertEventMessage(notificationMessageNewEvent.getMessage());
            incrementUnreadCountIfNecessary(notificationMessageNewEvent.getMessage());
            setHidden(false);
            Integer watcherCount2 = notificationMessageNewEvent.getWatcherCount();
            if (watcherCount2 != null) {
                setWatcherCount(watcherCount2.intValue());
            }
        } else if (chatEvent instanceof ReactionNewEvent) {
            upsertMessage$stream_chat_android_offline_release(((ReactionNewEvent) chatEvent).getMessage());
        } else if (chatEvent instanceof ReactionUpdateEvent) {
            upsertMessage$stream_chat_android_offline_release(((ReactionUpdateEvent) chatEvent).getMessage());
        } else if (chatEvent instanceof ReactionDeletedEvent) {
            upsertMessage$stream_chat_android_offline_release(((ReactionDeletedEvent) chatEvent).getMessage());
        } else if (chatEvent instanceof MemberRemovedEvent) {
            deleteMember(((MemberRemovedEvent) chatEvent).getUser().getId());
        } else if (chatEvent instanceof MemberAddedEvent) {
            upsertMember(((MemberAddedEvent) chatEvent).getMember());
        } else if (chatEvent instanceof MemberUpdatedEvent) {
            upsertMember(((MemberUpdatedEvent) chatEvent).getMember());
        } else if (chatEvent instanceof NotificationAddedToChannelEvent) {
            upsertMembers(((NotificationAddedToChannelEvent) chatEvent).getChannel().getMembers());
        } else if (chatEvent instanceof UserPresenceChangedEvent) {
            upsertUserPresence(((UserPresenceChangedEvent) chatEvent).getUser());
        } else if (chatEvent instanceof UserUpdatedEvent) {
            upsertUser(((UserUpdatedEvent) chatEvent).getUser());
        } else if (chatEvent instanceof UserStartWatchingEvent) {
            UserStartWatchingEvent userStartWatchingEvent = (UserStartWatchingEvent) chatEvent;
            upsertWatcher(userStartWatchingEvent.getUser());
            setWatcherCount(userStartWatchingEvent.getWatcherCount());
        } else if (chatEvent instanceof UserStopWatchingEvent) {
            UserStopWatchingEvent userStopWatchingEvent = (UserStopWatchingEvent) chatEvent;
            deleteWatcher(userStopWatchingEvent.getUser());
            setWatcherCount(userStopWatchingEvent.getWatcherCount());
        } else if (chatEvent instanceof ChannelUpdatedEvent) {
            updateChannelData(((ChannelUpdatedEvent) chatEvent).getChannel());
        } else if (chatEvent instanceof ChannelUpdatedByUserEvent) {
            updateChannelData(((ChannelUpdatedByUserEvent) chatEvent).getChannel());
        } else if (chatEvent instanceof ChannelHiddenEvent) {
            setHidden(true);
        } else if (chatEvent instanceof ChannelVisibleEvent) {
            setHidden(false);
        } else if (chatEvent instanceof ChannelDeletedEvent) {
            removeMessagesBefore(chatEvent.getCreatedAt());
            ChannelData value = this._channelData.getValue();
            if (value != null) {
                value.setDeletedAt(chatEvent.getCreatedAt());
                this._channelData.setValue(value);
            }
        } else if ((chatEvent instanceof ChannelTruncatedEvent) || (chatEvent instanceof NotificationChannelTruncatedEvent)) {
            removeMessagesBefore(chatEvent.getCreatedAt());
        } else if (chatEvent instanceof TypingStopEvent) {
            setTyping(((TypingStopEvent) chatEvent).getUser().getId(), (ChatEvent) null);
        } else if (chatEvent instanceof TypingStartEvent) {
            setTyping(((TypingStartEvent) chatEvent).getUser().getId(), chatEvent);
        } else if (chatEvent instanceof MessageReadEvent) {
            updateRead(new ChannelUserRead(((MessageReadEvent) chatEvent).getUser(), chatEvent.getCreatedAt(), 0, 4, (DefaultConstructorMarker) null));
        } else if (chatEvent instanceof NotificationMarkReadEvent) {
            NotificationMarkReadEvent notificationMarkReadEvent = (NotificationMarkReadEvent) chatEvent;
            updateRead(new ChannelUserRead(notificationMarkReadEvent.getUser(), chatEvent.getCreatedAt(), 0, 4, (DefaultConstructorMarker) null));
            Integer watcherCount3 = notificationMarkReadEvent.getWatcherCount();
            if (watcherCount3 != null) {
                setWatcherCount(watcherCount3.intValue());
            }
        } else if (chatEvent instanceof MarkAllReadEvent) {
            updateRead(new ChannelUserRead(((MarkAllReadEvent) chatEvent).getUser(), chatEvent.getCreatedAt(), 0, 4, (DefaultConstructorMarker) null));
        }
        return Unit.INSTANCE;
    }

    private final void upsertUserPresence(User user) {
        String id = user.getId();
        Member member = (Member) this._members.getValue().get(id);
        User user2 = (User) this._watchers.getValue().get(id);
        if (member != null) {
            member.setUser(user);
            upsertMember(member);
        }
        if (user2 != null) {
            upsertWatcher(user);
        }
    }

    private final void upsertUser(User user) {
        upsertUserPresence(user);
        String id = user.getId();
        ChannelData value = this._channelData.getValue();
        if (value != null && Intrinsics.areEqual((Object) value.getCreatedBy().getId(), (Object) id)) {
            value.setCreatedBy(user);
        }
        List arrayList = new ArrayList();
        for (Message message : this._messages.getValue().values()) {
            boolean z = false;
            if (Intrinsics.areEqual((Object) message.getUser().getId(), (Object) id)) {
                message.setUser(user);
                z = true;
            }
            for (Reaction next : message.getOwnReactions()) {
                User user2 = next.getUser();
                Intrinsics.checkNotNull(user2);
                if (Intrinsics.areEqual((Object) user2.getId(), (Object) id)) {
                    next.setUser(user);
                    z = true;
                }
            }
            for (Reaction next2 : message.getLatestReactions()) {
                User user3 = next2.getUser();
                Intrinsics.checkNotNull(user3);
                if (Intrinsics.areEqual((Object) user3.getId(), (Object) id)) {
                    next2.setUser(user);
                    z = true;
                }
            }
            if (z) {
                arrayList.add(message);
            }
        }
        if (!arrayList.isEmpty()) {
            upsertMessages(arrayList);
        }
    }

    private final void deleteWatcher(User user) {
        MutableStateFlow<Map<String, User>> mutableStateFlow = this._watchers;
        mutableStateFlow.setValue(MapsKt.minus(mutableStateFlow.getValue(), user.getId()));
    }

    private final void upsertWatcher(User user) {
        MutableStateFlow<Map<String, User>> mutableStateFlow = this._watchers;
        mutableStateFlow.setValue(MapsKt.plus(mutableStateFlow.getValue(), (Map<String, User>) MapsKt.mapOf(TuplesKt.m181to(user.getId(), user))));
    }

    private final void deleteMember(String str) {
        MutableStateFlow<Map<String, Member>> mutableStateFlow = this._members;
        mutableStateFlow.setValue(MapsKt.minus(mutableStateFlow.getValue(), str));
    }

    public final void upsertMembers(List<Member> list) {
        Intrinsics.checkNotNullParameter(list, ModelFields.MEMBERS);
        MutableStateFlow<Map<String, Member>> mutableStateFlow = this._members;
        Map value = mutableStateFlow.getValue();
        Iterable iterable = list;
        Map linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object next : iterable) {
            linkedHashMap.put(((Member) next).getUser().getId(), next);
        }
        mutableStateFlow.setValue(MapsKt.plus(value, linkedHashMap));
    }

    public final void upsertMember(Member member) {
        Intrinsics.checkNotNullParameter(member, "member");
        upsertMembers(CollectionsKt.listOf(member));
    }

    private final void updateReads(List<ChannelUserRead> list) {
        Map value = this._reads.getValue();
        Iterable iterable = list;
        Map linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object next : iterable) {
            linkedHashMap.put(((ChannelUserRead) next).getUserId(), next);
        }
        Map mutableMap = MapsKt.toMutableMap(linkedHashMap);
        ChannelUserRead channelUserRead = (ChannelUserRead) mutableMap.get(this.domainImpl.getCurrentUser().getId());
        if (channelUserRead != null) {
            this._read.setValue(channelUserRead);
            this._unreadCount.setValue(Integer.valueOf(channelUserRead.getUnreadMessages()));
        }
        this._reads.setValue(MapsKt.plus(value, mutableMap));
    }

    private final void updateRead(ChannelUserRead channelUserRead) {
        updateReads(CollectionsKt.listOf(channelUserRead));
    }

    private final void updateLiveDataFromLocalChannel(Channel channel) {
        Boolean hidden2 = channel.getHidden();
        if (hidden2 != null) {
            setHidden(hidden2.booleanValue());
        }
        this.hideMessagesBefore = channel.getHiddenMessagesBefore();
        updateLiveDataFromChannel(channel);
    }

    private final void updateOldMessagesFromLocalChannel(Channel channel) {
        Boolean hidden2 = channel.getHidden();
        if (hidden2 != null) {
            setHidden(hidden2.booleanValue());
        }
        this.hideMessagesBefore = channel.getHiddenMessagesBefore();
        updateOldMessagesFromChannel(channel);
    }

    public final void updateLiveDataFromChannel(Channel channel) {
        Intrinsics.checkNotNullParameter(channel, com.appsflyer.share.Constants.URL_CAMPAIGN);
        updateChannelData(channel);
        setWatcherCount(channel.getWatcherCount());
        updateReads(channel.getRead());
        setMembers(channel.getMembers());
        setWatchers(channel.getWatchers());
        upsertMessages(channel.getMessages());
        this.lastMessageAt.setValue(channel.getLastMessageAt());
    }

    private final void updateOldMessagesFromChannel(Channel channel) {
        updateChannelData(channel);
        setWatcherCount(channel.getWatcherCount());
        updateReads(channel.getRead());
        setMembers(channel.getMembers());
        setWatchers(channel.getWatchers());
        upsertOldMessages(channel.getMessages());
    }

    private final void setMembers(List<Member> list) {
        MutableStateFlow<Map<String, Member>> mutableStateFlow = this._members;
        Map value = mutableStateFlow.getValue();
        Iterable iterable = list;
        Map linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object next : iterable) {
            linkedHashMap.put(((Member) next).getUserId(), next);
        }
        mutableStateFlow.setValue(MapsKt.plus(value, linkedHashMap));
    }

    private final void updateChannelData(Channel channel) {
        this._channelData.setValue(new ChannelData(channel));
    }

    private final void setWatchers(List<User> list) {
        MutableStateFlow<Map<String, User>> mutableStateFlow = this._watchers;
        Map value = mutableStateFlow.getValue();
        Iterable iterable = list;
        Map linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object next : iterable) {
            linkedHashMap.put(((User) next).getId(), next);
        }
        mutableStateFlow.setValue(MapsKt.plus(value, linkedHashMap));
    }

    private final void incrementUnreadCountIfNecessary(Message message) {
        String id = this.domainImpl.getCurrentUser().getId();
        if (ClientExtensionsKt.shouldIncrementUnreadCount(message, id)) {
            int intValue = this._unreadCount.getValue().intValue() + 1;
            this._unreadCount.setValue(Integer.valueOf(intValue));
            MutableStateFlow<ChannelUserRead> mutableStateFlow = this._read;
            ChannelUserRead value = mutableStateFlow.getValue();
            mutableStateFlow.setValue(value != null ? ChannelUserRead.copy$default(value, (User) null, (Date) null, intValue, 3, (Object) null) : null);
            MutableStateFlow<Map<String, ChannelUserRead>> mutableStateFlow2 = this._reads;
            Map<String, ChannelUserRead> value2 = mutableStateFlow2.getValue();
            ChannelUserRead channelUserRead = (ChannelUserRead) value2.get(id);
            if (channelUserRead != null) {
                channelUserRead.setUnreadMessages(intValue);
            }
            Unit unit = Unit.INSTANCE;
            mutableStateFlow2.setValue(value2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0103, code lost:
        if (r6.before(r5) != false) goto L_0x0105;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01a5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object editMessage(p015io.getstream.chat.android.client.models.Message r56, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<p015io.getstream.chat.android.client.models.Message>> r57) {
        /*
            r55 = this;
            r0 = r55
            r1 = r57
            boolean r2 = r1 instanceof p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$editMessage$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$editMessage$1 r2 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$editMessage$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$editMessage$1 r2 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$editMessage$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.label
            r10 = 5
            r11 = 4
            r12 = 3
            r13 = 2
            r4 = 1
            r14 = 0
            if (r3 == 0) goto L_0x0087
            if (r3 == r4) goto L_0x0074
            if (r3 == r13) goto L_0x005f
            if (r3 == r12) goto L_0x0051
            if (r3 == r11) goto L_0x0048
            if (r3 != r10) goto L_0x0040
            java.lang.Object r2 = r2.L$0
            io.getstream.chat.android.client.utils.Result r2 = (p015io.getstream.chat.android.client.utils.Result) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x022e
        L_0x0040:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0048:
            java.lang.Object r2 = r2.L$0
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x01e8
        L_0x0051:
            java.lang.Object r3 = r2.L$1
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
            java.lang.Object r4 = r2.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r4 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r4
            kotlin.ResultKt.throwOnFailure(r1)
            r10 = r3
            goto L_0x01a8
        L_0x005f:
            java.lang.Object r3 = r2.L$3
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            java.lang.Object r4 = r2.L$2
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            java.lang.Object r5 = r2.L$1
            io.getstream.chat.android.client.models.Message r5 = (p015io.getstream.chat.android.client.models.Message) r5
            java.lang.Object r6 = r2.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r6 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r6
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x016f
        L_0x0074:
            boolean r3 = r2.Z$0
            java.lang.Object r4 = r2.L$2
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            java.lang.Object r5 = r2.L$1
            io.getstream.chat.android.client.models.Message r5 = (p015io.getstream.chat.android.client.models.Message) r5
            java.lang.Object r6 = r2.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r6 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r6
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0146
        L_0x0087:
            kotlin.ResultKt.throwOnFailure(r1)
            io.getstream.chat.android.livedata.ChatDomainImpl r1 = r0.domainImpl
            boolean r1 = r1.isOnline()
            kotlin.jvm.internal.Ref$ObjectRef r15 = new kotlin.jvm.internal.Ref$ObjectRef
            r15.<init>()
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r51 = 0
            r52 = -1
            r53 = 7
            r54 = 0
            r16 = r56
            io.getstream.chat.android.client.models.Message r3 = p015io.getstream.chat.android.client.models.Message.copy$default(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54)
            r15.element = r3
            T r3 = r15.element
            io.getstream.chat.android.client.models.Message r3 = (p015io.getstream.chat.android.client.models.Message) r3
            java.util.Date r5 = new java.util.Date
            r5.<init>()
            java.util.Date r6 = r3.getUpdatedAt()
            if (r6 == 0) goto L_0x0105
            java.util.Date r6 = r3.getUpdatedAt()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            boolean r6 = r6.before(r5)
            if (r6 == 0) goto L_0x0108
        L_0x0105:
            r3.setUpdatedAt(r5)
        L_0x0108:
            T r3 = r15.element
            io.getstream.chat.android.client.models.Message r3 = (p015io.getstream.chat.android.client.models.Message) r3
            if (r1 != 0) goto L_0x0111
            io.getstream.chat.android.client.utils.SyncStatus r5 = p015io.getstream.chat.android.client.utils.SyncStatus.SYNC_NEEDED
            goto L_0x0113
        L_0x0111:
            io.getstream.chat.android.client.utils.SyncStatus r5 = p015io.getstream.chat.android.client.utils.SyncStatus.IN_PROGRESS
        L_0x0113:
            r3.setSyncStatus(r5)
            T r3 = r15.element
            io.getstream.chat.android.client.models.Message r3 = (p015io.getstream.chat.android.client.models.Message) r3
            r0.upsertMessage$stream_chat_android_offline_release(r3)
            io.getstream.chat.android.livedata.ChatDomainImpl r3 = r0.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r3 = r3.getRepos$stream_chat_android_offline_release()
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepository r3 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository) r3
            T r5 = r15.element
            io.getstream.chat.android.client.models.Message r5 = (p015io.getstream.chat.android.client.models.Message) r5
            r6 = 0
            r7 = 2
            r8 = 0
            r2.L$0 = r0
            r10 = r56
            r2.L$1 = r10
            r2.L$2 = r15
            r2.Z$0 = r1
            r2.label = r4
            r4 = r5
            r5 = r6
            r6 = r2
            java.lang.Object r3 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository.DefaultImpls.insertMessage$default(r3, r4, r5, r6, r7, r8)
            if (r3 != r9) goto L_0x0142
            return r9
        L_0x0142:
            r6 = r0
            r3 = r1
            r5 = r10
            r4 = r15
        L_0x0146:
            if (r3 == 0) goto L_0x0238
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$editMessage$runnable$1 r1 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$editMessage$runnable$1
            r1.<init>(r6, r4)
            r3 = r1
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            java.util.Map<java.lang.String, kotlinx.coroutines.Job> r1 = r6.editJobs
            java.lang.String r7 = r5.getId()
            java.lang.Object r1 = r1.get(r7)
            kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1
            if (r1 == 0) goto L_0x016f
            r2.L$0 = r6
            r2.L$1 = r5
            r2.L$2 = r4
            r2.L$3 = r3
            r2.label = r13
            java.lang.Object r1 = kotlinx.coroutines.JobKt.cancelAndJoin(r1, r2)
            if (r1 != r9) goto L_0x016f
            return r9
        L_0x016f:
            r1 = r4
            r4 = r6
            io.getstream.chat.android.livedata.ChatDomainImpl r6 = r4.domainImpl
            kotlinx.coroutines.CoroutineScope r15 = r6.getScope$stream_chat_android_offline_release()
            r16 = 0
            r17 = 0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$editMessage$job$1 r6 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$editMessage$job$1
            r6.<init>(r4, r3, r14)
            r18 = r6
            kotlin.jvm.functions.Function2 r18 = (kotlin.jvm.functions.Function2) r18
            r19 = 3
            r20 = 0
            kotlinx.coroutines.Deferred r3 = kotlinx.coroutines.BuildersKt__Builders_commonKt.async$default(r15, r16, r17, r18, r19, r20)
            java.util.Map<java.lang.String, kotlinx.coroutines.Job> r6 = r4.editJobs
            java.lang.String r5 = r5.getId()
            r6.put(r5, r3)
            r2.L$0 = r4
            r2.L$1 = r1
            r2.L$2 = r14
            r2.L$3 = r14
            r2.label = r12
            java.lang.Object r3 = r3.await(r2)
            if (r3 != r9) goto L_0x01a6
            return r9
        L_0x01a6:
            r10 = r1
            r1 = r3
        L_0x01a8:
            io.getstream.chat.android.client.utils.Result r1 = (p015io.getstream.chat.android.client.utils.Result) r1
            boolean r3 = r1.isSuccess()
            if (r3 == 0) goto L_0x01f2
            java.lang.Object r1 = r1.data()
            io.getstream.chat.android.client.models.Message r1 = (p015io.getstream.chat.android.client.models.Message) r1
            r10.element = r1
            T r1 = r10.element
            io.getstream.chat.android.client.models.Message r1 = (p015io.getstream.chat.android.client.models.Message) r1
            io.getstream.chat.android.client.utils.SyncStatus r3 = p015io.getstream.chat.android.client.utils.SyncStatus.COMPLETED
            r1.setSyncStatus(r3)
            T r1 = r10.element
            io.getstream.chat.android.client.models.Message r1 = (p015io.getstream.chat.android.client.models.Message) r1
            r4.upsertMessage$stream_chat_android_offline_release(r1)
            io.getstream.chat.android.livedata.ChatDomainImpl r1 = r4.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r1 = r1.getRepos$stream_chat_android_offline_release()
            r3 = r1
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepository r3 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository) r3
            T r1 = r10.element
            r4 = r1
            io.getstream.chat.android.client.models.Message r4 = (p015io.getstream.chat.android.client.models.Message) r4
            r5 = 0
            r7 = 2
            r8 = 0
            r2.L$0 = r10
            r2.L$1 = r14
            r2.label = r11
            r6 = r2
            java.lang.Object r1 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository.DefaultImpls.insertMessage$default(r3, r4, r5, r6, r7, r8)
            if (r1 != r9) goto L_0x01e7
            return r9
        L_0x01e7:
            r2 = r10
        L_0x01e8:
            io.getstream.chat.android.client.utils.Result r1 = new io.getstream.chat.android.client.utils.Result
            T r2 = r2.element
            io.getstream.chat.android.client.models.Message r2 = (p015io.getstream.chat.android.client.models.Message) r2
            r1.<init>(r2)
            return r1
        L_0x01f2:
            T r3 = r10.element
            io.getstream.chat.android.client.models.Message r3 = (p015io.getstream.chat.android.client.models.Message) r3
            io.getstream.chat.android.client.errors.ChatError r5 = r1.error()
            boolean r5 = p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.isPermanent(r5)
            if (r5 == 0) goto L_0x0203
            io.getstream.chat.android.client.utils.SyncStatus r5 = p015io.getstream.chat.android.client.utils.SyncStatus.FAILED_PERMANENTLY
            goto L_0x0205
        L_0x0203:
            io.getstream.chat.android.client.utils.SyncStatus r5 = p015io.getstream.chat.android.client.utils.SyncStatus.SYNC_NEEDED
        L_0x0205:
            r3.setSyncStatus(r5)
            T r3 = r10.element
            io.getstream.chat.android.client.models.Message r3 = (p015io.getstream.chat.android.client.models.Message) r3
            r4.upsertMessage$stream_chat_android_offline_release(r3)
            io.getstream.chat.android.livedata.ChatDomainImpl r3 = r4.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r3 = r3.getRepos$stream_chat_android_offline_release()
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepository r3 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository) r3
            T r4 = r10.element
            io.getstream.chat.android.client.models.Message r4 = (p015io.getstream.chat.android.client.models.Message) r4
            r5 = 0
            r7 = 2
            r8 = 0
            r2.L$0 = r1
            r2.L$1 = r14
            r6 = 5
            r2.label = r6
            r6 = r2
            java.lang.Object r2 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository.DefaultImpls.insertMessage$default(r3, r4, r5, r6, r7, r8)
            if (r2 != r9) goto L_0x022d
            return r9
        L_0x022d:
            r2 = r1
        L_0x022e:
            io.getstream.chat.android.client.utils.Result r1 = new io.getstream.chat.android.client.utils.Result
            io.getstream.chat.android.client.errors.ChatError r2 = r2.error()
            r1.<init>((p015io.getstream.chat.android.client.errors.ChatError) r2)
            return r1
        L_0x0238:
            io.getstream.chat.android.client.utils.Result r1 = new io.getstream.chat.android.client.utils.Result
            T r2 = r4.element
            io.getstream.chat.android.client.models.Message r2 = (p015io.getstream.chat.android.client.models.Message) r2
            r1.<init>(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl.editMessage(io.getstream.chat.android.client.models.Message, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object deleteMessage(p015io.getstream.chat.android.client.models.Message r13, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<p015io.getstream.chat.android.client.models.Message>> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$deleteMessage$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$deleteMessage$1 r0 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$deleteMessage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$deleteMessage$1 r0 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$deleteMessage$1
            r0.<init>(r12, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r8 = 4
            r9 = 3
            r10 = 2
            r2 = 1
            if (r1 == 0) goto L_0x0065
            if (r1 == r2) goto L_0x0057
            if (r1 == r10) goto L_0x0049
            if (r1 == r9) goto L_0x0040
            if (r1 != r8) goto L_0x0038
            java.lang.Object r13 = r0.L$0
            io.getstream.chat.android.client.utils.Result r13 = (p015io.getstream.chat.android.client.utils.Result) r13
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0124
        L_0x0038:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0040:
            java.lang.Object r13 = r0.L$0
            io.getstream.chat.android.client.utils.Result r13 = (p015io.getstream.chat.android.client.utils.Result) r13
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00ea
        L_0x0049:
            java.lang.Object r13 = r0.L$1
            io.getstream.chat.android.client.models.Message r13 = (p015io.getstream.chat.android.client.models.Message) r13
            java.lang.Object r1 = r0.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r1 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r1
            kotlin.ResultKt.throwOnFailure(r14)
            r2 = r13
            goto L_0x00bd
        L_0x0057:
            boolean r13 = r0.Z$0
            java.lang.Object r1 = r0.L$1
            io.getstream.chat.android.client.models.Message r1 = (p015io.getstream.chat.android.client.models.Message) r1
            java.lang.Object r2 = r0.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r2 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r2
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00a2
        L_0x0065:
            kotlin.ResultKt.throwOnFailure(r14)
            io.getstream.chat.android.livedata.ChatDomainImpl r14 = r12.domainImpl
            boolean r14 = r14.isOnline()
            java.util.Date r1 = new java.util.Date
            r1.<init>()
            r13.setDeletedAt(r1)
            if (r14 != 0) goto L_0x007b
            io.getstream.chat.android.client.utils.SyncStatus r1 = p015io.getstream.chat.android.client.utils.SyncStatus.SYNC_NEEDED
            goto L_0x007d
        L_0x007b:
            io.getstream.chat.android.client.utils.SyncStatus r1 = p015io.getstream.chat.android.client.utils.SyncStatus.IN_PROGRESS
        L_0x007d:
            r13.setSyncStatus(r1)
            r12.upsertMessage$stream_chat_android_offline_release(r13)
            io.getstream.chat.android.livedata.ChatDomainImpl r1 = r12.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r1 = r1.getRepos$stream_chat_android_offline_release()
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepository r1 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository) r1
            r3 = 0
            r5 = 2
            r6 = 0
            r0.L$0 = r12
            r0.L$1 = r13
            r0.Z$0 = r14
            r0.label = r2
            r2 = r13
            r4 = r0
            java.lang.Object r1 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository.DefaultImpls.insertMessage$default(r1, r2, r3, r4, r5, r6)
            if (r1 != r7) goto L_0x009f
            return r7
        L_0x009f:
            r2 = r12
            r1 = r13
            r13 = r14
        L_0x00a2:
            if (r13 == 0) goto L_0x012e
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$deleteMessage$runnable$1 r13 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$deleteMessage$runnable$1
            r13.<init>(r2, r1)
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            io.getstream.chat.android.livedata.ChatDomainImpl r14 = r2.domainImpl
            r0.L$0 = r2
            r0.L$1 = r1
            r0.label = r10
            java.lang.Object r14 = r14.runAndRetry(r13, r0)
            if (r14 != r7) goto L_0x00ba
            return r7
        L_0x00ba:
            r11 = r2
            r2 = r1
            r1 = r11
        L_0x00bd:
            r13 = r14
            io.getstream.chat.android.client.utils.Result r13 = (p015io.getstream.chat.android.client.utils.Result) r13
            boolean r14 = r13.isSuccess()
            r3 = 0
            if (r14 == 0) goto L_0x00f4
            io.getstream.chat.android.client.utils.SyncStatus r14 = p015io.getstream.chat.android.client.utils.SyncStatus.COMPLETED
            r2.setSyncStatus(r14)
            r1.upsertMessage$stream_chat_android_offline_release(r2)
            io.getstream.chat.android.livedata.ChatDomainImpl r14 = r1.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r14 = r14.getRepos$stream_chat_android_offline_release()
            r1 = r14
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepository r1 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository) r1
            r14 = 0
            r5 = 2
            r6 = 0
            r0.L$0 = r13
            r0.L$1 = r3
            r0.label = r9
            r3 = r14
            r4 = r0
            java.lang.Object r14 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository.DefaultImpls.insertMessage$default(r1, r2, r3, r4, r5, r6)
            if (r14 != r7) goto L_0x00ea
            return r7
        L_0x00ea:
            io.getstream.chat.android.client.utils.Result r14 = new io.getstream.chat.android.client.utils.Result
            java.lang.Object r13 = r13.data()
            r14.<init>(r13)
            return r14
        L_0x00f4:
            io.getstream.chat.android.client.errors.ChatError r14 = r13.error()
            boolean r14 = p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.isPermanent(r14)
            if (r14 == 0) goto L_0x0101
            io.getstream.chat.android.client.utils.SyncStatus r14 = p015io.getstream.chat.android.client.utils.SyncStatus.FAILED_PERMANENTLY
            goto L_0x0103
        L_0x0101:
            io.getstream.chat.android.client.utils.SyncStatus r14 = p015io.getstream.chat.android.client.utils.SyncStatus.SYNC_NEEDED
        L_0x0103:
            r2.setSyncStatus(r14)
            r1.upsertMessage$stream_chat_android_offline_release(r2)
            io.getstream.chat.android.livedata.ChatDomainImpl r14 = r1.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r14 = r14.getRepos$stream_chat_android_offline_release()
            r1 = r14
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepository r1 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository) r1
            r14 = 0
            r5 = 2
            r6 = 0
            r0.L$0 = r13
            r0.L$1 = r3
            r0.label = r8
            r3 = r14
            r4 = r0
            java.lang.Object r14 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository.DefaultImpls.insertMessage$default(r1, r2, r3, r4, r5, r6)
            if (r14 != r7) goto L_0x0124
            return r7
        L_0x0124:
            io.getstream.chat.android.client.utils.Result r14 = new io.getstream.chat.android.client.utils.Result
            io.getstream.chat.android.client.errors.ChatError r13 = r13.error()
            r14.<init>((p015io.getstream.chat.android.client.errors.ChatError) r13)
            return r14
        L_0x012e:
            io.getstream.chat.android.client.utils.Result r13 = new io.getstream.chat.android.client.utils.Result
            r13.<init>(r1)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl.deleteMessage(io.getstream.chat.android.client.models.Message, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Channel toChannel() {
        ChannelData value = this._channelData.getValue();
        if (value == null) {
            value = new ChannelData(getChannelType(), getChannelId(), (String) null, (User) null, 0, false, (Date) null, (Date) null, (Date) null, 0, (Map) null, 2044, (DefaultConstructorMarker) null);
        }
        ChannelData channelData2 = value;
        List<Message> sortedMessages = sortedMessages();
        List<Message> list = sortedMessages;
        Channel channel$stream_chat_android_offline_release = channelData2.toChannel$stream_chat_android_offline_release(list, CollectionsKt.toList(this._members.getValue().values()), CollectionsKt.toList(this._reads.getValue().values()), CollectionsKt.toList(this._watchers.getValue().values()), this._watcherCount.getValue().intValue());
        channel$stream_chat_android_offline_release.setConfig(getConfig());
        channel$stream_chat_android_offline_release.setUnreadCount(this._unreadCount.getValue());
        Date value2 = this.lastMessageAt.getValue();
        if (value2 == null) {
            Message message = (Message) CollectionsKt.lastOrNull(sortedMessages);
            if (message != null) {
                value2 = message.getCreatedAt();
                if (value2 == null) {
                    value2 = message.getCreatedLocallyAt();
                }
            } else {
                value2 = null;
            }
        }
        channel$stream_chat_android_offline_release.setLastMessageAt(value2);
        channel$stream_chat_android_offline_release.setHidden(this._hidden.getValue());
        return channel$stream_chat_android_offline_release;
    }

    /* renamed from: loadOlderThreadMessages$stream_chat_android_offline_release$default */
    public static /* synthetic */ Result m1014xa2950f30(ChannelControllerImpl channelControllerImpl, String str, int i, Message message, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            message = null;
        }
        return channelControllerImpl.loadOlderThreadMessages$stream_chat_android_offline_release(str, i, message);
    }

    public final Result<List<Message>> loadOlderThreadMessages$stream_chat_android_offline_release(String str, int i, Message message) {
        Result<List<Message>> result;
        Intrinsics.checkNotNullParameter(str, "threadId");
        if (message != null) {
            result = this.client.getRepliesMore(str, message.getId(), i).execute();
        } else {
            result = this.client.getReplies(str, i).execute();
        }
        if (result.isSuccess()) {
            upsertMessages(result.data());
        }
        return result;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00cb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object loadMessageById$stream_chat_android_offline_release(java.lang.String r9, int r10, int r11, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<p015io.getstream.chat.android.client.models.Message>> r12) {
        /*
            r8 = this;
            boolean r0 = r12 instanceof p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$loadMessageById$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$loadMessageById$1 r0 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl$loadMessageById$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl$loadMessageById$1 r0 = new io.getstream.chat.android.livedata.controller.ChannelControllerImpl$loadMessageById$1
            r0.<init>(r8, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 1
            r5 = 2
            r6 = 0
            if (r2 == 0) goto L_0x0060
            if (r2 == r4) goto L_0x0050
            if (r2 == r5) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r9 = r0.L$0
            io.getstream.chat.android.client.models.Message r9 = (p015io.getstream.chat.android.client.models.Message) r9
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00cd
        L_0x0036:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003e:
            int r9 = r0.I$0
            java.lang.Object r10 = r0.L$2
            io.getstream.chat.android.client.models.Message r10 = (p015io.getstream.chat.android.client.models.Message) r10
            java.lang.Object r11 = r0.L$1
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r2 = r0.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r2 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r2
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00bd
        L_0x0050:
            int r11 = r0.I$1
            int r10 = r0.I$0
            java.lang.Object r9 = r0.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r2 = r0.L$0
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r2 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r2
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x007b
        L_0x0060:
            kotlin.ResultKt.throwOnFailure(r12)
            io.getstream.chat.android.client.ChatClient r12 = r8.client
            io.getstream.chat.android.client.call.Call r12 = r12.getMessage(r9)
            r0.L$0 = r8
            r0.L$1 = r9
            r0.I$0 = r10
            r0.I$1 = r11
            r0.label = r4
            java.lang.Object r12 = p015io.getstream.chat.android.client.call.CallKt.await(r12, r0)
            if (r12 != r1) goto L_0x007a
            return r1
        L_0x007a:
            r2 = r8
        L_0x007b:
            io.getstream.chat.android.client.utils.Result r12 = (p015io.getstream.chat.android.client.utils.Result) r12
            boolean r4 = r12.isError()
            if (r4 == 0) goto L_0x009f
            io.getstream.chat.android.client.utils.Result r10 = new io.getstream.chat.android.client.utils.Result
            io.getstream.chat.android.client.errors.ChatError r11 = new io.getstream.chat.android.client.errors.ChatError
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "Error while fetching message from backend. Message id: "
            r12.append(r0)
            r12.append(r9)
            java.lang.String r9 = r12.toString()
            r11.<init>(r9, r6, r5, r6)
            r10.<init>((p015io.getstream.chat.android.client.errors.ChatError) r11)
            return r10
        L_0x009f:
            java.lang.Object r12 = r12.data()
            io.getstream.chat.android.client.models.Message r12 = (p015io.getstream.chat.android.client.models.Message) r12
            r2.upsertMessage$stream_chat_android_offline_release(r12)
            r0.L$0 = r2
            r0.L$1 = r9
            r0.L$2 = r12
            r0.I$0 = r11
            r0.label = r5
            java.lang.Object r10 = r2.loadOlderMessages(r9, r10, r0)
            if (r10 != r1) goto L_0x00b9
            return r1
        L_0x00b9:
            r10 = r12
            r7 = r11
            r11 = r9
            r9 = r7
        L_0x00bd:
            r0.L$0 = r10
            r0.L$1 = r6
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r9 = r2.loadNewerMessages(r11, r9, r0)
            if (r9 != r1) goto L_0x00cc
            return r1
        L_0x00cc:
            r9 = r10
        L_0x00cd:
            io.getstream.chat.android.client.utils.Result r10 = new io.getstream.chat.android.client.utils.Result
            r10.<init>(r9)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl.loadMessageById$stream_chat_android_offline_release(java.lang.String, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void replyMessage$stream_chat_android_offline_release(Message message) {
        this._repliedMessage.setValue(message);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/controller/ChannelControllerImpl$Companion;", "", "()V", "COMMAND_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "TYPE_FILE", "", "TYPE_IMAGE", "TYPE_VIDEO", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.livedata.controller.ChannelControllerImpl$Companion */
    /* compiled from: ChannelControllerImpl.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
