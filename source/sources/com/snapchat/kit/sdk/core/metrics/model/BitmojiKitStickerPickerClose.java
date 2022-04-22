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

public final class BitmojiKitStickerPickerClose extends Message<BitmojiKitStickerPickerClose, Builder> {
    public static final ProtoAdapter<BitmojiKitStickerPickerClose> ADAPTER = new ProtoAdapter_BitmojiKitStickerPickerClose();
    public static final Long DEFAULT_STICKER_PICKER_SESSION_DURATION_MILLIS = 0L;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.snapchat.kit.sdk.core.metrics.model.BitmojiKitEventBase#ADAPTER", tag = 1)
    public final BitmojiKitEventBase bitmoji_kit_event_base;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", tag = 2)
    public final Long sticker_picker_session_duration_millis;

    public BitmojiKitStickerPickerClose(BitmojiKitEventBase bitmojiKitEventBase, Long l) {
        this(bitmojiKitEventBase, l, ByteString.EMPTY);
    }

    public BitmojiKitStickerPickerClose(BitmojiKitEventBase bitmojiKitEventBase, Long l, ByteString byteString) {
        super(ADAPTER, byteString);
        this.bitmoji_kit_event_base = bitmojiKitEventBase;
        this.sticker_picker_session_duration_millis = l;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.bitmoji_kit_event_base = this.bitmoji_kit_event_base;
        builder.sticker_picker_session_duration_millis = this.sticker_picker_session_duration_millis;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BitmojiKitStickerPickerClose)) {
            return false;
        }
        BitmojiKitStickerPickerClose bitmojiKitStickerPickerClose = (BitmojiKitStickerPickerClose) obj;
        return unknownFields().equals(bitmojiKitStickerPickerClose.unknownFields()) && Internal.equals(this.bitmoji_kit_event_base, bitmojiKitStickerPickerClose.bitmoji_kit_event_base) && Internal.equals(this.sticker_picker_session_duration_millis, bitmojiKitStickerPickerClose.sticker_picker_session_duration_millis);
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
        Long l = this.sticker_picker_session_duration_millis;
        if (l != null) {
            i2 = l.hashCode();
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
        if (this.sticker_picker_session_duration_millis != null) {
            sb.append(", sticker_picker_session_duration_millis=");
            sb.append(this.sticker_picker_session_duration_millis);
        }
        StringBuilder replace = sb.replace(0, 2, "BitmojiKitStickerPickerClose{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<BitmojiKitStickerPickerClose, Builder> {
        public BitmojiKitEventBase bitmoji_kit_event_base;
        public Long sticker_picker_session_duration_millis;

        public final Builder bitmoji_kit_event_base(BitmojiKitEventBase bitmojiKitEventBase) {
            this.bitmoji_kit_event_base = bitmojiKitEventBase;
            return this;
        }

        public final Builder sticker_picker_session_duration_millis(Long l) {
            this.sticker_picker_session_duration_millis = l;
            return this;
        }

        public final BitmojiKitStickerPickerClose build() {
            return new BitmojiKitStickerPickerClose(this.bitmoji_kit_event_base, this.sticker_picker_session_duration_millis, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_BitmojiKitStickerPickerClose extends ProtoAdapter<BitmojiKitStickerPickerClose> {
        public ProtoAdapter_BitmojiKitStickerPickerClose() {
            super(FieldEncoding.LENGTH_DELIMITED, BitmojiKitStickerPickerClose.class);
        }

        public final int encodedSize(BitmojiKitStickerPickerClose bitmojiKitStickerPickerClose) {
            return BitmojiKitEventBase.ADAPTER.encodedSizeWithTag(1, bitmojiKitStickerPickerClose.bitmoji_kit_event_base) + ProtoAdapter.UINT64.encodedSizeWithTag(2, bitmojiKitStickerPickerClose.sticker_picker_session_duration_millis) + bitmojiKitStickerPickerClose.unknownFields().size();
        }

        public final void encode(ProtoWriter protoWriter, BitmojiKitStickerPickerClose bitmojiKitStickerPickerClose) throws IOException {
            BitmojiKitEventBase.ADAPTER.encodeWithTag(protoWriter, 1, bitmojiKitStickerPickerClose.bitmoji_kit_event_base);
            ProtoAdapter.UINT64.encodeWithTag(protoWriter, 2, bitmojiKitStickerPickerClose.sticker_picker_session_duration_millis);
            protoWriter.writeBytes(bitmojiKitStickerPickerClose.unknownFields());
        }

        public final BitmojiKitStickerPickerClose decode(ProtoReader protoReader) throws IOException {
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
                    builder.sticker_picker_session_duration_millis(ProtoAdapter.UINT64.decode(protoReader));
                }
            }
        }

        public final BitmojiKitStickerPickerClose redact(BitmojiKitStickerPickerClose bitmojiKitStickerPickerClose) {
            Builder newBuilder = bitmojiKitStickerPickerClose.newBuilder();
            if (newBuilder.bitmoji_kit_event_base != null) {
                newBuilder.bitmoji_kit_event_base = BitmojiKitEventBase.ADAPTER.redact(newBuilder.bitmoji_kit_event_base);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
