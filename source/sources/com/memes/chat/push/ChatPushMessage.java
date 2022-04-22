package com.memes.chat.push;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.Gson;
import com.memes.chat.routing.ChatRouting;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, mo26107d2 = {"Lcom/memes/chat/push/ChatPushMessage;", "Landroid/os/Parcelable;", "channelId", "", "channelType", "messageId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "getChannelType", "getMessageId", "cid", "describeContents", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ChannelPart", "Companion", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChatPushMessage.kt */
public final class ChatPushMessage implements Parcelable {
    public static final Parcelable.Creator<ChatPushMessage> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String channelId;
    private final String channelType;
    private final String messageId;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ChatPushMessage> {
        public final ChatPushMessage createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ChatPushMessage(parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final ChatPushMessage[] newArray(int i) {
            return new ChatPushMessage[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.channelId);
        parcel.writeString(this.channelType);
        parcel.writeString(this.messageId);
    }

    public ChatPushMessage(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, "channelType");
        this.channelId = str;
        this.channelType = str2;
        this.messageId = str3;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final String getChannelType() {
        return this.channelType;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChatPushMessage(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3);
    }

    public final String getMessageId() {
        return this.messageId;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/chat/push/ChatPushMessage$Companion;", "", "()V", "createFromBundle", "Lcom/memes/chat/push/ChatPushMessage;", "bundle", "Landroid/os/Bundle;", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChatPushMessage.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ChatPushMessage createFromBundle(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            ChatPushMessage chatPushMessage = (ChatPushMessage) bundle.getParcelable(ChatRouting.EXTRA_PUSH_MESSAGE);
            if (chatPushMessage != null) {
                return chatPushMessage;
            }
            Object obj = bundle.get("channel");
            if (!(obj instanceof String)) {
                obj = null;
            }
            String str = (String) obj;
            CharSequence charSequence = str;
            boolean z = false;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                return null;
            }
            ChannelPart channelPart = (ChannelPart) new Gson().fromJson(str, ChannelPart.class);
            CharSequence id = channelPart.getId();
            if (id == null || StringsKt.isBlank(id)) {
                return null;
            }
            CharSequence type = channelPart.getType();
            if (type == null || StringsKt.isBlank(type)) {
                return null;
            }
            Object obj2 = bundle.get(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            if (!(obj2 instanceof String)) {
                obj2 = null;
            }
            String str2 = (String) obj2;
            CharSequence charSequence2 = str2;
            if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
                z = true;
            }
            if (z) {
                str2 = null;
            }
            return new ChatPushMessage(channelPart.getId(), channelPart.getType(), str2);
        }
    }

    public final String cid() {
        return this.channelType + ':' + this.channelId;
    }

    public String toString() {
        return "ChatPushMessage(channelId='" + this.channelId + "', channelType='" + this.channelType + "', messageId=" + this.messageId + ')';
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo26107d2 = {"Lcom/memes/chat/push/ChatPushMessage$ChannelPart;", "", "id", "", "type", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChatPushMessage.kt */
    private static final class ChannelPart {

        /* renamed from: id */
        private final String f937id;
        private final String type;

        public static /* synthetic */ ChannelPart copy$default(ChannelPart channelPart, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = channelPart.f937id;
            }
            if ((i & 2) != 0) {
                str2 = channelPart.type;
            }
            return channelPart.copy(str, str2);
        }

        public final String component1() {
            return this.f937id;
        }

        public final String component2() {
            return this.type;
        }

        public final ChannelPart copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "type");
            return new ChannelPart(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ChannelPart)) {
                return false;
            }
            ChannelPart channelPart = (ChannelPart) obj;
            return Intrinsics.areEqual((Object) this.f937id, (Object) channelPart.f937id) && Intrinsics.areEqual((Object) this.type, (Object) channelPart.type);
        }

        public int hashCode() {
            String str = this.f937id;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.type;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "ChannelPart(id=" + this.f937id + ", type=" + this.type + ")";
        }

        public ChannelPart(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "type");
            this.f937id = str;
            this.type = str2;
        }

        public final String getId() {
            return this.f937id;
        }

        public final String getType() {
            return this.type;
        }
    }
}
