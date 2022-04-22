package editor.gpu.gpuimage.filter;

import android.opengl.GLES20;

public class GlPhotoGammaFilter extends GlPhotoFilter {
    public static final String GAMMA_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform lowp float gamma;\n \n void main()\n {\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     gl_FragColor = vec4(pow(textureColor.rgb, vec3(gamma)), textureColor.w);\n }";
    private float gamma;
    private int gammaLocation;

    public GlPhotoGammaFilter() {
        this(1.2f);
    }

    public GlPhotoGammaFilter(float f) {
        super(GlPhotoFilter.NO_FILTER_VERTEX_SHADER, GAMMA_FRAGMENT_SHADER);
        this.gamma = f;
    }

    public void onInit() {
        super.onInit();
        this.gammaLocation = GLES20.glGetUniformLocation(getProgram(), "gamma");
    }

    public void onInitialized() {
        super.onInitialized();
        setGamma(this.gamma);
    }

    public void setGamma(float f) {
        this.gamma = f;
        setFloat(this.gammaLocation, f);
    }
}
