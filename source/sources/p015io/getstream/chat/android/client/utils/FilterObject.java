package p015io.getstream.chat.android.client.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005B\u001b\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0010\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002J\u0016\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001J\"\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0016j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\u0017J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\b¨\u0006\u0019"}, mo26107d2 = {"Lio/getstream/chat/android/client/utils/FilterObject;", "", "key", "", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "data", "", "(Ljava/util/Map;)V", "getData", "()Ljava/util/Map;", "setData", "component1", "copy", "equals", "", "other", "hashCode", "", "normalizeValue", "put", "toMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.utils.FilterObject */
/* compiled from: FilterObject.kt */
public final class FilterObject {
    private Map<String, Object> data;

    public FilterObject() {
        this((Map) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FilterObject copy$default(FilterObject filterObject, Map<String, Object> map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = filterObject.data;
        }
        return filterObject.copy(map);
    }

    public final Map<String, Object> component1() {
        return this.data;
    }

    public final FilterObject copy(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "data");
        return new FilterObject(map);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof FilterObject) && Intrinsics.areEqual((Object) this.data, (Object) ((FilterObject) obj).data);
        }
        return true;
    }

    public int hashCode() {
        Map<String, Object> map = this.data;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "FilterObject(data=" + this.data + ")";
    }

    public FilterObject(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "data");
        this.data = map;
        this.data = toMap();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FilterObject(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new LinkedHashMap() : map);
    }

    public final Map<String, Object> getData() {
        return this.data;
    }

    public final void setData(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.data = map;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FilterObject(String str, Object obj) {
        this((Map) null, 1, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(obj, "value");
        this.data.put(str, normalizeValue(obj));
    }

    public final FilterObject put(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(obj, "value");
        this.data.put(str, normalizeValue(obj));
        return this;
    }

    private final Object normalizeValue(Object obj) {
        if (obj instanceof FilterObject) {
            return ((FilterObject) obj).toMap();
        }
        if (!(obj instanceof Object[])) {
            return obj;
        }
        Object[] objArr = (Object[]) obj;
        if (!(objArr instanceof FilterObject[])) {
            return obj;
        }
        Collection arrayList = new ArrayList(objArr.length);
        for (Object obj2 : objArr) {
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type io.getstream.chat.android.client.utils.FilterObject");
            arrayList.add(((FilterObject) obj2).toMap());
        }
        return (List) arrayList;
    }

    public final HashMap<String, Object> toMap() {
        HashMap<String, Object> hashMap = new HashMap<>();
        for (Map.Entry next : this.data.entrySet()) {
            hashMap.put((String) next.getKey(), normalizeValue(next.getValue()));
        }
        return hashMap;
    }
}
