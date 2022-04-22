package editor.gpu.gpuimage.filter;

import android.opengl.GLES20;

public class GlPhotoExposureFilter extends GlPhotoFilter {
    public static final String EXPOSURE_FRAGMENT_SHADER = " varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform highp float exposure;\n \n void main()\n {\n     highp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     gl_FragColor = vec4(textureColor.rgb * pow(2.0, exposure), textureColor.w);\n } ";
    private float exposure;
    private int exposureLocation;

    public GlPhotoExposureFilter() {
        this(1.0f);
    }

    public GlPhotoExposureFilter(float f) {
        super(GlPhotoFilter.NO_FILTER_VERTEX_SHADER, EXPOSURE_FRAGMENT_SHADER);
        this.exposure = f;
    }

    public void onInit() {
        super.onInit();
        this.exposureLocation = GLES20.glGetUniformLocation(getProgram(), "exposure");
    }

    public void onInitialized() {
        super.onInitialized();
        setExposure(this.exposure);
    }

    public void setExposure(float f) {
        this.exposure = f;
        setFloat(this.exposureLocation, f);
    }
}
