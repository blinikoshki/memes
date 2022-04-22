package editor.gpu.command;

import editor.gpu.gpuvideo.composer.GPUMp4Composer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, mo26107d2 = {"Leditor/gpu/command/GpuVideoCommandExecutor;", "", "callback", "Leditor/gpu/command/GpuFrameworkProgressCallback;", "(Leditor/gpu/command/GpuFrameworkProgressCallback;)V", "execute", "Leditor/gpu/command/GpuFrameworkCommandResult;", "command", "Leditor/gpu/command/GpuVideoCommand;", "(Leditor/gpu/command/GpuVideoCommand;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeInternal", "Leditor/gpu/command/GpuCommandResult;", "composer", "Leditor/gpu/gpuvideo/composer/GPUMp4Composer;", "(Leditor/gpu/gpuvideo/composer/GPUMp4Composer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gputool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GpuVideoCommandExecutor.kt */
public final class GpuVideoCommandExecutor {
    /* access modifiers changed from: private */
    public final GpuFrameworkProgressCallback callback;

    public GpuVideoCommandExecutor(GpuFrameworkProgressCallback gpuFrameworkProgressCallback) {
        Intrinsics.checkNotNullParameter(gpuFrameworkProgressCallback, "callback");
        this.callback = gpuFrameworkProgressCallback;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object execute(editor.gpu.command.GpuVideoCommand r12, kotlin.coroutines.Continuation<? super editor.gpu.command.GpuFrameworkCommandResult> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof editor.gpu.command.GpuVideoCommandExecutor$execute$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            editor.gpu.command.GpuVideoCommandExecutor$execute$1 r0 = (editor.gpu.command.GpuVideoCommandExecutor$execute$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            editor.gpu.command.GpuVideoCommandExecutor$execute$1 r0 = new editor.gpu.command.GpuVideoCommandExecutor$execute$1
            r0.<init>(r11, r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r12 = r0.L$0
            editor.gpu.command.GpuVideoCommand r12 = (editor.gpu.command.GpuVideoCommand) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0136
        L_0x002f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r13)
            editor.gpu.conflation.GlConflatedFilter r13 = r12.getConflatedFilter()
            if (r13 == 0) goto L_0x0046
            editor.gpu.gpuvideo.egl.filter.GlVideoFilter r13 = r13.createVideoFilter()
            goto L_0x0113
        L_0x0046:
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.util.List r13 = (java.util.List) r13
            editor.gpu.util.VideoFilterRange r2 = editor.gpu.util.VideoFilterRange.INSTANCE
            editor.gpu.util.FloatRange r2 = r2.getBRIGHTNESS()
            float r2 = r2.getDefault()
            float r4 = r12.getBrightness()
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x006e
            editor.gpu.gpuvideo.egl.filter.GlVideoBrightnessFilter r2 = new editor.gpu.gpuvideo.egl.filter.GlVideoBrightnessFilter
            r2.<init>()
            float r4 = r12.getBrightness()
            r2.setBrightness(r4)
            r13.add(r2)
        L_0x006e:
            editor.gpu.util.VideoFilterRange r2 = editor.gpu.util.VideoFilterRange.INSTANCE
            editor.gpu.util.FloatRange r2 = r2.getCONTRAST()
            float r2 = r2.getDefault()
            float r4 = r12.getContrast()
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x008f
            editor.gpu.gpuvideo.egl.filter.GlVideoContrastFilter r2 = new editor.gpu.gpuvideo.egl.filter.GlVideoContrastFilter
            r2.<init>()
            float r4 = r12.getContrast()
            r2.setContrast(r4)
            r13.add(r2)
        L_0x008f:
            editor.gpu.util.VideoFilterRange r2 = editor.gpu.util.VideoFilterRange.INSTANCE
            editor.gpu.util.FloatRange r2 = r2.getSATURATION()
            float r2 = r2.getDefault()
            float r4 = r12.getSaturation()
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x00b0
            editor.gpu.gpuvideo.egl.filter.GlVideoSaturationFilter r2 = new editor.gpu.gpuvideo.egl.filter.GlVideoSaturationFilter
            r2.<init>()
            float r4 = r12.getSaturation()
            r2.setSaturation(r4)
            r13.add(r2)
        L_0x00b0:
            editor.gpu.util.VideoFilterRange r2 = editor.gpu.util.VideoFilterRange.INSTANCE
            editor.gpu.util.FloatRange r2 = r2.getPIXELATION()
            float r2 = r2.getDefault()
            float r4 = r12.getPixelation()
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x00d1
            editor.gpu.gpuvideo.egl.filter.GlVideoPixelationFilter r2 = new editor.gpu.gpuvideo.egl.filter.GlVideoPixelationFilter
            r2.<init>()
            float r4 = r12.getPixelation()
            r2.setPixel(r4)
            r13.add(r2)
        L_0x00d1:
            editor.gpu.util.VideoFilterRange r2 = editor.gpu.util.VideoFilterRange.INSTANCE
            editor.gpu.util.FloatRange r2 = r2.getSHARPNESS()
            float r2 = r2.getDefault()
            float r4 = r12.getSharpness()
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x00f2
            editor.gpu.gpuvideo.egl.filter.GlVideoSharpenFilter r2 = new editor.gpu.gpuvideo.egl.filter.GlVideoSharpenFilter
            r2.<init>()
            float r4 = r12.getSharpness()
            r2.setSharpness(r4)
            r13.add(r2)
        L_0x00f2:
            boolean r2 = r13.isEmpty()
            if (r2 == 0) goto L_0x0109
            editor.gpu.command.GpuFrameworkCommandResult r13 = new editor.gpu.command.GpuFrameworkCommandResult
            r5 = 1
            r6 = 0
            java.io.File r7 = r12.getInputFile()
            r8 = 0
            r9 = 10
            r10 = 0
            r4 = r13
            r4.<init>(r5, r6, r7, r8, r9, r10)
            return r13
        L_0x0109:
            editor.gpu.gpuvideo.egl.filter.GlVideoFilterGroup r2 = new editor.gpu.gpuvideo.egl.filter.GlVideoFilterGroup
            java.util.Collection r13 = (java.util.Collection) r13
            r2.<init>((java.util.Collection<editor.gpu.gpuvideo.egl.filter.GlVideoFilter>) r13)
            r13 = r2
            editor.gpu.gpuvideo.egl.filter.GlVideoFilter r13 = (editor.gpu.gpuvideo.egl.filter.GlVideoFilter) r13
        L_0x0113:
            editor.gpu.gpuvideo.composer.GPUMp4Composer r2 = new editor.gpu.gpuvideo.composer.GPUMp4Composer
            java.io.File r4 = r12.getInputFile()
            java.lang.String r4 = r4.getAbsolutePath()
            java.io.File r5 = r12.getOutputFile()
            java.lang.String r5 = r5.getAbsolutePath()
            r2.<init>(r4, r5)
            r2.filter(r13)
            r0.L$0 = r12
            r0.label = r3
            java.lang.Object r13 = r11.executeInternal(r2, r0)
            if (r13 != r1) goto L_0x0136
            return r1
        L_0x0136:
            editor.gpu.command.GpuCommandResult r13 = (editor.gpu.command.GpuCommandResult) r13
            boolean r0 = r13 instanceof editor.gpu.command.GpuCommandResult.Success
            if (r0 == 0) goto L_0x014d
            editor.gpu.command.GpuFrameworkCommandResult r13 = new editor.gpu.command.GpuFrameworkCommandResult
            r2 = 1
            r3 = 0
            java.io.File r4 = r12.getOutputFile()
            r5 = 0
            r6 = 10
            r7 = 0
            r1 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7)
            goto L_0x0164
        L_0x014d:
            boolean r12 = r13 instanceof editor.gpu.command.GpuCommandResult.Failure
            if (r12 == 0) goto L_0x0165
            editor.gpu.command.GpuFrameworkCommandResult r12 = new editor.gpu.command.GpuFrameworkCommandResult
            r1 = 0
            editor.gpu.command.GpuCommandResult$Failure r13 = (editor.gpu.command.GpuCommandResult.Failure) r13
            java.lang.String r2 = r13.getError()
            r3 = 0
            r4 = 0
            r5 = 12
            r6 = 0
            r0 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r13 = r12
        L_0x0164:
            return r13
        L_0x0165:
            kotlin.NoWhenBranchMatchedException r12 = new kotlin.NoWhenBranchMatchedException
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.gpu.command.GpuVideoCommandExecutor.execute(editor.gpu.command.GpuVideoCommand, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object executeInternal(GPUMp4Composer gPUMp4Composer, Continuation<? super GpuCommandResult> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        gPUMp4Composer.listener(new C4741x3243d386(safeContinuation, this, gPUMp4Composer));
        gPUMp4Composer.start();
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
