package coil.network;

import com.appsflyer.internal.referrer.Payload;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, mo26107d2 = {"Lcoil/network/HttpException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "response", "Lokhttp3/Response;", "(Lokhttp3/Response;)V", "getResponse", "()Lokhttp3/Response;", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: HttpException.kt */
public final class HttpException extends RuntimeException {
    private final Response response;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpException(Response response2) {
        super("HTTP " + response2.code() + ": " + response2.message());
        Intrinsics.checkNotNullParameter(response2, Payload.RESPONSE);
        this.response = response2;
    }

    public final Response getResponse() {
        return this.response;
    }
}
