package com.getstream.sdk.chat.view;

import com.getstream.sdk.chat.view.messages.AvatarStyle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H@¢\u0006\u0004\b\u0002\u0010\u0003"}, mo26107d2 = {"<anonymous>", "Lcom/getstream/sdk/chat/view/AvatarDrawable;", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.getstream.sdk.chat.view.AvatarView$setUser$1", mo26808f = "AvatarView.kt", mo26809i = {}, mo26810l = {52}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: AvatarView.kt */
final class AvatarView$setUser$1 extends SuspendLambda implements Function1<Continuation<? super AvatarDrawable>, Object> {
    final /* synthetic */ AvatarStyle $style;
    final /* synthetic */ User $user;
    int label;
    final /* synthetic */ AvatarView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AvatarView$setUser$1(AvatarView avatarView, User user, AvatarStyle avatarStyle, Continuation continuation) {
        super(1, continuation);
        this.this$0 = avatarView;
        this.$user = user;
        this.$style = avatarStyle;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new AvatarView$setUser$1(this.this$0, this.$user, this.$style, continuation);
    }

    public final Object invoke(Object obj) {
        return ((AvatarView$setUser$1) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AvatarView avatarView = this.this$0;
            User user = this.$user;
            AvatarStyle avatarStyle = this.$style;
            this.label = 1;
            obj = avatarView.createBitmap(user, avatarStyle, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return new AvatarDrawable(CollectionsKt.listOfNotNull(obj));
    }
}
