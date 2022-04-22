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

public final class LoginKitEventBase extends Message<LoginKitEventBase, Builder> {
    public static final ProtoAdapter<LoginKitEventBase> ADAPTER = new ProtoAdapter_LoginKitEventBase();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.snapchat.kit.sdk.core.metrics.model.KitEventBase#ADAPTER", tag = 1)
    public final KitEventBase kit_event_base;

    public LoginKitEventBase(KitEventBase kitEventBase) {
        this(kitEventBase, ByteString.EMPTY);
    }

    public LoginKitEventBase(KitEventBase kitEventBase, ByteString byteString) {
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
        if (!(obj instanceof LoginKitEventBase)) {
            return false;
        }
        LoginKitEventBase loginKitEventBase = (LoginKitEventBase) obj;
        return unknownFields().equals(loginKitEventBase.unknownFields()) && Internal.equals(this.kit_event_base, loginKitEventBase.kit_event_base);
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
        StringBuilder replace = sb.replace(0, 2, "LoginKitEventBase{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<LoginKitEventBase, Builder> {
        public KitEventBase kit_event_base;

        public final Builder kit_event_base(KitEventBase kitEventBase) {
            this.kit_event_base = kitEventBase;
            return this;
        }

        public final LoginKitEventBase build() {
            return new LoginKitEventBase(this.kit_event_base, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_LoginKitEventBase extends ProtoAdapter<LoginKitEventBase> {
        public ProtoAdapter_LoginKitEventBase() {
            super(FieldEncoding.LENGTH_DELIMITED, LoginKitEventBase.class);
        }

        public final int encodedSize(LoginKitEventBase loginKitEventBase) {
            return KitEventBase.ADAPTER.encodedSizeWithTag(1, loginKitEventBase.kit_event_base) + loginKitEventBase.unknownFields().size();
        }

        public final void encode(ProtoWriter protoWriter, LoginKitEventBase loginKitEventBase) throws IOException {
            KitEventBase.ADAPTER.encodeWithTag(protoWriter, 1, loginKitEventBase.kit_event_base);
            protoWriter.writeBytes(loginKitEventBase.unknownFields());
        }

        public final LoginKitEventBase decode(ProtoReader protoReader) throws IOException {
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

        public final LoginKitEventBase redact(LoginKitEventBase loginKitEventBase) {
            Builder newBuilder = loginKitEventBase.newBuilder();
            if (newBuilder.kit_event_base != null) {
                newBuilder.kit_event_base = KitEventBase.ADAPTER.redact(newBuilder.kit_event_base);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
