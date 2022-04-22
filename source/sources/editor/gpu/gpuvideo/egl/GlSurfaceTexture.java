package editor.gpu.gpuvideo.egl;

import android.graphics.SurfaceTexture;

public class GlSurfaceTexture implements SurfaceTexture.OnFrameAvailableListener {
    private SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener;
    private SurfaceTexture surfaceTexture;

    public int getTextureTarget() {
        return 36197;
    }

    public GlSurfaceTexture(int i) {
        SurfaceTexture surfaceTexture2 = new SurfaceTexture(i);
        this.surfaceTexture = surfaceTexture2;
        surfaceTexture2.setOnFrameAvailableListener(this);
    }

    public void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener2) {
        this.onFrameAvailableListener = onFrameAvailableListener2;
    }

    public void updateTexImage() {
        this.surfaceTexture.updateTexImage();
    }

    public void getTransformMatrix(float[] fArr) {
        this.surfaceTexture.getTransformMatrix(fArr);
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.surfaceTexture;
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture2) {
        SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener2 = this.onFrameAvailableListener;
        if (onFrameAvailableListener2 != null) {
            onFrameAvailableListener2.onFrameAvailable(this.surfaceTexture);
        }
    }

    public void release() {
        this.surfaceTexture.release();
    }
}
