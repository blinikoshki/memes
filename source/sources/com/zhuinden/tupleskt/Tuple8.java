package com.zhuinden.tupleskt;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u0004*\u0004\b\u0004\u0010\u0005*\u0004\b\u0005\u0010\u0006*\u0004\b\u0006\u0010\u0007*\u0004\b\u0007\u0010\b2\u00020\tBE\u0012\u0006\u0010\n\u001a\u00028\u0000\u0012\u0006\u0010\u000b\u001a\u00028\u0001\u0012\u0006\u0010\f\u001a\u00028\u0002\u0012\u0006\u0010\r\u001a\u00028\u0003\u0012\u0006\u0010\u000e\u001a\u00028\u0004\u0012\u0006\u0010\u000f\u001a\u00028\u0005\u0012\u0006\u0010\u0010\u001a\u00028\u0006\u0012\u0006\u0010\u0011\u001a\u00028\u0007¢\u0006\u0002\u0010\u0012J\u000e\u0010\u001d\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000e\u0010\u001e\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000e\u0010\u001f\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000e\u0010 \u001a\u00028\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000e\u0010!\u001a\u00028\u0004HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000e\u0010\"\u001a\u00028\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000e\u0010#\u001a\u00028\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000e\u0010$\u001a\u00028\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0001\u0010%\u001a2\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u00070\u00002\b\b\u0002\u0010\n\u001a\u00028\u00002\b\b\u0002\u0010\u000b\u001a\u00028\u00012\b\b\u0002\u0010\f\u001a\u00028\u00022\b\b\u0002\u0010\r\u001a\u00028\u00032\b\b\u0002\u0010\u000e\u001a\u00028\u00042\b\b\u0002\u0010\u000f\u001a\u00028\u00052\b\b\u0002\u0010\u0010\u001a\u00028\u00062\b\b\u0002\u0010\u0011\u001a\u00028\u0007HÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\b\u0010-\u001a\u00020.H\u0016R\u0013\u0010\u0011\u001a\u00028\u0007¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000e\u001a\u00028\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\n\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\r\u001a\u00028\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0018\u0010\u0014R\u0013\u0010\u000b\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0019\u0010\u0014R\u0013\u0010\u0010\u001a\u00028\u0006¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001a\u0010\u0014R\u0013\u0010\u000f\u001a\u00028\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001b\u0010\u0014R\u0013\u0010\f\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001c\u0010\u0014¨\u0006/"}, mo26107d2 = {"Lcom/zhuinden/tupleskt/Tuple8;", "A", "B", "C", "D", "E", "F", "G", "H", "Ljava/io/Serializable;", "first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getEighth", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getFifth", "getFirst", "getFourth", "getSecond", "getSeventh", "getSixth", "getThird", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/zhuinden/tupleskt/Tuple8;", "equals", "", "other", "", "hashCode", "", "toString", "", "com.zhuinden.tupleskt"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: Tuples.kt */
public final class Tuple8<A, B, C, D, E, F, G, H> implements Serializable {
    private final H eighth;
    private final E fifth;
    private final A first;
    private final D fourth;
    private final B second;
    private final G seventh;
    private final F sixth;
    private final C third;

    public static /* synthetic */ Tuple8 copy$default(Tuple8 tuple8, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, int i, Object obj9) {
        Tuple8 tuple82 = tuple8;
        int i2 = i;
        return tuple8.copy((i2 & 1) != 0 ? tuple82.first : obj, (i2 & 2) != 0 ? tuple82.second : obj2, (i2 & 4) != 0 ? tuple82.third : obj3, (i2 & 8) != 0 ? tuple82.fourth : obj4, (i2 & 16) != 0 ? tuple82.fifth : obj5, (i2 & 32) != 0 ? tuple82.sixth : obj6, (i2 & 64) != 0 ? tuple82.seventh : obj7, (i2 & 128) != 0 ? tuple82.eighth : obj8);
    }

    public final A component1() {
        return this.first;
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

    public final Tuple8<A, B, C, D, E, F, G, H> copy(A a, B b, C c, D d, E e, F f, G g, H h) {
        return new Tuple8(a, b, c, d, e, f, g, h);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tuple8)) {
            return false;
        }
        Tuple8 tuple8 = (Tuple8) obj;
        return Intrinsics.areEqual((Object) this.first, (Object) tuple8.first) && Intrinsics.areEqual((Object) this.second, (Object) tuple8.second) && Intrinsics.areEqual((Object) this.third, (Object) tuple8.third) && Intrinsics.areEqual((Object) this.fourth, (Object) tuple8.fourth) && Intrinsics.areEqual((Object) this.fifth, (Object) tuple8.fifth) && Intrinsics.areEqual((Object) this.sixth, (Object) tuple8.sixth) && Intrinsics.areEqual((Object) this.seventh, (Object) tuple8.seventh) && Intrinsics.areEqual((Object) this.eighth, (Object) tuple8.eighth);
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
        if (h != null) {
            i = h.hashCode();
        }
        return hashCode7 + i;
    }

    public Tuple8(A a, B b, C c, D d, E e, F f, G g, H h) {
        this.first = a;
        this.second = b;
        this.third = c;
        this.fourth = d;
        this.fifth = e;
        this.sixth = f;
        this.seventh = g;
        this.eighth = h;
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

    public String toString() {
        return "Tuple8[" + this.first + ", " + this.second + ", " + this.third + ", " + this.fourth + ", " + this.fifth + ", " + this.sixth + ", " + this.seventh + ", " + this.eighth + ']';
    }
}
