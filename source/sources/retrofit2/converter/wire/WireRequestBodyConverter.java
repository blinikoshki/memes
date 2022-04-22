package retrofit2.converter.wire;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import retrofit2.Converter;

final class WireRequestBodyConverter<T extends Message<T, ?>> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/x-protobuf");
    private final ProtoAdapter<T> adapter;

    WireRequestBodyConverter(ProtoAdapter<T> protoAdapter) {
        this.adapter = protoAdapter;
    }

    public RequestBody convert(T t) throws IOException {
        Buffer buffer = new Buffer();
        this.adapter.encode((BufferedSink) buffer, t);
        return RequestBody.create(MEDIA_TYPE, buffer.snapshot());
    }
}
