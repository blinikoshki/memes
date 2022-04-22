package editor.gpu.gpuvideo.egl;

import android.opengl.GLSurfaceView;
import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class DefaultContextFactory implements GLSurfaceView.EGLContextFactory {
    private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    private static final String TAG = "DefaultContextFactory";
    private int EGLContextClientVersion;

    public DefaultContextFactory(int i) {
        this.EGLContextClientVersion = i;
    }

    public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        int i = this.EGLContextClientVersion;
        return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, i != 0 ? new int[]{EGL_CONTEXT_CLIENT_VERSION, i, 12344} : null);
    }

    public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
        if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
            Log.e(TAG, "display:" + eGLDisplay + " context: " + eGLContext);
            throw new RuntimeException("eglDestroyContext" + egl10.eglGetError());
        }
    }
}
