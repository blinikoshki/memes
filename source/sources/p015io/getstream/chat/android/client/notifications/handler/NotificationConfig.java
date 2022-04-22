package p015io.getstream.chat.android.client.notifications.handler;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b \b\b\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u000fHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003Jw\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010+\u001a\u00020\u000f2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006/"}, mo26107d2 = {"Lio/getstream/chat/android/client/notifications/handler/NotificationConfig;", "", "notificationChannelId", "", "notificationChannelName", "smallIcon", "firebaseMessageIdKey", "", "firebaseMessageTextKey", "firebaseChannelIdKey", "firebaseChannelTypeKey", "firebaseChannelNameKey", "errorCaseNotificationTitle", "errorCaseNotificationContent", "useProvidedFirebaseInstance", "", "(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)V", "getErrorCaseNotificationContent", "()I", "getErrorCaseNotificationTitle", "getFirebaseChannelIdKey", "()Ljava/lang/String;", "getFirebaseChannelNameKey", "getFirebaseChannelTypeKey", "getFirebaseMessageIdKey", "getFirebaseMessageTextKey", "getNotificationChannelId", "getNotificationChannelName", "getSmallIcon", "getUseProvidedFirebaseInstance", "()Z", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.notifications.handler.NotificationConfig */
/* compiled from: NotificationConfig.kt */
public final class NotificationConfig {
    private final int errorCaseNotificationContent;
    private final int errorCaseNotificationTitle;
    private final String firebaseChannelIdKey;
    private final String firebaseChannelNameKey;
    private final String firebaseChannelTypeKey;
    private final String firebaseMessageIdKey;
    private final String firebaseMessageTextKey;
    private final int notificationChannelId;
    private final int notificationChannelName;
    private final int smallIcon;
    private final boolean useProvidedFirebaseInstance;

    public NotificationConfig() {
        this(0, 0, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, false, 2047, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ NotificationConfig copy$default(NotificationConfig notificationConfig, int i, int i2, int i3, String str, String str2, String str3, String str4, String str5, int i4, int i5, boolean z, int i6, Object obj) {
        NotificationConfig notificationConfig2 = notificationConfig;
        int i7 = i6;
        return notificationConfig.copy((i7 & 1) != 0 ? notificationConfig2.notificationChannelId : i, (i7 & 2) != 0 ? notificationConfig2.notificationChannelName : i2, (i7 & 4) != 0 ? notificationConfig2.smallIcon : i3, (i7 & 8) != 0 ? notificationConfig2.firebaseMessageIdKey : str, (i7 & 16) != 0 ? notificationConfig2.firebaseMessageTextKey : str2, (i7 & 32) != 0 ? notificationConfig2.firebaseChannelIdKey : str3, (i7 & 64) != 0 ? notificationConfig2.firebaseChannelTypeKey : str4, (i7 & 128) != 0 ? notificationConfig2.firebaseChannelNameKey : str5, (i7 & 256) != 0 ? notificationConfig2.errorCaseNotificationTitle : i4, (i7 & 512) != 0 ? notificationConfig2.errorCaseNotificationContent : i5, (i7 & 1024) != 0 ? notificationConfig2.useProvidedFirebaseInstance : z);
    }

    public final int component1() {
        return this.notificationChannelId;
    }

    public final int component10() {
        return this.errorCaseNotificationContent;
    }

    public final boolean component11() {
        return this.useProvidedFirebaseInstance;
    }

    public final int component2() {
        return this.notificationChannelName;
    }

    public final int component3() {
        return this.smallIcon;
    }

    public final String component4() {
        return this.firebaseMessageIdKey;
    }

    public final String component5() {
        return this.firebaseMessageTextKey;
    }

    public final String component6() {
        return this.firebaseChannelIdKey;
    }

    public final String component7() {
        return this.firebaseChannelTypeKey;
    }

    public final String component8() {
        return this.firebaseChannelNameKey;
    }

    public final int component9() {
        return this.errorCaseNotificationTitle;
    }

    public final NotificationConfig copy(int i, int i2, int i3, String str, String str2, String str3, String str4, String str5, int i4, int i5, boolean z) {
        String str6 = str;
        Intrinsics.checkNotNullParameter(str6, "firebaseMessageIdKey");
        String str7 = str2;
        Intrinsics.checkNotNullParameter(str7, "firebaseMessageTextKey");
        String str8 = str3;
        Intrinsics.checkNotNullParameter(str8, "firebaseChannelIdKey");
        String str9 = str4;
        Intrinsics.checkNotNullParameter(str9, "firebaseChannelTypeKey");
        String str10 = str5;
        Intrinsics.checkNotNullParameter(str10, "firebaseChannelNameKey");
        return new NotificationConfig(i, i2, i3, str6, str7, str8, str9, str10, i4, i5, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotificationConfig)) {
            return false;
        }
        NotificationConfig notificationConfig = (NotificationConfig) obj;
        return this.notificationChannelId == notificationConfig.notificationChannelId && this.notificationChannelName == notificationConfig.notificationChannelName && this.smallIcon == notificationConfig.smallIcon && Intrinsics.areEqual((Object) this.firebaseMessageIdKey, (Object) notificationConfig.firebaseMessageIdKey) && Intrinsics.areEqual((Object) this.firebaseMessageTextKey, (Object) notificationConfig.firebaseMessageTextKey) && Intrinsics.areEqual((Object) this.firebaseChannelIdKey, (Object) notificationConfig.firebaseChannelIdKey) && Intrinsics.areEqual((Object) this.firebaseChannelTypeKey, (Object) notificationConfig.firebaseChannelTypeKey) && Intrinsics.areEqual((Object) this.firebaseChannelNameKey, (Object) notificationConfig.firebaseChannelNameKey) && this.errorCaseNotificationTitle == notificationConfig.errorCaseNotificationTitle && this.errorCaseNotificationContent == notificationConfig.errorCaseNotificationContent && this.useProvidedFirebaseInstance == notificationConfig.useProvidedFirebaseInstance;
    }

    public int hashCode() {
        int i = ((((this.notificationChannelId * 31) + this.notificationChannelName) * 31) + this.smallIcon) * 31;
        String str = this.firebaseMessageIdKey;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.firebaseMessageTextKey;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.firebaseChannelIdKey;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.firebaseChannelTypeKey;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.firebaseChannelNameKey;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        int i3 = (((((hashCode4 + i2) * 31) + this.errorCaseNotificationTitle) * 31) + this.errorCaseNotificationContent) * 31;
        boolean z = this.useProvidedFirebaseInstance;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public String toString() {
        return "NotificationConfig(notificationChannelId=" + this.notificationChannelId + ", notificationChannelName=" + this.notificationChannelName + ", smallIcon=" + this.smallIcon + ", firebaseMessageIdKey=" + this.firebaseMessageIdKey + ", firebaseMessageTextKey=" + this.firebaseMessageTextKey + ", firebaseChannelIdKey=" + this.firebaseChannelIdKey + ", firebaseChannelTypeKey=" + this.firebaseChannelTypeKey + ", firebaseChannelNameKey=" + this.firebaseChannelNameKey + ", errorCaseNotificationTitle=" + this.errorCaseNotificationTitle + ", errorCaseNotificationContent=" + this.errorCaseNotificationContent + ", useProvidedFirebaseInstance=" + this.useProvidedFirebaseInstance + ")";
    }

    public NotificationConfig(int i, int i2, int i3, String str, String str2, String str3, String str4, String str5, int i4, int i5, boolean z) {
        Intrinsics.checkNotNullParameter(str, "firebaseMessageIdKey");
        Intrinsics.checkNotNullParameter(str2, "firebaseMessageTextKey");
        Intrinsics.checkNotNullParameter(str3, "firebaseChannelIdKey");
        Intrinsics.checkNotNullParameter(str4, "firebaseChannelTypeKey");
        Intrinsics.checkNotNullParameter(str5, "firebaseChannelNameKey");
        this.notificationChannelId = i;
        this.notificationChannelName = i2;
        this.smallIcon = i3;
        this.firebaseMessageIdKey = str;
        this.firebaseMessageTextKey = str2;
        this.firebaseChannelIdKey = str3;
        this.firebaseChannelTypeKey = str4;
        this.firebaseChannelNameKey = str5;
        this.errorCaseNotificationTitle = i4;
        this.errorCaseNotificationContent = i5;
        this.useProvidedFirebaseInstance = z;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ NotificationConfig(int r12, int r13, int r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, int r20, int r21, boolean r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r11 = this;
            r0 = r23
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            int r1 = p015io.getstream.chat.android.client.C4939R.string.stream_chat_notification_channel_id
            goto L_0x000a
        L_0x0009:
            r1 = r12
        L_0x000a:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0011
            int r2 = p015io.getstream.chat.android.client.C4939R.string.stream_chat_notification_channel_name
            goto L_0x0012
        L_0x0011:
            r2 = r13
        L_0x0012:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0019
            int r3 = p015io.getstream.chat.android.client.C4939R.C4941drawable.stream_ic_notification
            goto L_0x001a
        L_0x0019:
            r3 = r14
        L_0x001a:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0021
            java.lang.String r4 = "message_id"
            goto L_0x0022
        L_0x0021:
            r4 = r15
        L_0x0022:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0029
            java.lang.String r5 = "message_text"
            goto L_0x002b
        L_0x0029:
            r5 = r16
        L_0x002b:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0032
            java.lang.String r6 = "channel_id"
            goto L_0x0034
        L_0x0032:
            r6 = r17
        L_0x0034:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x003b
            java.lang.String r7 = "channel_type"
            goto L_0x003d
        L_0x003b:
            r7 = r18
        L_0x003d:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0044
            java.lang.String r8 = "channel_name"
            goto L_0x0046
        L_0x0044:
            r8 = r19
        L_0x0046:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x004d
            int r9 = p015io.getstream.chat.android.client.C4939R.string.stream_chat_notification_title
            goto L_0x004f
        L_0x004d:
            r9 = r20
        L_0x004f:
            r10 = r0 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x0056
            int r10 = p015io.getstream.chat.android.client.C4939R.string.stream_chat_notification_content
            goto L_0x0058
        L_0x0056:
            r10 = r21
        L_0x0058:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x005e
            r0 = 1
            goto L_0x0060
        L_0x005e:
            r0 = r22
        L_0x0060:
            r12 = r11
            r13 = r1
            r14 = r2
            r15 = r3
            r16 = r4
            r17 = r5
            r18 = r6
            r19 = r7
            r20 = r8
            r21 = r9
            r22 = r10
            r23 = r0
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.client.notifications.handler.NotificationConfig.<init>(int, int, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getNotificationChannelId() {
        return this.notificationChannelId;
    }

    public final int getNotificationChannelName() {
        return this.notificationChannelName;
    }

    public final int getSmallIcon() {
        return this.smallIcon;
    }

    public final String getFirebaseMessageIdKey() {
        return this.firebaseMessageIdKey;
    }

    public final String getFirebaseMessageTextKey() {
        return this.firebaseMessageTextKey;
    }

    public final String getFirebaseChannelIdKey() {
        return this.firebaseChannelIdKey;
    }

    public final String getFirebaseChannelTypeKey() {
        return this.firebaseChannelTypeKey;
    }

    public final String getFirebaseChannelNameKey() {
        return this.firebaseChannelNameKey;
    }

    public final int getErrorCaseNotificationTitle() {
        return this.errorCaseNotificationTitle;
    }

    public final int getErrorCaseNotificationContent() {
        return this.errorCaseNotificationContent;
    }

    public final boolean getUseProvidedFirebaseInstance() {
        return this.useProvidedFirebaseInstance;
    }
}
