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

public final class BitmojiKitShare extends Message<BitmojiKitShare, Builder> {
    public static final ProtoAdapter<BitmojiKitShare> ADAPTER = new ProtoAdapter_BitmojiKitShare();
    public static final BitmojiKitSearchCategory DEFAULT_SEARCH_CATEGORY = BitmojiKitSearchCategory.UNKNOWN_BITMOJI_KIT_SEARCH_CATEGORY;
    public static final BitmojiKitShareCategory DEFAULT_SHARE_CATEGORY = BitmojiKitShareCategory.UNKNOWN_BITMOJI_KIT_SHARE_CATEGORY;
    public static final String DEFAULT_STICKER_ID = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.snapchat.kit.sdk.core.metrics.model.BitmojiKitEventBase#ADAPTER", tag = 1)
    public final BitmojiKitEventBase bitmoji_kit_event_base;
    @WireField(adapter = "com.snapchat.kit.sdk.core.metrics.model.BitmojiKitSearchCategory#ADAPTER", tag = 5)
    public final BitmojiKitSearchCategory search_category;
    @WireField(adapter = "com.snapchat.kit.sdk.core.metrics.model.BitmojiKitShareCategory#ADAPTER", tag = 4)
    public final BitmojiKitShareCategory share_category;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String sticker_id;

    public BitmojiKitShare(BitmojiKitEventBase bitmojiKitEventBase, String str, BitmojiKitShareCategory bitmojiKitShareCategory, BitmojiKitSearchCategory bitmojiKitSearchCategory) {
        this(bitmojiKitEventBase, str, bitmojiKitShareCategory, bitmojiKitSearchCategory, ByteString.EMPTY);
    }

    public BitmojiKitShare(BitmojiKitEventBase bitmojiKitEventBase, String str, BitmojiKitShareCategory bitmojiKitShareCategory, BitmojiKitSearchCategory bitmojiKitSearchCategory, ByteString byteString) {
        super(ADAPTER, byteString);
        this.bitmoji_kit_event_base = bitmojiKitEventBase;
        this.sticker_id = str;
        this.share_category = bitmojiKitShareCategory;
        this.search_category = bitmojiKitSearchCategory;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.bitmoji_kit_event_base = this.bitmoji_kit_event_base;
        builder.sticker_id = this.sticker_id;
        builder.share_category = this.share_category;
        builder.search_category = this.search_category;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BitmojiKitShare)) {
            return false;
        }
        BitmojiKitShare bitmojiKitShare = (BitmojiKitShare) obj;
        return unknownFields().equals(bitmojiKitShare.unknownFields()) && Internal.equals(this.bitmoji_kit_event_base, bitmojiKitShare.bitmoji_kit_event_base) && Internal.equals(this.sticker_id, bitmojiKitShare.sticker_id) && Internal.equals(this.share_category, bitmojiKitShare.share_category) && Internal.equals(this.search_category, bitmojiKitShare.search_category);
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
        String str = this.sticker_id;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        BitmojiKitShareCategory bitmojiKitShareCategory = this.share_category;
        int hashCode4 = (hashCode3 + (bitmojiKitShareCategory != null ? bitmojiKitShareCategory.hashCode() : 0)) * 37;
        BitmojiKitSearchCategory bitmojiKitSearchCategory = this.search_category;
        if (bitmojiKitSearchCategory != null) {
            i2 = bitmojiKitSearchCategory.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.bitmoji_kit_event_base != null) {
            sb.append(", bitmoji_kit_event_base=");
            sb.append(this.bitmoji_kit_event_base);
        }
        if (this.sticker_id != null) {
            sb.append(", sticker_id=");
            sb.append(this.sticker_id);
        }
        if (this.share_category != null) {
            sb.append(", share_category=");
            sb.append(this.share_category);
        }
        if (this.search_category != null) {
            sb.append(", search_category=");
            sb.append(this.search_category);
        }
        StringBuilder replace = sb.replace(0, 2, "BitmojiKitShare{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<BitmojiKitShare, Builder> {
        public BitmojiKitEventBase bitmoji_kit_event_base;
        public BitmojiKitSearchCategory search_category;
        public BitmojiKitShareCategory share_category;
        public String sticker_id;

        public final Builder bitmoji_kit_event_base(BitmojiKitEventBase bitmojiKitEventBase) {
            this.bitmoji_kit_event_base = bitmojiKitEventBase;
            return this;
        }

        public final Builder sticker_id(String str) {
            this.sticker_id = str;
            return this;
        }

        public final Builder share_category(BitmojiKitShareCategory bitmojiKitShareCategory) {
            this.share_category = bitmojiKitShareCategory;
            return this;
        }

        public final Builder search_category(BitmojiKitSearchCategory bitmojiKitSearchCategory) {
            this.search_category = bitmojiKitSearchCategory;
            return this;
        }

        public final BitmojiKitShare build() {
            return new BitmojiKitShare(this.bitmoji_kit_event_base, this.sticker_id, this.share_category, this.search_category, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_BitmojiKitShare extends ProtoAdapter<BitmojiKitShare> {
        public ProtoAdapter_BitmojiKitShare() {
            super(FieldEncoding.LENGTH_DELIMITED, BitmojiKitShare.class);
        }

        public final int encodedSize(BitmojiKitShare bitmojiKitShare) {
            return BitmojiKitEventBase.ADAPTER.encodedSizeWithTag(1, bitmojiKitShare.bitmoji_kit_event_base) + ProtoAdapter.STRING.encodedSizeWithTag(3, bitmojiKitShare.sticker_id) + BitmojiKitShareCategory.ADAPTER.encodedSizeWithTag(4, bitmojiKitShare.share_category) + BitmojiKitSearchCategory.ADAPTER.encodedSizeWithTag(5, bitmojiKitShare.search_category) + bitmojiKitShare.unknownFields().size();
        }

        public final void encode(ProtoWriter protoWriter, BitmojiKitShare bitmojiKitShare) throws IOException {
            BitmojiKitEventBase.ADAPTER.encodeWithTag(protoWriter, 1, bitmojiKitShare.bitmoji_kit_event_base);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, bitmojiKitShare.sticker_id);
            BitmojiKitShareCategory.ADAPTER.encodeWithTag(protoWriter, 4, bitmojiKitShare.share_category);
            BitmojiKitSearchCategory.ADAPTER.encodeWithTag(protoWriter, 5, bitmojiKitShare.search_category);
            protoWriter.writeBytes(bitmojiKitShare.unknownFields());
        }

        public final BitmojiKitShare decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.bitmoji_kit_event_base(BitmojiKitEventBase.ADAPTER.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.sticker_id(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 4) {
                    try {
                        builder.share_category(BitmojiKitShareCategory.ADAPTER.decode(protoReader));
                    } catch (ProtoAdapter.EnumConstantNotFoundException e) {
                        builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf((long) e.value));
                    }
                } else if (nextTag != 5) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    try {
                        builder.search_category(BitmojiKitSearchCategory.ADAPTER.decode(protoReader));
                    } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                        builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf((long) e2.value));
                    }
                }
            }
        }

        public final BitmojiKitShare redact(BitmojiKitShare bitmojiKitShare) {
            Builder newBuilder = bitmojiKitShare.newBuilder();
            if (newBuilder.bitmoji_kit_event_base != null) {
                newBuilder.bitmoji_kit_event_base = BitmojiKitEventBase.ADAPTER.redact(newBuilder.bitmoji_kit_event_base);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
