package com.memes.network.util.zipgson.object;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/network/util/zipgson/object/ZippedObject;", "T1", "T2", "", "object1", "object2", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getObject1", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getObject2", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ZippedObject.kt */
public final class ZippedObject<T1, T2> {
    private final T1 object1;
    private final T2 object2;

    public ZippedObject(T1 t1, T2 t2) {
        this.object1 = t1;
        this.object2 = t2;
    }

    public final T1 getObject1() {
        return this.object1;
    }

    public final T2 getObject2() {
        return this.object2;
    }
}
