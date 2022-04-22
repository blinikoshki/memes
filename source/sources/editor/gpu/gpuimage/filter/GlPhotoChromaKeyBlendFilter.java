package editor.gpu.gpuimage.filter;

import android.opengl.GLES20;

public class GlPhotoChromaKeyBlendFilter extends GlPhotoTwoInputFilter {
    public static final String CHROMA_KEY_BLEND_FRAGMENT_SHADER = " precision highp float;\n \n varying highp vec2 textureCoordinate;\n varying highp vec2 textureCoordinate2;\n\n uniform float thresholdSensitivity;\n uniform float smoothing;\n uniform vec3 colorToReplace;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n void main()\n {\n     vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     vec4 textureColor2 = texture2D(inputImageTexture2, textureCoordinate2);\n     \n     float maskY = 0.2989 * colorToReplace.r + 0.5866 * colorToReplace.g + 0.1145 * colorToReplace.b;\n     float maskCr = 0.7132 * (colorToReplace.r - maskY);\n     float maskCb = 0.5647 * (colorToReplace.b - maskY);\n     \n     float Y = 0.2989 * textureColor.r + 0.5866 * textureColor.g + 0.1145 * textureColor.b;\n     float Cr = 0.7132 * (textureColor.r - Y);\n     float Cb = 0.5647 * (textureColor.b - Y);\n     \n     float blendValue = 1.0 - smoothstep(thresholdSensitivity, thresholdSensitivity + smoothing, distance(vec2(Cr, Cb), vec2(maskCr, maskCb)));\n     gl_FragColor = mix(textureColor, textureColor2, blendValue);\n }";
    private float[] colorToReplace = {0.0f, 1.0f, 0.0f};
    private int colorToReplaceLocation;
    private float smoothing = 0.1f;
    private int smoothingLocation;
    private float thresholdSensitivity = 0.4f;
    private int thresholdSensitivityLocation;

    public GlPhotoChromaKeyBlendFilter() {
        super(CHROMA_KEY_BLEND_FRAGMENT_SHADER);
    }

    public void onInit() {
        super.onInit();
        this.thresholdSensitivityLocation = GLES20.glGetUniformLocation(getProgram(), "thresholdSensitivity");
        this.smoothingLocation = GLES20.glGetUniformLocation(getProgram(), "smoothing");
        this.colorToReplaceLocation = GLES20.glGetUniformLocation(getProgram(), "colorToReplace");
    }

    public void onInitialized() {
        super.onInitialized();
        setSmoothing(this.smoothing);
        setThresholdSensitivity(this.thresholdSensitivity);
        float[] fArr = this.colorToReplace;
        setColorToReplace(fArr[0], fArr[1], fArr[2]);
    }

    public void setSmoothing(float f) {
        this.smoothing = f;
        setFloat(this.smoothingLocation, f);
    }

    public void setThresholdSensitivity(float f) {
        this.thresholdSensitivity = f;
        setFloat(this.thresholdSensitivityLocation, f);
    }

    public void setColorToReplace(float f, float f2, float f3) {
        float[] fArr = {f, f2, f3};
        this.colorToReplace = fArr;
        setFloatVec3(this.colorToReplaceLocation, fArr);
    }
}
