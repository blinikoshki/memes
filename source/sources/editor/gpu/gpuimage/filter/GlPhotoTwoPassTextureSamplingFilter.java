package editor.gpu.gpuimage.filter;

import android.opengl.GLES20;

public class GlPhotoTwoPassTextureSamplingFilter extends GlPhotoTwoPassFilter {
    public float getHorizontalTexelOffsetRatio() {
        return 1.0f;
    }

    public float getVerticalTexelOffsetRatio() {
        return 1.0f;
    }

    public GlPhotoTwoPassTextureSamplingFilter(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
    }

    public void onInit() {
        super.onInit();
        initTexelOffsets();
    }

    /* access modifiers changed from: protected */
    public void initTexelOffsets() {
        float horizontalTexelOffsetRatio = getHorizontalTexelOffsetRatio();
        GlPhotoFilter glPhotoFilter = getFilters().get(0);
        int glGetUniformLocation = GLES20.glGetUniformLocation(glPhotoFilter.getProgram(), "texelWidthOffset");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(glPhotoFilter.getProgram(), "texelHeightOffset");
        glPhotoFilter.setFloat(glGetUniformLocation, horizontalTexelOffsetRatio / ((float) getOutputWidth()));
        glPhotoFilter.setFloat(glGetUniformLocation2, 0.0f);
        float verticalTexelOffsetRatio = getVerticalTexelOffsetRatio();
        GlPhotoFilter glPhotoFilter2 = getFilters().get(1);
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(glPhotoFilter2.getProgram(), "texelWidthOffset");
        int glGetUniformLocation4 = GLES20.glGetUniformLocation(glPhotoFilter2.getProgram(), "texelHeightOffset");
        glPhotoFilter2.setFloat(glGetUniformLocation3, 0.0f);
        glPhotoFilter2.setFloat(glGetUniformLocation4, verticalTexelOffsetRatio / ((float) getOutputHeight()));
    }

    public void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        initTexelOffsets();
    }
}
