package editor.gpu.gpuvideo.egl.filter;

import android.opengl.GLES20;

public class GlVideoLuminanceThresholdFilter extends GlVideoFilter {
    private static final String LUMINANCE_THRESHOLD_FRAGMENT_SHADER = "precision mediump float;varying highp vec2 vTextureCoord;\n\nuniform lowp sampler2D sTexture;\nuniform highp float threshold;\n\nconst highp vec3 W = vec3(0.2125, 0.7154, 0.0721);\n\nvoid main()\n{\n    highp vec4 textureColor = texture2D(sTexture, vTextureCoord);\n    highp float luminance = dot(textureColor.rgb, W);\n    highp float thresholdResult = step(threshold, luminance);\n    \n    gl_FragColor = vec4(vec3(thresholdResult), textureColor.w);\n}";
    private float threshold = 0.5f;

    public GlVideoLuminanceThresholdFilter() {
        super("attribute highp vec4 aPosition;\nattribute highp vec4 aTextureCoord;\nvarying highp vec2 vTextureCoord;\nvoid main() {\ngl_Position = aPosition;\nvTextureCoord = aTextureCoord.xy;\n}\n", LUMINANCE_THRESHOLD_FRAGMENT_SHADER);
    }

    public void setThreshold(float f) {
        this.threshold = f;
    }

    public void onDraw() {
        GLES20.glUniform1f(getHandle("threshold"), this.threshold);
    }
}
