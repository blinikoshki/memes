package editor.editor.equipment.property;

import editor.optionsui.text.textedit.TextAlignment;
import editor.optionsui.text.textedit.TextCapMode;
import editor.optionsui.text.textedit.TextFontStyle;
import editor.optionsui.text.textfont.TextFont;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\f\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004\u0001\f\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c¨\u0006\u001d"}, mo26107d2 = {"Leditor/editor/equipment/property/TextProperty;", "Leditor/editor/equipment/property/NicoProperty;", "identifier", "", "(Ljava/lang/String;)V", "Alignment", "Caps", "Font", "FontStyle", "LetterSpacing", "LineSpacing", "Text", "TextAutoSize", "TextColor", "TextMargin", "TextSize", "Watermark", "Leditor/editor/equipment/property/TextProperty$Text;", "Leditor/editor/equipment/property/TextProperty$TextColor;", "Leditor/editor/equipment/property/TextProperty$TextSize;", "Leditor/editor/equipment/property/TextProperty$TextAutoSize;", "Leditor/editor/equipment/property/TextProperty$TextMargin;", "Leditor/editor/equipment/property/TextProperty$Alignment;", "Leditor/editor/equipment/property/TextProperty$Font;", "Leditor/editor/equipment/property/TextProperty$FontStyle;", "Leditor/editor/equipment/property/TextProperty$Caps;", "Leditor/editor/equipment/property/TextProperty$LetterSpacing;", "Leditor/editor/equipment/property/TextProperty$LineSpacing;", "Leditor/editor/equipment/property/TextProperty$Watermark;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NicoProperty.kt */
public abstract class TextProperty extends NicoProperty {
    private TextProperty(String str) {
        super(str, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ TextProperty(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Leditor/editor/equipment/property/TextProperty$Text;", "Leditor/editor/equipment/property/TextProperty;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoProperty.kt */
    public static final class Text extends TextProperty {
        private final String value;

        public static /* synthetic */ Text copy$default(Text text, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = text.value;
            }
            return text.copy(str);
        }

        public final String component1() {
            return this.value;
        }

        public final Text copy(String str) {
            return new Text(str);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Text) && Intrinsics.areEqual((Object) this.value, (Object) ((Text) obj).value);
            }
            return true;
        }

        public int hashCode() {
            String str = this.value;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Text(value=" + this.value + ")";
        }

        public final String getValue() {
            return this.value;
        }

        public Text(String str) {
            super("text", (DefaultConstructorMarker) null);
            this.value = str;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Leditor/editor/equipment/property/TextProperty$TextColor;", "Leditor/editor/equipment/property/TextProperty;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoProperty.kt */
    public static final class TextColor extends TextProperty {
        private final String value;

        public static /* synthetic */ TextColor copy$default(TextColor textColor, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = textColor.value;
            }
            return textColor.copy(str);
        }

        public final String component1() {
            return this.value;
        }

        public final TextColor copy(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            return new TextColor(str);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof TextColor) && Intrinsics.areEqual((Object) this.value, (Object) ((TextColor) obj).value);
            }
            return true;
        }

        public int hashCode() {
            String str = this.value;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "TextColor(value=" + this.value + ")";
        }

        public final String getValue() {
            return this.value;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TextColor(String str) {
            super("text-color", (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "value");
            this.value = str;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Leditor/editor/equipment/property/TextProperty$TextSize;", "Leditor/editor/equipment/property/TextProperty;", "value", "", "(F)V", "getValue", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoProperty.kt */
    public static final class TextSize extends TextProperty {
        private final float value;

        public static /* synthetic */ TextSize copy$default(TextSize textSize, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = textSize.value;
            }
            return textSize.copy(f);
        }

        public final float component1() {
            return this.value;
        }

        public final TextSize copy(float f) {
            return new TextSize(f);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof TextSize) && Float.compare(this.value, ((TextSize) obj).value) == 0;
            }
            return true;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.value);
        }

        public String toString() {
            return "TextSize(value=" + this.value + ")";
        }

        public final float getValue() {
            return this.value;
        }

        public TextSize(float f) {
            super("text-size", (DefaultConstructorMarker) null);
            this.value = f;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Leditor/editor/equipment/property/TextProperty$TextAutoSize;", "Leditor/editor/equipment/property/TextProperty;", "enabled", "", "(Z)V", "getEnabled", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoProperty.kt */
    public static final class TextAutoSize extends TextProperty {
        private final boolean enabled;

        public static /* synthetic */ TextAutoSize copy$default(TextAutoSize textAutoSize, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = textAutoSize.enabled;
            }
            return textAutoSize.copy(z);
        }

        public final boolean component1() {
            return this.enabled;
        }

        public final TextAutoSize copy(boolean z) {
            return new TextAutoSize(z);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof TextAutoSize) && this.enabled == ((TextAutoSize) obj).enabled;
            }
            return true;
        }

        public int hashCode() {
            boolean z = this.enabled;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "TextAutoSize(enabled=" + this.enabled + ")";
        }

        public final boolean getEnabled() {
            return this.enabled;
        }

        public TextAutoSize(boolean z) {
            super("text-auto-size", (DefaultConstructorMarker) null);
            this.enabled = z;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Leditor/editor/equipment/property/TextProperty$TextMargin;", "Leditor/editor/equipment/property/TextProperty;", "value", "", "(I)V", "getValue", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoProperty.kt */
    public static final class TextMargin extends TextProperty {
        private final int value;

        public static /* synthetic */ TextMargin copy$default(TextMargin textMargin, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = textMargin.value;
            }
            return textMargin.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final TextMargin copy(int i) {
            return new TextMargin(i);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof TextMargin) && this.value == ((TextMargin) obj).value;
            }
            return true;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "TextMargin(value=" + this.value + ")";
        }

        public final int getValue() {
            return this.value;
        }

        public TextMargin(int i) {
            super("margin", (DefaultConstructorMarker) null);
            this.value = i;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Leditor/editor/equipment/property/TextProperty$Alignment;", "Leditor/editor/equipment/property/TextProperty;", "value", "Leditor/optionsui/text/textedit/TextAlignment;", "(Leditor/optionsui/text/textedit/TextAlignment;)V", "getValue", "()Leditor/optionsui/text/textedit/TextAlignment;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoProperty.kt */
    public static final class Alignment extends TextProperty {
        private final TextAlignment value;

        public static /* synthetic */ Alignment copy$default(Alignment alignment, TextAlignment textAlignment, int i, Object obj) {
            if ((i & 1) != 0) {
                textAlignment = alignment.value;
            }
            return alignment.copy(textAlignment);
        }

        public final TextAlignment component1() {
            return this.value;
        }

        public final Alignment copy(TextAlignment textAlignment) {
            Intrinsics.checkNotNullParameter(textAlignment, "value");
            return new Alignment(textAlignment);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Alignment) && Intrinsics.areEqual((Object) this.value, (Object) ((Alignment) obj).value);
            }
            return true;
        }

        public int hashCode() {
            TextAlignment textAlignment = this.value;
            if (textAlignment != null) {
                return textAlignment.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Alignment(value=" + this.value + ")";
        }

        public final TextAlignment getValue() {
            return this.value;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Alignment(TextAlignment textAlignment) {
            super("alignment", (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(textAlignment, "value");
            this.value = textAlignment;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Leditor/editor/equipment/property/TextProperty$Font;", "Leditor/editor/equipment/property/TextProperty;", "value", "Leditor/optionsui/text/textfont/TextFont;", "(Leditor/optionsui/text/textfont/TextFont;)V", "getValue", "()Leditor/optionsui/text/textfont/TextFont;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoProperty.kt */
    public static final class Font extends TextProperty {
        private final TextFont value;

        public static /* synthetic */ Font copy$default(Font font, TextFont textFont, int i, Object obj) {
            if ((i & 1) != 0) {
                textFont = font.value;
            }
            return font.copy(textFont);
        }

        public final TextFont component1() {
            return this.value;
        }

        public final Font copy(TextFont textFont) {
            Intrinsics.checkNotNullParameter(textFont, "value");
            return new Font(textFont);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Font) && Intrinsics.areEqual((Object) this.value, (Object) ((Font) obj).value);
            }
            return true;
        }

        public int hashCode() {
            TextFont textFont = this.value;
            if (textFont != null) {
                return textFont.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Font(value=" + this.value + ")";
        }

        public final TextFont getValue() {
            return this.value;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Font(TextFont textFont) {
            super("font", (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(textFont, "value");
            this.value = textFont;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Leditor/editor/equipment/property/TextProperty$FontStyle;", "Leditor/editor/equipment/property/TextProperty;", "value", "Leditor/optionsui/text/textedit/TextFontStyle;", "(Leditor/optionsui/text/textedit/TextFontStyle;)V", "getValue", "()Leditor/optionsui/text/textedit/TextFontStyle;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoProperty.kt */
    public static final class FontStyle extends TextProperty {
        private final TextFontStyle value;

        public static /* synthetic */ FontStyle copy$default(FontStyle fontStyle, TextFontStyle textFontStyle, int i, Object obj) {
            if ((i & 1) != 0) {
                textFontStyle = fontStyle.value;
            }
            return fontStyle.copy(textFontStyle);
        }

        public final TextFontStyle component1() {
            return this.value;
        }

        public final FontStyle copy(TextFontStyle textFontStyle) {
            Intrinsics.checkNotNullParameter(textFontStyle, "value");
            return new FontStyle(textFontStyle);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof FontStyle) && Intrinsics.areEqual((Object) this.value, (Object) ((FontStyle) obj).value);
            }
            return true;
        }

        public int hashCode() {
            TextFontStyle textFontStyle = this.value;
            if (textFontStyle != null) {
                return textFontStyle.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "FontStyle(value=" + this.value + ")";
        }

        public final TextFontStyle getValue() {
            return this.value;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FontStyle(TextFontStyle textFontStyle) {
            super("font-style", (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(textFontStyle, "value");
            this.value = textFontStyle;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Leditor/editor/equipment/property/TextProperty$Caps;", "Leditor/editor/equipment/property/TextProperty;", "value", "Leditor/optionsui/text/textedit/TextCapMode;", "(Leditor/optionsui/text/textedit/TextCapMode;)V", "getValue", "()Leditor/optionsui/text/textedit/TextCapMode;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoProperty.kt */
    public static final class Caps extends TextProperty {
        private final TextCapMode value;

        public static /* synthetic */ Caps copy$default(Caps caps, TextCapMode textCapMode, int i, Object obj) {
            if ((i & 1) != 0) {
                textCapMode = caps.value;
            }
            return caps.copy(textCapMode);
        }

        public final TextCapMode component1() {
            return this.value;
        }

        public final Caps copy(TextCapMode textCapMode) {
            Intrinsics.checkNotNullParameter(textCapMode, "value");
            return new Caps(textCapMode);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Caps) && Intrinsics.areEqual((Object) this.value, (Object) ((Caps) obj).value);
            }
            return true;
        }

        public int hashCode() {
            TextCapMode textCapMode = this.value;
            if (textCapMode != null) {
                return textCapMode.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Caps(value=" + this.value + ")";
        }

        public final TextCapMode getValue() {
            return this.value;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Caps(TextCapMode textCapMode) {
            super("caps", (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(textCapMode, "value");
            this.value = textCapMode;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Leditor/editor/equipment/property/TextProperty$LetterSpacing;", "Leditor/editor/equipment/property/TextProperty;", "value", "", "(F)V", "getValue", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoProperty.kt */
    public static final class LetterSpacing extends TextProperty {
        private final float value;

        public static /* synthetic */ LetterSpacing copy$default(LetterSpacing letterSpacing, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = letterSpacing.value;
            }
            return letterSpacing.copy(f);
        }

        public final float component1() {
            return this.value;
        }

        public final LetterSpacing copy(float f) {
            return new LetterSpacing(f);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof LetterSpacing) && Float.compare(this.value, ((LetterSpacing) obj).value) == 0;
            }
            return true;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.value);
        }

        public String toString() {
            return "LetterSpacing(value=" + this.value + ")";
        }

        public final float getValue() {
            return this.value;
        }

        public LetterSpacing(float f) {
            super("letter-spacing", (DefaultConstructorMarker) null);
            this.value = f;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Leditor/editor/equipment/property/TextProperty$LineSpacing;", "Leditor/editor/equipment/property/TextProperty;", "value", "", "(F)V", "getValue", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoProperty.kt */
    public static final class LineSpacing extends TextProperty {
        private final float value;

        public static /* synthetic */ LineSpacing copy$default(LineSpacing lineSpacing, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = lineSpacing.value;
            }
            return lineSpacing.copy(f);
        }

        public final float component1() {
            return this.value;
        }

        public final LineSpacing copy(float f) {
            return new LineSpacing(f);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof LineSpacing) && Float.compare(this.value, ((LineSpacing) obj).value) == 0;
            }
            return true;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.value);
        }

        public String toString() {
            return "LineSpacing(value=" + this.value + ")";
        }

        public final float getValue() {
            return this.value;
        }

        public LineSpacing(float f) {
            super("line-spacing", (DefaultConstructorMarker) null);
            this.value = f;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Leditor/editor/equipment/property/TextProperty$Watermark;", "Leditor/editor/equipment/property/TextProperty;", "value", "", "(Z)V", "getValue", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoProperty.kt */
    public static final class Watermark extends TextProperty {
        private final boolean value;

        public static /* synthetic */ Watermark copy$default(Watermark watermark, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = watermark.value;
            }
            return watermark.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final Watermark copy(boolean z) {
            return new Watermark(z);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Watermark) && this.value == ((Watermark) obj).value;
            }
            return true;
        }

        public int hashCode() {
            boolean z = this.value;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "Watermark(value=" + this.value + ")";
        }

        public final boolean getValue() {
            return this.value;
        }

        public Watermark(boolean z) {
            super("watermark", (DefaultConstructorMarker) null);
            this.value = z;
        }
    }
}
