package org.threeten.p022bp.jdk8;

import org.threeten.p022bp.temporal.ChronoField;
import org.threeten.p022bp.temporal.TemporalAccessor;
import org.threeten.p022bp.temporal.TemporalField;
import org.threeten.p022bp.temporal.TemporalQueries;
import org.threeten.p022bp.temporal.TemporalQuery;
import org.threeten.p022bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.p022bp.temporal.ValueRange;

/* renamed from: org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor */
public abstract class DefaultInterfaceTemporalAccessor implements TemporalAccessor {
    public ValueRange range(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        if (isSupported(temporalField)) {
            return temporalField.range();
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public int get(TemporalField temporalField) {
        return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.chronology() || temporalQuery == TemporalQueries.precision()) {
            return null;
        }
        return temporalQuery.queryFrom(this);
    }
}
