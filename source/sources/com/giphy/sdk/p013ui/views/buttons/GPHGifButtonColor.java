package com.giphy.sdk.p013ui.views.buttons;

import com.giphy.sdk.p013ui.themes.LightTheme;
import com.giphy.sdk.p013ui.themes.Theme;
import com.giphy.sdk.p013ui.utils.GPHColor;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\b\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, mo26107d2 = {"Lcom/giphy/sdk/ui/views/buttons/GPHGifButtonColor;", "", "(Ljava/lang/String;I)V", "colors", "", "getColors", "()[I", "pink", "blue", "black", "white", "Companion", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.buttons.GPHGifButtonColor */
/* compiled from: GPHButtonColor.kt */
public enum GPHGifButtonColor {
    pink,
    blue,
    black,
    white;
    
    public static final Companion Companion = null;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.views.buttons.GPHGifButtonColor$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] iArr = new int[GPHGifButtonColor.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[GPHGifButtonColor.pink.ordinal()] = 1;
            iArr[GPHGifButtonColor.blue.ordinal()] = 2;
            iArr[GPHGifButtonColor.black.ordinal()] = 3;
            iArr[GPHGifButtonColor.white.ordinal()] = 4;
        }
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    public final int[] getColors() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return new int[]{GPHColor.INSTANCE.getGiphyPurple(), GPHColor.INSTANCE.getGiphyPink()};
        } else if (i == 2) {
            return new int[]{GPHColor.INSTANCE.getGiphyPurple(), GPHColor.INSTANCE.getGiphyAqua()};
        } else if (i == 3) {
            return new int[]{GPHColor.INSTANCE.getBlack(), GPHColor.INSTANCE.getBlack()};
        } else if (i == 4) {
            return new int[]{GPHColor.INSTANCE.getWhite(), GPHColor.INSTANCE.getWhite()};
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, mo26107d2 = {"Lcom/giphy/sdk/ui/views/buttons/GPHGifButtonColor$Companion;", "", "()V", "getThemeColors", "", "Lcom/giphy/sdk/ui/views/buttons/GPHGifButtonColor;", "theme", "Lcom/giphy/sdk/ui/themes/Theme;", "(Lcom/giphy/sdk/ui/themes/Theme;)[Lcom/giphy/sdk/ui/views/buttons/GPHGifButtonColor;", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.views.buttons.GPHGifButtonColor$Companion */
    /* compiled from: GPHButtonColor.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GPHGifButtonColor[] getThemeColors(Theme theme) {
            Intrinsics.checkParameterIsNotNull(theme, "theme");
            GPHGifButtonColor[] gPHGifButtonColorArr = new GPHGifButtonColor[3];
            gPHGifButtonColorArr[0] = GPHGifButtonColor.pink;
            gPHGifButtonColorArr[1] = GPHGifButtonColor.blue;
            gPHGifButtonColorArr[2] = Intrinsics.areEqual((Object) theme, (Object) LightTheme.INSTANCE) ? GPHGifButtonColor.black : GPHGifButtonColor.white;
            return gPHGifButtonColorArr;
        }
    }
}
