package editor.gpu.gpuimage.filter;

import android.graphics.PointF;
import android.opengl.GLES20;

public class GlPhotoSwirlFilter extends GlPhotoFilter {
    public static final String SWIRL_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nuniform highp vec2 center;\nuniform highp float radius;\nuniform highp float angle;\n\nvoid main()\n{\nhighp vec2 textureCoordinateToUse = textureCoordinate;\nhighp float dist = distance(center, textureCoordinate);\nif (dist < radius)\n{\ntextureCoordinateToUse -= center;\nhighp float percent = (radius - dist) / radius;\nhighp float theta = percent * percent * angle * 8.0;\nhighp float s = sin(theta);\nhighp float c = cos(theta);\ntextureCoordinateToUse = vec2(dot(textureCoordinateToUse, vec2(c, -s)), dot(textureCoordinateToUse, vec2(s, c)));\ntextureCoordinateToUse += center;\n}\n\ngl_FragColor = texture2D(inputImageTexture, textureCoordinateToUse );\n\n}\n";
    private float angle;
    private int angleLocation;
    private PointF center;
    private int centerLocation;
    private float radius;
    private int radiusLocation;

    public GlPhotoSwirlFilter() {
        this(0.5f, 1.0f, new PointF(0.5f, 0.5f));
    }

    public GlPhotoSwirlFilter(float f, float f2, PointF pointF) {
        super(GlPhotoFilter.NO_FILTER_VERTEX_SHADER, SWIRL_FRAGMENT_SHADER);
        this.radius = f;
        this.angle = f2;
        this.center = pointF;
    }

    public void onInit() {
        super.onInit();
        this.angleLocation = GLES20.glGetUniformLocation(getProgram(), "angle");
        this.radiusLocation = GLES20.glGetUniformLocation(getProgram(), "radius");
        this.centerLocation = GLES20.glGetUniformLocation(getProgram(), TtmlNode.CENTER);
    }

    public void onInitialized() {
        super.onInitialized();
        setRadius(this.radius);
        setAngle(this.angle);
        setCenter(this.center);
    }

    public void setRadius(float f) {
        this.radius = f;
        setFloat(this.radiusLocation, f);
    }

    public void setAngle(float f) {
        this.angle = f;
        setFloat(this.angleLocation, f);
    }

    public void setCenter(PointF pointF) {
        this.center = pointF;
        setPoint(this.centerLocation, pointF);
    }
}
