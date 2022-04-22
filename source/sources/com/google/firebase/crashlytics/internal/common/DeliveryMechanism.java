package com.google.firebase.crashlytics.internal.common;

public enum DeliveryMechanism {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);
    

    /* renamed from: id */
    private final int f767id;

    private DeliveryMechanism(int i) {
        this.f767id = i;
    }

    public int getId() {
        return this.f767id;
    }

    public String toString() {
        return Integer.toString(this.f767id);
    }

    public static DeliveryMechanism determineFrom(String str) {
        return str != null ? APP_STORE : DEVELOPER;
    }
}
