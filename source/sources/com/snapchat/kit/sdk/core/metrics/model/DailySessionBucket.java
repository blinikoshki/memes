package com.snapchat.kit.sdk.core.metrics.model;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

public enum DailySessionBucket implements WireEnum {
    NO_SESSION_BUCKET(0),
    ONE_SESSION(1),
    TWO_SESSION(2),
    THREE_SESSION(3),
    FOUR_SESSION(4),
    FIVE_SESSION(5),
    SIX_SESSION(6),
    SEVEN_SESSION(7),
    EIGHT_SESSION(8),
    NINE_SESSION(9),
    TEN_OR_MORE_SESSION(10);
    
    public static final ProtoAdapter<DailySessionBucket> ADAPTER = null;
    private final int value;

    static {
        ADAPTER = new ProtoAdapter_DailySessionBucket();
    }

    private DailySessionBucket(int i) {
        this.value = i;
    }

    public static DailySessionBucket fromValue(int i) {
        switch (i) {
            case 0:
                return NO_SESSION_BUCKET;
            case 1:
                return ONE_SESSION;
            case 2:
                return TWO_SESSION;
            case 3:
                return THREE_SESSION;
            case 4:
                return FOUR_SESSION;
            case 5:
                return FIVE_SESSION;
            case 6:
                return SIX_SESSION;
            case 7:
                return SEVEN_SESSION;
            case 8:
                return EIGHT_SESSION;
            case 9:
                return NINE_SESSION;
            case 10:
                return TEN_OR_MORE_SESSION;
            default:
                return null;
        }
    }

    public final int getValue() {
        return this.value;
    }

    private static final class ProtoAdapter_DailySessionBucket extends EnumAdapter<DailySessionBucket> {
        ProtoAdapter_DailySessionBucket() {
            super(DailySessionBucket.class);
        }

        /* access modifiers changed from: protected */
        public final DailySessionBucket fromValue(int i) {
            return DailySessionBucket.fromValue(i);
        }
    }
}
