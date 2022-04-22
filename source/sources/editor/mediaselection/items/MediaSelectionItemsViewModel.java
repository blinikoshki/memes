package editor.mediaselection.items;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.editor.C4175R;
import com.memes.network.giphy.api.model.GiphyGif;
import com.memes.network.memes.api.model.stockmemes.StockMeme;
import com.memes.network.reddit.api.model.RedditPost;
import editor.common.assetsprovider.AssetsProvider;
import editor.core.NicoViewModel;
import editor.mediaselection.MediaSelectionConfig;
import editor.mediaselection.items.MediaSelectionItem;
import editor.mediaselection.localmedia.IdBasedMedia;
import editor.mediaselection.localmedia.LocalMedia;
import editor.mediaselection.localmedia.LocalMediaExtKt;
import editor.mediaselection.localmedia.MediaProvider;
import editor.mediaselection.targetedmediabrowser.MediaSelectionTarget;
import editor.mediaselection.targetedmediabrowser.TargetedMediaSelectionConfig;
import editor.optionsui.layerpaint.LayerPaint;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010)\u001a\u00020*J(\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-2\u0018\u0010.\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u000100\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010/J\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u000202J\u0006\u00104\u001a\u000202J\u0006\u00105\u001a\u000202J\u0006\u00106\u001a\u000202J\u0006\u00107\u001a\u000202J\u0006\u00108\u001a\u000202J\u0014\u00109\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0:J\u0014\u0010;\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\t0:J\u0014\u0010<\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\t0:J\u0012\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\t0:J\u0012\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\t0:J\u000e\u0010?\u001a\u00020*2\u0006\u0010%\u001a\u00020&J\u0014\u0010@\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\t0:J\u0014\u0010A\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\t0:J\u0014\u0010B\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\t0:J\u0014\u0010C\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\t0:J\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\"0:J\u0014\u0010E\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\t0:J\u0006\u0010F\u001a\u00020*J\u0016\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\n2\u0006\u0010J\u001a\u00020HJ\u0016\u0010K\u001a\u00020H2\u0006\u0010L\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020HJ\u0016\u0010M\u001a\u00020H2\u0006\u0010N\u001a\u00020\u00112\u0006\u0010J\u001a\u00020HJ\u0016\u0010O\u001a\u00020H2\u0006\u0010P\u001a\u00020Q2\u0006\u0010J\u001a\u00020HJ\u0016\u0010R\u001a\u00020H2\u0006\u0010S\u001a\u00020\u00132\u0006\u0010J\u001a\u00020HJ\u0016\u0010T\u001a\u00020H2\u0006\u0010U\u001a\u00020\u00192\u0006\u0010J\u001a\u00020HJ\u0016\u0010V\u001a\u00020H2\u0006\u0010W\u001a\u00020\u00162\u0006\u0010J\u001a\u00020HJ\u0016\u0010X\u001a\u00020H2\u0006\u0010Y\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020HJ\u0016\u0010Z\u001a\u00020H2\u0006\u0010[\u001a\u00020\u001f2\u0006\u0010J\u001a\u00020HJ\u0010\u0010\\\u001a\u0002022\u0006\u0010,\u001a\u00020-H\u0002J\u0006\u0010]\u001a\u00020*R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00130(X\u0004¢\u0006\u0002\n\u0000¨\u0006^"}, mo26107d2 = {"Leditor/mediaselection/items/MediaSelectionItemsViewModel;", "Leditor/core/NicoViewModel;", "assetsProvider", "Leditor/common/assetsprovider/AssetsProvider;", "mediaProvider", "Leditor/mediaselection/localmedia/MediaProvider;", "(Leditor/common/assetsprovider/AssetsProvider;Leditor/mediaselection/localmedia/MediaProvider;)V", "_colors", "Landroidx/lifecycle/MutableLiveData;", "", "Leditor/optionsui/layerpaint/LayerPaint$Color;", "_colorsGradientsExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "_giphyExceptionHandler", "_giphyGifs", "Lcom/memes/network/giphy/api/model/GiphyGif;", "_gradients", "Leditor/optionsui/layerpaint/LayerPaint$Gradient;", "_mediaItemsSelected", "Leditor/mediaselection/items/MediaSelectionItem;", "_mediaItemsUnselected", "_patterns", "Leditor/optionsui/layerpaint/LayerPaint$Pattern;", "_patternsExceptionHandler", "_photos", "Leditor/mediaselection/localmedia/LocalMedia;", "_photosExceptionHandler", "_redditPostExceptionHandler", "_redditPosts", "Lcom/memes/network/reddit/api/model/RedditPost;", "_stockMemes", "Lcom/memes/network/memes/api/model/stockmemes/StockMeme;", "_stockMemesExceptionHandler", "_targetedMediaSelectionConfig", "Leditor/mediaselection/targetedmediabrowser/TargetedMediaSelectionConfig;", "_videos", "_videosExceptionHandler", "config", "Leditor/mediaselection/MediaSelectionConfig;", "selectedItemsList", "", "giphyActionButtonTapped", "", "handleTargetedMediaSelectionResult", "target", "Leditor/mediaselection/targetedmediabrowser/MediaSelectionTarget;", "resultPair", "Lkotlin/Pair;", "", "loadColorsGradients", "Lkotlinx/coroutines/Job;", "loadGiphyGifs", "loadPatterns", "loadPhotos", "loadRedditPosts", "loadStockMemes", "loadVideos", "onColorsAvailable", "Landroidx/lifecycle/LiveData;", "onGiphyGifsAvailable", "onGradientsAvailable", "onMediaItemsSelected", "onMediaItemsUnselected", "onMediaSelectionConfigChanged", "onPatternsAvailable", "onPhotosAvailable", "onRedditPostsAvailable", "onStockMemesAvailable", "onTargetedMediaSelectionConfigAvailable", "onVideosAvailable", "redditPostsActionButtonTapped", "setColorSelected", "", "colorPaint", "selected", "setGiphyGifSelected", "giphyGif", "setGradientSelected", "gradient", "setIdBasedMediaSelected", "idBasedMedia", "Leditor/mediaselection/localmedia/IdBasedMedia;", "setItemSelected", "item", "setLocalMediaSelected", "localMedia", "setPatternSelected", "pattern", "setRedditPostSelected", "redditPost", "setStockMemeSelected", "stockMeme", "startTargetedMediaSelection", "stockMemesActionButtonTapped", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaSelectionItemsViewModel.kt */
public final class MediaSelectionItemsViewModel extends NicoViewModel {
    /* access modifiers changed from: private */
    public final MutableLiveData<List<LayerPaint.Color>> _colors = new MutableLiveData<>();
    private final CoroutineExceptionHandler _colorsGradientsExceptionHandler = new C4815x7ec9bc3a(CoroutineExceptionHandler.Key, this);
    private final CoroutineExceptionHandler _giphyExceptionHandler = new C4817x7ec9bc3c(CoroutineExceptionHandler.Key, this);
    /* access modifiers changed from: private */
    public final MutableLiveData<List<GiphyGif>> _giphyGifs = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<List<LayerPaint.Gradient>> _gradients = new MutableLiveData<>();
    private final MutableLiveData<List<MediaSelectionItem>> _mediaItemsSelected;
    private final MutableLiveData<List<MediaSelectionItem>> _mediaItemsUnselected;
    /* access modifiers changed from: private */
    public final MutableLiveData<List<LayerPaint.Pattern>> _patterns = new MutableLiveData<>();
    private final CoroutineExceptionHandler _patternsExceptionHandler = new C4816x7ec9bc3b(CoroutineExceptionHandler.Key, this);
    /* access modifiers changed from: private */
    public final MutableLiveData<List<LocalMedia>> _photos = new MutableLiveData<>();
    private final CoroutineExceptionHandler _photosExceptionHandler = new C4818x7ec9bc3d(CoroutineExceptionHandler.Key, this);
    private final CoroutineExceptionHandler _redditPostExceptionHandler = new C4821x7ec9bc40(CoroutineExceptionHandler.Key, this);
    /* access modifiers changed from: private */
    public final MutableLiveData<List<RedditPost>> _redditPosts = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<List<StockMeme>> _stockMemes = new MutableLiveData<>();
    private final CoroutineExceptionHandler _stockMemesExceptionHandler = new C4820x7ec9bc3f(CoroutineExceptionHandler.Key, this);
    /* access modifiers changed from: private */
    public final MutableLiveData<TargetedMediaSelectionConfig> _targetedMediaSelectionConfig;
    /* access modifiers changed from: private */
    public final MutableLiveData<List<LocalMedia>> _videos = new MutableLiveData<>();
    private final CoroutineExceptionHandler _videosExceptionHandler = new C4819x7ec9bc3e(CoroutineExceptionHandler.Key, this);
    /* access modifiers changed from: private */
    public final AssetsProvider assetsProvider;
    /* access modifiers changed from: private */
    public MediaSelectionConfig config;
    /* access modifiers changed from: private */
    public final MediaProvider mediaProvider;
    /* access modifiers changed from: private */
    public final List<MediaSelectionItem> selectedItemsList;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MediaSelectionTarget.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[MediaSelectionTarget.GIPHY.ordinal()] = 1;
            iArr[MediaSelectionTarget.MEMES.ordinal()] = 2;
            iArr[MediaSelectionTarget.REDDIT.ordinal()] = 3;
        }
    }

    public MediaSelectionItemsViewModel(AssetsProvider assetsProvider2, MediaProvider mediaProvider2) {
        Intrinsics.checkNotNullParameter(assetsProvider2, "assetsProvider");
        Intrinsics.checkNotNullParameter(mediaProvider2, "mediaProvider");
        this.assetsProvider = assetsProvider2;
        this.mediaProvider = mediaProvider2;
        loadPhotos();
        loadVideos();
        loadGiphyGifs();
        loadStockMemes();
        loadRedditPosts();
        this.config = new MediaSelectionConfig(0, (List) null, false, 7, (DefaultConstructorMarker) null);
        this.selectedItemsList = new ArrayList();
        this._mediaItemsSelected = new MutableLiveData<>();
        this._mediaItemsUnselected = new MutableLiveData<>();
        this._targetedMediaSelectionConfig = new MutableLiveData<>();
    }

    public final LiveData<List<LayerPaint.Color>> onColorsAvailable() {
        return this._colors;
    }

    public final LiveData<List<LayerPaint.Gradient>> onGradientsAvailable() {
        return this._gradients;
    }

    public final LiveData<List<LayerPaint.Pattern>> onPatternsAvailable() {
        return this._patterns;
    }

    public final LiveData<List<GiphyGif>> onGiphyGifsAvailable() {
        return this._giphyGifs;
    }

    public final LiveData<List<LocalMedia>> onPhotosAvailable() {
        return this._photos;
    }

    public final LiveData<List<LocalMedia>> onVideosAvailable() {
        return this._videos;
    }

    public final LiveData<List<StockMeme>> onStockMemesAvailable() {
        return this._stockMemes;
    }

    public final LiveData<List<RedditPost>> onRedditPostsAvailable() {
        return this._redditPosts;
    }

    public final Job loadColorsGradients() {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this._colorsGradientsExceptionHandler, (CoroutineStart) null, new MediaSelectionItemsViewModel$loadColorsGradients$1(this, (Continuation) null), 2, (Object) null);
    }

    public final Job loadPatterns() {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this._patternsExceptionHandler, (CoroutineStart) null, new MediaSelectionItemsViewModel$loadPatterns$1(this, (Continuation) null), 2, (Object) null);
    }

    public final Job loadPhotos() {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this._photosExceptionHandler, (CoroutineStart) null, new MediaSelectionItemsViewModel$loadPhotos$1(this, (Continuation) null), 2, (Object) null);
    }

    public final Job loadVideos() {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this._videosExceptionHandler, (CoroutineStart) null, new MediaSelectionItemsViewModel$loadVideos$1(this, (Continuation) null), 2, (Object) null);
    }

    public final Job loadGiphyGifs() {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this._giphyExceptionHandler, (CoroutineStart) null, new MediaSelectionItemsViewModel$loadGiphyGifs$1(this, (Continuation) null), 2, (Object) null);
    }

    public final Job loadStockMemes() {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this._stockMemesExceptionHandler, (CoroutineStart) null, new MediaSelectionItemsViewModel$loadStockMemes$1(this, (Continuation) null), 2, (Object) null);
    }

    public final Job loadRedditPosts() {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this._redditPostExceptionHandler, (CoroutineStart) null, new MediaSelectionItemsViewModel$loadRedditPosts$1(this, (Continuation) null), 2, (Object) null);
    }

    public final LiveData<List<MediaSelectionItem>> onMediaItemsSelected() {
        return this._mediaItemsSelected;
    }

    public final LiveData<List<MediaSelectionItem>> onMediaItemsUnselected() {
        return this._mediaItemsUnselected;
    }

    public final LiveData<TargetedMediaSelectionConfig> onTargetedMediaSelectionConfigAvailable() {
        return this._targetedMediaSelectionConfig;
    }

    public final void onMediaSelectionConfigChanged(MediaSelectionConfig mediaSelectionConfig) {
        Intrinsics.checkNotNullParameter(mediaSelectionConfig, "config");
        this.config = mediaSelectionConfig;
    }

    public final boolean setColorSelected(LayerPaint.Color color, boolean z) {
        Intrinsics.checkNotNullParameter(color, "colorPaint");
        return setItemSelected(new MediaSelectionItem.Paint(color), z);
    }

    public final boolean setGradientSelected(LayerPaint.Gradient gradient, boolean z) {
        Intrinsics.checkNotNullParameter(gradient, "gradient");
        return setItemSelected(new MediaSelectionItem.Paint(gradient), z);
    }

    public final boolean setPatternSelected(LayerPaint.Pattern pattern, boolean z) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        return setItemSelected(new MediaSelectionItem.Paint(pattern), z);
    }

    public final boolean setLocalMediaSelected(LocalMedia localMedia, boolean z) {
        Intrinsics.checkNotNullParameter(localMedia, "localMedia");
        return setIdBasedMediaSelected(LocalMediaExtKt.toIdBasedMedia(localMedia), z);
    }

    public final boolean setIdBasedMediaSelected(IdBasedMedia idBasedMedia, boolean z) {
        Intrinsics.checkNotNullParameter(idBasedMedia, "idBasedMedia");
        return setItemSelected(new MediaSelectionItem.LocalContent(idBasedMedia), z);
    }

    public final boolean setGiphyGifSelected(GiphyGif giphyGif, boolean z) {
        Intrinsics.checkNotNullParameter(giphyGif, "giphyGif");
        return setItemSelected(new MediaSelectionItem.Giphy(giphyGif), z);
    }

    public final boolean setStockMemeSelected(StockMeme stockMeme, boolean z) {
        Intrinsics.checkNotNullParameter(stockMeme, "stockMeme");
        if (stockMeme.isInvalid()) {
            return !z;
        }
        return setItemSelected(new MediaSelectionItem.Meme(stockMeme), z);
    }

    public final boolean setRedditPostSelected(RedditPost redditPost, boolean z) {
        Intrinsics.checkNotNullParameter(redditPost, "redditPost");
        return setItemSelected(new MediaSelectionItem.Reddit(redditPost), z);
    }

    public final boolean setItemSelected(MediaSelectionItem mediaSelectionItem, boolean z) {
        Intrinsics.checkNotNullParameter(mediaSelectionItem, "item");
        if (this.selectedItemsList.contains(mediaSelectionItem) == z) {
            return z;
        }
        if (!z) {
            this.selectedItemsList.remove(mediaSelectionItem);
            this._mediaItemsUnselected.setValue(CollectionsKt.listOf(mediaSelectionItem));
        } else if (this.selectedItemsList.size() >= this.config.getSelectionCountLimit()) {
            toast(C4175R.string.media_selection_limit_reached);
            return false;
        } else {
            this.selectedItemsList.add(mediaSelectionItem);
            this._mediaItemsSelected.setValue(CollectionsKt.listOf(mediaSelectionItem));
        }
        return z;
    }

    public final void giphyActionButtonTapped() {
        startTargetedMediaSelection(MediaSelectionTarget.GIPHY);
    }

    public final void stockMemesActionButtonTapped() {
        startTargetedMediaSelection(MediaSelectionTarget.MEMES);
    }

    public final void redditPostsActionButtonTapped() {
        startTargetedMediaSelection(MediaSelectionTarget.REDDIT);
    }

    private final Job startTargetedMediaSelection(MediaSelectionTarget mediaSelectionTarget) {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new MediaSelectionItemsViewModel$startTargetedMediaSelection$1(this, mediaSelectionTarget, (Continuation) null), 3, (Object) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v18, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleTargetedMediaSelectionResult(editor.mediaselection.targetedmediabrowser.MediaSelectionTarget r9, kotlin.Pair<java.lang.String, java.lang.String> r10) {
        /*
            r8 = this;
            java.lang.String r0 = "target"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            if (r10 != 0) goto L_0x0008
            return
        L_0x0008:
            java.lang.Object r0 = r10.getSecond()
            java.lang.String r0 = (java.lang.String) r0
            com.google.gson.Gson r1 = new com.google.gson.Gson
            r1.<init>()
            java.lang.Class<java.util.List> r2 = java.util.List.class
            java.lang.reflect.Type r2 = (java.lang.reflect.Type) r2
            r3 = 1
            java.lang.reflect.Type[] r4 = new java.lang.reflect.Type[r3]
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            java.lang.reflect.Type r5 = (java.lang.reflect.Type) r5
            r6 = 0
            r4[r6] = r5
            com.google.gson.reflect.TypeToken r2 = com.google.gson.reflect.TypeToken.getParameterized(r2, r4)
            java.lang.String r4 = "TypeToken.getParameteriz…java, String::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            java.lang.reflect.Type r2 = r2.getType()
            java.lang.Object r0 = r1.fromJson((java.lang.String) r0, (java.lang.reflect.Type) r2)
            java.util.List r0 = (java.util.List) r0
            java.util.List<editor.mediaselection.items.MediaSelectionItem> r1 = r8.selectedItemsList
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r1 = r1.iterator()
        L_0x0043:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0075
            java.lang.Object r4 = r1.next()
            r5 = r4
            editor.mediaselection.items.MediaSelectionItem r5 = (editor.mediaselection.items.MediaSelectionItem) r5
            r7 = r0
            java.util.Collection r7 = (java.util.Collection) r7
            if (r7 == 0) goto L_0x005e
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x005c
            goto L_0x005e
        L_0x005c:
            r7 = 0
            goto L_0x005f
        L_0x005e:
            r7 = 1
        L_0x005f:
            if (r7 != 0) goto L_0x006e
            java.lang.String r5 = r5.getIdentifier()
            boolean r5 = r0.contains(r5)
            if (r5 != 0) goto L_0x006c
            goto L_0x006e
        L_0x006c:
            r5 = 0
            goto L_0x006f
        L_0x006e:
            r5 = 1
        L_0x006f:
            if (r5 == 0) goto L_0x0043
            r2.add(r4)
            goto L_0x0043
        L_0x0075:
            java.util.List r2 = (java.util.List) r2
            java.util.List<editor.mediaselection.items.MediaSelectionItem> r0 = r8.selectedItemsList
            r1 = r2
            java.util.Collection r1 = (java.util.Collection) r1
            r0.removeAll(r1)
            androidx.lifecycle.MutableLiveData<java.util.List<editor.mediaselection.items.MediaSelectionItem>> r0 = r8._mediaItemsUnselected
            r0.setValue(r2)
            java.lang.Object r10 = r10.getFirst()
            java.lang.String r10 = (java.lang.String) r10
            r0 = r10
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0098
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L_0x0096
            goto L_0x0098
        L_0x0096:
            r0 = 0
            goto L_0x0099
        L_0x0098:
            r0 = 1
        L_0x0099:
            if (r0 != 0) goto L_0x0201
            int[] r0 = editor.mediaselection.items.MediaSelectionItemsViewModel.WhenMappings.$EnumSwitchMapping$0
            int r9 = r9.ordinal()
            r9 = r0[r9]
            r0 = 10
            if (r9 == r3) goto L_0x017c
            r1 = 2
            if (r9 == r1) goto L_0x0104
            r1 = 3
            if (r9 != r1) goto L_0x00fe
            com.google.gson.Gson r9 = new com.google.gson.Gson
            r9.<init>()
            java.lang.Class<java.util.List> r1 = java.util.List.class
            java.lang.reflect.Type r1 = (java.lang.reflect.Type) r1
            java.lang.reflect.Type[] r2 = new java.lang.reflect.Type[r3]
            java.lang.Class<com.memes.network.reddit.api.model.RedditPost> r4 = com.memes.network.reddit.api.model.RedditPost.class
            java.lang.reflect.Type r4 = (java.lang.reflect.Type) r4
            r2[r6] = r4
            com.google.gson.reflect.TypeToken r1 = com.google.gson.reflect.TypeToken.getParameterized(r1, r2)
            java.lang.String r2 = "TypeToken.getParameteriz…\t\tRedditPost::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.reflect.Type r1 = r1.getType()
            java.lang.Object r9 = r9.fromJson((java.lang.String) r10, (java.lang.reflect.Type) r1)
            java.lang.String r10 = "Gson().fromJson<List<Red…::class.java).type\n\t\t\t\t\t)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r10 = new java.util.ArrayList
            int r0 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r9, r0)
            r10.<init>(r0)
            java.util.Collection r10 = (java.util.Collection) r10
            java.util.Iterator r9 = r9.iterator()
        L_0x00e5:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x00fa
            java.lang.Object r0 = r9.next()
            com.memes.network.reddit.api.model.RedditPost r0 = (com.memes.network.reddit.api.model.RedditPost) r0
            editor.mediaselection.items.MediaSelectionItem$Reddit r1 = new editor.mediaselection.items.MediaSelectionItem$Reddit
            r1.<init>(r0)
            r10.add(r1)
            goto L_0x00e5
        L_0x00fa:
            java.util.List r10 = (java.util.List) r10
            goto L_0x01cb
        L_0x00fe:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        L_0x0104:
            com.google.gson.Gson r9 = new com.google.gson.Gson
            r9.<init>()
            java.lang.Class<java.util.List> r1 = java.util.List.class
            java.lang.reflect.Type r1 = (java.lang.reflect.Type) r1
            java.lang.reflect.Type[] r2 = new java.lang.reflect.Type[r3]
            java.lang.Class<com.memes.network.memes.api.model.stockmemes.StockMeme> r4 = com.memes.network.memes.api.model.stockmemes.StockMeme.class
            java.lang.reflect.Type r4 = (java.lang.reflect.Type) r4
            r2[r6] = r4
            com.google.gson.reflect.TypeToken r1 = com.google.gson.reflect.TypeToken.getParameterized(r1, r2)
            java.lang.String r2 = "TypeToken.getParameteriz…a, StockMeme::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.reflect.Type r1 = r1.getType()
            java.lang.Object r9 = r9.fromJson((java.lang.String) r10, (java.lang.reflect.Type) r1)
            java.lang.String r10 = "Gson().fromJson<List<Sto…::class.java).type\n\t\t\t\t\t)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.Collection r10 = (java.util.Collection) r10
            java.util.Iterator r9 = r9.iterator()
        L_0x0138:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto L_0x0150
            java.lang.Object r1 = r9.next()
            r2 = r1
            com.memes.network.memes.api.model.stockmemes.StockMeme r2 = (com.memes.network.memes.api.model.stockmemes.StockMeme) r2
            boolean r2 = r2.isInvalid()
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x0138
            r10.add(r1)
            goto L_0x0138
        L_0x0150:
            java.util.List r10 = (java.util.List) r10
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r9 = new java.util.ArrayList
            int r0 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r10, r0)
            r9.<init>(r0)
            java.util.Collection r9 = (java.util.Collection) r9
            java.util.Iterator r10 = r10.iterator()
        L_0x0163:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L_0x0178
            java.lang.Object r0 = r10.next()
            com.memes.network.memes.api.model.stockmemes.StockMeme r0 = (com.memes.network.memes.api.model.stockmemes.StockMeme) r0
            editor.mediaselection.items.MediaSelectionItem$Meme r1 = new editor.mediaselection.items.MediaSelectionItem$Meme
            r1.<init>(r0)
            r9.add(r1)
            goto L_0x0163
        L_0x0178:
            r10 = r9
            java.util.List r10 = (java.util.List) r10
            goto L_0x01cb
        L_0x017c:
            com.google.gson.Gson r9 = new com.google.gson.Gson
            r9.<init>()
            java.lang.Class<java.util.List> r1 = java.util.List.class
            java.lang.reflect.Type r1 = (java.lang.reflect.Type) r1
            java.lang.reflect.Type[] r2 = new java.lang.reflect.Type[r3]
            java.lang.Class<com.memes.network.giphy.api.model.GiphyGif> r4 = com.memes.network.giphy.api.model.GiphyGif.class
            java.lang.reflect.Type r4 = (java.lang.reflect.Type) r4
            r2[r6] = r4
            com.google.gson.reflect.TypeToken r1 = com.google.gson.reflect.TypeToken.getParameterized(r1, r2)
            java.lang.String r2 = "TypeToken.getParameteriz…va, GiphyGif::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.reflect.Type r1 = r1.getType()
            java.lang.Object r9 = r9.fromJson((java.lang.String) r10, (java.lang.reflect.Type) r1)
            java.lang.String r10 = "Gson().fromJson<List<Gip…::class.java).type\n\t\t\t\t\t)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r10 = new java.util.ArrayList
            int r0 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r9, r0)
            r10.<init>(r0)
            java.util.Collection r10 = (java.util.Collection) r10
            java.util.Iterator r9 = r9.iterator()
        L_0x01b4:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x01c9
            java.lang.Object r0 = r9.next()
            com.memes.network.giphy.api.model.GiphyGif r0 = (com.memes.network.giphy.api.model.GiphyGif) r0
            editor.mediaselection.items.MediaSelectionItem$Giphy r1 = new editor.mediaselection.items.MediaSelectionItem$Giphy
            r1.<init>(r0)
            r10.add(r1)
            goto L_0x01b4
        L_0x01c9:
            java.util.List r10 = (java.util.List) r10
        L_0x01cb:
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Collection r9 = (java.util.Collection) r9
            java.util.Iterator r10 = r10.iterator()
        L_0x01d8:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L_0x01f2
            java.lang.Object r0 = r10.next()
            r1 = r0
            editor.mediaselection.items.MediaSelectionItem r1 = (editor.mediaselection.items.MediaSelectionItem) r1
            java.util.List<editor.mediaselection.items.MediaSelectionItem> r2 = r8.selectedItemsList
            boolean r1 = r2.contains(r1)
            r1 = r1 ^ r3
            if (r1 == 0) goto L_0x01d8
            r9.add(r0)
            goto L_0x01d8
        L_0x01f2:
            java.util.List r9 = (java.util.List) r9
            java.util.List<editor.mediaselection.items.MediaSelectionItem> r10 = r8.selectedItemsList
            r0 = r9
            java.util.Collection r0 = (java.util.Collection) r0
            r10.addAll(r0)
            androidx.lifecycle.MutableLiveData<java.util.List<editor.mediaselection.items.MediaSelectionItem>> r10 = r8._mediaItemsSelected
            r10.setValue(r9)
        L_0x0201:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.mediaselection.items.MediaSelectionItemsViewModel.handleTargetedMediaSelectionResult(editor.mediaselection.targetedmediabrowser.MediaSelectionTarget, kotlin.Pair):void");
    }
}
