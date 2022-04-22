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

public final class LoginKitAuthStart extends Message<LoginKitAuthStart, Builder> {
    public static final ProtoAdapter<LoginKitAuthStart> ADAPTER = new ProtoAdapter_LoginKitAuthStart();
    public static final String DEFAULT_FEATURES_REQUESTED_STRING_LIST = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String features_requested_string_list;
    @WireField(adapter = "com.snapchat.kit.sdk.core.metrics.model.LoginKitEventBase#ADAPTER", tag = 1)
    public final LoginKitEventBase log_kit_event_base;

    public LoginKitAuthStart(LoginKitEventBase loginKitEventBase, String str) {
        this(loginKitEventBase, str, ByteString.EMPTY);
    }

    public LoginKitAuthStart(LoginKitEventBase loginKitEventBase, String str, ByteString byteString) {
        super(ADAPTER, byteString);
        this.log_kit_event_base = loginKitEventBase;
        this.features_requested_string_list = str;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.log_kit_event_base = this.log_kit_event_base;
        builder.features_requested_string_list = this.features_requested_string_list;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoginKitAuthStart)) {
            return false;
        }
        LoginKitAuthStart loginKitAuthStart = (LoginKitAuthStart) obj;
        return unknownFields().equals(loginKitAuthStart.unknownFields()) && Internal.equals(this.log_kit_event_base, loginKitAuthStart.log_kit_event_base) && Internal.equals(this.features_requested_string_list, loginKitAuthStart.features_requested_string_list);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        LoginKitEventBase loginKitEventBase = this.log_kit_event_base;
        int i2 = 0;
        int hashCode2 = (hashCode + (loginKitEventBase != null ? loginKitEventBase.hashCode() : 0)) * 37;
        String str = this.features_requested_string_list;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.log_kit_event_base != null) {
            sb.append(", log_kit_event_base=");
            sb.append(this.log_kit_event_base);
        }
        if (this.features_requested_string_list != null) {
            sb.append(", features_requested_string_list=");
            sb.append(this.features_requested_string_list);
        }
        StringBuilder replace = sb.replace(0, 2, "LoginKitAuthStart{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<LoginKitAuthStart, Builder> {
        public String features_requested_string_list;
        public LoginKitEventBase log_kit_event_base;

        public final Builder log_kit_event_base(LoginKitEventBase loginKitEventBase) {
            this.log_kit_event_base = loginKitEventBase;
            return this;
        }

        public final Builder features_requested_string_list(String str) {
            this.features_requested_string_list = str;
            return this;
        }

        public final LoginKitAuthStart build() {
            return new LoginKitAuthStart(this.log_kit_event_base, this.features_requested_string_list, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_LoginKitAuthStart extends ProtoAdapter<LoginKitAuthStart> {
        public ProtoAdapter_LoginKitAuthStart() {
            super(FieldEncoding.LENGTH_DELIMITED, LoginKitAuthStart.class);
        }

        public final int encodedSize(LoginKitAuthStart loginKitAuthStart) {
            return LoginKitEventBase.ADAPTER.encodedSizeWithTag(1, loginKitAuthStart.log_kit_event_base) + ProtoAdapter.STRING.encodedSizeWithTag(2, loginKitAuthStart.features_requested_string_list) + loginKitAuthStart.unknownFields().size();
        }

        public final void encode(ProtoWriter protoWriter, LoginKitAuthStart loginKitAuthStart) throws IOException {
            LoginKitEventBase.ADAPTER.encodeWithTag(protoWriter, 1, loginKitAuthStart.log_kit_event_base);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, loginKitAuthStart.features_requested_string_list);
            protoWriter.writeBytes(loginKitAuthStart.unknownFields());
        }

        public final LoginKitAuthStart decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.log_kit_event_base(LoginKitEventBase.ADAPTER.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.features_requested_string_list(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final LoginKitAuthStart redact(LoginKitAuthStart loginKitAuthStart) {
            Builder newBuilder = loginKitAuthStart.newBuilder();
            if (newBuilder.log_kit_event_base != null) {
                newBuilder.log_kit_event_base = LoginKitEventBase.ADAPTER.redact(newBuilder.log_kit_event_base);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
