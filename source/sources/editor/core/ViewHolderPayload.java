package editor.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, mo26107d2 = {"Leditor/core/ViewHolderPayload;", "", "key", "", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ViewHolderPayload.kt */
public final class ViewHolderPayload {
    private final String key;
    private final Object value;

    public static /* synthetic */ ViewHolderPayload copy$default(ViewHolderPayload viewHolderPayload, String str, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = viewHolderPayload.key;
        }
        if ((i & 2) != 0) {
            obj = viewHolderPayload.value;
        }
        return viewHolderPayload.copy(str, obj);
    }

    public final String component1() {
        return this.key;
    }

    public final Object component2() {
        return this.value;
    }

    public final ViewHolderPayload copy(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        return new ViewHolderPayload(str, obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewHolderPayload)) {
            return false;
        }
        ViewHolderPayload viewHolderPayload = (ViewHolderPayload) obj;
        return Intrinsics.areEqual((Object) this.key, (Object) viewHolderPayload.key) && Intrinsics.areEqual(this.value, viewHolderPayload.value);
    }

    public int hashCode() {
        String str = this.key;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Object obj = this.value;
        if (obj != null) {
            i = obj.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ViewHolderPayload(key=" + this.key + ", value=" + this.value + ")";
    }

    public ViewHolderPayload(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.key = str;
        this.value = obj;
    }

    public final String getKey() {
        return this.key;
    }

    public final Object getValue() {
        return this.value;
    }
}
