package com.memes.commons.util;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u000b\u001a\u00020\u00002\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0000J\u0006\u0010\r\u001a\u00020\u0000J\u0006\u0010\u000e\u001a\u00020\u0000J\u0006\u0010\u000f\u001a\u00020\u0000J\u0006\u0010\u0010\u001a\u00020\u0000J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016R\u0012\u0010\u0005\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo26107d2 = {"Lcom/memes/commons/util/ActivityStarter;", "", "startIntent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "enterAnimation", "", "exitAnimation", "shouldFinishAffinity", "", "shouldFinishCurrentActivity", "animate", "clearStack", "clearTask", "finishAffinity", "finishCurrentActivity", "newTask", "startFrom", "", "activity", "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "Companion", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ActivityStarter.kt */
public final class ActivityStarter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private int enterAnimation;
    private int exitAnimation;
    private boolean shouldFinishAffinity;
    private boolean shouldFinishCurrentActivity;
    private final Intent startIntent;

    private ActivityStarter(Intent intent) {
        this.startIntent = intent;
        this.enterAnimation = -1;
        this.exitAnimation = -1;
    }

    public /* synthetic */ ActivityStarter(Intent intent, DefaultConstructorMarker defaultConstructorMarker) {
        this(intent);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b¨\u0006\f"}, mo26107d2 = {"Lcom/memes/commons/util/ActivityStarter$Companion;", "", "()V", "finishWithRootCheck", "", "activity", "Landroid/app/Activity;", "lastRootIntent", "Landroid/content/Intent;", "of", "Lcom/memes/commons/util/ActivityStarter;", "startIntent", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ActivityStarter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: of */
        public final ActivityStarter mo57312of(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "startIntent");
            return new ActivityStarter(intent, (DefaultConstructorMarker) null);
        }

        public final void finishWithRootCheck(Activity activity, Intent intent) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(intent, "lastRootIntent");
            if (activity.isTaskRoot()) {
                mo57312of(intent).startFrom(activity);
            }
            activity.finish();
        }
    }

    public final ActivityStarter animate(int i, int i2) {
        this.enterAnimation = i;
        this.exitAnimation = i2;
        return this;
    }

    public final ActivityStarter newTask() {
        this.startIntent.addFlags(268435456);
        return this;
    }

    public final ActivityStarter clearTask() {
        this.startIntent.addFlags(32768);
        return this;
    }

    public final ActivityStarter clearStack() {
        return newTask().clearTask();
    }

    public final ActivityStarter finishCurrentActivity() {
        this.shouldFinishCurrentActivity = true;
        return this;
    }

    public final ActivityStarter finishAffinity() {
        this.shouldFinishAffinity = true;
        return this;
    }

    public final void startFrom(Activity activity) {
        int i;
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.startActivity(this.startIntent);
        int i2 = this.enterAnimation;
        if (!(i2 == -1 || (i = this.exitAnimation) == -1)) {
            activity.overridePendingTransition(i2, i);
        }
        if (this.shouldFinishCurrentActivity) {
            activity.finish();
        } else if (this.shouldFinishAffinity) {
            activity.setResult(0);
            activity.finishAffinity();
        }
    }

    public final void startFrom(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
        startFrom((Activity) requireActivity);
    }
}
