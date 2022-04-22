package com.snapchat.kit.sdk.core.metrics.model;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

public enum StoryKitPlayerType implements WireEnum {
    STORY_KIT_PLAYER_TYPE_NONE(0),
    STORY_KIT_PLAYER_TYPE_EMBEDDED(1),
    STORY_KIT_PLAYER_TYPE_FULLSCREEN(2);
    
    public static final ProtoAdapter<StoryKitPlayerType> ADAPTER = null;
    private final int value;

    static {
        ADAPTER = new ProtoAdapter_StoryKitPlayerType();
    }

    private StoryKitPlayerType(int i) {
        this.value = i;
    }

    public static StoryKitPlayerType fromValue(int i) {
        if (i == 0) {
            return STORY_KIT_PLAYER_TYPE_NONE;
        }
        if (i == 1) {
            return STORY_KIT_PLAYER_TYPE_EMBEDDED;
        }
        if (i != 2) {
            return null;
        }
        return STORY_KIT_PLAYER_TYPE_FULLSCREEN;
    }

    public final int getValue() {
        return this.value;
    }

    private static final class ProtoAdapter_StoryKitPlayerType extends EnumAdapter<StoryKitPlayerType> {
        ProtoAdapter_StoryKitPlayerType() {
            super(StoryKitPlayerType.class);
        }

        /* access modifiers changed from: protected */
        public final StoryKitPlayerType fromValue(int i) {
            return StoryKitPlayerType.fromValue(i);
        }
    }
}
