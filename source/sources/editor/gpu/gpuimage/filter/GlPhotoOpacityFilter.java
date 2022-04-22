package editor.gpu.gpuimage.filter;

import android.opengl.GLES20;

public class GlPhotoOpacityFilter extends GlPhotoFilter {
    public static final String OPACITY_FRAGMENT_SHADER = "  varying highp vec2 textureCoordinate;\n  \n  uniform sampler2D inputImageTexture;\n  uniform lowp float opacity;\n  \n  void main()\n  {\n      lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n      \n      gl_FragColor = vec4(textureColor.rgb, textureColor.a * opacity);\n  }\n";
    private float opacity;
    private int opacityLocation;

    public GlPhotoOpacityFilter() {
        this(1.0f);
    }

    public GlPhotoOpacityFilter(float f) {
        super(GlPhotoFilter.NO_FILTER_VERTEX_SHADER, OPACITY_FRAGMENT_SHADER);
        this.opacity = f;
    }

    public void onInit() {
        super.onInit();
        this.opacityLocation = GLES20.glGetUniformLocation(getProgram(), "opacity");
    }

    public void onInitialized() {
        super.onInitialized();
        setOpacity(this.opacity);
    }

    public void setOpacity(float f) {
        this.opacity = f;
        setFloat(this.opacityLocation, f);
    }
}
