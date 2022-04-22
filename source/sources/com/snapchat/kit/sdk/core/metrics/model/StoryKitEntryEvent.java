package com.snapchat.kit.sdk.core.metrics.model;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

public enum StoryKitEntryEvent implements WireEnum {
    STORY_KIT_ENTRY_EVENT_PLAYER_NONE(0),
    STORY_KIT_ENTRY_EVENT_PLAYER_OPEN(1),
    STORY_KIT_ENTRY_EVENT_TAP_LEFT(2),
    STORY_KIT_ENTRY_EVENT_TAP_RIGHT(3),
    STORY_KIT_ENTRY_EVENT_AUTO_ADVANCE(4);
    
    public static final ProtoAdapter<StoryKitEntryEvent> ADAPTER = null;
    private final int value;

    static {
        ADAPTER = new ProtoAdapter_StoryKitEntryEvent();
    }

    private StoryKitEntryEvent(int i) {
        this.value = i;
    }

    public static StoryKitEntryEvent fromValue(int i) {
        if (i == 0) {
            return STORY_KIT_ENTRY_EVENT_PLAYER_NONE;
        }
        if (i == 1) {
            return STORY_KIT_ENTRY_EVENT_PLAYER_OPEN;
        }
        if (i == 2) {
            return STORY_KIT_ENTRY_EVENT_TAP_LEFT;
        }
        if (i == 3) {
            return STORY_KIT_ENTRY_EVENT_TAP_RIGHT;
        }
        if (i != 4) {
            return null;
        }
        return STORY_KIT_ENTRY_EVENT_AUTO_ADVANCE;
    }

    public final int getValue() {
        return this.value;
    }

    private static final class ProtoAdapter_StoryKitEntryEvent extends EnumAdapter<StoryKitEntryEvent> {
        ProtoAdapter_StoryKitEntryEvent() {
            super(StoryKitEntryEvent.class);
        }

        /* access modifiers changed from: protected */
        public final StoryKitEntryEvent fromValue(int i) {
            return StoryKitEntryEvent.fromValue(i);
        }
    }
}
