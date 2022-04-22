package editor.gpu.gpuimage.filter;

import android.opengl.GLES20;

public class GlPhotoBrightnessFilter extends GlPhotoFilter {
    public static final String BRIGHTNESS_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform lowp float brightness;\n \n void main()\n {\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     gl_FragColor = vec4((textureColor.rgb + vec3(brightness)), textureColor.w);\n }";
    private float brightness;
    private int brightnessLocation;

    public GlPhotoBrightnessFilter() {
        this(0.0f);
    }

    public GlPhotoBrightnessFilter(float f) {
        super(GlPhotoFilter.NO_FILTER_VERTEX_SHADER, BRIGHTNESS_FRAGMENT_SHADER);
        this.brightness = f;
    }

    public void onInit() {
        super.onInit();
        this.brightnessLocation = GLES20.glGetUniformLocation(getProgram(), "brightness");
    }

    public void onInitialized() {
        super.onInitialized();
        setBrightness(this.brightness);
    }

    public void setBrightness(float f) {
        this.brightness = f;
        setFloat(this.brightnessLocation, f);
    }
}
