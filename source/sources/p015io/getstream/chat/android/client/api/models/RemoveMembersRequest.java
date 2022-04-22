package p015io.getstream.chat.android.client.api.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.ModelFields;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/RemoveMembersRequest;", "", "members", "", "", "(Ljava/util/List;)V", "getMembers", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.RemoveMembersRequest */
/* compiled from: RemoveMembersRequest.kt */
public final class RemoveMembersRequest {
    @SerializedName("remove_members")
    private final List<String> members;

    public static /* synthetic */ RemoveMembersRequest copy$default(RemoveMembersRequest removeMembersRequest, List<String> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = removeMembersRequest.members;
        }
        return removeMembersRequest.copy(list);
    }

    public final List<String> component1() {
        return this.members;
    }

    public final RemoveMembersRequest copy(List<String> list) {
        Intrinsics.checkNotNullParameter(list, ModelFields.MEMBERS);
        return new RemoveMembersRequest(list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RemoveMembersRequest) && Intrinsics.areEqual((Object) this.members, (Object) ((RemoveMembersRequest) obj).members);
        }
        return true;
    }

    public int hashCode() {
        List<String> list = this.members;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "RemoveMembersRequest(members=" + this.members + ")";
    }

    public RemoveMembersRequest(List<String> list) {
        Intrinsics.checkNotNullParameter(list, ModelFields.MEMBERS);
        this.members = list;
    }

    public final List<String> getMembers() {
        return this.members;
    }
}
