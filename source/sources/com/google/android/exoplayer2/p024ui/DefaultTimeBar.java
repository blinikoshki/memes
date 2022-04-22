package com.google.android.exoplayer2.p024ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.exoplayer2.C1844C;
import com.google.android.exoplayer2.p024ui.TimeBar;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.google.android.exoplayer2.ui.DefaultTimeBar */
public class DefaultTimeBar extends View implements TimeBar {
    private static final String ACCESSIBILITY_CLASS_NAME = "android.widget.SeekBar";
    public static final int DEFAULT_AD_MARKER_COLOR = -1291845888;
    public static final int DEFAULT_AD_MARKER_WIDTH_DP = 4;
    public static final int DEFAULT_BAR_HEIGHT_DP = 4;
    public static final int DEFAULT_BUFFERED_COLOR = -855638017;
    private static final int DEFAULT_INCREMENT_COUNT = 20;
    public static final int DEFAULT_PLAYED_AD_MARKER_COLOR = 872414976;
    public static final int DEFAULT_PLAYED_COLOR = -1;
    public static final int DEFAULT_SCRUBBER_COLOR = -1;
    public static final int DEFAULT_SCRUBBER_DISABLED_SIZE_DP = 0;
    public static final int DEFAULT_SCRUBBER_DRAGGED_SIZE_DP = 16;
    public static final int DEFAULT_SCRUBBER_ENABLED_SIZE_DP = 12;
    public static final int DEFAULT_TOUCH_TARGET_HEIGHT_DP = 26;
    public static final int DEFAULT_UNPLAYED_COLOR = 872415231;
    private static final int FINE_SCRUB_RATIO = 3;
    private static final int FINE_SCRUB_Y_THRESHOLD_DP = -50;
    private static final long STOP_SCRUBBING_TIMEOUT_MS = 1000;
    private int adGroupCount;
    private long[] adGroupTimesMs;
    private final Paint adMarkerPaint;
    private final int adMarkerWidth;
    private final int barHeight;
    private final Rect bufferedBar;
    private final Paint bufferedPaint;
    private long bufferedPosition;
    private final float density;
    private long duration;
    private final int fineScrubYThreshold;
    private final StringBuilder formatBuilder;
    private final Formatter formatter;
    private int keyCountIncrement;
    private long keyTimeIncrement;
    private int lastCoarseScrubXPosition;
    private Rect lastExclusionRectangle;
    private final CopyOnWriteArraySet<TimeBar.OnScrubListener> listeners;
    private final int[] locationOnScreen;
    private boolean[] playedAdGroups;
    private final Paint playedAdMarkerPaint;
    private final Paint playedPaint;
    private long position;
    private final Rect progressBar;
    private long scrubPosition;
    private final Rect scrubberBar;
    private final int scrubberDisabledSize;
    private final int scrubberDraggedSize;
    private final Drawable scrubberDrawable;
    private final int scrubberEnabledSize;
    private final int scrubberPadding;
    private final Paint scrubberPaint;
    private boolean scrubbing;
    private final Rect seekBounds;
    private final Runnable stopScrubbingRunnable;
    private final Point touchPosition;
    private final int touchTargetHeight;
    private final Paint unplayedPaint;

    private static int dpToPx(float f, int i) {
        return (int) ((((float) i) * f) + 0.5f);
    }

    private static int pxToDp(float f, int i) {
        return (int) (((float) i) / f);
    }

    public DefaultTimeBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultTimeBar(Context context, AttributeSet attributeSet, int i, AttributeSet attributeSet2) {
        super(context, attributeSet, i);
        boolean z;
        AttributeSet attributeSet3 = attributeSet2;
        this.seekBounds = new Rect();
        this.progressBar = new Rect();
        this.bufferedBar = new Rect();
        this.scrubberBar = new Rect();
        Paint paint = new Paint();
        this.playedPaint = paint;
        Paint paint2 = new Paint();
        this.bufferedPaint = paint2;
        Paint paint3 = new Paint();
        this.unplayedPaint = paint3;
        Paint paint4 = new Paint();
        this.adMarkerPaint = paint4;
        Paint paint5 = new Paint();
        this.playedAdMarkerPaint = paint5;
        Paint paint6 = new Paint();
        this.scrubberPaint = paint6;
        paint6.setAntiAlias(true);
        this.listeners = new CopyOnWriteArraySet<>();
        this.locationOnScreen = new int[2];
        this.touchPosition = new Point();
        float f = context.getResources().getDisplayMetrics().density;
        this.density = f;
        this.fineScrubYThreshold = dpToPx(f, FINE_SCRUB_Y_THRESHOLD_DP);
        int dpToPx = dpToPx(f, 4);
        int dpToPx2 = dpToPx(f, 26);
        int dpToPx3 = dpToPx(f, 4);
        int dpToPx4 = dpToPx(f, 12);
        int dpToPx5 = dpToPx(f, 0);
        int dpToPx6 = dpToPx(f, 16);
        if (attributeSet3 != null) {
            Paint paint7 = paint5;
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet3, C2684R.styleable.DefaultTimeBar, 0, 0);
            try {
                Drawable drawable = obtainStyledAttributes.getDrawable(C2684R.styleable.DefaultTimeBar_scrubber_drawable);
                this.scrubberDrawable = drawable;
                if (drawable != null) {
                    setDrawableLayoutDirection(drawable);
                    dpToPx2 = Math.max(drawable.getMinimumHeight(), dpToPx2);
                }
                this.barHeight = obtainStyledAttributes.getDimensionPixelSize(C2684R.styleable.DefaultTimeBar_bar_height, dpToPx);
                this.touchTargetHeight = obtainStyledAttributes.getDimensionPixelSize(C2684R.styleable.DefaultTimeBar_touch_target_height, dpToPx2);
                this.adMarkerWidth = obtainStyledAttributes.getDimensionPixelSize(C2684R.styleable.DefaultTimeBar_ad_marker_width, dpToPx3);
                this.scrubberEnabledSize = obtainStyledAttributes.getDimensionPixelSize(C2684R.styleable.DefaultTimeBar_scrubber_enabled_size, dpToPx4);
                this.scrubberDisabledSize = obtainStyledAttributes.getDimensionPixelSize(C2684R.styleable.DefaultTimeBar_scrubber_disabled_size, dpToPx5);
                this.scrubberDraggedSize = obtainStyledAttributes.getDimensionPixelSize(C2684R.styleable.DefaultTimeBar_scrubber_dragged_size, dpToPx6);
                int i2 = obtainStyledAttributes.getInt(C2684R.styleable.DefaultTimeBar_played_color, -1);
                int i3 = obtainStyledAttributes.getInt(C2684R.styleable.DefaultTimeBar_scrubber_color, -1);
                int i4 = obtainStyledAttributes.getInt(C2684R.styleable.DefaultTimeBar_buffered_color, DEFAULT_BUFFERED_COLOR);
                int i5 = obtainStyledAttributes.getInt(C2684R.styleable.DefaultTimeBar_unplayed_color, DEFAULT_UNPLAYED_COLOR);
                int i6 = obtainStyledAttributes.getInt(C2684R.styleable.DefaultTimeBar_ad_marker_color, DEFAULT_AD_MARKER_COLOR);
                int i7 = obtainStyledAttributes.getInt(C2684R.styleable.DefaultTimeBar_played_ad_marker_color, DEFAULT_PLAYED_AD_MARKER_COLOR);
                paint.setColor(i2);
                paint6.setColor(i3);
                paint2.setColor(i4);
                paint3.setColor(i5);
                paint4.setColor(i6);
                paint7.setColor(i7);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            this.barHeight = dpToPx;
            this.touchTargetHeight = dpToPx2;
            this.adMarkerWidth = dpToPx3;
            this.scrubberEnabledSize = dpToPx4;
            this.scrubberDisabledSize = dpToPx5;
            this.scrubberDraggedSize = dpToPx6;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(DEFAULT_BUFFERED_COLOR);
            paint3.setColor(DEFAULT_UNPLAYED_COLOR);
            paint4.setColor(DEFAULT_AD_MARKER_COLOR);
            paint5.setColor(DEFAULT_PLAYED_AD_MARKER_COLOR);
            this.scrubberDrawable = null;
        }
        StringBuilder sb = new StringBuilder();
        this.formatBuilder = sb;
        this.formatter = new Formatter(sb, Locale.getDefault());
        this.stopScrubbingRunnable = new Runnable() {
            public final void run() {
                DefaultTimeBar.this.lambda$new$0$DefaultTimeBar();
            }
        };
        Drawable drawable2 = this.scrubberDrawable;
        if (drawable2 != null) {
            z = true;
            this.scrubberPadding = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            z = true;
            this.scrubberPadding = (Math.max(this.scrubberDisabledSize, Math.max(this.scrubberEnabledSize, this.scrubberDraggedSize)) + 1) / 2;
        }
        this.duration = C1844C.TIME_UNSET;
        this.keyTimeIncrement = C1844C.TIME_UNSET;
        this.keyCountIncrement = 20;
        setFocusable(z);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(z ? 1 : 0);
        }
    }

    public /* synthetic */ void lambda$new$0$DefaultTimeBar() {
        stopScrubbing(false);
    }

    public void setPlayedColor(int i) {
        this.playedPaint.setColor(i);
        invalidate(this.seekBounds);
    }

    public void setScrubberColor(int i) {
        this.scrubberPaint.setColor(i);
        invalidate(this.seekBounds);
    }

    public void setBufferedColor(int i) {
        this.bufferedPaint.setColor(i);
        invalidate(this.seekBounds);
    }

    public void setUnplayedColor(int i) {
        this.unplayedPaint.setColor(i);
        invalidate(this.seekBounds);
    }

    public void setAdMarkerColor(int i) {
        this.adMarkerPaint.setColor(i);
        invalidate(this.seekBounds);
    }

    public void setPlayedAdMarkerColor(int i) {
        this.playedAdMarkerPaint.setColor(i);
        invalidate(this.seekBounds);
    }

    public void addListener(TimeBar.OnScrubListener onScrubListener) {
        this.listeners.add(onScrubListener);
    }

    public void removeListener(TimeBar.OnScrubListener onScrubListener) {
        this.listeners.remove(onScrubListener);
    }

    public void setKeyTimeIncrement(long j) {
        Assertions.checkArgument(j > 0);
        this.keyCountIncrement = -1;
        this.keyTimeIncrement = j;
    }

    public void setKeyCountIncrement(int i) {
        Assertions.checkArgument(i > 0);
        this.keyCountIncrement = i;
        this.keyTimeIncrement = C1844C.TIME_UNSET;
    }

    public void setPosition(long j) {
        this.position = j;
        setContentDescription(getProgressText());
        update();
    }

    public void setBufferedPosition(long j) {
        this.bufferedPosition = j;
        update();
    }

    public void setDuration(long j) {
        this.duration = j;
        if (this.scrubbing && j == C1844C.TIME_UNSET) {
            stopScrubbing(true);
        }
        update();
    }

    public long getPreferredUpdateDelay() {
        int pxToDp = pxToDp(this.density, this.progressBar.width());
        if (pxToDp != 0) {
            long j = this.duration;
            if (!(j == 0 || j == C1844C.TIME_UNSET)) {
                return j / ((long) pxToDp);
            }
        }
        return Long.MAX_VALUE;
    }

    public void setAdGroupTimesMs(long[] jArr, boolean[] zArr, int i) {
        Assertions.checkArgument(i == 0 || !(jArr == null || zArr == null));
        this.adGroupCount = i;
        this.adGroupTimesMs = jArr;
        this.playedAdGroups = zArr;
        update();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.scrubbing && !z) {
            stopScrubbing(true);
        }
    }

    public void onDraw(Canvas canvas) {
        canvas.save();
        drawTimeBar(canvas);
        drawPlayhead(canvas);
        canvas.restore();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if (r3 != 3) goto L_0x0076;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.isEnabled()
            r1 = 0
            if (r0 == 0) goto L_0x0076
            long r2 = r7.duration
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x0010
            goto L_0x0076
        L_0x0010:
            android.graphics.Point r0 = r7.resolveRelativeTouchPosition(r8)
            int r2 = r0.x
            int r0 = r0.y
            int r3 = r8.getAction()
            r4 = 1
            if (r3 == 0) goto L_0x005d
            r5 = 3
            if (r3 == r4) goto L_0x004e
            r6 = 2
            if (r3 == r6) goto L_0x0028
            if (r3 == r5) goto L_0x004e
            goto L_0x0076
        L_0x0028:
            boolean r8 = r7.scrubbing
            if (r8 == 0) goto L_0x0076
            int r8 = r7.fineScrubYThreshold
            if (r0 >= r8) goto L_0x003a
            int r8 = r7.lastCoarseScrubXPosition
            int r2 = r2 - r8
            int r2 = r2 / r5
            int r8 = r8 + r2
            float r8 = (float) r8
            r7.positionScrubber(r8)
            goto L_0x0040
        L_0x003a:
            r7.lastCoarseScrubXPosition = r2
            float r8 = (float) r2
            r7.positionScrubber(r8)
        L_0x0040:
            long r0 = r7.getScrubberPosition()
            r7.updateScrubbing(r0)
            r7.update()
            r7.invalidate()
            return r4
        L_0x004e:
            boolean r0 = r7.scrubbing
            if (r0 == 0) goto L_0x0076
            int r8 = r8.getAction()
            if (r8 != r5) goto L_0x0059
            r1 = 1
        L_0x0059:
            r7.stopScrubbing(r1)
            return r4
        L_0x005d:
            float r8 = (float) r2
            float r0 = (float) r0
            boolean r0 = r7.isInSeekBar(r8, r0)
            if (r0 == 0) goto L_0x0076
            r7.positionScrubber(r8)
            long r0 = r7.getScrubberPosition()
            r7.startScrubbing(r0)
            r7.update()
            r7.invalidate()
            return r4
        L_0x0076:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.p024ui.DefaultTimeBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        if (scrubIncrementally(r0) == false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        removeCallbacks(r4.stopScrubbingRunnable);
        postDelayed(r4.stopScrubbingRunnable, 1000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L_0x0030
            long r0 = r4.getPositionIncrement()
            r2 = 66
            r3 = 1
            if (r5 == r2) goto L_0x0027
            switch(r5) {
                case 21: goto L_0x0013;
                case 22: goto L_0x0014;
                case 23: goto L_0x0027;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x0030
        L_0x0013:
            long r0 = -r0
        L_0x0014:
            boolean r0 = r4.scrubIncrementally(r0)
            if (r0 == 0) goto L_0x0030
            java.lang.Runnable r5 = r4.stopScrubbingRunnable
            r4.removeCallbacks(r5)
            java.lang.Runnable r5 = r4.stopScrubbingRunnable
            r0 = 1000(0x3e8, double:4.94E-321)
            r4.postDelayed(r5, r0)
            return r3
        L_0x0027:
            boolean r0 = r4.scrubbing
            if (r0 == 0) goto L_0x0030
            r5 = 0
            r4.stopScrubbing(r5)
            return r3
        L_0x0030:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.p024ui.DefaultTimeBar.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (this.scrubbing && !z) {
            stopScrubbing(false);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        updateDrawableState();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.scrubberDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 0) {
            size = this.touchTargetHeight;
        } else if (mode != 1073741824) {
            size = Math.min(this.touchTargetHeight, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), size);
        updateDrawableState();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int i7 = (i6 - this.touchTargetHeight) / 2;
        int i8 = this.touchTargetHeight;
        int i9 = ((i8 - this.barHeight) / 2) + i7;
        this.seekBounds.set(getPaddingLeft(), i7, i5 - getPaddingRight(), i8 + i7);
        this.progressBar.set(this.seekBounds.left + this.scrubberPadding, i9, this.seekBounds.right - this.scrubberPadding, this.barHeight + i9);
        if (Util.SDK_INT >= 29) {
            setSystemGestureExclusionRectsV29(i5, i6);
        }
        update();
    }

    public void onRtlPropertiesChanged(int i) {
        Drawable drawable = this.scrubberDrawable;
        if (drawable != null && setDrawableLayoutDirection(drawable, i)) {
            invalidate();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.duration > 0) {
            if (Util.SDK_INT >= 21) {
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
                return;
            }
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        if (this.duration <= 0) {
            return false;
        }
        if (i == 8192) {
            if (scrubIncrementally(-getPositionIncrement())) {
                stopScrubbing(false);
            }
        } else if (i != 4096) {
            return false;
        } else {
            if (scrubIncrementally(getPositionIncrement())) {
                stopScrubbing(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    private void startScrubbing(long j) {
        this.scrubPosition = j;
        this.scrubbing = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator<TimeBar.OnScrubListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onScrubStart(this, j);
        }
    }

    private void updateScrubbing(long j) {
        if (this.scrubPosition != j) {
            this.scrubPosition = j;
            Iterator<TimeBar.OnScrubListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onScrubMove(this, j);
            }
        }
    }

    private void stopScrubbing(boolean z) {
        removeCallbacks(this.stopScrubbingRunnable);
        this.scrubbing = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<TimeBar.OnScrubListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onScrubStop(this, this.scrubPosition, z);
        }
    }

    private boolean scrubIncrementally(long j) {
        long j2 = this.duration;
        if (j2 <= 0) {
            return false;
        }
        long j3 = this.scrubbing ? this.scrubPosition : this.position;
        long constrainValue = Util.constrainValue(j3 + j, 0, j2);
        if (constrainValue == j3) {
            return false;
        }
        if (!this.scrubbing) {
            startScrubbing(constrainValue);
        } else {
            updateScrubbing(constrainValue);
        }
        update();
        return true;
    }

    private void update() {
        this.bufferedBar.set(this.progressBar);
        this.scrubberBar.set(this.progressBar);
        long j = this.scrubbing ? this.scrubPosition : this.position;
        if (this.duration > 0) {
            this.bufferedBar.right = Math.min(this.progressBar.left + ((int) ((((long) this.progressBar.width()) * this.bufferedPosition) / this.duration)), this.progressBar.right);
            this.scrubberBar.right = Math.min(this.progressBar.left + ((int) ((((long) this.progressBar.width()) * j) / this.duration)), this.progressBar.right);
        } else {
            this.bufferedBar.right = this.progressBar.left;
            this.scrubberBar.right = this.progressBar.left;
        }
        invalidate(this.seekBounds);
    }

    private void positionScrubber(float f) {
        this.scrubberBar.right = Util.constrainValue((int) f, this.progressBar.left, this.progressBar.right);
    }

    private Point resolveRelativeTouchPosition(MotionEvent motionEvent) {
        getLocationOnScreen(this.locationOnScreen);
        this.touchPosition.set(((int) motionEvent.getRawX()) - this.locationOnScreen[0], ((int) motionEvent.getRawY()) - this.locationOnScreen[1]);
        return this.touchPosition;
    }

    private long getScrubberPosition() {
        if (this.progressBar.width() <= 0 || this.duration == C1844C.TIME_UNSET) {
            return 0;
        }
        return (((long) this.scrubberBar.width()) * this.duration) / ((long) this.progressBar.width());
    }

    private boolean isInSeekBar(float f, float f2) {
        return this.seekBounds.contains((int) f, (int) f2);
    }

    private void drawTimeBar(Canvas canvas) {
        int height = this.progressBar.height();
        int centerY = this.progressBar.centerY() - (height / 2);
        int i = height + centerY;
        if (this.duration <= 0) {
            canvas.drawRect((float) this.progressBar.left, (float) centerY, (float) this.progressBar.right, (float) i, this.unplayedPaint);
            return;
        }
        int i2 = this.bufferedBar.left;
        int i3 = this.bufferedBar.right;
        int max = Math.max(Math.max(this.progressBar.left, i3), this.scrubberBar.right);
        if (max < this.progressBar.right) {
            canvas.drawRect((float) max, (float) centerY, (float) this.progressBar.right, (float) i, this.unplayedPaint);
        }
        int max2 = Math.max(i2, this.scrubberBar.right);
        if (i3 > max2) {
            canvas.drawRect((float) max2, (float) centerY, (float) i3, (float) i, this.bufferedPaint);
        }
        if (this.scrubberBar.width() > 0) {
            canvas.drawRect((float) this.scrubberBar.left, (float) centerY, (float) this.scrubberBar.right, (float) i, this.playedPaint);
        }
        if (this.adGroupCount != 0) {
            long[] jArr = (long[]) Assertions.checkNotNull(this.adGroupTimesMs);
            boolean[] zArr = (boolean[]) Assertions.checkNotNull(this.playedAdGroups);
            int i4 = this.adMarkerWidth / 2;
            for (int i5 = 0; i5 < this.adGroupCount; i5++) {
                int min = this.progressBar.left + Math.min(this.progressBar.width() - this.adMarkerWidth, Math.max(0, ((int) ((((long) this.progressBar.width()) * Util.constrainValue(jArr[i5], 0, this.duration)) / this.duration)) - i4));
                canvas.drawRect((float) min, (float) centerY, (float) (min + this.adMarkerWidth), (float) i, zArr[i5] ? this.playedAdMarkerPaint : this.adMarkerPaint);
            }
        }
    }

    private void drawPlayhead(Canvas canvas) {
        int i;
        if (this.duration > 0) {
            int constrainValue = Util.constrainValue(this.scrubberBar.right, this.scrubberBar.left, this.progressBar.right);
            int centerY = this.scrubberBar.centerY();
            Drawable drawable = this.scrubberDrawable;
            if (drawable == null) {
                if (this.scrubbing || isFocused()) {
                    i = this.scrubberDraggedSize;
                } else {
                    i = isEnabled() ? this.scrubberEnabledSize : this.scrubberDisabledSize;
                }
                canvas.drawCircle((float) constrainValue, (float) centerY, (float) (i / 2), this.scrubberPaint);
                return;
            }
            int intrinsicWidth = drawable.getIntrinsicWidth() / 2;
            int intrinsicHeight = this.scrubberDrawable.getIntrinsicHeight() / 2;
            this.scrubberDrawable.setBounds(constrainValue - intrinsicWidth, centerY - intrinsicHeight, constrainValue + intrinsicWidth, centerY + intrinsicHeight);
            this.scrubberDrawable.draw(canvas);
        }
    }

    private void updateDrawableState() {
        Drawable drawable = this.scrubberDrawable;
        if (drawable != null && drawable.isStateful() && this.scrubberDrawable.setState(getDrawableState())) {
            invalidate();
        }
    }

    private void setSystemGestureExclusionRectsV29(int i, int i2) {
        Rect rect = this.lastExclusionRectangle;
        if (rect == null || rect.width() != i || this.lastExclusionRectangle.height() != i2) {
            Rect rect2 = new Rect(0, 0, i, i2);
            this.lastExclusionRectangle = rect2;
            setSystemGestureExclusionRects(Collections.singletonList(rect2));
        }
    }

    private String getProgressText() {
        return Util.getStringForTime(this.formatBuilder, this.formatter, this.position);
    }

    private long getPositionIncrement() {
        long j = this.keyTimeIncrement;
        if (j != C1844C.TIME_UNSET) {
            return j;
        }
        long j2 = this.duration;
        if (j2 == C1844C.TIME_UNSET) {
            return 0;
        }
        return j2 / ((long) this.keyCountIncrement);
    }

    private boolean setDrawableLayoutDirection(Drawable drawable) {
        return Util.SDK_INT >= 23 && setDrawableLayoutDirection(drawable, getLayoutDirection());
    }

    private static boolean setDrawableLayoutDirection(Drawable drawable, int i) {
        return Util.SDK_INT >= 23 && drawable.setLayoutDirection(i);
    }
}
