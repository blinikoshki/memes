package p015io.getstream.chat.android.client.api;

import kotlin.Metadata;
import p015io.getstream.chat.android.client.api.models.GuestUserRequest;
import p015io.getstream.chat.android.client.api.models.TokenResponse;
import p015io.getstream.chat.android.client.call.RetrofitCall;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'¨\u0006\t"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/RetrofitAnonymousApi;", "", "getGuestUser", "Lio/getstream/chat/android/client/call/RetrofitCall;", "Lio/getstream/chat/android/client/api/models/TokenResponse;", "apiKey", "", "body", "Lio/getstream/chat/android/client/api/models/GuestUserRequest;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
@AnonymousApi
/* renamed from: io.getstream.chat.android.client.api.RetrofitAnonymousApi */
/* compiled from: RetrofitAnonymousApi.kt */
public interface RetrofitAnonymousApi {
    @POST("/guest")
    RetrofitCall<TokenResponse> getGuestUser(@Query("api_key") String str, @Body GuestUserRequest guestUserRequest);
}
