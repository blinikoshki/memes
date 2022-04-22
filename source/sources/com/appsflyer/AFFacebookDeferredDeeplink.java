package com.appsflyer;

public final class AFFacebookDeferredDeeplink {
    private final boolean $$a;
    public final long $$b;
    public final String AFDateFormat;

    public interface AppLinkFetchEvents {
        void onAppLinkFetchFailed(String str);

        void onAppLinkFetchFinished(String str, String str2, String str3);
    }

    AFFacebookDeferredDeeplink() {
    }

    public AFFacebookDeferredDeeplink(String str, long j, boolean z) {
        this.AFDateFormat = str;
        this.$$b = j;
        this.$$a = z;
    }

    public final boolean AFDateFormat() {
        return this.$$a;
    }
}
