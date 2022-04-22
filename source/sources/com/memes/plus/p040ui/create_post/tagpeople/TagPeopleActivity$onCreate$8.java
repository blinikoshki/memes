package com.memes.plus.p040ui.create_post.tagpeople;

import com.google.android.exoplayer2.p024ui.PlayerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.create_post.tagpeople.TagPeopleActivity$onCreate$8 */
/* compiled from: TagPeopleActivity.kt */
final class TagPeopleActivity$onCreate$8 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Integer $fileType;
    final /* synthetic */ String $path;
    final /* synthetic */ TagPeopleActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TagPeopleActivity$onCreate$8(TagPeopleActivity tagPeopleActivity, Integer num, String str) {
        super(0);
        this.this$0 = tagPeopleActivity;
        this.$fileType = num;
        this.$path = str;
    }

    public final void invoke() {
        PlayerView playerView = this.this$0.getBinding().previewPlayerView;
        Intrinsics.checkNotNullExpressionValue(playerView, "binding.previewPlayerView");
        playerView.setVisibility(0);
        Integer num = this.$fileType;
        if (num != null && num.intValue() == 1231) {
            this.this$0.showPhoto(this.$path);
        } else if (num != null && num.intValue() == 1232) {
            this.this$0.showVideo(this.$path);
        }
    }
}
