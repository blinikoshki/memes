package com.appsflyer.internal.model.event;

import android.content.Context;
import com.appsflyer.AFEvent;
import com.appsflyer.AFHelper;

public abstract class BackgroundEvent extends AFEvent {
    private boolean getDataFormatter;
    private final boolean getInstance;
    private final boolean requestListener;

    BackgroundEvent() {
        this((String) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (Context) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackgroundEvent(String str, String str2, Boolean bool, Boolean bool2, Boolean bool3, Context context) {
        super(str, str2, Boolean.valueOf(bool3 != null ? bool3.booleanValue() : false), context);
        boolean z = true;
        this.getInstance = bool != null ? bool.booleanValue() : true;
        this.requestListener = bool2 != null ? bool2.booleanValue() : z;
    }

    public BackgroundEvent trackingStopped(boolean z) {
        this.getDataFormatter = z;
        return this;
    }

    public boolean trackingStopped() {
        return this.getDataFormatter;
    }

    public boolean readResponse() {
        return this.getInstance;
    }

    public boolean proxyMode() {
        return this.requestListener;
    }

    public String body() {
        return AFHelper.toJsonObject(params()).toString();
    }
}
