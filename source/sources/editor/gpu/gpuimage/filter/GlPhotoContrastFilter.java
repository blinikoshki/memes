package editor.gpu.gpuimage.filter;

import android.opengl.GLES20;

public class GlPhotoContrastFilter extends GlPhotoFilter {
    public static final String CONTRAST_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform lowp float contrast;\n \n void main()\n {\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     gl_FragColor = vec4(((textureColor.rgb - vec3(0.5)) * contrast + vec3(0.5)), textureColor.w);\n }";
    private float contrast;
    private int contrastLocation;

    public GlPhotoContrastFilter() {
        this(1.2f);
    }

    public GlPhotoContrastFilter(float f) {
        super(GlPhotoFilter.NO_FILTER_VERTEX_SHADER, CONTRAST_FRAGMENT_SHADER);
        this.contrast = f;
    }

    public void onInit() {
        super.onInit();
        this.contrastLocation = GLES20.glGetUniformLocation(getProgram(), "contrast");
    }

    public void onInitialized() {
        super.onInitialized();
        setContrast(this.contrast);
    }

    public void setContrast(float f) {
        this.contrast = f;
        setFloat(this.contrastLocation, f);
    }
}
