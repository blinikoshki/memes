package com.memes.network.memes.source.remote.model.usersearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.p040ui.explore_search.ExploreSearchType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, mo26107d2 = {"Lcom/memes/network/memes/source/remote/model/usersearch/UserSearchRequest;", "", "keyword", "", "searchType", "page", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getKeyword", "()Ljava/lang/String;", "getPage", "()I", "getSearchType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: UserSearchRequest.kt */
public final class UserSearchRequest {
    @SerializedName("searchText")
    @Expose
    private final String keyword;
    @SerializedName("page")
    @Expose
    private final int page;
    @SerializedName("searchType")
    @Expose
    private final String searchType;

    public UserSearchRequest() {
        this((String) null, (String) null, 0, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ UserSearchRequest copy$default(UserSearchRequest userSearchRequest, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = userSearchRequest.keyword;
        }
        if ((i2 & 2) != 0) {
            str2 = userSearchRequest.searchType;
        }
        if ((i2 & 4) != 0) {
            i = userSearchRequest.page;
        }
        return userSearchRequest.copy(str, str2, i);
    }

    public final String component1() {
        return this.keyword;
    }

    public final String component2() {
        return this.searchType;
    }

    public final int component3() {
        return this.page;
    }

    public final UserSearchRequest copy(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str2, "searchType");
        return new UserSearchRequest(str, str2, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserSearchRequest)) {
            return false;
        }
        UserSearchRequest userSearchRequest = (UserSearchRequest) obj;
        return Intrinsics.areEqual((Object) this.keyword, (Object) userSearchRequest.keyword) && Intrinsics.areEqual((Object) this.searchType, (Object) userSearchRequest.searchType) && this.page == userSearchRequest.page;
    }

    public int hashCode() {
        String str = this.keyword;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.searchType;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode + i) * 31) + this.page;
    }

    public String toString() {
        return "UserSearchRequest(keyword=" + this.keyword + ", searchType=" + this.searchType + ", page=" + this.page + ")";
    }

    public UserSearchRequest(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str2, "searchType");
        this.keyword = str;
        this.searchType = str2;
        this.page = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserSearchRequest(String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? ExploreSearchType.PEOPLE : str2, (i2 & 4) != 0 ? 0 : i);
    }

    public final String getKeyword() {
        return this.keyword;
    }

    public final String getSearchType() {
        return this.searchType;
    }

    public final int getPage() {
        return this.page;
    }
}
