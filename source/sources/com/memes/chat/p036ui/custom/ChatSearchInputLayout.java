package com.memes.chat.p036ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.memes.chat.databinding.VChatSearchLayoutBinding;
import com.memes.commons.util.ExtensionsKt;
import com.memes.commons.util.SoftKeyboardUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0012\u001a\u00020\u0010H\u0014J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001c\u0010\u0016\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0002J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0018J\u0006\u0010\u001c\u001a\u00020\u0010R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo26107d2 = {"Lcom/memes/chat/ui/custom/ChatSearchInputLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/memes/chat/databinding/VChatSearchLayoutBinding;", "getBinding", "()Lcom/memes/chat/databinding/VChatSearchLayoutBinding;", "binding$delegate", "Lkotlin/Lazy;", "callback", "Lcom/memes/chat/ui/custom/ChatSearchInputLayout$Callback;", "clearText", "", "hideKeyboard", "onFinishInflate", "onSearchQueryChanged", "query", "", "onSearchRequested", "closeKeyboard", "", "setCallback", "setDrawableStartVisible", "setVisible", "showKeyboard", "Callback", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.custom.ChatSearchInputLayout */
/* compiled from: ChatSearchInputLayout.kt */
public final class ChatSearchInputLayout extends LinearLayout {
    private final Lazy binding$delegate;
    private Callback callback;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/chat/ui/custom/ChatSearchInputLayout$Callback;", "", "onSearchRequested", "", "query", "", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.custom.ChatSearchInputLayout$Callback */
    /* compiled from: ChatSearchInputLayout.kt */
    public interface Callback {
        void onSearchRequested(String str);
    }

    private final VChatSearchLayoutBinding getBinding() {
        return (VChatSearchLayoutBinding) this.binding$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatSearchInputLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.binding$delegate = LazyKt.lazy(new ChatSearchInputLayout$binding$2(this, context));
        setOrientation(0);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        getBinding();
        super.onFinishInflate();
        getBinding().searchInputCancelView.setOnClickListener(new ChatSearchInputLayout$onFinishInflate$1(this));
        EditText editText = getBinding().searchInputEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.searchInputEditText");
        editText.addTextChangedListener(new C4138xd9657905(this));
        getBinding().searchInputEditText.setOnEditorActionListener(new ChatSearchInputLayout$onFinishInflate$3(this));
    }

    public final void setDrawableStartVisible(boolean z) {
        if (z) {
            ImageView imageView = getBinding().searchIndicatorImageView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.searchIndicatorImageView");
            imageView.setVisibility(0);
            return;
        }
        ImageView imageView2 = getBinding().searchIndicatorImageView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.searchIndicatorImageView");
        imageView2.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void onSearchQueryChanged(String str) {
        ImageView imageView = getBinding().searchInputCancelView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.searchInputCancelView");
        imageView.setVisibility(StringsKt.isBlank(str) ^ true ? 0 : 8);
        onSearchRequested(str, false);
    }

    static /* synthetic */ void onSearchRequested$default(ChatSearchInputLayout chatSearchInputLayout, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        chatSearchInputLayout.onSearchRequested(str, z);
    }

    private final void onSearchRequested(String str, boolean z) {
        if (z) {
            hideKeyboard();
        }
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onSearchRequested(str);
        }
    }

    public final void setCallback(Callback callback2) {
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.callback = callback2;
    }

    public final void clearText() {
        EditText editText = getBinding().searchInputEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.searchInputEditText");
        ExtensionsKt.clearText(editText);
    }

    public final void showKeyboard() {
        SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
        EditText editText = getBinding().searchInputEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.searchInputEditText");
        softKeyboardUtil.showKeyboard(editText);
    }

    public final void hideKeyboard() {
        SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
        EditText editText = getBinding().searchInputEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.searchInputEditText");
        softKeyboardUtil.hideKeyboard(editText);
    }
}
