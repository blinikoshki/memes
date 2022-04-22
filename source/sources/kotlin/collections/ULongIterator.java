package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u0002H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u0002H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\u0006ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\t"}, mo26107d2 = {"Lkotlin/collections/ULongIterator;", "", "Lkotlin/ULong;", "()V", "next", "next-s-VKNKU", "()J", "nextULong", "nextULong-s-VKNKU", "kotlin-stdlib"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: UIterators.kt */
public abstract class ULongIterator implements Iterator<ULong>, KMappedMarker {
    /* renamed from: nextULong-s-VKNKU  reason: not valid java name */
    public abstract long m1461nextULongsVKNKU();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object next() {
        return ULong.m1179boximpl(m1460nextsVKNKU());
    }

    /* renamed from: next-s-VKNKU  reason: not valid java name */
    public final long m1460nextsVKNKU() {
        return m1461nextULongsVKNKU();
    }
}
