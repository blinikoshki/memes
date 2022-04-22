package editor.optionsui.watermark.savedwatermarks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.memes.editor.databinding.NSavedWatermarkItemBinding;
import editor.core.NicoRecyclerAdapter;
import editor.optionsui.watermark.Watermark;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R#\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo26107d2 = {"Leditor/optionsui/watermark/savedwatermarks/SavedWatermarksAdapter;", "Leditor/core/NicoRecyclerAdapter;", "Leditor/optionsui/watermark/Watermark;", "context", "Landroid/content/Context;", "listener", "Leditor/optionsui/watermark/savedwatermarks/SavedWatermarksAdapterListener;", "(Landroid/content/Context;Leditor/optionsui/watermark/savedwatermarks/SavedWatermarksAdapterListener;)V", "layoutInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "Lkotlin/Lazy;", "onBindViewHolder", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "SavedWatermarkViewHolder", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: SavedWatermarksAdapter.kt */
public final class SavedWatermarksAdapter extends NicoRecyclerAdapter<Watermark> {
    /* access modifiers changed from: private */
    public final Context context;
    private final Lazy layoutInflater$delegate = LazyKt.lazy(new SavedWatermarksAdapter$layoutInflater$2(this));
    /* access modifiers changed from: private */
    public final SavedWatermarksAdapterListener listener;

    private final LayoutInflater getLayoutInflater() {
        return (LayoutInflater) this.layoutInflater$delegate.getValue();
    }

    public SavedWatermarksAdapter(Context context2, SavedWatermarksAdapterListener savedWatermarksAdapterListener) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(savedWatermarksAdapterListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.context = context2;
        this.listener = savedWatermarksAdapterListener;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        NSavedWatermarkItemBinding inflate = NSavedWatermarkItemBinding.inflate(getLayoutInflater(), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NSavedWatermarkItemBindi…tInflater, parent, false)");
        return new SavedWatermarkViewHolder(this, inflate);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof SavedWatermarkViewHolder) {
            ((SavedWatermarkViewHolder) viewHolder).setItem((Watermark) getItemAt(i));
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\b\u0010\n\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Leditor/optionsui/watermark/savedwatermarks/SavedWatermarksAdapter$SavedWatermarkViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/memes/editor/databinding/NSavedWatermarkItemBinding;", "(Leditor/optionsui/watermark/savedwatermarks/SavedWatermarksAdapter;Lcom/memes/editor/databinding/NSavedWatermarkItemBinding;)V", "savedWatermark", "Leditor/optionsui/watermark/Watermark;", "setItem", "", "watermark", "showThumbnail", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: SavedWatermarksAdapter.kt */
    public final class SavedWatermarkViewHolder extends RecyclerView.ViewHolder {
        private final NSavedWatermarkItemBinding binding;
        /* access modifiers changed from: private */
        public Watermark savedWatermark;
        final /* synthetic */ SavedWatermarksAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedWatermarkViewHolder(SavedWatermarksAdapter savedWatermarksAdapter, NSavedWatermarkItemBinding nSavedWatermarkItemBinding) {
            super(nSavedWatermarkItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(nSavedWatermarkItemBinding, "binding");
            this.this$0 = savedWatermarksAdapter;
            this.binding = nSavedWatermarkItemBinding;
            nSavedWatermarkItemBinding.thumbnailImageView.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ SavedWatermarkViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    this.this$0.this$0.listener.onSavedWatermarkTapped(SavedWatermarkViewHolder.access$getSavedWatermark$p(this.this$0));
                }
            });
            nSavedWatermarkItemBinding.deleteWatermarkView.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ SavedWatermarkViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    this.this$0.this$0.listener.onSavedWatermarkDeleteRequested(SavedWatermarkViewHolder.access$getSavedWatermark$p(this.this$0));
                }
            });
        }

        public static final /* synthetic */ Watermark access$getSavedWatermark$p(SavedWatermarkViewHolder savedWatermarkViewHolder) {
            Watermark watermark = savedWatermarkViewHolder.savedWatermark;
            if (watermark == null) {
                Intrinsics.throwUninitializedPropertyAccessException("savedWatermark");
            }
            return watermark;
        }

        public final void setItem(Watermark watermark) {
            Intrinsics.checkNotNullParameter(watermark, "watermark");
            this.savedWatermark = watermark;
            showThumbnail();
        }

        private final void showThumbnail() {
            Watermark watermark = this.savedWatermark;
            if (watermark == null) {
                Intrinsics.throwUninitializedPropertyAccessException("savedWatermark");
            }
            String thumbnailPath = watermark.getThumbnailPath();
            CharSequence charSequence = thumbnailPath;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                this.binding.thumbnailImageView.setImageResource(0);
                return;
            }
            File file = new File(thumbnailPath);
            if (!file.exists()) {
                this.binding.thumbnailImageView.setImageResource(0);
            } else {
                ((RequestBuilder) ((RequestBuilder) Glide.with(this.this$0.context).load(file).diskCacheStrategy(DiskCacheStrategy.NONE)).skipMemoryCache(true)).into(this.binding.thumbnailImageView);
            }
        }
    }
}
