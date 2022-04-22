package com.appsflyer.internal.model.event;

import android.content.Context;
import com.appsflyer.AFEvent;

public class AdRevenue extends AFEvent {
    public AdRevenue() {
        super((String) null, (String) null, Boolean.FALSE, (Context) null);
    }

    public AFEvent urlString(String str) {
        return super.urlString(addChannel(str));
    }
}
