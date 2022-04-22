package p015io.getstream.chat.android.client.api.models;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/UpdateCooldownRequest;", "", "cooldown", "", "(I)V", "getCooldown", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.UpdateCooldownRequest */
/* compiled from: UpdateCooldownRequest.kt */
public final class UpdateCooldownRequest {
    private final int cooldown;

    public static /* synthetic */ UpdateCooldownRequest copy$default(UpdateCooldownRequest updateCooldownRequest, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = updateCooldownRequest.cooldown;
        }
        return updateCooldownRequest.copy(i);
    }

    public final int component1() {
        return this.cooldown;
    }

    public final UpdateCooldownRequest copy(int i) {
        return new UpdateCooldownRequest(i);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof UpdateCooldownRequest) && this.cooldown == ((UpdateCooldownRequest) obj).cooldown;
        }
        return true;
    }

    public int hashCode() {
        return this.cooldown;
    }

    public String toString() {
        return "UpdateCooldownRequest(cooldown=" + this.cooldown + ")";
    }

    public UpdateCooldownRequest(int i) {
        this.cooldown = i;
    }

    public final int getCooldown() {
        return this.cooldown;
    }
}
