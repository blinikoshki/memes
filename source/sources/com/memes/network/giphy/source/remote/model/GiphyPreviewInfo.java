package com.memes.network.giphy.source.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000f\u0010\n¨\u0006\u001b"}, mo26107d2 = {"Lcom/memes/network/giphy/source/remote/model/GiphyPreviewInfo;", "", "url", "", "size", "width", "", "height", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSize", "()Ljava/lang/String;", "getUrl", "getWidth", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/memes/network/giphy/source/remote/model/GiphyPreviewInfo;", "equals", "", "other", "hashCode", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GiphyPreviewInfo.kt */
public final class GiphyPreviewInfo {
    @SerializedName("height")
    @Expose
    private final Integer height;
    @SerializedName("size")
    @Expose
    private final String size;
    @SerializedName("url")
    @Expose
    private final String url;
    @SerializedName("width")
    @Expose
    private final Integer width;

    public GiphyPreviewInfo() {
        this((String) null, (String) null, (Integer) null, (Integer) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GiphyPreviewInfo copy$default(GiphyPreviewInfo giphyPreviewInfo, String str, String str2, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = giphyPreviewInfo.url;
        }
        if ((i & 2) != 0) {
            str2 = giphyPreviewInfo.size;
        }
        if ((i & 4) != 0) {
            num = giphyPreviewInfo.width;
        }
        if ((i & 8) != 0) {
            num2 = giphyPreviewInfo.height;
        }
        return giphyPreviewInfo.copy(str, str2, num, num2);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.size;
    }

    public final Integer component3() {
        return this.width;
    }

    public final Integer component4() {
        return this.height;
    }

    public final GiphyPreviewInfo copy(String str, String str2, Integer num, Integer num2) {
        return new GiphyPreviewInfo(str, str2, num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GiphyPreviewInfo)) {
            return false;
        }
        GiphyPreviewInfo giphyPreviewInfo = (GiphyPreviewInfo) obj;
        return Intrinsics.areEqual((Object) this.url, (Object) giphyPreviewInfo.url) && Intrinsics.areEqual((Object) this.size, (Object) giphyPreviewInfo.size) && Intrinsics.areEqual((Object) this.width, (Object) giphyPreviewInfo.width) && Intrinsics.areEqual((Object) this.height, (Object) giphyPreviewInfo.height);
    }

    public int hashCode() {
        String str = this.url;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.size;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.width;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.height;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "GiphyPreviewInfo(url=" + this.url + ", size=" + this.size + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public GiphyPreviewInfo(String str, String str2, Integer num, Integer num2) {
        this.url = str;
        this.size = str2;
        this.width = num;
        this.height = num2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GiphyPreviewInfo(String str, String str2, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2);
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getSize() {
        return this.size;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final Integer getHeight() {
        return this.height;
    }
}
