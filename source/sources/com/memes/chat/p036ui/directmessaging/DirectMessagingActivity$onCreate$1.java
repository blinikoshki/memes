package com.memes.chat.p036ui.directmessaging;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import p015io.getstream.chat.android.client.models.Channel;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "result", "Lkotlin/Result;", "Lio/getstream/chat/android/client/models/Channel;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.directmessaging.DirectMessagingActivity$onCreate$1 */
/* compiled from: DirectMessagingActivity.kt */
final class DirectMessagingActivity$onCreate$1<T> implements Observer<Result<? extends Channel>> {
    final /* synthetic */ DirectMessagingActivity this$0;

    DirectMessagingActivity$onCreate$1(DirectMessagingActivity directMessagingActivity) {
        this.this$0 = directMessagingActivity;
    }

    public final void onChanged(Result<? extends Channel> result) {
        if (Result.m1036isSuccessimpl(result.m1038unboximpl())) {
            DirectMessagingActivity directMessagingActivity = this.this$0;
            Object r2 = result.m1038unboximpl();
            ResultKt.throwOnFailure(r2);
            directMessagingActivity.showChannel((Channel) r2);
        }
        this.this$0.finish();
        this.this$0.overridePendingTransition(0, 0);
    }
}
