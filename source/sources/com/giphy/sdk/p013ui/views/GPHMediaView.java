package com.giphy.sdk.p013ui.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.imagepipeline.image.ImageInfo;
import com.giphy.sdk.p013ui.drawables.GPHBrandingDrawer;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J&\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0018H\u0014R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006#"}, mo26107d2 = {"Lcom/giphy/sdk/ui/views/GPHMediaView;", "Lcom/giphy/sdk/ui/views/GifView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "brandingDrawer", "Lcom/giphy/sdk/ui/drawables/GPHBrandingDrawer;", "mediaActionsView", "Lcom/giphy/sdk/ui/views/GPHMediaActionsView;", "getMediaActionsView", "()Lcom/giphy/sdk/ui/views/GPHMediaActionsView;", "setMediaActionsView", "(Lcom/giphy/sdk/ui/views/GPHMediaActionsView;)V", "showAttribution", "", "getShowAttribution", "()Z", "setShowAttribution", "(Z)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onFinalImageSet", "id", "", "imageInfo", "Lcom/facebook/imagepipeline/image/ImageInfo;", "anim", "Landroid/graphics/drawable/Animatable;", "onMediaChanged", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GPHMediaView */
/* compiled from: GPHMediaView.kt */
public final class GPHMediaView extends GifView {
    private HashMap _$_findViewCache;
    private GPHBrandingDrawer brandingDrawer;
    private GPHMediaActionsView mediaActionsView;
    private boolean showAttribution;

    public GPHMediaView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public GPHMediaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GPHMediaView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GPHMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.showAttribution = true;
        this.brandingDrawer = new GPHBrandingDrawer(context);
        this.mediaActionsView = new GPHMediaActionsView(context, new GPHActions[]{GPHActions.CopyLink, GPHActions.OpenGiphy});
        setOnLongClickListener(new View.OnLongClickListener(this) {
            final /* synthetic */ GPHMediaView this$0;

            {
                this.this$0 = r1;
            }

            public final boolean onLongClick(View view) {
                this.this$0.getMediaActionsView().showAsDropDown(this.this$0);
                return true;
            }
        });
    }

    public final boolean getShowAttribution() {
        return this.showAttribution;
    }

    public final void setShowAttribution(boolean z) {
        this.showAttribution = z;
    }

    public final GPHMediaActionsView getMediaActionsView() {
        return this.mediaActionsView;
    }

    public final void setMediaActionsView(GPHMediaActionsView gPHMediaActionsView) {
        Intrinsics.checkParameterIsNotNull(gPHMediaActionsView, "<set-?>");
        this.mediaActionsView = gPHMediaActionsView;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        GPHBrandingDrawer gPHBrandingDrawer;
        super.onDraw(canvas);
        if (this.showAttribution && (gPHBrandingDrawer = this.brandingDrawer) != null) {
            gPHBrandingDrawer.draw(canvas);
        }
    }

    public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
        GPHBrandingDrawer gPHBrandingDrawer;
        super.onFinalImageSet(str, imageInfo, animatable);
        if (this.showAttribution && (gPHBrandingDrawer = this.brandingDrawer) != null) {
            gPHBrandingDrawer.startAnimation();
        }
    }

    /* access modifiers changed from: protected */
    public void onMediaChanged() {
        this.mediaActionsView.setMedia(getMedia());
    }
}
