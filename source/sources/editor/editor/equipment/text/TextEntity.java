package editor.editor.equipment.text;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.memes.editor.C4175R;
import editor.editor.equipment.core.CoreEntity;
import editor.editor.equipment.property.NicoProperty;
import editor.editor.equipment.property.NicoPropertyBundle;
import editor.editor.equipment.property.TextProperty;
import editor.optionsui.text.textedit.TextFontStyle;
import editor.util.ColorUtil;
import editor.util.TextPropertyUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001'B\u0017\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000fH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0010H\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0011H\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0012H\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0013H\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0014H\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0015H\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0016H\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0017H\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0018H\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0019H\u0002J\u000e\u0010\u001a\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!H\u0016J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020\fH\u0014R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006("}, mo26107d2 = {"Leditor/editor/equipment/text/TextEntity;", "Leditor/editor/equipment/core/CoreEntity;", "Leditor/editor/equipment/text/TextLayer;", "Leditor/editor/equipment/text/TextStyle;", "layer", "style", "(Leditor/editor/equipment/text/TextLayer;Leditor/editor/equipment/text/TextStyle;)V", "token", "", "getToken", "()Ljava/lang/String;", "apply", "", "property", "Leditor/editor/equipment/property/TextProperty$Alignment;", "Leditor/editor/equipment/property/TextProperty$Caps;", "Leditor/editor/equipment/property/TextProperty$Font;", "Leditor/editor/equipment/property/TextProperty$FontStyle;", "Leditor/editor/equipment/property/TextProperty$LetterSpacing;", "Leditor/editor/equipment/property/TextProperty$LineSpacing;", "Leditor/editor/equipment/property/TextProperty$Text;", "Leditor/editor/equipment/property/TextProperty$TextAutoSize;", "Leditor/editor/equipment/property/TextProperty$TextColor;", "Leditor/editor/equipment/property/TextProperty$TextMargin;", "Leditor/editor/equipment/property/TextProperty$TextSize;", "Leditor/editor/equipment/property/TextProperty$Watermark;", "applyProperty", "Leditor/editor/equipment/property/TextProperty;", "applyPropertyBundle", "bundle", "Leditor/editor/equipment/property/NicoPropertyBundle;", "duplicate", "parent", "Landroid/view/ViewGroup;", "getTextLineCount", "", "isDefault", "", "refreshStyle", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextEntity.kt */
public final class TextEntity extends CoreEntity<TextLayer, TextStyle> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String token;

    public /* synthetic */ TextEntity(TextLayer textLayer, TextStyle textStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(textLayer, textStyle);
    }

    private TextEntity(TextLayer textLayer, TextStyle textStyle) {
        super(textLayer, textStyle);
        this.token = createEntityToken("text");
        refreshStyle();
    }

    public String getToken() {
        return this.token;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\r"}, mo26107d2 = {"Leditor/editor/equipment/text/TextEntity$Companion;", "", "()V", "create", "Leditor/editor/equipment/text/TextEntity;", "parent", "Landroid/view/ViewGroup;", "style", "Leditor/editor/equipment/text/TextStyle;", "textPaddingPixel", "", "context", "Landroid/content/Context;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: TextEntity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int textPaddingPixel(Context context) {
            return context.getResources().getDimensionPixelSize(C4175R.dimen._2sdp);
        }

        public static /* synthetic */ TextEntity create$default(Companion companion, ViewGroup viewGroup, TextStyle textStyle, int i, Object obj) {
            if ((i & 2) != 0) {
                textStyle = new TextStyle();
            }
            return companion.create(viewGroup, textStyle);
        }

        public final TextEntity create(ViewGroup viewGroup, TextStyle textStyle) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            Intrinsics.checkNotNullParameter(textStyle, "style");
            Context context = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            TextLayerView textLayerView = new TextLayerView(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
            textLayerView.setLayoutParams(new ViewGroup.MarginLayoutParams(context.getResources().getDimensionPixelSize(C4175R.dimen._100sdp), context.getResources().getDimensionPixelSize(C4175R.dimen._100sdp)));
            Context context2 = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
            int textPaddingPixel = textPaddingPixel(context2);
            View view = textLayerView;
            view.setPadding(textPaddingPixel, textPaddingPixel, textPaddingPixel, textPaddingPixel);
            viewGroup.addView(view);
            TextLayer textLayer = new TextLayer(textLayerView);
            textLayer.getLifecycle().onAdding();
            return new TextEntity(textLayer, textStyle, (DefaultConstructorMarker) null);
        }
    }

    public TextEntity duplicate(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        TextStyle textStyle = new TextStyle();
        ((TextStyle) getStyle()).copy(textStyle);
        TextEntity create = Companion.create(viewGroup, textStyle);
        create.hide();
        ((TextLayer) create.getLayer()).post(new TextEntity$duplicate$1(this, create));
        return create;
    }

    public final boolean isDefault() {
        String text = ((TextStyle) getStyle()).getText();
        CharSequence charSequence = text;
        return (charSequence == null || StringsKt.isBlank(charSequence)) || Intrinsics.areEqual((Object) text, (Object) TextConfig.DEFAULT_TEXT);
    }

    public final int getTextLineCount() {
        return ((TextLayer) getLayer()).getTextLineCount();
    }

    /* access modifiers changed from: protected */
    public void refreshStyle() {
        TextStyle textStyle = (TextStyle) getStyle();
        applyPropertyBundle(NicoPropertyBundle.Companion.from(getToken(), new TextProperty.Text(textStyle.getText()), new TextProperty.TextColor(textStyle.getColor()), new TextProperty.TextSize(textStyle.getTextSize()), new TextProperty.TextAutoSize(textStyle.getTextAutoSize()), new TextProperty.TextMargin(textStyle.getMargin()), new TextProperty.Alignment(textStyle.getAlignment()), new TextProperty.FontStyle(textStyle.getFontStyle()), new TextProperty.Caps(textStyle.getCapMode()), new TextProperty.Font(textStyle.getFont()), new TextProperty.LetterSpacing(textStyle.getLetterSpacing()), new TextProperty.LineSpacing(textStyle.getLineSpacing()), new TextProperty.Watermark(textStyle.isWatermark())));
        super.refreshStyle();
    }

    public void applyPropertyBundle(NicoPropertyBundle nicoPropertyBundle) {
        Intrinsics.checkNotNullParameter(nicoPropertyBundle, "bundle");
        for (NicoProperty next : nicoPropertyBundle.getProperties()) {
            if (next instanceof TextProperty) {
                applyProperty((TextProperty) next);
            } else {
                applyProperty(next);
            }
        }
    }

    public final void applyProperty(TextProperty textProperty) {
        Intrinsics.checkNotNullParameter(textProperty, "property");
        if (textProperty instanceof TextProperty.Text) {
            apply((TextProperty.Text) textProperty);
        } else if (textProperty instanceof TextProperty.TextColor) {
            apply((TextProperty.TextColor) textProperty);
        } else if (textProperty instanceof TextProperty.TextSize) {
            apply((TextProperty.TextSize) textProperty);
        } else if (textProperty instanceof TextProperty.TextAutoSize) {
            apply((TextProperty.TextAutoSize) textProperty);
        } else if (textProperty instanceof TextProperty.TextMargin) {
            apply((TextProperty.TextMargin) textProperty);
        } else if (textProperty instanceof TextProperty.Alignment) {
            apply((TextProperty.Alignment) textProperty);
        } else if (textProperty instanceof TextProperty.FontStyle) {
            apply((TextProperty.FontStyle) textProperty);
        } else if (textProperty instanceof TextProperty.Caps) {
            apply((TextProperty.Caps) textProperty);
        } else if (textProperty instanceof TextProperty.Font) {
            apply((TextProperty.Font) textProperty);
        } else if (textProperty instanceof TextProperty.LetterSpacing) {
            apply((TextProperty.LetterSpacing) textProperty);
        } else if (textProperty instanceof TextProperty.LineSpacing) {
            apply((TextProperty.LineSpacing) textProperty);
        } else if (textProperty instanceof TextProperty.Watermark) {
            apply((TextProperty.Watermark) textProperty);
        }
        notifyPropertyApplied(textProperty);
    }

    private final void apply(TextProperty.Text text) {
        ((TextStyle) getStyle()).setText(text.getValue());
        ((TextLayer) getLayer()).setText(text.getValue());
        apply(new TextProperty.FontStyle(((TextStyle) getStyle()).getFontStyle()));
    }

    private final void apply(TextProperty.TextColor textColor) {
        ((TextStyle) getStyle()).setColor(textColor.getValue());
        int colorHexToInt = ColorUtil.INSTANCE.colorHexToInt(textColor.getValue());
        ((TextLayer) getLayer()).setTextColor(colorHexToInt);
        ((TextLayer) getLayer()).setHintTextColor(colorHexToInt);
    }

    private final void apply(TextProperty.TextSize textSize) {
        ((TextStyle) getStyle()).setTextSize(textSize.getValue());
        ((TextLayer) getLayer()).setTextSizePixels(textSize.getValue());
    }

    private final void apply(TextProperty.TextAutoSize textAutoSize) {
        ((TextStyle) getStyle()).setTextAutoSize(textAutoSize.getEnabled());
        ((TextLayer) getLayer()).setTextAutoSizeEnabled(textAutoSize.getEnabled());
    }

    private final void apply(TextProperty.TextMargin textMargin) {
        ((TextStyle) getStyle()).setMargin(textMargin.getValue());
        ((TextLayer) getLayer()).setTextMargin(TextPropertyUtil.INSTANCE.marginPercentToValue(textMargin.getValue()));
    }

    private final void apply(TextProperty.Alignment alignment) {
        ((TextStyle) getStyle()).setAlignment(alignment.getValue());
        ((TextLayer) getLayer()).setTextGravity(TextPropertyUtil.INSTANCE.alignmentToGravity(alignment.getValue()));
    }

    private final void apply(TextProperty.Font font) {
        ((TextStyle) getStyle()).setFont(font.getValue());
        ((TextLayer) getLayer()).setTypefaceFrom(font.getValue());
    }

    private final void apply(TextProperty.FontStyle fontStyle) {
        ((TextStyle) getStyle()).setFontStyle(fontStyle.getValue());
        String text = ((TextStyle) getStyle()).getText();
        if (text != null) {
            TextFontStyle value = fontStyle.getValue();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!value.getBold() && !value.getItalic() && !value.getUnderline()) {
                Intrinsics.checkNotNullExpressionValue(spannableStringBuilder.append(text), "append(text)");
            } else if (value.getBold() && value.getItalic() && value.getUnderline()) {
                StyleSpan styleSpan = new StyleSpan(1);
                int length = spannableStringBuilder.length();
                StyleSpan styleSpan2 = new StyleSpan(2);
                int length2 = spannableStringBuilder.length();
                UnderlineSpan underlineSpan = new UnderlineSpan();
                int length3 = spannableStringBuilder.length();
                spannableStringBuilder.append(text);
                spannableStringBuilder.setSpan(underlineSpan, length3, spannableStringBuilder.length(), 17);
                spannableStringBuilder.setSpan(styleSpan2, length2, spannableStringBuilder.length(), 17);
                spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
            } else if (value.getBold() && value.getItalic()) {
                StyleSpan styleSpan3 = new StyleSpan(1);
                int length4 = spannableStringBuilder.length();
                StyleSpan styleSpan4 = new StyleSpan(2);
                int length5 = spannableStringBuilder.length();
                spannableStringBuilder.append(text);
                spannableStringBuilder.setSpan(styleSpan4, length5, spannableStringBuilder.length(), 17);
                spannableStringBuilder.setSpan(styleSpan3, length4, spannableStringBuilder.length(), 17);
            } else if (value.getBold() && value.getUnderline()) {
                StyleSpan styleSpan5 = new StyleSpan(1);
                int length6 = spannableStringBuilder.length();
                UnderlineSpan underlineSpan2 = new UnderlineSpan();
                int length7 = spannableStringBuilder.length();
                spannableStringBuilder.append(text);
                spannableStringBuilder.setSpan(underlineSpan2, length7, spannableStringBuilder.length(), 17);
                spannableStringBuilder.setSpan(styleSpan5, length6, spannableStringBuilder.length(), 17);
            } else if (value.getItalic() && value.getUnderline()) {
                StyleSpan styleSpan6 = new StyleSpan(2);
                int length8 = spannableStringBuilder.length();
                UnderlineSpan underlineSpan3 = new UnderlineSpan();
                int length9 = spannableStringBuilder.length();
                spannableStringBuilder.append(text);
                spannableStringBuilder.setSpan(underlineSpan3, length9, spannableStringBuilder.length(), 17);
                spannableStringBuilder.setSpan(styleSpan6, length8, spannableStringBuilder.length(), 17);
            } else if (value.getBold()) {
                StyleSpan styleSpan7 = new StyleSpan(1);
                int length10 = spannableStringBuilder.length();
                spannableStringBuilder.append(text);
                spannableStringBuilder.setSpan(styleSpan7, length10, spannableStringBuilder.length(), 17);
            } else if (value.getItalic()) {
                StyleSpan styleSpan8 = new StyleSpan(2);
                int length11 = spannableStringBuilder.length();
                spannableStringBuilder.append(text);
                spannableStringBuilder.setSpan(styleSpan8, length11, spannableStringBuilder.length(), 17);
            } else if (value.getUnderline()) {
                UnderlineSpan underlineSpan4 = new UnderlineSpan();
                int length12 = spannableStringBuilder.length();
                spannableStringBuilder.append(text);
                spannableStringBuilder.setSpan(underlineSpan4, length12, spannableStringBuilder.length(), 17);
            }
            if (value.getItalic()) {
                spannableStringBuilder.append("  ");
            }
            ((TextLayer) getLayer()).setText(new SpannedString(spannableStringBuilder));
        }
    }

    private final void apply(TextProperty.Caps caps) {
        ((TextStyle) getStyle()).setCapMode(caps.getValue());
        ((TextStyle) getStyle()).setText(TextPropertyUtil.INSTANCE.transformTextToCapMode(caps.getValue(), ((TextStyle) getStyle()).getText()));
        apply(new TextProperty.FontStyle(((TextStyle) getStyle()).getFontStyle()));
    }

    private final void apply(TextProperty.LetterSpacing letterSpacing) {
        ((TextStyle) getStyle()).setLetterSpacing(letterSpacing.getValue());
        ((TextLayer) getLayer()).setLetterSpacing(letterSpacing.getValue());
    }

    private final void apply(TextProperty.LineSpacing lineSpacing) {
        ((TextStyle) getStyle()).setLineSpacing(lineSpacing.getValue());
        ((TextLayer) getLayer()).setLineSpacing(lineSpacing.getValue());
    }

    private final void apply(TextProperty.Watermark watermark) {
        ((TextStyle) getStyle()).setWatermark(watermark.getValue());
    }
}
