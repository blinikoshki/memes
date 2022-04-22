package p015io.getstream.chat.android.client.api2;

import kotlin.Metadata;
import p015io.getstream.chat.android.client.api.AuthenticatedApi;
import p015io.getstream.chat.android.client.api2.model.requests.MessageRequest;
import p015io.getstream.chat.android.client.api2.model.response.MessageResponse;
import p015io.getstream.chat.android.client.call.RetrofitCall;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@MoshiApi
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u0006H'J6\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u0006H'JJ\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\f\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u000fH'J@\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u000fH'¨\u0006\u0011"}, mo26107d2 = {"Lio/getstream/chat/android/client/api2/MessageApi;", "", "deleteMessage", "Lio/getstream/chat/android/client/call/RetrofitCall;", "Lio/getstream/chat/android/client/api2/model/response/MessageResponse;", "messageId", "", "apiKey", "userId", "connectionId", "getMessage", "sendMessage", "channelType", "channelId", "message", "Lio/getstream/chat/android/client/api2/model/requests/MessageRequest;", "updateMessage", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
@AuthenticatedApi
/* renamed from: io.getstream.chat.android.client.api2.MessageApi */
/* compiled from: MessageApi.kt */
public interface MessageApi {
    @DELETE("/messages/{id}")
    RetrofitCall<MessageResponse> deleteMessage(@Path("id") String str, @Query("api_key") String str2, @Query("user_id") String str3, @Query("client_id") String str4);

    @GET("/messages/{id}")
    RetrofitCall<MessageResponse> getMessage(@Path("id") String str, @Query("api_key") String str2, @Query("user_id") String str3, @Query("client_id") String str4);

    @POST("/channels/{type}/{id}/message")
    RetrofitCall<MessageResponse> sendMessage(@Path("type") String str, @Path("id") String str2, @Query("api_key") String str3, @Query("user_id") String str4, @Query("client_id") String str5, @Body MessageRequest messageRequest);

    @POST("/messages/{id}")
    RetrofitCall<MessageResponse> updateMessage(@Path("id") String str, @Query("api_key") String str2, @Query("user_id") String str3, @Query("client_id") String str4, @Body MessageRequest messageRequest);
}
