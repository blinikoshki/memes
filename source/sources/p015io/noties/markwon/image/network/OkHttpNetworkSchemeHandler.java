package p015io.noties.markwon.image.network;

import android.net.Uri;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import p015io.noties.markwon.image.ImageItem;
import p015io.noties.markwon.image.SchemeHandler;

/* renamed from: io.noties.markwon.image.network.OkHttpNetworkSchemeHandler */
public class OkHttpNetworkSchemeHandler extends SchemeHandler {
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private final Call.Factory factory;

    public static OkHttpNetworkSchemeHandler create() {
        return create(new OkHttpClient());
    }

    public static OkHttpNetworkSchemeHandler create(OkHttpClient okHttpClient) {
        return create((Call.Factory) okHttpClient);
    }

    public static OkHttpNetworkSchemeHandler create(Call.Factory factory2) {
        return new OkHttpNetworkSchemeHandler(factory2);
    }

    OkHttpNetworkSchemeHandler(Call.Factory factory2) {
        this.factory = factory2;
    }

    public ImageItem handle(String str, Uri uri) {
        try {
            Response execute = this.factory.newCall(new Request.Builder().url(str).tag(str).build()).execute();
            if (execute != null) {
                ResponseBody body = execute.body();
                InputStream byteStream = body != null ? body.byteStream() : null;
                if (byteStream != null) {
                    return ImageItem.withDecodingNeeded(NetworkSchemeHandler.contentType(execute.header("Content-Type")), byteStream);
                }
                throw new IllegalStateException("Response does not contain body: " + str);
            }
            throw new IllegalStateException("Could not obtain network response: " + str);
        } catch (Throwable th) {
            throw new IllegalStateException("Exception obtaining network resource: " + str, th);
        }
    }

    public Collection<String> supportedSchemes() {
        return Arrays.asList(new String[]{"http", "https"});
    }
}
