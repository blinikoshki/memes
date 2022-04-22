package editor.gpu.gpuimage.filter;

import android.opengl.GLES20;

public class GlPhotoSobelThresholdFilter extends GlPhoto3x3TextureSamplingFilter {
    public static final String SOBEL_THRESHOLD_EDGE_DETECTION = "precision mediump float;\n\nvarying vec2 textureCoordinate;\nvarying vec2 leftTextureCoordinate;\nvarying vec2 rightTextureCoordinate;\n\nvarying vec2 topTextureCoordinate;\nvarying vec2 topLeftTextureCoordinate;\nvarying vec2 topRightTextureCoordinate;\n\nvarying vec2 bottomTextureCoordinate;\nvarying vec2 bottomLeftTextureCoordinate;\nvarying vec2 bottomRightTextureCoordinate;\n\nuniform sampler2D inputImageTexture;\nuniform lowp float threshold;\n\nconst highp vec3 W = vec3(0.2125, 0.7154, 0.0721);\n\nvoid main()\n{\n    float bottomLeftIntensity = texture2D(inputImageTexture, bottomLeftTextureCoordinate).r;\n    float topRightIntensity = texture2D(inputImageTexture, topRightTextureCoordinate).r;\n    float topLeftIntensity = texture2D(inputImageTexture, topLeftTextureCoordinate).r;\n    float bottomRightIntensity = texture2D(inputImageTexture, bottomRightTextureCoordinate).r;\n    float leftIntensity = texture2D(inputImageTexture, leftTextureCoordinate).r;\n    float rightIntensity = texture2D(inputImageTexture, rightTextureCoordinate).r;\n    float bottomIntensity = texture2D(inputImageTexture, bottomTextureCoordinate).r;\n    float topIntensity = texture2D(inputImageTexture, topTextureCoordinate).r;\n    float h = -topLeftIntensity - 2.0 * topIntensity - topRightIntensity + bottomLeftIntensity + 2.0 * bottomIntensity + bottomRightIntensity;\n    float v = -bottomLeftIntensity - 2.0 * leftIntensity - topLeftIntensity + bottomRightIntensity + 2.0 * rightIntensity + topRightIntensity;\n\n    float mag = 1.0 - length(vec2(h, v));\n    mag = step(threshold, mag);\n\n    gl_FragColor = vec4(vec3(mag), 1.0);\n}\n";
    private float threshold;
    private int uniformThresholdLocation;

    public GlPhotoSobelThresholdFilter() {
        this(0.9f);
    }

    public GlPhotoSobelThresholdFilter(float f) {
        super(SOBEL_THRESHOLD_EDGE_DETECTION);
        this.threshold = f;
    }

    public void onInit() {
        super.onInit();
        this.uniformThresholdLocation = GLES20.glGetUniformLocation(getProgram(), "threshold");
    }

    public void onInitialized() {
        super.onInitialized();
        setThreshold(this.threshold);
    }

    public void setThreshold(float f) {
        this.threshold = f;
        setFloat(this.uniformThresholdLocation, f);
    }
}
