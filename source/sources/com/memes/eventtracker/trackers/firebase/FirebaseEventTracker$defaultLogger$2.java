package com.memes.eventtracker.trackers.firebase;

import android.app.Application;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: FirebaseEventTracker.kt */
final class FirebaseEventTracker$defaultLogger$2 extends Lambda implements Function0<FirebaseAnalytics> {
    final /* synthetic */ Application $application;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FirebaseEventTracker$defaultLogger$2(Application application) {
        super(0);
        this.$application = application;
    }

    public final FirebaseAnalytics invoke() {
        return FirebaseAnalytics.getInstance(this.$application);
    }
}
