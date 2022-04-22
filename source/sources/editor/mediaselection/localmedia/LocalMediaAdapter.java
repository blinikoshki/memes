package editor.mediaselection.localmedia;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NLocalMediaSelectionItemBinding;
import editor.mediaselection.BaseMediaCategoryAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aBO\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012@\u0010\u0005\u001a<\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\u0002`\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0015H\u0016¨\u0006\u001b"}, mo26107d2 = {"Leditor/mediaselection/localmedia/LocalMediaAdapter;", "Leditor/mediaselection/BaseMediaCategoryAdapter;", "Leditor/mediaselection/localmedia/LocalMedia;", "context", "Landroid/content/Context;", "itemSelectionCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "item", "", "selected", "Leditor/mediaselection/ItemSelectedCallback;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function2;)V", "getItemId", "", "onBindViewHolder", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "LocalMediaSelectionViewHolder", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: LocalMediaAdapter.kt */
public class LocalMediaAdapter extends BaseMediaCategoryAdapter<LocalMedia> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocalMediaAdapter(Context context, Function2<? super LocalMedia, ? super Boolean, Boolean> function2) {
        super(context, function2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function2, "itemSelectionCallback");
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        NLocalMediaSelectionItemBinding inflate = NLocalMediaSelectionItemBinding.inflate(getLayoutInflater(), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NLocalMediaSelectionItem…\t\t\tparent,\n\t\t\t\tfalse\n\t\t\t)");
        return new LocalMediaSelectionViewHolder(this, inflate);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof LocalMediaSelectionViewHolder) {
            ((LocalMediaSelectionViewHolder) viewHolder).setItem((LocalMedia) getItemAt(i));
        }
    }

    public String getItemId(LocalMedia localMedia) {
        Intrinsics.checkNotNullParameter(localMedia, "item");
        return localMedia.getIdentifier();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo26107d2 = {"Leditor/mediaselection/localmedia/LocalMediaAdapter$LocalMediaSelectionViewHolder;", "Leditor/mediaselection/BaseMediaCategoryAdapter$BaseMediaCategoryItemViewHolder;", "Leditor/mediaselection/BaseMediaCategoryAdapter;", "Leditor/mediaselection/localmedia/LocalMedia;", "binding", "Lcom/memes/editor/databinding/NLocalMediaSelectionItemBinding;", "(Leditor/mediaselection/localmedia/LocalMediaAdapter;Lcom/memes/editor/databinding/NLocalMediaSelectionItemBinding;)V", "localMedia", "cleanup", "", "glideRequestManager", "Lcom/bumptech/glide/RequestManager;", "getItem", "onSelectionIndicatorVisibilityChanged", "isVisible", "", "setItem", "item", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: LocalMediaAdapter.kt */
    public final class LocalMediaSelectionViewHolder extends BaseMediaCategoryAdapter<LocalMedia>.BaseMediaCategoryItemViewHolder {
        private final NLocalMediaSelectionItemBinding binding;
        private LocalMedia localMedia;
        final /* synthetic */ LocalMediaAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public LocalMediaSelectionViewHolder(editor.mediaselection.localmedia.LocalMediaAdapter r3, com.memes.editor.databinding.NLocalMediaSelectionItemBinding r4) {
            /*
                r2 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                r2.this$0 = r3
                com.memes.commons.aspectratio.AspectRatioFrameLayout r0 = r4.getRoot()
                java.lang.String r1 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                android.view.View r0 = (android.view.View) r0
                r2.<init>(r3, r0)
                r2.binding = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: editor.mediaselection.localmedia.LocalMediaAdapter.LocalMediaSelectionViewHolder.<init>(editor.mediaselection.localmedia.LocalMediaAdapter, com.memes.editor.databinding.NLocalMediaSelectionItemBinding):void");
        }

        public LocalMedia getItem() {
            LocalMedia localMedia2 = this.localMedia;
            if (localMedia2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("localMedia");
            }
            return localMedia2;
        }

        public void onSelectionIndicatorVisibilityChanged(boolean z) {
            if (z) {
                View view = this.binding.selectionIndicator;
                Intrinsics.checkNotNullExpressionValue(view, "binding.selectionIndicator");
                view.setVisibility(0);
                return;
            }
            View view2 = this.binding.selectionIndicator;
            Intrinsics.checkNotNullExpressionValue(view2, "binding.selectionIndicator");
            view2.setVisibility(8);
        }

        public void setItem(LocalMedia localMedia2) {
            Intrinsics.checkNotNullParameter(localMedia2, "item");
            this.localMedia = localMedia2;
            if (localMedia2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("localMedia");
            }
            float aspectRatio = localMedia2.aspectRatio();
            this.binding.getRoot().setAspectRatio(aspectRatio);
            if (aspectRatio == 1.0f) {
                ImageView imageView = this.binding.mediaView;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.mediaView");
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                ImageView imageView2 = this.binding.mediaView;
                Intrinsics.checkNotNullExpressionValue(imageView2, "binding.mediaView");
                imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            RequestManager access$getGlideRequestManager = this.this$0.getGlideRequestManager();
            LocalMedia localMedia3 = this.localMedia;
            if (localMedia3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("localMedia");
            }
            ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) access$getGlideRequestManager.load(localMedia3.getSource()).diskCacheStrategy(DiskCacheStrategy.DATA)).skipMemoryCache(true)).placeholder(C4175R.C4178drawable.n_local_media_placeholder)).into(this.binding.mediaView);
            if (localMedia2.getMediaTye() == 3) {
                ImageView imageView3 = this.binding.videoView;
                Intrinsics.checkNotNullExpressionValue(imageView3, "binding.videoView");
                imageView3.setVisibility(0);
            } else {
                ImageView imageView4 = this.binding.videoView;
                Intrinsics.checkNotNullExpressionValue(imageView4, "binding.videoView");
                imageView4.setVisibility(8);
            }
            super.setItem(localMedia2);
        }

        public void cleanup(RequestManager requestManager) {
            Intrinsics.checkNotNullParameter(requestManager, "glideRequestManager");
            requestManager.clear((View) this.binding.mediaView);
        }
    }
}
