package com.memes.plus.p040ui.posts.edit_post;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.memes.plus.p040ui.posts.post_tags_dialog.PostTaggedUser;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "taggedUsers", "", "Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUser;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.edit_post.EditPostActivity$attachObservers$2 */
/* compiled from: EditPostActivity.kt */
final class EditPostActivity$attachObservers$2<T> implements Observer<List<? extends PostTaggedUser>> {
    final /* synthetic */ EditPostActivity this$0;

    EditPostActivity$attachObservers$2(EditPostActivity editPostActivity) {
        this.this$0 = editPostActivity;
    }

    public final void onChanged(List<PostTaggedUser> list) {
        String str;
        int size = list.size();
        int size2 = list.size();
        if (size2 == 0) {
            str = "";
        } else if (size2 != 1) {
            str = size + " People";
        } else {
            Intrinsics.checkNotNullExpressionValue(list, "taggedUsers");
            str = ((PostTaggedUser) CollectionsKt.first(list)).getUserName();
        }
        TextView textView = this.this$0.getBinding().tagsPeopleCountTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tagsPeopleCountTextView");
        textView.setText(str);
    }
}
