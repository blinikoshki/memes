package com.memes.eventtracker.tracking;

import android.app.Application;
import com.google.android.exoplayer2.util.MimeTypes;
import com.memes.eventtracker.alias.EventAliasResolver;
import com.memes.eventtracker.trackers.EventTracker;
import com.memes.eventtracker.trackers.appsflyer.AppsFlyerEventTracker;
import com.memes.eventtracker.trackers.blank.BlankEventTracker;
import com.memes.eventtracker.trackers.facebook.FacebookEventTracker;
import com.memes.eventtracker.trackers.firebase.FirebaseEventTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/eventtracker/tracking/EventTracking;", "", "()V", "Builder", "Companion", "eventtracker_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EventTracking.kt */
public final class EventTracking {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static EventTrackingManager eventTrackingManager;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/eventtracker/tracking/EventTracking$Companion;", "", "()V", "eventTrackingManager", "Lcom/memes/eventtracker/tracking/EventTrackingManager;", "trackingManager", "eventtracker_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: EventTracking.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EventTrackingManager trackingManager() {
            if (EventTracking.eventTrackingManager == null) {
                EventTracking.eventTrackingManager = new Builder().build();
            }
            EventTrackingManager access$getEventTrackingManager$cp = EventTracking.eventTrackingManager;
            if (access$getEventTrackingManager$cp == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eventTrackingManager");
            }
            return access$getEventTrackingManager$cp;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0000J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo26107d2 = {"Lcom/memes/eventtracker/tracking/EventTracking$Builder;", "", "()V", "router", "Lcom/memes/eventtracker/tracking/EventRouter;", "addAppsFlyerEventTracker", "application", "Landroid/app/Application;", "addBlankEventTracker", "addFacebookEventTracker", "addFirebaseEventTracker", "build", "Lcom/memes/eventtracker/tracking/EventTrackingManager;", "enableAliasResolver", "eventtracker_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: EventTracking.kt */
    public static final class Builder {
        private final EventRouter router = new EventRouter();

        public final Builder addAppsFlyerEventTracker(Application application) {
            Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
            EventTracker instance = AppsFlyerEventTracker.Companion.getInstance(application);
            instance.init();
            instance.enable();
            this.router.add(instance);
            return this;
        }

        public final Builder addFacebookEventTracker(Application application) {
            Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
            EventTracker instance = FacebookEventTracker.Companion.getInstance(application);
            instance.init();
            instance.enable();
            this.router.add(instance);
            return this;
        }

        public final Builder addFirebaseEventTracker(Application application) {
            Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
            EventTracker instance = FirebaseEventTracker.Companion.getInstance(application);
            instance.init();
            instance.enable();
            this.router.add(instance);
            return this;
        }

        public final Builder addBlankEventTracker() {
            BlankEventTracker blankEventTracker = new BlankEventTracker();
            blankEventTracker.init();
            blankEventTracker.enable();
            this.router.add(blankEventTracker);
            return this;
        }

        public final Builder enableAliasResolver(Application application) {
            Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
            this.router.setAliasResolver$eventtracker_release(new EventAliasResolver(application));
            return this;
        }

        public final EventTrackingManager build() {
            EventTracking.eventTrackingManager = new EventTrackingManager(this.router);
            EventTrackingManager access$getEventTrackingManager$cp = EventTracking.eventTrackingManager;
            if (access$getEventTrackingManager$cp == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eventTrackingManager");
            }
            return access$getEventTrackingManager$cp;
        }
    }
}
