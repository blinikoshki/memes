package com.zhuinden.tupleskt;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u0004*\u0004\b\u0004\u0010\u0005*\u0004\b\u0005\u0010\u0006*\u0004\b\u0006\u0010\u0007*\u0004\b\u0007\u0010\b*\u0004\b\b\u0010\t*\u0004\b\t\u0010\n*\u0004\b\n\u0010\u000b*\u0004\b\u000b\u0010\f*\u0004\b\f\u0010\r*\u0004\b\r\u0010\u000e2\u00020\u000fBu\u0012\u0006\u0010\u0010\u001a\u00028\u0000\u0012\u0006\u0010\u0011\u001a\u00028\u0001\u0012\u0006\u0010\u0012\u001a\u00028\u0002\u0012\u0006\u0010\u0013\u001a\u00028\u0003\u0012\u0006\u0010\u0014\u001a\u00028\u0004\u0012\u0006\u0010\u0015\u001a\u00028\u0005\u0012\u0006\u0010\u0016\u001a\u00028\u0006\u0012\u0006\u0010\u0017\u001a\u00028\u0007\u0012\u0006\u0010\u0018\u001a\u00028\b\u0012\u0006\u0010\u0019\u001a\u00028\t\u0012\u0006\u0010\u001a\u001a\u00028\n\u0012\u0006\u0010\u001b\u001a\u00028\u000b\u0012\u0006\u0010\u001c\u001a\u00028\f\u0012\u0006\u0010\u001d\u001a\u00028\r¢\u0006\u0002\u0010\u001eJ\u000e\u0010/\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010 J\u000e\u00100\u001a\u00028\tHÆ\u0003¢\u0006\u0002\u0010 J\u000e\u00101\u001a\u00028\nHÆ\u0003¢\u0006\u0002\u0010 J\u000e\u00102\u001a\u00028\u000bHÆ\u0003¢\u0006\u0002\u0010 J\u000e\u00103\u001a\u00028\fHÆ\u0003¢\u0006\u0002\u0010 J\u000e\u00104\u001a\u00028\rHÆ\u0003¢\u0006\u0002\u0010 J\u000e\u00105\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010 J\u000e\u00106\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010 J\u000e\u00107\u001a\u00028\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u000e\u00108\u001a\u00028\u0004HÆ\u0003¢\u0006\u0002\u0010 J\u000e\u00109\u001a\u00028\u0005HÆ\u0003¢\u0006\u0002\u0010 J\u000e\u0010:\u001a\u00028\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u000e\u0010;\u001a\u00028\u0007HÆ\u0003¢\u0006\u0002\u0010 J\u000e\u0010<\u001a\u00028\bHÆ\u0003¢\u0006\u0002\u0010 Jî\u0001\u0010=\u001aV\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r0\u00002\b\b\u0002\u0010\u0010\u001a\u00028\u00002\b\b\u0002\u0010\u0011\u001a\u00028\u00012\b\b\u0002\u0010\u0012\u001a\u00028\u00022\b\b\u0002\u0010\u0013\u001a\u00028\u00032\b\b\u0002\u0010\u0014\u001a\u00028\u00042\b\b\u0002\u0010\u0015\u001a\u00028\u00052\b\b\u0002\u0010\u0016\u001a\u00028\u00062\b\b\u0002\u0010\u0017\u001a\u00028\u00072\b\b\u0002\u0010\u0018\u001a\u00028\b2\b\b\u0002\u0010\u0019\u001a\u00028\t2\b\b\u0002\u0010\u001a\u001a\u00028\n2\b\b\u0002\u0010\u001b\u001a\u00028\u000b2\b\b\u0002\u0010\u001c\u001a\u00028\f2\b\b\u0002\u0010\u001d\u001a\u00028\rHÆ\u0001¢\u0006\u0002\u0010>J\u0013\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010BHÖ\u0003J\t\u0010C\u001a\u00020DHÖ\u0001J\b\u0010E\u001a\u00020FH\u0016R\u0013\u0010\u0017\u001a\u00028\u0007¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u001a\u001a\u00028\n¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\"\u0010 R\u0013\u0010\u0014\u001a\u00028\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b#\u0010 R\u0013\u0010\u0010\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010!\u001a\u0004\b$\u0010 R\u0013\u0010\u001d\u001a\u00028\r¢\u0006\n\n\u0002\u0010!\u001a\u0004\b%\u0010 R\u0013\u0010\u0013\u001a\u00028\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b&\u0010 R\u0013\u0010\u0018\u001a\u00028\b¢\u0006\n\n\u0002\u0010!\u001a\u0004\b'\u0010 R\u0013\u0010\u0011\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010!\u001a\u0004\b(\u0010 R\u0013\u0010\u0016\u001a\u00028\u0006¢\u0006\n\n\u0002\u0010!\u001a\u0004\b)\u0010 R\u0013\u0010\u0015\u001a\u00028\u0005¢\u0006\n\n\u0002\u0010!\u001a\u0004\b*\u0010 R\u0013\u0010\u0019\u001a\u00028\t¢\u0006\n\n\u0002\u0010!\u001a\u0004\b+\u0010 R\u0013\u0010\u0012\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010!\u001a\u0004\b,\u0010 R\u0013\u0010\u001c\u001a\u00028\f¢\u0006\n\n\u0002\u0010!\u001a\u0004\b-\u0010 R\u0013\u0010\u001b\u001a\u00028\u000b¢\u0006\n\n\u0002\u0010!\u001a\u0004\b.\u0010 ¨\u0006G"}, mo26107d2 = {"Lcom/zhuinden/tupleskt/Tuple14;", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ljava/io/Serializable;", "first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth", "thirteenth", "fourteenth", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getEighth", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getEleventh", "getFifth", "getFirst", "getFourteenth", "getFourth", "getNinth", "getSecond", "getSeventh", "getSixth", "getTenth", "getThird", "getThirteenth", "getTwelfth", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/zhuinden/tupleskt/Tuple14;", "equals", "", "other", "", "hashCode", "", "toString", "", "com.zhuinden.tupleskt"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: Tuples.kt */
public final class Tuple14<A, B, C, D, E, F, G, H, I, J, K, L, M, N> implements Serializable {
    private final H eighth;
    private final K eleventh;
    private final E fifth;
    private final A first;
    private final N fourteenth;
    private final D fourth;
    private final I ninth;
    private final B second;
    private final G seventh;
    private final F sixth;
    private final J tenth;
    private final C third;
    private final M thirteenth;
    private final L twelfth;

    public static /* synthetic */ Tuple14 copy$default(Tuple14 tuple14, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, int i, Object obj15) {
        Tuple14 tuple142 = tuple14;
        int i2 = i;
        return tuple14.copy((i2 & 1) != 0 ? tuple142.first : obj, (i2 & 2) != 0 ? tuple142.second : obj2, (i2 & 4) != 0 ? tuple142.third : obj3, (i2 & 8) != 0 ? tuple142.fourth : obj4, (i2 & 16) != 0 ? tuple142.fifth : obj5, (i2 & 32) != 0 ? tuple142.sixth : obj6, (i2 & 64) != 0 ? tuple142.seventh : obj7, (i2 & 128) != 0 ? tuple142.eighth : obj8, (i2 & 256) != 0 ? tuple142.ninth : obj9, (i2 & 512) != 0 ? tuple142.tenth : obj10, (i2 & 1024) != 0 ? tuple142.eleventh : obj11, (i2 & 2048) != 0 ? tuple142.twelfth : obj12, (i2 & 4096) != 0 ? tuple142.thirteenth : obj13, (i2 & 8192) != 0 ? tuple142.fourteenth : obj14);
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

    public final L component12() {
        return this.twelfth;
    }

    public final M component13() {
        return this.thirteenth;
    }

    public final N component14() {
        return this.fourteenth;
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

    public final Tuple14<A, B, C, D, E, F, G, H, I, J, K, L, M, N> copy(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n) {
        return new Tuple14(a, b, c, d, e, f, g, h, i, j, k, l, m, n);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tuple14)) {
            return false;
        }
        Tuple14 tuple14 = (Tuple14) obj;
        return Intrinsics.areEqual((Object) this.first, (Object) tuple14.first) && Intrinsics.areEqual((Object) this.second, (Object) tuple14.second) && Intrinsics.areEqual((Object) this.third, (Object) tuple14.third) && Intrinsics.areEqual((Object) this.fourth, (Object) tuple14.fourth) && Intrinsics.areEqual((Object) this.fifth, (Object) tuple14.fifth) && Intrinsics.areEqual((Object) this.sixth, (Object) tuple14.sixth) && Intrinsics.areEqual((Object) this.seventh, (Object) tuple14.seventh) && Intrinsics.areEqual((Object) this.eighth, (Object) tuple14.eighth) && Intrinsics.areEqual((Object) this.ninth, (Object) tuple14.ninth) && Intrinsics.areEqual((Object) this.tenth, (Object) tuple14.tenth) && Intrinsics.areEqual((Object) this.eleventh, (Object) tuple14.eleventh) && Intrinsics.areEqual((Object) this.twelfth, (Object) tuple14.twelfth) && Intrinsics.areEqual((Object) this.thirteenth, (Object) tuple14.thirteenth) && Intrinsics.areEqual((Object) this.fourteenth, (Object) tuple14.fourteenth);
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
        int hashCode11 = (hashCode10 + (k != null ? k.hashCode() : 0)) * 31;
        L l = this.twelfth;
        int hashCode12 = (hashCode11 + (l != null ? l.hashCode() : 0)) * 31;
        M m = this.thirteenth;
        int hashCode13 = (hashCode12 + (m != null ? m.hashCode() : 0)) * 31;
        N n = this.fourteenth;
        if (n != null) {
            i = n.hashCode();
        }
        return hashCode13 + i;
    }

    public Tuple14(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n) {
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
        this.twelfth = l;
        this.thirteenth = m;
        this.fourteenth = n;
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

    public final L getTwelfth() {
        return this.twelfth;
    }

    public final M getThirteenth() {
        return this.thirteenth;
    }

    public final N getFourteenth() {
        return this.fourteenth;
    }

    public String toString() {
        return "Tuple14[" + this.first + ", " + this.second + ", " + this.third + ", " + this.fourth + ", " + this.fifth + ", " + this.sixth + ", " + this.seventh + ", " + this.eighth + ", " + this.ninth + ", " + this.tenth + ", " + this.eleventh + ", " + this.twelfth + ", " + this.thirteenth + ", " + this.fourteenth + ']';
    }
}
