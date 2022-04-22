package com.snap.kit.common.model;

import com.snap.kit.common.model.OsType;
import com.snap.kit.common.model.Types;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class DeviceEnvironmentInfo extends Message<DeviceEnvironmentInfo, Builder> {
    public static final ProtoAdapter<DeviceEnvironmentInfo> ADAPTER = new ProtoAdapter_DeviceEnvironmentInfo();
    public static final Types.Trilean DEFAULT_IS_APP_PRERELEASE = Types.Trilean.NONE;
    public static final String DEFAULT_LOCALE = "";
    public static final String DEFAULT_MODEL = "";
    public static final OsType.Enum DEFAULT_OS_TYPE = OsType.Enum.NONE;
    public static final String DEFAULT_OS_VERSION = "";
    public static final Types.Trilean DEFAULT_RUNNING_IN_SIMULATOR = Types.Trilean.NONE;
    public static final Types.Trilean DEFAULT_RUNNING_IN_TESTS = Types.Trilean.NONE;
    public static final Types.Trilean DEFAULT_RUNNING_WITH_DEBUGGER_ATTACHED = Types.Trilean.NONE;
    public static final String DEFAULT_TARGET_ARCHITECTURE = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.snap.kit.common.model.Types$Trilean#ADAPTER", tag = 9)
    public final Types.Trilean is_app_prerelease;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String locale;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String model;
    @WireField(adapter = "com.snap.kit.common.model.OsType$Enum#ADAPTER", tag = 1)
    public final OsType.Enum os_type;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String os_version;
    @WireField(adapter = "com.snap.kit.common.model.Types$Trilean#ADAPTER", tag = 8)
    public final Types.Trilean running_in_simulator;
    @WireField(adapter = "com.snap.kit.common.model.Types$Trilean#ADAPTER", tag = 7)
    public final Types.Trilean running_in_tests;
    @WireField(adapter = "com.snap.kit.common.model.Types$Trilean#ADAPTER", tag = 6)
    public final Types.Trilean running_with_debugger_attached;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String target_architecture;

    public DeviceEnvironmentInfo(OsType.Enum enumR, String str, String str2, String str3, String str4, Types.Trilean trilean, Types.Trilean trilean2, Types.Trilean trilean3, Types.Trilean trilean4) {
        this(enumR, str, str2, str3, str4, trilean, trilean2, trilean3, trilean4, ByteString.EMPTY);
    }

    public DeviceEnvironmentInfo(OsType.Enum enumR, String str, String str2, String str3, String str4, Types.Trilean trilean, Types.Trilean trilean2, Types.Trilean trilean3, Types.Trilean trilean4, ByteString byteString) {
        super(ADAPTER, byteString);
        this.os_type = enumR;
        this.os_version = str;
        this.model = str2;
        this.target_architecture = str3;
        this.locale = str4;
        this.running_with_debugger_attached = trilean;
        this.running_in_tests = trilean2;
        this.running_in_simulator = trilean3;
        this.is_app_prerelease = trilean4;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.os_type = this.os_type;
        builder.os_version = this.os_version;
        builder.model = this.model;
        builder.target_architecture = this.target_architecture;
        builder.locale = this.locale;
        builder.running_with_debugger_attached = this.running_with_debugger_attached;
        builder.running_in_tests = this.running_in_tests;
        builder.running_in_simulator = this.running_in_simulator;
        builder.is_app_prerelease = this.is_app_prerelease;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceEnvironmentInfo)) {
            return false;
        }
        DeviceEnvironmentInfo deviceEnvironmentInfo = (DeviceEnvironmentInfo) obj;
        return unknownFields().equals(deviceEnvironmentInfo.unknownFields()) && Internal.equals(this.os_type, deviceEnvironmentInfo.os_type) && Internal.equals(this.os_version, deviceEnvironmentInfo.os_version) && Internal.equals(this.model, deviceEnvironmentInfo.model) && Internal.equals(this.target_architecture, deviceEnvironmentInfo.target_architecture) && Internal.equals(this.locale, deviceEnvironmentInfo.locale) && Internal.equals(this.running_with_debugger_attached, deviceEnvironmentInfo.running_with_debugger_attached) && Internal.equals(this.running_in_tests, deviceEnvironmentInfo.running_in_tests) && Internal.equals(this.running_in_simulator, deviceEnvironmentInfo.running_in_simulator) && Internal.equals(this.is_app_prerelease, deviceEnvironmentInfo.is_app_prerelease);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        OsType.Enum enumR = this.os_type;
        int i2 = 0;
        int hashCode2 = (hashCode + (enumR != null ? enumR.hashCode() : 0)) * 37;
        String str = this.os_version;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.model;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.target_architecture;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.locale;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Types.Trilean trilean = this.running_with_debugger_attached;
        int hashCode7 = (hashCode6 + (trilean != null ? trilean.hashCode() : 0)) * 37;
        Types.Trilean trilean2 = this.running_in_tests;
        int hashCode8 = (hashCode7 + (trilean2 != null ? trilean2.hashCode() : 0)) * 37;
        Types.Trilean trilean3 = this.running_in_simulator;
        int hashCode9 = (hashCode8 + (trilean3 != null ? trilean3.hashCode() : 0)) * 37;
        Types.Trilean trilean4 = this.is_app_prerelease;
        if (trilean4 != null) {
            i2 = trilean4.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.os_type != null) {
            sb.append(", os_type=");
            sb.append(this.os_type);
        }
        if (this.os_version != null) {
            sb.append(", os_version=");
            sb.append(this.os_version);
        }
        if (this.model != null) {
            sb.append(", model=");
            sb.append(this.model);
        }
        if (this.target_architecture != null) {
            sb.append(", target_architecture=");
            sb.append(this.target_architecture);
        }
        if (this.locale != null) {
            sb.append(", locale=");
            sb.append(this.locale);
        }
        if (this.running_with_debugger_attached != null) {
            sb.append(", running_with_debugger_attached=");
            sb.append(this.running_with_debugger_attached);
        }
        if (this.running_in_tests != null) {
            sb.append(", running_in_tests=");
            sb.append(this.running_in_tests);
        }
        if (this.running_in_simulator != null) {
            sb.append(", running_in_simulator=");
            sb.append(this.running_in_simulator);
        }
        if (this.is_app_prerelease != null) {
            sb.append(", is_app_prerelease=");
            sb.append(this.is_app_prerelease);
        }
        StringBuilder replace = sb.replace(0, 2, "DeviceEnvironmentInfo{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<DeviceEnvironmentInfo, Builder> {
        public Types.Trilean is_app_prerelease;
        public String locale;
        public String model;
        public OsType.Enum os_type;
        public String os_version;
        public Types.Trilean running_in_simulator;
        public Types.Trilean running_in_tests;
        public Types.Trilean running_with_debugger_attached;
        public String target_architecture;

        public final Builder os_type(OsType.Enum enumR) {
            this.os_type = enumR;
            return this;
        }

        public final Builder os_version(String str) {
            this.os_version = str;
            return this;
        }

        public final Builder model(String str) {
            this.model = str;
            return this;
        }

        public final Builder target_architecture(String str) {
            this.target_architecture = str;
            return this;
        }

        public final Builder locale(String str) {
            this.locale = str;
            return this;
        }

        public final Builder running_with_debugger_attached(Types.Trilean trilean) {
            this.running_with_debugger_attached = trilean;
            return this;
        }

        public final Builder running_in_tests(Types.Trilean trilean) {
            this.running_in_tests = trilean;
            return this;
        }

        public final Builder running_in_simulator(Types.Trilean trilean) {
            this.running_in_simulator = trilean;
            return this;
        }

        public final Builder is_app_prerelease(Types.Trilean trilean) {
            this.is_app_prerelease = trilean;
            return this;
        }

        public final DeviceEnvironmentInfo build() {
            return new DeviceEnvironmentInfo(this.os_type, this.os_version, this.model, this.target_architecture, this.locale, this.running_with_debugger_attached, this.running_in_tests, this.running_in_simulator, this.is_app_prerelease, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_DeviceEnvironmentInfo extends ProtoAdapter<DeviceEnvironmentInfo> {
        public ProtoAdapter_DeviceEnvironmentInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, DeviceEnvironmentInfo.class);
        }

        public final int encodedSize(DeviceEnvironmentInfo deviceEnvironmentInfo) {
            return OsType.Enum.ADAPTER.encodedSizeWithTag(1, deviceEnvironmentInfo.os_type) + ProtoAdapter.STRING.encodedSizeWithTag(2, deviceEnvironmentInfo.os_version) + ProtoAdapter.STRING.encodedSizeWithTag(3, deviceEnvironmentInfo.model) + ProtoAdapter.STRING.encodedSizeWithTag(4, deviceEnvironmentInfo.target_architecture) + ProtoAdapter.STRING.encodedSizeWithTag(5, deviceEnvironmentInfo.locale) + Types.Trilean.ADAPTER.encodedSizeWithTag(6, deviceEnvironmentInfo.running_with_debugger_attached) + Types.Trilean.ADAPTER.encodedSizeWithTag(7, deviceEnvironmentInfo.running_in_tests) + Types.Trilean.ADAPTER.encodedSizeWithTag(8, deviceEnvironmentInfo.running_in_simulator) + Types.Trilean.ADAPTER.encodedSizeWithTag(9, deviceEnvironmentInfo.is_app_prerelease) + deviceEnvironmentInfo.unknownFields().size();
        }

        public final void encode(ProtoWriter protoWriter, DeviceEnvironmentInfo deviceEnvironmentInfo) throws IOException {
            OsType.Enum.ADAPTER.encodeWithTag(protoWriter, 1, deviceEnvironmentInfo.os_type);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, deviceEnvironmentInfo.os_version);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, deviceEnvironmentInfo.model);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, deviceEnvironmentInfo.target_architecture);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, deviceEnvironmentInfo.locale);
            Types.Trilean.ADAPTER.encodeWithTag(protoWriter, 6, deviceEnvironmentInfo.running_with_debugger_attached);
            Types.Trilean.ADAPTER.encodeWithTag(protoWriter, 7, deviceEnvironmentInfo.running_in_tests);
            Types.Trilean.ADAPTER.encodeWithTag(protoWriter, 8, deviceEnvironmentInfo.running_in_simulator);
            Types.Trilean.ADAPTER.encodeWithTag(protoWriter, 9, deviceEnvironmentInfo.is_app_prerelease);
            protoWriter.writeBytes(deviceEnvironmentInfo.unknownFields());
        }

        public final DeviceEnvironmentInfo decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            try {
                                builder.os_type(OsType.Enum.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e) {
                                builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf((long) e.value));
                                break;
                            }
                        case 2:
                            builder.os_version(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.model(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.target_architecture(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.locale(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            try {
                                builder.running_with_debugger_attached(Types.Trilean.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf((long) e2.value));
                                break;
                            }
                        case 7:
                            try {
                                builder.running_in_tests(Types.Trilean.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e3) {
                                builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf((long) e3.value));
                                break;
                            }
                        case 8:
                            try {
                                builder.running_in_simulator(Types.Trilean.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e4) {
                                builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf((long) e4.value));
                                break;
                            }
                        case 9:
                            try {
                                builder.is_app_prerelease(Types.Trilean.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e5) {
                                builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf((long) e5.value));
                                break;
                            }
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
            }
        }

        public final DeviceEnvironmentInfo redact(DeviceEnvironmentInfo deviceEnvironmentInfo) {
            Builder newBuilder = deviceEnvironmentInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
