package coil.decode;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import coil.size.PixelSize;
import coil.size.Size;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b¨\u0006\n"}, mo26107d2 = {"<anonymous>", "", "decoder", "Landroid/graphics/ImageDecoder;", "info", "Landroid/graphics/ImageDecoder$ImageInfo;", "source", "Landroid/graphics/ImageDecoder$Source;", "onHeaderDecoded", "androidx/core/graphics/ImageDecoderKt$decodeDrawable$1", "coil/decode/ImageDecoderDecoder$$special$$inlined$decodeDrawable$1"}, mo26108k = 3, mo26109mv = {1, 4, 1})
/* renamed from: coil.decode.ImageDecoderDecoder$decode$$inlined$withInterruptibleSource$lambda$1 */
/* compiled from: ImageDecoder.kt */
public final class C0926xd26e187e implements ImageDecoder.OnHeaderDecodedListener {
    final /* synthetic */ Ref.BooleanRef $isSampled$inlined;
    final /* synthetic */ Options $options$inlined;
    final /* synthetic */ Size $size$inlined;
    final /* synthetic */ Ref.ObjectRef $tempFile$inlined;

    public C0926xd26e187e(Ref.ObjectRef objectRef, Ref.BooleanRef booleanRef, Size size, Options options) {
        this.$tempFile$inlined = objectRef;
        this.$isSampled$inlined = booleanRef;
        this.$size$inlined = size;
        this.$options$inlined = options;
    }

    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        Intrinsics.checkParameterIsNotNull(imageDecoder, "decoder");
        Intrinsics.checkParameterIsNotNull(imageInfo, "info");
        Intrinsics.checkParameterIsNotNull(source, "source");
        File file = (File) this.$tempFile$inlined.element;
        if (file != null) {
            file.delete();
        }
        if (this.$size$inlined instanceof PixelSize) {
            android.util.Size size = imageInfo.getSize();
            int width = size.getWidth();
            int height = size.getHeight();
            double computeSizeMultiplier = DecodeUtils.computeSizeMultiplier(width, height, ((PixelSize) this.$size$inlined).getWidth(), ((PixelSize) this.$size$inlined).getHeight(), this.$options$inlined.getScale());
            this.$isSampled$inlined.element = computeSizeMultiplier < ((double) 1);
            if (this.$isSampled$inlined.element || !this.$options$inlined.getAllowInexactSize()) {
                imageDecoder.setTargetSize(MathKt.roundToInt(((double) width) * computeSizeMultiplier), MathKt.roundToInt(computeSizeMultiplier * ((double) height)));
            }
        }
        imageDecoder.setAllocator(this.$options$inlined.getConfig() == Bitmap.Config.HARDWARE ? 3 : 1);
        imageDecoder.setMemorySizePolicy(this.$options$inlined.getAllowRgb565() ^ true ? 1 : 0);
        if (this.$options$inlined.getColorSpace() != null) {
            imageDecoder.setTargetColorSpace(this.$options$inlined.getColorSpace());
        }
        imageDecoder.setUnpremultipliedRequired(!this.$options$inlined.getPremultipliedAlpha());
    }
}
