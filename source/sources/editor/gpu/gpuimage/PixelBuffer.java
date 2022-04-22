package editor.gpu.gpuimage;

import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.util.Log;
import com.memes.eventtracker.util.Util;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

public class PixelBuffer {
    private static final boolean LIST_CONFIGS = false;
    private static final String TAG = "PixelBuffer";
    private Bitmap bitmap;
    private EGL10 egl10;
    private EGLConfig eglConfig;
    private EGLConfig[] eglConfigs;
    private EGLContext eglContext;
    private EGLDisplay eglDisplay;
    private EGLSurface eglSurface;
    private GL10 gl10 = ((GL10) this.eglContext.getGL());
    private int height;
    private String mThreadOwner = Thread.currentThread().getName();
    private GLSurfaceView.Renderer renderer;
    private int width;

    public PixelBuffer(int i, int i2) {
        this.width = i;
        this.height = i2;
        int[] iArr = {12375, i, 12374, i2, 12344};
        EGL10 egl102 = (EGL10) EGLContext.getEGL();
        this.egl10 = egl102;
        EGLDisplay eglGetDisplay = egl102.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.eglDisplay = eglGetDisplay;
        this.egl10.eglInitialize(eglGetDisplay, new int[2]);
        EGLConfig chooseConfig = chooseConfig();
        this.eglConfig = chooseConfig;
        this.eglContext = this.egl10.eglCreateContext(this.eglDisplay, chooseConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
        EGLSurface eglCreatePbufferSurface = this.egl10.eglCreatePbufferSurface(this.eglDisplay, this.eglConfig, iArr);
        this.eglSurface = eglCreatePbufferSurface;
        this.egl10.eglMakeCurrent(this.eglDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, this.eglContext);
    }

    public void setRenderer(GLSurfaceView.Renderer renderer2) {
        this.renderer = renderer2;
        if (!Thread.currentThread().getName().equals(this.mThreadOwner)) {
            Log.e(TAG, "setRenderer: This thread does not own the OpenGL context.");
            return;
        }
        this.renderer.onSurfaceCreated(this.gl10, this.eglConfig);
        this.renderer.onSurfaceChanged(this.gl10, this.width, this.height);
    }

    public Bitmap getBitmap() {
        if (this.renderer == null) {
            Log.e(TAG, "getBitmap: Renderer was not set.");
            return null;
        } else if (!Thread.currentThread().getName().equals(this.mThreadOwner)) {
            Log.e(TAG, "getBitmap: This thread does not own the OpenGL context.");
            return null;
        } else {
            this.renderer.onDrawFrame(this.gl10);
            this.renderer.onDrawFrame(this.gl10);
            convertToBitmap();
            return this.bitmap;
        }
    }

    public void destroy() {
        this.renderer.onDrawFrame(this.gl10);
        this.renderer.onDrawFrame(this.gl10);
        this.egl10.eglMakeCurrent(this.eglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        this.egl10.eglDestroySurface(this.eglDisplay, this.eglSurface);
        this.egl10.eglDestroyContext(this.eglDisplay, this.eglContext);
        this.egl10.eglTerminate(this.eglDisplay);
    }

    private EGLConfig chooseConfig() {
        int[] iArr = new int[1];
        int[] iArr2 = {12325, 0, 12326, 0, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344};
        int[] iArr3 = iArr;
        this.egl10.eglChooseConfig(this.eglDisplay, iArr2, (EGLConfig[]) null, 0, iArr3);
        int i = iArr[0];
        EGLConfig[] eGLConfigArr = new EGLConfig[i];
        this.eglConfigs = eGLConfigArr;
        this.egl10.eglChooseConfig(this.eglDisplay, iArr2, eGLConfigArr, i, iArr3);
        return this.eglConfigs[0];
    }

    private void listConfig() {
        Log.i(TAG, "Config List {");
        for (EGLConfig eGLConfig : this.eglConfigs) {
            Log.i(TAG, "    <d,s,r,g,b,a> = <" + getConfigAttrib(eGLConfig, 12325) + Util.EVENT_ID_SEPARATOR + getConfigAttrib(eGLConfig, 12326) + Util.EVENT_ID_SEPARATOR + getConfigAttrib(eGLConfig, 12324) + Util.EVENT_ID_SEPARATOR + getConfigAttrib(eGLConfig, 12323) + Util.EVENT_ID_SEPARATOR + getConfigAttrib(eGLConfig, 12322) + Util.EVENT_ID_SEPARATOR + getConfigAttrib(eGLConfig, 12321) + ">");
        }
        Log.i(TAG, "}");
    }

    private int getConfigAttrib(EGLConfig eGLConfig, int i) {
        int[] iArr = new int[1];
        if (this.egl10.eglGetConfigAttrib(this.eglDisplay, eGLConfig, i, iArr)) {
            return iArr[0];
        }
        return 0;
    }

    private void convertToBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
        this.bitmap = createBitmap;
        GPUImageNativeLibrary.adjustBitmap(createBitmap);
    }
}
