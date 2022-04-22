package editor.optionsui.text.textfont;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, mo26107d2 = {"Leditor/optionsui/text/textfont/TextFontCategory;", "", "displayName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "matches", "", "name", "RECENT", "DEFAULT", "PREMIUM", "CLASSIC", "SPECIAL", "MOVIE", "SCRIPT", "RETRO", "TECHNO", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextFontCategory.kt */
public enum TextFontCategory {
    RECENT("Recent"),
    DEFAULT("Default"),
    PREMIUM("Premium"),
    CLASSIC("Classic"),
    SPECIAL("Special"),
    MOVIE("Movie"),
    SCRIPT("Script"),
    RETRO("Retro"),
    TECHNO("Techno");
    
    private final String displayName;

    private TextFontCategory(String str) {
        this.displayName = str;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final boolean matches(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return StringsKt.equals(name(), str, true);
    }
}
