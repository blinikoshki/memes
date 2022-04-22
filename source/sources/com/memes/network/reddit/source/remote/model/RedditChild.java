package com.memes.network.reddit.source.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Lcom/memes/network/reddit/source/remote/model/RedditChild;", "", "data", "Lcom/memes/network/reddit/source/remote/model/RedditChildData;", "(Lcom/memes/network/reddit/source/remote/model/RedditChildData;)V", "getData", "()Lcom/memes/network/reddit/source/remote/model/RedditChildData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: RedditChild.kt */
public final class RedditChild {
    @SerializedName("data")
    @Expose
    private final RedditChildData data;

    public RedditChild() {
        this((RedditChildData) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RedditChild copy$default(RedditChild redditChild, RedditChildData redditChildData, int i, Object obj) {
        if ((i & 1) != 0) {
            redditChildData = redditChild.data;
        }
        return redditChild.copy(redditChildData);
    }

    public final RedditChildData component1() {
        return this.data;
    }

    public final RedditChild copy(RedditChildData redditChildData) {
        return new RedditChild(redditChildData);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RedditChild) && Intrinsics.areEqual((Object) this.data, (Object) ((RedditChild) obj).data);
        }
        return true;
    }

    public int hashCode() {
        RedditChildData redditChildData = this.data;
        if (redditChildData != null) {
            return redditChildData.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "RedditChild(data=" + this.data + ")";
    }

    public RedditChild(RedditChildData redditChildData) {
        this.data = redditChildData;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RedditChild(RedditChildData redditChildData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : redditChildData);
    }

    public final RedditChildData getData() {
        return this.data;
    }
}
