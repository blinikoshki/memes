package editor.editor.equipment.text;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannedString;
import android.text.TextPaint;
import android.view.ViewGroup;
import androidx.core.widget.TextViewCompat;
import editor.editor.equipment.core.CoreLayer;
import editor.optionsui.text.textfont.TextFont;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u000e\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\fJ\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u000e\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020#R\u000e\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, mo26107d2 = {"Leditor/editor/equipment/text/TextLayer;", "Leditor/editor/equipment/core/CoreLayer;", "Leditor/editor/equipment/text/TextLayerView;", "textView", "(Leditor/editor/equipment/text/TextLayerView;)V", "getTextLineCount", "", "setHintTextColor", "", "color", "setLetterSpacing", "spacing", "", "setLineSpacing", "setText", "spannedString", "Landroid/text/SpannedString;", "text", "", "setTextAutoSizeEnabled", "enabled", "", "setTextColor", "setTextGravity", "textGravity", "setTextMargin", "margin", "setTextSizePixels", "size", "setTextUnderline", "setTypeface", "typeface", "Landroid/graphics/Typeface;", "setTypefaceFrom", "textFont", "Leditor/optionsui/text/textfont/TextFont;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextLayer.kt */
public final class TextLayer extends CoreLayer<TextLayerView> {
    private final TextLayerView textView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextLayer(TextLayerView textLayerView) {
        super(textLayerView);
        Intrinsics.checkNotNullParameter(textLayerView, "textView");
        this.textView = textLayerView;
    }

    public final void setText(String str) {
        this.textView.setText(str);
    }

    public final void setText(SpannedString spannedString) {
        Intrinsics.checkNotNullParameter(spannedString, "spannedString");
        this.textView.setText(spannedString);
    }

    public final void setTextColor(int i) {
        this.textView.setTextColor(i);
    }

    public final void setHintTextColor(int i) {
        this.textView.setHintTextColor(i);
    }

    public final void setTextSizePixels(float f) {
        this.textView.setTextSize(0, f);
    }

    public final void setTextAutoSizeEnabled(boolean z) {
        if (z) {
            int[] iArr = new int[96];
            for (int i = 0; i < 96; i++) {
                iArr[i] = i + 4;
            }
            TextViewCompat.setAutoSizeTextTypeUniformWithPresetSizes(this.textView, iArr, 2);
            return;
        }
        TextViewCompat.setAutoSizeTextTypeWithDefaults(this.textView, 0);
    }

    public final void setTextMargin(int i) {
        ViewGroup.LayoutParams layoutParams = this.textView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(i, i, i, i);
        this.textView.setLayoutParams(marginLayoutParams);
    }

    public final void setTextGravity(int i) {
        this.textView.setGravity(i);
    }

    public final void setTypeface(Typeface typeface) {
        this.textView.setTypeface(typeface);
    }

    public final void setTypefaceFrom(TextFont textFont) {
        Intrinsics.checkNotNullParameter(textFont, "textFont");
        Context context = this.textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "textView.context");
        setTypeface(textFont.toTypeface(context));
    }

    @Deprecated(message = "Unused")
    public final void setTextUnderline(boolean z) {
        TextPaint paint = this.textView.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "textView.paint");
        paint.setUnderlineText(z);
    }

    public final void setLetterSpacing(float f) {
        this.textView.setLetterSpacing(f);
    }

    public final void setLineSpacing(float f) {
        this.textView.setLineSpacing(0.0f, f);
    }

    public final int getTextLineCount() {
        return this.textView.getLineCount();
    }
}
