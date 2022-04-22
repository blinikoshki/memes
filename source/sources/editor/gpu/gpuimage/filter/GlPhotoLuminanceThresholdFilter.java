package editor.gpu.gpuimage.filter;

import android.opengl.GLES20;

public class GlPhotoLuminanceThresholdFilter extends GlPhotoFilter {
    public static final String LUMINANCE_THRESHOLD_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\nuniform highp float threshold;\n\nconst highp vec3 W = vec3(0.2125, 0.7154, 0.0721);\n\nvoid main()\n{\n    highp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n    highp float luminance = dot(textureColor.rgb, W);\n    highp float thresholdResult = step(threshold, luminance);\n    \n    gl_FragColor = vec4(vec3(thresholdResult), textureColor.w);\n}";
    private float threshold;
    private int uniformThresholdLocation;

    public GlPhotoLuminanceThresholdFilter() {
        this(0.5f);
    }

    public GlPhotoLuminanceThresholdFilter(float f) {
        super(GlPhotoFilter.NO_FILTER_VERTEX_SHADER, LUMINANCE_THRESHOLD_FRAGMENT_SHADER);
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
