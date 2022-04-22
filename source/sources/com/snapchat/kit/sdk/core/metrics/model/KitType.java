package com.snapchat.kit.sdk.core.metrics.model;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

public enum KitType implements WireEnum {
    UNKNOWN_KIT_TYPE(0),
    BITMOJI_KIT(1),
    CREATIVE_KIT(2),
    LOGIN_KIT(3),
    STORY_KIT(4);
    
    public static final ProtoAdapter<KitType> ADAPTER = null;
    private final int value;

    static {
        ADAPTER = new ProtoAdapter_KitType();
    }

    private KitType(int i) {
        this.value = i;
    }

    public static KitType fromValue(int i) {
        if (i == 0) {
            return UNKNOWN_KIT_TYPE;
        }
        if (i == 1) {
            return BITMOJI_KIT;
        }
        if (i == 2) {
            return CREATIVE_KIT;
        }
        if (i == 3) {
            return LOGIN_KIT;
        }
        if (i != 4) {
            return null;
        }
        return STORY_KIT;
    }

    public final int getValue() {
        return this.value;
    }

    private static final class ProtoAdapter_KitType extends EnumAdapter<KitType> {
        ProtoAdapter_KitType() {
            super(KitType.class);
        }

        /* access modifiers changed from: protected */
        public final KitType fromValue(int i) {
            return KitType.fromValue(i);
        }
    }
}
