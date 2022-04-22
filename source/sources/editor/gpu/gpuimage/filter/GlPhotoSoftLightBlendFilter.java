package editor.gpu.gpuimage.filter;

public class GlPhotoSoftLightBlendFilter extends GlPhotoTwoInputFilter {
    public static final String SOFT_LIGHT_BLEND_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\n varying highp vec2 textureCoordinate2;\n\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n void main()\n {\n     mediump vec4 base = texture2D(inputImageTexture, textureCoordinate);\n     mediump vec4 overlay = texture2D(inputImageTexture2, textureCoordinate2);\n     \n     gl_FragColor = base * (overlay.a * (base / base.a) + (2.0 * overlay * (1.0 - (base / base.a)))) + overlay * (1.0 - base.a) + base * (1.0 - overlay.a);\n }";

    public GlPhotoSoftLightBlendFilter() {
        super(SOFT_LIGHT_BLEND_FRAGMENT_SHADER);
    }
}
