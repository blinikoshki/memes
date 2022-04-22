package com.memes.chat.util.usecases;

import com.memes.chat.util.extensions.ChatErrorExtKt;
import com.memes.network.chat.source.remote.model.signin.ChatSignInRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.models.ConnectionData;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.Result;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u001b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ#\u0010\n\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/chat/util/usecases/ChatSignInUseCase;", "", "chatClient", "Lio/getstream/chat/android/client/ChatClient;", "(Lio/getstream/chat/android/client/ChatClient;)V", "execute", "Lcom/memes/chat/util/usecases/ChatSignInUseCase$Response;", "request", "Lcom/memes/network/chat/source/remote/model/signin/ChatSignInRequest;", "(Lcom/memes/network/chat/source/remote/model/signin/ChatSignInRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signIn", "", "Lio/getstream/chat/android/client/models/User;", "chatUser", "chatToken", "(Lio/getstream/chat/android/client/models/User;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Response", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChatSignInUseCase.kt */
public final class ChatSignInUseCase {
    private final ChatClient chatClient;

    public ChatSignInUseCase(ChatClient chatClient2) {
        Intrinsics.checkNotNullParameter(chatClient2, "chatClient");
        this.chatClient = chatClient2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo26107d2 = {"Lcom/memes/chat/util/usecases/ChatSignInUseCase$Response;", "", "chatUser", "Lio/getstream/chat/android/client/models/User;", "chatToken", "", "(Lio/getstream/chat/android/client/models/User;Ljava/lang/String;)V", "getChatToken", "()Ljava/lang/String;", "getChatUser", "()Lio/getstream/chat/android/client/models/User;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChatSignInUseCase.kt */
    public static final class Response {
        private final String chatToken;
        private final User chatUser;

        public static /* synthetic */ Response copy$default(Response response, User user, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                user = response.chatUser;
            }
            if ((i & 2) != 0) {
                str = response.chatToken;
            }
            return response.copy(user, str);
        }

        public final User component1() {
            return this.chatUser;
        }

        public final String component2() {
            return this.chatToken;
        }

        public final Response copy(User user, String str) {
            Intrinsics.checkNotNullParameter(user, "chatUser");
            Intrinsics.checkNotNullParameter(str, "chatToken");
            return new Response(user, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Response)) {
                return false;
            }
            Response response = (Response) obj;
            return Intrinsics.areEqual((Object) this.chatUser, (Object) response.chatUser) && Intrinsics.areEqual((Object) this.chatToken, (Object) response.chatToken);
        }

        public int hashCode() {
            User user = this.chatUser;
            int i = 0;
            int hashCode = (user != null ? user.hashCode() : 0) * 31;
            String str = this.chatToken;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "Response(chatUser=" + this.chatUser + ", chatToken=" + this.chatToken + ")";
        }

        public Response(User user, String str) {
            Intrinsics.checkNotNullParameter(user, "chatUser");
            Intrinsics.checkNotNullParameter(str, "chatToken");
            this.chatUser = user;
            this.chatToken = str;
        }

        public final User getChatUser() {
            return this.chatUser;
        }

        public final String getChatToken() {
            return this.chatToken;
        }
    }

    public final Object execute(ChatSignInRequest chatSignInRequest, Continuation<? super Response> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ChatSignInUseCase$execute$2(this, chatSignInRequest, (Continuation) null), continuation);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0075 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object signIn(com.memes.network.chat.source.remote.model.signin.ChatSignInRequest r5, kotlin.coroutines.Continuation<? super java.lang.String> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.memes.chat.util.usecases.ChatSignInUseCase$signIn$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.memes.chat.util.usecases.ChatSignInUseCase$signIn$1 r0 = (com.memes.chat.util.usecases.ChatSignInUseCase$signIn$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.memes.chat.util.usecases.ChatSignInUseCase$signIn$1 r0 = new com.memes.chat.util.usecases.ChatSignInUseCase$signIn$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x005c
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.String r6 = r5.getUserId()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = kotlin.text.StringsKt.isBlank(r6)
            if (r6 != 0) goto L_0x0095
            java.lang.String r6 = r5.getUserToken()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = kotlin.text.StringsKt.isBlank(r6)
            if (r6 != 0) goto L_0x008b
            com.memes.network.NetworkProxy r6 = com.memes.network.NetworkProxy.INSTANCE
            com.memes.network.chat.api.ChatDataSource r6 = r6.fromChat()
            r0.label = r3
            java.lang.Object r6 = r6.createChatToken(r5, r0)
            if (r6 != r1) goto L_0x005c
            return r1
        L_0x005c:
            com.memes.network.core.UniversalResult r6 = (com.memes.network.core.UniversalResult) r6
            boolean r5 = r6.isError()
            r0 = 0
            if (r5 == 0) goto L_0x0066
            return r0
        L_0x0066:
            java.lang.Object r5 = r6.getItem()
            com.memes.network.chat.source.remote.model.signin.ChatTokenResponse r5 = (com.memes.network.chat.source.remote.model.signin.ChatTokenResponse) r5
            if (r5 != 0) goto L_0x006f
            return r0
        L_0x006f:
            boolean r6 = r5.isError()
            if (r6 == 0) goto L_0x0076
            return r0
        L_0x0076:
            java.lang.String r5 = r5.getToken()
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L_0x0087
            boolean r6 = kotlin.text.StringsKt.isBlank(r6)
            if (r6 == 0) goto L_0x0086
            goto L_0x0087
        L_0x0086:
            r3 = 0
        L_0x0087:
            if (r3 == 0) goto L_0x008a
            return r0
        L_0x008a:
            return r5
        L_0x008b:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.String r6 = "Invalid User Token"
            r5.<init>(r6)
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            throw r5
        L_0x0095:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.String r6 = "Invalid User ID"
            r5.<init>(r6)
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.chat.util.usecases.ChatSignInUseCase.signIn(com.memes.network.chat.source.remote.model.signin.ChatSignInRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object signIn(User user, String str, Continuation<? super User> continuation) {
        Result<ConnectionData> execute = this.chatClient.connectUser(user, str).execute();
        if (execute.isSuccess()) {
            ConnectionData data = execute.data();
            Timber.m306i("Connection (" + data.getConnectionId() + ") established for user " + data.getUser(), new Object[0]);
            return data.getUser();
        }
        Timber.m303e(ChatErrorExtKt.displayableMessage(execute.error()), new Object[0]);
        return null;
    }
}
