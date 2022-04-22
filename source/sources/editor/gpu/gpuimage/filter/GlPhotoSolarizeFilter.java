package editor.gpu.gpuimage.filter;

import android.opengl.GLES20;

public class GlPhotoSolarizeFilter extends GlPhotoFilter {
    public static final String SOLATIZE_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\nuniform highp float threshold;\n\nconst highp vec3 W = vec3(0.2125, 0.7154, 0.0721);\n\nvoid main()\n{\n    highp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n    highp float luminance = dot(textureColor.rgb, W);\n    highp float thresholdResult = step(luminance, threshold);\n    highp vec3 finalColor = abs(thresholdResult - textureColor.rgb);\n    \n    gl_FragColor = vec4(finalColor, textureColor.w);\n}";
    private float threshold;
    private int uniformThresholdLocation;

    public GlPhotoSolarizeFilter() {
        this(0.5f);
    }

    public GlPhotoSolarizeFilter(float f) {
        super(GlPhotoFilter.NO_FILTER_VERTEX_SHADER, SOLATIZE_FRAGMENT_SHADER);
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
