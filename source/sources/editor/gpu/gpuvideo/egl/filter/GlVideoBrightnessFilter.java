package editor.gpu.gpuvideo.egl.filter;

import android.opengl.GLES20;

public class GlVideoBrightnessFilter extends GlVideoFilter {
    private static final String BRIGHTNESS_FRAGMENT_SHADER = "precision mediump float; varying vec2 vTextureCoord;\n \n uniform lowp sampler2D sTexture;\n uniform lowp float brightness;\n \n void main()\n {\n     lowp vec4 textureColor = texture2D(sTexture, vTextureCoord);\n     \n     gl_FragColor = vec4((textureColor.rgb + vec3(brightness)), textureColor.w);\n }";
    private float brightness = 0.0f;

    public GlVideoBrightnessFilter() {
        super("attribute highp vec4 aPosition;\nattribute highp vec4 aTextureCoord;\nvarying highp vec2 vTextureCoord;\nvoid main() {\ngl_Position = aPosition;\nvTextureCoord = aTextureCoord.xy;\n}\n", BRIGHTNESS_FRAGMENT_SHADER);
    }

    public GlVideoBrightnessFilter(float f) {
        super("attribute highp vec4 aPosition;\nattribute highp vec4 aTextureCoord;\nvarying highp vec2 vTextureCoord;\nvoid main() {\ngl_Position = aPosition;\nvTextureCoord = aTextureCoord.xy;\n}\n", BRIGHTNESS_FRAGMENT_SHADER);
        setBrightness(f);
    }

    public void setBrightness(float f) {
        this.brightness = f;
    }

    public void onDraw() {
        GLES20.glUniform1f(getHandle("brightness"), this.brightness);
    }
}
