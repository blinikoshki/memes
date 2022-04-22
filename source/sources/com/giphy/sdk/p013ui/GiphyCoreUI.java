package com.giphy.sdk.p013ui;

import android.content.Context;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.listener.RequestLoggingListener;
import com.giphy.sdk.core.GiphyCore;
import com.giphy.sdk.p013ui.themes.LightTheme;
import com.giphy.sdk.p013ui.themes.Theme;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, mo26107d2 = {"Lcom/giphy/sdk/ui/GiphyCoreUI;", "", "()V", "autoPlay", "", "getAutoPlay", "()Z", "setAutoPlay", "(Z)V", "frescoInitialized", "themeUsed", "Lcom/giphy/sdk/ui/themes/Theme;", "getThemeUsed$ui_sdk_release", "()Lcom/giphy/sdk/ui/themes/Theme;", "setThemeUsed$ui_sdk_release", "(Lcom/giphy/sdk/ui/themes/Theme;)V", "configure", "", "context", "Landroid/content/Context;", "apiKey", "", "initFresco", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.GiphyCoreUI */
/* compiled from: GiphyCoreUI.kt */
public final class GiphyCoreUI {
    public static final GiphyCoreUI INSTANCE = new GiphyCoreUI();
    private static boolean autoPlay = true;
    private static boolean frescoInitialized;
    private static Theme themeUsed = LightTheme.INSTANCE;

    private GiphyCoreUI() {
    }

    public final boolean getAutoPlay() {
        return autoPlay;
    }

    public final void setAutoPlay(boolean z) {
        autoPlay = z;
    }

    public final Theme getThemeUsed$ui_sdk_release() {
        return themeUsed;
    }

    public final void setThemeUsed$ui_sdk_release(Theme theme) {
        Intrinsics.checkParameterIsNotNull(theme, "<set-?>");
        themeUsed = theme;
    }

    public final void configure(Context context, String str) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "apiKey");
        GiphyCore giphyCore = GiphyCore.INSTANCE;
        String name = giphyCore.getName();
        giphyCore.setName(name + ", UISDK");
        String versionName = giphyCore.getVersionName();
        giphyCore.setVersionName(versionName + ", 1.0");
        giphyCore.configure(context, str, true);
        if (!frescoInitialized) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkExpressionValueIsNotNull(applicationContext, "context.applicationContext");
            initFresco(applicationContext);
        }
    }

    private final void initFresco(Context context) {
        DiskCacheConfig build = DiskCacheConfig.newBuilder(context).setMaxCacheSize(StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_BYTES).build();
        DiskCacheConfig build2 = DiskCacheConfig.newBuilder(context).setMaxCacheSize(262144000).build();
        new HashSet().add(new RequestLoggingListener());
        Fresco.initialize(context, OkHttpImagePipelineConfigFactory.newBuilder(context, new OkHttpClient.Builder().addInterceptor(GiphyCoreUI$initFresco$okHttpClient$1.INSTANCE).build()).setSmallImageDiskCacheConfig(build).setMainDiskCacheConfig(build2).build());
        frescoInitialized = true;
    }
}
