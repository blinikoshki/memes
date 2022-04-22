package editor.gpu.gpuimage.filter;

import android.opengl.GLES20;

public class GlPhotoHighlightShadowFilter extends GlPhotoFilter {
    public static final String HIGHLIGHT_SHADOW_FRAGMENT_SHADER = " uniform sampler2D inputImageTexture;\n varying highp vec2 textureCoordinate;\n  \n uniform lowp float shadows;\n uniform lowp float highlights;\n \n const mediump vec3 luminanceWeighting = vec3(0.3, 0.3, 0.3);\n \n void main()\n {\n \tlowp vec4 source = texture2D(inputImageTexture, textureCoordinate);\n \tmediump float luminance = dot(source.rgb, luminanceWeighting);\n \n \tmediump float shadow = clamp((pow(luminance, 1.0/(shadows+1.0)) + (-0.76)*pow(luminance, 2.0/(shadows+1.0))) - luminance, 0.0, 1.0);\n \tmediump float highlight = clamp((1.0 - (pow(1.0-luminance, 1.0/(2.0-highlights)) + (-0.8)*pow(1.0-luminance, 2.0/(2.0-highlights)))) - luminance, -1.0, 0.0);\n \tlowp vec3 result = vec3(0.0, 0.0, 0.0) + ((luminance + shadow + highlight) - 0.0) * ((source.rgb - vec3(0.0, 0.0, 0.0))/(luminance - 0.0));\n \n \tgl_FragColor = vec4(result.rgb, source.a);\n }";
    private float highlights;
    private int highlightsLocation;
    private float shadows;
    private int shadowsLocation;

    public GlPhotoHighlightShadowFilter() {
        this(0.0f, 1.0f);
    }

    public GlPhotoHighlightShadowFilter(float f, float f2) {
        super(GlPhotoFilter.NO_FILTER_VERTEX_SHADER, HIGHLIGHT_SHADOW_FRAGMENT_SHADER);
        this.highlights = f2;
        this.shadows = f;
    }

    public void onInit() {
        super.onInit();
        this.highlightsLocation = GLES20.glGetUniformLocation(getProgram(), "highlights");
        this.shadowsLocation = GLES20.glGetUniformLocation(getProgram(), "shadows");
    }

    public void onInitialized() {
        super.onInitialized();
        setHighlights(this.highlights);
        setShadows(this.shadows);
    }

    public void setHighlights(float f) {
        this.highlights = f;
        setFloat(this.highlightsLocation, f);
    }

    public void setShadows(float f) {
        this.shadows = f;
        setFloat(this.shadowsLocation, f);
    }
}
