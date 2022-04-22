package p015io.getstream.chat.android.livedata.usecase;

import com.facebook.share.internal.ShareConstants;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.call.CoroutineCall;
import p015io.getstream.chat.android.client.extensions.MessageExtensionsKt;
import p015io.getstream.chat.android.client.models.Attachment;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.livedata.ChatDomainImpl;
import p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl;
import p015io.getstream.chat.android.livedata.utils.ValidationKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J[\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2,\u0010\u000e\u001a(\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u000f¢\u0006\u0002\b\u0015H\u0002J'\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJa\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\f0\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2,\u0010\u000e\u001a(\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u000f¢\u0006\u0002\b\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u001e*\u0004\u0018\u00010\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/usecase/SendMessageWithAttachmentsImpl;", "Lio/getstream/chat/android/livedata/usecase/SendMessageWithAttachments;", "domainImpl", "Lio/getstream/chat/android/livedata/ChatDomainImpl;", "(Lio/getstream/chat/android/livedata/ChatDomainImpl;)V", "invoke", "Lio/getstream/chat/android/client/call/Call;", "Lio/getstream/chat/android/client/models/Message;", "cid", "", "message", "files", "", "Ljava/io/File;", "attachmentTransformer", "Lkotlin/Function2;", "Lio/getstream/chat/android/client/models/Attachment;", "Lkotlin/ParameterName;", "name", "file", "", "Lkotlin/ExtensionFunctionType;", "uploadFile", "Lio/getstream/chat/android/client/utils/Result;", "channelControllerImpl", "Lio/getstream/chat/android/livedata/controller/ChannelControllerImpl;", "(Lio/getstream/chat/android/livedata/controller/ChannelControllerImpl;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadFiles", "(Lio/getstream/chat/android/livedata/controller/ChannelControllerImpl;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isImageMimetype", "", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.usecase.SendMessageWithAttachmentsImpl */
/* compiled from: SendMessageWithAttachmentsImpl.kt */
public final class SendMessageWithAttachmentsImpl implements SendMessageWithAttachments {
    private final ChatDomainImpl domainImpl;

    public SendMessageWithAttachmentsImpl(ChatDomainImpl chatDomainImpl) {
        Intrinsics.checkNotNullParameter(chatDomainImpl, "domainImpl");
        this.domainImpl = chatDomainImpl;
    }

    public Call<Message> invoke(String str, Message message, List<? extends File> list, Function2<? super Attachment, ? super File, Unit> function2) {
        Intrinsics.checkNotNullParameter(str, "cid");
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(list, "files");
        Intrinsics.checkNotNullParameter(function2, "attachmentTransformer");
        ValidationKt.validateCid(str);
        ChannelControllerImpl channel$stream_chat_android_offline_release = this.domainImpl.channel$stream_chat_android_offline_release(str);
        MessageExtensionsKt.enrichWithCid(message, str);
        return new CoroutineCall<>(this.domainImpl.getScope$stream_chat_android_offline_release(), new SendMessageWithAttachmentsImpl$invoke$1(this, channel$stream_chat_android_offline_release, list, function2, message, (Continuation) null));
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c0 A[SYNTHETIC] */
    final /* synthetic */ java.lang.Object uploadFiles(p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl r9, java.util.List<? extends java.io.File> r10, kotlin.jvm.functions.Function2<? super p015io.getstream.chat.android.client.models.Attachment, ? super java.io.File, kotlin.Unit> r11, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<java.util.List<p015io.getstream.chat.android.client.models.Attachment>>> r12) {
        /*
            r8 = this;
            boolean r0 = r12 instanceof p015io.getstream.chat.android.livedata.usecase.SendMessageWithAttachmentsImpl$uploadFiles$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            io.getstream.chat.android.livedata.usecase.SendMessageWithAttachmentsImpl$uploadFiles$1 r0 = (p015io.getstream.chat.android.livedata.usecase.SendMessageWithAttachmentsImpl$uploadFiles$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.usecase.SendMessageWithAttachmentsImpl$uploadFiles$1 r0 = new io.getstream.chat.android.livedata.usecase.SendMessageWithAttachmentsImpl$uploadFiles$1
            r0.<init>(r8, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x004a
            if (r2 != r3) goto L_0x0042
            java.lang.Object r9 = r0.L$5
            io.getstream.chat.android.client.utils.Result r9 = (p015io.getstream.chat.android.client.utils.Result) r9
            java.lang.Object r10 = r0.L$4
            java.io.File r10 = (java.io.File) r10
            java.lang.Object r11 = r0.L$3
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r2 = r0.L$2
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            java.lang.Object r4 = r0.L$1
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r4 = (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl) r4
            java.lang.Object r5 = r0.L$0
            io.getstream.chat.android.livedata.usecase.SendMessageWithAttachmentsImpl r5 = (p015io.getstream.chat.android.livedata.usecase.SendMessageWithAttachmentsImpl) r5
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x008f
        L_0x0042:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x004a:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            io.getstream.chat.android.client.utils.Result r12 = new io.getstream.chat.android.client.utils.Result
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
            r12.<init>(r2)
            java.util.Iterator r10 = r10.iterator()
            r5 = r8
            r7 = r10
            r10 = r9
            r9 = r12
            r12 = r11
            r11 = r7
        L_0x0062:
            boolean r2 = r11.hasNext()
            if (r2 == 0) goto L_0x00c0
            java.lang.Object r2 = r11.next()
            java.io.File r2 = (java.io.File) r2
            boolean r4 = r9.isError()
            if (r4 == 0) goto L_0x0075
            goto L_0x0062
        L_0x0075:
            r0.L$0 = r5
            r0.L$1 = r10
            r0.L$2 = r12
            r0.L$3 = r11
            r0.L$4 = r2
            r0.L$5 = r9
            r0.label = r3
            java.lang.Object r4 = r5.uploadFile(r10, r2, r0)
            if (r4 != r1) goto L_0x008a
            return r1
        L_0x008a:
            r7 = r4
            r4 = r10
            r10 = r2
            r2 = r12
            r12 = r7
        L_0x008f:
            io.getstream.chat.android.client.utils.Result r12 = (p015io.getstream.chat.android.client.utils.Result) r12
            boolean r6 = r12.isError()
            if (r6 == 0) goto L_0x00a1
            io.getstream.chat.android.client.utils.Result r9 = new io.getstream.chat.android.client.utils.Result
            io.getstream.chat.android.client.errors.ChatError r10 = r12.error()
            r9.<init>((p015io.getstream.chat.android.client.errors.ChatError) r10)
            goto L_0x00bd
        L_0x00a1:
            java.lang.Object r9 = r9.data()
            java.util.Collection r9 = (java.util.Collection) r9
            java.lang.Object r12 = r12.data()
            r6 = r12
            io.getstream.chat.android.client.models.Attachment r6 = (p015io.getstream.chat.android.client.models.Attachment) r6
            r2.invoke(r6, r10)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            java.util.List r9 = kotlin.collections.CollectionsKt.plus(r9, r12)
            io.getstream.chat.android.client.utils.Result r10 = new io.getstream.chat.android.client.utils.Result
            r10.<init>(r9)
            r9 = r10
        L_0x00bd:
            r12 = r2
            r10 = r4
            goto L_0x0062
        L_0x00c0:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.usecase.SendMessageWithAttachmentsImpl.uploadFiles(io.getstream.chat.android.livedata.controller.ChannelControllerImpl, java.util.List, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object uploadFile(p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl r32, java.io.File r33, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<p015io.getstream.chat.android.client.models.Attachment>> r34) {
        /*
            r31 = this;
            r0 = r31
            r1 = r32
            r2 = r33
            r3 = r34
            boolean r4 = r3 instanceof p015io.getstream.chat.android.livedata.usecase.SendMessageWithAttachmentsImpl$uploadFile$1
            if (r4 == 0) goto L_0x001c
            r4 = r3
            io.getstream.chat.android.livedata.usecase.SendMessageWithAttachmentsImpl$uploadFile$1 r4 = (p015io.getstream.chat.android.livedata.usecase.SendMessageWithAttachmentsImpl$uploadFile$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r5 & r6
            if (r5 == 0) goto L_0x001c
            int r3 = r4.label
            int r3 = r3 - r6
            r4.label = r3
            goto L_0x0021
        L_0x001c:
            io.getstream.chat.android.livedata.usecase.SendMessageWithAttachmentsImpl$uploadFile$1 r4 = new io.getstream.chat.android.livedata.usecase.SendMessageWithAttachmentsImpl$uploadFile$1
            r4.<init>(r0, r3)
        L_0x0021:
            java.lang.Object r3 = r4.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r6 = r4.label
            r7 = 2
            r8 = 1
            if (r6 == 0) goto L_0x0059
            if (r6 == r8) goto L_0x0049
            if (r6 != r7) goto L_0x0041
            java.lang.Object r1 = r4.L$2
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r4.L$1
            java.io.File r2 = (java.io.File) r2
            java.lang.Object r4 = r4.L$0
            io.getstream.chat.android.livedata.usecase.SendMessageWithAttachmentsImpl r4 = (p015io.getstream.chat.android.livedata.usecase.SendMessageWithAttachmentsImpl) r4
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x009d
        L_0x0041:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0049:
            java.lang.Object r1 = r4.L$2
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r4.L$1
            java.io.File r2 = (java.io.File) r2
            java.lang.Object r4 = r4.L$0
            io.getstream.chat.android.livedata.usecase.SendMessageWithAttachmentsImpl r4 = (p015io.getstream.chat.android.livedata.usecase.SendMessageWithAttachmentsImpl) r4
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x0083
        L_0x0059:
            kotlin.ResultKt.throwOnFailure(r3)
            android.webkit.MimeTypeMap r3 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r6 = kotlin.p017io.FilesKt.getExtension(r33)
            java.lang.String r3 = r3.getMimeTypeFromExtension(r6)
            boolean r6 = r0.isImageMimetype(r3)
            if (r6 != r8) goto L_0x0086
            r4.L$0 = r0
            r4.L$1 = r2
            r4.L$2 = r3
            r4.label = r8
            java.lang.Object r1 = r1.sendImage(r2, r4)
            if (r1 != r5) goto L_0x007d
            return r5
        L_0x007d:
            r4 = r0
            r30 = r3
            r3 = r1
            r1 = r30
        L_0x0083:
            io.getstream.chat.android.client.utils.Result r3 = (p015io.getstream.chat.android.client.utils.Result) r3
            goto L_0x009f
        L_0x0086:
            if (r6 != 0) goto L_0x0106
            r4.L$0 = r0
            r4.L$1 = r2
            r4.L$2 = r3
            r4.label = r7
            java.lang.Object r1 = r1.sendFile(r2, r4)
            if (r1 != r5) goto L_0x0097
            return r5
        L_0x0097:
            r4 = r0
            r30 = r3
            r3 = r1
            r1 = r30
        L_0x009d:
            io.getstream.chat.android.client.utils.Result r3 = (p015io.getstream.chat.android.client.utils.Result) r3
        L_0x009f:
            boolean r5 = r3.isError()
            if (r5 == 0) goto L_0x00af
            io.getstream.chat.android.client.utils.Result r1 = new io.getstream.chat.android.client.utils.Result
            io.getstream.chat.android.client.errors.ChatError r2 = r3.error()
            r1.<init>((p015io.getstream.chat.android.client.errors.ChatError) r2)
            goto L_0x0105
        L_0x00af:
            java.lang.Object r3 = r3.data()
            java.lang.String r3 = (java.lang.String) r3
            r22 = r3
            io.getstream.chat.android.client.models.Attachment r5 = new io.getstream.chat.android.client.models.Attachment
            r9 = r5
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            java.lang.String r23 = r2.getName()
            long r6 = r2.length()
            int r2 = (int) r6
            r17 = r2
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 249663(0x3cf3f, float:3.49852E-40)
            r29 = 0
            r16 = r1
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            boolean r1 = r4.isImageMimetype(r1)
            if (r1 != r8) goto L_0x00f4
            r5.setImageUrl(r3)
            java.lang.String r1 = "image"
            r5.setType(r1)
            goto L_0x00fe
        L_0x00f4:
            if (r1 != 0) goto L_0x00fe
            r5.setAssetUrl(r3)
            java.lang.String r1 = "file"
            r5.setType(r1)
        L_0x00fe:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            io.getstream.chat.android.client.utils.Result r1 = new io.getstream.chat.android.client.utils.Result
            r1.<init>(r5)
        L_0x0105:
            return r1
        L_0x0106:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.usecase.SendMessageWithAttachmentsImpl.uploadFile(io.getstream.chat.android.livedata.controller.ChannelControllerImpl, java.io.File, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean isImageMimetype(String str) {
        if (str != null) {
            return StringsKt.contains$default((CharSequence) str, (CharSequence) "image", false, 2, (Object) null);
        }
        return false;
    }
}
