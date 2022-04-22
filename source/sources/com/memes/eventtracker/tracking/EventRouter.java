package com.memes.eventtracker.tracking;

import com.google.gson.Gson;
import com.memes.eventtracker.alias.EventAliasResolver;
import com.memes.eventtracker.specialevents.SpecialEvent;
import com.memes.eventtracker.trackers.EventTracker;
import com.memes.eventtracker.trackers.appsflyer.AppsFlyerEventTracker;
import com.memes.eventtracker.trackers.blank.BlankEventTracker;
import com.memes.eventtracker.trackers.facebook.FacebookEventTracker;
import com.memes.eventtracker.trackers.firebase.FirebaseEventTracker;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 )2\u00020\u0001:\u0001)B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015J\u0006\u0010\u0019\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u0018\u0010 \u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\u0015H\u0002J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020$J!\u0010 \u001a\u00020\u00172\u0006\u0010\"\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020(R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, mo26107d2 = {"Lcom/memes/eventtracker/tracking/EventRouter;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "aliasResolver", "Lcom/memes/eventtracker/alias/EventAliasResolver;", "getAliasResolver$eventtracker_release", "()Lcom/memes/eventtracker/alias/EventAliasResolver;", "setAliasResolver$eventtracker_release", "(Lcom/memes/eventtracker/alias/EventAliasResolver;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "routerExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getRouterExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "routerExceptionHandler$delegate", "Lkotlin/Lazy;", "trackers", "", "Lcom/memes/eventtracker/trackers/EventTracker;", "add", "", "tracker", "clear", "count", "", "createStackTrace", "", "throwable", "", "send", "Lkotlinx/coroutines/Job;", "event", "Lcom/memes/eventtracker/specialevents/SpecialEvent;", "Lcom/memes/eventtracker/tracking/TrackableEvent;", "(Lcom/memes/eventtracker/tracking/TrackableEvent;Lcom/memes/eventtracker/trackers/EventTracker;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPageInfo", "pageInfo", "Lcom/memes/eventtracker/tracking/TrackingPageInfo;", "Companion", "eventtracker_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EventRouter.kt */
public final class EventRouter implements CoroutineScope {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "EventRouter";
    private EventAliasResolver aliasResolver;
    private final Lazy routerExceptionHandler$delegate = LazyKt.lazy(new EventRouter$routerExceptionHandler$2(this));
    /* access modifiers changed from: private */
    public final List<EventTracker> trackers = new ArrayList();

    private final CoroutineExceptionHandler getRouterExceptionHandler() {
        return (CoroutineExceptionHandler) this.routerExceptionHandler$delegate.getValue();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/eventtracker/tracking/EventRouter$Companion;", "", "()V", "TAG", "", "eventtracker_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: EventRouter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CoroutineContext getCoroutineContext() {
        return Dispatchers.getIO().plus(getRouterExceptionHandler());
    }

    public final EventAliasResolver getAliasResolver$eventtracker_release() {
        return this.aliasResolver;
    }

    public final void setAliasResolver$eventtracker_release(EventAliasResolver eventAliasResolver) {
        this.aliasResolver = eventAliasResolver;
    }

    public final void add(EventTracker eventTracker) {
        Intrinsics.checkNotNullParameter(eventTracker, "tracker");
        this.trackers.add(eventTracker);
    }

    public final int count() {
        return this.trackers.size();
    }

    public final void clear() {
        this.trackers.clear();
    }

    public final void setPageInfo(TrackingPageInfo trackingPageInfo) {
        Intrinsics.checkNotNullParameter(trackingPageInfo, "pageInfo");
        for (EventTracker pageInfo : this.trackers) {
            pageInfo.setPageInfo(trackingPageInfo);
        }
    }

    public final Job send(TrackableEvent trackableEvent) {
        Intrinsics.checkNotNullParameter(trackableEvent, "event");
        return BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new EventRouter$send$1(this, trackableEvent, (Continuation) null), 3, (Object) null);
    }

    public final Job send(SpecialEvent specialEvent) {
        Intrinsics.checkNotNullParameter(specialEvent, "event");
        return BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new EventRouter$send$2(this, specialEvent, (Continuation) null), 3, (Object) null);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object send(com.memes.eventtracker.tracking.TrackableEvent r8, com.memes.eventtracker.trackers.EventTracker r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.memes.eventtracker.tracking.EventRouter$send$3
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.memes.eventtracker.tracking.EventRouter$send$3 r0 = (com.memes.eventtracker.tracking.EventRouter$send$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.memes.eventtracker.tracking.EventRouter$send$3 r0 = new com.memes.eventtracker.tracking.EventRouter$send$3
            r0.<init>(r7, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            java.lang.String r4 = "EventRouter"
            r5 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 != r5) goto L_0x0038
            java.lang.Object r8 = r0.L$1
            com.memes.eventtracker.trackers.EventTracker r8 = (com.memes.eventtracker.trackers.EventTracker) r8
            java.lang.Object r9 = r0.L$0
            com.memes.eventtracker.tracking.TrackableEvent r9 = (com.memes.eventtracker.tracking.TrackableEvent) r9
            kotlin.ResultKt.throwOnFailure(r10)
            r6 = r9
            r9 = r8
            r8 = r6
            goto L_0x006c
        L_0x0038:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r10)
            boolean r10 = r9 instanceof com.memes.eventtracker.trackers.blank.BlankEventTracker
            if (r10 == 0) goto L_0x004d
            r9.send(r8)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x004d:
            com.memes.eventtracker.alias.EventAliasResolver r10 = r7.aliasResolver
            if (r10 != 0) goto L_0x0059
            java.lang.String r8 = "Event Alias Resolver is not set."
            android.util.Log.e(r4, r8)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x0059:
            if (r10 == 0) goto L_0x006f
            java.lang.String r2 = r8.getEventId()
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r5
            java.lang.Object r10 = r10.resolve(r2, r0)
            if (r10 != r1) goto L_0x006c
            return r1
        L_0x006c:
            com.memes.eventtracker.alias.EventAlias r10 = (com.memes.eventtracker.alias.EventAlias) r10
            goto L_0x0070
        L_0x006f:
            r10 = r3
        L_0x0070:
            if (r10 != 0) goto L_0x0092
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Failed to resolve event("
            r9.append(r10)
            java.lang.String r8 = r8.getEventId()
            r9.append(r8)
            java.lang.String r8 = ") alias."
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            android.util.Log.e(r4, r8)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x0092:
            boolean r0 = r9 instanceof com.memes.eventtracker.trackers.facebook.FacebookEventTracker
            if (r0 == 0) goto L_0x009b
            java.lang.String r10 = r10.getFb()
            goto L_0x00ac
        L_0x009b:
            boolean r0 = r9 instanceof com.memes.eventtracker.trackers.firebase.FirebaseEventTracker
            if (r0 == 0) goto L_0x00a4
            java.lang.String r10 = r10.getFi()
            goto L_0x00ac
        L_0x00a4:
            boolean r0 = r9 instanceof com.memes.eventtracker.trackers.appsflyer.AppsFlyerEventTracker
            if (r0 == 0) goto L_0x00f6
            java.lang.String r10 = r10.getAf()
        L_0x00ac:
            r0 = r10
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x00b9
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L_0x00b8
            goto L_0x00b9
        L_0x00b8:
            r5 = 0
        L_0x00b9:
            if (r5 == 0) goto L_0x00eb
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "Event("
            r10.append(r0)
            java.lang.String r8 = r8.getEventId()
            r10.append(r8)
            java.lang.String r8 = ") is not resolvable for tracker("
            r10.append(r8)
            java.lang.Class r8 = r9.getClass()
            java.lang.String r8 = r8.getSimpleName()
            r10.append(r8)
            java.lang.String r8 = ")."
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            android.util.Log.w(r4, r8)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x00eb:
            r0 = 2
            com.memes.eventtracker.tracking.TrackableEvent r8 = com.memes.eventtracker.tracking.TrackableEvent.copy$default(r8, r10, r3, r0, r3)
            r9.send(r8)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x00f6:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "Resolved Alias("
            r9.append(r0)
            r9.append(r10)
            java.lang.String r10 = ") didn't match any trackers."
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.eventtracker.tracking.EventRouter.send(com.memes.eventtracker.tracking.TrackableEvent, com.memes.eventtracker.trackers.EventTracker, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void send(SpecialEvent specialEvent, EventTracker eventTracker) {
        TrackableEvent trackableEvent;
        if (eventTracker instanceof BlankEventTracker) {
            eventTracker.send(specialEvent.facebookEvent());
            return;
        }
        if (eventTracker instanceof FacebookEventTracker) {
            trackableEvent = specialEvent.facebookEvent();
        } else if (eventTracker instanceof FirebaseEventTracker) {
            trackableEvent = specialEvent.firebaseEvent();
        } else if (eventTracker instanceof AppsFlyerEventTracker) {
            trackableEvent = specialEvent.appsFlyerEvent();
        } else {
            throw new RuntimeException("Unable to use SpecialEvent: " + specialEvent + "; it didn't match any trackers.");
        }
        if (!Intrinsics.areEqual((Object) trackableEvent, (Object) TrackableEvent.Companion.getEMPTY())) {
            System.out.println("-! -> " + new Gson().toJson((Object) trackableEvent));
            eventTracker.send(trackableEvent);
        }
    }

    /* access modifiers changed from: private */
    public final String createStackTrace(Throwable th) {
        String str;
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            th.printStackTrace(printWriter);
            str = stringWriter.toString();
        } catch (Exception unused) {
            str = null;
        } catch (Throwable th2) {
            printWriter.close();
            stringWriter.close();
            throw th2;
        }
        printWriter.close();
        stringWriter.close();
        return str;
    }
}
