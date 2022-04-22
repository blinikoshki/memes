package editor.util;

import com.memes.commons.output.OutputTarget;
import com.memes.commons.output.OutputTargetGenerator;
import editor.ffmpeg.api.FfmpegCommand;
import editor.ffmpeg.core.MultimediaFramework;
import editor.ffmpeg.core.command.MultimediaCommand;
import editor.ffmpeg.core.info.DataPacket;
import editor.tools.crop.CropBounds;
import java.io.File;
import java.io.FileWriter;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001:\u0001*B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J)\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J#\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J)\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u001b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0019\u0010\"\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J'\u0010#\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\bH@ø\u0001\u0000¢\u0006\u0002\u0010%J3\u0010&\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010)R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, mo26107d2 = {"Leditor/util/FfmpegCommandUtil;", "", "ffmpegFramework", "Leditor/ffmpeg/core/MultimediaFramework;", "outputTargetGenerator", "Lcom/memes/commons/output/OutputTargetGenerator;", "(Leditor/ffmpeg/core/MultimediaFramework;Lcom/memes/commons/output/OutputTargetGenerator;)V", "outputFolder", "", "getOutputFolder", "()Ljava/lang/String;", "setOutputFolder", "(Ljava/lang/String;)V", "executeCropCommand", "Ljava/io/File;", "inputFile", "mediaType", "", "cropBounds", "Leditor/tools/crop/CropBounds;", "(Ljava/io/File;ILeditor/tools/crop/CropBounds;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeGifToVideoConversionCommand", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeH264TranscodeCommand", "outputFile", "(Ljava/io/File;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeLoopCommand", "inputDurationMillis", "", "targetDurationMillis", "(Ljava/io/File;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeMetadataRetrievalCommand", "Leditor/ffmpeg/core/info/DataPacket;", "file", "executeReverseVideoCommand", "executeThumbnailRetrievalCommand", "outputFileName", "(Ljava/io/File;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeTrimVideoCommand", "startMillis", "endMillis", "(Ljava/io/File;JJLjava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Command", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FfmpegCommandUtil.kt */
public final class FfmpegCommandUtil {
    /* access modifiers changed from: private */
    public final MultimediaFramework ffmpegFramework;
    private String outputFolder = OutputTarget.FOLDER_CACHE;
    /* access modifiers changed from: private */
    public final OutputTargetGenerator outputTargetGenerator;

    public FfmpegCommandUtil(MultimediaFramework multimediaFramework, OutputTargetGenerator outputTargetGenerator2) {
        Intrinsics.checkNotNullParameter(multimediaFramework, "ffmpegFramework");
        Intrinsics.checkNotNullParameter(outputTargetGenerator2, "outputTargetGenerator");
        this.ffmpegFramework = multimediaFramework;
        this.outputTargetGenerator = outputTargetGenerator2;
    }

    public final String getOutputFolder() {
        return this.outputFolder;
    }

    public final void setOutputFolder(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.outputFolder = str;
    }

    public final Object executeMetadataRetrievalCommand(File file, Continuation<? super DataPacket> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FfmpegCommandUtil$executeMetadataRetrievalCommand$2(this, file, (Continuation) null), continuation);
    }

    public static /* synthetic */ Object executeThumbnailRetrievalCommand$default(FfmpegCommandUtil ffmpegCommandUtil, File file, String str, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return ffmpegCommandUtil.executeThumbnailRetrievalCommand(file, str, continuation);
    }

    public final Object executeThumbnailRetrievalCommand(File file, String str, Continuation<? super File> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FfmpegCommandUtil$executeThumbnailRetrievalCommand$2(this, str, file, (Continuation) null), continuation);
    }

    public final Object executeReverseVideoCommand(File file, Continuation<? super File> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FfmpegCommandUtil$executeReverseVideoCommand$2(this, file, (Continuation) null), continuation);
    }

    public final Object executeCropCommand(File file, int i, CropBounds cropBounds, Continuation<? super File> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FfmpegCommandUtil$executeCropCommand$2(this, i, file, cropBounds, (Continuation) null), continuation);
    }

    public final Object executeH264TranscodeCommand(File file, File file2, Continuation<? super File> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FfmpegCommandUtil$executeH264TranscodeCommand$2(this, file, file2, (Continuation) null), continuation);
    }

    public final Object executeTrimVideoCommand(File file, long j, long j2, File file2, Continuation<? super File> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FfmpegCommandUtil$executeTrimVideoCommand$2(this, file, j, j2, file2, (Continuation) null), continuation);
    }

    public final Object executeLoopCommand(File file, long j, long j2, Continuation<? super File> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FfmpegCommandUtil$executeLoopCommand$2(this, j, j2, file, (Continuation) null), continuation);
    }

    public final Object executeGifToVideoConversionCommand(File file, Continuation<? super File> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FfmpegCommandUtil$executeGifToVideoConversionCommand$2(this, file, (Continuation) null), continuation);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J&\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006J\u0016\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J&\u0010\u0017\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u001b"}, mo26107d2 = {"Leditor/util/FfmpegCommandUtil$Command;", "", "()V", "createConversionCommand", "Leditor/ffmpeg/api/FfmpegCommand;", "inputFile", "Ljava/io/File;", "outputFile", "createCropMediaCommand", "Leditor/ffmpeg/core/command/MultimediaCommand;", "file", "cropBounds", "Leditor/tools/crop/CropBounds;", "createFrameRetrievalCommand", "createH264TranscodeCommand", "createLoopVideoCommand", "loopConfigFile", "loopInputFile", "loopOutputFile", "loopCount", "", "createMetadataRetrievalCommand", "createReverseVideoCommand", "createTrimVideoCommand", "startMillis", "", "endMillis", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: FfmpegCommandUtil.kt */
    private static final class Command {
        public static final Command INSTANCE = new Command();

        private Command() {
        }

        public final FfmpegCommand createMetadataRetrievalCommand(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            FfmpegCommand overwriteOutputFile = FfmpegCommand.Companion.m2582new().overwriteOutputFile();
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
            return overwriteOutputFile.addInputSource(absolutePath);
        }

        public final FfmpegCommand createFrameRetrievalCommand(File file, File file2) {
            Intrinsics.checkNotNullParameter(file, "inputFile");
            Intrinsics.checkNotNullParameter(file2, "outputFile");
            FfmpegCommand overwriteOutputFile = FfmpegCommand.Companion.m2582new().overwriteOutputFile();
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "inputFile.absolutePath");
            FfmpegCommand oneFrameOnly = overwriteOutputFile.addInputSource(absolutePath).oneFrameOnly();
            String absolutePath2 = file2.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath2, "outputFile.absolutePath");
            return oneFrameOnly.addOutputPath(absolutePath2);
        }

        public final FfmpegCommand createReverseVideoCommand(File file, File file2) {
            Intrinsics.checkNotNullParameter(file, "inputFile");
            Intrinsics.checkNotNullParameter(file2, "outputFile");
            FfmpegCommand overwriteOutputFile = FfmpegCommand.Companion.m2582new().overwriteOutputFile();
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "inputFile.absolutePath");
            FfmpegCommand addUltraFastPreset = overwriteOutputFile.addInputSource(absolutePath).reverseVideo().reverseAudio().addUltraFastPreset();
            String absolutePath2 = file2.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath2, "outputFile.absolutePath");
            return addUltraFastPreset.addOutputPath(absolutePath2);
        }

        public final MultimediaCommand createCropMediaCommand(File file, CropBounds cropBounds, File file2) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(cropBounds, "cropBounds");
            Intrinsics.checkNotNullParameter(file2, "outputFile");
            FfmpegCommand overwriteOutputFile = FfmpegCommand.Companion.m2582new().overwriteOutputFile();
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
            FfmpegCommand addUltraFastPreset = overwriteOutputFile.addInputSource(absolutePath).openComplexFilter(new FfmpegCommandUtil$Command$createCropMediaCommand$1(cropBounds)).copyAudioStream().addUltraFastPreset();
            String absolutePath2 = file2.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath2, "outputFile.absolutePath");
            return addUltraFastPreset.addOutputPath(absolutePath2);
        }

        public final MultimediaCommand createTrimVideoCommand(File file, long j, long j2, File file2) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(file2, "outputFile");
            FfmpegCommand overwriteOutputFile = FfmpegCommand.Companion.m2582new().overwriteOutputFile();
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
            FfmpegCommand addUltraFastPreset = overwriteOutputFile.addInputSource(absolutePath).useAudioCodecAAC().copyNonKeyFrames().seekTo(j).cutAt(j2).addUltraFastPreset();
            String absolutePath2 = file2.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath2, "outputFile.absolutePath");
            return addUltraFastPreset.addOutputPath(absolutePath2);
        }

        public final MultimediaCommand createH264TranscodeCommand(File file, File file2) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(file2, "outputFile");
            FfmpegCommand overwriteOutputFile = FfmpegCommand.Companion.m2582new().overwriteOutputFile();
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
            FfmpegCommand addUltraFastPreset = overwriteOutputFile.addInputSource(absolutePath).useVideoCodecLibx264().useAudioCodecAAC().addUltraFastPreset();
            String absolutePath2 = file2.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath2, "outputFile.absolutePath");
            return addUltraFastPreset.addOutputPath(absolutePath2);
        }

        public final FfmpegCommand createLoopVideoCommand(File file, File file2, File file3, int i) {
            Intrinsics.checkNotNullParameter(file, "loopConfigFile");
            Intrinsics.checkNotNullParameter(file2, "loopInputFile");
            Intrinsics.checkNotNullParameter(file3, "loopOutputFile");
            FileWriter fileWriter = new FileWriter(file);
            for (int i2 = 0; i2 < i; i2++) {
                fileWriter.write("file '" + file2.getAbsolutePath() + "'\n");
            }
            fileWriter.close();
            FfmpegCommand overwriteOutputFile = FfmpegCommand.Companion.m2582new().overwriteOutputFile();
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "loopConfigFile.absolutePath");
            FfmpegCommand addUltraFastPreset = overwriteOutputFile.addConcatInputSource(absolutePath).copy().addUltraFastPreset();
            String absolutePath2 = file3.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath2, "loopOutputFile.absolutePath");
            return addUltraFastPreset.addOutputPath(absolutePath2);
        }

        public final FfmpegCommand createConversionCommand(File file, File file2) {
            Intrinsics.checkNotNullParameter(file, "inputFile");
            Intrinsics.checkNotNullParameter(file2, "outputFile");
            FfmpegCommand overwriteOutputFile = FfmpegCommand.Companion.m2582new().overwriteOutputFile();
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "inputFile.absolutePath");
            FfmpegCommand addUltraFastPreset = overwriteOutputFile.addInputSource(absolutePath).useYUV420PPixFormat().scaleIfNotDivisibleBy2().addUltraFastPreset();
            String absolutePath2 = file2.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath2, "outputFile.absolutePath");
            return addUltraFastPreset.addOutputPath(absolutePath2);
        }
    }
}
