package com.giphy.sdk.p013ui.views.buttons;

import com.giphy.sdk.p013ui.C1800R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, mo26107d2 = {"Lcom/giphy/sdk/ui/views/buttons/GPHContentTypeButtonStyle;", "", "(Ljava/lang/String;I)V", "image", "", "getImage$ui_sdk_release", "()I", "stickers", "emoji", "text", "stickersOutline", "emojiOutline", "textOutline", "Companion", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.buttons.GPHContentTypeButtonStyle */
/* compiled from: GPHContentTypeButton.kt */
public enum GPHContentTypeButtonStyle {
    stickers,
    emoji,
    text,
    stickersOutline,
    emojiOutline,
    textOutline;
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final GPHContentTypeButtonStyle defaultSetting = null;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.views.buttons.GPHContentTypeButtonStyle$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] iArr = new int[GPHContentTypeButtonStyle.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[GPHContentTypeButtonStyle.stickers.ordinal()] = 1;
            iArr[GPHContentTypeButtonStyle.emoji.ordinal()] = 2;
            iArr[GPHContentTypeButtonStyle.text.ordinal()] = 3;
            iArr[GPHContentTypeButtonStyle.stickersOutline.ordinal()] = 4;
            iArr[GPHContentTypeButtonStyle.emojiOutline.ordinal()] = 5;
            iArr[GPHContentTypeButtonStyle.textOutline.ordinal()] = 6;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/giphy/sdk/ui/views/buttons/GPHContentTypeButtonStyle$Companion;", "", "()V", "defaultSetting", "Lcom/giphy/sdk/ui/views/buttons/GPHContentTypeButtonStyle;", "getDefaultSetting", "()Lcom/giphy/sdk/ui/views/buttons/GPHContentTypeButtonStyle;", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.views.buttons.GPHContentTypeButtonStyle$Companion */
    /* compiled from: GPHContentTypeButton.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GPHContentTypeButtonStyle getDefaultSetting() {
            return GPHContentTypeButtonStyle.defaultSetting;
        }
    }

    static {
        GPHContentTypeButtonStyle gPHContentTypeButtonStyle;
        Companion = new Companion((DefaultConstructorMarker) null);
        defaultSetting = gPHContentTypeButtonStyle;
    }

    public final int getImage$ui_sdk_release() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return C1800R.C1802drawable.gph_button_icon_sticker;
            case 2:
                return C1800R.C1802drawable.gph_button_icon_emoji_stroke;
            case 3:
                return C1800R.C1802drawable.gph_button_icon_text;
            case 4:
                return C1800R.C1802drawable.gph_button_icon_sticker_stroke;
            case 5:
                return C1800R.C1802drawable.gph_button_icon_emoji;
            case 6:
                return C1800R.C1802drawable.gph_button_icon_text_stroke;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
