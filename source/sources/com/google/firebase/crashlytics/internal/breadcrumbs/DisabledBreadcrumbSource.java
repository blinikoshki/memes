package com.google.firebase.crashlytics.internal.breadcrumbs;

import com.google.firebase.crashlytics.internal.Logger;

public class DisabledBreadcrumbSource implements BreadcrumbSource {
    public void registerBreadcrumbHandler(BreadcrumbHandler breadcrumbHandler) {
        Logger.getLogger().mo53729d("Could not register handler for breadcrumbs events.");
    }
}
