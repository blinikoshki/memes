package com.snapchat.kit.sdk.core.metrics.model;

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

public final class BitmojiKitSearch extends Message<BitmojiKitSearch, Builder> {
    public static final ProtoAdapter<BitmojiKitSearch> ADAPTER = new ProtoAdapter_BitmojiKitSearch();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.snapchat.kit.sdk.core.metrics.model.BitmojiKitEventBase#ADAPTER", tag = 1)
    public final BitmojiKitEventBase bitmoji_kit_event_base;
    @WireField(adapter = "com.snapchat.kit.sdk.core.metrics.model.BitmojiKitSearchTerm#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<BitmojiKitSearchTerm> search_terms;

    public BitmojiKitSearch(BitmojiKitEventBase bitmojiKitEventBase, List<BitmojiKitSearchTerm> list) {
        this(bitmojiKitEventBase, list, ByteString.EMPTY);
    }

    public BitmojiKitSearch(BitmojiKitEventBase bitmojiKitEventBase, List<BitmojiKitSearchTerm> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.bitmoji_kit_event_base = bitmojiKitEventBase;
        this.search_terms = Internal.immutableCopyOf("search_terms", list);
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.bitmoji_kit_event_base = this.bitmoji_kit_event_base;
        builder.search_terms = Internal.copyOf("search_terms", this.search_terms);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BitmojiKitSearch)) {
            return false;
        }
        BitmojiKitSearch bitmojiKitSearch = (BitmojiKitSearch) obj;
        return unknownFields().equals(bitmojiKitSearch.unknownFields()) && Internal.equals(this.bitmoji_kit_event_base, bitmojiKitSearch.bitmoji_kit_event_base) && this.search_terms.equals(bitmojiKitSearch.search_terms);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        BitmojiKitEventBase bitmojiKitEventBase = this.bitmoji_kit_event_base;
        int hashCode2 = ((hashCode + (bitmojiKitEventBase != null ? bitmojiKitEventBase.hashCode() : 0)) * 37) + this.search_terms.hashCode();
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.bitmoji_kit_event_base != null) {
            sb.append(", bitmoji_kit_event_base=");
            sb.append(this.bitmoji_kit_event_base);
        }
        if (!this.search_terms.isEmpty()) {
            sb.append(", search_terms=");
            sb.append(this.search_terms);
        }
        StringBuilder replace = sb.replace(0, 2, "BitmojiKitSearch{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<BitmojiKitSearch, Builder> {
        public BitmojiKitEventBase bitmoji_kit_event_base;
        public List<BitmojiKitSearchTerm> search_terms = Internal.newMutableList();

        public final Builder bitmoji_kit_event_base(BitmojiKitEventBase bitmojiKitEventBase) {
            this.bitmoji_kit_event_base = bitmojiKitEventBase;
            return this;
        }

        public final Builder search_terms(List<BitmojiKitSearchTerm> list) {
            Internal.checkElementsNotNull((List<?>) list);
            this.search_terms = list;
            return this;
        }

        public final BitmojiKitSearch build() {
            return new BitmojiKitSearch(this.bitmoji_kit_event_base, this.search_terms, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_BitmojiKitSearch extends ProtoAdapter<BitmojiKitSearch> {
        public ProtoAdapter_BitmojiKitSearch() {
            super(FieldEncoding.LENGTH_DELIMITED, BitmojiKitSearch.class);
        }

        public final int encodedSize(BitmojiKitSearch bitmojiKitSearch) {
            return BitmojiKitEventBase.ADAPTER.encodedSizeWithTag(1, bitmojiKitSearch.bitmoji_kit_event_base) + BitmojiKitSearchTerm.ADAPTER.asRepeated().encodedSizeWithTag(2, bitmojiKitSearch.search_terms) + bitmojiKitSearch.unknownFields().size();
        }

        public final void encode(ProtoWriter protoWriter, BitmojiKitSearch bitmojiKitSearch) throws IOException {
            BitmojiKitEventBase.ADAPTER.encodeWithTag(protoWriter, 1, bitmojiKitSearch.bitmoji_kit_event_base);
            BitmojiKitSearchTerm.ADAPTER.asRepeated().encodeWithTag(protoWriter, 2, bitmojiKitSearch.search_terms);
            protoWriter.writeBytes(bitmojiKitSearch.unknownFields());
        }

        public final BitmojiKitSearch decode(ProtoReader protoReader) throws IOException {
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
                    builder.search_terms.add(BitmojiKitSearchTerm.ADAPTER.decode(protoReader));
                }
            }
        }

        public final BitmojiKitSearch redact(BitmojiKitSearch bitmojiKitSearch) {
            Builder newBuilder = bitmojiKitSearch.newBuilder();
            if (newBuilder.bitmoji_kit_event_base != null) {
                newBuilder.bitmoji_kit_event_base = BitmojiKitEventBase.ADAPTER.redact(newBuilder.bitmoji_kit_event_base);
            }
            Internal.redactElements(newBuilder.search_terms, BitmojiKitSearchTerm.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
