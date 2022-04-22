package editor.editor.equipment.property;

import com.memes.commons.media.MediaContent;
import editor.editor.equipment.media.content.CropSpec;
import editor.editor.equipment.media.content.FilterSpec;
import editor.optionsui.watermark.PhotoWatermarkSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0005\u0005\u0006\u0007\b\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004\u0001\u0005\n\u000b\f\r\u000e¨\u0006\u000f"}, mo26107d2 = {"Leditor/editor/equipment/property/MediaProperty;", "Leditor/editor/equipment/property/NicoProperty;", "identifier", "", "(Ljava/lang/String;)V", "AspectResize", "Content", "Crop", "Filter", "Watermark", "Leditor/editor/equipment/property/MediaProperty$AspectResize;", "Leditor/editor/equipment/property/MediaProperty$Content;", "Leditor/editor/equipment/property/MediaProperty$Crop;", "Leditor/editor/equipment/property/MediaProperty$Filter;", "Leditor/editor/equipment/property/MediaProperty$Watermark;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NicoProperty.kt */
public abstract class MediaProperty extends NicoProperty {
    private MediaProperty(String str) {
        super(str, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ MediaProperty(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Leditor/editor/equipment/property/MediaProperty$AspectResize;", "Leditor/editor/equipment/property/MediaProperty;", "value", "", "(F)V", "getValue", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoProperty.kt */
    public static final class AspectResize extends MediaProperty {
        private final float value;

        public static /* synthetic */ AspectResize copy$default(AspectResize aspectResize, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = aspectResize.value;
            }
            return aspectResize.copy(f);
        }

        public final float component1() {
            return this.value;
        }

        public final AspectResize copy(float f) {
            return new AspectResize(f);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof AspectResize) && Float.compare(this.value, ((AspectResize) obj).value) == 0;
            }
            return true;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.value);
        }

        public String toString() {
            return "AspectResize(value=" + this.value + ")";
        }

        public final float getValue() {
            return this.value;
        }

        public AspectResize(float f) {
            super("aspect-resize", (DefaultConstructorMarker) null);
            this.value = f;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Leditor/editor/equipment/property/MediaProperty$Content;", "Leditor/editor/equipment/property/MediaProperty;", "value", "Lcom/memes/commons/media/MediaContent;", "(Lcom/memes/commons/media/MediaContent;)V", "getValue", "()Lcom/memes/commons/media/MediaContent;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoProperty.kt */
    public static final class Content extends MediaProperty {
        private final MediaContent value;

        public static /* synthetic */ Content copy$default(Content content, MediaContent mediaContent, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaContent = content.value;
            }
            return content.copy(mediaContent);
        }

        public final MediaContent component1() {
            return this.value;
        }

        public final Content copy(MediaContent mediaContent) {
            return new Content(mediaContent);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Content) && Intrinsics.areEqual((Object) this.value, (Object) ((Content) obj).value);
            }
            return true;
        }

        public int hashCode() {
            MediaContent mediaContent = this.value;
            if (mediaContent != null) {
                return mediaContent.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Content(value=" + this.value + ")";
        }

        public final MediaContent getValue() {
            return this.value;
        }

        public Content(MediaContent mediaContent) {
            super("content", (DefaultConstructorMarker) null);
            this.value = mediaContent;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Leditor/editor/equipment/property/MediaProperty$Crop;", "Leditor/editor/equipment/property/MediaProperty;", "spec", "Leditor/editor/equipment/media/content/CropSpec;", "(Leditor/editor/equipment/media/content/CropSpec;)V", "getSpec", "()Leditor/editor/equipment/media/content/CropSpec;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoProperty.kt */
    public static final class Crop extends MediaProperty {
        private final CropSpec spec;

        public static /* synthetic */ Crop copy$default(Crop crop, CropSpec cropSpec, int i, Object obj) {
            if ((i & 1) != 0) {
                cropSpec = crop.spec;
            }
            return crop.copy(cropSpec);
        }

        public final CropSpec component1() {
            return this.spec;
        }

        public final Crop copy(CropSpec cropSpec) {
            Intrinsics.checkNotNullParameter(cropSpec, "spec");
            return new Crop(cropSpec);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Crop) && Intrinsics.areEqual((Object) this.spec, (Object) ((Crop) obj).spec);
            }
            return true;
        }

        public int hashCode() {
            CropSpec cropSpec = this.spec;
            if (cropSpec != null) {
                return cropSpec.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Crop(spec=" + this.spec + ")";
        }

        public final CropSpec getSpec() {
            return this.spec;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Crop(CropSpec cropSpec) {
            super("crop", (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(cropSpec, "spec");
            this.spec = cropSpec;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Leditor/editor/equipment/property/MediaProperty$Filter;", "Leditor/editor/equipment/property/MediaProperty;", "spec", "Leditor/editor/equipment/media/content/FilterSpec;", "(Leditor/editor/equipment/media/content/FilterSpec;)V", "getSpec", "()Leditor/editor/equipment/media/content/FilterSpec;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoProperty.kt */
    public static final class Filter extends MediaProperty {
        private final FilterSpec spec;

        public static /* synthetic */ Filter copy$default(Filter filter, FilterSpec filterSpec, int i, Object obj) {
            if ((i & 1) != 0) {
                filterSpec = filter.spec;
            }
            return filter.copy(filterSpec);
        }

        public final FilterSpec component1() {
            return this.spec;
        }

        public final Filter copy(FilterSpec filterSpec) {
            Intrinsics.checkNotNullParameter(filterSpec, "spec");
            return new Filter(filterSpec);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Filter) && Intrinsics.areEqual((Object) this.spec, (Object) ((Filter) obj).spec);
            }
            return true;
        }

        public int hashCode() {
            FilterSpec filterSpec = this.spec;
            if (filterSpec != null) {
                return filterSpec.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Filter(spec=" + this.spec + ")";
        }

        public final FilterSpec getSpec() {
            return this.spec;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Filter(FilterSpec filterSpec) {
            super("filter", (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(filterSpec, "spec");
            this.spec = filterSpec;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo26107d2 = {"Leditor/editor/equipment/property/MediaProperty$Watermark;", "Leditor/editor/equipment/property/MediaProperty;", "value", "", "type", "Leditor/optionsui/watermark/PhotoWatermarkSource;", "(ZLeditor/optionsui/watermark/PhotoWatermarkSource;)V", "getType", "()Leditor/optionsui/watermark/PhotoWatermarkSource;", "getValue", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoProperty.kt */
    public static final class Watermark extends MediaProperty {
        private final PhotoWatermarkSource type;
        private final boolean value;

        public static /* synthetic */ Watermark copy$default(Watermark watermark, boolean z, PhotoWatermarkSource photoWatermarkSource, int i, Object obj) {
            if ((i & 1) != 0) {
                z = watermark.value;
            }
            if ((i & 2) != 0) {
                photoWatermarkSource = watermark.type;
            }
            return watermark.copy(z, photoWatermarkSource);
        }

        public final boolean component1() {
            return this.value;
        }

        public final PhotoWatermarkSource component2() {
            return this.type;
        }

        public final Watermark copy(boolean z, PhotoWatermarkSource photoWatermarkSource) {
            Intrinsics.checkNotNullParameter(photoWatermarkSource, "type");
            return new Watermark(z, photoWatermarkSource);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Watermark)) {
                return false;
            }
            Watermark watermark = (Watermark) obj;
            return this.value == watermark.value && Intrinsics.areEqual((Object) this.type, (Object) watermark.type);
        }

        public int hashCode() {
            boolean z = this.value;
            if (z) {
                z = true;
            }
            int i = (z ? 1 : 0) * true;
            PhotoWatermarkSource photoWatermarkSource = this.type;
            return i + (photoWatermarkSource != null ? photoWatermarkSource.hashCode() : 0);
        }

        public String toString() {
            return "Watermark(value=" + this.value + ", type=" + this.type + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Watermark(boolean z, PhotoWatermarkSource photoWatermarkSource, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z, photoWatermarkSource);
        }

        public final boolean getValue() {
            return this.value;
        }

        public final PhotoWatermarkSource getType() {
            return this.type;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Watermark(boolean z, PhotoWatermarkSource photoWatermarkSource) {
            super("watermark", (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(photoWatermarkSource, "type");
            this.value = z;
            this.type = photoWatermarkSource;
        }
    }
}
