package com.getstream.sdk.chat.utils.frescoimageviewer;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.viewpager.widget.ViewPager;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p015io.getstream.chat.android.client.logger.ChatLogger;

public class ImageViewer implements OnDismissListener, DialogInterface.OnKeyListener {
    private static final String TAG = "ImageViewer";
    /* access modifiers changed from: private */
    public Builder builder;
    private AlertDialog dialog;
    private ImageViewerView viewer;

    public interface Formatter<T> {
        String format(T t);
    }

    public interface OnDismissListener {
        void onDismiss();
    }

    public interface OnImageChangeListener {
        void onImageChange(int i);
    }

    protected ImageViewer(Builder builder2) {
        this.builder = builder2;
        createDialog();
    }

    public static ImageRequestBuilder createImageRequestBuilder() {
        return ImageRequestBuilder.newBuilderWithSource(Uri.parse(""));
    }

    public void show() {
        if (!this.builder.dataSet.data.isEmpty()) {
            this.dialog.show();
        } else {
            ChatLogger.Companion.getInstance().logE((Object) "ImageView", "Images list cannot be empty! Viewer ignored.");
        }
    }

    public String getUrl() {
        return this.viewer.getUrl();
    }

    private void createDialog() {
        ImageViewerView imageViewerView = new ImageViewerView(this.builder.context);
        this.viewer = imageViewerView;
        imageViewerView.setCustomImageRequestBuilder(this.builder.customImageRequestBuilder);
        this.viewer.setCustomDraweeHierarchyBuilder(this.builder.customHierarchyBuilder);
        this.viewer.allowZooming(this.builder.isZoomingAllowed);
        this.viewer.allowSwipeToDismiss(this.builder.isSwipeToDismissAllowed);
        this.viewer.setOnDismissListener(this);
        this.viewer.setBackgroundColor(this.builder.backgroundColor);
        this.viewer.setOverlayView(this.builder.overlayView);
        this.viewer.setImageMargin(this.builder.imageMarginPixels);
        this.viewer.setContainerPadding(this.builder.containerPaddingPixels);
        this.viewer.setUrls(this.builder.dataSet, this.builder.startPosition);
        this.viewer.setPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            public void onPageSelected(int i) {
                if (ImageViewer.this.builder.imageChangeListener != null) {
                    ImageViewer.this.builder.imageChangeListener.onImageChange(i);
                }
            }
        });
        AlertDialog create = new AlertDialog.Builder(this.builder.context, getDialogStyle()).setView((View) this.viewer).setOnKeyListener(this).create();
        this.dialog = create;
        create.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                if (ImageViewer.this.builder.onDismissListener != null) {
                    ImageViewer.this.builder.onDismissListener.onDismiss();
                }
            }
        });
    }

    public void onDismiss() {
        this.dialog.dismiss();
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
            if (this.viewer.isScaled()) {
                this.viewer.resetScale();
            } else {
                dialogInterface.cancel();
            }
        }
        return true;
    }

    private int getDialogStyle() {
        return this.builder.shouldStatusBarHide ? 16973841 : 16973840;
    }

    static class DataSet<T> {
        /* access modifiers changed from: private */
        public List<T> data;
        /* access modifiers changed from: private */
        public Formatter<T> formatter;

        DataSet(List<T> list) {
            this.data = list;
        }

        /* access modifiers changed from: package-private */
        public String format(int i) {
            return format(this.data.get(i));
        }

        /* access modifiers changed from: package-private */
        public String format(T t) {
            Formatter<T> formatter2 = this.formatter;
            if (formatter2 == null) {
                return t.toString();
            }
            return formatter2.format(t);
        }

        public List<T> getData() {
            return this.data;
        }
    }

    public static class Builder<T> {
        /* access modifiers changed from: private */
        public int backgroundColor;
        /* access modifiers changed from: private */
        public int[] containerPaddingPixels;
        /* access modifiers changed from: private */
        public Context context;
        /* access modifiers changed from: private */
        public GenericDraweeHierarchyBuilder customHierarchyBuilder;
        /* access modifiers changed from: private */
        public ImageRequestBuilder customImageRequestBuilder;
        /* access modifiers changed from: private */
        public DataSet<T> dataSet;
        /* access modifiers changed from: private */
        public OnImageChangeListener imageChangeListener;
        /* access modifiers changed from: private */
        public int imageMarginPixels;
        /* access modifiers changed from: private */
        public boolean isSwipeToDismissAllowed;
        /* access modifiers changed from: private */
        public boolean isZoomingAllowed;
        /* access modifiers changed from: private */
        public OnDismissListener onDismissListener;
        /* access modifiers changed from: private */
        public View overlayView;
        /* access modifiers changed from: private */
        public boolean shouldStatusBarHide;
        /* access modifiers changed from: private */
        public int startPosition;

        public Builder(Context context2, T[] tArr) {
            this(context2, new ArrayList(Arrays.asList(tArr)));
        }

        public Builder(Context context2, List<T> list) {
            this.backgroundColor = -16777216;
            this.containerPaddingPixels = new int[4];
            this.shouldStatusBarHide = true;
            this.isZoomingAllowed = true;
            this.isSwipeToDismissAllowed = true;
            this.context = context2;
            this.dataSet = new DataSet<>(list);
        }

        public Builder setFormatter(Formatter<T> formatter) {
            Formatter unused = this.dataSet.formatter = formatter;
            return this;
        }

        public Builder setBackgroundColorRes(int i) {
            return setBackgroundColor(this.context.getResources().getColor(i));
        }

        public Builder setBackgroundColor(int i) {
            this.backgroundColor = i;
            return this;
        }

        public Builder setStartPosition(int i) {
            this.startPosition = i;
            return this;
        }

        public Builder setImageChangeListener(OnImageChangeListener onImageChangeListener) {
            this.imageChangeListener = onImageChangeListener;
            return this;
        }

        public Builder setOverlayView(View view) {
            this.overlayView = view;
            return this;
        }

        public Builder setImageMarginPx(int i) {
            this.imageMarginPixels = i;
            return this;
        }

        public Builder setImageMargin(Context context2, int i) {
            this.imageMarginPixels = Math.round(context2.getResources().getDimension(i));
            return this;
        }

        public Builder setContainerPaddingPx(int i, int i2, int i3, int i4) {
            this.containerPaddingPixels = new int[]{i, i2, i3, i4};
            return this;
        }

        public Builder setContainerPadding(Context context2, int i, int i2, int i3, int i4) {
            setContainerPaddingPx(Math.round(context2.getResources().getDimension(i)), Math.round(context2.getResources().getDimension(i2)), Math.round(context2.getResources().getDimension(i3)), Math.round(context2.getResources().getDimension(i4)));
            return this;
        }

        public Builder setContainerPaddingPx(int i) {
            this.containerPaddingPixels = new int[]{i, i, i, i};
            return this;
        }

        public Builder setContainerPadding(Context context2, int i) {
            int round = Math.round(context2.getResources().getDimension(i));
            setContainerPaddingPx(round, round, round, round);
            return this;
        }

        public Builder hideStatusBar(boolean z) {
            this.shouldStatusBarHide = z;
            return this;
        }

        public Builder allowZooming(boolean z) {
            this.isZoomingAllowed = z;
            return this;
        }

        public Builder allowSwipeToDismiss(boolean z) {
            this.isSwipeToDismissAllowed = z;
            return this;
        }

        public Builder setOnDismissListener(OnDismissListener onDismissListener2) {
            this.onDismissListener = onDismissListener2;
            return this;
        }

        public Builder setCustomImageRequestBuilder(ImageRequestBuilder imageRequestBuilder) {
            this.customImageRequestBuilder = imageRequestBuilder;
            return this;
        }

        public Builder setCustomDraweeHierarchyBuilder(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder) {
            this.customHierarchyBuilder = genericDraweeHierarchyBuilder;
            return this;
        }

        public ImageViewer build() {
            return new ImageViewer(this);
        }

        public ImageViewer show() {
            ImageViewer build = build();
            build.show();
            return build;
        }
    }
}
