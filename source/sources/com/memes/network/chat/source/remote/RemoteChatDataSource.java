package com.memes.network.chat.source.remote;

import com.memes.network.chat.api.ChatDataSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\nJ/\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, mo26107d2 = {"Lcom/memes/network/chat/source/remote/RemoteChatDataSource;", "Lcom/memes/network/chat/api/ChatDataSource;", "chatClient", "Lcom/memes/network/chat/source/remote/ChatClient;", "(Lcom/memes/network/chat/source/remote/ChatClient;)V", "createChatToken", "Lcom/memes/network/core/UniversalResult;", "Lcom/memes/network/chat/source/remote/model/signin/ChatTokenResponse;", "request", "Lcom/memes/network/chat/source/remote/model/signin/ChatSignInRequest;", "(Lcom/memes/network/chat/source/remote/model/signin/ChatSignInRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadPhotoFile", "", "userId", "userToken", "file", "Ljava/io/File;", "(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: RemoteChatDataSource.kt */
public final class RemoteChatDataSource implements ChatDataSource {
    private final ChatClient chatClient;

    public RemoteChatDataSource(ChatClient chatClient2) {
        Intrinsics.checkNotNullParameter(chatClient2, "chatClient");
        this.chatClient = chatClient2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object createChatToken(com.memes.network.chat.source.remote.model.signin.ChatSignInRequest r9, kotlin.coroutines.Continuation<? super com.memes.network.core.UniversalResult<com.memes.network.chat.source.remote.model.signin.ChatTokenResponse>> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.memes.network.chat.source.remote.RemoteChatDataSource$createChatToken$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.memes.network.chat.source.remote.RemoteChatDataSource$createChatToken$1 r0 = (com.memes.network.chat.source.remote.RemoteChatDataSource$createChatToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.memes.network.chat.source.remote.RemoteChatDataSource$createChatToken$1 r0 = new com.memes.network.chat.source.remote.RemoteChatDataSource$createChatToken$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0040
        L_0x002a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r10)
            com.memes.network.chat.source.remote.ChatClient r10 = r8.chatClient
            r0.label = r3
            java.lang.Object r10 = r10.createToken(r9, r0)
            if (r10 != r1) goto L_0x0040
            return r1
        L_0x0040:
            retrofit2.Response r10 = (retrofit2.Response) r10
            com.memes.network.core.UniversalResult r9 = new com.memes.network.core.UniversalResult
            int r1 = r10.code()
            java.lang.String r2 = r10.message()
            java.lang.String r0 = "response.message()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            java.lang.Object r3 = r10.body()
            r4 = 0
            r5 = 0
            r6 = 24
            r7 = 0
            r0 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.network.chat.source.remote.RemoteChatDataSource.createChatToken(com.memes.network.chat.source.remote.model.signin.ChatSignInRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object uploadPhotoFile(java.lang.String r21, java.lang.String r22, java.io.File r23, kotlin.coroutines.Continuation<? super com.memes.network.core.UniversalResult<java.lang.String>> r24) {
        /*
            r20 = this;
            r0 = r20
            r1 = r24
            boolean r2 = r1 instanceof com.memes.network.chat.source.remote.RemoteChatDataSource$uploadPhotoFile$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.memes.network.chat.source.remote.RemoteChatDataSource$uploadPhotoFile$1 r2 = (com.memes.network.chat.source.remote.RemoteChatDataSource$uploadPhotoFile$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.memes.network.chat.source.remote.RemoteChatDataSource$uploadPhotoFile$1 r2 = new com.memes.network.chat.source.remote.RemoteChatDataSource$uploadPhotoFile$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 3
            r6 = 2
            r7 = 0
            r8 = 0
            r9 = 1
            if (r4 == 0) goto L_0x005d
            if (r4 == r9) goto L_0x0051
            if (r4 == r6) goto L_0x0044
            if (r4 != r5) goto L_0x003c
            java.lang.Object r2 = r2.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.throwOnFailure(r1)
            r5 = r2
            goto L_0x019f
        L_0x003c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0044:
            java.lang.Object r4 = r2.L$1
            java.io.File r4 = (java.io.File) r4
            java.lang.Object r6 = r2.L$0
            com.memes.network.chat.source.remote.RemoteChatDataSource r6 = (com.memes.network.chat.source.remote.RemoteChatDataSource) r6
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0114
        L_0x0051:
            java.lang.Object r4 = r2.L$1
            java.io.File r4 = (java.io.File) r4
            java.lang.Object r10 = r2.L$0
            com.memes.network.chat.source.remote.RemoteChatDataSource r10 = (com.memes.network.chat.source.remote.RemoteChatDataSource) r10
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x007e
        L_0x005d:
            kotlin.ResultKt.throwOnFailure(r1)
            com.memes.network.chat.source.remote.model.jwt.JwtRequest r1 = new com.memes.network.chat.source.remote.model.jwt.JwtRequest
            r4 = r21
            r10 = r22
            r1.<init>(r4, r10)
            com.memes.network.chat.source.remote.ChatClient r4 = r0.chatClient
            r2.L$0 = r0
            r10 = r23
            r2.L$1 = r10
            r2.label = r9
            java.lang.String r11 = "https://api.memes.com/legacy_auth"
            java.lang.Object r1 = r4.createJwt(r11, r1, r2)
            if (r1 != r3) goto L_0x007c
            return r3
        L_0x007c:
            r4 = r10
            r10 = r0
        L_0x007e:
            retrofit2.Response r1 = (retrofit2.Response) r1
            boolean r11 = r1.isSuccessful()
            if (r11 != 0) goto L_0x00b8
            okhttp3.ResponseBody r1 = r1.errorBody()
            if (r1 == 0) goto L_0x0090
            java.lang.String r8 = r1.string()
        L_0x0090:
            com.google.gson.Gson r1 = new com.google.gson.Gson
            r1.<init>()
            java.lang.Class<com.memes.network.chat.source.remote.model.jwt.JwtError> r2 = com.memes.network.chat.source.remote.model.jwt.JwtError.class
            java.lang.Object r1 = r1.fromJson((java.lang.String) r8, r2)
            com.memes.network.chat.source.remote.model.jwt.JwtError r1 = (com.memes.network.chat.source.remote.model.jwt.JwtError) r1
            com.memes.network.core.UniversalResult r10 = new com.memes.network.core.UniversalResult
            r3 = 400(0x190, float:5.6E-43)
            if (r1 == 0) goto L_0x00aa
            java.lang.String r1 = r1.getMessage()
            if (r1 == 0) goto L_0x00aa
            goto L_0x00ac
        L_0x00aa:
            java.lang.String r1 = "Legacy Jwt Generation Failed."
        L_0x00ac:
            r4 = r1
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 28
            r9 = 0
            r2 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return r10
        L_0x00b8:
            java.lang.Object r1 = r1.body()
            com.memes.network.chat.source.remote.model.jwt.JwtResult r1 = (com.memes.network.chat.source.remote.model.jwt.JwtResult) r1
            if (r1 == 0) goto L_0x00c5
            java.lang.String r1 = r1.getJwt()
            goto L_0x00c6
        L_0x00c5:
            r1 = r8
        L_0x00c6:
            r11 = r1
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            if (r11 == 0) goto L_0x00d4
            boolean r11 = kotlin.text.StringsKt.isBlank(r11)
            if (r11 == 0) goto L_0x00d2
            goto L_0x00d4
        L_0x00d2:
            r11 = 0
            goto L_0x00d5
        L_0x00d4:
            r11 = 1
        L_0x00d5:
            if (r11 == 0) goto L_0x00eb
            com.memes.network.core.UniversalResult r1 = new com.memes.network.core.UniversalResult
            r13 = 400(0x190, float:5.6E-43)
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 28
            r19 = 0
            java.lang.String r14 = "Invalid Jwt Token Received."
            r12 = r1
            r12.<init>(r13, r14, r15, r16, r17, r18, r19)
            return r1
        L_0x00eb:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Bearer "
            r11.append(r12)
            r11.append(r1)
            java.lang.String r1 = r11.toString()
            com.memes.network.chat.source.remote.model.fileupload.GenerateUploadUrlRequest$Companion r11 = com.memes.network.chat.source.remote.model.fileupload.GenerateUploadUrlRequest.Companion
            com.memes.network.chat.source.remote.model.fileupload.GenerateUploadUrlRequest r11 = r11.ofPhoto()
            com.memes.network.chat.source.remote.ChatClient r12 = r10.chatClient
            r2.L$0 = r10
            r2.L$1 = r4
            r2.label = r6
            java.lang.String r6 = "https://api.memes.com/api/media/message/upload"
            java.lang.Object r1 = r12.createUploadUrl(r1, r6, r11, r2)
            if (r1 != r3) goto L_0x0113
            return r3
        L_0x0113:
            r6 = r10
        L_0x0114:
            retrofit2.Response r1 = (retrofit2.Response) r1
            boolean r10 = r1.isSuccessful()
            if (r10 == 0) goto L_0x0123
            java.lang.Object r10 = r1.body()
            com.memes.network.chat.source.remote.model.fileupload.GenerateUploadUrlResult r10 = (com.memes.network.chat.source.remote.model.fileupload.GenerateUploadUrlResult) r10
            goto L_0x013c
        L_0x0123:
            okhttp3.ResponseBody r10 = r1.errorBody()
            if (r10 == 0) goto L_0x012e
            java.lang.String r10 = r10.string()
            goto L_0x012f
        L_0x012e:
            r10 = r8
        L_0x012f:
            com.google.gson.Gson r11 = new com.google.gson.Gson
            r11.<init>()
            java.lang.Class<com.memes.network.chat.source.remote.model.fileupload.GenerateUploadUrlResult> r12 = com.memes.network.chat.source.remote.model.fileupload.GenerateUploadUrlResult.class
            java.lang.Object r10 = r11.fromJson((java.lang.String) r10, r12)
            com.memes.network.chat.source.remote.model.fileupload.GenerateUploadUrlResult r10 = (com.memes.network.chat.source.remote.model.fileupload.GenerateUploadUrlResult) r10
        L_0x013c:
            if (r10 == 0) goto L_0x0143
            java.lang.String r11 = r10.getUploadUrl()
            goto L_0x0144
        L_0x0143:
            r11 = r8
        L_0x0144:
            if (r10 == 0) goto L_0x014b
            java.lang.String r12 = r10.getFinalUrl()
            goto L_0x014c
        L_0x014b:
            r12 = r8
        L_0x014c:
            if (r10 == 0) goto L_0x01ca
            java.lang.Boolean r13 = r10.getSuccess()
            java.lang.Boolean r14 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r9)
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r14)
            r13 = r13 ^ r9
            if (r13 != 0) goto L_0x01ca
            r13 = r11
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            if (r13 == 0) goto L_0x016b
            boolean r13 = kotlin.text.StringsKt.isBlank(r13)
            if (r13 == 0) goto L_0x0169
            goto L_0x016b
        L_0x0169:
            r13 = 0
            goto L_0x016c
        L_0x016b:
            r13 = 1
        L_0x016c:
            if (r13 != 0) goto L_0x01ca
            r13 = r12
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            if (r13 == 0) goto L_0x017c
            boolean r13 = kotlin.text.StringsKt.isBlank(r13)
            if (r13 == 0) goto L_0x017a
            goto L_0x017c
        L_0x017a:
            r13 = 0
            goto L_0x017d
        L_0x017c:
            r13 = 1
        L_0x017d:
            if (r13 == 0) goto L_0x0180
            goto L_0x01ca
        L_0x0180:
            java.lang.String r1 = "image/*"
            okhttp3.MediaType r1 = okhttp3.MediaType.parse(r1)
            okhttp3.RequestBody r1 = okhttp3.RequestBody.create((okhttp3.MediaType) r1, (java.io.File) r4)
            com.memes.network.chat.source.remote.ChatClient r4 = r6.chatClient
            java.lang.String r6 = "fileUploadRequestBody"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r6)
            r2.L$0 = r12
            r2.L$1 = r8
            r2.label = r5
            java.lang.Object r1 = r4.uploadFileToUrl(r11, r1, r2)
            if (r1 != r3) goto L_0x019e
            return r3
        L_0x019e:
            r5 = r12
        L_0x019f:
            retrofit2.Response r1 = (retrofit2.Response) r1
            boolean r2 = r1.isSuccessful()
            if (r2 != 0) goto L_0x01ba
            com.memes.network.core.UniversalResult r2 = new com.memes.network.core.UniversalResult
            int r7 = r1.code()
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 28
            r13 = 0
            java.lang.String r8 = "File upload failed."
            r6 = r2
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            return r2
        L_0x01ba:
            com.memes.network.core.UniversalResult r1 = new com.memes.network.core.UniversalResult
            r3 = 200(0xc8, float:2.8E-43)
            r6 = 0
            r7 = 0
            r8 = 24
            r9 = 0
            java.lang.String r4 = "File uploaded."
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return r1
        L_0x01ca:
            if (r10 == 0) goto L_0x01d0
            java.lang.String r8 = r10.getMessage()
        L_0x01d0:
            r2 = r8
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x01db
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)
            if (r2 == 0) goto L_0x01dc
        L_0x01db:
            r7 = 1
        L_0x01dc:
            if (r7 == 0) goto L_0x01e0
            java.lang.String r8 = "File upload failed."
        L_0x01e0:
            r11 = r8
            com.memes.network.core.UniversalResult r2 = new com.memes.network.core.UniversalResult
            int r10 = r1.code()
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 28
            r16 = 0
            r9 = r2
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.network.chat.source.remote.RemoteChatDataSource.uploadPhotoFile(java.lang.String, java.lang.String, java.io.File, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
