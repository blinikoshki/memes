package editor.gpu.gpuvideo.egl.filter;

import android.opengl.GLES20;

public class GlVideoContrastFilter extends GlVideoFilter {
    private static final String CONTRAST_FRAGMENT_SHADER = "precision mediump float; varying vec2 vTextureCoord;\n \n uniform lowp sampler2D sTexture;\n uniform lowp float contrast;\n \n void main()\n {\n     lowp vec4 textureColor = texture2D(sTexture, vTextureCoord);\n     \n     gl_FragColor = vec4(((textureColor.rgb - vec3(0.5)) * contrast + vec3(0.5)), textureColor.w);\n }";
    private float contrast = 1.2f;

    public GlVideoContrastFilter() {
        super("attribute highp vec4 aPosition;\nattribute highp vec4 aTextureCoord;\nvarying highp vec2 vTextureCoord;\nvoid main() {\ngl_Position = aPosition;\nvTextureCoord = aTextureCoord.xy;\n}\n", CONTRAST_FRAGMENT_SHADER);
    }

    public GlVideoContrastFilter(float f) {
        super("attribute highp vec4 aPosition;\nattribute highp vec4 aTextureCoord;\nvarying highp vec2 vTextureCoord;\nvoid main() {\ngl_Position = aPosition;\nvTextureCoord = aTextureCoord.xy;\n}\n", CONTRAST_FRAGMENT_SHADER);
        setContrast(f);
    }

    public void setContrast(float f) {
        this.contrast = f;
    }

    public void onDraw() {
        GLES20.glUniform1f(getHandle("contrast"), this.contrast);
    }
}
