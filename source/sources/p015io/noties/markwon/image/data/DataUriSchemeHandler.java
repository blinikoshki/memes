package p015io.noties.markwon.image.data;

import android.net.Uri;
import java.io.ByteArrayInputStream;
import java.util.Collection;
import java.util.Collections;
import p015io.noties.markwon.image.ImageItem;
import p015io.noties.markwon.image.SchemeHandler;

/* renamed from: io.noties.markwon.image.data.DataUriSchemeHandler */
public class DataUriSchemeHandler extends SchemeHandler {
    public static final String SCHEME = "data";
    private static final String START = "data:";
    private final DataUriDecoder uriDecoder;
    private final DataUriParser uriParser;

    public static DataUriSchemeHandler create() {
        return new DataUriSchemeHandler(DataUriParser.create(), DataUriDecoder.create());
    }

    DataUriSchemeHandler(DataUriParser dataUriParser, DataUriDecoder dataUriDecoder) {
        this.uriParser = dataUriParser;
        this.uriDecoder = dataUriDecoder;
    }

    public ImageItem handle(String str, Uri uri) {
        if (str.startsWith(START)) {
            DataUri parse = this.uriParser.parse(str.substring(5));
            if (parse != null) {
                try {
                    byte[] decode = this.uriDecoder.decode(parse);
                    if (decode != null) {
                        return ImageItem.withDecodingNeeded(parse.contentType(), new ByteArrayInputStream(decode));
                    }
                    throw new IllegalStateException("Decoding data-uri failed: " + str);
                } catch (Throwable th) {
                    throw new IllegalStateException("Cannot decode data-uri: " + str, th);
                }
            } else {
                throw new IllegalStateException("Invalid data-uri: " + str);
            }
        } else {
            throw new IllegalStateException("Invalid data-uri: " + str);
        }
    }

    public Collection<String> supportedSchemes() {
        return Collections.singleton("data");
    }
}
