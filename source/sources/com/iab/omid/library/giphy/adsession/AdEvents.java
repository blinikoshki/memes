package com.iab.omid.library.giphy.adsession;

import com.iab.omid.library.giphy.p032d.C3987e;

public final class AdEvents {
    private final C3967a adSession;

    private AdEvents(C3967a aVar) {
        this.adSession = aVar;
    }

    public static AdEvents createAdEvents(AdSession adSession2) {
        C3967a aVar = (C3967a) adSession2;
        C3987e.m710a((Object) adSession2, "AdSession is null");
        C3987e.m715d(aVar);
        C3987e.m713b(aVar);
        AdEvents adEvents = new AdEvents(aVar);
        aVar.getAdSessionStatePublisher().mo55988a(adEvents);
        return adEvents;
    }

    public void impressionOccurred() {
        C3987e.m713b(this.adSession);
        C3987e.m717f(this.adSession);
        if (!this.adSession.mo55923d()) {
            try {
                this.adSession.start();
            } catch (Exception unused) {
            }
        }
        if (this.adSession.mo55923d()) {
            this.adSession.mo55921b();
        }
    }
}
