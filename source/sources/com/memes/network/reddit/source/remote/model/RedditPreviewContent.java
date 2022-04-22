package com.memes.network.reddit.source.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, mo26107d2 = {"Lcom/memes/network/reddit/source/remote/model/RedditPreviewContent;", "", "source", "Lcom/memes/network/reddit/source/remote/model/RedditPreviewContentInfo;", "resolutions", "", "variant", "Lcom/memes/network/reddit/source/remote/model/RedditVariant;", "(Lcom/memes/network/reddit/source/remote/model/RedditPreviewContentInfo;Ljava/util/List;Lcom/memes/network/reddit/source/remote/model/RedditVariant;)V", "getResolutions", "()Ljava/util/List;", "getSource", "()Lcom/memes/network/reddit/source/remote/model/RedditPreviewContentInfo;", "getVariant", "()Lcom/memes/network/reddit/source/remote/model/RedditVariant;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: RedditPreviewContent.kt */
public final class RedditPreviewContent {
    @SerializedName("resolutions")
    @Expose
    private final List<RedditPreviewContentInfo> resolutions;
    @SerializedName("source")
    @Expose
    private final RedditPreviewContentInfo source;
    @SerializedName("variants")
    @Expose
    private final RedditVariant variant;

    public RedditPreviewContent() {
        this((RedditPreviewContentInfo) null, (List) null, (RedditVariant) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RedditPreviewContent copy$default(RedditPreviewContent redditPreviewContent, RedditPreviewContentInfo redditPreviewContentInfo, List<RedditPreviewContentInfo> list, RedditVariant redditVariant, int i, Object obj) {
        if ((i & 1) != 0) {
            redditPreviewContentInfo = redditPreviewContent.source;
        }
        if ((i & 2) != 0) {
            list = redditPreviewContent.resolutions;
        }
        if ((i & 4) != 0) {
            redditVariant = redditPreviewContent.variant;
        }
        return redditPreviewContent.copy(redditPreviewContentInfo, list, redditVariant);
    }

    public final RedditPreviewContentInfo component1() {
        return this.source;
    }

    public final List<RedditPreviewContentInfo> component2() {
        return this.resolutions;
    }

    public final RedditVariant component3() {
        return this.variant;
    }

    public final RedditPreviewContent copy(RedditPreviewContentInfo redditPreviewContentInfo, List<RedditPreviewContentInfo> list, RedditVariant redditVariant) {
        return new RedditPreviewContent(redditPreviewContentInfo, list, redditVariant);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedditPreviewContent)) {
            return false;
        }
        RedditPreviewContent redditPreviewContent = (RedditPreviewContent) obj;
        return Intrinsics.areEqual((Object) this.source, (Object) redditPreviewContent.source) && Intrinsics.areEqual((Object) this.resolutions, (Object) redditPreviewContent.resolutions) && Intrinsics.areEqual((Object) this.variant, (Object) redditPreviewContent.variant);
    }

    public int hashCode() {
        RedditPreviewContentInfo redditPreviewContentInfo = this.source;
        int i = 0;
        int hashCode = (redditPreviewContentInfo != null ? redditPreviewContentInfo.hashCode() : 0) * 31;
        List<RedditPreviewContentInfo> list = this.resolutions;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        RedditVariant redditVariant = this.variant;
        if (redditVariant != null) {
            i = redditVariant.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "RedditPreviewContent(source=" + this.source + ", resolutions=" + this.resolutions + ", variant=" + this.variant + ")";
    }

    public RedditPreviewContent(RedditPreviewContentInfo redditPreviewContentInfo, List<RedditPreviewContentInfo> list, RedditVariant redditVariant) {
        this.source = redditPreviewContentInfo;
        this.resolutions = list;
        this.variant = redditVariant;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RedditPreviewContent(RedditPreviewContentInfo redditPreviewContentInfo, List list, RedditVariant redditVariant, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : redditPreviewContentInfo, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : redditVariant);
    }

    public final RedditPreviewContentInfo getSource() {
        return this.source;
    }

    public final List<RedditPreviewContentInfo> getResolutions() {
        return this.resolutions;
    }

    public final RedditVariant getVariant() {
        return this.variant;
    }
}
