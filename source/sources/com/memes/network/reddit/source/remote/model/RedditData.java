package com.memes.network.reddit.source.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\bJ\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0007\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, mo26107d2 = {"Lcom/memes/network/reddit/source/remote/model/RedditData;", "", "children", "", "Lcom/memes/network/reddit/source/remote/model/RedditChild;", "after", "", "before", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Object;)V", "getAfter", "()Ljava/lang/String;", "setAfter", "(Ljava/lang/String;)V", "getBefore", "()Ljava/lang/Object;", "setBefore", "(Ljava/lang/Object;)V", "getChildren", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: RedditData.kt */
public final class RedditData {
    @SerializedName("after")
    @Expose
    private String after;
    @SerializedName("before")
    @Expose
    private Object before;
    @SerializedName("children")
    @Expose
    private final List<RedditChild> children;

    public RedditData() {
        this((List) null, (String) null, (Object) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RedditData copy$default(RedditData redditData, List<RedditChild> list, String str, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            list = redditData.children;
        }
        if ((i & 2) != 0) {
            str = redditData.after;
        }
        if ((i & 4) != 0) {
            obj = redditData.before;
        }
        return redditData.copy(list, str, obj);
    }

    public final List<RedditChild> component1() {
        return this.children;
    }

    public final String component2() {
        return this.after;
    }

    public final Object component3() {
        return this.before;
    }

    public final RedditData copy(List<RedditChild> list, String str, Object obj) {
        return new RedditData(list, str, obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedditData)) {
            return false;
        }
        RedditData redditData = (RedditData) obj;
        return Intrinsics.areEqual((Object) this.children, (Object) redditData.children) && Intrinsics.areEqual((Object) this.after, (Object) redditData.after) && Intrinsics.areEqual(this.before, redditData.before);
    }

    public int hashCode() {
        List<RedditChild> list = this.children;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.after;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Object obj = this.before;
        if (obj != null) {
            i = obj.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "RedditData(children=" + this.children + ", after=" + this.after + ", before=" + this.before + ")";
    }

    public RedditData(List<RedditChild> list, String str, Object obj) {
        this.children = list;
        this.after = str;
        this.before = obj;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RedditData(List list, String str, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : obj);
    }

    public final List<RedditChild> getChildren() {
        return this.children;
    }

    public final String getAfter() {
        return this.after;
    }

    public final void setAfter(String str) {
        this.after = str;
    }

    public final Object getBefore() {
        return this.before;
    }

    public final void setBefore(Object obj) {
        this.before = obj;
    }
}
