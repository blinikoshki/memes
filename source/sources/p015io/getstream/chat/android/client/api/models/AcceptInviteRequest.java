package p015io.getstream.chat.android.client.api.models;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0019B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/AcceptInviteRequest;", "", "user", "Lio/getstream/chat/android/client/models/User;", "message", "Lio/getstream/chat/android/client/api/models/AcceptInviteRequest$AcceptInviteMessage;", "accept_invite", "", "(Lio/getstream/chat/android/client/models/User;Lio/getstream/chat/android/client/api/models/AcceptInviteRequest$AcceptInviteMessage;Z)V", "getAccept_invite", "()Z", "getMessage", "()Lio/getstream/chat/android/client/api/models/AcceptInviteRequest$AcceptInviteMessage;", "getUser", "()Lio/getstream/chat/android/client/models/User;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "AcceptInviteMessage", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.AcceptInviteRequest */
/* compiled from: AcceptInviteRequest.kt */
public final class AcceptInviteRequest {
    private final boolean accept_invite;
    private final AcceptInviteMessage message;
    private final User user;

    public static /* synthetic */ AcceptInviteRequest copy$default(AcceptInviteRequest acceptInviteRequest, User user2, AcceptInviteMessage acceptInviteMessage, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            user2 = acceptInviteRequest.user;
        }
        if ((i & 2) != 0) {
            acceptInviteMessage = acceptInviteRequest.message;
        }
        if ((i & 4) != 0) {
            z = acceptInviteRequest.accept_invite;
        }
        return acceptInviteRequest.copy(user2, acceptInviteMessage, z);
    }

    public final User component1() {
        return this.user;
    }

    public final AcceptInviteMessage component2() {
        return this.message;
    }

    public final boolean component3() {
        return this.accept_invite;
    }

    public final AcceptInviteRequest copy(User user2, AcceptInviteMessage acceptInviteMessage, boolean z) {
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(acceptInviteMessage, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return new AcceptInviteRequest(user2, acceptInviteMessage, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AcceptInviteRequest)) {
            return false;
        }
        AcceptInviteRequest acceptInviteRequest = (AcceptInviteRequest) obj;
        return Intrinsics.areEqual((Object) this.user, (Object) acceptInviteRequest.user) && Intrinsics.areEqual((Object) this.message, (Object) acceptInviteRequest.message) && this.accept_invite == acceptInviteRequest.accept_invite;
    }

    public int hashCode() {
        User user2 = this.user;
        int i = 0;
        int hashCode = (user2 != null ? user2.hashCode() : 0) * 31;
        AcceptInviteMessage acceptInviteMessage = this.message;
        if (acceptInviteMessage != null) {
            i = acceptInviteMessage.hashCode();
        }
        int i2 = (hashCode + i) * 31;
        boolean z = this.accept_invite;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    public String toString() {
        return "AcceptInviteRequest(user=" + this.user + ", message=" + this.message + ", accept_invite=" + this.accept_invite + ")";
    }

    public AcceptInviteRequest(User user2, AcceptInviteMessage acceptInviteMessage, boolean z) {
        Intrinsics.checkNotNullParameter(user2, "user");
        Intrinsics.checkNotNullParameter(acceptInviteMessage, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.user = user2;
        this.message = acceptInviteMessage;
        this.accept_invite = z;
    }

    public final User getUser() {
        return this.user;
    }

    public final AcceptInviteMessage getMessage() {
        return this.message;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AcceptInviteRequest(User user2, AcceptInviteMessage acceptInviteMessage, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(user2, acceptInviteMessage, (i & 4) != 0 ? true : z);
    }

    public final boolean getAccept_invite() {
        return this.accept_invite;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/AcceptInviteRequest$AcceptInviteMessage;", "", "text", "", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.api.models.AcceptInviteRequest$AcceptInviteMessage */
    /* compiled from: AcceptInviteRequest.kt */
    public static final class AcceptInviteMessage {
        private final String text;

        public AcceptInviteMessage() {
            this((String) null, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ AcceptInviteMessage copy$default(AcceptInviteMessage acceptInviteMessage, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = acceptInviteMessage.text;
            }
            return acceptInviteMessage.copy(str);
        }

        public final String component1() {
            return this.text;
        }

        public final AcceptInviteMessage copy(String str) {
            return new AcceptInviteMessage(str);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof AcceptInviteMessage) && Intrinsics.areEqual((Object) this.text, (Object) ((AcceptInviteMessage) obj).text);
            }
            return true;
        }

        public int hashCode() {
            String str = this.text;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "AcceptInviteMessage(text=" + this.text + ")";
        }

        public AcceptInviteMessage(String str) {
            this.text = str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AcceptInviteMessage(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        public final String getText() {
            return this.text;
        }
    }
}
