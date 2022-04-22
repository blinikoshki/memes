package com.memes.network.giphy.api.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0006J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u001d\u001a\u00020\u001aJ\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006!"}, mo26107d2 = {"Lcom/memes/network/giphy/api/model/GiphyAttribute;", "", "type", "", "gifs", "", "Lcom/memes/network/giphy/api/model/GiphyGif;", "error", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "setError", "(Ljava/lang/String;)V", "getGifs", "()Ljava/util/List;", "setGifs", "(Ljava/util/List;)V", "getType", "setType", "addGif", "giphyGif", "component1", "component2", "component3", "copy", "equals", "", "other", "firstGifUrl", "hasGifs", "hashCode", "", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GiphyAttribute.kt */
public final class GiphyAttribute {
    private String error;
    private List<GiphyGif> gifs;
    private String type;

    public static /* synthetic */ GiphyAttribute copy$default(GiphyAttribute giphyAttribute, String str, List<GiphyGif> list, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = giphyAttribute.type;
        }
        if ((i & 2) != 0) {
            list = giphyAttribute.gifs;
        }
        if ((i & 4) != 0) {
            str2 = giphyAttribute.error;
        }
        return giphyAttribute.copy(str, list, str2);
    }

    public final String component1() {
        return this.type;
    }

    public final List<GiphyGif> component2() {
        return this.gifs;
    }

    public final String component3() {
        return this.error;
    }

    public final GiphyAttribute copy(String str, List<GiphyGif> list, String str2) {
        Intrinsics.checkNotNullParameter(str, "type");
        return new GiphyAttribute(str, list, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GiphyAttribute)) {
            return false;
        }
        GiphyAttribute giphyAttribute = (GiphyAttribute) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) giphyAttribute.type) && Intrinsics.areEqual((Object) this.gifs, (Object) giphyAttribute.gifs) && Intrinsics.areEqual((Object) this.error, (Object) giphyAttribute.error);
    }

    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<GiphyGif> list = this.gifs;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.error;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "GiphyAttribute(type=" + this.type + ", gifs=" + this.gifs + ", error=" + this.error + ")";
    }

    public GiphyAttribute(String str, List<GiphyGif> list, String str2) {
        Intrinsics.checkNotNullParameter(str, "type");
        this.type = str;
        this.gifs = list;
        this.error = str2;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GiphyAttribute(String str, List list, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : str2);
    }

    public final List<GiphyGif> getGifs() {
        return this.gifs;
    }

    public final void setGifs(List<GiphyGif> list) {
        this.gifs = list;
    }

    public final String getError() {
        return this.error;
    }

    public final void setError(String str) {
        this.error = str;
    }

    public final boolean hasGifs() {
        List<GiphyGif> list = this.gifs;
        if (list != null) {
            if (list != null && !list.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public final String firstGifUrl() {
        if (!hasGifs()) {
            return null;
        }
        List<GiphyGif> list = this.gifs;
        Intrinsics.checkNotNull(list);
        return list.get(0).getGifUrl();
    }

    public final GiphyAttribute addGif(GiphyGif giphyGif) {
        Intrinsics.checkNotNullParameter(giphyGif, "giphyGif");
        if (this.gifs == null) {
            this.gifs = new ArrayList();
        }
        if (giphyGif.getGifUrl() != null) {
            List<GiphyGif> list = this.gifs;
            Intrinsics.checkNotNull(list);
            list.add(giphyGif);
        }
        return this;
    }
}
