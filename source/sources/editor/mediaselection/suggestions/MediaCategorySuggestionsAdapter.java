package editor.mediaselection.suggestions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.memes.editor.databinding.NMediaCategorySuggestionItemBinding;
import editor.core.NicoRecyclerAdapter;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B0\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fR)\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006X\u0004¢\u0006\u0002\n\u0000R#\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006!"}, mo26107d2 = {"Leditor/mediaselection/suggestions/MediaCategorySuggestionsAdapter;", "Leditor/core/NicoRecyclerAdapter;", "Leditor/mediaselection/suggestions/MediaCategorySuggestion;", "context", "Landroid/content/Context;", "itemSelectionCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "suggestion", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "layoutInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "Lkotlin/Lazy;", "onBindViewHolder", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelectedSuggestionText", "", "suggestionText", "", "MediaCategorySuggestionViewHolder", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaCategorySuggestionsAdapter.kt */
public final class MediaCategorySuggestionsAdapter extends NicoRecyclerAdapter<MediaCategorySuggestion> {
    /* access modifiers changed from: private */
    public final Function1<MediaCategorySuggestion, Unit> itemSelectionCallback;
    private final Lazy layoutInflater$delegate;

    private final LayoutInflater getLayoutInflater() {
        return (LayoutInflater) this.layoutInflater$delegate.getValue();
    }

    public MediaCategorySuggestionsAdapter(Context context, Function1<? super MediaCategorySuggestion, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "itemSelectionCallback");
        this.itemSelectionCallback = function1;
        this.layoutInflater$delegate = LazyKt.lazy(new MediaCategorySuggestionsAdapter$layoutInflater$2(context));
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        NMediaCategorySuggestionItemBinding inflate = NMediaCategorySuggestionItemBinding.inflate(getLayoutInflater(), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NMediaCategorySuggestion…,\n\t\t\tparent,\n\t\t\tfalse\n\t\t)");
        return new MediaCategorySuggestionViewHolder(this, inflate);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof MediaCategorySuggestionViewHolder) {
            ((MediaCategorySuggestionViewHolder) viewHolder).setItem((MediaCategorySuggestion) getItemAt(i));
        }
    }

    public final boolean setSelectedSuggestionText(String str) {
        String str2;
        boolean z = false;
        int i = 0;
        for (MediaCategorySuggestion mediaCategorySuggestion : getItems()) {
            boolean selected = mediaCategorySuggestion.getSelected();
            String title = mediaCategorySuggestion.getTitle();
            if (str != null) {
                Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
                str2 = StringsKt.trim((CharSequence) str).toString();
            } else {
                str2 = null;
            }
            mediaCategorySuggestion.setSelected(Intrinsics.areEqual((Object) title, (Object) str2));
            if (selected != mediaCategorySuggestion.getSelected()) {
                notifyItemChanged(i);
            }
            if (mediaCategorySuggestion.getSelected()) {
                z = true;
            }
            i++;
        }
        return z;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Leditor/mediaselection/suggestions/MediaCategorySuggestionsAdapter$MediaCategorySuggestionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/memes/editor/databinding/NMediaCategorySuggestionItemBinding;", "(Leditor/mediaselection/suggestions/MediaCategorySuggestionsAdapter;Lcom/memes/editor/databinding/NMediaCategorySuggestionItemBinding;)V", "suggestion", "Leditor/mediaselection/suggestions/MediaCategorySuggestion;", "setItem", "", "item", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MediaCategorySuggestionsAdapter.kt */
    private final class MediaCategorySuggestionViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final NMediaCategorySuggestionItemBinding binding;
        /* access modifiers changed from: private */
        public MediaCategorySuggestion suggestion;
        final /* synthetic */ MediaCategorySuggestionsAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MediaCategorySuggestionViewHolder(MediaCategorySuggestionsAdapter mediaCategorySuggestionsAdapter, NMediaCategorySuggestionItemBinding nMediaCategorySuggestionItemBinding) {
            super(nMediaCategorySuggestionItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(nMediaCategorySuggestionItemBinding, "binding");
            this.this$0 = mediaCategorySuggestionsAdapter;
            this.binding = nMediaCategorySuggestionItemBinding;
            nMediaCategorySuggestionItemBinding.getRoot().setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ MediaCategorySuggestionViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    if (!MediaCategorySuggestionViewHolder.access$getSuggestion$p(this.this$0).getSelected()) {
                        int i = 0;
                        for (Object next : this.this$0.this$0.getItems()) {
                            int i2 = i + 1;
                            if (i < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            MediaCategorySuggestion mediaCategorySuggestion = (MediaCategorySuggestion) next;
                            if (mediaCategorySuggestion.getSelected()) {
                                mediaCategorySuggestion.setSelected(false);
                                this.this$0.this$0.notifyItemChanged(i);
                            }
                            i = i2;
                        }
                        MediaCategorySuggestionViewHolder.access$getSuggestion$p(this.this$0).setSelected(true);
                        LinearLayout root = this.this$0.binding.getRoot();
                        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                        root.setSelected(MediaCategorySuggestionViewHolder.access$getSuggestion$p(this.this$0).getSelected());
                        this.this$0.this$0.itemSelectionCallback.invoke(MediaCategorySuggestionViewHolder.access$getSuggestion$p(this.this$0));
                        MediaCategorySuggestionsAdapter mediaCategorySuggestionsAdapter = this.this$0.this$0;
                        View view2 = this.this$0.itemView;
                        Intrinsics.checkNotNullExpressionValue(view2, "itemView");
                        mediaCategorySuggestionsAdapter.scrollToCenterHorizontally(view2);
                    }
                }
            });
        }

        public static final /* synthetic */ MediaCategorySuggestion access$getSuggestion$p(MediaCategorySuggestionViewHolder mediaCategorySuggestionViewHolder) {
            MediaCategorySuggestion mediaCategorySuggestion = mediaCategorySuggestionViewHolder.suggestion;
            if (mediaCategorySuggestion == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suggestion");
            }
            return mediaCategorySuggestion;
        }

        public final void setItem(MediaCategorySuggestion mediaCategorySuggestion) {
            Intrinsics.checkNotNullParameter(mediaCategorySuggestion, "item");
            this.suggestion = mediaCategorySuggestion;
            ImageView imageView = this.binding.iconView;
            MediaCategorySuggestion mediaCategorySuggestion2 = this.suggestion;
            if (mediaCategorySuggestion2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suggestion");
            }
            imageView.setImageResource(mediaCategorySuggestion2.getIcon());
            TextView textView = this.binding.textView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
            MediaCategorySuggestion mediaCategorySuggestion3 = this.suggestion;
            if (mediaCategorySuggestion3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suggestion");
            }
            textView.setText(mediaCategorySuggestion3.getTitle());
            LinearLayout root = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            MediaCategorySuggestion mediaCategorySuggestion4 = this.suggestion;
            if (mediaCategorySuggestion4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suggestion");
            }
            root.setSelected(mediaCategorySuggestion4.getSelected());
        }
    }
}
