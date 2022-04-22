package com.giphy.sdk.p013ui.views.buttons;

import com.giphy.sdk.p013ui.C1800R;
import com.giphy.sdk.p013ui.utils.GPHColor;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\b\u0001\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006j\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, mo26107d2 = {"Lcom/giphy/sdk/ui/views/buttons/GPHGiphyButtonStyle;", "", "(Ljava/lang/String;I)V", "backgroundColor", "", "getBackgroundColor$ui_sdk_release", "()I", "image", "getImage$ui_sdk_release", "rounded", "", "getRounded$ui_sdk_release", "()Z", "tintColor", "getTintColor$ui_sdk_release", "logo", "logoRounded", "iconSquare", "iconSquareRounded", "iconColor", "iconBlack", "iconWhite", "Companion", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.buttons.GPHGiphyButtonStyle */
/* compiled from: GPHGiphyButton.kt */
public enum GPHGiphyButtonStyle {
    logo,
    logoRounded,
    iconSquare,
    iconSquareRounded,
    iconColor,
    iconBlack,
    iconWhite;
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final GPHGiphyButtonStyle defaultSetting = null;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.views.buttons.GPHGiphyButtonStyle$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3 = null;

        static {
            int[] iArr = new int[GPHGiphyButtonStyle.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[GPHGiphyButtonStyle.logo.ordinal()] = 1;
            iArr[GPHGiphyButtonStyle.logoRounded.ordinal()] = 2;
            iArr[GPHGiphyButtonStyle.iconSquare.ordinal()] = 3;
            iArr[GPHGiphyButtonStyle.iconSquareRounded.ordinal()] = 4;
            iArr[GPHGiphyButtonStyle.iconColor.ordinal()] = 5;
            iArr[GPHGiphyButtonStyle.iconBlack.ordinal()] = 6;
            iArr[GPHGiphyButtonStyle.iconWhite.ordinal()] = 7;
            int[] iArr2 = new int[GPHGiphyButtonStyle.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[GPHGiphyButtonStyle.logo.ordinal()] = 1;
            iArr2[GPHGiphyButtonStyle.logoRounded.ordinal()] = 2;
            iArr2[GPHGiphyButtonStyle.iconSquare.ordinal()] = 3;
            iArr2[GPHGiphyButtonStyle.iconSquareRounded.ordinal()] = 4;
            int[] iArr3 = new int[GPHGiphyButtonStyle.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[GPHGiphyButtonStyle.iconBlack.ordinal()] = 1;
            iArr3[GPHGiphyButtonStyle.iconWhite.ordinal()] = 2;
            int[] iArr4 = new int[GPHGiphyButtonStyle.values().length];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[GPHGiphyButtonStyle.logoRounded.ordinal()] = 1;
            iArr4[GPHGiphyButtonStyle.iconSquareRounded.ordinal()] = 2;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/giphy/sdk/ui/views/buttons/GPHGiphyButtonStyle$Companion;", "", "()V", "defaultSetting", "Lcom/giphy/sdk/ui/views/buttons/GPHGiphyButtonStyle;", "getDefaultSetting", "()Lcom/giphy/sdk/ui/views/buttons/GPHGiphyButtonStyle;", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.views.buttons.GPHGiphyButtonStyle$Companion */
    /* compiled from: GPHGiphyButton.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GPHGiphyButtonStyle getDefaultSetting() {
            return GPHGiphyButtonStyle.defaultSetting;
        }
    }

    static {
        GPHGiphyButtonStyle gPHGiphyButtonStyle;
        Companion = new Companion((DefaultConstructorMarker) null);
        defaultSetting = gPHGiphyButtonStyle;
    }

    public final int getImage$ui_sdk_release() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
            case 2:
                return C1800R.C1802drawable.gph_logo_button;
            case 3:
            case 4:
                return C1800R.C1802drawable.gph_logo_square_button;
            case 5:
                return C1800R.C1802drawable.gph_logo_color_icon;
            case 6:
            case 7:
                return C1800R.C1802drawable.gph_logo_solid_icon;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final int getBackgroundColor$ui_sdk_release() {
        int i = WhenMappings.$EnumSwitchMapping$1[ordinal()];
        if (i == 1 || i == 2) {
            return GPHColor.INSTANCE.getGiphyBlack();
        }
        if (i == 3 || i == 4) {
            return GPHColor.INSTANCE.getGiphyBlack();
        }
        return GPHColor.INSTANCE.getTransparent();
    }

    public final int getTintColor$ui_sdk_release() {
        int i = WhenMappings.$EnumSwitchMapping$2[ordinal()];
        if (i == 1) {
            return GPHColor.INSTANCE.getBlack();
        }
        if (i != 2) {
            return GPHColor.INSTANCE.getTransparent();
        }
        return GPHColor.INSTANCE.getWhite();
    }

    public final boolean getRounded$ui_sdk_release() {
        int i = WhenMappings.$EnumSwitchMapping$3[ordinal()];
        return i == 1 || i == 2;
    }
}
