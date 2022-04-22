package coil.fetch;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.HttpUrl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0002H\u0016J\f\u0010\u000b\u001a\u00020\f*\u00020\u0002H\u0016¨\u0006\r"}, mo26107d2 = {"Lcoil/fetch/HttpUriFetcher;", "Lcoil/fetch/HttpFetcher;", "Landroid/net/Uri;", "callFactory", "Lokhttp3/Call$Factory;", "(Lokhttp3/Call$Factory;)V", "handles", "", "data", "key", "", "toHttpUrl", "Lokhttp3/HttpUrl;", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: HttpFetcher.kt */
public final class HttpUriFetcher extends HttpFetcher<Uri> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpUriFetcher(Call.Factory factory) {
        super(factory);
        Intrinsics.checkNotNullParameter(factory, "callFactory");
    }

    public boolean handles(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "data");
        return Intrinsics.areEqual((Object) uri.getScheme(), (Object) "http") || Intrinsics.areEqual((Object) uri.getScheme(), (Object) "https");
    }

    public String key(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "data");
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "data.toString()");
        return uri2;
    }

    public HttpUrl toHttpUrl(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "$this$toHttpUrl");
        HttpUrl httpUrl = HttpUrl.get(uri.toString());
        Intrinsics.checkNotNullExpressionValue(httpUrl, "HttpUrl.get(toString())");
        return httpUrl;
    }
}
