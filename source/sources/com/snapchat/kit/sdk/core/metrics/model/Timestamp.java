package com.snapchat.kit.sdk.core.metrics.model;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class Timestamp extends Message<Timestamp, Builder> {
    public static final ProtoAdapter<Timestamp> ADAPTER = new ProtoAdapter_Timestamp();
    public static final Integer DEFAULT_NANOS = 0;
    public static final Long DEFAULT_SECONDS = 0L;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer nanos;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final Long seconds;

    public Timestamp(Long l, Integer num) {
        this(l, num, ByteString.EMPTY);
    }

    public Timestamp(Long l, Integer num, ByteString byteString) {
        super(ADAPTER, byteString);
        this.seconds = l;
        this.nanos = num;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.seconds = this.seconds;
        builder.nanos = this.nanos;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Timestamp)) {
            return false;
        }
        Timestamp timestamp = (Timestamp) obj;
        return unknownFields().equals(timestamp.unknownFields()) && Internal.equals(this.seconds, timestamp.seconds) && Internal.equals(this.nanos, timestamp.nanos);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Long l = this.seconds;
        int i2 = 0;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.nanos;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.seconds != null) {
            sb.append(", seconds=");
            sb.append(this.seconds);
        }
        if (this.nanos != null) {
            sb.append(", nanos=");
            sb.append(this.nanos);
        }
        StringBuilder replace = sb.replace(0, 2, "Timestamp{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<Timestamp, Builder> {
        public Integer nanos;
        public Long seconds;

        public final Builder seconds(Long l) {
            this.seconds = l;
            return this;
        }

        public final Builder nanos(Integer num) {
            this.nanos = num;
            return this;
        }

        public final Timestamp build() {
            return new Timestamp(this.seconds, this.nanos, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_Timestamp extends ProtoAdapter<Timestamp> {
        public ProtoAdapter_Timestamp() {
            super(FieldEncoding.LENGTH_DELIMITED, Timestamp.class);
        }

        public final int encodedSize(Timestamp timestamp) {
            return ProtoAdapter.INT64.encodedSizeWithTag(1, timestamp.seconds) + ProtoAdapter.INT32.encodedSizeWithTag(2, timestamp.nanos) + timestamp.unknownFields().size();
        }

        public final void encode(ProtoWriter protoWriter, Timestamp timestamp) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(protoWriter, 1, timestamp.seconds);
            ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, timestamp.nanos);
            protoWriter.writeBytes(timestamp.unknownFields());
        }

        public final Timestamp decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.seconds(ProtoAdapter.INT64.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.nanos(ProtoAdapter.INT32.decode(protoReader));
                }
            }
        }

        public final Timestamp redact(Timestamp timestamp) {
            Builder newBuilder = timestamp.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
