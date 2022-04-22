package com.appsflyer.internal.model.event;

import android.content.Context;

public abstract class Purchase extends BackgroundEvent {
    Purchase() {
        this((String) null, (Boolean) null, (Context) null);
    }

    Purchase(String str, Boolean bool, Context context) {
        super(str, (String) null, Boolean.FALSE, (Boolean) null, bool, context);
    }
}
