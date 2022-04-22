package com.iab.omid.library.giphy.adsession.video;

import com.iab.omid.library.giphy.p032d.C3985c;
import com.iab.omid.library.giphy.p032d.C3987e;
import org.json.JSONException;
import org.json.JSONObject;

public final class VastProperties {
    private static final String TAG = "VastProperties: ";
    private final boolean isAutoPlay;
    private final boolean isSkippable;
    private final Position position;
    private final Float skipOffset;

    private VastProperties(boolean z, Float f, boolean z2, Position position2) {
        this.isSkippable = z;
        this.skipOffset = f;
        this.isAutoPlay = z2;
        this.position = position2;
    }

    public static VastProperties createVastPropertiesForNonSkippableVideo(boolean z, Position position2) {
        C3987e.m710a((Object) position2, "Position is null");
        return new VastProperties(false, (Float) null, z, position2);
    }

    public static VastProperties createVastPropertiesForSkippableVideo(float f, boolean z, Position position2) {
        C3987e.m710a((Object) position2, "Position is null");
        return new VastProperties(true, Float.valueOf(f), z, position2);
    }

    /* access modifiers changed from: package-private */
    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.isSkippable);
            if (this.isSkippable) {
                jSONObject.put("skipOffset", this.skipOffset);
            }
            jSONObject.put("autoPlay", this.isAutoPlay);
            jSONObject.put("position", this.position);
        } catch (JSONException e) {
            C3985c.m705a("VastProperties: JSON error", e);
        }
        return jSONObject;
    }
}
