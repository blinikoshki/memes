package editor.editor.entry.drafts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.memes.commons.aspectratio.AspectRatioFrameLayout;
import com.memes.commons.outlineprovider.ViewCornerOutlineProvider;
import com.memes.commons.outlineprovider.ViewCornerOutlineProviderKt;
import com.memes.editor.databinding.NEditorEntryDraftItemBinding;
import editor.core.NicoRecyclerAdapter;
import editor.editor.dashboard.drafts.EditorDraft;
import editor.util.ExtKt;
import java.io.File;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002$%B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u000e\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R#\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0013\u0010\u0014¨\u0006&"}, mo26107d2 = {"Leditor/editor/entry/drafts/EditorDraftEntriesAdapter;", "Leditor/core/NicoRecyclerAdapter;", "Leditor/editor/dashboard/drafts/EditorDraft;", "context", "Landroid/content/Context;", "callback", "Leditor/editor/entry/drafts/EditorDraftEntriesAdapter$Callback;", "(Landroid/content/Context;Leditor/editor/entry/drafts/EditorDraftEntriesAdapter$Callback;)V", "cornerRadius", "", "getCornerRadius", "()F", "cornerRadius$delegate", "Lkotlin/Lazy;", "glideRequestManager", "Lcom/bumptech/glide/RequestManager;", "layoutInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "onBindViewHolder", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "removeDraftById", "draftId", "", "Callback", "EditorDraftViewHolder", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EditorDraftEntriesAdapter.kt */
public final class EditorDraftEntriesAdapter extends NicoRecyclerAdapter<EditorDraft> {
    /* access modifiers changed from: private */
    public final Callback callback;
    /* access modifiers changed from: private */
    public final Context context;
    private final Lazy cornerRadius$delegate = LazyKt.lazy(new EditorDraftEntriesAdapter$cornerRadius$2(this));
    /* access modifiers changed from: private */
    public final RequestManager glideRequestManager;
    private final Lazy layoutInflater$delegate = LazyKt.lazy(new EditorDraftEntriesAdapter$layoutInflater$2(this));

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, mo26107d2 = {"Leditor/editor/entry/drafts/EditorDraftEntriesAdapter$Callback;", "", "onDeleteEditorDraftSelected", "", "draft", "Leditor/editor/dashboard/drafts/EditorDraft;", "onEditorDraftSelected", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: EditorDraftEntriesAdapter.kt */
    public interface Callback {
        void onDeleteEditorDraftSelected(EditorDraft editorDraft);

        void onEditorDraftSelected(EditorDraft editorDraft);
    }

    /* access modifiers changed from: private */
    public final float getCornerRadius() {
        return ((Number) this.cornerRadius$delegate.getValue()).floatValue();
    }

    private final LayoutInflater getLayoutInflater() {
        return (LayoutInflater) this.layoutInflater$delegate.getValue();
    }

    public EditorDraftEntriesAdapter(Context context2, Callback callback2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.context = context2;
        this.callback = callback2;
        RequestManager with = Glide.with(context2);
        Intrinsics.checkNotNullExpressionValue(with, "Glide.with(context)");
        this.glideRequestManager = with;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        NEditorEntryDraftItemBinding inflate = NEditorEntryDraftItemBinding.inflate(getLayoutInflater(), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NEditorEntryDraftItemBin…tInflater, parent, false)");
        return new EditorDraftViewHolder(this, inflate);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof EditorDraftViewHolder) {
            ((EditorDraftViewHolder) viewHolder).setItem((EditorDraft) getItemAt(i));
        }
    }

    public final void removeDraftById(String str) {
        Intrinsics.checkNotNullParameter(str, "draftId");
        Iterator it = getItems().iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual((Object) ((EditorDraft) it.next()).getUid(), (Object) str)) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            removeItemAt(i);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u000b\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\f"}, mo26107d2 = {"Leditor/editor/entry/drafts/EditorDraftEntriesAdapter$EditorDraftViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/memes/editor/databinding/NEditorEntryDraftItemBinding;", "(Leditor/editor/entry/drafts/EditorDraftEntriesAdapter;Lcom/memes/editor/databinding/NEditorEntryDraftItemBinding;)V", "draft", "Leditor/editor/dashboard/drafts/EditorDraft;", "cleanup", "", "loadThumbnail", "setItem", "showThumbnailNotAvailable", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: EditorDraftEntriesAdapter.kt */
    private final class EditorDraftViewHolder extends RecyclerView.ViewHolder {
        private final NEditorEntryDraftItemBinding binding;
        /* access modifiers changed from: private */
        public EditorDraft draft;
        final /* synthetic */ EditorDraftEntriesAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EditorDraftViewHolder(EditorDraftEntriesAdapter editorDraftEntriesAdapter, NEditorEntryDraftItemBinding nEditorEntryDraftItemBinding) {
            super(nEditorEntryDraftItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(nEditorEntryDraftItemBinding, "binding");
            this.this$0 = editorDraftEntriesAdapter;
            this.binding = nEditorEntryDraftItemBinding;
            nEditorEntryDraftItemBinding.getRoot().setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ EditorDraftViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    this.this$0.this$0.callback.onEditorDraftSelected(EditorDraftViewHolder.access$getDraft$p(this.this$0));
                }
            });
            nEditorEntryDraftItemBinding.getRoot().setOnLongClickListener(new View.OnLongClickListener(this) {
                final /* synthetic */ EditorDraftViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final boolean onLongClick(View view) {
                    this.this$0.this$0.callback.onDeleteEditorDraftSelected(EditorDraftViewHolder.access$getDraft$p(this.this$0));
                    return true;
                }
            });
            AspectRatioFrameLayout root = nEditorEntryDraftItemBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            ViewCornerOutlineProviderKt.roundCorners$default((View) root, editorDraftEntriesAdapter.getCornerRadius(), (ViewCornerOutlineProvider.CornerType) null, 2, (Object) null);
        }

        public static final /* synthetic */ EditorDraft access$getDraft$p(EditorDraftViewHolder editorDraftViewHolder) {
            EditorDraft editorDraft = editorDraftViewHolder.draft;
            if (editorDraft == null) {
                Intrinsics.throwUninitializedPropertyAccessException("draft");
            }
            return editorDraft;
        }

        public final void setItem(EditorDraft editorDraft) {
            Intrinsics.checkNotNullParameter(editorDraft, "draft");
            this.draft = editorDraft;
            this.binding.aspectRatioFrameLayout.setAspectRatio(((float) editorDraft.getFrameWidth()) / ((float) editorDraft.getFrameHeight()));
            loadThumbnail();
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

        public final void cleanup() {
            this.this$0.glideRequestManager.clear((View) this.binding.thumbnailImageView);
        }
    }

    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof EditorDraftViewHolder) {
            ((EditorDraftViewHolder) viewHolder).cleanup();
        }
        super.onViewRecycled(viewHolder);
    }
}
