package editor.mediaselection.items;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.memes.commons.aspectratio.AspectRatioFrameLayout;
import com.memes.commons.media.MediaContent;
import com.memes.network.giphy.api.model.GiphyGif;
import com.memes.network.memes.api.model.stockmemes.StockMeme;
import com.memes.network.reddit.api.model.RedditPost;
import editor.mediaselection.items.MediaSelectionItem;
import editor.optionsui.layerpaint.LayerPaint;
import editor.util.DrawableUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006&"}, mo26107d2 = {"Leditor/mediaselection/items/MediaSelectionItemView;", "Lcom/memes/commons/aspectratio/AspectRatioFrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "imageView$delegate", "Lkotlin/Lazy;", "cleanup", "", "glideRequestManager", "Lcom/bumptech/glide/RequestManager;", "load", "item", "Leditor/mediaselection/items/MediaSelectionItem;", "loadDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "loadGiphyGif", "giphyGif", "Lcom/memes/network/giphy/api/model/GiphyGif;", "loadMediaContent", "content", "Lcom/memes/commons/media/MediaContent;", "loadPaint", "layerPaint", "Leditor/optionsui/layerpaint/LayerPaint;", "loadRedditPost", "redditPost", "Lcom/memes/network/reddit/api/model/RedditPost;", "loadStockMeme", "stockMeme", "Lcom/memes/network/memes/api/model/stockmemes/StockMeme;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaSelectionItemView.kt */
public final class MediaSelectionItemView extends AspectRatioFrameLayout {
    private final Lazy imageView$delegate;

    private final ImageView getImageView() {
        return (ImageView) this.imageView$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaSelectionItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.imageView$delegate = LazyKt.lazy(new MediaSelectionItemView$imageView$2(context));
        setResizeMode(2);
        addView(getImageView());
    }

    public final void load(MediaSelectionItem mediaSelectionItem, RequestManager requestManager) {
        Intrinsics.checkNotNullParameter(mediaSelectionItem, "item");
        Intrinsics.checkNotNullParameter(requestManager, "glideRequestManager");
        if (mediaSelectionItem instanceof MediaSelectionItem.Paint) {
            loadPaint(((MediaSelectionItem.Paint) mediaSelectionItem).getPaint());
        } else if (mediaSelectionItem instanceof MediaSelectionItem.Giphy) {
            loadGiphyGif(((MediaSelectionItem.Giphy) mediaSelectionItem).getGiphyGif(), requestManager);
        } else if (mediaSelectionItem instanceof MediaSelectionItem.Meme) {
            loadStockMeme(((MediaSelectionItem.Meme) mediaSelectionItem).getStockMeme(), requestManager);
        } else if (mediaSelectionItem instanceof MediaSelectionItem.Reddit) {
            loadRedditPost(((MediaSelectionItem.Reddit) mediaSelectionItem).getRedditPost(), requestManager);
        } else if (mediaSelectionItem instanceof MediaSelectionItem.LocalContent) {
            loadMediaContent(((MediaSelectionItem.LocalContent) mediaSelectionItem).getIdBasedMedia().getContent(), requestManager);
        }
    }

    public final void loadDrawable(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        setAspectRatio(1.0f);
        getImageView().setImageDrawable(drawable);
    }

    public final void cleanup(RequestManager requestManager) {
        Intrinsics.checkNotNullParameter(requestManager, "glideRequestManager");
        requestManager.clear((View) getImageView());
    }

    private final void loadPaint(LayerPaint layerPaint) {
        Drawable drawable;
        setAspectRatio(1.0f);
        if (layerPaint instanceof LayerPaint.Color) {
            drawable = new ColorDrawable(((LayerPaint.Color) layerPaint).colorInt());
        } else if (layerPaint instanceof LayerPaint.Gradient) {
            drawable = DrawableUtil.INSTANCE.createDrawable((LayerPaint.Gradient) layerPaint);
        } else if (layerPaint instanceof LayerPaint.Pattern) {
            DrawableUtil drawableUtil = DrawableUtil.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            drawable = drawableUtil.createDrawable(context, (LayerPaint.Pattern) layerPaint);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        getImageView().setImageDrawable(drawable);
    }

    private final void loadGiphyGif(GiphyGif giphyGif, RequestManager requestManager) {
        setAspectRatio(giphyGif.aspectRatio());
        ((RequestBuilder) ((RequestBuilder) requestManager.load(giphyGif.getGifUrl()).diskCacheStrategy(DiskCacheStrategy.DATA)).skipMemoryCache(true)).into(getImageView());
    }

    private final void loadStockMeme(StockMeme stockMeme, RequestManager requestManager) {
        setAspectRatio(stockMeme.aspectRatio());
        String absoluteThumbUrl = stockMeme.absoluteThumbUrl();
        CharSequence charSequence = absoluteThumbUrl;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            getImageView().setImageResource(0);
        } else {
            ((RequestBuilder) ((RequestBuilder) requestManager.load(absoluteThumbUrl).diskCacheStrategy(DiskCacheStrategy.DATA)).skipMemoryCache(true)).into(getImageView());
        }
    }

    private final void loadRedditPost(RedditPost redditPost, RequestManager requestManager) {
        RedditPost.Media gifMedia = redditPost.getGifMedia();
        if (gifMedia == null) {
            gifMedia = redditPost.getImageMedia();
        }
        setAspectRatio(gifMedia.aspectRatio());
        ((RequestBuilder) ((RequestBuilder) requestManager.load(gifMedia.getThumbnail()).diskCacheStrategy(DiskCacheStrategy.DATA)).skipMemoryCache(true)).into(getImageView());
    }

    private final void loadMediaContent(MediaContent mediaContent, RequestManager requestManager) {
        setAspectRatio(mediaContent.aspectRatio());
        ((RequestBuilder) ((RequestBuilder) requestManager.load(mediaContent.getContentUrl()).diskCacheStrategy(DiskCacheStrategy.DATA)).skipMemoryCache(true)).into(getImageView());
    }
}
