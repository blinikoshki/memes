package editor.gpu.gpuvideo.capture;

import android.opengl.EGLContext;
import android.opengl.Matrix;
import android.util.Log;
import editor.gpu.gpuvideo.egl.GlFramebufferObject;
import editor.gpu.gpuvideo.egl.GlPreview;
import editor.gpu.gpuvideo.egl.filter.GlVideoFilter;

public class EncodeRenderHandler implements Runnable {
    private static final String TAG = "GPUCameraRecorder";
    private float[] MVPMatrix;
    private float[] STMatrix;
    private final float XMatrixScale;
    private final float YMatrixScale;
    private float aspectRatio;
    private EglWrapper egl;
    private final float fileHeight;
    private final float fileWidth;
    private GlFramebufferObject filterFramebufferObject;
    private GlFramebufferObject framebufferObject;
    private GlVideoFilter glFilter;
    private EglSurface inputSurface;
    private boolean isRecordable;
    private GlVideoFilter normalFilter;
    private GlPreview previewShader;
    private final boolean recordNoFilter;
    private int requestDraw;
    private boolean requestRelease;
    private boolean requestSetEglContext;
    private EGLContext sharedContext;
    private Object surface;
    private final Object sync = new Object();
    private int texId;

    /* JADX WARNING: Can't wrap try/catch for region: R(8:2|3|(1:5)(1:6)|7|8|9|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0053 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static editor.gpu.gpuvideo.capture.EncodeRenderHandler createHandler(java.lang.String r12, boolean r13, boolean r14, float r15, float r16, float r17, boolean r18, editor.gpu.gpuvideo.egl.filter.GlVideoFilter r19) {
        /*
            java.lang.String r0 = "GPUCameraRecorder"
            java.lang.String r1 = "createHandler:"
            android.util.Log.v(r0, r1)
            java.lang.String r0 = "GPUCameraRecorder"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "fileAspect:"
            r1.append(r2)
            float r6 = r17 / r16
            r1.append(r6)
            java.lang.String r2 = " viewAcpect: "
            r1.append(r2)
            r2 = r15
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
            editor.gpu.gpuvideo.capture.EncodeRenderHandler r0 = new editor.gpu.gpuvideo.capture.EncodeRenderHandler
            r3 = r0
            r4 = r13
            r5 = r14
            r7 = r15
            r8 = r16
            r9 = r17
            r10 = r18
            r11 = r19
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            java.lang.Object r1 = r0.sync
            monitor-enter(r1)
            java.lang.Thread r2 = new java.lang.Thread     // Catch:{ all -> 0x0055 }
            boolean r3 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0055 }
            if (r3 != 0) goto L_0x0046
            r3 = r12
            goto L_0x0048
        L_0x0046:
            java.lang.String r3 = "GPUCameraRecorder"
        L_0x0048:
            r2.<init>(r0, r3)     // Catch:{ all -> 0x0055 }
            r2.start()     // Catch:{ all -> 0x0055 }
            java.lang.Object r2 = r0.sync     // Catch:{ InterruptedException -> 0x0053 }
            r2.wait()     // Catch:{ InterruptedException -> 0x0053 }
        L_0x0053:
            monitor-exit(r1)     // Catch:{ all -> 0x0055 }
            return r0
        L_0x0055:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0055 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.gpu.gpuvideo.capture.EncodeRenderHandler.createHandler(java.lang.String, boolean, boolean, float, float, float, boolean, editor.gpu.gpuvideo.egl.filter.GlVideoFilter):editor.gpu.gpuvideo.capture.EncodeRenderHandler");
    }

    private EncodeRenderHandler(boolean z, boolean z2, float f, float f2, float f3, float f4, boolean z3, GlVideoFilter glVideoFilter) {
        int i = -1;
        this.texId = -1;
        this.MVPMatrix = new float[16];
        this.STMatrix = new float[16];
        float f5 = 1.0f;
        this.aspectRatio = 1.0f;
        this.fileWidth = f3;
        this.fileHeight = f4;
        this.recordNoFilter = z3;
        this.glFilter = glVideoFilter;
        if (f == f2) {
            this.XMatrixScale = (float) (!z2 ? 1 : i);
            this.YMatrixScale = z ? -1.0f : f5;
        } else if (f < f2) {
            this.XMatrixScale = (float) (z2 ? -1 : 1);
            float f6 = ((float) (!z ? 1 : i)) * (f2 / f);
            this.YMatrixScale = f6;
            Log.v(TAG, "cameraAspect: " + f2 + " YMatrixScale :" + f6);
        } else {
            float f7 = ((float) (z2 ? -1 : 1)) * (f / f2);
            this.XMatrixScale = f7;
            float f8 = (float) (!z ? 1 : i);
            this.YMatrixScale = f8;
            Log.v(TAG, "cameraAspect: " + f2 + " YMatrixScale :" + f8 + " XMatrixScale :" + f7);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:15|16|17|18|19|20) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0049 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setEglContext(android.opengl.EGLContext r3, int r4, java.lang.Object r5) {
        /*
            r2 = this;
            java.lang.String r0 = "GPUCameraRecorder"
            java.lang.String r1 = "setEglContext:"
            android.util.Log.i(r0, r1)
            boolean r0 = r5 instanceof android.view.Surface
            if (r0 != 0) goto L_0x002b
            boolean r0 = r5 instanceof android.graphics.SurfaceTexture
            if (r0 != 0) goto L_0x002b
            boolean r0 = r5 instanceof android.view.SurfaceHolder
            if (r0 == 0) goto L_0x0014
            goto L_0x002b
        L_0x0014:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "unsupported window type:"
            r4.append(r0)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L_0x002b:
            java.lang.Object r0 = r2.sync
            monitor-enter(r0)
            boolean r1 = r2.requestRelease     // Catch:{ all -> 0x004b }
            if (r1 == 0) goto L_0x0034
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            return
        L_0x0034:
            r2.sharedContext = r3     // Catch:{ all -> 0x004b }
            r2.texId = r4     // Catch:{ all -> 0x004b }
            r2.surface = r5     // Catch:{ all -> 0x004b }
            r3 = 1
            r2.isRecordable = r3     // Catch:{ all -> 0x004b }
            r2.requestSetEglContext = r3     // Catch:{ all -> 0x004b }
            java.lang.Object r3 = r2.sync     // Catch:{ all -> 0x004b }
            r3.notifyAll()     // Catch:{ all -> 0x004b }
            java.lang.Object r3 = r2.sync     // Catch:{ InterruptedException -> 0x0049 }
            r3.wait()     // Catch:{ InterruptedException -> 0x0049 }
        L_0x0049:
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            return
        L_0x004b:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.gpu.gpuvideo.capture.EncodeRenderHandler.setEglContext(android.opengl.EGLContext, int, java.lang.Object):void");
    }

    /* access modifiers changed from: package-private */
    public final void prepareDraw() {
        synchronized (this.sync) {
            if (!this.requestRelease) {
                this.requestDraw++;
                this.sync.notifyAll();
            }
        }
    }

    public final void draw(int i, float[] fArr, float[] fArr2, float f) {
        synchronized (this.sync) {
            if (!this.requestRelease) {
                this.texId = i;
                System.arraycopy(fArr, 0, this.STMatrix, 0, 16);
                System.arraycopy(fArr2, 0, this.MVPMatrix, 0, 16);
                Matrix.scaleM(this.MVPMatrix, 0, this.XMatrixScale, this.YMatrixScale, 1.0f);
                this.aspectRatio = f;
                this.requestDraw++;
                this.sync.notifyAll();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void release() {
        /*
            r2 = this;
            java.lang.String r0 = "GPUCameraRecorder"
            java.lang.String r1 = "release:"
            android.util.Log.i(r0, r1)
            java.lang.Object r0 = r2.sync
            monitor-enter(r0)
            boolean r1 = r2.requestRelease     // Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x0010
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x0010:
            r1 = 1
            r2.requestRelease = r1     // Catch:{ all -> 0x001f }
            java.lang.Object r1 = r2.sync     // Catch:{ all -> 0x001f }
            r1.notifyAll()     // Catch:{ all -> 0x001f }
            java.lang.Object r1 = r2.sync     // Catch:{ InterruptedException -> 0x001d }
            r1.wait()     // Catch:{ InterruptedException -> 0x001d }
        L_0x001d:
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x001f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.gpu.gpuvideo.capture.EncodeRenderHandler.release():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0039, code lost:
        if (r4 == false) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003d, code lost:
        if (r6.egl == null) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0041, code lost:
        if (r6.texId < 0) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0043, code lost:
        r6.inputSurface.makeCurrent();
        android.opengl.GLES20.glClear(16384);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0051, code lost:
        if (isRecordFilter() == false) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0053, code lost:
        r6.framebufferObject.enable();
        r6.filterFramebufferObject.enable();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005d, code lost:
        r6.previewShader.draw(r6.texId, r6.MVPMatrix, r6.STMatrix, r6.aspectRatio);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006e, code lost:
        if (isRecordFilter() == false) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0070, code lost:
        r6.framebufferObject.enable();
        r6.glFilter.draw(r6.filterFramebufferObject.getTexName(), r6.framebufferObject);
        android.opengl.GLES20.glBindFramebuffer(36160, 0);
        android.opengl.GLES20.glViewport(0, 0, r6.framebufferObject.getWidth(), r6.framebufferObject.getHeight());
        android.opengl.GLES20.glClear(16640);
        r6.normalFilter.draw(r6.framebufferObject.getTexName(), (editor.gpu.gpuvideo.egl.GlFramebufferObject) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a8, code lost:
        r6.inputSurface.swap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00af, code lost:
        r0 = r6.sync;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b1, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r6.sync.wait();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ba, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00d7, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r6 = this;
            java.lang.String r0 = "GPUCameraRecorder"
            java.lang.String r1 = "EncodeRenderHandler thread started:"
            android.util.Log.i(r0, r1)
            java.lang.Object r0 = r6.sync
            monitor-enter(r0)
            r1 = 0
            r6.requestRelease = r1     // Catch:{ all -> 0x00db }
            r6.requestSetEglContext = r1     // Catch:{ all -> 0x00db }
            r6.requestDraw = r1     // Catch:{ all -> 0x00db }
            java.lang.Object r2 = r6.sync     // Catch:{ all -> 0x00db }
            r2.notifyAll()     // Catch:{ all -> 0x00db }
            monitor-exit(r0)     // Catch:{ all -> 0x00db }
        L_0x0017:
            java.lang.Object r2 = r6.sync
            monitor-enter(r2)
            boolean r0 = r6.requestRelease     // Catch:{ all -> 0x00d8 }
            r3 = 1
            if (r0 == 0) goto L_0x0022
            monitor-exit(r2)     // Catch:{ all -> 0x00d8 }
            goto L_0x00bd
        L_0x0022:
            boolean r0 = r6.requestSetEglContext     // Catch:{ all -> 0x00d8 }
            if (r0 == 0) goto L_0x002b
            r6.requestSetEglContext = r1     // Catch:{ all -> 0x00d8 }
            r6.internalPrepare()     // Catch:{ all -> 0x00d8 }
        L_0x002b:
            int r0 = r6.requestDraw     // Catch:{ all -> 0x00d8 }
            if (r0 <= 0) goto L_0x0031
            r4 = 1
            goto L_0x0032
        L_0x0031:
            r4 = 0
        L_0x0032:
            if (r4 == 0) goto L_0x0038
            int r0 = r0 + -1
            r6.requestDraw = r0     // Catch:{ all -> 0x00d8 }
        L_0x0038:
            monitor-exit(r2)     // Catch:{ all -> 0x00d8 }
            if (r4 == 0) goto L_0x00af
            editor.gpu.gpuvideo.capture.EglWrapper r0 = r6.egl
            if (r0 == 0) goto L_0x0017
            int r0 = r6.texId
            if (r0 < 0) goto L_0x0017
            editor.gpu.gpuvideo.capture.EglSurface r0 = r6.inputSurface
            r0.makeCurrent()
            r0 = 16384(0x4000, float:2.2959E-41)
            android.opengl.GLES20.glClear(r0)
            boolean r0 = r6.isRecordFilter()
            if (r0 == 0) goto L_0x005d
            editor.gpu.gpuvideo.egl.GlFramebufferObject r0 = r6.framebufferObject
            r0.enable()
            editor.gpu.gpuvideo.egl.GlFramebufferObject r0 = r6.filterFramebufferObject
            r0.enable()
        L_0x005d:
            editor.gpu.gpuvideo.egl.GlPreview r0 = r6.previewShader
            int r2 = r6.texId
            float[] r3 = r6.MVPMatrix
            float[] r4 = r6.STMatrix
            float r5 = r6.aspectRatio
            r0.draw(r2, r3, r4, r5)
            boolean r0 = r6.isRecordFilter()
            if (r0 == 0) goto L_0x00a8
            editor.gpu.gpuvideo.egl.GlFramebufferObject r0 = r6.framebufferObject
            r0.enable()
            editor.gpu.gpuvideo.egl.filter.GlVideoFilter r0 = r6.glFilter
            editor.gpu.gpuvideo.egl.GlFramebufferObject r2 = r6.filterFramebufferObject
            int r2 = r2.getTexName()
            editor.gpu.gpuvideo.egl.GlFramebufferObject r3 = r6.framebufferObject
            r0.draw(r2, r3)
            r0 = 36160(0x8d40, float:5.0671E-41)
            android.opengl.GLES20.glBindFramebuffer(r0, r1)
            editor.gpu.gpuvideo.egl.GlFramebufferObject r0 = r6.framebufferObject
            int r0 = r0.getWidth()
            editor.gpu.gpuvideo.egl.GlFramebufferObject r2 = r6.framebufferObject
            int r2 = r2.getHeight()
            android.opengl.GLES20.glViewport(r1, r1, r0, r2)
            r0 = 16640(0x4100, float:2.3318E-41)
            android.opengl.GLES20.glClear(r0)
            editor.gpu.gpuvideo.egl.filter.GlVideoFilter r0 = r6.normalFilter
            editor.gpu.gpuvideo.egl.GlFramebufferObject r2 = r6.framebufferObject
            int r2 = r2.getTexName()
            r3 = 0
            r0.draw(r2, r3)
        L_0x00a8:
            editor.gpu.gpuvideo.capture.EglSurface r0 = r6.inputSurface
            r0.swap()
            goto L_0x0017
        L_0x00af:
            java.lang.Object r0 = r6.sync
            monitor-enter(r0)
            java.lang.Object r2 = r6.sync     // Catch:{ InterruptedException -> 0x00bc }
            r2.wait()     // Catch:{ InterruptedException -> 0x00bc }
            monitor-exit(r0)     // Catch:{ all -> 0x00ba }
            goto L_0x0017
        L_0x00ba:
            r1 = move-exception
            goto L_0x00d6
        L_0x00bc:
            monitor-exit(r0)     // Catch:{ all -> 0x00ba }
        L_0x00bd:
            java.lang.Object r1 = r6.sync
            monitor-enter(r1)
            r6.requestRelease = r3     // Catch:{ all -> 0x00d3 }
            r6.internalRelease()     // Catch:{ all -> 0x00d3 }
            java.lang.Object r0 = r6.sync     // Catch:{ all -> 0x00d3 }
            r0.notifyAll()     // Catch:{ all -> 0x00d3 }
            monitor-exit(r1)     // Catch:{ all -> 0x00d3 }
            java.lang.String r0 = "GPUCameraRecorder"
            java.lang.String r1 = "EncodeRenderHandler thread finished:"
            android.util.Log.i(r0, r1)
            return
        L_0x00d3:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00d3 }
            throw r0
        L_0x00d6:
            monitor-exit(r0)     // Catch:{ all -> 0x00ba }
            throw r1
        L_0x00d8:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00d8 }
            throw r0
        L_0x00db:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00db }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.gpu.gpuvideo.capture.EncodeRenderHandler.run():void");
    }

    private void internalPrepare() {
        Log.i(TAG, "internalPrepare:");
        internalRelease();
        EglWrapper eglWrapper = new EglWrapper(this.sharedContext, false, this.isRecordable);
        this.egl = eglWrapper;
        EglSurface createFromSurface = eglWrapper.createFromSurface(this.surface);
        this.inputSurface = createFromSurface;
        createFromSurface.makeCurrent();
        GlPreview glPreview = new GlPreview(36197);
        this.previewShader = glPreview;
        glPreview.setup();
        if (isRecordFilter()) {
            GlFramebufferObject glFramebufferObject = new GlFramebufferObject();
            this.framebufferObject = glFramebufferObject;
            glFramebufferObject.setup((int) this.fileWidth, (int) this.fileHeight);
            GlFramebufferObject glFramebufferObject2 = new GlFramebufferObject();
            this.filterFramebufferObject = glFramebufferObject2;
            glFramebufferObject2.setup((int) this.fileWidth, (int) this.fileHeight);
            GlVideoFilter glVideoFilter = new GlVideoFilter();
            this.normalFilter = glVideoFilter;
            glVideoFilter.setup();
        }
        this.surface = null;
        this.sync.notifyAll();
    }

    private void internalRelease() {
        Log.i(TAG, "internalRelease:");
        EglSurface eglSurface = this.inputSurface;
        if (eglSurface != null) {
            eglSurface.release();
            this.inputSurface = null;
        }
        EglWrapper eglWrapper = this.egl;
        if (eglWrapper != null) {
            eglWrapper.release();
            this.egl = null;
        }
        GlVideoFilter glVideoFilter = this.normalFilter;
        if (glVideoFilter != null) {
            glVideoFilter.release();
            this.normalFilter = null;
        }
        GlFramebufferObject glFramebufferObject = this.filterFramebufferObject;
        if (glFramebufferObject != null) {
            glFramebufferObject.release();
            this.filterFramebufferObject = null;
        }
        GlFramebufferObject glFramebufferObject2 = this.framebufferObject;
        if (glFramebufferObject2 != null) {
            glFramebufferObject2.release();
            this.framebufferObject = null;
        }
    }

    private boolean isRecordFilter() {
        return this.glFilter != null && !this.recordNoFilter;
    }
}
