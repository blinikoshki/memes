package editor.gpu.gpuimage.filter;

import android.opengl.GLES20;

public class GlPhotoWhiteBalanceFilter extends GlPhotoFilter {
    public static final String WHITE_BALANCE_FRAGMENT_SHADER = "uniform sampler2D inputImageTexture;\nvarying highp vec2 textureCoordinate;\n \nuniform lowp float temperature;\nuniform lowp float tint;\n\nconst lowp vec3 warmFilter = vec3(0.93, 0.54, 0.0);\n\nconst mediump mat3 RGBtoYIQ = mat3(0.299, 0.587, 0.114, 0.596, -0.274, -0.322, 0.212, -0.523, 0.311);\nconst mediump mat3 YIQtoRGB = mat3(1.0, 0.956, 0.621, 1.0, -0.272, -0.647, 1.0, -1.105, 1.702);\n\nvoid main()\n{\n\tlowp vec4 source = texture2D(inputImageTexture, textureCoordinate);\n\t\n\tmediump vec3 yiq = RGBtoYIQ * source.rgb; //adjusting tint\n\tyiq.b = clamp(yiq.b + tint*0.5226*0.1, -0.5226, 0.5226);\n\tlowp vec3 rgb = YIQtoRGB * yiq;\n\n\tlowp vec3 processed = vec3(\n\t\t(rgb.r < 0.5 ? (2.0 * rgb.r * warmFilter.r) : (1.0 - 2.0 * (1.0 - rgb.r) * (1.0 - warmFilter.r))), //adjusting temperature\n\t\t(rgb.g < 0.5 ? (2.0 * rgb.g * warmFilter.g) : (1.0 - 2.0 * (1.0 - rgb.g) * (1.0 - warmFilter.g))), \n\t\t(rgb.b < 0.5 ? (2.0 * rgb.b * warmFilter.b) : (1.0 - 2.0 * (1.0 - rgb.b) * (1.0 - warmFilter.b))));\n\n\tgl_FragColor = vec4(mix(rgb, processed, temperature), source.a);\n}";
    private float temperature;
    private int temperatureLocation;
    private float tint;
    private int tintLocation;

    public GlPhotoWhiteBalanceFilter() {
        this(5000.0f, 0.0f);
    }

    public GlPhotoWhiteBalanceFilter(float f, float f2) {
        super(GlPhotoFilter.NO_FILTER_VERTEX_SHADER, WHITE_BALANCE_FRAGMENT_SHADER);
        this.temperature = f;
        this.tint = f2;
    }

    public void onInit() {
        super.onInit();
        this.temperatureLocation = GLES20.glGetUniformLocation(getProgram(), "temperature");
        this.tintLocation = GLES20.glGetUniformLocation(getProgram(), "tint");
    }

    public void onInitialized() {
        super.onInitialized();
        setTemperature(this.temperature);
        setTint(this.tint);
    }

    public void setTemperature(float f) {
        this.temperature = f;
        setFloat(this.temperatureLocation, (float) ((((double) f) - 5000.0d) * (f < 5000.0f ? 4.0E-4d : 6.0E-5d)));
    }

    public void setTint(float f) {
        this.tint = f;
        setFloat(this.tintLocation, (float) (((double) f) / 100.0d));
    }
}
