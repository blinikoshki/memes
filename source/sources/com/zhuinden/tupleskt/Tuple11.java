package com.zhuinden.tupleskt;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u0004*\u0004\b\u0004\u0010\u0005*\u0004\b\u0005\u0010\u0006*\u0004\b\u0006\u0010\u0007*\u0004\b\u0007\u0010\b*\u0004\b\b\u0010\t*\u0004\b\t\u0010\n*\u0004\b\n\u0010\u000b2\u00020\fB]\u0012\u0006\u0010\r\u001a\u00028\u0000\u0012\u0006\u0010\u000e\u001a\u00028\u0001\u0012\u0006\u0010\u000f\u001a\u00028\u0002\u0012\u0006\u0010\u0010\u001a\u00028\u0003\u0012\u0006\u0010\u0011\u001a\u00028\u0004\u0012\u0006\u0010\u0012\u001a\u00028\u0005\u0012\u0006\u0010\u0013\u001a\u00028\u0006\u0012\u0006\u0010\u0014\u001a\u00028\u0007\u0012\u0006\u0010\u0015\u001a\u00028\b\u0012\u0006\u0010\u0016\u001a\u00028\t\u0012\u0006\u0010\u0017\u001a\u00028\n¢\u0006\u0002\u0010\u0018J\u000e\u0010&\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000e\u0010'\u001a\u00028\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000e\u0010(\u001a\u00028\nHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000e\u0010)\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000e\u0010*\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000e\u0010+\u001a\u00028\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000e\u0010,\u001a\u00028\u0004HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000e\u0010-\u001a\u00028\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000e\u0010.\u001a\u00028\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000e\u0010/\u001a\u00028\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000e\u00100\u001a\u00028\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ¾\u0001\u00101\u001aD\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n0\u00002\b\b\u0002\u0010\r\u001a\u00028\u00002\b\b\u0002\u0010\u000e\u001a\u00028\u00012\b\b\u0002\u0010\u000f\u001a\u00028\u00022\b\b\u0002\u0010\u0010\u001a\u00028\u00032\b\b\u0002\u0010\u0011\u001a\u00028\u00042\b\b\u0002\u0010\u0012\u001a\u00028\u00052\b\b\u0002\u0010\u0013\u001a\u00028\u00062\b\b\u0002\u0010\u0014\u001a\u00028\u00072\b\b\u0002\u0010\u0015\u001a\u00028\b2\b\b\u0002\u0010\u0016\u001a\u00028\t2\b\b\u0002\u0010\u0017\u001a\u00028\nHÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u000208HÖ\u0001J\b\u00109\u001a\u00020:H\u0016R\u0013\u0010\u0014\u001a\u00028\u0007¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0017\u001a\u00028\n¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001aR\u0013\u0010\u0011\u001a\u00028\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001d\u0010\u001aR\u0013\u0010\r\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001e\u0010\u001aR\u0013\u0010\u0010\u001a\u00028\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001f\u0010\u001aR\u0013\u0010\u0015\u001a\u00028\b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b \u0010\u001aR\u0013\u0010\u000e\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b!\u0010\u001aR\u0013\u0010\u0013\u001a\u00028\u0006¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\"\u0010\u001aR\u0013\u0010\u0012\u001a\u00028\u0005¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b#\u0010\u001aR\u0013\u0010\u0016\u001a\u00028\t¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b$\u0010\u001aR\u0013\u0010\u000f\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b%\u0010\u001a¨\u0006;"}, mo26107d2 = {"Lcom/zhuinden/tupleskt/Tuple11;", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "Ljava/io/Serializable;", "first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getEighth", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getEleventh", "getFifth", "getFirst", "getFourth", "getNinth", "getSecond", "getSeventh", "getSixth", "getTenth", "getThird", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/zhuinden/tupleskt/Tuple11;", "equals", "", "other", "", "hashCode", "", "toString", "", "com.zhuinden.tupleskt"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: Tuples.kt */
public final class Tuple11<A, B, C, D, E, F, G, H, I, J, K> implements Serializable {
    private final H eighth;
    private final K eleventh;
    private final E fifth;
    private final A first;
    private final D fourth;
    private final I ninth;
    private final B second;
    private final G seventh;
    private final F sixth;
    private final J tenth;
    private final C third;

    public static /* synthetic */ Tuple11 copy$default(Tuple11 tuple11, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, int i, Object obj12) {
        Tuple11 tuple112 = tuple11;
        int i2 = i;
        return tuple11.copy((i2 & 1) != 0 ? tuple112.first : obj, (i2 & 2) != 0 ? tuple112.second : obj2, (i2 & 4) != 0 ? tuple112.third : obj3, (i2 & 8) != 0 ? tuple112.fourth : obj4, (i2 & 16) != 0 ? tuple112.fifth : obj5, (i2 & 32) != 0 ? tuple112.sixth : obj6, (i2 & 64) != 0 ? tuple112.seventh : obj7, (i2 & 128) != 0 ? tuple112.eighth : obj8, (i2 & 256) != 0 ? tuple112.ninth : obj9, (i2 & 512) != 0 ? tuple112.tenth : obj10, (i2 & 1024) != 0 ? tuple112.eleventh : obj11);
    }

    public final A component1() {
        return this.first;
    }

    public final J component10() {
        return this.tenth;
    }

    public final K component11() {
        return this.eleventh;
    }

    public final B component2() {
        return this.second;
    }

    public final C component3() {
        return this.third;
    }

    public final D component4() {
        return this.fourth;
    }

    public final E component5() {
        return this.fifth;
    }

    public final F component6() {
        return this.sixth;
    }

    public final G component7() {
        return this.seventh;
    }

    public final H component8() {
        return this.eighth;
    }

    public final I component9() {
        return this.ninth;
    }

    public final Tuple11<A, B, C, D, E, F, G, H, I, J, K> copy(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k) {
        return new Tuple11(a, b, c, d, e, f, g, h, i, j, k);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tuple11)) {
            return false;
        }
        Tuple11 tuple11 = (Tuple11) obj;
        return Intrinsics.areEqual((Object) this.first, (Object) tuple11.first) && Intrinsics.areEqual((Object) this.second, (Object) tuple11.second) && Intrinsics.areEqual((Object) this.third, (Object) tuple11.third) && Intrinsics.areEqual((Object) this.fourth, (Object) tuple11.fourth) && Intrinsics.areEqual((Object) this.fifth, (Object) tuple11.fifth) && Intrinsics.areEqual((Object) this.sixth, (Object) tuple11.sixth) && Intrinsics.areEqual((Object) this.seventh, (Object) tuple11.seventh) && Intrinsics.areEqual((Object) this.eighth, (Object) tuple11.eighth) && Intrinsics.areEqual((Object) this.ninth, (Object) tuple11.ninth) && Intrinsics.areEqual((Object) this.tenth, (Object) tuple11.tenth) && Intrinsics.areEqual((Object) this.eleventh, (Object) tuple11.eleventh);
    }

    public int hashCode() {
        A a = this.first;
        int i = 0;
        int hashCode = (a != null ? a.hashCode() : 0) * 31;
        B b = this.second;
        int hashCode2 = (hashCode + (b != null ? b.hashCode() : 0)) * 31;
        C c = this.third;
        int hashCode3 = (hashCode2 + (c != null ? c.hashCode() : 0)) * 31;
        D d = this.fourth;
        int hashCode4 = (hashCode3 + (d != null ? d.hashCode() : 0)) * 31;
        E e = this.fifth;
        int hashCode5 = (hashCode4 + (e != null ? e.hashCode() : 0)) * 31;
        F f = this.sixth;
        int hashCode6 = (hashCode5 + (f != null ? f.hashCode() : 0)) * 31;
        G g = this.seventh;
        int hashCode7 = (hashCode6 + (g != null ? g.hashCode() : 0)) * 31;
        H h = this.eighth;
        int hashCode8 = (hashCode7 + (h != null ? h.hashCode() : 0)) * 31;
        I i2 = this.ninth;
        int hashCode9 = (hashCode8 + (i2 != null ? i2.hashCode() : 0)) * 31;
        J j = this.tenth;
        int hashCode10 = (hashCode9 + (j != null ? j.hashCode() : 0)) * 31;
        K k = this.eleventh;
        if (k != null) {
            i = k.hashCode();
        }
        return hashCode10 + i;
    }

    public Tuple11(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k) {
        this.first = a;
        this.second = b;
        this.third = c;
        this.fourth = d;
        this.fifth = e;
        this.sixth = f;
        this.seventh = g;
        this.eighth = h;
        this.ninth = i;
        this.tenth = j;
        this.eleventh = k;
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public final C getThird() {
        return this.third;
    }

    public final D getFourth() {
        return this.fourth;
    }

    public final E getFifth() {
        return this.fifth;
    }

    public final F getSixth() {
        return this.sixth;
    }

    public final G getSeventh() {
        return this.seventh;
    }

    public final H getEighth() {
        return this.eighth;
    }

    public final I getNinth() {
        return this.ninth;
    }

    public final J getTenth() {
        return this.tenth;
    }

    public final K getEleventh() {
        return this.eleventh;
    }

    public String toString() {
        return "Tuple11[" + this.first + ", " + this.second + ", " + this.third + ", " + this.fourth + ", " + this.fifth + ", " + this.sixth + ", " + this.seventh + ", " + this.eighth + ", " + this.ninth + ", " + this.tenth + ", " + this.eleventh + ']';
    }
}
