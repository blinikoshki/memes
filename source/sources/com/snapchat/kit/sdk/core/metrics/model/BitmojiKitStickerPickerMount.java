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

public final class BitmojiKitStickerPickerMount extends Message<BitmojiKitStickerPickerMount, Builder> {
    public static final ProtoAdapter<BitmojiKitStickerPickerMount> ADAPTER = new ProtoAdapter_BitmojiKitStickerPickerMount();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.snapchat.kit.sdk.core.metrics.model.BitmojiKitEventBase#ADAPTER", tag = 1)
    public final BitmojiKitEventBase bitmoji_kit_event_base;

    public BitmojiKitStickerPickerMount(BitmojiKitEventBase bitmojiKitEventBase) {
        this(bitmojiKitEventBase, ByteString.EMPTY);
    }

    public BitmojiKitStickerPickerMount(BitmojiKitEventBase bitmojiKitEventBase, ByteString byteString) {
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
        if (!(obj instanceof BitmojiKitStickerPickerMount)) {
            return false;
        }
        BitmojiKitStickerPickerMount bitmojiKitStickerPickerMount = (BitmojiKitStickerPickerMount) obj;
        return unknownFields().equals(bitmojiKitStickerPickerMount.unknownFields()) && Internal.equals(this.bitmoji_kit_event_base, bitmojiKitStickerPickerMount.bitmoji_kit_event_base);
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
        StringBuilder replace = sb.replace(0, 2, "BitmojiKitStickerPickerMount{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<BitmojiKitStickerPickerMount, Builder> {
        public BitmojiKitEventBase bitmoji_kit_event_base;

        public final Builder bitmoji_kit_event_base(BitmojiKitEventBase bitmojiKitEventBase) {
            this.bitmoji_kit_event_base = bitmojiKitEventBase;
            return this;
        }

        public final BitmojiKitStickerPickerMount build() {
            return new BitmojiKitStickerPickerMount(this.bitmoji_kit_event_base, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_BitmojiKitStickerPickerMount extends ProtoAdapter<BitmojiKitStickerPickerMount> {
        public ProtoAdapter_BitmojiKitStickerPickerMount() {
            super(FieldEncoding.LENGTH_DELIMITED, BitmojiKitStickerPickerMount.class);
        }

        public final int encodedSize(BitmojiKitStickerPickerMount bitmojiKitStickerPickerMount) {
            return BitmojiKitEventBase.ADAPTER.encodedSizeWithTag(1, bitmojiKitStickerPickerMount.bitmoji_kit_event_base) + bitmojiKitStickerPickerMount.unknownFields().size();
        }

        public final void encode(ProtoWriter protoWriter, BitmojiKitStickerPickerMount bitmojiKitStickerPickerMount) throws IOException {
            BitmojiKitEventBase.ADAPTER.encodeWithTag(protoWriter, 1, bitmojiKitStickerPickerMount.bitmoji_kit_event_base);
            protoWriter.writeBytes(bitmojiKitStickerPickerMount.unknownFields());
        }

        public final BitmojiKitStickerPickerMount decode(ProtoReader protoReader) throws IOException {
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

        public final BitmojiKitStickerPickerMount redact(BitmojiKitStickerPickerMount bitmojiKitStickerPickerMount) {
            Builder newBuilder = bitmojiKitStickerPickerMount.newBuilder();
            if (newBuilder.bitmoji_kit_event_base != null) {
                newBuilder.bitmoji_kit_event_base = BitmojiKitEventBase.ADAPTER.redact(newBuilder.bitmoji_kit_event_base);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
