package com.memes.network.giphy.source.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo26107d2 = {"Lcom/memes/network/giphy/source/remote/model/GiphyItem;", "", "id", "", "images", "Lcom/memes/network/giphy/source/remote/model/GiphyImages;", "(Ljava/lang/String;Lcom/memes/network/giphy/source/remote/model/GiphyImages;)V", "getId", "()Ljava/lang/String;", "getImages", "()Lcom/memes/network/giphy/source/remote/model/GiphyImages;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GiphyItem.kt */
public final class GiphyItem {
    @SerializedName("id")
    @Expose

    /* renamed from: id */
    private final String f989id;
    @SerializedName("images")
    @Expose
    private final GiphyImages images;

    public static /* synthetic */ GiphyItem copy$default(GiphyItem giphyItem, String str, GiphyImages giphyImages, int i, Object obj) {
        if ((i & 1) != 0) {
            str = giphyItem.f989id;
        }
        if ((i & 2) != 0) {
            giphyImages = giphyItem.images;
        }
        return giphyItem.copy(str, giphyImages);
    }

    public final String component1() {
        return this.f989id;
    }

    public final GiphyImages component2() {
        return this.images;
    }

    public final GiphyItem copy(String str, GiphyImages giphyImages) {
        Intrinsics.checkNotNullParameter(str, "id");
        return new GiphyItem(str, giphyImages);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GiphyItem)) {
            return false;
        }
        GiphyItem giphyItem = (GiphyItem) obj;
        return Intrinsics.areEqual((Object) this.f989id, (Object) giphyItem.f989id) && Intrinsics.areEqual((Object) this.images, (Object) giphyItem.images);
    }

    public int hashCode() {
        String str = this.f989id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        GiphyImages giphyImages = this.images;
        if (giphyImages != null) {
            i = giphyImages.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "GiphyItem(id=" + this.f989id + ", images=" + this.images + ")";
    }

    public GiphyItem(String str, GiphyImages giphyImages) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.f989id = str;
        this.images = giphyImages;
    }

    public final String getId() {
        return this.f989id;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GiphyItem(String str, GiphyImages giphyImages, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : giphyImages);
    }

    public final GiphyImages getImages() {
        return this.images;
    }
}
