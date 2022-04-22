package com.memes.plus.p040ui.posts.post_basics.viewcount;

import android.widget.TextView;
import com.memes.plus.C4199R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo26107d2 = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.post_basics.viewcount.PostViewCountView$textView$2 */
/* compiled from: PostViewCountView.kt */
final class PostViewCountView$textView$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ PostViewCountView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostViewCountView$textView$2(PostViewCountView postViewCountView) {
        super(0);
        this.this$0 = postViewCountView;
    }

    public final TextView invoke() {
        return (TextView) this.this$0.findViewById(C4199R.C4203id.text_view);
    }
}
