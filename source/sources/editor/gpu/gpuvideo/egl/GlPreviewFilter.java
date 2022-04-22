package editor.gpu.gpuvideo.egl;

import android.opengl.GLES20;
import editor.gpu.gpuvideo.egl.filter.GlVideoFilter;

public class GlPreviewFilter extends GlVideoFilter {
    public static final int GL_TEXTURE_EXTERNAL_OES = 36197;
    private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nuniform float uCRatio;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying highp vec2 vTextureCoord;\nvoid main() {\nvec4 scaledPos = aPosition;\nscaledPos.x = scaledPos.x * uCRatio;\ngl_Position = uMVPMatrix * scaledPos;\nvTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
    private final int texTarget;

    public GlPreviewFilter(int i) {
        super(VERTEX_SHADER, createFragmentShaderSourceOESIfNeed(i));
        this.texTarget = i;
    }

    private static String createFragmentShaderSourceOESIfNeed(int i) {
        if (i != 36197) {
            return "precision mediump float;\nvarying highp vec2 vTextureCoord;\nuniform lowp sampler2D sTexture;\nvoid main() {\ngl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
        }
        return "#extension GL_OES_EGL_image_external : require\n" + "precision mediump float;\nvarying highp vec2 vTextureCoord;\nuniform lowp sampler2D sTexture;\nvoid main() {\ngl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n".replace("sampler2D", "samplerExternalOES");
    }

    public void draw(int i, float[] fArr, float[] fArr2, float f) {
        useProgram();
        GLES20.glUniformMatrix4fv(getHandle("uMVPMatrix"), 1, false, fArr, 0);
        GLES20.glUniformMatrix4fv(getHandle("uSTMatrix"), 1, false, fArr2, 0);
        GLES20.glUniform1f(getHandle("uCRatio"), f);
        GLES20.glBindBuffer(34962, getVertexBufferName());
        GLES20.glEnableVertexAttribArray(getHandle("aPosition"));
        GLES20.glVertexAttribPointer(getHandle("aPosition"), 3, 5126, false, 20, 0);
        GLES20.glEnableVertexAttribArray(getHandle("aTextureCoord"));
        GLES20.glVertexAttribPointer(getHandle("aTextureCoord"), 2, 5126, false, 20, 12);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.texTarget, i);
        GLES20.glUniform1i(getHandle(GlVideoFilter.DEFAULT_UNIFORM_SAMPLER), 0);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(getHandle("aPosition"));
        GLES20.glDisableVertexAttribArray(getHandle("aTextureCoord"));
        GLES20.glBindBuffer(34962, 0);
        GLES20.glBindTexture(3553, 0);
    }
}
