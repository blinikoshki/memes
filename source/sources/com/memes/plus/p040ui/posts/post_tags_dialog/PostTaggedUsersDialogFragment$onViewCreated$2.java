package com.memes.plus.p040ui.posts.post_tags_dialog;

import android.content.DialogInterface;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.plus.C4199R;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onShow"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.post_tags_dialog.PostTaggedUsersDialogFragment$onViewCreated$2 */
/* compiled from: PostTaggedUsersDialogFragment.kt */
final class PostTaggedUsersDialogFragment$onViewCreated$2 implements DialogInterface.OnShowListener {
    final /* synthetic */ PostTaggedUsersDialogFragment this$0;

    PostTaggedUsersDialogFragment$onViewCreated$2(PostTaggedUsersDialogFragment postTaggedUsersDialogFragment) {
        this.this$0 = postTaggedUsersDialogFragment;
    }

    public final void onShow(DialogInterface dialogInterface) {
        ContentLayout.showProgress$default(this.this$0.getBinding().contentLayout, (String) null, 1, (Object) null);
        this.this$0.getBinding().hideDialogView.setText(C4199R.string.cancel);
    }
}
