package editor.gpu.gpuimage.filter;

import android.opengl.GLES20;

public class GlPhotoHazeFilter extends GlPhotoFilter {
    public static final String HAZE_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nuniform lowp float distance;\nuniform highp float slope;\n\nvoid main()\n{\n\t//todo reconsider precision modifiers\t \n\t highp vec4 color = vec4(1.0);//todo reimplement as a parameter\n\n\t highp float  d = textureCoordinate.y * slope  +  distance; \n\n\t highp vec4 c = texture2D(inputImageTexture, textureCoordinate) ; // consider using unpremultiply\n\n\t c = (c - d * color) / (1.0 -d);\n\n\t gl_FragColor = c; //consider using premultiply(c);\n}\n";
    private float distance;
    private int distanceLocation;
    private float slope;
    private int slopeLocation;

    public GlPhotoHazeFilter() {
        this(0.2f, 0.0f);
    }

    public GlPhotoHazeFilter(float f, float f2) {
        super(GlPhotoFilter.NO_FILTER_VERTEX_SHADER, HAZE_FRAGMENT_SHADER);
        this.distance = f;
        this.slope = f2;
    }

    public void onInit() {
        super.onInit();
        this.distanceLocation = GLES20.glGetUniformLocation(getProgram(), "distance");
        this.slopeLocation = GLES20.glGetUniformLocation(getProgram(), "slope");
    }

    public void onInitialized() {
        super.onInitialized();
        setDistance(this.distance);
        setSlope(this.slope);
    }

    public void setDistance(float f) {
        this.distance = f;
        setFloat(this.distanceLocation, f);
    }

    public void setSlope(float f) {
        this.slope = f;
        setFloat(this.slopeLocation, f);
    }
}
