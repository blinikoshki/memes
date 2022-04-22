package com.iab.omid.library.giphy.adsession.video;

import com.iab.omid.library.giphy.adsession.AdSession;
import com.iab.omid.library.giphy.adsession.C3967a;
import com.iab.omid.library.giphy.p030b.C3976e;
import com.iab.omid.library.giphy.p032d.C3983b;
import com.iab.omid.library.giphy.p032d.C3987e;
import org.json.JSONObject;

public final class VideoEvents {
    private final C3967a adSession;

    private VideoEvents(C3967a aVar) {
        this.adSession = aVar;
    }

    private void confirmValidDuration(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Invalid Video duration");
        }
    }

    private void confirmValidVolume(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Invalid Video volume");
        }
    }

    public static VideoEvents createVideoEvents(AdSession adSession2) {
        C3967a aVar = (C3967a) adSession2;
        C3987e.m710a((Object) adSession2, "AdSession is null");
        C3987e.m718g(aVar);
        C3987e.m709a(aVar);
        C3987e.m713b(aVar);
        C3987e.m716e(aVar);
        VideoEvents videoEvents = new VideoEvents(aVar);
        aVar.getAdSessionStatePublisher().mo55992a(videoEvents);
        return videoEvents;
    }

    public void adUserInteraction(InteractionType interactionType) {
        C3987e.m710a((Object) interactionType, "InteractionType is null");
        C3987e.m714c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        C3983b.m694a(jSONObject, "interactionType", interactionType);
        this.adSession.getAdSessionStatePublisher().mo55995a("adUserInteraction", jSONObject);
    }

    public void bufferFinish() {
        C3987e.m714c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo55993a("bufferFinish");
    }

    public void bufferStart() {
        C3987e.m714c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo55993a("bufferStart");
    }

    public void complete() {
        C3987e.m714c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo55993a("complete");
    }

    public void firstQuartile() {
        C3987e.m714c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo55993a("firstQuartile");
    }

    public void loaded(VastProperties vastProperties) {
        C3987e.m710a((Object) vastProperties, "VastProperties is null");
        C3987e.m713b(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo55995a("loaded", vastProperties.toJSON());
    }

    public void midpoint() {
        C3987e.m714c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo55993a("midpoint");
    }

    public void pause() {
        C3987e.m714c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo55993a("pause");
    }

    public void playerStateChange(PlayerState playerState) {
        C3987e.m710a((Object) playerState, "PlayerState is null");
        C3987e.m714c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        C3983b.m694a(jSONObject, "state", playerState);
        this.adSession.getAdSessionStatePublisher().mo55995a("playerStateChange", jSONObject);
    }

    public void resume() {
        C3987e.m714c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo55993a("resume");
    }

    public void skipped() {
        C3987e.m714c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo55993a("skipped");
    }

    public void start(float f, float f2) {
        confirmValidDuration(f);
        confirmValidVolume(f2);
        C3987e.m714c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        C3983b.m694a(jSONObject, "duration", Float.valueOf(f));
        C3983b.m694a(jSONObject, "videoPlayerVolume", Float.valueOf(f2));
        C3983b.m694a(jSONObject, "deviceVolume", Float.valueOf(C3976e.m666a().mo55979d()));
        this.adSession.getAdSessionStatePublisher().mo55995a(TtmlNode.START, jSONObject);
    }

    public void thirdQuartile() {
        C3987e.m714c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo55993a("thirdQuartile");
    }

    public void volumeChange(float f) {
        confirmValidVolume(f);
        C3987e.m714c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        C3983b.m694a(jSONObject, "videoPlayerVolume", Float.valueOf(f));
        C3983b.m694a(jSONObject, "deviceVolume", Float.valueOf(C3976e.m666a().mo55979d()));
        this.adSession.getAdSessionStatePublisher().mo55995a("volumeChange", jSONObject);
    }
}
