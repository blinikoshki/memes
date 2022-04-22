package editor.gpu.gpuvideo.egl.filter;

import android.graphics.PointF;
import android.opengl.GLES20;

public class GlVideoZoomBlurFilter extends GlVideoFilter {
    private static final String ZOOM_BLUR_FRAGMENT_SHADER = "precision mediump float; varying vec2 vTextureCoord;\n\nuniform lowp sampler2D sTexture;\n\nuniform highp vec2 blurCenter;\nuniform highp float blurSize;\n\nvoid main()\n{\n    // TODO: Do a more intelligent scaling based on resolution here\n    highp vec2 samplingOffset = 1.0/100.0 * (blurCenter - vTextureCoord) * blurSize;\n    \n    lowp vec4 fragmentColor = texture2D(sTexture, vTextureCoord) * 0.18;\n    fragmentColor += texture2D(sTexture, vTextureCoord + samplingOffset) * 0.15;\n    fragmentColor += texture2D(sTexture, vTextureCoord + (2.0 * samplingOffset)) *  0.12;\n    fragmentColor += texture2D(sTexture, vTextureCoord + (3.0 * samplingOffset)) * 0.09;\n    fragmentColor += texture2D(sTexture, vTextureCoord + (4.0 * samplingOffset)) * 0.05;\n    fragmentColor += texture2D(sTexture, vTextureCoord - samplingOffset) * 0.15;\n    fragmentColor += texture2D(sTexture, vTextureCoord - (2.0 * samplingOffset)) *  0.12;\n    fragmentColor += texture2D(sTexture, vTextureCoord - (3.0 * samplingOffset)) * 0.09;\n    fragmentColor += texture2D(sTexture, vTextureCoord - (4.0 * samplingOffset)) * 0.05;\n    \n    gl_FragColor = fragmentColor;\n}\n";
    private PointF blurCenter = new PointF(0.5f, 0.5f);
    private float blurSize = 1.0f;

    public GlVideoZoomBlurFilter() {
        super("attribute highp vec4 aPosition;\nattribute highp vec4 aTextureCoord;\nvarying highp vec2 vTextureCoord;\nvoid main() {\ngl_Position = aPosition;\nvTextureCoord = aTextureCoord.xy;\n}\n", ZOOM_BLUR_FRAGMENT_SHADER);
    }

    public void setBlurCenter(PointF pointF) {
        this.blurCenter = pointF;
    }

    public void setBlurSize(float f) {
        this.blurSize = f;
    }

    public void onDraw() {
        GLES20.glUniform2f(getHandle("blurCenter"), this.blurCenter.x, this.blurCenter.y);
        GLES20.glUniform1f(getHandle("blurSize"), this.blurSize);
    }
}
