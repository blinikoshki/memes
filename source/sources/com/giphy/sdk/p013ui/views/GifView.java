package com.giphy.sdk.p013ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.RetainingDataSourceSupplier;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.giphy.sdk.core.GiphyCore;
import com.giphy.sdk.core.models.Image;
import com.giphy.sdk.core.models.Images;
import com.giphy.sdk.core.models.Media;
import com.giphy.sdk.core.models.enums.RenditionType;
import com.giphy.sdk.p013ui.C1800R;
import com.giphy.sdk.p013ui.ConstantsKt;
import com.giphy.sdk.p013ui.GiphyCoreUI;
import com.giphy.sdk.p013ui.ads.AdPillDrawer;
import com.giphy.sdk.p013ui.ads.AdPillSize;
import com.giphy.sdk.p013ui.drawables.GifStepAction;
import com.giphy.sdk.p013ui.drawables.GifStepMapping;
import com.giphy.sdk.p013ui.drawables.ImageFormat;
import com.giphy.sdk.p013ui.drawables.ImageUriInfo;
import com.giphy.sdk.p013ui.drawables.LoadStep;
import com.giphy.sdk.p013ui.themes.LightTheme;
import com.giphy.sdk.p013ui.utils.GifUtils;
import com.giphy.sdk.p013ui.utils.ImageDownloadChooserKt;
import com.giphy.sdk.p013ui.utils.IntExtensionsKt;
import com.giphy.sdk.tracking.MediaExtensionKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000»\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013*\u0001O\b\u0016\u0018\u00002\u00020\u0001:\u0001zB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010N\u001a\u00020OH\u0002¢\u0006\u0002\u0010PJ\u000e\u0010Q\u001a\b\u0012\u0004\u0012\u00020J0RH\u0002J\u0006\u0010S\u001a\u00020TJ\b\u0010U\u001a\u000209H\u0002J\u0010\u0010V\u001a\u0002092\b\b\u0001\u0010W\u001a\u00020\u0007J\u0010\u0010V\u001a\u0002092\b\u0010X\u001a\u0004\u0018\u00010YJ\b\u0010Z\u001a\u000209H\u0002J\u0010\u0010[\u001a\u0002092\u0006\u0010\\\u001a\u00020]H\u0002J\b\u0010^\u001a\u000209H\u0002J\b\u0010_\u001a\u000209H\u0002J\u0012\u0010`\u001a\u0002092\b\u0010a\u001a\u0004\u0018\u00010bH\u0014J*\u0010c\u001a\u0002092\b\u0010d\u001a\u0004\u0018\u00010Y2\n\b\u0001\u0010e\u001a\u0004\u0018\u00010f2\n\b\u0001\u0010g\u001a\u0004\u0018\u00010hH\u0016J\u0018\u0010i\u001a\u0002092\u0006\u0010j\u001a\u00020\u00072\u0006\u0010k\u001a\u00020\u0007H\u0014J\b\u0010l\u001a\u000209H\u0014J\u0006\u0010m\u001a\u000209J\u0006\u0010n\u001a\u000209J\u0006\u0010o\u001a\u000209J\u0010\u0010p\u001a\u0002092\u0006\u0010\\\u001a\u00020]H\u0002J\b\u0010q\u001a\u000209H\u0002J\u000e\u0010r\u001a\u0002092\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010s\u001a\u000209J$\u00105\u001a\u0002092\b\u00102\u001a\u0004\u0018\u0001012\n\b\u0002\u0010t\u001a\u0004\u0018\u00010M2\u0006\u0010>\u001a\u00020\u0012J-\u00105\u001a\u0002092\b\u00102\u001a\u0004\u0018\u0001012\n\b\u0002\u0010t\u001a\u0004\u0018\u00010M2\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010vJ\u0018\u0010w\u001a\u0002092\u0006\u0010d\u001a\u00020Y2\b\b\u0002\u0010t\u001a\u00020MJ\b\u0010x\u001a\u000209H\u0002J\b\u0010y\u001a\u000209H\u0002R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R(\u00102\u001a\u0004\u0018\u0001012\b\u00100\u001a\u0004\u0018\u000101@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00107\u001a\n\u0012\u0004\u0012\u000209\u0018\u000108X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0010\u0010>\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0A0@X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010C\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010)\"\u0004\bE\u0010+R\u001a\u0010F\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010)\"\u0004\bH\u0010+R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u000e¢\u0006\u0002\n\u0000¨\u0006{"}, mo26107d2 = {"Lcom/giphy/sdk/ui/views/GifView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DEFAULT_ASPECT_RATIO", "", "adPillDrawer", "Lcom/giphy/sdk/ui/ads/AdPillDrawer;", "adPillSize", "Lcom/giphy/sdk/ui/ads/AdPillSize;", "autoPlay", "", "bgDrawable", "Landroid/graphics/drawable/Drawable;", "getBgDrawable", "()Landroid/graphics/drawable/Drawable;", "setBgDrawable", "(Landroid/graphics/drawable/Drawable;)V", "desiredAspect", "getDesiredAspect", "()F", "setDesiredAspect", "(F)V", "gifCallback", "Lcom/giphy/sdk/ui/views/GifView$GifCallback;", "getGifCallback", "()Lcom/giphy/sdk/ui/views/GifView$GifCallback;", "setGifCallback", "(Lcom/giphy/sdk/ui/views/GifView$GifCallback;)V", "imageFormat", "Lcom/giphy/sdk/ui/drawables/ImageFormat;", "getImageFormat", "()Lcom/giphy/sdk/ui/drawables/ImageFormat;", "setImageFormat", "(Lcom/giphy/sdk/ui/drawables/ImageFormat;)V", "isBackgroundVisible", "()Z", "setBackgroundVisible", "(Z)V", "keepGifRatio", "loaded", "getLoaded", "setLoaded", "value", "Lcom/giphy/sdk/core/models/Media;", "media", "getMedia", "()Lcom/giphy/sdk/core/models/Media;", "setMedia", "(Lcom/giphy/sdk/core/models/Media;)V", "onPingbackGifLoadSuccess", "Lkotlin/Function0;", "", "getOnPingbackGifLoadSuccess", "()Lkotlin/jvm/functions/Function0;", "setOnPingbackGifLoadSuccess", "(Lkotlin/jvm/functions/Function0;)V", "placeholderDrawable", "retainingSupplier", "Lcom/facebook/datasource/RetainingDataSourceSupplier;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "shouldAnimateAdPill", "getShouldAnimateAdPill", "setShouldAnimateAdPill", "showProgress", "getShowProgress", "setShowProgress", "step", "Lcom/giphy/sdk/ui/drawables/LoadStep;", "stepIndex", "targetRendition", "Lcom/giphy/sdk/core/models/enums/RenditionType;", "getControllerListener", "com/giphy/sdk/ui/views/GifView$getControllerListener$1", "()Lcom/giphy/sdk/ui/views/GifView$getControllerListener$1;", "getLoadingSteps", "", "getProgressDrawable", "Lcom/facebook/drawee/drawable/ProgressBarDrawable;", "initAdPill", "loadAsset", "resId", "url", "", "loadCurrentStep", "loadImageFromUri", "uri", "Landroid/net/Uri;", "loadMedia", "loadNextStep", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onFinalImageSet", "id", "imageInfo", "Lcom/facebook/imagepipeline/image/ImageInfo;", "anim", "Landroid/graphics/drawable/Animatable;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onMediaChanged", "pause", "play", "removeLock", "replaceImage", "resetAdPill", "setAdPill", "setLocked", "renditionType", "placeholderColor", "(Lcom/giphy/sdk/core/models/Media;Lcom/giphy/sdk/core/models/enums/RenditionType;Ljava/lang/Integer;)V", "setMediaWithId", "tryLoadCurrentStep", "tryLoadNextStep", "GifCallback", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GifView */
/* compiled from: GifView.kt */
public class GifView extends SimpleDraweeView {
    private final float DEFAULT_ASPECT_RATIO;
    private HashMap _$_findViewCache;
    private AdPillDrawer adPillDrawer;
    private AdPillSize adPillSize;
    private boolean autoPlay;
    private Drawable bgDrawable;
    private float desiredAspect;
    private GifCallback gifCallback;
    private ImageFormat imageFormat;
    private boolean isBackgroundVisible;
    private final boolean keepGifRatio;
    private boolean loaded;
    private Media media;
    private Function0<Unit> onPingbackGifLoadSuccess;
    private Drawable placeholderDrawable;
    private final RetainingDataSourceSupplier<CloseableReference<CloseableImage>> retainingSupplier;
    private boolean shouldAnimateAdPill;
    private boolean showProgress;
    private LoadStep step;
    private int stepIndex;
    private RenditionType targetRendition;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.views.GifView$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GifStepAction.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[GifStepAction.NEXT.ordinal()] = 1;
            iArr[GifStepAction.SKIP.ordinal()] = 2;
            iArr[GifStepAction.TERMINATE.ordinal()] = 3;
        }
    }

    public GifView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public GifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public void onMediaChanged() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GifView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.autoPlay = GiphyCoreUI.INSTANCE.getAutoPlay();
        this.DEFAULT_ASPECT_RATIO = 1.7777778f;
        this.retainingSupplier = new RetainingDataSourceSupplier<>();
        this.shouldAnimateAdPill = true;
        this.desiredAspect = 1.7777778f;
        this.isBackgroundVisible = true;
        this.imageFormat = ImageFormat.WEBP;
        this.bgDrawable = ContextCompat.getDrawable(context, C1800R.C1802drawable.gph_sticker_bg_drawable);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1800R.styleable.GifView, 0, 0);
        this.keepGifRatio = obtainStyledAttributes.getBoolean(C1800R.styleable.GifView_gphKeepGifRatio, true);
        obtainStyledAttributes.recycle();
        Drawable drawable = this.bgDrawable;
        if (drawable != null) {
            drawable.setAlpha(Intrinsics.areEqual((Object) GiphyCoreUI.INSTANCE.getThemeUsed$ui_sdk_release(), (Object) LightTheme.INSTANCE) ? 30 : 255);
        }
    }

    public final boolean getShouldAnimateAdPill() {
        return this.shouldAnimateAdPill;
    }

    public final void setShouldAnimateAdPill(boolean z) {
        this.shouldAnimateAdPill = z;
    }

    public final GifCallback getGifCallback() {
        return this.gifCallback;
    }

    public final void setGifCallback(GifCallback gifCallback2) {
        this.gifCallback = gifCallback2;
    }

    public final Function0<Unit> getOnPingbackGifLoadSuccess() {
        return this.onPingbackGifLoadSuccess;
    }

    public final void setOnPingbackGifLoadSuccess(Function0<Unit> function0) {
        this.onPingbackGifLoadSuccess = function0;
    }

    public final float getDesiredAspect() {
        return this.desiredAspect;
    }

    public final void setDesiredAspect(float f) {
        this.desiredAspect = f;
    }

    public final boolean getShowProgress() {
        return this.showProgress;
    }

    public final void setShowProgress(boolean z) {
        this.showProgress = z;
    }

    public final boolean isBackgroundVisible() {
        return this.isBackgroundVisible;
    }

    public final void setBackgroundVisible(boolean z) {
        this.isBackgroundVisible = z;
    }

    public final ImageFormat getImageFormat() {
        return this.imageFormat;
    }

    public final void setImageFormat(ImageFormat imageFormat2) {
        Intrinsics.checkParameterIsNotNull(imageFormat2, "<set-?>");
        this.imageFormat = imageFormat2;
    }

    public final boolean getLoaded() {
        return this.loaded;
    }

    public final void setLoaded(boolean z) {
        this.loaded = z;
    }

    public final Media getMedia() {
        return this.media;
    }

    private final void setMedia(Media media2) {
        this.loaded = false;
        this.media = media2;
        onMediaChanged();
        resetAdPill();
        requestLayout();
        loadMedia();
    }

    public final Drawable getBgDrawable() {
        return this.bgDrawable;
    }

    public final void setBgDrawable(Drawable drawable) {
        this.bgDrawable = drawable;
    }

    public static /* synthetic */ void setMedia$default(GifView gifView, Media media2, RenditionType renditionType, Integer num, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                renditionType = null;
            }
            if ((i & 4) != 0) {
                num = null;
            }
            gifView.setMedia(media2, renditionType, num);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMedia");
    }

    public final void setMedia(Media media2, RenditionType renditionType, Integer num) {
        setMedia(media2, renditionType, (Drawable) new ColorDrawable(num != null ? num.intValue() : ConstantsKt.getPlaceholderColor()));
    }

    public static /* synthetic */ void setMedia$default(GifView gifView, Media media2, RenditionType renditionType, Drawable drawable, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                renditionType = null;
            }
            gifView.setMedia(media2, renditionType, drawable);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMedia");
    }

    public final void setMedia(Media media2, RenditionType renditionType, Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(drawable, "placeholderDrawable");
        setMedia(media2);
        this.targetRendition = renditionType;
        this.placeholderDrawable = drawable;
    }

    public static /* synthetic */ void setMediaWithId$default(GifView gifView, String str, RenditionType renditionType, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                renditionType = RenditionType.fixedWidth;
            }
            gifView.setMediaWithId(str, renditionType);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMediaWithId");
    }

    public final void setMediaWithId(String str, RenditionType renditionType) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(renditionType, "renditionType");
        GiphyCore.INSTANCE.getApiClient().gifById(str, new GifView$setMediaWithId$1(this, renditionType));
    }

    public final void loadAsset(String str) {
        try {
            setMedia((Media) null);
            Uri parse = Uri.parse(str);
            Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(url)");
            loadImageFromUri(parse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void loadAsset(int i) {
        setMedia((Media) null);
        this.loaded = false;
        setController(((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setOldController(getController())).setControllerListener(getControllerListener())).setImageRequest(ImageRequestBuilder.newBuilderWithResourceId(i).build())).build());
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void loadMedia() {
        /*
            r3 = this;
            r0 = 0
            r3.loaded = r0
            r3.stepIndex = r0
            android.graphics.drawable.Drawable r0 = r3.placeholderDrawable
            if (r0 == 0) goto L_0x0012
            com.facebook.drawee.interfaces.DraweeHierarchy r1 = r3.getHierarchy()
            com.facebook.drawee.generic.GenericDraweeHierarchy r1 = (com.facebook.drawee.generic.GenericDraweeHierarchy) r1
            r1.setPlaceholderImage((android.graphics.drawable.Drawable) r0)
        L_0x0012:
            boolean r0 = r3.showProgress
            if (r0 == 0) goto L_0x0025
            com.facebook.drawee.interfaces.DraweeHierarchy r0 = r3.getHierarchy()
            com.facebook.drawee.generic.GenericDraweeHierarchy r0 = (com.facebook.drawee.generic.GenericDraweeHierarchy) r0
            com.facebook.drawee.drawable.ProgressBarDrawable r1 = r3.getProgressDrawable()
            android.graphics.drawable.Drawable r1 = (android.graphics.drawable.Drawable) r1
            r0.setProgressBarImage((android.graphics.drawable.Drawable) r1)
        L_0x0025:
            com.giphy.sdk.core.models.Media r0 = r3.media
            r1 = 0
            if (r0 == 0) goto L_0x004f
            boolean r0 = r0.isSticker()
            r2 = 1
            if (r0 != r2) goto L_0x004f
            com.giphy.sdk.core.models.Media r0 = r3.media
            if (r0 == 0) goto L_0x003a
            java.lang.Boolean r0 = com.giphy.sdk.tracking.MediaExtensionKt.isEmoji(r0)
            goto L_0x003b
        L_0x003a:
            r0 = r1
        L_0x003b:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 != 0) goto L_0x004f
            boolean r0 = r3.isBackgroundVisible
            if (r0 == 0) goto L_0x004f
            android.graphics.drawable.Drawable r0 = r3.bgDrawable
            r3.setBackground(r0)
            goto L_0x0054
        L_0x004f:
            android.graphics.drawable.Drawable r1 = (android.graphics.drawable.Drawable) r1
            r3.setBackground(r1)
        L_0x0054:
            com.giphy.sdk.core.models.Media r0 = r3.media
            if (r0 == 0) goto L_0x005b
            r3.loadCurrentStep()
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.giphy.sdk.p013ui.views.GifView.loadMedia():void");
    }

    private final void tryLoadNextStep() {
        if (this.stepIndex < getLoadingSteps().size()) {
            int i = WhenMappings.$EnumSwitchMapping$0[getLoadingSteps().get(this.stepIndex).getActionIfLoaded().ordinal()];
            if (i == 1) {
                this.stepIndex++;
                tryLoadCurrentStep();
            } else if (i == 2) {
                this.stepIndex += 2;
                tryLoadCurrentStep();
            }
        }
    }

    private final void tryLoadCurrentStep() {
        if (this.stepIndex < getLoadingSteps().size()) {
            loadCurrentStep();
        }
    }

    private final void loadCurrentStep() {
        List<LoadStep> loadingSteps = getLoadingSteps();
        LoadStep loadStep = loadingSteps.get(this.stepIndex);
        Media media2 = this.media;
        Uri uri = null;
        Image imageWithRenditionType = media2 != null ? ImageDownloadChooserKt.imageWithRenditionType(media2, loadStep.getType()) : null;
        if (imageWithRenditionType != null) {
            uri = ImageDownloadChooserKt.uriWithFormatOrFallback(imageWithRenditionType, this.imageFormat);
        }
        if (uri == null) {
            tryLoadNextStep();
        } else if (loadingSteps.size() > 1) {
            setController(((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setOldController(getController())).setControllerListener(getControllerListener())).setDataSourceSupplier(this.retainingSupplier)).build());
            replaceImage(uri);
        } else {
            loadImageFromUri(uri);
        }
    }

    private final void replaceImage(Uri uri) {
        LoadStep loadStep = this.step;
        this.retainingSupplier.replaceSupplier(Fresco.getImagePipeline().getDataSourceSupplier(ImageRequestBuilder.newBuilderWithSource(uri).setCacheChoice((loadStep != null ? loadStep.getActionIfLoaded() : null) == GifStepAction.TERMINATE ? ImageRequest.CacheChoice.DEFAULT : ImageRequest.CacheChoice.SMALL).build(), (Object) null, ImageRequest.RequestLevel.FULL_FETCH));
    }

    private final void loadNextStep() {
        this.step = getLoadingSteps().get(this.stepIndex);
        GifUtils gifUtils = GifUtils.INSTANCE;
        Media media2 = this.media;
        LoadStep loadStep = this.step;
        if (loadStep == null) {
            Intrinsics.throwNpe();
        }
        Image imageDataForType = gifUtils.getImageDataForType(media2, loadStep.getType());
        GifUtils gifUtils2 = GifUtils.INSTANCE;
        if (imageDataForType == null) {
            Intrinsics.throwNpe();
        }
        ImageUriInfo imageToLoad = gifUtils2.getImageToLoad(imageDataForType, this.imageFormat);
        if (imageToLoad != null) {
            replaceImage(imageToLoad.getUri());
        }
    }

    private final void loadImageFromUri(Uri uri) {
        setController(((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setUri(uri).setOldController(getController())).setControllerListener(getControllerListener())).build());
    }

    private final List<LoadStep> getLoadingSteps() {
        ArrayList<LoadStep> arrayList;
        if (this.targetRendition != null) {
            GifStepMapping gifStepMapping = GifStepMapping.INSTANCE;
            RenditionType renditionType = this.targetRendition;
            if (renditionType == null) {
                Intrinsics.throwNpe();
            }
            return gifStepMapping.getLoadingSteps(renditionType);
        }
        Media media2 = this.media;
        if (Intrinsics.areEqual((Object) media2 != null ? MediaExtensionKt.isEmoji(media2) : null, (Object) true)) {
            arrayList = GifStepMapping.INSTANCE.getEMOJI_STEPS();
        } else {
            arrayList = GifStepMapping.INSTANCE.getFIXED_WIDTH_STEPS();
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        Media media2;
        int i3;
        int i4;
        Images images;
        Images images2;
        Timber.m300d("onMeasure " + getSuggestedMinimumHeight() + ' ' + View.MeasureSpec.toString(i) + ' ' + View.MeasureSpec.toString(i2) + ' ' + this.media, new Object[0]);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if ((mode == 1073741824 && mode2 == 1073741824 && !this.keepGifRatio) || (media2 = this.media) == null) {
            super.onMeasure(i, i2);
            return;
        }
        if (media2 != null) {
            Image image = null;
            if (mode2 == 1073741824) {
                if (!(media2 == null || (images2 = media2.getImages()) == null)) {
                    image = images2.getOriginal();
                }
                if (image == null) {
                    Intrinsics.throwNpe();
                }
            } else if (mode == 1073741824) {
                if (!(media2 == null || (images = media2.getImages()) == null)) {
                    image = images.getFixedWidth();
                }
                if (image == null) {
                    Intrinsics.throwNpe();
                }
            } else {
                LoadStep loadStep = (LoadStep) CollectionsKt.last(getLoadingSteps());
                Media media3 = this.media;
                if (media3 != null) {
                    image = ImageDownloadChooserKt.imageWithRenditionType(media3, loadStep.getType());
                }
                if (image == null) {
                    Intrinsics.throwNpe();
                }
            }
            this.desiredAspect = ((float) image.getWidth()) / ((float) image.getHeight());
            i4 = IntExtensionsKt.getPx(image.getWidth());
            i3 = IntExtensionsKt.getPx(image.getHeight());
        } else {
            i4 = 0;
            i3 = 0;
        }
        float f = ((float) i4) / ((float) i3);
        this.desiredAspect = f;
        if (f == 0.0f || Float.isNaN(f)) {
            this.desiredAspect = this.DEFAULT_ASPECT_RATIO;
        }
        int resolveSize = View.resolveSize(i4, i);
        int resolveSize2 = View.resolveSize(i3, i2);
        Timber.m300d("rendition size [" + i4 + " x " + i3 + "] measured=[" + resolveSize + " x " + resolveSize2 + "] " + this.desiredAspect, new Object[0]);
        if (mode2 == Integer.MIN_VALUE) {
            resolveSize2 = View.getDefaultSize(resolveSize2, i2);
        }
        if (mode == 0) {
            resolveSize = (int) (((float) resolveSize2) * this.desiredAspect);
        }
        if (mode == Integer.MIN_VALUE && mode2 == 0) {
            resolveSize2 = (int) (((float) resolveSize) / this.desiredAspect);
        }
        if (mode2 == 0) {
            resolveSize2 = (int) (((float) resolveSize) / this.desiredAspect);
        }
        if (mode == 0 || mode == Integer.MIN_VALUE) {
            resolveSize = (int) (((float) resolveSize2) * this.desiredAspect);
        }
        if (resolveSize2 > getMaxHeight()) {
            resolveSize2 = getMaxHeight();
        }
        if (this.keepGifRatio) {
            resolveSize = (int) (((float) resolveSize2) * this.desiredAspect);
        }
        setMeasuredDimension(resolveSize, resolveSize2);
    }

    public final void setAdPill(AdPillSize adPillSize2) {
        Intrinsics.checkParameterIsNotNull(adPillSize2, "adPillSize");
        this.adPillSize = adPillSize2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getBottleData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initAdPill() {
        /*
            r4 = this;
            com.giphy.sdk.core.models.Media r0 = r4.media
            if (r0 == 0) goto L_0x000f
            com.giphy.sdk.core.models.BottleData r0 = r0.getBottleData()
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = r0.getTid()
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x001d
            int r0 = r0.length()
            if (r0 != 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            r0 = 0
            goto L_0x001e
        L_0x001d:
            r0 = 1
        L_0x001e:
            if (r0 != 0) goto L_0x0036
            com.giphy.sdk.ui.ads.AdPillSize r0 = r4.adPillSize
            if (r0 == 0) goto L_0x0036
            com.giphy.sdk.ui.ads.AdPillDrawer r1 = new com.giphy.sdk.ui.ads.AdPillDrawer
            android.content.Context r2 = r4.getContext()
            java.lang.String r3 = "context"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            boolean r3 = r4.shouldAnimateAdPill
            r1.<init>(r2, r0, r3)
            r4.adPillDrawer = r1
        L_0x0036:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.giphy.sdk.p013ui.views.GifView.initAdPill():void");
    }

    private final void resetAdPill() {
        AdPillDrawer adPillDrawer2 = this.adPillDrawer;
        if (adPillDrawer2 != null) {
            adPillDrawer2.cancelAnimation();
        }
        this.adPillDrawer = null;
    }

    private final GifView$getControllerListener$1 getControllerListener() {
        return new GifView$getControllerListener$1(this);
    }

    public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
        int i;
        long j;
        if (!this.loaded) {
            this.loaded = true;
            GifCallback gifCallback2 = this.gifCallback;
            if (gifCallback2 != null) {
                GifCallback.DefaultImpls.onImageSet$default(gifCallback2, imageInfo, animatable, 0, 0, 12, (Object) null);
            }
            Function0<Unit> function0 = this.onPingbackGifLoadSuccess;
            if (function0 != null) {
                Unit invoke = function0.invoke();
            }
            initAdPill();
        }
        AnimatedDrawable2 animatedDrawable2 = (AnimatedDrawable2) (!(animatable instanceof AnimatedDrawable2) ? null : animatable);
        if (animatedDrawable2 != null) {
            i = animatedDrawable2.getLoopCount();
            j = animatedDrawable2.getLoopDurationMs();
        } else {
            j = -1;
            i = 0;
        }
        if (this.autoPlay && animatable != null) {
            animatable.start();
        }
        GifCallback gifCallback3 = this.gifCallback;
        if (gifCallback3 != null) {
            gifCallback3.onImageSet(imageInfo, animatable, j, i);
        }
        tryLoadNextStep();
    }

    public final void play() {
        Animatable animatable;
        DraweeController controller;
        Animatable animatable2;
        this.autoPlay = true;
        DraweeController controller2 = getController();
        if (controller2 != null && (animatable = controller2.getAnimatable()) != null && !animatable.isRunning() && (controller = getController()) != null && (animatable2 = controller.getAnimatable()) != null) {
            animatable2.start();
        }
    }

    public final void pause() {
        Animatable animatable;
        DraweeController controller;
        Animatable animatable2;
        this.autoPlay = false;
        DraweeController controller2 = getController();
        if (controller2 != null && (animatable = controller2.getAnimatable()) != null && animatable.isRunning() && (controller = getController()) != null && (animatable2 = controller.getAnimatable()) != null) {
            animatable2.stop();
        }
    }

    public final ProgressBarDrawable getProgressDrawable() {
        ProgressBarDrawable progressBarDrawable = new ProgressBarDrawable();
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        progressBarDrawable.setColor(context.getResources().getColor(C1800R.C1801color.gph_gif_details_progress_bar_bg));
        progressBarDrawable.setBounds(0, getHeight() - 6, getWidth(), getHeight());
        progressBarDrawable.setPadding(0);
        return progressBarDrawable;
    }

    public final void setLocked() {
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        ((GenericDraweeHierarchy) getHierarchy()).setOverlayImage(new ScaleTypeDrawable(context.getResources().getDrawable(C1800R.C1802drawable.gph_ic_locked_red), ScalingUtils.ScaleType.CENTER_INSIDE));
        invalidate();
    }

    public final void removeLock() {
        ((GenericDraweeHierarchy) getHierarchy()).setOverlayImage((Drawable) null);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        AdPillDrawer adPillDrawer2 = this.adPillDrawer;
        if (adPillDrawer2 != null) {
            adPillDrawer2.draw(canvas);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J0\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, mo26107d2 = {"Lcom/giphy/sdk/ui/views/GifView$GifCallback;", "", "onFailure", "", "throwable", "", "onImageSet", "imageInfo", "Lcom/facebook/imagepipeline/image/ImageInfo;", "anim", "Landroid/graphics/drawable/Animatable;", "loopDuration", "", "loopCount", "", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.views.GifView$GifCallback */
    /* compiled from: GifView.kt */
    public interface GifCallback {
        void onFailure(Throwable th);

        void onImageSet(ImageInfo imageInfo, Animatable animatable, long j, int i);

        @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
        /* renamed from: com.giphy.sdk.ui.views.GifView$GifCallback$DefaultImpls */
        /* compiled from: GifView.kt */
        public static final class DefaultImpls {
            public static /* synthetic */ void onImageSet$default(GifCallback gifCallback, ImageInfo imageInfo, Animatable animatable, long j, int i, int i2, Object obj) {
                if (obj == null) {
                    if ((i2 & 4) != 0) {
                        j = -1;
                    }
                    gifCallback.onImageSet(imageInfo, animatable, j, (i2 & 8) != 0 ? 0 : i);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onImageSet");
            }
        }
    }
}
