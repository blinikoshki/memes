package com.facebook.common.logging;

public interface LoggingDelegate {
    /* renamed from: d */
    void mo15532d(String str, String str2);

    /* renamed from: d */
    void mo15533d(String str, String str2, Throwable th);

    /* renamed from: e */
    void mo15534e(String str, String str2);

    /* renamed from: e */
    void mo15535e(String str, String str2, Throwable th);

    int getMinimumLoggingLevel();

    /* renamed from: i */
    void mo15537i(String str, String str2);

    /* renamed from: i */
    void mo15538i(String str, String str2, Throwable th);

    boolean isLoggable(int i);

    void log(int i, String str, String str2);

    void setMinimumLoggingLevel(int i);

    /* renamed from: v */
    void mo15543v(String str, String str2);

    /* renamed from: v */
    void mo15544v(String str, String str2, Throwable th);

    /* renamed from: w */
    void mo15545w(String str, String str2);

    /* renamed from: w */
    void mo15546w(String str, String str2, Throwable th);

    void wtf(String str, String str2);

    void wtf(String str, String str2, Throwable th);
}
