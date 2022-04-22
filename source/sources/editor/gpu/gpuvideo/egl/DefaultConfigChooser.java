package editor.gpu.gpuvideo.egl;

import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public class DefaultConfigChooser implements GLSurfaceView.EGLConfigChooser {
    private static final int EGL_OPENGL_ES2_BIT = 4;
    private final int alphaSize;
    private final int blueSize;
    private final int[] configSpec;
    private final int depthSize;
    private final int greenSize;
    private final int redSize;
    private final int stencilSize;

    public DefaultConfigChooser(int i) {
        this(true, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DefaultConfigChooser(boolean z, int i) {
        this(8, 8, 8, 0, z ? 16 : 0, 0, i);
    }

    public DefaultConfigChooser(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.configSpec = filterConfigSpec(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344}, i7);
        this.redSize = i;
        this.greenSize = i2;
        this.blueSize = i3;
        this.alphaSize = i4;
        this.depthSize = i5;
        this.stencilSize = i6;
    }

    private int[] filterConfigSpec(int[] iArr, int i) {
        if (i != 2) {
            return iArr;
        }
        int length = iArr.length;
        int[] iArr2 = new int[(length + 2)];
        int i2 = length - 1;
        System.arraycopy(iArr, 0, iArr2, 0, i2);
        iArr2[i2] = 12352;
        iArr2[length] = 4;
        iArr2[length + 1] = 12344;
        return iArr2;
    }

    public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        int[] iArr = new int[1];
        if (egl10.eglChooseConfig(eGLDisplay, this.configSpec, (EGLConfig[]) null, 0, iArr)) {
            int i = iArr[0];
            if (i > 0) {
                EGLConfig[] eGLConfigArr = new EGLConfig[i];
                if (egl10.eglChooseConfig(eGLDisplay, this.configSpec, eGLConfigArr, i, iArr)) {
                    EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
                    if (chooseConfig != null) {
                        return chooseConfig;
                    }
                    throw new IllegalArgumentException("No config chosen");
                }
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            throw new IllegalArgumentException("No configs match configSpec");
        }
        throw new IllegalArgumentException("eglChooseConfig failed");
    }

    private EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
        for (EGLConfig eGLConfig : eGLConfigArr) {
            EGL10 egl102 = egl10;
            EGLDisplay eGLDisplay2 = eGLDisplay;
            EGLConfig eGLConfig2 = eGLConfig;
            int findConfigAttrib = findConfigAttrib(egl102, eGLDisplay2, eGLConfig2, 12325, 0);
            int findConfigAttrib2 = findConfigAttrib(egl102, eGLDisplay2, eGLConfig2, 12326, 0);
            if (findConfigAttrib >= this.depthSize && findConfigAttrib2 >= this.stencilSize) {
                EGL10 egl103 = egl10;
                EGLDisplay eGLDisplay3 = eGLDisplay;
                EGLConfig eGLConfig3 = eGLConfig;
                int findConfigAttrib3 = findConfigAttrib(egl103, eGLDisplay3, eGLConfig3, 12324, 0);
                int findConfigAttrib4 = findConfigAttrib(egl103, eGLDisplay3, eGLConfig3, 12323, 0);
                int findConfigAttrib5 = findConfigAttrib(egl103, eGLDisplay3, eGLConfig3, 12322, 0);
                int findConfigAttrib6 = findConfigAttrib(egl103, eGLDisplay3, eGLConfig3, 12321, 0);
                if (findConfigAttrib3 == this.redSize && findConfigAttrib4 == this.greenSize && findConfigAttrib5 == this.blueSize && findConfigAttrib6 == this.alphaSize) {
                    return eGLConfig;
                }
            }
        }
        return null;
    }

    private int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
        int[] iArr = new int[1];
        return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr) ? iArr[0] : i2;
    }
}
