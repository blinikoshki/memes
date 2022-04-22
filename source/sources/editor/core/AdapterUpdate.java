package editor.core;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006HÆ\u0003J+\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006HÆ\u0001J\u0006\u0010\u0011\u001a\u00020\u0004J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0011\u001a\u00020\u0004J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, mo26107d2 = {"Leditor/core/AdapterUpdate;", "ITEM", "", "page", "", "items", "", "(ILjava/util/List;)V", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getPage", "()I", "component1", "component2", "copy", "count", "equals", "", "other", "hashCode", "keepOnly", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AdapterUpdate.kt */
public final class AdapterUpdate<ITEM> {
    private List<? extends ITEM> items;
    private final int page;

    public static /* synthetic */ AdapterUpdate copy$default(AdapterUpdate adapterUpdate, int i, List<? extends ITEM> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = adapterUpdate.page;
        }
        if ((i2 & 2) != 0) {
            list = adapterUpdate.items;
        }
        return adapterUpdate.copy(i, list);
    }

    public final int component1() {
        return this.page;
    }

    public final List<ITEM> component2() {
        return this.items;
    }

    public final AdapterUpdate<ITEM> copy(int i, List<? extends ITEM> list) {
        return new AdapterUpdate<>(i, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdapterUpdate)) {
            return false;
        }
        AdapterUpdate adapterUpdate = (AdapterUpdate) obj;
        return this.page == adapterUpdate.page && Intrinsics.areEqual((Object) this.items, (Object) adapterUpdate.items);
    }

    public int hashCode() {
        int i = this.page * 31;
        List<? extends ITEM> list = this.items;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "AdapterUpdate(page=" + this.page + ", items=" + this.items + ")";
    }

    public AdapterUpdate(int i, List<? extends ITEM> list) {
        this.page = i;
        this.items = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdapterUpdate(int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, list);
    }

    public final int getPage() {
        return this.page;
    }

    public final List<ITEM> getItems() {
        return this.items;
    }

    public final void setItems(List<? extends ITEM> list) {
        this.items = list;
    }

    public final AdapterUpdate<ITEM> keepOnly(int i) {
        List<? extends ITEM> list = this.items;
        if (list != null && list.size() > i) {
            this.items = list.subList(0, i);
        }
        return this;
    }

    public final int count() {
        List<? extends ITEM> list = this.items;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
