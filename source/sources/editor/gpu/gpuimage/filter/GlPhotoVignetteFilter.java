package editor.gpu.gpuimage.filter;

import android.graphics.PointF;
import android.opengl.GLES20;

public class GlPhotoVignetteFilter extends GlPhotoFilter {
    public static final String VIGNETTING_FRAGMENT_SHADER = " uniform sampler2D inputImageTexture;\n varying highp vec2 textureCoordinate;\n \n uniform lowp vec2 vignetteCenter;\n uniform lowp vec3 vignetteColor;\n uniform highp float vignetteStart;\n uniform highp float vignetteEnd;\n \n void main()\n {\n     /*\n     lowp vec3 rgb = texture2D(inputImageTexture, textureCoordinate).rgb;\n     lowp float d = distance(textureCoordinate, vec2(0.5,0.5));\n     rgb *= (1.0 - smoothstep(vignetteStart, vignetteEnd, d));\n     gl_FragColor = vec4(vec3(rgb),1.0);\n      */\n     \n     lowp vec3 rgb = texture2D(inputImageTexture, textureCoordinate).rgb;\n     lowp float d = distance(textureCoordinate, vec2(vignetteCenter.x, vignetteCenter.y));\n     lowp float percent = smoothstep(vignetteStart, vignetteEnd, d);\n     gl_FragColor = vec4(mix(rgb.x, vignetteColor.x, percent), mix(rgb.y, vignetteColor.y, percent), mix(rgb.z, vignetteColor.z, percent), 1.0);\n }";
    private PointF vignetteCenter;
    private int vignetteCenterLocation;
    private float[] vignetteColor;
    private int vignetteColorLocation;
    private float vignetteEnd;
    private int vignetteEndLocation;
    private float vignetteStart;
    private int vignetteStartLocation;

    public GlPhotoVignetteFilter() {
        this(new PointF(), new float[]{0.0f, 0.0f, 0.0f}, 0.3f, 0.75f);
    }

    public GlPhotoVignetteFilter(PointF pointF, float[] fArr, float f, float f2) {
        super(GlPhotoFilter.NO_FILTER_VERTEX_SHADER, VIGNETTING_FRAGMENT_SHADER);
        this.vignetteCenter = pointF;
        this.vignetteColor = fArr;
        this.vignetteStart = f;
        this.vignetteEnd = f2;
    }

    public void onInit() {
        super.onInit();
        this.vignetteCenterLocation = GLES20.glGetUniformLocation(getProgram(), "vignetteCenter");
        this.vignetteColorLocation = GLES20.glGetUniformLocation(getProgram(), "vignetteColor");
        this.vignetteStartLocation = GLES20.glGetUniformLocation(getProgram(), "vignetteStart");
        this.vignetteEndLocation = GLES20.glGetUniformLocation(getProgram(), "vignetteEnd");
    }

    public void onInitialized() {
        super.onInitialized();
        setVignetteCenter(this.vignetteCenter);
        setVignetteColor(this.vignetteColor);
        setVignetteStart(this.vignetteStart);
        setVignetteEnd(this.vignetteEnd);
    }

    public void setVignetteCenter(PointF pointF) {
        this.vignetteCenter = pointF;
        setPoint(this.vignetteCenterLocation, pointF);
    }

    public void setVignetteColor(float[] fArr) {
        this.vignetteColor = fArr;
        setFloatVec3(this.vignetteColorLocation, fArr);
    }

    public void setVignetteStart(float f) {
        this.vignetteStart = f;
        setFloat(this.vignetteStartLocation, f);
    }

    public void setVignetteEnd(float f) {
        this.vignetteEnd = f;
        setFloat(this.vignetteEndLocation, f);
    }
}
