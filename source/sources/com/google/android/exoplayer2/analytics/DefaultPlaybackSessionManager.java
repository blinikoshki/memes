package com.google.android.exoplayer2.analytics;

import android.util.Base64;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.PlaybackSessionManager;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Supplier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public final class DefaultPlaybackSessionManager implements PlaybackSessionManager {
    public static final Supplier<String> DEFAULT_SESSION_ID_GENERATOR = C1853xa5dbaaae.INSTANCE;
    private static final Random RANDOM = new Random();
    private static final int SESSION_ID_LENGTH = 12;
    private String currentSessionId;
    private Timeline currentTimeline;
    private PlaybackSessionManager.Listener listener;
    /* access modifiers changed from: private */
    public final Timeline.Period period;
    private final Supplier<String> sessionIdGenerator;
    private final HashMap<String, SessionDescriptor> sessions;
    /* access modifiers changed from: private */
    public final Timeline.Window window;

    public DefaultPlaybackSessionManager() {
        this(DEFAULT_SESSION_ID_GENERATOR);
    }

    public DefaultPlaybackSessionManager(Supplier<String> supplier) {
        this.sessionIdGenerator = supplier;
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        this.sessions = new HashMap<>();
        this.currentTimeline = Timeline.EMPTY;
    }

    public void setListener(PlaybackSessionManager.Listener listener2) {
        this.listener = listener2;
    }

    public synchronized String getSessionForMediaPeriodId(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        return getOrAddSession(timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, mediaPeriodId).sessionId;
    }

    public synchronized boolean belongsToSession(AnalyticsListener.EventTime eventTime, String str) {
        SessionDescriptor sessionDescriptor = this.sessions.get(str);
        if (sessionDescriptor == null) {
            return false;
        }
        sessionDescriptor.maybeSetWindowSequenceNumber(eventTime.windowIndex, eventTime.mediaPeriodId);
        return sessionDescriptor.belongsToSession(eventTime.windowIndex, eventTime.mediaPeriodId);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0113, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void updateSessions(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime r25) {
        /*
            r24 = this;
            r1 = r24
            r0 = r25
            monitor-enter(r24)
            com.google.android.exoplayer2.analytics.PlaybackSessionManager$Listener r2 = r1.listener     // Catch:{ all -> 0x0114 }
            com.google.android.exoplayer2.util.Assertions.checkNotNull(r2)     // Catch:{ all -> 0x0114 }
            java.util.HashMap<java.lang.String, com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager$SessionDescriptor> r2 = r1.sessions     // Catch:{ all -> 0x0114 }
            java.lang.String r3 = r1.currentSessionId     // Catch:{ all -> 0x0114 }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x0114 }
            com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager$SessionDescriptor r2 = (com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor) r2     // Catch:{ all -> 0x0114 }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r3 = r0.mediaPeriodId     // Catch:{ all -> 0x0114 }
            r4 = 1
            if (r3 == 0) goto L_0x0041
            if (r2 == 0) goto L_0x0041
            long r5 = r2.windowSequenceNumber     // Catch:{ all -> 0x0114 }
            r7 = -1
            r3 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x0030
            int r2 = r2.windowIndex     // Catch:{ all -> 0x0114 }
            int r5 = r0.windowIndex     // Catch:{ all -> 0x0114 }
            if (r2 == r5) goto L_0x003d
        L_0x002e:
            r3 = 1
            goto L_0x003d
        L_0x0030:
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r5 = r0.mediaPeriodId     // Catch:{ all -> 0x0114 }
            long r5 = r5.windowSequenceNumber     // Catch:{ all -> 0x0114 }
            long r7 = r2.windowSequenceNumber     // Catch:{ all -> 0x0114 }
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 >= 0) goto L_0x003d
            goto L_0x002e
        L_0x003d:
            if (r3 == 0) goto L_0x0041
            monitor-exit(r24)
            return
        L_0x0041:
            int r2 = r0.windowIndex     // Catch:{ all -> 0x0114 }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r3 = r0.mediaPeriodId     // Catch:{ all -> 0x0114 }
            com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager$SessionDescriptor r2 = r1.getOrAddSession(r2, r3)     // Catch:{ all -> 0x0114 }
            java.lang.String r3 = r1.currentSessionId     // Catch:{ all -> 0x0114 }
            if (r3 != 0) goto L_0x0053
            java.lang.String r3 = r2.sessionId     // Catch:{ all -> 0x0114 }
            r1.currentSessionId = r3     // Catch:{ all -> 0x0114 }
        L_0x0053:
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r3 = r0.mediaPeriodId     // Catch:{ all -> 0x0114 }
            if (r3 == 0) goto L_0x00d5
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r3 = r0.mediaPeriodId     // Catch:{ all -> 0x0114 }
            boolean r3 = r3.isAd()     // Catch:{ all -> 0x0114 }
            if (r3 == 0) goto L_0x00d5
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r10 = new com.google.android.exoplayer2.source.MediaSource$MediaPeriodId     // Catch:{ all -> 0x0114 }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r3 = r0.mediaPeriodId     // Catch:{ all -> 0x0114 }
            java.lang.Object r3 = r3.periodUid     // Catch:{ all -> 0x0114 }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r5 = r0.mediaPeriodId     // Catch:{ all -> 0x0114 }
            long r5 = r5.windowSequenceNumber     // Catch:{ all -> 0x0114 }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r7 = r0.mediaPeriodId     // Catch:{ all -> 0x0114 }
            int r7 = r7.adGroupIndex     // Catch:{ all -> 0x0114 }
            r10.<init>(r3, r5, r7)     // Catch:{ all -> 0x0114 }
            int r3 = r0.windowIndex     // Catch:{ all -> 0x0114 }
            com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager$SessionDescriptor r3 = r1.getOrAddSession(r3, r10)     // Catch:{ all -> 0x0114 }
            boolean r5 = r3.isCreated     // Catch:{ all -> 0x0114 }
            if (r5 != 0) goto L_0x00d5
            boolean unused = r3.isCreated = r4     // Catch:{ all -> 0x0114 }
            com.google.android.exoplayer2.Timeline r5 = r0.timeline     // Catch:{ all -> 0x0114 }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r6 = r0.mediaPeriodId     // Catch:{ all -> 0x0114 }
            java.lang.Object r6 = r6.periodUid     // Catch:{ all -> 0x0114 }
            com.google.android.exoplayer2.Timeline$Period r7 = r1.period     // Catch:{ all -> 0x0114 }
            r5.getPeriodByUid(r6, r7)     // Catch:{ all -> 0x0114 }
            com.google.android.exoplayer2.Timeline$Period r5 = r1.period     // Catch:{ all -> 0x0114 }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r6 = r0.mediaPeriodId     // Catch:{ all -> 0x0114 }
            int r6 = r6.adGroupIndex     // Catch:{ all -> 0x0114 }
            long r5 = r5.getAdGroupTimeUs(r6)     // Catch:{ all -> 0x0114 }
            long r5 = com.google.android.exoplayer2.C1844C.usToMs(r5)     // Catch:{ all -> 0x0114 }
            com.google.android.exoplayer2.Timeline$Period r7 = r1.period     // Catch:{ all -> 0x0114 }
            long r7 = r7.getPositionInWindowMs()     // Catch:{ all -> 0x0114 }
            long r5 = r5 + r7
            r7 = 0
            long r11 = java.lang.Math.max(r7, r5)     // Catch:{ all -> 0x0114 }
            com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime r15 = new com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime     // Catch:{ all -> 0x0114 }
            long r6 = r0.realtimeMs     // Catch:{ all -> 0x0114 }
            com.google.android.exoplayer2.Timeline r8 = r0.timeline     // Catch:{ all -> 0x0114 }
            int r9 = r0.windowIndex     // Catch:{ all -> 0x0114 }
            com.google.android.exoplayer2.Timeline r13 = r0.currentTimeline     // Catch:{ all -> 0x0114 }
            int r14 = r0.currentWindowIndex     // Catch:{ all -> 0x0114 }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r5 = r0.currentMediaPeriodId     // Catch:{ all -> 0x0114 }
            r16 = r5
            long r4 = r0.currentPlaybackPositionMs     // Catch:{ all -> 0x0114 }
            r20 = r2
            r21 = r3
            long r2 = r0.totalBufferedDurationMs     // Catch:{ all -> 0x0114 }
            r22 = r4
            r4 = r16
            r16 = r22
            r5 = r15
            r0 = r15
            r15 = r4
            r18 = r2
            r5.<init>(r6, r8, r9, r10, r11, r13, r14, r15, r16, r18)     // Catch:{ all -> 0x0114 }
            com.google.android.exoplayer2.analytics.PlaybackSessionManager$Listener r2 = r1.listener     // Catch:{ all -> 0x0114 }
            java.lang.String r3 = r21.sessionId     // Catch:{ all -> 0x0114 }
            r2.onSessionCreated(r0, r3)     // Catch:{ all -> 0x0114 }
            goto L_0x00d7
        L_0x00d5:
            r20 = r2
        L_0x00d7:
            boolean r0 = r20.isCreated     // Catch:{ all -> 0x0114 }
            if (r0 != 0) goto L_0x00ef
            r0 = r20
            r2 = 1
            boolean unused = r0.isCreated = r2     // Catch:{ all -> 0x0114 }
            com.google.android.exoplayer2.analytics.PlaybackSessionManager$Listener r2 = r1.listener     // Catch:{ all -> 0x0114 }
            java.lang.String r3 = r0.sessionId     // Catch:{ all -> 0x0114 }
            r4 = r25
            r2.onSessionCreated(r4, r3)     // Catch:{ all -> 0x0114 }
            goto L_0x00f3
        L_0x00ef:
            r4 = r25
            r0 = r20
        L_0x00f3:
            java.lang.String r2 = r0.sessionId     // Catch:{ all -> 0x0114 }
            java.lang.String r3 = r1.currentSessionId     // Catch:{ all -> 0x0114 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0114 }
            if (r2 == 0) goto L_0x0112
            boolean r2 = r0.isActive     // Catch:{ all -> 0x0114 }
            if (r2 != 0) goto L_0x0112
            r2 = 1
            boolean unused = r0.isActive = r2     // Catch:{ all -> 0x0114 }
            com.google.android.exoplayer2.analytics.PlaybackSessionManager$Listener r2 = r1.listener     // Catch:{ all -> 0x0114 }
            java.lang.String r0 = r0.sessionId     // Catch:{ all -> 0x0114 }
            r2.onSessionActive(r4, r0)     // Catch:{ all -> 0x0114 }
        L_0x0112:
            monitor-exit(r24)
            return
        L_0x0114:
            r0 = move-exception
            monitor-exit(r24)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.updateSessions(com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime):void");
    }

    public synchronized void updateSessionsWithTimelineChange(AnalyticsListener.EventTime eventTime) {
        Assertions.checkNotNull(this.listener);
        Timeline timeline = this.currentTimeline;
        this.currentTimeline = eventTime.timeline;
        Iterator<SessionDescriptor> it = this.sessions.values().iterator();
        while (it.hasNext()) {
            SessionDescriptor next = it.next();
            if (!next.tryResolvingToNewTimeline(timeline, this.currentTimeline)) {
                it.remove();
                if (next.isCreated) {
                    if (next.sessionId.equals(this.currentSessionId)) {
                        this.currentSessionId = null;
                    }
                    this.listener.onSessionFinished(eventTime, next.sessionId, false);
                }
            }
        }
        updateSessionsWithDiscontinuity(eventTime, 4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void updateSessionsWithDiscontinuity(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime r7, int r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            com.google.android.exoplayer2.analytics.PlaybackSessionManager$Listener r0 = r6.listener     // Catch:{ all -> 0x00d1 }
            com.google.android.exoplayer2.util.Assertions.checkNotNull(r0)     // Catch:{ all -> 0x00d1 }
            r0 = 0
            r1 = 1
            if (r8 == 0) goto L_0x0010
            r2 = 3
            if (r8 != r2) goto L_0x000e
            goto L_0x0010
        L_0x000e:
            r8 = 0
            goto L_0x0011
        L_0x0010:
            r8 = 1
        L_0x0011:
            java.util.HashMap<java.lang.String, com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager$SessionDescriptor> r2 = r6.sessions     // Catch:{ all -> 0x00d1 }
            java.util.Collection r2 = r2.values()     // Catch:{ all -> 0x00d1 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00d1 }
        L_0x001b:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x00d1 }
            if (r3 == 0) goto L_0x005c
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x00d1 }
            com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager$SessionDescriptor r3 = (com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor) r3     // Catch:{ all -> 0x00d1 }
            boolean r4 = r3.isFinishedAtEventTime(r7)     // Catch:{ all -> 0x00d1 }
            if (r4 == 0) goto L_0x001b
            r2.remove()     // Catch:{ all -> 0x00d1 }
            boolean r4 = r3.isCreated     // Catch:{ all -> 0x00d1 }
            if (r4 == 0) goto L_0x001b
            java.lang.String r4 = r3.sessionId     // Catch:{ all -> 0x00d1 }
            java.lang.String r5 = r6.currentSessionId     // Catch:{ all -> 0x00d1 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00d1 }
            if (r8 == 0) goto L_0x004c
            if (r4 == 0) goto L_0x004c
            boolean r5 = r3.isActive     // Catch:{ all -> 0x00d1 }
            if (r5 == 0) goto L_0x004c
            r5 = 1
            goto L_0x004d
        L_0x004c:
            r5 = 0
        L_0x004d:
            if (r4 == 0) goto L_0x0052
            r4 = 0
            r6.currentSessionId = r4     // Catch:{ all -> 0x00d1 }
        L_0x0052:
            com.google.android.exoplayer2.analytics.PlaybackSessionManager$Listener r4 = r6.listener     // Catch:{ all -> 0x00d1 }
            java.lang.String r3 = r3.sessionId     // Catch:{ all -> 0x00d1 }
            r4.onSessionFinished(r7, r3, r5)     // Catch:{ all -> 0x00d1 }
            goto L_0x001b
        L_0x005c:
            java.util.HashMap<java.lang.String, com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager$SessionDescriptor> r8 = r6.sessions     // Catch:{ all -> 0x00d1 }
            java.lang.String r0 = r6.currentSessionId     // Catch:{ all -> 0x00d1 }
            java.lang.Object r8 = r8.get(r0)     // Catch:{ all -> 0x00d1 }
            com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager$SessionDescriptor r8 = (com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.SessionDescriptor) r8     // Catch:{ all -> 0x00d1 }
            int r0 = r7.windowIndex     // Catch:{ all -> 0x00d1 }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r7.mediaPeriodId     // Catch:{ all -> 0x00d1 }
            com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager$SessionDescriptor r0 = r6.getOrAddSession(r0, r1)     // Catch:{ all -> 0x00d1 }
            java.lang.String r1 = r0.sessionId     // Catch:{ all -> 0x00d1 }
            r6.currentSessionId = r1     // Catch:{ all -> 0x00d1 }
            r6.updateSessions(r7)     // Catch:{ all -> 0x00d1 }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r7.mediaPeriodId     // Catch:{ all -> 0x00d1 }
            if (r1 == 0) goto L_0x00cf
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r7.mediaPeriodId     // Catch:{ all -> 0x00d1 }
            boolean r1 = r1.isAd()     // Catch:{ all -> 0x00d1 }
            if (r1 == 0) goto L_0x00cf
            if (r8 == 0) goto L_0x00af
            long r1 = r8.windowSequenceNumber     // Catch:{ all -> 0x00d1 }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r3 = r7.mediaPeriodId     // Catch:{ all -> 0x00d1 }
            long r3 = r3.windowSequenceNumber     // Catch:{ all -> 0x00d1 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x00af
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r8.adMediaPeriodId     // Catch:{ all -> 0x00d1 }
            if (r1 == 0) goto L_0x00af
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r8.adMediaPeriodId     // Catch:{ all -> 0x00d1 }
            int r1 = r1.adGroupIndex     // Catch:{ all -> 0x00d1 }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r2 = r7.mediaPeriodId     // Catch:{ all -> 0x00d1 }
            int r2 = r2.adGroupIndex     // Catch:{ all -> 0x00d1 }
            if (r1 != r2) goto L_0x00af
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r8 = r8.adMediaPeriodId     // Catch:{ all -> 0x00d1 }
            int r8 = r8.adIndexInAdGroup     // Catch:{ all -> 0x00d1 }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r7.mediaPeriodId     // Catch:{ all -> 0x00d1 }
            int r1 = r1.adIndexInAdGroup     // Catch:{ all -> 0x00d1 }
            if (r8 == r1) goto L_0x00cf
        L_0x00af:
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r8 = new com.google.android.exoplayer2.source.MediaSource$MediaPeriodId     // Catch:{ all -> 0x00d1 }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r7.mediaPeriodId     // Catch:{ all -> 0x00d1 }
            java.lang.Object r1 = r1.periodUid     // Catch:{ all -> 0x00d1 }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r2 = r7.mediaPeriodId     // Catch:{ all -> 0x00d1 }
            long r2 = r2.windowSequenceNumber     // Catch:{ all -> 0x00d1 }
            r8.<init>(r1, r2)     // Catch:{ all -> 0x00d1 }
            int r1 = r7.windowIndex     // Catch:{ all -> 0x00d1 }
            com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager$SessionDescriptor r8 = r6.getOrAddSession(r1, r8)     // Catch:{ all -> 0x00d1 }
            com.google.android.exoplayer2.analytics.PlaybackSessionManager$Listener r1 = r6.listener     // Catch:{ all -> 0x00d1 }
            java.lang.String r8 = r8.sessionId     // Catch:{ all -> 0x00d1 }
            java.lang.String r0 = r0.sessionId     // Catch:{ all -> 0x00d1 }
            r1.onAdPlaybackStarted(r7, r8, r0)     // Catch:{ all -> 0x00d1 }
        L_0x00cf:
            monitor-exit(r6)
            return
        L_0x00d1:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager.updateSessionsWithDiscontinuity(com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime, int):void");
    }

    public void finishAllSessions(AnalyticsListener.EventTime eventTime) {
        PlaybackSessionManager.Listener listener2;
        this.currentSessionId = null;
        Iterator<SessionDescriptor> it = this.sessions.values().iterator();
        while (it.hasNext()) {
            SessionDescriptor next = it.next();
            it.remove();
            if (next.isCreated && (listener2 = this.listener) != null) {
                listener2.onSessionFinished(eventTime, next.sessionId, false);
            }
        }
    }

    private SessionDescriptor getOrAddSession(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        int i2;
        SessionDescriptor sessionDescriptor = null;
        long j = Long.MAX_VALUE;
        for (SessionDescriptor next : this.sessions.values()) {
            next.maybeSetWindowSequenceNumber(i, mediaPeriodId);
            if (next.belongsToSession(i, mediaPeriodId)) {
                long access$100 = next.windowSequenceNumber;
                if (access$100 == -1 || access$100 < j) {
                    sessionDescriptor = next;
                    j = access$100;
                } else if (!(i2 != 0 || ((SessionDescriptor) Util.castNonNull(sessionDescriptor)).adMediaPeriodId == null || next.adMediaPeriodId == null)) {
                    sessionDescriptor = next;
                }
            }
        }
        if (sessionDescriptor != null) {
            return sessionDescriptor;
        }
        String str = this.sessionIdGenerator.get();
        SessionDescriptor sessionDescriptor2 = new SessionDescriptor(str, i, mediaPeriodId);
        this.sessions.put(str, sessionDescriptor2);
        return sessionDescriptor2;
    }

    /* access modifiers changed from: private */
    public static String generateDefaultSessionId() {
        byte[] bArr = new byte[12];
        RANDOM.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    private final class SessionDescriptor {
        /* access modifiers changed from: private */
        public MediaSource.MediaPeriodId adMediaPeriodId;
        /* access modifiers changed from: private */
        public boolean isActive;
        /* access modifiers changed from: private */
        public boolean isCreated;
        /* access modifiers changed from: private */
        public final String sessionId;
        /* access modifiers changed from: private */
        public int windowIndex;
        /* access modifiers changed from: private */
        public long windowSequenceNumber;

        public SessionDescriptor(String str, int i, MediaSource.MediaPeriodId mediaPeriodId) {
            long j;
            this.sessionId = str;
            this.windowIndex = i;
            if (mediaPeriodId == null) {
                j = -1;
            } else {
                j = mediaPeriodId.windowSequenceNumber;
            }
            this.windowSequenceNumber = j;
            if (mediaPeriodId != null && mediaPeriodId.isAd()) {
                this.adMediaPeriodId = mediaPeriodId;
            }
        }

        public boolean tryResolvingToNewTimeline(Timeline timeline, Timeline timeline2) {
            int resolveWindowIndexToNewTimeline = resolveWindowIndexToNewTimeline(timeline, timeline2, this.windowIndex);
            this.windowIndex = resolveWindowIndexToNewTimeline;
            if (resolveWindowIndexToNewTimeline == -1) {
                return false;
            }
            MediaSource.MediaPeriodId mediaPeriodId = this.adMediaPeriodId;
            if (mediaPeriodId != null && timeline2.getIndexOfPeriod(mediaPeriodId.periodUid) == -1) {
                return false;
            }
            return true;
        }

        public boolean belongsToSession(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            if (mediaPeriodId == null) {
                return i == this.windowIndex;
            }
            if (this.adMediaPeriodId == null) {
                if (mediaPeriodId.isAd() || mediaPeriodId.windowSequenceNumber != this.windowSequenceNumber) {
                    return false;
                }
                return true;
            } else if (mediaPeriodId.windowSequenceNumber == this.adMediaPeriodId.windowSequenceNumber && mediaPeriodId.adGroupIndex == this.adMediaPeriodId.adGroupIndex && mediaPeriodId.adIndexInAdGroup == this.adMediaPeriodId.adIndexInAdGroup) {
                return true;
            } else {
                return false;
            }
        }

        public void maybeSetWindowSequenceNumber(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            if (this.windowSequenceNumber == -1 && i == this.windowIndex && mediaPeriodId != null) {
                this.windowSequenceNumber = mediaPeriodId.windowSequenceNumber;
            }
        }

        public boolean isFinishedAtEventTime(AnalyticsListener.EventTime eventTime) {
            if (this.windowSequenceNumber == -1) {
                return false;
            }
            if (eventTime.mediaPeriodId == null) {
                if (this.windowIndex != eventTime.windowIndex) {
                    return true;
                }
                return false;
            } else if (eventTime.mediaPeriodId.windowSequenceNumber > this.windowSequenceNumber) {
                return true;
            } else {
                if (this.adMediaPeriodId == null) {
                    return false;
                }
                int indexOfPeriod = eventTime.timeline.getIndexOfPeriod(eventTime.mediaPeriodId.periodUid);
                int indexOfPeriod2 = eventTime.timeline.getIndexOfPeriod(this.adMediaPeriodId.periodUid);
                if (eventTime.mediaPeriodId.windowSequenceNumber < this.adMediaPeriodId.windowSequenceNumber || indexOfPeriod < indexOfPeriod2) {
                    return false;
                }
                if (indexOfPeriod > indexOfPeriod2) {
                    return true;
                }
                if (eventTime.mediaPeriodId.isAd()) {
                    int i = eventTime.mediaPeriodId.adGroupIndex;
                    int i2 = eventTime.mediaPeriodId.adIndexInAdGroup;
                    if (i > this.adMediaPeriodId.adGroupIndex || (i == this.adMediaPeriodId.adGroupIndex && i2 > this.adMediaPeriodId.adIndexInAdGroup)) {
                        return true;
                    }
                    return false;
                } else if (eventTime.mediaPeriodId.nextAdGroupIndex == -1 || eventTime.mediaPeriodId.nextAdGroupIndex > this.adMediaPeriodId.adGroupIndex) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        private int resolveWindowIndexToNewTimeline(Timeline timeline, Timeline timeline2, int i) {
            if (i < timeline.getWindowCount()) {
                timeline.getWindow(i, DefaultPlaybackSessionManager.this.window);
                for (int i2 = DefaultPlaybackSessionManager.this.window.firstPeriodIndex; i2 <= DefaultPlaybackSessionManager.this.window.lastPeriodIndex; i2++) {
                    int indexOfPeriod = timeline2.getIndexOfPeriod(timeline.getUidOfPeriod(i2));
                    if (indexOfPeriod != -1) {
                        return timeline2.getPeriod(indexOfPeriod, DefaultPlaybackSessionManager.this.period).windowIndex;
                    }
                }
                return -1;
            } else if (i < timeline2.getWindowCount()) {
                return i;
            } else {
                return -1;
            }
        }
    }
}
