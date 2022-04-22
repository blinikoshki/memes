package com.snapchat.kit.sdk.core.models;

public final class SkateDate {
    public final long mDay;
    public final long mMonth;
    public final long mYear;

    public SkateDate(long j, long j2, long j3) {
        this.mDay = j;
        this.mMonth = j2;
        this.mYear = j3;
    }

    public final boolean isSameDate(SkateDate skateDate) {
        return this.mDay == skateDate.mDay && isSameMonth(skateDate);
    }

    public final boolean isSameMonth(SkateDate skateDate) {
        return this.mMonth == skateDate.mMonth && this.mYear == skateDate.mYear;
    }
}
