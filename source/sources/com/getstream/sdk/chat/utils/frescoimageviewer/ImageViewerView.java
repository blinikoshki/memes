package com.getstream.sdk.chat.utils.frescoimageviewer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.GestureDetectorCompat;
import androidx.viewpager.widget.ViewPager;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.getstream.sdk.chat.utils.frescoimageviewer.ImageViewer;
import com.getstream.sdk.chat.utils.frescoimageviewer.SwipeDirectionDetector;
import com.getstream.sdk.chat.utils.frescoimageviewer.SwipeToDismissListener;
import p015io.getstream.chat.android.p016ui.common.C1891R;

class ImageViewerView extends RelativeLayout implements OnDismissListener, SwipeToDismissListener.OnViewMoveListener {
    private ImageViewerAdapter adapter;
    private View backgroundView;
    private GenericDraweeHierarchyBuilder customDraweeHierarchyBuilder;
    private ImageRequestBuilder customImageRequestBuilder;
    /* access modifiers changed from: private */
    public SwipeDirectionDetector.Direction direction;
    private SwipeDirectionDetector directionDetector;
    private ViewGroup dismissContainer;
    private GestureDetectorCompat gestureDetector;
    /* access modifiers changed from: private */
    public boolean isOverlayWasClicked;
    private boolean isSwipeToDismissAllowed = true;
    private boolean isZoomingAllowed = true;
    private OnDismissListener onDismissListener;
    private View overlayView;
    private ViewPager.OnPageChangeListener pageChangeListener;
    /* access modifiers changed from: private */
    public MultiTouchViewPager pager;
    private ScaleGestureDetector scaleDetector;
    private SwipeToDismissListener swipeDismissListener;
    private boolean wasScaled;

    public ImageViewerView(Context context) {
        super(context);
        init();
    }

    public ImageViewerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ImageViewerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void setUrls(ImageViewer.DataSet<?> dataSet, int i) {
        ImageViewerAdapter imageViewerAdapter = new ImageViewerAdapter(getContext(), dataSet, this.customImageRequestBuilder, this.customDraweeHierarchyBuilder, this.isZoomingAllowed);
        this.adapter = imageViewerAdapter;
        this.pager.setAdapter(imageViewerAdapter);
        setStartPosition(i);
    }

    public void setCustomImageRequestBuilder(ImageRequestBuilder imageRequestBuilder) {
        this.customImageRequestBuilder = imageRequestBuilder;
    }

    public void setCustomDraweeHierarchyBuilder(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder) {
        this.customDraweeHierarchyBuilder = genericDraweeHierarchyBuilder;
    }

    public void setBackgroundColor(int i) {
        findViewById(C1891R.C1895id.backgroundView).setBackgroundColor(i);
    }

    public void setOverlayView(View view) {
        this.overlayView = view;
        if (view != null) {
            this.dismissContainer.addView(view);
        }
    }

    public void allowZooming(boolean z) {
        this.isZoomingAllowed = z;
    }

    public void allowSwipeToDismiss(boolean z) {
        this.isSwipeToDismissAllowed = z;
    }

    public void setImageMargin(int i) {
        this.pager.setPageMargin(i);
    }

    public void setContainerPadding(int[] iArr) {
        this.pager.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
    }

    private void init() {
        inflate(getContext(), C1891R.C1897layout.stream_image_viewer, this);
        this.backgroundView = findViewById(C1891R.C1895id.backgroundView);
        this.pager = (MultiTouchViewPager) findViewById(C1891R.C1895id.pager);
        this.dismissContainer = (ViewGroup) findViewById(C1891R.C1895id.container);
        SwipeToDismissListener swipeToDismissListener = new SwipeToDismissListener(findViewById(C1891R.C1895id.dismissView), this, this);
        this.swipeDismissListener = swipeToDismissListener;
        this.dismissContainer.setOnTouchListener(swipeToDismissListener);
        this.directionDetector = new SwipeDirectionDetector(getContext()) {
            public void onDirectionDetected(SwipeDirectionDetector.Direction direction) {
                SwipeDirectionDetector.Direction unused = ImageViewerView.this.direction = direction;
            }
        };
        this.scaleDetector = new ScaleGestureDetector(getContext(), new ScaleGestureDetector.SimpleOnScaleGestureListener());
        this.gestureDetector = new GestureDetectorCompat(getContext(), new GestureDetector.SimpleOnGestureListener() {
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (!ImageViewerView.this.pager.isScrolled()) {
                    return false;
                }
                ImageViewerView imageViewerView = ImageViewerView.this;
                imageViewerView.onClick(motionEvent, imageViewerView.isOverlayWasClicked);
                return false;
            }
        });
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        onUpDownEvent(motionEvent);
        if (this.direction == null && (this.scaleDetector.isInProgress() || motionEvent.getPointerCount() > 1)) {
            this.wasScaled = true;
            return this.pager.dispatchTouchEvent(motionEvent);
        } else if (this.adapter.isScaled(this.pager.getCurrentItem())) {
            return super.dispatchTouchEvent(motionEvent);
        } else {
            this.directionDetector.onTouchEvent(motionEvent);
            if (this.direction != null) {
                int i = C17333.f166x8593bc7[this.direction.ordinal()];
                if (i == 1 || i == 2) {
                    if (this.isSwipeToDismissAllowed && !this.wasScaled && this.pager.isScrolled()) {
                        return this.swipeDismissListener.onTouch(this.dismissContainer, motionEvent);
                    }
                } else if (i == 3 || i == 4) {
                    return this.pager.dispatchTouchEvent(motionEvent);
                }
            }
            return true;
        }
    }

    /* renamed from: com.getstream.sdk.chat.utils.frescoimageviewer.ImageViewerView$3 */
    static /* synthetic */ class C17333 {

        /* renamed from: $SwitchMap$com$getstream$sdk$chat$utils$frescoimageviewer$SwipeDirectionDetector$Direction */
        static final /* synthetic */ int[] f166x8593bc7;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.getstream.sdk.chat.utils.frescoimageviewer.SwipeDirectionDetector$Direction[] r0 = com.getstream.sdk.chat.utils.frescoimageviewer.SwipeDirectionDetector.Direction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f166x8593bc7 = r0
                com.getstream.sdk.chat.utils.frescoimageviewer.SwipeDirectionDetector$Direction r1 = com.getstream.sdk.chat.utils.frescoimageviewer.SwipeDirectionDetector.Direction.UP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f166x8593bc7     // Catch:{ NoSuchFieldError -> 0x001d }
                com.getstream.sdk.chat.utils.frescoimageviewer.SwipeDirectionDetector$Direction r1 = com.getstream.sdk.chat.utils.frescoimageviewer.SwipeDirectionDetector.Direction.DOWN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f166x8593bc7     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.getstream.sdk.chat.utils.frescoimageviewer.SwipeDirectionDetector$Direction r1 = com.getstream.sdk.chat.utils.frescoimageviewer.SwipeDirectionDetector.Direction.LEFT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f166x8593bc7     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.getstream.sdk.chat.utils.frescoimageviewer.SwipeDirectionDetector$Direction r1 = com.getstream.sdk.chat.utils.frescoimageviewer.SwipeDirectionDetector.Direction.RIGHT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.utils.frescoimageviewer.ImageViewerView.C17333.<clinit>():void");
        }
    }

    public void onDismiss() {
        OnDismissListener onDismissListener2 = this.onDismissListener;
        if (onDismissListener2 != null) {
            onDismissListener2.onDismiss();
        }
    }

    public void onViewMove(float f, int i) {
        float abs = 1.0f - (((1.0f / ((float) i)) / 4.0f) * Math.abs(f));
        this.backgroundView.setAlpha(abs);
        View view = this.overlayView;
        if (view != null) {
            view.setAlpha(abs);
        }
    }

    public void setOnDismissListener(OnDismissListener onDismissListener2) {
        this.onDismissListener = onDismissListener2;
    }

    public void resetScale() {
        this.adapter.resetScale(this.pager.getCurrentItem());
    }

    public boolean isScaled() {
        return this.adapter.isScaled(this.pager.getCurrentItem());
    }

    public String getUrl() {
        return this.adapter.getUrl(this.pager.getCurrentItem());
    }

    public void setPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.pager.removeOnPageChangeListener(this.pageChangeListener);
        this.pageChangeListener = onPageChangeListener;
        this.pager.addOnPageChangeListener(onPageChangeListener);
        onPageChangeListener.onPageSelected(this.pager.getCurrentItem());
    }

    private void setStartPosition(int i) {
        this.pager.setCurrentItem(i);
    }

    private void onUpDownEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            onActionUp(motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            onActionDown(motionEvent);
        }
        this.scaleDetector.onTouchEvent(motionEvent);
        this.gestureDetector.onTouchEvent(motionEvent);
    }

    private void onActionDown(MotionEvent motionEvent) {
        this.direction = null;
        this.wasScaled = false;
        this.pager.dispatchTouchEvent(motionEvent);
        this.swipeDismissListener.onTouch(this.dismissContainer, motionEvent);
        this.isOverlayWasClicked = dispatchOverlayTouch(motionEvent);
    }

    private void onActionUp(MotionEvent motionEvent) {
        this.swipeDismissListener.onTouch(this.dismissContainer, motionEvent);
        this.pager.dispatchTouchEvent(motionEvent);
        this.isOverlayWasClicked = dispatchOverlayTouch(motionEvent);
    }

    /* access modifiers changed from: private */
    public void onClick(MotionEvent motionEvent, boolean z) {
        View view = this.overlayView;
        if (view != null && !z) {
            AnimationUtils.animateVisibility(view);
            super.dispatchTouchEvent(motionEvent);
        }
    }

    private boolean dispatchOverlayTouch(MotionEvent motionEvent) {
        View view = this.overlayView;
        return view != null && view.getVisibility() == 0 && this.overlayView.dispatchTouchEvent(motionEvent);
    }
}
