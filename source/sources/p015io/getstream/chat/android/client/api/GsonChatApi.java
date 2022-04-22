package p015io.getstream.chat.android.client.api;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.messaging.Constants;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import editor.editor.equipment.core.CoreConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import p015io.getstream.chat.android.client.api.models.AcceptInviteRequest;
import p015io.getstream.chat.android.client.api.models.AddDeviceRequest;
import p015io.getstream.chat.android.client.api.models.AddMembersRequest;
import p015io.getstream.chat.android.client.api.models.BanUserRequest;
import p015io.getstream.chat.android.client.api.models.ChannelResponse;
import p015io.getstream.chat.android.client.api.models.CompletableResponse;
import p015io.getstream.chat.android.client.api.models.GetSyncHistory;
import p015io.getstream.chat.android.client.api.models.GuestUserRequest;
import p015io.getstream.chat.android.client.api.models.HideChannelRequest;
import p015io.getstream.chat.android.client.api.models.MarkReadRequest;
import p015io.getstream.chat.android.client.api.models.MessageRequest;
import p015io.getstream.chat.android.client.api.models.MuteChannelRequest;
import p015io.getstream.chat.android.client.api.models.MuteUserRequest;
import p015io.getstream.chat.android.client.api.models.QueryChannelRequest;
import p015io.getstream.chat.android.client.api.models.QueryChannelsRequest;
import p015io.getstream.chat.android.client.api.models.QueryMembersRequest;
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.client.api.models.QueryUsersRequest;
import p015io.getstream.chat.android.client.api.models.ReactionRequest;
import p015io.getstream.chat.android.client.api.models.RejectInviteRequest;
import p015io.getstream.chat.android.client.api.models.RemoveMembersRequest;
import p015io.getstream.chat.android.client.api.models.SearchMessagesRequest;
import p015io.getstream.chat.android.client.api.models.SendActionRequest;
import p015io.getstream.chat.android.client.api.models.SendEventRequest;
import p015io.getstream.chat.android.client.api.models.TranslateMessageRequest;
import p015io.getstream.chat.android.client.api.models.UpdateChannelRequest;
import p015io.getstream.chat.android.client.api.models.UpdateCooldownRequest;
import p015io.getstream.chat.android.client.api.models.UpdateUsersRequest;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.call.CallKt;
import p015io.getstream.chat.android.client.call.CoroutineCall;
import p015io.getstream.chat.android.client.call.RetrofitCall;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.events.ChatEvent;
import p015io.getstream.chat.android.client.extensions.MessageExtensionsKt;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.ChannelUserRead;
import p015io.getstream.chat.android.client.models.Device;
import p015io.getstream.chat.android.client.models.Flag;
import p015io.getstream.chat.android.client.models.GuestUser;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.ModelFields;
import p015io.getstream.chat.android.client.models.Mute;
import p015io.getstream.chat.android.client.models.Reaction;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.uploader.FileUploader;
import p015io.getstream.chat.android.client.utils.FilterObject;
import p015io.getstream.chat.android.client.utils.ProgressCallback;
import p015io.getstream.chat.android.client.utils.SyncStatus;
import p015io.getstream.chat.android.client.utils.UuidGenerator;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00122\u0006\u0010\u0019\u001a\u00020\u0003H\u0016J,\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cH\u0016JG\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00122\u0006\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$H\u0016¢\u0006\u0002\u0010%J\u001e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00180\u00122\u0006\u0010\u0019\u001a\u00020\u0003H\u0016J&\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00180\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0003H\u0016J&\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00180\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0003H\u0016J\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u00122\u0006\u0010-\u001a\u00020\u0003H\u0016J\u001e\u0010.\u001a\b\u0012\u0004\u0012\u00020,0\u00122\u0006\u0010-\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u0003H\u0016J\u001e\u00100\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J&\u00101\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u00102\u001a\u00020!H\u0016J\"\u00103\u001a\b\u0012\u0004\u0012\u0002040\u00122\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000306H\u0002J\u0016\u00107\u001a\b\u0012\u0004\u0012\u0002040\u00122\u0006\u0010-\u001a\u00020\u0003H\u0016J\u0016\u00108\u001a\b\u0012\u0004\u0012\u0002040\u00122\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0010\u00109\u001a\u00020\u00132\u0006\u0010:\u001a\u00020;H\u0002J\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00130\u001c2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020;0\u001cH\u0002J\u0014\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u001c0\u0012H\u0016J\u001e\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u00122\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u0003H\u0016J\u0016\u0010C\u001a\b\u0012\u0004\u0012\u00020,0\u00122\u0006\u0010-\u001a\u00020\u0003H\u0016J,\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0\u001c0\u00122\u0006\u0010-\u001a\u00020\u00032\u0006\u0010F\u001a\u00020!2\u0006\u0010G\u001a\u00020!H\u0016J$\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u001c0\u00122\u0006\u0010-\u001a\u00020\u00032\u0006\u0010G\u001a\u00020!H\u0016J,\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u001c0\u00122\u0006\u0010-\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u00032\u0006\u0010G\u001a\u00020!H\u0016J*\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0\u001c0\u00122\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c2\u0006\u0010N\u001a\u00020OH\u0016J&\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00180\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020$H\u0016J\u000e\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012H\u0016J&\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00180\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0003H\u0016J\u001e\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00180\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u000e\u0010U\u001a\b\u0012\u0004\u0012\u00020V0\u0012H\u0016J\u0016\u0010W\u001a\b\u0012\u0004\u0012\u00020V0\u00122\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0018\u0010X\u001a\b\u0012\u0004\u0012\u0002HZ0Y\"\b\b\u0000\u0010Z*\u00020[H\u0002J&\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010]\u001a\u00020^H\u0016J\u001c\u0010_\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u001c0\u00122\u0006\u0010]\u001a\u00020`H\u0016JX\u0010a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020b0\u001c0\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010F\u001a\u00020!2\u0006\u0010G\u001a\u00020!2\u0006\u0010c\u001a\u00020d2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020b0f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020b0\u001cH\u0016J\u001c\u0010g\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0\u001c0\u00122\u0006\u0010g\u001a\u00020iH\u0016J\u001e\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J,\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cH\u0016J\u001c\u0010l\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u001c0\u00122\u0006\u0010m\u001a\u00020nH\u0016J\u0016\u0010o\u001a\b\u0012\u0004\u0012\u00020,0\u00122\u0006\u0010m\u001a\u00020pH\u0016J:\u0010q\u001a\b\u0012\u0004\u0012\u00020L0\u00122\u0006\u0010r\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0012\u0010s\u001a\u000e\u0012\u0004\u0012\u00020[\u0012\u0004\u0012\u00020[0tH\u0016J0\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010v\u001a\u00020w2\b\u0010x\u001a\u0004\u0018\u00010yH\u0016J0\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010v\u001a\u00020w2\b\u0010x\u001a\u0004\u0018\u00010yH\u0016J&\u0010{\u001a\b\u0012\u0004\u0012\u00020,0\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020,H\u0016J\u001e\u0010|\u001a\b\u0012\u0004\u0012\u00020E0\u00122\u0006\u0010}\u001a\u00020E2\u0006\u0010~\u001a\u00020$H\u0016J&\u0010|\u001a\b\u0012\u0004\u0012\u00020E0\u00122\u0006\u0010-\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u00032\u0006\u0010~\u001a\u00020$H\u0016J\u0018\u0010\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u001f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u001f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J \u0010\u0001\u001a\b\u0012\u0004\u0012\u00020,0\u00122\u0006\u0010-\u001a\u00020\u00032\u0007\u0010\u0001\u001a\u00020\u0003H\u0016J/\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00122\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$H\u0016J\u001f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u000f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012H\u0016J\u0017\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180\u00122\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J(\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0007\u0010m\u001a\u00030\u0001H\u0016J'\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u00102\u001a\u00020!H\u0002J\u0017\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020,0\u00122\u0006\u0010\u0016\u001a\u00020,H\u0016J$\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0\u001c0\u00122\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020h0\u001cH\u0016J\u0011\u0010\u0001\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020,H\u0002J\t\u0010\u0001\u001a\u00020\u0018H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/GsonChatApi;", "Lio/getstream/chat/android/client/api/ChatApi;", "apiKey", "", "retrofitApi", "Lio/getstream/chat/android/client/api/RetrofitApi;", "retrofitAnonymousApi", "Lio/getstream/chat/android/client/api/RetrofitAnonymousApi;", "uuidGenerator", "Lio/getstream/chat/android/client/utils/UuidGenerator;", "fileUploader", "Lio/getstream/chat/android/client/uploader/FileUploader;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Ljava/lang/String;Lio/getstream/chat/android/client/api/RetrofitApi;Lio/getstream/chat/android/client/api/RetrofitAnonymousApi;Lio/getstream/chat/android/client/utils/UuidGenerator;Lio/getstream/chat/android/client/uploader/FileUploader;Lkotlinx/coroutines/CoroutineScope;)V", "connectionId", "userId", "acceptInvite", "Lio/getstream/chat/android/client/call/Call;", "Lio/getstream/chat/android/client/models/Channel;", "channelType", "channelId", "message", "addDevice", "", "firebaseToken", "addMembers", "members", "", "banUser", "Lio/getstream/chat/android/client/api/models/CompletableResponse;", "targetId", "timeout", "", "reason", "shadow", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lio/getstream/chat/android/client/call/Call;", "deleteChannel", "deleteDevice", "deleteFile", "url", "deleteImage", "deleteMessage", "Lio/getstream/chat/android/client/models/Message;", "messageId", "deleteReaction", "reactionType", "disableSlowMode", "enableSlowMode", "cooldownTimeInSeconds", "flag", "Lio/getstream/chat/android/client/models/Flag;", "body", "", "flagMessage", "flagUser", "flattenChannel", "response", "Lio/getstream/chat/android/client/api/models/ChannelResponse;", "flattenChannels", "responses", "getDevices", "Lio/getstream/chat/android/client/models/Device;", "getGuestUser", "Lio/getstream/chat/android/client/models/GuestUser;", "userName", "getMessage", "getReactions", "Lio/getstream/chat/android/client/models/Reaction;", "offset", "limit", "getReplies", "getRepliesMore", "firstId", "getSyncHistory", "Lio/getstream/chat/android/client/events/ChatEvent;", "channelIds", "lastSyncAt", "Ljava/util/Date;", "hideChannel", "clearHistory", "markAllRead", "markRead", "muteChannel", "muteCurrentUser", "Lio/getstream/chat/android/client/models/Mute;", "muteUser", "noConnectionIdError", "Lio/getstream/chat/android/client/api/ErrorCall;", "T", "", "queryChannel", "query", "Lio/getstream/chat/android/client/api/models/QueryChannelRequest;", "queryChannels", "Lio/getstream/chat/android/client/api/models/QueryChannelsRequest;", "queryMembers", "Lio/getstream/chat/android/client/models/Member;", "filter", "Lio/getstream/chat/android/client/utils/FilterObject;", "sort", "Lio/getstream/chat/android/client/api/models/QuerySort;", "queryUsers", "Lio/getstream/chat/android/client/models/User;", "Lio/getstream/chat/android/client/api/models/QueryUsersRequest;", "rejectInvite", "removeMembers", "searchMessages", "request", "Lio/getstream/chat/android/client/api/models/SearchMessagesRequest;", "sendAction", "Lio/getstream/chat/android/client/api/models/SendActionRequest;", "sendEvent", "eventType", "extraData", "", "sendFile", "file", "Ljava/io/File;", "callback", "Lio/getstream/chat/android/client/utils/ProgressCallback;", "sendImage", "sendMessage", "sendReaction", "reaction", "enforceUnique", "setConnection", "showChannel", "stopWatching", "translate", "language", "unBanUser", "unMuteChannel", "unmuteCurrentUser", "unmuteUser", "updateChannel", "Lio/getstream/chat/android/client/api/models/UpdateChannelRequest;", "updateCooldown", "updateMessage", "updateUsers", "users", "verifyMessageId", "warmUp", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.GsonChatApi */
/* compiled from: GsonChatApi.kt */
public final class GsonChatApi implements ChatApi {
    private final String apiKey;
    /* access modifiers changed from: private */
    public String connectionId;
    private final CoroutineScope coroutineScope;
    /* access modifiers changed from: private */
    public final FileUploader fileUploader;
    private final RetrofitAnonymousApi retrofitAnonymousApi;
    private final RetrofitApi retrofitApi;
    /* access modifiers changed from: private */
    public String userId;
    private final UuidGenerator uuidGenerator;

    public GsonChatApi(String str, RetrofitApi retrofitApi2, RetrofitAnonymousApi retrofitAnonymousApi2, UuidGenerator uuidGenerator2, FileUploader fileUploader2, CoroutineScope coroutineScope2) {
        Intrinsics.checkNotNullParameter(str, "apiKey");
        Intrinsics.checkNotNullParameter(retrofitApi2, "retrofitApi");
        Intrinsics.checkNotNullParameter(retrofitAnonymousApi2, "retrofitAnonymousApi");
        Intrinsics.checkNotNullParameter(uuidGenerator2, "uuidGenerator");
        Intrinsics.checkNotNullParameter(fileUploader2, "fileUploader");
        Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
        this.apiKey = str;
        this.retrofitApi = retrofitApi2;
        this.retrofitAnonymousApi = retrofitAnonymousApi2;
        this.uuidGenerator = uuidGenerator2;
        this.fileUploader = fileUploader2;
        this.coroutineScope = coroutineScope2;
        this.userId = "";
        this.connectionId = "";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GsonChatApi(String str, RetrofitApi retrofitApi2, RetrofitAnonymousApi retrofitAnonymousApi2, UuidGenerator uuidGenerator2, FileUploader fileUploader2, CoroutineScope coroutineScope2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, retrofitApi2, retrofitAnonymousApi2, uuidGenerator2, fileUploader2, (i & 32) != 0 ? GlobalScope.INSTANCE : coroutineScope2);
    }

    public void setConnection(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "connectionId");
        this.userId = str;
        this.connectionId = str2;
    }

    public Call<String> sendFile(String str, String str2, File file, ProgressCallback progressCallback) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(file, "file");
        return new CoroutineCall<>(this.coroutineScope, new GsonChatApi$sendFile$1(this, progressCallback, str, str2, file, (Continuation) null));
    }

    public Call<String> sendImage(String str, String str2, File file, ProgressCallback progressCallback) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(file, "file");
        return new CoroutineCall<>(this.coroutineScope, new GsonChatApi$sendImage$1(this, progressCallback, str, str2, file, (Continuation) null));
    }

    public Call<Unit> deleteFile(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, "url");
        return new CoroutineCall<>(this.coroutineScope, new GsonChatApi$deleteFile$1(this, str, str2, str3, (Continuation) null));
    }

    public Call<Unit> deleteImage(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, "url");
        return new CoroutineCall<>(this.coroutineScope, new GsonChatApi$deleteImage$1(this, str, str2, str3, (Continuation) null));
    }

    public Call<Unit> addDevice(String str) {
        Intrinsics.checkNotNullParameter(str, "firebaseToken");
        return CallKt.map(this.retrofitApi.addDevices(this.apiKey, this.userId, this.connectionId, new AddDeviceRequest(str)), GsonChatApi$addDevice$1.INSTANCE);
    }

    public Call<Unit> deleteDevice(String str) {
        Intrinsics.checkNotNullParameter(str, "firebaseToken");
        return CallKt.map(this.retrofitApi.deleteDevice(str, this.apiKey, this.userId, this.connectionId), GsonChatApi$deleteDevice$1.INSTANCE);
    }

    public Call<List<Device>> getDevices() {
        return CallKt.map(this.retrofitApi.getDevices(this.apiKey, this.userId, this.connectionId), GsonChatApi$getDevices$1.INSTANCE);
    }

    public Call<List<Message>> searchMessages(SearchMessagesRequest searchMessagesRequest) {
        Intrinsics.checkNotNullParameter(searchMessagesRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        return CallKt.map(this.retrofitApi.searchMessages(this.apiKey, this.connectionId, searchMessagesRequest), GsonChatApi$searchMessages$1.INSTANCE);
    }

    public Call<List<Message>> getRepliesMore(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        Intrinsics.checkNotNullParameter(str2, "firstId");
        return CallKt.map(this.retrofitApi.getRepliesMore(str, this.apiKey, this.userId, this.connectionId, i, str2), GsonChatApi$getRepliesMore$1.INSTANCE);
    }

    public Call<List<Message>> getReplies(String str, int i) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        return CallKt.map(this.retrofitApi.getReplies(str, this.apiKey, this.userId, this.connectionId, i), GsonChatApi$getReplies$1.INSTANCE);
    }

    public Call<List<Reaction>> getReactions(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        return CallKt.map(this.retrofitApi.getReactions(str, this.apiKey, this.connectionId, i, i2), GsonChatApi$getReactions$1.INSTANCE);
    }

    public Call<Reaction> sendReaction(Reaction reaction, boolean z) {
        Intrinsics.checkNotNullParameter(reaction, "reaction");
        return CallKt.map(this.retrofitApi.sendReaction(reaction.getMessageId(), this.apiKey, this.userId, this.connectionId, new ReactionRequest(reaction, z)), GsonChatApi$sendReaction$1.INSTANCE);
    }

    public Call<Reaction> sendReaction(String str, String str2, boolean z) {
        String str3 = str;
        Intrinsics.checkNotNullParameter(str3, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str4, "reactionType");
        return sendReaction(new Reaction(str3, str4, 0, (User) null, (String) null, (Date) null, (Date) null, (Date) null, (SyncStatus) null, (Map) null, false, 2040, (DefaultConstructorMarker) null), z);
    }

    public Call<Message> deleteReaction(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        Intrinsics.checkNotNullParameter(str2, "reactionType");
        return CallKt.map(this.retrofitApi.deleteReaction(str, str2, this.apiKey, this.userId, this.connectionId), GsonChatApi$deleteReaction$1.INSTANCE);
    }

    public Call<Message> deleteMessage(String str) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        return CallKt.map(this.retrofitApi.deleteMessage(str, this.apiKey, this.userId, this.connectionId), GsonChatApi$deleteMessage$1.INSTANCE);
    }

    public Call<Message> sendAction(SendActionRequest sendActionRequest) {
        Intrinsics.checkNotNullParameter(sendActionRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        return CallKt.map(this.retrofitApi.sendAction(sendActionRequest.getMessageId(), this.apiKey, this.userId, this.connectionId, sendActionRequest), GsonChatApi$sendAction$1.INSTANCE);
    }

    public Call<Message> getMessage(String str) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        return CallKt.map(this.retrofitApi.getMessage(str, this.apiKey, this.userId, this.connectionId), GsonChatApi$getMessage$1.INSTANCE);
    }

    public Call<Message> sendMessage(String str, String str2, Message message) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        verifyMessageId(message);
        return CallKt.map(this.retrofitApi.sendMessage(str, str2, this.apiKey, this.userId, this.connectionId, new MessageRequest(message)), GsonChatApi$sendMessage$1.INSTANCE);
    }

    public Call<Unit> muteChannel(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        RetrofitApi retrofitApi2 = this.retrofitApi;
        String str3 = this.apiKey;
        String str4 = this.userId;
        String str5 = this.connectionId;
        return CallKt.map(retrofitApi2.muteChannel(str3, str4, str5, new MuteChannelRequest(str + ':' + str2)), GsonChatApi$muteChannel$1.INSTANCE);
    }

    public Call<Unit> unMuteChannel(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        RetrofitApi retrofitApi2 = this.retrofitApi;
        String str3 = this.apiKey;
        String str4 = this.userId;
        String str5 = this.connectionId;
        return CallKt.map(retrofitApi2.unMuteChannel(str3, str4, str5, new MuteChannelRequest(str + ':' + str2)), GsonChatApi$unMuteChannel$1.INSTANCE);
    }

    public Call<Message> updateMessage(Message message) {
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return CallKt.map(this.retrofitApi.updateMessage(message.getId(), this.apiKey, this.userId, this.connectionId, new MessageRequest(message)), GsonChatApi$updateMessage$1.INSTANCE);
    }

    public Call<Unit> stopWatching(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return CallKt.map(this.retrofitApi.stopWatching(str, str2, this.apiKey, this.connectionId, MapsKt.emptyMap()), GsonChatApi$stopWatching$1.INSTANCE);
    }

    public Call<List<Channel>> queryChannels(QueryChannelsRequest queryChannelsRequest) {
        Intrinsics.checkNotNullParameter(queryChannelsRequest, SearchIntents.EXTRA_QUERY);
        if (this.connectionId.length() == 0) {
            return noConnectionIdError();
        }
        return CallKt.map(this.retrofitApi.queryChannels(this.apiKey, this.userId, this.connectionId, queryChannelsRequest), new GsonChatApi$queryChannels$1(this));
    }

    public Call<List<User>> updateUsers(List<User> list) {
        Intrinsics.checkNotNullParameter(list, "users");
        Iterable<User> iterable = list;
        Map linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (User user : iterable) {
            linkedHashMap.put(user.getId(), user);
        }
        return CallKt.map(this.retrofitApi.updateUsers(this.apiKey, this.connectionId, new UpdateUsersRequest(linkedHashMap)), GsonChatApi$updateUsers$1.INSTANCE);
    }

    public Call<Channel> queryChannel(String str, String str2, QueryChannelRequest queryChannelRequest) {
        RetrofitCall<ChannelResponse> retrofitCall;
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(queryChannelRequest, SearchIntents.EXTRA_QUERY);
        if (str2.length() == 0) {
            retrofitCall = this.retrofitApi.queryChannel(str, this.apiKey, this.userId, this.connectionId, queryChannelRequest);
        } else {
            retrofitCall = this.retrofitApi.queryChannel(str, str2, this.apiKey, this.userId, this.connectionId, queryChannelRequest);
        }
        return CallKt.map(retrofitCall, new GsonChatApi$queryChannel$1(this));
    }

    public Call<Channel> updateChannel(String str, String str2, UpdateChannelRequest updateChannelRequest) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(updateChannelRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        return CallKt.map(this.retrofitApi.updateChannel(str, str2, this.apiKey, this.connectionId, updateChannelRequest), new GsonChatApi$updateChannel$1(this));
    }

    public Call<Channel> enableSlowMode(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return updateCooldown(str, str2, i);
    }

    public Call<Channel> disableSlowMode(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return updateCooldown(str, str2, 0);
    }

    private final Call<Channel> updateCooldown(String str, String str2, int i) {
        return CallKt.map(this.retrofitApi.updateCooldown(str, str2, this.apiKey, this.connectionId, new UpdateCooldownRequest(i)), new GsonChatApi$updateCooldown$1(this));
    }

    public Call<Unit> markRead(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        return CallKt.map(this.retrofitApi.markRead(str, str2, this.apiKey, this.userId, this.connectionId, new MarkReadRequest(str3)), GsonChatApi$markRead$1.INSTANCE);
    }

    public Call<Unit> showChannel(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return CallKt.map(this.retrofitApi.showChannel(str, str2, this.apiKey, this.connectionId, MapsKt.emptyMap()), GsonChatApi$showChannel$1.INSTANCE);
    }

    public Call<Unit> hideChannel(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return CallKt.map(this.retrofitApi.hideChannel(str, str2, this.apiKey, this.connectionId, new HideChannelRequest(z)), GsonChatApi$hideChannel$1.INSTANCE);
    }

    public Call<Channel> rejectInvite(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return CallKt.map(this.retrofitApi.rejectInvite(str, str2, this.apiKey, this.connectionId, new RejectInviteRequest(false, 1, (DefaultConstructorMarker) null)), new GsonChatApi$rejectInvite$1(this));
    }

    public Call<Mute> muteCurrentUser() {
        return muteUser(this.userId);
    }

    public Call<Unit> unmuteCurrentUser() {
        return unmuteUser(this.userId);
    }

    public Call<Channel> acceptInvite(String str, String str2, String str3) {
        String str4 = str;
        Intrinsics.checkNotNullParameter(str4, "channelType");
        String str5 = str2;
        Intrinsics.checkNotNullParameter(str5, "channelId");
        RetrofitApi retrofitApi2 = this.retrofitApi;
        String str6 = this.apiKey;
        String str7 = this.connectionId;
        User user = new User((String) null, (String) null, false, false, (List) null, false, (Date) null, (Date) null, (Date) null, 0, 0, 0, (List) null, (List) null, (List) null, (Map) null, 65535, (DefaultConstructorMarker) null);
        user.setId(this.userId);
        Unit unit = Unit.INSTANCE;
        return CallKt.map(retrofitApi2.acceptInvite(str4, str5, str6, str7, new AcceptInviteRequest(user, new AcceptInviteRequest.AcceptInviteMessage(str3), false, 4, (DefaultConstructorMarker) null)), new GsonChatApi$acceptInvite$2(this));
    }

    public Call<Channel> deleteChannel(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return CallKt.map(this.retrofitApi.deleteChannel(str, str2, this.apiKey, this.connectionId), new GsonChatApi$deleteChannel$1(this));
    }

    public Call<Unit> markAllRead() {
        return CallKt.map(this.retrofitApi.markAllRead(this.apiKey, this.userId, this.connectionId), GsonChatApi$markAllRead$1.INSTANCE);
    }

    public Call<GuestUser> getGuestUser(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        Intrinsics.checkNotNullParameter(str2, TagPeopleActivity.USER_NAME);
        return CallKt.map(this.retrofitAnonymousApi.getGuestUser(this.apiKey, new GuestUserRequest(str, str2)), GsonChatApi$getGuestUser$1.INSTANCE);
    }

    public Call<List<User>> queryUsers(QueryUsersRequest queryUsersRequest) {
        Intrinsics.checkNotNullParameter(queryUsersRequest, "queryUsers");
        return CallKt.map(this.retrofitApi.queryUsers(this.apiKey, this.connectionId, queryUsersRequest), GsonChatApi$queryUsers$1.INSTANCE);
    }

    public Call<Channel> addMembers(String str, String str2, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(list, ModelFields.MEMBERS);
        return CallKt.map(this.retrofitApi.addMembers(str, str2, this.apiKey, this.connectionId, new AddMembersRequest(list)), new GsonChatApi$addMembers$1(this));
    }

    public Call<Channel> removeMembers(String str, String str2, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(list, ModelFields.MEMBERS);
        return CallKt.map(this.retrofitApi.removeMembers(str, str2, this.apiKey, this.connectionId, new RemoveMembersRequest(list)), new GsonChatApi$removeMembers$1(this));
    }

    public Call<List<Member>> queryMembers(String str, String str2, int i, int i2, FilterObject filterObject, QuerySort<Member> querySort, List<Member> list) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        FilterObject filterObject2 = filterObject;
        Intrinsics.checkNotNullParameter(filterObject2, "filter");
        QuerySort<Member> querySort2 = querySort;
        Intrinsics.checkNotNullParameter(querySort2, "sort");
        List<Member> list2 = list;
        Intrinsics.checkNotNullParameter(list2, ModelFields.MEMBERS);
        return CallKt.map(this.retrofitApi.queryMembers(this.apiKey, this.connectionId, new QueryMembersRequest(str, str2, filterObject2, i, i2, querySort2, list2)), GsonChatApi$queryMembers$1.INSTANCE);
    }

    public Call<Mute> muteUser(String str) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        RetrofitApi retrofitApi2 = this.retrofitApi;
        String str2 = this.apiKey;
        String str3 = this.userId;
        return CallKt.map(retrofitApi2.muteUser(str2, str3, this.connectionId, new MuteUserRequest(str, str3)), GsonChatApi$muteUser$1.INSTANCE);
    }

    public Call<Unit> unmuteUser(String str) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        RetrofitApi retrofitApi2 = this.retrofitApi;
        String str2 = this.apiKey;
        String str3 = this.userId;
        return CallKt.map(retrofitApi2.unMuteUser(str2, str3, this.connectionId, new MuteUserRequest(str, str3)), GsonChatApi$unmuteUser$1.INSTANCE);
    }

    public Call<Flag> flagUser(String str) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        return flag(MapsKt.mutableMapOf(TuplesKt.m181to(DeviceRequestsHelper.DEVICE_TARGET_USER_ID, str)));
    }

    public Call<Flag> flagMessage(String str) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        return flag(MapsKt.mutableMapOf(TuplesKt.m181to("target_message_id", str)));
    }

    private final Call<Flag> flag(Map<String, String> map) {
        return CallKt.map(this.retrofitApi.flag(this.apiKey, this.userId, this.connectionId, map), GsonChatApi$flag$1.INSTANCE);
    }

    public Call<CompletableResponse> banUser(String str, Integer num, String str2, String str3, String str4, boolean z) {
        Intrinsics.checkNotNullParameter(str, "targetId");
        String str5 = str3;
        Intrinsics.checkNotNullParameter(str5, "channelType");
        String str6 = str4;
        Intrinsics.checkNotNullParameter(str6, "channelId");
        return this.retrofitApi.banUser(this.apiKey, this.connectionId, new BanUserRequest(str, num, str2, str5, str6, z));
    }

    public Call<CompletableResponse> unBanUser(String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "targetId");
        Intrinsics.checkNotNullParameter(str2, "channelType");
        Intrinsics.checkNotNullParameter(str3, "channelId");
        return this.retrofitApi.unBanUser(this.apiKey, this.connectionId, str, str2, str3, z);
    }

    public Call<ChatEvent> sendEvent(String str, String str2, String str3, Map<Object, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "eventType");
        Intrinsics.checkNotNullParameter(str2, "channelType");
        Intrinsics.checkNotNullParameter(str3, "channelId");
        Intrinsics.checkNotNullParameter(map, "extraData");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("type", str);
        linkedHashMap.putAll(map);
        return CallKt.map(this.retrofitApi.sendEvent(str2, str3, this.apiKey, this.userId, this.connectionId, new SendEventRequest(linkedHashMap)), GsonChatApi$sendEvent$1.INSTANCE);
    }

    public Call<Message> translate(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        Intrinsics.checkNotNullParameter(str2, "language");
        return CallKt.map(this.retrofitApi.translate(str, this.apiKey, this.userId, this.connectionId, new TranslateMessageRequest(str2)), GsonChatApi$translate$1.INSTANCE);
    }

    public Call<List<ChatEvent>> getSyncHistory(List<String> list, Date date) {
        Intrinsics.checkNotNullParameter(list, "channelIds");
        Intrinsics.checkNotNullParameter(date, "lastSyncAt");
        return CallKt.map(this.retrofitApi.getSyncHistory(new GetSyncHistory(list, date), this.apiKey, this.userId, this.connectionId), GsonChatApi$getSyncHistory$1.INSTANCE);
    }

    public void warmUp() {
        this.retrofitApi.warmUp().enqueue();
    }

    private final <T> ErrorCall<T> noConnectionIdError() {
        return new ErrorCall<>(new ChatError("setUser is either not called or not finished", (Throwable) null, 2, (DefaultConstructorMarker) null));
    }

    /* access modifiers changed from: private */
    public final List<Channel> flattenChannels(List<ChannelResponse> list) {
        Iterable<ChannelResponse> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ChannelResponse flattenChannel : iterable) {
            arrayList.add(flattenChannel(flattenChannel));
        }
        return (List) arrayList;
    }

    /* access modifiers changed from: private */
    public final Channel flattenChannel(ChannelResponse channelResponse) {
        channelResponse.getChannel().setWatcherCount(channelResponse.getWatcher_count());
        Channel channel = channelResponse.getChannel();
        List<ChannelUserRead> read = channelResponse.getRead();
        if (read == null) {
            read = CollectionsKt.emptyList();
        }
        channel.setRead(read);
        Channel channel2 = channelResponse.getChannel();
        List<Member> members = channelResponse.getMembers();
        if (members == null) {
            members = CollectionsKt.emptyList();
        }
        channel2.setMembers(members);
        Channel channel3 = channelResponse.getChannel();
        List<Message> messages = channelResponse.getMessages();
        if (messages == null) {
            messages = CollectionsKt.emptyList();
        }
        Iterable<Message> iterable = messages;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Message enrichWithCid : iterable) {
            arrayList.add(MessageExtensionsKt.enrichWithCid(enrichWithCid, channelResponse.getChannel().getCid()));
        }
        channel3.setMessages((List) arrayList);
        Channel channel4 = channelResponse.getChannel();
        List<User> watchers = channelResponse.getWatchers();
        if (watchers == null) {
            watchers = CollectionsKt.emptyList();
        }
        channel4.setWatchers(watchers);
        channelResponse.getChannel().setHidden(channelResponse.getHidden());
        channelResponse.getChannel().setHiddenMessagesBefore(channelResponse.getHide_messages_before());
        return channelResponse.getChannel();
    }

    private final void verifyMessageId(Message message) {
        if (message.getId().length() == 0) {
            message.setId(this.userId + CoreConfig.ENTITY_TOKEN_PREFIX + this.uuidGenerator.generate());
        }
    }
}
