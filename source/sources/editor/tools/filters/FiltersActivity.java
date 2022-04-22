package editor.tools.filters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.p024ui.PlayerView;
import com.memes.commons.media.MediaContent;
import com.memes.commons.media.MediaFile;
import com.memes.commons.util.ExtensionsKt;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NFiltersActivityBinding;
import editor.common.commonslider.CommonSliderInput;
import editor.common.commonslider.CommonSliderViewModel;
import editor.common.mediaplayback.MediaPlaybackOrganiser;
import editor.core.NEditorPlanAwareActivity;
import editor.custom.liveevent.LiveEventObserver;
import editor.gpu.conflation.GlConflatedFilter;
import editor.gpu.gpuimage.GPUImageView;
import editor.gpu.gpuimage.filter.GlPhotoFilter;
import editor.gpu.gpuvideo.egl.filter.GlVideoFilter;
import editor.gpu.gpuvideo.player.GPUPlayerView;
import editor.tools.filters.basicfilters.BasicFiltersViewModel;
import editor.tools.filters.conflation.FilterRequest;
import editor.tools.filters.deepfryfilters.DeepFryFiltersViewModel;
import editor.tools.filters.helpers.MediaImageFilterManager;
import editor.tools.filters.helpers.MediaVideoFilterManager;
import editor.tools.filters.mediaenhance.MediaEnhanceViewModel;
import editor.tools.filters.tabs.MediaFilterTabAction;
import editor.tools.filters.tabs.MediaFilterTabsViewModel;
import editor.transporter.FragmentManagerUtil;
import editor.util.FloatRange;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 {2\u00020\u0001:\u0001{B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0002J\u0018\u0010C\u001a\u00020@2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010H\u001a\u00020@2\u0006\u0010A\u001a\u00020IH\u0002J\u0018\u0010H\u001a\u00020@2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010J\u001a\u00020@2\u0006\u0010A\u001a\u00020KH\u0002J\u0018\u0010J\u001a\u00020@2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0002J\b\u0010L\u001a\u00020@H\u0002J\n\u0010M\u001a\u0004\u0018\u00010(H\u0002J\u0006\u0010N\u001a\u00020OJ\u0010\u0010P\u001a\u00020@2\u0006\u0010Q\u001a\u00020OH\u0002J\b\u0010R\u001a\u00020@H\u0016J\u0012\u0010S\u001a\u00020@2\b\u0010T\u001a\u0004\u0018\u00010UH\u0014J\b\u0010V\u001a\u00020@H\u0014J\b\u0010W\u001a\u00020@H\u0014J\b\u0010X\u001a\u00020@H\u0014J\b\u0010Y\u001a\u00020@H\u0002J\u0010\u0010Z\u001a\u00020@2\u0006\u0010[\u001a\u00020\\H\u0002J\u0010\u0010]\u001a\u00020@2\u0006\u0010A\u001a\u00020^H\u0002J\u0010\u0010_\u001a\u00020@2\u0006\u0010`\u001a\u00020aH\u0002J\u0018\u0010b\u001a\u00020@2\u0006\u0010c\u001a\u00020G2\u0006\u0010d\u001a\u00020GH\u0002J\u0018\u0010e\u001a\u00020@2\u0006\u0010f\u001a\u00020G2\u0006\u0010g\u001a\u00020GH\u0002J\u0010\u0010h\u001a\u00020@2\u0006\u0010i\u001a\u00020jH\u0002J\u0018\u0010k\u001a\u00020@2\u0006\u0010l\u001a\u00020G2\u0006\u0010m\u001a\u00020GH\u0002J\u0018\u0010n\u001a\u00020@2\u0006\u0010o\u001a\u00020G2\u0006\u0010p\u001a\u00020GH\u0002J\u0018\u0010q\u001a\u00020@2\u0006\u0010r\u001a\u00020G2\u0006\u0010s\u001a\u00020GH\u0002J\u0018\u0010t\u001a\u00020@2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020xH\u0002J\u0010\u0010y\u001a\u00020@2\u0006\u0010i\u001a\u00020zH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\b\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020#8BX\u0002¢\u0006\f\n\u0004\b&\u0010\b\u001a\u0004\b$\u0010%R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020*8BX\u0002¢\u0006\f\n\u0004\b-\u0010\b\u001a\u0004\b+\u0010,R\u001b\u0010.\u001a\u00020/8BX\u0002¢\u0006\f\n\u0004\b2\u0010\b\u001a\u0004\b0\u00101R\u001b\u00103\u001a\u0002048BX\u0002¢\u0006\f\n\u0004\b7\u0010\b\u001a\u0004\b5\u00106R\u000e\u00108\u001a\u000209X.¢\u0006\u0002\n\u0000R\u001b\u0010:\u001a\u00020;8BX\u0002¢\u0006\f\n\u0004\b>\u0010\b\u001a\u0004\b<\u0010=¨\u0006|"}, mo26107d2 = {"Leditor/tools/filters/FiltersActivity;", "Leditor/core/NEditorPlanAwareActivity;", "()V", "basicFiltersViewModel", "Leditor/tools/filters/basicfilters/BasicFiltersViewModel;", "getBasicFiltersViewModel", "()Leditor/tools/filters/basicfilters/BasicFiltersViewModel;", "basicFiltersViewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/memes/editor/databinding/NFiltersActivityBinding;", "getBinding", "()Lcom/memes/editor/databinding/NFiltersActivityBinding;", "binding$delegate", "commonSliderViewModel", "Leditor/common/commonslider/CommonSliderViewModel;", "getCommonSliderViewModel", "()Leditor/common/commonslider/CommonSliderViewModel;", "commonSliderViewModel$delegate", "deepFryFiltersViewModel", "Leditor/tools/filters/deepfryfilters/DeepFryFiltersViewModel;", "getDeepFryFiltersViewModel", "()Leditor/tools/filters/deepfryfilters/DeepFryFiltersViewModel;", "deepFryFiltersViewModel$delegate", "filtersTabsViewModel", "Leditor/tools/filters/tabs/MediaFilterTabsViewModel;", "getFiltersTabsViewModel", "()Leditor/tools/filters/tabs/MediaFilterTabsViewModel;", "filtersTabsViewModel$delegate", "filtersViewModel", "Leditor/tools/filters/FiltersViewModel;", "getFiltersViewModel", "()Leditor/tools/filters/FiltersViewModel;", "filtersViewModel$delegate", "fragmentManagerUtil", "Leditor/transporter/FragmentManagerUtil;", "getFragmentManagerUtil", "()Leditor/transporter/FragmentManagerUtil;", "fragmentManagerUtil$delegate", "gpuPlayerView", "Leditor/gpu/gpuvideo/player/GPUPlayerView;", "imageFilterManager", "Leditor/tools/filters/helpers/MediaImageFilterManager;", "getImageFilterManager", "()Leditor/tools/filters/helpers/MediaImageFilterManager;", "imageFilterManager$delegate", "mediaEnhanceViewModel", "Leditor/tools/filters/mediaenhance/MediaEnhanceViewModel;", "getMediaEnhanceViewModel", "()Leditor/tools/filters/mediaenhance/MediaEnhanceViewModel;", "mediaEnhanceViewModel$delegate", "organiser", "Leditor/common/mediaplayback/MediaPlaybackOrganiser;", "getOrganiser", "()Leditor/common/mediaplayback/MediaPlaybackOrganiser;", "organiser$delegate", "receivedFilterRequest", "Leditor/tools/filters/conflation/FilterRequest;", "videoFilterManager", "Leditor/tools/filters/helpers/MediaVideoFilterManager;", "getVideoFilterManager", "()Leditor/tools/filters/helpers/MediaVideoFilterManager;", "videoFilterManager$delegate", "applyConflatedFilter", "", "filter", "Leditor/gpu/conflation/GlConflatedFilter;", "applyFilter", "filterType", "Leditor/tools/filters/MediaFilterType;", "filterValue", "", "applyImageFilter", "Leditor/gpu/gpuimage/filter/GlPhotoFilter;", "applyVideoFilter", "Leditor/gpu/gpuvideo/egl/filter/GlVideoFilter;", "clearEnhanceFilters", "createGpuPlayer", "getCurrentContentType", "", "handleFilterTrigger", "trigger", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "releaseGpuPlayer", "setContent", "content", "Lcom/memes/commons/media/MediaContent;", "setFilter", "Leditor/tools/filters/MediaFilter;", "setFilterTab", "filterTab", "Leditor/tools/filters/conflation/FilterRequest$FilterTab;", "showBrightnessSlider", "initialBrightness", "defaultBrightness", "showContrastSlider", "initialContrast", "defaultContrast", "showPhoto", "file", "Lcom/memes/commons/media/MediaFile;", "showPixelationSlider", "initialPixelation", "defaultPixelation", "showSaturationSlider", "initialSaturation", "defaultSaturation", "showSharpnessSlider", "initialSharpness", "defaultSharpness", "showSingleSlider", "token", "", "input", "Leditor/common/commonslider/CommonSliderInput;", "showVideo", "Ljava/io/File;", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FiltersActivity.kt */
public abstract class FiltersActivity extends NEditorPlanAwareActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_FILTER_REQUEST = "intent_extra_filter_request";
    public static final String EXTRA_FILTER_RESULT = "intent_extra_filter_result";
    private final Lazy basicFiltersViewModel$delegate = LazyKt.lazy(new FiltersActivity$basicFiltersViewModel$2(this));
    private final Lazy binding$delegate = LazyKt.lazy(new FiltersActivity$binding$2(this));
    private final Lazy commonSliderViewModel$delegate = LazyKt.lazy(new FiltersActivity$commonSliderViewModel$2(this));
    private final Lazy deepFryFiltersViewModel$delegate = LazyKt.lazy(new FiltersActivity$deepFryFiltersViewModel$2(this));
    private final Lazy filtersTabsViewModel$delegate = LazyKt.lazy(new FiltersActivity$filtersTabsViewModel$2(this));
    private final Lazy filtersViewModel$delegate = LazyKt.lazy(new FiltersActivity$filtersViewModel$2(this));
    private final Lazy fragmentManagerUtil$delegate = LazyKt.lazy(new FiltersActivity$fragmentManagerUtil$2(this));
    private GPUPlayerView gpuPlayerView;
    private final Lazy imageFilterManager$delegate = LazyKt.lazy(FiltersActivity$imageFilterManager$2.INSTANCE);
    private final Lazy mediaEnhanceViewModel$delegate = LazyKt.lazy(new FiltersActivity$mediaEnhanceViewModel$2(this));
    private final Lazy organiser$delegate = LazyKt.lazy(FiltersActivity$organiser$2.INSTANCE);
    /* access modifiers changed from: private */
    public FilterRequest receivedFilterRequest;
    private final Lazy videoFilterManager$delegate = LazyKt.lazy(FiltersActivity$videoFilterManager$2.INSTANCE);

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[MediaFilterTabAction.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[MediaFilterTabAction.DONE.ordinal()] = 1;
            iArr[MediaFilterTabAction.CANCEL.ordinal()] = 2;
            int[] iArr2 = new int[MediaFilterType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[MediaFilterType.CONTRAST.ordinal()] = 1;
            iArr2[MediaFilterType.BRIGHTNESS.ordinal()] = 2;
            iArr2[MediaFilterType.SATURATION.ordinal()] = 3;
            iArr2[MediaFilterType.PIXELATION.ordinal()] = 4;
            iArr2[MediaFilterType.SHARPNESS.ordinal()] = 5;
        }
    }

    private final BasicFiltersViewModel getBasicFiltersViewModel() {
        return (BasicFiltersViewModel) this.basicFiltersViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final NFiltersActivityBinding getBinding() {
        return (NFiltersActivityBinding) this.binding$delegate.getValue();
    }

    private final CommonSliderViewModel getCommonSliderViewModel() {
        return (CommonSliderViewModel) this.commonSliderViewModel$delegate.getValue();
    }

    private final DeepFryFiltersViewModel getDeepFryFiltersViewModel() {
        return (DeepFryFiltersViewModel) this.deepFryFiltersViewModel$delegate.getValue();
    }

    private final MediaFilterTabsViewModel getFiltersTabsViewModel() {
        return (MediaFilterTabsViewModel) this.filtersTabsViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final FiltersViewModel getFiltersViewModel() {
        return (FiltersViewModel) this.filtersViewModel$delegate.getValue();
    }

    private final FragmentManagerUtil getFragmentManagerUtil() {
        return (FragmentManagerUtil) this.fragmentManagerUtil$delegate.getValue();
    }

    private final MediaImageFilterManager getImageFilterManager() {
        return (MediaImageFilterManager) this.imageFilterManager$delegate.getValue();
    }

    private final MediaEnhanceViewModel getMediaEnhanceViewModel() {
        return (MediaEnhanceViewModel) this.mediaEnhanceViewModel$delegate.getValue();
    }

    private final MediaPlaybackOrganiser getOrganiser() {
        return (MediaPlaybackOrganiser) this.organiser$delegate.getValue();
    }

    private final MediaVideoFilterManager getVideoFilterManager() {
        return (MediaVideoFilterManager) this.videoFilterManager$delegate.getValue();
    }

    public static final /* synthetic */ FilterRequest access$getReceivedFilterRequest$p(FiltersActivity filtersActivity) {
        FilterRequest filterRequest = filtersActivity.receivedFilterRequest;
        if (filterRequest == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receivedFilterRequest");
        }
        return filterRequest;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Leditor/tools/filters/FiltersActivity$Companion;", "", "()V", "EXTRA_FILTER_REQUEST", "", "EXTRA_FILTER_RESULT", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: FiltersActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NFiltersActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        registerViewModel(getFiltersViewModel());
        getFragmentManagerUtil().showFilterTabsFragment();
        getBinding().backView.setOnClickListener(new FiltersActivity$onCreate$1(this));
        LifecycleOwner lifecycleOwner = this;
        getFiltersTabsViewModel().onFilterTabActionSelected().observe(lifecycleOwner, new FiltersActivity$onCreate$2(this));
        getMediaEnhanceViewModel().onFilterOptionSelected().observe(lifecycleOwner, new LiveEventObserver(new FiltersActivity$onCreate$3(this)));
        getCommonSliderViewModel().onSliderValueUpdated().observe(lifecycleOwner, new FiltersActivity$onCreate$4(this));
        getBasicFiltersViewModel().onFilterSelected().observe(lifecycleOwner, new FiltersActivity$onCreate$5(this));
        getDeepFryFiltersViewModel().onFilterSelected().observe(lifecycleOwner, new FiltersActivity$onCreate$6(this));
        getFiltersViewModel().filterOutput().observe(lifecycleOwner, new FiltersActivity$onCreate$7(this));
        getFiltersViewModel().filterError().observe(lifecycleOwner, new FiltersActivity$onCreate$8(this));
        Intent intent = getIntent();
        FilterRequest filterRequest = intent != null ? (FilterRequest) intent.getParcelableExtra(EXTRA_FILTER_REQUEST) : null;
        if (filterRequest == null) {
            ExtensionsKt.toast((Context) this, "Unable to find the source of filter request, please try again later.");
            finish();
            return;
        }
        this.receivedFilterRequest = filterRequest;
        setContent(filterRequest.getContent());
        setFilter(filterRequest.getFilter());
        setFilterTab(filterRequest.getFilterTab());
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        getOrganiser().pauseSafely();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        getOrganiser().resumeSafely();
    }

    public void onBackPressed() {
        setResult(0, (Intent) null);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        releaseGpuPlayer();
        getOrganiser().releaseSafely();
    }

    public final int getCurrentContentType() {
        FilterRequest filterRequest = this.receivedFilterRequest;
        if (filterRequest == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receivedFilterRequest");
        }
        return filterRequest.getContent().contentType();
    }

    private final void setContent(MediaContent mediaContent) {
        if (mediaContent.isPhoto()) {
            showPhoto(MediaFile.Companion.from(mediaContent));
        } else if (mediaContent.isPlayableVideo()) {
            showVideo(mediaContent.asFile());
        } else {
            throw new RuntimeException("Unknown content-type: " + mediaContent);
        }
        getBasicFiltersViewModel().setContentType(mediaContent.contentType());
        getDeepFryFiltersViewModel().setContentType(mediaContent.contentType());
    }

    private final void showPhoto(MediaFile mediaFile) {
        Timber.m300d("~> showPhoto: file=" + mediaFile, new Object[0]);
        GPUImageView gPUImageView = getBinding().photoView;
        Intrinsics.checkNotNullExpressionValue(gPUImageView, "binding.photoView");
        gPUImageView.setVisibility(0);
        PlayerView playerView = getBinding().videoView;
        Intrinsics.checkNotNullExpressionValue(playerView, "binding.videoView");
        playerView.setVisibility(8);
        GPUImageView gPUImageView2 = getBinding().photoView;
        Uri fromFile = Uri.fromFile(mediaFile);
        Intrinsics.checkExpressionValueIsNotNull(fromFile, "Uri.fromFile(this)");
        gPUImageView2.setImage(fromFile);
        getBinding().photoView.setRatio(mediaFile.getAspectRatio());
        getBinding().photoView.onResume();
    }

    private final void showVideo(File file) {
        Timber.m300d("~> showVideo: file=" + file, new Object[0]);
        GPUImageView gPUImageView = getBinding().photoView;
        Intrinsics.checkNotNullExpressionValue(gPUImageView, "binding.photoView");
        gPUImageView.setVisibility(8);
        PlayerView playerView = getBinding().videoView;
        Intrinsics.checkNotNullExpressionValue(playerView, "binding.videoView");
        playerView.setVisibility(0);
        releaseGpuPlayer();
        getOrganiser().releaseSafely();
        MediaPlaybackOrganiser organiser = getOrganiser();
        Uri fromFile = Uri.fromFile(file);
        PlayerView playerView2 = getBinding().videoView;
        Intrinsics.checkNotNullExpressionValue(playerView2, "binding.videoView");
        organiser.start(fromFile, playerView2);
    }

    private final void setFilter(MediaFilter mediaFilter) {
        GlConflatedFilter appliedConflatedFilter = mediaFilter.getAppliedConflatedFilter();
        if (appliedConflatedFilter != null) {
            applyConflatedFilter(appliedConflatedFilter);
            return;
        }
        applyFilter(MediaFilterType.CONTRAST, mediaFilter.getAppliedContrast());
        applyFilter(MediaFilterType.BRIGHTNESS, mediaFilter.getAppliedBrightness());
        applyFilter(MediaFilterType.SATURATION, mediaFilter.getAppliedSaturation());
        applyFilter(MediaFilterType.PIXELATION, mediaFilter.getAppliedPixelation());
        applyFilter(MediaFilterType.SHARPNESS, mediaFilter.getAppliedSharpness());
    }

    /* access modifiers changed from: private */
    public final void applyFilter(MediaFilterType mediaFilterType, float f) {
        FilterRequest filterRequest = this.receivedFilterRequest;
        if (filterRequest == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receivedFilterRequest");
        }
        filterRequest.getFilter().clearAppliedConflatedFilter();
        getBasicFiltersViewModel().setSelectedFilterName("haha");
        getDeepFryFiltersViewModel().setSelectedFilterName("haha");
        FilterRequest filterRequest2 = this.receivedFilterRequest;
        if (filterRequest2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receivedFilterRequest");
        }
        MediaFilter filter = filterRequest2.getFilter();
        int i = WhenMappings.$EnumSwitchMapping$1[mediaFilterType.ordinal()];
        if (i == 1) {
            filter.setContrast(f);
            getMediaEnhanceViewModel().setContrastFilterApplied(filter.hasContrast());
        } else if (i == 2) {
            filter.setBrightness(f);
            getMediaEnhanceViewModel().setBrightnessFilterApplied(filter.hasBrightness());
        } else if (i == 3) {
            filter.setSaturation(f);
            getMediaEnhanceViewModel().setSaturationFilterApplied(filter.hasSaturation());
        } else if (i == 4) {
            filter.setPixelation(f);
            getMediaEnhanceViewModel().setPixelationFilterApplied(filter.hasPixelation());
        } else if (i == 5) {
            filter.setSharpness(f);
            getMediaEnhanceViewModel().setSharpnessFilterApplied(filter.hasSharpness());
        }
        int currentContentType = getCurrentContentType();
        if (currentContentType == 1231) {
            applyImageFilter(mediaFilterType, f);
        } else if (currentContentType == 1232 || currentContentType == 1237) {
            applyVideoFilter(mediaFilterType, f);
        } else {
            throw new RuntimeException("Unknown content-type: " + currentContentType);
        }
    }

    /* access modifiers changed from: private */
    public final void applyConflatedFilter(GlConflatedFilter glConflatedFilter) {
        clearEnhanceFilters();
        FilterRequest filterRequest = this.receivedFilterRequest;
        if (filterRequest == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receivedFilterRequest");
        }
        filterRequest.getFilter().setAppliedConflatedFilter(glConflatedFilter);
        getBasicFiltersViewModel().setSelectedFilterName(glConflatedFilter.name());
        getDeepFryFiltersViewModel().setSelectedFilterName(glConflatedFilter.name());
        int currentContentType = getCurrentContentType();
        if (currentContentType == 1231) {
            applyImageFilter(glConflatedFilter.createPhotoFilter());
        } else if (currentContentType == 1232 || currentContentType == 1237) {
            applyVideoFilter(glConflatedFilter.createVideoFilter());
        } else {
            throw new RuntimeException("Unknown content-type: " + currentContentType);
        }
    }

    private final void applyImageFilter(MediaFilterType mediaFilterType, float f) {
        applyImageFilter(getImageFilterManager().updateFilter(mediaFilterType, (int) f));
    }

    private final void applyImageFilter(GlPhotoFilter glPhotoFilter) {
        GPUImageView gPUImageView = getBinding().photoView;
        Intrinsics.checkNotNullExpressionValue(gPUImageView, "binding.photoView");
        gPUImageView.setFilter(glPhotoFilter);
    }

    private final void applyVideoFilter(MediaFilterType mediaFilterType, float f) {
        applyVideoFilter(getVideoFilterManager().updateFilter(mediaFilterType, (int) f));
    }

    private final void applyVideoFilter(GlVideoFilter glVideoFilter) {
        if (this.gpuPlayerView == null) {
            releaseGpuPlayer();
            GPUPlayerView createGpuPlayer = createGpuPlayer();
            this.gpuPlayerView = createGpuPlayer;
            if (createGpuPlayer == null) {
                return;
            }
        }
        GPUPlayerView gPUPlayerView = this.gpuPlayerView;
        if (gPUPlayerView != null) {
            gPUPlayerView.setGlFilter(glVideoFilter);
        }
    }

    private final void setFilterTab(FilterRequest.FilterTab filterTab) {
        getFiltersTabsViewModel().setSelectedFilterTab(filterTab);
    }

    /* access modifiers changed from: private */
    public final void handleFilterTrigger(int i) {
        FilterRequest filterRequest = this.receivedFilterRequest;
        if (filterRequest == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receivedFilterRequest");
        }
        MediaFilter filter = filterRequest.getFilter();
        switch (i) {
            case 10:
                showContrastSlider(filter.getAppliedContrast(), filter.getDefaultContrast());
                return;
            case 11:
                showBrightnessSlider(filter.getAppliedBrightness(), filter.getDefaultBrightness());
                return;
            case 12:
                showSaturationSlider(filter.getAppliedSaturation(), filter.getDefaultSaturation());
                return;
            case 13:
                showPixelationSlider(filter.getAppliedPixelation(), filter.getDefaultPixelation());
                return;
            case 14:
                showSharpnessSlider(filter.getAppliedSharpness(), filter.getDefaultSharpness());
                return;
            default:
                return;
        }
    }

    private final void showContrastSlider(float f, float f2) {
        FilterRequest filterRequest = this.receivedFilterRequest;
        if (filterRequest == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receivedFilterRequest");
        }
        String identifier = filterRequest.getIdentifier();
        String string = getString(C4175R.string.contrast);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.contrast)");
        showSingleSlider(identifier, new CommonSliderInput(10, string, f, new FloatRange(f2, 0.0f, 100.0f)));
    }

    private final void showBrightnessSlider(float f, float f2) {
        FilterRequest filterRequest = this.receivedFilterRequest;
        if (filterRequest == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receivedFilterRequest");
        }
        String identifier = filterRequest.getIdentifier();
        String string = getString(C4175R.string.brightness);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.brightness)");
        showSingleSlider(identifier, new CommonSliderInput(11, string, f, new FloatRange(f2, 0.0f, 100.0f)));
    }

    private final void showSaturationSlider(float f, float f2) {
        FilterRequest filterRequest = this.receivedFilterRequest;
        if (filterRequest == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receivedFilterRequest");
        }
        String identifier = filterRequest.getIdentifier();
        String string = getString(C4175R.string.saturation);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.saturation)");
        showSingleSlider(identifier, new CommonSliderInput(12, string, f, new FloatRange(f2, 0.0f, 100.0f)));
    }

    private final void showPixelationSlider(float f, float f2) {
        FilterRequest filterRequest = this.receivedFilterRequest;
        if (filterRequest == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receivedFilterRequest");
        }
        String identifier = filterRequest.getIdentifier();
        String string = getString(C4175R.string.pixelation);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.pixelation)");
        showSingleSlider(identifier, new CommonSliderInput(13, string, f, new FloatRange(f2, 0.0f, 100.0f)));
    }

    private final void showSharpnessSlider(float f, float f2) {
        FilterRequest filterRequest = this.receivedFilterRequest;
        if (filterRequest == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receivedFilterRequest");
        }
        String identifier = filterRequest.getIdentifier();
        String string = getString(C4175R.string.sharpness);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.sharpness)");
        showSingleSlider(identifier, new CommonSliderInput(14, string, f, new FloatRange(f2, 0.0f, 100.0f)));
    }

    private final void showSingleSlider(String str, CommonSliderInput commonSliderInput) {
        getCommonSliderViewModel().setInput(str, commonSliderInput);
        getFragmentManagerUtil().showSingleSliderFragment();
    }

    private final GPUPlayerView createGpuPlayer() {
        PlayerView playerView = getBinding().videoView;
        Intrinsics.checkNotNullExpressionValue(playerView, "binding.videoView");
        Player player = playerView.getPlayer();
        if (!(player instanceof SimpleExoPlayer)) {
            player = null;
        }
        SimpleExoPlayer simpleExoPlayer = (SimpleExoPlayer) player;
        if (simpleExoPlayer == null) {
            return null;
        }
        GPUPlayerView gPUPlayerView = new GPUPlayerView(this);
        gPUPlayerView.setSimpleExoPlayer(simpleExoPlayer);
        PlayerView playerView2 = getBinding().videoView;
        Intrinsics.checkNotNullExpressionValue(playerView2, "binding.videoView");
        int i = playerView2.getLayoutParams().width;
        PlayerView playerView3 = getBinding().videoView;
        Intrinsics.checkNotNullExpressionValue(playerView3, "binding.videoView");
        gPUPlayerView.setLayoutParams(new RelativeLayout.LayoutParams(i, playerView3.getLayoutParams().height));
        getBinding().videoView.addView(gPUPlayerView);
        gPUPlayerView.onResume();
        return gPUPlayerView;
    }

    private final void releaseGpuPlayer() {
        GPUPlayerView gPUPlayerView = this.gpuPlayerView;
        if (gPUPlayerView != null) {
            if (gPUPlayerView != null) {
                gPUPlayerView.setGlFilter((GlVideoFilter) null);
            }
            GPUPlayerView gPUPlayerView2 = this.gpuPlayerView;
            if (gPUPlayerView2 != null) {
                gPUPlayerView2.onPause();
            }
            getBinding().videoView.removeView(this.gpuPlayerView);
            this.gpuPlayerView = null;
        }
    }

    private final void clearEnhanceFilters() {
        FilterRequest filterRequest = this.receivedFilterRequest;
        if (filterRequest == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receivedFilterRequest");
        }
        MediaFilter filter = filterRequest.getFilter();
        if (!filter.isCleared()) {
            getMediaEnhanceViewModel().clearAppliedFilter();
            filter.clear();
            int currentContentType = getCurrentContentType();
            if (currentContentType == 1231) {
                getImageFilterManager().clearFilter();
                GPUImageView gPUImageView = getBinding().photoView;
                Intrinsics.checkNotNullExpressionValue(gPUImageView, "binding.photoView");
                gPUImageView.setFilter(new GlPhotoFilter());
            } else if (currentContentType == 1232) {
                getVideoFilterManager().clearFilter();
                GPUPlayerView gPUPlayerView = this.gpuPlayerView;
                if (gPUPlayerView != null) {
                    gPUPlayerView.setGlFilter(new GlVideoFilter());
                }
            }
        }
    }
}
