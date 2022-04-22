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

public final class KitHeartbeat extends Message<KitHeartbeat, Builder> {
    public static final ProtoAdapter<KitHeartbeat> ADAPTER = new ProtoAdapter_KitHeartbeat();
    public static final String DEFAULT_INSTALLATION_ID = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String installation_id;
    @WireField(adapter = "com.snapchat.kit.sdk.core.metrics.model.KitEventBase#ADAPTER", tag = 1)
    public final KitEventBase kit_event_base;

    public KitHeartbeat(KitEventBase kitEventBase, String str) {
        this(kitEventBase, str, ByteString.EMPTY);
    }

    public KitHeartbeat(KitEventBase kitEventBase, String str, ByteString byteString) {
        super(ADAPTER, byteString);
        this.kit_event_base = kitEventBase;
        this.installation_id = str;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.kit_event_base = this.kit_event_base;
        builder.installation_id = this.installation_id;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof KitHeartbeat)) {
            return false;
        }
        KitHeartbeat kitHeartbeat = (KitHeartbeat) obj;
        return unknownFields().equals(kitHeartbeat.unknownFields()) && Internal.equals(this.kit_event_base, kitHeartbeat.kit_event_base) && Internal.equals(this.installation_id, kitHeartbeat.installation_id);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        KitEventBase kitEventBase = this.kit_event_base;
        int i2 = 0;
        int hashCode2 = (hashCode + (kitEventBase != null ? kitEventBase.hashCode() : 0)) * 37;
        String str = this.installation_id;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.kit_event_base != null) {
            sb.append(", kit_event_base=");
            sb.append(this.kit_event_base);
        }
        if (this.installation_id != null) {
            sb.append(", installation_id=");
            sb.append(this.installation_id);
        }
        StringBuilder replace = sb.replace(0, 2, "KitHeartbeat{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<KitHeartbeat, Builder> {
        public String installation_id;
        public KitEventBase kit_event_base;

        public final Builder kit_event_base(KitEventBase kitEventBase) {
            this.kit_event_base = kitEventBase;
            return this;
        }

        public final Builder installation_id(String str) {
            this.installation_id = str;
            return this;
        }

        public final KitHeartbeat build() {
            return new KitHeartbeat(this.kit_event_base, this.installation_id, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_KitHeartbeat extends ProtoAdapter<KitHeartbeat> {
        public ProtoAdapter_KitHeartbeat() {
            super(FieldEncoding.LENGTH_DELIMITED, KitHeartbeat.class);
        }

        public final int encodedSize(KitHeartbeat kitHeartbeat) {
            return KitEventBase.ADAPTER.encodedSizeWithTag(1, kitHeartbeat.kit_event_base) + ProtoAdapter.STRING.encodedSizeWithTag(2, kitHeartbeat.installation_id) + kitHeartbeat.unknownFields().size();
        }

        public final void encode(ProtoWriter protoWriter, KitHeartbeat kitHeartbeat) throws IOException {
            KitEventBase.ADAPTER.encodeWithTag(protoWriter, 1, kitHeartbeat.kit_event_base);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, kitHeartbeat.installation_id);
            protoWriter.writeBytes(kitHeartbeat.unknownFields());
        }

        public final KitHeartbeat decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.kit_event_base(KitEventBase.ADAPTER.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.installation_id(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final KitHeartbeat redact(KitHeartbeat kitHeartbeat) {
            Builder newBuilder = kitHeartbeat.newBuilder();
            if (newBuilder.kit_event_base != null) {
                newBuilder.kit_event_base = KitEventBase.ADAPTER.redact(newBuilder.kit_event_base);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
