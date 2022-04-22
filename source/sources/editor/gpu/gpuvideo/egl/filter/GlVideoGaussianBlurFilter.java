package editor.gpu.gpuvideo.egl.filter;

import android.opengl.GLES20;

public class GlVideoGaussianBlurFilter extends GlVideoFilter {
    private static final String FRAGMENT_SHADER = "precision mediump float;const lowp int GAUSSIAN_SAMPLES = 9;varying highp vec2 blurCoordinates[GAUSSIAN_SAMPLES];uniform lowp sampler2D sTexture;void main() {lowp vec4 sum = vec4(0.0);sum += texture2D(sTexture, blurCoordinates[0]) * 0.05;sum += texture2D(sTexture, blurCoordinates[1]) * 0.09;sum += texture2D(sTexture, blurCoordinates[2]) * 0.12;sum += texture2D(sTexture, blurCoordinates[3]) * 0.15;sum += texture2D(sTexture, blurCoordinates[4]) * 0.18;sum += texture2D(sTexture, blurCoordinates[5]) * 0.15;sum += texture2D(sTexture, blurCoordinates[6]) * 0.12;sum += texture2D(sTexture, blurCoordinates[7]) * 0.09;sum += texture2D(sTexture, blurCoordinates[8]) * 0.05;gl_FragColor = sum;}";
    private static final String VERTEX_SHADER = "attribute vec4 aPosition;attribute vec4 aTextureCoord;const lowp int GAUSSIAN_SAMPLES = 9;uniform highp float texelWidthOffset;uniform highp float texelHeightOffset;uniform highp float blurSize;varying highp vec2 blurCoordinates[GAUSSIAN_SAMPLES];void main() {gl_Position = aPosition;highp vec2 vTextureCoord = aTextureCoord.xy;int multiplier = 0;highp vec2 blurStep;highp vec2 singleStepOffset = vec2(texelHeightOffset, texelWidthOffset) * blurSize;for (lowp int i = 0; i < GAUSSIAN_SAMPLES; i++) {multiplier = (i - ((GAUSSIAN_SAMPLES - 1) / 2));blurStep = float(multiplier) * singleStepOffset;blurCoordinates[i] = vTextureCoord.xy + blurStep;}}";
    private float blurSize = 0.2f;
    private float texelHeightOffset = 0.01f;
    private float texelWidthOffset = 0.01f;

    public GlVideoGaussianBlurFilter() {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
    }

    public float getTexelWidthOffset() {
        return this.texelWidthOffset;
    }

    public void setTexelWidthOffset(float f) {
        this.texelWidthOffset = f;
    }

    public float getTexelHeightOffset() {
        return this.texelHeightOffset;
    }

    public void setTexelHeightOffset(float f) {
        this.texelHeightOffset = f;
    }

    public float getBlurSize() {
        return this.blurSize;
    }

    public void setBlurSize(float f) {
        this.blurSize = f;
    }

    public void onDraw() {
        GLES20.glUniform1f(getHandle("texelWidthOffset"), this.texelWidthOffset);
        GLES20.glUniform1f(getHandle("texelHeightOffset"), this.texelHeightOffset);
        GLES20.glUniform1f(getHandle("blurSize"), this.blurSize);
    }
}
