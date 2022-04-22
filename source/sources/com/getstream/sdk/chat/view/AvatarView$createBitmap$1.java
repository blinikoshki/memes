package com.getstream.sdk.chat.view;

import com.getstream.sdk.chat.view.messages.AvatarStyle;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H@"}, mo26107d2 = {"createBitmap", "", "Lio/getstream/chat/android/client/models/User;", "style", "Lcom/getstream/sdk/chat/view/messages/AvatarStyle;", "continuation", "Lkotlin/coroutines/Continuation;", "Landroid/graphics/Bitmap;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.getstream.sdk.chat.view.AvatarView", mo26808f = "AvatarView.kt", mo26809i = {0, 0, 0}, mo26810l = {72}, mo26811m = "createBitmap", mo26812n = {"this", "$this$createBitmap", "style"}, mo26813s = {"L$0", "L$1", "L$2"})
/* compiled from: AvatarView.kt */
final class AvatarView$createBitmap$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AvatarView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AvatarView$createBitmap$1(AvatarView avatarView, Continuation continuation) {
        super(continuation);
        this.this$0 = avatarView;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.createBitmap((User) null, (AvatarStyle) null, this);
    }
}
