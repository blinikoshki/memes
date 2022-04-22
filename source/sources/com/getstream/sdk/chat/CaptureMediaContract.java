package com.getstream.sdk.chat;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcelable;
import androidx.activity.result.contract.ActivityResultContract;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.ClassUtils;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;
import p015io.getstream.chat.android.p016ui.common.C1891R;

@InternalStreamChatApi
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\u001f\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0010J&\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\fH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo26107d2 = {"Lcom/getstream/sdk/chat/CaptureMediaContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "Ljava/io/File;", "()V", "pictureFile", "videoFile", "createFileName", "", "prefix", "extension", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "(Landroid/content/Context;Lkotlin/Unit;)Landroid/content/Intent;", "createIntentList", "", "action", "destinationFile", "parseResult", "resultCode", "", "intent", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CaptureMediaContract.kt */
public final class CaptureMediaContract extends ActivityResultContract<Unit, File> {
    private File pictureFile;
    private File videoFile;

    public Intent createIntent(Context context, Unit unit) {
        Intrinsics.checkNotNullParameter(context, "context");
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (externalFilesDir == null) {
            externalFilesDir = context.getCacheDir();
        }
        File file = new File(externalFilesDir, createFileName("STREAM_IMG", "jpg"));
        this.pictureFile = file;
        List<Intent> createIntentList = createIntentList(context, "android.media.action.IMAGE_CAPTURE", file);
        File externalFilesDir2 = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
        if (externalFilesDir2 == null) {
            externalFilesDir2 = context.getCacheDir();
        }
        File file2 = new File(externalFilesDir2, createFileName("STREAM_VID", "mp4"));
        this.videoFile = file2;
        List plus = CollectionsKt.plus(createIntentList, createIntentList(context, "android.media.action.VIDEO_CAPTURE", file2));
        Intent intent = (Intent) CollectionsKt.lastOrNull(plus);
        if (intent == null) {
            intent = new Intent();
        }
        Intent createChooser = Intent.createChooser(intent, context.getString(C1891R.string.stream_input_camera_title));
        Object[] array = CollectionsKt.minus(plus, intent).toArray(new Intent[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) array);
        Intrinsics.checkNotNullExpressionValue(createChooser, "Intent.createChooser(ini…          )\n            }");
        return createChooser;
    }

    private final String createFileName(String str, String str2) {
        return str + '_' + CaptureMediaContractKt.dateFormat.format(Long.valueOf(new Date().getTime())) + ClassUtils.PACKAGE_SEPARATOR_CHAR + str2;
    }

    private final List<Intent> createIntentList(Context context, String str, File file) {
        Uri uriForFile = StreamFileProvider.Companion.getUriForFile(context, file);
        Intent intent = new Intent(str);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "context.packageManager.q…CH_DEFAULT_ONLY\n        )");
        Iterable<ResolveInfo> iterable = queryIntentActivities;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ResolveInfo resolveInfo : iterable) {
            Intent intent2 = new Intent(intent);
            intent2.putExtra("output", uriForFile);
            intent2.setFlags(2);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
            intent2.setPackage(resolveInfo.activityInfo.packageName);
            arrayList.add(intent2);
        }
        return (List) arrayList;
    }

    public File parseResult(int i, Intent intent) {
        File access$takeIfCaptured = CaptureMediaContractKt.takeIfCaptured(this.pictureFile);
        if (access$takeIfCaptured == null) {
            access$takeIfCaptured = CaptureMediaContractKt.takeIfCaptured(this.videoFile);
        }
        if (i == -1) {
            return access$takeIfCaptured;
        }
        return null;
    }
}
