package editor.gpu.gpuvideo.composer;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Size;
import android.view.Surface;
import androidx.work.WorkRequest;
import editor.gpu.gpuvideo.egl.EglUtil;
import editor.gpu.gpuvideo.egl.GlFramebufferObject;
import editor.gpu.gpuvideo.egl.GlPreviewFilter;
import editor.gpu.gpuvideo.egl.GlSurfaceTexture;
import editor.gpu.gpuvideo.egl.filter.GlVideoFilter;

class DecoderSurface implements SurfaceTexture.OnFrameAvailableListener {
    private static final String TAG = "DecoderSurface";
    private static final boolean VERBOSE = false;
    private float[] MMatrix = new float[16];
    private float[] MVPMatrix = new float[16];
    private float[] ProjMatrix = new float[16];
    private float[] STMatrix = new float[16];
    private float[] VMatrix = new float[16];
    private EGLContext eglContext = EGL14.EGL_NO_CONTEXT;
    private EGLDisplay eglDisplay = EGL14.EGL_NO_DISPLAY;
    private EGLSurface eglSurface = EGL14.EGL_NO_SURFACE;
    private FillMode fillMode = FillMode.PRESERVE_ASPECT_FIT;
    private FillModeCustomItem fillModeCustomItem;
    private GlVideoFilter filter;
    private GlFramebufferObject filterFramebufferObject;
    private boolean flipHorizontal = false;
    private boolean flipVertical = false;
    private boolean frameAvailable;
    private Object frameSyncObject = new Object();
    private GlFramebufferObject framebufferObject;
    private Size inputResolution;
    private GlVideoFilter normalShader;
    private Size outputResolution;
    private GlPreviewFilter previewShader;
    private GlSurfaceTexture previewTexture;
    private Rotation rotation = Rotation.NORMAL;
    private Surface surface;
    private int texName;

    DecoderSurface(GlVideoFilter glVideoFilter) {
        this.filter = glVideoFilter;
        setup();
    }

    private void setup() {
        this.filter.setup();
        this.framebufferObject = new GlFramebufferObject();
        GlVideoFilter glVideoFilter = new GlVideoFilter();
        this.normalShader = glVideoFilter;
        glVideoFilter.setup();
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i = iArr[0];
        this.texName = i;
        GlSurfaceTexture glSurfaceTexture = new GlSurfaceTexture(i);
        this.previewTexture = glSurfaceTexture;
        glSurfaceTexture.setOnFrameAvailableListener(this);
        this.surface = new Surface(this.previewTexture.getSurfaceTexture());
        GLES20.glBindTexture(this.previewTexture.getTextureTarget(), this.texName);
        EglUtil.setupSampler(this.previewTexture.getTextureTarget(), 9729, 9728);
        GLES20.glBindTexture(3553, 0);
        GlPreviewFilter glPreviewFilter = new GlPreviewFilter(this.previewTexture.getTextureTarget());
        this.previewShader = glPreviewFilter;
        glPreviewFilter.setup();
        this.filterFramebufferObject = new GlFramebufferObject();
        Matrix.setLookAtM(this.VMatrix, 0, 0.0f, 0.0f, 5.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        GLES20.glGetIntegerv(3379, iArr, 0);
    }

    /* access modifiers changed from: package-private */
    public void release() {
        if (this.eglDisplay != EGL14.EGL_NO_DISPLAY) {
            EGL14.eglDestroySurface(this.eglDisplay, this.eglSurface);
            EGL14.eglDestroyContext(this.eglDisplay, this.eglContext);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.eglDisplay);
        }
        this.surface.release();
        this.previewTexture.release();
        this.eglDisplay = EGL14.EGL_NO_DISPLAY;
        this.eglContext = EGL14.EGL_NO_CONTEXT;
        this.eglSurface = EGL14.EGL_NO_SURFACE;
        this.filter.release();
        this.filter = null;
        this.surface = null;
        this.previewTexture = null;
    }

    /* access modifiers changed from: package-private */
    public Surface getSurface() {
        return this.surface;
    }

    /* access modifiers changed from: package-private */
    public void awaitNewImage() {
        synchronized (this.frameSyncObject) {
            while (!this.frameAvailable) {
                try {
                    this.frameSyncObject.wait(WorkRequest.MIN_BACKOFF_MILLIS);
                    if (!this.frameAvailable) {
                        throw new RuntimeException("Surface frame wait timed out");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            this.frameAvailable = false;
        }
        this.previewTexture.updateTexImage();
        this.previewTexture.getTransformMatrix(this.STMatrix);
    }

    /* access modifiers changed from: package-private */
    public void drawImage() {
        FillModeCustomItem fillModeCustomItem2;
        this.framebufferObject.enable();
        GLES20.glViewport(0, 0, this.framebufferObject.getWidth(), this.framebufferObject.getHeight());
        if (this.filter != null) {
            this.filterFramebufferObject.enable();
            GLES20.glViewport(0, 0, this.filterFramebufferObject.getWidth(), this.filterFramebufferObject.getHeight());
        }
        GLES20.glClear(16384);
        Matrix.multiplyMM(this.MVPMatrix, 0, this.VMatrix, 0, this.MMatrix, 0);
        float[] fArr = this.MVPMatrix;
        Matrix.multiplyMM(fArr, 0, this.ProjMatrix, 0, fArr, 0);
        float f = -1.0f;
        float f2 = this.flipHorizontal ? -1.0f : 1.0f;
        if (!this.flipVertical) {
            f = 1.0f;
        }
        int i = C47771.$SwitchMap$editor$gpu$gpuvideo$composer$FillMode[this.fillMode.ordinal()];
        if (i == 1) {
            float[] scaleAspectFit = FillMode.getScaleAspectFit(this.rotation.getRotation(), this.inputResolution.getWidth(), this.inputResolution.getHeight(), this.outputResolution.getWidth(), this.outputResolution.getHeight());
            Matrix.scaleM(this.MVPMatrix, 0, scaleAspectFit[0] * f2, scaleAspectFit[1] * f, 1.0f);
            if (this.rotation != Rotation.NORMAL) {
                Matrix.rotateM(this.MVPMatrix, 0, (float) (-this.rotation.getRotation()), 0.0f, 0.0f, 1.0f);
            }
        } else if (i == 2) {
            float[] scaleAspectCrop = FillMode.getScaleAspectCrop(this.rotation.getRotation(), this.inputResolution.getWidth(), this.inputResolution.getHeight(), this.outputResolution.getWidth(), this.outputResolution.getHeight());
            Matrix.scaleM(this.MVPMatrix, 0, scaleAspectCrop[0] * f2, scaleAspectCrop[1] * f, 1.0f);
            if (this.rotation != Rotation.NORMAL) {
                Matrix.rotateM(this.MVPMatrix, 0, (float) (-this.rotation.getRotation()), 0.0f, 0.0f, 1.0f);
            }
        } else if (i == 3 && (fillModeCustomItem2 = this.fillModeCustomItem) != null) {
            Matrix.translateM(this.MVPMatrix, 0, fillModeCustomItem2.getTranslateX(), -this.fillModeCustomItem.getTranslateY(), 0.0f);
            float[] scaleAspectCrop2 = FillMode.getScaleAspectCrop(this.rotation.getRotation(), this.inputResolution.getWidth(), this.inputResolution.getHeight(), this.outputResolution.getWidth(), this.outputResolution.getHeight());
            if (this.fillModeCustomItem.getRotate() == 0.0f || this.fillModeCustomItem.getRotate() == 180.0f) {
                Matrix.scaleM(this.MVPMatrix, 0, this.fillModeCustomItem.getScale() * scaleAspectCrop2[0] * f2, this.fillModeCustomItem.getScale() * scaleAspectCrop2[1] * f, 1.0f);
            } else {
                Matrix.scaleM(this.MVPMatrix, 0, this.fillModeCustomItem.getScale() * scaleAspectCrop2[0] * (1.0f / this.fillModeCustomItem.getVideoWidth()) * this.fillModeCustomItem.getVideoHeight() * f2, this.fillModeCustomItem.getScale() * scaleAspectCrop2[1] * (this.fillModeCustomItem.getVideoWidth() / this.fillModeCustomItem.getVideoHeight()) * f, 1.0f);
            }
            Matrix.rotateM(this.MVPMatrix, 0, -(((float) this.rotation.getRotation()) + this.fillModeCustomItem.getRotate()), 0.0f, 0.0f, 1.0f);
        }
        this.previewShader.draw(this.texName, this.MVPMatrix, this.STMatrix, 1.0f);
        if (this.filter != null) {
            this.framebufferObject.enable();
            GLES20.glClear(16384);
            this.filter.draw(this.filterFramebufferObject.getTexName(), this.framebufferObject);
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, this.framebufferObject.getWidth(), this.framebufferObject.getHeight());
        GLES20.glClear(16640);
        this.normalShader.draw(this.framebufferObject.getTexName(), (GlFramebufferObject) null);
    }

    /* renamed from: editor.gpu.gpuvideo.composer.DecoderSurface$1 */
    static /* synthetic */ class C47771 {
        static final /* synthetic */ int[] $SwitchMap$editor$gpu$gpuvideo$composer$FillMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                editor.gpu.gpuvideo.composer.FillMode[] r0 = editor.gpu.gpuvideo.composer.FillMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$editor$gpu$gpuvideo$composer$FillMode = r0
                editor.gpu.gpuvideo.composer.FillMode r1 = editor.gpu.gpuvideo.composer.FillMode.PRESERVE_ASPECT_FIT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$editor$gpu$gpuvideo$composer$FillMode     // Catch:{ NoSuchFieldError -> 0x001d }
                editor.gpu.gpuvideo.composer.FillMode r1 = editor.gpu.gpuvideo.composer.FillMode.PRESERVE_ASPECT_CROP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$editor$gpu$gpuvideo$composer$FillMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                editor.gpu.gpuvideo.composer.FillMode r1 = editor.gpu.gpuvideo.composer.FillMode.CUSTOM     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: editor.gpu.gpuvideo.composer.DecoderSurface.C47771.<clinit>():void");
        }
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.frameSyncObject) {
            if (!this.frameAvailable) {
                this.frameAvailable = true;
                this.frameSyncObject.notifyAll();
            } else {
                throw new RuntimeException("frameAvailable already set, frame could be dropped");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setRotation(Rotation rotation2) {
        this.rotation = rotation2;
    }

    /* access modifiers changed from: package-private */
    public void setOutputResolution(Size size) {
        this.outputResolution = size;
    }

    /* access modifiers changed from: package-private */
    public void setFillMode(FillMode fillMode2) {
        this.fillMode = fillMode2;
    }

    /* access modifiers changed from: package-private */
    public void setInputResolution(Size size) {
        this.inputResolution = size;
    }

    /* access modifiers changed from: package-private */
    public void setFillModeCustomItem(FillModeCustomItem fillModeCustomItem2) {
        this.fillModeCustomItem = fillModeCustomItem2;
    }

    /* access modifiers changed from: package-private */
    public void setFlipVertical(boolean z) {
        this.flipVertical = z;
    }

    /* access modifiers changed from: package-private */
    public void setFlipHorizontal(boolean z) {
        this.flipHorizontal = z;
    }

    /* access modifiers changed from: package-private */
    public void completeParams() {
        int width = this.outputResolution.getWidth();
        int height = this.outputResolution.getHeight();
        this.framebufferObject.setup(width, height);
        this.normalShader.setFrameSize(width, height);
        this.filterFramebufferObject.setup(width, height);
        this.previewShader.setFrameSize(width, height);
        Matrix.frustumM(this.ProjMatrix, 0, -1.0f, 1.0f, -1.0f, 1.0f, 5.0f, 7.0f);
        Matrix.setIdentityM(this.MMatrix, 0);
        GlVideoFilter glVideoFilter = this.filter;
        if (glVideoFilter != null) {
            glVideoFilter.setFrameSize(width, height);
        }
    }
}
