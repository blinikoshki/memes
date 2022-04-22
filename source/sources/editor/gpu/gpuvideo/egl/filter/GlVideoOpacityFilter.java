package editor.gpu.gpuvideo.egl.filter;

import android.opengl.GLES20;

public class GlVideoOpacityFilter extends GlVideoFilter {
    private static final String OPACITY_FRAGMENT_SHADER = "precision mediump float; varying highp vec2 vTextureCoord;\n  \n uniform lowp sampler2D sTexture;\n uniform lowp float opacity;\n  \n  void main()\n  {\n      lowp vec4 textureColor = texture2D(sTexture, vTextureCoord);\n      \n      gl_FragColor = vec4(textureColor.rgb, textureColor.a * opacity);\n  }\n";
    private float opacity = 1.0f;

    public GlVideoOpacityFilter() {
        super("attribute highp vec4 aPosition;\nattribute highp vec4 aTextureCoord;\nvarying highp vec2 vTextureCoord;\nvoid main() {\ngl_Position = aPosition;\nvTextureCoord = aTextureCoord.xy;\n}\n", OPACITY_FRAGMENT_SHADER);
    }

    public void setOpacity(float f) {
        this.opacity = f;
    }

    public void onDraw() {
        GLES20.glUniform1f(getHandle("opacity"), this.opacity);
    }
}
