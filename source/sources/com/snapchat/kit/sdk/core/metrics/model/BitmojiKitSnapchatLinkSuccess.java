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

public final class BitmojiKitSnapchatLinkSuccess extends Message<BitmojiKitSnapchatLinkSuccess, Builder> {
    public static final ProtoAdapter<BitmojiKitSnapchatLinkSuccess> ADAPTER = new ProtoAdapter_BitmojiKitSnapchatLinkSuccess();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.snapchat.kit.sdk.core.metrics.model.BitmojiKitEventBase#ADAPTER", tag = 1)
    public final BitmojiKitEventBase bitmoji_kit_event_base;

    public BitmojiKitSnapchatLinkSuccess(BitmojiKitEventBase bitmojiKitEventBase) {
        this(bitmojiKitEventBase, ByteString.EMPTY);
    }

    public BitmojiKitSnapchatLinkSuccess(BitmojiKitEventBase bitmojiKitEventBase, ByteString byteString) {
        super(ADAPTER, byteString);
        this.bitmoji_kit_event_base = bitmojiKitEventBase;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.bitmoji_kit_event_base = this.bitmoji_kit_event_base;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BitmojiKitSnapchatLinkSuccess)) {
            return false;
        }
        BitmojiKitSnapchatLinkSuccess bitmojiKitSnapchatLinkSuccess = (BitmojiKitSnapchatLinkSuccess) obj;
        return unknownFields().equals(bitmojiKitSnapchatLinkSuccess.unknownFields()) && Internal.equals(this.bitmoji_kit_event_base, bitmojiKitSnapchatLinkSuccess.bitmoji_kit_event_base);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        BitmojiKitEventBase bitmojiKitEventBase = this.bitmoji_kit_event_base;
        int hashCode2 = hashCode + (bitmojiKitEventBase != null ? bitmojiKitEventBase.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.bitmoji_kit_event_base != null) {
            sb.append(", bitmoji_kit_event_base=");
            sb.append(this.bitmoji_kit_event_base);
        }
        StringBuilder replace = sb.replace(0, 2, "BitmojiKitSnapchatLinkSuccess{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<BitmojiKitSnapchatLinkSuccess, Builder> {
        public BitmojiKitEventBase bitmoji_kit_event_base;

        public final Builder bitmoji_kit_event_base(BitmojiKitEventBase bitmojiKitEventBase) {
            this.bitmoji_kit_event_base = bitmojiKitEventBase;
            return this;
        }

        public final BitmojiKitSnapchatLinkSuccess build() {
            return new BitmojiKitSnapchatLinkSuccess(this.bitmoji_kit_event_base, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_BitmojiKitSnapchatLinkSuccess extends ProtoAdapter<BitmojiKitSnapchatLinkSuccess> {
        public ProtoAdapter_BitmojiKitSnapchatLinkSuccess() {
            super(FieldEncoding.LENGTH_DELIMITED, BitmojiKitSnapchatLinkSuccess.class);
        }

        public final int encodedSize(BitmojiKitSnapchatLinkSuccess bitmojiKitSnapchatLinkSuccess) {
            return BitmojiKitEventBase.ADAPTER.encodedSizeWithTag(1, bitmojiKitSnapchatLinkSuccess.bitmoji_kit_event_base) + bitmojiKitSnapchatLinkSuccess.unknownFields().size();
        }

        public final void encode(ProtoWriter protoWriter, BitmojiKitSnapchatLinkSuccess bitmojiKitSnapchatLinkSuccess) throws IOException {
            BitmojiKitEventBase.ADAPTER.encodeWithTag(protoWriter, 1, bitmojiKitSnapchatLinkSuccess.bitmoji_kit_event_base);
            protoWriter.writeBytes(bitmojiKitSnapchatLinkSuccess.unknownFields());
        }

        public final BitmojiKitSnapchatLinkSuccess decode(ProtoReader protoReader) throws IOException {
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
                    builder.bitmoji_kit_event_base(BitmojiKitEventBase.ADAPTER.decode(protoReader));
                }
            }
        }

        public final BitmojiKitSnapchatLinkSuccess redact(BitmojiKitSnapchatLinkSuccess bitmojiKitSnapchatLinkSuccess) {
            Builder newBuilder = bitmojiKitSnapchatLinkSuccess.newBuilder();
            if (newBuilder.bitmoji_kit_event_base != null) {
                newBuilder.bitmoji_kit_event_base = BitmojiKitEventBase.ADAPTER.redact(newBuilder.bitmoji_kit_event_base);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
