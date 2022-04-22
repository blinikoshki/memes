package editor.gpu.gpuvideo.player;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.video.VideoListener;
import editor.gpu.gpuvideo.egl.GlConfigChooser;
import editor.gpu.gpuvideo.egl.GlContextFactory;
import editor.gpu.gpuvideo.egl.filter.GlVideoFilter;

public class GPUPlayerView extends GLSurfaceView implements VideoListener {
    private static final String TAG = "GPUPlayerView";
    private SimpleExoPlayer player;
    private PlayerScaleType playerScaleType;
    private final GPUPlayerRenderer renderer;
    private float videoAspect;

    public void onRenderedFirstFrame() {
    }

    public /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
        VideoListener.CC.$default$onSurfaceSizeChanged(this, i, i2);
    }

    public GPUPlayerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public GPUPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.videoAspect = 1.0f;
        this.playerScaleType = PlayerScaleType.RESIZE_FIT_WIDTH;
        setEGLContextFactory(new GlContextFactory());
        setEGLConfigChooser(new GlConfigChooser(false));
        GPUPlayerRenderer gPUPlayerRenderer = new GPUPlayerRenderer(this);
        this.renderer = gPUPlayerRenderer;
        setRenderer(gPUPlayerRenderer);
    }

    public GPUPlayerView setSimpleExoPlayer(SimpleExoPlayer simpleExoPlayer) {
        SimpleExoPlayer simpleExoPlayer2 = this.player;
        if (simpleExoPlayer2 != null) {
            simpleExoPlayer2.release();
            this.player = null;
        }
        this.player = simpleExoPlayer;
        simpleExoPlayer.addVideoListener(this);
        this.renderer.setSimpleExoPlayer(simpleExoPlayer);
        return this;
    }

    public void setGlFilter(GlVideoFilter glVideoFilter) {
        this.renderer.setGlFilter(glVideoFilter);
    }

    public void setPlayerScaleType(PlayerScaleType playerScaleType2) {
        this.playerScaleType = playerScaleType2;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i3 = C47881.$SwitchMap$editor$gpu$gpuvideo$player$PlayerScaleType[this.playerScaleType.ordinal()];
        if (i3 == 1) {
            measuredHeight = (int) (((float) measuredWidth) / this.videoAspect);
        } else if (i3 == 2) {
            measuredWidth = (int) (((float) measuredHeight) * this.videoAspect);
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    /* renamed from: editor.gpu.gpuvideo.player.GPUPlayerView$1 */
    static /* synthetic */ class C47881 {
        static final /* synthetic */ int[] $SwitchMap$editor$gpu$gpuvideo$player$PlayerScaleType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                editor.gpu.gpuvideo.player.PlayerScaleType[] r0 = editor.gpu.gpuvideo.player.PlayerScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$editor$gpu$gpuvideo$player$PlayerScaleType = r0
                editor.gpu.gpuvideo.player.PlayerScaleType r1 = editor.gpu.gpuvideo.player.PlayerScaleType.RESIZE_FIT_WIDTH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$editor$gpu$gpuvideo$player$PlayerScaleType     // Catch:{ NoSuchFieldError -> 0x001d }
                editor.gpu.gpuvideo.player.PlayerScaleType r1 = editor.gpu.gpuvideo.player.PlayerScaleType.RESIZE_FIT_HEIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: editor.gpu.gpuvideo.player.GPUPlayerView.C47881.<clinit>():void");
        }
    }

    public void onPause() {
        super.onPause();
        this.renderer.release();
    }

    public void onVideoSizeChanged(int i, int i2, int i3, float f) {
        this.videoAspect = (((float) i) / ((float) i2)) * f;
        requestLayout();
    }
}
