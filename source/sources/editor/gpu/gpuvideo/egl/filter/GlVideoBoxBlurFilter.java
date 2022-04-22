package editor.gpu.gpuvideo.egl.filter;

import android.opengl.GLES20;

public class GlVideoBoxBlurFilter extends GlVideoFilter {
    private static final String FRAGMENT_SHADER = "precision mediump float;uniform lowp sampler2D sTexture;varying highp vec2 centerTextureCoordinate;varying highp vec2 oneStepLeftTextureCoordinate;varying highp vec2 twoStepsLeftTextureCoordinate;varying highp vec2 oneStepRightTextureCoordinate;varying highp vec2 twoStepsRightTextureCoordinate;void main() {lowp vec4 color = texture2D(sTexture, centerTextureCoordinate) * 0.2;color += texture2D(sTexture, oneStepLeftTextureCoordinate) * 0.2;color += texture2D(sTexture, oneStepRightTextureCoordinate) * 0.2;color += texture2D(sTexture, twoStepsLeftTextureCoordinate) * 0.2;color += texture2D(sTexture, twoStepsRightTextureCoordinate) * 0.2;gl_FragColor = color;}";
    private static final String VERTEX_SHADER = "attribute vec4 aPosition;attribute vec4 aTextureCoord;uniform highp float texelWidthOffset;uniform highp float texelHeightOffset;uniform highp float blurSize;varying highp vec2 centerTextureCoordinate;varying highp vec2 oneStepLeftTextureCoordinate;varying highp vec2 twoStepsLeftTextureCoordinate;varying highp vec2 oneStepRightTextureCoordinate;varying highp vec2 twoStepsRightTextureCoordinate;void main() {gl_Position = aPosition;vec2 firstOffset = vec2(1.5 * texelWidthOffset, 1.5 * texelHeightOffset) * blurSize;vec2 secondOffset = vec2(3.5 * texelWidthOffset, 3.5 * texelHeightOffset) * blurSize;centerTextureCoordinate = aTextureCoord.xy;oneStepLeftTextureCoordinate = centerTextureCoordinate - firstOffset;twoStepsLeftTextureCoordinate = centerTextureCoordinate - secondOffset;oneStepRightTextureCoordinate = centerTextureCoordinate + firstOffset;twoStepsRightTextureCoordinate = centerTextureCoordinate + secondOffset;}";
    private float blurSize = 1.0f;
    private float texelHeightOffset = 0.003f;
    private float texelWidthOffset = 0.003f;

    public GlVideoBoxBlurFilter() {
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
