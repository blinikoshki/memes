package editor.optionsui.text.textfont;

import android.content.res.AssetManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.memes.commons.util.ExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo26107d2 = {"Leditor/optionsui/text/textfont/TextFontsProvider;", "", "assetManager", "Landroid/content/res/AssetManager;", "(Landroid/content/res/AssetManager;)V", "allFonts", "", "Leditor/optionsui/text/textfont/TextFont;", "classicFonts", "defaultFonts", "fonts", "fileName", "", "movieFonts", "premiumFonts", "retroFonts", "scriptFonts", "specialFonts", "technoFonts", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextFontsProvider.kt */
public final class TextFontsProvider {
    private final AssetManager assetManager;

    public TextFontsProvider(AssetManager assetManager2) {
        Intrinsics.checkNotNullParameter(assetManager2, "assetManager");
        this.assetManager = assetManager2;
    }

    public final List<TextFont> allFonts() {
        List<TextFont> arrayList = new ArrayList<>();
        arrayList.addAll(defaultFonts());
        arrayList.addAll(premiumFonts());
        arrayList.addAll(classicFonts());
        arrayList.addAll(specialFonts());
        arrayList.addAll(movieFonts());
        arrayList.addAll(scriptFonts());
        arrayList.addAll(retroFonts());
        arrayList.addAll(technoFonts());
        return arrayList;
    }

    private final List<TextFont> defaultFonts() {
        List<TextFont> arrayList = new ArrayList<>();
        arrayList.add(TextFont.Companion.memesDefault());
        arrayList.add(TextFont.Companion.systemDefault());
        return arrayList;
    }

    private final List<TextFont> classicFonts() {
        return fonts("editor_classic_fonts.json");
    }

    private final List<TextFont> movieFonts() {
        return fonts("editor_movie_fonts.json");
    }

    private final List<TextFont> premiumFonts() {
        return fonts("editor_premium_fonts.json");
    }

    private final List<TextFont> retroFonts() {
        return fonts("editor_retro_fonts.json");
    }

    private final List<TextFont> scriptFonts() {
        return fonts("editor_script_fonts.json");
    }

    private final List<TextFont> specialFonts() {
        return fonts("editor_special_fonts.json");
    }

    private final List<TextFont> technoFonts() {
        return fonts("editor_techno_fonts.json");
    }

    private final List<TextFont> fonts(String str) {
        AssetManager assetManager2 = this.assetManager;
        String readAssetsFile = ExtensionsKt.readAssetsFile(assetManager2, "fonts/" + str);
        Gson gson = new Gson();
        TypeToken<?> parameterized = TypeToken.getParameterized(List.class, TextFont.class);
        Intrinsics.checkNotNullExpressionValue(parameterized, "TypeToken.getParameteriz…va, TextFont::class.java)");
        List list = (List) gson.fromJson(readAssetsFile, parameterized.getType());
        Intrinsics.checkNotNullExpressionValue(list, "fonts");
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (!Intrinsics.areEqual((Object) ((TextFont) next).getFileName(), (Object) "blank.ttf")) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }
}
