package com.memes.plus.p040ui.create_post;

import com.memes.plus.util.ShareFileUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/util/ShareFileUtil;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.create_post.ExportPostActivity$shareFileUtil$2 */
/* compiled from: ExportPostActivity.kt */
final class ExportPostActivity$shareFileUtil$2 extends Lambda implements Function0<ShareFileUtil> {
    final /* synthetic */ ExportPostActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExportPostActivity$shareFileUtil$2(ExportPostActivity exportPostActivity) {
        super(0);
        this.this$0 = exportPostActivity;
    }

    public final ShareFileUtil invoke() {
        return new ShareFileUtil(this.this$0);
    }
}
