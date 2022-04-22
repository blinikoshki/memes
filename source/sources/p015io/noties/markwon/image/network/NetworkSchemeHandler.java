package p015io.noties.markwon.image.network;

import android.net.Uri;
import com.google.common.net.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import p015io.noties.markwon.image.ImageItem;
import p015io.noties.markwon.image.SchemeHandler;

/* renamed from: io.noties.markwon.image.network.NetworkSchemeHandler */
public class NetworkSchemeHandler extends SchemeHandler {
    public static final String SCHEME_HTTP = "http";
    public static final String SCHEME_HTTPS = "https";

    public static NetworkSchemeHandler create() {
        return new NetworkSchemeHandler();
    }

    NetworkSchemeHandler() {
    }

    public ImageItem handle(String str, Uri uri) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode >= 200 && responseCode < 300) {
                return ImageItem.withDecodingNeeded(contentType(httpURLConnection.getHeaderField(HttpHeaders.CONTENT_TYPE)), new BufferedInputStream(httpURLConnection.getInputStream()));
            }
            throw new IOException("Bad response code: " + responseCode + ", url: " + str);
        } catch (IOException e) {
            throw new IllegalStateException("Exception obtaining network resource: " + str, e);
        }
    }

    public Collection<String> supportedSchemes() {
        return Arrays.asList(new String[]{"http", "https"});
    }

    static String contentType(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(59);
        return indexOf > -1 ? str.substring(0, indexOf) : str;
    }
}
