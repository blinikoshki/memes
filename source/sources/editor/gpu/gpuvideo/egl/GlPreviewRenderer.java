package editor.gpu.gpuvideo.egl;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.util.Size;
import editor.gpu.gpuvideo.capture.MediaVideoEncoder;
import editor.gpu.gpuvideo.egl.filter.GlVideoFilter;
import javax.microedition.khronos.egl.EGLConfig;

public class GlPreviewRenderer extends GlFrameBufferObjectRenderer implements SurfaceTexture.OnFrameAvailableListener {
    private float[] MMatrix = new float[16];
    private float[] MVPMatrix = new float[16];
    private float[] ProjMatrix = new float[16];
    private float[] STMatrix = new float[16];
    private float[] VMatrix = new float[16];
    private int angle = 0;
    private float aspectRatio = 1.0f;
    private Size cameraResolution;
    private float drawScale = 1.0f;
    private GlFramebufferObject filterFramebufferObject;
    private float gestureScale = 1.0f;
    /* access modifiers changed from: private */
    public GlVideoFilter glFilter;
    /* access modifiers changed from: private */
    public final GLSurfaceView glView;
    private final Handler handler = new Handler();
    /* access modifiers changed from: private */
    public boolean isNewShader;
    private GlPreview previewShader;
    /* access modifiers changed from: private */
    public GlSurfaceTexture previewTexture;
    private float scaleRatio = 1.0f;
    /* access modifiers changed from: private */
    public SurfaceCreateListener surfaceCreateListener;
    /* access modifiers changed from: private */
    public int texName;
    private int updateTexImageCompare = 0;
    private int updateTexImageCounter = 0;
    /* access modifiers changed from: private */
    public MediaVideoEncoder videoEncoder;

    public interface SurfaceCreateListener {
        void onCreated(SurfaceTexture surfaceTexture);
    }

    public GlPreviewRenderer(GLSurfaceView gLSurfaceView) {
        this.glView = gLSurfaceView;
        gLSurfaceView.setEGLConfigChooser(new GlConfigChooser(false));
        gLSurfaceView.setEGLContextFactory(new GlContextFactory());
        gLSurfaceView.setRenderer(this);
        gLSurfaceView.setRenderMode(0);
        Matrix.setIdentityM(this.STMatrix, 0);
    }

    public void onStartPreview(float f, float f2, boolean z) {
        Matrix.setIdentityM(this.MMatrix, 0);
        Matrix.rotateM(this.MMatrix, 0, (float) (-this.angle), 0.0f, 0.0f, 1.0f);
        if (!z) {
            float measuredHeight = ((float) this.glView.getMeasuredHeight()) / ((float) this.glView.getMeasuredWidth());
            float f3 = f / f2;
            if (measuredHeight >= f3) {
                Matrix.scaleM(this.MMatrix, 0, 1.0f, 1.0f, 1.0f);
                return;
            }
            float f4 = (f3 / measuredHeight) * 1.0f;
            Matrix.scaleM(this.MMatrix, 0, f4, f4, 1.0f);
        } else if (this.glView.getMeasuredWidth() == this.glView.getMeasuredHeight()) {
            float max = Math.max(f / f2, f2 / f) * 1.0f;
            Matrix.scaleM(this.MMatrix, 0, max, max, 1.0f);
        } else {
            float max2 = Math.max(((float) this.glView.getMeasuredHeight()) / f, ((float) this.glView.getMeasuredWidth()) / f2) * 1.0f;
            Matrix.scaleM(this.MMatrix, 0, max2, max2, 1.0f);
        }
    }

    public void setGlFilter(final GlVideoFilter glVideoFilter) {
        this.glView.queueEvent(new Runnable() {
            public void run() {
                if (GlPreviewRenderer.this.glFilter != null) {
                    GlPreviewRenderer.this.glFilter.release();
                }
                GlVideoFilter unused = GlPreviewRenderer.this.glFilter = glVideoFilter;
                boolean unused2 = GlPreviewRenderer.this.isNewShader = true;
                GlPreviewRenderer.this.glView.requestRender();
            }
        });
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.updateTexImageCounter++;
        this.glView.requestRender();
    }

    public void onSurfaceCreated(EGLConfig eGLConfig) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i = iArr[0];
        this.texName = i;
        GlSurfaceTexture glSurfaceTexture = new GlSurfaceTexture(i);
        this.previewTexture = glSurfaceTexture;
        glSurfaceTexture.setOnFrameAvailableListener(this);
        GLES20.glBindTexture(this.previewTexture.getTextureTarget(), this.texName);
        EglUtil.setupSampler(this.previewTexture.getTextureTarget(), 9729, 9728);
        GLES20.glBindTexture(3553, 0);
        this.filterFramebufferObject = new GlFramebufferObject();
        GlPreview glPreview = new GlPreview(this.previewTexture.getTextureTarget());
        this.previewShader = glPreview;
        glPreview.setup();
        Matrix.setLookAtM(this.VMatrix, 0, 0.0f, 0.0f, 5.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        if (this.glFilter != null) {
            this.isNewShader = true;
        }
        GLES20.glGetIntegerv(3379, iArr, 0);
        this.handler.post(new Runnable() {
            public void run() {
                if (GlPreviewRenderer.this.surfaceCreateListener != null) {
                    GlPreviewRenderer.this.surfaceCreateListener.onCreated(GlPreviewRenderer.this.previewTexture.getSurfaceTexture());
                }
            }
        });
    }

    public void onSurfaceChanged(int i, int i2) {
        this.filterFramebufferObject.setup(i, i2);
        this.previewShader.setFrameSize(i, i2);
        GlVideoFilter glVideoFilter = this.glFilter;
        if (glVideoFilter != null) {
            glVideoFilter.setFrameSize(i, i2);
        }
        float f = ((float) i) / ((float) i2);
        this.scaleRatio = f;
        Matrix.frustumM(this.ProjMatrix, 0, -f, f, -1.0f, 1.0f, 5.0f, 7.0f);
    }

    public void onDrawFrame(GlFramebufferObject glFramebufferObject) {
        float f = this.drawScale;
        if (f != this.gestureScale) {
            float f2 = 1.0f / f;
            Matrix.scaleM(this.MMatrix, 0, f2, f2, 1.0f);
            float f3 = this.gestureScale;
            this.drawScale = f3;
            Matrix.scaleM(this.MMatrix, 0, f3, f3, 1.0f);
        }
        synchronized (this) {
            if (this.updateTexImageCompare != this.updateTexImageCounter) {
                while (this.updateTexImageCompare != this.updateTexImageCounter) {
                    this.previewTexture.updateTexImage();
                    this.previewTexture.getTransformMatrix(this.STMatrix);
                    this.updateTexImageCompare++;
                }
            }
        }
        if (this.isNewShader) {
            GlVideoFilter glVideoFilter = this.glFilter;
            if (glVideoFilter != null) {
                glVideoFilter.setup();
                this.glFilter.setFrameSize(glFramebufferObject.getWidth(), glFramebufferObject.getHeight());
            }
            this.isNewShader = false;
        }
        if (this.glFilter != null) {
            this.filterFramebufferObject.enable();
        }
        GLES20.glClear(16384);
        Matrix.multiplyMM(this.MVPMatrix, 0, this.VMatrix, 0, this.MMatrix, 0);
        float[] fArr = this.MVPMatrix;
        Matrix.multiplyMM(fArr, 0, this.ProjMatrix, 0, fArr, 0);
        this.previewShader.draw(this.texName, this.MVPMatrix, this.STMatrix, this.aspectRatio);
        if (this.glFilter != null) {
            glFramebufferObject.enable();
            GLES20.glClear(16384);
            this.glFilter.draw(this.filterFramebufferObject.getTexName(), glFramebufferObject);
        }
        synchronized (this) {
            MediaVideoEncoder mediaVideoEncoder = this.videoEncoder;
            if (mediaVideoEncoder != null) {
                mediaVideoEncoder.frameAvailableSoon(this.texName, this.STMatrix, this.MVPMatrix, this.aspectRatio);
            }
        }
    }

    public void setCameraResolution(Size size) {
        this.cameraResolution = size;
    }

    public void setVideoEncoder(final MediaVideoEncoder mediaVideoEncoder) {
        this.glView.queueEvent(new Runnable() {
            public void run() {
                synchronized (GlPreviewRenderer.this) {
                    MediaVideoEncoder mediaVideoEncoder = mediaVideoEncoder;
                    if (mediaVideoEncoder != null) {
                        mediaVideoEncoder.setEglContext(EGL14.eglGetCurrentContext(), GlPreviewRenderer.this.texName);
                    }
                    MediaVideoEncoder unused = GlPreviewRenderer.this.videoEncoder = mediaVideoEncoder;
                }
            }
        });
    }

    public GlSurfaceTexture getPreviewTexture() {
        return this.previewTexture;
    }

    public void setAngle(int i) {
        this.angle = i;
        if (i == 90 || i == 270) {
            this.aspectRatio = ((float) this.cameraResolution.getWidth()) / ((float) this.cameraResolution.getHeight());
        } else {
            this.aspectRatio = ((float) this.cameraResolution.getHeight()) / ((float) this.cameraResolution.getWidth());
        }
    }

    public void setGestureScale(float f) {
        this.gestureScale = f;
    }

    public GlVideoFilter getFilter() {
        return this.glFilter;
    }

    public void release() {
        this.glView.queueEvent(new Runnable() {
            public void run() {
                if (GlPreviewRenderer.this.glFilter != null) {
                    GlPreviewRenderer.this.glFilter.release();
                }
            }
        });
    }

    public void setSurfaceCreateListener(SurfaceCreateListener surfaceCreateListener2) {
        this.surfaceCreateListener = surfaceCreateListener2;
    }
}
