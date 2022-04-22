package editor.editor.entry.framesizes;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.memes.commons.outlineprovider.ViewCornerOutlineProvider;
import com.memes.commons.outlineprovider.ViewCornerOutlineProviderKt;
import com.memes.editor.databinding.NEditorEntryFrameSizeItemBinding;
import editor.core.NicoRecyclerAdapter;
import editor.optionsui.frame.frameresize.FrameSize;
import editor.optionsui.frame.frameresize.FrameSizeConfig;
import editor.util.DrawableUtil;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002-.B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000fH\u0016J\u0018\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u0014XD¢\u0006\u0002\n\u0000R#\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u0014XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014XD¢\u0006\u0002\n\u0000R.\u0010\u001d\u001a\"\u0012\u0004\u0012\u00020\u001f\u0012\u0006\u0012\u0004\u0018\u00010 0\u001ej\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0006\u0012\u0004\u0018\u00010 `!X\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, mo26107d2 = {"Leditor/editor/entry/framesizes/EntryFrameSizesAdapter;", "Leditor/core/NicoRecyclerAdapter;", "Leditor/optionsui/frame/frameresize/FrameSize;", "context", "Landroid/content/Context;", "callback", "Leditor/editor/entry/framesizes/EntryFrameSizesAdapter$Callback;", "(Landroid/content/Context;Leditor/editor/entry/framesizes/EntryFrameSizesAdapter$Callback;)V", "cornerRadius", "", "getCornerRadius", "()F", "cornerRadius$delegate", "Lkotlin/Lazy;", "itemWidth", "", "getItemWidth", "()I", "itemWidth$delegate", "landscapeIconAspectRatio", "", "layoutInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "portraitIconAspectRatio", "storyIconAspectRatio", "thumbnailDrawablesMap", "Ljava/util/HashMap;", "", "Landroid/graphics/drawable/Drawable;", "Lkotlin/collections/HashMap;", "getHeightForIcon", "frameSize", "onBindViewHolder", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callback", "FrameSizeEntryViewHolder", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EntryFrameSizesAdapter.kt */
public final class EntryFrameSizesAdapter extends NicoRecyclerAdapter<FrameSize> {
    /* access modifiers changed from: private */
    public final Callback callback;
    /* access modifiers changed from: private */
    public final Context context;
    private final Lazy cornerRadius$delegate = LazyKt.lazy(new EntryFrameSizesAdapter$cornerRadius$2(this));
    private final Lazy itemWidth$delegate = LazyKt.lazy(new EntryFrameSizesAdapter$itemWidth$2(this));
    private final double landscapeIconAspectRatio = 1.689655172413793d;
    private final Lazy layoutInflater$delegate = LazyKt.lazy(new EntryFrameSizesAdapter$layoutInflater$2(this));
    private final double portraitIconAspectRatio = 0.723880597014925d;
    private final double storyIconAspectRatio = 0.678321678321678d;
    /* access modifiers changed from: private */
    public final HashMap<String, Drawable> thumbnailDrawablesMap = new HashMap<>();

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo26107d2 = {"Leditor/editor/entry/framesizes/EntryFrameSizesAdapter$Callback;", "", "onFrameSizeSelected", "", "entry", "Leditor/optionsui/frame/frameresize/FrameSize;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: EntryFrameSizesAdapter.kt */
    public interface Callback {
        void onFrameSizeSelected(FrameSize frameSize);
    }

    /* access modifiers changed from: private */
    public final float getCornerRadius() {
        return ((Number) this.cornerRadius$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public final int getItemWidth() {
        return ((Number) this.itemWidth$delegate.getValue()).intValue();
    }

    private final LayoutInflater getLayoutInflater() {
        return (LayoutInflater) this.layoutInflater$delegate.getValue();
    }

    public EntryFrameSizesAdapter(Context context2, Callback callback2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.context = context2;
        this.callback = callback2;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        NEditorEntryFrameSizeItemBinding inflate = NEditorEntryFrameSizeItemBinding.inflate(getLayoutInflater(), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NEditorEntryFrameSizeIte…tInflater, parent, false)");
        return new FrameSizeEntryViewHolder(this, inflate);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof FrameSizeEntryViewHolder) {
            ((FrameSizeEntryViewHolder) viewHolder).setItem((FrameSize) getItemAt(i));
        }
    }

    /* access modifiers changed from: private */
    public final int getHeightForIcon(FrameSize frameSize, int i) {
        if (frameSize.isSquare()) {
            return i;
        }
        if (frameSize.isPortrait()) {
            return MathKt.roundToInt(((double) i) / this.portraitIconAspectRatio);
        }
        return frameSize.isLandscape() ? MathKt.roundToInt(((double) i) / this.landscapeIconAspectRatio) : i;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Leditor/editor/entry/framesizes/EntryFrameSizesAdapter$FrameSizeEntryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/memes/editor/databinding/NEditorEntryFrameSizeItemBinding;", "(Leditor/editor/entry/framesizes/EntryFrameSizesAdapter;Lcom/memes/editor/databinding/NEditorEntryFrameSizeItemBinding;)V", "frameSize", "Leditor/optionsui/frame/frameresize/FrameSize;", "loadThumbnail", "", "setItem", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: EntryFrameSizesAdapter.kt */
    private final class FrameSizeEntryViewHolder extends RecyclerView.ViewHolder {
        private final NEditorEntryFrameSizeItemBinding binding;
        /* access modifiers changed from: private */
        public FrameSize frameSize;
        final /* synthetic */ EntryFrameSizesAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FrameSizeEntryViewHolder(EntryFrameSizesAdapter entryFrameSizesAdapter, NEditorEntryFrameSizeItemBinding nEditorEntryFrameSizeItemBinding) {
            super(nEditorEntryFrameSizeItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(nEditorEntryFrameSizeItemBinding, "binding");
            this.this$0 = entryFrameSizesAdapter;
            this.binding = nEditorEntryFrameSizeItemBinding;
            nEditorEntryFrameSizeItemBinding.getRoot().setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ FrameSizeEntryViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    this.this$0.this$0.callback.onFrameSizeSelected(FrameSizeEntryViewHolder.access$getFrameSize$p(this.this$0));
                }
            });
            ImageView imageView = nEditorEntryFrameSizeItemBinding.imageView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.imageView");
            ViewCornerOutlineProviderKt.roundCorners$default((View) imageView, entryFrameSizesAdapter.getCornerRadius(), (ViewCornerOutlineProvider.CornerType) null, 2, (Object) null);
        }

        public static final /* synthetic */ FrameSize access$getFrameSize$p(FrameSizeEntryViewHolder frameSizeEntryViewHolder) {
            FrameSize frameSize2 = frameSizeEntryViewHolder.frameSize;
            if (frameSize2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("frameSize");
            }
            return frameSize2;
        }

        public final void setItem(FrameSize frameSize2) {
            Intrinsics.checkNotNullParameter(frameSize2, "frameSize");
            this.frameSize = frameSize2;
            TextView textView = this.binding.titleTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleTextView");
            textView.setText(frameSize2.getTitle());
            TextView textView2 = this.binding.subtitleTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.subtitleTextView");
            textView2.setText(frameSize2.subtitle());
            loadThumbnail();
            EntryFrameSizesAdapter entryFrameSizesAdapter = this.this$0;
            this.binding.aspectRatioLayout.setAspectRatio(((float) this.this$0.getItemWidth()) / ((float) entryFrameSizesAdapter.getHeightForIcon(frameSize2, entryFrameSizesAdapter.getItemWidth())));
        }

        private final void loadThumbnail() {
            Drawable drawable;
            FrameSize frameSize2 = this.frameSize;
            if (frameSize2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("frameSize");
            }
            String thumbName = frameSize2.getThumbName();
            CharSequence charSequence = thumbName;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                this.binding.imageView.setImageDrawable((Drawable) null);
            } else if (!this.this$0.thumbnailDrawablesMap.containsKey(thumbName) || (drawable = (Drawable) this.this$0.thumbnailDrawablesMap.get(thumbName)) == null) {
                Drawable createDrawable = DrawableUtil.INSTANCE.createDrawable(this.this$0.context, thumbName, FrameSizeConfig.INSTANCE.filePath(thumbName));
                this.this$0.thumbnailDrawablesMap.put(thumbName, createDrawable);
                this.binding.imageView.setImageDrawable(createDrawable);
            } else {
                this.binding.imageView.setImageDrawable(drawable);
            }
        }
    }
}
