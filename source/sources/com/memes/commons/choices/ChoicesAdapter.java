package com.memes.commons.choices;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.memes.commons.choices.Choice;
import com.memes.commons.databinding.ChoiceDividerItemBinding;
import com.memes.commons.databinding.ChoiceItemBinding;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002#$B0\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\u0002\u0010\fJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0018\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0018H\u0016J\u0014\u0010!\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\"R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128DX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R)\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, mo26107d2 = {"Lcom/memes/commons/choices/ChoicesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "onChoiceSelected", "Lkotlin/Function1;", "Lcom/memes/commons/choices/Choice;", "Lkotlin/ParameterName;", "name", "choice", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "items", "", "getItems", "()Ljava/util/List;", "layoutInflater", "Landroid/view/LayoutInflater;", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "Lkotlin/Lazy;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItems", "", "ChoiceDividerViewHolder", "ChoiceViewHolder", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChoicesAdapter.kt */
public class ChoicesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    /* access modifiers changed from: private */
    public final Context context;
    private final List<Choice> items = new ArrayList();
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

    /* access modifiers changed from: protected */
    public final List<Choice> getItems() {
        return this.items;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i == 12) {
            ChoiceItemBinding inflate = ChoiceItemBinding.inflate(getLayoutInflater(), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "ChoiceItemBinding.inflat…tInflater, parent, false)");
            return new ChoiceViewHolder(this, inflate);
        } else if (i == 13) {
            ChoiceDividerItemBinding inflate2 = ChoiceDividerItemBinding.inflate(getLayoutInflater(), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "ChoiceDividerItemBinding…tInflater, parent, false)");
            return new ChoiceDividerViewHolder(this, inflate2);
        } else {
            throw new RuntimeException("Unknown view-type: " + i);
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof ChoiceViewHolder) {
            ((ChoiceViewHolder) viewHolder).setItem(this.items.get(i));
        }
    }

    public int getItemCount() {
        return this.items.size();
    }

    public int getItemViewType(int i) {
        return this.items.get(i).getType();
    }

    public final void setItems(List<Choice> list) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        this.items.clear();
        this.items.addAll(list);
        notifyDataSetChanged();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lcom/memes/commons/choices/ChoicesAdapter$ChoiceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/memes/commons/databinding/ChoiceItemBinding;", "(Lcom/memes/commons/choices/ChoicesAdapter;Lcom/memes/commons/databinding/ChoiceItemBinding;)V", "choice", "Lcom/memes/commons/choices/Choice;", "setItem", "", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChoicesAdapter.kt */
    public final class ChoiceViewHolder extends RecyclerView.ViewHolder {
        private final ChoiceItemBinding binding;
        /* access modifiers changed from: private */
        public Choice choice;
        final /* synthetic */ ChoicesAdapter this$0;

        @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Choice.HighlightType.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[Choice.HighlightType.NONE.ordinal()] = 1;
                iArr[Choice.HighlightType.PLAIN.ordinal()] = 2;
                iArr[Choice.HighlightType.PRIMARY.ordinal()] = 3;
                iArr[Choice.HighlightType.DANGER.ordinal()] = 4;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChoiceViewHolder(ChoicesAdapter choicesAdapter, ChoiceItemBinding choiceItemBinding) {
            super(choiceItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(choiceItemBinding, "binding");
            this.this$0 = choicesAdapter;
            this.binding = choiceItemBinding;
            choiceItemBinding.titleView.setOnClickListener(new View.OnClickListener(this) {
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
            int i;
            long j;
            Intrinsics.checkNotNullParameter(choice2, "choice");
            this.choice = choice2;
            TextView textView = this.binding.titleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
            textView.setText(choice2.getTitle());
            TextView textView2 = this.binding.titleView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
            textView2.setSelected(!choice2.getEnabled());
            int i2 = WhenMappings.$EnumSwitchMapping$0[choice2.getHighlightType().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    j = 4293980400L;
                } else if (i2 == 3) {
                    j = 4282219730L;
                } else if (i2 == 4) {
                    j = 4291379000L;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                i = (int) j;
            } else {
                TextView textView3 = this.binding.titleView;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.titleView");
                i = textView3.getCurrentTextColor();
            }
            this.binding.titleView.setTextColor(i);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/commons/choices/ChoicesAdapter$ChoiceDividerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/memes/commons/databinding/ChoiceDividerItemBinding;", "(Lcom/memes/commons/choices/ChoicesAdapter;Lcom/memes/commons/databinding/ChoiceDividerItemBinding;)V", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChoicesAdapter.kt */
    public final class ChoiceDividerViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ ChoicesAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChoiceDividerViewHolder(ChoicesAdapter choicesAdapter, ChoiceDividerItemBinding choiceDividerItemBinding) {
            super(choiceDividerItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(choiceDividerItemBinding, "binding");
            this.this$0 = choicesAdapter;
        }
    }
}
