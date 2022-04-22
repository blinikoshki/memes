package editor.gpu.gpuvideo.capture;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLSurface;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class EglSurface {
    private static final boolean DEBUG = false;
    private static final String TAG = "EglWrapper";
    private final EglWrapper egl;
    private EGLSurface eglSurface = EGL14.EGL_NO_SURFACE;
    private final int height;
    private final int width;

    EglSurface(EglWrapper eglWrapper, Object obj) {
        if ((obj instanceof SurfaceView) || (obj instanceof Surface) || (obj instanceof SurfaceHolder) || (obj instanceof SurfaceTexture)) {
            this.egl = eglWrapper;
            EGLSurface createWindowSurface = eglWrapper.createWindowSurface(obj);
            this.eglSurface = createWindowSurface;
            this.width = eglWrapper.querySurface(createWindowSurface, 12375);
            this.height = eglWrapper.querySurface(this.eglSurface, 12374);
            return;
        }
        throw new IllegalArgumentException("unsupported surface");
    }

    public void makeCurrent() {
        this.egl.makeCurrent(this.eglSurface);
    }

    public void swap() {
        this.egl.swap(this.eglSurface);
    }

    public EGLContext getContext() {
        return this.egl.getContext();
    }

    public void release() {
        this.egl.makeDefault();
        this.egl.destroyWindowSurface(this.eglSurface);
        this.eglSurface = EGL14.EGL_NO_SURFACE;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
