package editor.common.mediaplayback;

import com.google.android.exoplayer2.SimpleExoPlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MediaPlaybackOrganiser.kt */
final /* synthetic */ class MediaPlaybackOrganiser$pauseSafely$1 extends MutablePropertyReference0Impl {
    MediaPlaybackOrganiser$pauseSafely$1(MediaPlaybackOrganiser mediaPlaybackOrganiser) {
        super(mediaPlaybackOrganiser, MediaPlaybackOrganiser.class, "player", "getPlayer()Lcom/google/android/exoplayer2/SimpleExoPlayer;", 0);
    }

    public Object get() {
        return MediaPlaybackOrganiser.access$getPlayer$p((MediaPlaybackOrganiser) this.receiver);
    }

    public void set(Object obj) {
        ((MediaPlaybackOrganiser) this.receiver).player = (SimpleExoPlayer) obj;
    }
}
