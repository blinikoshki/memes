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

public final class CreativeKitEventBase extends Message<CreativeKitEventBase, Builder> {
    public static final ProtoAdapter<CreativeKitEventBase> ADAPTER = new ProtoAdapter_CreativeKitEventBase();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.snapchat.kit.sdk.core.metrics.model.KitEventBase#ADAPTER", tag = 1)
    public final KitEventBase kit_event_base;

    public CreativeKitEventBase(KitEventBase kitEventBase) {
        this(kitEventBase, ByteString.EMPTY);
    }

    public CreativeKitEventBase(KitEventBase kitEventBase, ByteString byteString) {
        super(ADAPTER, byteString);
        this.kit_event_base = kitEventBase;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.kit_event_base = this.kit_event_base;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreativeKitEventBase)) {
            return false;
        }
        CreativeKitEventBase creativeKitEventBase = (CreativeKitEventBase) obj;
        return unknownFields().equals(creativeKitEventBase.unknownFields()) && Internal.equals(this.kit_event_base, creativeKitEventBase.kit_event_base);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        KitEventBase kitEventBase = this.kit_event_base;
        int hashCode2 = hashCode + (kitEventBase != null ? kitEventBase.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.kit_event_base != null) {
            sb.append(", kit_event_base=");
            sb.append(this.kit_event_base);
        }
        StringBuilder replace = sb.replace(0, 2, "CreativeKitEventBase{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<CreativeKitEventBase, Builder> {
        public KitEventBase kit_event_base;

        public final Builder kit_event_base(KitEventBase kitEventBase) {
            this.kit_event_base = kitEventBase;
            return this;
        }

        public final CreativeKitEventBase build() {
            return new CreativeKitEventBase(this.kit_event_base, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_CreativeKitEventBase extends ProtoAdapter<CreativeKitEventBase> {
        public ProtoAdapter_CreativeKitEventBase() {
            super(FieldEncoding.LENGTH_DELIMITED, CreativeKitEventBase.class);
        }

        public final int encodedSize(CreativeKitEventBase creativeKitEventBase) {
            return KitEventBase.ADAPTER.encodedSizeWithTag(1, creativeKitEventBase.kit_event_base) + creativeKitEventBase.unknownFields().size();
        }

        public final void encode(ProtoWriter protoWriter, CreativeKitEventBase creativeKitEventBase) throws IOException {
            KitEventBase.ADAPTER.encodeWithTag(protoWriter, 1, creativeKitEventBase.kit_event_base);
            protoWriter.writeBytes(creativeKitEventBase.unknownFields());
        }

        public final CreativeKitEventBase decode(ProtoReader protoReader) throws IOException {
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
                    builder.kit_event_base(KitEventBase.ADAPTER.decode(protoReader));
                }
            }
        }

        public final CreativeKitEventBase redact(CreativeKitEventBase creativeKitEventBase) {
            Builder newBuilder = creativeKitEventBase.newBuilder();
            if (newBuilder.kit_event_base != null) {
                newBuilder.kit_event_base = KitEventBase.ADAPTER.redact(newBuilder.kit_event_base);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
