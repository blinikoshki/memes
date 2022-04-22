package com.memes.eventtracker.alias;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, mo26107d2 = {"Lcom/memes/eventtracker/alias/EventAlias;", "", "id", "", "fb", "af", "fi", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAf", "()Ljava/lang/String;", "getFb", "getFi", "getId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "eventtracker_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EventAlias.kt */
public final class EventAlias {

    /* renamed from: af */
    private final String f984af;

    /* renamed from: fb */
    private final String f985fb;

    /* renamed from: fi */
    private final String f986fi;

    /* renamed from: id */
    private final String f987id;

    public static /* synthetic */ EventAlias copy$default(EventAlias eventAlias, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = eventAlias.f987id;
        }
        if ((i & 2) != 0) {
            str2 = eventAlias.f985fb;
        }
        if ((i & 4) != 0) {
            str3 = eventAlias.f984af;
        }
        if ((i & 8) != 0) {
            str4 = eventAlias.f986fi;
        }
        return eventAlias.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.f987id;
    }

    public final String component2() {
        return this.f985fb;
    }

    public final String component3() {
        return this.f984af;
    }

    public final String component4() {
        return this.f986fi;
    }

    public final EventAlias copy(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "id");
        return new EventAlias(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EventAlias)) {
            return false;
        }
        EventAlias eventAlias = (EventAlias) obj;
        return Intrinsics.areEqual((Object) this.f987id, (Object) eventAlias.f987id) && Intrinsics.areEqual((Object) this.f985fb, (Object) eventAlias.f985fb) && Intrinsics.areEqual((Object) this.f984af, (Object) eventAlias.f984af) && Intrinsics.areEqual((Object) this.f986fi, (Object) eventAlias.f986fi);
    }

    public int hashCode() {
        String str = this.f987id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f985fb;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f984af;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f986fi;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "EventAlias(id=" + this.f987id + ", fb=" + this.f985fb + ", af=" + this.f984af + ", fi=" + this.f986fi + ")";
    }

    public EventAlias(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.f987id = str;
        this.f985fb = str2;
        this.f984af = str3;
        this.f986fi = str4;
    }

    public final String getId() {
        return this.f987id;
    }

    public final String getFb() {
        return this.f985fb;
    }

    public final String getAf() {
        return this.f984af;
    }

    public final String getFi() {
        return this.f986fi;
    }
}
