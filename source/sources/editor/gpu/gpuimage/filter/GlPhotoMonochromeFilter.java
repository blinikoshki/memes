package editor.gpu.gpuimage.filter;

import android.opengl.GLES20;

public class GlPhotoMonochromeFilter extends GlPhotoFilter {
    public static final String MONOCHROME_FRAGMENT_SHADER = " precision lowp float;\n  \n  varying highp vec2 textureCoordinate;\n  \n  uniform sampler2D inputImageTexture;\n  uniform float intensity;\n  uniform vec3 filterColor;\n  \n  const mediump vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);\n  \n  void main()\n  {\n \t//desat, then apply overlay blend\n \tlowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n \tfloat luminance = dot(textureColor.rgb, luminanceWeighting);\n \t\n \tlowp vec4 desat = vec4(vec3(luminance), 1.0);\n \t\n \t//overlay\n \tlowp vec4 outputColor = vec4(\n                                  (desat.r < 0.5 ? (2.0 * desat.r * filterColor.r) : (1.0 - 2.0 * (1.0 - desat.r) * (1.0 - filterColor.r))),\n                                  (desat.g < 0.5 ? (2.0 * desat.g * filterColor.g) : (1.0 - 2.0 * (1.0 - desat.g) * (1.0 - filterColor.g))),\n                                  (desat.b < 0.5 ? (2.0 * desat.b * filterColor.b) : (1.0 - 2.0 * (1.0 - desat.b) * (1.0 - filterColor.b))),\n                                  1.0\n                                  );\n \t\n \t//which is better, or are they equal?\n \tgl_FragColor = vec4( mix(textureColor.rgb, outputColor.rgb, intensity), textureColor.a);\n  }";
    private float[] color;
    private int filterColorLocation;
    private float intensity;
    private int intensityLocation;

    public GlPhotoMonochromeFilter() {
        this(1.0f, new float[]{0.6f, 0.45f, 0.3f, 1.0f});
    }

    public GlPhotoMonochromeFilter(float f, float[] fArr) {
        super(GlPhotoFilter.NO_FILTER_VERTEX_SHADER, MONOCHROME_FRAGMENT_SHADER);
        this.intensity = f;
        this.color = fArr;
    }

    public void onInit() {
        super.onInit();
        this.intensityLocation = GLES20.glGetUniformLocation(getProgram(), "intensity");
        this.filterColorLocation = GLES20.glGetUniformLocation(getProgram(), "filterColor");
    }

    public void onInitialized() {
        super.onInitialized();
        setIntensity(1.0f);
        setColor(new float[]{0.6f, 0.45f, 0.3f, 1.0f});
    }

    public void setIntensity(float f) {
        this.intensity = f;
        setFloat(this.intensityLocation, f);
    }

    public void setColor(float[] fArr) {
        this.color = fArr;
        setColor(fArr[0], fArr[1], fArr[2]);
    }

    public void setColor(float f, float f2, float f3) {
        setFloatVec3(this.filterColorLocation, new float[]{f, f2, f3});
    }
}
