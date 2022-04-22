package editor.gpu.gpuvideo.egl.filter;

import android.opengl.GLES20;

public class GlVideoExposureFilter extends GlVideoFilter {
    private static final String EXPOSURE_FRAGMENT_SHADER = "precision mediump float; varying vec2 vTextureCoord;\n \n uniform lowp sampler2D sTexture;\n uniform highp float exposure;\n \n void main()\n {\n     highp vec4 textureColor = texture2D(sTexture, vTextureCoord);\n     \n     gl_FragColor = vec4(textureColor.rgb * pow(2.0, exposure), textureColor.w);\n } ";
    private float exposure = 1.0f;

    public GlVideoExposureFilter() {
        super("attribute highp vec4 aPosition;\nattribute highp vec4 aTextureCoord;\nvarying highp vec2 vTextureCoord;\nvoid main() {\ngl_Position = aPosition;\nvTextureCoord = aTextureCoord.xy;\n}\n", EXPOSURE_FRAGMENT_SHADER);
    }

    public void setExposure(float f) {
        this.exposure = f;
    }

    public void onDraw() {
        GLES20.glUniform1f(getHandle("exposure"), this.exposure);
    }
}
