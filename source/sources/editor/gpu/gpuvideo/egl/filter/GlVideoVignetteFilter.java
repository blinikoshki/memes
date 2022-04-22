package editor.gpu.gpuvideo.egl.filter;

import android.opengl.GLES20;

public class GlVideoVignetteFilter extends GlVideoFilter {
    private static final String FRAGMENT_SHADER = "precision mediump float;varying vec2 vTextureCoord;uniform lowp sampler2D sTexture;uniform lowp vec2 vignetteCenter;uniform highp float vignetteStart;uniform highp float vignetteEnd;void main() {lowp vec3 rgb = texture2D(sTexture, vTextureCoord).rgb;lowp float d = distance(vTextureCoord, vec2(vignetteCenter.x, vignetteCenter.y));lowp float percent = smoothstep(vignetteStart, vignetteEnd, d);gl_FragColor = vec4(mix(rgb.x, 0.0, percent), mix(rgb.y, 0.0, percent), mix(rgb.z, 0.0, percent), 1.0);}";
    private float vignetteCenterX = 0.5f;
    private float vignetteCenterY = 0.5f;
    private float vignetteEnd = 0.85f;
    private float vignetteStart = 0.2f;

    public GlVideoVignetteFilter() {
        super("attribute highp vec4 aPosition;\nattribute highp vec4 aTextureCoord;\nvarying highp vec2 vTextureCoord;\nvoid main() {\ngl_Position = aPosition;\nvTextureCoord = aTextureCoord.xy;\n}\n", FRAGMENT_SHADER);
    }

    public float getVignetteStart() {
        return this.vignetteStart;
    }

    public void setVignetteStart(float f) {
        this.vignetteStart = f;
    }

    public float getVignetteEnd() {
        return this.vignetteEnd;
    }

    public void setVignetteEnd(float f) {
        this.vignetteEnd = f;
    }

    public void onDraw() {
        GLES20.glUniform2f(getHandle("vignetteCenter"), this.vignetteCenterX, this.vignetteCenterY);
        GLES20.glUniform1f(getHandle("vignetteStart"), this.vignetteStart);
        GLES20.glUniform1f(getHandle("vignetteEnd"), this.vignetteEnd);
    }
}
