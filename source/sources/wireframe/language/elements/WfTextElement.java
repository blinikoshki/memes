package wireframe.language.elements;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wireframe.language.properties.WfColor;
import wireframe.language.properties.WfGravity;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u0006J\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo26107d2 = {"Lwireframe/language/elements/WfTextElement;", "Lwireframe/language/elements/WfElement;", "()V", "contentGravity", "Lwireframe/language/properties/WfGravity;", "textBold", "", "textColor", "Lwireframe/language/properties/WfColor;", "textItalic", "textUnderlined", "getContentGravity", "getTextColor", "hasContentGravity", "hasTextColor", "isTextBold", "isTextItalic", "isTextUnderlined", "setContentGravity", "", "gravity", "setIsTextBold", "isBold", "setIsTextItalic", "isItalic", "setIsTextUnderlined", "isUnderlined", "setTextColor", "color", "wireframe-lang"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: WfTextElement.kt */
public final class WfTextElement extends WfElement {
    private WfGravity contentGravity;
    private boolean textBold;
    private WfColor textColor;
    private boolean textItalic;
    private boolean textUnderlined;

    public final boolean hasContentGravity() {
        return this.contentGravity != null;
    }

    public final WfGravity getContentGravity() {
        return this.contentGravity;
    }

    public final void setContentGravity(WfGravity wfGravity) {
        Intrinsics.checkNotNullParameter(wfGravity, "gravity");
        this.contentGravity = wfGravity;
    }

    public final boolean hasTextColor() {
        return this.textColor != null;
    }

    public final WfColor getTextColor() {
        WfColor wfColor = this.textColor;
        if (wfColor != null) {
            return wfColor;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void setTextColor(WfColor wfColor) {
        Intrinsics.checkNotNullParameter(wfColor, TtmlNode.ATTR_TTS_COLOR);
        this.textColor = wfColor;
    }

    public final boolean isTextBold() {
        return this.textBold;
    }

    public final void setIsTextBold(boolean z) {
        this.textBold = z;
    }

    public final boolean isTextItalic() {
        return this.textItalic;
    }

    public final void setIsTextItalic(boolean z) {
        this.textItalic = z;
    }

    public final boolean isTextUnderlined() {
        return this.textUnderlined;
    }

    public final void setIsTextUnderlined(boolean z) {
        this.textUnderlined = z;
    }
}
