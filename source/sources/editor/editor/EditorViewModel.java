package editor.editor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.commons.media.MediaFile;
import com.memes.commons.output.OutputTargetGenerator;
import com.memes.commons.util.SingleLiveEvent;
import editor.core.NicoViewModel;
import editor.editor.export.command.ExportCommandSource;
import editor.ffmpeg.core.MultimediaFramework;
import editor.ffmpeg.core.callback.MultimediaFrameworkErrorNotifier;
import editor.ffmpeg.core.callback.OnMultimediaProgressListener;
import editor.util.FfmpegCommandUtil;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ!\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\u0019J\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\"J!\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'H@ø\u0001\u0000¢\u0006\u0002\u0010(J!\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020$H@ø\u0001\u0000¢\u0006\u0002\u0010.J1\u0010/\u001a\u00020'2\u0006\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u00020'2\u0006\u00102\u001a\u00020$2\u0006\u00103\u001a\u00020$H@ø\u0001\u0000¢\u0006\u0002\u00104J\u001c\u00105\u001a\u00020*2\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u000107H\u0016J\u001a\u00109\u001a\u00020*2\u0006\u0010:\u001a\u00020\u001d2\b\u0010;\u001a\u0004\u0018\u000107H\u0016J\u0019\u0010<\u001a\u00020*2\u0006\u0010\u0018\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138FX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006="}, mo26107d2 = {"Leditor/editor/EditorViewModel;", "Leditor/core/NicoViewModel;", "Leditor/ffmpeg/core/callback/OnMultimediaProgressListener;", "Leditor/ffmpeg/core/callback/MultimediaFrameworkErrorNotifier;", "ffmpegFramework", "Leditor/ffmpeg/core/MultimediaFramework;", "outputTargetGenerator", "Lcom/memes/commons/output/OutputTargetGenerator;", "(Leditor/ffmpeg/core/MultimediaFramework;Lcom/memes/commons/output/OutputTargetGenerator;)V", "_exported", "Lcom/memes/commons/util/SingleLiveEvent;", "Lcom/memes/commons/media/MediaFile;", "commandUtil", "Leditor/util/FfmpegCommandUtil;", "getCommandUtil", "()Leditor/util/FfmpegCommandUtil;", "commandUtil$delegate", "Lkotlin/Lazy;", "frameworkExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getFrameworkExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "frameworkExceptionHandler$delegate", "createExportThumbnail", "commandSource", "Leditor/editor/export/command/ExportCommandSource;", "(Leditor/editor/export/command/ExportCommandSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeFrameCommand", "mediaType", "", "(Leditor/editor/export/command/ExportCommandSource;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "export", "Lkotlinx/coroutines/Job;", "exported", "Landroidx/lifecycle/LiveData;", "findContentDuration", "", "contentType", "contentFile", "Ljava/io/File;", "(ILjava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loopOverlayRegionIfRequired", "", "overlayRegion", "Leditor/editor/export/regions/OverlayRegion;", "longestVideoDurationMillis", "(Leditor/editor/export/regions/OverlayRegion;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loopVideoIfRequired", "inputContentType", "inputFile", "inputDurationMillis", "targetDurationMillis", "(ILjava/io/File;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onFrameworkErrorNotificationReceived", "message", "", "errorLog", "onMultimediaTaskProgressAvailable", "progress", "preparedMessage", "performCommandSourcePrerequisites", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EditorViewModel.kt */
public final class EditorViewModel extends NicoViewModel implements OnMultimediaProgressListener, MultimediaFrameworkErrorNotifier {
    /* access modifiers changed from: private */
    public final SingleLiveEvent<MediaFile> _exported = new SingleLiveEvent<>();
    private final Lazy commandUtil$delegate = LazyKt.lazy(new EditorViewModel$commandUtil$2(this));
    /* access modifiers changed from: private */
    public final MultimediaFramework ffmpegFramework;
    private final Lazy frameworkExceptionHandler$delegate = LazyKt.lazy(new EditorViewModel$frameworkExceptionHandler$2(this));
    /* access modifiers changed from: private */
    public final OutputTargetGenerator outputTargetGenerator;

    /* access modifiers changed from: private */
    public final FfmpegCommandUtil getCommandUtil() {
        return (FfmpegCommandUtil) this.commandUtil$delegate.getValue();
    }

    public final CoroutineExceptionHandler getFrameworkExceptionHandler() {
        return (CoroutineExceptionHandler) this.frameworkExceptionHandler$delegate.getValue();
    }

    public EditorViewModel(MultimediaFramework multimediaFramework, OutputTargetGenerator outputTargetGenerator2) {
        Intrinsics.checkNotNullParameter(multimediaFramework, "ffmpegFramework");
        Intrinsics.checkNotNullParameter(outputTargetGenerator2, "outputTargetGenerator");
        this.ffmpegFramework = multimediaFramework;
        this.outputTargetGenerator = outputTargetGenerator2;
        multimediaFramework.setOnProgressListener(this);
        multimediaFramework.setFrameworkErrorNotifier(this);
    }

    public final LiveData<MediaFile> exported() {
        return this._exported;
    }

    public final Job export(ExportCommandSource exportCommandSource) {
        Intrinsics.checkNotNullParameter(exportCommandSource, "commandSource");
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), getFrameworkExceptionHandler(), (CoroutineStart) null, new EditorViewModel$export$1(this, exportCommandSource, (Continuation) null), 2, (Object) null);
    }

    public final Object createExportThumbnail(ExportCommandSource exportCommandSource, Continuation<? super MediaFile> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new EditorViewModel$createExportThumbnail$2(this, exportCommandSource, (Continuation) null), continuation);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object executeFrameCommand(ExportCommandSource exportCommandSource, int i, Continuation<? super MediaFile> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new EditorViewModel$executeFrameCommand$2(this, i, exportCommandSource, (Continuation) null), continuation);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object performCommandSourcePrerequisites(editor.editor.export.command.ExportCommandSource r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof editor.editor.EditorViewModel$performCommandSourcePrerequisites$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            editor.editor.EditorViewModel$performCommandSourcePrerequisites$1 r0 = (editor.editor.EditorViewModel$performCommandSourcePrerequisites$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            editor.editor.EditorViewModel$performCommandSourcePrerequisites$1 r0 = new editor.editor.EditorViewModel$performCommandSourcePrerequisites$1
            r0.<init>(r12, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x005a
            if (r2 == r4) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            long r4 = r0.J$0
            java.lang.Object r13 = r0.L$2
            java.util.Iterator r13 = (java.util.Iterator) r13
            java.lang.Object r2 = r0.L$1
            editor.editor.export.command.ExportCommandSource r2 = (editor.editor.export.command.ExportCommandSource) r2
            java.lang.Object r6 = r0.L$0
            editor.editor.EditorViewModel r6 = (editor.editor.EditorViewModel) r6
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00b0
        L_0x003c:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0044:
            long r5 = r0.J$0
            java.lang.Object r13 = r0.L$3
            java.util.Iterator r13 = (java.util.Iterator) r13
            java.lang.Object r2 = r0.L$2
            editor.editor.export.regions.OverlayRegion r2 = (editor.editor.export.regions.OverlayRegion) r2
            java.lang.Object r7 = r0.L$1
            editor.editor.export.command.ExportCommandSource r7 = (editor.editor.export.command.ExportCommandSource) r7
            java.lang.Object r8 = r0.L$0
            editor.editor.EditorViewModel r8 = (editor.editor.EditorViewModel) r8
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0095
        L_0x005a:
            kotlin.ResultKt.throwOnFailure(r14)
            r5 = 0
            java.util.List r14 = r13.getOverlayRegions()
            java.util.Iterator r14 = r14.iterator()
            r8 = r12
            r11 = r14
            r14 = r13
            r13 = r11
        L_0x006b:
            boolean r2 = r13.hasNext()
            if (r2 == 0) goto L_0x00a5
            java.lang.Object r2 = r13.next()
            editor.editor.export.regions.OverlayRegion r2 = (editor.editor.export.regions.OverlayRegion) r2
            int r7 = r2.getContentType()
            java.io.File r9 = r2.getContentFile()
            r0.L$0 = r8
            r0.L$1 = r14
            r0.L$2 = r2
            r0.L$3 = r13
            r0.J$0 = r5
            r0.label = r4
            java.lang.Object r7 = r8.findContentDuration(r7, r9, r0)
            if (r7 != r1) goto L_0x0092
            return r1
        L_0x0092:
            r11 = r7
            r7 = r14
            r14 = r11
        L_0x0095:
            java.lang.Number r14 = (java.lang.Number) r14
            long r9 = r14.longValue()
            r2.setDurationMillis(r9)
            int r14 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r14 >= 0) goto L_0x00a3
            r5 = r9
        L_0x00a3:
            r14 = r7
            goto L_0x006b
        L_0x00a5:
            java.util.List r13 = r14.getOverlayRegions()
            java.util.Iterator r13 = r13.iterator()
            r2 = r14
            r4 = r5
            r6 = r8
        L_0x00b0:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x00d0
            java.lang.Object r14 = r13.next()
            editor.editor.export.regions.OverlayRegion r14 = (editor.editor.export.regions.OverlayRegion) r14
            r0.L$0 = r6
            r0.L$1 = r2
            r0.L$2 = r13
            r7 = 0
            r0.L$3 = r7
            r0.J$0 = r4
            r0.label = r3
            java.lang.Object r14 = r6.loopOverlayRegionIfRequired(r14, r4, r0)
            if (r14 != r1) goto L_0x00b0
            return r1
        L_0x00d0:
            r2.setEndTimeoutMillis(r4)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.editor.EditorViewModel.performCommandSourcePrerequisites(editor.editor.export.command.ExportCommandSource, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00af A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object loopOverlayRegionIfRequired(editor.editor.export.regions.OverlayRegion r17, long r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r20
            boolean r3 = r2 instanceof editor.editor.EditorViewModel$loopOverlayRegionIfRequired$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            editor.editor.EditorViewModel$loopOverlayRegionIfRequired$1 r3 = (editor.editor.EditorViewModel$loopOverlayRegionIfRequired$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            editor.editor.EditorViewModel$loopOverlayRegionIfRequired$1 r3 = new editor.editor.EditorViewModel$loopOverlayRegionIfRequired$1
            r3.<init>(r0, r2)
        L_0x001f:
            r11 = r3
            java.lang.Object r2 = r11.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r11.label
            r12 = 1232(0x4d0, float:1.726E-42)
            r5 = 2
            r6 = 0
            r13 = 1
            if (r4 == 0) goto L_0x0056
            if (r4 == r13) goto L_0x0044
            if (r4 != r5) goto L_0x003c
            java.lang.Object r1 = r11.L$0
            editor.editor.export.regions.OverlayRegion r1 = (editor.editor.export.regions.OverlayRegion) r1
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x00b0
        L_0x003c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0044:
            long r7 = r11.J$0
            java.lang.Object r1 = r11.L$2
            editor.editor.export.regions.OverlayRegion r1 = (editor.editor.export.regions.OverlayRegion) r1
            java.lang.Object r4 = r11.L$1
            editor.editor.export.regions.OverlayRegion r4 = (editor.editor.export.regions.OverlayRegion) r4
            java.lang.Object r9 = r11.L$0
            editor.editor.EditorViewModel r9 = (editor.editor.EditorViewModel) r9
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0086
        L_0x0056:
            kotlin.ResultKt.throwOnFailure(r2)
            int r2 = r17.getContentType()
            r4 = 1235(0x4d3, float:1.73E-42)
            if (r2 != r4) goto L_0x008e
            r1.setContentType(r12)
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            editor.editor.EditorViewModel$loopOverlayRegionIfRequired$2 r4 = new editor.editor.EditorViewModel$loopOverlayRegionIfRequired$2
            r4.<init>(r0, r1, r6)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r11.L$0 = r0
            r11.L$1 = r1
            r11.L$2 = r1
            r7 = r18
            r11.J$0 = r7
            r11.label = r13
            java.lang.Object r2 = kotlinx.coroutines.BuildersKt.withContext(r2, r4, r11)
            if (r2 != r3) goto L_0x0084
            return r3
        L_0x0084:
            r9 = r0
            r4 = r1
        L_0x0086:
            java.io.File r2 = (java.io.File) r2
            r1.setContentFile(r2)
            r1 = r4
            r4 = r9
            goto L_0x0091
        L_0x008e:
            r7 = r18
            r4 = r0
        L_0x0091:
            r9 = r7
            int r2 = r1.getContentType()
            java.io.File r7 = r1.getContentFile()
            long r14 = r1.getDurationMillis()
            r11.L$0 = r1
            r11.L$1 = r6
            r11.L$2 = r6
            r11.label = r5
            r5 = r2
            r6 = r7
            r7 = r14
            java.lang.Object r2 = r4.loopVideoIfRequired(r5, r6, r7, r9, r11)
            if (r2 != r3) goto L_0x00b0
            return r3
        L_0x00b0:
            java.io.File r2 = (java.io.File) r2
            java.io.File r3 = r1.getContentFile()
            java.lang.String r3 = r3.getAbsolutePath()
            java.lang.String r4 = r2.getAbsolutePath()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            r3 = r3 ^ r13
            if (r3 == 0) goto L_0x00cb
            r1.setContentFile(r2)
            r1.setContentType(r12)
        L_0x00cb:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.editor.EditorViewModel.loopOverlayRegionIfRequired(editor.editor.export.regions.OverlayRegion, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object loopVideoIfRequired(int i, File file, long j, long j2, Continuation<? super File> continuation) {
        if (i != 1232 && i != 1237 && i != 1235) {
            Timber.m303e("Not looping files other than videos or gifs. path=" + file, new Object[0]);
            return file;
        } else if (j == 0) {
            Timber.m303e("Unable to loop a region with 0ms duration. path=" + file, new Object[0]);
            return file;
        } else {
            int i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
            if (i2 == 0) {
                return file;
            }
            if (i2 > 0) {
                Timber.m303e("There exists an input with longer duration(%s) than expected(%s)", Boxing.boxLong(j), Boxing.boxLong(j2));
                return file;
            }
            Timber.m300d("Looping file. path=" + file, new Object[0]);
            return getCommandUtil().executeLoopCommand(file, j, j2, continuation);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object findContentDuration(int i, File file, Continuation<? super Long> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new EditorViewModel$findContentDuration$2(this, i, file, (Continuation) null), continuation);
    }

    public void onMultimediaTaskProgressAvailable(int i, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append('%');
        updateBlockingProgress(i, sb.toString());
    }

    public void onFrameworkErrorNotificationReceived(String str, String str2) {
        Timber.m303e(str2, new Object[0]);
    }
}
