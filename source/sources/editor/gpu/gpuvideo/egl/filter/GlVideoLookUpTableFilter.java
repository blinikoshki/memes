package editor.gpu.gpuvideo.egl.filter;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import editor.gpu.gpuvideo.egl.EglUtil;

public class GlVideoLookUpTableFilter extends GlVideoFilter {
    private static final String FRAGMENT_SHADER = "precision mediump float;uniform mediump sampler2D lutTexture; \nuniform lowp sampler2D sTexture; \nvarying highp vec2 vTextureCoord; \nvec4 sampleAs3DTexture(vec3 uv) {\n    float width = 16.;\n    float sliceSize = 1.0 / width;\n    float slicePixelSize = sliceSize / width;\n    float sliceInnerSize = slicePixelSize * (width - 1.0);\n    float zSlice0 = min(floor(uv.z * width), width - 1.0);\n    float zSlice1 = min(zSlice0 + 1.0, width - 1.0);\n    float xOffset = slicePixelSize * 0.5 + uv.x * sliceInnerSize;\n    float s0 = xOffset + (zSlice0 * sliceSize);\n    float s1 = xOffset + (zSlice1 * sliceSize);\n    vec4 slice0Color = texture2D(lutTexture, vec2(s0, uv.y));\n    vec4 slice1Color = texture2D(lutTexture, vec2(s1, uv.y));\n    float zOffset = mod(uv.z * width, 1.0);\n    vec4 result = mix(slice0Color, slice1Color, zOffset);\n    return result;\n}\nvoid main() {\n   vec4 pixel = texture2D(sTexture, vTextureCoord);\n   vec4 gradedPixel = sampleAs3DTexture(pixel.rgb);\n   gradedPixel.a = pixel.a;\n   pixel = gradedPixel;\n   gl_FragColor = pixel;\n }";
    private int hTex = -1;
    private Bitmap lutTexture;

    public GlVideoLookUpTableFilter(Bitmap bitmap) {
        super("attribute highp vec4 aPosition;\nattribute highp vec4 aTextureCoord;\nvarying highp vec2 vTextureCoord;\nvoid main() {\ngl_Position = aPosition;\nvTextureCoord = aTextureCoord.xy;\n}\n", FRAGMENT_SHADER);
        this.lutTexture = bitmap;
    }

    public GlVideoLookUpTableFilter(Resources resources, int i) {
        super("attribute highp vec4 aPosition;\nattribute highp vec4 aTextureCoord;\nvarying highp vec2 vTextureCoord;\nvoid main() {\ngl_Position = aPosition;\nvTextureCoord = aTextureCoord.xy;\n}\n", FRAGMENT_SHADER);
        this.lutTexture = BitmapFactory.decodeResource(resources, i);
    }

    public void onDraw() {
        int handle = getHandle("lutTexture");
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(3553, this.hTex);
        GLES20.glUniform1i(handle, 3);
    }

    public void setup() {
        super.setup();
        loadTexture();
    }

    private void loadTexture() {
        if (this.hTex == -1) {
            this.hTex = EglUtil.loadTexture(this.lutTexture, -1, false);
        }
    }

    public void releaseLutBitmap() {
        Bitmap bitmap = this.lutTexture;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.lutTexture.recycle();
            this.lutTexture = null;
        }
    }

    public void reset() {
        this.hTex = -1;
        this.hTex = EglUtil.loadTexture(this.lutTexture, -1, false);
    }
}
