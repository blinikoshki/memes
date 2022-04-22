package editor.gpu.gpuimage.filter;

import android.opengl.GLES20;
import androidx.work.Data;
import editor.gpu.gpuimage.GPUImageRenderer;
import editor.gpu.gpuimage.util.Rotation;
import editor.gpu.gpuimage.util.TextureRotationUtil;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

public class GlPhotoFilterGroup extends GlPhotoFilter {
    private List<GlPhotoFilter> filters;
    private int[] frameBufferTextures;
    private int[] frameBuffers;
    private final FloatBuffer glCubeBuffer;
    private final FloatBuffer glTextureBuffer;
    private final FloatBuffer glTextureFlipBuffer;
    private List<GlPhotoFilter> mergedFilters;

    public GlPhotoFilterGroup() {
        this((List<GlPhotoFilter>) null);
    }

    public GlPhotoFilterGroup(List<GlPhotoFilter> list) {
        this.filters = list;
        if (list == null) {
            this.filters = new ArrayList();
        } else {
            updateMergedFilters();
        }
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(GPUImageRenderer.CUBE.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.glCubeBuffer = asFloatBuffer;
        asFloatBuffer.put(GPUImageRenderer.CUBE).position(0);
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(TextureRotationUtil.TEXTURE_NO_ROTATION.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.glTextureBuffer = asFloatBuffer2;
        asFloatBuffer2.put(TextureRotationUtil.TEXTURE_NO_ROTATION).position(0);
        float[] rotation = TextureRotationUtil.getRotation(Rotation.NORMAL, false, true);
        FloatBuffer asFloatBuffer3 = ByteBuffer.allocateDirect(rotation.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.glTextureFlipBuffer = asFloatBuffer3;
        asFloatBuffer3.put(rotation).position(0);
    }

    public void addFilter(GlPhotoFilter glPhotoFilter) {
        if (glPhotoFilter != null) {
            this.filters.add(glPhotoFilter);
            updateMergedFilters();
        }
    }

    public void onInit() {
        super.onInit();
        for (GlPhotoFilter ifNeedInit : this.filters) {
            ifNeedInit.ifNeedInit();
        }
    }

    public void onDestroy() {
        destroyFramebuffers();
        for (GlPhotoFilter destroy : this.filters) {
            destroy.destroy();
        }
        super.onDestroy();
    }

    private void destroyFramebuffers() {
        int[] iArr = this.frameBufferTextures;
        if (iArr != null) {
            GLES20.glDeleteTextures(iArr.length, iArr, 0);
            this.frameBufferTextures = null;
        }
        int[] iArr2 = this.frameBuffers;
        if (iArr2 != null) {
            GLES20.glDeleteFramebuffers(iArr2.length, iArr2, 0);
            this.frameBuffers = null;
        }
    }

    public void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        if (this.frameBuffers != null) {
            destroyFramebuffers();
        }
        int size = this.filters.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.filters.get(i3).onOutputSizeChanged(i, i2);
        }
        int i4 = i;
        int i5 = i2;
        List<GlPhotoFilter> list = this.mergedFilters;
        if (list != null && list.size() > 0) {
            int i6 = 1;
            int size2 = this.mergedFilters.size() - 1;
            this.frameBuffers = new int[size2];
            this.frameBufferTextures = new int[size2];
            int i7 = 0;
            while (i7 < size2) {
                GLES20.glGenFramebuffers(i6, this.frameBuffers, i7);
                GLES20.glGenTextures(i6, this.frameBufferTextures, i7);
                GLES20.glBindTexture(3553, this.frameBufferTextures[i7]);
                GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, (Buffer) null);
                GLES20.glTexParameterf(3553, Data.MAX_DATA_BYTES, 9729.0f);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
                GLES20.glBindFramebuffer(36160, this.frameBuffers[i7]);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.frameBufferTextures[i7], 0);
                GLES20.glBindTexture(3553, 0);
                GLES20.glBindFramebuffer(36160, 0);
                i7++;
                i6 = 1;
            }
        }
    }

    public void onDraw(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        List<GlPhotoFilter> list;
        runPendingOnDrawTasks();
        if (isInitialized() && this.frameBuffers != null && this.frameBufferTextures != null && (list = this.mergedFilters) != null) {
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                GlPhotoFilter glPhotoFilter = this.mergedFilters.get(i2);
                int i3 = size - 1;
                boolean z = i2 < i3;
                if (z) {
                    GLES20.glBindFramebuffer(36160, this.frameBuffers[i2]);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                }
                if (i2 == 0) {
                    glPhotoFilter.onDraw(i, floatBuffer, floatBuffer2);
                } else if (i2 == i3) {
                    glPhotoFilter.onDraw(i, this.glCubeBuffer, size % 2 == 0 ? this.glTextureFlipBuffer : this.glTextureBuffer);
                } else {
                    glPhotoFilter.onDraw(i, this.glCubeBuffer, this.glTextureBuffer);
                }
                if (z) {
                    GLES20.glBindFramebuffer(36160, 0);
                    i = this.frameBufferTextures[i2];
                }
                i2++;
            }
        }
    }

    public List<GlPhotoFilter> getFilters() {
        return this.filters;
    }

    public List<GlPhotoFilter> getMergedFilters() {
        return this.mergedFilters;
    }

    public void updateMergedFilters() {
        if (this.filters != null) {
            List<GlPhotoFilter> list = this.mergedFilters;
            if (list == null) {
                this.mergedFilters = new ArrayList();
            } else {
                list.clear();
            }
            for (GlPhotoFilter next : this.filters) {
                if (next instanceof GlPhotoFilterGroup) {
                    GlPhotoFilterGroup glPhotoFilterGroup = (GlPhotoFilterGroup) next;
                    glPhotoFilterGroup.updateMergedFilters();
                    List<GlPhotoFilter> mergedFilters2 = glPhotoFilterGroup.getMergedFilters();
                    if (mergedFilters2 != null && !mergedFilters2.isEmpty()) {
                        this.mergedFilters.addAll(mergedFilters2);
                    }
                } else {
                    this.mergedFilters.add(next);
                }
            }
        }
    }
}
