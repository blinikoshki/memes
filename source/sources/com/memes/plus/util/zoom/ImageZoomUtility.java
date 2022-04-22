package com.memes.plus.util.zoom;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.memes.plus.C4199R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u0000 \u00012\u00020\u0001:\u000e\u0001\u0001\u0001\u0001\u0001\u0001\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020.J\u000e\u0010[\u001a\u00020Y2\u0006\u0010Z\u001a\u000201J\u000e\u0010\\\u001a\u00020Y2\u0006\u0010Z\u001a\u000203J\b\u0010]\u001a\u00020YH\u0002J\u0010\u0010^\u001a\u00020Y2\u0006\u0010_\u001a\u00020`H\u0002J\u0006\u0010a\u001a\u00020YJ\b\u0010b\u001a\u00020YH\u0002J\b\u0010c\u001a\u00020YH\u0002J\u0016\u0010d\u001a\u00020\u000f2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020hJ\u0016\u0010d\u001a\u00020\u000f2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020IJ'\u0010d\u001a\u00020\u000f2\u0006\u0010e\u001a\u00020f2\u0012\u0010i\u001a\n\u0012\u0006\b\u0001\u0012\u00020I0j\"\u00020I¢\u0006\u0002\u0010kJ\u0010\u0010l\u001a\u00020Y2\u0006\u0010m\u001a\u00020nH\u0002J)\u0010o\u001a\u00020\u000f2\u0006\u0010e\u001a\u00020f2\u0012\u0010i\u001a\n\u0012\u0006\b\u0001\u0012\u00020I0j\"\u00020IH\u0002¢\u0006\u0002\u0010kJ\u0006\u0010p\u001a\u00020YJ\u000e\u0010q\u001a\u00020Y2\u0006\u0010Z\u001a\u00020.J\u000e\u0010r\u001a\u00020Y2\u0006\u0010Z\u001a\u000201J\u000e\u0010s\u001a\u00020Y2\u0006\u0010Z\u001a\u000203J\b\u0010t\u001a\u00020YH\u0002J\u001a\u0010u\u001a\u00020Y2\u0006\u0010v\u001a\u00020\u001a2\b\u0010e\u001a\u0004\u0018\u00010fH\u0002J\b\u0010w\u001a\u00020YH\u0002JR\u0010x\u001a\u00020Y2\u0006\u0010y\u001a\u00020\u001a2\u0006\u0010z\u001a\u00020\u001a2\u0006\u0010{\u001a\u00020\u001a2\u0006\u0010|\u001a\u00020\u001c2\u0006\u0010}\u001a\u00020\u001c2\u0006\u0010~\u001a\u00020\u001a2\u0006\u0010\u001a\u00020\u001a2\u0007\u0010\u0001\u001a\u00020\u001c2\u0007\u0010\u0001\u001a\u00020\u001cH\u0002J\u001b\u0010\u0001\u001a\u00020Y2\u0007\u0010\u0001\u001a\u00020\u001a2\u0007\u0010\u0001\u001a\u00020\u001aH\u0002R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f8F@FX\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f8F@FX\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u001a\u0010)\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R\u001e\u0010,\u001a\u0012\u0012\u0004\u0012\u00020.0-j\b\u0012\u0004\u0012\u00020.`/X\u000e¢\u0006\u0002\n\u0000R\u001e\u00100\u001a\u0012\u0012\u0004\u0012\u0002010-j\b\u0012\u0004\u0012\u000201`/X\u000e¢\u0006\u0002\n\u0000R\u001e\u00102\u001a\u0012\u0012\u0004\u0012\u0002030-j\b\u0012\u0004\u0012\u000203`/X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u000b\"\u0004\b;\u0010\rR\u001a\u0010<\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u000b\"\u0004\b>\u0010\rR\u000e\u0010?\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010B\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010#\"\u0004\bD\u0010%R\u001a\u0010E\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u001e\"\u0004\bG\u0010 R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010LX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010M\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0004\n\u0002\u0010NR\u0010\u0010O\u001a\u0004\u0018\u00010PX\u000e¢\u0006\u0002\n\u0000R\"\u0010Q\u001a\u0004\u0018\u00010I2\b\u0010\u0003\u001a\u0004\u0018\u00010I@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\"\u0010U\u001a\u0004\u0018\u00010T2\b\u0010\u0003\u001a\u0004\u0018\u00010T@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bV\u0010W¨\u0006\u0001"}, mo26107d2 = {"Lcom/memes/plus/util/zoom/ImageZoomUtility;", "", "()V", "<set-?>", "Landroid/app/Dialog;", "dialog", "getDialog", "()Landroid/app/Dialog;", "dismissDuration", "", "getDismissDuration", "()J", "setDismissDuration", "(J)V", "enabled", "", "isAnimating", "value", "isEnabled", "()Z", "setEnabled", "(Z)V", "isPlaceHolderEnabled", "setPlaceHolderEnabled", "isZooming", "lastScale", "", "layoutTheme", "", "getLayoutTheme", "()I", "setLayoutTheme", "(I)V", "maxScale", "getMaxScale", "()F", "setMaxScale", "(F)V", "maxShadowAlpha", "getMaxShadowAlpha", "setMaxShadowAlpha", "minScale", "getMinScale", "setMinScale", "onZoomLayoutCreatorListener", "Ljava/util/ArrayList;", "Lcom/memes/plus/util/zoom/ImageZoomUtility$OnZoomLayoutCreatorListener;", "Lkotlin/collections/ArrayList;", "onZoomScaleChangedListener", "Lcom/memes/plus/util/zoom/ImageZoomUtility$OnZoomScaleChangedListener;", "onZoomStateChangedListener", "Lcom/memes/plus/util/zoom/ImageZoomUtility$OnZoomStateChangedListener;", "originalDistance", "originalXY", "", "pivotX", "pivotY", "placeHolderDelay", "getPlaceHolderDelay", "setPlaceHolderDelay", "placeHolderDismissDelay", "getPlaceHolderDismissDelay", "setPlaceHolderDismissDelay", "placeHolderEnabled", "placeholderView", "Lcom/memes/plus/util/zoom/ImageZoomUtility$PlaceholderView;", "shadowAlphaFactory", "getShadowAlphaFactory", "setShadowAlphaFactory", "shadowColor", "getShadowColor", "setShadowColor", "shadowView", "Landroid/view/View;", "twoPointerCenter", "viewFrameLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "viewIndex", "Ljava/lang/Integer;", "viewLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "zoomableView", "getZoomableView", "()Landroid/view/View;", "Landroid/view/ViewGroup;", "zoomableViewParent", "getZoomableViewParent", "()Landroid/view/ViewGroup;", "addOnZoomLayoutCreatorListener", "", "listener", "addOnZoomScaleChangedListener", "addOnZoomStateChangedListener", "animateDismiss", "dialogCreated", "layout", "Landroid/widget/FrameLayout;", "dismiss", "dismissDialog", "dismissDialogAndViews", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "parent", "Landroid/app/Activity;", "parents", "", "(Landroid/view/MotionEvent;[Landroid/view/View;)Z", "init", "context", "Landroid/content/Context;", "load", "release", "removeOnZoomLayoutCreatorListener", "removeOnZoomScaleChangedListener", "removeOnZoomStateChangedListener", "reset", "scaleChanged", "scale", "stateChanged", "updateZoomableView", "animatedFraction", "scaleYStart", "scaleXStart", "leftMarginStart", "topMarginStart", "scaleXEnd", "scaleYEnd", "leftMarginEnd", "topMarginEnd", "updateZoomableViewMargins", "left", "top", "Companion", "ImageZoomInstanceState", "OnZoomLayoutCreatorListener", "OnZoomScaleChangedListener", "OnZoomStateChangedListener", "PlaceholderView", "SelfUtil", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ImageZoomUtility.kt */
public final class ImageZoomUtility {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private Dialog dialog;
    private long dismissDuration = -1;
    private boolean enabled = true;
    private boolean isAnimating;
    private boolean isZooming;
    private float lastScale = -10.0f;
    private int layoutTheme = C4199R.C4207style.ZoomLayoutStyle;
    private float maxScale = -1.0f;
    private float maxShadowAlpha = 0.8f;
    private float minScale = 1.0f;
    private ArrayList<OnZoomLayoutCreatorListener> onZoomLayoutCreatorListener = new ArrayList<>();
    private ArrayList<OnZoomScaleChangedListener> onZoomScaleChangedListener = new ArrayList<>();
    private ArrayList<OnZoomStateChangedListener> onZoomStateChangedListener = new ArrayList<>();
    private int originalDistance;
    private int[] originalXY;
    private float pivotX;
    private float pivotY;
    private long placeHolderDelay = 80;
    private long placeHolderDismissDelay = 30;
    private boolean placeHolderEnabled = true;
    /* access modifiers changed from: private */
    public PlaceholderView placeholderView;
    private float shadowAlphaFactory = 6.0f;
    private int shadowColor = -16777216;
    /* access modifiers changed from: private */
    public View shadowView;
    private int[] twoPointerCenter;
    private FrameLayout.LayoutParams viewFrameLayoutParams;
    /* access modifiers changed from: private */
    public Integer viewIndex = 0;
    /* access modifiers changed from: private */
    public ViewGroup.LayoutParams viewLayoutParams;
    /* access modifiers changed from: private */
    public View zoomableView;
    /* access modifiers changed from: private */
    public ViewGroup zoomableViewParent;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, mo26107d2 = {"Lcom/memes/plus/util/zoom/ImageZoomUtility$OnZoomLayoutCreatorListener;", "", "onZoomLayoutCreated", "", "zoomUtility", "Lcom/memes/plus/util/zoom/ImageZoomUtility;", "zoomableView", "Landroid/view/View;", "zoomLayout", "Landroid/widget/FrameLayout;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ImageZoomUtility.kt */
    public interface OnZoomLayoutCreatorListener {
        void onZoomLayoutCreated(ImageZoomUtility imageZoomUtility, View view, FrameLayout frameLayout);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, mo26107d2 = {"Lcom/memes/plus/util/zoom/ImageZoomUtility$OnZoomScaleChangedListener;", "", "onZoomScaleChanged", "", "zoomUtility", "Lcom/memes/plus/util/zoom/ImageZoomUtility;", "zoomableView", "Landroid/view/View;", "scale", "", "event", "Landroid/view/MotionEvent;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ImageZoomUtility.kt */
    public interface OnZoomScaleChangedListener {
        void onZoomScaleChanged(ImageZoomUtility imageZoomUtility, View view, float f, MotionEvent motionEvent);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, mo26107d2 = {"Lcom/memes/plus/util/zoom/ImageZoomUtility$OnZoomStateChangedListener;", "", "onZoomStateChanged", "", "zoomUtility", "Lcom/memes/plus/util/zoom/ImageZoomUtility;", "zoomableView", "Landroid/view/View;", "isZooming", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ImageZoomUtility.kt */
    public interface OnZoomStateChangedListener {
        void onZoomStateChanged(ImageZoomUtility imageZoomUtility, View view, boolean z);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001J\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\f¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/plus/util/zoom/ImageZoomUtility$Companion;", "", "()V", "addZoomableView", "", "view", "Landroid/view/View;", "tag", "getInstance", "Lcom/memes/plus/util/zoom/ImageZoomUtility;", "getZoomableViewTag", "isSkippingLayout", "", "isZoomableView", "removeZoomableView", "skipLayout", "skip", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ImageZoomUtility.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isZoomableView(View view) {
            Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
            return view.getTag(C4199R.C4203id.zoomable) != null;
        }

        public final void addZoomableView(View view) {
            Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
            view.setTag(C4199R.C4203id.zoomable, new Object());
        }

        public final void addZoomableView(View view, Object obj) {
            Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
            if (obj == null) {
                obj = new Object();
            }
            view.setTag(C4199R.C4203id.zoomable, obj);
        }

        public final Object getZoomableViewTag(View view) {
            Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
            return view.getTag(C4199R.C4203id.zoomable);
        }

        public final void removeZoomableView(View view) {
            Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
            view.setTag(C4199R.C4203id.zoomable, (Object) null);
        }

        public final ImageZoomUtility getInstance() {
            return ImageZoomInstanceState.INSTANCE.getZoomUtility();
        }

        public final boolean isSkippingLayout(View view) {
            Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
            return view.getTag(C4199R.C4203id.skip_zoom_layout) != null;
        }

        public final void skipLayout(View view, boolean z) {
            Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
            view.setTag(C4199R.C4203id.skip_zoom_layout, z ? new Object() : null);
        }
    }

    public final View getZoomableView() {
        return this.zoomableView;
    }

    public final ViewGroup getZoomableViewParent() {
        return this.zoomableViewParent;
    }

    public final Dialog getDialog() {
        return this.dialog;
    }

    public final boolean isZooming() {
        return this.isZooming;
    }

    public final float getMaxScale() {
        return this.maxScale;
    }

    public final void setMaxScale(float f) {
        this.maxScale = f;
    }

    public final float getMinScale() {
        return this.minScale;
    }

    public final void setMinScale(float f) {
        this.minScale = f;
    }

    public final float getShadowAlphaFactory() {
        return this.shadowAlphaFactory;
    }

    public final void setShadowAlphaFactory(float f) {
        this.shadowAlphaFactory = f;
    }

    public final float getMaxShadowAlpha() {
        return this.maxShadowAlpha;
    }

    public final void setMaxShadowAlpha(float f) {
        this.maxShadowAlpha = f;
    }

    public final int getShadowColor() {
        return this.shadowColor;
    }

    public final void setShadowColor(int i) {
        this.shadowColor = i;
    }

    public final int getLayoutTheme() {
        return this.layoutTheme;
    }

    public final void setLayoutTheme(int i) {
        this.layoutTheme = i;
    }

    public final long getDismissDuration() {
        return this.dismissDuration;
    }

    public final void setDismissDuration(long j) {
        this.dismissDuration = j;
    }

    public final long getPlaceHolderDelay() {
        return this.placeHolderDelay;
    }

    public final void setPlaceHolderDelay(long j) {
        this.placeHolderDelay = j;
    }

    public final long getPlaceHolderDismissDelay() {
        return this.placeHolderDismissDelay;
    }

    public final void setPlaceHolderDismissDelay(long j) {
        this.placeHolderDismissDelay = j;
    }

    public final boolean isPlaceHolderEnabled() {
        return this.placeHolderEnabled;
    }

    public final void setPlaceHolderEnabled(boolean z) {
        this.placeHolderEnabled = z;
        PlaceholderView placeholderView2 = this.placeholderView;
        if (placeholderView2 != null) {
            placeholderView2.setEnabled(z);
        }
    }

    public final boolean isEnabled() {
        return this.enabled;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
        if (this.zoomableView != null && !this.isAnimating) {
            animateDismiss();
        }
    }

    private final void init(Context context) {
        if (this.dismissDuration < 0) {
            this.dismissDuration = (long) context.getResources().getInteger(17694720);
        }
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        Intrinsics.checkNotNullParameter(view, "parent");
        return load(motionEvent, view);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent, Activity activity) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        Intrinsics.checkNotNullParameter(activity, "parent");
        View findViewById = activity.findViewById(16908290);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        return load(motionEvent, findViewById);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent, View... viewArr) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        Intrinsics.checkNotNullParameter(viewArr, "parents");
        return load(motionEvent, (View[]) Arrays.copyOf(viewArr, viewArr.length));
    }

    private final boolean load(MotionEvent motionEvent, View... viewArr) {
        MotionEvent motionEvent2 = motionEvent;
        View[] viewArr2 = viewArr;
        if (!isEnabled()) {
            return this.isAnimating;
        }
        if (viewArr2.length == 0) {
            return false;
        }
        Context context = viewArr2[0].getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        init(context);
        if (motionEvent.getPointerCount() >= 2) {
            if (this.zoomableView == null) {
                View findZoomableView = SelfUtil.INSTANCE.findZoomableView(motionEvent2, (View[]) Arrays.copyOf(viewArr2, viewArr2.length));
                if (findZoomableView == null) {
                    return false;
                }
                this.zoomableView = findZoomableView;
                reset();
                this.isAnimating = false;
                this.isZooming = true;
                int[] iArr = new int[2];
                this.originalXY = iArr;
                if (findZoomableView != null) {
                    findZoomableView.getLocationOnScreen(iArr);
                }
                FrameLayout frameLayout = new FrameLayout(context);
                View view = new View(context);
                this.shadowView = view;
                view.setBackgroundColor(this.shadowColor);
                View view2 = this.shadowView;
                if (view2 != null) {
                    view2.setAlpha(0.0f);
                }
                frameLayout.addView(this.shadowView, new FrameLayout.LayoutParams(-1, -1));
                Dialog dialog2 = new Dialog(context, 16973841);
                this.dialog = dialog2;
                dialog2.addContentView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
                dialogCreated(frameLayout);
                Dialog dialog3 = this.dialog;
                if (dialog3 != null) {
                    dialog3.show();
                }
                Integer num = null;
                ViewParent parent = findZoomableView != null ? findZoomableView.getParent() : null;
                Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewGroup viewGroup = (ViewGroup) parent;
                this.zoomableViewParent = viewGroup;
                if (viewGroup != null) {
                    num = Integer.valueOf(viewGroup.indexOfChild(this.zoomableView));
                }
                this.viewIndex = num;
                this.viewLayoutParams = findZoomableView.getLayoutParams();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(findZoomableView.getWidth(), findZoomableView.getHeight());
                this.viewFrameLayoutParams = layoutParams;
                int[] iArr2 = this.originalXY;
                Intrinsics.checkNotNull(iArr2);
                layoutParams.leftMargin = iArr2[0];
                FrameLayout.LayoutParams layoutParams2 = this.viewFrameLayoutParams;
                if (layoutParams2 != null) {
                    int[] iArr3 = this.originalXY;
                    Intrinsics.checkNotNull(iArr3);
                    layoutParams2.topMargin = iArr3[1];
                }
                PlaceholderView placeholderView2 = new PlaceholderView(findZoomableView);
                this.placeholderView = placeholderView2;
                placeholderView2.setEnabled(this.placeHolderEnabled);
                Integer num2 = this.viewIndex;
                int intValue = num2 != null ? num2.intValue() : 0;
                ViewGroup viewGroup2 = this.zoomableViewParent;
                if (viewGroup2 != null) {
                    viewGroup2.addView(this.placeholderView, intValue, this.viewLayoutParams);
                }
                ViewGroup viewGroup3 = this.zoomableViewParent;
                if (viewGroup3 != null) {
                    viewGroup3.removeView(findZoomableView);
                }
                frameLayout.addView(this.zoomableView, this.viewFrameLayoutParams);
                if (this.placeHolderEnabled) {
                    findZoomableView.postDelayed(new ImageZoomUtility$load$1(this), this.placeHolderDelay);
                }
                MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
                motionEvent2.getPointerCoords(0, pointerCoords);
                MotionEvent.PointerCoords pointerCoords2 = new MotionEvent.PointerCoords();
                motionEvent2.getPointerCoords(1, pointerCoords2);
                this.originalDistance = SelfUtil.INSTANCE.getDistance((double) pointerCoords.x, (double) pointerCoords.y, (double) pointerCoords2.x, (double) pointerCoords2.y);
                float f = (float) 2;
                this.twoPointerCenter = new int[]{(int) ((pointerCoords2.x + pointerCoords.x) / f), (int) ((pointerCoords2.y + pointerCoords.y) / f)};
                float rawX = motionEvent.getRawX();
                int[] iArr4 = this.originalXY;
                Intrinsics.checkNotNull(iArr4);
                this.pivotX = rawX - ((float) iArr4[0]);
                float rawY = motionEvent.getRawY();
                int[] iArr5 = this.originalXY;
                Intrinsics.checkNotNull(iArr5);
                this.pivotY = rawY - ((float) iArr5[1]);
                stateChanged();
                return true;
            }
            MotionEvent.PointerCoords pointerCoords3 = new MotionEvent.PointerCoords();
            motionEvent2.getPointerCoords(0, pointerCoords3);
            MotionEvent.PointerCoords pointerCoords4 = new MotionEvent.PointerCoords();
            motionEvent2.getPointerCoords(1, pointerCoords4);
            float f2 = (float) 2;
            int[] iArr6 = {(int) ((pointerCoords4.x + pointerCoords3.x) / f2), (int) ((pointerCoords4.y + pointerCoords3.y) / f2)};
            SelfUtil selfUtil = SelfUtil.INSTANCE;
            double d = (double) pointerCoords3.x;
            int i = this.originalDistance;
            double distance = (((double) selfUtil.getDistance(d, (double) pointerCoords3.y, (double) pointerCoords4.x, (double) pointerCoords4.y)) - ((double) i)) / ((double) i);
            View view3 = this.zoomableView;
            Intrinsics.checkNotNull(view3);
            view3.setPivotX(this.pivotX);
            View view4 = this.zoomableView;
            Intrinsics.checkNotNull(view4);
            view4.setPivotY(this.pivotY);
            float f3 = (float) (((double) 1) + distance);
            float f4 = this.minScale;
            if (f4 != -1.0f) {
                f3 = Math.max(f4, f3);
            }
            float f5 = this.maxScale;
            if (f5 != -1.0f) {
                f3 = Math.min(f5, f3);
            }
            float min = Math.min(Float.MAX_VALUE, Math.max(Float.MIN_VALUE, f3));
            View view5 = this.zoomableView;
            Intrinsics.checkNotNull(view5);
            view5.setScaleX(min);
            View view6 = this.zoomableView;
            Intrinsics.checkNotNull(view6);
            view6.setScaleY(min);
            int[] iArr7 = this.twoPointerCenter;
            if (!(iArr7 == null || this.originalXY == null)) {
                int i2 = iArr6[0];
                Intrinsics.checkNotNull(iArr7);
                int i3 = i2 - iArr7[0];
                int[] iArr8 = this.originalXY;
                Intrinsics.checkNotNull(iArr8);
                float f6 = (float) (i3 + iArr8[0]);
                int i4 = iArr6[1];
                int[] iArr9 = this.twoPointerCenter;
                Intrinsics.checkNotNull(iArr9);
                int[] iArr10 = this.originalXY;
                Intrinsics.checkNotNull(iArr10);
                updateZoomableViewMargins(f6, ((float) (i4 - iArr9[1])) + ((float) iArr10[1]));
            }
            scaleChanged(min, motionEvent2);
            float f7 = this.lastScale;
            if (f7 != -10.0f && f7 == min) {
                return true;
            }
            this.lastScale = min;
            View view7 = this.shadowView;
            if (view7 == null) {
                return true;
            }
            view7.setAlpha(Math.max(Math.min(this.maxShadowAlpha, (float) Math.abs(distance / ((double) this.shadowAlphaFactory))), 0.0f));
            return true;
        } else if (this.zoomableView == null) {
            return false;
        } else {
            if (!this.isAnimating) {
                animateDismiss();
            }
            return true;
        }
    }

    private final void reset() {
        this.lastScale = -10.0f;
    }

    private final void animateDismiss() {
        reset();
        View view = this.zoomableView;
        if (view != null && this.originalXY != null) {
            this.isAnimating = true;
            Intrinsics.checkNotNull(view);
            float scaleY = view.getScaleY();
            View view2 = this.zoomableView;
            Intrinsics.checkNotNull(view2);
            float scaleX = view2.getScaleX();
            FrameLayout.LayoutParams layoutParams = this.viewFrameLayoutParams;
            Intrinsics.checkNotNull(layoutParams);
            int i = layoutParams.leftMargin;
            FrameLayout.LayoutParams layoutParams2 = this.viewFrameLayoutParams;
            Intrinsics.checkNotNull(layoutParams2);
            int i2 = layoutParams2.topMargin;
            View view3 = this.shadowView;
            Intrinsics.checkNotNull(view3);
            float alpha = view3.getAlpha();
            int[] iArr = this.originalXY;
            Intrinsics.checkNotNull(iArr);
            int i3 = iArr[0];
            int[] iArr2 = this.originalXY;
            Intrinsics.checkNotNull(iArr2);
            int i4 = iArr2[1];
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            Intrinsics.checkNotNullExpressionValue(ofFloat, "valueAnimator");
            ofFloat.setDuration(this.dismissDuration);
            float f = scaleY;
            float f2 = scaleX;
            int i5 = i;
            int i6 = i3;
            ValueAnimator valueAnimator = ofFloat;
            int i7 = i4;
            int i8 = i2;
            ValueAnimator valueAnimator2 = valueAnimator;
            valueAnimator2.addUpdateListener(new ImageZoomUtility$animateDismiss$1(this, f, f2, i5, i2, 1.0f, 1.0f, i6, i7, 0.0f, alpha));
            valueAnimator2.addListener(new ImageZoomUtility$animateDismiss$2(this, f, f2, i5, i8, 1.0f, 1.0f, i6, i7, valueAnimator2));
            valueAnimator2.start();
        }
    }

    /* access modifiers changed from: private */
    public final void updateZoomableView(float f, float f2, float f3, int i, int i2, float f4, float f5, int i3, int i4) {
        View view = this.zoomableView;
        if (view != null) {
            view.setScaleX(((f4 - f3) * f) + f3);
        }
        View view2 = this.zoomableView;
        if (view2 != null) {
            view2.setScaleY(((f5 - f2) * f) + f2);
        }
        View view3 = this.zoomableView;
        Intrinsics.checkNotNull(view3);
        scaleChanged(view3.getScaleX(), (MotionEvent) null);
        updateZoomableViewMargins((((float) (i3 - i)) * f) + ((float) i), (((float) (i4 - i2)) * f) + ((float) i2));
    }

    private final void updateZoomableViewMargins(float f, float f2) {
        FrameLayout.LayoutParams layoutParams;
        if (this.zoomableView != null && (layoutParams = this.viewFrameLayoutParams) != null) {
            Intrinsics.checkNotNull(layoutParams);
            layoutParams.leftMargin = (int) f;
            FrameLayout.LayoutParams layoutParams2 = this.viewFrameLayoutParams;
            Intrinsics.checkNotNull(layoutParams2);
            layoutParams2.topMargin = (int) f2;
            View view = this.zoomableView;
            if (view != null) {
                view.setLayoutParams(this.viewFrameLayoutParams);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void dismissDialogAndViews() {
        View view = this.zoomableView;
        if (view != null) {
            view.setVisibility(0);
            if (this.placeHolderEnabled) {
                PlaceholderView placeholderView2 = this.placeholderView;
                if (placeholderView2 != null) {
                    placeholderView2.setVisibility(0);
                }
                PlaceholderView placeholderView3 = this.placeholderView;
                if (placeholderView3 != null) {
                    placeholderView3.postDelayed(new ImageZoomUtility$dismissDialogAndViews$1(this, view), this.placeHolderDismissDelay);
                }
            } else {
                ViewParent parent = view.getParent();
                Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(view);
                ViewGroup viewGroup = this.zoomableViewParent;
                if (viewGroup != null) {
                    Integer num = this.viewIndex;
                    Intrinsics.checkNotNull(num);
                    viewGroup.addView(view, num.intValue(), this.viewLayoutParams);
                }
                ViewGroup viewGroup2 = this.zoomableViewParent;
                if (viewGroup2 != null) {
                    viewGroup2.removeView(this.placeholderView);
                }
                dismissDialog();
            }
        } else {
            dismissDialog();
        }
        this.isAnimating = false;
        this.isZooming = false;
        stateChanged();
    }

    /* access modifiers changed from: private */
    public final void dismissDialog() {
        Dialog dialog2 = this.dialog;
        if (dialog2 != null) {
            if (dialog2 != null) {
                dialog2.dismiss();
            }
            this.dialog = null;
        }
        View view = null;
        this.shadowView = view;
        this.placeholderView = null;
        View view2 = this.zoomableView;
        if (view2 != null) {
            if (view2 != null) {
                view2.invalidate();
            }
            this.zoomableView = view;
        }
        this.isAnimating = false;
        this.isZooming = false;
    }

    private final void stateChanged() {
        if (this.zoomableView != null) {
            Iterator<OnZoomStateChangedListener> it = this.onZoomStateChangedListener.iterator();
            while (it.hasNext()) {
                View view = this.zoomableView;
                Intrinsics.checkNotNull(view);
                it.next().onZoomStateChanged(this, view, this.isZooming);
            }
        }
    }

    private final void scaleChanged(float f, MotionEvent motionEvent) {
        if (this.zoomableView != null) {
            Iterator<OnZoomScaleChangedListener> it = this.onZoomScaleChangedListener.iterator();
            while (it.hasNext()) {
                View view = this.zoomableView;
                Intrinsics.checkNotNull(view);
                it.next().onZoomScaleChanged(this, view, f, motionEvent);
            }
        }
    }

    private final void dialogCreated(FrameLayout frameLayout) {
        if (this.zoomableView != null) {
            Iterator<OnZoomLayoutCreatorListener> it = this.onZoomLayoutCreatorListener.iterator();
            while (it.hasNext()) {
                View view = this.zoomableView;
                Intrinsics.checkNotNull(view);
                it.next().onZoomLayoutCreated(this, view, frameLayout);
            }
        }
    }

    public final void addOnZoomStateChangedListener(OnZoomStateChangedListener onZoomStateChangedListener2) {
        Intrinsics.checkNotNullParameter(onZoomStateChangedListener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onZoomStateChangedListener.add(onZoomStateChangedListener2);
    }

    public final void removeOnZoomStateChangedListener(OnZoomStateChangedListener onZoomStateChangedListener2) {
        Intrinsics.checkNotNullParameter(onZoomStateChangedListener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onZoomStateChangedListener.remove(onZoomStateChangedListener2);
    }

    public final void addOnZoomScaleChangedListener(OnZoomScaleChangedListener onZoomScaleChangedListener2) {
        Intrinsics.checkNotNullParameter(onZoomScaleChangedListener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onZoomScaleChangedListener.add(onZoomScaleChangedListener2);
    }

    public final void removeOnZoomScaleChangedListener(OnZoomScaleChangedListener onZoomScaleChangedListener2) {
        Intrinsics.checkNotNullParameter(onZoomScaleChangedListener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onZoomScaleChangedListener.remove(onZoomScaleChangedListener2);
    }

    public final void addOnZoomLayoutCreatorListener(OnZoomLayoutCreatorListener onZoomLayoutCreatorListener2) {
        Intrinsics.checkNotNullParameter(onZoomLayoutCreatorListener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onZoomLayoutCreatorListener.add(onZoomLayoutCreatorListener2);
    }

    public final void removeOnZoomLayoutCreatorListener(OnZoomLayoutCreatorListener onZoomLayoutCreatorListener2) {
        Intrinsics.checkNotNullParameter(onZoomLayoutCreatorListener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onZoomLayoutCreatorListener.remove(onZoomLayoutCreatorListener2);
    }

    public final void dismiss() {
        dismissDialog();
    }

    public final void release() {
        dismiss();
        ImageZoomInstanceState.INSTANCE.release();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, mo26107d2 = {"Lcom/memes/plus/util/zoom/ImageZoomUtility$ImageZoomInstanceState;", "", "()V", "utility", "Lcom/memes/plus/util/zoom/ImageZoomUtility;", "getZoomUtility", "release", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ImageZoomUtility.kt */
    public static final class ImageZoomInstanceState {
        public static final ImageZoomInstanceState INSTANCE = new ImageZoomInstanceState();
        private static ImageZoomUtility utility;

        private ImageZoomInstanceState() {
        }

        public final ImageZoomUtility getZoomUtility() {
            if (utility == null) {
                utility = new ImageZoomUtility();
            }
            ImageZoomUtility imageZoomUtility = utility;
            if (imageZoomUtility != null) {
                return imageZoomUtility;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }

        public final void release() {
            utility = null;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/plus/util/zoom/ImageZoomUtility$PlaceholderView;", "Landroid/view/View;", "view", "(Landroid/view/View;)V", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ImageZoomUtility.kt */
    public static final class PlaceholderView extends View {
        private View view;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PlaceholderView(Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public PlaceholderView(android.view.View r3) {
            /*
                r2 = this;
                java.lang.String r0 = "view"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                android.content.Context r0 = r3.getContext()
                java.lang.String r1 = "view.context"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                r2.<init>((android.content.Context) r0)
                r2.view = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.util.zoom.ImageZoomUtility.PlaceholderView.<init>(android.view.View):void");
        }

        /* access modifiers changed from: protected */
        public void onDraw(Canvas canvas) {
            if (this.view == null || !isEnabled()) {
                super.onDraw(canvas);
                return;
            }
            View view2 = this.view;
            if (view2 != null) {
                view2.draw(canvas);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002J)\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0010\"\u00020\u0004¢\u0006\u0002\u0010\u0011J&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u0014J2\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002¨\u0006\u0018"}, mo26107d2 = {"Lcom/memes/plus/util/zoom/ImageZoomUtility$SelfUtil;", "", "()V", "checkChild", "Landroid/view/View;", "vg", "Landroid/view/ViewGroup;", "x1", "", "y1", "x2", "y2", "findZoomableView", "ev", "Landroid/view/MotionEvent;", "parents", "", "(Landroid/view/MotionEvent;[Landroid/view/View;)Landroid/view/View;", "getDistance", "", "", "isViewInArea", "", "view", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ImageZoomUtility.kt */
    public static final class SelfUtil {
        public static final SelfUtil INSTANCE = new SelfUtil();

        private SelfUtil() {
        }

        public final View findZoomableView(MotionEvent motionEvent, View... viewArr) {
            View checkChild;
            Intrinsics.checkNotNullParameter(motionEvent, "ev");
            Intrinsics.checkNotNullParameter(viewArr, "parents");
            if (viewArr.length == 0) {
                return null;
            }
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            motionEvent.getPointerCoords(0, pointerCoords);
            MotionEvent.PointerCoords pointerCoords2 = new MotionEvent.PointerCoords();
            motionEvent.getPointerCoords(1, pointerCoords2);
            for (ViewGroup viewGroup : viewArr) {
                if (!ImageZoomUtility.Companion.isSkippingLayout(viewGroup)) {
                    if (isViewInArea(viewGroup, pointerCoords.x, pointerCoords.y, pointerCoords2.x, pointerCoords2.y) && ImageZoomUtility.Companion.isZoomableView(viewGroup)) {
                        return viewGroup;
                    }
                    if ((viewGroup instanceof ViewGroup) && (checkChild = checkChild(viewGroup, pointerCoords.x, pointerCoords.y, pointerCoords2.x, pointerCoords2.y)) != null) {
                        return checkChild;
                    }
                }
            }
            return null;
        }

        private final View checkChild(ViewGroup viewGroup, float f, float f2, float f3, float f4) {
            View checkChild;
            ViewGroup viewGroup2 = viewGroup;
            if (viewGroup2 == null) {
                return null;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup2.getChildAt(i);
                Companion companion = ImageZoomUtility.Companion;
                Intrinsics.checkNotNullExpressionValue(childAt, "child");
                if (!companion.isSkippingLayout(childAt) && isViewInArea(childAt, f, f2, f3, f4)) {
                    if (ImageZoomUtility.Companion.isZoomableView(childAt)) {
                        return childAt;
                    }
                    if ((childAt instanceof ViewGroup) && (checkChild = checkChild((ViewGroup) childAt, f, f2, f3, f4)) != null) {
                        return checkChild;
                    }
                }
            }
            return null;
        }

        private final boolean isViewInArea(View view, float f, float f2, float f3, float f4) {
            if (view == null) {
                return false;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            Rect rect = new Rect();
            rect.left = iArr[0];
            rect.top = iArr[1];
            rect.right = rect.left + view.getWidth();
            rect.bottom = rect.top + view.getHeight();
            if (!rect.contains((int) f, (int) f2) || !rect.contains((int) f3, (int) f4)) {
                return false;
            }
            return true;
        }

        public final int getDistance(double d, double d2, double d3, double d4) {
            return (int) Math.sqrt(Math.pow(d3 - d, 2.0d) + Math.pow(d4 - d2, 2.0d));
        }
    }
}
