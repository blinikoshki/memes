package com.memes.network.chat.api;

import com.memes.network.chat.source.remote.model.signin.ChatSignInRequest;
import com.memes.network.chat.source.remote.model.signin.ChatTokenResponse;
import com.memes.network.core.UniversalResult;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J/\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, mo26107d2 = {"Lcom/memes/network/chat/api/ChatDataSource;", "", "createChatToken", "Lcom/memes/network/core/UniversalResult;", "Lcom/memes/network/chat/source/remote/model/signin/ChatTokenResponse;", "request", "Lcom/memes/network/chat/source/remote/model/signin/ChatSignInRequest;", "(Lcom/memes/network/chat/source/remote/model/signin/ChatSignInRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadPhotoFile", "", "userId", "userToken", "file", "Ljava/io/File;", "(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChatDataSource.kt */
public interface ChatDataSource {
    Object createChatToken(ChatSignInRequest chatSignInRequest, Continuation<? super UniversalResult<ChatTokenResponse>> continuation);

    Object uploadPhotoFile(String str, String str2, File file, Continuation<? super UniversalResult<String>> continuation);
}
