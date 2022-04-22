package com.memes.network.giphy.api.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u001c\u001a\u00020\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001f"}, mo26107d2 = {"Lcom/memes/network/giphy/api/model/GiphyGif;", "", "id", "", "gifUrl", "mp4Url", "width", "", "height", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getGifUrl", "()Ljava/lang/String;", "getHeight", "()I", "getId", "getMp4Url", "getWidth", "aspectRatio", "", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "getIdentifier", "hashCode", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GiphyGif.kt */
public final class GiphyGif {
    private final String gifUrl;
    private final int height;

    /* renamed from: id */
    private final String f988id;
    private final String mp4Url;
    private final int width;

    public static /* synthetic */ GiphyGif copy$default(GiphyGif giphyGif, String str, String str2, String str3, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = giphyGif.f988id;
        }
        if ((i3 & 2) != 0) {
            str2 = giphyGif.gifUrl;
        }
        String str4 = str2;
        if ((i3 & 4) != 0) {
            str3 = giphyGif.mp4Url;
        }
        String str5 = str3;
        if ((i3 & 8) != 0) {
            i = giphyGif.width;
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            i2 = giphyGif.height;
        }
        return giphyGif.copy(str, str4, str5, i4, i2);
    }

    public final String component1() {
        return this.f988id;
    }

    public final String component2() {
        return this.gifUrl;
    }

    public final String component3() {
        return this.mp4Url;
    }

    public final int component4() {
        return this.width;
    }

    public final int component5() {
        return this.height;
    }

    public final GiphyGif copy(String str, String str2, String str3, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "gifUrl");
        Intrinsics.checkNotNullParameter(str3, "mp4Url");
        return new GiphyGif(str, str2, str3, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GiphyGif)) {
            return false;
        }
        GiphyGif giphyGif = (GiphyGif) obj;
        return Intrinsics.areEqual((Object) this.f988id, (Object) giphyGif.f988id) && Intrinsics.areEqual((Object) this.gifUrl, (Object) giphyGif.gifUrl) && Intrinsics.areEqual((Object) this.mp4Url, (Object) giphyGif.mp4Url) && this.width == giphyGif.width && this.height == giphyGif.height;
    }

    public int hashCode() {
        String str = this.f988id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.gifUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.mp4Url;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return ((((hashCode2 + i) * 31) + this.width) * 31) + this.height;
    }

    public String toString() {
        return "GiphyGif(id=" + this.f988id + ", gifUrl=" + this.gifUrl + ", mp4Url=" + this.mp4Url + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public GiphyGif(String str, String str2, String str3, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "gifUrl");
        Intrinsics.checkNotNullParameter(str3, "mp4Url");
        this.f988id = str;
        this.gifUrl = str2;
        this.mp4Url = str3;
        this.width = i;
        this.height = i2;
    }

    public final String getId() {
        return this.f988id;
    }

    public final String getGifUrl() {
        return this.gifUrl;
    }

    public final String getMp4Url() {
        return this.mp4Url;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getIdentifier() {
        return this.f988id;
    }

    public final float aspectRatio() {
        int i = this.height;
        if (i != 0) {
            return ((float) this.width) / ((float) i);
        }
        return 1.0f;
    }
}
