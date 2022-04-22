package editor.gpu.gpuimage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import editor.gpu.gpuimage.GLTextureView;
import editor.gpu.gpuimage.GPUImage;
import editor.gpu.gpuimage.filter.GlPhotoFilter;
import editor.gpu.gpuimage.util.OpenGlUtils;
import editor.gpu.gpuimage.util.Rotation;
import editor.gpu.gpuimage.util.TextureRotationUtil;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GPUImageRenderer implements GLSurfaceView.Renderer, GLTextureView.Renderer, Camera.PreviewCallback {
    public static final float[] CUBE = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static final int NO_IMAGE = -1;
    /* access modifiers changed from: private */
    public int addedPadding;
    private float backgroundBlue = 0.0f;
    private float backgroundGreen = 0.0f;
    private float backgroundRed = 0.0f;
    /* access modifiers changed from: private */
    public GlPhotoFilter filter;
    private boolean flipHorizontal;
    private boolean flipVertical;
    private final FloatBuffer glCubeBuffer;
    /* access modifiers changed from: private */
    public IntBuffer glRgbBuffer;
    private final FloatBuffer glTextureBuffer;
    /* access modifiers changed from: private */
    public int glTextureId = -1;
    /* access modifiers changed from: private */
    public int imageHeight;
    /* access modifiers changed from: private */
    public int imageWidth;
    /* access modifiers changed from: private */
    public int outputHeight;
    /* access modifiers changed from: private */
    public int outputWidth;
    private Rotation rotation;
    private final Queue<Runnable> runOnDraw;
    private final Queue<Runnable> runOnDrawEnd;
    private GPUImage.ScaleType scaleType = GPUImage.ScaleType.CENTER_CROP;
    public final Object surfaceChangedWaiter = new Object();
    /* access modifiers changed from: private */
    public SurfaceTexture surfaceTexture = null;

    private float addDistance(float f, float f2) {
        return f == 0.0f ? f2 : 1.0f - f2;
    }

    public GPUImageRenderer(GlPhotoFilter glPhotoFilter) {
        this.filter = glPhotoFilter;
        this.runOnDraw = new LinkedList();
        this.runOnDrawEnd = new LinkedList();
        float[] fArr = CUBE;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.glCubeBuffer = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        this.glTextureBuffer = ByteBuffer.allocateDirect(TextureRotationUtil.TEXTURE_NO_ROTATION.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        setRotation(Rotation.NORMAL, false, false);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        GLES20.glClearColor(this.backgroundRed, this.backgroundGreen, this.backgroundBlue, 1.0f);
        GLES20.glDisable(2929);
        this.filter.ifNeedInit();
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.outputWidth = i;
        this.outputHeight = i2;
        GLES20.glViewport(0, 0, i, i2);
        GLES20.glUseProgram(this.filter.getProgram());
        this.filter.onOutputSizeChanged(i, i2);
        adjustImageScaling();
        synchronized (this.surfaceChangedWaiter) {
            this.surfaceChangedWaiter.notifyAll();
        }
    }

    public void onDrawFrame(GL10 gl10) {
        GLES20.glClear(16640);
        runAll(this.runOnDraw);
        this.filter.onDraw(this.glTextureId, this.glCubeBuffer, this.glTextureBuffer);
        runAll(this.runOnDrawEnd);
        SurfaceTexture surfaceTexture2 = this.surfaceTexture;
        if (surfaceTexture2 != null) {
            surfaceTexture2.updateTexImage();
        }
    }

    public void setBackgroundColor(float f, float f2, float f3) {
        this.backgroundRed = f;
        this.backgroundGreen = f2;
        this.backgroundBlue = f3;
    }

    private void runAll(Queue<Runnable> queue) {
        synchronized (queue) {
            while (!queue.isEmpty()) {
                queue.poll().run();
            }
        }
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        onPreviewFrame(bArr, previewSize.width, previewSize.height);
    }

    public void onPreviewFrame(final byte[] bArr, final int i, final int i2) {
        if (this.glRgbBuffer == null) {
            this.glRgbBuffer = IntBuffer.allocate(i * i2);
        }
        if (this.runOnDraw.isEmpty()) {
            runOnDraw(new Runnable() {
                public void run() {
                    GPUImageNativeLibrary.YUVtoRBGA(bArr, i, i2, GPUImageRenderer.this.glRgbBuffer.array());
                    GPUImageRenderer gPUImageRenderer = GPUImageRenderer.this;
                    int unused = gPUImageRenderer.glTextureId = OpenGlUtils.loadTexture(gPUImageRenderer.glRgbBuffer, i, i2, GPUImageRenderer.this.glTextureId);
                    int access$200 = GPUImageRenderer.this.imageWidth;
                    int i = i;
                    if (access$200 != i) {
                        int unused2 = GPUImageRenderer.this.imageWidth = i;
                        int unused3 = GPUImageRenderer.this.imageHeight = i2;
                        GPUImageRenderer.this.adjustImageScaling();
                    }
                }
            });
        }
    }

    public void setUpSurfaceTexture(final Camera camera) {
        runOnDraw(new Runnable() {
            public void run() {
                int[] iArr = new int[1];
                GLES20.glGenTextures(1, iArr, 0);
                SurfaceTexture unused = GPUImageRenderer.this.surfaceTexture = new SurfaceTexture(iArr[0]);
                try {
                    camera.setPreviewTexture(GPUImageRenderer.this.surfaceTexture);
                    camera.setPreviewCallback(GPUImageRenderer.this);
                    camera.startPreview();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setFilter(final GlPhotoFilter glPhotoFilter) {
        runOnDraw(new Runnable() {
            public void run() {
                GlPhotoFilter access$600 = GPUImageRenderer.this.filter;
                GlPhotoFilter unused = GPUImageRenderer.this.filter = glPhotoFilter;
                if (access$600 != null) {
                    access$600.destroy();
                }
                GPUImageRenderer.this.filter.ifNeedInit();
                GLES20.glUseProgram(GPUImageRenderer.this.filter.getProgram());
                GPUImageRenderer.this.filter.onOutputSizeChanged(GPUImageRenderer.this.outputWidth, GPUImageRenderer.this.outputHeight);
            }
        });
    }

    public void deleteImage() {
        runOnDraw(new Runnable() {
            public void run() {
                GLES20.glDeleteTextures(1, new int[]{GPUImageRenderer.this.glTextureId}, 0);
                int unused = GPUImageRenderer.this.glTextureId = -1;
            }
        });
    }

    public void setImageBitmap(Bitmap bitmap) {
        setImageBitmap(bitmap, true);
    }

    public void setImageBitmap(final Bitmap bitmap, final boolean z) {
        if (bitmap != null) {
            runOnDraw(new Runnable() {
                public void run() {
                    Bitmap bitmap = null;
                    if (bitmap.getWidth() % 2 == 1) {
                        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth() + 1, bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                        createBitmap.setDensity(bitmap.getDensity());
                        Canvas canvas = new Canvas(createBitmap);
                        canvas.drawARGB(0, 0, 0, 0);
                        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                        int unused = GPUImageRenderer.this.addedPadding = 1;
                        bitmap = createBitmap;
                    } else {
                        int unused2 = GPUImageRenderer.this.addedPadding = 0;
                    }
                    GPUImageRenderer gPUImageRenderer = GPUImageRenderer.this;
                    int unused3 = gPUImageRenderer.glTextureId = OpenGlUtils.loadTexture(bitmap != null ? bitmap : bitmap, gPUImageRenderer.glTextureId, z);
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                    int unused4 = GPUImageRenderer.this.imageWidth = bitmap.getWidth();
                    int unused5 = GPUImageRenderer.this.imageHeight = bitmap.getHeight();
                    GPUImageRenderer.this.adjustImageScaling();
                }
            });
        }
    }

    public void setScaleType(GPUImage.ScaleType scaleType2) {
        this.scaleType = scaleType2;
    }

    /* access modifiers changed from: protected */
    public int getFrameWidth() {
        return this.outputWidth;
    }

    /* access modifiers changed from: protected */
    public int getFrameHeight() {
        return this.outputHeight;
    }

    /* access modifiers changed from: private */
    public void adjustImageScaling() {
        float f = (float) this.outputWidth;
        float f2 = (float) this.outputHeight;
        if (this.rotation == Rotation.ROTATION_270 || this.rotation == Rotation.ROTATION_90) {
            f = (float) this.outputHeight;
            f2 = (float) this.outputWidth;
        }
        float max = Math.max(f / ((float) this.imageWidth), f2 / ((float) this.imageHeight));
        float round = ((float) Math.round(((float) this.imageWidth) * max)) / f;
        float round2 = ((float) Math.round(((float) this.imageHeight) * max)) / f2;
        float[] fArr = CUBE;
        float[] rotation2 = TextureRotationUtil.getRotation(this.rotation, this.flipHorizontal, this.flipVertical);
        if (this.scaleType == GPUImage.ScaleType.CENTER_CROP) {
            float f3 = (1.0f - (1.0f / round)) / 2.0f;
            float f4 = (1.0f - (1.0f / round2)) / 2.0f;
            rotation2 = new float[]{addDistance(rotation2[0], f3), addDistance(rotation2[1], f4), addDistance(rotation2[2], f3), addDistance(rotation2[3], f4), addDistance(rotation2[4], f3), addDistance(rotation2[5], f4), addDistance(rotation2[6], f3), addDistance(rotation2[7], f4)};
        } else {
            fArr = new float[]{fArr[0] / round2, fArr[1] / round, fArr[2] / round2, fArr[3] / round, fArr[4] / round2, fArr[5] / round, fArr[6] / round2, fArr[7] / round};
        }
        this.glCubeBuffer.clear();
        this.glCubeBuffer.put(fArr).position(0);
        this.glTextureBuffer.clear();
        this.glTextureBuffer.put(rotation2).position(0);
    }

    public void setRotationCamera(Rotation rotation2, boolean z, boolean z2) {
        setRotation(rotation2, z2, z);
    }

    public void setRotation(Rotation rotation2) {
        this.rotation = rotation2;
        adjustImageScaling();
    }

    public void setRotation(Rotation rotation2, boolean z, boolean z2) {
        this.flipHorizontal = z;
        this.flipVertical = z2;
        setRotation(rotation2);
    }

    public Rotation getRotation() {
        return this.rotation;
    }

    public boolean isFlippedHorizontally() {
        return this.flipHorizontal;
    }

    public boolean isFlippedVertically() {
        return this.flipVertical;
    }

    /* access modifiers changed from: protected */
    public void runOnDraw(Runnable runnable) {
        synchronized (this.runOnDraw) {
            this.runOnDraw.add(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void runOnDrawEnd(Runnable runnable) {
        synchronized (this.runOnDrawEnd) {
            this.runOnDrawEnd.add(runnable);
        }
    }
}
