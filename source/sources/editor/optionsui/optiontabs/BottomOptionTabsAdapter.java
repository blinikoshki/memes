package editor.optionsui.optiontabs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.memes.editor.databinding.NBottomTabItemBinding;
import editor.core.NicoRecyclerAdapter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB0\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u0018\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0014H\u0016R#\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014XD¢\u0006\u0002\n\u0000R)\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo26107d2 = {"Leditor/optionsui/optiontabs/BottomOptionTabsAdapter;", "Leditor/core/NicoRecyclerAdapter;", "Leditor/optionsui/optiontabs/BottomOptionTab;", "context", "Landroid/content/Context;", "tabSelectionCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "optionTab", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "layoutInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "Lkotlin/Lazy;", "selectionItemIndex", "", "onBindViewHolder", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "BottomOptionTabViewHolder", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BottomOptionTabsAdapter.kt */
public final class BottomOptionTabsAdapter extends NicoRecyclerAdapter<BottomOptionTab> {
    private final Lazy layoutInflater$delegate;
    /* access modifiers changed from: private */
    public final int selectionItemIndex = -1;
    /* access modifiers changed from: private */
    public final Function1<BottomOptionTab, Unit> tabSelectionCallback;

    private final LayoutInflater getLayoutInflater() {
        return (LayoutInflater) this.layoutInflater$delegate.getValue();
    }

    public BottomOptionTabsAdapter(Context context, Function1<? super BottomOptionTab, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "tabSelectionCallback");
        this.tabSelectionCallback = function1;
        this.layoutInflater$delegate = LazyKt.lazy(new BottomOptionTabsAdapter$layoutInflater$2(context));
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        NBottomTabItemBinding inflate = NBottomTabItemBinding.inflate(getLayoutInflater(), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NBottomTabItemBinding.in…tInflater, parent, false)");
        return new BottomOptionTabViewHolder(this, inflate);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof BottomOptionTabViewHolder) {
            ((BottomOptionTabViewHolder) viewHolder).setItem((BottomOptionTab) getItemAt(i));
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Leditor/optionsui/optiontabs/BottomOptionTabsAdapter$BottomOptionTabViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/memes/editor/databinding/NBottomTabItemBinding;", "(Leditor/optionsui/optiontabs/BottomOptionTabsAdapter;Lcom/memes/editor/databinding/NBottomTabItemBinding;)V", "optionTab", "Leditor/optionsui/optiontabs/BottomOptionTab;", "setItem", "", "item", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: BottomOptionTabsAdapter.kt */
    public final class BottomOptionTabViewHolder extends RecyclerView.ViewHolder {
        private final NBottomTabItemBinding binding;
        /* access modifiers changed from: private */
        public BottomOptionTab optionTab;
        final /* synthetic */ BottomOptionTabsAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BottomOptionTabViewHolder(BottomOptionTabsAdapter bottomOptionTabsAdapter, NBottomTabItemBinding nBottomTabItemBinding) {
            super(nBottomTabItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(nBottomTabItemBinding, "binding");
            this.this$0 = bottomOptionTabsAdapter;
            this.binding = nBottomTabItemBinding;
            nBottomTabItemBinding.getRoot().setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ BottomOptionTabViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    this.this$0.this$0.tabSelectionCallback.invoke(BottomOptionTabViewHolder.access$getOptionTab$p(this.this$0));
                }
            });
        }

        public static final /* synthetic */ BottomOptionTab access$getOptionTab$p(BottomOptionTabViewHolder bottomOptionTabViewHolder) {
            BottomOptionTab bottomOptionTab = bottomOptionTabViewHolder.optionTab;
            if (bottomOptionTab == null) {
                Intrinsics.throwUninitializedPropertyAccessException("optionTab");
            }
            return bottomOptionTab;
        }

        public final void setItem(BottomOptionTab bottomOptionTab) {
            Intrinsics.checkNotNullParameter(bottomOptionTab, "item");
            this.optionTab = bottomOptionTab;
            this.binding.iconImageView.setImageResource(bottomOptionTab.getIcon());
            TextView textView = this.binding.textView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
            textView.setText(bottomOptionTab.getText());
            boolean z = getAdapterPosition() == this.this$0.selectionItemIndex;
            AppCompatImageView appCompatImageView = this.binding.iconImageView;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "binding.iconImageView");
            appCompatImageView.setSelected(z);
            TextView textView2 = this.binding.textView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.textView");
            textView2.setSelected(z);
        }
    }
}
