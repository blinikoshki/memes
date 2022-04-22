package p015io.noties.markwon.image.data;

import android.text.TextUtils;
import android.util.Base64;

/* renamed from: io.noties.markwon.image.data.DataUriDecoder */
public abstract class DataUriDecoder {
    public abstract byte[] decode(DataUri dataUri) throws Throwable;

    public static DataUriDecoder create() {
        return new Impl();
    }

    /* renamed from: io.noties.markwon.image.data.DataUriDecoder$Impl */
    static class Impl extends DataUriDecoder {
        private static final String CHARSET = "UTF-8";

        Impl() {
        }

        public byte[] decode(DataUri dataUri) throws Throwable {
            String data = dataUri.data();
            if (TextUtils.isEmpty(data)) {
                return null;
            }
            if (dataUri.base64()) {
                return Base64.decode(data.getBytes("UTF-8"), 0);
            }
            return data.getBytes("UTF-8");
        }
    }
}
