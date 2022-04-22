package com.getstream.sdk.chat.utils;

import android.webkit.MimeTypeMap;
import com.getstream.sdk.chat.model.AttachmentMetaData;
import kotlin.Metadata;
import org.apache.commons.lang3.ClassUtils;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, mo26107d2 = {"getTitleWithExtension", "", "Lcom/getstream/sdk/chat/model/AttachmentMetaData;", "stream-chat-android-ui-common_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: StorageHelper.kt */
public final class StorageHelperKt {
    /* access modifiers changed from: private */
    public static final String getTitleWithExtension(AttachmentMetaData attachmentMetaData) {
        CharSequence fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(attachmentMetaData.getTitle());
        boolean z = false;
        if (fileExtensionFromUrl == null || fileExtensionFromUrl.length() == 0) {
            CharSequence mimeType = attachmentMetaData.getMimeType();
            if (mimeType == null || mimeType.length() == 0) {
                z = true;
            }
            if (!z) {
                return attachmentMetaData.getTitle() + ClassUtils.PACKAGE_SEPARATOR_CHAR + MimeTypeMap.getSingleton().getExtensionFromMimeType(attachmentMetaData.getMimeType());
            }
        }
        String title = attachmentMetaData.getTitle();
        return title != null ? title : "";
    }
}
