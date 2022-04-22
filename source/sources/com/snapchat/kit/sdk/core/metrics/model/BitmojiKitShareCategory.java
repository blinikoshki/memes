package com.snapchat.kit.sdk.core.metrics.model;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

public enum BitmojiKitShareCategory implements WireEnum {
    UNKNOWN_BITMOJI_KIT_SHARE_CATEGORY(0),
    POPULAR(1),
    SEARCH(2);
    
    public static final ProtoAdapter<BitmojiKitShareCategory> ADAPTER = null;
    private final int value;

    static {
        ADAPTER = new ProtoAdapter_BitmojiKitShareCategory();
    }

    private BitmojiKitShareCategory(int i) {
        this.value = i;
    }

    public static BitmojiKitShareCategory fromValue(int i) {
        if (i == 0) {
            return UNKNOWN_BITMOJI_KIT_SHARE_CATEGORY;
        }
        if (i == 1) {
            return POPULAR;
        }
        if (i != 2) {
            return null;
        }
        return SEARCH;
    }

    public final int getValue() {
        return this.value;
    }

    private static final class ProtoAdapter_BitmojiKitShareCategory extends EnumAdapter<BitmojiKitShareCategory> {
        ProtoAdapter_BitmojiKitShareCategory() {
            super(BitmojiKitShareCategory.class);
        }

        /* access modifiers changed from: protected */
        public final BitmojiKitShareCategory fromValue(int i) {
            return BitmojiKitShareCategory.fromValue(i);
        }
    }
}
