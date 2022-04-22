package editor.custom.mediacategoryview;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.tabs.TabLayout;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NMediaSelectionCategoryBinding;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\u001fJ\b\u0010#\u001a\u00020\u001fH\u0014J\u0012\u0010$\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010'\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010(\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010)\u001a\u00020\u001f2\b\b\u0001\u0010*\u001a\u00020\u000fJ\u0010\u0010)\u001a\u00020\u001f2\b\u0010+\u001a\u0004\u0018\u00010\u0011J\u0012\u0010,\u001a\u00020\u001f2\n\u0010-\u001a\u0006\u0012\u0002\b\u00030.J\u0014\u0010/\u001a\u00020\u001f2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001f01J\u000e\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u000204J7\u00105\u001a\u00020\u001f2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u0011072!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f0\u001bJ\u0010\u00108\u001a\u00020\u001f2\b\u00109\u001a\u0004\u0018\u00010\u0011J\b\u0010:\u001a\u00020\u001fH\u0002J\b\u0010;\u001a\u00020\u001fH\u0002J\u0006\u0010<\u001a\u00020\u001fJ\u0006\u0010=\u001a\u00020\u001fJ\u0010\u0010>\u001a\u00020\u001f2\b\b\u0002\u0010?\u001a\u00020\u0011J\u001e\u0010@\u001a\u00020\u001f2\b\b\u0002\u0010?\u001a\u00020\u00112\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001f01J\u0010\u0010B\u001a\u00020\u001f2\b\b\u0002\u0010?\u001a\u00020\u0011R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u0017\u0010\u0018R+\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, mo26107d2 = {"Leditor/custom/mediacategoryview/MediaCategoryView;", "Landroid/widget/FrameLayout;", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/memes/editor/databinding/NMediaSelectionCategoryBinding;", "getBinding", "()Lcom/memes/editor/databinding/NMediaSelectionCategoryBinding;", "binding$delegate", "Lkotlin/Lazy;", "contentHeight", "", "defaultContentNotAvailableMessage", "", "defaultErrorMessage", "defaultProgressMessage", "layoutInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "tabSelectionListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "tabTitle", "", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "hide", "onFinishInflate", "onTabReselected", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabSelected", "onTabUnselected", "setActionButtonText", "textRes", "text", "setAdapter", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setOnActionButtonClickListener", "listener", "Lkotlin/Function0;", "setShouldShowActionButton", "isVisible", "", "setTabs", "tabTitles", "", "setTitle", "title", "setupRecyclerView", "setupTabLayout", "show", "showContent", "showContentNotAvailable", "message", "showError", "retryListener", "showProgress", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaCategoryView.kt */
public final class MediaCategoryView extends FrameLayout implements TabLayout.OnTabSelectedListener {
    private final Lazy binding$delegate = LazyKt.lazy(new MediaCategoryView$binding$2(this));
    /* access modifiers changed from: private */
    public int contentHeight;
    private String defaultContentNotAvailableMessage = "Content not available.";
    private String defaultErrorMessage = "Error.";
    private String defaultProgressMessage = "Loading..";
    private final Lazy layoutInflater$delegate;
    private Function1<? super String, Unit> tabSelectionListener;

    /* access modifiers changed from: private */
    public final NMediaSelectionCategoryBinding getBinding() {
        return (NMediaSelectionCategoryBinding) this.binding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final LayoutInflater getLayoutInflater() {
        return (LayoutInflater) this.layoutInflater$delegate.getValue();
    }

    public void onTabReselected(TabLayout.Tab tab) {
    }

    public void onTabUnselected(TabLayout.Tab tab) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.layoutInflater$delegate = LazyKt.lazy(new MediaCategoryView$layoutInflater$2(context));
        getBinding();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C4175R.styleable.MediaCategoryView, 0, 0);
            try {
                this.contentHeight = obtainStyledAttributes.getDimensionPixelSize(C4175R.styleable.MediaCategoryView_mcv_contentHeight, this.contentHeight);
                setTitle(obtainStyledAttributes.getString(C4175R.styleable.MediaCategoryView_mcv_title));
                setActionButtonText(obtainStyledAttributes.getString(C4175R.styleable.MediaCategoryView_mcv_actionButtonText));
                setShouldShowActionButton(obtainStyledAttributes.getBoolean(C4175R.styleable.MediaCategoryView_mcv_showActionButton, true));
                int resourceId = obtainStyledAttributes.getResourceId(C4175R.styleable.MediaCategoryView_mcv_actionButtonTextAppearance, 0);
                if (resourceId != 0) {
                    TextViewCompat.setTextAppearance(getBinding().actionTextView, resourceId);
                }
                String string = obtainStyledAttributes.getString(C4175R.styleable.MediaCategoryView_mcv_defaultProgressMessage);
                if (string == null) {
                    string = this.defaultProgressMessage;
                }
                this.defaultProgressMessage = string;
                String string2 = obtainStyledAttributes.getString(C4175R.styleable.MediaCategoryView_mcv_defaultContentNotAvailableMessage);
                if (string2 == null) {
                    string2 = this.defaultContentNotAvailableMessage;
                }
                this.defaultContentNotAvailableMessage = string2;
                String string3 = obtainStyledAttributes.getString(C4175R.styleable.MediaCategoryView_mcv_defaultErrorMessage);
                if (string3 == null) {
                    string3 = this.defaultErrorMessage;
                }
                this.defaultErrorMessage = string3;
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        setLayoutTransition(new LayoutTransition());
        getLayoutTransition().enableTransitionType(4);
        setupTabLayout();
        setupRecyclerView();
        showProgress$default(this, (String) null, 1, (Object) null);
        post(new MediaCategoryView$onFinishInflate$1(this));
    }

    private final void setupTabLayout() {
        TabLayout.OnTabSelectedListener onTabSelectedListener = this;
        getBinding().tabLayout.removeOnTabSelectedListener(onTabSelectedListener);
        getBinding().tabLayout.addOnTabSelectedListener(onTabSelectedListener);
    }

    private final void setupRecyclerView() {
        RecyclerView recyclerView = getBinding().recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    }

    public final void setTitle(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            getBinding().tabLayout.removeAllTabs();
            return;
        }
        TabLayout tabLayout = getBinding().tabLayout;
        Intrinsics.checkNotNullExpressionValue(tabLayout, "binding.tabLayout");
        int tabCount = tabLayout.getTabCount();
        if (tabCount == 0) {
            TabLayout.Tab newTab = getBinding().tabLayout.newTab();
            Intrinsics.checkNotNullExpressionValue(newTab, "binding.tabLayout.newTab()");
            newTab.setText(charSequence);
            getBinding().tabLayout.addTab(newTab);
        } else if (tabCount != 1) {
            getBinding().tabLayout.removeAllTabs();
            TabLayout.Tab newTab2 = getBinding().tabLayout.newTab();
            Intrinsics.checkNotNullExpressionValue(newTab2, "binding.tabLayout.newTab()");
            newTab2.setText(charSequence);
            getBinding().tabLayout.addTab(newTab2);
        } else {
            TabLayout.Tab tabAt = getBinding().tabLayout.getTabAt(0);
            if (tabAt != null) {
                tabAt.setText(charSequence);
            }
        }
    }

    public final void setActionButtonText(String str) {
        TextView textView = getBinding().actionTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.actionTextView");
        textView.setText(str);
    }

    public final void setActionButtonText(int i) {
        getBinding().actionTextView.setText(i);
    }

    public final void setShouldShowActionButton(boolean z) {
        TextView textView = getBinding().actionTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.actionTextView");
        textView.setVisibility(z ? 0 : 8);
    }

    public final void setAdapter(RecyclerView.Adapter<?> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        RecyclerView recyclerView = getBinding().recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setAdapter(adapter);
    }

    public final void setTabs(List<String> list, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "tabTitles");
        Intrinsics.checkNotNullParameter(function1, "tabSelectionListener");
        getBinding().tabLayout.removeAllTabs();
        for (String text : list) {
            TabLayout.Tab newTab = getBinding().tabLayout.newTab();
            Intrinsics.checkNotNullExpressionValue(newTab, "binding.tabLayout.newTab()");
            newTab.setText((CharSequence) text);
            getBinding().tabLayout.addTab(newTab);
        }
        this.tabSelectionListener = function1;
    }

    public final void setOnActionButtonClickListener(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        getBinding().actionTextView.setOnClickListener(new MediaCategoryView$setOnActionButtonClickListener$1(function0));
    }

    public final RecyclerView getRecyclerView() {
        RecyclerView recyclerView = getBinding().recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        return recyclerView;
    }

    public final void showContent() {
        ConstraintLayout constraintLayout = getBinding().contentLayout;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.contentLayout");
        constraintLayout.setVisibility(0);
        LinearLayout linearLayout = getBinding().stateLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.stateLayout");
        linearLayout.setVisibility(8);
    }

    public static /* synthetic */ void showProgress$default(MediaCategoryView mediaCategoryView, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mediaCategoryView.defaultProgressMessage;
        }
        mediaCategoryView.showProgress(str);
    }

    public final void showProgress(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        TextView textView = getBinding().messageTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.messageTextView");
        textView.setText(str);
        TextViewCompat.setTextAppearance(getBinding().messageTextView, C4175R.C4183style.MediaSelectionCategory_Title);
        ProgressBar progressBar = getBinding().progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.progressBar");
        progressBar.setVisibility(0);
        TextView textView2 = getBinding().retryView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.retryView");
        textView2.setVisibility(8);
        ConstraintLayout constraintLayout = getBinding().contentLayout;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.contentLayout");
        constraintLayout.setVisibility(8);
        LinearLayout linearLayout = getBinding().stateLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.stateLayout");
        linearLayout.setVisibility(0);
    }

    public static /* synthetic */ void showContentNotAvailable$default(MediaCategoryView mediaCategoryView, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mediaCategoryView.defaultContentNotAvailableMessage;
        }
        mediaCategoryView.showContentNotAvailable(str);
    }

    public final void showContentNotAvailable(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        TextView textView = getBinding().messageTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.messageTextView");
        textView.setText(str);
        TextViewCompat.setTextAppearance(getBinding().messageTextView, C4175R.C4183style.MediaSelectionCategory_Title);
        ProgressBar progressBar = getBinding().progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.progressBar");
        progressBar.setVisibility(8);
        TextView textView2 = getBinding().retryView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.retryView");
        textView2.setVisibility(8);
        ConstraintLayout constraintLayout = getBinding().contentLayout;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.contentLayout");
        constraintLayout.setVisibility(8);
        LinearLayout linearLayout = getBinding().stateLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.stateLayout");
        linearLayout.setVisibility(0);
    }

    public static /* synthetic */ void showError$default(MediaCategoryView mediaCategoryView, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mediaCategoryView.defaultErrorMessage;
        }
        mediaCategoryView.showError(str, function0);
    }

    public final void showError(String str, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(function0, "retryListener");
        TextView textView = getBinding().messageTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.messageTextView");
        textView.setText(str);
        TextViewCompat.setTextAppearance(getBinding().messageTextView, C4175R.C4183style.MediaSelectionCategory_Title_Error);
        getBinding().retryView.setOnClickListener(new MediaCategoryView$showError$1(this, function0));
        ProgressBar progressBar = getBinding().progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.progressBar");
        progressBar.setVisibility(8);
        TextView textView2 = getBinding().retryView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.retryView");
        textView2.setVisibility(0);
        ConstraintLayout constraintLayout = getBinding().contentLayout;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.contentLayout");
        constraintLayout.setVisibility(8);
        LinearLayout linearLayout = getBinding().stateLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.stateLayout");
        linearLayout.setVisibility(0);
    }

    public final void show() {
        setVisibility(0);
    }

    public final void hide() {
        setVisibility(8);
    }

    public void onTabSelected(TabLayout.Tab tab) {
        CharSequence text;
        if (tab != null && (text = tab.getText()) != null) {
            Intrinsics.checkNotNullExpressionValue(text, "tab?.text ?: return");
            Function1<? super String, Unit> function1 = this.tabSelectionListener;
            if (function1 != null) {
                Unit invoke = function1.invoke(text.toString());
            }
        }
    }
}
