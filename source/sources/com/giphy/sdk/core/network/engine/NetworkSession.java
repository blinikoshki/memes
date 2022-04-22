package com.giphy.sdk.core.network.engine;

import android.net.Uri;
import com.giphy.sdk.core.network.api.GPHApiClient;
import com.giphy.sdk.core.threading.ApiTask;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001Jr\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\f0\u00142\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00162\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H&Jh\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\f0\u00142\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00162\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0016H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001a"}, mo26107d2 = {"Lcom/giphy/sdk/core/network/engine/NetworkSession;", "", "completionExecutor", "Ljava/util/concurrent/Executor;", "getCompletionExecutor", "()Ljava/util/concurrent/Executor;", "networkRequestExecutor", "Ljava/util/concurrent/ExecutorService;", "getNetworkRequestExecutor", "()Ljava/util/concurrent/ExecutorService;", "postStringConnection", "Lcom/giphy/sdk/core/threading/ApiTask;", "T", "serverUrl", "Landroid/net/Uri;", "path", "", "method", "Lcom/giphy/sdk/core/network/api/GPHApiClient$HTTPMethod;", "responseClass", "Ljava/lang/Class;", "queryStrings", "", "headers", "requestBody", "queryStringConnection", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: NetworkSession.kt */
public interface NetworkSession {
    Executor getCompletionExecutor();

    ExecutorService getNetworkRequestExecutor();

    <T> ApiTask<T> postStringConnection(Uri uri, String str, GPHApiClient.HTTPMethod hTTPMethod, Class<T> cls, Map<String, String> map, Map<String, String> map2, Object obj);

    <T> ApiTask<T> queryStringConnection(Uri uri, String str, GPHApiClient.HTTPMethod hTTPMethod, Class<T> cls, Map<String, String> map, Map<String, String> map2);
}
