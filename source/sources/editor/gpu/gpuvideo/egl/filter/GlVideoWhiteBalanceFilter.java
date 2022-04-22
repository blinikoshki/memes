package editor.gpu.gpuvideo.egl.filter;

import android.opengl.GLES20;

public class GlVideoWhiteBalanceFilter extends GlVideoFilter {
    private static final String WHITE_BALANCE_FRAGMENT_SHADER = "precision mediump float; uniform lowp sampler2D sTexture;\n varying vec2 vTextureCoord;\n \nuniform lowp float temperature;\nuniform lowp float tint;\n\nconst lowp vec3 warmFilter = vec3(0.93, 0.54, 0.0);\n\nconst mediump mat3 RGBtoYIQ = mat3(0.299, 0.587, 0.114, 0.596, -0.274, -0.322, 0.212, -0.523, 0.311);\nconst mediump mat3 YIQtoRGB = mat3(1.0, 0.956, 0.621, 1.0, -0.272, -0.647, 1.0, -1.105, 1.702);\n\nvoid main()\n{\n\tlowp vec4 source = texture2D(sTexture, vTextureCoord);\n\t\n\tmediump vec3 yiq = RGBtoYIQ * source.rgb; //adjusting tint\n\tyiq.b = clamp(yiq.b + tint*0.5226*0.1, -0.5226, 0.5226);\n\tlowp vec3 rgb = YIQtoRGB * yiq;\n\n\tlowp vec3 processed = vec3(\n\t\t(rgb.r < 0.5 ? (2.0 * rgb.r * warmFilter.r) : (1.0 - 2.0 * (1.0 - rgb.r) * (1.0 - warmFilter.r))), //adjusting temperature\n\t\t(rgb.g < 0.5 ? (2.0 * rgb.g * warmFilter.g) : (1.0 - 2.0 * (1.0 - rgb.g) * (1.0 - warmFilter.g))), \n\t\t(rgb.b < 0.5 ? (2.0 * rgb.b * warmFilter.b) : (1.0 - 2.0 * (1.0 - rgb.b) * (1.0 - warmFilter.b))));\n\n\tgl_FragColor = vec4(mix(rgb, processed, temperature), source.a);\n}";
    private float temperature = 5000.0f;
    private float tint = 0.0f;

    public GlVideoWhiteBalanceFilter() {
        super("attribute highp vec4 aPosition;\nattribute highp vec4 aTextureCoord;\nvarying highp vec2 vTextureCoord;\nvoid main() {\ngl_Position = aPosition;\nvTextureCoord = aTextureCoord.xy;\n}\n", WHITE_BALANCE_FRAGMENT_SHADER);
    }

    public void setTemperature(float f) {
        this.temperature = (float) ((((double) f) - 5000.0d) * (f < 5000.0f ? 4.0E-4d : 6.0E-5d));
    }

    public void setTint(float f) {
        this.tint = (float) (((double) f) / 100.0d);
    }

    public void onDraw() {
        GLES20.glUniform1f(getHandle("temperature"), this.temperature);
        GLES20.glUniform1f(getHandle("tint"), this.tint);
    }
}
