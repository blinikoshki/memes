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

public final class OsType extends Message<OsType, Builder> {
    public static final ProtoAdapter<OsType> ADAPTER = new ProtoAdapter_OsType();
    private static final long serialVersionUID = 0;

    public OsType() {
        this(ByteString.EMPTY);
    }

    public OsType(ByteString byteString) {
        super(ADAPTER, byteString);
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        return obj instanceof OsType;
    }

    public final int hashCode() {
        return unknownFields().hashCode();
    }

    public final String toString() {
        StringBuilder replace = new StringBuilder().replace(0, 2, "OsType{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<OsType, Builder> {
        public final OsType build() {
            return new OsType(super.buildUnknownFields());
        }
    }

    public enum Enum implements WireEnum {
        NONE(0, "None"),
        IOS(1, "iOS"),
        ANDROID(2, "Android");
        
        public static final ProtoAdapter<Enum> ADAPTER = null;
        public final String name;
        private final int value;

        static {
            ADAPTER = new ProtoAdapter_Enum();
        }

        private Enum(int i, String str) {
            this.value = i;
            this.name = str;
        }

        public static Enum fromValue(int i) {
            if (i == 0) {
                return NONE;
            }
            if (i == 1) {
                return IOS;
            }
            if (i != 2) {
                return null;
            }
            return ANDROID;
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

    private static final class ProtoAdapter_OsType extends ProtoAdapter<OsType> {
        public ProtoAdapter_OsType() {
            super(FieldEncoding.LENGTH_DELIMITED, OsType.class);
        }

        public final int encodedSize(OsType osType) {
            return osType.unknownFields().size();
        }

        public final void encode(ProtoWriter protoWriter, OsType osType) throws IOException {
            protoWriter.writeBytes(osType.unknownFields());
        }

        public final OsType decode(ProtoReader protoReader) throws IOException {
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

        public final OsType redact(OsType osType) {
            Builder newBuilder = osType.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
