package editor.optionsui.addcontent.contentpicker;

import com.bumptech.glide.Registry;
import com.memes.commons.output.OutputExtension;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\u0005j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, mo26107d2 = {"Leditor/optionsui/addcontent/contentpicker/ContentPickerTarget;", "", "(Ljava/lang/String;I)V", "allowedExtensions", "", "", "()[Ljava/lang/String;", "string", "PHOTO", "GIF", "VIDEO", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ContentPickerTarget.kt */
public enum ContentPickerTarget {
    PHOTO,
    GIF,
    VIDEO;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] iArr = new int[ContentPickerTarget.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ContentPickerTarget.PHOTO.ordinal()] = 1;
            iArr[ContentPickerTarget.GIF.ordinal()] = 2;
            iArr[ContentPickerTarget.VIDEO.ordinal()] = 3;
            int[] iArr2 = new int[ContentPickerTarget.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ContentPickerTarget.PHOTO.ordinal()] = 1;
            iArr2[ContentPickerTarget.GIF.ordinal()] = 2;
            iArr2[ContentPickerTarget.VIDEO.ordinal()] = 3;
        }
    }

    public final String string() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return "Photo";
        }
        if (i == 2) {
            return Registry.BUCKET_GIF;
        }
        if (i == 3) {
            return "Video";
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String[] allowedExtensions() {
        int i = WhenMappings.$EnumSwitchMapping$1[ordinal()];
        if (i == 1) {
            return new String[]{OutputExtension.JPG, ".jpeg", OutputExtension.PNG, ".bmp"};
        }
        if (i == 2) {
            return new String[]{OutputExtension.GIF};
        }
        if (i == 3) {
            return new String[]{OutputExtension.MP4, ".mov"};
        }
        throw new NoWhenBranchMatchedException();
    }
}
