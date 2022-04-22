package org.threeten.p022bp.temporal;

import org.threeten.p022bp.DateTimeException;

/* renamed from: org.threeten.bp.temporal.UnsupportedTemporalTypeException */
public class UnsupportedTemporalTypeException extends DateTimeException {
    private static final long serialVersionUID = -189676278478L;

    public UnsupportedTemporalTypeException(String str) {
        super(str);
    }

    public UnsupportedTemporalTypeException(String str, Throwable th) {
        super(str, th);
    }
}
