package p015io.getstream.chat.android.client.api;

import kotlin.Metadata;
import okhttp3.MultipartBody;
import p015io.getstream.chat.android.client.api.models.CompletableResponse;
import p015io.getstream.chat.android.client.api.models.UploadFileResponse;
import p015io.getstream.chat.android.client.call.RetrofitCall;
import retrofit2.http.DELETE;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0006H'J@\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0006H'JJ\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u0006H'JJ\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u0006H'¨\u0006\u0012"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/RetrofitCdnApi;", "", "deleteFile", "Lio/getstream/chat/android/client/call/RetrofitCall;", "Lio/getstream/chat/android/client/api/models/CompletableResponse;", "channelType", "", "channelId", "apiKey", "connectionId", "url", "deleteImage", "sendFile", "Lio/getstream/chat/android/client/api/models/UploadFileResponse;", "file", "Lokhttp3/MultipartBody$Part;", "userId", "sendImage", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
@AuthenticatedApi
/* renamed from: io.getstream.chat.android.client.api.RetrofitCdnApi */
/* compiled from: RetrofitCdnApi.kt */
public interface RetrofitCdnApi {
    @DELETE("/channels/{type}/{id}/file")
    RetrofitCall<CompletableResponse> deleteFile(@Path("type") String str, @Path("id") String str2, @Query("api_key") String str3, @Query("client_id") String str4, @Query("url") String str5);

    @DELETE("/channels/{type}/{id}/image")
    RetrofitCall<CompletableResponse> deleteImage(@Path("type") String str, @Path("id") String str2, @Query("api_key") String str3, @Query("client_id") String str4, @Query("url") String str5);

    @POST("/channels/{type}/{id}/file")
    @Multipart
    RetrofitCall<UploadFileResponse> sendFile(@Path("type") String str, @Path("id") String str2, @Part MultipartBody.Part part, @Query("api_key") String str3, @Query("user_id") String str4, @Query("client_id") String str5);

    @POST("/channels/{type}/{id}/image")
    @Multipart
    RetrofitCall<UploadFileResponse> sendImage(@Path("type") String str, @Path("id") String str2, @Part MultipartBody.Part part, @Query("api_key") String str3, @Query("user_id") String str4, @Query("client_id") String str5);
}
