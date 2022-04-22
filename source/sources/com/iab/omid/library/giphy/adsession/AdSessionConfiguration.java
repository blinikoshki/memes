package com.iab.omid.library.giphy.adsession;

import com.iab.omid.library.giphy.p032d.C3983b;
import com.iab.omid.library.giphy.p032d.C3987e;
import org.json.JSONObject;

public class AdSessionConfiguration {
    private final Owner impressionOwner;
    private final boolean isolateVerificationScripts;
    private final Owner videoEventsOwner;

    private AdSessionConfiguration(Owner owner, Owner owner2, boolean z) {
        this.impressionOwner = owner;
        if (owner2 == null) {
            this.videoEventsOwner = Owner.NONE;
        } else {
            this.videoEventsOwner = owner2;
        }
        this.isolateVerificationScripts = z;
    }

    @Deprecated
    public static AdSessionConfiguration createAdSessionConfiguration(Owner owner, Owner owner2) {
        return createAdSessionConfiguration(owner, owner2, true);
    }

    public static AdSessionConfiguration createAdSessionConfiguration(Owner owner, Owner owner2, boolean z) {
        C3987e.m710a((Object) owner, "Impression owner is null");
        C3987e.m708a(owner);
        return new AdSessionConfiguration(owner, owner2, z);
    }

    public boolean isNativeImpressionOwner() {
        return Owner.NATIVE == this.impressionOwner;
    }

    public boolean isNativeVideoEventsOwner() {
        return Owner.NATIVE == this.videoEventsOwner;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        C3983b.m694a(jSONObject, "impressionOwner", this.impressionOwner);
        C3983b.m694a(jSONObject, "videoEventsOwner", this.videoEventsOwner);
        C3983b.m694a(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.isolateVerificationScripts));
        return jSONObject;
    }
}
