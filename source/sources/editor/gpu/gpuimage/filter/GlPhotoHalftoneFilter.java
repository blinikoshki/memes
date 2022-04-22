package editor.gpu.gpuimage.filter;

import android.opengl.GLES20;

public class GlPhotoHalftoneFilter extends GlPhotoFilter {
    public static final String HALFTONE_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform highp float fractionalWidthOfPixel;\nuniform highp float aspectRatio;\nconst highp vec3 W = vec3(0.2125, 0.7154, 0.0721);\nvoid main()\n{\n  highp vec2 sampleDivisor = vec2(fractionalWidthOfPixel, fractionalWidthOfPixel / aspectRatio);\n  highp vec2 samplePos = textureCoordinate - mod(textureCoordinate, sampleDivisor) + 0.5 * sampleDivisor;\n  highp vec2 textureCoordinateToUse = vec2(textureCoordinate.x, (textureCoordinate.y * aspectRatio + 0.5 - 0.5 * aspectRatio));\n  highp vec2 adjustedSamplePos = vec2(samplePos.x, (samplePos.y * aspectRatio + 0.5 - 0.5 * aspectRatio));\n  highp float distanceFromSamplePoint = distance(adjustedSamplePos, textureCoordinateToUse);\n  lowp vec3 sampledColor = texture2D(inputImageTexture, samplePos).rgb;\n  highp float dotScaling = 1.0 - dot(sampledColor, W);\n  lowp float checkForPresenceWithinDot = 1.0 - step(distanceFromSamplePoint, (fractionalWidthOfPixel * 0.5) * dotScaling);\n  gl_FragColor = vec4(vec3(checkForPresenceWithinDot), 1.0);\n}";
    private float aspectRatio;
    private int aspectRatioLocation;
    private float fractionalWidthOfAPixel;
    private int fractionalWidthOfPixelLocation;

    public GlPhotoHalftoneFilter() {
        this(0.01f);
    }

    public GlPhotoHalftoneFilter(float f) {
        super(GlPhotoFilter.NO_FILTER_VERTEX_SHADER, HALFTONE_FRAGMENT_SHADER);
        this.fractionalWidthOfAPixel = f;
    }

    public void onInit() {
        super.onInit();
        this.fractionalWidthOfPixelLocation = GLES20.glGetUniformLocation(getProgram(), "fractionalWidthOfPixel");
        this.aspectRatioLocation = GLES20.glGetUniformLocation(getProgram(), "aspectRatio");
    }

    public void onInitialized() {
        super.onInitialized();
        setFractionalWidthOfAPixel(this.fractionalWidthOfAPixel);
        setAspectRatio(this.aspectRatio);
    }

    public void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        setAspectRatio(((float) i2) / ((float) i));
    }

    public void setFractionalWidthOfAPixel(float f) {
        this.fractionalWidthOfAPixel = f;
        setFloat(this.fractionalWidthOfPixelLocation, f);
    }

    public void setAspectRatio(float f) {
        this.aspectRatio = f;
        setFloat(this.aspectRatioLocation, f);
    }
}
