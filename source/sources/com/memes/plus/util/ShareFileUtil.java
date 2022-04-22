package com.memes.plus.util;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import androidx.core.content.FileProvider;
import com.facebook.share.internal.ShareConstants;
import com.memes.commons.provider.SimpleFileProvider;
import com.memes.commons.util.ExtensionsKt;
import com.memes.commons.util.FileMimeDetector;
import com.memes.plus.p040ui.splash.SplashActivity;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0002¢\u0006\u0002\u0010\tJ\u0010\u0010\u0005\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bH\u0002¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo26107d2 = {"Lcom/memes/plus/util/ShareFileUtil;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "findInstalledPackage", "", "packageNames", "", "([Ljava/lang/String;)Ljava/lang/String;", "", "packageName", "getSelfComponentNames", "Landroid/content/ComponentName;", "()[Landroid/content/ComponentName;", "share", "", "intent", "Landroid/content/Intent;", "request", "Lcom/memes/plus/util/ShareFileUtil$ShareFileRequest;", "ShareFileRequest", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ShareFileUtil.kt */
public final class ShareFileUtil {
    private final Context context;

    public ShareFileUtil(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u001b\u001a\u00020\rR\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000b¨\u0006\u001c"}, mo26107d2 = {"Lcom/memes/plus/util/ShareFileUtil$ShareFileRequest;", "", "file", "Ljava/io/File;", "extraText", "", "(Ljava/io/File;Ljava/lang/String;)V", "chooserTitle", "getChooserTitle", "()Ljava/lang/String;", "setChooserTitle", "(Ljava/lang/String;)V", "excludeSelf", "", "getExcludeSelf", "()Z", "setExcludeSelf", "(Z)V", "getExtraText", "getFile", "()Ljava/io/File;", "subject", "getSubject", "setSubject", "targetPackage", "getTargetPackage", "setTargetPackage", "hasTargetPackage", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ShareFileUtil.kt */
    public static final class ShareFileRequest {
        private String chooserTitle;
        private boolean excludeSelf;
        private final String extraText;
        private final File file;
        private String subject;
        private String targetPackage;

        public ShareFileRequest(File file2, String str) {
            Intrinsics.checkNotNullParameter(file2, "file");
            this.file = file2;
            this.extraText = str;
            this.subject = "Share";
            this.chooserTitle = "Share file to";
        }

        public final File getFile() {
            return this.file;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ShareFileRequest(File file2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(file2, (i & 2) != 0 ? "" : str);
        }

        public final String getExtraText() {
            return this.extraText;
        }

        public final String getSubject() {
            return this.subject;
        }

        public final void setSubject(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.subject = str;
        }

        public final String getChooserTitle() {
            return this.chooserTitle;
        }

        public final void setChooserTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.chooserTitle = str;
        }

        public final String getTargetPackage() {
            return this.targetPackage;
        }

        public final void setTargetPackage(String str) {
            this.targetPackage = str;
        }

        public final boolean getExcludeSelf() {
            return this.excludeSelf;
        }

        public final void setExcludeSelf(boolean z) {
            this.excludeSelf = z;
        }

        public final boolean hasTargetPackage() {
            return this.targetPackage != null;
        }
    }

    public final void share(ShareFileRequest shareFileRequest) {
        Intrinsics.checkNotNullParameter(shareFileRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Uri uriForFile = FileProvider.getUriForFile(this.context, SimpleFileProvider.NAME, shareFileRequest.getFile());
        Intent intent = new Intent("android.intent.action.SEND");
        intent.addFlags(1);
        intent.setType(FileMimeDetector.INSTANCE.detect(shareFileRequest.getFile()));
        intent.putExtra("android.intent.extra.SUBJECT", shareFileRequest.getSubject());
        intent.putExtra("android.intent.extra.TEXT", shareFileRequest.getExtraText());
        intent.putExtra("android.intent.extra.STREAM", uriForFile);
        if (shareFileRequest.getTargetPackage() != null) {
            intent.setPackage(shareFileRequest.getTargetPackage());
            share(intent);
            return;
        }
        Intent createChooser = Intent.createChooser(intent, shareFileRequest.getChooserTitle());
        if (shareFileRequest.getExcludeSelf() && Build.VERSION.SDK_INT >= 24) {
            createChooser.putExtra("android.intent.extra.EXCLUDE_COMPONENTS", (Parcelable[]) getSelfComponentNames());
        }
        Intrinsics.checkNotNullExpressionValue(createChooser, "chooserIntent");
        share(createChooser);
    }

    private final void share(Intent intent) {
        if (intent.resolveActivity(this.context.getPackageManager()) == null) {
            intent.setPackage((String) null);
            ExtensionsKt.toast(this.context, "App not found.");
            if (intent.resolveActivity(this.context.getPackageManager()) == null) {
                ExtensionsKt.toast(this.context, "There's no app installed to handle this file.");
                return;
            }
        }
        try {
            this.context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
        }
    }

    private final ComponentName[] getSelfComponentNames() {
        return new ComponentName[]{new ComponentName(this.context, SplashActivity.class)};
    }

    private final String findInstalledPackage(String[] strArr) {
        for (String str : strArr) {
            if (findInstalledPackage(str)) {
                return str;
            }
        }
        return null;
    }

    private final boolean findInstalledPackage(String str) {
        try {
            this.context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
