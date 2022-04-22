package com.memes.commons.contentlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.memes.commons.C4144R;
import com.memes.commons.databinding.NestedContentLayoutBinding;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 42\u00020\u0001:\u000234B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020 H\u0014J\u0010\u0010$\u001a\u00020 2\b\b\u0001\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020 J\u0010\u0010(\u001a\u00020 2\b\b\u0001\u0010)\u001a\u00020&J\u0010\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020\u0017H\u0002J\u0006\u0010,\u001a\u00020 J\u0012\u0010-\u001a\u00020 2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/J\u0012\u00100\u001a\u00020 2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/J\u0012\u00101\u001a\u00020 2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/J\u0012\u00102\u001a\u00020 2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001b¨\u00065"}, mo26107d2 = {"Lcom/memes/commons/contentlayout/NestedContentLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/memes/commons/databinding/NestedContentLayoutBinding;", "getBinding", "()Lcom/memes/commons/databinding/NestedContentLayoutBinding;", "binding$delegate", "Lkotlin/Lazy;", "callback", "Lcom/memes/commons/contentlayout/NestedContentLayout$Callback;", "getCallback", "()Lcom/memes/commons/contentlayout/NestedContentLayout$Callback;", "setCallback", "(Lcom/memes/commons/contentlayout/NestedContentLayout$Callback;)V", "children", "", "Landroid/view/View;", "contentInvisibilityMode", "", "getContentInvisibilityMode", "()Z", "setContentInvisibilityMode", "(Z)V", "overlayMode", "getOverlayMode", "setOverlayMode", "apply", "", "contentVisibilityAction", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "onFinishInflate", "setErrorIcon", "drawableRes", "", "setErrorTextBoldStyle", "setErrorTextSize", "dimenRes", "showChildren", "shouldShow", "showContent", "showContentNotAvailable", "message", "", "showError", "showLoginError", "showProgress", "Callback", "Companion", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NestedContentLayout.kt */
public final class NestedContentLayout extends FrameLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DEFAULT_ERROR = "Something went wrong.";
    private static final String MSG_NO_CONTENT = "No data found.";
    private final Lazy binding$delegate;
    public Callback callback;
    /* access modifiers changed from: private */
    public List<View> children;
    private boolean contentInvisibilityMode;
    private boolean overlayMode;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/commons/contentlayout/NestedContentLayout$Callback;", "", "onContentLayoutErrorResolutionButtonTapped", "", "who", "", "why", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NestedContentLayout.kt */
    public interface Callback {
        void onContentLayoutErrorResolutionButtonTapped(int i, int i2);
    }

    private final NestedContentLayoutBinding getBinding() {
        return (NestedContentLayoutBinding) this.binding$delegate.getValue();
    }

    public static final /* synthetic */ List access$getChildren$p(NestedContentLayout nestedContentLayout) {
        List<View> list = nestedContentLayout.children;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("children");
        }
        return list;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NestedContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        this.binding$delegate = LazyKt.lazy(new NestedContentLayout$binding$2(this, context));
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/commons/contentlayout/NestedContentLayout$Companion;", "", "()V", "DEFAULT_ERROR", "", "MSG_NO_CONTENT", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NestedContentLayout.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final Callback getCallback() {
        Callback callback2 = this.callback;
        if (callback2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
        }
        return callback2;
    }

    public final void setCallback(Callback callback2) {
        Intrinsics.checkNotNullParameter(callback2, "<set-?>");
        this.callback = callback2;
    }

    public final boolean getOverlayMode() {
        return this.overlayMode;
    }

    public final void setOverlayMode(boolean z) {
        this.overlayMode = z;
    }

    public final boolean getContentInvisibilityMode() {
        return this.contentInvisibilityMode;
    }

    public final void setContentInvisibilityMode(boolean z) {
        this.contentInvisibilityMode = z;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        this.children = new ArrayList();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            List<View> list = this.children;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("children");
            }
            View childAt = getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(index)");
            list.add(childAt);
        }
        getBinding();
        showContent();
        super.onFinishInflate();
    }

    private final void showChildren(boolean z) {
        int i;
        if (this.overlayMode) {
            z = true;
        }
        if (this.children != null) {
            List<View> list = this.children;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("children");
            }
            for (View next : list) {
                if (z) {
                    i = 0;
                } else {
                    i = this.contentInvisibilityMode ? 4 : 8;
                }
                next.setVisibility(i);
            }
        }
    }

    public final void setErrorIcon(int i) {
        getBinding().nestedErrorIconImageView.setImageResource(i);
    }

    public final void setErrorTextSize(int i) {
        getBinding().nestedErrorMessageTextView.setTextSize(0, getResources().getDimension(i));
    }

    public final void setErrorTextBoldStyle() {
        TextView textView = getBinding().nestedErrorMessageTextView;
        TextView textView2 = getBinding().nestedErrorMessageTextView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.nestedErrorMessageTextView");
        textView.setTypeface(textView2.getTypeface(), 1);
    }

    public final void apply(ContentVisibilityAction contentVisibilityAction) {
        Intrinsics.checkNotNullParameter(contentVisibilityAction, "contentVisibilityAction");
        switch (contentVisibilityAction.getAction()) {
            case ContentVisibilityAction.PROGRESS:
                showProgress(contentVisibilityAction.getMessage());
                return;
            case ContentVisibilityAction.ERROR:
                showError(contentVisibilityAction.getMessage());
                return;
            case ContentVisibilityAction.LOGIN_ERROR:
                showLoginError(contentVisibilityAction.getMessage());
                return;
            case ContentVisibilityAction.NO_CONTENT:
                showContentNotAvailable(contentVisibilityAction.getMessage());
                return;
            default:
                showContent();
                return;
        }
    }

    public final void showContent() {
        showChildren(true);
        ProgressBar progressBar = getBinding().nestedProgressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.nestedProgressBar");
        progressBar.setVisibility(8);
        LinearLayout linearLayout = getBinding().nestedErrorContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.nestedErrorContainer");
        linearLayout.setVisibility(8);
        ImageView imageView = getBinding().nestedErrorIconImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.nestedErrorIconImageView");
        imageView.setVisibility(8);
    }

    public static /* synthetic */ void showProgress$default(NestedContentLayout nestedContentLayout, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        nestedContentLayout.showProgress(str);
    }

    public final void showProgress(String str) {
        showChildren(false);
        ProgressBar progressBar = getBinding().nestedProgressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.nestedProgressBar");
        progressBar.setVisibility(0);
        LinearLayout linearLayout = getBinding().nestedErrorContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.nestedErrorContainer");
        linearLayout.setVisibility(8);
        ImageView imageView = getBinding().nestedErrorIconImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.nestedErrorIconImageView");
        imageView.setVisibility(8);
    }

    public static /* synthetic */ void showError$default(NestedContentLayout nestedContentLayout, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        nestedContentLayout.showError(str);
    }

    public final void showError(String str) {
        showChildren(false);
        TextView textView = getBinding().nestedErrorMessageTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.nestedErrorMessageTextView");
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
        }
        textView.setText(charSequence);
        getBinding().nestedErrorResolutionButton.setText(C4144R.string.try_again);
        getBinding().nestedErrorResolutionButton.setOnClickListener(new NestedContentLayout$showError$1(this));
        ImageView imageView = getBinding().nestedErrorIconImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.nestedErrorIconImageView");
        imageView.setVisibility(8);
        Button button = getBinding().nestedErrorResolutionButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.nestedErrorResolutionButton");
        button.setVisibility(0);
        ProgressBar progressBar = getBinding().nestedProgressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.nestedProgressBar");
        progressBar.setVisibility(8);
        LinearLayout linearLayout = getBinding().nestedErrorContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.nestedErrorContainer");
        linearLayout.setVisibility(0);
    }

    public static /* synthetic */ void showLoginError$default(NestedContentLayout nestedContentLayout, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        nestedContentLayout.showLoginError(str);
    }

    public final void showLoginError(String str) {
        showChildren(false);
        TextView textView = getBinding().nestedErrorMessageTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.nestedErrorMessageTextView");
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
        }
        textView.setText(charSequence);
        getBinding().nestedErrorResolutionButton.setText(C4144R.string.login);
        getBinding().nestedErrorResolutionButton.setOnClickListener(new NestedContentLayout$showLoginError$1(this, str));
        ImageView imageView = getBinding().nestedErrorIconImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.nestedErrorIconImageView");
        imageView.setVisibility(8);
        Button button = getBinding().nestedErrorResolutionButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.nestedErrorResolutionButton");
        button.setVisibility(0);
        ProgressBar progressBar = getBinding().nestedProgressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.nestedProgressBar");
        progressBar.setVisibility(8);
        LinearLayout linearLayout = getBinding().nestedErrorContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.nestedErrorContainer");
        linearLayout.setVisibility(0);
    }

    public static /* synthetic */ void showContentNotAvailable$default(NestedContentLayout nestedContentLayout, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        nestedContentLayout.showContentNotAvailable(str);
    }

    public final void showContentNotAvailable(String str) {
        showChildren(false);
        TextView textView = getBinding().nestedErrorMessageTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.nestedErrorMessageTextView");
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
        }
        textView.setText(charSequence);
        ImageView imageView = getBinding().nestedErrorIconImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.nestedErrorIconImageView");
        imageView.setVisibility(0);
        Button button = getBinding().nestedErrorResolutionButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.nestedErrorResolutionButton");
        button.setVisibility(8);
        ProgressBar progressBar = getBinding().nestedProgressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.nestedProgressBar");
        progressBar.setVisibility(8);
        LinearLayout linearLayout = getBinding().nestedErrorContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.nestedErrorContainer");
        linearLayout.setVisibility(0);
    }
}
