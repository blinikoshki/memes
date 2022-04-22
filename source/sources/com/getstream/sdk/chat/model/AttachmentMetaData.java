package com.getstream.sdk.chat.model;

import android.content.Context;
import android.net.Uri;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.getstream.sdk.chat.StreamFileProvider;
import com.getstream.sdk.chat.utils.Utils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p015io.getstream.chat.android.client.models.Attachment;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;

@InternalStreamChatApi
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u001b\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tBA\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0010J\u000b\u00105\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\bHÆ\u0003JE\u0010:\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010;\u001a\u00020\u00162\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0012\u0010=\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\t\u0010>\u001a\u00020\u001fHÖ\u0001J\t\u0010?\u001a\u00020\rHÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001b\"\u0004\b+\u0010\u001dR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001b\"\u0004\b-\u0010\u001dR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010'\"\u0004\b4\u0010)¨\u0006@"}, mo26107d2 = {"Lcom/getstream/sdk/chat/model/AttachmentMetaData;", "", "attachment", "Lio/getstream/chat/android/client/models/Attachment;", "(Lio/getstream/chat/android/client/models/Attachment;)V", "context", "Landroid/content/Context;", "file", "Ljava/io/File;", "(Landroid/content/Context;Ljava/io/File;)V", "uri", "Landroid/net/Uri;", "type", "", "mimeType", "title", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)V", "getFile", "()Ljava/io/File;", "setFile", "(Ljava/io/File;)V", "isSelected", "", "()Z", "setSelected", "(Z)V", "getMimeType", "()Ljava/lang/String;", "setMimeType", "(Ljava/lang/String;)V", "selectedPosition", "", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "size", "", "getSize", "()J", "setSize", "(J)V", "getTitle", "setTitle", "getType", "setType", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "videoLength", "getVideoLength", "setVideoLength", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "getTypeFromMimeType", "hashCode", "toString", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AttachmentMetaData.kt */
public final class AttachmentMetaData {
    private File file;
    private boolean isSelected;
    private String mimeType;
    private int selectedPosition;
    private long size;
    private String title;
    private String type;
    private Uri uri;
    private long videoLength;

    public AttachmentMetaData() {
        this((Uri) null, (String) null, (String) null, (String) null, (File) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AttachmentMetaData copy$default(AttachmentMetaData attachmentMetaData, Uri uri2, String str, String str2, String str3, File file2, int i, Object obj) {
        if ((i & 1) != 0) {
            uri2 = attachmentMetaData.uri;
        }
        if ((i & 2) != 0) {
            str = attachmentMetaData.type;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = attachmentMetaData.mimeType;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = attachmentMetaData.title;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            file2 = attachmentMetaData.file;
        }
        return attachmentMetaData.copy(uri2, str4, str5, str6, file2);
    }

    public final Uri component1() {
        return this.uri;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.mimeType;
    }

    public final String component4() {
        return this.title;
    }

    public final File component5() {
        return this.file;
    }

    public final AttachmentMetaData copy(Uri uri2, String str, String str2, String str3, File file2) {
        return new AttachmentMetaData(uri2, str, str2, str3, file2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AttachmentMetaData)) {
            return false;
        }
        AttachmentMetaData attachmentMetaData = (AttachmentMetaData) obj;
        return Intrinsics.areEqual((Object) this.uri, (Object) attachmentMetaData.uri) && Intrinsics.areEqual((Object) this.type, (Object) attachmentMetaData.type) && Intrinsics.areEqual((Object) this.mimeType, (Object) attachmentMetaData.mimeType) && Intrinsics.areEqual((Object) this.title, (Object) attachmentMetaData.title) && Intrinsics.areEqual((Object) this.file, (Object) attachmentMetaData.file);
    }

    public int hashCode() {
        Uri uri2 = this.uri;
        int i = 0;
        int hashCode = (uri2 != null ? uri2.hashCode() : 0) * 31;
        String str = this.type;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.mimeType;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.title;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        File file2 = this.file;
        if (file2 != null) {
            i = file2.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "AttachmentMetaData(uri=" + this.uri + ", type=" + this.type + ", mimeType=" + this.mimeType + ", title=" + this.title + ", file=" + this.file + ")";
    }

    public AttachmentMetaData(Uri uri2, String str, String str2, String str3, File file2) {
        this.uri = uri2;
        this.type = str;
        this.mimeType = str2;
        this.title = str3;
        this.file = file2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AttachmentMetaData(android.net.Uri r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.io.File r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            r0 = 0
            if (r10 == 0) goto L_0x0008
            r4 = r0
            android.net.Uri r4 = (android.net.Uri) r4
        L_0x0008:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x000f
            r5 = r0
            java.lang.String r5 = (java.lang.String) r5
        L_0x000f:
            r10 = r5
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0017
            r6 = r0
            java.lang.String r6 = (java.lang.String) r6
        L_0x0017:
            r1 = r6
            r5 = r9 & 8
            if (r5 == 0) goto L_0x001f
            r7 = r0
            java.lang.String r7 = (java.lang.String) r7
        L_0x001f:
            r2 = r7
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0027
            r8 = r0
            java.io.File r8 = (java.io.File) r8
        L_0x0027:
            r0 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r1
            r9 = r2
            r10 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.model.AttachmentMetaData.<init>(android.net.Uri, java.lang.String, java.lang.String, java.lang.String, java.io.File, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final void setUri(Uri uri2) {
        this.uri = uri2;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final void setMimeType(String str) {
        this.mimeType = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final File getFile() {
        return this.file;
    }

    public final void setFile(File file2) {
        this.file = file2;
    }

    public final long getSize() {
        return this.size;
    }

    public final void setSize(long j) {
        this.size = j;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final int getSelectedPosition() {
        return this.selectedPosition;
    }

    public final void setSelectedPosition(int i) {
        this.selectedPosition = i;
    }

    public final long getVideoLength() {
        return this.videoLength;
    }

    public final void setVideoLength(long j) {
        this.videoLength = j;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AttachmentMetaData(Attachment attachment) {
        this((Uri) null, attachment.getType(), attachment.getMimeType(), attachment.getTitle(), (File) null, 17, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(attachment, MessengerShareContentUtility.ATTACHMENT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AttachmentMetaData(Context context, File file2) {
        this(StreamFileProvider.Companion.getUriForFile(context, file2), (String) null, (String) null, (String) null, file2, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file2, "file");
        String mimeType2 = Utils.getMimeType(file2);
        this.mimeType = mimeType2;
        this.type = getTypeFromMimeType(mimeType2);
        this.size = file2.length();
    }

    private final String getTypeFromMimeType(String str) {
        if (str == null) {
            return "file";
        }
        CharSequence charSequence = str;
        if (StringsKt.contains$default(charSequence, (CharSequence) "image", false, 2, (Object) null)) {
            return "image";
        }
        return StringsKt.contains$default(charSequence, (CharSequence) "video", false, 2, (Object) null) ? "video" : "file";
    }
}
