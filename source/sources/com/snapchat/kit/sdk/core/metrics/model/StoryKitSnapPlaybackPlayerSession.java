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

public final class StoryKitSnapPlaybackPlayerSession extends Message<StoryKitSnapPlaybackPlayerSession, Builder> {
    public static final ProtoAdapter<StoryKitSnapPlaybackPlayerSession> ADAPTER = new ProtoAdapter_StoryKitSnapPlaybackPlayerSession();
    public static final String DEFAULT_PLAYER_SESSION_ID = "";
    public static final StoryKitPlayerType DEFAULT_PLAYER_TYPE = StoryKitPlayerType.STORY_KIT_PLAYER_TYPE_NONE;
    public static final Long DEFAULT_SESSION_DURATION_MS = 0L;
    public static final Long DEFAULT_SNAP_COUNT = 0L;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String player_session_id;
    @WireField(adapter = "com.snapchat.kit.sdk.core.metrics.model.StoryKitPlayerType#ADAPTER", tag = 5)
    public final StoryKitPlayerType player_type;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", tag = 4)
    public final Long session_duration_ms;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", tag = 3)
    public final Long snap_count;
    @WireField(adapter = "com.snapchat.kit.sdk.core.metrics.model.StoryKitEventBase#ADAPTER", tag = 1)
    public final StoryKitEventBase story_kit_event_base;

    public StoryKitSnapPlaybackPlayerSession(StoryKitEventBase storyKitEventBase, String str, Long l, Long l2, StoryKitPlayerType storyKitPlayerType) {
        this(storyKitEventBase, str, l, l2, storyKitPlayerType, ByteString.EMPTY);
    }

    public StoryKitSnapPlaybackPlayerSession(StoryKitEventBase storyKitEventBase, String str, Long l, Long l2, StoryKitPlayerType storyKitPlayerType, ByteString byteString) {
        super(ADAPTER, byteString);
        this.story_kit_event_base = storyKitEventBase;
        this.player_session_id = str;
        this.snap_count = l;
        this.session_duration_ms = l2;
        this.player_type = storyKitPlayerType;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.story_kit_event_base = this.story_kit_event_base;
        builder.player_session_id = this.player_session_id;
        builder.snap_count = this.snap_count;
        builder.session_duration_ms = this.session_duration_ms;
        builder.player_type = this.player_type;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StoryKitSnapPlaybackPlayerSession)) {
            return false;
        }
        StoryKitSnapPlaybackPlayerSession storyKitSnapPlaybackPlayerSession = (StoryKitSnapPlaybackPlayerSession) obj;
        return unknownFields().equals(storyKitSnapPlaybackPlayerSession.unknownFields()) && Internal.equals(this.story_kit_event_base, storyKitSnapPlaybackPlayerSession.story_kit_event_base) && Internal.equals(this.player_session_id, storyKitSnapPlaybackPlayerSession.player_session_id) && Internal.equals(this.snap_count, storyKitSnapPlaybackPlayerSession.snap_count) && Internal.equals(this.session_duration_ms, storyKitSnapPlaybackPlayerSession.session_duration_ms) && Internal.equals(this.player_type, storyKitSnapPlaybackPlayerSession.player_type);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        StoryKitEventBase storyKitEventBase = this.story_kit_event_base;
        int i2 = 0;
        int hashCode2 = (hashCode + (storyKitEventBase != null ? storyKitEventBase.hashCode() : 0)) * 37;
        String str = this.player_session_id;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Long l = this.snap_count;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.session_duration_ms;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        StoryKitPlayerType storyKitPlayerType = this.player_type;
        if (storyKitPlayerType != null) {
            i2 = storyKitPlayerType.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.story_kit_event_base != null) {
            sb.append(", story_kit_event_base=");
            sb.append(this.story_kit_event_base);
        }
        if (this.player_session_id != null) {
            sb.append(", player_session_id=");
            sb.append(this.player_session_id);
        }
        if (this.snap_count != null) {
            sb.append(", snap_count=");
            sb.append(this.snap_count);
        }
        if (this.session_duration_ms != null) {
            sb.append(", session_duration_ms=");
            sb.append(this.session_duration_ms);
        }
        if (this.player_type != null) {
            sb.append(", player_type=");
            sb.append(this.player_type);
        }
        StringBuilder replace = sb.replace(0, 2, "StoryKitSnapPlaybackPlayerSession{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<StoryKitSnapPlaybackPlayerSession, Builder> {
        public String player_session_id;
        public StoryKitPlayerType player_type;
        public Long session_duration_ms;
        public Long snap_count;
        public StoryKitEventBase story_kit_event_base;

        public final Builder story_kit_event_base(StoryKitEventBase storyKitEventBase) {
            this.story_kit_event_base = storyKitEventBase;
            return this;
        }

        public final Builder player_session_id(String str) {
            this.player_session_id = str;
            return this;
        }

        public final Builder snap_count(Long l) {
            this.snap_count = l;
            return this;
        }

        public final Builder session_duration_ms(Long l) {
            this.session_duration_ms = l;
            return this;
        }

        public final Builder player_type(StoryKitPlayerType storyKitPlayerType) {
            this.player_type = storyKitPlayerType;
            return this;
        }

        public final StoryKitSnapPlaybackPlayerSession build() {
            return new StoryKitSnapPlaybackPlayerSession(this.story_kit_event_base, this.player_session_id, this.snap_count, this.session_duration_ms, this.player_type, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_StoryKitSnapPlaybackPlayerSession extends ProtoAdapter<StoryKitSnapPlaybackPlayerSession> {
        public ProtoAdapter_StoryKitSnapPlaybackPlayerSession() {
            super(FieldEncoding.LENGTH_DELIMITED, StoryKitSnapPlaybackPlayerSession.class);
        }

        public final int encodedSize(StoryKitSnapPlaybackPlayerSession storyKitSnapPlaybackPlayerSession) {
            return StoryKitEventBase.ADAPTER.encodedSizeWithTag(1, storyKitSnapPlaybackPlayerSession.story_kit_event_base) + ProtoAdapter.STRING.encodedSizeWithTag(2, storyKitSnapPlaybackPlayerSession.player_session_id) + ProtoAdapter.UINT64.encodedSizeWithTag(3, storyKitSnapPlaybackPlayerSession.snap_count) + ProtoAdapter.UINT64.encodedSizeWithTag(4, storyKitSnapPlaybackPlayerSession.session_duration_ms) + StoryKitPlayerType.ADAPTER.encodedSizeWithTag(5, storyKitSnapPlaybackPlayerSession.player_type) + storyKitSnapPlaybackPlayerSession.unknownFields().size();
        }

        public final void encode(ProtoWriter protoWriter, StoryKitSnapPlaybackPlayerSession storyKitSnapPlaybackPlayerSession) throws IOException {
            StoryKitEventBase.ADAPTER.encodeWithTag(protoWriter, 1, storyKitSnapPlaybackPlayerSession.story_kit_event_base);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, storyKitSnapPlaybackPlayerSession.player_session_id);
            ProtoAdapter.UINT64.encodeWithTag(protoWriter, 3, storyKitSnapPlaybackPlayerSession.snap_count);
            ProtoAdapter.UINT64.encodeWithTag(protoWriter, 4, storyKitSnapPlaybackPlayerSession.session_duration_ms);
            StoryKitPlayerType.ADAPTER.encodeWithTag(protoWriter, 5, storyKitSnapPlaybackPlayerSession.player_type);
            protoWriter.writeBytes(storyKitSnapPlaybackPlayerSession.unknownFields());
        }

        public final StoryKitSnapPlaybackPlayerSession decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.story_kit_event_base(StoryKitEventBase.ADAPTER.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.player_session_id(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.snap_count(ProtoAdapter.UINT64.decode(protoReader));
                } else if (nextTag == 4) {
                    builder.session_duration_ms(ProtoAdapter.UINT64.decode(protoReader));
                } else if (nextTag != 5) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    try {
                        builder.player_type(StoryKitPlayerType.ADAPTER.decode(protoReader));
                    } catch (ProtoAdapter.EnumConstantNotFoundException e) {
                        builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf((long) e.value));
                    }
                }
            }
        }

        public final StoryKitSnapPlaybackPlayerSession redact(StoryKitSnapPlaybackPlayerSession storyKitSnapPlaybackPlayerSession) {
            Builder newBuilder = storyKitSnapPlaybackPlayerSession.newBuilder();
            if (newBuilder.story_kit_event_base != null) {
                newBuilder.story_kit_event_base = StoryKitEventBase.ADAPTER.redact(newBuilder.story_kit_event_base);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
