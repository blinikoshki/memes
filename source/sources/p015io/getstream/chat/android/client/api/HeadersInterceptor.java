package p015io.getstream.chat.android.client.api;

import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;
import p015io.getstream.chat.android.client.ChatClient;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/HeadersInterceptor;", "Lokhttp3/Interceptor;", "isAnonymous", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.HeadersInterceptor */
/* compiled from: HeadersInterceptor.kt */
public final class HeadersInterceptor implements Interceptor {
    private final Function0<Boolean> isAnonymous;

    public HeadersInterceptor(Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "isAnonymous");
        this.isAnonymous = function0;
    }

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        return chain.proceed(chain.request().newBuilder().addHeader(HttpHeaders.CONTENT_TYPE, "application/json").addHeader("stream-auth-type", this.isAnonymous.invoke().booleanValue() ? "anonymous" : "jwt").addHeader(HttpHeaders.ACCEPT_ENCODING, "application/gzip").addHeader("X-STREAM-CLIENT", ChatClient.Companion.instance().getVersion()).addHeader(HttpHeaders.CACHE_CONTROL, "no-cache").build());
    }
}
