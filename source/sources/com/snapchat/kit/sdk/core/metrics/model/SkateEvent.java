package com.snapchat.kit.sdk.core.metrics.model;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class SkateEvent extends Message<SkateEvent, Builder> {
    public static final ProtoAdapter<SkateEvent> ADAPTER = new ProtoAdapter_SkateEvent();
    public static final DailySessionBucket DEFAULT_DAILY_SESSION_BUCKET = DailySessionBucket.NO_SESSION_BUCKET;
    public static final Long DEFAULT_DAY = 0L;
    public static final Boolean DEFAULT_IS_FIRST_WITHIN_MONTH = Boolean.FALSE;
    public static final String DEFAULT_KIT_VARIANTS_STRING_LIST = "";
    public static final LoginRoute DEFAULT_LOGIN_ROUTE = LoginRoute.UNKNOWN_LOGIN_ROUTE;
    public static final Long DEFAULT_MONTH = 0L;
    public static final Double DEFAULT_SAMPLE_RATE = Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    public static final SnapKitInitType DEFAULT_SNAP_KIT_INIT_TYPE = SnapKitInitType.INIT_TYPE_NONE;
    public static final Long DEFAULT_YEAR = 0L;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.snapchat.kit.sdk.core.metrics.model.DailySessionBucket#ADAPTER", tag = 1)
    public final DailySessionBucket daily_session_bucket;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", tag = 6)
    public final Long day;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 2)
    public final Boolean is_first_within_month;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String kit_variants_string_list;
    @WireField(adapter = "com.snapchat.kit.sdk.core.metrics.model.LoginRoute#ADAPTER", tag = 3)
    public final LoginRoute login_route;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", tag = 7)
    public final Long month;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 4)
    public final Double sample_rate;
    @WireField(adapter = "com.snapchat.kit.sdk.core.metrics.model.SnapKitInitType#ADAPTER", tag = 11)
    public final SnapKitInitType snap_kit_init_type;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", tag = 8)
    public final Long year;

    public SkateEvent(DailySessionBucket dailySessionBucket, Boolean bool, LoginRoute loginRoute, Double d, String str, Long l, Long l2, Long l3, SnapKitInitType snapKitInitType) {
        this(dailySessionBucket, bool, loginRoute, d, str, l, l2, l3, snapKitInitType, ByteString.EMPTY);
    }

    public SkateEvent(DailySessionBucket dailySessionBucket, Boolean bool, LoginRoute loginRoute, Double d, String str, Long l, Long l2, Long l3, SnapKitInitType snapKitInitType, ByteString byteString) {
        super(ADAPTER, byteString);
        this.daily_session_bucket = dailySessionBucket;
        this.is_first_within_month = bool;
        this.login_route = loginRoute;
        this.sample_rate = d;
        this.kit_variants_string_list = str;
        this.day = l;
        this.month = l2;
        this.year = l3;
        this.snap_kit_init_type = snapKitInitType;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.daily_session_bucket = this.daily_session_bucket;
        builder.is_first_within_month = this.is_first_within_month;
        builder.login_route = this.login_route;
        builder.sample_rate = this.sample_rate;
        builder.kit_variants_string_list = this.kit_variants_string_list;
        builder.day = this.day;
        builder.month = this.month;
        builder.year = this.year;
        builder.snap_kit_init_type = this.snap_kit_init_type;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SkateEvent)) {
            return false;
        }
        SkateEvent skateEvent = (SkateEvent) obj;
        return unknownFields().equals(skateEvent.unknownFields()) && Internal.equals(this.daily_session_bucket, skateEvent.daily_session_bucket) && Internal.equals(this.is_first_within_month, skateEvent.is_first_within_month) && Internal.equals(this.login_route, skateEvent.login_route) && Internal.equals(this.sample_rate, skateEvent.sample_rate) && Internal.equals(this.kit_variants_string_list, skateEvent.kit_variants_string_list) && Internal.equals(this.day, skateEvent.day) && Internal.equals(this.month, skateEvent.month) && Internal.equals(this.year, skateEvent.year) && Internal.equals(this.snap_kit_init_type, skateEvent.snap_kit_init_type);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        DailySessionBucket dailySessionBucket = this.daily_session_bucket;
        int i2 = 0;
        int hashCode2 = (hashCode + (dailySessionBucket != null ? dailySessionBucket.hashCode() : 0)) * 37;
        Boolean bool = this.is_first_within_month;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        LoginRoute loginRoute = this.login_route;
        int hashCode4 = (hashCode3 + (loginRoute != null ? loginRoute.hashCode() : 0)) * 37;
        Double d = this.sample_rate;
        int hashCode5 = (hashCode4 + (d != null ? d.hashCode() : 0)) * 37;
        String str = this.kit_variants_string_list;
        int hashCode6 = (hashCode5 + (str != null ? str.hashCode() : 0)) * 37;
        Long l = this.day;
        int hashCode7 = (hashCode6 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.month;
        int hashCode8 = (hashCode7 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.year;
        int hashCode9 = (hashCode8 + (l3 != null ? l3.hashCode() : 0)) * 37;
        SnapKitInitType snapKitInitType = this.snap_kit_init_type;
        if (snapKitInitType != null) {
            i2 = snapKitInitType.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.daily_session_bucket != null) {
            sb.append(", daily_session_bucket=");
            sb.append(this.daily_session_bucket);
        }
        if (this.is_first_within_month != null) {
            sb.append(", is_first_within_month=");
            sb.append(this.is_first_within_month);
        }
        if (this.login_route != null) {
            sb.append(", login_route=");
            sb.append(this.login_route);
        }
        if (this.sample_rate != null) {
            sb.append(", sample_rate=");
            sb.append(this.sample_rate);
        }
        if (this.kit_variants_string_list != null) {
            sb.append(", kit_variants_string_list=");
            sb.append(this.kit_variants_string_list);
        }
        if (this.day != null) {
            sb.append(", day=");
            sb.append(this.day);
        }
        if (this.month != null) {
            sb.append(", month=");
            sb.append(this.month);
        }
        if (this.year != null) {
            sb.append(", year=");
            sb.append(this.year);
        }
        if (this.snap_kit_init_type != null) {
            sb.append(", snap_kit_init_type=");
            sb.append(this.snap_kit_init_type);
        }
        StringBuilder replace = sb.replace(0, 2, "SkateEvent{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<SkateEvent, Builder> {
        public DailySessionBucket daily_session_bucket;
        public Long day;
        public Boolean is_first_within_month;
        public String kit_variants_string_list;
        public LoginRoute login_route;
        public Long month;
        public Double sample_rate;
        public SnapKitInitType snap_kit_init_type;
        public Long year;

        public final Builder daily_session_bucket(DailySessionBucket dailySessionBucket) {
            this.daily_session_bucket = dailySessionBucket;
            return this;
        }

        public final Builder is_first_within_month(Boolean bool) {
            this.is_first_within_month = bool;
            return this;
        }

        public final Builder login_route(LoginRoute loginRoute) {
            this.login_route = loginRoute;
            return this;
        }

        public final Builder sample_rate(Double d) {
            this.sample_rate = d;
            return this;
        }

        public final Builder kit_variants_string_list(String str) {
            this.kit_variants_string_list = str;
            return this;
        }

        public final Builder day(Long l) {
            this.day = l;
            return this;
        }

        public final Builder month(Long l) {
            this.month = l;
            return this;
        }

        public final Builder year(Long l) {
            this.year = l;
            return this;
        }

        public final Builder snap_kit_init_type(SnapKitInitType snapKitInitType) {
            this.snap_kit_init_type = snapKitInitType;
            return this;
        }

        public final SkateEvent build() {
            return new SkateEvent(this.daily_session_bucket, this.is_first_within_month, this.login_route, this.sample_rate, this.kit_variants_string_list, this.day, this.month, this.year, this.snap_kit_init_type, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_SkateEvent extends ProtoAdapter<SkateEvent> {
        public ProtoAdapter_SkateEvent() {
            super(FieldEncoding.LENGTH_DELIMITED, SkateEvent.class);
        }

        public final int encodedSize(SkateEvent skateEvent) {
            return DailySessionBucket.ADAPTER.encodedSizeWithTag(1, skateEvent.daily_session_bucket) + ProtoAdapter.BOOL.encodedSizeWithTag(2, skateEvent.is_first_within_month) + LoginRoute.ADAPTER.encodedSizeWithTag(3, skateEvent.login_route) + ProtoAdapter.DOUBLE.encodedSizeWithTag(4, skateEvent.sample_rate) + ProtoAdapter.STRING.encodedSizeWithTag(5, skateEvent.kit_variants_string_list) + ProtoAdapter.UINT64.encodedSizeWithTag(6, skateEvent.day) + ProtoAdapter.UINT64.encodedSizeWithTag(7, skateEvent.month) + ProtoAdapter.UINT64.encodedSizeWithTag(8, skateEvent.year) + SnapKitInitType.ADAPTER.encodedSizeWithTag(11, skateEvent.snap_kit_init_type) + skateEvent.unknownFields().size();
        }

        public final void encode(ProtoWriter protoWriter, SkateEvent skateEvent) throws IOException {
            DailySessionBucket.ADAPTER.encodeWithTag(protoWriter, 1, skateEvent.daily_session_bucket);
            ProtoAdapter.BOOL.encodeWithTag(protoWriter, 2, skateEvent.is_first_within_month);
            LoginRoute.ADAPTER.encodeWithTag(protoWriter, 3, skateEvent.login_route);
            ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 4, skateEvent.sample_rate);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, skateEvent.kit_variants_string_list);
            ProtoAdapter.UINT64.encodeWithTag(protoWriter, 6, skateEvent.day);
            ProtoAdapter.UINT64.encodeWithTag(protoWriter, 7, skateEvent.month);
            ProtoAdapter.UINT64.encodeWithTag(protoWriter, 8, skateEvent.year);
            SnapKitInitType.ADAPTER.encodeWithTag(protoWriter, 11, skateEvent.snap_kit_init_type);
            protoWriter.writeBytes(skateEvent.unknownFields());
        }

        public final SkateEvent decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag != 11) {
                    switch (nextTag) {
                        case 1:
                            try {
                                builder.daily_session_bucket(DailySessionBucket.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e) {
                                builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf((long) e.value));
                                break;
                            }
                        case 2:
                            builder.is_first_within_month(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 3:
                            try {
                                builder.login_route(LoginRoute.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf((long) e2.value));
                                break;
                            }
                        case 4:
                            builder.sample_rate(ProtoAdapter.DOUBLE.decode(protoReader));
                            break;
                        case 5:
                            builder.kit_variants_string_list(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            builder.day(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 7:
                            builder.month(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 8:
                            builder.year(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    try {
                        builder.snap_kit_init_type(SnapKitInitType.ADAPTER.decode(protoReader));
                    } catch (ProtoAdapter.EnumConstantNotFoundException e3) {
                        builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf((long) e3.value));
                    }
                }
            }
        }

        public final SkateEvent redact(SkateEvent skateEvent) {
            Builder newBuilder = skateEvent.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
