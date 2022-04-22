package editor.common.assetsprovider;

import android.content.Context;
import android.content.res.AssetManager;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.memes.commons.util.ExtensionsKt;
import editor.optionsui.frame.frameresize.FrameSize;
import editor.optionsui.frame.frameresize.FrameSizeConfig;
import editor.optionsui.layerpaint.LayerPaint;
import editor.tools.crop.CropOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0012J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo26107d2 = {"Leditor/common/assetsprovider/AssetsProvider;", "", "assetManager", "Landroid/content/res/AssetManager;", "(Landroid/content/res/AssetManager;)V", "colors", "", "Leditor/optionsui/layerpaint/LayerPaint$Color;", "cropPreviews", "Leditor/tools/crop/CropOption$Preview;", "entryFrameSizes", "Leditor/optionsui/frame/frameresize/FrameSize;", "frameSizes", "gradients", "Leditor/optionsui/layerpaint/LayerPaint$Gradient;", "patterns", "Leditor/optionsui/layerpaint/LayerPaint$Pattern;", "getColors", "", "getCropPreviews", "getEntryFrameSizes", "getFrameSizes", "getGradients", "getPatterns", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AssetsProvider.kt */
public final class AssetsProvider {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final AssetManager assetManager;
    private final List<LayerPaint.Color> colors;
    private final List<CropOption.Preview> cropPreviews;
    private final List<FrameSize> entryFrameSizes;
    private final List<FrameSize> frameSizes;
    private final List<LayerPaint.Gradient> gradients;
    private final List<LayerPaint.Pattern> patterns;

    private AssetsProvider(AssetManager assetManager2) {
        this.assetManager = assetManager2;
        this.frameSizes = new ArrayList();
        this.entryFrameSizes = new ArrayList();
        this.cropPreviews = new ArrayList();
        this.colors = new ArrayList();
        this.gradients = new ArrayList();
        this.patterns = new ArrayList();
    }

    public /* synthetic */ AssetsProvider(AssetManager assetManager2, DefaultConstructorMarker defaultConstructorMarker) {
        this(assetManager2);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"Leditor/common/assetsprovider/AssetsProvider$Companion;", "", "()V", "from", "Leditor/common/assetsprovider/AssetsProvider;", "context", "Landroid/content/Context;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: AssetsProvider.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AssetsProvider from(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            AssetManager assets = context.getAssets();
            Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
            return new AssetsProvider(assets, (DefaultConstructorMarker) null);
        }
    }

    public final List<FrameSize> getFrameSizes() {
        if (this.frameSizes.isEmpty()) {
            String readAssetsFile = ExtensionsKt.readAssetsFile(this.assetManager, "frame/frame-resize.json");
            Gson gson = new Gson();
            TypeToken<?> parameterized = TypeToken.getParameterized(List.class, FrameSize.class);
            Intrinsics.checkNotNullExpressionValue(parameterized, "TypeToken.getParameteriz…ameSize::class.java\n\t\t\t\t)");
            List list = (List) gson.fromJson(readAssetsFile, parameterized.getType());
            List<FrameSize> list2 = this.frameSizes;
            Intrinsics.checkNotNullExpressionValue(list, "sizes");
            list2.addAll(list);
        }
        return this.frameSizes;
    }

    public final List<FrameSize> getEntryFrameSizes() {
        if (this.entryFrameSizes.isEmpty()) {
            String readAssetsFile = ExtensionsKt.readAssetsFile(this.assetManager, FrameSizeConfig.INSTANCE.contentJsonPath());
            Gson gson = new Gson();
            TypeToken<?> parameterized = TypeToken.getParameterized(List.class, FrameSize.class);
            Intrinsics.checkNotNullExpressionValue(parameterized, "TypeToken.getParameteriz…ameSize::class.java\n\t\t\t\t)");
            List list = (List) gson.fromJson(readAssetsFile, parameterized.getType());
            List<FrameSize> list2 = this.entryFrameSizes;
            Intrinsics.checkNotNullExpressionValue(list, RemoteConfigConstants.ResponseFieldKey.ENTRIES);
            list2.addAll(list);
        }
        return this.entryFrameSizes;
    }

    public final List<CropOption.Preview> getCropPreviews() {
        if (this.cropPreviews.isEmpty()) {
            String readAssetsFile = ExtensionsKt.readAssetsFile(this.assetManager, "crop/media-crop.json");
            Gson gson = new Gson();
            TypeToken<?> parameterized = TypeToken.getParameterized(List.class, CropOption.Preview.class);
            Intrinsics.checkNotNullExpressionValue(parameterized, "TypeToken.getParameteriz…Preview::class.java\n\t\t\t\t)");
            List list = (List) gson.fromJson(readAssetsFile, parameterized.getType());
            List<CropOption.Preview> list2 = this.cropPreviews;
            Intrinsics.checkNotNullExpressionValue(list, "previews");
            list2.addAll(list);
        }
        return this.cropPreviews;
    }

    public final List<LayerPaint.Color> getColors() {
        if (this.colors.isEmpty()) {
            String readAssetsFile = ExtensionsKt.readAssetsFile(this.assetManager, "colors/color-palette.json");
            Gson gson = new Gson();
            TypeToken<?> parameterized = TypeToken.getParameterized(List.class, String.class);
            Intrinsics.checkNotNullExpressionValue(parameterized, "TypeToken.getParameteriz…\tString::class.java\n\t\t\t\t)");
            List list = (List) gson.fromJson(readAssetsFile, parameterized.getType());
            Intrinsics.checkNotNullExpressionValue(list, "hexColors");
            Iterable<String> iterable = list;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (String color : iterable) {
                arrayList.add(new LayerPaint.Color(color));
            }
            this.colors.addAll((List) arrayList);
        }
        return this.colors;
    }

    public final List<LayerPaint.Gradient> getGradients() {
        if (this.gradients.isEmpty()) {
            String readAssetsFile = ExtensionsKt.readAssetsFile(this.assetManager, "colors/gradient-color-palette.json");
            Gson gson = new Gson();
            TypeToken<?> parameterized = TypeToken.getParameterized(List.class, GradientPalette.class);
            Intrinsics.checkNotNullExpressionValue(parameterized, "TypeToken.getParameteriz…Palette::class.java\n\t\t\t\t)");
            List list = (List) gson.fromJson(readAssetsFile, parameterized.getType());
            Intrinsics.checkNotNullExpressionValue(list, "gradientPalettes");
            Iterable<GradientPalette> iterable = list;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (GradientPalette gradientPalette : iterable) {
                arrayList.add(new LayerPaint.Gradient(gradientPalette.getValues().get(0), gradientPalette.getValues().get(1), gradientPalette.getValues().get(2), false, 8, (DefaultConstructorMarker) null));
            }
            this.gradients.addAll((List) arrayList);
        }
        return this.gradients;
    }

    public final List<LayerPaint.Pattern> getPatterns() {
        if (this.patterns.isEmpty()) {
            String readAssetsFile = ExtensionsKt.readAssetsFile(this.assetManager, "patterns/patterns.json");
            Gson gson = new Gson();
            TypeToken<?> parameterized = TypeToken.getParameterized(List.class, LayerPaint.Pattern.class);
            Intrinsics.checkNotNullExpressionValue(parameterized, "TypeToken.getParameteriz…Pattern::class.java\n\t\t\t\t)");
            List list = (List) gson.fromJson(readAssetsFile, parameterized.getType());
            Intrinsics.checkNotNullExpressionValue(list, "patternList");
            Iterable<LayerPaint.Pattern> iterable = list;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (LayerPaint.Pattern pattern : iterable) {
                arrayList.add(new LayerPaint.Pattern(pattern.getSource(), pattern.getWidth(), pattern.getHeight()));
            }
            this.patterns.addAll((List) arrayList);
        }
        return this.patterns;
    }
}
