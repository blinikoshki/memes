package editor.tools.wftransformer;

import android.graphics.Rect;
import editor.editor.equipment.property.NicoProperty;
import editor.editor.equipment.property.TextProperty;
import editor.editor.equipment.text.TextEntity;
import editor.optionsui.layerpaint.LayerPaint;
import editor.optionsui.text.textedit.TextFontStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wireframe.language.elements.WfLayoutElement;
import wireframe.language.elements.WfTextElement;
import wireframe.language.properties.WfMargin;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ.\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo26107d2 = {"Leditor/tools/wftransformer/WfTextTransformer;", "Leditor/tools/wftransformer/WfElementTransformer;", "()V", "element", "Lwireframe/language/elements/WfTextElement;", "elementRect", "Landroid/graphics/Rect;", "parent", "Lwireframe/language/elements/WfLayoutElement;", "parentRect", "transform", "", "entity", "Leditor/editor/equipment/text/TextEntity;", "with", "parentElement", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: WfTextTransformer.kt */
public final class WfTextTransformer extends WfElementTransformer {
    private WfTextElement element;
    private Rect elementRect;
    private WfLayoutElement parent;
    private Rect parentRect;

    public static /* synthetic */ WfTextTransformer with$default(WfTextTransformer wfTextTransformer, WfTextElement wfTextElement, Rect rect, WfLayoutElement wfLayoutElement, Rect rect2, int i, Object obj) {
        if ((i & 4) != 0) {
            wfLayoutElement = null;
        }
        if ((i & 8) != 0) {
            rect2 = null;
        }
        return wfTextTransformer.with(wfTextElement, rect, wfLayoutElement, rect2);
    }

    public final WfTextTransformer with(WfTextElement wfTextElement, Rect rect, WfLayoutElement wfLayoutElement, Rect rect2) {
        Intrinsics.checkNotNullParameter(wfTextElement, "element");
        Intrinsics.checkNotNullParameter(rect, "elementRect");
        this.element = wfTextElement;
        this.elementRect = rect;
        this.parent = wfLayoutElement;
        this.parentRect = rect2;
        return this;
    }

    public final void transform(TextEntity textEntity) {
        Intrinsics.checkNotNullParameter(textEntity, "entity");
        WfTextElement wfTextElement = this.element;
        if (wfTextElement == null) {
            Intrinsics.throwUninitializedPropertyAccessException("element");
        }
        WfMargin margin = wfTextElement.getMargin();
        Rect rect = this.elementRect;
        if (rect == null) {
            Intrinsics.throwUninitializedPropertyAccessException("elementRect");
        }
        int left = rect.left + margin.getLeft();
        Rect rect2 = this.elementRect;
        if (rect2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("elementRect");
        }
        int top2 = rect2.top + margin.getTop();
        Rect rect3 = this.elementRect;
        if (rect3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("elementRect");
        }
        int right = rect3.right - margin.getRight();
        Rect rect4 = this.elementRect;
        if (rect4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("elementRect");
        }
        Rect rect5 = new Rect(left, top2, right, rect4.bottom - margin.getBottom());
        WfTextElement wfTextElement2 = this.element;
        if (wfTextElement2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("element");
        }
        boolean isTextBold = wfTextElement2.isTextBold();
        WfTextElement wfTextElement3 = this.element;
        if (wfTextElement3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("element");
        }
        boolean isTextItalic = wfTextElement3.isTextItalic();
        WfTextElement wfTextElement4 = this.element;
        if (wfTextElement4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("element");
        }
        textEntity.applyProperty(new TextProperty.FontStyle(new TextFontStyle(isTextBold, isTextItalic, wfTextElement4.isTextUnderlined())));
        WfTextElement wfTextElement5 = this.element;
        if (wfTextElement5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("element");
        }
        if (wfTextElement5.hasTextColor()) {
            WfTextElement wfTextElement6 = this.element;
            if (wfTextElement6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("element");
            }
            textEntity.applyProperty(new TextProperty.TextColor(wfTextElement6.getTextColor().getHexColor()));
        }
        WfTextElement wfTextElement7 = this.element;
        if (wfTextElement7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("element");
        }
        if (wfTextElement7.hasBackgroundColor()) {
            WfTextElement wfTextElement8 = this.element;
            if (wfTextElement8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("element");
            }
            textEntity.applyProperty(new NicoProperty.Background(new LayerPaint.Color(wfTextElement8.getBackgroundColor().getHexColor())));
        }
        WfTextElement wfTextElement9 = this.element;
        if (wfTextElement9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("element");
        }
        positionEntityToRect(wfTextElement9, textEntity, rect5);
    }
}
