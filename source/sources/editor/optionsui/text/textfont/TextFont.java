package editor.optionsui.text.textfont;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import com.facebook.internal.logging.monitor.MonitorLogServerProtocol;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001 B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001e\u001a\u00020\u001fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, mo26107d2 = {"Leditor/optionsui/text/textfont/TextFont;", "", "id", "", "displayName", "type", "fileName", "isPremiumFont", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getDisplayName", "()Ljava/lang/String;", "getFileName", "getId", "()Z", "getType", "typeface", "Landroid/graphics/Typeface;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "toTypeface", "context", "Landroid/content/Context;", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextFont.kt */
public final class TextFont {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @SerializedName("display_name")
    @Expose
    private final String displayName;
    @SerializedName("file_name")
    @Expose
    private final String fileName;
    @SerializedName("id")
    @Expose

    /* renamed from: id */
    private final String f1435id;
    @SerializedName("premium")
    @Expose
    private final boolean isPremiumFont;
    @SerializedName("type")
    @Expose
    private final String type;
    private transient Typeface typeface;

    public static /* synthetic */ TextFont copy$default(TextFont textFont, String str, String str2, String str3, String str4, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = textFont.f1435id;
        }
        if ((i & 2) != 0) {
            str2 = textFont.displayName;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = textFont.type;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = textFont.fileName;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            z = textFont.isPremiumFont;
        }
        return textFont.copy(str, str5, str6, str7, z);
    }

    public final String component1() {
        return this.f1435id;
    }

    public final String component2() {
        return this.displayName;
    }

    public final String component3() {
        return this.type;
    }

    public final String component4() {
        return this.fileName;
    }

    public final boolean component5() {
        return this.isPremiumFont;
    }

    public final TextFont copy(String str, String str2, String str3, String str4, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "displayName");
        Intrinsics.checkNotNullParameter(str3, "type");
        Intrinsics.checkNotNullParameter(str4, "fileName");
        return new TextFont(str, str2, str3, str4, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFont)) {
            return false;
        }
        TextFont textFont = (TextFont) obj;
        return Intrinsics.areEqual((Object) this.f1435id, (Object) textFont.f1435id) && Intrinsics.areEqual((Object) this.displayName, (Object) textFont.displayName) && Intrinsics.areEqual((Object) this.type, (Object) textFont.type) && Intrinsics.areEqual((Object) this.fileName, (Object) textFont.fileName) && this.isPremiumFont == textFont.isPremiumFont;
    }

    public int hashCode() {
        String str = this.f1435id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.displayName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.type;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.fileName;
        if (str4 != null) {
            i = str4.hashCode();
        }
        int i2 = (hashCode3 + i) * 31;
        boolean z = this.isPremiumFont;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    public String toString() {
        return "TextFont(id=" + this.f1435id + ", displayName=" + this.displayName + ", type=" + this.type + ", fileName=" + this.fileName + ", isPremiumFont=" + this.isPremiumFont + ")";
    }

    public TextFont(String str, String str2, String str3, String str4, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "displayName");
        Intrinsics.checkNotNullParameter(str3, "type");
        Intrinsics.checkNotNullParameter(str4, "fileName");
        this.f1435id = str;
        this.displayName = str2;
        this.type = str3;
        this.fileName = str4;
        this.isPremiumFont = z;
    }

    public final String getId() {
        return this.f1435id;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getType() {
        return this.type;
    }

    public final String getFileName() {
        return this.fileName;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextFont(String str, String str2, String str3, String str4, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i & 16) != 0 ? false : z);
    }

    public final boolean isPremiumFont() {
        return this.isPremiumFont;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, mo26107d2 = {"Leditor/optionsui/text/textfont/TextFont$Companion;", "", "()V", "memesDefault", "Leditor/optionsui/text/textfont/TextFont;", "systemDefault", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: TextFont.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TextFont systemDefault() {
            return new TextFont("", "System Default", MonitorLogServerProtocol.DEFAULT_SAMPLE_RATES_KEY, "/", false, 16, (DefaultConstructorMarker) null);
        }

        public final TextFont memesDefault() {
            return new TextFont("memes_default", "Memes Default", MonitorLogServerProtocol.DEFAULT_SAMPLE_RATES_KEY, "helvetica_neue_light.otf", false, 16, (DefaultConstructorMarker) null);
        }
    }

    public final Typeface toTypeface(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (StringsKt.isBlank(this.f1435id)) {
            return null;
        }
        if (this.typeface == null) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            AssetManager assets = applicationContext.getAssets();
            this.typeface = Typeface.createFromAsset(assets, "fonts/" + this.type + '/' + this.fileName);
        }
        return this.typeface;
    }
}
