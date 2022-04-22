package editor.gpu.gpuimage.filter;

import android.opengl.GLES20;

public class GlPhotoPosterizeFilter extends GlPhotoFilter {
    public static final String POSTERIZE_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\nuniform highp float colorLevels;\n\nvoid main()\n{\n   highp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n   \n   gl_FragColor = floor((textureColor * colorLevels) + vec4(0.5)) / colorLevels;\n}";
    private int colorLevels;
    private int glUniformColorLevels;

    public GlPhotoPosterizeFilter() {
        this(10);
    }

    public GlPhotoPosterizeFilter(int i) {
        super(GlPhotoFilter.NO_FILTER_VERTEX_SHADER, POSTERIZE_FRAGMENT_SHADER);
        this.colorLevels = i;
    }

    public void onInit() {
        super.onInit();
        this.glUniformColorLevels = GLES20.glGetUniformLocation(getProgram(), "colorLevels");
    }

    public void onInitialized() {
        super.onInitialized();
        setColorLevels(this.colorLevels);
    }

    public void setColorLevels(int i) {
        this.colorLevels = i;
        setFloat(this.glUniformColorLevels, (float) i);
    }
}
