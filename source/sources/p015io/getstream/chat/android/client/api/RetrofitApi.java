package p015io.getstream.chat.android.client.api;

import java.util.Map;
import kotlin.Metadata;
import okhttp3.ResponseBody;
import p015io.getstream.chat.android.client.api.models.AcceptInviteRequest;
import p015io.getstream.chat.android.client.api.models.AddDeviceRequest;
import p015io.getstream.chat.android.client.api.models.AddMembersRequest;
import p015io.getstream.chat.android.client.api.models.BanUserRequest;
import p015io.getstream.chat.android.client.api.models.ChannelResponse;
import p015io.getstream.chat.android.client.api.models.CompletableResponse;
import p015io.getstream.chat.android.client.api.models.EventResponse;
import p015io.getstream.chat.android.client.api.models.FlagResponse;
import p015io.getstream.chat.android.client.api.models.GetDevicesResponse;
import p015io.getstream.chat.android.client.api.models.GetReactionsResponse;
import p015io.getstream.chat.android.client.api.models.GetRepliesResponse;
import p015io.getstream.chat.android.client.api.models.GetSyncHistory;
import p015io.getstream.chat.android.client.api.models.GetSyncHistoryResponse;
import p015io.getstream.chat.android.client.api.models.HideChannelRequest;
import p015io.getstream.chat.android.client.api.models.MarkReadRequest;
import p015io.getstream.chat.android.client.api.models.MessageRequest;
import p015io.getstream.chat.android.client.api.models.MessageResponse;
import p015io.getstream.chat.android.client.api.models.MuteChannelRequest;
import p015io.getstream.chat.android.client.api.models.MuteUserRequest;
import p015io.getstream.chat.android.client.api.models.MuteUserResponse;
import p015io.getstream.chat.android.client.api.models.QueryChannelRequest;
import p015io.getstream.chat.android.client.api.models.QueryChannelsRequest;
import p015io.getstream.chat.android.client.api.models.QueryChannelsResponse;
import p015io.getstream.chat.android.client.api.models.QueryMembersRequest;
import p015io.getstream.chat.android.client.api.models.QueryMembersResponse;
import p015io.getstream.chat.android.client.api.models.QueryUserListResponse;
import p015io.getstream.chat.android.client.api.models.QueryUsersRequest;
import p015io.getstream.chat.android.client.api.models.ReactionRequest;
import p015io.getstream.chat.android.client.api.models.ReactionResponse;
import p015io.getstream.chat.android.client.api.models.RejectInviteRequest;
import p015io.getstream.chat.android.client.api.models.RemoveMembersRequest;
import p015io.getstream.chat.android.client.api.models.SearchMessagesRequest;
import p015io.getstream.chat.android.client.api.models.SearchMessagesResponse;
import p015io.getstream.chat.android.client.api.models.SendActionRequest;
import p015io.getstream.chat.android.client.api.models.SendEventRequest;
import p015io.getstream.chat.android.client.api.models.TranslateMessageRequest;
import p015io.getstream.chat.android.client.api.models.UpdateChannelRequest;
import p015io.getstream.chat.android.client.api.models.UpdateCooldownRequest;
import p015io.getstream.chat.android.client.api.models.UpdateUsersRequest;
import p015io.getstream.chat.android.client.api.models.UpdateUsersResponse;
import p015io.getstream.chat.android.client.call.RetrofitCall;
import p015io.getstream.chat.android.client.parser.UrlQueryPayload;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.OPTIONS;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000¤\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u000bH'J6\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u0011H'J@\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0013H'J,\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0015H'J6\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u0006H'J6\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0018\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u0006H'J6\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u0006H'J@\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u00062\b\b\u0001\u0010\u001d\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u0006H'JB\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00032\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\u0014\b\u0001\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060 H'J,\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00032\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u0006H'J6\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u0006H'J@\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010&\u001a\u00020'2\b\b\u0001\u0010(\u001a\u00020'H'J@\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010(\u001a\u00020'H'JJ\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010(\u001a\u00020'2\b\b\u0001\u0010,\u001a\u00020\u0006H'J6\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00032\b\b\u0001\u0010\n\u001a\u00020/2\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u0006H'J@\u00100\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u000201H'J,\u00102\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u0006H'JJ\u00103\u001a\b\u0012\u0004\u0012\u0002040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u000205H'J6\u00106\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u000207H'J6\u00108\u001a\b\u0012\u0004\u0012\u0002090\u00032\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020:H'J@\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020<H'JJ\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020<H'J6\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u00032\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010?\u001a\u00020@H'J,\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\u00032\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010?\u001a\u00020CH'J,\u0010D\u001a\b\u0012\u0004\u0012\u00020E0\u00032\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010?\u001a\u00020FH'J@\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020HH'J@\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020JH'J,\u0010K\u001a\b\u0012\u0004\u0012\u00020L0\u00032\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010?\u001a\u00020MH'J@\u0010N\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020OH'JJ\u0010P\u001a\b\u0012\u0004\u0012\u0002040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020QH'JJ\u0010R\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010S\u001a\u00020TH'J@\u0010U\u001a\b\u0012\u0004\u0012\u00020V0\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020WH'JL\u0010X\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\u0014\b\u0001\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010 H'JL\u0010Y\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\u0014\b\u0001\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010 H'J@\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020[H'JJ\u0010\\\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010]\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010^\u001a\u00020_H'J6\u0010`\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u000207H'J6\u0010a\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020:H'J@\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020cH'J@\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020eH'J@\u0010f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010S\u001a\u00020TH'J,\u0010g\u001a\b\u0012\u0004\u0012\u00020h0\u00032\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020iH'J\u000e\u0010j\u001a\b\u0012\u0004\u0012\u00020k0\u0003H'¨\u0006l"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/RetrofitApi;", "", "acceptInvite", "Lio/getstream/chat/android/client/call/RetrofitCall;", "Lio/getstream/chat/android/client/api/models/ChannelResponse;", "channelType", "", "channelId", "apiKey", "clientID", "body", "Lio/getstream/chat/android/client/api/models/AcceptInviteRequest;", "addDevices", "Lio/getstream/chat/android/client/api/models/CompletableResponse;", "userId", "connectionId", "request", "Lio/getstream/chat/android/client/api/models/AddDeviceRequest;", "addMembers", "Lio/getstream/chat/android/client/api/models/AddMembersRequest;", "banUser", "Lio/getstream/chat/android/client/api/models/BanUserRequest;", "deleteChannel", "deleteDevice", "deviceId", "deleteMessage", "Lio/getstream/chat/android/client/api/models/MessageResponse;", "messageId", "deleteReaction", "reactionType", "flag", "Lio/getstream/chat/android/client/api/models/FlagResponse;", "", "getDevices", "Lio/getstream/chat/android/client/api/models/GetDevicesResponse;", "getMessage", "getReactions", "Lio/getstream/chat/android/client/api/models/GetReactionsResponse;", "offset", "", "limit", "getReplies", "Lio/getstream/chat/android/client/api/models/GetRepliesResponse;", "getRepliesMore", "firstId", "getSyncHistory", "Lio/getstream/chat/android/client/api/models/GetSyncHistoryResponse;", "Lio/getstream/chat/android/client/api/models/GetSyncHistory;", "hideChannel", "Lio/getstream/chat/android/client/api/models/HideChannelRequest;", "markAllRead", "markRead", "Lio/getstream/chat/android/client/api/models/EventResponse;", "Lio/getstream/chat/android/client/api/models/MarkReadRequest;", "muteChannel", "Lio/getstream/chat/android/client/api/models/MuteChannelRequest;", "muteUser", "Lio/getstream/chat/android/client/api/models/MuteUserResponse;", "Lio/getstream/chat/android/client/api/models/MuteUserRequest;", "queryChannel", "Lio/getstream/chat/android/client/api/models/QueryChannelRequest;", "queryChannels", "Lio/getstream/chat/android/client/api/models/QueryChannelsResponse;", "payload", "Lio/getstream/chat/android/client/api/models/QueryChannelsRequest;", "queryMembers", "Lio/getstream/chat/android/client/api/models/QueryMembersResponse;", "Lio/getstream/chat/android/client/api/models/QueryMembersRequest;", "queryUsers", "Lio/getstream/chat/android/client/api/models/QueryUserListResponse;", "Lio/getstream/chat/android/client/api/models/QueryUsersRequest;", "rejectInvite", "Lio/getstream/chat/android/client/api/models/RejectInviteRequest;", "removeMembers", "Lio/getstream/chat/android/client/api/models/RemoveMembersRequest;", "searchMessages", "Lio/getstream/chat/android/client/api/models/SearchMessagesResponse;", "Lio/getstream/chat/android/client/api/models/SearchMessagesRequest;", "sendAction", "Lio/getstream/chat/android/client/api/models/SendActionRequest;", "sendEvent", "Lio/getstream/chat/android/client/api/models/SendEventRequest;", "sendMessage", "message", "Lio/getstream/chat/android/client/api/models/MessageRequest;", "sendReaction", "Lio/getstream/chat/android/client/api/models/ReactionResponse;", "Lio/getstream/chat/android/client/api/models/ReactionRequest;", "showChannel", "stopWatching", "translate", "Lio/getstream/chat/android/client/api/models/TranslateMessageRequest;", "unBanUser", "targetUserId", "shadow", "", "unMuteChannel", "unMuteUser", "updateChannel", "Lio/getstream/chat/android/client/api/models/UpdateChannelRequest;", "updateCooldown", "Lio/getstream/chat/android/client/api/models/UpdateCooldownRequest;", "updateMessage", "updateUsers", "Lio/getstream/chat/android/client/api/models/UpdateUsersResponse;", "Lio/getstream/chat/android/client/api/models/UpdateUsersRequest;", "warmUp", "Lokhttp3/ResponseBody;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
@AuthenticatedApi
/* renamed from: io.getstream.chat.android.client.api.RetrofitApi */
/* compiled from: RetrofitApi.kt */
public interface RetrofitApi {
    @POST("/channels/{type}/{id}")
    RetrofitCall<ChannelResponse> acceptInvite(@Path("type") String str, @Path("id") String str2, @Query("api_key") String str3, @Query("client_id") String str4, @Body AcceptInviteRequest acceptInviteRequest);

    @POST("devices")
    RetrofitCall<CompletableResponse> addDevices(@Query("api_key") String str, @Query("user_id") String str2, @Query("client_id") String str3, @Body AddDeviceRequest addDeviceRequest);

    @POST("/channels/{type}/{id}")
    RetrofitCall<ChannelResponse> addMembers(@Path("type") String str, @Path("id") String str2, @Query("api_key") String str3, @Query("client_id") String str4, @Body AddMembersRequest addMembersRequest);

    @POST("/moderation/ban")
    RetrofitCall<CompletableResponse> banUser(@Query("api_key") String str, @Query("client_id") String str2, @Body BanUserRequest banUserRequest);

    @DELETE("/channels/{type}/{id}")
    RetrofitCall<ChannelResponse> deleteChannel(@Path("type") String str, @Path("id") String str2, @Query("api_key") String str3, @Query("client_id") String str4);

    @DELETE("/devices")
    RetrofitCall<CompletableResponse> deleteDevice(@Query("id") String str, @Query("api_key") String str2, @Query("user_id") String str3, @Query("client_id") String str4);

    @DELETE("/messages/{id}")
    RetrofitCall<MessageResponse> deleteMessage(@Path("id") String str, @Query("api_key") String str2, @Query("user_id") String str3, @Query("client_id") String str4);

    @DELETE("/messages/{id}/reaction/{type}")
    RetrofitCall<MessageResponse> deleteReaction(@Path("id") String str, @Path("type") String str2, @Query("api_key") String str3, @Query("user_id") String str4, @Query("client_id") String str5);

    @POST("/moderation/flag")
    RetrofitCall<FlagResponse> flag(@Query("api_key") String str, @Query("user_id") String str2, @Query("client_id") String str3, @Body Map<String, String> map);

    @GET("/devices")
    RetrofitCall<GetDevicesResponse> getDevices(@Query("api_key") String str, @Query("user_id") String str2, @Query("client_id") String str3);

    @GET("/messages/{id}")
    RetrofitCall<MessageResponse> getMessage(@Path("id") String str, @Query("api_key") String str2, @Query("user_id") String str3, @Query("client_id") String str4);

    @GET("/messages/{id}/reactions")
    RetrofitCall<GetReactionsResponse> getReactions(@Path("id") String str, @Query("api_key") String str2, @Query("client_id") String str3, @Query("offset") int i, @Query("limit") int i2);

    @GET("/messages/{parent_id}/replies")
    RetrofitCall<GetRepliesResponse> getReplies(@Path("parent_id") String str, @Query("api_key") String str2, @Query("user_id") String str3, @Query("client_id") String str4, @Query("limit") int i);

    @GET("/messages/{parent_id}/replies")
    RetrofitCall<GetRepliesResponse> getRepliesMore(@Path("parent_id") String str, @Query("api_key") String str2, @Query("user_id") String str3, @Query("client_id") String str4, @Query("limit") int i, @Query("id_lt") String str5);

    @POST("/sync")
    RetrofitCall<GetSyncHistoryResponse> getSyncHistory(@Body GetSyncHistory getSyncHistory, @Query("api_key") String str, @Query("user_id") String str2, @Query("connection_id") String str3);

    @POST("/channels/{type}/{id}/hide")
    RetrofitCall<CompletableResponse> hideChannel(@Path("type") String str, @Path("id") String str2, @Query("api_key") String str3, @Query("client_id") String str4, @Body HideChannelRequest hideChannelRequest);

    @POST("/channels/read")
    RetrofitCall<CompletableResponse> markAllRead(@Query("api_key") String str, @Query("user_id") String str2, @Query("client_id") String str3);

    @POST("/channels/{type}/{id}/read")
    RetrofitCall<EventResponse> markRead(@Path("type") String str, @Path("id") String str2, @Query("api_key") String str3, @Query("user_id") String str4, @Query("client_id") String str5, @Body MarkReadRequest markReadRequest);

    @POST("/moderation/mute/channel")
    RetrofitCall<CompletableResponse> muteChannel(@Query("api_key") String str, @Query("user_id") String str2, @Query("connection_id") String str3, @Body MuteChannelRequest muteChannelRequest);

    @POST("/moderation/mute")
    RetrofitCall<MuteUserResponse> muteUser(@Query("api_key") String str, @Query("user_id") String str2, @Query("client_id") String str3, @Body MuteUserRequest muteUserRequest);

    @POST("/channels/{type}/query")
    RetrofitCall<ChannelResponse> queryChannel(@Path("type") String str, @Query("api_key") String str2, @Query("user_id") String str3, @Query("client_id") String str4, @Body QueryChannelRequest queryChannelRequest);

    @POST("/channels/{type}/{id}/query")
    RetrofitCall<ChannelResponse> queryChannel(@Path("type") String str, @Path("id") String str2, @Query("api_key") String str3, @Query("user_id") String str4, @Query("client_id") String str5, @Body QueryChannelRequest queryChannelRequest);

    @GET("/channels")
    RetrofitCall<QueryChannelsResponse> queryChannels(@Query("api_key") String str, @Query("user_id") String str2, @Query("client_id") String str3, @Query("payload") @UrlQueryPayload QueryChannelsRequest queryChannelsRequest);

    @GET("/members")
    RetrofitCall<QueryMembersResponse> queryMembers(@Query("api_key") String str, @Query("connection_id") String str2, @Query("payload") @UrlQueryPayload QueryMembersRequest queryMembersRequest);

    @GET("/users")
    RetrofitCall<QueryUserListResponse> queryUsers(@Query("api_key") String str, @Query("client_id") String str2, @Query("payload") @UrlQueryPayload QueryUsersRequest queryUsersRequest);

    @POST("/channels/{type}/{id}")
    RetrofitCall<ChannelResponse> rejectInvite(@Path("type") String str, @Path("id") String str2, @Query("api_key") String str3, @Query("client_id") String str4, @Body RejectInviteRequest rejectInviteRequest);

    @POST("/channels/{type}/{id}")
    RetrofitCall<ChannelResponse> removeMembers(@Path("type") String str, @Path("id") String str2, @Query("api_key") String str3, @Query("client_id") String str4, @Body RemoveMembersRequest removeMembersRequest);

    @GET("/search")
    RetrofitCall<SearchMessagesResponse> searchMessages(@Query("api_key") String str, @Query("client_id") String str2, @Query("payload") @UrlQueryPayload SearchMessagesRequest searchMessagesRequest);

    @POST("/messages/{id}/action")
    RetrofitCall<MessageResponse> sendAction(@Path("id") String str, @Query("api_key") String str2, @Query("user_id") String str3, @Query("client_id") String str4, @Body SendActionRequest sendActionRequest);

    @POST("/channels/{type}/{id}/event")
    RetrofitCall<EventResponse> sendEvent(@Path("type") String str, @Path("id") String str2, @Query("api_key") String str3, @Query("user_id") String str4, @Query("client_id") String str5, @Body SendEventRequest sendEventRequest);

    @POST("/channels/{type}/{id}/message")
    RetrofitCall<MessageResponse> sendMessage(@Path("type") String str, @Path("id") String str2, @Query("api_key") String str3, @Query("user_id") String str4, @Query("client_id") String str5, @Body MessageRequest messageRequest);

    @POST("/messages/{id}/reaction")
    RetrofitCall<ReactionResponse> sendReaction(@Path("id") String str, @Query("api_key") String str2, @Query("user_id") String str3, @Query("client_id") String str4, @Body ReactionRequest reactionRequest);

    @POST("/channels/{type}/{id}/show")
    RetrofitCall<CompletableResponse> showChannel(@Path("type") String str, @Path("id") String str2, @Query("api_key") String str3, @Query("client_id") String str4, @Body Map<Object, Object> map);

    @POST("/channels/{type}/{id}/stop-watching")
    RetrofitCall<CompletableResponse> stopWatching(@Path("type") String str, @Path("id") String str2, @Query("api_key") String str3, @Query("client_id") String str4, @Body Map<Object, Object> map);

    @POST("/messages/{messageId}/translate")
    RetrofitCall<MessageResponse> translate(@Path("messageId") String str, @Query("api_key") String str2, @Query("user_id") String str3, @Query("connection_id") String str4, @Body TranslateMessageRequest translateMessageRequest);

    @DELETE("/moderation/ban")
    RetrofitCall<CompletableResponse> unBanUser(@Query("api_key") String str, @Query("client_id") String str2, @Query("target_user_id") String str3, @Query("type") String str4, @Query("id") String str5, @Query("shadow") boolean z);

    @POST("/moderation/unmute/channel")
    RetrofitCall<CompletableResponse> unMuteChannel(@Query("api_key") String str, @Query("user_id") String str2, @Query("connection_id") String str3, @Body MuteChannelRequest muteChannelRequest);

    @POST("/moderation/unmute")
    RetrofitCall<CompletableResponse> unMuteUser(@Query("api_key") String str, @Query("user_id") String str2, @Query("client_id") String str3, @Body MuteUserRequest muteUserRequest);

    @POST("/channels/{type}/{id}")
    RetrofitCall<ChannelResponse> updateChannel(@Path("type") String str, @Path("id") String str2, @Query("api_key") String str3, @Query("client_id") String str4, @Body UpdateChannelRequest updateChannelRequest);

    @POST("/channels/{type}/{id}")
    RetrofitCall<ChannelResponse> updateCooldown(@Path("type") String str, @Path("id") String str2, @Query("api_key") String str3, @Query("client_id") String str4, @Body UpdateCooldownRequest updateCooldownRequest);

    @POST("/messages/{id}")
    RetrofitCall<MessageResponse> updateMessage(@Path("id") String str, @Query("api_key") String str2, @Query("user_id") String str3, @Query("client_id") String str4, @Body MessageRequest messageRequest);

    @POST("/users")
    RetrofitCall<UpdateUsersResponse> updateUsers(@Query("api_key") String str, @Query("connection_id") String str2, @Body UpdateUsersRequest updateUsersRequest);

    @OPTIONS("/connect")
    RetrofitCall<ResponseBody> warmUp();
}
