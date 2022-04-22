package org.threeten.p022bp.jdk8;

import org.threeten.p022bp.temporal.Temporal;
import org.threeten.p022bp.temporal.TemporalAdjuster;
import org.threeten.p022bp.temporal.TemporalAmount;
import org.threeten.p022bp.temporal.TemporalUnit;

/* renamed from: org.threeten.bp.jdk8.DefaultInterfaceTemporal */
public abstract class DefaultInterfaceTemporal extends DefaultInterfaceTemporalAccessor implements Temporal {
    public Temporal with(TemporalAdjuster temporalAdjuster) {
        return temporalAdjuster.adjustInto(this);
    }

    public Temporal plus(TemporalAmount temporalAmount) {
        return temporalAmount.addTo(this);
    }

    public Temporal minus(TemporalAmount temporalAmount) {
        return temporalAmount.subtractFrom(this);
    }

    public Temporal minus(long j, TemporalUnit temporalUnit) {
        return j == Long.MIN_VALUE ? plus(Long.MAX_VALUE, temporalUnit).plus(1, temporalUnit) : plus(-j, temporalUnit);
    }
}
