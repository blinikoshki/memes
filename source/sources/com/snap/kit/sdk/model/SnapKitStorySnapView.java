package com.snap.kit.sdk.model;

import com.snapchat.kit.sdk.core.metrics.model.Timestamp;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class SnapKitStorySnapView extends Message<SnapKitStorySnapView, Builder> {
    public static final ProtoAdapter<SnapKitStorySnapView> ADAPTER = new ProtoAdapter_SnapKitStorySnapView();
    public static final String DEFAULT_OWNER_EXTERNAL_ID = "";
    public static final String DEFAULT_SNAP_ID = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.google.protobuf.Timestamp#ADAPTER", tag = 1)
    public final Timestamp client_timestamp;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String owner_external_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String snap_id;

    public SnapKitStorySnapView(Timestamp timestamp, String str, String str2) {
        this(timestamp, str, str2, ByteString.EMPTY);
    }

    public SnapKitStorySnapView(Timestamp timestamp, String str, String str2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.client_timestamp = timestamp;
        this.snap_id = str;
        this.owner_external_id = str2;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.client_timestamp = this.client_timestamp;
        builder.snap_id = this.snap_id;
        builder.owner_external_id = this.owner_external_id;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SnapKitStorySnapView)) {
            return false;
        }
        SnapKitStorySnapView snapKitStorySnapView = (SnapKitStorySnapView) obj;
        return unknownFields().equals(snapKitStorySnapView.unknownFields()) && Internal.equals(this.client_timestamp, snapKitStorySnapView.client_timestamp) && Internal.equals(this.snap_id, snapKitStorySnapView.snap_id) && Internal.equals(this.owner_external_id, snapKitStorySnapView.owner_external_id);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Timestamp timestamp = this.client_timestamp;
        int i2 = 0;
        int hashCode2 = (hashCode + (timestamp != null ? timestamp.hashCode() : 0)) * 37;
        String str = this.snap_id;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.owner_external_id;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.client_timestamp != null) {
            sb.append(", client_timestamp=");
            sb.append(this.client_timestamp);
        }
        if (this.snap_id != null) {
            sb.append(", snap_id=");
            sb.append(this.snap_id);
        }
        if (this.owner_external_id != null) {
            sb.append(", owner_external_id=");
            sb.append(this.owner_external_id);
        }
        StringBuilder replace = sb.replace(0, 2, "SnapKitStorySnapView{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<SnapKitStorySnapView, Builder> {
        public Timestamp client_timestamp;
        public String owner_external_id;
        public String snap_id;

        public final Builder client_timestamp(Timestamp timestamp) {
            this.client_timestamp = timestamp;
            return this;
        }

        public final Builder snap_id(String str) {
            this.snap_id = str;
            return this;
        }

        public final Builder owner_external_id(String str) {
            this.owner_external_id = str;
            return this;
        }

        public final SnapKitStorySnapView build() {
            return new SnapKitStorySnapView(this.client_timestamp, this.snap_id, this.owner_external_id, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_SnapKitStorySnapView extends ProtoAdapter<SnapKitStorySnapView> {
        public ProtoAdapter_SnapKitStorySnapView() {
            super(FieldEncoding.LENGTH_DELIMITED, SnapKitStorySnapView.class);
        }

        public final int encodedSize(SnapKitStorySnapView snapKitStorySnapView) {
            return Timestamp.ADAPTER.encodedSizeWithTag(1, snapKitStorySnapView.client_timestamp) + ProtoAdapter.STRING.encodedSizeWithTag(2, snapKitStorySnapView.snap_id) + ProtoAdapter.STRING.encodedSizeWithTag(3, snapKitStorySnapView.owner_external_id) + snapKitStorySnapView.unknownFields().size();
        }

        public final void encode(ProtoWriter protoWriter, SnapKitStorySnapView snapKitStorySnapView) throws IOException {
            Timestamp.ADAPTER.encodeWithTag(protoWriter, 1, snapKitStorySnapView.client_timestamp);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, snapKitStorySnapView.snap_id);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, snapKitStorySnapView.owner_external_id);
            protoWriter.writeBytes(snapKitStorySnapView.unknownFields());
        }

        public final SnapKitStorySnapView decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.client_timestamp(Timestamp.ADAPTER.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.snap_id(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.owner_external_id(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final SnapKitStorySnapView redact(SnapKitStorySnapView snapKitStorySnapView) {
            Builder newBuilder = snapKitStorySnapView.newBuilder();
            if (newBuilder.client_timestamp != null) {
                newBuilder.client_timestamp = Timestamp.ADAPTER.redact(newBuilder.client_timestamp);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
