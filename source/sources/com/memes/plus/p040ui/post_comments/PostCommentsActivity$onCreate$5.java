package com.memes.plus.p040ui.post_comments;

import android.content.Context;
import android.view.View;
import com.livinglifetechway.quickpermissions_kotlin.PermissionsManagerKt;
import com.livinglifetechway.quickpermissions_kotlin.util.QuickPermissionsOptions;
import com.memes.commons.imageselection.ImageSelector;
import com.memes.plus.C4199R;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.PostCommentsActivity$onCreate$5 */
/* compiled from: PostCommentsActivity.kt */
final class PostCommentsActivity$onCreate$5 implements View.OnClickListener {
    final /* synthetic */ PostCommentsActivity this$0;

    PostCommentsActivity$onCreate$5(PostCommentsActivity postCommentsActivity) {
        this.this$0 = postCommentsActivity;
    }

    public final void onClick(View view) {
        PermissionsManagerKt.runWithPermissions$default((Context) this.this$0, new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"}, (QuickPermissionsOptions) null, (Function0) new Function0<Unit>(this) {
            final /* synthetic */ PostCommentsActivity$onCreate$5 this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                ImageSelector.enableCrop$default(this.this$0.this$0.imageSelector.requestIdentifier(46568).selectionSourcesLayoutRes(C4199R.C4205layout.image_selection_choices_item), (Pair) null, 1, (Object) null).callback(this.this$0.this$0).start();
            }
        }, 2, (Object) null);
    }
}
