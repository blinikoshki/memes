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

public final class StoryKitEventBase extends Message<StoryKitEventBase, Builder> {
    public static final ProtoAdapter<StoryKitEventBase> ADAPTER = new ProtoAdapter_StoryKitEventBase();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.snapchat.kit.sdk.core.metrics.model.KitEventBase#ADAPTER", tag = 1)
    public final KitEventBase kit_event_base;

    public StoryKitEventBase(KitEventBase kitEventBase) {
        this(kitEventBase, ByteString.EMPTY);
    }

    public StoryKitEventBase(KitEventBase kitEventBase, ByteString byteString) {
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
        if (!(obj instanceof StoryKitEventBase)) {
            return false;
        }
        StoryKitEventBase storyKitEventBase = (StoryKitEventBase) obj;
        return unknownFields().equals(storyKitEventBase.unknownFields()) && Internal.equals(this.kit_event_base, storyKitEventBase.kit_event_base);
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
        StringBuilder replace = sb.replace(0, 2, "StoryKitEventBase{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<StoryKitEventBase, Builder> {
        public KitEventBase kit_event_base;

        public final Builder kit_event_base(KitEventBase kitEventBase) {
            this.kit_event_base = kitEventBase;
            return this;
        }

        public final StoryKitEventBase build() {
            return new StoryKitEventBase(this.kit_event_base, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_StoryKitEventBase extends ProtoAdapter<StoryKitEventBase> {
        public ProtoAdapter_StoryKitEventBase() {
            super(FieldEncoding.LENGTH_DELIMITED, StoryKitEventBase.class);
        }

        public final int encodedSize(StoryKitEventBase storyKitEventBase) {
            return KitEventBase.ADAPTER.encodedSizeWithTag(1, storyKitEventBase.kit_event_base) + storyKitEventBase.unknownFields().size();
        }

        public final void encode(ProtoWriter protoWriter, StoryKitEventBase storyKitEventBase) throws IOException {
            KitEventBase.ADAPTER.encodeWithTag(protoWriter, 1, storyKitEventBase.kit_event_base);
            protoWriter.writeBytes(storyKitEventBase.unknownFields());
        }

        public final StoryKitEventBase decode(ProtoReader protoReader) throws IOException {
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

        public final StoryKitEventBase redact(StoryKitEventBase storyKitEventBase) {
            Builder newBuilder = storyKitEventBase.newBuilder();
            if (newBuilder.kit_event_base != null) {
                newBuilder.kit_event_base = KitEventBase.ADAPTER.redact(newBuilder.kit_event_base);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
