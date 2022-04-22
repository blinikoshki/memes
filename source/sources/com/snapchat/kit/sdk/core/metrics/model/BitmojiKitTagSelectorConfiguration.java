package com.snapchat.kit.sdk.core.metrics.model;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

public enum BitmojiKitTagSelectorConfiguration implements WireEnum {
    TAG_SELECTOR_VISIBLE(0),
    TAG_SELECTOR_HIDDEN(1);
    
    public static final ProtoAdapter<BitmojiKitTagSelectorConfiguration> ADAPTER = null;
    private final int value;

    static {
        ADAPTER = new ProtoAdapter_BitmojiKitTagSelectorConfiguration();
    }

    private BitmojiKitTagSelectorConfiguration(int i) {
        this.value = i;
    }

    public static BitmojiKitTagSelectorConfiguration fromValue(int i) {
        if (i == 0) {
            return TAG_SELECTOR_VISIBLE;
        }
        if (i != 1) {
            return null;
        }
        return TAG_SELECTOR_HIDDEN;
    }

    public final int getValue() {
        return this.value;
    }

    private static final class ProtoAdapter_BitmojiKitTagSelectorConfiguration extends EnumAdapter<BitmojiKitTagSelectorConfiguration> {
        ProtoAdapter_BitmojiKitTagSelectorConfiguration() {
            super(BitmojiKitTagSelectorConfiguration.class);
        }

        /* access modifiers changed from: protected */
        public final BitmojiKitTagSelectorConfiguration fromValue(int i) {
            return BitmojiKitTagSelectorConfiguration.fromValue(i);
        }
    }
}
