package com.memes.network.reddit.source.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/network/reddit/source/remote/model/RedditPreview;", "", "images", "", "Lcom/memes/network/reddit/source/remote/model/RedditPreviewContent;", "(Ljava/util/List;)V", "getImages", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: RedditPreview.kt */
public final class RedditPreview {
    @SerializedName("images")
    @Expose
    private final List<RedditPreviewContent> images;

    public RedditPreview() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RedditPreview copy$default(RedditPreview redditPreview, List<RedditPreviewContent> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = redditPreview.images;
        }
        return redditPreview.copy(list);
    }

    public final List<RedditPreviewContent> component1() {
        return this.images;
    }

    public final RedditPreview copy(List<RedditPreviewContent> list) {
        return new RedditPreview(list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RedditPreview) && Intrinsics.areEqual((Object) this.images, (Object) ((RedditPreview) obj).images);
        }
        return true;
    }

    public int hashCode() {
        List<RedditPreviewContent> list = this.images;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "RedditPreview(images=" + this.images + ")";
    }

    public RedditPreview(List<RedditPreviewContent> list) {
        this.images = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RedditPreview(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    public final List<RedditPreviewContent> getImages() {
        return this.images;
    }
}
