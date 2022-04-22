package org.threeten.p022bp.temporal;

import java.util.List;

/* renamed from: org.threeten.bp.temporal.TemporalAmount */
public interface TemporalAmount {
    Temporal addTo(Temporal temporal);

    long get(TemporalUnit temporalUnit);

    List<TemporalUnit> getUnits();

    Temporal subtractFrom(Temporal temporal);
}
