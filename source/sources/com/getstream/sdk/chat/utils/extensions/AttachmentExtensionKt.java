package com.getstream.sdk.chat.utils.extensions;

import com.getstream.sdk.chat.utils.StorageHelper;
import com.getstream.sdk.chat.utils.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Attachment;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, mo26107d2 = {"getDisplayableName", "", "Lio/getstream/chat/android/client/models/Attachment;", "stream-chat-android-ui-common_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: AttachmentExtension.kt */
public final class AttachmentExtensionKt {
    public static final String getDisplayableName(Attachment attachment) {
        Intrinsics.checkNotNullParameter(attachment, "$this$getDisplayableName");
        StringUtils stringUtils = StringUtils.INSTANCE;
        String title = attachment.getTitle();
        if (title == null) {
            title = attachment.getName();
        }
        return stringUtils.removeTimePrefix(title, StorageHelper.TIME_FORMAT);
    }
}
