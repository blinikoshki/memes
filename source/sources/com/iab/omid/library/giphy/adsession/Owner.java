package com.iab.omid.library.giphy.adsession;

import com.facebook.internal.AnalyticsEvents;

public enum Owner {
    NATIVE(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE),
    JAVASCRIPT("javascript"),
    NONE("none");
    
    private final String owner;

    private Owner(String str) {
        this.owner = str;
    }

    public String toString() {
        return this.owner;
    }
}
