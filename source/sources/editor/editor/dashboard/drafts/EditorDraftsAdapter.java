package editor.editor.dashboard.drafts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.memes.editor.databinding.NDraftItemBinding;
import editor.core.NicoRecyclerAdapter;
import editor.util.ExtKt;
import java.io.File;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB0\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R)\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006X\u0004¢\u0006\u0002\n\u0000R#\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, mo26107d2 = {"Leditor/editor/dashboard/drafts/EditorDraftsAdapter;", "Leditor/core/NicoRecyclerAdapter;", "Leditor/editor/dashboard/drafts/EditorDraft;", "context", "Landroid/content/Context;", "draftViewer", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "draft", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "inflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getInflater", "()Landroid/view/LayoutInflater;", "inflater$delegate", "Lkotlin/Lazy;", "onBindViewHolder", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DraftViewHolder", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
@Deprecated(message = "unused")
/* compiled from: EditorDraftsAdapter.kt */
public final class EditorDraftsAdapter extends NicoRecyclerAdapter<EditorDraft> {
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public final Function1<EditorDraft, Unit> draftViewer;
    private final Lazy inflater$delegate = LazyKt.lazy(new EditorDraftsAdapter$inflater$2(this));

    private final LayoutInflater getInflater() {
        return (LayoutInflater) this.inflater$delegate.getValue();
    }

    public EditorDraftsAdapter(Context context2, Function1<? super EditorDraft, Unit> function1) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(function1, "draftViewer");
        this.context = context2;
        this.draftViewer = function1;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        NDraftItemBinding inflate = NDraftItemBinding.inflate(getInflater(), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NDraftItemBinding.inflate(inflater, parent, false)");
        return new DraftViewHolder(this, inflate);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof DraftViewHolder) {
            ((DraftViewHolder) viewHolder).setItem((EditorDraft) getItemAt(i));
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\n\u001a\u00020\bH\u0002J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Leditor/editor/dashboard/drafts/EditorDraftsAdapter$DraftViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/memes/editor/databinding/NDraftItemBinding;", "(Leditor/editor/dashboard/drafts/EditorDraftsAdapter;Lcom/memes/editor/databinding/NDraftItemBinding;)V", "draft", "Leditor/editor/dashboard/drafts/EditorDraft;", "loadThumbnail", "", "setItem", "showThumbnailNotAvailable", "updateItemSize", "width", "", "height", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: EditorDraftsAdapter.kt */
    public final class DraftViewHolder extends RecyclerView.ViewHolder {
        private final NDraftItemBinding binding;
        /* access modifiers changed from: private */
        public EditorDraft draft;
        final /* synthetic */ EditorDraftsAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DraftViewHolder(EditorDraftsAdapter editorDraftsAdapter, NDraftItemBinding nDraftItemBinding) {
            super(nDraftItemBinding.root);
            Intrinsics.checkNotNullParameter(nDraftItemBinding, "binding");
            this.this$0 = editorDraftsAdapter;
            this.binding = nDraftItemBinding;
            nDraftItemBinding.root.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ DraftViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    this.this$0.this$0.draftViewer.invoke(DraftViewHolder.access$getDraft$p(this.this$0));
                }
            });
        }

        public static final /* synthetic */ EditorDraft access$getDraft$p(DraftViewHolder draftViewHolder) {
            EditorDraft editorDraft = draftViewHolder.draft;
            if (editorDraft == null) {
                Intrinsics.throwUninitializedPropertyAccessException("draft");
            }
            return editorDraft;
        }

        public final void setItem(EditorDraft editorDraft) {
            Intrinsics.checkNotNullParameter(editorDraft, "draft");
            this.draft = editorDraft;
            updateItemSize(editorDraft.getFrameWidth(), editorDraft.getFrameHeight());
            loadThumbnail();
        }

        private final void updateItemSize(int i, int i2) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this.binding.root);
            ImageView imageView = this.binding.thumbnailImageView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.thumbnailImageView");
            int id = imageView.getId();
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append(':');
            sb.append(i2);
            constraintSet.setDimensionRatio(id, sb.toString());
            constraintSet.applyTo(this.binding.root);
        }

        private final void loadThumbnail() {
            EditorDraft editorDraft = this.draft;
            if (editorDraft == null) {
                Intrinsics.throwUninitializedPropertyAccessException("draft");
            }
            String thumbnailPath = editorDraft.getThumbnailPath();
            CharSequence charSequence = thumbnailPath;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                showThumbnailNotAvailable();
                return;
            }
            File file = new File(thumbnailPath);
            if (!file.exists()) {
                showThumbnailNotAvailable();
            } else {
                Glide.with(this.this$0.context).load(file).into(this.binding.thumbnailImageView);
            }
        }

        private final void showThumbnailNotAvailable() {
            this.binding.thumbnailImageView.setImageResource(0);
            this.binding.thumbnailImageView.setBackgroundColor(ExtKt.nextRgb$default(Random.Default, 0, 1, (Object) null));
        }
    }
}
