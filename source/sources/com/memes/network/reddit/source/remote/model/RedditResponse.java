package com.memes.network.reddit.source.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.memes.network.reddit.api.model.RedditPost;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0014\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fJ\u0014\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\fH\u0002J\t\u0010 \u001a\u00020\u0016HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006!"}, mo26107d2 = {"Lcom/memes/network/reddit/source/remote/model/RedditResponse;", "", "data", "Lcom/memes/network/reddit/source/remote/model/RedditData;", "(Lcom/memes/network/reddit/source/remote/model/RedditData;)V", "getData", "()Lcom/memes/network/reddit/source/remote/model/RedditData;", "component1", "copy", "createGifMedia", "Lcom/memes/network/reddit/api/model/RedditPost$Media;", "previewContent", "Lcom/memes/network/reddit/source/remote/model/RedditPreviewContent;", "createImageMedia", "createRedditPosts", "", "Lcom/memes/network/reddit/api/model/RedditPost;", "createVideoMedia", "equals", "", "other", "fixUrl", "", "url", "getNextPaginationTarget", "hashCode", "", "redditPreviewContentInfoToRedditMedia", "contentInfo", "Lcom/memes/network/reddit/source/remote/model/RedditPreviewContentInfo;", "redditPreviewContentToRedditMedia", "content", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: RedditResponse.kt */
public final class RedditResponse {
    @SerializedName("data")
    @Expose
    private final RedditData data;

    public RedditResponse() {
        this((RedditData) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RedditResponse copy$default(RedditResponse redditResponse, RedditData redditData, int i, Object obj) {
        if ((i & 1) != 0) {
            redditData = redditResponse.data;
        }
        return redditResponse.copy(redditData);
    }

    public final RedditData component1() {
        return this.data;
    }

    public final RedditResponse copy(RedditData redditData) {
        return new RedditResponse(redditData);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RedditResponse) && Intrinsics.areEqual((Object) this.data, (Object) ((RedditResponse) obj).data);
        }
        return true;
    }

    public int hashCode() {
        RedditData redditData = this.data;
        if (redditData != null) {
            return redditData.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "RedditResponse(data=" + this.data + ")";
    }

    public RedditResponse(RedditData redditData) {
        this.data = redditData;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RedditResponse(RedditData redditData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : redditData);
    }

    public final RedditData getData() {
        return this.data;
    }

    public final List<RedditPost> createRedditPosts() {
        RedditPreviewContent redditPreviewContent;
        RedditPost.Media createImageMedia;
        RedditData redditData = this.data;
        List<RedditChild> children = redditData != null ? redditData.getChildren() : null;
        Collection collection = children;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        List<RedditPost> arrayList = new ArrayList<>();
        for (RedditChild data2 : children) {
            RedditChildData data3 = data2.getData();
            if (data3 != null && !data3.getOver18()) {
                RedditPreview preview = data3.getPreview();
                List<RedditPreviewContent> images = preview != null ? preview.getImages() : null;
                Collection collection2 = images;
                if (!(collection2 == null || collection2.isEmpty()) && (createImageMedia = createImageMedia(redditPreviewContent)) != null) {
                    arrayList.add(new RedditPost(data3.getId(), createImageMedia, createGifMedia((redditPreviewContent = (RedditPreviewContent) CollectionsKt.first(images))), createVideoMedia(redditPreviewContent)));
                }
            }
        }
        return arrayList;
    }

    public final String getNextPaginationTarget() {
        RedditData redditData = this.data;
        if (redditData != null) {
            return redditData.getAfter();
        }
        return null;
    }

    private final RedditPost.Media createImageMedia(RedditPreviewContent redditPreviewContent) {
        if (redditPreviewContent == null) {
            return null;
        }
        return redditPreviewContentToRedditMedia(redditPreviewContent);
    }

    private final RedditPost.Media createGifMedia(RedditPreviewContent redditPreviewContent) {
        RedditVariant variant;
        if (redditPreviewContent == null || (variant = redditPreviewContent.getVariant()) == null) {
            return null;
        }
        return redditPreviewContentToRedditMedia(variant.getGif());
    }

    private final RedditPost.Media createVideoMedia(RedditPreviewContent redditPreviewContent) {
        RedditVariant variant;
        if (redditPreviewContent == null || (variant = redditPreviewContent.getVariant()) == null) {
            return null;
        }
        return redditPreviewContentToRedditMedia(variant.getVideo());
    }

    private final RedditPost.Media redditPreviewContentToRedditMedia(RedditPreviewContent redditPreviewContent) {
        if (redditPreviewContent == null) {
            return null;
        }
        RedditPost.Media redditPreviewContentInfoToRedditMedia = redditPreviewContentInfoToRedditMedia(redditPreviewContent.getSource());
        if (redditPreviewContentInfoToRedditMedia != null) {
            return redditPreviewContentInfoToRedditMedia;
        }
        List<RedditPreviewContentInfo> resolutions = redditPreviewContent.getResolutions();
        if (resolutions == null || !(!resolutions.isEmpty())) {
            return null;
        }
        return redditPreviewContentInfoToRedditMedia((RedditPreviewContentInfo) CollectionsKt.last(resolutions));
    }

    private final RedditPost.Media redditPreviewContentInfoToRedditMedia(RedditPreviewContentInfo redditPreviewContentInfo) {
        if (redditPreviewContentInfo == null) {
            return null;
        }
        CharSequence url = redditPreviewContentInfo.getUrl();
        if ((url == null || StringsKt.isBlank(url)) || Intrinsics.areEqual((Object) redditPreviewContentInfo.getUrl(), (Object) "self") || redditPreviewContentInfo.getWidth() == null || redditPreviewContentInfo.getHeight() == null) {
            return null;
        }
        return new RedditPost.Media(fixUrl(redditPreviewContentInfo.getUrl()), redditPreviewContentInfo.getWidth().intValue(), redditPreviewContentInfo.getHeight().intValue());
    }

    private final String fixUrl(String str) {
        return StringsKt.replace$default(str, "amp;", "", false, 4, (Object) null);
    }
}
