package coil.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0004J(\u0010\n\u001a\u00020\u000b\"\u0004\b\u0002\u0010\u0001\"\u0004\b\u0003\u0010\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0007H\u0002J\u001c\u0010\r\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\u0002J\u001c\u0010\u000e\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\u0002J\u001b\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001¢\u0006\u0002\u0010\u0012J(\u0010\u0013\u001a\u00020\u000b\"\u0004\b\u0002\u0010\u0001\"\u0004\b\u0003\u0010\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0007H\u0002J\r\u0010\u0014\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\u0015J\u0015\u0010\u0014\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016RB\u0010\u0005\u001a6\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00070\u0006j\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007`\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo26107d2 = {"Lcoil/collection/LinkedMultimap;", "K", "V", "", "()V", "entries", "Ljava/util/HashMap;", "Lcoil/collection/LinkedMultimap$LinkedEntry;", "Lkotlin/collections/HashMap;", "head", "insertEntry", "", "entry", "makeHead", "makeTail", "put", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "removeEntry", "removeLast", "()Ljava/lang/Object;", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "LinkedEntry", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: LinkedMultimap.kt */
public final class LinkedMultimap<K, V> {
    private final HashMap<K, LinkedEntry<K, V>> entries = new HashMap<>();
    private final LinkedEntry<K, V> head = new LinkedEntry<>(null);

    public final void put(K k, V v) {
        Map map = this.entries;
        Object obj = map.get(k);
        LinkedEntry linkedEntry = obj;
        if (obj == null) {
            LinkedEntry linkedEntry2 = new LinkedEntry(k);
            makeTail(linkedEntry2);
            map.put(k, linkedEntry2);
            linkedEntry = linkedEntry2;
        }
        ((LinkedEntry) linkedEntry).add(v);
    }

    public final V removeLast(K k) {
        Map map = this.entries;
        Object obj = map.get(k);
        if (obj == null) {
            obj = new LinkedEntry(k);
            map.put(k, obj);
        }
        LinkedEntry linkedEntry = (LinkedEntry) obj;
        makeHead(linkedEntry);
        return linkedEntry.removeLast();
    }

    public final V removeLast() {
        for (LinkedEntry<K, V> prev = this.head.getPrev(); !Intrinsics.areEqual((Object) prev, (Object) this.head); prev = prev.getPrev()) {
            V removeLast = prev.removeLast();
            if (removeLast != null) {
                return removeLast;
            }
            removeEntry(prev);
            Map map = this.entries;
            K key = prev.getKey();
            Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
            TypeIntrinsics.asMutableMap(map).remove(key);
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedMultimap( ");
        LinkedEntry<K, V> next = this.head.getNext();
        while (!Intrinsics.areEqual((Object) next, (Object) this.head)) {
            sb.append('{');
            sb.append(next.getKey());
            sb.append(':');
            sb.append(next.getSize());
            sb.append('}');
            next = next.getNext();
            if (!Intrinsics.areEqual((Object) next, (Object) this.head)) {
                sb.append(", ");
            }
        }
        sb.append(" )");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    private final void makeHead(LinkedEntry<K, V> linkedEntry) {
        removeEntry(linkedEntry);
        linkedEntry.setPrev(this.head);
        linkedEntry.setNext(this.head.getNext());
        insertEntry(linkedEntry);
    }

    private final void makeTail(LinkedEntry<K, V> linkedEntry) {
        removeEntry(linkedEntry);
        linkedEntry.setPrev(this.head.getPrev());
        linkedEntry.setNext(this.head);
        insertEntry(linkedEntry);
    }

    private final <K, V> void insertEntry(LinkedEntry<K, V> linkedEntry) {
        linkedEntry.getNext().setPrev(linkedEntry);
        linkedEntry.getPrev().setNext(linkedEntry);
    }

    private final <K, V> void removeEntry(LinkedEntry<K, V> linkedEntry) {
        linkedEntry.getPrev().setNext(linkedEntry.getNext());
        linkedEntry.getNext().setPrev(linkedEntry.getPrev());
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00018\u0002¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u0003¢\u0006\u0002\u0010\u0005J\r\u0010\u001a\u001a\u0004\u0018\u00018\u0003¢\u0006\u0002\u0010\u0007R\u0015\u0010\u0004\u001a\u0004\u0018\u00018\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo26107d2 = {"Lcoil/collection/LinkedMultimap$LinkedEntry;", "K", "V", "", "key", "(Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "next", "getNext", "()Lcoil/collection/LinkedMultimap$LinkedEntry;", "setNext", "(Lcoil/collection/LinkedMultimap$LinkedEntry;)V", "prev", "getPrev", "setPrev", "size", "", "getSize", "()I", "values", "", "add", "", "value", "removeLast", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: LinkedMultimap.kt */
    private static final class LinkedEntry<K, V> {
        private final K key;
        private LinkedEntry<K, V> next;
        private LinkedEntry<K, V> prev;
        private List<V> values;

        public LinkedEntry(K k) {
            this.key = k;
            LinkedEntry<K, V> linkedEntry = this;
            this.prev = linkedEntry;
            this.next = linkedEntry;
        }

        public final K getKey() {
            return this.key;
        }

        public final LinkedEntry<K, V> getPrev() {
            return this.prev;
        }

        public final void setPrev(LinkedEntry<K, V> linkedEntry) {
            Intrinsics.checkNotNullParameter(linkedEntry, "<set-?>");
            this.prev = linkedEntry;
        }

        public final LinkedEntry<K, V> getNext() {
            return this.next;
        }

        public final void setNext(LinkedEntry<K, V> linkedEntry) {
            Intrinsics.checkNotNullParameter(linkedEntry, "<set-?>");
            this.next = linkedEntry;
        }

        public final int getSize() {
            List<V> list = this.values;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public final V removeLast() {
            List<V> list = this.values;
            if (list != null) {
                return CollectionsKt.removeLastOrNull(list);
            }
            return null;
        }

        public final void add(V v) {
            List<V> list = this.values;
            if (list == null) {
                list = new ArrayList<>();
                this.values = list;
            }
            list.add(v);
        }
    }
}
