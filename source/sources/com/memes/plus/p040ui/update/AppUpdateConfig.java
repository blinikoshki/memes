package com.memes.plus.p040ui.update;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0013\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\nR\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, mo26107d2 = {"Lcom/memes/plus/ui/update/AppUpdateConfig;", "", "packageName", "", "targetVersion", "", "isForceUpdateRequired", "", "isUpdateAvailable", "(Ljava/lang/String;IZZ)V", "()Z", "lastFetchedAt", "", "getLastFetchedAt", "()J", "setLastFetchedAt", "(J)V", "getPackageName", "()Ljava/lang/String;", "getTargetVersion", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.update.AppUpdateConfig */
/* compiled from: AppUpdateConfig.kt */
public final class AppUpdateConfig {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY = "android_auc_73";
    @SerializedName("force_update")
    @Expose
    private final boolean isForceUpdateRequired;
    @SerializedName("update_available")
    @Expose
    private final boolean isUpdateAvailable;
    private long lastFetchedAt;
    @SerializedName("pkg")
    @Expose
    private final String packageName;
    @SerializedName("target_version")
    @Expose
    private final int targetVersion;

    public AppUpdateConfig() {
        this((String) null, 0, false, false, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AppUpdateConfig copy$default(AppUpdateConfig appUpdateConfig, String str, int i, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = appUpdateConfig.packageName;
        }
        if ((i2 & 2) != 0) {
            i = appUpdateConfig.targetVersion;
        }
        if ((i2 & 4) != 0) {
            z = appUpdateConfig.isForceUpdateRequired;
        }
        if ((i2 & 8) != 0) {
            z2 = appUpdateConfig.isUpdateAvailable;
        }
        return appUpdateConfig.copy(str, i, z, z2);
    }

    public final String component1() {
        return this.packageName;
    }

    public final int component2() {
        return this.targetVersion;
    }

    public final boolean component3() {
        return this.isForceUpdateRequired;
    }

    public final boolean component4() {
        return this.isUpdateAvailable;
    }

    public final AppUpdateConfig copy(String str, int i, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "packageName");
        return new AppUpdateConfig(str, i, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppUpdateConfig)) {
            return false;
        }
        AppUpdateConfig appUpdateConfig = (AppUpdateConfig) obj;
        return Intrinsics.areEqual((Object) this.packageName, (Object) appUpdateConfig.packageName) && this.targetVersion == appUpdateConfig.targetVersion && this.isForceUpdateRequired == appUpdateConfig.isForceUpdateRequired && this.isUpdateAvailable == appUpdateConfig.isUpdateAvailable;
    }

    public int hashCode() {
        String str = this.packageName;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.targetVersion) * 31;
        boolean z = this.isForceUpdateRequired;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        boolean z3 = this.isUpdateAvailable;
        if (!z3) {
            z2 = z3;
        }
        return i + (z2 ? 1 : 0);
    }

    public String toString() {
        return "AppUpdateConfig(packageName=" + this.packageName + ", targetVersion=" + this.targetVersion + ", isForceUpdateRequired=" + this.isForceUpdateRequired + ", isUpdateAvailable=" + this.isUpdateAvailable + ")";
    }

    public AppUpdateConfig(String str, int i, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "packageName");
        this.packageName = str;
        this.targetVersion = i;
        this.isForceUpdateRequired = z;
        this.isUpdateAvailable = z2;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final int getTargetVersion() {
        return this.targetVersion;
    }

    public final boolean isForceUpdateRequired() {
        return this.isForceUpdateRequired;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AppUpdateConfig(String str, int i, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? BuildConfig.APPLICATION_ID : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? false : z2);
    }

    public final boolean isUpdateAvailable() {
        return this.isUpdateAvailable;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/plus/ui/update/AppUpdateConfig$Companion;", "", "()V", "KEY", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.update.AppUpdateConfig$Companion */
    /* compiled from: AppUpdateConfig.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final long getLastFetchedAt() {
        return this.lastFetchedAt;
    }

    public final void setLastFetchedAt(long j) {
        this.lastFetchedAt = j;
    }
}
