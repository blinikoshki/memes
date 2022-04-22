package editor.gpu.gpuimage.filter;

import android.opengl.GLES20;

public class GlPhotoSharpenFilter extends GlPhotoFilter {
    public static final String SHARPEN_FRAGMENT_SHADER = "precision highp float;\n\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 leftTextureCoordinate;\nvarying highp vec2 rightTextureCoordinate; \nvarying highp vec2 topTextureCoordinate;\nvarying highp vec2 bottomTextureCoordinate;\n\nvarying highp float centerMultiplier;\nvarying highp float edgeMultiplier;\n\nuniform sampler2D inputImageTexture;\n\nvoid main()\n{\n    mediump vec3 textureColor = texture2D(inputImageTexture, textureCoordinate).rgb;\n    mediump vec3 leftTextureColor = texture2D(inputImageTexture, leftTextureCoordinate).rgb;\n    mediump vec3 rightTextureColor = texture2D(inputImageTexture, rightTextureCoordinate).rgb;\n    mediump vec3 topTextureColor = texture2D(inputImageTexture, topTextureCoordinate).rgb;\n    mediump vec3 bottomTextureColor = texture2D(inputImageTexture, bottomTextureCoordinate).rgb;\n\n    gl_FragColor = vec4((textureColor * centerMultiplier - (leftTextureColor * edgeMultiplier + rightTextureColor * edgeMultiplier + topTextureColor * edgeMultiplier + bottomTextureColor * edgeMultiplier)), texture2D(inputImageTexture, bottomTextureCoordinate).w);\n}";
    public static final String SHARPEN_VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nuniform float imageWidthFactor; \nuniform float imageHeightFactor; \nuniform float sharpness;\n\nvarying vec2 textureCoordinate;\nvarying vec2 leftTextureCoordinate;\nvarying vec2 rightTextureCoordinate; \nvarying vec2 topTextureCoordinate;\nvarying vec2 bottomTextureCoordinate;\n\nvarying float centerMultiplier;\nvarying float edgeMultiplier;\n\nvoid main()\n{\n    gl_Position = position;\n    \n    mediump vec2 widthStep = vec2(imageWidthFactor, 0.0);\n    mediump vec2 heightStep = vec2(0.0, imageHeightFactor);\n    \n    textureCoordinate = inputTextureCoordinate.xy;\n    leftTextureCoordinate = inputTextureCoordinate.xy - widthStep;\n    rightTextureCoordinate = inputTextureCoordinate.xy + widthStep;\n    topTextureCoordinate = inputTextureCoordinate.xy + heightStep;     \n    bottomTextureCoordinate = inputTextureCoordinate.xy - heightStep;\n    \n    centerMultiplier = 1.0 + 4.0 * sharpness;\n    edgeMultiplier = sharpness;\n}";
    private int imageHeightFactorLocation;
    private int imageWidthFactorLocation;
    private float sharpness;
    private int sharpnessLocation;

    public GlPhotoSharpenFilter() {
        this(0.0f);
    }

    public GlPhotoSharpenFilter(float f) {
        super(SHARPEN_VERTEX_SHADER, SHARPEN_FRAGMENT_SHADER);
        this.sharpness = f;
    }

    public void onInit() {
        super.onInit();
        this.sharpnessLocation = GLES20.glGetUniformLocation(getProgram(), "sharpness");
        this.imageWidthFactorLocation = GLES20.glGetUniformLocation(getProgram(), "imageWidthFactor");
        this.imageHeightFactorLocation = GLES20.glGetUniformLocation(getProgram(), "imageHeightFactor");
    }

    public void onInitialized() {
        super.onInitialized();
        setSharpness(this.sharpness);
    }

    public void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        setFloat(this.imageWidthFactorLocation, 1.0f / ((float) i));
        setFloat(this.imageHeightFactorLocation, 1.0f / ((float) i2));
    }

    public void setSharpness(float f) {
        this.sharpness = f;
        setFloat(this.sharpnessLocation, f);
    }
}
