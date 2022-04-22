package com.memes.plus.p040ui.create_post;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.Observer;
import com.memes.commons.util.ActivityStarter;
import com.memes.plus.p040ui.home.feeds.HomeFeedType;
import com.memes.plus.p040ui.home.routing.HomeRouting;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.create_post.ExportPostActivity$attachObservers$5 */
/* compiled from: ExportPostActivity.kt */
final class ExportPostActivity$attachObservers$5<T> implements Observer<Boolean> {
    final /* synthetic */ ExportPostActivity this$0;

    ExportPostActivity$attachObservers$5(ExportPostActivity exportPostActivity) {
        this.this$0 = exportPostActivity;
    }

    public final void onChanged(Boolean bool) {
        ActivityStarter.Companion.mo57312of(HomeRouting.INSTANCE.getIntent((Context) this.this$0, HomeFeedType.FOLLOWING)).finishAffinity().startFrom((Activity) this.this$0);
    }
}
