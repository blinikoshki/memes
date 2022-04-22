package editor.common.choicesbottomsheet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.memes.editor.databinding.NChoiceDividerItemBinding;
import com.memes.editor.databinding.NChoiceItemBinding;
import editor.core.NicoRecyclerAdapter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB0\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8DX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR)\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo26107d2 = {"Leditor/common/choicesbottomsheet/ChoicesAdapter;", "Leditor/core/NicoRecyclerAdapter;", "Leditor/common/choicesbottomsheet/Choice;", "context", "Landroid/content/Context;", "onChoiceSelected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "choice", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "layoutInflater", "Landroid/view/LayoutInflater;", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "Lkotlin/Lazy;", "getItemViewType", "", "position", "onBindViewHolder", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ChoiceDividerViewHolder", "ChoiceViewHolder", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChoicesAdapter.kt */
public class ChoicesAdapter extends NicoRecyclerAdapter<Choice> {
    /* access modifiers changed from: private */
    public final Context context;
    private final Lazy layoutInflater$delegate = LazyKt.lazy(new ChoicesAdapter$layoutInflater$2(this));
    /* access modifiers changed from: private */
    public final Function1<Choice, Unit> onChoiceSelected;

    /* access modifiers changed from: protected */
    public final LayoutInflater getLayoutInflater() {
        return (LayoutInflater) this.layoutInflater$delegate.getValue();
    }

    public ChoicesAdapter(Context context2, Function1<? super Choice, Unit> function1) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(function1, "onChoiceSelected");
        this.context = context2;
        this.onChoiceSelected = function1;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i == 12) {
            NChoiceItemBinding inflate = NChoiceItemBinding.inflate(getLayoutInflater(), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "NChoiceItemBinding.infla…tInflater, parent, false)");
            return new ChoiceViewHolder(this, inflate);
        } else if (i == 13) {
            NChoiceDividerItemBinding inflate2 = NChoiceDividerItemBinding.inflate(getLayoutInflater(), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "NChoiceDividerItemBindin…tInflater, parent, false)");
            return new ChoiceDividerViewHolder(this, inflate2);
        } else {
            throw new RuntimeException("Unknown view-type: " + i);
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof ChoiceViewHolder) {
            ((ChoiceViewHolder) viewHolder).setItem((Choice) getItemAt(i));
        }
    }

    public int getItemViewType(int i) {
        return ((Choice) getItemAt(i)).getType();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Leditor/common/choicesbottomsheet/ChoicesAdapter$ChoiceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/memes/editor/databinding/NChoiceItemBinding;", "(Leditor/common/choicesbottomsheet/ChoicesAdapter;Lcom/memes/editor/databinding/NChoiceItemBinding;)V", "choice", "Leditor/common/choicesbottomsheet/Choice;", "setItem", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChoicesAdapter.kt */
    public final class ChoiceViewHolder extends RecyclerView.ViewHolder {
        private final NChoiceItemBinding binding;
        /* access modifiers changed from: private */
        public Choice choice;
        final /* synthetic */ ChoicesAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChoiceViewHolder(ChoicesAdapter choicesAdapter, NChoiceItemBinding nChoiceItemBinding) {
            super(nChoiceItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(nChoiceItemBinding, "binding");
            this.this$0 = choicesAdapter;
            this.binding = nChoiceItemBinding;
            nChoiceItemBinding.titleView.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ ChoiceViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    this.this$0.this$0.onChoiceSelected.invoke(ChoiceViewHolder.access$getChoice$p(this.this$0));
                }
            });
        }

        public static final /* synthetic */ Choice access$getChoice$p(ChoiceViewHolder choiceViewHolder) {
            Choice choice2 = choiceViewHolder.choice;
            if (choice2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("choice");
            }
            return choice2;
        }

        public final void setItem(Choice choice2) {
            Intrinsics.checkNotNullParameter(choice2, "choice");
            this.choice = choice2;
            TextView textView = this.binding.titleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
            textView.setText(choice2.getTitle());
            TextView textView2 = this.binding.titleView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
            textView2.setSelected(!choice2.getEnabled());
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, mo26107d2 = {"Leditor/common/choicesbottomsheet/ChoicesAdapter$ChoiceDividerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/memes/editor/databinding/NChoiceDividerItemBinding;", "(Leditor/common/choicesbottomsheet/ChoicesAdapter;Lcom/memes/editor/databinding/NChoiceDividerItemBinding;)V", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChoicesAdapter.kt */
    public final class ChoiceDividerViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ ChoicesAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChoiceDividerViewHolder(ChoicesAdapter choicesAdapter, NChoiceDividerItemBinding nChoiceDividerItemBinding) {
            super(nChoiceDividerItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(nChoiceDividerItemBinding, "binding");
            this.this$0 = choicesAdapter;
        }
    }
}
