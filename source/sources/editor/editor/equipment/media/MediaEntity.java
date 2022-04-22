package editor.editor.equipment.media;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import editor.editor.equipment.core.CoreEntity;
import editor.editor.equipment.media.content.CropSpec;
import editor.editor.equipment.media.content.FilterSpec;
import editor.editor.equipment.property.MediaProperty;
import editor.editor.equipment.property.NicoProperty;
import editor.editor.equipment.property.NicoPropertyBundle;
import editor.optionsui.watermark.PhotoWatermarkSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001$B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000fH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0010H\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0011H\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0012H\u0002J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\fJ\b\u0010\u001f\u001a\u00020\fH\u0014J\u000e\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\u001dJ\u0006\u0010\"\u001a\u00020\fJ\u0006\u0010#\u001a\u00020\fR\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006%"}, mo26107d2 = {"Leditor/editor/equipment/media/MediaEntity;", "Leditor/editor/equipment/core/CoreEntity;", "Leditor/editor/equipment/media/MediaLayer;", "Leditor/editor/equipment/media/MediaStyle;", "layer", "style", "(Leditor/editor/equipment/media/MediaLayer;Leditor/editor/equipment/media/MediaStyle;)V", "token", "", "getToken", "()Ljava/lang/String;", "apply", "", "property", "Leditor/editor/equipment/property/MediaProperty$AspectResize;", "Leditor/editor/equipment/property/MediaProperty$Content;", "Leditor/editor/equipment/property/MediaProperty$Crop;", "Leditor/editor/equipment/property/MediaProperty$Filter;", "Leditor/editor/equipment/property/MediaProperty$Watermark;", "applyProperty", "Leditor/editor/equipment/property/MediaProperty;", "applyPropertyBundle", "bundle", "Leditor/editor/equipment/property/NicoPropertyBundle;", "duplicate", "parent", "Landroid/view/ViewGroup;", "hide", "isDefault", "", "refresh", "refreshStyle", "setAspectsFixed", "fixed", "startPlaying", "stopPlaying", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaEntity.kt */
public final class MediaEntity extends CoreEntity<MediaLayer, MediaStyle> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String token = createEntityToken("media");

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaEntity(MediaLayer mediaLayer, MediaStyle mediaStyle) {
        super(mediaLayer, mediaStyle);
        Intrinsics.checkNotNullParameter(mediaLayer, "layer");
        Intrinsics.checkNotNullParameter(mediaStyle, "style");
        refreshStyle();
    }

    public String getToken() {
        return this.token;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo26107d2 = {"Leditor/editor/equipment/media/MediaEntity$Companion;", "", "()V", "create", "Leditor/editor/equipment/media/MediaEntity;", "parent", "Landroid/view/ViewGroup;", "style", "Leditor/editor/equipment/media/MediaStyle;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MediaEntity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ MediaEntity create$default(Companion companion, ViewGroup viewGroup, MediaStyle mediaStyle, int i, Object obj) {
            if ((i & 2) != 0) {
                mediaStyle = new MediaStyle();
            }
            return companion.create(viewGroup, mediaStyle);
        }

        public final MediaEntity create(ViewGroup viewGroup, MediaStyle mediaStyle) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            Intrinsics.checkNotNullParameter(mediaStyle, "style");
            Context context = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            MediaLayerView mediaLayerView = new MediaLayerView(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
            int width = viewGroup.getWidth();
            int height = viewGroup.getHeight();
            int i = GenericDraweeHierarchyBuilder.DEFAULT_FADE_DURATION;
            if (width >= 300 && height >= 300) {
                i = width >= height ? (height * 40) / 100 : (width * 40) / 100;
            }
            mediaLayerView.setLayoutParams(new ViewGroup.MarginLayoutParams(i, i));
            viewGroup.addView(mediaLayerView);
            MediaLayer mediaLayer = new MediaLayer(mediaLayerView);
            mediaLayer.getLifecycle().onAdding();
            return new MediaEntity(mediaLayer, mediaStyle);
        }
    }

    public MediaEntity duplicate(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        MediaStyle mediaStyle = new MediaStyle();
        ((MediaStyle) getStyle()).copy(mediaStyle);
        MediaEntity create = Companion.create(viewGroup, mediaStyle);
        float f = (float) 20;
        create.applyProperty(new NicoProperty.Translate(((MediaLayer) getLayer()).getX() + f, ((MediaLayer) getLayer()).getY() + f));
        return create;
    }

    public final void startPlaying() {
        ((MediaLayer) getLayer()).play();
    }

    public final void stopPlaying() {
        ((MediaLayer) getLayer()).pause();
    }

    public final void setAspectsFixed(boolean z) {
        ((MediaLayerView) ((MediaLayer) getLayer()).underlyingView()).setAreAspectsFixed(z);
    }

    public final void refresh() {
        ((MediaLayer) getLayer()).refresh();
    }

    public final boolean isDefault() {
        return ((MediaStyle) getStyle()).getOriginalContent() == null;
    }

    public void hide() {
        super.hide();
        stopPlaying();
    }

    /* access modifiers changed from: protected */
    public void refreshStyle() {
        super.refreshStyle();
        MediaStyle mediaStyle = (MediaStyle) getStyle();
        NicoPropertyBundle from = NicoPropertyBundle.Companion.from(getToken(), new MediaProperty.Content(mediaStyle.getOriginalContent()));
        CropSpec cropSpec = mediaStyle.getCropSpec();
        if (cropSpec != null && cropSpec.contentExists()) {
            from.addProperties(new MediaProperty.Crop(cropSpec));
        }
        FilterSpec filterSpec = mediaStyle.getFilterSpec();
        if (filterSpec != null && filterSpec.contentExists()) {
            from.addProperties(new MediaProperty.Filter(filterSpec));
        }
        PhotoWatermarkSource watermarkSource = mediaStyle.getWatermarkSource();
        if (mediaStyle.isWatermark() && watermarkSource != null) {
            from.addProperties(new MediaProperty.Watermark(mediaStyle.isWatermark(), watermarkSource));
        }
        applyPropertyBundle(from);
    }

    public void applyPropertyBundle(NicoPropertyBundle nicoPropertyBundle) {
        Intrinsics.checkNotNullParameter(nicoPropertyBundle, "bundle");
        for (NicoProperty next : nicoPropertyBundle.getProperties()) {
            if (next instanceof MediaProperty) {
                applyProperty((MediaProperty) next);
            } else {
                applyProperty(next);
            }
        }
    }

    public final void applyProperty(MediaProperty mediaProperty) {
        Intrinsics.checkNotNullParameter(mediaProperty, "property");
        if (mediaProperty instanceof MediaProperty.AspectResize) {
            apply((MediaProperty.AspectResize) mediaProperty);
        } else if (mediaProperty instanceof MediaProperty.Content) {
            apply((MediaProperty.Content) mediaProperty);
        } else if (mediaProperty instanceof MediaProperty.Crop) {
            apply((MediaProperty.Crop) mediaProperty);
        } else if (mediaProperty instanceof MediaProperty.Filter) {
            apply((MediaProperty.Filter) mediaProperty);
        } else if (mediaProperty instanceof MediaProperty.Watermark) {
            apply((MediaProperty.Watermark) mediaProperty);
        }
        notifyPropertyApplied(mediaProperty);
    }

    private final void apply(MediaProperty.AspectResize aspectResize) {
        setAspectsFixed(false);
        ((MediaLayer) getLayer()).setAspectRatio(aspectResize.getValue());
    }

    private final void apply(MediaProperty.Content content) {
        ((MediaStyle) getStyle()).setContent(content.getValue());
        MediaLayer.setContent$default((MediaLayer) getLayer(), content.getValue(), false, 2, (Object) null);
    }

    private final void apply(MediaProperty.Crop crop) {
        ((MediaStyle) getStyle()).setCropSpec(crop.getSpec());
        if (crop.getSpec().contentExists()) {
            MediaLayer.setContent$default((MediaLayer) getLayer(), crop.getSpec().getContent(), false, 2, (Object) null);
        }
    }

    private final void apply(MediaProperty.Filter filter) {
        ((MediaStyle) getStyle()).setFilterSpec(filter.getSpec());
        if (filter.getSpec().contentExists()) {
            ((MediaLayer) getLayer()).setContent(filter.getSpec().getContent(), false);
        }
    }

    private final void apply(MediaProperty.Watermark watermark) {
        ((MediaStyle) getStyle()).setWatermark(watermark.getValue());
        ((MediaStyle) getStyle()).setWatermarkSource(watermark.getType());
    }
}
