package editor.optionsui.text.textfont;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, mo26107d2 = {"Leditor/optionsui/text/textfont/FontItem;", "", "()V", "Divider", "Placeholder", "Preview", "Leditor/optionsui/text/textfont/FontItem$Preview;", "Leditor/optionsui/text/textfont/FontItem$Divider;", "Leditor/optionsui/text/textfont/FontItem$Placeholder;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FontItem.kt */
public abstract class FontItem {
    private FontItem() {
    }

    public /* synthetic */ FontItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo26107d2 = {"Leditor/optionsui/text/textfont/FontItem$Preview;", "Leditor/optionsui/text/textfont/FontItem;", "fontType", "", "textFont", "Leditor/optionsui/text/textfont/TextFont;", "(Ljava/lang/String;Leditor/optionsui/text/textfont/TextFont;)V", "getFontType", "()Ljava/lang/String;", "getTextFont", "()Leditor/optionsui/text/textfont/TextFont;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: FontItem.kt */
    public static final class Preview extends FontItem {
        private final String fontType;
        private final TextFont textFont;

        public static /* synthetic */ Preview copy$default(Preview preview, String str, TextFont textFont2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = preview.fontType;
            }
            if ((i & 2) != 0) {
                textFont2 = preview.textFont;
            }
            return preview.copy(str, textFont2);
        }

        public final String component1() {
            return this.fontType;
        }

        public final TextFont component2() {
            return this.textFont;
        }

        public final Preview copy(String str, TextFont textFont2) {
            Intrinsics.checkNotNullParameter(str, "fontType");
            Intrinsics.checkNotNullParameter(textFont2, "textFont");
            return new Preview(str, textFont2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Preview)) {
                return false;
            }
            Preview preview = (Preview) obj;
            return Intrinsics.areEqual((Object) this.fontType, (Object) preview.fontType) && Intrinsics.areEqual((Object) this.textFont, (Object) preview.textFont);
        }

        public int hashCode() {
            String str = this.fontType;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            TextFont textFont2 = this.textFont;
            if (textFont2 != null) {
                i = textFont2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "Preview(fontType=" + this.fontType + ", textFont=" + this.textFont + ")";
        }

        public final String getFontType() {
            return this.fontType;
        }

        public final TextFont getTextFont() {
            return this.textFont;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Preview(String str, TextFont textFont2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "fontType");
            Intrinsics.checkNotNullParameter(textFont2, "textFont");
            this.fontType = str;
            this.textFont = textFont2;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, mo26107d2 = {"Leditor/optionsui/text/textfont/FontItem$Divider;", "Leditor/optionsui/text/textfont/FontItem;", "beforeFontType", "", "afterFontType", "(Ljava/lang/String;Ljava/lang/String;)V", "getAfterFontType", "()Ljava/lang/String;", "getBeforeFontType", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: FontItem.kt */
    public static final class Divider extends FontItem {
        private final String afterFontType;
        private final String beforeFontType;

        public static /* synthetic */ Divider copy$default(Divider divider, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = divider.beforeFontType;
            }
            if ((i & 2) != 0) {
                str2 = divider.afterFontType;
            }
            return divider.copy(str, str2);
        }

        public final String component1() {
            return this.beforeFontType;
        }

        public final String component2() {
            return this.afterFontType;
        }

        public final Divider copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "beforeFontType");
            Intrinsics.checkNotNullParameter(str2, "afterFontType");
            return new Divider(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Divider)) {
                return false;
            }
            Divider divider = (Divider) obj;
            return Intrinsics.areEqual((Object) this.beforeFontType, (Object) divider.beforeFontType) && Intrinsics.areEqual((Object) this.afterFontType, (Object) divider.afterFontType);
        }

        public int hashCode() {
            String str = this.beforeFontType;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.afterFontType;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "Divider(beforeFontType=" + this.beforeFontType + ", afterFontType=" + this.afterFontType + ")";
        }

        public final String getBeforeFontType() {
            return this.beforeFontType;
        }

        public final String getAfterFontType() {
            return this.afterFontType;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Divider(String str, String str2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "beforeFontType");
            Intrinsics.checkNotNullParameter(str2, "afterFontType");
            this.beforeFontType = str;
            this.afterFontType = str2;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Leditor/optionsui/text/textfont/FontItem$Placeholder;", "Leditor/optionsui/text/textfont/FontItem;", "fontType", "", "(Ljava/lang/String;)V", "getFontType", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: FontItem.kt */
    public static final class Placeholder extends FontItem {
        private final String fontType;

        public static /* synthetic */ Placeholder copy$default(Placeholder placeholder, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = placeholder.fontType;
            }
            return placeholder.copy(str);
        }

        public final String component1() {
            return this.fontType;
        }

        public final Placeholder copy(String str) {
            Intrinsics.checkNotNullParameter(str, "fontType");
            return new Placeholder(str);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Placeholder) && Intrinsics.areEqual((Object) this.fontType, (Object) ((Placeholder) obj).fontType);
            }
            return true;
        }

        public int hashCode() {
            String str = this.fontType;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Placeholder(fontType=" + this.fontType + ")";
        }

        public final String getFontType() {
            return this.fontType;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Placeholder(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "fontType");
            this.fontType = str;
        }
    }
}
