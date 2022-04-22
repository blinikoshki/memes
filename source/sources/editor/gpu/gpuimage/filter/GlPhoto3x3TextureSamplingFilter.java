package editor.gpu.gpuimage.filter;

import android.opengl.GLES20;

public class GlPhoto3x3TextureSamplingFilter extends GlPhotoFilter {
    public static final String THREE_X_THREE_TEXTURE_SAMPLING_VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nuniform highp float texelWidth; \nuniform highp float texelHeight; \n\nvarying vec2 textureCoordinate;\nvarying vec2 leftTextureCoordinate;\nvarying vec2 rightTextureCoordinate;\n\nvarying vec2 topTextureCoordinate;\nvarying vec2 topLeftTextureCoordinate;\nvarying vec2 topRightTextureCoordinate;\n\nvarying vec2 bottomTextureCoordinate;\nvarying vec2 bottomLeftTextureCoordinate;\nvarying vec2 bottomRightTextureCoordinate;\n\nvoid main()\n{\n    gl_Position = position;\n\n    vec2 widthStep = vec2(texelWidth, 0.0);\n    vec2 heightStep = vec2(0.0, texelHeight);\n    vec2 widthHeightStep = vec2(texelWidth, texelHeight);\n    vec2 widthNegativeHeightStep = vec2(texelWidth, -texelHeight);\n\n    textureCoordinate = inputTextureCoordinate.xy;\n    leftTextureCoordinate = inputTextureCoordinate.xy - widthStep;\n    rightTextureCoordinate = inputTextureCoordinate.xy + widthStep;\n\n    topTextureCoordinate = inputTextureCoordinate.xy - heightStep;\n    topLeftTextureCoordinate = inputTextureCoordinate.xy - widthHeightStep;\n    topRightTextureCoordinate = inputTextureCoordinate.xy + widthNegativeHeightStep;\n\n    bottomTextureCoordinate = inputTextureCoordinate.xy + heightStep;\n    bottomLeftTextureCoordinate = inputTextureCoordinate.xy - widthNegativeHeightStep;\n    bottomRightTextureCoordinate = inputTextureCoordinate.xy + widthHeightStep;\n}";
    private boolean hasOverriddenImageSizeFactor;
    private float lineSize;
    private float texelHeight;
    private float texelWidth;
    private int uniformTexelHeightLocation;
    private int uniformTexelWidthLocation;

    public GlPhoto3x3TextureSamplingFilter() {
        this(GlPhotoFilter.NO_FILTER_VERTEX_SHADER);
    }

    public GlPhoto3x3TextureSamplingFilter(String str) {
        super(THREE_X_THREE_TEXTURE_SAMPLING_VERTEX_SHADER, str);
        this.hasOverriddenImageSizeFactor = false;
        this.lineSize = 1.0f;
    }

    public void onInit() {
        super.onInit();
        this.uniformTexelWidthLocation = GLES20.glGetUniformLocation(getProgram(), "texelWidth");
        this.uniformTexelHeightLocation = GLES20.glGetUniformLocation(getProgram(), "texelHeight");
    }

    public void onInitialized() {
        super.onInitialized();
        if (this.texelWidth != 0.0f) {
            updateTexelValues();
        }
    }

    public void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        if (!this.hasOverriddenImageSizeFactor) {
            setLineSize(this.lineSize);
        }
    }

    public void setTexelWidth(float f) {
        this.hasOverriddenImageSizeFactor = true;
        this.texelWidth = f;
        setFloat(this.uniformTexelWidthLocation, f);
    }

    public void setTexelHeight(float f) {
        this.hasOverriddenImageSizeFactor = true;
        this.texelHeight = f;
        setFloat(this.uniformTexelHeightLocation, f);
    }

    public void setLineSize(float f) {
        this.lineSize = f;
        this.texelWidth = f / ((float) getOutputWidth());
        this.texelHeight = f / ((float) getOutputHeight());
        updateTexelValues();
    }

    private void updateTexelValues() {
        setFloat(this.uniformTexelWidthLocation, this.texelWidth);
        setFloat(this.uniformTexelHeightLocation, this.texelHeight);
    }
}
