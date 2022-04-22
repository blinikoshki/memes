package org.threeten.p022bp.jdk8;

import java.util.Locale;
import org.threeten.p022bp.chrono.Era;
import org.threeten.p022bp.format.DateTimeFormatterBuilder;
import org.threeten.p022bp.format.TextStyle;
import org.threeten.p022bp.temporal.ChronoField;
import org.threeten.p022bp.temporal.ChronoUnit;
import org.threeten.p022bp.temporal.Temporal;
import org.threeten.p022bp.temporal.TemporalField;
import org.threeten.p022bp.temporal.TemporalQueries;
import org.threeten.p022bp.temporal.TemporalQuery;
import org.threeten.p022bp.temporal.UnsupportedTemporalTypeException;

/* renamed from: org.threeten.bp.jdk8.DefaultInterfaceEra */
public abstract class DefaultInterfaceEra extends DefaultInterfaceTemporalAccessor implements Era {
    public boolean isSupported(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            if (temporalField == ChronoField.ERA) {
                return true;
            }
            return false;
        } else if (temporalField == null || !temporalField.isSupportedBy(this)) {
            return false;
        } else {
            return true;
        }
    }

    public int get(TemporalField temporalField) {
        if (temporalField == ChronoField.ERA) {
            return getValue();
        }
        return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    public long getLong(TemporalField temporalField) {
        if (temporalField == ChronoField.ERA) {
            return (long) getValue();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.ERA, (long) getValue());
    }

    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.precision()) {
            return ChronoUnit.ERAS;
        }
        if (temporalQuery == TemporalQueries.chronology() || temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.offset() || temporalQuery == TemporalQueries.localDate() || temporalQuery == TemporalQueries.localTime()) {
            return null;
        }
        return temporalQuery.queryFrom(this);
    }

    public String getDisplayName(TextStyle textStyle, Locale locale) {
        return new DateTimeFormatterBuilder().appendText((TemporalField) ChronoField.ERA, textStyle).toFormatter(locale).format(this);
    }
}
