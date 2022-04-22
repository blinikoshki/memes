package editor.gpu.gpuimage.filter;

import android.opengl.GLES20;

public class GlPhotoVibranceFilter extends GlPhotoFilter {
    public static final String VIBRANCE_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\nuniform lowp float vibrance;\n\nvoid main() {\n    lowp vec4 color = texture2D(inputImageTexture, textureCoordinate);\n    lowp float average = (color.r + color.g + color.b) / 3.0;\n    lowp float mx = max(color.r, max(color.g, color.b));\n    lowp float amt = (mx - average) * (-vibrance * 3.0);\n    color.rgb = mix(color.rgb, vec3(mx), amt);\n    gl_FragColor = color;\n}";
    private float vibrance;
    private int vibranceLocation;

    public void onInit() {
        super.onInit();
        this.vibranceLocation = GLES20.glGetUniformLocation(getProgram(), "vibrance");
    }

    public GlPhotoVibranceFilter() {
        this(0.0f);
    }

    public GlPhotoVibranceFilter(float f) {
        super(GlPhotoFilter.NO_FILTER_VERTEX_SHADER, VIBRANCE_FRAGMENT_SHADER);
        this.vibrance = f;
    }

    public void onInitialized() {
        super.onInitialized();
        setVibrance(this.vibrance);
    }

    public void setVibrance(float f) {
        this.vibrance = f;
        if (isInitialized()) {
            setFloat(this.vibranceLocation, f);
        }
    }
}
