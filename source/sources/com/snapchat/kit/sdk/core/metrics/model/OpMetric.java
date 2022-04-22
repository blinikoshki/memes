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

public final class OpMetric extends Message<OpMetric, Builder> {
    public static final ProtoAdapter<OpMetric> ADAPTER = new ProtoAdapter_OpMetric();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.snapchat.kit.sdk.core.metrics.model.CounterMetric#ADAPTER", tag = 1)
    public final CounterMetric counter_metric;
    @WireField(adapter = "com.snapchat.kit.sdk.core.metrics.model.LevelMetric#ADAPTER", tag = 3)
    public final LevelMetric level_metric;
    @WireField(adapter = "com.snapchat.kit.sdk.core.metrics.model.TimerMetric#ADAPTER", tag = 2)
    public final TimerMetric timer_metric;

    public OpMetric(CounterMetric counterMetric, TimerMetric timerMetric, LevelMetric levelMetric) {
        this(counterMetric, timerMetric, levelMetric, ByteString.EMPTY);
    }

    public OpMetric(CounterMetric counterMetric, TimerMetric timerMetric, LevelMetric levelMetric, ByteString byteString) {
        super(ADAPTER, byteString);
        if (Internal.countNonNull(counterMetric, timerMetric, levelMetric) <= 1) {
            this.counter_metric = counterMetric;
            this.timer_metric = timerMetric;
            this.level_metric = levelMetric;
            return;
        }
        throw new IllegalArgumentException("at most one of counter_metric, timer_metric, level_metric may be non-null");
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.counter_metric = this.counter_metric;
        builder.timer_metric = this.timer_metric;
        builder.level_metric = this.level_metric;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OpMetric)) {
            return false;
        }
        OpMetric opMetric = (OpMetric) obj;
        return unknownFields().equals(opMetric.unknownFields()) && Internal.equals(this.counter_metric, opMetric.counter_metric) && Internal.equals(this.timer_metric, opMetric.timer_metric) && Internal.equals(this.level_metric, opMetric.level_metric);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        CounterMetric counterMetric = this.counter_metric;
        int i2 = 0;
        int hashCode2 = (hashCode + (counterMetric != null ? counterMetric.hashCode() : 0)) * 37;
        TimerMetric timerMetric = this.timer_metric;
        int hashCode3 = (hashCode2 + (timerMetric != null ? timerMetric.hashCode() : 0)) * 37;
        LevelMetric levelMetric = this.level_metric;
        if (levelMetric != null) {
            i2 = levelMetric.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.counter_metric != null) {
            sb.append(", counter_metric=");
            sb.append(this.counter_metric);
        }
        if (this.timer_metric != null) {
            sb.append(", timer_metric=");
            sb.append(this.timer_metric);
        }
        if (this.level_metric != null) {
            sb.append(", level_metric=");
            sb.append(this.level_metric);
        }
        StringBuilder replace = sb.replace(0, 2, "OpMetric{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<OpMetric, Builder> {
        public CounterMetric counter_metric;
        public LevelMetric level_metric;
        public TimerMetric timer_metric;

        public final Builder counter_metric(CounterMetric counterMetric) {
            this.counter_metric = counterMetric;
            this.timer_metric = null;
            this.level_metric = null;
            return this;
        }

        public final Builder timer_metric(TimerMetric timerMetric) {
            this.timer_metric = timerMetric;
            this.counter_metric = null;
            this.level_metric = null;
            return this;
        }

        public final Builder level_metric(LevelMetric levelMetric) {
            this.level_metric = levelMetric;
            this.counter_metric = null;
            this.timer_metric = null;
            return this;
        }

        public final OpMetric build() {
            return new OpMetric(this.counter_metric, this.timer_metric, this.level_metric, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_OpMetric extends ProtoAdapter<OpMetric> {
        public ProtoAdapter_OpMetric() {
            super(FieldEncoding.LENGTH_DELIMITED, OpMetric.class);
        }

        public final int encodedSize(OpMetric opMetric) {
            return CounterMetric.ADAPTER.encodedSizeWithTag(1, opMetric.counter_metric) + TimerMetric.ADAPTER.encodedSizeWithTag(2, opMetric.timer_metric) + LevelMetric.ADAPTER.encodedSizeWithTag(3, opMetric.level_metric) + opMetric.unknownFields().size();
        }

        public final void encode(ProtoWriter protoWriter, OpMetric opMetric) throws IOException {
            CounterMetric.ADAPTER.encodeWithTag(protoWriter, 1, opMetric.counter_metric);
            TimerMetric.ADAPTER.encodeWithTag(protoWriter, 2, opMetric.timer_metric);
            LevelMetric.ADAPTER.encodeWithTag(protoWriter, 3, opMetric.level_metric);
            protoWriter.writeBytes(opMetric.unknownFields());
        }

        public final OpMetric decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.counter_metric(CounterMetric.ADAPTER.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.timer_metric(TimerMetric.ADAPTER.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.level_metric(LevelMetric.ADAPTER.decode(protoReader));
                }
            }
        }

        public final OpMetric redact(OpMetric opMetric) {
            Builder newBuilder = opMetric.newBuilder();
            if (newBuilder.counter_metric != null) {
                newBuilder.counter_metric = CounterMetric.ADAPTER.redact(newBuilder.counter_metric);
            }
            if (newBuilder.timer_metric != null) {
                newBuilder.timer_metric = TimerMetric.ADAPTER.redact(newBuilder.timer_metric);
            }
            if (newBuilder.level_metric != null) {
                newBuilder.level_metric = LevelMetric.ADAPTER.redact(newBuilder.level_metric);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
