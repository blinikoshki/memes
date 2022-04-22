package p015io.getstream.chat.android.livedata.service.sync;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;
import com.facebook.AccessToken;
import com.giphy.sdk.core.network.api.GPHApiClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/service/sync/EncryptedBackgroundSyncConfigStore;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "clear", "", "get", "Lio/getstream/chat/android/livedata/service/sync/BackgroundSyncConfig;", "put", "config", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.service.sync.EncryptedBackgroundSyncConfigStore */
/* compiled from: EncryptedBackgroundSyncConfigStore.kt */
public final class EncryptedBackgroundSyncConfigStore {
    private final SharedPreferences prefs;

    public EncryptedBackgroundSyncConfigStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        MasterKey build = new MasterKey.Builder(context, "_stream_sync_config_master_key_").setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build();
        Intrinsics.checkNotNullExpressionValue(build, "MasterKey.Builder(contex…GCM)\n            .build()");
        SharedPreferences create = EncryptedSharedPreferences.create(context, "stream_livedata_sync_config_store", build, EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
        Intrinsics.checkNotNullExpressionValue(create, "EncryptedSharedPreferenc…heme.AES256_GCM\n        )");
        this.prefs = create;
    }

    public final void put(BackgroundSyncConfig backgroundSyncConfig) {
        Intrinsics.checkNotNullParameter(backgroundSyncConfig, "config");
        SharedPreferences.Editor edit = this.prefs.edit();
        edit.putString(GPHApiClient.API_KEY, backgroundSyncConfig.getApiKey());
        edit.putString(AccessToken.USER_ID_KEY, backgroundSyncConfig.getUserId());
        edit.putString("user_token", backgroundSyncConfig.getUserToken());
        edit.apply();
    }

    public final BackgroundSyncConfig get() {
        SharedPreferences sharedPreferences = this.prefs;
        String str = "";
        String string = sharedPreferences.getString(GPHApiClient.API_KEY, str);
        if (string == null) {
            string = str;
        }
        Intrinsics.checkNotNullExpressionValue(string, "getString(KEY_API_KEY, \"\") ?: \"\"");
        String string2 = sharedPreferences.getString(AccessToken.USER_ID_KEY, str);
        if (string2 == null) {
            string2 = str;
        }
        Intrinsics.checkNotNullExpressionValue(string2, "getString(KEY_USER_ID, \"\") ?: \"\"");
        String string3 = sharedPreferences.getString("user_token", str);
        if (string3 != null) {
            str = string3;
        }
        Intrinsics.checkNotNullExpressionValue(str, "getString(KEY_USER_TOKEN, \"\") ?: \"\"");
        BackgroundSyncConfig backgroundSyncConfig = new BackgroundSyncConfig(string, string2, str);
        if (backgroundSyncConfig.isValid()) {
            return backgroundSyncConfig;
        }
        return null;
    }

    public final void clear() {
        this.prefs.edit().clear().apply();
    }
}
