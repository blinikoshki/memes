package com.snapchat.kit.sdk.core.metrics.model;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

public enum StoryKitMediaType implements WireEnum {
    STORY_KIT_MEDIA_TYPE_NONE(0),
    STORY_KIT_MEDIA_TYPE_VIDEO(1),
    STORY_KIT_MEDIA_TYPE_IMAGE(2);
    
    public static final ProtoAdapter<StoryKitMediaType> ADAPTER = null;
    private final int value;

    static {
        ADAPTER = new ProtoAdapter_StoryKitMediaType();
    }

    private StoryKitMediaType(int i) {
        this.value = i;
    }

    public static StoryKitMediaType fromValue(int i) {
        if (i == 0) {
            return STORY_KIT_MEDIA_TYPE_NONE;
        }
        if (i == 1) {
            return STORY_KIT_MEDIA_TYPE_VIDEO;
        }
        if (i != 2) {
            return null;
        }
        return STORY_KIT_MEDIA_TYPE_IMAGE;
    }

    public final int getValue() {
        return this.value;
    }

    private static final class ProtoAdapter_StoryKitMediaType extends EnumAdapter<StoryKitMediaType> {
        ProtoAdapter_StoryKitMediaType() {
            super(StoryKitMediaType.class);
        }

        /* access modifiers changed from: protected */
        public final StoryKitMediaType fromValue(int i) {
            return StoryKitMediaType.fromValue(i);
        }
    }
}
