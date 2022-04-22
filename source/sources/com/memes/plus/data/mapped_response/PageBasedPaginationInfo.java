package com.memes.plus.data.mapped_response;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0018"}, mo26107d2 = {"Lcom/memes/plus/data/mapped_response/PageBasedPaginationInfo;", "Lcom/memes/plus/data/mapped_response/PaginationInfo;", "currentPage", "", "totalPages", "recordsPerPage", "(III)V", "getCurrentPage", "()I", "getRecordsPerPage", "getTotalPages", "canFetchNextPage", "", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: PageBasedPaginationInfo.kt */
public final class PageBasedPaginationInfo implements PaginationInfo {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int currentPage;
    private final int recordsPerPage;
    private final int totalPages;

    public static /* synthetic */ PageBasedPaginationInfo copy$default(PageBasedPaginationInfo pageBasedPaginationInfo, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = pageBasedPaginationInfo.currentPage;
        }
        if ((i4 & 2) != 0) {
            i2 = pageBasedPaginationInfo.totalPages;
        }
        if ((i4 & 4) != 0) {
            i3 = pageBasedPaginationInfo.recordsPerPage;
        }
        return pageBasedPaginationInfo.copy(i, i2, i3);
    }

    public final int component1() {
        return this.currentPage;
    }

    public final int component2() {
        return this.totalPages;
    }

    public final int component3() {
        return this.recordsPerPage;
    }

    public final PageBasedPaginationInfo copy(int i, int i2, int i3) {
        return new PageBasedPaginationInfo(i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PageBasedPaginationInfo)) {
            return false;
        }
        PageBasedPaginationInfo pageBasedPaginationInfo = (PageBasedPaginationInfo) obj;
        return this.currentPage == pageBasedPaginationInfo.currentPage && this.totalPages == pageBasedPaginationInfo.totalPages && this.recordsPerPage == pageBasedPaginationInfo.recordsPerPage;
    }

    public int hashCode() {
        return (((this.currentPage * 31) + this.totalPages) * 31) + this.recordsPerPage;
    }

    public String toString() {
        return "PageBasedPaginationInfo(currentPage=" + this.currentPage + ", totalPages=" + this.totalPages + ", recordsPerPage=" + this.recordsPerPage + ")";
    }

    public PageBasedPaginationInfo(int i, int i2, int i3) {
        this.currentPage = i;
        this.totalPages = i2;
        this.recordsPerPage = i3;
    }

    public final int getCurrentPage() {
        return this.currentPage;
    }

    public final int getTotalPages() {
        return this.totalPages;
    }

    public final int getRecordsPerPage() {
        return this.recordsPerPage;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, mo26107d2 = {"Lcom/memes/plus/data/mapped_response/PageBasedPaginationInfo$Companion;", "", "()V", "default", "Lcom/memes/plus/data/mapped_response/PageBasedPaginationInfo;", "currentPage", "", "totalPages", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: PageBasedPaginationInfo.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: default  reason: not valid java name */
        public final PageBasedPaginationInfo m2577default(int i, int i2) {
            return new PageBasedPaginationInfo(i, i2, -1);
        }
    }

    public final boolean canFetchNextPage() {
        return this.currentPage < this.totalPages;
    }
}
