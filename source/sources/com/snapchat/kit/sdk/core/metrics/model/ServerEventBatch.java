package com.snapchat.kit.sdk.core.metrics.model;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

public final class ServerEventBatch extends Message<ServerEventBatch, Builder> {
    public static final ProtoAdapter<ServerEventBatch> ADAPTER = new ProtoAdapter_ServerEventBatch();
    public static final Long DEFAULT_MAX_SEQUENCE_ID_ON_INSTANCE = 0L;
    public static final Double DEFAULT_SERVER_UPLOAD_TS = Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", tag = 3)
    public final Long max_sequence_id_on_instance;
    @WireField(adapter = "com.snapchat.kit.sdk.core.metrics.model.ServerEvent#ADAPTER", label = WireField.Label.REPEATED, tag = 4)
    public final List<ServerEvent> server_events;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 1)
    public final Double server_upload_ts;

    public ServerEventBatch(Double d, Long l, List<ServerEvent> list) {
        this(d, l, list, ByteString.EMPTY);
    }

    public ServerEventBatch(Double d, Long l, List<ServerEvent> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.server_upload_ts = d;
        this.max_sequence_id_on_instance = l;
        this.server_events = Internal.immutableCopyOf("server_events", list);
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.server_upload_ts = this.server_upload_ts;
        builder.max_sequence_id_on_instance = this.max_sequence_id_on_instance;
        builder.server_events = Internal.copyOf("server_events", this.server_events);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ServerEventBatch)) {
            return false;
        }
        ServerEventBatch serverEventBatch = (ServerEventBatch) obj;
        return unknownFields().equals(serverEventBatch.unknownFields()) && Internal.equals(this.server_upload_ts, serverEventBatch.server_upload_ts) && Internal.equals(this.max_sequence_id_on_instance, serverEventBatch.max_sequence_id_on_instance) && this.server_events.equals(serverEventBatch.server_events);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Double d = this.server_upload_ts;
        int i2 = 0;
        int hashCode2 = (hashCode + (d != null ? d.hashCode() : 0)) * 37;
        Long l = this.max_sequence_id_on_instance;
        if (l != null) {
            i2 = l.hashCode();
        }
        int hashCode3 = ((hashCode2 + i2) * 37) + this.server_events.hashCode();
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.server_upload_ts != null) {
            sb.append(", server_upload_ts=");
            sb.append(this.server_upload_ts);
        }
        if (this.max_sequence_id_on_instance != null) {
            sb.append(", max_sequence_id_on_instance=");
            sb.append(this.max_sequence_id_on_instance);
        }
        if (!this.server_events.isEmpty()) {
            sb.append(", server_events=");
            sb.append(this.server_events);
        }
        StringBuilder replace = sb.replace(0, 2, "ServerEventBatch{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<ServerEventBatch, Builder> {
        public Long max_sequence_id_on_instance;
        public List<ServerEvent> server_events = Internal.newMutableList();
        public Double server_upload_ts;

        public final Builder server_upload_ts(Double d) {
            this.server_upload_ts = d;
            return this;
        }

        public final Builder max_sequence_id_on_instance(Long l) {
            this.max_sequence_id_on_instance = l;
            return this;
        }

        public final Builder server_events(List<ServerEvent> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.server_events = list;
            return this;
        }

        public final ServerEventBatch build() {
            return new ServerEventBatch(this.server_upload_ts, this.max_sequence_id_on_instance, this.server_events, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_ServerEventBatch extends ProtoAdapter<ServerEventBatch> {
        public ProtoAdapter_ServerEventBatch() {
            super(FieldEncoding.LENGTH_DELIMITED, ServerEventBatch.class);
        }

        public final int encodedSize(ServerEventBatch serverEventBatch) {
            return ProtoAdapter.DOUBLE.encodedSizeWithTag(1, serverEventBatch.server_upload_ts) + ProtoAdapter.UINT64.encodedSizeWithTag(3, serverEventBatch.max_sequence_id_on_instance) + ServerEvent.ADAPTER.asRepeated().encodedSizeWithTag(4, serverEventBatch.server_events) + serverEventBatch.unknownFields().size();
        }

        public final void encode(ProtoWriter protoWriter, ServerEventBatch serverEventBatch) throws IOException {
            ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 1, serverEventBatch.server_upload_ts);
            ProtoAdapter.UINT64.encodeWithTag(protoWriter, 3, serverEventBatch.max_sequence_id_on_instance);
            ServerEvent.ADAPTER.asRepeated().encodeWithTag(protoWriter, 4, serverEventBatch.server_events);
            protoWriter.writeBytes(serverEventBatch.unknownFields());
        }

        public final ServerEventBatch decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.server_upload_ts(ProtoAdapter.DOUBLE.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.max_sequence_id_on_instance(ProtoAdapter.UINT64.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.server_events.add(ServerEvent.ADAPTER.decode(protoReader));
                }
            }
        }

        public final ServerEventBatch redact(ServerEventBatch serverEventBatch) {
            Builder newBuilder = serverEventBatch.newBuilder();
            Internal.redactElements(newBuilder.server_events, ServerEvent.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
