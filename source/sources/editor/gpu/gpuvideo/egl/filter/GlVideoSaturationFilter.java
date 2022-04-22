package editor.gpu.gpuvideo.egl.filter;

import android.opengl.GLES20;

public class GlVideoSaturationFilter extends GlVideoFilter {
    private static final String SATURATION_FRAGMENT_SHADER = "precision mediump float; varying vec2 vTextureCoord;\n \n uniform lowp sampler2D sTexture;\n uniform lowp float saturation;\n \n const mediump vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);\n \n void main()\n {\n    lowp vec4 textureColor = texture2D(sTexture, vTextureCoord);\n    lowp float luminance = dot(textureColor.rgb, luminanceWeighting);\n    lowp vec3 greyScaleColor = vec3(luminance);\n    \n    gl_FragColor = vec4(mix(greyScaleColor, textureColor.rgb, saturation), textureColor.w);\n     \n }";
    private float saturation = 1.0f;

    public GlVideoSaturationFilter() {
        super("attribute highp vec4 aPosition;\nattribute highp vec4 aTextureCoord;\nvarying highp vec2 vTextureCoord;\nvoid main() {\ngl_Position = aPosition;\nvTextureCoord = aTextureCoord.xy;\n}\n", SATURATION_FRAGMENT_SHADER);
    }

    public GlVideoSaturationFilter(float f) {
        super("attribute highp vec4 aPosition;\nattribute highp vec4 aTextureCoord;\nvarying highp vec2 vTextureCoord;\nvoid main() {\ngl_Position = aPosition;\nvTextureCoord = aTextureCoord.xy;\n}\n", SATURATION_FRAGMENT_SHADER);
        setSaturation(f);
    }

    public void setSaturation(float f) {
        this.saturation = f;
    }

    public void onDraw() {
        GLES20.glUniform1f(getHandle("saturation"), this.saturation);
    }
}
