package editor.gpu.gpuvideo.egl.filter;

import android.opengl.GLES20;

public class GlVideoSharpenFilter extends GlVideoFilter {
    private static final String FRAGMENT_SHADER = "precision highp float;uniform lowp sampler2D sTexture;varying highp vec2 textureCoordinate;varying highp vec2 leftTextureCoordinate;varying highp vec2 rightTextureCoordinate;varying highp vec2 topTextureCoordinate;varying highp vec2 bottomTextureCoordinate;varying float centerMultiplier;varying float edgeMultiplier;void main() {mediump vec3 textureColor       = texture2D(sTexture, textureCoordinate).rgb;mediump vec3 leftTextureColor   = texture2D(sTexture, leftTextureCoordinate).rgb;mediump vec3 rightTextureColor  = texture2D(sTexture, rightTextureCoordinate).rgb;mediump vec3 topTextureColor    = texture2D(sTexture, topTextureCoordinate).rgb;mediump vec3 bottomTextureColor = texture2D(sTexture, bottomTextureCoordinate).rgb;gl_FragColor = vec4((textureColor * centerMultiplier - (leftTextureColor * edgeMultiplier + rightTextureColor * edgeMultiplier + topTextureColor * edgeMultiplier + bottomTextureColor * edgeMultiplier)), texture2D(sTexture, bottomTextureCoordinate).w);}";
    private static final String VERTEX_SHADER = "attribute vec4 aPosition;attribute vec4 aTextureCoord;uniform float imageWidthFactor;uniform float imageHeightFactor;uniform float sharpness;varying highp vec2 textureCoordinate;varying highp vec2 leftTextureCoordinate;varying highp vec2 rightTextureCoordinate;varying highp vec2 topTextureCoordinate;varying highp vec2 bottomTextureCoordinate;varying float centerMultiplier;varying float edgeMultiplier;void main() {gl_Position = aPosition;mediump vec2 widthStep = vec2(imageWidthFactor, 0.0);mediump vec2 heightStep = vec2(0.0, imageHeightFactor);textureCoordinate       = aTextureCoord.xy;leftTextureCoordinate   = textureCoordinate - widthStep;rightTextureCoordinate  = textureCoordinate + widthStep;topTextureCoordinate    = textureCoordinate + heightStep;bottomTextureCoordinate = textureCoordinate - heightStep;centerMultiplier = 1.0 + 4.0 * sharpness;edgeMultiplier = sharpness;}";
    private float imageHeightFactor = 0.004f;
    private float imageWidthFactor = 0.004f;
    private float sharpness = 1.0f;

    public GlVideoSharpenFilter() {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
    }

    public GlVideoSharpenFilter(float f) {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        setSharpness(f);
    }

    public float getSharpness() {
        return this.sharpness;
    }

    public void setSharpness(float f) {
        this.sharpness = f;
    }

    public void setFrameSize(int i, int i2) {
        this.imageWidthFactor = 1.0f / ((float) i);
        this.imageHeightFactor = 1.0f / ((float) i2);
    }

    public void onDraw() {
        GLES20.glUniform1f(getHandle("imageWidthFactor"), this.imageWidthFactor);
        GLES20.glUniform1f(getHandle("imageHeightFactor"), this.imageHeightFactor);
        GLES20.glUniform1f(getHandle("sharpness"), this.sharpness);
    }
}
