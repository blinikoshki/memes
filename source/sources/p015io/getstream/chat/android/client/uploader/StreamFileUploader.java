package p015io.getstream.chat.android.client.uploader;

import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import p015io.getstream.chat.android.client.api.RetrofitCdnApi;
import p015io.getstream.chat.android.client.api.models.ProgressRequestBody;
import p015io.getstream.chat.android.client.api.models.UploadFileResponse;
import p015io.getstream.chat.android.client.extensions.FileExtensionsKt;
import p015io.getstream.chat.android.client.utils.ProgressCallback;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J0\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0016J0\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0016J2\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J:\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J2\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J:\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo26107d2 = {"Lio/getstream/chat/android/client/uploader/StreamFileUploader;", "Lio/getstream/chat/android/client/uploader/FileUploader;", "apiKey", "", "retrofitCdnApi", "Lio/getstream/chat/android/client/api/RetrofitCdnApi;", "(Ljava/lang/String;Lio/getstream/chat/android/client/api/RetrofitCdnApi;)V", "deleteFile", "", "channelType", "channelId", "userId", "connectionId", "url", "deleteImage", "sendFile", "file", "Ljava/io/File;", "callback", "Lio/getstream/chat/android/client/utils/ProgressCallback;", "sendImage", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.uploader.StreamFileUploader */
/* compiled from: StreamFileUploader.kt */
public final class StreamFileUploader implements FileUploader {
    private final String apiKey;
    private final RetrofitCdnApi retrofitCdnApi;

    public StreamFileUploader(String str, RetrofitCdnApi retrofitCdnApi2) {
        Intrinsics.checkNotNullParameter(str, "apiKey");
        Intrinsics.checkNotNullParameter(retrofitCdnApi2, "retrofitCdnApi");
        this.apiKey = str;
        this.retrofitCdnApi = retrofitCdnApi2;
    }

    public String sendFile(String str, String str2, String str3, String str4, File file, ProgressCallback progressCallback) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, TagPeopleActivity.USER_ID);
        Intrinsics.checkNotNullParameter(str4, "connectionId");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(progressCallback, "callback");
        String str5 = str;
        String str6 = str2;
        Result<UploadFileResponse> execute = this.retrofitCdnApi.sendFile(str5, str6, MultipartBody.Part.Companion.createFormData("file", file.getName(), new ProgressRequestBody(file, progressCallback)), this.apiKey, str3, str4).execute();
        if (execute.isSuccess()) {
            return execute.data().getFile();
        }
        return null;
    }

    public String sendFile(String str, String str2, String str3, String str4, File file) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, TagPeopleActivity.USER_ID);
        Intrinsics.checkNotNullParameter(str4, "connectionId");
        Intrinsics.checkNotNullParameter(file, "file");
        String str5 = str;
        String str6 = str2;
        Result<UploadFileResponse> execute = this.retrofitCdnApi.sendFile(str5, str6, MultipartBody.Part.Companion.createFormData("file", file.getName(), RequestBody.Companion.create(file, FileExtensionsKt.getMediaType(file))), this.apiKey, str3, str4).execute();
        if (execute.isSuccess()) {
            return execute.data().getFile();
        }
        return null;
    }

    public String sendImage(String str, String str2, String str3, String str4, File file, ProgressCallback progressCallback) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, TagPeopleActivity.USER_ID);
        Intrinsics.checkNotNullParameter(str4, "connectionId");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(progressCallback, "callback");
        String str5 = str;
        String str6 = str2;
        Result<UploadFileResponse> execute = this.retrofitCdnApi.sendImage(str5, str6, MultipartBody.Part.Companion.createFormData("file", file.getName(), new ProgressRequestBody(file, progressCallback)), this.apiKey, str3, str4).execute();
        if (execute.isSuccess()) {
            return execute.data().getFile();
        }
        return null;
    }

    public String sendImage(String str, String str2, String str3, String str4, File file) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, TagPeopleActivity.USER_ID);
        Intrinsics.checkNotNullParameter(str4, "connectionId");
        Intrinsics.checkNotNullParameter(file, "file");
        String str5 = str;
        String str6 = str2;
        Result<UploadFileResponse> execute = this.retrofitCdnApi.sendImage(str5, str6, MultipartBody.Part.Companion.createFormData("file", file.getName(), RequestBody.Companion.create(file, FileExtensionsKt.getMediaType(file))), this.apiKey, str3, str4).execute();
        if (execute.isSuccess()) {
            return execute.data().getFile();
        }
        return null;
    }

    public void deleteFile(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, TagPeopleActivity.USER_ID);
        Intrinsics.checkNotNullParameter(str4, "connectionId");
        Intrinsics.checkNotNullParameter(str5, "url");
        this.retrofitCdnApi.deleteFile(str, str2, this.apiKey, str4, str5).execute();
    }

    public void deleteImage(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, TagPeopleActivity.USER_ID);
        Intrinsics.checkNotNullParameter(str4, "connectionId");
        Intrinsics.checkNotNullParameter(str5, "url");
        this.retrofitCdnApi.deleteImage(str, str2, this.apiKey, str4, str5).execute();
    }
}
