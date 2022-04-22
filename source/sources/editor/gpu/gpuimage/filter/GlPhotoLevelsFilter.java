package editor.gpu.gpuimage.filter;

import android.opengl.GLES20;

public class GlPhotoLevelsFilter extends GlPhotoFilter {
    public static final String LEVELS_FRAGMET_SHADER = " varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform mediump vec3 levelMinimum;\n uniform mediump vec3 levelMiddle;\n uniform mediump vec3 levelMaximum;\n uniform mediump vec3 minOutput;\n uniform mediump vec3 maxOutput;\n \n void main()\n {\n     mediump vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     gl_FragColor = vec4( mix(minOutput, maxOutput, pow(min(max(textureColor.rgb -levelMinimum, vec3(0.0)) / (levelMaximum - levelMinimum  ), vec3(1.0)), 1.0 /levelMiddle)) , textureColor.a);\n }\n";
    private static final String LOGTAG = "GlPhotoLevelsFilter";
    private float[] max;
    private int maxLocation;
    private float[] maxOutput;
    private int maxOutputLocation;
    private float[] mid;
    private int midLocation;
    private float[] min;
    private int minLocation;
    private float[] minOutput;
    private int minOutputLocation;

    public GlPhotoLevelsFilter() {
        this(new float[]{0.0f, 0.0f, 0.0f}, new float[]{1.0f, 1.0f, 1.0f}, new float[]{1.0f, 1.0f, 1.0f}, new float[]{0.0f, 0.0f, 0.0f}, new float[]{1.0f, 1.0f, 1.0f});
    }

    private GlPhotoLevelsFilter(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float[] fArr5) {
        super(GlPhotoFilter.NO_FILTER_VERTEX_SHADER, LEVELS_FRAGMET_SHADER);
        this.min = fArr;
        this.mid = fArr2;
        this.max = fArr3;
        this.minOutput = fArr4;
        this.maxOutput = fArr5;
    }

    public void onInit() {
        super.onInit();
        this.minLocation = GLES20.glGetUniformLocation(getProgram(), "levelMinimum");
        this.midLocation = GLES20.glGetUniformLocation(getProgram(), "levelMiddle");
        this.maxLocation = GLES20.glGetUniformLocation(getProgram(), "levelMaximum");
        this.minOutputLocation = GLES20.glGetUniformLocation(getProgram(), "minOutput");
        this.maxOutputLocation = GLES20.glGetUniformLocation(getProgram(), "maxOutput");
    }

    public void onInitialized() {
        super.onInitialized();
        setMin(0.0f, 1.0f, 1.0f, 0.0f, 1.0f);
        updateUniforms();
    }

    public void updateUniforms() {
        setFloatVec3(this.minLocation, this.min);
        setFloatVec3(this.midLocation, this.mid);
        setFloatVec3(this.maxLocation, this.max);
        setFloatVec3(this.minOutputLocation, this.minOutput);
        setFloatVec3(this.maxOutputLocation, this.maxOutput);
    }

    public void setMin(float f, float f2, float f3, float f4, float f5) {
        setRedMin(f, f2, f3, f4, f5);
        setGreenMin(f, f2, f3, f4, f5);
        setBlueMin(f, f2, f3, f4, f5);
    }

    public void setMin(float f, float f2, float f3) {
        setMin(f, f2, f3, 0.0f, 1.0f);
    }

    public void setRedMin(float f, float f2, float f3, float f4, float f5) {
        this.min[0] = f;
        this.mid[0] = f2;
        this.max[0] = f3;
        this.minOutput[0] = f4;
        this.maxOutput[0] = f5;
        updateUniforms();
    }

    public void setRedMin(float f, float f2, float f3) {
        setRedMin(f, f2, f3, 0.0f, 1.0f);
    }

    public void setGreenMin(float f, float f2, float f3, float f4, float f5) {
        this.min[1] = f;
        this.mid[1] = f2;
        this.max[1] = f3;
        this.minOutput[1] = f4;
        this.maxOutput[1] = f5;
        updateUniforms();
    }

    public void setGreenMin(float f, float f2, float f3) {
        setGreenMin(f, f2, f3, 0.0f, 1.0f);
    }

    public void setBlueMin(float f, float f2, float f3, float f4, float f5) {
        this.min[2] = f;
        this.mid[2] = f2;
        this.max[2] = f3;
        this.minOutput[2] = f4;
        this.maxOutput[2] = f5;
        updateUniforms();
    }

    public void setBlueMin(float f, float f2, float f3) {
        setBlueMin(f, f2, f3, 0.0f, 1.0f);
    }
}
