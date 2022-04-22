package com.memes.network.reddit.source.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, mo26107d2 = {"Lcom/memes/network/reddit/source/remote/model/RedditVariant;", "", "gif", "Lcom/memes/network/reddit/source/remote/model/RedditPreviewContent;", "video", "(Lcom/memes/network/reddit/source/remote/model/RedditPreviewContent;Lcom/memes/network/reddit/source/remote/model/RedditPreviewContent;)V", "getGif", "()Lcom/memes/network/reddit/source/remote/model/RedditPreviewContent;", "getVideo", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: RedditVariant.kt */
public final class RedditVariant {
    @SerializedName("gif")
    @Expose
    private final RedditPreviewContent gif;
    @SerializedName("mp4")
    @Expose
    private final RedditPreviewContent video;

    public RedditVariant() {
        this((RedditPreviewContent) null, (RedditPreviewContent) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RedditVariant copy$default(RedditVariant redditVariant, RedditPreviewContent redditPreviewContent, RedditPreviewContent redditPreviewContent2, int i, Object obj) {
        if ((i & 1) != 0) {
            redditPreviewContent = redditVariant.gif;
        }
        if ((i & 2) != 0) {
            redditPreviewContent2 = redditVariant.video;
        }
        return redditVariant.copy(redditPreviewContent, redditPreviewContent2);
    }

    public final RedditPreviewContent component1() {
        return this.gif;
    }

    public final RedditPreviewContent component2() {
        return this.video;
    }

    public final RedditVariant copy(RedditPreviewContent redditPreviewContent, RedditPreviewContent redditPreviewContent2) {
        return new RedditVariant(redditPreviewContent, redditPreviewContent2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedditVariant)) {
            return false;
        }
        RedditVariant redditVariant = (RedditVariant) obj;
        return Intrinsics.areEqual((Object) this.gif, (Object) redditVariant.gif) && Intrinsics.areEqual((Object) this.video, (Object) redditVariant.video);
    }

    public int hashCode() {
        RedditPreviewContent redditPreviewContent = this.gif;
        int i = 0;
        int hashCode = (redditPreviewContent != null ? redditPreviewContent.hashCode() : 0) * 31;
        RedditPreviewContent redditPreviewContent2 = this.video;
        if (redditPreviewContent2 != null) {
            i = redditPreviewContent2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "RedditVariant(gif=" + this.gif + ", video=" + this.video + ")";
    }

    public RedditVariant(RedditPreviewContent redditPreviewContent, RedditPreviewContent redditPreviewContent2) {
        this.gif = redditPreviewContent;
        this.video = redditPreviewContent2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RedditVariant(RedditPreviewContent redditPreviewContent, RedditPreviewContent redditPreviewContent2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : redditPreviewContent, (i & 2) != 0 ? null : redditPreviewContent2);
    }

    public final RedditPreviewContent getGif() {
        return this.gif;
    }

    public final RedditPreviewContent getVideo() {
        return this.video;
    }
}
