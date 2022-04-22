package com.appsflyer.internal.model.event;

import android.content.Context;

public class ProxyEvent extends BackgroundEvent {
    private String getInstance;

    public ProxyEvent() {
        super((String) null, (String) null, (Boolean) null, Boolean.FALSE, (Boolean) null, (Context) null);
    }

    public BackgroundEvent body(String str) {
        this.getInstance = str;
        return this;
    }

    public String body() {
        return this.getInstance;
    }
}
