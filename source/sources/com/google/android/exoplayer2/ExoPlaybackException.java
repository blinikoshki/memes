package com.google.android.exoplayer2;

import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.TimeoutException;

public final class ExoPlaybackException extends Exception {
    public static final int TIMEOUT_OPERATION_RELEASE = 1;
    public static final int TIMEOUT_OPERATION_SET_FOREGROUND_MODE = 2;
    public static final int TIMEOUT_OPERATION_UNDEFINED = 0;
    public static final int TYPE_OUT_OF_MEMORY = 4;
    public static final int TYPE_REMOTE = 3;
    public static final int TYPE_RENDERER = 1;
    public static final int TYPE_SOURCE = 0;
    public static final int TYPE_TIMEOUT = 5;
    public static final int TYPE_UNEXPECTED = 2;
    private final Throwable cause;
    public final MediaSource.MediaPeriodId mediaPeriodId;
    public final Format rendererFormat;
    public final int rendererFormatSupport;
    public final int rendererIndex;
    public final String rendererName;
    public final int timeoutOperation;
    public final long timestampMs;
    public final int type;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface TimeoutOperation {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    public static ExoPlaybackException createForSource(IOException iOException) {
        return new ExoPlaybackException(0, (Throwable) iOException);
    }

    public static ExoPlaybackException createForRenderer(Exception exc, String str, int i, Format format, int i2) {
        return new ExoPlaybackException(1, exc, (String) null, str, i, format, format == null ? 4 : i2, 0);
    }

    public static ExoPlaybackException createForUnexpected(RuntimeException runtimeException) {
        return new ExoPlaybackException(2, (Throwable) runtimeException);
    }

    public static ExoPlaybackException createForRemote(String str) {
        return new ExoPlaybackException(3, str);
    }

    public static ExoPlaybackException createForOutOfMemory(OutOfMemoryError outOfMemoryError) {
        return new ExoPlaybackException(4, (Throwable) outOfMemoryError);
    }

    public static ExoPlaybackException createForTimeout(TimeoutException timeoutException, int i) {
        return new ExoPlaybackException(5, timeoutException, (String) null, (String) null, -1, (Format) null, 4, i);
    }

    private ExoPlaybackException(int i, Throwable th) {
        this(i, th, (String) null, (String) null, -1, (Format) null, 4, 0);
    }

    private ExoPlaybackException(int i, String str) {
        this(i, (Throwable) null, str, (String) null, -1, (Format) null, 4, 0);
    }

    private ExoPlaybackException(int i, Throwable th, String str, String str2, int i2, Format format, int i3, int i4) {
        this(deriveMessage(i, str, str2, i2, format, i3), th, i, str2, i2, format, i3, (MediaSource.MediaPeriodId) null, i4, SystemClock.elapsedRealtime());
    }

    private ExoPlaybackException(String str, Throwable th, int i, String str2, int i2, Format format, int i3, MediaSource.MediaPeriodId mediaPeriodId2, int i4, long j) {
        super(str, th);
        this.type = i;
        this.cause = th;
        this.rendererName = str2;
        this.rendererIndex = i2;
        this.rendererFormat = format;
        this.rendererFormatSupport = i3;
        this.mediaPeriodId = mediaPeriodId2;
        this.timeoutOperation = i4;
        this.timestampMs = j;
    }

    public IOException getSourceException() {
        Assertions.checkState(this.type == 0);
        return (IOException) Assertions.checkNotNull(this.cause);
    }

    public Exception getRendererException() {
        boolean z = true;
        if (this.type != 1) {
            z = false;
        }
        Assertions.checkState(z);
        return (Exception) Assertions.checkNotNull(this.cause);
    }

    public RuntimeException getUnexpectedException() {
        Assertions.checkState(this.type == 2);
        return (RuntimeException) Assertions.checkNotNull(this.cause);
    }

    public OutOfMemoryError getOutOfMemoryError() {
        Assertions.checkState(this.type == 4);
        return (OutOfMemoryError) Assertions.checkNotNull(this.cause);
    }

    public TimeoutException getTimeoutException() {
        Assertions.checkState(this.type == 5);
        return (TimeoutException) Assertions.checkNotNull(this.cause);
    }

    /* access modifiers changed from: package-private */
    public ExoPlaybackException copyWithMediaPeriodId(MediaSource.MediaPeriodId mediaPeriodId2) {
        return new ExoPlaybackException(getMessage(), this.cause, this.type, this.rendererName, this.rendererIndex, this.rendererFormat, this.rendererFormatSupport, mediaPeriodId2, this.timeoutOperation, this.timestampMs);
    }

    private static String deriveMessage(int i, String str, String str2, int i2, Format format, int i3) {
        String str3;
        if (i == 0) {
            str3 = "Source error";
        } else if (i != 1) {
            str3 = i != 3 ? i != 4 ? i != 5 ? "Unexpected runtime error" : "Timeout error" : "Out of memory error" : "Remote error";
        } else {
            String valueOf = String.valueOf(format);
            String formatSupportString = RendererCapabilities.CC.getFormatSupportString(i3);
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 53 + String.valueOf(valueOf).length() + String.valueOf(formatSupportString).length());
            sb.append(str2);
            sb.append(" error, index=");
            sb.append(i2);
            sb.append(", format=");
            sb.append(valueOf);
            sb.append(", format_supported=");
            sb.append(formatSupportString);
            str3 = sb.toString();
        }
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        String valueOf2 = String.valueOf(str3);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 2 + String.valueOf(str).length());
        sb2.append(valueOf2);
        sb2.append(": ");
        sb2.append(str);
        return sb2.toString();
    }
}
