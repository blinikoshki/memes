package com.snapchat.kit.sdk.core.metrics.model;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

public enum BitmojiKitSearchBarConfiguration implements WireEnum {
    SEARCH_BAR_VISIBLE(0),
    SEARCH_BAR_HIDDEN(1);
    
    public static final ProtoAdapter<BitmojiKitSearchBarConfiguration> ADAPTER = null;
    private final int value;

    static {
        ADAPTER = new ProtoAdapter_BitmojiKitSearchBarConfiguration();
    }

    private BitmojiKitSearchBarConfiguration(int i) {
        this.value = i;
    }

    public static BitmojiKitSearchBarConfiguration fromValue(int i) {
        if (i == 0) {
            return SEARCH_BAR_VISIBLE;
        }
        if (i != 1) {
            return null;
        }
        return SEARCH_BAR_HIDDEN;
    }

    public final int getValue() {
        return this.value;
    }

    private static final class ProtoAdapter_BitmojiKitSearchBarConfiguration extends EnumAdapter<BitmojiKitSearchBarConfiguration> {
        ProtoAdapter_BitmojiKitSearchBarConfiguration() {
            super(BitmojiKitSearchBarConfiguration.class);
        }

        /* access modifiers changed from: protected */
        public final BitmojiKitSearchBarConfiguration fromValue(int i) {
            return BitmojiKitSearchBarConfiguration.fromValue(i);
        }
    }
}
