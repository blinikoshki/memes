package editor.gpu.gpuimage.filter;

import android.opengl.GLES20;

public class GlPhotoSaturationFilter extends GlPhotoFilter {
    public static final String SATURATION_FRAGMENT_SHADER = " varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform lowp float saturation;\n \n // Values from \"Graphics Shaders: Theory and Practice\" by Bailey and Cunningham\n const mediump vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);\n \n void main()\n {\n    lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n    lowp float luminance = dot(textureColor.rgb, luminanceWeighting);\n    lowp vec3 greyScaleColor = vec3(luminance);\n    \n    gl_FragColor = vec4(mix(greyScaleColor, textureColor.rgb, saturation), textureColor.w);\n     \n }";
    private float saturation;
    private int saturationLocation;

    public GlPhotoSaturationFilter() {
        this(1.0f);
    }

    public GlPhotoSaturationFilter(float f) {
        super(GlPhotoFilter.NO_FILTER_VERTEX_SHADER, SATURATION_FRAGMENT_SHADER);
        this.saturation = f;
    }

    public void onInit() {
        super.onInit();
        this.saturationLocation = GLES20.glGetUniformLocation(getProgram(), "saturation");
    }

    public void onInitialized() {
        super.onInitialized();
        setSaturation(this.saturation);
    }

    public void setSaturation(float f) {
        this.saturation = f;
        setFloat(this.saturationLocation, f);
    }
}
