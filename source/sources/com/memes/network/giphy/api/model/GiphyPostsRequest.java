package com.memes.network.giphy.api.model;

import com.google.android.gms.actions.SearchIntents;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, mo26107d2 = {"Lcom/memes/network/giphy/api/model/GiphyPostsRequest;", "", "query", "", "limit", "", "offset", "(Ljava/lang/String;ILjava/lang/String;)V", "getLimit", "()I", "getOffset", "()Ljava/lang/String;", "getQuery", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GiphyPostsRequest.kt */
public final class GiphyPostsRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String QUERY_TRENDING = "trending";
    private final int limit;
    private final String offset;
    private final String query;

    public static /* synthetic */ GiphyPostsRequest copy$default(GiphyPostsRequest giphyPostsRequest, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = giphyPostsRequest.query;
        }
        if ((i2 & 2) != 0) {
            i = giphyPostsRequest.limit;
        }
        if ((i2 & 4) != 0) {
            str2 = giphyPostsRequest.offset;
        }
        return giphyPostsRequest.copy(str, i, str2);
    }

    public final String component1() {
        return this.query;
    }

    public final int component2() {
        return this.limit;
    }

    public final String component3() {
        return this.offset;
    }

    public final GiphyPostsRequest copy(String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(str, SearchIntents.EXTRA_QUERY);
        Intrinsics.checkNotNullParameter(str2, "offset");
        return new GiphyPostsRequest(str, i, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GiphyPostsRequest)) {
            return false;
        }
        GiphyPostsRequest giphyPostsRequest = (GiphyPostsRequest) obj;
        return Intrinsics.areEqual((Object) this.query, (Object) giphyPostsRequest.query) && this.limit == giphyPostsRequest.limit && Intrinsics.areEqual((Object) this.offset, (Object) giphyPostsRequest.offset);
    }

    public int hashCode() {
        String str = this.query;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.limit) * 31;
        String str2 = this.offset;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "GiphyPostsRequest(query=" + this.query + ", limit=" + this.limit + ", offset=" + this.offset + ")";
    }

    public GiphyPostsRequest(String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(str, SearchIntents.EXTRA_QUERY);
        Intrinsics.checkNotNullParameter(str2, "offset");
        this.query = str;
        this.limit = i;
        this.offset = str2;
    }

    public final String getQuery() {
        return this.query;
    }

    public final int getLimit() {
        return this.limit;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GiphyPostsRequest(String str, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 24 : i, (i2 & 4) != 0 ? "0" : str2);
    }

    public final String getOffset() {
        return this.offset;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Lcom/memes/network/giphy/api/model/GiphyPostsRequest$Companion;", "", "()V", "QUERY_TRENDING", "", "ofTrending", "Lcom/memes/network/giphy/api/model/GiphyPostsRequest;", "limit", "", "offset", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: GiphyPostsRequest.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ GiphyPostsRequest ofTrending$default(Companion companion, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = 24;
            }
            if ((i2 & 2) != 0) {
                str = "0";
            }
            return companion.ofTrending(i, str);
        }

        public final GiphyPostsRequest ofTrending(int i, String str) {
            Intrinsics.checkNotNullParameter(str, "offset");
            return new GiphyPostsRequest(GiphyPostsRequest.QUERY_TRENDING, i, str);
        }
    }
}
