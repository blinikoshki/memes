package com.memes.network.reddit.source.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\b\b\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jt\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0007HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0012R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001a¨\u0006,"}, mo26107d2 = {"Lcom/memes/network/reddit/source/remote/model/RedditChildData;", "", "id", "", "subreddit", "thumbnail", "thumbnailWidth", "", "thumbnailHeight", "over18", "", "isVideo", "preview", "Lcom/memes/network/reddit/source/remote/model/RedditPreview;", "permalink", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ZZLcom/memes/network/reddit/source/remote/model/RedditPreview;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "()Z", "getOver18", "getPermalink", "getPreview", "()Lcom/memes/network/reddit/source/remote/model/RedditPreview;", "getSubreddit", "getThumbnail", "getThumbnailHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getThumbnailWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ZZLcom/memes/network/reddit/source/remote/model/RedditPreview;Ljava/lang/String;)Lcom/memes/network/reddit/source/remote/model/RedditChildData;", "equals", "other", "hashCode", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: RedditChildData.kt */
public final class RedditChildData {
    @SerializedName("id")
    @Expose

    /* renamed from: id */
    private final String f996id;
    @SerializedName("is_video")
    @Expose
    private final boolean isVideo;
    @SerializedName("over_18")
    @Expose
    private final boolean over18;
    @SerializedName("permalink")
    @Expose
    private final String permalink;
    @SerializedName("preview")
    @Expose
    private final RedditPreview preview;
    @SerializedName("subreddit")
    @Expose
    private final String subreddit;
    @SerializedName("thumbnail")
    @Expose
    private final String thumbnail;
    @SerializedName("thumbnail_height")
    @Expose
    private final Integer thumbnailHeight;
    @SerializedName("thumbnail_width")
    @Expose
    private final Integer thumbnailWidth;

    public static /* synthetic */ RedditChildData copy$default(RedditChildData redditChildData, String str, String str2, String str3, Integer num, Integer num2, boolean z, boolean z2, RedditPreview redditPreview, String str4, int i, Object obj) {
        RedditChildData redditChildData2 = redditChildData;
        int i2 = i;
        return redditChildData.copy((i2 & 1) != 0 ? redditChildData2.f996id : str, (i2 & 2) != 0 ? redditChildData2.subreddit : str2, (i2 & 4) != 0 ? redditChildData2.thumbnail : str3, (i2 & 8) != 0 ? redditChildData2.thumbnailWidth : num, (i2 & 16) != 0 ? redditChildData2.thumbnailHeight : num2, (i2 & 32) != 0 ? redditChildData2.over18 : z, (i2 & 64) != 0 ? redditChildData2.isVideo : z2, (i2 & 128) != 0 ? redditChildData2.preview : redditPreview, (i2 & 256) != 0 ? redditChildData2.permalink : str4);
    }

    public final String component1() {
        return this.f996id;
    }

    public final String component2() {
        return this.subreddit;
    }

    public final String component3() {
        return this.thumbnail;
    }

    public final Integer component4() {
        return this.thumbnailWidth;
    }

    public final Integer component5() {
        return this.thumbnailHeight;
    }

    public final boolean component6() {
        return this.over18;
    }

    public final boolean component7() {
        return this.isVideo;
    }

    public final RedditPreview component8() {
        return this.preview;
    }

    public final String component9() {
        return this.permalink;
    }

    public final RedditChildData copy(String str, String str2, String str3, Integer num, Integer num2, boolean z, boolean z2, RedditPreview redditPreview, String str4) {
        Intrinsics.checkNotNullParameter(str, "id");
        return new RedditChildData(str, str2, str3, num, num2, z, z2, redditPreview, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedditChildData)) {
            return false;
        }
        RedditChildData redditChildData = (RedditChildData) obj;
        return Intrinsics.areEqual((Object) this.f996id, (Object) redditChildData.f996id) && Intrinsics.areEqual((Object) this.subreddit, (Object) redditChildData.subreddit) && Intrinsics.areEqual((Object) this.thumbnail, (Object) redditChildData.thumbnail) && Intrinsics.areEqual((Object) this.thumbnailWidth, (Object) redditChildData.thumbnailWidth) && Intrinsics.areEqual((Object) this.thumbnailHeight, (Object) redditChildData.thumbnailHeight) && this.over18 == redditChildData.over18 && this.isVideo == redditChildData.isVideo && Intrinsics.areEqual((Object) this.preview, (Object) redditChildData.preview) && Intrinsics.areEqual((Object) this.permalink, (Object) redditChildData.permalink);
    }

    public int hashCode() {
        String str = this.f996id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.subreddit;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.thumbnail;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num = this.thumbnailWidth;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.thumbnailHeight;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 31;
        boolean z = this.over18;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (hashCode5 + (z ? 1 : 0)) * 31;
        boolean z3 = this.isVideo;
        if (!z3) {
            z2 = z3;
        }
        int i3 = (i2 + (z2 ? 1 : 0)) * 31;
        RedditPreview redditPreview = this.preview;
        int hashCode6 = (i3 + (redditPreview != null ? redditPreview.hashCode() : 0)) * 31;
        String str4 = this.permalink;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "RedditChildData(id=" + this.f996id + ", subreddit=" + this.subreddit + ", thumbnail=" + this.thumbnail + ", thumbnailWidth=" + this.thumbnailWidth + ", thumbnailHeight=" + this.thumbnailHeight + ", over18=" + this.over18 + ", isVideo=" + this.isVideo + ", preview=" + this.preview + ", permalink=" + this.permalink + ")";
    }

    public RedditChildData(String str, String str2, String str3, Integer num, Integer num2, boolean z, boolean z2, RedditPreview redditPreview, String str4) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.f996id = str;
        this.subreddit = str2;
        this.thumbnail = str3;
        this.thumbnailWidth = num;
        this.thumbnailHeight = num2;
        this.over18 = z;
        this.isVideo = z2;
        this.preview = redditPreview;
        this.permalink = str4;
    }

    public final String getId() {
        return this.f996id;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RedditChildData(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.Integer r13, java.lang.Integer r14, boolean r15, boolean r16, com.memes.network.reddit.source.remote.model.RedditPreview r17, java.lang.String r18, int r19, kotlin.jvm.internal.DefaultConstructorMarker r20) {
        /*
            r9 = this;
            r0 = r19
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x000b
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x000c
        L_0x000b:
            r1 = r11
        L_0x000c:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0014
            r3 = r2
            java.lang.String r3 = (java.lang.String) r3
            goto L_0x0015
        L_0x0014:
            r3 = r12
        L_0x0015:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x001d
            r4 = r2
            java.lang.Integer r4 = (java.lang.Integer) r4
            goto L_0x001e
        L_0x001d:
            r4 = r13
        L_0x001e:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0026
            r5 = r2
            java.lang.Integer r5 = (java.lang.Integer) r5
            goto L_0x0027
        L_0x0026:
            r5 = r14
        L_0x0027:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x002d
            r6 = 1
            goto L_0x002e
        L_0x002d:
            r6 = r15
        L_0x002e:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x0034
            r7 = 0
            goto L_0x0036
        L_0x0034:
            r7 = r16
        L_0x0036:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x003e
            r8 = r2
            com.memes.network.reddit.source.remote.model.RedditPreview r8 = (com.memes.network.reddit.source.remote.model.RedditPreview) r8
            goto L_0x0040
        L_0x003e:
            r8 = r17
        L_0x0040:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0048
            r0 = r2
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x004a
        L_0x0048:
            r0 = r18
        L_0x004a:
            r11 = r9
            r12 = r10
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r0
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.network.reddit.source.remote.model.RedditChildData.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, boolean, boolean, com.memes.network.reddit.source.remote.model.RedditPreview, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getSubreddit() {
        return this.subreddit;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final Integer getThumbnailWidth() {
        return this.thumbnailWidth;
    }

    public final Integer getThumbnailHeight() {
        return this.thumbnailHeight;
    }

    public final boolean getOver18() {
        return this.over18;
    }

    public final boolean isVideo() {
        return this.isVideo;
    }

    public final RedditPreview getPreview() {
        return this.preview;
    }

    public final String getPermalink() {
        return this.permalink;
    }
}
