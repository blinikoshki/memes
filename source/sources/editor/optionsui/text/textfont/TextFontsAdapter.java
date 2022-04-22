package editor.optionsui.text.textfont;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.memes.commons.util.ExtensionsKt;
import com.memes.editor.databinding.NTextFontDividerItemBinding;
import com.memes.editor.databinding.NTextFontPlaceholderItemBinding;
import com.memes.editor.databinding.NTextFontPreviewItemBinding;
import editor.core.NicoRecyclerAdapter;
import editor.optionsui.text.textfont.FontItem;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\n\b\u0010\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004*+,-B0\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\u0002\u0010\fJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0018H\u0016J!\u0010\"\u001a\u00020\u000b2\u0012\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160$\"\u00020\u0016H\u0002¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000eJ\u000e\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108DX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R)\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006."}, mo26107d2 = {"Leditor/optionsui/text/textfont/TextFontsAdapter;", "Leditor/core/NicoRecyclerAdapter;", "Leditor/optionsui/text/textfont/FontItem;", "context", "Landroid/content/Context;", "onFontSelected", "Lkotlin/Function1;", "Leditor/optionsui/text/textfont/TextFont;", "Lkotlin/ParameterName;", "name", "font", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "hasPremiumPlan", "", "layoutInflater", "Landroid/view/LayoutInflater;", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "Lkotlin/Lazy;", "selectedFontId", "", "getItemViewType", "", "position", "getSpanSizeForPosition", "onBindViewHolder", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "refreshFontsById", "fontIds", "", "([Ljava/lang/String;)V", "setHasPremiumPlan", "enabled", "setSelectedFontId", "id", "Companion", "FontDividerViewHolder", "FontPlaceholderViewHolder", "FontPreviewViewHolder", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextFontsAdapter.kt */
public class TextFontsAdapter extends NicoRecyclerAdapter<FontItem> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int TYPE_DIVIDER = 518;
    private static final int TYPE_PLACEHOLDER = 517;
    private static final int TYPE_PREVIEW = 516;
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public boolean hasPremiumPlan;
    private final Lazy layoutInflater$delegate = LazyKt.lazy(new TextFontsAdapter$layoutInflater$2(this));
    /* access modifiers changed from: private */
    public final Function1<TextFont, Unit> onFontSelected;
    /* access modifiers changed from: private */
    public String selectedFontId = "na";

    /* access modifiers changed from: protected */
    public final LayoutInflater getLayoutInflater() {
        return (LayoutInflater) this.layoutInflater$delegate.getValue();
    }

    public TextFontsAdapter(Context context2, Function1<? super TextFont, Unit> function1) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(function1, "onFontSelected");
        this.context = context2;
        this.onFontSelected = function1;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo26107d2 = {"Leditor/optionsui/text/textfont/TextFontsAdapter$Companion;", "", "()V", "TYPE_DIVIDER", "", "TYPE_PLACEHOLDER", "TYPE_PREVIEW", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: TextFontsAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        switch (i) {
            case TYPE_PREVIEW /*516*/:
                NTextFontPreviewItemBinding inflate = NTextFontPreviewItemBinding.inflate(getLayoutInflater(), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "NTextFontPreviewItemBind…tInflater, parent, false)");
                return new FontPreviewViewHolder(this, inflate);
            case TYPE_PLACEHOLDER /*517*/:
                NTextFontPlaceholderItemBinding inflate2 = NTextFontPlaceholderItemBinding.inflate(getLayoutInflater(), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate2, "NTextFontPlaceholderItem…tInflater, parent, false)");
                return new FontPlaceholderViewHolder(this, inflate2);
            case TYPE_DIVIDER /*518*/:
                NTextFontDividerItemBinding inflate3 = NTextFontDividerItemBinding.inflate(getLayoutInflater(), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate3, "NTextFontDividerItemBind…tInflater, parent, false)");
                return new FontDividerViewHolder(this, inflate3);
            default:
                throw new RuntimeException("Unknown view-type: " + i);
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof FontPreviewViewHolder) {
            Object itemAt = getItemAt(i);
            Objects.requireNonNull(itemAt, "null cannot be cast to non-null type editor.optionsui.text.textfont.FontItem.Preview");
            ((FontPreviewViewHolder) viewHolder).setItem(((FontItem.Preview) itemAt).getTextFont());
        }
    }

    public int getItemViewType(int i) {
        FontItem fontItem = (FontItem) getItemAt(i);
        if (fontItem instanceof FontItem.Preview) {
            return TYPE_PREVIEW;
        }
        if (fontItem instanceof FontItem.Placeholder) {
            return TYPE_PLACEHOLDER;
        }
        if (fontItem instanceof FontItem.Divider) {
            return TYPE_DIVIDER;
        }
        throw new NoWhenBranchMatchedException();
    }

    public int getSpanSizeForPosition(int i) {
        return ((FontItem) getItemAt(i)) instanceof FontItem.Divider ? 2 : 1;
    }

    public final void setSelectedFontId(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        String str2 = this.selectedFontId;
        this.selectedFontId = str;
        if (Intrinsics.areEqual((Object) str2, (Object) str)) {
            refreshFontsById(this.selectedFontId);
            return;
        }
        refreshFontsById(str2, this.selectedFontId);
    }

    private final void refreshFontsById(String... strArr) {
        int itemCount = getItemCount();
        for (int i = 0; i < itemCount; i++) {
            FontItem fontItem = (FontItem) getItemAt(i);
            if ((fontItem instanceof FontItem.Preview) && ArraysKt.contains((T[]) strArr, ((FontItem.Preview) fontItem).getTextFont().getId())) {
                notifyItemChanged(i);
            }
        }
    }

    public final void setHasPremiumPlan(boolean z) {
        if (this.hasPremiumPlan != z) {
            this.hasPremiumPlan = z;
            notifyDataSetChanged();
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\t\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Leditor/optionsui/text/textfont/TextFontsAdapter$FontPreviewViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/memes/editor/databinding/NTextFontPreviewItemBinding;", "(Leditor/optionsui/text/textfont/TextFontsAdapter;Lcom/memes/editor/databinding/NTextFontPreviewItemBinding;)V", "font", "Leditor/optionsui/text/textfont/TextFont;", "setItem", "", "showPremiumFontIndicator", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: TextFontsAdapter.kt */
    public final class FontPreviewViewHolder extends RecyclerView.ViewHolder {
        private final NTextFontPreviewItemBinding binding;
        /* access modifiers changed from: private */
        public TextFont font;
        final /* synthetic */ TextFontsAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FontPreviewViewHolder(TextFontsAdapter textFontsAdapter, NTextFontPreviewItemBinding nTextFontPreviewItemBinding) {
            super(nTextFontPreviewItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(nTextFontPreviewItemBinding, "binding");
            this.this$0 = textFontsAdapter;
            this.binding = nTextFontPreviewItemBinding;
            nTextFontPreviewItemBinding.getRoot().setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ FontPreviewViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    this.this$0.this$0.onFontSelected.invoke(FontPreviewViewHolder.access$getFont$p(this.this$0));
                }
            });
            nTextFontPreviewItemBinding.getRoot().setOnLongClickListener(new View.OnLongClickListener(this) {
                final /* synthetic */ FontPreviewViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final boolean onLongClick(View view) {
                    ExtensionsKt.toast(this.this$0.this$0.context, FontPreviewViewHolder.access$getFont$p(this.this$0).getDisplayName());
                    return true;
                }
            });
        }

        public static final /* synthetic */ TextFont access$getFont$p(FontPreviewViewHolder fontPreviewViewHolder) {
            TextFont textFont = fontPreviewViewHolder.font;
            if (textFont == null) {
                Intrinsics.throwUninitializedPropertyAccessException("font");
            }
            return textFont;
        }

        public final void setItem(TextFont textFont) {
            Intrinsics.checkNotNullParameter(textFont, "font");
            this.font = textFont;
            TextView textView = this.binding.fontPreviewTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.fontPreviewTextView");
            textView.setTypeface(textFont.toTypeface(this.this$0.context));
            boolean areEqual = Intrinsics.areEqual((Object) textFont.getId(), (Object) this.this$0.selectedFontId);
            TextView textView2 = this.binding.fontPreviewTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.fontPreviewTextView");
            textView2.setSelected(areEqual);
            showPremiumFontIndicator();
        }

        private final void showPremiumFontIndicator() {
            int i;
            View view = this.binding.premiumFontIndicatorView;
            Intrinsics.checkNotNullExpressionValue(view, "binding.premiumFontIndicatorView");
            if (!this.this$0.hasPremiumPlan) {
                TextFont textFont = this.font;
                if (textFont == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("font");
                }
                if (textFont.isPremiumFont()) {
                    i = 0;
                    view.setVisibility(i);
                }
            }
            i = 8;
            view.setVisibility(i);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, mo26107d2 = {"Leditor/optionsui/text/textfont/TextFontsAdapter$FontPlaceholderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/memes/editor/databinding/NTextFontPlaceholderItemBinding;", "(Leditor/optionsui/text/textfont/TextFontsAdapter;Lcom/memes/editor/databinding/NTextFontPlaceholderItemBinding;)V", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: TextFontsAdapter.kt */
    public final class FontPlaceholderViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ TextFontsAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FontPlaceholderViewHolder(TextFontsAdapter textFontsAdapter, NTextFontPlaceholderItemBinding nTextFontPlaceholderItemBinding) {
            super(nTextFontPlaceholderItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(nTextFontPlaceholderItemBinding, "binding");
            this.this$0 = textFontsAdapter;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, mo26107d2 = {"Leditor/optionsui/text/textfont/TextFontsAdapter$FontDividerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/memes/editor/databinding/NTextFontDividerItemBinding;", "(Leditor/optionsui/text/textfont/TextFontsAdapter;Lcom/memes/editor/databinding/NTextFontDividerItemBinding;)V", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: TextFontsAdapter.kt */
    public final class FontDividerViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ TextFontsAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FontDividerViewHolder(TextFontsAdapter textFontsAdapter, NTextFontDividerItemBinding nTextFontDividerItemBinding) {
            super(nTextFontDividerItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(nTextFontDividerItemBinding, "binding");
            this.this$0 = textFontsAdapter;
        }
    }
}
