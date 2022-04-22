package p015io.getstream.chat.android.client.socket;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;
import p015io.getstream.chat.android.client.logger.TaggedLogger;
import p015io.getstream.chat.android.client.socket.ChatSocketServiceImpl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\b¨\u0006\t¸\u0006\u0000"}, mo26107d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.socket.ChatSocketServiceImpl$$special$$inlined$observable$1 */
/* compiled from: Delegates.kt */
public final class ChatSocketServiceImpl$$special$$inlined$observable$1 extends ObservableProperty<ChatSocketServiceImpl.State> {
    final /* synthetic */ Object $initialValue;
    final /* synthetic */ ChatSocketServiceImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatSocketServiceImpl$$special$$inlined$observable$1(Object obj, Object obj2, ChatSocketServiceImpl chatSocketServiceImpl) {
        super(obj2);
        this.$initialValue = obj;
        this.this$0 = chatSocketServiceImpl;
    }

    /* access modifiers changed from: protected */
    public void afterChange(KProperty<?> kProperty, ChatSocketServiceImpl.State state, ChatSocketServiceImpl.State state2) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        ChatSocketServiceImpl.State state3 = state2;
        if (!Intrinsics.areEqual((Object) state, (Object) state3)) {
            TaggedLogger access$getLogger$p = this.this$0.logger;
            access$getLogger$p.logI("updateState: " + state3.getClass().getSimpleName());
            if (state3 instanceof ChatSocketServiceImpl.State.Connecting) {
                this.this$0.healthMonitor.stop();
                this.this$0.callListeners(ChatSocketServiceImpl$state$2$1.INSTANCE);
            } else if (state3 instanceof ChatSocketServiceImpl.State.Connected) {
                this.this$0.healthMonitor.start();
                this.this$0.callListeners(new ChatSocketServiceImpl$$special$$inlined$observable$1$lambda$1(state3));
            } else if (state3 instanceof ChatSocketServiceImpl.State.NetworkDisconnected) {
                this.this$0.releaseSocket();
                this.this$0.healthMonitor.stop();
                this.this$0.callListeners(ChatSocketServiceImpl$state$2$3.INSTANCE);
            } else if (state3 instanceof ChatSocketServiceImpl.State.Disconnected) {
                this.this$0.releaseSocket();
                this.this$0.healthMonitor.onDisconnected();
                this.this$0.callListeners(ChatSocketServiceImpl$state$2$4.INSTANCE);
            } else if (state3 instanceof ChatSocketServiceImpl.State.DisconnectedPermanently) {
                this.this$0.releaseSocket();
                this.this$0.connectionConf = ChatSocketServiceImpl.ConnectionConf.None.INSTANCE;
                this.this$0.networkStateProvider.unsubscribe(this.this$0.networkStateListener);
                this.this$0.healthMonitor.stop();
                this.this$0.callListeners(ChatSocketServiceImpl$state$2$5.INSTANCE);
            }
        }
    }
}
