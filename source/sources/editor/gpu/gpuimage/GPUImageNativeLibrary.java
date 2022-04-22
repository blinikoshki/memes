package editor.gpu.gpuimage;

import android.graphics.Bitmap;

public class GPUImageNativeLibrary {
    public static native void YUVtoARBG(byte[] bArr, int i, int i2, int[] iArr);

    public static native void YUVtoRBGA(byte[] bArr, int i, int i2, int[] iArr);

    public static native void adjustBitmap(Bitmap bitmap);

    static {
        System.loadLibrary("yuv-decoder");
    }
}
