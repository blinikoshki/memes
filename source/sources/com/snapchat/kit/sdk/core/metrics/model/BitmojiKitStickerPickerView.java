package com.snapchat.kit.sdk.core.metrics.model;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

public enum BitmojiKitStickerPickerView implements WireEnum {
    UNKNOWN_BITMOJI_KIT_PICKER_VIEW(0),
    STICKER_PICKER(1),
    CREATE_AVATAR(2),
    LINK_ACCOUNT(3),
    NOT_AUTHORIZED(4),
    ERROR_VIEW(5);
    
    public static final ProtoAdapter<BitmojiKitStickerPickerView> ADAPTER = null;
    private final int value;

    static {
        ADAPTER = new ProtoAdapter_BitmojiKitStickerPickerView();
    }

    private BitmojiKitStickerPickerView(int i) {
        this.value = i;
    }

    public static BitmojiKitStickerPickerView fromValue(int i) {
        if (i == 0) {
            return UNKNOWN_BITMOJI_KIT_PICKER_VIEW;
        }
        if (i == 1) {
            return STICKER_PICKER;
        }
        if (i == 2) {
            return CREATE_AVATAR;
        }
        if (i == 3) {
            return LINK_ACCOUNT;
        }
        if (i == 4) {
            return NOT_AUTHORIZED;
        }
        if (i != 5) {
            return null;
        }
        return ERROR_VIEW;
    }

    public final int getValue() {
        return this.value;
    }

    private static final class ProtoAdapter_BitmojiKitStickerPickerView extends EnumAdapter<BitmojiKitStickerPickerView> {
        ProtoAdapter_BitmojiKitStickerPickerView() {
            super(BitmojiKitStickerPickerView.class);
        }

        /* access modifiers changed from: protected */
        public final BitmojiKitStickerPickerView fromValue(int i) {
            return BitmojiKitStickerPickerView.fromValue(i);
        }
    }
}
