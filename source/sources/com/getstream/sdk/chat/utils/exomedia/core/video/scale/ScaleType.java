package com.getstream.sdk.chat.utils.exomedia.core.video.scale;

public enum ScaleType {
    CENTER,
    CENTER_CROP,
    CENTER_INSIDE,
    FIT_CENTER,
    FIT_XY,
    NONE;

    public static ScaleType fromOrdinal(int i) {
        if (i < 0 || i > NONE.ordinal()) {
            return NONE;
        }
        return values()[i];
    }
}
