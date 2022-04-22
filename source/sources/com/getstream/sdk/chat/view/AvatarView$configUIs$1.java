package com.getstream.sdk.chat.view;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import com.getstream.sdk.chat.view.messages.AvatarStyle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.getstream.sdk.chat.view.AvatarView$configUIs$1", mo26808f = "AvatarView.kt", mo26809i = {}, mo26810l = {64}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: AvatarView.kt */
final class AvatarView$configUIs$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1 $generateAvatarDrawable;
    final /* synthetic */ AvatarStyle $style;
    Object L$0;
    int label;
    final /* synthetic */ AvatarView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AvatarView$configUIs$1(AvatarView avatarView, AvatarStyle avatarStyle, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.this$0 = avatarView;
        this.$style = avatarStyle;
        this.$generateAvatarDrawable = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new AvatarView$configUIs$1(this.this$0, this.$style, this.$generateAvatarDrawable, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((AvatarView$configUIs$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        AvatarView avatarView;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ViewGroup.LayoutParams layoutParams = this.this$0.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = this.$style.getAvatarWidth();
                layoutParams.height = this.$style.getAvatarHeight();
                if (layoutParams != null) {
                    this.this$0.setLayoutParams(layoutParams);
                }
            }
            AvatarView avatarView2 = this.this$0;
            Function1 function1 = this.$generateAvatarDrawable;
            this.L$0 = avatarView2;
            this.label = 1;
            Object invoke = function1.invoke(this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            avatarView = avatarView2;
            obj = invoke;
        } else if (i == 1) {
            avatarView = (AvatarView) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        avatarView.setImageDrawable((Drawable) obj);
        return Unit.INSTANCE;
    }
}
