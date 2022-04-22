package com.zhuinden.tupleskt;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u0004*\u0004\b\u0004\u0010\u0005*\u0004\b\u0005\u0010\u0006*\u0004\b\u0006\u0010\u00072\u00020\bB=\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00028\u0001\u0012\u0006\u0010\u000b\u001a\u00028\u0002\u0012\u0006\u0010\f\u001a\u00028\u0003\u0012\u0006\u0010\r\u001a\u00028\u0004\u0012\u0006\u0010\u000e\u001a\u00028\u0005\u0012\u0006\u0010\u000f\u001a\u00028\u0006¢\u0006\u0002\u0010\u0010J\u000e\u0010\u001a\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000e\u0010\u001b\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000e\u0010\u001c\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000e\u0010\u001d\u001a\u00028\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000e\u0010\u001e\u001a\u00028\u0004HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000e\u0010\u001f\u001a\u00028\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000e\u0010 \u001a\u00028\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J~\u0010!\u001a,\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u00060\u00002\b\b\u0002\u0010\t\u001a\u00028\u00002\b\b\u0002\u0010\n\u001a\u00028\u00012\b\b\u0002\u0010\u000b\u001a\u00028\u00022\b\b\u0002\u0010\f\u001a\u00028\u00032\b\b\u0002\u0010\r\u001a\u00028\u00042\b\b\u0002\u0010\u000e\u001a\u00028\u00052\b\b\u0002\u0010\u000f\u001a\u00028\u0006HÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\b\u0010)\u001a\u00020*H\u0016R\u0013\u0010\r\u001a\u00028\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\f\u001a\u00028\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\n\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\u000f\u001a\u00028\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\u000e\u001a\u00028\u0005¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0012R\u0013\u0010\u000b\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0019\u0010\u0012¨\u0006+"}, mo26107d2 = {"Lcom/zhuinden/tupleskt/Tuple7;", "A", "B", "C", "D", "E", "F", "G", "Ljava/io/Serializable;", "first", "second", "third", "fourth", "fifth", "sixth", "seventh", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getFifth", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getFirst", "getFourth", "getSecond", "getSeventh", "getSixth", "getThird", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/zhuinden/tupleskt/Tuple7;", "equals", "", "other", "", "hashCode", "", "toString", "", "com.zhuinden.tupleskt"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: Tuples.kt */
public final class Tuple7<A, B, C, D, E, F, G> implements Serializable {
    private final E fifth;
    private final A first;
    private final D fourth;
    private final B second;
    private final G seventh;
    private final F sixth;
    private final C third;

    public static /* synthetic */ Tuple7 copy$default(Tuple7 tuple7, A a, B b, C c, D d, E e, F f, G g, int i, Object obj) {
        if ((i & 1) != 0) {
            a = tuple7.first;
        }
        if ((i & 2) != 0) {
            b = tuple7.second;
        }
        B b2 = b;
        if ((i & 4) != 0) {
            c = tuple7.third;
        }
        C c2 = c;
        if ((i & 8) != 0) {
            d = tuple7.fourth;
        }
        D d2 = d;
        if ((i & 16) != 0) {
            e = tuple7.fifth;
        }
        E e2 = e;
        if ((i & 32) != 0) {
            f = tuple7.sixth;
        }
        F f2 = f;
        if ((i & 64) != 0) {
            g = tuple7.seventh;
        }
        return tuple7.copy(a, b2, c2, d2, e2, f2, g);
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

    public final Tuple7<A, B, C, D, E, F, G> copy(A a, B b, C c, D d, E e, F f, G g) {
        return new Tuple7(a, b, c, d, e, f, g);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tuple7)) {
            return false;
        }
        Tuple7 tuple7 = (Tuple7) obj;
        return Intrinsics.areEqual((Object) this.first, (Object) tuple7.first) && Intrinsics.areEqual((Object) this.second, (Object) tuple7.second) && Intrinsics.areEqual((Object) this.third, (Object) tuple7.third) && Intrinsics.areEqual((Object) this.fourth, (Object) tuple7.fourth) && Intrinsics.areEqual((Object) this.fifth, (Object) tuple7.fifth) && Intrinsics.areEqual((Object) this.sixth, (Object) tuple7.sixth) && Intrinsics.areEqual((Object) this.seventh, (Object) tuple7.seventh);
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
        if (g != null) {
            i = g.hashCode();
        }
        return hashCode6 + i;
    }

    public Tuple7(A a, B b, C c, D d, E e, F f, G g) {
        this.first = a;
        this.second = b;
        this.third = c;
        this.fourth = d;
        this.fifth = e;
        this.sixth = f;
        this.seventh = g;
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

    public String toString() {
        return "Tuple7[" + this.first + ", " + this.second + ", " + this.third + ", " + this.fourth + ", " + this.fifth + ", " + this.sixth + ", " + this.seventh + ']';
    }
}
