package p015io.getstream.chat.android.livedata.usecase;

import android.app.DownloadManager;
import android.net.Uri;
import android.os.Environment;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.call.CoroutineCall;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.models.Attachment;
import p015io.getstream.chat.android.client.utils.Result;
import p015io.getstream.chat.android.livedata.ChatDomainImpl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/usecase/DownloadAttachmentImpl;", "Lio/getstream/chat/android/livedata/usecase/DownloadAttachment;", "domainImpl", "Lio/getstream/chat/android/livedata/ChatDomainImpl;", "(Lio/getstream/chat/android/livedata/ChatDomainImpl;)V", "invoke", "Lio/getstream/chat/android/client/call/Call;", "", "attachment", "Lio/getstream/chat/android/client/models/Attachment;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.usecase.DownloadAttachmentImpl */
/* compiled from: DownloadAttachment.kt */
public final class DownloadAttachmentImpl implements DownloadAttachment {
    private final ChatDomainImpl domainImpl;

    public DownloadAttachmentImpl(ChatDomainImpl chatDomainImpl) {
        Intrinsics.checkNotNullParameter(chatDomainImpl, "domainImpl");
        this.domainImpl = chatDomainImpl;
    }

    public Call<Unit> invoke(Attachment attachment) {
        Result result;
        Intrinsics.checkNotNullParameter(attachment, MessengerShareContentUtility.ATTACHMENT);
        try {
            Object systemService = this.domainImpl.getAppContext$stream_chat_android_offline_release().getSystemService("download");
            if (systemService != null) {
                DownloadManager downloadManager = (DownloadManager) systemService;
                String assetUrl = attachment.getAssetUrl();
                if (assetUrl == null) {
                    assetUrl = attachment.getImageUrl();
                }
                downloadManager.enqueue(new DownloadManager.Request(Uri.parse(assetUrl)).setTitle(attachment.getName()).setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, attachment.getName()).setNotificationVisibility(1));
                result = new Result(Unit.INSTANCE);
                return new CoroutineCall<>(this.domainImpl.getScope$stream_chat_android_offline_release(), new DownloadAttachmentImpl$invoke$1(result, (Continuation) null));
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.DownloadManager");
        } catch (Exception e) {
            result = new Result(new ChatError((String) null, e, 1, (DefaultConstructorMarker) null));
        }
    }
}
