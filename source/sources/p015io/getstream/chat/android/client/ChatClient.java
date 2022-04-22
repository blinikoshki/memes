package p015io.getstream.chat.android.client;

import android.content.Context;
import android.util.Base64;
import androidx.lifecycle.LifecycleOwner;
import androidx.work.WorkRequest;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.RemoteMessage;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.ClassUtils;
import p015io.getstream.chat.android.client.api.ChatApi;
import p015io.getstream.chat.android.client.api.ChatClientConfig;
import p015io.getstream.chat.android.client.api.models.QueryChannelRequest;
import p015io.getstream.chat.android.client.api.models.QueryChannelsRequest;
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.client.api.models.QueryUsersRequest;
import p015io.getstream.chat.android.client.api.models.SearchMessagesRequest;
import p015io.getstream.chat.android.client.api.models.SendActionRequest;
import p015io.getstream.chat.android.client.api.models.UpdateChannelRequest;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.call.CallKt;
import p015io.getstream.chat.android.client.channel.ChannelClient;
import p015io.getstream.chat.android.client.clientstate.ClientState;
import p015io.getstream.chat.android.client.clientstate.ClientStateService;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.events.ChatEvent;
import p015io.getstream.chat.android.client.events.ConnectedEvent;
import p015io.getstream.chat.android.client.events.DisconnectedEvent;
import p015io.getstream.chat.android.client.extensions.RemoteMessageExtensionsKt;
import p015io.getstream.chat.android.client.helpers.QueryChannelsPostponeHelper;
import p015io.getstream.chat.android.client.logger.ChatLogLevel;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.ChatLoggerHandler;
import p015io.getstream.chat.android.client.logger.TaggedLogger;
import p015io.getstream.chat.android.client.models.Attachment;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.ConnectionData;
import p015io.getstream.chat.android.client.models.Device;
import p015io.getstream.chat.android.client.models.Filters;
import p015io.getstream.chat.android.client.models.Flag;
import p015io.getstream.chat.android.client.models.GuestUser;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.ModelFields;
import p015io.getstream.chat.android.client.models.Mute;
import p015io.getstream.chat.android.client.models.Reaction;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.notifications.ChatNotifications;
import p015io.getstream.chat.android.client.notifications.handler.ChatNotificationHandler;
import p015io.getstream.chat.android.client.notifications.handler.NotificationConfig;
import p015io.getstream.chat.android.client.p049di.ChatModule;
import p015io.getstream.chat.android.client.socket.ChatSocket;
import p015io.getstream.chat.android.client.socket.InitConnectionListener;
import p015io.getstream.chat.android.client.socket.SocketListener;
import p015io.getstream.chat.android.client.token.TokenManager;
import p015io.getstream.chat.android.client.token.TokenManagerImpl;
import p015io.getstream.chat.android.client.token.TokenProvider;
import p015io.getstream.chat.android.client.uploader.FileUploader;
import p015io.getstream.chat.android.client.utils.FilterObject;
import p015io.getstream.chat.android.client.utils.ImmediateTokenProvider;
import p015io.getstream.chat.android.client.utils.ProgressCallback;
import p015io.getstream.chat.android.client.utils.observable.ChatEventsObservable;
import p015io.getstream.chat.android.client.utils.observable.ChatObservable;
import p015io.getstream.chat.android.client.utils.observable.Disposable;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 ó\u00012\u00020\u0001:\u0004ò\u0001ó\u0001B;\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ(\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\b\u00100\u001a\u0004\u0018\u00010.H\u0007J\u0016\u00101\u001a\b\u0012\u0004\u0012\u00020\u00170+2\u0006\u00102\u001a\u00020.H\u0007J,\u00103\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\f\u00104\u001a\b\u0012\u0004\u0012\u00020.05H\u0007J\u000e\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u000208J?\u00109\u001a\b\u0012\u0004\u0012\u00020\u00170+2\u0006\u0010:\u001a\u00020.2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\b\u0010;\u001a\u0004\u0018\u00010.2\b\u0010<\u001a\u0004\u0018\u00010=H\u0007¢\u0006\u0002\u0010>J!\u0010?\u001a\u00020\u00172\b\u0010@\u001a\u0004\u0018\u00010A2\b\u0010B\u001a\u0004\u0018\u00010CH\u0000¢\u0006\u0002\bDJ\u000e\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020.J\u0016\u0010E\u001a\u00020F2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.J\u000e\u0010H\u001a\b\u0012\u0004\u0012\u00020I0+H\u0007J\u001e\u0010J\u001a\b\u0012\u0004\u0012\u00020I0+2\u0006\u0010K\u001a\u00020.2\u0006\u0010L\u001a\u00020.H\u0007J\u001e\u0010M\u001a\b\u0012\u0004\u0012\u00020I0+2\u0006\u0010N\u001a\u00020\u00162\u0006\u0010O\u001a\u00020PH\u0007J\u001e\u0010M\u001a\b\u0012\u0004\u0012\u00020I0+2\u0006\u0010N\u001a\u00020\u00162\u0006\u0010Q\u001a\u00020.H\u0007J,\u0010R\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\f\u00104\u001a\b\u0012\u0004\u0012\u00020.05H\u0007J@\u0010R\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\f\u00104\u001a\b\u0012\u0004\u0012\u00020.052\u0012\u0010S\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00010TH\u0007J2\u0010R\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0012\u0010S\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00010TH\u0007J$\u0010R\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001a\u00020.2\f\u00104\u001a\b\u0012\u0004\u0012\u00020.05H\u0007J8\u0010R\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001a\u00020.2\f\u00104\u001a\b\u0012\u0004\u0012\u00020.052\u0012\u0010S\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00010TH\u0007J1\u0010U\u001a\b\u0012\u0004\u0012\u00020I0+2!\u0010V\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\bW\u0012\b\bX\u0012\u0004\b\b(Y\u0012\u0004\u0012\u00020\u00170\u0015H\u0002J\u001e\u0010Z\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0007J\u0016\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00170+2\u0006\u00102\u001a\u00020.H\u0007J&\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00170+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u0010]\u001a\u00020.H\u0007J&\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00170+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u0010]\u001a\u00020.H\u0007J\u0016\u0010_\u001a\b\u0012\u0004\u0012\u00020`0+2\u0006\u0010a\u001a\u00020.H\u0007J\u001e\u0010b\u001a\b\u0012\u0004\u0012\u00020`0+2\u0006\u0010a\u001a\u00020.2\u0006\u0010c\u001a\u00020.H\u0007J\u000e\u0010d\u001a\u00020.2\u0006\u0010K\u001a\u00020.J\u001e\u0010e\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0007J\u0006\u0010f\u001a\u00020\u0017J\u0006\u0010g\u001a\u00020\u0017J&\u0010h\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u0010i\u001a\u00020=H\u0007J\u0012\u0010j\u001a\u00020k2\b\u00107\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010l\u001a\u00020mH\u0007J\u0016\u0010n\u001a\b\u0012\u0004\u0012\u00020o0+2\u0006\u0010K\u001a\u00020.H\u0007J\u0016\u0010p\u001a\b\u0012\u0004\u0012\u00020o0+2\u0006\u0010a\u001a\u00020.H\u0007J\u0016\u0010q\u001a\b\u0012\u0004\u0012\u00020o0+2\u0006\u0010K\u001a\u00020.H\u0007J<\u0010r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020s050+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u0010t\u001a\u00020=2\u0006\u0010u\u001a\u00020=2\u0006\u0010v\u001a\u00020.H\u0003J\b\u0010w\u001a\u0004\u0018\u00010.J\b\u0010x\u001a\u0004\u0018\u00010.J\b\u0010y\u001a\u0004\u0018\u00010\u0016J\u0014\u0010z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020{050+H\u0007J4\u0010|\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020s050+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u0010t\u001a\u00020=2\u0006\u0010u\u001a\u00020=H\u0007J\u001e\u0010}\u001a\b\u0012\u0004\u0012\u00020~0+2\u0006\u0010K\u001a\u00020.2\u0006\u0010\u001a\u00020.H\u0007J5\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020s050+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u0010t\u001a\u00020=2\u0006\u0010u\u001a\u00020=H\u0007J\u0017\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020`0+2\u0006\u0010a\u001a\u00020.H\u0007J=\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020`050+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u0010t\u001a\u00020=2\u0006\u0010u\u001a\u00020=2\u0006\u0010v\u001a\u00020.H\u0007J.\u0010\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0001050+2\u0006\u0010a\u001a\u00020.2\u0006\u0010t\u001a\u00020=2\u0006\u0010u\u001a\u00020=H\u0007J%\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020`050+2\u0006\u0010a\u001a\u00020.2\u0006\u0010u\u001a\u00020=H\u0007J.\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020`050+2\u0006\u0010a\u001a\u00020.2\u0007\u0010\u0001\u001a\u00020.2\u0006\u0010u\u001a\u00020=H\u0007J/\u0010\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0001050+2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020.052\b\u0010\u0001\u001a\u00030\u0001H\u0007J\u0019\u0010\u0001\u001a\u00020\u00172\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00170\u0001H\u0002J\u0007\u0010\u0001\u001a\u00020.J*\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\t\b\u0002\u0010\u0001\u001a\u00020kH\u0007J\u0019\u0010\u0001\u001a\u00020\u00172\u0006\u0010N\u001a\u00020\u00162\u0006\u0010O\u001a\u00020PH\u0002J\u0007\u0010\u0001\u001a\u00020kJ\t\u0010\u0001\u001a\u00020kH\u0002J\u0013\u0010\u0001\u001a\u00020k2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u000f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170+H\u0007J'\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u0010a\u001a\u00020.H\u0007J\u001f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0007J\u001f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0007J\u0010\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010+H\u0007J\u0018\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010+2\u0006\u0010K\u001a\u00020.H\u0007J\u0011\u0010 \u0001\u001a\u00020\u00172\u0006\u0010N\u001a\u00020\u0016H\u0002J\u0011\u0010¡\u0001\u001a\u00020\u00172\b\u0010\u0001\u001a\u00030\u0001J\u000f\u0010¢\u0001\u001a\u00020\u00172\u0006\u0010Q\u001a\u00020.J#\u0010£\u0001\u001a\b\u0012\u0004\u0012\u00020`0+2\u0006\u00100\u001a\u00020`2\n\u0010¤\u0001\u001a\u0005\u0018\u00010\u0001H\u0007J\u001f\u0010£\u0001\u001a\b\u0012\u0004\u0012\u00020`0+2\u0006\u00100\u001a\u00020`2\u0006\u0010<\u001a\u00020=H\u0007J)\u0010¥\u0001\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\b\u0010¦\u0001\u001a\u00030§\u0001H\u0007J\u001f\u0010¨\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,050+2\b\u0010¦\u0001\u001a\u00030©\u0001H\u0007J`\u0010ª\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030«\u0001050+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u0010t\u001a\u00020=2\u0006\u0010u\u001a\u00020=2\b\u0010¬\u0001\u001a\u00030­\u00012\u000f\u0010®\u0001\u001a\n\u0012\u0005\u0012\u00030«\u00010¯\u00012\r\u00104\u001a\t\u0012\u0005\u0012\u00030«\u000105H\u0007J\u001f\u0010°\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0016050+2\b\u0010±\u0001\u001a\u00030²\u0001H\u0007J\u0007\u0010³\u0001\u001a\u00020\u0017J\u001f\u0010´\u0001\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0007J-\u0010µ\u0001\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\f\u00104\u001a\b\u0012\u0004\u0012\u00020.05H\u0007J'\u0010¶\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170+2\u0006\u0010:\u001a\u00020.2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0007J\u000f\u0010·\u0001\u001a\u00020\u00172\u0006\u00107\u001a\u000208J\u001f\u0010¸\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020`050+2\b\u0010¦\u0001\u001a\u00030¹\u0001H\u0007J\u0019\u0010º\u0001\u001a\b\u0012\u0004\u0012\u00020`0+2\b\u0010¦\u0001\u001a\u00030»\u0001H\u0007J?\u0010¼\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010+2\u0007\u0010½\u0001\u001a\u00020.2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0014\b\u0002\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010TH\u0007J7\u0010¾\u0001\u001a\b\u0012\u0004\u0012\u00020.0+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\b\u0010¿\u0001\u001a\u00030À\u00012\f\b\u0002\u0010Á\u0001\u001a\u0005\u0018\u00010Â\u0001H\u0007J7\u0010Ã\u0001\u001a\b\u0012\u0004\u0012\u00020.0+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\b\u0010¿\u0001\u001a\u00030À\u00012\f\b\u0002\u0010Á\u0001\u001a\u0005\u0018\u00010Â\u0001H\u0007J'\u0010Ä\u0001\u001a\b\u0012\u0004\u0012\u00020`0+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020`H\u0007J%\u0010Å\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010+2\b\u0010Æ\u0001\u001a\u00030\u00012\t\b\u0002\u0010Ç\u0001\u001a\u00020kH\u0007J+\u0010Å\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010+2\u0006\u0010a\u001a\u00020.2\u0006\u0010c\u001a\u00020.2\t\b\u0002\u0010Ç\u0001\u001a\u00020kH\u0007J\u0015\u0010È\u0001\u001a\u00020\u00172\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0012H\u0007J%\u0010É\u0001\u001a\u00020\u00172\u0006\u0010K\u001a\u00020.2\u0006\u0010L\u001a\u00020.2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0012H\u0007J%\u0010Ê\u0001\u001a\u00020\u00172\u0006\u0010N\u001a\u00020\u00162\u0006\u0010O\u001a\u00020P2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0012H\u0007J%\u0010Ê\u0001\u001a\u00020\u00172\u0006\u0010N\u001a\u00020\u00162\u0006\u0010Q\u001a\u00020.2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0012H\u0007J\u001a\u0010Ë\u0001\u001a\u00020\u00172\u0006\u0010N\u001a\u00020\u00162\u0007\u0010Ì\u0001\u001a\u00020.H\u0007J@\u0010Í\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170+2\u0006\u0010:\u001a\u00020.2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\b\u0010;\u001a\u0004\u0018\u00010.2\b\u0010<\u001a\u0004\u0018\u00010=H\u0007¢\u0006\u0002\u0010>J\u001f\u0010Î\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0007J\u001f\u0010Ï\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0007J/\u0010Ð\u0001\u001a\u00030Ñ\u00012#\u00107\u001a\u001f\u0012\u0015\u0012\u00130\u0001¢\u0006\r\bW\u0012\t\bX\u0012\u0005\b\b(Ò\u0001\u0012\u0004\u0012\u00020\u00170\u0015H\u0007J\u0018\u0010Ð\u0001\u001a\u00030Ñ\u00012\u000e\u00107\u001a\n\u0012\u0005\u0012\u00030\u00010Ó\u0001Ji\u0010Ô\u0001\u001a\u00030Ñ\u00012\b\u0010Õ\u0001\u001a\u00030Ö\u00012(\u0010×\u0001\u001a\u0015\u0012\u0010\b\u0001\u0012\f\u0012\u0007\b\u0001\u0012\u00030\u00010Ù\u00010Ø\u0001\"\f\u0012\u0007\b\u0001\u0012\u00030\u00010Ù\u00012#\u00107\u001a\u001f\u0012\u0015\u0012\u00130\u0001¢\u0006\r\bW\u0012\t\bX\u0012\u0005\b\b(Ò\u0001\u0012\u0004\u0012\u00020\u00170\u0015H\u0007¢\u0006\u0003\u0010Ú\u0001JR\u0010Ô\u0001\u001a\u00030Ñ\u00012\b\u0010Õ\u0001\u001a\u00030Ö\u00012(\u0010×\u0001\u001a\u0015\u0012\u0010\b\u0001\u0012\f\u0012\u0007\b\u0001\u0012\u00030\u00010Ù\u00010Ø\u0001\"\f\u0012\u0007\b\u0001\u0012\u00030\u00010Ù\u00012\u000e\u00107\u001a\n\u0012\u0005\u0012\u00030\u00010Ó\u0001¢\u0006\u0003\u0010Û\u0001JU\u0010Ô\u0001\u001a\u00030Ñ\u00012\b\u0010Õ\u0001\u001a\u00030Ö\u00012\u0014\u0010×\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020.0Ø\u0001\"\u00020.2#\u00107\u001a\u001f\u0012\u0015\u0012\u00130\u0001¢\u0006\r\bW\u0012\t\bX\u0012\u0005\b\b(Ò\u0001\u0012\u0004\u0012\u00020\u00170\u0015H\u0007¢\u0006\u0003\u0010Ü\u0001J>\u0010Ô\u0001\u001a\u00030Ñ\u00012\b\u0010Õ\u0001\u001a\u00030Ö\u00012\u0014\u0010×\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020.0Ø\u0001\"\u00020.2\u000e\u00107\u001a\n\u0012\u0005\u0012\u00030\u00010Ó\u0001¢\u0006\u0003\u0010Ý\u0001J_\u0010Ô\u0001\u001a\u00030Ñ\u00012(\u0010×\u0001\u001a\u0015\u0012\u0010\b\u0001\u0012\f\u0012\u0007\b\u0001\u0012\u00030\u00010Ù\u00010Ø\u0001\"\f\u0012\u0007\b\u0001\u0012\u00030\u00010Ù\u00012#\u00107\u001a\u001f\u0012\u0015\u0012\u00130\u0001¢\u0006\r\bW\u0012\t\bX\u0012\u0005\b\b(Ò\u0001\u0012\u0004\u0012\u00020\u00170\u0015H\u0007¢\u0006\u0003\u0010Þ\u0001JH\u0010Ô\u0001\u001a\u00030Ñ\u00012(\u0010×\u0001\u001a\u0015\u0012\u0010\b\u0001\u0012\f\u0012\u0007\b\u0001\u0012\u00030\u00010Ù\u00010Ø\u0001\"\f\u0012\u0007\b\u0001\u0012\u00030\u00010Ù\u00012\u000e\u00107\u001a\n\u0012\u0005\u0012\u00030\u00010Ó\u0001¢\u0006\u0003\u0010ß\u0001JK\u0010Ô\u0001\u001a\u00030Ñ\u00012\u0014\u0010×\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020.0Ø\u0001\"\u00020.2#\u00107\u001a\u001f\u0012\u0015\u0012\u00130\u0001¢\u0006\r\bW\u0012\t\bX\u0012\u0005\b\b(Ò\u0001\u0012\u0004\u0012\u00020\u00170\u0015H\u0007¢\u0006\u0003\u0010à\u0001J4\u0010Ô\u0001\u001a\u00030Ñ\u00012\u0014\u0010×\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020.0Ø\u0001\"\u00020.2\u000e\u00107\u001a\n\u0012\u0005\u0012\u00030\u00010Ó\u0001¢\u0006\u0003\u0010á\u0001JL\u0010â\u0001\u001a\u00030Ñ\u0001\"\n\b\u0000\u0010ã\u0001*\u00030\u00012\u000f\u0010½\u0001\u001a\n\u0012\u0005\u0012\u0003Hã\u00010Ù\u00012#\u00107\u001a\u001f\u0012\u0015\u0012\u0013Hã\u0001¢\u0006\r\bW\u0012\t\bX\u0012\u0005\b\b(Ò\u0001\u0012\u0004\u0012\u00020\u00170\u0015H\u0007J5\u0010â\u0001\u001a\u00030Ñ\u0001\"\n\b\u0000\u0010ã\u0001*\u00030\u00012\u000f\u0010½\u0001\u001a\n\u0012\u0005\u0012\u0003Hã\u00010Ù\u00012\u000e\u00107\u001a\n\u0012\u0005\u0012\u0003Hã\u00010Ó\u0001J8\u0010â\u0001\u001a\u00030Ñ\u00012\u0007\u0010½\u0001\u001a\u00020.2#\u00107\u001a\u001f\u0012\u0015\u0012\u00130\u0001¢\u0006\r\bW\u0012\t\bX\u0012\u0005\b\b(Ò\u0001\u0012\u0004\u0012\u00020\u00170\u0015H\u0007J!\u0010â\u0001\u001a\u00030Ñ\u00012\u0007\u0010½\u0001\u001a\u00020.2\u000e\u00107\u001a\n\u0012\u0005\u0012\u00030\u00010Ó\u0001J \u0010ä\u0001\u001a\b\u0012\u0004\u0012\u00020`0+2\u0006\u0010a\u001a\u00020.2\u0007\u0010å\u0001\u001a\u00020.H\u0007J'\u0010æ\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170+2\u0006\u0010:\u001a\u00020.2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0007J\u001f\u0010ç\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0007J\u000f\u0010è\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170+H\u0007J\u0017\u0010é\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170+2\u0006\u0010K\u001a\u00020.H\u0007J\u0017\u0010ê\u0001\u001a\b\u0012\u0004\u0012\u00020`0+2\u0006\u00100\u001a\u00020`H\u0007JA\u0010ë\u0001\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\t\u0010ì\u0001\u001a\u0004\u0018\u00010`2\u0015\b\u0002\u0010í\u0001\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00010TH\u0007J\u0017\u0010ì\u0001\u001a\b\u0012\u0004\u0012\u00020`0+2\u0006\u00100\u001a\u00020`H\u0007J\u0017\u0010î\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160+2\u0006\u0010N\u001a\u00020\u0016H\u0007J$\u0010ï\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0016050+2\r\u0010ð\u0001\u001a\b\u0012\u0004\u0012\u00020\u001605H\u0007J\t\u0010ñ\u0001\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R%\u0010\u0013\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u00170\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u00020!8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R#\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006ô\u0001"}, mo26107d2 = {"Lio/getstream/chat/android/client/ChatClient;", "", "config", "Lio/getstream/chat/android/client/api/ChatClientConfig;", "api", "Lio/getstream/chat/android/client/api/ChatApi;", "socket", "Lio/getstream/chat/android/client/socket/ChatSocket;", "notifications", "Lio/getstream/chat/android/client/notifications/ChatNotifications;", "tokenManager", "Lio/getstream/chat/android/client/token/TokenManager;", "clientStateService", "Lio/getstream/chat/android/client/clientstate/ClientStateService;", "(Lio/getstream/chat/android/client/api/ChatClientConfig;Lio/getstream/chat/android/client/api/ChatApi;Lio/getstream/chat/android/client/socket/ChatSocket;Lio/getstream/chat/android/client/notifications/ChatNotifications;Lio/getstream/chat/android/client/token/TokenManager;Lio/getstream/chat/android/client/clientstate/ClientStateService;)V", "getConfig", "()Lio/getstream/chat/android/client/api/ChatClientConfig;", "connectionListener", "Lio/getstream/chat/android/client/socket/InitConnectionListener;", "disconnectListeners", "", "Lkotlin/Function1;", "Lio/getstream/chat/android/client/models/User;", "", "getDisconnectListeners", "()Ljava/util/List;", "eventsObservable", "Lio/getstream/chat/android/client/utils/observable/ChatEventsObservable;", "lifecycleObserver", "Lio/getstream/chat/android/client/StreamLifecycleObserver;", "logger", "Lio/getstream/chat/android/client/logger/TaggedLogger;", "notificationHandler", "Lio/getstream/chat/android/client/notifications/handler/ChatNotificationHandler;", "getNotificationHandler$annotations", "()V", "getNotificationHandler", "()Lio/getstream/chat/android/client/notifications/handler/ChatNotificationHandler;", "preSetUserListeners", "getPreSetUserListeners", "queryChannelsPostponeHelper", "Lio/getstream/chat/android/client/helpers/QueryChannelsPostponeHelper;", "acceptInvite", "Lio/getstream/chat/android/client/call/Call;", "Lio/getstream/chat/android/client/models/Channel;", "channelType", "", "channelId", "message", "addDevice", "deviceId", "addMembers", "members", "", "addSocketListener", "listener", "Lio/getstream/chat/android/client/socket/SocketListener;", "banUser", "targetId", "reason", "timeout", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lio/getstream/chat/android/client/call/Call;", "callConnectionListener", "connectedEvent", "Lio/getstream/chat/android/client/events/ConnectedEvent;", "error", "Lio/getstream/chat/android/client/errors/ChatError;", "callConnectionListener$stream_chat_android_client_release", "channel", "Lio/getstream/chat/android/client/channel/ChannelClient;", "cid", "connectAnonymousUser", "Lio/getstream/chat/android/client/models/ConnectionData;", "connectGuestUser", "userId", "username", "connectUser", "user", "tokenProvider", "Lio/getstream/chat/android/client/token/TokenProvider;", "token", "createChannel", "extraData", "", "createInitListenerCall", "performCall", "Lkotlin/ParameterName;", "name", "initListener", "deleteChannel", "deleteDevice", "deleteFile", "url", "deleteImage", "deleteMessage", "Lio/getstream/chat/android/client/models/Message;", "messageId", "deleteReaction", "reactionType", "devToken", "disableSlowMode", "disconnect", "disconnectSocket", "enableSlowMode", "cooldownTimeInSeconds", "ensureUserNotSet", "", "events", "Lio/getstream/chat/android/client/utils/observable/ChatObservable;", "flag", "Lio/getstream/chat/android/client/models/Flag;", "flagMessage", "flagUser", "getAttachments", "Lio/getstream/chat/android/client/models/Attachment;", "offset", "limit", "type", "getConnectionId", "getCurrentToken", "getCurrentUser", "getDevices", "Lio/getstream/chat/android/client/models/Device;", "getFileAttachments", "getGuestToken", "Lio/getstream/chat/android/client/models/GuestUser;", "userName", "getImageAttachments", "getMessage", "getMessagesWithAttachments", "getReactions", "Lio/getstream/chat/android/client/models/Reaction;", "getReplies", "getRepliesMore", "firstId", "getSyncHistory", "Lio/getstream/chat/android/client/events/ChatEvent;", "channelsIds", "lastSyncAt", "Ljava/util/Date;", "getTokenAndConnect", "connect", "Lkotlin/Function0;", "getVersion", "hideChannel", "clearHistory", "initializeClientWithUser", "isSocketConnected", "isUserSet", "isValidRemoteMessage", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "markAllRead", "markMessageRead", "markRead", "muteChannel", "muteCurrentUser", "Lio/getstream/chat/android/client/models/Mute;", "muteUser", "notifySetUser", "onMessageReceived", "onNewTokenReceived", "pinMessage", "expirationDate", "queryChannel", "request", "Lio/getstream/chat/android/client/api/models/QueryChannelRequest;", "queryChannels", "Lio/getstream/chat/android/client/api/models/QueryChannelsRequest;", "queryMembers", "Lio/getstream/chat/android/client/models/Member;", "filter", "Lio/getstream/chat/android/client/utils/FilterObject;", "sort", "Lio/getstream/chat/android/client/api/models/QuerySort;", "queryUsers", "query", "Lio/getstream/chat/android/client/api/models/QueryUsersRequest;", "reconnectSocket", "rejectInvite", "removeMembers", "removeShadowBan", "removeSocketListener", "searchMessages", "Lio/getstream/chat/android/client/api/models/SearchMessagesRequest;", "sendAction", "Lio/getstream/chat/android/client/api/models/SendActionRequest;", "sendEvent", "eventType", "sendFile", "file", "Ljava/io/File;", "callback", "Lio/getstream/chat/android/client/utils/ProgressCallback;", "sendImage", "sendMessage", "sendReaction", "reaction", "enforceUnique", "setAnonymousUser", "setGuestUser", "setUser", "setUserWithoutConnecting", "userToken", "shadowBanUser", "showChannel", "stopWatching", "subscribe", "Lio/getstream/chat/android/client/utils/observable/Disposable;", "event", "Lio/getstream/chat/android/client/ChatEventListener;", "subscribeFor", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "eventTypes", "", "Ljava/lang/Class;", "(Landroidx/lifecycle/LifecycleOwner;[Ljava/lang/Class;Lkotlin/jvm/functions/Function1;)Lio/getstream/chat/android/client/utils/observable/Disposable;", "(Landroidx/lifecycle/LifecycleOwner;[Ljava/lang/Class;Lio/getstream/chat/android/client/ChatEventListener;)Lio/getstream/chat/android/client/utils/observable/Disposable;", "(Landroidx/lifecycle/LifecycleOwner;[Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lio/getstream/chat/android/client/utils/observable/Disposable;", "(Landroidx/lifecycle/LifecycleOwner;[Ljava/lang/String;Lio/getstream/chat/android/client/ChatEventListener;)Lio/getstream/chat/android/client/utils/observable/Disposable;", "([Ljava/lang/Class;Lkotlin/jvm/functions/Function1;)Lio/getstream/chat/android/client/utils/observable/Disposable;", "([Ljava/lang/Class;Lio/getstream/chat/android/client/ChatEventListener;)Lio/getstream/chat/android/client/utils/observable/Disposable;", "([Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lio/getstream/chat/android/client/utils/observable/Disposable;", "([Ljava/lang/String;Lio/getstream/chat/android/client/ChatEventListener;)Lio/getstream/chat/android/client/utils/observable/Disposable;", "subscribeForSingle", "T", "translate", "language", "unBanUser", "unMuteChannel", "unmuteCurrentUser", "unmuteUser", "unpinMessage", "updateChannel", "updateMessage", "channelExtraData", "updateUser", "updateUsers", "users", "warmUp", "Builder", "Companion", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.ChatClient */
/* compiled from: ChatClient.kt */
public final class ChatClient {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final QuerySort<Member> DEFAULT_SORT = new QuerySort().desc("last_updated", Reflection.getOrCreateKotlinClass(Member.class));
    private static final String VERSION_PREFIX = "stream-chat-android-";
    /* access modifiers changed from: private */
    public static ChatClient instance;
    /* access modifiers changed from: private */
    public final ChatApi api;
    /* access modifiers changed from: private */
    public final ClientStateService clientStateService;
    private final ChatClientConfig config;
    private InitConnectionListener connectionListener;
    private final List<Function1<User, Unit>> disconnectListeners;
    private final ChatEventsObservable eventsObservable;
    /* access modifiers changed from: private */
    public final StreamLifecycleObserver lifecycleObserver;
    private final TaggedLogger logger;
    private final ChatNotificationHandler notificationHandler;
    /* access modifiers changed from: private */
    public final ChatNotifications notifications;
    private final List<Function1<User, Unit>> preSetUserListeners;
    private final QueryChannelsPostponeHelper queryChannelsPostponeHelper;
    /* access modifiers changed from: private */
    public final ChatSocket socket;
    private final TokenManager tokenManager;

    @InternalStreamChatApi
    public static /* synthetic */ void getNotificationHandler$annotations() {
    }

    @JvmStatic
    public static final ChatClient instance() {
        return Companion.instance();
    }

    public final String getVersion() {
        return "stream-chat-android-4.6.0";
    }

    public final Call<Reaction> sendReaction(Reaction reaction) {
        return sendReaction$default(this, reaction, false, 2, (Object) null);
    }

    public final Call<Reaction> sendReaction(String str, String str2) {
        return sendReaction$default(this, str, str2, false, 4, (Object) null);
    }

    public ChatClient(ChatClientConfig chatClientConfig, ChatApi chatApi, ChatSocket chatSocket, ChatNotifications chatNotifications, TokenManager tokenManager2, ClientStateService clientStateService2) {
        Intrinsics.checkNotNullParameter(chatClientConfig, "config");
        Intrinsics.checkNotNullParameter(chatApi, "api");
        Intrinsics.checkNotNullParameter(chatSocket, "socket");
        Intrinsics.checkNotNullParameter(chatNotifications, "notifications");
        Intrinsics.checkNotNullParameter(tokenManager2, "tokenManager");
        Intrinsics.checkNotNullParameter(clientStateService2, "clientStateService");
        this.config = chatClientConfig;
        this.api = chatApi;
        this.socket = chatSocket;
        this.notifications = chatNotifications;
        this.tokenManager = tokenManager2;
        this.clientStateService = clientStateService2;
        this.queryChannelsPostponeHelper = new QueryChannelsPostponeHelper(chatApi, clientStateService2, 0, 0, 12, (DefaultConstructorMarker) null);
        this.notificationHandler = chatNotifications.getHandler();
        TaggedLogger taggedLogger = ChatLogger.Companion.get("Client");
        this.logger = taggedLogger;
        ChatEventsObservable chatEventsObservable = new ChatEventsObservable(chatSocket, this);
        this.eventsObservable = chatEventsObservable;
        this.lifecycleObserver = new StreamLifecycleObserver(new ChatClient$lifecycleObserver$1(this));
        this.disconnectListeners = new ArrayList();
        this.preSetUserListeners = new ArrayList();
        ChatEventsObservable.subscribe$default(chatEventsObservable, (Function1) null, new ChatEventListener<ChatEvent>(this) {
            final /* synthetic */ ChatClient this$0;

            {
                this.this$0 = r1;
            }

            public final void onEvent(ChatEvent chatEvent) {
                Intrinsics.checkNotNullParameter(chatEvent, "event");
                this.this$0.notifications.onChatEvent(chatEvent);
                if (chatEvent instanceof ConnectedEvent) {
                    ConnectedEvent connectedEvent = (ConnectedEvent) chatEvent;
                    User me = connectedEvent.getMe();
                    String connectionId = connectedEvent.getConnectionId();
                    this.this$0.clientStateService.onConnected(me, connectionId);
                    this.this$0.api.setConnection(me.getId(), connectionId);
                    this.this$0.lifecycleObserver.observe();
                } else if (chatEvent instanceof DisconnectedEvent) {
                    this.this$0.clientStateService.onDisconnected();
                }
            }
        }, 1, (Object) null);
        taggedLogger.logI("Initialised: " + getVersion());
    }

    public final ChatClientConfig getConfig() {
        return this.config;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChatClient(ChatClientConfig chatClientConfig, ChatApi chatApi, ChatSocket chatSocket, ChatNotifications chatNotifications, TokenManager tokenManager2, ClientStateService clientStateService2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(chatClientConfig, chatApi, chatSocket, chatNotifications, (i & 16) != 0 ? new TokenManagerImpl() : tokenManager2, (i & 32) != 0 ? new ClientStateService() : clientStateService2);
    }

    public final ChatNotificationHandler getNotificationHandler() {
        return this.notificationHandler;
    }

    public final List<Function1<User, Unit>> getDisconnectListeners() {
        return this.disconnectListeners;
    }

    public final List<Function1<User, Unit>> getPreSetUserListeners() {
        return this.preSetUserListeners;
    }

    private final Call<ConnectionData> createInitListenerCall(Function1<? super InitConnectionListener, Unit> function1) {
        return new ChatClient$createInitListenerCall$1(function1);
    }

    public static /* synthetic */ void setUser$default(ChatClient chatClient, User user, String str, InitConnectionListener initConnectionListener, int i, Object obj) {
        if ((i & 4) != 0) {
            initConnectionListener = null;
        }
        chatClient.setUser(user, str, initConnectionListener);
    }

    @Deprecated(message = "Use connectUser instead", replaceWith = @ReplaceWith(expression = "this.connectUser(user, token).enqueue { result -> TODO(\"Handle result\") })", imports = {}))
    public final void setUser(User user, String str, InitConnectionListener initConnectionListener) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(str, "token");
        setUser(user, (TokenProvider) new ImmediateTokenProvider(str), initConnectionListener);
    }

    public final Call<ConnectionData> connectUser(User user, String str) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(str, "token");
        return connectUser(user, (TokenProvider) new ImmediateTokenProvider(str));
    }

    public static /* synthetic */ void setUser$default(ChatClient chatClient, User user, TokenProvider tokenProvider, InitConnectionListener initConnectionListener, int i, Object obj) {
        if ((i & 4) != 0) {
            initConnectionListener = null;
        }
        chatClient.setUser(user, tokenProvider, initConnectionListener);
    }

    @Deprecated(message = "Use connectUser instead", replaceWith = @ReplaceWith(expression = "this.connectUser(user, tokenProvider).enqueue { result -> TODO(\"Handle result\") })", imports = {}))
    public final void setUser(User user, TokenProvider tokenProvider, InitConnectionListener initConnectionListener) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(tokenProvider, "tokenProvider");
        if (ensureUserNotSet(initConnectionListener)) {
            initializeClientWithUser(user, tokenProvider);
            this.connectionListener = initConnectionListener;
            getTokenAndConnect(new ChatClient$setUser$1(this, user));
        }
    }

    private final void initializeClientWithUser(User user, TokenProvider tokenProvider) {
        this.clientStateService.onSetUser(user);
        notifySetUser(user);
        this.config.setAnonymous(false);
        this.tokenManager.setTokenProvider(tokenProvider);
        warmUp();
        this.notifications.onSetUser();
    }

    public final Call<ConnectionData> connectUser(User user, TokenProvider tokenProvider) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(tokenProvider, "tokenProvider");
        return createInitListenerCall(new ChatClient$connectUser$1(this, user, tokenProvider));
    }

    @InternalStreamChatApi
    public final void setUserWithoutConnecting(User user, String str) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(str, "userToken");
        if (!isUserSet()) {
            initializeClientWithUser(user, new ImmediateTokenProvider(str));
        }
    }

    /* access modifiers changed from: private */
    public final void notifySetUser(User user) {
        for (Function1 invoke : this.preSetUserListeners) {
            invoke.invoke(user);
        }
    }

    public static /* synthetic */ void setAnonymousUser$default(ChatClient chatClient, InitConnectionListener initConnectionListener, int i, Object obj) {
        if ((i & 1) != 0) {
            initConnectionListener = null;
        }
        chatClient.setAnonymousUser(initConnectionListener);
    }

    @Deprecated(message = "Use connectAnonymousUser instead", replaceWith = @ReplaceWith(expression = "this.connectAnonymousUser().enqueue { result -> TODO(\"Handle result\") })", imports = {}))
    public final void setAnonymousUser(InitConnectionListener initConnectionListener) {
        this.clientStateService.onSetAnonymousUser();
        this.connectionListener = new ChatClient$setAnonymousUser$1(this, initConnectionListener);
        this.config.setAnonymous(true);
        warmUp();
        getTokenAndConnect(new ChatClient$setAnonymousUser$2(this));
    }

    public final Call<ConnectionData> connectAnonymousUser() {
        return createInitListenerCall(new ChatClient$connectAnonymousUser$1(this));
    }

    public static /* synthetic */ void setGuestUser$default(ChatClient chatClient, String str, String str2, InitConnectionListener initConnectionListener, int i, Object obj) {
        if ((i & 4) != 0) {
            initConnectionListener = null;
        }
        chatClient.setGuestUser(str, str2, initConnectionListener);
    }

    @Deprecated(message = "Use connectGuestUser instead", replaceWith = @ReplaceWith(expression = "this.connectGuestUser(userId, username).enqueue { result -> TODO(\"Handle result\") })", imports = {}))
    public final void setGuestUser(String str, String str2, InitConnectionListener initConnectionListener) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "username");
        getGuestToken(str, str2).enqueue(new ChatClient$setGuestUser$1(this, initConnectionListener));
    }

    public final Call<ConnectionData> connectGuestUser(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "username");
        return createInitListenerCall(new ChatClient$connectGuestUser$1(this, str, str2));
    }

    public final Call<GuestUser> getGuestToken(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        Intrinsics.checkNotNullParameter(str2, TagPeopleActivity.USER_NAME);
        return this.api.getGuestUser(str, str2);
    }

    public static /* synthetic */ Call sendFile$default(ChatClient chatClient, String str, String str2, File file, ProgressCallback progressCallback, int i, Object obj) {
        if ((i & 8) != 0) {
            progressCallback = null;
        }
        return chatClient.sendFile(str, str2, file, progressCallback);
    }

    public final Call<String> sendFile(String str, String str2, File file, ProgressCallback progressCallback) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(file, "file");
        return this.api.sendFile(str, str2, file, progressCallback);
    }

    public static /* synthetic */ Call sendImage$default(ChatClient chatClient, String str, String str2, File file, ProgressCallback progressCallback, int i, Object obj) {
        if ((i & 8) != 0) {
            progressCallback = null;
        }
        return chatClient.sendImage(str, str2, file, progressCallback);
    }

    public final Call<String> sendImage(String str, String str2, File file, ProgressCallback progressCallback) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(file, "file");
        return this.api.sendImage(str, str2, file, progressCallback);
    }

    public final Call<List<Member>> queryMembers(String str, String str2, int i, int i2, FilterObject filterObject, QuerySort<Member> querySort, List<Member> list) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(filterObject, "filter");
        Intrinsics.checkNotNullParameter(querySort, "sort");
        List<Member> list2 = list;
        Intrinsics.checkNotNullParameter(list2, ModelFields.MEMBERS);
        return this.api.queryMembers(str, str2, i, i2, filterObject, querySort, list2);
    }

    public final Call<Unit> deleteFile(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, "url");
        return this.api.deleteFile(str, str2, str3);
    }

    public final Call<Unit> deleteImage(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, "url");
        return this.api.deleteImage(str, str2, str3);
    }

    public final Call<List<Reaction>> getReactions(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        return this.api.getReactions(str, i, i2);
    }

    public static /* synthetic */ Call sendReaction$default(ChatClient chatClient, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return chatClient.sendReaction(str, str2, z);
    }

    public final Call<Reaction> sendReaction(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        Intrinsics.checkNotNullParameter(str2, "reactionType");
        return this.api.sendReaction(str, str2, z);
    }

    public final Call<Message> deleteReaction(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        Intrinsics.checkNotNullParameter(str2, "reactionType");
        return this.api.deleteReaction(str, str2);
    }

    public static /* synthetic */ Call sendReaction$default(ChatClient chatClient, Reaction reaction, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return chatClient.sendReaction(reaction, z);
    }

    public final Call<Reaction> sendReaction(Reaction reaction, boolean z) {
        Intrinsics.checkNotNullParameter(reaction, "reaction");
        return this.api.sendReaction(reaction, z);
    }

    public final void disconnectSocket() {
        this.socket.disconnect();
    }

    public final void reconnectSocket() {
        ClientState state$stream_chat_android_client_release = this.clientStateService.getState$stream_chat_android_client_release();
        if (state$stream_chat_android_client_release instanceof ClientState.Anonymous) {
            this.socket.connectAnonymously();
            Unit unit = Unit.INSTANCE;
        } else if (state$stream_chat_android_client_release instanceof ClientState.User) {
            this.socket.connect(((ClientState.User) state$stream_chat_android_client_release).getUser());
            Unit unit2 = Unit.INSTANCE;
        } else if (state$stream_chat_android_client_release instanceof ClientState.Idle) {
            Unit unit3 = Unit.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void addSocketListener(SocketListener socketListener) {
        Intrinsics.checkNotNullParameter(socketListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.socket.addListener(socketListener);
    }

    public final void removeSocketListener(SocketListener socketListener) {
        Intrinsics.checkNotNullParameter(socketListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.socket.removeListener(socketListener);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use subscribe() on the client directly instead")
    public final ChatObservable events() {
        return this.socket.events();
    }

    @Deprecated(message = "Use subscribe with ChatEventListener parameter")
    public final Disposable subscribe(Function1<? super ChatEvent, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return ChatEventsObservable.subscribe$default(this.eventsObservable, (Function1) null, new C4938xecfd389(function1), 1, (Object) null);
    }

    public final Disposable subscribe(ChatEventListener<ChatEvent> chatEventListener) {
        Intrinsics.checkNotNullParameter(chatEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return ChatEventsObservable.subscribe$default(this.eventsObservable, (Function1) null, chatEventListener, 1, (Object) null);
    }

    @Deprecated(message = "Use subscribeFor with ChatEventListener parameter")
    public final Disposable subscribeFor(String[] strArr, Function1<? super ChatEvent, Unit> function1) {
        Intrinsics.checkNotNullParameter(strArr, "eventTypes");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return this.eventsObservable.subscribe(new ChatClient$subscribeFor$filter$1(strArr), new C4938xecfd389(function1));
    }

    public final Disposable subscribeFor(String[] strArr, ChatEventListener<ChatEvent> chatEventListener) {
        Intrinsics.checkNotNullParameter(strArr, "eventTypes");
        Intrinsics.checkNotNullParameter(chatEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return this.eventsObservable.subscribe(new ChatClient$subscribeFor$filter$2(strArr), chatEventListener);
    }

    @Deprecated(message = "Use subscribeFor with ChatEventListener parameter")
    public final Disposable subscribeFor(LifecycleOwner lifecycleOwner, String[] strArr, Function1<? super ChatEvent, Unit> function1) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(strArr, "eventTypes");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Disposable subscribeFor = subscribeFor((String[]) Arrays.copyOf(strArr, strArr.length), (ChatEventListener<ChatEvent>) new ChatClient$subscribeFor$disposable$1(lifecycleOwner, function1));
        lifecycleOwner.getLifecycle().addObserver(new ChatClient$subscribeFor$1(subscribeFor));
        return subscribeFor;
    }

    public final Disposable subscribeFor(LifecycleOwner lifecycleOwner, String[] strArr, ChatEventListener<ChatEvent> chatEventListener) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(strArr, "eventTypes");
        Intrinsics.checkNotNullParameter(chatEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Disposable subscribeFor = subscribeFor((String[]) Arrays.copyOf(strArr, strArr.length), (ChatEventListener<ChatEvent>) new ChatClient$subscribeFor$disposable$2(lifecycleOwner, chatEventListener));
        lifecycleOwner.getLifecycle().addObserver(new ChatClient$subscribeFor$2(subscribeFor));
        return subscribeFor;
    }

    @Deprecated(message = "Use subscribeFor with ChatEventListener parameter")
    public final Disposable subscribeFor(Class<? extends ChatEvent>[] clsArr, Function1<? super ChatEvent, Unit> function1) {
        Intrinsics.checkNotNullParameter(clsArr, "eventTypes");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return this.eventsObservable.subscribe(new ChatClient$subscribeFor$filter$3(clsArr), new C4938xecfd389(function1));
    }

    public final Disposable subscribeFor(Class<? extends ChatEvent>[] clsArr, ChatEventListener<ChatEvent> chatEventListener) {
        Intrinsics.checkNotNullParameter(clsArr, "eventTypes");
        Intrinsics.checkNotNullParameter(chatEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return this.eventsObservable.subscribe(new ChatClient$subscribeFor$filter$4(clsArr), chatEventListener);
    }

    @Deprecated(message = "Use subscribeFor with ChatEventListener parameter")
    public final Disposable subscribeFor(LifecycleOwner lifecycleOwner, Class<? extends ChatEvent>[] clsArr, Function1<? super ChatEvent, Unit> function1) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(clsArr, "eventTypes");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Disposable subscribeFor = subscribeFor((Class<? extends ChatEvent>[]) (Class[]) Arrays.copyOf(clsArr, clsArr.length), (ChatEventListener<ChatEvent>) new ChatClient$subscribeFor$disposable$3(lifecycleOwner, function1));
        lifecycleOwner.getLifecycle().addObserver(new ChatClient$subscribeFor$3(subscribeFor));
        return subscribeFor;
    }

    public final Disposable subscribeFor(LifecycleOwner lifecycleOwner, Class<? extends ChatEvent>[] clsArr, ChatEventListener<ChatEvent> chatEventListener) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(clsArr, "eventTypes");
        Intrinsics.checkNotNullParameter(chatEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Disposable subscribeFor = subscribeFor((Class<? extends ChatEvent>[]) (Class[]) Arrays.copyOf(clsArr, clsArr.length), (ChatEventListener<ChatEvent>) new ChatClient$subscribeFor$disposable$4(lifecycleOwner, chatEventListener));
        lifecycleOwner.getLifecycle().addObserver(new ChatClient$subscribeFor$4(subscribeFor));
        return subscribeFor;
    }

    @Deprecated(message = "Use subscribeForSingle with ChatEventListener parameter")
    public final Disposable subscribeForSingle(String str, Function1<? super ChatEvent, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "eventType");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return this.eventsObservable.subscribeSingle(new ChatClient$subscribeForSingle$filter$1(str), new C4938xecfd389(function1));
    }

    public final Disposable subscribeForSingle(String str, ChatEventListener<ChatEvent> chatEventListener) {
        Intrinsics.checkNotNullParameter(str, "eventType");
        Intrinsics.checkNotNullParameter(chatEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return this.eventsObservable.subscribeSingle(new ChatClient$subscribeForSingle$filter$2(str), chatEventListener);
    }

    @Deprecated(message = "Use subscribeForSingle with ChatEventListener parameter")
    public final <T extends ChatEvent> Disposable subscribeForSingle(Class<T> cls, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(cls, "eventType");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return this.eventsObservable.subscribeSingle(new ChatClient$subscribeForSingle$filter$3(cls), new ChatClient$subscribeForSingle$1(function1));
    }

    public final <T extends ChatEvent> Disposable subscribeForSingle(Class<T> cls, ChatEventListener<T> chatEventListener) {
        Intrinsics.checkNotNullParameter(cls, "eventType");
        Intrinsics.checkNotNullParameter(chatEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return this.eventsObservable.subscribeSingle(new ChatClient$subscribeForSingle$filter$4(cls), new ChatClient$subscribeForSingle$2(chatEventListener));
    }

    public final void disconnect() {
        try {
            Result.Companion companion = Result.Companion;
            ChatClient chatClient = this;
            User userOrError$stream_chat_android_client_release = chatClient.clientStateService.getState$stream_chat_android_client_release().userOrError$stream_chat_android_client_release();
            for (Function1 invoke : chatClient.disconnectListeners) {
                invoke.invoke(userOrError$stream_chat_android_client_release);
            }
            Result.m1029constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m1029constructorimpl(ResultKt.createFailure(th));
        }
        this.connectionListener = null;
        this.clientStateService.onDisconnectRequested();
        this.socket.disconnect();
    }

    public final Call<List<Device>> getDevices() {
        return this.api.getDevices();
    }

    public final Call<Unit> deleteDevice(String str) {
        Intrinsics.checkNotNullParameter(str, "deviceId");
        return this.api.deleteDevice(str);
    }

    public final Call<Unit> addDevice(String str) {
        Intrinsics.checkNotNullParameter(str, "deviceId");
        return this.api.addDevice(str);
    }

    public final Call<List<Message>> searchMessages(SearchMessagesRequest searchMessagesRequest) {
        Intrinsics.checkNotNullParameter(searchMessagesRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        return this.api.searchMessages(searchMessagesRequest);
    }

    public final Call<List<Attachment>> getFileAttachments(String str, String str2, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return getAttachments(str, str2, i, i2, "file");
    }

    public final Call<List<Attachment>> getImageAttachments(String str, String str2, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return getAttachments(str, str2, i, i2, "image");
    }

    private final Call<List<Attachment>> getAttachments(String str, String str2, int i, int i2, String str3) {
        return CallKt.map(getMessagesWithAttachments(str, str2, i, i2, str3), new ChatClient$getAttachments$1(str3));
    }

    public final Call<List<Message>> getMessagesWithAttachments(String str, String str2, int i, int i2, String str3) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, "type");
        return searchMessages(new SearchMessagesRequest(i, i2, Filters.m1010in("cid", str + ':' + str2), Filters.m1010in("attachments.type", str3)));
    }

    public final Call<List<Message>> getReplies(String str, int i) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        return this.api.getReplies(str, i);
    }

    public final Call<List<Message>> getRepliesMore(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        Intrinsics.checkNotNullParameter(str2, "firstId");
        return this.api.getRepliesMore(str, str2, i);
    }

    public final Call<Message> sendAction(SendActionRequest sendActionRequest) {
        Intrinsics.checkNotNullParameter(sendActionRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        return this.api.sendAction(sendActionRequest);
    }

    public final Call<Message> deleteMessage(String str) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        return this.api.deleteMessage(str);
    }

    public final Call<Message> getMessage(String str) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        return this.api.getMessage(str);
    }

    public final Call<Message> sendMessage(String str, String str2, Message message) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return this.api.sendMessage(str, str2, message);
    }

    public final Call<Message> updateMessage(Message message) {
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return this.api.updateMessage(message);
    }

    public final Call<Message> pinMessage(Message message, Date date) {
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        message.setPinned(true);
        message.setPinExpires(date);
        Unit unit = Unit.INSTANCE;
        return updateMessage(message);
    }

    public final Call<Message> pinMessage(Message message, int i) {
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Calendar instance2 = Calendar.getInstance();
        instance2.add(13, i);
        message.setPinned(true);
        Intrinsics.checkNotNullExpressionValue(instance2, "calendar");
        message.setPinExpires(instance2.getTime());
        Unit unit = Unit.INSTANCE;
        return updateMessage(message);
    }

    public final Call<Message> unpinMessage(Message message) {
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        message.setPinned(false);
        Unit unit = Unit.INSTANCE;
        return updateMessage(message);
    }

    public final Call<Channel> queryChannel(String str, String str2, QueryChannelRequest queryChannelRequest) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(queryChannelRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        return this.queryChannelsPostponeHelper.queryChannel$stream_chat_android_client_release(str, str2, queryChannelRequest);
    }

    public final Call<List<Channel>> queryChannels(QueryChannelsRequest queryChannelsRequest) {
        Intrinsics.checkNotNullParameter(queryChannelsRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        return this.queryChannelsPostponeHelper.queryChannels$stream_chat_android_client_release(queryChannelsRequest);
    }

    public final Call<Channel> deleteChannel(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return this.api.deleteChannel(str, str2);
    }

    public final Call<Unit> markMessageRead(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        return this.api.markRead(str, str2, str3);
    }

    public final Call<Unit> showChannel(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return this.api.showChannel(str, str2);
    }

    public static /* synthetic */ Call hideChannel$default(ChatClient chatClient, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return chatClient.hideChannel(str, str2, z);
    }

    public final Call<Unit> hideChannel(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return this.api.hideChannel(str, str2, z);
    }

    public final Call<Unit> stopWatching(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return this.api.stopWatching(str, str2);
    }

    public static /* synthetic */ Call updateChannel$default(ChatClient chatClient, String str, String str2, Message message, Map map, int i, Object obj) {
        if ((i & 8) != 0) {
            map = MapsKt.emptyMap();
        }
        return chatClient.updateChannel(str, str2, message, map);
    }

    public final Call<Channel> updateChannel(String str, String str2, Message message, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(map, "channelExtraData");
        return this.api.updateChannel(str, str2, new UpdateChannelRequest(map, message));
    }

    public final Call<Channel> enableSlowMode(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return this.api.enableSlowMode(str, str2, i);
    }

    public final Call<Channel> disableSlowMode(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return this.api.disableSlowMode(str, str2);
    }

    public final Call<Channel> rejectInvite(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return this.api.rejectInvite(str, str2);
    }

    public static /* synthetic */ Call sendEvent$default(ChatClient chatClient, String str, String str2, String str3, Map map, int i, Object obj) {
        if ((i & 8) != 0) {
            map = MapsKt.emptyMap();
        }
        return chatClient.sendEvent(str, str2, str3, map);
    }

    public final Call<ChatEvent> sendEvent(String str, String str2, String str3, Map<Object, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "eventType");
        Intrinsics.checkNotNullParameter(str2, "channelType");
        Intrinsics.checkNotNullParameter(str3, "channelId");
        Intrinsics.checkNotNullParameter(map, "extraData");
        return this.api.sendEvent(str, str2, str3, map);
    }

    public final Call<Channel> acceptInvite(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return this.api.acceptInvite(str, str2, str3);
    }

    public final Call<Unit> markAllRead() {
        return this.api.markAllRead();
    }

    public final Call<Unit> markRead(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return ChatApi.DefaultImpls.markRead$default(this.api, str, str2, (String) null, 4, (Object) null);
    }

    public final Call<List<User>> updateUsers(List<User> list) {
        Intrinsics.checkNotNullParameter(list, "users");
        return this.api.updateUsers(list);
    }

    public final Call<User> updateUser(User user) {
        Intrinsics.checkNotNullParameter(user, "user");
        return CallKt.map(updateUsers(CollectionsKt.listOf(user)), ChatClient$updateUser$1.INSTANCE);
    }

    public final Call<List<User>> queryUsers(QueryUsersRequest queryUsersRequest) {
        Intrinsics.checkNotNullParameter(queryUsersRequest, SearchIntents.EXTRA_QUERY);
        return this.api.queryUsers(queryUsersRequest);
    }

    public final Call<Channel> addMembers(String str, String str2, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(list, ModelFields.MEMBERS);
        return this.api.addMembers(str, str2, list);
    }

    public final Call<Channel> removeMembers(String str, String str2, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(list, ModelFields.MEMBERS);
        return this.api.removeMembers(str, str2, list);
    }

    public final Call<Mute> muteUser(String str) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        return this.api.muteUser(str);
    }

    public final Call<Unit> muteChannel(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return this.api.muteChannel(str, str2);
    }

    public final Call<Unit> unMuteChannel(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return this.api.unMuteChannel(str, str2);
    }

    public final Call<Unit> unmuteUser(String str) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        return this.api.unmuteUser(str);
    }

    public final Call<Unit> unmuteCurrentUser() {
        return this.api.unmuteCurrentUser();
    }

    public final Call<Mute> muteCurrentUser() {
        return this.api.muteCurrentUser();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "We are going to replace with flagUser()", replaceWith = @ReplaceWith(expression = "this.flagUser(userId)", imports = {}))
    public final Call<Flag> flag(String str) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        return flagUser(str);
    }

    public final Call<Flag> flagUser(String str) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        return this.api.flagUser(str);
    }

    public final Call<Flag> flagMessage(String str) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        return this.api.flagMessage(str);
    }

    public final Call<Message> translate(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        Intrinsics.checkNotNullParameter(str2, "language");
        return this.api.translate(str, str2);
    }

    public final Call<Unit> banUser(String str, String str2, String str3, String str4, Integer num) {
        Intrinsics.checkNotNullParameter(str, "targetId");
        Intrinsics.checkNotNullParameter(str2, "channelType");
        Intrinsics.checkNotNullParameter(str3, "channelId");
        return CallKt.map(this.api.banUser(str, num, str4, str2, str3, false), ChatClient$banUser$1.INSTANCE);
    }

    public final Call<Unit> unBanUser(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "targetId");
        Intrinsics.checkNotNullParameter(str2, "channelType");
        Intrinsics.checkNotNullParameter(str3, "channelId");
        return CallKt.map(this.api.unBanUser(str, str2, str3, false), ChatClient$unBanUser$1.INSTANCE);
    }

    public final Call<Unit> shadowBanUser(String str, String str2, String str3, String str4, Integer num) {
        Intrinsics.checkNotNullParameter(str, "targetId");
        Intrinsics.checkNotNullParameter(str2, "channelType");
        Intrinsics.checkNotNullParameter(str3, "channelId");
        return CallKt.map(this.api.banUser(str, num, str4, str2, str3, true), ChatClient$shadowBanUser$1.INSTANCE);
    }

    public final Call<Unit> removeShadowBan(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "targetId");
        Intrinsics.checkNotNullParameter(str2, "channelType");
        Intrinsics.checkNotNullParameter(str3, "channelId");
        return CallKt.map(this.api.unBanUser(str, str2, str3, true), ChatClient$removeShadowBan$1.INSTANCE);
    }

    public final void onMessageReceived(RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        this.notifications.onFirebaseMessage(remoteMessage);
    }

    public final void onNewTokenReceived(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        this.notifications.setFirebaseToken(str);
    }

    public final String getConnectionId() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m1029constructorimpl(this.clientStateService.getState$stream_chat_android_client_release().connectionIdOrError$stream_chat_android_client_release());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1029constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m1035isFailureimpl(obj)) {
            obj = null;
        }
        return (String) obj;
    }

    public final User getCurrentUser() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m1029constructorimpl(this.clientStateService.getState$stream_chat_android_client_release().userOrError$stream_chat_android_client_release());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1029constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m1035isFailureimpl(obj)) {
            obj = null;
        }
        return (User) obj;
    }

    public final String getCurrentToken() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m1029constructorimpl(this.clientStateService.getState$stream_chat_android_client_release().tokenOrError$stream_chat_android_client_release());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1029constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m1035isFailureimpl(obj)) {
            obj = null;
        }
        return (String) obj;
    }

    public final boolean isSocketConnected() {
        ClientState state$stream_chat_android_client_release = this.clientStateService.getState$stream_chat_android_client_release();
        return (state$stream_chat_android_client_release instanceof ClientState.User.Authorized.Connected) || (state$stream_chat_android_client_release instanceof ClientState.Anonymous.Authorized.Connected);
    }

    public final ChannelClient channel(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return new ChannelClient(str, str2, this);
    }

    public final ChannelClient channel(String str) {
        Intrinsics.checkNotNullParameter(str, "cid");
        CharSequence charSequence = str;
        return channel((String) StringsKt.split$default(charSequence, new String[]{":"}, false, 0, 6, (Object) null).get(0), (String) StringsKt.split$default(charSequence, new String[]{":"}, false, 0, 6, (Object) null).get(1));
    }

    public final Call<Channel> createChannel(String str, String str2, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(map, "extraData");
        return createChannel(str, str2, CollectionsKt.emptyList(), map);
    }

    public final Call<Channel> createChannel(String str, String str2, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(list, ModelFields.MEMBERS);
        return createChannel(str, str2, list, MapsKt.emptyMap());
    }

    public final Call<Channel> createChannel(String str, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(list, ModelFields.MEMBERS);
        return createChannel(str, "", list, MapsKt.emptyMap());
    }

    public final Call<Channel> createChannel(String str, List<String> list, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(list, ModelFields.MEMBERS);
        Intrinsics.checkNotNullParameter(map, "extraData");
        return createChannel(str, "", list, map);
    }

    public final Call<Channel> createChannel(String str, String str2, List<String> list, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(list, ModelFields.MEMBERS);
        Intrinsics.checkNotNullParameter(map, "extraData");
        return queryChannel(str, str2, new QueryChannelRequest().withData(MapsKt.plus(map, (Map<String, ? extends Object>) MapsKt.mapOf(TuplesKt.m181to(ModelFields.MEMBERS, list)))));
    }

    public final Call<List<ChatEvent>> getSyncHistory(List<String> list, Date date) {
        Intrinsics.checkNotNullParameter(list, "channelsIds");
        Intrinsics.checkNotNullParameter(date, "lastSyncAt");
        return this.api.getSyncHistory(list, date);
    }

    public final void callConnectionListener$stream_chat_android_client_release(ConnectedEvent connectedEvent, ChatError chatError) {
        InitConnectionListener initConnectionListener;
        if (connectedEvent != null) {
            User me = connectedEvent.getMe();
            String connectionId = connectedEvent.getConnectionId();
            InitConnectionListener initConnectionListener2 = this.connectionListener;
            if (initConnectionListener2 != null) {
                initConnectionListener2.onSuccess(new InitConnectionListener.ConnectionData(me, connectionId));
            }
        } else if (!(chatError == null || (initConnectionListener = this.connectionListener) == null)) {
            initConnectionListener.onError(chatError);
        }
        this.connectionListener = null;
    }

    private final void getTokenAndConnect(Function0<Unit> function0) {
        this.tokenManager.loadAsync(new ChatClient$getTokenAndConnect$1(this, function0));
    }

    private final void warmUp() {
        if (this.config.getWarmUp()) {
            this.api.warmUp();
        }
    }

    private final boolean ensureUserNotSet(InitConnectionListener initConnectionListener) {
        if (!isUserSet()) {
            return true;
        }
        this.logger.logE("Trying to set user without disconnecting the previous one - make sure that previously set user is disconnected.");
        if (initConnectionListener != null) {
            initConnectionListener.onError(new ChatError("User cannot be set until previous one is disconnected.", (Throwable) null, 2, (DefaultConstructorMarker) null));
        }
        return false;
    }

    private final boolean isUserSet() {
        return !(this.clientStateService.getState$stream_chat_android_client_release() instanceof ClientState.Idle);
    }

    /* access modifiers changed from: private */
    public final boolean isValidRemoteMessage(RemoteMessage remoteMessage) {
        return this.notifications.isValidRemoteMessage(remoteMessage);
    }

    public final String devToken(String str) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        if (str.length() > 0) {
            String str2 = "{\"user_id\":\"" + str + "\"}";
            Charset charset = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(charset, "StandardCharsets.UTF_8");
            Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
            byte[] bytes = str2.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            String encodeToString = Base64.encodeToString(bytes, 2);
            Intrinsics.checkNotNullExpressionValue(encodeToString, "Base64.encodeToString(\"{…s.UTF_8), Base64.NO_WRAP)");
            return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" + ClassUtils.PACKAGE_SEPARATOR_CHAR + encodeToString + ClassUtils.PACKAGE_SEPARATOR_CHAR + "devtoken";
        }
        throw new IllegalArgumentException("User id must not be empty".toString());
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0003J\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0003J\u0006\u0010\u001c\u001a\u00020\u0000J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u000fJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0003J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo26107d2 = {"Lio/getstream/chat/android/client/ChatClient$Builder;", "", "apiKey", "", "appContext", "Landroid/content/Context;", "(Ljava/lang/String;Landroid/content/Context;)V", "baseTimeout", "", "baseUrl", "cdnTimeout", "cdnUrl", "fileUploader", "Lio/getstream/chat/android/client/uploader/FileUploader;", "logLevel", "Lio/getstream/chat/android/client/logger/ChatLogLevel;", "loggerHandler", "Lio/getstream/chat/android/client/logger/ChatLoggerHandler;", "notificationsHandler", "Lio/getstream/chat/android/client/notifications/handler/ChatNotificationHandler;", "tokenManager", "Lio/getstream/chat/android/client/token/TokenManager;", "warmUp", "", "timeout", "value", "build", "Lio/getstream/chat/android/client/ChatClient;", "disableWarmUp", "level", "notifications", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.ChatClient$Builder */
    /* compiled from: ChatClient.kt */
    public static final class Builder {
        private final String apiKey;
        private final Context appContext;
        private long baseTimeout = WorkRequest.MIN_BACKOFF_MILLIS;
        private String baseUrl = "chat-us-east-1.stream-io-api.com";
        private long cdnTimeout = WorkRequest.MIN_BACKOFF_MILLIS;
        private String cdnUrl = "chat-us-east-1.stream-io-api.com";
        private FileUploader fileUploader;
        private ChatLogLevel logLevel = ChatLogLevel.NOTHING;
        private ChatLoggerHandler loggerHandler;
        private ChatNotificationHandler notificationsHandler;
        private final TokenManager tokenManager;
        private boolean warmUp = true;

        public Builder(String str, Context context) {
            Intrinsics.checkNotNullParameter(str, "apiKey");
            Intrinsics.checkNotNullParameter(context, "appContext");
            this.apiKey = str;
            this.appContext = context;
            this.notificationsHandler = new ChatNotificationHandler(context, (NotificationConfig) null, 2, (DefaultConstructorMarker) null);
            this.tokenManager = new TokenManagerImpl();
        }

        public final Builder logLevel(ChatLogLevel chatLogLevel) {
            Intrinsics.checkNotNullParameter(chatLogLevel, FirebaseAnalytics.Param.LEVEL);
            this.logLevel = chatLogLevel;
            return this;
        }

        public final Builder logLevel(String str) {
            Intrinsics.checkNotNullParameter(str, FirebaseAnalytics.Param.LEVEL);
            this.logLevel = ChatLogLevel.valueOf(str);
            return this;
        }

        public final Builder loggerHandler(ChatLoggerHandler chatLoggerHandler) {
            Intrinsics.checkNotNullParameter(chatLoggerHandler, "loggerHandler");
            this.loggerHandler = chatLoggerHandler;
            return this;
        }

        public final Builder notifications(ChatNotificationHandler chatNotificationHandler) {
            Intrinsics.checkNotNullParameter(chatNotificationHandler, "notificationsHandler");
            this.notificationsHandler = chatNotificationHandler;
            return this;
        }

        public final Builder fileUploader(FileUploader fileUploader2) {
            Intrinsics.checkNotNullParameter(fileUploader2, "fileUploader");
            this.fileUploader = fileUploader2;
            return this;
        }

        public final Builder baseTimeout(long j) {
            this.baseTimeout = j;
            return this;
        }

        public final Builder cdnTimeout(long j) {
            this.cdnTimeout = j;
            return this;
        }

        public final Builder disableWarmUp() {
            Builder builder = this;
            builder.warmUp = false;
            return builder;
        }

        public final Builder baseUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            if (StringsKt.startsWith$default(str, "https://", false, 2, (Object) null)) {
                Object[] array = StringsKt.split$default((CharSequence) str, new String[]{"https://"}, false, 0, 6, (Object) null).toArray(new String[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                str = ((String[]) array)[1];
            }
            if (StringsKt.startsWith$default(str, "http://", false, 2, (Object) null)) {
                Object[] array2 = StringsKt.split$default((CharSequence) str, new String[]{"http://"}, false, 0, 6, (Object) null).toArray(new String[0]);
                Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
                str = ((String[]) array2)[1];
            }
            if (StringsKt.endsWith$default(str, "/", false, 2, (Object) null)) {
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                str = str.substring(0, str.length() - 1);
                Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            this.baseUrl = str;
            return this;
        }

        public final Builder cdnUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            if (StringsKt.startsWith$default(str, "https://", false, 2, (Object) null)) {
                Object[] array = StringsKt.split$default((CharSequence) str, new String[]{"https://"}, false, 0, 6, (Object) null).toArray(new String[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                str = ((String[]) array)[1];
            }
            if (StringsKt.startsWith$default(str, "http://", false, 2, (Object) null)) {
                Object[] array2 = StringsKt.split$default((CharSequence) str, new String[]{"http://"}, false, 0, 6, (Object) null).toArray(new String[0]);
                Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
                str = ((String[]) array2)[1];
            }
            if (StringsKt.endsWith$default(str, "/", false, 2, (Object) null)) {
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                str = str.substring(0, str.length() - 1);
                Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            this.cdnUrl = str;
            return this;
        }

        public final ChatClient build() {
            if (!(this.apiKey.length() == 0)) {
                ChatClientConfig chatClientConfig = new ChatClientConfig(this.apiKey, "https://" + this.baseUrl + '/', "https://" + this.cdnUrl + '/', "wss://" + this.baseUrl + '/', this.baseTimeout, this.cdnTimeout, this.warmUp, new ChatLogger.Config(this.logLevel, this.loggerHandler));
                chatClientConfig.setEnableMoshi$stream_chat_android_client_release(false);
                ChatModule chatModule = new ChatModule(this.appContext, chatClientConfig, this.notificationsHandler, this.fileUploader, this.tokenManager);
                ChatClient chatClient = new ChatClient(chatClientConfig, chatModule.api(), chatModule.socket(), chatModule.notifications(), this.tokenManager, (ClientStateService) null, 32, (DefaultConstructorMarker) null);
                ChatClient.instance = chatClient;
                return chatClient;
            }
            throw new IllegalStateException("apiKey is not defined in " + getClass().getSimpleName());
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\f¨\u0006\u0012"}, mo26107d2 = {"Lio/getstream/chat/android/client/ChatClient$Companion;", "", "()V", "DEFAULT_SORT", "Lio/getstream/chat/android/client/api/models/QuerySort;", "Lio/getstream/chat/android/client/models/Member;", "VERSION_PREFIX", "", "instance", "Lio/getstream/chat/android/client/ChatClient;", "isInitialized", "", "()Z", "isValidRemoteMessage", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "defaultNotificationConfig", "Lio/getstream/chat/android/client/notifications/handler/NotificationConfig;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.ChatClient$Companion */
    /* compiled from: ChatClient.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ChatClient instance() {
            ChatClient access$getInstance$cp = ChatClient.instance;
            if (access$getInstance$cp != null) {
                return access$getInstance$cp;
            }
            throw new IllegalStateException("ChatClient.Builder::build() must be called before obtaining ChatClient instance");
        }

        public final boolean isInitialized() {
            return ChatClient.instance != null;
        }

        public static /* synthetic */ boolean isValidRemoteMessage$default(Companion companion, RemoteMessage remoteMessage, NotificationConfig notificationConfig, int i, Object obj) {
            RemoteMessage remoteMessage2;
            NotificationConfig notificationConfig2;
            if ((i & 2) != 0) {
                notificationConfig2 = new NotificationConfig(0, 0, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, false, 2047, (DefaultConstructorMarker) null);
                Companion companion2 = companion;
                remoteMessage2 = remoteMessage;
            } else {
                Companion companion3 = companion;
                remoteMessage2 = remoteMessage;
                notificationConfig2 = notificationConfig;
            }
            return companion.isValidRemoteMessage(remoteMessage2, notificationConfig2);
        }

        public final boolean isValidRemoteMessage(RemoteMessage remoteMessage, NotificationConfig notificationConfig) {
            Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
            Intrinsics.checkNotNullParameter(notificationConfig, "defaultNotificationConfig");
            ChatClient access$getInstance$cp = ChatClient.instance;
            return access$getInstance$cp != null ? access$getInstance$cp.isValidRemoteMessage(remoteMessage) : RemoteMessageExtensionsKt.isValid(remoteMessage, notificationConfig);
        }
    }

    static {
        QuerySort.Companion companion = QuerySort.Companion;
    }
}
