package coil;

import coil.EventListener;
import coil.request.ImageRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "Lcoil/EventListener;", "it", "Lcoil/request/ImageRequest;", "create"}, mo26108k = 3, mo26109mv = {1, 4, 1})
/* compiled from: EventListener.kt */
final class EventListener$Factory$Companion$invoke$1 implements EventListener.Factory {
    final /* synthetic */ EventListener $listener;

    EventListener$Factory$Companion$invoke$1(EventListener eventListener) {
        this.$listener = eventListener;
    }

    public final EventListener create(ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, "it");
        return this.$listener;
    }
}
