package com.memes.network.chat.source;

import com.memes.network.chat.api.ChatDataSource;
import com.memes.network.chat.source.remote.model.signin.ChatSignInRequest;
import com.memes.network.chat.source.remote.model.signin.ChatTokenResponse;
import com.memes.network.core.UniversalResult;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ/\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/network/chat/source/ChatRepository;", "Lcom/memes/network/chat/api/ChatDataSource;", "dataSource", "(Lcom/memes/network/chat/api/ChatDataSource;)V", "createChatToken", "Lcom/memes/network/core/UniversalResult;", "Lcom/memes/network/chat/source/remote/model/signin/ChatTokenResponse;", "request", "Lcom/memes/network/chat/source/remote/model/signin/ChatSignInRequest;", "(Lcom/memes/network/chat/source/remote/model/signin/ChatSignInRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadPhotoFile", "", "userId", "userToken", "file", "Ljava/io/File;", "(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChatRepository.kt */
public final class ChatRepository implements ChatDataSource {
    /* access modifiers changed from: private */
    public final ChatDataSource dataSource;

    public ChatRepository(ChatDataSource chatDataSource) {
        Intrinsics.checkNotNullParameter(chatDataSource, "dataSource");
        this.dataSource = chatDataSource;
    }

    public Object createChatToken(ChatSignInRequest chatSignInRequest, Continuation<? super UniversalResult<ChatTokenResponse>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ChatRepository$createChatToken$2(this, chatSignInRequest, (Continuation) null), continuation);
    }

    public Object uploadPhotoFile(String str, String str2, File file, Continuation<? super UniversalResult<String>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ChatRepository$uploadPhotoFile$2(this, str, str2, file, (Continuation) null), continuation);
    }
}
