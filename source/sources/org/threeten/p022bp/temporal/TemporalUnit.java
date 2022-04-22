package org.threeten.p022bp.temporal;

import org.threeten.p022bp.Duration;

/* renamed from: org.threeten.bp.temporal.TemporalUnit */
public interface TemporalUnit {
    <R extends Temporal> R addTo(R r, long j);

    long between(Temporal temporal, Temporal temporal2);

    Duration getDuration();

    boolean isDateBased();

    boolean isDurationEstimated();

    boolean isSupportedBy(Temporal temporal);

    boolean isTimeBased();

    String toString();
}
