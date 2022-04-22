package editor.gpu.command;

import editor.gpu.command.GpuCommandResult;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\"\u0010\u0007\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003¨\u0006\u0010"}, mo26107d2 = {"Leditor/gpu/command/GpuImageCommandExecutor;", "", "()V", "execute", "Leditor/gpu/command/GpuFrameworkCommandResult;", "command", "Leditor/gpu/command/GpuImageCommand;", "executeInternal", "Leditor/gpu/command/GpuCommandResult;", "inputBitmap", "Landroid/graphics/Bitmap;", "outputFile", "Ljava/io/File;", "inputFile", "filterGroup", "Leditor/gpu/gpuimage/filter/GlPhotoFilterGroup;", "gputool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GpuImageCommandExecutor.kt */
public final class GpuImageCommandExecutor {
    public final GpuFrameworkCommandResult execute(GpuImageCommand gpuImageCommand) {
        Intrinsics.checkNotNullParameter(gpuImageCommand, "command");
        GpuCommandResult executeInternal = executeInternal(gpuImageCommand.getInputBitmap(), gpuImageCommand.getOutputFile());
        if (executeInternal instanceof GpuCommandResult.Success) {
            return new GpuFrameworkCommandResult(true, (String) null, gpuImageCommand.getOutputFile(), (Exception) null, 10, (DefaultConstructorMarker) null);
        }
        if (executeInternal instanceof GpuCommandResult.Failure) {
            return new GpuFrameworkCommandResult(false, ((GpuCommandResult.Failure) executeInternal).getError(), (File) null, (Exception) null, 12, (DefaultConstructorMarker) null);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        kotlin.p017io.CloseableKt.closeFinally(r0, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        throw r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final editor.gpu.command.GpuCommandResult executeInternal(android.graphics.Bitmap r5, java.io.File r6) {
        /*
            r4 = this;
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0032 }
            r0.<init>(r6)     // Catch:{ IOException -> 0x0032 }
            java.io.Closeable r0 = (java.io.Closeable) r0     // Catch:{ IOException -> 0x0032 }
            r6 = 0
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ IOException -> 0x0032 }
            r1 = r0
            java.io.FileOutputStream r1 = (java.io.FileOutputStream) r1     // Catch:{ all -> 0x002b }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ all -> 0x002b }
            r3 = 100
            java.io.OutputStream r1 = (java.io.OutputStream) r1     // Catch:{ all -> 0x002b }
            boolean r5 = r5.compress(r2, r3, r1)     // Catch:{ all -> 0x002b }
            if (r5 == 0) goto L_0x001e
            editor.gpu.command.GpuCommandResult$Success r5 = editor.gpu.command.GpuCommandResult.Success.INSTANCE     // Catch:{ all -> 0x002b }
            editor.gpu.command.GpuCommandResult r5 = (editor.gpu.command.GpuCommandResult) r5     // Catch:{ all -> 0x002b }
            goto L_0x0027
        L_0x001e:
            editor.gpu.command.GpuCommandResult$Failure r5 = new editor.gpu.command.GpuCommandResult$Failure     // Catch:{ all -> 0x002b }
            java.lang.String r1 = "Bitmap compression failed."
            r5.<init>(r1)     // Catch:{ all -> 0x002b }
            editor.gpu.command.GpuCommandResult r5 = (editor.gpu.command.GpuCommandResult) r5     // Catch:{ all -> 0x002b }
        L_0x0027:
            kotlin.p017io.CloseableKt.closeFinally(r0, r6)     // Catch:{ IOException -> 0x0032 }
            return r5
        L_0x002b:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x002d }
        L_0x002d:
            r6 = move-exception
            kotlin.p017io.CloseableKt.closeFinally(r0, r5)     // Catch:{ IOException -> 0x0032 }
            throw r6     // Catch:{ IOException -> 0x0032 }
        L_0x0032:
            r5 = move-exception
            r5.printStackTrace()
            editor.gpu.command.GpuCommandResult$Failure r6 = new editor.gpu.command.GpuCommandResult$Failure
            java.lang.String r5 = r5.getMessage()
            if (r5 == 0) goto L_0x003f
            goto L_0x0041
        L_0x003f:
            java.lang.String r5 = "IOException when writing bitmap to file."
        L_0x0041:
            r6.<init>(r5)
            editor.gpu.command.GpuCommandResult r6 = (editor.gpu.command.GpuCommandResult) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.gpu.command.GpuImageCommandExecutor.executeInternal(android.graphics.Bitmap, java.io.File):editor.gpu.command.GpuCommandResult");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0082, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        kotlin.p017io.CloseableKt.closeFinally(r9, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0086, code lost:
        throw r0;
     */
    @kotlin.Deprecated(message = "doesn't work reliably")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.io.File executeInternal(java.io.File r7, java.io.File r8, editor.gpu.gpuimage.filter.GlPhotoFilterGroup r9) {
        /*
            r6 = this;
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            r1 = 0
            r2 = r1
            android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
            r0.element = r2
            editor.gpu.command.GpuImageCommandExecutor$executeInternal$callback$1 r2 = new editor.gpu.command.GpuImageCommandExecutor$executeInternal$callback$1
            r2.<init>(r0)
            editor.gpu.gpuimage.GPUImage$ResponseListener r2 = (editor.gpu.gpuimage.GPUImage.ResponseListener) r2
            r3 = 0
            java.lang.Object[] r4 = new java.lang.Object[r3]
            java.lang.String r5 = "Starting to decode bitmap file"
            timber.log.Timber.m300d(r5, r4)
            java.lang.String r7 = r7.getAbsolutePath()
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeFile(r7)
            java.lang.Object[] r4 = new java.lang.Object[r3]
            java.lang.String r5 = "Starting to apply all filters"
            timber.log.Timber.m300d(r5, r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.List r4 = (java.util.List) r4
            r4.add(r9)
            editor.gpu.gpuimage.GPUImage.getBitmapForMultipleFilters(r7, r4, r2)
            java.lang.Object[] r7 = new java.lang.Object[r3]
            java.lang.String r9 = "Applied all filters"
            timber.log.Timber.m300d(r9, r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = "LatestBitmap = available("
            r7.append(r9)
            T r9 = r0.element
            android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
            if (r9 == 0) goto L_0x004f
            r9 = 1
            goto L_0x0050
        L_0x004f:
            r9 = 0
        L_0x0050:
            r7.append(r9)
            r9 = 41
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r9 = new java.lang.Object[r3]
            timber.log.Timber.m300d(r7, r9)
            T r7 = r0.element
            android.graphics.Bitmap r7 = (android.graphics.Bitmap) r7
            if (r7 == 0) goto L_0x008b
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0087 }
            r9.<init>(r8)     // Catch:{ IOException -> 0x0087 }
            java.io.Closeable r9 = (java.io.Closeable) r9     // Catch:{ IOException -> 0x0087 }
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ IOException -> 0x0087 }
            r0 = r9
            java.io.FileOutputStream r0 = (java.io.FileOutputStream) r0     // Catch:{ all -> 0x0080 }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ all -> 0x0080 }
            r3 = 100
            java.io.OutputStream r0 = (java.io.OutputStream) r0     // Catch:{ all -> 0x0080 }
            r7.compress(r2, r3, r0)     // Catch:{ all -> 0x0080 }
            kotlin.p017io.CloseableKt.closeFinally(r9, r1)     // Catch:{ IOException -> 0x0087 }
            goto L_0x008b
        L_0x0080:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0082 }
        L_0x0082:
            r0 = move-exception
            kotlin.p017io.CloseableKt.closeFinally(r9, r7)     // Catch:{ IOException -> 0x0087 }
            throw r0     // Catch:{ IOException -> 0x0087 }
        L_0x0087:
            r7 = move-exception
            r7.printStackTrace()
        L_0x008b:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.gpu.command.GpuImageCommandExecutor.executeInternal(java.io.File, java.io.File, editor.gpu.gpuimage.filter.GlPhotoFilterGroup):java.io.File");
    }
}
