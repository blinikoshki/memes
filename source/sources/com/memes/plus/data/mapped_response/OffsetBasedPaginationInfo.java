package com.memes.plus.data.mapped_response;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, mo26107d2 = {"Lcom/memes/plus/data/mapped_response/OffsetBasedPaginationInfo;", "Lcom/memes/plus/data/mapped_response/PaginationInfo;", "limit", "", "offset", "", "(ILjava/lang/String;)V", "getLimit", "()I", "getOffset", "()Ljava/lang/String;", "canFetchNextPage", "", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: OffsetBasedPaginationInfo.kt */
public final class OffsetBasedPaginationInfo implements PaginationInfo {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int limit;
    private final String offset;

    public static /* synthetic */ OffsetBasedPaginationInfo copy$default(OffsetBasedPaginationInfo offsetBasedPaginationInfo, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = offsetBasedPaginationInfo.limit;
        }
        if ((i2 & 2) != 0) {
            str = offsetBasedPaginationInfo.offset;
        }
        return offsetBasedPaginationInfo.copy(i, str);
    }

    public final int component1() {
        return this.limit;
    }

    public final String component2() {
        return this.offset;
    }

    public final OffsetBasedPaginationInfo copy(int i, String str) {
        return new OffsetBasedPaginationInfo(i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OffsetBasedPaginationInfo)) {
            return false;
        }
        OffsetBasedPaginationInfo offsetBasedPaginationInfo = (OffsetBasedPaginationInfo) obj;
        return this.limit == offsetBasedPaginationInfo.limit && Intrinsics.areEqual((Object) this.offset, (Object) offsetBasedPaginationInfo.offset);
    }

    public int hashCode() {
        int i = this.limit * 31;
        String str = this.offset;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "OffsetBasedPaginationInfo(limit=" + this.limit + ", offset=" + this.offset + ")";
    }

    public OffsetBasedPaginationInfo(int i, String str) {
        this.limit = i;
        this.offset = str;
    }

    public final int getLimit() {
        return this.limit;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OffsetBasedPaginationInfo(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : str);
    }

    public final String getOffset() {
        return this.offset;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/data/mapped_response/OffsetBasedPaginationInfo$Companion;", "", "()V", "default", "Lcom/memes/plus/data/mapped_response/OffsetBasedPaginationInfo;", "limit", "", "offset", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: OffsetBasedPaginationInfo.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ OffsetBasedPaginationInfo default$default(Companion companion, int i, String str, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                str = null;
            }
            return companion.m2576default(i, str);
        }

        /* renamed from: default  reason: not valid java name */
        public final OffsetBasedPaginationInfo m2576default(int i, String str) {
            return new OffsetBasedPaginationInfo(i, str);
        }
    }

    public final boolean canFetchNextPage() {
        return this.offset != null;
    }
}
