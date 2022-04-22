package com.memes.plus;

import android.app.Application;
import android.content.Context;
import androidx.appcompat.app.AppCompatDelegate;
import com.giphy.sdk.p013ui.GiphyCoreUI;
import com.memes.chat.ChatManager;
import com.memes.commons.media.MediaContentDownloader;
import com.memes.crashreporter.CrashReporter;
import com.memes.crashreporter.CrashReporterProvider;
import com.memes.eventtracker.tracking.EventTracking;
import com.memes.eventtracker.tracking.EventTrackingManager;
import com.memes.plus.firebase.firebase_token.FirebaseTokenProvider;
import com.memes.plus.notifications.NotificationChannels;
import com.memes.plus.p040ui.subscription.eventreporter.source.BaseSubscriptionReporter;
import com.memes.plus.p040ui.subscription.eventreporter.source.FileBackedSubscriptionReporter;
import com.memes.plus.util.RepositoryInjection;
import editor.NEditor;
import editor.work.EditorCacheDeletionWorker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¨\u0006\u0015"}, mo26107d2 = {"Lcom/memes/plus/App;", "Landroid/app/Application;", "()V", "createFirebaseToken", "", "createNotificationChannels", "enqueueEditorCacheDeletionWorker", "initChat", "initCrashReporter", "initDownloader", "initEditor", "initEventTracking", "initGiphyCore", "initLeakCanary", "initStrictMode", "initTimber", "onCreate", "refreshSession", "context", "Landroid/content/Context;", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: App.kt */
public final class App extends Application {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PID_KEY = "MEMES_PROCESS_ID";

    private final void initLeakCanary() {
    }

    private final void initStrictMode() {
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Lcom/memes/plus/App$Companion;", "", "()V", "PID_KEY", "", "crashReporter", "Lcom/memes/crashreporter/CrashReporter;", "subscriptionReporter", "Lcom/memes/plus/ui/subscription/eventreporter/source/BaseSubscriptionReporter;", "context", "Landroid/content/Context;", "trackingManager", "Lcom/memes/eventtracker/tracking/EventTrackingManager;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: App.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CrashReporter crashReporter() {
            return CrashReporterProvider.INSTANCE.reporter();
        }

        public final EventTrackingManager trackingManager() {
            return EventTracking.Companion.trackingManager();
        }

        public final BaseSubscriptionReporter subscriptionReporter(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            return new FileBackedSubscriptionReporter(applicationContext);
        }
    }

    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setDefaultNightMode(2);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        Context context = this;
        AppVersion.INSTANCE.init(context);
        initCrashReporter();
        initTimber();
        initLeakCanary();
        initGiphyCore();
        initDownloader();
        initEventTracking();
        initStrictMode();
        createFirebaseToken();
        createNotificationChannels();
        refreshSession(context);
        initChat();
        initEditor();
        enqueueEditorCacheDeletionWorker();
    }

    private final void initTimber() {
        Timber.plant((Timber.Tree) new LogTree(Companion.crashReporter()));
    }

    private final void initGiphyCore() {
        GiphyCoreUI.INSTANCE.configure(this, ApiRouting.GIPHY_API_KEY);
    }

    private final void initDownloader() {
        MediaContentDownloader.Companion companion = MediaContentDownloader.Companion;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        companion.initialize(applicationContext);
    }

    private final void initCrashReporter() {
        Boolean bool = BuildConfig.DEVELOPER_MODE;
        Intrinsics.checkNotNullExpressionValue(bool, "BuildConfig.DEVELOPER_MODE");
        if (bool.booleanValue()) {
            CrashReporterProvider.INSTANCE.initBlankCrashReporter();
        } else {
            CrashReporterProvider.INSTANCE.initFirebaseCrashReporter();
        }
    }

    private final void initEventTracking() {
        Boolean bool = BuildConfig.DEVELOPER_MODE;
        Intrinsics.checkNotNullExpressionValue(bool, "BuildConfig.DEVELOPER_MODE");
        if (bool.booleanValue()) {
            new EventTracking.Builder().addBlankEventTracker().build();
            return;
        }
        Application application = this;
        new EventTracking.Builder().addAppsFlyerEventTracker(application).addFacebookEventTracker(application).addFirebaseEventTracker(application).enableAliasResolver(application).build();
    }

    private final void createFirebaseToken() {
        FirebaseTokenProvider.fetch$default(FirebaseTokenProvider.INSTANCE, RepositoryInjection.INSTANCE.storageRepository(this), false, (FirebaseTokenProvider.Callback) null, 4, (Object) null);
    }

    private final void createNotificationChannels() {
        NotificationChannels notificationChannels = NotificationChannels.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        notificationChannels.create(applicationContext);
    }

    private final void refreshSession(Context context) {
        RepositoryInjection repositoryInjection = RepositoryInjection.INSTANCE;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        repositoryInjection.storageRepository(applicationContext).refreshSession();
    }

    private final void initChat() {
        ChatManager.INSTANCE.init(this);
    }

    private final void initEditor() {
        NEditor.INSTANCE.initialize(this);
    }

    private final void enqueueEditorCacheDeletionWorker() {
        EditorCacheDeletionWorker.Companion.enqueue(this);
    }
}
