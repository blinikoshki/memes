package editor.mediaselection;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.memes.commons.activity.ContractLauncher;
import com.memes.commons.media.MediaContent;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NMediaSelectionActivityBinding;
import com.memes.network.giphy.api.model.GiphyGif;
import com.memes.network.memes.api.model.stockmemes.StockMeme;
import com.memes.network.reddit.api.model.RedditPost;
import editor.core.ItemCountChangeListener;
import editor.core.NicoActivity;
import editor.custom.mediacategoryview.MediaCategoryView;
import editor.mediaselection.giphygifs.GiphyGifsHorizontalSelectionAdapter;
import editor.mediaselection.items.MediaSelectionItemsAdapter;
import editor.mediaselection.items.MediaSelectionItemsViewModel;
import editor.mediaselection.localmedia.IdBasedMedia;
import editor.mediaselection.localmedia.LocalMedia;
import editor.mediaselection.localmedia.LocalMediaExtKt;
import editor.mediaselection.localmedia.LocalMediaHorizontalSelectionAdapter;
import editor.mediaselection.paints.ColorsHorizontalSelectionAdapter;
import editor.mediaselection.paints.GradientsHorizontalSelectionAdapter;
import editor.mediaselection.paints.PatternsHorizontalSelectionAdapter;
import editor.mediaselection.redditposts.RedditPostsHorizontalSelectionAdapter;
import editor.mediaselection.stockmemes.StockMemesHorizontalSelectionAdapter;
import editor.mediaselection.targetedmediabrowser.TargetedMediaSelectionActivityContract;
import editor.mediaselection.targetedmediabrowser.TargetedMediaSelectionConfig;
import editor.optionsui.addcontent.contentpicker.ContentPickerActivityContract;
import editor.optionsui.addcontent.contentpicker.ContentPickerTarget;
import editor.optionsui.addcontent.contentpicker.ContentResolverActivityContract;
import editor.optionsui.frame.frameresize.FrameSize;
import editor.optionsui.layerpaint.LayerPaint;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;
import tools.activityproxy.ActivityExtra;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 ~2\u00020\u00012\u00020\u0002:\u0001~B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010N\u001a\u00020OH\u0002J\b\u0010P\u001a\u00020OH\u0002J\b\u0010Q\u001a\u00020OH\u0002J\b\u0010R\u001a\u00020OH\u0002J\b\u0010S\u001a\u00020OH\u0002J\b\u0010T\u001a\u00020OH\u0002J\b\u0010U\u001a\u00020OH\u0002J\b\u0010V\u001a\u00020OH\u0002J\u0012\u0010W\u001a\u00020O2\b\u0010X\u001a\u0004\u0018\u00010YH\u0014J\u001e\u0010Z\u001a\u00020O2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020]0\\2\u0006\u0010^\u001a\u00020_H\u0016J\u0018\u0010`\u001a\u00020\u00162\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\u0016H\u0002J\u0010\u0010d\u001a\u00020O2\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010e\u001a\u00020O2\u0006\u0010f\u001a\u00020\u0013H\u0002J\u0010\u0010g\u001a\u00020O2\u0006\u0010a\u001a\u00020bH\u0002J\u0018\u0010h\u001a\u00020O2\u000e\u0010i\u001a\n\u0012\u0004\u0012\u00020k\u0018\u00010jH\u0002J\u0018\u0010l\u001a\u00020O2\u000e\u0010m\u001a\n\u0012\u0004\u0012\u00020n\u0018\u00010jH\u0002J\u0018\u0010o\u001a\u00020O2\u000e\u0010p\u001a\n\u0012\u0004\u0012\u00020q\u0018\u00010jH\u0002J\u0018\u0010r\u001a\u00020O2\u000e\u0010s\u001a\n\u0012\u0004\u0012\u00020t\u0018\u00010jH\u0002J\u0018\u0010u\u001a\u00020O2\u000e\u0010v\u001a\n\u0012\u0004\u0012\u00020b\u0018\u00010jH\u0002J\u0018\u0010w\u001a\u00020O2\u000e\u0010x\u001a\n\u0012\u0004\u0012\u00020y\u0018\u00010jH\u0002J\u0018\u0010z\u001a\u00020O2\u000e\u0010{\u001a\n\u0012\u0004\u0012\u00020|\u0018\u00010jH\u0002J\u0018\u0010}\u001a\u00020O2\u000e\u0010v\u001a\n\u0012\u0004\u0012\u00020b\u0018\u00010jH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u001c\u0012\u0004\u0012\u00020\u0013\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00160\u00140\u0012X\u0004¢\u0006\u0002\n\u0000R(\u0010\u0017\u001a\u001c\u0012\u0004\u0012\u00020\u0015\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00160\u00140\u0012X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\t\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\t\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020#8BX\u0002¢\u0006\f\n\u0004\b&\u0010\t\u001a\u0004\b$\u0010%R\u001b\u0010'\u001a\u00020(8BX\u0002¢\u0006\f\n\u0004\b+\u0010\t\u001a\u0004\b)\u0010*R\u001b\u0010,\u001a\u00020-8BX\u0002¢\u0006\f\n\u0004\b0\u0010\t\u001a\u0004\b.\u0010/R\u001b\u00101\u001a\u0002028BX\u0002¢\u0006\f\n\u0004\b5\u0010\t\u001a\u0004\b3\u00104R\u001b\u00106\u001a\u0002078BX\u0002¢\u0006\f\n\u0004\b:\u0010\t\u001a\u0004\b8\u00109R*\u0010;\u001a\u001e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\u00150<j\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\u0015`>X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010?\u001a\u00020@8BX\u0002¢\u0006\f\n\u0004\bC\u0010\t\u001a\u0004\bA\u0010BR,\u0010D\u001a \u0012\u0004\u0012\u00020E\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010=\u0012\u0006\u0012\u0004\u0018\u00010=\u0018\u00010\u00140\u0012X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010F\u001a\u0002028BX\u0002¢\u0006\f\n\u0004\bH\u0010\t\u001a\u0004\bG\u00104R\u001b\u0010I\u001a\u00020J8BX\u0002¢\u0006\f\n\u0004\bM\u0010\t\u001a\u0004\bK\u0010L¨\u0006"}, mo26107d2 = {"Leditor/mediaselection/MediaSelectionActivity;", "Leditor/core/NicoActivity;", "Leditor/core/ItemCountChangeListener;", "()V", "binding", "Lcom/memes/editor/databinding/NMediaSelectionActivityBinding;", "getBinding", "()Lcom/memes/editor/databinding/NMediaSelectionActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "colorsAdapter", "Leditor/mediaselection/paints/ColorsHorizontalSelectionAdapter;", "getColorsAdapter", "()Leditor/mediaselection/paints/ColorsHorizontalSelectionAdapter;", "colorsAdapter$delegate", "config", "Leditor/mediaselection/MediaSelectionConfig;", "contentPickerContractLauncher", "Lcom/memes/commons/activity/ContractLauncher;", "Leditor/optionsui/addcontent/contentpicker/ContentPickerTarget;", "Lkotlin/Pair;", "Lcom/memes/commons/media/MediaContent;", "", "contentResolverContract", "giphyGifsAdapter", "Leditor/mediaselection/giphygifs/GiphyGifsHorizontalSelectionAdapter;", "getGiphyGifsAdapter", "()Leditor/mediaselection/giphygifs/GiphyGifsHorizontalSelectionAdapter;", "giphyGifsAdapter$delegate", "gradientsAdapter", "Leditor/mediaselection/paints/GradientsHorizontalSelectionAdapter;", "getGradientsAdapter", "()Leditor/mediaselection/paints/GradientsHorizontalSelectionAdapter;", "gradientsAdapter$delegate", "mediaImportViewModel", "Leditor/mediaselection/MediaImportViewModel;", "getMediaImportViewModel", "()Leditor/mediaselection/MediaImportViewModel;", "mediaImportViewModel$delegate", "mediaSelectionItemsAdapter", "Leditor/mediaselection/items/MediaSelectionItemsAdapter;", "getMediaSelectionItemsAdapter", "()Leditor/mediaselection/items/MediaSelectionItemsAdapter;", "mediaSelectionItemsAdapter$delegate", "patternsAdapter", "Leditor/mediaselection/paints/PatternsHorizontalSelectionAdapter;", "getPatternsAdapter", "()Leditor/mediaselection/paints/PatternsHorizontalSelectionAdapter;", "patternsAdapter$delegate", "photosAdapter", "Leditor/mediaselection/localmedia/LocalMediaHorizontalSelectionAdapter;", "getPhotosAdapter", "()Leditor/mediaselection/localmedia/LocalMediaHorizontalSelectionAdapter;", "photosAdapter$delegate", "redditPostsAdapter", "Leditor/mediaselection/redditposts/RedditPostsHorizontalSelectionAdapter;", "getRedditPostsAdapter", "()Leditor/mediaselection/redditposts/RedditPostsHorizontalSelectionAdapter;", "redditPostsAdapter$delegate", "resolvedMediaContentsMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "stockMemesAdapter", "Leditor/mediaselection/stockmemes/StockMemesHorizontalSelectionAdapter;", "getStockMemesAdapter", "()Leditor/mediaselection/stockmemes/StockMemesHorizontalSelectionAdapter;", "stockMemesAdapter$delegate", "targetedMediaSelectionContractLauncher", "Leditor/mediaselection/targetedmediabrowser/TargetedMediaSelectionConfig;", "videosAdapter", "getVideosAdapter", "videosAdapter$delegate", "viewModel", "Leditor/mediaselection/items/MediaSelectionItemsViewModel;", "getViewModel", "()Leditor/mediaselection/items/MediaSelectionItemsViewModel;", "viewModel$delegate", "initColorsGradientsSelection", "", "initGiphyGifsSelection", "initPatternsSelection", "initPhotosSelection", "initRedditPostsSelection", "initSelectedMediaCategory", "initStockMemesSelection", "initVideosSelection", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onItemCountChanged", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "count", "", "onLocalMediaSelectionChanged", "localMedia", "Leditor/mediaselection/localmedia/LocalMedia;", "selected", "onSelectedMediaItemCountChanged", "pickContent", "target", "resolveContent", "showColors", "colors", "", "Leditor/optionsui/layerpaint/LayerPaint$Color;", "showGiphyGifs", "gifs", "Lcom/memes/network/giphy/api/model/GiphyGif;", "showGradients", "gradients", "Leditor/optionsui/layerpaint/LayerPaint$Gradient;", "showPatterns", "patterns", "Leditor/optionsui/layerpaint/LayerPaint$Pattern;", "showPhotos", "contents", "showRedditPosts", "posts", "Lcom/memes/network/reddit/api/model/RedditPost;", "showStockMemes", "memes", "Lcom/memes/network/memes/api/model/stockmemes/StockMeme;", "showVideos", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaSelectionActivity.kt */
public final class MediaSelectionActivity extends NicoActivity implements ItemCountChangeListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Lazy binding$delegate = LazyKt.lazy(new MediaSelectionActivity$binding$2(this));
    private final Lazy colorsAdapter$delegate = LazyKt.lazy(new MediaSelectionActivity$colorsAdapter$2(this));
    /* access modifiers changed from: private */
    public MediaSelectionConfig config = new MediaSelectionConfig(0, (List) null, false, 7, (DefaultConstructorMarker) null);
    private final ContractLauncher<ContentPickerTarget, Pair<MediaContent, Boolean>> contentPickerContractLauncher = new ContractLauncher<>(new ContentPickerActivityContract());
    private final ContractLauncher<MediaContent, Pair<MediaContent, Boolean>> contentResolverContract = new ContractLauncher<>(new ContentResolverActivityContract());
    private final Lazy giphyGifsAdapter$delegate = LazyKt.lazy(new MediaSelectionActivity$giphyGifsAdapter$2(this));
    private final Lazy gradientsAdapter$delegate = LazyKt.lazy(new MediaSelectionActivity$gradientsAdapter$2(this));
    private final Lazy mediaImportViewModel$delegate = LazyKt.lazy(new MediaSelectionActivity$mediaImportViewModel$2(this));
    private final Lazy mediaSelectionItemsAdapter$delegate = LazyKt.lazy(new MediaSelectionActivity$mediaSelectionItemsAdapter$2(this));
    private final Lazy patternsAdapter$delegate = LazyKt.lazy(new MediaSelectionActivity$patternsAdapter$2(this));
    private final Lazy photosAdapter$delegate = LazyKt.lazy(new MediaSelectionActivity$photosAdapter$2(this));
    private final Lazy redditPostsAdapter$delegate = LazyKt.lazy(new MediaSelectionActivity$redditPostsAdapter$2(this));
    /* access modifiers changed from: private */
    public final HashMap<String, MediaContent> resolvedMediaContentsMap = new HashMap<>();
    private final Lazy stockMemesAdapter$delegate = LazyKt.lazy(new MediaSelectionActivity$stockMemesAdapter$2(this));
    /* access modifiers changed from: private */
    public final ContractLauncher<TargetedMediaSelectionConfig, Pair<String, String>> targetedMediaSelectionContractLauncher = new ContractLauncher<>(new TargetedMediaSelectionActivityContract());
    private final Lazy videosAdapter$delegate = LazyKt.lazy(new MediaSelectionActivity$videosAdapter$2(this));
    private final Lazy viewModel$delegate = LazyKt.lazy(new MediaSelectionActivity$viewModel$2(this));

    /* access modifiers changed from: private */
    public final NMediaSelectionActivityBinding getBinding() {
        return (NMediaSelectionActivityBinding) this.binding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ColorsHorizontalSelectionAdapter getColorsAdapter() {
        return (ColorsHorizontalSelectionAdapter) this.colorsAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final GiphyGifsHorizontalSelectionAdapter getGiphyGifsAdapter() {
        return (GiphyGifsHorizontalSelectionAdapter) this.giphyGifsAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final GradientsHorizontalSelectionAdapter getGradientsAdapter() {
        return (GradientsHorizontalSelectionAdapter) this.gradientsAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final MediaImportViewModel getMediaImportViewModel() {
        return (MediaImportViewModel) this.mediaImportViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final MediaSelectionItemsAdapter getMediaSelectionItemsAdapter() {
        return (MediaSelectionItemsAdapter) this.mediaSelectionItemsAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final PatternsHorizontalSelectionAdapter getPatternsAdapter() {
        return (PatternsHorizontalSelectionAdapter) this.patternsAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final LocalMediaHorizontalSelectionAdapter getPhotosAdapter() {
        return (LocalMediaHorizontalSelectionAdapter) this.photosAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final RedditPostsHorizontalSelectionAdapter getRedditPostsAdapter() {
        return (RedditPostsHorizontalSelectionAdapter) this.redditPostsAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final StockMemesHorizontalSelectionAdapter getStockMemesAdapter() {
        return (StockMemesHorizontalSelectionAdapter) this.stockMemesAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final LocalMediaHorizontalSelectionAdapter getVideosAdapter() {
        return (LocalMediaHorizontalSelectionAdapter) this.videosAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final MediaSelectionItemsViewModel getViewModel() {
        return (MediaSelectionItemsViewModel) this.viewModel$delegate.getValue();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, mo26107d2 = {"Leditor/mediaselection/MediaSelectionActivity$Companion;", "", "()V", "getStartIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "selectionConfig", "Leditor/mediaselection/MediaSelectionConfig;", "frameSize", "Leditor/optionsui/frame/frameresize/FrameSize;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MediaSelectionActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent getStartIntent(Context context, MediaSelectionConfig mediaSelectionConfig) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(mediaSelectionConfig, "selectionConfig");
            Intent intent = new Intent(context, MediaSelectionActivity.class);
            intent.putExtra("intent_extra_media_selection_config", mediaSelectionConfig);
            return intent;
        }

        public final Intent getStartIntent(Context context, MediaSelectionConfig mediaSelectionConfig, FrameSize frameSize) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(mediaSelectionConfig, "selectionConfig");
            Intrinsics.checkNotNullParameter(frameSize, "frameSize");
            Intent startIntent = getStartIntent(context, mediaSelectionConfig);
            startIntent.putExtra(ActivityExtra.FRAME_SIZE, frameSize);
            return startIntent;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        MediaSelectionConfig mediaSelectionConfig;
        super.onCreate(bundle);
        NMediaSelectionActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        registerViewModel(getViewModel(), getMediaImportViewModel());
        AppCompatActivity appCompatActivity = this;
        this.contentPickerContractLauncher.register(appCompatActivity);
        this.contentResolverContract.register(appCompatActivity);
        this.targetedMediaSelectionContractLauncher.register(appCompatActivity);
        Intent intent = getIntent();
        if (intent == null || (mediaSelectionConfig = (MediaSelectionConfig) intent.getParcelableExtra("intent_extra_media_selection_config")) == null) {
            mediaSelectionConfig = this.config;
        }
        this.config = mediaSelectionConfig;
        getViewModel().onMediaSelectionConfigChanged(this.config);
        initColorsGradientsSelection();
        initPatternsSelection();
        initPhotosSelection();
        initVideosSelection();
        initGiphyGifsSelection();
        initStockMemesSelection();
        initRedditPostsSelection();
        initSelectedMediaCategory();
        getBinding().backImageView.setOnClickListener(new MediaSelectionActivity$onCreate$1(this));
        LifecycleOwner lifecycleOwner = this;
        getViewModel().onColorsAvailable().observe(lifecycleOwner, new MediaSelectionActivity$onCreate$2(this));
        getViewModel().onGradientsAvailable().observe(lifecycleOwner, new MediaSelectionActivity$onCreate$3(this));
        getViewModel().onPatternsAvailable().observe(lifecycleOwner, new MediaSelectionActivity$onCreate$4(this));
        getViewModel().onPhotosAvailable().observe(lifecycleOwner, new MediaSelectionActivity$onCreate$5(this));
        getViewModel().onVideosAvailable().observe(lifecycleOwner, new MediaSelectionActivity$onCreate$6(this));
        getViewModel().onGiphyGifsAvailable().observe(lifecycleOwner, new MediaSelectionActivity$onCreate$7(this));
        getViewModel().onStockMemesAvailable().observe(lifecycleOwner, new MediaSelectionActivity$onCreate$8(this));
        getViewModel().onRedditPostsAvailable().observe(lifecycleOwner, new MediaSelectionActivity$onCreate$9(this));
        getViewModel().onMediaItemsSelected().observe(lifecycleOwner, new MediaSelectionActivity$onCreate$10(this));
        getViewModel().onMediaItemsUnselected().observe(lifecycleOwner, new MediaSelectionActivity$onCreate$11(this));
        getViewModel().onTargetedMediaSelectionConfigAvailable().observe(lifecycleOwner, new MediaSelectionActivity$onCreate$12(this));
        getMediaImportViewModel().onContentsDownloaded().observe(lifecycleOwner, new MediaSelectionActivity$onCreate$13(this));
        getMediaImportViewModel().onContentDownloadFailed().observe(lifecycleOwner, new MediaSelectionActivity$onCreate$14(this));
    }

    private final void initColorsGradientsSelection() {
        String string = getString(C4175R.string.media_selection_colors);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.media_selection_colors)");
        String string2 = getString(C4175R.string.media_selection_gradients);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.media_selection_gradients)");
        getBinding().colorsGradientsCategoryView.setTabs(CollectionsKt.listOf(string, string2), new MediaSelectionActivity$initColorsGradientsSelection$1(this, string, string2));
        getBinding().colorsGradientsCategoryView.setAdapter(getColorsAdapter());
    }

    private final void initPatternsSelection() {
        getBinding().patternsCategoryView.setAdapter(getPatternsAdapter());
    }

    private final void initPhotosSelection() {
        getBinding().photosCategoryView.setAdapter(getPhotosAdapter());
        getBinding().photosCategoryView.setOnActionButtonClickListener(new MediaSelectionActivity$initPhotosSelection$1(this));
    }

    private final void initVideosSelection() {
        getBinding().videosCategoryView.setAdapter(getVideosAdapter());
        getBinding().videosCategoryView.setOnActionButtonClickListener(new MediaSelectionActivity$initVideosSelection$1(this));
    }

    private final void initGiphyGifsSelection() {
        getBinding().giphyCategoryView.setAdapter(getGiphyGifsAdapter());
        getBinding().giphyCategoryView.setOnActionButtonClickListener(new MediaSelectionActivity$initGiphyGifsSelection$1(this));
    }

    private final void initStockMemesSelection() {
        getBinding().memesCategoryView.setAdapter(getStockMemesAdapter());
        getBinding().memesCategoryView.setOnActionButtonClickListener(new MediaSelectionActivity$initStockMemesSelection$1(this));
    }

    private final void initRedditPostsSelection() {
        getBinding().redditCategoryView.setAdapter(getRedditPostsAdapter());
        getBinding().redditCategoryView.setOnActionButtonClickListener(new MediaSelectionActivity$initRedditPostsSelection$1(this));
    }

    private final void initSelectedMediaCategory() {
        getMediaSelectionItemsAdapter().setItemCountChangeListener(this);
        getBinding().selectedMediaCategoryView.setAdapter(getMediaSelectionItemsAdapter());
        getBinding().selectedMediaCategoryView.setOnActionButtonClickListener(new MediaSelectionActivity$initSelectedMediaCategory$1(this));
    }

    /* access modifiers changed from: private */
    public final void showColors(List<LayerPaint.Color> list) {
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            MediaCategoryView.showError$default(getBinding().colorsGradientsCategoryView, (String) null, new MediaSelectionActivity$showColors$1(this), 1, (Object) null);
            return;
        }
        getColorsAdapter().setItems(list);
        getBinding().colorsGradientsCategoryView.showContent();
    }

    /* access modifiers changed from: private */
    public final void showGradients(List<LayerPaint.Gradient> list) {
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            MediaCategoryView.showError$default(getBinding().colorsGradientsCategoryView, (String) null, new MediaSelectionActivity$showGradients$1(this), 1, (Object) null);
            return;
        }
        getGradientsAdapter().setItems(list);
        getBinding().colorsGradientsCategoryView.showContent();
    }

    /* access modifiers changed from: private */
    public final void showPatterns(List<LayerPaint.Pattern> list) {
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            MediaCategoryView.showError$default(getBinding().patternsCategoryView, (String) null, new MediaSelectionActivity$showPatterns$1(this), 1, (Object) null);
            return;
        }
        getPatternsAdapter().setItems(list);
        getBinding().patternsCategoryView.showContent();
    }

    /* access modifiers changed from: private */
    public final void showPhotos(List<LocalMedia> list) {
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            MediaCategoryView.showError$default(getBinding().photosCategoryView, (String) null, new MediaSelectionActivity$showPhotos$1(this), 1, (Object) null);
            return;
        }
        getPhotosAdapter().setItems(list);
        getBinding().photosCategoryView.showContent();
    }

    /* access modifiers changed from: private */
    public final void showVideos(List<LocalMedia> list) {
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            MediaCategoryView.showError$default(getBinding().videosCategoryView, (String) null, new MediaSelectionActivity$showVideos$1(this), 1, (Object) null);
            return;
        }
        getVideosAdapter().setItems(list);
        getBinding().videosCategoryView.showContent();
    }

    /* access modifiers changed from: private */
    public final void showGiphyGifs(List<GiphyGif> list) {
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            MediaCategoryView.showError$default(getBinding().giphyCategoryView, (String) null, new MediaSelectionActivity$showGiphyGifs$1(this), 1, (Object) null);
            return;
        }
        getGiphyGifsAdapter().setItems(list);
        getBinding().giphyCategoryView.showContent();
    }

    /* access modifiers changed from: private */
    public final void showStockMemes(List<StockMeme> list) {
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            MediaCategoryView.showError$default(getBinding().memesCategoryView, (String) null, new MediaSelectionActivity$showStockMemes$1(this), 1, (Object) null);
            return;
        }
        getStockMemesAdapter().setItems(list);
        getBinding().memesCategoryView.showContent();
    }

    /* access modifiers changed from: private */
    public final void showRedditPosts(List<RedditPost> list) {
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            MediaCategoryView.showError$default(getBinding().redditCategoryView, (String) null, new MediaSelectionActivity$showRedditPosts$1(this), 1, (Object) null);
            return;
        }
        getRedditPostsAdapter().setItems(list);
        getBinding().redditCategoryView.showContent();
    }

    private final void onSelectedMediaItemCountChanged(int i) {
        boolean z = true;
        int i2 = 0;
        boolean z2 = i > 0;
        MediaCategoryView mediaCategoryView = getBinding().selectedMediaCategoryView;
        Intrinsics.checkNotNullExpressionValue(mediaCategoryView, "binding.selectedMediaCategoryView");
        if (mediaCategoryView.getVisibility() != 0) {
            z = false;
        }
        if (z != z2) {
            MediaCategoryView mediaCategoryView2 = getBinding().selectedMediaCategoryView;
            Intrinsics.checkNotNullExpressionValue(mediaCategoryView2, "binding.selectedMediaCategoryView");
            if (!z2) {
                i2 = 8;
            }
            mediaCategoryView2.setVisibility(i2);
        }
        if (i > 0) {
            getBinding().selectedMediaCategoryView.getRecyclerView().smoothScrollToPosition(i);
            MediaCategoryView mediaCategoryView3 = getBinding().selectedMediaCategoryView;
            mediaCategoryView3.setTitle("Selected Items (" + i + ')');
        } else {
            getBinding().selectedMediaCategoryView.setTitle("Selected Items");
        }
        getBinding().selectedMediaCategoryView.showContent();
    }

    public void onItemCountChanged(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter, int i) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        if (adapter instanceof MediaSelectionItemsAdapter) {
            onSelectedMediaItemCountChanged(i);
        }
    }

    /* access modifiers changed from: private */
    public final void pickContent(ContentPickerTarget contentPickerTarget) {
        Timber.m300d("~> pick-content: " + contentPickerTarget, new Object[0]);
        this.contentPickerContractLauncher.launch(contentPickerTarget, new MediaSelectionActivity$pickContent$1(this));
    }

    /* access modifiers changed from: private */
    public final boolean onLocalMediaSelectionChanged(LocalMedia localMedia, boolean z) {
        if (!z) {
            return getViewModel().setLocalMediaSelected(localMedia, z);
        }
        MediaContent mediaContent = this.resolvedMediaContentsMap.get(localMedia.getIdentifier());
        if (mediaContent != null) {
            return getViewModel().setIdBasedMediaSelected(new IdBasedMedia(localMedia.getIdentifier(), mediaContent), z);
        }
        resolveContent(localMedia);
        return false;
    }

    private final void resolveContent(LocalMedia localMedia) {
        Timber.m300d("~> media-selection resolve-content: " + localMedia, new Object[0]);
        this.contentResolverContract.launch(LocalMediaExtKt.toIdBasedMedia(localMedia).getContent(), new MediaSelectionActivity$resolveContent$1(this, localMedia));
    }
}
