package com.snap.kit.common.model;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;

public final class KitType extends Message<KitType, Builder> {
    public static final ProtoAdapter<KitType> ADAPTER = new ProtoAdapter_KitType();
    private static final long serialVersionUID = 0;

    public KitType() {
        this(ByteString.EMPTY);
    }

    public KitType(ByteString byteString) {
        super(ADAPTER, byteString);
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        return obj instanceof KitType;
    }

    public final int hashCode() {
        return unknownFields().hashCode();
    }

    public final String toString() {
        StringBuilder replace = new StringBuilder().replace(0, 2, "KitType{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<KitType, Builder> {
        public final KitType build() {
            return new KitType(super.buildUnknownFields());
        }
    }

    public enum Enum implements WireEnum {
        NONE(0),
        LOGIN_KIT(1),
        BITMOJI_KIT(2),
        CREATIVE_KIT(3),
        STORY_KIT(4);
        
        public static final ProtoAdapter<Enum> ADAPTER = null;
        private final int value;

        static {
            ADAPTER = new ProtoAdapter_Enum();
        }

        private Enum(int i) {
            this.value = i;
        }

        public static Enum fromValue(int i) {
            if (i == 0) {
                return NONE;
            }
            if (i == 1) {
                return LOGIN_KIT;
            }
            if (i == 2) {
                return BITMOJI_KIT;
            }
            if (i == 3) {
                return CREATIVE_KIT;
            }
            if (i != 4) {
                return null;
            }
            return STORY_KIT;
        }

        public final int getValue() {
            return this.value;
        }

        private static final class ProtoAdapter_Enum extends EnumAdapter<Enum> {
            ProtoAdapter_Enum() {
                super(Enum.class);
            }

            /* access modifiers changed from: protected */
            public final Enum fromValue(int i) {
                return Enum.fromValue(i);
            }
        }
    }

    private static final class ProtoAdapter_KitType extends ProtoAdapter<KitType> {
        public ProtoAdapter_KitType() {
            super(FieldEncoding.LENGTH_DELIMITED, KitType.class);
        }

        public final int encodedSize(KitType kitType) {
            return kitType.unknownFields().size();
        }

        public final void encode(ProtoWriter protoWriter, KitType kitType) throws IOException {
            protoWriter.writeBytes(kitType.unknownFields());
        }

        public final KitType decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
            }
        }

        public final KitType redact(KitType kitType) {
            Builder newBuilder = kitType.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
