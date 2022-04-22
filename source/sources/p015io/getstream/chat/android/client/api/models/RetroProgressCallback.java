package p015io.getstream.chat.android.client.api.models;

import androidx.core.app.NotificationCompat;
import com.appsflyer.internal.referrer.Payload;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.utils.ProgressCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J$\u0010\f\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/RetroProgressCallback;", "Lretrofit2/Callback;", "Lio/getstream/chat/android/client/api/models/UploadFileResponse;", "callback", "Lio/getstream/chat/android/client/utils/ProgressCallback;", "(Lio/getstream/chat/android/client/utils/ProgressCallback;)V", "onFailure", "", "call", "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.RetroProgressCallback */
/* compiled from: RetroProgressCallback.kt */
public final class RetroProgressCallback implements Callback<UploadFileResponse> {
    private final ProgressCallback callback;

    public RetroProgressCallback(ProgressCallback progressCallback) {
        Intrinsics.checkNotNullParameter(progressCallback, "callback");
        this.callback = progressCallback;
    }

    public void onFailure(Call<UploadFileResponse> call, Throwable th) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(th, "t");
        this.callback.onError(new ChatError((String) null, th, 1, (DefaultConstructorMarker) null));
    }

    public void onResponse(Call<UploadFileResponse> call, Response<UploadFileResponse> response) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(response, Payload.RESPONSE);
        UploadFileResponse body = response.body();
        if (body == null) {
            onFailure(call, new RuntimeException("file response is null"));
            return;
        }
        this.callback.onSuccess(body.getFile());
    }
}
