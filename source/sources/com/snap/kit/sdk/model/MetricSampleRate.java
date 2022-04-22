package com.snap.kit.sdk.model;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class MetricSampleRate extends Message<MetricSampleRate, Builder> {
    public static final ProtoAdapter<MetricSampleRate> ADAPTER = new ProtoAdapter_MetricSampleRate();
    public static final Double DEFAULT_RATE = Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 1)
    public final Double rate;

    public MetricSampleRate(Double d) {
        this(d, ByteString.EMPTY);
    }

    public MetricSampleRate(Double d, ByteString byteString) {
        super(ADAPTER, byteString);
        this.rate = d;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.rate = this.rate;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MetricSampleRate)) {
            return false;
        }
        MetricSampleRate metricSampleRate = (MetricSampleRate) obj;
        return unknownFields().equals(metricSampleRate.unknownFields()) && Internal.equals(this.rate, metricSampleRate.rate);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Double d = this.rate;
        int hashCode2 = hashCode + (d != null ? d.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.rate != null) {
            sb.append(", rate=");
            sb.append(this.rate);
        }
        StringBuilder replace = sb.replace(0, 2, "MetricSampleRate{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<MetricSampleRate, Builder> {
        public Double rate;

        public final Builder rate(Double d) {
            this.rate = d;
            return this;
        }

        public final MetricSampleRate build() {
            return new MetricSampleRate(this.rate, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_MetricSampleRate extends ProtoAdapter<MetricSampleRate> {
        public ProtoAdapter_MetricSampleRate() {
            super(FieldEncoding.LENGTH_DELIMITED, MetricSampleRate.class);
        }

        public final int encodedSize(MetricSampleRate metricSampleRate) {
            return ProtoAdapter.DOUBLE.encodedSizeWithTag(1, metricSampleRate.rate) + metricSampleRate.unknownFields().size();
        }

        public final void encode(ProtoWriter protoWriter, MetricSampleRate metricSampleRate) throws IOException {
            ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 1, metricSampleRate.rate);
            protoWriter.writeBytes(metricSampleRate.unknownFields());
        }

        public final MetricSampleRate decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag != 1) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.rate(ProtoAdapter.DOUBLE.decode(protoReader));
                }
            }
        }

        public final MetricSampleRate redact(MetricSampleRate metricSampleRate) {
            Builder newBuilder = metricSampleRate.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
