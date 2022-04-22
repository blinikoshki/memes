package p015io.getstream.chat.android.livedata.repository.domain.channel.userread;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.ChannelUserRead;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001aH\u0010\u0003\u001a\u00020\u0002*\u00020\u000121\u0010\u0004\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, mo26107d2 = {"toEntity", "Lio/getstream/chat/android/livedata/repository/domain/channel/userread/ChannelUserReadEntity;", "Lio/getstream/chat/android/client/models/ChannelUserRead;", "toModel", "getUser", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "userId", "Lkotlin/coroutines/Continuation;", "Lio/getstream/chat/android/client/models/User;", "", "(Lio/getstream/chat/android/livedata/repository/domain/channel/userread/ChannelUserReadEntity;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stream-chat-android-offline_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.channel.userread.ChannelUserReadMapperKt */
/* compiled from: ChannelUserReadMapper.kt */
public final class ChannelUserReadMapperKt {
    public static final ChannelUserReadEntity toEntity(ChannelUserRead channelUserRead) {
        Intrinsics.checkNotNullParameter(channelUserRead, "$this$toEntity");
        return new ChannelUserReadEntity(channelUserRead.getUserId(), channelUserRead.getLastRead());
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object toModel(p015io.getstream.chat.android.livedata.repository.domain.channel.userread.ChannelUserReadEntity r6, kotlin.jvm.functions.Function2<? super java.lang.String, ? super kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.models.User>, ? extends java.lang.Object> r7, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.models.ChannelUserRead> r8) {
        /*
            boolean r0 = r8 instanceof p015io.getstream.chat.android.livedata.repository.domain.channel.userread.ChannelUserReadMapperKt$toModel$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            io.getstream.chat.android.livedata.repository.domain.channel.userread.ChannelUserReadMapperKt$toModel$1 r0 = (p015io.getstream.chat.android.livedata.repository.domain.channel.userread.ChannelUserReadMapperKt$toModel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.domain.channel.userread.ChannelUserReadMapperKt$toModel$1 r0 = new io.getstream.chat.android.livedata.repository.domain.channel.userread.ChannelUserReadMapperKt$toModel$1
            r0.<init>(r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r6 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.channel.userread.ChannelUserReadEntity r6 = (p015io.getstream.chat.android.livedata.repository.domain.channel.userread.ChannelUserReadEntity) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0048
        L_0x002e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r8 = r6.getUserId()
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r8 = r7.invoke(r8, r0)
            if (r8 != r1) goto L_0x0048
            return r1
        L_0x0048:
            r1 = r8
            io.getstream.chat.android.client.models.User r1 = (p015io.getstream.chat.android.client.models.User) r1
            java.util.Date r2 = r6.getLastRead()
            r3 = 0
            r4 = 4
            r5 = 0
            io.getstream.chat.android.client.models.ChannelUserRead r6 = new io.getstream.chat.android.client.models.ChannelUserRead
            r0 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.channel.userread.ChannelUserReadMapperKt.toModel(io.getstream.chat.android.livedata.repository.domain.channel.userread.ChannelUserReadEntity, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
