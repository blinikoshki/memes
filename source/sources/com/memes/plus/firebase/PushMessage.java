package com.memes.plus.firebase;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.FrameMetricsAggregator;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.messaging.RemoteMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010&\u001a\u00020'HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020'HÖ\u0001R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0010\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0013R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0010\"\u0004\b%\u0010\u0013¨\u0006."}, mo26107d2 = {"Lcom/memes/plus/firebase/PushMessage;", "Landroid/os/Parcelable;", "type", "", "timestamp", "", "postId", "senderId", "senderProfilePic", "Landroid/graphics/Bitmap;", "receiverId", "title", "text", "log", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLog", "()Ljava/lang/String;", "getPostId", "setPostId", "(Ljava/lang/String;)V", "getReceiverId", "setReceiverId", "getSenderId", "setSenderId", "getSenderProfilePic", "()Landroid/graphics/Bitmap;", "setSenderProfilePic", "(Landroid/graphics/Bitmap;)V", "getText", "setText", "getTimestamp", "()J", "setTimestamp", "(J)V", "getTitle", "setTitle", "getType", "setType", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: PushMessage.kt */
public final class PushMessage implements Parcelable {
    public static final Parcelable.Creator<PushMessage> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String log;
    private String postId;
    private String receiverId;
    private String senderId;
    private Bitmap senderProfilePic;
    private String text;
    private long timestamp;
    private String title;
    private String type;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PushMessage> {
        public final PushMessage createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new PushMessage(parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bitmap) Bitmap.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final PushMessage[] newArray(int i) {
            return new PushMessage[i];
        }
    }

    public PushMessage() {
        this((String) null, 0, (String) null, (String) null, (Bitmap) null, (String) null, (String) null, (String) null, (String) null, FrameMetricsAggregator.EVERY_DURATION, (DefaultConstructorMarker) null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.type);
        parcel.writeLong(this.timestamp);
        parcel.writeString(this.postId);
        parcel.writeString(this.senderId);
        Bitmap bitmap = this.senderProfilePic;
        if (bitmap != null) {
            parcel.writeInt(1);
            bitmap.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.receiverId);
        parcel.writeString(this.title);
        parcel.writeString(this.text);
        parcel.writeString(this.log);
    }

    public PushMessage(String str, long j, String str2, String str3, Bitmap bitmap, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str7, "log");
        this.type = str;
        this.timestamp = j;
        this.postId = str2;
        this.senderId = str3;
        this.senderProfilePic = bitmap;
        this.receiverId = str4;
        this.title = str5;
        this.text = str6;
        this.log = str7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PushMessage(java.lang.String r12, long r13, java.lang.String r15, java.lang.String r16, android.graphics.Bitmap r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x000b
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x000c
        L_0x000b:
            r1 = r12
        L_0x000c:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0013
            r3 = 0
            goto L_0x0014
        L_0x0013:
            r3 = r13
        L_0x0014:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x001c
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x001d
        L_0x001c:
            r5 = r15
        L_0x001d:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0025
            r6 = r2
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x0027
        L_0x0025:
            r6 = r16
        L_0x0027:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002f
            r7 = r2
            android.graphics.Bitmap r7 = (android.graphics.Bitmap) r7
            goto L_0x0031
        L_0x002f:
            r7 = r17
        L_0x0031:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0039
            r8 = r2
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x003b
        L_0x0039:
            r8 = r18
        L_0x003b:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0043
            r9 = r2
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x0045
        L_0x0043:
            r9 = r19
        L_0x0045:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x004c
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x004e
        L_0x004c:
            r2 = r20
        L_0x004e:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0055
            java.lang.String r0 = "log not provided"
            goto L_0x0057
        L_0x0055:
            r0 = r21
        L_0x0057:
            r12 = r11
            r13 = r1
            r14 = r3
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r2
            r22 = r0
            r12.<init>(r13, r14, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.firebase.PushMessage.<init>(java.lang.String, long, java.lang.String, java.lang.String, android.graphics.Bitmap, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final void setPostId(String str) {
        this.postId = str;
    }

    public final String getSenderId() {
        return this.senderId;
    }

    public final void setSenderId(String str) {
        this.senderId = str;
    }

    public final Bitmap getSenderProfilePic() {
        return this.senderProfilePic;
    }

    public final void setSenderProfilePic(Bitmap bitmap) {
        this.senderProfilePic = bitmap;
    }

    public final String getReceiverId() {
        return this.receiverId;
    }

    public final void setReceiverId(String str) {
        this.receiverId = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final String getLog() {
        return this.log;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/firebase/PushMessage$Companion;", "", "()V", "from", "Lcom/memes/plus/firebase/PushMessage;", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: PushMessage.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PushMessage from(RemoteMessage remoteMessage) {
            Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
            StringBuilder sb = new StringBuilder();
            sb.append("\n                    remoteMessage -> {\n                        to = ");
            sb.append(remoteMessage.getTo());
            sb.append("\n                        from = ");
            sb.append(remoteMessage.getFrom());
            sb.append("\n                        messageId = ");
            sb.append(remoteMessage.getMessageId());
            sb.append("\n                        messageType = ");
            sb.append(remoteMessage.getMessageType());
            sb.append("\n                        originalPriority = ");
            sb.append(remoteMessage.getOriginalPriority());
            sb.append("\n                        priority = ");
            sb.append(remoteMessage.getPriority());
            sb.append("\n                        toIntent() = ");
            sb.append(remoteMessage.toIntent());
            sb.append("\n                        toIntent() = ");
            Intent intent = remoteMessage.toIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "remoteMessage.toIntent()");
            sb.append(intent.getExtras());
            sb.append("\n                        ttl= ");
            sb.append(remoteMessage.getTtl());
            sb.append("\n                        data = ");
            sb.append(remoteMessage.getData());
            sb.append("\n                        sentTime = ");
            sb.append(remoteMessage.getSentTime());
            sb.append("\n                        notification = ");
            sb.append(remoteMessage.getNotification());
            sb.append("\n                    }\n                ");
            return new PushMessage(remoteMessage.getData().get("type"), remoteMessage.getSentTime(), remoteMessage.getData().get(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID), remoteMessage.getData().get("notificationBy"), (Bitmap) null, remoteMessage.getData().get("notificationTo"), (String) null, remoteMessage.getData().get("notificationData"), sb.toString());
        }
    }
}
