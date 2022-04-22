package editor.gpu.gpuvideo.composer;

public enum FillMode {
    PRESERVE_ASPECT_FIT,
    PRESERVE_ASPECT_CROP,
    CUSTOM;

    public static float[] getScaleAspectFit(int i, int i2, int i3, int i4, int i5) {
        float[] fArr = {1.0f, 1.0f};
        fArr[1] = 1.0f;
        fArr[0] = 1.0f;
        if (i == 90 || i == 270) {
            int i6 = i3;
            i3 = i2;
            i2 = i6;
        }
        float f = ((float) i2) / ((float) i3);
        float f2 = (float) i4;
        float f3 = f2 / f;
        float f4 = (float) i5;
        if (f3 < f4) {
            fArr[1] = f3 / f4;
        } else {
            fArr[0] = (f4 * f) / f2;
        }
        return fArr;
    }

    public static float[] getScaleAspectCrop(int i, int i2, int i3, int i4, int i5) {
        float[] fArr = {1.0f, 1.0f};
        fArr[1] = 1.0f;
        fArr[0] = 1.0f;
        if (i == 90 || i == 270) {
            int i6 = i3;
            i3 = i2;
            i2 = i6;
        }
        float f = ((float) i2) / ((float) i3);
        float f2 = (float) i4;
        float f3 = (float) i5;
        if (f > f2 / f3) {
            fArr[0] = (f3 * f) / f2;
        } else {
            fArr[1] = (f2 / f) / f3;
        }
        return fArr;
    }
}
