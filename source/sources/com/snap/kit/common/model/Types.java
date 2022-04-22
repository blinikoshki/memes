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

public final class Types extends Message<Types, Builder> {
    public static final ProtoAdapter<Types> ADAPTER = new ProtoAdapter_Types();
    private static final long serialVersionUID = 0;

    public Types() {
        this(ByteString.EMPTY);
    }

    public Types(ByteString byteString) {
        super(ADAPTER, byteString);
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        return obj instanceof Types;
    }

    public final int hashCode() {
        return unknownFields().hashCode();
    }

    public final String toString() {
        StringBuilder replace = new StringBuilder().replace(0, 2, "Types{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<Types, Builder> {
        public final Types build() {
            return new Types(super.buildUnknownFields());
        }
    }

    public enum Trilean implements WireEnum {
        NONE(0),
        FALSE(1),
        TRUE(2);
        
        public static final ProtoAdapter<Trilean> ADAPTER = null;
        private final int value;

        static {
            ADAPTER = new ProtoAdapter_Trilean();
        }

        private Trilean(int i) {
            this.value = i;
        }

        public static Trilean fromValue(int i) {
            if (i == 0) {
                return NONE;
            }
            if (i == 1) {
                return FALSE;
            }
            if (i != 2) {
                return null;
            }
            return TRUE;
        }

        public final int getValue() {
            return this.value;
        }

        private static final class ProtoAdapter_Trilean extends EnumAdapter<Trilean> {
            ProtoAdapter_Trilean() {
                super(Trilean.class);
            }

            /* access modifiers changed from: protected */
            public final Trilean fromValue(int i) {
                return Trilean.fromValue(i);
            }
        }
    }

    private static final class ProtoAdapter_Types extends ProtoAdapter<Types> {
        public ProtoAdapter_Types() {
            super(FieldEncoding.LENGTH_DELIMITED, Types.class);
        }

        public final int encodedSize(Types types) {
            return types.unknownFields().size();
        }

        public final void encode(ProtoWriter protoWriter, Types types) throws IOException {
            protoWriter.writeBytes(types.unknownFields());
        }

        public final Types decode(ProtoReader protoReader) throws IOException {
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

        public final Types redact(Types types) {
            Builder newBuilder = types.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
