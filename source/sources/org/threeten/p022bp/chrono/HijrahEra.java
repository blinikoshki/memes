package org.threeten.p022bp.chrono;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Locale;
import org.threeten.p022bp.DateTimeException;
import org.threeten.p022bp.format.DateTimeFormatterBuilder;
import org.threeten.p022bp.format.TextStyle;
import org.threeten.p022bp.temporal.ChronoField;
import org.threeten.p022bp.temporal.ChronoUnit;
import org.threeten.p022bp.temporal.Temporal;
import org.threeten.p022bp.temporal.TemporalField;
import org.threeten.p022bp.temporal.TemporalQueries;
import org.threeten.p022bp.temporal.TemporalQuery;
import org.threeten.p022bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.p022bp.temporal.ValueRange;

/* renamed from: org.threeten.bp.chrono.HijrahEra */
public enum HijrahEra implements Era {
    BEFORE_AH,
    AH;

    /* renamed from: of */
    public static HijrahEra m278of(int i) {
        if (i == 0) {
            return BEFORE_AH;
        }
        if (i == 1) {
            return AH;
        }
        throw new DateTimeException("HijrahEra not valid");
    }

    public int getValue() {
        return ordinal();
    }

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

    public ValueRange range(TemporalField temporalField) {
        if (temporalField == ChronoField.ERA) {
            return ValueRange.m288of(1, 1);
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
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

    /* access modifiers changed from: package-private */
    public int prolepticYear(int i) {
        return this == AH ? i : 1 - i;
    }

    private Object writeReplace() {
        return new Ser((byte) 4, this);
    }

    /* access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(getValue());
    }

    static HijrahEra readExternal(DataInput dataInput) throws IOException {
        return m278of(dataInput.readByte());
    }
}
