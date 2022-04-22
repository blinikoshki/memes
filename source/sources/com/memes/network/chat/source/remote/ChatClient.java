package com.memes.network.chat.source.remote;

import com.memes.network.chat.source.remote.model.fileupload.GenerateUploadUrlRequest;
import com.memes.network.chat.source.remote.model.fileupload.GenerateUploadUrlResult;
import com.memes.network.chat.source.remote.model.jwt.JwtRequest;
import com.memes.network.chat.source.remote.model.jwt.JwtResult;
import com.memes.network.chat.source.remote.model.signin.ChatSignInRequest;
import com.memes.network.chat.source.remote.model.signin.ChatTokenResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Url;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0002\u0010\rJ5\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0011H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J+\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0015H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, mo26107d2 = {"Lcom/memes/network/chat/source/remote/ChatClient;", "", "createJwt", "Lretrofit2/Response;", "Lcom/memes/network/chat/source/remote/model/jwt/JwtResult;", "url", "", "request", "Lcom/memes/network/chat/source/remote/model/jwt/JwtRequest;", "(Ljava/lang/String;Lcom/memes/network/chat/source/remote/model/jwt/JwtRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createToken", "Lcom/memes/network/chat/source/remote/model/signin/ChatTokenResponse;", "Lcom/memes/network/chat/source/remote/model/signin/ChatSignInRequest;", "(Lcom/memes/network/chat/source/remote/model/signin/ChatSignInRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createUploadUrl", "Lcom/memes/network/chat/source/remote/model/fileupload/GenerateUploadUrlResult;", "token", "Lcom/memes/network/chat/source/remote/model/fileupload/GenerateUploadUrlRequest;", "(Ljava/lang/String;Ljava/lang/String;Lcom/memes/network/chat/source/remote/model/fileupload/GenerateUploadUrlRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadFileToUrl", "Lokhttp3/ResponseBody;", "Lokhttp3/RequestBody;", "(Ljava/lang/String;Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChatClient.kt */
public interface ChatClient {
    @POST
    Object createJwt(@Url String str, @Body JwtRequest jwtRequest, Continuation<? super Response<JwtResult>> continuation);

    @POST("api/stream/token")
    Object createToken(@Body ChatSignInRequest chatSignInRequest, Continuation<? super Response<ChatTokenResponse>> continuation);

    @POST
    Object createUploadUrl(@Header("Authorization") String str, @Url String str2, @Body GenerateUploadUrlRequest generateUploadUrlRequest, Continuation<? super Response<GenerateUploadUrlResult>> continuation);

    @PUT
    Object uploadFileToUrl(@Url String str, @Body RequestBody requestBody, Continuation<? super Response<ResponseBody>> continuation);
}
