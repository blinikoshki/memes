package top.defaults.drawabletoolbox;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 2}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 #2\u00020\u0001:\u0002#$B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0007H\u0007J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0007J&\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0007J\u0010\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0007H\u0007J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0007J\u0010\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0007H\u0007J(\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0007J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0007J\u0010\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0007H\u0007J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0007Jf\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u0007J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0007J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0007H\u0007J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0007J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0007H\u0007J\u0010\u0010\"\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0007H\u0007J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0007J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0007H\u0007J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0007J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, mo26107d2 = {"Ltop/defaults/drawabletoolbox/LayerDrawableBuilder;", "", "()V", "layers", "Ljava/util/ArrayList;", "Ltop/defaults/drawabletoolbox/LayerDrawableBuilder$Layer;", "paddingBottom", "", "paddingEnd", "paddingLeft", "paddingMode", "paddingRight", "paddingStart", "paddingTop", "add", "drawable", "Landroid/graphics/drawable/Drawable;", "build", "Landroid/graphics/drawable/LayerDrawable;", "gravity", "height", "inset", "insetLeft", "insetTop", "insetRight", "insetBottom", "insetEnd", "insetRelative", "insetStart", "modify", "index", "width", "padding", "mode", "paddingRelative", "Companion", "Layer", "drawabletoolbox_release"}, mo26108k = 1, mo26109mv = {1, 1, 11})
/* compiled from: LayerDrawableBuilder.kt */
public final class LayerDrawableBuilder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DIMEN_UNDEFINED = Integer.MIN_VALUE;
    private final ArrayList<Layer> layers = new ArrayList<>();
    private int paddingBottom;
    private int paddingEnd;
    private int paddingLeft;
    private int paddingMode;
    private int paddingRight;
    private int paddingStart;
    private int paddingTop;

    @Metadata(mo26105bv = {1, 0, 2}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Ltop/defaults/drawabletoolbox/LayerDrawableBuilder$Companion;", "", "()V", "DIMEN_UNDEFINED", "", "drawabletoolbox_release"}, mo26108k = 1, mo26109mv = {1, 1, 11})
    /* compiled from: LayerDrawableBuilder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final LayerDrawableBuilder paddingMode(int i) {
        LayerDrawableBuilder layerDrawableBuilder = this;
        layerDrawableBuilder.paddingMode = i;
        return layerDrawableBuilder;
    }

    public final LayerDrawableBuilder paddingLeft(int i) {
        LayerDrawableBuilder layerDrawableBuilder = this;
        layerDrawableBuilder.paddingLeft = i;
        return layerDrawableBuilder;
    }

    public final LayerDrawableBuilder paddingTop(int i) {
        LayerDrawableBuilder layerDrawableBuilder = this;
        layerDrawableBuilder.paddingTop = i;
        return layerDrawableBuilder;
    }

    public final LayerDrawableBuilder paddingRight(int i) {
        LayerDrawableBuilder layerDrawableBuilder = this;
        layerDrawableBuilder.paddingRight = i;
        return layerDrawableBuilder;
    }

    public final LayerDrawableBuilder paddingBottom(int i) {
        LayerDrawableBuilder layerDrawableBuilder = this;
        layerDrawableBuilder.paddingBottom = i;
        return layerDrawableBuilder;
    }

    public final LayerDrawableBuilder paddingStart(int i) {
        LayerDrawableBuilder layerDrawableBuilder = this;
        layerDrawableBuilder.paddingStart = i;
        return layerDrawableBuilder;
    }

    public final LayerDrawableBuilder paddingEnd(int i) {
        LayerDrawableBuilder layerDrawableBuilder = this;
        layerDrawableBuilder.paddingEnd = i;
        return layerDrawableBuilder;
    }

    public final LayerDrawableBuilder padding(int i) {
        LayerDrawableBuilder layerDrawableBuilder = this;
        layerDrawableBuilder.paddingLeft(i).paddingTop(i).paddingRight(i).paddingBottom(i);
        return layerDrawableBuilder;
    }

    public final LayerDrawableBuilder paddingRelative(int i) {
        LayerDrawableBuilder layerDrawableBuilder = this;
        layerDrawableBuilder.paddingStart(i).paddingTop(i).paddingEnd(i).paddingBottom(i);
        return layerDrawableBuilder;
    }

    public final LayerDrawableBuilder add(Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(drawable, "drawable");
        LayerDrawableBuilder layerDrawableBuilder = this;
        layerDrawableBuilder.layers.add(new Layer(drawable));
        return layerDrawableBuilder;
    }

    public final LayerDrawableBuilder width(int i) {
        LayerDrawableBuilder layerDrawableBuilder = this;
        ((Layer) CollectionsKt.last(layerDrawableBuilder.layers)).setWidth(i);
        return layerDrawableBuilder;
    }

    public final LayerDrawableBuilder height(int i) {
        LayerDrawableBuilder layerDrawableBuilder = this;
        ((Layer) CollectionsKt.last(layerDrawableBuilder.layers)).setHeight(i);
        return layerDrawableBuilder;
    }

    public final LayerDrawableBuilder insetLeft(int i) {
        LayerDrawableBuilder layerDrawableBuilder = this;
        ((Layer) CollectionsKt.last(layerDrawableBuilder.layers)).setInsetLeft(i);
        return layerDrawableBuilder;
    }

    public final LayerDrawableBuilder insetTop(int i) {
        LayerDrawableBuilder layerDrawableBuilder = this;
        ((Layer) CollectionsKt.last(layerDrawableBuilder.layers)).setInsetTop(i);
        return layerDrawableBuilder;
    }

    public final LayerDrawableBuilder insetRight(int i) {
        LayerDrawableBuilder layerDrawableBuilder = this;
        ((Layer) CollectionsKt.last(layerDrawableBuilder.layers)).setInsetRight(i);
        return layerDrawableBuilder;
    }

    public final LayerDrawableBuilder insetBottom(int i) {
        LayerDrawableBuilder layerDrawableBuilder = this;
        ((Layer) CollectionsKt.last(layerDrawableBuilder.layers)).setInsetBottom(i);
        return layerDrawableBuilder;
    }

    public final LayerDrawableBuilder insetStart(int i) {
        LayerDrawableBuilder layerDrawableBuilder = this;
        ((Layer) CollectionsKt.last(layerDrawableBuilder.layers)).setInsetStart(i);
        return layerDrawableBuilder;
    }

    public final LayerDrawableBuilder insetEnd(int i) {
        LayerDrawableBuilder layerDrawableBuilder = this;
        ((Layer) CollectionsKt.last(layerDrawableBuilder.layers)).setInsetEnd(i);
        return layerDrawableBuilder;
    }

    public final LayerDrawableBuilder inset(int i) {
        LayerDrawableBuilder layerDrawableBuilder = this;
        layerDrawableBuilder.insetLeft(i).insetTop(i).insetRight(i).insetBottom(i);
        return layerDrawableBuilder;
    }

    public final LayerDrawableBuilder inset(int i, int i2, int i3, int i4) {
        LayerDrawableBuilder layerDrawableBuilder = this;
        layerDrawableBuilder.insetLeft(i).insetTop(i2).insetRight(i3).insetBottom(i4);
        return layerDrawableBuilder;
    }

    public final LayerDrawableBuilder insetRelative(int i) {
        LayerDrawableBuilder layerDrawableBuilder = this;
        layerDrawableBuilder.insetStart(i).insetTop(i).insetEnd(i).insetBottom(i);
        return layerDrawableBuilder;
    }

    public final LayerDrawableBuilder insetRelative(int i, int i2, int i3, int i4) {
        LayerDrawableBuilder layerDrawableBuilder = this;
        layerDrawableBuilder.insetStart(i).insetTop(i2).insetEnd(i3).insetBottom(i4);
        return layerDrawableBuilder;
    }

    public final LayerDrawableBuilder gravity(int i) {
        LayerDrawableBuilder layerDrawableBuilder = this;
        ((Layer) CollectionsKt.last(layerDrawableBuilder.layers)).setGravity(i);
        return layerDrawableBuilder;
    }

    public static /* bridge */ /* synthetic */ LayerDrawableBuilder modify$default(LayerDrawableBuilder layerDrawableBuilder, int i, Drawable drawable, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, Object obj) {
        int i11 = i10;
        return layerDrawableBuilder.modify(i, drawable, (i11 & 4) != 0 ? Integer.MIN_VALUE : i2, (i11 & 8) != 0 ? Integer.MIN_VALUE : i3, (i11 & 16) != 0 ? Integer.MIN_VALUE : i4, (i11 & 32) != 0 ? Integer.MIN_VALUE : i5, (i11 & 64) != 0 ? Integer.MIN_VALUE : i6, (i11 & 128) != 0 ? Integer.MIN_VALUE : i7, (i11 & 256) != 0 ? Integer.MIN_VALUE : i8, (i11 & 512) != 0 ? Integer.MIN_VALUE : i9);
    }

    public final LayerDrawableBuilder modify(int i, Drawable drawable, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        Intrinsics.checkParameterIsNotNull(drawable, "drawable");
        LayerDrawableBuilder layerDrawableBuilder = this;
        Layer layer = layerDrawableBuilder.layers.get(i);
        layer.setDrawable(drawable);
        if (i2 != Integer.MIN_VALUE) {
            layer.setWidth(i2);
        }
        if (i3 != Integer.MIN_VALUE) {
            layer.setHeight(i3);
        }
        if (i4 != Integer.MIN_VALUE) {
            layer.setInsetLeft(i4);
        }
        if (i5 != Integer.MIN_VALUE) {
            layer.setInsetTop(i5);
        }
        if (i6 != Integer.MIN_VALUE) {
            layer.setInsetRight(i6);
        }
        if (i7 != Integer.MIN_VALUE) {
            layer.setInsetBottom(i7);
        }
        if (i8 != Integer.MIN_VALUE) {
            layer.setInsetStart(i8);
        }
        if (i9 != Integer.MIN_VALUE) {
            layer.setInsetEnd(i9);
        }
        return layerDrawableBuilder;
    }

    public final LayerDrawable build() {
        Iterable<Layer> iterable = this.layers;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Layer drawable : iterable) {
            arrayList.add(drawable.getDrawable());
        }
        Object[] array = ((List) arrayList).toArray(new Drawable[0]);
        if (array != null) {
            LayerDrawable layerDrawable = new LayerDrawable((Drawable[]) array);
            int size = this.layers.size();
            for (int i = 0; i < size; i++) {
                Layer layer = this.layers.get(i);
                layerDrawable.setLayerInset(i, layer.getInsetLeft(), layer.getInsetTop(), layer.getInsetRight(), layer.getInsetBottom());
                if (Build.VERSION.SDK_INT >= 23 && !(layer.getInsetStart() == Integer.MIN_VALUE && layer.getInsetEnd() == Integer.MIN_VALUE)) {
                    layerDrawable.setLayerInsetRelative(i, layer.getInsetStart(), layer.getInsetTop(), layer.getInsetEnd(), layer.getInsetBottom());
                }
                layerDrawable.setId(i, i);
                if (Build.VERSION.SDK_INT >= 23) {
                    layerDrawable.setLayerGravity(i, layer.getGravity());
                    layerDrawable.setLayerInsetStart(i, layer.getInsetStart());
                    layerDrawable.setLayerInsetEnd(i, layer.getInsetEnd());
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                layerDrawable.setPaddingMode(this.paddingMode);
            }
            if (Build.VERSION.SDK_INT >= 23) {
                layerDrawable.setPadding(this.paddingLeft, this.paddingTop, this.paddingRight, this.paddingBottom);
                int i2 = this.paddingStart;
                if (!(i2 == Integer.MIN_VALUE && this.paddingEnd == Integer.MIN_VALUE)) {
                    layerDrawable.setPaddingRelative(i2, this.paddingTop, this.paddingEnd, this.paddingBottom);
                }
            }
            return layerDrawable;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Metadata(mo26105bv = {1, 0, 2}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001d\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u001a\u0010\u0017\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR\u001a\u0010\u001a\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR\u001a\u0010\u001d\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000b\"\u0004\b\u001f\u0010\rR\u001a\u0010 \u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000b\"\u0004\b\"\u0010\rR\u001a\u0010#\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000b\"\u0004\b%\u0010\r¨\u0006&"}, mo26107d2 = {"Ltop/defaults/drawabletoolbox/LayerDrawableBuilder$Layer;", "", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "gravity", "", "getGravity", "()I", "setGravity", "(I)V", "height", "getHeight", "setHeight", "insetBottom", "getInsetBottom", "setInsetBottom", "insetEnd", "getInsetEnd", "setInsetEnd", "insetLeft", "getInsetLeft", "setInsetLeft", "insetRight", "getInsetRight", "setInsetRight", "insetStart", "getInsetStart", "setInsetStart", "insetTop", "getInsetTop", "setInsetTop", "width", "getWidth", "setWidth", "drawabletoolbox_release"}, mo26108k = 1, mo26109mv = {1, 1, 11})
    /* compiled from: LayerDrawableBuilder.kt */
    public static final class Layer {
        private Drawable drawable;
        private int gravity;
        private int height = -1;
        private int insetBottom;
        private int insetEnd = Integer.MIN_VALUE;
        private int insetLeft;
        private int insetRight;
        private int insetStart = Integer.MIN_VALUE;
        private int insetTop;
        private int width = -1;

        public Layer(Drawable drawable2) {
            Intrinsics.checkParameterIsNotNull(drawable2, "drawable");
            this.drawable = drawable2;
        }

        public final Drawable getDrawable() {
            return this.drawable;
        }

        public final void setDrawable(Drawable drawable2) {
            Intrinsics.checkParameterIsNotNull(drawable2, "<set-?>");
            this.drawable = drawable2;
        }

        public final int getGravity() {
            return this.gravity;
        }

        public final void setGravity(int i) {
            this.gravity = i;
        }

        public final int getWidth() {
            return this.width;
        }

        public final void setWidth(int i) {
            this.width = i;
        }

        public final int getHeight() {
            return this.height;
        }

        public final void setHeight(int i) {
            this.height = i;
        }

        public final int getInsetLeft() {
            return this.insetLeft;
        }

        public final void setInsetLeft(int i) {
            this.insetLeft = i;
        }

        public final int getInsetTop() {
            return this.insetTop;
        }

        public final void setInsetTop(int i) {
            this.insetTop = i;
        }

        public final int getInsetRight() {
            return this.insetRight;
        }

        public final void setInsetRight(int i) {
            this.insetRight = i;
        }

        public final int getInsetBottom() {
            return this.insetBottom;
        }

        public final void setInsetBottom(int i) {
            this.insetBottom = i;
        }

        public final int getInsetStart() {
            return this.insetStart;
        }

        public final void setInsetStart(int i) {
            this.insetStart = i;
        }

        public final int getInsetEnd() {
            return this.insetEnd;
        }

        public final void setInsetEnd(int i) {
            this.insetEnd = i;
        }
    }
}
