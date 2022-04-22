package editor.gpu.gpuimage.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import editor.gpu.gpuimage.util.OpenGlUtils;
import editor.gpu.gpuimage.util.Rotation;
import editor.gpu.gpuimage.util.TextureRotationUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class GlPhotoTwoInputFilter extends GlPhotoFilter {
    private static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n}";
    private Bitmap bitmap;
    private int filterInputTextureUniform2;
    private int filterSecondTextureCoordinateAttribute;
    /* access modifiers changed from: private */
    public int filterSourceTexture2;
    private ByteBuffer texture2CoordinatesBuffer;

    public GlPhotoTwoInputFilter(String str) {
        this(VERTEX_SHADER, str);
    }

    public GlPhotoTwoInputFilter(String str, String str2) {
        super(str, str2);
        this.filterSourceTexture2 = -1;
        setRotation(Rotation.NORMAL, false, false);
    }

    public void onInit() {
        super.onInit();
        this.filterSecondTextureCoordinateAttribute = GLES20.glGetAttribLocation(getProgram(), "inputTextureCoordinate2");
        this.filterInputTextureUniform2 = GLES20.glGetUniformLocation(getProgram(), "inputImageTexture2");
        GLES20.glEnableVertexAttribArray(this.filterSecondTextureCoordinateAttribute);
    }

    public void onInitialized() {
        super.onInitialized();
        Bitmap bitmap2 = this.bitmap;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            setBitmap(this.bitmap);
        }
    }

    public void setBitmap(final Bitmap bitmap2) {
        if (bitmap2 == null || !bitmap2.isRecycled()) {
            this.bitmap = bitmap2;
            if (bitmap2 != null) {
                runOnDraw(new Runnable() {
                    public void run() {
                        Bitmap bitmap;
                        if (GlPhotoTwoInputFilter.this.filterSourceTexture2 == -1 && (bitmap = bitmap2) != null && !bitmap.isRecycled()) {
                            GLES20.glActiveTexture(33987);
                            int unused = GlPhotoTwoInputFilter.this.filterSourceTexture2 = OpenGlUtils.loadTexture(bitmap2, -1, false);
                        }
                    }
                });
            }
        }
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public void recycleBitmap() {
        Bitmap bitmap2 = this.bitmap;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.bitmap.recycle();
            this.bitmap = null;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        GLES20.glDeleteTextures(1, new int[]{this.filterSourceTexture2}, 0);
        this.filterSourceTexture2 = -1;
    }

    /* access modifiers changed from: protected */
    public void onDrawArraysPre() {
        GLES20.glEnableVertexAttribArray(this.filterSecondTextureCoordinateAttribute);
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(3553, this.filterSourceTexture2);
        GLES20.glUniform1i(this.filterInputTextureUniform2, 3);
        this.texture2CoordinatesBuffer.position(0);
        GLES20.glVertexAttribPointer(this.filterSecondTextureCoordinateAttribute, 2, 5126, false, 0, this.texture2CoordinatesBuffer);
    }

    public void setRotation(Rotation rotation, boolean z, boolean z2) {
        float[] rotation2 = TextureRotationUtil.getRotation(rotation, z, z2);
        ByteBuffer order = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = order.asFloatBuffer();
        asFloatBuffer.put(rotation2);
        asFloatBuffer.flip();
        this.texture2CoordinatesBuffer = order;
    }
}
