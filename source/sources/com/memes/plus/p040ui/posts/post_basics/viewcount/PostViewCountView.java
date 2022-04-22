package com.memes.plus.p040ui.posts.post_basics.viewcount;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.memes.commons.util.PrettyCounter;
import com.memes.plus.C4199R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post_basics/viewcount/PostViewCountView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "iconView", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "iconView$delegate", "Lkotlin/Lazy;", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textView$delegate", "onFinishInflate", "", "setViewCount", "count", "", "countStr", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.post_basics.viewcount.PostViewCountView */
/* compiled from: PostViewCountView.kt */
public final class PostViewCountView extends LinearLayout {
    private final Lazy iconView$delegate = LazyKt.lazy(new PostViewCountView$iconView$2(this));
    private final Lazy textView$delegate = LazyKt.lazy(new PostViewCountView$textView$2(this));

    private final ImageView getIconView() {
        return (ImageView) this.iconView$delegate.getValue();
    }

    private final TextView getTextView() {
        return (TextView) this.textView$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PostViewCountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        LinearLayout.inflate(getContext(), C4199R.C4205layout.post_view_count_view, this);
        super.onFinishInflate();
    }

    public final void setViewCount(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            setVisibility(8);
            return;
        }
        Long longOrNull = StringsKt.toLongOrNull(str);
        if (longOrNull == null || longOrNull.longValue() <= 0) {
            setVisibility(8);
            return;
        }
        setViewCount(longOrNull.longValue());
        setVisibility(0);
    }

    private final void setViewCount(long j) {
        getTextView().setText(PrettyCounter.INSTANCE.apply(j));
    }
}
