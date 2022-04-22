package wireframe.language.elements;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wireframe.language.common.WfComponent;
import wireframe.language.properties.WfColor;
import wireframe.language.properties.WfCorner;
import wireframe.language.properties.WfDimension;
import wireframe.language.properties.WfGravity;
import wireframe.language.properties.WfMargin;
import wireframe.language.properties.WfPadding;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0006J\u0006\u0010\u0017\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\nJ\u0006\u0010\u0019\u001a\u00020\fJ\u0006\u0010\u001a\u001a\u00020\u000eJ\u0006\u0010\u001b\u001a\u00020\u0010J\u0006\u0010\u001c\u001a\u00020\u0010J\u0006\u0010\u001d\u001a\u00020\u0013J\u0006\u0010\u001e\u001a\u00020\nJ\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0004J\u000e\u0010$\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010%\u001a\u00020\"2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u0013J\u000e\u0010&\u001a\u00020\"2\u0006\u0010(\u001a\u00020\nJ&\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u0013J\u000e\u0010)\u001a\u00020\"2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010.\u001a\u00020\"2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010/\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u00100\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\u0013J\u000e\u00103\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u0013J\u000e\u00103\u001a\u00020\"2\u0006\u0010(\u001a\u00020\nR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u00064"}, mo26107d2 = {"Lwireframe/language/elements/WfElement;", "Lwireframe/language/common/WfComponent;", "()V", "bgColor", "Lwireframe/language/properties/WfColor;", "corner", "Lwireframe/language/properties/WfCorner;", "gravityInParent", "Lwireframe/language/properties/WfGravity;", "height", "Lwireframe/language/properties/WfDimension;", "margin", "Lwireframe/language/properties/WfMargin;", "padding", "Lwireframe/language/properties/WfPadding;", "rotation", "", "scale", "weight", "", "width", "getBackgroundColor", "getCorner", "getGravityInParent", "getHeight", "getMargin", "getPadding", "getRotation", "getScale", "getWeight", "getWidth", "hasBackgroundColor", "", "setBackgroundColor", "", "color", "setCorner", "setGravityInParent", "setHeight", "percentage", "dimension", "setMargin", "left", "top", "right", "bottom", "setPadding", "setRotation", "setScale", "setWeight", "value", "setWidth", "wireframe-lang"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: WfElement.kt */
public class WfElement implements WfComponent {
    private WfColor bgColor;
    private WfCorner corner = new WfCorner();
    private WfGravity gravityInParent = WfGravity.NONE;
    private WfDimension height = WfDimension.WrapContent.INSTANCE;
    private WfMargin margin = new WfMargin();
    private WfPadding padding = new WfPadding();
    private float rotation;
    private float scale = 1.0f;
    private int weight;
    private WfDimension width = WfDimension.WrapContent.INSTANCE;

    public final WfDimension getWidth() {
        return this.width;
    }

    public final void setWidth(WfDimension wfDimension) {
        Intrinsics.checkNotNullParameter(wfDimension, ViewHierarchyConstants.DIMENSION_KEY);
        this.width = wfDimension;
    }

    public final void setWidth(int i) {
        this.width = new WfDimension.Percentage(i);
    }

    public final WfDimension getHeight() {
        return this.height;
    }

    public final void setHeight(WfDimension wfDimension) {
        Intrinsics.checkNotNullParameter(wfDimension, ViewHierarchyConstants.DIMENSION_KEY);
        this.height = wfDimension;
    }

    public final void setHeight(int i) {
        this.height = new WfDimension.Percentage(i);
    }

    public final int getWeight() {
        return this.weight;
    }

    public final void setWeight(int i) {
        this.weight = i;
    }

    public final WfGravity getGravityInParent() {
        return this.gravityInParent;
    }

    public final void setGravityInParent(WfGravity wfGravity) {
        Intrinsics.checkNotNullParameter(wfGravity, "gravityInParent");
        this.gravityInParent = wfGravity;
    }

    public final WfMargin getMargin() {
        return this.margin;
    }

    public final void setMargin(WfMargin wfMargin) {
        Intrinsics.checkNotNullParameter(wfMargin, "margin");
        this.margin = wfMargin;
    }

    public final void setMargin(int i, int i2, int i3, int i4) {
        this.margin = new WfMargin(i, i2, i3, i4);
    }

    public final WfPadding getPadding() {
        return this.padding;
    }

    public final void setPadding(WfPadding wfPadding) {
        Intrinsics.checkNotNullParameter(wfPadding, "padding");
        this.padding = wfPadding;
    }

    public final boolean hasBackgroundColor() {
        return this.bgColor != null;
    }

    public final WfColor getBackgroundColor() {
        WfColor wfColor = this.bgColor;
        if (wfColor != null) {
            return wfColor;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void setBackgroundColor(WfColor wfColor) {
        Intrinsics.checkNotNullParameter(wfColor, TtmlNode.ATTR_TTS_COLOR);
        this.bgColor = wfColor;
    }

    public final WfCorner getCorner() {
        return this.corner;
    }

    public final void setCorner(WfCorner wfCorner) {
        Intrinsics.checkNotNullParameter(wfCorner, "corner");
        this.corner = wfCorner;
    }

    public final float getRotation() {
        return this.rotation;
    }

    public final void setRotation(float f) {
        this.rotation = f;
    }

    public final float getScale() {
        return this.scale;
    }

    public final void setScale(float f) {
        this.scale = f;
    }
}
