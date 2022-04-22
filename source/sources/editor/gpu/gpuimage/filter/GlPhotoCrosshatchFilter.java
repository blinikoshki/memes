package editor.gpu.gpuimage.filter;

import android.opengl.GLES20;

public class GlPhotoCrosshatchFilter extends GlPhotoFilter {
    public static final String CROSSHATCH_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform highp float crossHatchSpacing;\nuniform highp float lineWidth;\nconst highp vec3 W = vec3(0.2125, 0.7154, 0.0721);\nvoid main()\n{\nhighp float luminance = dot(texture2D(inputImageTexture, textureCoordinate).rgb, W);\nlowp vec4 colorToDisplay = vec4(1.0, 1.0, 1.0, 1.0);\nif (luminance < 1.00)\n{\nif (mod(textureCoordinate.x + textureCoordinate.y, crossHatchSpacing) <= lineWidth)\n{\ncolorToDisplay = vec4(0.0, 0.0, 0.0, 1.0);\n}\n}\nif (luminance < 0.75)\n{\nif (mod(textureCoordinate.x - textureCoordinate.y, crossHatchSpacing) <= lineWidth)\n{\ncolorToDisplay = vec4(0.0, 0.0, 0.0, 1.0);\n}\n}\nif (luminance < 0.50)\n{\nif (mod(textureCoordinate.x + textureCoordinate.y - (crossHatchSpacing / 2.0), crossHatchSpacing) <= lineWidth)\n{\ncolorToDisplay = vec4(0.0, 0.0, 0.0, 1.0);\n}\n}\nif (luminance < 0.3)\n{\nif (mod(textureCoordinate.x - textureCoordinate.y - (crossHatchSpacing / 2.0), crossHatchSpacing) <= lineWidth)\n{\ncolorToDisplay = vec4(0.0, 0.0, 0.0, 1.0);\n}\n}\ngl_FragColor = colorToDisplay;\n}\n";
    private float crossHatchSpacing;
    private int crossHatchSpacingLocation;
    private float lineWidth;
    private int lineWidthLocation;

    public GlPhotoCrosshatchFilter() {
        this(0.03f, 0.003f);
    }

    public GlPhotoCrosshatchFilter(float f, float f2) {
        super(GlPhotoFilter.NO_FILTER_VERTEX_SHADER, CROSSHATCH_FRAGMENT_SHADER);
        this.crossHatchSpacing = f;
        this.lineWidth = f2;
    }

    public void onInit() {
        super.onInit();
        this.crossHatchSpacingLocation = GLES20.glGetUniformLocation(getProgram(), "crossHatchSpacing");
        this.lineWidthLocation = GLES20.glGetUniformLocation(getProgram(), "lineWidth");
    }

    public void onInitialized() {
        super.onInitialized();
        setCrossHatchSpacing(this.crossHatchSpacing);
        setLineWidth(this.lineWidth);
    }

    public void setCrossHatchSpacing(float f) {
        float outputWidth = getOutputWidth() != 0 ? 1.0f / ((float) getOutputWidth()) : 4.8828125E-4f;
        if (f < outputWidth) {
            this.crossHatchSpacing = outputWidth;
        } else {
            this.crossHatchSpacing = f;
        }
        setFloat(this.crossHatchSpacingLocation, this.crossHatchSpacing);
    }

    public void setLineWidth(float f) {
        this.lineWidth = f;
        setFloat(this.lineWidthLocation, f);
    }
}
