package p015io.getstream.chat.android.client.api.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.parser.IgnoreSerialisation;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u0018B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/GuestUserRequest;", "", "id", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "user", "Lio/getstream/chat/android/client/api/models/GuestUserRequest$GuestUserBody;", "getUser", "()Lio/getstream/chat/android/client/api/models/GuestUserRequest$GuestUserBody;", "setUser", "(Lio/getstream/chat/android/client/api/models/GuestUserRequest$GuestUserBody;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "GuestUserBody", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.GuestUserRequest */
/* compiled from: GuestUserRequest.kt */
public final class GuestUserRequest {
    @IgnoreSerialisation

    /* renamed from: id */
    private final String f1446id;
    @IgnoreSerialisation
    private final String name;
    private GuestUserBody user;

    public static /* synthetic */ GuestUserRequest copy$default(GuestUserRequest guestUserRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = guestUserRequest.f1446id;
        }
        if ((i & 2) != 0) {
            str2 = guestUserRequest.name;
        }
        return guestUserRequest.copy(str, str2);
    }

    public final String component1() {
        return this.f1446id;
    }

    public final String component2() {
        return this.name;
    }

    public final GuestUserRequest copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        return new GuestUserRequest(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GuestUserRequest)) {
            return false;
        }
        GuestUserRequest guestUserRequest = (GuestUserRequest) obj;
        return Intrinsics.areEqual((Object) this.f1446id, (Object) guestUserRequest.f1446id) && Intrinsics.areEqual((Object) this.name, (Object) guestUserRequest.name);
    }

    public int hashCode() {
        String str = this.f1446id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "GuestUserRequest(id=" + this.f1446id + ", name=" + this.name + ")";
    }

    public GuestUserRequest(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        this.f1446id = str;
        this.name = str2;
        this.user = new GuestUserBody(str, str2);
    }

    public final String getId() {
        return this.f1446id;
    }

    public final String getName() {
        return this.name;
    }

    public final GuestUserBody getUser() {
        return this.user;
    }

    public final void setUser(GuestUserBody guestUserBody) {
        Intrinsics.checkNotNullParameter(guestUserBody, "<set-?>");
        this.user = guestUserBody;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/GuestUserRequest$GuestUserBody;", "", "id", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.api.models.GuestUserRequest$GuestUserBody */
    /* compiled from: GuestUserRequest.kt */
    public static final class GuestUserBody {

        /* renamed from: id */
        private final String f1447id;
        private final String name;

        public static /* synthetic */ GuestUserBody copy$default(GuestUserBody guestUserBody, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = guestUserBody.f1447id;
            }
            if ((i & 2) != 0) {
                str2 = guestUserBody.name;
            }
            return guestUserBody.copy(str, str2);
        }

        public final String component1() {
            return this.f1447id;
        }

        public final String component2() {
            return this.name;
        }

        public final GuestUserBody copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "name");
            return new GuestUserBody(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GuestUserBody)) {
                return false;
            }
            GuestUserBody guestUserBody = (GuestUserBody) obj;
            return Intrinsics.areEqual((Object) this.f1447id, (Object) guestUserBody.f1447id) && Intrinsics.areEqual((Object) this.name, (Object) guestUserBody.name);
        }

        public int hashCode() {
            String str = this.f1447id;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.name;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "GuestUserBody(id=" + this.f1447id + ", name=" + this.name + ")";
        }

        public GuestUserBody(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "name");
            this.f1447id = str;
            this.name = str2;
        }

        public final String getId() {
            return this.f1447id;
        }

        public final String getName() {
            return this.name;
        }
    }
}
