package editor.common.mediapicker;

import android.content.Context;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.livinglifetechway.quickpermissions_kotlin.PermissionsManagerKt;
import com.livinglifetechway.quickpermissions_kotlin.util.QuickPermissionsOptions;
import com.memes.commons.activity.ContractLauncher;
import com.memes.commons.media.MediaType;
import com.memes.commons.output.OutputTargetGenerator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\tH\u0016JI\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00132#\u0010\u0007\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bJI\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00132#\u0010\u0007\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bJI\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00132#\u0010\u0007\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bJ;\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00152#\u0010\u0007\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bJS\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00132\u0006\u0010\u001d\u001a\u00020\u001a2#\u0010\u0007\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bH\u0002R-\u0010\u0007\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo26107d2 = {"Leditor/common/mediapicker/MimeMediaPicker;", "Leditor/common/mediapicker/MediaPicker;", "context", "Landroid/content/Context;", "outputTargetGenerator", "Lcom/memes/commons/output/OutputTargetGenerator;", "(Landroid/content/Context;Lcom/memes/commons/output/OutputTargetGenerator;)V", "listener", "Lkotlin/Function1;", "Leditor/common/mediapicker/MediaPickResult;", "Lkotlin/ParameterName;", "name", "result", "", "onPickResultAvailable", "pickGif", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "contractLauncher", "Lcom/memes/commons/activity/ContractLauncher;", "", "Landroid/net/Uri;", "pickPhoto", "pickVideo", "resolveContent", "contentType", "", "contentUri", "start", "mediaType", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MimeMediaPicker.kt */
public final class MimeMediaPicker extends MediaPicker {
    private Function1<? super MediaPickResult, Unit> listener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MimeMediaPicker(Context context, OutputTargetGenerator outputTargetGenerator) {
        super(context, outputTargetGenerator);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(outputTargetGenerator, "outputTargetGenerator");
    }

    public final void pickPhoto(AppCompatActivity appCompatActivity, ContractLauncher<String, Uri> contractLauncher, Function1<? super MediaPickResult, Unit> function1) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Intrinsics.checkNotNullParameter(contractLauncher, "contractLauncher");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        start(appCompatActivity, contractLauncher, MediaType.PHOTO, function1);
    }

    public final void pickVideo(AppCompatActivity appCompatActivity, ContractLauncher<String, Uri> contractLauncher, Function1<? super MediaPickResult, Unit> function1) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Intrinsics.checkNotNullParameter(contractLauncher, "contractLauncher");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        start(appCompatActivity, contractLauncher, MediaType.VIDEO, function1);
    }

    public final void pickGif(AppCompatActivity appCompatActivity, ContractLauncher<String, Uri> contractLauncher, Function1<? super MediaPickResult, Unit> function1) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Intrinsics.checkNotNullParameter(contractLauncher, "contractLauncher");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        start(appCompatActivity, contractLauncher, MediaType.GIF, function1);
    }

    private final void start(AppCompatActivity appCompatActivity, ContractLauncher<String, Uri> contractLauncher, int i, Function1<? super MediaPickResult, Unit> function1) {
        String str;
        this.listener = function1;
        if (MediaType.INSTANCE.isPhoto(i)) {
            str = "image/jpg";
        } else if (MediaType.INSTANCE.isVideo(i)) {
            str = "video/mp4";
        } else {
            str = MediaType.INSTANCE.isGif(i) ? "image/gif" : "*/*";
        }
        PermissionsManagerKt.runWithPermissions$default((Context) appCompatActivity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, (QuickPermissionsOptions) null, (Function0) new MimeMediaPicker$start$1(this, contractLauncher, str, i, function1), 2, (Object) null);
    }

    public final void resolveContent(int i, Uri uri, Function1<? super MediaPickResult, Unit> function1) {
        Intrinsics.checkNotNullParameter(uri, "contentUri");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listener = function1;
        resolveContent(i, uri);
    }

    public void onPickResultAvailable(MediaPickResult mediaPickResult) {
        Intrinsics.checkNotNullParameter(mediaPickResult, "result");
        Function1<? super MediaPickResult, Unit> function1 = this.listener;
        if (function1 != null) {
            Unit invoke = function1.invoke(mediaPickResult);
        }
    }
}
