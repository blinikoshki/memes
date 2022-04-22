package com.getstream.sdk.chat.utils.frescoimageviewer;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.getstream.sdk.chat.utils.frescoimageviewer.ImageViewer;
import com.getstream.sdk.chat.utils.frescoimageviewer.adapter.RecyclingPagerAdapter;
import com.getstream.sdk.chat.utils.frescoimageviewer.adapter.ViewHolder;
import com.getstream.sdk.chat.utils.frescoimageviewer.drawee.ZoomableDraweeView;
import java.util.HashSet;
import java.util.Iterator;
import p019me.relex.photodraweeview.OnScaleChangeListener;

class ImageViewerAdapter extends RecyclingPagerAdapter<ImageViewHolder> {
    private Context context;
    /* access modifiers changed from: private */
    public ImageViewer.DataSet<?> dataSet;
    /* access modifiers changed from: private */
    public GenericDraweeHierarchyBuilder hierarchyBuilder;
    private HashSet<ImageViewHolder> holders = new HashSet<>();
    /* access modifiers changed from: private */
    public ImageRequestBuilder imageRequestBuilder;
    private boolean isZoomingAllowed;

    ImageViewerAdapter(Context context2, ImageViewer.DataSet<?> dataSet2, ImageRequestBuilder imageRequestBuilder2, GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder, boolean z) {
        this.context = context2;
        this.dataSet = dataSet2;
        this.imageRequestBuilder = imageRequestBuilder2;
        this.hierarchyBuilder = genericDraweeHierarchyBuilder;
        this.isZoomingAllowed = z;
    }

    public ImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ZoomableDraweeView zoomableDraweeView = new ZoomableDraweeView(this.context);
        zoomableDraweeView.setEnabled(this.isZoomingAllowed);
        ImageViewHolder imageViewHolder = new ImageViewHolder(zoomableDraweeView);
        this.holders.add(imageViewHolder);
        return imageViewHolder;
    }

    public void onBindViewHolder(ImageViewHolder imageViewHolder, int i) {
        imageViewHolder.bind(i);
    }

    public int getItemCount() {
        return this.dataSet.getData().size();
    }

    /* access modifiers changed from: package-private */
    public boolean isScaled(int i) {
        Iterator<ImageViewHolder> it = this.holders.iterator();
        while (it.hasNext()) {
            ImageViewHolder next = it.next();
            if (next.position == i) {
                return next.isScaled;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void resetScale(int i) {
        Iterator<ImageViewHolder> it = this.holders.iterator();
        while (it.hasNext()) {
            ImageViewHolder next = it.next();
            if (next.position == i) {
                next.resetScale();
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String getUrl(int i) {
        return this.dataSet.format(i);
    }

    /* access modifiers changed from: private */
    public BaseControllerListener<ImageInfo> getDraweeControllerListener(final ZoomableDraweeView zoomableDraweeView) {
        return new BaseControllerListener<ImageInfo>() {
            public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
                super.onFinalImageSet(str, imageInfo, animatable);
                if (imageInfo != null) {
                    zoomableDraweeView.update(imageInfo.getWidth(), imageInfo.getHeight());
                }
            }
        };
    }

    class ImageViewHolder extends ViewHolder implements OnScaleChangeListener {
        private ZoomableDraweeView drawee;
        /* access modifiers changed from: private */
        public boolean isScaled;
        /* access modifiers changed from: private */
        public int position = -1;

        ImageViewHolder(View view) {
            super(view);
            this.drawee = (ZoomableDraweeView) view;
        }

        /* access modifiers changed from: package-private */
        public void bind(int i) {
            this.position = i;
            tryToSetHierarchy();
            setController(ImageViewerAdapter.this.dataSet.format(i));
            this.drawee.setOnScaleChangeListener(this);
        }

        public void onScaleChange(float f, float f2, float f3) {
            this.isScaled = this.drawee.getScale() > 1.0f;
        }

        /* access modifiers changed from: package-private */
        public void resetScale() {
            this.drawee.setScale(1.0f, true);
        }

        private void tryToSetHierarchy() {
            if (ImageViewerAdapter.this.hierarchyBuilder != null) {
                ImageViewerAdapter.this.hierarchyBuilder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
                this.drawee.setHierarchy(ImageViewerAdapter.this.hierarchyBuilder.build());
            }
        }

        private void setController(String str) {
            PipelineDraweeControllerBuilder newDraweeControllerBuilder = Fresco.newDraweeControllerBuilder();
            newDraweeControllerBuilder.setUri(str);
            newDraweeControllerBuilder.setOldController(this.drawee.getController());
            newDraweeControllerBuilder.setControllerListener(ImageViewerAdapter.this.getDraweeControllerListener(this.drawee));
            if (ImageViewerAdapter.this.imageRequestBuilder != null) {
                ImageViewerAdapter.this.imageRequestBuilder.setSource(Uri.parse(str));
                newDraweeControllerBuilder.setImageRequest(ImageViewerAdapter.this.imageRequestBuilder.build());
            }
            this.drawee.setController(newDraweeControllerBuilder.build());
        }
    }
}
