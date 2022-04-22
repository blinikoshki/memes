package com.giphy.sdk.analytics.batching;

import android.util.Log;
import com.giphy.sdk.analytics.models.Session;
import com.giphy.sdk.analytics.network.api.GPHPingbackApi;
import com.giphy.sdk.analytics.network.api.GPHPingbackClient;
import com.giphy.sdk.analytics.network.engine.DefaultNetworkSession;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015J\u0006\u0010\u001b\u001a\u00020\u0019J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002R\u0019\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006 "}, mo26107d2 = {"Lcom/giphy/sdk/analytics/batching/PingbackSubmissionQueue;", "", "pingbackClient", "Lcom/giphy/sdk/analytics/network/api/GPHPingbackApi;", "(Lcom/giphy/sdk/analytics/network/api/GPHPingbackApi;)V", "apiKey", "", "(Ljava/lang/String;)V", "executorService", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "getExecutorService", "()Ljava/util/concurrent/ScheduledExecutorService;", "retriesCount", "", "retryFlush", "Ljava/lang/Runnable;", "retryFuture", "Ljava/util/concurrent/ScheduledFuture;", "sessions", "Ljava/util/LinkedList;", "Lcom/giphy/sdk/analytics/models/Session;", "getSessions", "()Ljava/util/LinkedList;", "add", "", "session", "flush", "scheduleReattempt", "submitAllSessions", "trimQueueIfNecessary", "Companion", "giphy-android-sdk-analytics_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: PingbackSubmissionQueue.kt */
public final class PingbackSubmissionQueue {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static long delayAfterFailure = 5000;
    /* access modifiers changed from: private */
    public static int maximumQueuedSessions = 10;
    /* access modifiers changed from: private */
    public static long maximumRetriesCount = 3;
    private final ScheduledExecutorService executorService;
    private GPHPingbackApi pingbackClient;
    /* access modifiers changed from: private */
    public int retriesCount;
    private final Runnable retryFlush;
    private ScheduledFuture<?> retryFuture;
    private final LinkedList<Session> sessions;

    public final ScheduledExecutorService getExecutorService() {
        return this.executorService;
    }

    public final LinkedList<Session> getSessions() {
        return this.sessions;
    }

    public PingbackSubmissionQueue(GPHPingbackApi gPHPingbackApi) {
        Intrinsics.checkParameterIsNotNull(gPHPingbackApi, "pingbackClient");
        this.executorService = Executors.newSingleThreadScheduledExecutor();
        this.sessions = new LinkedList<>();
        this.retryFlush = new PingbackSubmissionQueue$retryFlush$1(this);
        this.pingbackClient = gPHPingbackApi;
    }

    public PingbackSubmissionQueue(String str) {
        Intrinsics.checkParameterIsNotNull(str, "apiKey");
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.executorService = newSingleThreadScheduledExecutor;
        this.sessions = new LinkedList<>();
        this.retryFlush = new PingbackSubmissionQueue$retryFlush$1(this);
        Intrinsics.checkExpressionValueIsNotNull(newSingleThreadScheduledExecutor, "executorService");
        Intrinsics.checkExpressionValueIsNotNull(newSingleThreadScheduledExecutor, "executorService");
        this.pingbackClient = new GPHPingbackClient(str, new DefaultNetworkSession(newSingleThreadScheduledExecutor, newSingleThreadScheduledExecutor));
    }

    public final void add(Session session) {
        Intrinsics.checkParameterIsNotNull(session, "session");
        this.executorService.execute(new PingbackSubmissionQueue$add$1(this, session));
    }

    public final void flush() {
        this.executorService.execute(new PingbackSubmissionQueue$flush$1(this));
    }

    /* access modifiers changed from: private */
    public final void submitAllSessions() {
        while (!this.sessions.isEmpty()) {
            Session pollFirst = this.sessions.pollFirst();
            GPHPingbackApi gPHPingbackApi = this.pingbackClient;
            Intrinsics.checkExpressionValueIsNotNull(pollFirst, "session");
            gPHPingbackApi.submitSession(pollFirst, new PingbackSubmissionQueue$submitAllSessions$1(this, pollFirst));
        }
    }

    /* access modifiers changed from: private */
    public final void trimQueueIfNecessary() {
        while (this.sessions.size() > maximumQueuedSessions) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("trimming queued session because count == %s", Arrays.copyOf(new Object[]{Integer.valueOf(this.sessions.size())}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
            Log.d("PINGBACK", format);
            this.sessions.removeLast();
        }
    }

    /* access modifiers changed from: private */
    public final void scheduleReattempt() {
        ScheduledFuture<?> scheduledFuture = this.retryFuture;
        if (scheduledFuture != null) {
            if (scheduledFuture == null) {
                Intrinsics.throwNpe();
            }
            if (!scheduledFuture.isCancelled()) {
                ScheduledFuture<?> scheduledFuture2 = this.retryFuture;
                if (scheduledFuture2 == null) {
                    Intrinsics.throwNpe();
                }
                scheduledFuture2.cancel(false);
            }
        }
        int i = this.retriesCount;
        if (((long) i) < maximumRetriesCount) {
            this.retryFuture = this.executorService.schedule(this.retryFlush, delayAfterFailure * ((long) Math.pow(3.0d, (double) i)), TimeUnit.MILLISECONDS);
        } else {
            this.retriesCount = i + 1;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, mo26107d2 = {"Lcom/giphy/sdk/analytics/batching/PingbackSubmissionQueue$Companion;", "", "()V", "delayAfterFailure", "", "getDelayAfterFailure", "()J", "setDelayAfterFailure", "(J)V", "maximumQueuedSessions", "", "getMaximumQueuedSessions", "()I", "setMaximumQueuedSessions", "(I)V", "maximumRetriesCount", "getMaximumRetriesCount", "setMaximumRetriesCount", "giphy-android-sdk-analytics_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* compiled from: PingbackSubmissionQueue.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getMaximumQueuedSessions() {
            return PingbackSubmissionQueue.maximumQueuedSessions;
        }

        public final void setMaximumQueuedSessions(int i) {
            PingbackSubmissionQueue.maximumQueuedSessions = i;
        }

        public final long getDelayAfterFailure() {
            return PingbackSubmissionQueue.delayAfterFailure;
        }

        public final void setDelayAfterFailure(long j) {
            PingbackSubmissionQueue.delayAfterFailure = j;
        }

        public final long getMaximumRetriesCount() {
            return PingbackSubmissionQueue.maximumRetriesCount;
        }

        public final void setMaximumRetriesCount(long j) {
            PingbackSubmissionQueue.maximumRetriesCount = j;
        }
    }
}
