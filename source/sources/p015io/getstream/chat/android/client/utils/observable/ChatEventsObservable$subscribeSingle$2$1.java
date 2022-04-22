package p015io.getstream.chat.android.client.utils.observable;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.utils.observable.ChatEventsObservable$subscribeSingle$2$1 */
/* compiled from: ChatEventsObservable.kt */
final /* synthetic */ class ChatEventsObservable$subscribeSingle$2$1 extends FunctionReferenceImpl implements Function0<Unit> {
    ChatEventsObservable$subscribeSingle$2$1(SubscriptionImpl subscriptionImpl) {
        super(0, subscriptionImpl, SubscriptionImpl.class, "dispose", "dispose()V", 0);
    }

    public final void invoke() {
        ((SubscriptionImpl) this.receiver).dispose();
    }
}
