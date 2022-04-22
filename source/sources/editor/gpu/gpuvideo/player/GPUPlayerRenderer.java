package editor.gpu.gpuvideo.player;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import android.view.Surface;
import com.google.android.exoplayer2.SimpleExoPlayer;
import editor.gpu.gpuvideo.egl.EglUtil;
import editor.gpu.gpuvideo.egl.GlFrameBufferObjectRenderer;
import editor.gpu.gpuvideo.egl.GlFramebufferObject;
import editor.gpu.gpuvideo.egl.GlPreviewFilter;
import editor.gpu.gpuvideo.egl.GlSurfaceTexture;
import editor.gpu.gpuvideo.egl.filter.GlVideoFilter;
import editor.gpu.gpuvideo.egl.filter.GlVideoLookUpTableFilter;
import javax.microedition.khronos.egl.EGLConfig;

public class GPUPlayerRenderer extends GlFrameBufferObjectRenderer implements SurfaceTexture.OnFrameAvailableListener {
    private static final String TAG = "GPUPlayerRenderer";
    private float[] MMatrix = new float[16];
    private float[] MVPMatrix = new float[16];
    private float[] ProjMatrix = new float[16];
    private float[] STMatrix;
    private float[] VMatrix = new float[16];
    private float aspectRatio;
    private GlFramebufferObject filterFramebufferObject;
    /* access modifiers changed from: private */
    public GlVideoFilter glFilter;
    /* access modifiers changed from: private */
    public final GPUPlayerView glPreview;
    /* access modifiers changed from: private */
    public boolean isNewFilter;
    private GlPreviewFilter previewFilter;
    private GlSurfaceTexture previewTexture;
    private SimpleExoPlayer simpleExoPlayer;
    private int texName;
    private boolean updateSurface = false;

    GPUPlayerRenderer(GPUPlayerView gPUPlayerView) {
        float[] fArr = new float[16];
        this.STMatrix = fArr;
        this.aspectRatio = 1.0f;
        Matrix.setIdentityM(fArr, 0);
        this.glPreview = gPUPlayerView;
    }

    /* access modifiers changed from: package-private */
    public void setGlFilter(final GlVideoFilter glVideoFilter) {
        this.glPreview.queueEvent(new Runnable() {
            public void run() {
                if (GPUPlayerRenderer.this.glFilter != null) {
                    GPUPlayerRenderer.this.glFilter.release();
                    if (GPUPlayerRenderer.this.glFilter instanceof GlVideoLookUpTableFilter) {
                        ((GlVideoLookUpTableFilter) GPUPlayerRenderer.this.glFilter).releaseLutBitmap();
                    }
                    GlVideoFilter unused = GPUPlayerRenderer.this.glFilter = null;
                }
                GlVideoFilter unused2 = GPUPlayerRenderer.this.glFilter = glVideoFilter;
                boolean unused3 = GPUPlayerRenderer.this.isNewFilter = true;
                GPUPlayerRenderer.this.glPreview.requestRender();
            }
        });
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
        GlPreviewFilter glPreviewFilter = new GlPreviewFilter(this.previewTexture.getTextureTarget());
        this.previewFilter = glPreviewFilter;
        glPreviewFilter.setup();
        this.simpleExoPlayer.setVideoSurface(new Surface(this.previewTexture.getSurfaceTexture()));
        Matrix.setLookAtM(this.VMatrix, 0, 0.0f, 0.0f, 5.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        synchronized (this) {
            this.updateSurface = false;
        }
        if (this.glFilter != null) {
            this.isNewFilter = true;
        }
        GLES20.glGetIntegerv(3379, iArr, 0);
    }

    public void onSurfaceChanged(int i, int i2) {
        String str = TAG;
        Log.d(str, "onSurfaceChanged width = " + i + "  height = " + i2);
        this.filterFramebufferObject.setup(i, i2);
        this.previewFilter.setFrameSize(i, i2);
        GlVideoFilter glVideoFilter = this.glFilter;
        if (glVideoFilter != null) {
            glVideoFilter.setFrameSize(i, i2);
        }
        float f = ((float) i) / ((float) i2);
        this.aspectRatio = f;
        Matrix.frustumM(this.ProjMatrix, 0, -f, f, -1.0f, 1.0f, 5.0f, 7.0f);
        Matrix.setIdentityM(this.MMatrix, 0);
    }

    public void onDrawFrame(GlFramebufferObject glFramebufferObject) {
        synchronized (this) {
            if (this.updateSurface) {
                this.previewTexture.updateTexImage();
                this.previewTexture.getTransformMatrix(this.STMatrix);
                this.updateSurface = false;
            }
        }
        if (this.isNewFilter) {
            GlVideoFilter glVideoFilter = this.glFilter;
            if (glVideoFilter != null) {
                glVideoFilter.setup();
                this.glFilter.setFrameSize(glFramebufferObject.getWidth(), glFramebufferObject.getHeight());
            }
            this.isNewFilter = false;
        }
        if (this.glFilter != null) {
            this.filterFramebufferObject.enable();
            GLES20.glViewport(0, 0, this.filterFramebufferObject.getWidth(), this.filterFramebufferObject.getHeight());
        }
        GLES20.glClear(16384);
        Matrix.multiplyMM(this.MVPMatrix, 0, this.VMatrix, 0, this.MMatrix, 0);
        float[] fArr = this.MVPMatrix;
        Matrix.multiplyMM(fArr, 0, this.ProjMatrix, 0, fArr, 0);
        this.previewFilter.draw(this.texName, this.MVPMatrix, this.STMatrix, this.aspectRatio);
        if (this.glFilter != null) {
            glFramebufferObject.enable();
            GLES20.glClear(16384);
            this.glFilter.draw(this.filterFramebufferObject.getTexName(), glFramebufferObject);
        }
    }

    public synchronized void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.updateSurface = true;
        this.glPreview.requestRender();
    }

    /* access modifiers changed from: package-private */
    public void setSimpleExoPlayer(SimpleExoPlayer simpleExoPlayer2) {
        this.simpleExoPlayer = simpleExoPlayer2;
    }

    /* access modifiers changed from: package-private */
    public void release() {
        GlVideoFilter glVideoFilter = this.glFilter;
        if (glVideoFilter != null) {
            glVideoFilter.release();
        }
        GlSurfaceTexture glSurfaceTexture = this.previewTexture;
        if (glSurfaceTexture != null) {
            glSurfaceTexture.release();
        }
    }
}
