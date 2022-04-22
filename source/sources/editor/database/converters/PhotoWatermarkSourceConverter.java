package editor.database.converters;

import editor.optionsui.watermark.PhotoWatermarkSource;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007¨\u0006\t"}, mo26107d2 = {"Leditor/database/converters/PhotoWatermarkSourceConverter;", "", "()V", "fromValue", "Leditor/optionsui/watermark/PhotoWatermarkSource;", "value", "", "toValue", "source", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: PhotoWatermarkSourceConverter.kt */
public final class PhotoWatermarkSourceConverter {

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PhotoWatermarkSource.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[PhotoWatermarkSource.RAW.ordinal()] = 1;
            iArr[PhotoWatermarkSource.SIGNATURE.ordinal()] = 2;
        }
    }

    public final PhotoWatermarkSource fromValue(int i) {
        if (i == 0) {
            return PhotoWatermarkSource.RAW;
        }
        if (i == 1) {
            return PhotoWatermarkSource.SIGNATURE;
        }
        throw new RuntimeException("Unknown PhotoWatermarkSource: " + i);
    }

    public final int toValue(PhotoWatermarkSource photoWatermarkSource) {
        Intrinsics.checkNotNullParameter(photoWatermarkSource, "source");
        int i = WhenMappings.$EnumSwitchMapping$0[photoWatermarkSource.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }
}
