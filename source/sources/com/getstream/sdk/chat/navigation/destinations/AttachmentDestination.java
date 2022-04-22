package com.getstream.sdk.chat.navigation.destinations;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.getstream.sdk.chat.model.ModelType;
import com.getstream.sdk.chat.utils.frescoimageviewer.ImageViewer;
import com.getstream.sdk.chat.view.activity.AttachmentActivity;
import com.getstream.sdk.chat.view.activity.AttachmentDocumentActivity;
import com.getstream.sdk.chat.view.activity.AttachmentMediaActivity;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.models.Attachment;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.p016ui.common.C1891R;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0016\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014J\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, mo26107d2 = {"Lcom/getstream/sdk/chat/navigation/destinations/AttachmentDestination;", "Lcom/getstream/sdk/chat/navigation/destinations/ChatDestination;", "message", "Lio/getstream/chat/android/client/models/Message;", "attachment", "Lio/getstream/chat/android/client/models/Attachment;", "context", "Landroid/content/Context;", "(Lio/getstream/chat/android/client/models/Message;Lio/getstream/chat/android/client/models/Attachment;Landroid/content/Context;)V", "getAttachment", "()Lio/getstream/chat/android/client/models/Attachment;", "setAttachment", "(Lio/getstream/chat/android/client/models/Attachment;)V", "getMessage", "()Lio/getstream/chat/android/client/models/Message;", "setMessage", "(Lio/getstream/chat/android/client/models/Message;)V", "loadFile", "", "navigate", "showAttachment", "showImageViewer", "isGif", "", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AttachmentDestination.kt */
public class AttachmentDestination extends ChatDestination {
    private Attachment attachment;
    private Message message;

    public final Message getMessage() {
        return this.message;
    }

    public final void setMessage(Message message2) {
        Intrinsics.checkNotNullParameter(message2, "<set-?>");
        this.message = message2;
    }

    public final Attachment getAttachment() {
        return this.attachment;
    }

    public final void setAttachment(Attachment attachment2) {
        Intrinsics.checkNotNullParameter(attachment2, "<set-?>");
        this.attachment = attachment2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AttachmentDestination(Message message2, Attachment attachment2, Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(message2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(attachment2, MessengerShareContentUtility.ATTACHMENT);
        Intrinsics.checkNotNullParameter(context, "context");
        this.message = message2;
        this.attachment = attachment2;
    }

    public void navigate() {
        showAttachment(this.message, this.attachment);
    }

    public final void showAttachment(Message message2, Attachment attachment2) {
        Intrinsics.checkNotNullParameter(message2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(attachment2, MessengerShareContentUtility.ATTACHMENT);
        String str = null;
        String type = attachment2.getType();
        String type2 = attachment2.getType();
        if (type2 != null) {
            switch (type2.hashCode()) {
                case -309474065:
                    if (type2.equals(ModelType.attach_product)) {
                        str = attachment2.getUrl();
                        break;
                    }
                    break;
                case 3143036:
                    if (type2.equals("file")) {
                        loadFile(attachment2);
                        return;
                    }
                    break;
                case 98361695:
                    if (type2.equals(ModelType.attach_giphy)) {
                        str = attachment2.getThumbUrl();
                        break;
                    }
                    break;
                case 100313435:
                    if (type2.equals("image")) {
                        if (attachment2.getOgUrl() != null) {
                            str = attachment2.getOgUrl();
                            type = "link";
                            break;
                        } else if (isGif(attachment2)) {
                            str = attachment2.getImageUrl();
                            type = ModelType.attach_giphy;
                            break;
                        } else {
                            showImageViewer(message2, attachment2);
                            return;
                        }
                    }
                    break;
                case 112202875:
                    if (type2.equals("video")) {
                        str = attachment2.getAssetUrl();
                        break;
                    }
                    break;
            }
        }
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            Toast.makeText(getContext(), getContext().getString(C1891R.string.stream_attachment_invalid_url), 0).show();
            return;
        }
        Intent intent = new Intent(getContext(), AttachmentActivity.class);
        intent.putExtra("type", type);
        intent.putExtra("url", str);
        start(intent);
    }

    private final void loadFile(Attachment attachment2) {
        String mimeType = attachment2.getMimeType();
        String assetUrl = attachment2.getAssetUrl();
        if (mimeType == null) {
            ChatLogger instance = ChatLogger.Companion.getInstance();
            instance.logE((Object) "AttachmentDestination", "MimeType is null for url " + assetUrl);
            Toast.makeText(getContext(), getContext().getString(C1891R.string.stream_attachment_invalid_mime_type, new Object[]{attachment2.getName()}), 0).show();
            return;
        }
        CharSequence charSequence = mimeType;
        if (StringsKt.contains$default(charSequence, (CharSequence) MimeTypes.BASE_TYPE_AUDIO, false, 2, (Object) null) || StringsKt.contains$default(charSequence, (CharSequence) "video", false, 2, (Object) null)) {
            Intent intent = new Intent(getContext(), AttachmentMediaActivity.class);
            intent.putExtra("type", mimeType);
            intent.putExtra("url", assetUrl);
            start(intent);
        } else if (Intrinsics.areEqual((Object) mimeType, (Object) ModelType.attach_mime_doc) || Intrinsics.areEqual((Object) mimeType, (Object) ModelType.attach_mime_txt) || Intrinsics.areEqual((Object) mimeType, (Object) ModelType.attach_mime_pdf) || Intrinsics.areEqual((Object) mimeType, (Object) ModelType.attach_mime_html) || StringsKt.contains$default(charSequence, (CharSequence) "application/vnd", false, 2, (Object) null)) {
            Intent intent2 = new Intent(getContext(), AttachmentDocumentActivity.class);
            intent2.putExtra("url", assetUrl);
            start(intent2);
        }
    }

    /* access modifiers changed from: protected */
    public void showImageViewer(Message message2, Attachment attachment2) {
        int i;
        Intrinsics.checkNotNullParameter(message2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(attachment2, MessengerShareContentUtility.ATTACHMENT);
        Collection arrayList = new ArrayList();
        Iterator it = message2.getAttachments().iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Attachment attachment3 = (Attachment) next;
            if (Intrinsics.areEqual((Object) attachment3.getType(), (Object) "image")) {
                CharSequence imageUrl = attachment3.getImageUrl();
                if (!(imageUrl == null || imageUrl.length() == 0)) {
                    i = 1;
                }
            }
            if (i != 0) {
                arrayList.add(next);
            }
        }
        Collection arrayList2 = new ArrayList();
        for (Attachment imageUrl2 : (List) arrayList) {
            String imageUrl3 = imageUrl2.getImageUrl();
            if (imageUrl3 != null) {
                arrayList2.add(imageUrl3);
            }
        }
        List list = (List) arrayList2;
        if (list.isEmpty()) {
            Toast.makeText(getContext(), "Invalid image(s)!", 0).show();
            return;
        }
        int indexOf = message2.getAttachments().indexOf(attachment2);
        ImageViewer.Builder builder = new ImageViewer.Builder(getContext(), list);
        int size = list.size();
        if (indexOf >= 0 && size > indexOf) {
            i = indexOf;
        }
        builder.setStartPosition(i).show();
    }

    private final boolean isGif(Attachment attachment2) {
        String mimeType = attachment2.getMimeType();
        if (mimeType != null) {
            return StringsKt.contains$default((CharSequence) mimeType, (CharSequence) "gif", false, 2, (Object) null);
        }
        return false;
    }
}
