package editor.ffmpeg.api;

import com.facebook.internal.NativeProtocol;
import editor.ffmpeg.api.layers.FfColorLayer;
import editor.ffmpeg.api.layers.FfLayerCounter;
import editor.ffmpeg.core.command.MultimediaCommand;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.ClassUtils;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 E2\u00020\u0001:\u0001EB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ&\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0005J\u0014\u0010\u0013\u001a\u00020\u00002\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015J\u0006\u0010\u0016\u001a\u00020\u0000J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0005J\u0006\u0010\u0018\u001a\u00020\u0000J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0005J\u0006\u0010\u001b\u001a\u00020\u0000J\u0006\u0010\u001c\u001a\u00020\u0000J\u0006\u0010\u001d\u001a\u00020\u0000J\u0006\u0010\u001e\u001a\u00020\u0000J\u0006\u0010\u001f\u001a\u00020\u0000J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"J-\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0017\u0010&\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020(0'¢\u0006\u0002\b)H\bø\u0001\u0000J'\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u00052\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010.J\u000e\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020\rJ\u0010\u00101\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0002J\u0006\u00102\u001a\u00020\u0000J8\u00103\u001a\u00020\u000020\u0010&\u001a,\u0012\u0004\u0012\u00020\u0000\u0012\u0017\u0012\u001505j\u0002`6¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020(04¢\u0006\u0002\b)J\u0006\u00109\u001a\u00020\u0000J\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006J\u0006\u0010;\u001a\u00020\u0000J\u0006\u0010<\u001a\u00020\u0000J%\u0010=\u001a\u00020\u00002\u0017\u0010&\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020(0'¢\u0006\u0002\b)H\bø\u0001\u0000J\u0006\u0010>\u001a\u00020\u0000J\u000e\u0010?\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"J\u0006\u0010@\u001a\u00020\u0000J\u0006\u0010A\u001a\u00020\u0000J\u0006\u0010B\u001a\u00020\u0000J\u0006\u0010C\u001a\u00020\u0000J\u0006\u0010D\u001a\u00020\u0000R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006F"}, mo26107d2 = {"Leditor/ffmpeg/api/FfmpegCommand;", "Leditor/ffmpeg/core/command/MultimediaCommand;", "()V", "list", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "addAudioPlaybackSpeedFilter", "playbackSpeed", "", "addAvFilterInput", "color", "opacity", "", "width", "height", "addConcatInputSource", "path", "addInputSource", "addInputSources", "paths", "", "addNullAudioSource", "addOutputPath", "addUltraFastPreset", "applyComplexFilterConfiguration", "configuration", "copy", "copyAudioCodec", "copyAudioStream", "copyNonKeyFrames", "copyVideoCodec", "cutAt", "millis", "", "doIf", "condition", "", "action", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "inputSelectionTargetOf", "inputIndex", "streamType", "streamIndex", "(ILjava/lang/String;Ljava/lang/Integer;)Ljava/lang/String;", "limitFrameCount", "count", "millisToTimeDuration", "oneFrameOnly", "openComplexFilter", "Lkotlin/Function2;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Lkotlin/ParameterName;", "name", "overwriteOutputFile", "raw", "reverseAudio", "reverseVideo", "run", "scaleIfNotDivisibleBy2", "seekTo", "shortest", "useAudioCodecAAC", "useVideoCodecLibx264", "useYUV420PPixFormat", "withNullMuxer", "Companion", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FfmpegCommand.kt */
public final class FfmpegCommand implements MultimediaCommand {
    public static final String AUDIO_STREAM = "a";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String SUBTITLE_STREAM = "s";
    public static final String VIDEO_STREAM = "v";
    private final ArrayList<String> list;

    private FfmpegCommand() {
        this.list = new ArrayList<>();
    }

    public /* synthetic */ FfmpegCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Leditor/ffmpeg/api/FfmpegCommand$Companion;", "", "()V", "AUDIO_STREAM", "", "SUBTITLE_STREAM", "VIDEO_STREAM", "new", "Leditor/ffmpeg/api/FfmpegCommand;", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: FfmpegCommand.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: new  reason: not valid java name */
        public final FfmpegCommand m2582new() {
            FfLayerCounter.INSTANCE.reset();
            return new FfmpegCommand((DefaultConstructorMarker) null);
        }
    }

    public final FfmpegCommand openComplexFilter(Function2<? super FfmpegCommand, ? super StringBuilder, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, NativeProtocol.WEB_DIALOG_ACTION);
        StringBuilder sb = new StringBuilder();
        function2.invoke(this, sb);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "configuration.toString()");
        CharSequence charSequence = sb2;
        CharSequence charSequence2 = charSequence;
        int lastIndexOf$default = StringsKt.lastIndexOf$default(charSequence2, "[", 0, false, 6, (Object) null);
        int lastIndexOf$default2 = StringsKt.lastIndexOf$default(charSequence2, "]", 0, false, 6, (Object) null);
        int lastIndexOf$default3 = StringsKt.lastIndexOf$default(charSequence2, ";", 0, false, 6, (Object) null);
        if (lastIndexOf$default + 1 <= lastIndexOf$default2 && lastIndexOf$default3 > lastIndexOf$default2) {
            Objects.requireNonNull(sb2, "null cannot be cast to non-null type java.lang.String");
            String substring = sb2.substring(lastIndexOf$default, lastIndexOf$default3 + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (StringsKt.endsWith$default(sb2, substring, false, 2, (Object) null)) {
                int indexOf$default = StringsKt.indexOf$default(charSequence, substring, 0, false, 6, (Object) null);
                Objects.requireNonNull(sb2, "null cannot be cast to non-null type java.lang.String");
                sb2 = sb2.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(sb2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
        }
        applyComplexFilterConfiguration(sb2);
        return this;
    }

    public final FfmpegCommand doIf(boolean z, Function1<? super FfmpegCommand, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, NativeProtocol.WEB_DIALOG_ACTION);
        if (z) {
            function1.invoke(this);
        }
        return this;
    }

    public final FfmpegCommand run(Function1<? super FfmpegCommand, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, NativeProtocol.WEB_DIALOG_ACTION);
        function1.invoke(this);
        return this;
    }

    public static /* synthetic */ String inputSelectionTargetOf$default(FfmpegCommand ffmpegCommand, int i, String str, Integer num, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num = null;
        }
        return ffmpegCommand.inputSelectionTargetOf(i, str, num);
    }

    public final String inputSelectionTargetOf(int i, String str, Integer num) {
        Intrinsics.checkNotNullParameter(str, "streamType");
        String str2 = i + ':' + str;
        if (num == null) {
            return str2;
        }
        return str2 + ':' + num;
    }

    public final FfmpegCommand overwriteOutputFile() {
        this.list.add("-y");
        return this;
    }

    public final FfmpegCommand addConcatInputSource(String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        this.list.add("-f");
        this.list.add("concat");
        this.list.add("-safe");
        this.list.add("0");
        this.list.add("-i");
        this.list.add(str);
        return this;
    }

    public final FfmpegCommand addInputSource(String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        this.list.add("-i");
        this.list.add(str);
        return this;
    }

    public final FfmpegCommand addInputSources(List<String> list2) {
        Intrinsics.checkNotNullParameter(list2, "paths");
        for (String addInputSource : list2) {
            addInputSource(addInputSource);
        }
        return this;
    }

    public final FfmpegCommand seekTo(long j) {
        this.list.add("-ss");
        this.list.add(millisToTimeDuration(j));
        return this;
    }

    public final FfmpegCommand addAvFilterInput(String str, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, TtmlNode.ATTR_TTS_COLOR);
        this.list.add("-f");
        this.list.add("lavfi");
        this.list.add("-i");
        this.list.add(FfColorLayer.INSTANCE.mo64284of(str, ((float) i) / 100.0f, i2, i3));
        return this;
    }

    public final FfmpegCommand addNullAudioSource() {
        this.list.add("-f");
        this.list.add("lavfi");
        this.list.add("-t");
        this.list.add("0.1");
        this.list.add("-i");
        this.list.add("anullsrc");
        return this;
    }

    public final FfmpegCommand addAudioPlaybackSpeedFilter(float f) {
        this.list.add("-af");
        ArrayList<String> arrayList = this.list;
        arrayList.add("atempo=" + f);
        return this;
    }

    public final FfmpegCommand applyComplexFilterConfiguration(String str) {
        Intrinsics.checkNotNullParameter(str, "configuration");
        if (!StringsKt.isBlank(str)) {
            this.list.add("-filter_complex");
            this.list.add(str);
        }
        return this;
    }

    public final FfmpegCommand copy() {
        this.list.add("-c");
        this.list.add("copy");
        return this;
    }

    public final FfmpegCommand copyVideoCodec() {
        this.list.add("-vcodec");
        this.list.add("copy");
        return this;
    }

    public final FfmpegCommand copyAudioCodec() {
        this.list.add("-acodec");
        this.list.add("copy");
        return this;
    }

    public final FfmpegCommand copyNonKeyFrames() {
        this.list.add("-copyinkf");
        return this;
    }

    public final FfmpegCommand copyAudioStream() {
        this.list.add("-c:a");
        this.list.add("copy");
        return this;
    }

    public final FfmpegCommand useVideoCodecLibx264() {
        this.list.add("-c:v");
        this.list.add("libx264");
        return this;
    }

    public final FfmpegCommand useAudioCodecAAC() {
        this.list.add("-c:a");
        this.list.add("aac");
        return this;
    }

    public final FfmpegCommand reverseVideo() {
        this.list.add("-vf");
        this.list.add("reverse");
        return this;
    }

    public final FfmpegCommand reverseAudio() {
        this.list.add("-af");
        this.list.add("areverse");
        return this;
    }

    public final FfmpegCommand useYUV420PPixFormat() {
        this.list.add("-pix_fmt");
        this.list.add("yuv420p");
        return this;
    }

    public final FfmpegCommand scaleIfNotDivisibleBy2() {
        this.list.add("-vf");
        this.list.add("scale=trunc(iw/2)*2:trunc(ih/2)*2");
        return this;
    }

    public final FfmpegCommand addUltraFastPreset() {
        this.list.add("-preset");
        this.list.add("ultrafast");
        return this;
    }

    public final FfmpegCommand cutAt(long j) {
        this.list.add("-to");
        this.list.add(millisToTimeDuration(j));
        return this;
    }

    public final FfmpegCommand shortest() {
        this.list.add("-shortest");
        return this;
    }

    public final FfmpegCommand limitFrameCount(int i) {
        this.list.add("-frames");
        this.list.add(String.valueOf(i));
        return this;
    }

    public final FfmpegCommand oneFrameOnly() {
        return limitFrameCount(1);
    }

    public final FfmpegCommand withNullMuxer() {
        this.list.add("-f");
        this.list.add("null");
        return this;
    }

    public final FfmpegCommand addOutputPath(String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        this.list.add(str);
        return this;
    }

    public final ArrayList<String> raw() {
        Timber.m300d("generated_command=" + this.list, new Object[0]);
        return this.list;
    }

    private final String millisToTimeDuration(long j) {
        long j2 = (long) 1000;
        String valueOf = String.valueOf(j / j2);
        String format = new DecimalFormat("000").format(j % j2);
        return valueOf + ClassUtils.PACKAGE_SEPARATOR_CHAR + format;
    }
}
