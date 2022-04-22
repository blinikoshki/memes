package com.giphy.sdk.analytics.batching;

import android.util.Log;
import androidx.work.WorkRequest;
import com.giphy.sdk.analytics.batching.PingbackWrapperRecycler;
import com.giphy.sdk.analytics.models.Action;
import com.giphy.sdk.analytics.models.Attribute;
import com.giphy.sdk.analytics.models.Session;
import com.giphy.sdk.analytics.models.User;
import com.giphy.sdk.analytics.models.enums.ActionType;
import com.giphy.sdk.analytics.models.enums.AttributeKey;
import com.giphy.sdk.analytics.models.enums.EventType;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\u0018\u0000 52\u00020\u0001:\u00015B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007Jp\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u00032\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u00032\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u00032\b\u0010'\u001a\u0004\u0018\u00010\u00032\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020\u001aJ\u0010\u0010+\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120-J,\u0010.\u001a\u00020\u00152\b\u0010&\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010/\u001a\u00020\u001aH\u0002J\b\u00100\u001a\u00020\u001aH\u0002J\b\u00101\u001a\u00020\u001aH\u0002J\u0010\u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u0015H\u0002J\u001a\u00104\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001b\u001a\u00020\u0003H\u0002R\u0014\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0002\b\u0003\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u00066"}, mo26107d2 = {"Lcom/giphy/sdk/analytics/batching/PingbackCollector;", "", "apiKey", "", "(Ljava/lang/String;)V", "submissionQueue", "Lcom/giphy/sdk/analytics/batching/PingbackSubmissionQueue;", "(Lcom/giphy/sdk/analytics/batching/PingbackSubmissionQueue;)V", "addPingbackFuture", "Ljava/util/concurrent/ScheduledFuture;", "addPingbackRunnable", "Ljava/lang/Runnable;", "eventWrapperRecycler", "Lcom/giphy/sdk/analytics/batching/PingbackWrapperRecycler;", "executorService", "Ljava/util/concurrent/ScheduledExecutorService;", "pingbacksBatch", "", "Lcom/giphy/sdk/analytics/batching/PingbackWrapperRecycler$PingbackWrapper;", "sessions", "Ljava/util/HashMap;", "Lcom/giphy/sdk/analytics/models/Session;", "getSessions", "()Ljava/util/HashMap;", "submitReadySessionsFuture", "addPingback", "", "userId", "loggedInUserId", "randomId", "responseId", "referrer", "eventType", "Lcom/giphy/sdk/analytics/models/enums/EventType;", "mediaId", "tid", "actionType", "Lcom/giphy/sdk/analytics/models/enums/ActionType;", "sessionId", "layoutType", "position", "", "flush", "generalSessionKeyForUser", "getPingbacksBatch", "", "getSession", "processPingbacksBatch", "scheduleSubmitAllSessions", "submitAllSessions", "submitReadySession", "session", "uniqueSessionKey", "Companion", "giphy-android-sdk-analytics_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: PingbackCollector.kt */
public final class PingbackCollector {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static long addPingbackDelay = 3000;
    /* access modifiers changed from: private */
    public static long maximumIdleTimeBeforeSubmitting = WorkRequest.MIN_BACKOFF_MILLIS;
    /* access modifiers changed from: private */
    public static int maximumPingbacksBeforeSubmitting = 100;
    private ScheduledFuture<?> addPingbackFuture;
    private final Runnable addPingbackRunnable;
    private final PingbackWrapperRecycler eventWrapperRecycler;
    private final ScheduledExecutorService executorService;
    private final List<PingbackWrapperRecycler.PingbackWrapper> pingbacksBatch;
    private final HashMap<String, Session> sessions;
    /* access modifiers changed from: private */
    public final PingbackSubmissionQueue submissionQueue;
    private ScheduledFuture<?> submitReadySessionsFuture;

    public PingbackCollector(PingbackSubmissionQueue pingbackSubmissionQueue) {
        Intrinsics.checkParameterIsNotNull(pingbackSubmissionQueue, "submissionQueue");
        this.submissionQueue = pingbackSubmissionQueue;
        this.addPingbackRunnable = new PingbackCollector$addPingbackRunnable$1(this);
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        Intrinsics.checkExpressionValueIsNotNull(newSingleThreadScheduledExecutor, "Executors.newSingleThreadScheduledExecutor()");
        this.executorService = newSingleThreadScheduledExecutor;
        this.sessions = new HashMap<>();
        this.pingbacksBatch = new ArrayList();
        this.eventWrapperRecycler = new PingbackWrapperRecycler();
    }

    public final HashMap<String, Session> getSessions() {
        return this.sessions;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PingbackCollector(String str) {
        this(new PingbackSubmissionQueue(str));
        Intrinsics.checkParameterIsNotNull(str, "apiKey");
    }

    public final void addPingback(String str, String str2, String str3, String str4, String str5, EventType eventType, String str6, String str7, ActionType actionType, String str8, String str9, int i) {
        PingbackWrapperRecycler.PingbackWrapper item;
        int size;
        Intrinsics.checkParameterIsNotNull(str, TagPeopleActivity.USER_ID);
        Intrinsics.checkParameterIsNotNull(str2, "loggedInUserId");
        Intrinsics.checkParameterIsNotNull(str4, "responseId");
        Intrinsics.checkParameterIsNotNull(eventType, "eventType");
        Intrinsics.checkParameterIsNotNull(str6, "mediaId");
        Intrinsics.checkParameterIsNotNull(actionType, "actionType");
        synchronized (this.eventWrapperRecycler) {
            item = this.eventWrapperRecycler.getItem(str, str2, str3, str4, str5, eventType, str6, str7, actionType, str8, str9, i);
            Unit unit = Unit.INSTANCE;
        }
        synchronized (this.pingbacksBatch) {
            List<PingbackWrapperRecycler.PingbackWrapper> list = this.pingbacksBatch;
            if (item == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pingbackWrapper");
            }
            list.add(item);
            size = this.pingbacksBatch.size();
            Unit unit2 = Unit.INSTANCE;
        }
        ScheduledFuture<?> scheduledFuture = this.addPingbackFuture;
        if (scheduledFuture != null) {
            if (scheduledFuture == null) {
                Intrinsics.throwNpe();
            }
            if (!scheduledFuture.isCancelled()) {
                ScheduledFuture<?> scheduledFuture2 = this.addPingbackFuture;
                if (scheduledFuture2 == null) {
                    Intrinsics.throwNpe();
                }
                scheduledFuture2.cancel(false);
            }
        }
        if (str7 != null) {
            flush();
        } else if (size < maximumPingbacksBeforeSubmitting) {
            this.addPingbackFuture = this.executorService.schedule(this.addPingbackRunnable, addPingbackDelay, TimeUnit.MILLISECONDS);
        } else {
            this.executorService.execute(this.addPingbackRunnable);
        }
    }

    public final void flush() {
        this.executorService.execute(new PingbackCollector$flush$1(this));
    }

    public final List<PingbackWrapperRecycler.PingbackWrapper> getPingbacksBatch() {
        return this.pingbacksBatch;
    }

    /* access modifiers changed from: private */
    public final void submitAllSessions() {
        Iterator<Map.Entry<String, Session>> it = this.sessions.entrySet().iterator();
        while (it.hasNext()) {
            Object value = it.next().getValue();
            Intrinsics.checkExpressionValueIsNotNull(value, "it.next().value");
            Session session = (Session) value;
            if (session.getActionCount() >= 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("Enqueueing session %s %s", Arrays.copyOf(new Object[]{session.getSessionId(), Integer.valueOf(session.getActionCount())}, 2));
                Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
                Log.d("PINGBACK", format);
                this.submissionQueue.add(session);
            }
            it.remove();
        }
    }

    private final void submitReadySession(Session session) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("Enqueueing ready session %s %s", Arrays.copyOf(new Object[]{session.getSessionId(), Integer.valueOf(session.getActionCount())}, 2));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        Log.d("PINGBACK", format);
        this.submissionQueue.add(session);
        this.sessions.remove(uniqueSessionKey(session.getSessionId(), session.getUser().getUserId()));
    }

    /* access modifiers changed from: private */
    public final void scheduleSubmitAllSessions() {
        ScheduledFuture<?> scheduledFuture = this.submitReadySessionsFuture;
        if (scheduledFuture != null) {
            if (scheduledFuture == null) {
                Intrinsics.throwNpe();
            }
            if (!scheduledFuture.isCancelled()) {
                ScheduledFuture<?> scheduledFuture2 = this.submitReadySessionsFuture;
                if (scheduledFuture2 == null) {
                    Intrinsics.throwNpe();
                }
                scheduledFuture2.cancel(false);
            }
        }
        this.submitReadySessionsFuture = this.executorService.schedule(new PingbackCollector$scheduleSubmitAllSessions$1(this), maximumIdleTimeBeforeSubmitting, TimeUnit.MILLISECONDS);
    }

    private final Session getSession(String str, String str2, String str3, String str4) {
        String uniqueSessionKey = uniqueSessionKey(str, str2);
        Session session = this.sessions.get(uniqueSessionKey);
        if (session != null) {
            return session;
        }
        Session session2 = new Session(new User(str2, str3, str4), str, (List) null, 4, (DefaultConstructorMarker) null);
        this.sessions.put(uniqueSessionKey, session2);
        return session2;
    }

    private final String uniqueSessionKey(String str, String str2) {
        if (str != null) {
            if (!(str.length() == 0)) {
                return str;
            }
        }
        return generalSessionKeyForUser(str2);
    }

    private final String generalSessionKeyForUser(String str) {
        return "user:" + str;
    }

    /* access modifiers changed from: private */
    public final void processPingbacksBatch() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.pingbacksBatch) {
            arrayList.addAll(this.pingbacksBatch);
            this.pingbacksBatch.clear();
            Unit unit = Unit.INSTANCE;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            PingbackWrapperRecycler.PingbackWrapper pingbackWrapper = (PingbackWrapperRecycler.PingbackWrapper) it.next();
            Session session = getSession(pingbackWrapper.getSessionId(), pingbackWrapper.getUserId(), pingbackWrapper.getLoggedInUserId(), pingbackWrapper.getRandomId());
            Action action = new Action(pingbackWrapper.getActionType(), pingbackWrapper.getMediaId(), pingbackWrapper.getTid(), pingbackWrapper.getTs(), (List) null, 16, (DefaultConstructorMarker) null);
            if (pingbackWrapper.getLayoutType() != null) {
                action.addAttribute(new Attribute(AttributeKey.LAYOUT_TYPE, pingbackWrapper.getLayoutType()));
            }
            if (pingbackWrapper.getPosition() >= 0) {
                action.addAttribute(new Attribute(AttributeKey.POSITION, Integer.toString(pingbackWrapper.getPosition())));
            }
            session.addAction(pingbackWrapper.getResponseId(), pingbackWrapper.getReferrer(), pingbackWrapper.getEventType(), action);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("Action added %s %s %s | %s %s %s %s | %s | %s %s", Arrays.copyOf(new Object[]{action.getActionType(), action.getGifId(), Long.valueOf(action.getTs()), pingbackWrapper.getResponseId(), pingbackWrapper.getRandomId(), pingbackWrapper.getReferrer(), pingbackWrapper.getEventType(), pingbackWrapper.getSessionId(), pingbackWrapper.getLayoutType(), Integer.valueOf(pingbackWrapper.getPosition())}, 10));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
            Log.d("PINGBACK", format);
            if (session.getActionCount() >= maximumPingbacksBeforeSubmitting) {
                submitReadySession(session);
            }
        }
        synchronized (this.eventWrapperRecycler) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                PingbackWrapperRecycler.PingbackWrapper pingbackWrapper2 = (PingbackWrapperRecycler.PingbackWrapper) it2.next();
                PingbackWrapperRecycler pingbackWrapperRecycler = this.eventWrapperRecycler;
                Intrinsics.checkExpressionValueIsNotNull(pingbackWrapper2, "eventWrapper");
                pingbackWrapperRecycler.recycleItem(pingbackWrapper2);
            }
            Unit unit2 = Unit.INSTANCE;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, mo26107d2 = {"Lcom/giphy/sdk/analytics/batching/PingbackCollector$Companion;", "", "()V", "addPingbackDelay", "", "getAddPingbackDelay", "()J", "setAddPingbackDelay", "(J)V", "maximumIdleTimeBeforeSubmitting", "getMaximumIdleTimeBeforeSubmitting", "setMaximumIdleTimeBeforeSubmitting", "maximumPingbacksBeforeSubmitting", "", "getMaximumPingbacksBeforeSubmitting", "()I", "setMaximumPingbacksBeforeSubmitting", "(I)V", "giphy-android-sdk-analytics_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* compiled from: PingbackCollector.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long getAddPingbackDelay() {
            return PingbackCollector.addPingbackDelay;
        }

        public final void setAddPingbackDelay(long j) {
            PingbackCollector.addPingbackDelay = j;
        }

        public final long getMaximumIdleTimeBeforeSubmitting() {
            return PingbackCollector.maximumIdleTimeBeforeSubmitting;
        }

        public final void setMaximumIdleTimeBeforeSubmitting(long j) {
            PingbackCollector.maximumIdleTimeBeforeSubmitting = j;
        }

        public final int getMaximumPingbacksBeforeSubmitting() {
            return PingbackCollector.maximumPingbacksBeforeSubmitting;
        }

        public final void setMaximumPingbacksBeforeSubmitting(int i) {
            PingbackCollector.maximumPingbacksBeforeSubmitting = i;
        }
    }
}
