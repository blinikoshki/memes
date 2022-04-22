package retrofit2.converter.wire;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

final class WireResponseBodyConverter<T extends Message<T, ?>> implements Converter<ResponseBody, T> {
    private final ProtoAdapter<T> adapter;

    WireResponseBodyConverter(ProtoAdapter<T> protoAdapter) {
        this.adapter = protoAdapter;
    }

    public T convert(ResponseBody responseBody) throws IOException {
        try {
            return (Message) this.adapter.decode(responseBody.source());
        } finally {
            responseBody.close();
        }
    }
}
