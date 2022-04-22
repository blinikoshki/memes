package coil.decode;

import coil.size.OriginalSize;
import coil.size.PixelSize;
import coil.size.Scale;
import coil.size.Size;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import okio.BufferedSource;
import okio.ByteString;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0010\u001a\u00020\u000e2\b\b\u0001\u0010\u0011\u001a\u00020\u000e2\b\b\u0001\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J8\u0010\u0019\u001a\u00020\u001a2\b\b\u0001\u0010\u000f\u001a\u00020\u001a2\b\b\u0001\u0010\u0010\u001a\u00020\u001a2\b\b\u0001\u0010\u0011\u001a\u00020\u001a2\b\b\u0001\u0010\u0012\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J8\u0010\u0019\u001a\u00020\u001b2\b\b\u0001\u0010\u000f\u001a\u00020\u001b2\b\b\u0001\u0010\u0010\u001a\u00020\u001b2\b\b\u0001\u0010\u0011\u001a\u00020\u001b2\b\b\u0001\u0010\u0012\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J8\u0010\u0019\u001a\u00020\u001a2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0010\u001a\u00020\u000e2\b\b\u0001\u0010\u0011\u001a\u00020\u000e2\b\b\u0001\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, mo26107d2 = {"Lcoil/decode/DecodeUtils;", "", "()V", "GIF_HEADER_87A", "Lokio/ByteString;", "GIF_HEADER_89A", "HEIF_HEADER_FTYP", "HEIF_HEADER_HEVC", "HEIF_HEADER_HEVX", "HEIF_HEADER_MSF1", "WEBP_HEADER_RIFF", "WEBP_HEADER_VPX8", "WEBP_HEADER_WEBP", "calculateInSampleSize", "", "srcWidth", "srcHeight", "dstWidth", "dstHeight", "scale", "Lcoil/size/Scale;", "computePixelSize", "Lcoil/size/PixelSize;", "dstSize", "Lcoil/size/Size;", "computeSizeMultiplier", "", "", "isAnimatedHeif", "", "source", "Lokio/BufferedSource;", "isAnimatedWebP", "isGif", "isHeif", "isWebP", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: DecodeUtils.kt */
public final class DecodeUtils {
    private static final ByteString GIF_HEADER_87A = ByteString.Companion.encodeUtf8("GIF87a");
    private static final ByteString GIF_HEADER_89A = ByteString.Companion.encodeUtf8("GIF89a");
    private static final ByteString HEIF_HEADER_FTYP = ByteString.Companion.encodeUtf8("ftyp");
    private static final ByteString HEIF_HEADER_HEVC = ByteString.Companion.encodeUtf8("hevc");
    private static final ByteString HEIF_HEADER_HEVX = ByteString.Companion.encodeUtf8("hevx");
    private static final ByteString HEIF_HEADER_MSF1 = ByteString.Companion.encodeUtf8("msf1");
    public static final DecodeUtils INSTANCE = new DecodeUtils();
    private static final ByteString WEBP_HEADER_RIFF = ByteString.Companion.encodeUtf8("RIFF");
    private static final ByteString WEBP_HEADER_VPX8 = ByteString.Companion.encodeUtf8("VP8X");
    private static final ByteString WEBP_HEADER_WEBP = ByteString.Companion.encodeUtf8("WEBP");

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 1})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[Scale.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Scale.FILL.ordinal()] = 1;
            iArr[Scale.FIT.ordinal()] = 2;
            int[] iArr2 = new int[Scale.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[Scale.FILL.ordinal()] = 1;
            iArr2[Scale.FIT.ordinal()] = 2;
            int[] iArr3 = new int[Scale.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[Scale.FILL.ordinal()] = 1;
            iArr3[Scale.FIT.ordinal()] = 2;
            int[] iArr4 = new int[Scale.values().length];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[Scale.FILL.ordinal()] = 1;
            iArr4[Scale.FIT.ordinal()] = 2;
        }
    }

    private DecodeUtils() {
    }

    @JvmStatic
    public static final boolean isGif(BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        return bufferedSource.rangeEquals(0, GIF_HEADER_89A) || bufferedSource.rangeEquals(0, GIF_HEADER_87A);
    }

    @JvmStatic
    public static final boolean isWebP(BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        return bufferedSource.rangeEquals(0, WEBP_HEADER_RIFF) && bufferedSource.rangeEquals(8, WEBP_HEADER_WEBP);
    }

    @JvmStatic
    public static final boolean isAnimatedWebP(BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        return isWebP(bufferedSource) && bufferedSource.rangeEquals(12, WEBP_HEADER_VPX8) && bufferedSource.request(17) && ((byte) (bufferedSource.getBuffer().getByte(16) & 2)) > 0;
    }

    @JvmStatic
    public static final boolean isHeif(BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        return bufferedSource.rangeEquals(4, HEIF_HEADER_FTYP);
    }

    @JvmStatic
    public static final boolean isAnimatedHeif(BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        return isHeif(bufferedSource) && (bufferedSource.rangeEquals(8, HEIF_HEADER_MSF1) || bufferedSource.rangeEquals(8, HEIF_HEADER_HEVC) || bufferedSource.rangeEquals(8, HEIF_HEADER_HEVX));
    }

    @JvmStatic
    public static final int calculateInSampleSize(int i, int i2, int i3, int i4, Scale scale) {
        Intrinsics.checkNotNullParameter(scale, "scale");
        int coerceAtLeast = RangesKt.coerceAtLeast(Integer.highestOneBit(i / i3), 1);
        int coerceAtLeast2 = RangesKt.coerceAtLeast(Integer.highestOneBit(i2 / i4), 1);
        int i5 = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i5 == 1) {
            return Math.min(coerceAtLeast, coerceAtLeast2);
        }
        if (i5 == 2) {
            return Math.max(coerceAtLeast, coerceAtLeast2);
        }
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final double computeSizeMultiplier(int i, int i2, int i3, int i4, Scale scale) {
        Intrinsics.checkNotNullParameter(scale, "scale");
        double d = ((double) i3) / ((double) i);
        double d2 = ((double) i4) / ((double) i2);
        int i5 = WhenMappings.$EnumSwitchMapping$1[scale.ordinal()];
        if (i5 == 1) {
            return Math.max(d, d2);
        }
        if (i5 == 2) {
            return Math.min(d, d2);
        }
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final float computeSizeMultiplier(float f, float f2, float f3, float f4, Scale scale) {
        Intrinsics.checkNotNullParameter(scale, "scale");
        float f5 = f3 / f;
        float f6 = f4 / f2;
        int i = WhenMappings.$EnumSwitchMapping$2[scale.ordinal()];
        if (i == 1) {
            return Math.max(f5, f6);
        }
        if (i == 2) {
            return Math.min(f5, f6);
        }
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final double computeSizeMultiplier(double d, double d2, double d3, double d4, Scale scale) {
        Intrinsics.checkNotNullParameter(scale, "scale");
        double d5 = d3 / d;
        double d6 = d4 / d2;
        int i = WhenMappings.$EnumSwitchMapping$3[scale.ordinal()];
        if (i == 1) {
            return Math.max(d5, d6);
        }
        if (i == 2) {
            return Math.min(d5, d6);
        }
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final PixelSize computePixelSize(int i, int i2, Size size, Scale scale) {
        Intrinsics.checkNotNullParameter(size, "dstSize");
        Intrinsics.checkNotNullParameter(scale, "scale");
        if (size instanceof OriginalSize) {
            return new PixelSize(i, i2);
        }
        if (size instanceof PixelSize) {
            PixelSize pixelSize = (PixelSize) size;
            double computeSizeMultiplier = computeSizeMultiplier(i, i2, pixelSize.getWidth(), pixelSize.getHeight(), scale);
            return new PixelSize(MathKt.roundToInt(((double) i) * computeSizeMultiplier), MathKt.roundToInt(computeSizeMultiplier * ((double) i2)));
        }
        throw new NoWhenBranchMatchedException();
    }
}
