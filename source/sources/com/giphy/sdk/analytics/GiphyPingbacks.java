package com.giphy.sdk.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.giphy.sdk.analytics.batching.PingbackCollector;
import com.giphy.sdk.analytics.models.enums.ActionType;
import com.giphy.sdk.analytics.models.enums.EventType;
import com.giphy.sdk.analytics.network.api.CompletionHandler;
import com.giphy.sdk.analytics.threading.ApiTask;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010*\u001a\u00020+2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0004J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0004H\u0002J\b\u0010-\u001a\u00020+H\u0002J\u000e\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040/J\u0006\u00100\u001a\u00020+J\b\u00101\u001a\u00020+H\u0002J\b\u00102\u001a\u00020+H\u0002Jf\u00103\u001a\u00020+2\u0006\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u00042\b\u00107\u001a\u0004\u0018\u00010\u00042\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00042\b\u0010;\u001a\u0004\u0018\u00010\u00042\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u00042\b\u0010?\u001a\u0004\u0018\u00010\u00042\u0006\u0010@\u001a\u00020AJ\u0012\u0010B\u001a\u00020+2\b\u0010C\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010D\u001a\u00020+2\b\u0010C\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010E\u001a\u00020+H\u0002J\u0010\u0010F\u001a\u00020+2\u0006\u0010G\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR6\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R(\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\rR(\u0010!\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u001cR\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X.¢\u0006\u0002\n\u0000R\u001e\u0010(\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\r¨\u0006H"}, mo26107d2 = {"Lcom/giphy/sdk/analytics/GiphyPingbacks;", "", "()V", "KEY_AD_ID", "", "KEY_ENCRYPTED_RANDOM_ID", "KEY_PINGBACK_ID", "KEY_RANDOM_ID", "KEY_UU_ID", "PREFERENCES_FILE_NAME", "<set-?>", "adId", "getAdId", "()Ljava/lang/String;", "additionalHeaders", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getAdditionalHeaders", "()Ljava/util/HashMap;", "setAdditionalHeaders", "(Ljava/util/HashMap;)V", "apiKey", "context", "Landroid/content/Context;", "value", "encryptedRandomId", "getEncryptedRandomId", "setEncryptedRandomId", "(Ljava/lang/String;)V", "pingbackCollector", "Lcom/giphy/sdk/analytics/batching/PingbackCollector;", "pingbackId", "getPingbackId", "randomId", "getRandomId", "setRandomId", "randomIdLock", "Ljava/util/concurrent/locks/ReentrantLock;", "sharedPref", "Landroid/content/SharedPreferences;", "uuid", "getUuid", "configure", "", "encryptRandomId", "fetchAdId", "fetchAndStoreRandomIdTask", "Lcom/giphy/sdk/analytics/threading/ApiTask;", "flush", "initAdId", "initRandomId", "log", "userId", "loggedInUserId", "responseId", "referrer", "eventType", "Lcom/giphy/sdk/analytics/models/enums/EventType;", "mediaId", "tid", "actionType", "Lcom/giphy/sdk/analytics/models/enums/ActionType;", "sessionId", "layoutType", "position", "", "saveAdId", "advertId", "savePingbackId", "saveUUID", "storeRandomId", "networkRandomId", "giphy-android-sdk-analytics_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: GiphyPingbacks.kt */
public final class GiphyPingbacks {
    public static final GiphyPingbacks INSTANCE = new GiphyPingbacks();
    private static final String KEY_AD_ID = "AD_ID";
    private static final String KEY_ENCRYPTED_RANDOM_ID = "ENCRYPTED_RANDOM_ID";
    private static final String KEY_PINGBACK_ID = "PINGBACK_ID";
    private static final String KEY_RANDOM_ID = "RANDOM_ID";
    private static final String KEY_UU_ID = "UU_ID";
    private static final String PREFERENCES_FILE_NAME = "ACCOUNT_PREFS";
    private static String adId = "";
    private static HashMap<String, String> additionalHeaders = new HashMap<>();
    /* access modifiers changed from: private */
    public static String apiKey;
    /* access modifiers changed from: private */
    public static Context context;
    private static String encryptedRandomId;
    private static PingbackCollector pingbackCollector;
    private static String pingbackId = "";
    private static String randomId;
    private static final ReentrantLock randomIdLock = new ReentrantLock();
    private static SharedPreferences sharedPref;
    private static String uuid = "";

    private GiphyPingbacks() {
    }

    public static final /* synthetic */ String access$getApiKey$p(GiphyPingbacks giphyPingbacks) {
        String str = apiKey;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apiKey");
        }
        return str;
    }

    public static final /* synthetic */ Context access$getContext$p(GiphyPingbacks giphyPingbacks) {
        Context context2 = context;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        }
        return context2;
    }

    public final String getAdId() {
        return adId;
    }

    public final String getUuid() {
        return uuid;
    }

    public final String getPingbackId() {
        return pingbackId;
    }

    public final HashMap<String, String> getAdditionalHeaders() {
        return additionalHeaders;
    }

    public final void setAdditionalHeaders(HashMap<String, String> hashMap) {
        Intrinsics.checkParameterIsNotNull(hashMap, "<set-?>");
        additionalHeaders = hashMap;
    }

    public final String getRandomId() {
        return randomId;
    }

    public final void setRandomId(String str) {
        randomId = str;
        SharedPreferences sharedPreferences = sharedPref;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPref");
        }
        sharedPreferences.edit().putString(KEY_RANDOM_ID, str).apply();
    }

    public final String getEncryptedRandomId() {
        return encryptedRandomId;
    }

    private final void setEncryptedRandomId(String str) {
        encryptedRandomId = str;
        SharedPreferences sharedPreferences = sharedPref;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPref");
        }
        sharedPreferences.edit().putString(KEY_ENCRYPTED_RANDOM_ID, str).apply();
    }

    public final void configure(Context context2, String str) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(str, "apiKey");
        apiKey = str;
        pingbackCollector = new PingbackCollector(str);
        context = context2;
        SharedPreferences sharedPreferences = context2.getSharedPreferences(PREFERENCES_FILE_NAME, 0);
        Intrinsics.checkExpressionValueIsNotNull(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        sharedPref = sharedPreferences;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPref");
        }
        setRandomId(sharedPreferences.getString(KEY_RANDOM_ID, (String) null));
        SharedPreferences sharedPreferences2 = sharedPref;
        if (sharedPreferences2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPref");
        }
        setEncryptedRandomId(sharedPreferences2.getString(KEY_ENCRYPTED_RANDOM_ID, (String) null));
        initAdId();
        initRandomId();
    }

    public final void flush() {
        PingbackCollector pingbackCollector2 = pingbackCollector;
        if (pingbackCollector2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pingbackCollector");
        }
        pingbackCollector2.flush();
    }

    public final void log(String str, String str2, String str3, String str4, EventType eventType, String str5, String str6, ActionType actionType, String str7, String str8, int i) {
        String str9 = str;
        Intrinsics.checkParameterIsNotNull(str, TagPeopleActivity.USER_ID);
        Intrinsics.checkParameterIsNotNull(str2, "loggedInUserId");
        Intrinsics.checkParameterIsNotNull(str3, "responseId");
        Intrinsics.checkParameterIsNotNull(eventType, "eventType");
        Intrinsics.checkParameterIsNotNull(str5, "mediaId");
        Intrinsics.checkParameterIsNotNull(actionType, "actionType");
        PingbackCollector pingbackCollector2 = pingbackCollector;
        if (pingbackCollector2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pingbackCollector");
        }
        pingbackCollector2.addPingback(str, str2, randomId, str3, str4, eventType, str5, str6, actionType, str7, str8, i);
    }

    private final void initAdId() {
        SharedPreferences.Editor putString;
        SharedPreferences sharedPreferences = sharedPref;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPref");
        }
        String string = sharedPreferences.getString(KEY_AD_ID, "");
        Intrinsics.checkExpressionValueIsNotNull(string, "sharedPref.getString(KEY_AD_ID, \"\")");
        adId = string;
        SharedPreferences sharedPreferences2 = sharedPref;
        if (sharedPreferences2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPref");
        }
        String string2 = sharedPreferences2.getString(KEY_UU_ID, "");
        Intrinsics.checkExpressionValueIsNotNull(string2, "sharedPref.getString(KEY_UU_ID, \"\")");
        uuid = string2;
        SharedPreferences sharedPreferences3 = sharedPref;
        if (sharedPreferences3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPref");
        }
        String string3 = sharedPreferences3.getString(KEY_PINGBACK_ID, "");
        Intrinsics.checkExpressionValueIsNotNull(string3, "sharedPref.getString(KEY_PINGBACK_ID, \"\")");
        pingbackId = string3;
        CharSequence charSequence = uuid;
        if (charSequence == null || charSequence.length() == 0) {
            uuid = pingbackId;
            SharedPreferences sharedPreferences4 = sharedPref;
            if (sharedPreferences4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPref");
            }
            SharedPreferences.Editor edit = sharedPreferences4.edit();
            if (!(edit == null || (putString = edit.putString(KEY_UU_ID, uuid)) == null)) {
                putString.apply();
            }
        }
        fetchAdId();
    }

    private final void fetchAdId() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new GiphyPingbacks$fetchAdId$1((Continuation) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void saveAdId(String str) {
        SharedPreferences.Editor putString;
        if (str == null) {
            str = "";
        }
        adId = str;
        SharedPreferences sharedPreferences = sharedPref;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPref");
        }
        if (!Intrinsics.areEqual((Object) adId, (Object) sharedPreferences.getString(KEY_AD_ID, ""))) {
            SharedPreferences sharedPreferences2 = sharedPref;
            if (sharedPreferences2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPref");
            }
            SharedPreferences.Editor edit = sharedPreferences2.edit();
            if (edit != null && (putString = edit.putString(KEY_AD_ID, adId)) != null) {
                putString.apply();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void saveUUID() {
        SharedPreferences.Editor putString;
        SharedPreferences sharedPreferences = sharedPref;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPref");
        }
        String string = sharedPreferences.getString(KEY_UU_ID, "");
        Intrinsics.checkExpressionValueIsNotNull(string, "sharedPref.getString(KEY_UU_ID, \"\")");
        uuid = string;
        CharSequence charSequence = string;
        if (charSequence == null || charSequence.length() == 0) {
            String uuid2 = UUID.randomUUID().toString();
            Intrinsics.checkExpressionValueIsNotNull(uuid2, "UUID.randomUUID().toString()");
            uuid = uuid2;
            SharedPreferences sharedPreferences2 = sharedPref;
            if (sharedPreferences2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPref");
            }
            SharedPreferences.Editor edit = sharedPreferences2.edit();
            if (edit != null && (putString = edit.putString(KEY_UU_ID, uuid)) != null) {
                putString.apply();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void savePingbackId(String str) {
        SharedPreferences.Editor putString;
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            pingbackId = uuid;
        } else {
            pingbackId = str;
        }
        SharedPreferences sharedPreferences = sharedPref;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPref");
        }
        if (!Intrinsics.areEqual((Object) pingbackId, (Object) sharedPreferences.getString(KEY_PINGBACK_ID, ""))) {
            SharedPreferences sharedPreferences2 = sharedPref;
            if (sharedPreferences2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPref");
            }
            SharedPreferences.Editor edit = sharedPreferences2.edit();
            if (edit != null && (putString = edit.putString(KEY_PINGBACK_ID, pingbackId)) != null) {
                putString.apply();
            }
        }
    }

    private final String encryptRandomId(String str) {
        Charset charset = Charsets.UTF_8;
        if (str != null) {
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            String encodeToString = Base64.encodeToString(new SecretKeySpec(bytes, "AES").getEncoded(), 0);
            Intrinsics.checkExpressionValueIsNotNull(encodeToString, "encrypted");
            return encodeToString;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    private final void initRandomId() {
        CharSequence charSequence = randomId;
        if (charSequence == null || charSequence.length() == 0) {
            fetchAndStoreRandomIdTask().executeAsyncTask((CompletionHandler) null);
        }
    }

    public final ApiTask<String> fetchAndStoreRandomIdTask() {
        return new ApiTask<>(GiphyPingbacks$fetchAndStoreRandomIdTask$1.INSTANCE, ApiTask.Companion.getNetworkRequestExecutor(), ApiTask.Companion.getCompletionExecutor());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0019 A[Catch:{ all -> 0x0024 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void storeRandomId(java.lang.String r3) {
        /*
            r2 = this;
            java.util.concurrent.locks.ReentrantLock r0 = randomIdLock
            java.util.concurrent.locks.Lock r0 = (java.util.concurrent.locks.Lock) r0
            r0.lock()
            java.lang.String r1 = randomId     // Catch:{ all -> 0x0024 }
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x0016
            int r1 = r1.length()     // Catch:{ all -> 0x0024 }
            if (r1 != 0) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            r1 = 0
            goto L_0x0017
        L_0x0016:
            r1 = 1
        L_0x0017:
            if (r1 == 0) goto L_0x001e
            com.giphy.sdk.analytics.GiphyPingbacks r1 = INSTANCE     // Catch:{ all -> 0x0024 }
            r1.setRandomId(r3)     // Catch:{ all -> 0x0024 }
        L_0x001e:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0024 }
            r0.unlock()
            return
        L_0x0024:
            r3 = move-exception
            r0.unlock()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.giphy.sdk.analytics.GiphyPingbacks.storeRandomId(java.lang.String):void");
    }
}
