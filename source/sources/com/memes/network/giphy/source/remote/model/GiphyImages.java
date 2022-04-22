package com.memes.network.giphy.source.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, mo26107d2 = {"Lcom/memes/network/giphy/source/remote/model/GiphyImages;", "", "originalMp4", "Lcom/memes/network/giphy/source/remote/model/GiphyMp4Info;", "previewGif", "Lcom/memes/network/giphy/source/remote/model/GiphyPreviewInfo;", "(Lcom/memes/network/giphy/source/remote/model/GiphyMp4Info;Lcom/memes/network/giphy/source/remote/model/GiphyPreviewInfo;)V", "getOriginalMp4", "()Lcom/memes/network/giphy/source/remote/model/GiphyMp4Info;", "setOriginalMp4", "(Lcom/memes/network/giphy/source/remote/model/GiphyMp4Info;)V", "getPreviewGif", "()Lcom/memes/network/giphy/source/remote/model/GiphyPreviewInfo;", "setPreviewGif", "(Lcom/memes/network/giphy/source/remote/model/GiphyPreviewInfo;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GiphyImages.kt */
public final class GiphyImages {
    @SerializedName("original_mp4")
    @Expose
    private GiphyMp4Info originalMp4;
    @SerializedName("preview_gif")
    @Expose
    private GiphyPreviewInfo previewGif;

    public GiphyImages() {
        this((GiphyMp4Info) null, (GiphyPreviewInfo) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GiphyImages copy$default(GiphyImages giphyImages, GiphyMp4Info giphyMp4Info, GiphyPreviewInfo giphyPreviewInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            giphyMp4Info = giphyImages.originalMp4;
        }
        if ((i & 2) != 0) {
            giphyPreviewInfo = giphyImages.previewGif;
        }
        return giphyImages.copy(giphyMp4Info, giphyPreviewInfo);
    }

    public final GiphyMp4Info component1() {
        return this.originalMp4;
    }

    public final GiphyPreviewInfo component2() {
        return this.previewGif;
    }

    public final GiphyImages copy(GiphyMp4Info giphyMp4Info, GiphyPreviewInfo giphyPreviewInfo) {
        return new GiphyImages(giphyMp4Info, giphyPreviewInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GiphyImages)) {
            return false;
        }
        GiphyImages giphyImages = (GiphyImages) obj;
        return Intrinsics.areEqual((Object) this.originalMp4, (Object) giphyImages.originalMp4) && Intrinsics.areEqual((Object) this.previewGif, (Object) giphyImages.previewGif);
    }

    public int hashCode() {
        GiphyMp4Info giphyMp4Info = this.originalMp4;
        int i = 0;
        int hashCode = (giphyMp4Info != null ? giphyMp4Info.hashCode() : 0) * 31;
        GiphyPreviewInfo giphyPreviewInfo = this.previewGif;
        if (giphyPreviewInfo != null) {
            i = giphyPreviewInfo.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "GiphyImages(originalMp4=" + this.originalMp4 + ", previewGif=" + this.previewGif + ")";
    }

    public GiphyImages(GiphyMp4Info giphyMp4Info, GiphyPreviewInfo giphyPreviewInfo) {
        this.originalMp4 = giphyMp4Info;
        this.previewGif = giphyPreviewInfo;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GiphyImages(GiphyMp4Info giphyMp4Info, GiphyPreviewInfo giphyPreviewInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : giphyMp4Info, (i & 2) != 0 ? null : giphyPreviewInfo);
    }

    public final GiphyMp4Info getOriginalMp4() {
        return this.originalMp4;
    }

    public final void setOriginalMp4(GiphyMp4Info giphyMp4Info) {
        this.originalMp4 = giphyMp4Info;
    }

    public final GiphyPreviewInfo getPreviewGif() {
        return this.previewGif;
    }

    public final void setPreviewGif(GiphyPreviewInfo giphyPreviewInfo) {
        this.previewGif = giphyPreviewInfo;
    }
}
