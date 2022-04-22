package editor.ffmpeg.api;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import editor.ffmpeg.core.MultimediaFramework;
import editor.ffmpeg.core.callback.MultimediaFrameworkErrorNotifier;
import editor.ffmpeg.core.callback.OnMultimediaProgressListener;
import editor.ffmpeg.core.command.MultimediaCommand;
import editor.ffmpeg.core.command.MultimediaCommandResult;
import editor.ffmpeg.core.info.DataPacket;
import editor.ffmpeg.internal.FfmpegCommandMapper;
import editor.ffmpeg.internal.FfmpegCommandResult;
import editor.ffmpeg.internal.core.FfmpegBinary;
import editor.ffmpeg.internal.core.FfmpegProvider;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nH\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, mo26107d2 = {"Leditor/ffmpeg/api/FfmpegFramework;", "Leditor/ffmpeg/core/MultimediaFramework;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "commandMapper", "Leditor/ffmpeg/internal/FfmpegCommandMapper;", "ffmpegBinary", "Leditor/ffmpeg/internal/core/FfmpegBinary;", "frameworkErrorNotifier", "Leditor/ffmpeg/core/callback/MultimediaFrameworkErrorNotifier;", "onProgressListener", "Leditor/ffmpeg/core/callback/OnMultimediaProgressListener;", "execute", "Leditor/ffmpeg/core/command/MultimediaCommandResult;", "command", "Leditor/ffmpeg/core/command/MultimediaCommand;", "(Leditor/ffmpeg/core/command/MultimediaCommand;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadIfNeeded", "", "setFrameworkErrorNotifier", "notifier", "setOnProgressListener", "listener", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FfmpegFramework.kt */
public final class FfmpegFramework implements MultimediaFramework {
    private final FfmpegCommandMapper commandMapper = new FfmpegCommandMapper();
    private final Context context;
    /* access modifiers changed from: private */
    public FfmpegBinary ffmpegBinary;
    private MultimediaFrameworkErrorNotifier frameworkErrorNotifier;
    private OnMultimediaProgressListener onProgressListener;

    public FfmpegFramework(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public static final /* synthetic */ FfmpegBinary access$getFfmpegBinary$p(FfmpegFramework ffmpegFramework) {
        FfmpegBinary ffmpegBinary2 = ffmpegFramework.ffmpegBinary;
        if (ffmpegBinary2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ffmpegBinary");
        }
        return ffmpegBinary2;
    }

    public void loadIfNeeded() {
        if (this.ffmpegBinary == null) {
            FfmpegProvider ffmpegProvider = FfmpegProvider.INSTANCE;
            Context applicationContext = this.context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            this.ffmpegBinary = ffmpegProvider.createFor(applicationContext);
        }
    }

    public void setOnProgressListener(OnMultimediaProgressListener onMultimediaProgressListener) {
        Intrinsics.checkNotNullParameter(onMultimediaProgressListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onProgressListener = onMultimediaProgressListener;
    }

    public void setFrameworkErrorNotifier(MultimediaFrameworkErrorNotifier multimediaFrameworkErrorNotifier) {
        Intrinsics.checkNotNullParameter(multimediaFrameworkErrorNotifier, "notifier");
        this.frameworkErrorNotifier = multimediaFrameworkErrorNotifier;
    }

    public Object execute(MultimediaCommand multimediaCommand, Continuation<? super MultimediaCommandResult> continuation) {
        MultimediaFrameworkErrorNotifier multimediaFrameworkErrorNotifier;
        if (multimediaCommand instanceof FfmpegCommand) {
            String[] commandArray = this.commandMapper.toCommandArray((FfmpegCommand) multimediaCommand);
            FfmpegBinary ffmpegBinary2 = this.ffmpegBinary;
            if (ffmpegBinary2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ffmpegBinary");
            }
            FfmpegCommandResult execute$default = FfmpegBinary.DefaultImpls.execute$default(ffmpegBinary2, commandArray, (Map) null, this.onProgressListener, 2, (Object) null);
            if (!execute$default.getSuccess() && (multimediaFrameworkErrorNotifier = this.frameworkErrorNotifier) != null) {
                String output = execute$default.getOutput();
                DataPacket dataPacket = execute$default.getDataPacket();
                multimediaFrameworkErrorNotifier.onFrameworkErrorNotificationReceived(output, dataPacket != null ? dataPacket.rawLog() : null);
            }
            return this.commandMapper.toResult(execute$default);
        }
        throw new RuntimeException("Unknown Multimedia Command: " + multimediaCommand);
    }
}
