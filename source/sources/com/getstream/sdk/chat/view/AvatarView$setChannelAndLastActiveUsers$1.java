package com.getstream.sdk.chat.view;

import com.getstream.sdk.chat.view.messages.AvatarStyle;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Channel;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H@¢\u0006\u0004\b\u0002\u0010\u0003"}, mo26107d2 = {"<anonymous>", "Lcom/getstream/sdk/chat/view/AvatarDrawable;", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.getstream.sdk.chat.view.AvatarView$setChannelAndLastActiveUsers$1", mo26808f = "AvatarView.kt", mo26809i = {}, mo26810l = {43, 44}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: AvatarView.kt */
final class AvatarView$setChannelAndLastActiveUsers$1 extends SuspendLambda implements Function1<Continuation<? super AvatarDrawable>, Object> {
    final /* synthetic */ Channel $channel;
    final /* synthetic */ List $lastActiveUsers;
    final /* synthetic */ AvatarStyle $style;
    int label;
    final /* synthetic */ AvatarView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AvatarView$setChannelAndLastActiveUsers$1(AvatarView avatarView, Channel channel, List list, AvatarStyle avatarStyle, Continuation continuation) {
        super(1, continuation);
        this.this$0 = avatarView;
        this.$channel = channel;
        this.$lastActiveUsers = list;
        this.$style = avatarStyle;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new AvatarView$setChannelAndLastActiveUsers$1(this.this$0, this.$channel, this.$lastActiveUsers, this.$style, continuation);
    }

    public final Object invoke(Object obj) {
        return ((AvatarView$setChannelAndLastActiveUsers$1) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        if (r6 != null) goto L_0x0060;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x001f
            if (r1 == r4) goto L_0x001b
            if (r1 != r3) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004b
        L_0x0013:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001b:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0031
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r6)
            io.getstream.chat.android.client.models.Channel r6 = r5.$channel
            if (r6 == 0) goto L_0x003c
            com.getstream.sdk.chat.view.AvatarView r1 = r5.this$0
            r5.label = r4
            java.lang.Object r6 = r1.createBitmap(r6, r5)
            if (r6 != r0) goto L_0x0031
            return r0
        L_0x0031:
            android.graphics.Bitmap r6 = (android.graphics.Bitmap) r6
            if (r6 == 0) goto L_0x003c
            java.util.List r6 = kotlin.collections.CollectionsKt.listOf(r6)
            if (r6 == 0) goto L_0x003c
            goto L_0x0060
        L_0x003c:
            com.getstream.sdk.chat.view.AvatarView r6 = r5.this$0
            java.util.List r1 = r5.$lastActiveUsers
            com.getstream.sdk.chat.view.messages.AvatarStyle r4 = r5.$style
            r5.label = r3
            java.lang.Object r6 = r6.createBitmaps(r1, r4, r5)
            if (r6 != r0) goto L_0x004b
            return r0
        L_0x004b:
            r0 = r6
            java.util.List r0 = (java.util.List) r0
            boolean r0 = r0.isEmpty()
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x005d
            goto L_0x005e
        L_0x005d:
            r6 = r2
        L_0x005e:
            java.util.List r6 = (java.util.List) r6
        L_0x0060:
            if (r6 == 0) goto L_0x0064
            r2 = r6
            goto L_0x007a
        L_0x0064:
            io.getstream.chat.android.client.models.Channel r6 = r5.$channel
            if (r6 == 0) goto L_0x007a
            java.lang.String r6 = p015io.getstream.chat.android.client.models.ContentUtils.getInitials((p015io.getstream.chat.android.client.models.Channel) r6)
            if (r6 == 0) goto L_0x007a
            com.getstream.sdk.chat.view.AvatarView r0 = r5.this$0
            com.getstream.sdk.chat.view.messages.AvatarStyle r1 = r5.$style
            android.graphics.Bitmap r6 = r0.createImageRounded(r6, r1)
            java.util.List r2 = kotlin.collections.CollectionsKt.listOf(r6)
        L_0x007a:
            if (r2 == 0) goto L_0x007d
            goto L_0x0081
        L_0x007d:
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0081:
            com.getstream.sdk.chat.view.AvatarDrawable r6 = new com.getstream.sdk.chat.view.AvatarDrawable
            r6.<init>(r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.view.AvatarView$setChannelAndLastActiveUsers$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
