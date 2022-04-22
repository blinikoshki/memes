package com.appsflyer;

public class AdvertisingIdObject {
    private final Boolean $$a;
    private Boolean $$b;
    private final String valueOf;

    AdvertisingIdObject(String str, Boolean bool) {
        this.valueOf = str;
        this.$$a = bool;
    }

    public Boolean isManual() {
        return this.$$b;
    }

    public void setManual(boolean z) {
        this.$$b = Boolean.valueOf(z);
    }

    public String getAdvertisingId() {
        return this.valueOf;
    }

    public Boolean isLimitAdTracking() {
        return this.$$a;
    }
}
