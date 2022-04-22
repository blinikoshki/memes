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

public final class BitmojiKitPreviewIconChange extends Message<BitmojiKitPreviewIconChange, Builder> {
    public static final ProtoAdapter<BitmojiKitPreviewIconChange> ADAPTER = new ProtoAdapter_BitmojiKitPreviewIconChange();
    public static final String DEFAULT_PREVIEW_STICKER_ID = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.snapchat.kit.sdk.core.metrics.model.BitmojiKitEventBase#ADAPTER", tag = 1)
    public final BitmojiKitEventBase bitmoji_kit_event_base;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String preview_sticker_id;

    public BitmojiKitPreviewIconChange(BitmojiKitEventBase bitmojiKitEventBase, String str) {
        this(bitmojiKitEventBase, str, ByteString.EMPTY);
    }

    public BitmojiKitPreviewIconChange(BitmojiKitEventBase bitmojiKitEventBase, String str, ByteString byteString) {
        super(ADAPTER, byteString);
        this.bitmoji_kit_event_base = bitmojiKitEventBase;
        this.preview_sticker_id = str;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.bitmoji_kit_event_base = this.bitmoji_kit_event_base;
        builder.preview_sticker_id = this.preview_sticker_id;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BitmojiKitPreviewIconChange)) {
            return false;
        }
        BitmojiKitPreviewIconChange bitmojiKitPreviewIconChange = (BitmojiKitPreviewIconChange) obj;
        return unknownFields().equals(bitmojiKitPreviewIconChange.unknownFields()) && Internal.equals(this.bitmoji_kit_event_base, bitmojiKitPreviewIconChange.bitmoji_kit_event_base) && Internal.equals(this.preview_sticker_id, bitmojiKitPreviewIconChange.preview_sticker_id);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        BitmojiKitEventBase bitmojiKitEventBase = this.bitmoji_kit_event_base;
        int i2 = 0;
        int hashCode2 = (hashCode + (bitmojiKitEventBase != null ? bitmojiKitEventBase.hashCode() : 0)) * 37;
        String str = this.preview_sticker_id;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.bitmoji_kit_event_base != null) {
            sb.append(", bitmoji_kit_event_base=");
            sb.append(this.bitmoji_kit_event_base);
        }
        if (this.preview_sticker_id != null) {
            sb.append(", preview_sticker_id=");
            sb.append(this.preview_sticker_id);
        }
        StringBuilder replace = sb.replace(0, 2, "BitmojiKitPreviewIconChange{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<BitmojiKitPreviewIconChange, Builder> {
        public BitmojiKitEventBase bitmoji_kit_event_base;
        public String preview_sticker_id;

        public final Builder bitmoji_kit_event_base(BitmojiKitEventBase bitmojiKitEventBase) {
            this.bitmoji_kit_event_base = bitmojiKitEventBase;
            return this;
        }

        public final Builder preview_sticker_id(String str) {
            this.preview_sticker_id = str;
            return this;
        }

        public final BitmojiKitPreviewIconChange build() {
            return new BitmojiKitPreviewIconChange(this.bitmoji_kit_event_base, this.preview_sticker_id, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_BitmojiKitPreviewIconChange extends ProtoAdapter<BitmojiKitPreviewIconChange> {
        public ProtoAdapter_BitmojiKitPreviewIconChange() {
            super(FieldEncoding.LENGTH_DELIMITED, BitmojiKitPreviewIconChange.class);
        }

        public final int encodedSize(BitmojiKitPreviewIconChange bitmojiKitPreviewIconChange) {
            return BitmojiKitEventBase.ADAPTER.encodedSizeWithTag(1, bitmojiKitPreviewIconChange.bitmoji_kit_event_base) + ProtoAdapter.STRING.encodedSizeWithTag(2, bitmojiKitPreviewIconChange.preview_sticker_id) + bitmojiKitPreviewIconChange.unknownFields().size();
        }

        public final void encode(ProtoWriter protoWriter, BitmojiKitPreviewIconChange bitmojiKitPreviewIconChange) throws IOException {
            BitmojiKitEventBase.ADAPTER.encodeWithTag(protoWriter, 1, bitmojiKitPreviewIconChange.bitmoji_kit_event_base);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, bitmojiKitPreviewIconChange.preview_sticker_id);
            protoWriter.writeBytes(bitmojiKitPreviewIconChange.unknownFields());
        }

        public final BitmojiKitPreviewIconChange decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.bitmoji_kit_event_base(BitmojiKitEventBase.ADAPTER.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.preview_sticker_id(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final BitmojiKitPreviewIconChange redact(BitmojiKitPreviewIconChange bitmojiKitPreviewIconChange) {
            Builder newBuilder = bitmojiKitPreviewIconChange.newBuilder();
            if (newBuilder.bitmoji_kit_event_base != null) {
                newBuilder.bitmoji_kit_event_base = BitmojiKitEventBase.ADAPTER.redact(newBuilder.bitmoji_kit_event_base);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
