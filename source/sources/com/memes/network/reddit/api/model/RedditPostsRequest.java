package com.memes.network.reddit.api.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, mo26107d2 = {"Lcom/memes/network/reddit/api/model/RedditPostsRequest;", "", "subreddit", "", "query", "limit", "", "offset", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getLimit", "()I", "getOffset", "()Ljava/lang/String;", "getQuery", "getSubreddit", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: RedditPostsRequest.kt */
public final class RedditPostsRequest {
    private final int limit;
    private final String offset;
    private final String query;
    private final String subreddit;

    public static /* synthetic */ RedditPostsRequest copy$default(RedditPostsRequest redditPostsRequest, String str, String str2, int i, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = redditPostsRequest.subreddit;
        }
        if ((i2 & 2) != 0) {
            str2 = redditPostsRequest.query;
        }
        if ((i2 & 4) != 0) {
            i = redditPostsRequest.limit;
        }
        if ((i2 & 8) != 0) {
            str3 = redditPostsRequest.offset;
        }
        return redditPostsRequest.copy(str, str2, i, str3);
    }

    public final String component1() {
        return this.subreddit;
    }

    public final String component2() {
        return this.query;
    }

    public final int component3() {
        return this.limit;
    }

    public final String component4() {
        return this.offset;
    }

    public final RedditPostsRequest copy(String str, String str2, int i, String str3) {
        Intrinsics.checkNotNullParameter(str, "subreddit");
        return new RedditPostsRequest(str, str2, i, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedditPostsRequest)) {
            return false;
        }
        RedditPostsRequest redditPostsRequest = (RedditPostsRequest) obj;
        return Intrinsics.areEqual((Object) this.subreddit, (Object) redditPostsRequest.subreddit) && Intrinsics.areEqual((Object) this.query, (Object) redditPostsRequest.query) && this.limit == redditPostsRequest.limit && Intrinsics.areEqual((Object) this.offset, (Object) redditPostsRequest.offset);
    }

    public int hashCode() {
        String str = this.subreddit;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.query;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.limit) * 31;
        String str3 = this.offset;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "RedditPostsRequest(subreddit=" + this.subreddit + ", query=" + this.query + ", limit=" + this.limit + ", offset=" + this.offset + ")";
    }

    public RedditPostsRequest(String str, String str2, int i, String str3) {
        Intrinsics.checkNotNullParameter(str, "subreddit");
        this.subreddit = str;
        this.query = str2;
        this.limit = i;
        this.offset = str3;
    }

    public final String getSubreddit() {
        return this.subreddit;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RedditPostsRequest(String str, String str2, int i, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? 20 : i, (i2 & 8) != 0 ? null : str3);
    }

    public final String getQuery() {
        return this.query;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final String getOffset() {
        return this.offset;
    }
}
