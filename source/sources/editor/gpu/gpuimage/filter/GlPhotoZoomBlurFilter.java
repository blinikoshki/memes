package editor.gpu.gpuimage.filter;

import android.graphics.PointF;
import android.opengl.GLES20;

public class GlPhotoZoomBlurFilter extends GlPhotoFilter {
    public static final String ZOOM_BLUR_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nuniform highp vec2 blurCenter;\nuniform highp float blurSize;\n\nvoid main()\n{\n    // TODO: Do a more intelligent scaling based on resolution here\n    highp vec2 samplingOffset = 1.0/100.0 * (blurCenter - textureCoordinate) * blurSize;\n    \n    lowp vec4 fragmentColor = texture2D(inputImageTexture, textureCoordinate) * 0.18;\n    fragmentColor += texture2D(inputImageTexture, textureCoordinate + samplingOffset) * 0.15;\n    fragmentColor += texture2D(inputImageTexture, textureCoordinate + (2.0 * samplingOffset)) *  0.12;\n    fragmentColor += texture2D(inputImageTexture, textureCoordinate + (3.0 * samplingOffset)) * 0.09;\n    fragmentColor += texture2D(inputImageTexture, textureCoordinate + (4.0 * samplingOffset)) * 0.05;\n    fragmentColor += texture2D(inputImageTexture, textureCoordinate - samplingOffset) * 0.15;\n    fragmentColor += texture2D(inputImageTexture, textureCoordinate - (2.0 * samplingOffset)) *  0.12;\n    fragmentColor += texture2D(inputImageTexture, textureCoordinate - (3.0 * samplingOffset)) * 0.09;\n    fragmentColor += texture2D(inputImageTexture, textureCoordinate - (4.0 * samplingOffset)) * 0.05;\n    \n    gl_FragColor = fragmentColor;\n}\n";
    private PointF blurCenter;
    private int blurCenterLocation;
    private float blurSize;
    private int blurSizeLocation;

    public GlPhotoZoomBlurFilter() {
        this(new PointF(0.5f, 0.5f), 1.0f);
    }

    public GlPhotoZoomBlurFilter(PointF pointF, float f) {
        super(GlPhotoFilter.NO_FILTER_VERTEX_SHADER, ZOOM_BLUR_FRAGMENT_SHADER);
        this.blurCenter = pointF;
        this.blurSize = f;
    }

    public void onInit() {
        super.onInit();
        this.blurCenterLocation = GLES20.glGetUniformLocation(getProgram(), "blurCenter");
        this.blurSizeLocation = GLES20.glGetUniformLocation(getProgram(), "blurSize");
    }

    public void onInitialized() {
        super.onInitialized();
        setBlurCenter(this.blurCenter);
        setBlurSize(this.blurSize);
    }

    public void setBlurCenter(PointF pointF) {
        this.blurCenter = pointF;
        setPoint(this.blurCenterLocation, pointF);
    }

    public void setBlurSize(float f) {
        this.blurSize = f;
        setFloat(this.blurSizeLocation, f);
    }
}
