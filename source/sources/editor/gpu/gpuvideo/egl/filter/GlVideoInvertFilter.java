package editor.gpu.gpuvideo.egl.filter;

public class GlVideoInvertFilter extends GlVideoFilter {
    private static final String FRAGMENT_SHADER = "precision mediump float;varying vec2 vTextureCoord;uniform lowp sampler2D sTexture;void main() {lowp vec4 color = texture2D(sTexture, vTextureCoord);gl_FragColor = vec4((1.0 - color.rgb), color.w);}";

    public GlVideoInvertFilter() {
        super("attribute highp vec4 aPosition;\nattribute highp vec4 aTextureCoord;\nvarying highp vec2 vTextureCoord;\nvoid main() {\ngl_Position = aPosition;\nvTextureCoord = aTextureCoord.xy;\n}\n", FRAGMENT_SHADER);
    }
}
