package editor.util;

import android.content.Context;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import editor.optionsui.layerpaint.LayerPaint;
import editor.optionsui.layerpaint.pattern.PatternsConfig;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\u000e"}, mo26107d2 = {"Leditor/util/DrawableUtil;", "", "()V", "createDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "paint", "Leditor/optionsui/layerpaint/LayerPaint$Pattern;", "assetFileName", "", "assetFilePath", "Leditor/optionsui/layerpaint/LayerPaint$Gradient;", "createTileDrawable", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: DrawableUtil.kt */
public final class DrawableUtil {
    public static final DrawableUtil INSTANCE = new DrawableUtil();

    private DrawableUtil() {
    }

    public final Drawable createDrawable(LayerPaint.Gradient gradient) {
        Intrinsics.checkNotNullParameter(gradient, "paint");
        return new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{gradient.startColorInt(), gradient.centerColorInt(), gradient.endColorInt()});
    }

    public final Drawable createDrawable(Context context, LayerPaint.Pattern pattern) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pattern, "paint");
        String source = pattern.getSource();
        return createDrawable(context, source, PatternsConfig.ASSET_PATH + pattern.getSource());
    }

    public final Drawable createDrawable(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "assetFileName");
        Intrinsics.checkNotNullParameter(str2, "assetFilePath");
        InputStream open = context.getAssets().open(str2);
        Intrinsics.checkNotNullExpressionValue(open, "context.assets.open(assetFilePath)");
        Drawable createFromStream = Drawable.createFromStream(open, str);
        Intrinsics.checkNotNullExpressionValue(createFromStream, "Drawable.createFromStream(stream, assetFileName)");
        return createFromStream;
    }

    public final Drawable createTileDrawable(Context context, LayerPaint.Pattern pattern) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pattern, "paint");
        return new TileDrawable(createDrawable(context, pattern), Shader.TileMode.REPEAT);
    }
}
