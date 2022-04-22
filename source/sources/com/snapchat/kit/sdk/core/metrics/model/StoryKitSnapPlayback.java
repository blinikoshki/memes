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

public final class StoryKitSnapPlayback extends Message<StoryKitSnapPlayback, Builder> {
    public static final ProtoAdapter<StoryKitSnapPlayback> ADAPTER = new ProtoAdapter_StoryKitSnapPlayback();
    public static final StoryKitEntryEvent DEFAULT_ENTRY_EVENT = StoryKitEntryEvent.STORY_KIT_ENTRY_EVENT_PLAYER_NONE;
    public static final StoryKitExitEvent DEFAULT_EXIT_EVENT = StoryKitExitEvent.STORY_KIT_EXIT_EVENT_PLAYER_NONE;
    public static final Long DEFAULT_INITIAL_STALL_MS = 0L;
    public static final Long DEFAULT_MEDIA_DURATION_UNCHECKED_MS = 0L;
    public static final StoryKitMediaType DEFAULT_MEDIA_TYPE = StoryKitMediaType.STORY_KIT_MEDIA_TYPE_NONE;
    public static final String DEFAULT_MEDIA_URL = "";
    public static final String DEFAULT_PLAYER_SESSION_ID = "";
    public static final String DEFAULT_SNAP_ID_UNCHECKED = "";
    public static final Long DEFAULT_SNAP_VIEW_INDEX = 0L;
    public static final Long DEFAULT_VIEW_TIME_MS = 0L;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.snapchat.kit.sdk.core.metrics.model.StoryKitEntryEvent#ADAPTER", tag = 10)
    public final StoryKitEntryEvent entry_event;
    @WireField(adapter = "com.snapchat.kit.sdk.core.metrics.model.StoryKitExitEvent#ADAPTER", tag = 11)
    public final StoryKitExitEvent exit_event;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", tag = 7)
    public final Long initial_stall_ms;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", tag = 6)
    public final Long media_duration_unchecked_ms;
    @WireField(adapter = "com.snapchat.kit.sdk.core.metrics.model.StoryKitMediaType#ADAPTER", tag = 5)
    public final StoryKitMediaType media_type;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String media_url;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String player_session_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String snap_id_unchecked;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", tag = 8)
    public final Long snap_view_index;
    @WireField(adapter = "com.snapchat.kit.sdk.core.metrics.model.StoryKitEventBase#ADAPTER", tag = 1)
    public final StoryKitEventBase story_kit_event_base;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", tag = 9)
    public final Long view_time_ms;

    public StoryKitSnapPlayback(StoryKitEventBase storyKitEventBase, String str, String str2, String str3, StoryKitMediaType storyKitMediaType, Long l, Long l2, Long l3, Long l4, StoryKitEntryEvent storyKitEntryEvent, StoryKitExitEvent storyKitExitEvent) {
        this(storyKitEventBase, str, str2, str3, storyKitMediaType, l, l2, l3, l4, storyKitEntryEvent, storyKitExitEvent, ByteString.EMPTY);
    }

    public StoryKitSnapPlayback(StoryKitEventBase storyKitEventBase, String str, String str2, String str3, StoryKitMediaType storyKitMediaType, Long l, Long l2, Long l3, Long l4, StoryKitEntryEvent storyKitEntryEvent, StoryKitExitEvent storyKitExitEvent, ByteString byteString) {
        super(ADAPTER, byteString);
        this.story_kit_event_base = storyKitEventBase;
        this.player_session_id = str;
        this.media_url = str2;
        this.snap_id_unchecked = str3;
        this.media_type = storyKitMediaType;
        this.media_duration_unchecked_ms = l;
        this.initial_stall_ms = l2;
        this.snap_view_index = l3;
        this.view_time_ms = l4;
        this.entry_event = storyKitEntryEvent;
        this.exit_event = storyKitExitEvent;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.story_kit_event_base = this.story_kit_event_base;
        builder.player_session_id = this.player_session_id;
        builder.media_url = this.media_url;
        builder.snap_id_unchecked = this.snap_id_unchecked;
        builder.media_type = this.media_type;
        builder.media_duration_unchecked_ms = this.media_duration_unchecked_ms;
        builder.initial_stall_ms = this.initial_stall_ms;
        builder.snap_view_index = this.snap_view_index;
        builder.view_time_ms = this.view_time_ms;
        builder.entry_event = this.entry_event;
        builder.exit_event = this.exit_event;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StoryKitSnapPlayback)) {
            return false;
        }
        StoryKitSnapPlayback storyKitSnapPlayback = (StoryKitSnapPlayback) obj;
        return unknownFields().equals(storyKitSnapPlayback.unknownFields()) && Internal.equals(this.story_kit_event_base, storyKitSnapPlayback.story_kit_event_base) && Internal.equals(this.player_session_id, storyKitSnapPlayback.player_session_id) && Internal.equals(this.media_url, storyKitSnapPlayback.media_url) && Internal.equals(this.snap_id_unchecked, storyKitSnapPlayback.snap_id_unchecked) && Internal.equals(this.media_type, storyKitSnapPlayback.media_type) && Internal.equals(this.media_duration_unchecked_ms, storyKitSnapPlayback.media_duration_unchecked_ms) && Internal.equals(this.initial_stall_ms, storyKitSnapPlayback.initial_stall_ms) && Internal.equals(this.snap_view_index, storyKitSnapPlayback.snap_view_index) && Internal.equals(this.view_time_ms, storyKitSnapPlayback.view_time_ms) && Internal.equals(this.entry_event, storyKitSnapPlayback.entry_event) && Internal.equals(this.exit_event, storyKitSnapPlayback.exit_event);
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
        String str2 = this.media_url;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.snap_id_unchecked;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        StoryKitMediaType storyKitMediaType = this.media_type;
        int hashCode6 = (hashCode5 + (storyKitMediaType != null ? storyKitMediaType.hashCode() : 0)) * 37;
        Long l = this.media_duration_unchecked_ms;
        int hashCode7 = (hashCode6 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.initial_stall_ms;
        int hashCode8 = (hashCode7 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.snap_view_index;
        int hashCode9 = (hashCode8 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.view_time_ms;
        int hashCode10 = (hashCode9 + (l4 != null ? l4.hashCode() : 0)) * 37;
        StoryKitEntryEvent storyKitEntryEvent = this.entry_event;
        int hashCode11 = (hashCode10 + (storyKitEntryEvent != null ? storyKitEntryEvent.hashCode() : 0)) * 37;
        StoryKitExitEvent storyKitExitEvent = this.exit_event;
        if (storyKitExitEvent != null) {
            i2 = storyKitExitEvent.hashCode();
        }
        int i3 = hashCode11 + i2;
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
        if (this.media_url != null) {
            sb.append(", media_url=");
            sb.append(this.media_url);
        }
        if (this.snap_id_unchecked != null) {
            sb.append(", snap_id_unchecked=");
            sb.append(this.snap_id_unchecked);
        }
        if (this.media_type != null) {
            sb.append(", media_type=");
            sb.append(this.media_type);
        }
        if (this.media_duration_unchecked_ms != null) {
            sb.append(", media_duration_unchecked_ms=");
            sb.append(this.media_duration_unchecked_ms);
        }
        if (this.initial_stall_ms != null) {
            sb.append(", initial_stall_ms=");
            sb.append(this.initial_stall_ms);
        }
        if (this.snap_view_index != null) {
            sb.append(", snap_view_index=");
            sb.append(this.snap_view_index);
        }
        if (this.view_time_ms != null) {
            sb.append(", view_time_ms=");
            sb.append(this.view_time_ms);
        }
        if (this.entry_event != null) {
            sb.append(", entry_event=");
            sb.append(this.entry_event);
        }
        if (this.exit_event != null) {
            sb.append(", exit_event=");
            sb.append(this.exit_event);
        }
        StringBuilder replace = sb.replace(0, 2, "StoryKitSnapPlayback{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<StoryKitSnapPlayback, Builder> {
        public StoryKitEntryEvent entry_event;
        public StoryKitExitEvent exit_event;
        public Long initial_stall_ms;
        public Long media_duration_unchecked_ms;
        public StoryKitMediaType media_type;
        public String media_url;
        public String player_session_id;
        public String snap_id_unchecked;
        public Long snap_view_index;
        public StoryKitEventBase story_kit_event_base;
        public Long view_time_ms;

        public final Builder story_kit_event_base(StoryKitEventBase storyKitEventBase) {
            this.story_kit_event_base = storyKitEventBase;
            return this;
        }

        public final Builder player_session_id(String str) {
            this.player_session_id = str;
            return this;
        }

        public final Builder media_url(String str) {
            this.media_url = str;
            return this;
        }

        public final Builder snap_id_unchecked(String str) {
            this.snap_id_unchecked = str;
            return this;
        }

        public final Builder media_type(StoryKitMediaType storyKitMediaType) {
            this.media_type = storyKitMediaType;
            return this;
        }

        public final Builder media_duration_unchecked_ms(Long l) {
            this.media_duration_unchecked_ms = l;
            return this;
        }

        public final Builder initial_stall_ms(Long l) {
            this.initial_stall_ms = l;
            return this;
        }

        public final Builder snap_view_index(Long l) {
            this.snap_view_index = l;
            return this;
        }

        public final Builder view_time_ms(Long l) {
            this.view_time_ms = l;
            return this;
        }

        public final Builder entry_event(StoryKitEntryEvent storyKitEntryEvent) {
            this.entry_event = storyKitEntryEvent;
            return this;
        }

        public final Builder exit_event(StoryKitExitEvent storyKitExitEvent) {
            this.exit_event = storyKitExitEvent;
            return this;
        }

        public final StoryKitSnapPlayback build() {
            return new StoryKitSnapPlayback(this.story_kit_event_base, this.player_session_id, this.media_url, this.snap_id_unchecked, this.media_type, this.media_duration_unchecked_ms, this.initial_stall_ms, this.snap_view_index, this.view_time_ms, this.entry_event, this.exit_event, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_StoryKitSnapPlayback extends ProtoAdapter<StoryKitSnapPlayback> {
        public ProtoAdapter_StoryKitSnapPlayback() {
            super(FieldEncoding.LENGTH_DELIMITED, StoryKitSnapPlayback.class);
        }

        public final int encodedSize(StoryKitSnapPlayback storyKitSnapPlayback) {
            return StoryKitEventBase.ADAPTER.encodedSizeWithTag(1, storyKitSnapPlayback.story_kit_event_base) + ProtoAdapter.STRING.encodedSizeWithTag(2, storyKitSnapPlayback.player_session_id) + ProtoAdapter.STRING.encodedSizeWithTag(3, storyKitSnapPlayback.media_url) + ProtoAdapter.STRING.encodedSizeWithTag(4, storyKitSnapPlayback.snap_id_unchecked) + StoryKitMediaType.ADAPTER.encodedSizeWithTag(5, storyKitSnapPlayback.media_type) + ProtoAdapter.UINT64.encodedSizeWithTag(6, storyKitSnapPlayback.media_duration_unchecked_ms) + ProtoAdapter.UINT64.encodedSizeWithTag(7, storyKitSnapPlayback.initial_stall_ms) + ProtoAdapter.UINT64.encodedSizeWithTag(8, storyKitSnapPlayback.snap_view_index) + ProtoAdapter.UINT64.encodedSizeWithTag(9, storyKitSnapPlayback.view_time_ms) + StoryKitEntryEvent.ADAPTER.encodedSizeWithTag(10, storyKitSnapPlayback.entry_event) + StoryKitExitEvent.ADAPTER.encodedSizeWithTag(11, storyKitSnapPlayback.exit_event) + storyKitSnapPlayback.unknownFields().size();
        }

        public final void encode(ProtoWriter protoWriter, StoryKitSnapPlayback storyKitSnapPlayback) throws IOException {
            StoryKitEventBase.ADAPTER.encodeWithTag(protoWriter, 1, storyKitSnapPlayback.story_kit_event_base);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, storyKitSnapPlayback.player_session_id);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, storyKitSnapPlayback.media_url);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, storyKitSnapPlayback.snap_id_unchecked);
            StoryKitMediaType.ADAPTER.encodeWithTag(protoWriter, 5, storyKitSnapPlayback.media_type);
            ProtoAdapter.UINT64.encodeWithTag(protoWriter, 6, storyKitSnapPlayback.media_duration_unchecked_ms);
            ProtoAdapter.UINT64.encodeWithTag(protoWriter, 7, storyKitSnapPlayback.initial_stall_ms);
            ProtoAdapter.UINT64.encodeWithTag(protoWriter, 8, storyKitSnapPlayback.snap_view_index);
            ProtoAdapter.UINT64.encodeWithTag(protoWriter, 9, storyKitSnapPlayback.view_time_ms);
            StoryKitEntryEvent.ADAPTER.encodeWithTag(protoWriter, 10, storyKitSnapPlayback.entry_event);
            StoryKitExitEvent.ADAPTER.encodeWithTag(protoWriter, 11, storyKitSnapPlayback.exit_event);
            protoWriter.writeBytes(storyKitSnapPlayback.unknownFields());
        }

        public final StoryKitSnapPlayback decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.story_kit_event_base(StoryKitEventBase.ADAPTER.decode(protoReader));
                            break;
                        case 2:
                            builder.player_session_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.media_url(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.snap_id_unchecked(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            try {
                                builder.media_type(StoryKitMediaType.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e) {
                                builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf((long) e.value));
                                break;
                            }
                        case 6:
                            builder.media_duration_unchecked_ms(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 7:
                            builder.initial_stall_ms(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 8:
                            builder.snap_view_index(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 9:
                            builder.view_time_ms(ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 10:
                            try {
                                builder.entry_event(StoryKitEntryEvent.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf((long) e2.value));
                                break;
                            }
                        case 11:
                            try {
                                builder.exit_event(StoryKitExitEvent.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e3) {
                                builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf((long) e3.value));
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

        public final StoryKitSnapPlayback redact(StoryKitSnapPlayback storyKitSnapPlayback) {
            Builder newBuilder = storyKitSnapPlayback.newBuilder();
            if (newBuilder.story_kit_event_base != null) {
                newBuilder.story_kit_event_base = StoryKitEventBase.ADAPTER.redact(newBuilder.story_kit_event_base);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
