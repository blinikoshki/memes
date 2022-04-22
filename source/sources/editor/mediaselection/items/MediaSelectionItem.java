package editor.mediaselection.items;

import com.memes.network.giphy.api.model.GiphyGif;
import com.memes.network.memes.api.model.stockmemes.StockMeme;
import com.memes.network.reddit.api.model.RedditPost;
import editor.mediaselection.localmedia.IdBasedMedia;
import editor.optionsui.layerpaint.LayerPaint;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0005\f\r\u000e\u000f\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0005\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, mo26107d2 = {"Leditor/mediaselection/items/MediaSelectionItem;", "", "identifier", "", "(Ljava/lang/String;)V", "getIdentifier", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "Giphy", "LocalContent", "Meme", "Paint", "Reddit", "Leditor/mediaselection/items/MediaSelectionItem$Paint;", "Leditor/mediaselection/items/MediaSelectionItem$Giphy;", "Leditor/mediaselection/items/MediaSelectionItem$Meme;", "Leditor/mediaselection/items/MediaSelectionItem$Reddit;", "Leditor/mediaselection/items/MediaSelectionItem$LocalContent;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaSelectionItem.kt */
public abstract class MediaSelectionItem {
    private final String identifier;

    private MediaSelectionItem(String str) {
        this.identifier = str;
    }

    public /* synthetic */ MediaSelectionItem(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Leditor/mediaselection/items/MediaSelectionItem$Paint;", "Leditor/mediaselection/items/MediaSelectionItem;", "paint", "Leditor/optionsui/layerpaint/LayerPaint;", "(Leditor/optionsui/layerpaint/LayerPaint;)V", "getPaint", "()Leditor/optionsui/layerpaint/LayerPaint;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MediaSelectionItem.kt */
    public static final class Paint extends MediaSelectionItem {
        private final LayerPaint paint;

        public static /* synthetic */ Paint copy$default(Paint paint2, LayerPaint layerPaint, int i, Object obj) {
            if ((i & 1) != 0) {
                layerPaint = paint2.paint;
            }
            return paint2.copy(layerPaint);
        }

        public final LayerPaint component1() {
            return this.paint;
        }

        public final Paint copy(LayerPaint layerPaint) {
            Intrinsics.checkNotNullParameter(layerPaint, "paint");
            return new Paint(layerPaint);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Paint) && Intrinsics.areEqual((Object) this.paint, (Object) ((Paint) obj).paint);
            }
            return true;
        }

        public int hashCode() {
            LayerPaint layerPaint = this.paint;
            if (layerPaint != null) {
                return layerPaint.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Paint(paint=" + this.paint + ")";
        }

        public final LayerPaint getPaint() {
            return this.paint;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Paint(LayerPaint layerPaint) {
            super(layerPaint.getIdentifier(), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(layerPaint, "paint");
            this.paint = layerPaint;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Leditor/mediaselection/items/MediaSelectionItem$Giphy;", "Leditor/mediaselection/items/MediaSelectionItem;", "giphyGif", "Lcom/memes/network/giphy/api/model/GiphyGif;", "(Lcom/memes/network/giphy/api/model/GiphyGif;)V", "getGiphyGif", "()Lcom/memes/network/giphy/api/model/GiphyGif;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MediaSelectionItem.kt */
    public static final class Giphy extends MediaSelectionItem {
        private final GiphyGif giphyGif;

        public static /* synthetic */ Giphy copy$default(Giphy giphy, GiphyGif giphyGif2, int i, Object obj) {
            if ((i & 1) != 0) {
                giphyGif2 = giphy.giphyGif;
            }
            return giphy.copy(giphyGif2);
        }

        public final GiphyGif component1() {
            return this.giphyGif;
        }

        public final Giphy copy(GiphyGif giphyGif2) {
            Intrinsics.checkNotNullParameter(giphyGif2, "giphyGif");
            return new Giphy(giphyGif2);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Giphy) && Intrinsics.areEqual((Object) this.giphyGif, (Object) ((Giphy) obj).giphyGif);
            }
            return true;
        }

        public int hashCode() {
            GiphyGif giphyGif2 = this.giphyGif;
            if (giphyGif2 != null) {
                return giphyGif2.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Giphy(giphyGif=" + this.giphyGif + ")";
        }

        public final GiphyGif getGiphyGif() {
            return this.giphyGif;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Giphy(GiphyGif giphyGif2) {
            super(giphyGif2.getIdentifier(), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(giphyGif2, "giphyGif");
            this.giphyGif = giphyGif2;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Leditor/mediaselection/items/MediaSelectionItem$Meme;", "Leditor/mediaselection/items/MediaSelectionItem;", "stockMeme", "Lcom/memes/network/memes/api/model/stockmemes/StockMeme;", "(Lcom/memes/network/memes/api/model/stockmemes/StockMeme;)V", "getStockMeme", "()Lcom/memes/network/memes/api/model/stockmemes/StockMeme;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MediaSelectionItem.kt */
    public static final class Meme extends MediaSelectionItem {
        private final StockMeme stockMeme;

        public static /* synthetic */ Meme copy$default(Meme meme, StockMeme stockMeme2, int i, Object obj) {
            if ((i & 1) != 0) {
                stockMeme2 = meme.stockMeme;
            }
            return meme.copy(stockMeme2);
        }

        public final StockMeme component1() {
            return this.stockMeme;
        }

        public final Meme copy(StockMeme stockMeme2) {
            Intrinsics.checkNotNullParameter(stockMeme2, "stockMeme");
            return new Meme(stockMeme2);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Meme) && Intrinsics.areEqual((Object) this.stockMeme, (Object) ((Meme) obj).stockMeme);
            }
            return true;
        }

        public int hashCode() {
            StockMeme stockMeme2 = this.stockMeme;
            if (stockMeme2 != null) {
                return stockMeme2.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Meme(stockMeme=" + this.stockMeme + ")";
        }

        public final StockMeme getStockMeme() {
            return this.stockMeme;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Meme(StockMeme stockMeme2) {
            super(stockMeme2.getIdentifier(), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(stockMeme2, "stockMeme");
            this.stockMeme = stockMeme2;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Leditor/mediaselection/items/MediaSelectionItem$Reddit;", "Leditor/mediaselection/items/MediaSelectionItem;", "redditPost", "Lcom/memes/network/reddit/api/model/RedditPost;", "(Lcom/memes/network/reddit/api/model/RedditPost;)V", "getRedditPost", "()Lcom/memes/network/reddit/api/model/RedditPost;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MediaSelectionItem.kt */
    public static final class Reddit extends MediaSelectionItem {
        private final RedditPost redditPost;

        public static /* synthetic */ Reddit copy$default(Reddit reddit, RedditPost redditPost2, int i, Object obj) {
            if ((i & 1) != 0) {
                redditPost2 = reddit.redditPost;
            }
            return reddit.copy(redditPost2);
        }

        public final RedditPost component1() {
            return this.redditPost;
        }

        public final Reddit copy(RedditPost redditPost2) {
            Intrinsics.checkNotNullParameter(redditPost2, "redditPost");
            return new Reddit(redditPost2);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Reddit) && Intrinsics.areEqual((Object) this.redditPost, (Object) ((Reddit) obj).redditPost);
            }
            return true;
        }

        public int hashCode() {
            RedditPost redditPost2 = this.redditPost;
            if (redditPost2 != null) {
                return redditPost2.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Reddit(redditPost=" + this.redditPost + ")";
        }

        public final RedditPost getRedditPost() {
            return this.redditPost;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Reddit(RedditPost redditPost2) {
            super(redditPost2.getIdentifier(), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(redditPost2, "redditPost");
            this.redditPost = redditPost2;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Leditor/mediaselection/items/MediaSelectionItem$LocalContent;", "Leditor/mediaselection/items/MediaSelectionItem;", "idBasedMedia", "Leditor/mediaselection/localmedia/IdBasedMedia;", "(Leditor/mediaselection/localmedia/IdBasedMedia;)V", "getIdBasedMedia", "()Leditor/mediaselection/localmedia/IdBasedMedia;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MediaSelectionItem.kt */
    public static final class LocalContent extends MediaSelectionItem {
        private final IdBasedMedia idBasedMedia;

        public static /* synthetic */ LocalContent copy$default(LocalContent localContent, IdBasedMedia idBasedMedia2, int i, Object obj) {
            if ((i & 1) != 0) {
                idBasedMedia2 = localContent.idBasedMedia;
            }
            return localContent.copy(idBasedMedia2);
        }

        public final IdBasedMedia component1() {
            return this.idBasedMedia;
        }

        public final LocalContent copy(IdBasedMedia idBasedMedia2) {
            Intrinsics.checkNotNullParameter(idBasedMedia2, "idBasedMedia");
            return new LocalContent(idBasedMedia2);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof LocalContent) && Intrinsics.areEqual((Object) this.idBasedMedia, (Object) ((LocalContent) obj).idBasedMedia);
            }
            return true;
        }

        public int hashCode() {
            IdBasedMedia idBasedMedia2 = this.idBasedMedia;
            if (idBasedMedia2 != null) {
                return idBasedMedia2.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "LocalContent(idBasedMedia=" + this.idBasedMedia + ")";
        }

        public final IdBasedMedia getIdBasedMedia() {
            return this.idBasedMedia;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LocalContent(IdBasedMedia idBasedMedia2) {
            super(idBasedMedia2.getId(), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(idBasedMedia2, "idBasedMedia");
            this.idBasedMedia = idBasedMedia2;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type editor.mediaselection.items.MediaSelectionItem");
        if (!Intrinsics.areEqual((Object) this.identifier, (Object) ((MediaSelectionItem) obj).identifier)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.identifier.hashCode();
    }
}
