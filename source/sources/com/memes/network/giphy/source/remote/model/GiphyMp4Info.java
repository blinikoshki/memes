package com.memes.network.giphy.source.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, mo26107d2 = {"Lcom/memes/network/giphy/source/remote/model/GiphyMp4Info;", "", "mp4", "", "mp4Size", "width", "height", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHeight", "()Ljava/lang/String;", "getMp4", "getMp4Size", "getWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GiphyMp4Info.kt */
public final class GiphyMp4Info {
    @SerializedName("height")
    @Expose
    private final String height;
    @SerializedName("mp4")
    @Expose
    private final String mp4;
    @SerializedName("mp4_size")
    @Expose
    private final String mp4Size;
    @SerializedName("width")
    @Expose
    private final String width;

    public GiphyMp4Info() {
        this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GiphyMp4Info copy$default(GiphyMp4Info giphyMp4Info, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = giphyMp4Info.mp4;
        }
        if ((i & 2) != 0) {
            str2 = giphyMp4Info.mp4Size;
        }
        if ((i & 4) != 0) {
            str3 = giphyMp4Info.width;
        }
        if ((i & 8) != 0) {
            str4 = giphyMp4Info.height;
        }
        return giphyMp4Info.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.mp4;
    }

    public final String component2() {
        return this.mp4Size;
    }

    public final String component3() {
        return this.width;
    }

    public final String component4() {
        return this.height;
    }

    public final GiphyMp4Info copy(String str, String str2, String str3, String str4) {
        return new GiphyMp4Info(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GiphyMp4Info)) {
            return false;
        }
        GiphyMp4Info giphyMp4Info = (GiphyMp4Info) obj;
        return Intrinsics.areEqual((Object) this.mp4, (Object) giphyMp4Info.mp4) && Intrinsics.areEqual((Object) this.mp4Size, (Object) giphyMp4Info.mp4Size) && Intrinsics.areEqual((Object) this.width, (Object) giphyMp4Info.width) && Intrinsics.areEqual((Object) this.height, (Object) giphyMp4Info.height);
    }

    public int hashCode() {
        String str = this.mp4;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.mp4Size;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.width;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.height;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "GiphyMp4Info(mp4=" + this.mp4 + ", mp4Size=" + this.mp4Size + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public GiphyMp4Info(String str, String str2, String str3, String str4) {
        this.mp4 = str;
        this.mp4Size = str2;
        this.width = str3;
        this.height = str4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GiphyMp4Info(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    public final String getMp4() {
        return this.mp4;
    }

    public final String getMp4Size() {
        return this.mp4Size;
    }

    public final String getWidth() {
        return this.width;
    }

    public final String getHeight() {
        return this.height;
    }
}
