package com.memes.network.reddit.api.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u001bB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0017\u001a\u00020\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001c"}, mo26107d2 = {"Lcom/memes/network/reddit/api/model/RedditPost;", "", "id", "", "imageMedia", "Lcom/memes/network/reddit/api/model/RedditPost$Media;", "gifMedia", "videoMedia", "(Ljava/lang/String;Lcom/memes/network/reddit/api/model/RedditPost$Media;Lcom/memes/network/reddit/api/model/RedditPost$Media;Lcom/memes/network/reddit/api/model/RedditPost$Media;)V", "getGifMedia", "()Lcom/memes/network/reddit/api/model/RedditPost$Media;", "getId", "()Ljava/lang/String;", "getImageMedia", "getVideoMedia", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "getIdentifier", "hashCode", "", "toString", "Media", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: RedditPost.kt */
public final class RedditPost {
    private final Media gifMedia;

    /* renamed from: id */
    private final String f995id;
    private final Media imageMedia;
    private final Media videoMedia;

    public static /* synthetic */ RedditPost copy$default(RedditPost redditPost, String str, Media media, Media media2, Media media3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = redditPost.f995id;
        }
        if ((i & 2) != 0) {
            media = redditPost.imageMedia;
        }
        if ((i & 4) != 0) {
            media2 = redditPost.gifMedia;
        }
        if ((i & 8) != 0) {
            media3 = redditPost.videoMedia;
        }
        return redditPost.copy(str, media, media2, media3);
    }

    public final String component1() {
        return this.f995id;
    }

    public final Media component2() {
        return this.imageMedia;
    }

    public final Media component3() {
        return this.gifMedia;
    }

    public final Media component4() {
        return this.videoMedia;
    }

    public final RedditPost copy(String str, Media media, Media media2, Media media3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(media, "imageMedia");
        return new RedditPost(str, media, media2, media3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedditPost)) {
            return false;
        }
        RedditPost redditPost = (RedditPost) obj;
        return Intrinsics.areEqual((Object) this.f995id, (Object) redditPost.f995id) && Intrinsics.areEqual((Object) this.imageMedia, (Object) redditPost.imageMedia) && Intrinsics.areEqual((Object) this.gifMedia, (Object) redditPost.gifMedia) && Intrinsics.areEqual((Object) this.videoMedia, (Object) redditPost.videoMedia);
    }

    public int hashCode() {
        String str = this.f995id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Media media = this.imageMedia;
        int hashCode2 = (hashCode + (media != null ? media.hashCode() : 0)) * 31;
        Media media2 = this.gifMedia;
        int hashCode3 = (hashCode2 + (media2 != null ? media2.hashCode() : 0)) * 31;
        Media media3 = this.videoMedia;
        if (media3 != null) {
            i = media3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "RedditPost(id=" + this.f995id + ", imageMedia=" + this.imageMedia + ", gifMedia=" + this.gifMedia + ", videoMedia=" + this.videoMedia + ")";
    }

    public RedditPost(String str, Media media, Media media2, Media media3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(media, "imageMedia");
        this.f995id = str;
        this.imageMedia = media;
        this.gifMedia = media2;
        this.videoMedia = media3;
    }

    public final String getId() {
        return this.f995id;
    }

    public final Media getImageMedia() {
        return this.imageMedia;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RedditPost(String str, Media media, Media media2, Media media3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, media, (i & 4) != 0 ? null : media2, (i & 8) != 0 ? null : media3);
    }

    public final Media getGifMedia() {
        return this.gifMedia;
    }

    public final Media getVideoMedia() {
        return this.videoMedia;
    }

    public final String getIdentifier() {
        return this.f995id;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\r\u001a\u00020\u000eJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, mo26107d2 = {"Lcom/memes/network/reddit/api/model/RedditPost$Media;", "", "thumbnail", "", "width", "", "height", "(Ljava/lang/String;II)V", "getHeight", "()I", "getThumbnail", "()Ljava/lang/String;", "getWidth", "aspectRatio", "", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: RedditPost.kt */
    public static final class Media {
        private final int height;
        private final String thumbnail;
        private final int width;

        public static /* synthetic */ Media copy$default(Media media, String str, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = media.thumbnail;
            }
            if ((i3 & 2) != 0) {
                i = media.width;
            }
            if ((i3 & 4) != 0) {
                i2 = media.height;
            }
            return media.copy(str, i, i2);
        }

        public final String component1() {
            return this.thumbnail;
        }

        public final int component2() {
            return this.width;
        }

        public final int component3() {
            return this.height;
        }

        public final Media copy(String str, int i, int i2) {
            Intrinsics.checkNotNullParameter(str, "thumbnail");
            return new Media(str, i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Media)) {
                return false;
            }
            Media media = (Media) obj;
            return Intrinsics.areEqual((Object) this.thumbnail, (Object) media.thumbnail) && this.width == media.width && this.height == media.height;
        }

        public int hashCode() {
            String str = this.thumbnail;
            return ((((str != null ? str.hashCode() : 0) * 31) + this.width) * 31) + this.height;
        }

        public String toString() {
            return "Media(thumbnail=" + this.thumbnail + ", width=" + this.width + ", height=" + this.height + ")";
        }

        public Media(String str, int i, int i2) {
            Intrinsics.checkNotNullParameter(str, "thumbnail");
            this.thumbnail = str;
            this.width = i;
            this.height = i2;
        }

        public final String getThumbnail() {
            return this.thumbnail;
        }

        public final int getWidth() {
            return this.width;
        }

        public final int getHeight() {
            return this.height;
        }

        public final float aspectRatio() {
            int i = this.height;
            if (i != 0) {
                return ((float) this.width) / ((float) i);
            }
            return 1.0f;
        }
    }
}
