package editor.gpu.gpuimage.filter;

import android.opengl.GLES20;

public class GlPhotoFalseColorFilter extends GlPhotoFilter {
    public static final String FALSECOLOR_FRAGMENT_SHADER = "precision lowp float;\n\nvarying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\nuniform float intensity;\nuniform vec3 firstColor;\nuniform vec3 secondColor;\n\nconst mediump vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);\n\nvoid main()\n{\nlowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\nfloat luminance = dot(textureColor.rgb, luminanceWeighting);\n\ngl_FragColor = vec4( mix(firstColor.rgb, secondColor.rgb, luminance), textureColor.a);\n}\n";
    private float[] firstColor;
    private int firstColorLocation;
    private float[] secondColor;
    private int secondColorLocation;

    public GlPhotoFalseColorFilter() {
        this(0.0f, 0.0f, 0.5f, 1.0f, 0.0f, 0.0f);
    }

    public GlPhotoFalseColorFilter(float f, float f2, float f3, float f4, float f5, float f6) {
        this(new float[]{f, f2, f3}, new float[]{f4, f5, f6});
    }

    public GlPhotoFalseColorFilter(float[] fArr, float[] fArr2) {
        super(GlPhotoFilter.NO_FILTER_VERTEX_SHADER, FALSECOLOR_FRAGMENT_SHADER);
        this.firstColor = fArr;
        this.secondColor = fArr2;
    }

    public void onInit() {
        super.onInit();
        this.firstColorLocation = GLES20.glGetUniformLocation(getProgram(), "firstColor");
        this.secondColorLocation = GLES20.glGetUniformLocation(getProgram(), "secondColor");
    }

    public void onInitialized() {
        super.onInitialized();
        setFirstColor(this.firstColor);
        setSecondColor(this.secondColor);
    }

    public void setFirstColor(float[] fArr) {
        this.firstColor = fArr;
        setFloatVec3(this.firstColorLocation, fArr);
    }

    public void setSecondColor(float[] fArr) {
        this.secondColor = fArr;
        setFloatVec3(this.secondColorLocation, fArr);
    }
}
