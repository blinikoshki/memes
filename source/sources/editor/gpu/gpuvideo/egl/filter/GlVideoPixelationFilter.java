package editor.gpu.gpuvideo.egl.filter;

import android.opengl.GLES20;

public class GlVideoPixelationFilter extends GlVideoFilter {
    private static final String PIXELATION_FRAGMENT_SHADER = "precision highp float;\nvarying highp vec2 vTextureCoord;\nuniform float imageWidthFactor;\nuniform float imageHeightFactor;\nuniform lowp sampler2D sTexture;\nuniform float pixel;\nvoid main()\n{\n  vec2 uv  = vTextureCoord.xy;\n  float dx = pixel * imageWidthFactor;\n  float dy = pixel * imageHeightFactor;\n  vec2 coord = vec2(dx * floor(uv.x / dx), dy * floor(uv.y / dy));\n  vec3 tc = texture2D(sTexture, coord).xyz;\n  gl_FragColor = vec4(tc, 1.0);\n}";
    private float imageHeightFactor = 0.0013888889f;
    private float imageWidthFactor = 0.0013888889f;
    private float pixel = 1.0f;

    public GlVideoPixelationFilter() {
        super("attribute highp vec4 aPosition;\nattribute highp vec4 aTextureCoord;\nvarying highp vec2 vTextureCoord;\nvoid main() {\ngl_Position = aPosition;\nvTextureCoord = aTextureCoord.xy;\n}\n", PIXELATION_FRAGMENT_SHADER);
    }

    public GlVideoPixelationFilter(float f) {
        super("attribute highp vec4 aPosition;\nattribute highp vec4 aTextureCoord;\nvarying highp vec2 vTextureCoord;\nvoid main() {\ngl_Position = aPosition;\nvTextureCoord = aTextureCoord.xy;\n}\n", PIXELATION_FRAGMENT_SHADER);
        setPixel(f);
    }

    public void setFrameSize(int i, int i2) {
        super.setFrameSize(i, i2);
        this.imageWidthFactor = 1.0f / ((float) i);
        this.imageHeightFactor = 1.0f / ((float) i2);
    }

    public void onDraw() {
        GLES20.glUniform1f(getHandle("pixel"), this.pixel);
        GLES20.glUniform1f(getHandle("imageWidthFactor"), this.imageWidthFactor);
        GLES20.glUniform1f(getHandle("imageHeightFactor"), this.imageHeightFactor);
    }

    public void setPixel(float f) {
        this.pixel = f;
    }
}
