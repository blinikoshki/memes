package org.jetbrains.anko.collections;

import android.util.SparseIntArray;
import editor.ffmpeg.api.FfmpegCommand;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;

@Metadata(mo26105bv = {1, 0, 1}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lorg/jetbrains/anko/collections/SparseIntArraySequence;", "Lkotlin/sequences/Sequence;", "", "a", "Landroid/util/SparseIntArray;", "(Landroid/util/SparseIntArray;)V", "iterator", "", "SparseIntArrayIterator", "commons_release"}, mo26108k = 1, mo26109mv = {1, 1, 5})
/* compiled from: Arrays.kt */
public final class SparseIntArraySequence implements Sequence<Integer> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final SparseIntArray f493a;

    public SparseIntArraySequence(SparseIntArray sparseIntArray) {
        Intrinsics.checkParameterIsNotNull(sparseIntArray, FfmpegCommand.AUDIO_STREAM);
        this.f493a = sparseIntArray;
    }

    public Iterator<Integer> iterator() {
        return new SparseIntArrayIterator();
    }

    @Metadata(mo26105bv = {1, 0, 1}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Lorg/jetbrains/anko/collections/SparseIntArraySequence$SparseIntArrayIterator;", "", "", "(Lorg/jetbrains/anko/collections/SparseIntArraySequence;)V", "index", "size", "hasNext", "", "next", "()Ljava/lang/Integer;", "commons_release"}, mo26108k = 1, mo26109mv = {1, 1, 5})
    /* compiled from: Arrays.kt */
    private final class SparseIntArrayIterator implements Iterator<Integer>, KMappedMarker {
        private int index;
        private final int size;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public SparseIntArrayIterator() {
            this.size = SparseIntArraySequence.this.f493a.size();
        }

        public boolean hasNext() {
            return this.size > this.index;
        }

        public Integer next() {
            if (SparseIntArraySequence.this.f493a.size() == this.size) {
                SparseIntArray access$getA$p = SparseIntArraySequence.this.f493a;
                int i = this.index;
                this.index = i + 1;
                return Integer.valueOf(access$getA$p.get(i));
            }
            throw new ConcurrentModificationException();
        }
    }
}
