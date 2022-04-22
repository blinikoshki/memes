package p015io.getstream.chat.android.client.extensions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p015io.getstream.chat.android.client.models.Attachment;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00068@X\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007\",\u0010\t\u001a\u0004\u0018\u00010\u0001*\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00018F@FX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, mo26107d2 = {"ATTACHMENT_TYPE_FILE", "", "ATTACHMENT_TYPE_IMAGE", "EXTRA_UPLOAD_ID", "isImage", "", "Lio/getstream/chat/android/client/models/Attachment;", "(Lio/getstream/chat/android/client/models/Attachment;)Z", "value", "uploadId", "getUploadId", "(Lio/getstream/chat/android/client/models/Attachment;)Ljava/lang/String;", "setUploadId", "(Lio/getstream/chat/android/client/models/Attachment;Ljava/lang/String;)V", "stream-chat-android-client_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.extensions.AttachmentExtensionsKt */
/* compiled from: AttachmentExtensions.kt */
public final class AttachmentExtensionsKt {
    public static final String ATTACHMENT_TYPE_FILE = "file";
    public static final String ATTACHMENT_TYPE_IMAGE = "image";
    private static final String EXTRA_UPLOAD_ID = "uploadId";

    public static final boolean isImage(Attachment attachment) {
        Intrinsics.checkNotNullParameter(attachment, "$this$isImage");
        String mimeType = attachment.getMimeType();
        if (mimeType != null) {
            return StringsKt.startsWith$default(mimeType, "image", false, 2, (Object) null);
        }
        return false;
    }

    public static final String getUploadId(Attachment attachment) {
        Intrinsics.checkNotNullParameter(attachment, "$this$uploadId");
        return (String) attachment.getExtraData().get(EXTRA_UPLOAD_ID);
    }

    public static final void setUploadId(Attachment attachment, String str) {
        Intrinsics.checkNotNullParameter(attachment, "$this$uploadId");
        if (str != null) {
            attachment.getExtraData().put(EXTRA_UPLOAD_ID, str);
        }
    }
}
