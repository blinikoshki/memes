package com.giphy.sdk.p013ui.views.buttons;

import com.giphy.sdk.p013ui.C1800R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0001\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8@X\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8@X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, mo26107d2 = {"Lcom/giphy/sdk/ui/views/buttons/GPHGifButtonStyle;", "", "(Ljava/lang/String;I)V", "image", "", "getImage$ui_sdk_release", "()I", "masked", "", "getMasked$ui_sdk_release", "()Z", "rounded", "getRounded$ui_sdk_release", "rectangle", "rectangleRounded", "rectangleOutline", "rectangleOutlineRounded", "square", "squareRounded", "squareOutline", "squareOutlineRounded", "text", "Companion", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.buttons.GPHGifButtonStyle */
/* compiled from: GPHGifButton.kt */
public enum GPHGifButtonStyle {
    rectangle,
    rectangleRounded,
    rectangleOutline,
    rectangleOutlineRounded,
    square,
    squareRounded,
    squareOutline,
    squareOutlineRounded,
    text;
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final GPHGifButtonStyle defaultSetting = null;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.views.buttons.GPHGifButtonStyle$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = null;

        static {
            int[] iArr = new int[GPHGifButtonStyle.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[GPHGifButtonStyle.rectangleOutline.ordinal()] = 1;
            iArr[GPHGifButtonStyle.rectangleOutlineRounded.ordinal()] = 2;
            iArr[GPHGifButtonStyle.squareOutline.ordinal()] = 3;
            iArr[GPHGifButtonStyle.squareOutlineRounded.ordinal()] = 4;
            int[] iArr2 = new int[GPHGifButtonStyle.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[GPHGifButtonStyle.rectangleRounded.ordinal()] = 1;
            iArr2[GPHGifButtonStyle.rectangleOutlineRounded.ordinal()] = 2;
            iArr2[GPHGifButtonStyle.squareRounded.ordinal()] = 3;
            iArr2[GPHGifButtonStyle.squareOutlineRounded.ordinal()] = 4;
            int[] iArr3 = new int[GPHGifButtonStyle.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[GPHGifButtonStyle.rectangle.ordinal()] = 1;
            iArr3[GPHGifButtonStyle.rectangleRounded.ordinal()] = 2;
            iArr3[GPHGifButtonStyle.rectangleOutline.ordinal()] = 3;
            iArr3[GPHGifButtonStyle.rectangleOutlineRounded.ordinal()] = 4;
            iArr3[GPHGifButtonStyle.square.ordinal()] = 5;
            iArr3[GPHGifButtonStyle.squareRounded.ordinal()] = 6;
            iArr3[GPHGifButtonStyle.squareOutline.ordinal()] = 7;
            iArr3[GPHGifButtonStyle.squareOutlineRounded.ordinal()] = 8;
            iArr3[GPHGifButtonStyle.text.ordinal()] = 9;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/giphy/sdk/ui/views/buttons/GPHGifButtonStyle$Companion;", "", "()V", "defaultSetting", "Lcom/giphy/sdk/ui/views/buttons/GPHGifButtonStyle;", "getDefaultSetting", "()Lcom/giphy/sdk/ui/views/buttons/GPHGifButtonStyle;", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.views.buttons.GPHGifButtonStyle$Companion */
    /* compiled from: GPHGifButton.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GPHGifButtonStyle getDefaultSetting() {
            return GPHGifButtonStyle.defaultSetting;
        }
    }

    static {
        GPHGifButtonStyle gPHGifButtonStyle;
        Companion = new Companion((DefaultConstructorMarker) null);
        defaultSetting = gPHGifButtonStyle;
    }

    public final boolean getMasked$ui_sdk_release() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    public final boolean getRounded$ui_sdk_release() {
        int i = WhenMappings.$EnumSwitchMapping$1[ordinal()];
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    public final int getImage$ui_sdk_release() {
        switch (WhenMappings.$EnumSwitchMapping$2[ordinal()]) {
            case 1:
            case 2:
                return C1800R.C1802drawable.gph_gif_button;
            case 3:
            case 4:
                return C1800R.C1802drawable.gph_gif_text;
            case 5:
            case 6:
                return C1800R.C1802drawable.gph_gif_square_button;
            case 7:
            case 8:
                return C1800R.C1802drawable.gph_gif_square_text;
            case 9:
                return C1800R.C1802drawable.gph_gif_text;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
