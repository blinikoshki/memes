package editor.common.colorshadeselector;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.math.MathKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rJ\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo26107d2 = {"Leditor/common/colorshadeselector/ColorShadesGenerator;", "", "()V", "FRACTION", "", "canDarken", "", "color", "Leditor/common/colorshadeselector/ArgbColor;", "canLighten", "createDarkShades", "", "count", "", "createLightShades", "darken", "generateShadesOf", "", "colorInt", "shadeCount", "lighten", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ColorShadesGenerator.kt */
public final class ColorShadesGenerator {
    private static final double FRACTION = 0.09d;
    public static final ColorShadesGenerator INSTANCE = new ColorShadesGenerator();

    private ColorShadesGenerator() {
    }

    public final List<Integer> generateShadesOf(int i, int i2) {
        ArgbColor argbColor = new ArgbColor(i);
        int i3 = i2 - 1;
        int i4 = i3 / 2;
        List<ArgbColor> createDarkShades = createDarkShades(argbColor, i4);
        int i5 = i3 - i4;
        List<ArgbColor> createLightShades = createLightShades(argbColor, i5);
        if (createDarkShades.size() != i4) {
            createLightShades.addAll(createLightShades(createLightShades.get(createLightShades.size() - 1), i4 - createDarkShades.size()));
        } else if (createLightShades.size() != i5) {
            createDarkShades.addAll(createDarkShades(createDarkShades.get(createDarkShades.size() - 1), i5 - createLightShades.size()));
        }
        if (createDarkShades.size() + createLightShades.size() != i2) {
            System.out.println("Couldn't create enough color shades; requested " + i2);
        }
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(argbColor.toInt()));
        for (ArgbColor argbColor2 : createDarkShades) {
            arrayList.add(Integer.valueOf(argbColor2.toInt()));
        }
        for (ArgbColor argbColor3 : createLightShades) {
            arrayList.add(0, Integer.valueOf(argbColor3.toInt()));
        }
        return arrayList;
    }

    private final boolean canLighten(ArgbColor argbColor) {
        return argbColor.getRed() < 255 || argbColor.getGreen() < 255 || argbColor.getBlue() < 255;
    }

    private final ArgbColor lighten(ArgbColor argbColor) {
        return new ArgbColor(argbColor.getAlpha(), MathKt.roundToInt(Math.min(255.0d, ((double) argbColor.getRed()) + 22.95d)), MathKt.roundToInt(Math.min(255.0d, ((double) argbColor.getGreen()) + 22.95d)), MathKt.roundToInt(Math.min(255.0d, ((double) argbColor.getBlue()) + 22.95d)));
    }

    private final List<ArgbColor> createLightShades(ArgbColor argbColor, int i) {
        List<ArgbColor> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < i; i2++) {
            ColorShadesGenerator colorShadesGenerator = INSTANCE;
            if (colorShadesGenerator.canLighten(argbColor)) {
                argbColor = colorShadesGenerator.lighten(argbColor);
                arrayList.add(argbColor);
            }
        }
        return arrayList;
    }

    private final boolean canDarken(ArgbColor argbColor) {
        return argbColor.getRed() > 0 || argbColor.getGreen() > 0 || argbColor.getBlue() > 0;
    }

    private final ArgbColor darken(ArgbColor argbColor) {
        return new ArgbColor(argbColor.getAlpha(), MathKt.roundToInt(Math.max(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, ((double) argbColor.getRed()) - 22.95d)), MathKt.roundToInt(Math.max(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, ((double) argbColor.getGreen()) - 22.95d)), MathKt.roundToInt(Math.max(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, ((double) argbColor.getBlue()) - 22.95d)));
    }

    private final List<ArgbColor> createDarkShades(ArgbColor argbColor, int i) {
        List<ArgbColor> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < i; i2++) {
            ColorShadesGenerator colorShadesGenerator = INSTANCE;
            if (colorShadesGenerator.canDarken(argbColor)) {
                argbColor = colorShadesGenerator.darken(argbColor);
                arrayList.add(argbColor);
            }
        }
        return arrayList;
    }
}
