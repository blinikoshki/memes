package p015io.getstream.chat.android.client.api.models;

import java.util.Objects;
import kotlin.Metadata;
import p015io.getstream.chat.android.client.api.models.ChannelRequest;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b`\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002J\r\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J\r\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J\r\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J\r\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J\r\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J\r\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010R\u0018\u0010\u0003\u001a\u00020\u0004X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u00020\u0004X¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0018\u0010\f\u001a\u00020\u0004X¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0016"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/ChannelRequest;", "T", "", "presence", "", "getPresence", "()Z", "setPresence", "(Z)V", "state", "getState", "setState", "watch", "getWatch", "setWatch", "noPresence", "()Lio/getstream/chat/android/client/api/models/ChannelRequest;", "noState", "noWatch", "withPresence", "withState", "withWatch", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.ChannelRequest */
/* compiled from: ChannelRequest.kt */
public interface ChannelRequest<T extends ChannelRequest<T>> {
    boolean getPresence();

    boolean getState();

    boolean getWatch();

    T noPresence();

    T noState();

    T noWatch();

    void setPresence(boolean z);

    void setState(boolean z);

    void setWatch(boolean z);

    T withPresence();

    T withState();

    T withWatch();

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.api.models.ChannelRequest$DefaultImpls */
    /* compiled from: ChannelRequest.kt */
    public static final class DefaultImpls {
        public static <T extends ChannelRequest<T>> T withWatch(ChannelRequest<T> channelRequest) {
            channelRequest.setWatch(true);
            Objects.requireNonNull(channelRequest, "null cannot be cast to non-null type T");
            return channelRequest;
        }

        public static <T extends ChannelRequest<T>> T withState(ChannelRequest<T> channelRequest) {
            channelRequest.setState(true);
            Objects.requireNonNull(channelRequest, "null cannot be cast to non-null type T");
            return channelRequest;
        }

        public static <T extends ChannelRequest<T>> T noWatch(ChannelRequest<T> channelRequest) {
            channelRequest.setWatch(false);
            Objects.requireNonNull(channelRequest, "null cannot be cast to non-null type T");
            return channelRequest;
        }

        public static <T extends ChannelRequest<T>> T noState(ChannelRequest<T> channelRequest) {
            channelRequest.setState(false);
            Objects.requireNonNull(channelRequest, "null cannot be cast to non-null type T");
            return channelRequest;
        }

        public static <T extends ChannelRequest<T>> T withPresence(ChannelRequest<T> channelRequest) {
            channelRequest.setPresence(true);
            Objects.requireNonNull(channelRequest, "null cannot be cast to non-null type T");
            return channelRequest;
        }

        public static <T extends ChannelRequest<T>> T noPresence(ChannelRequest<T> channelRequest) {
            channelRequest.setPresence(false);
            Objects.requireNonNull(channelRequest, "null cannot be cast to non-null type T");
            return channelRequest;
        }
    }
}
