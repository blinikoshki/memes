package com.iab.omid.library.giphy.adsession;

import android.view.View;
import com.iab.omid.library.giphy.p032d.C3987e;
import com.iab.omid.library.giphy.publisher.AdSessionStatePublisher;

public abstract class AdSession {
    public static AdSession createAdSession(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        C3987e.m707a();
        C3987e.m710a((Object) adSessionConfiguration, "AdSessionConfiguration is null");
        C3987e.m710a((Object) adSessionContext, "AdSessionContext is null");
        return new C3967a(adSessionConfiguration, adSessionContext);
    }

    public abstract void addFriendlyObstruction(View view);

    public abstract void error(ErrorType errorType, String str);

    public abstract void finish();

    public abstract String getAdSessionId();

    public abstract AdSessionStatePublisher getAdSessionStatePublisher();

    public abstract void registerAdView(View view);

    public abstract void removeAllFriendlyObstructions();

    public abstract void removeFriendlyObstruction(View view);

    public abstract void start();
}
