package com.memes.eventtracker.tracking;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo26107d2 = {"Lcom/memes/eventtracker/tracking/TrackingPageInfo;", "", "activity", "Landroid/app/Activity;", "title", "", "(Landroid/app/Activity;Ljava/lang/String;)V", "getActivity", "()Landroid/app/Activity;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "eventtracker_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TrackingPageInfo.kt */
public final class TrackingPageInfo {
    private final Activity activity;
    private final String title;

    public static /* synthetic */ TrackingPageInfo copy$default(TrackingPageInfo trackingPageInfo, Activity activity2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            activity2 = trackingPageInfo.activity;
        }
        if ((i & 2) != 0) {
            str = trackingPageInfo.title;
        }
        return trackingPageInfo.copy(activity2, str);
    }

    public final Activity component1() {
        return this.activity;
    }

    public final String component2() {
        return this.title;
    }

    public final TrackingPageInfo copy(Activity activity2, String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        return new TrackingPageInfo(activity2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrackingPageInfo)) {
            return false;
        }
        TrackingPageInfo trackingPageInfo = (TrackingPageInfo) obj;
        return Intrinsics.areEqual((Object) this.activity, (Object) trackingPageInfo.activity) && Intrinsics.areEqual((Object) this.title, (Object) trackingPageInfo.title);
    }

    public int hashCode() {
        Activity activity2 = this.activity;
        int i = 0;
        int hashCode = (activity2 != null ? activity2.hashCode() : 0) * 31;
        String str = this.title;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "TrackingPageInfo(activity=" + this.activity + ", title=" + this.title + ")";
    }

    public TrackingPageInfo(Activity activity2, String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.activity = activity2;
        this.title = str;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final String getTitle() {
        return this.title;
    }
}
