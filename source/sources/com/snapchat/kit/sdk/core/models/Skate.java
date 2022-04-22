package com.snapchat.kit.sdk.core.models;

import com.snapchat.kit.sdk.core.metrics.model.DailySessionBucket;

public class Skate {
    private int mCount;
    public final SkateDate mDate;

    public Skate(SkateDate skateDate, int i) {
        this.mDate = skateDate;
        this.mCount = i;
    }

    public void incrementCount() {
        this.mCount++;
    }

    public int getCount() {
        return this.mCount;
    }

    public DailySessionBucket getDailySessionBucket() {
        switch (this.mCount) {
            case 1:
                return DailySessionBucket.ONE_SESSION;
            case 2:
                return DailySessionBucket.TWO_SESSION;
            case 3:
                return DailySessionBucket.THREE_SESSION;
            case 4:
                return DailySessionBucket.FOUR_SESSION;
            case 5:
                return DailySessionBucket.FIVE_SESSION;
            case 6:
                return DailySessionBucket.SIX_SESSION;
            case 7:
                return DailySessionBucket.SEVEN_SESSION;
            case 8:
                return DailySessionBucket.EIGHT_SESSION;
            case 9:
                return DailySessionBucket.NINE_SESSION;
            default:
                return DailySessionBucket.TEN_OR_MORE_SESSION;
        }
    }
}
