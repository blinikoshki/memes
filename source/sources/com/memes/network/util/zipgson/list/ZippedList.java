package com.memes.network.util.zipgson.list;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B!\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/network/util/zipgson/list/ZippedList;", "T1", "T2", "", "list1", "", "list2", "(Ljava/util/List;Ljava/util/List;)V", "getList1", "()Ljava/util/List;", "getList2", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ZippedList.kt */
public final class ZippedList<T1, T2> {
    private final List<T1> list1;
    private final List<T2> list2;

    public ZippedList(List<? extends T1> list, List<? extends T2> list3) {
        Intrinsics.checkNotNullParameter(list, "list1");
        Intrinsics.checkNotNullParameter(list3, "list2");
        this.list1 = list;
        this.list2 = list3;
    }

    public final List<T1> getList1() {
        return this.list1;
    }

    public final List<T2> getList2() {
        return this.list2;
    }
}
