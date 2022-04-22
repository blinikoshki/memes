package p015io.getstream.chat.android.livedata;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.livedata.repository.builder.RepositoryFacadeBuilder;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, mo26107d2 = {"<anonymous>", "", "Lio/getstream/chat/android/livedata/repository/builder/RepositoryFacadeBuilder;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.ChatDomainImpl$setUser$1 */
/* compiled from: ChatDomainImpl.kt */
final class ChatDomainImpl$setUser$1 extends Lambda implements Function1<RepositoryFacadeBuilder, Unit> {
    final /* synthetic */ ChatDomainImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatDomainImpl$setUser$1(ChatDomainImpl chatDomainImpl) {
        super(1);
        this.this$0 = chatDomainImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RepositoryFacadeBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(RepositoryFacadeBuilder repositoryFacadeBuilder) {
        Intrinsics.checkNotNullParameter(repositoryFacadeBuilder, "$receiver");
        repositoryFacadeBuilder.context(this.this$0.getAppContext$stream_chat_android_offline_release());
        repositoryFacadeBuilder.database(this.this$0.getDb$stream_chat_android_offline_release());
        repositoryFacadeBuilder.currentUser(this.this$0.getCurrentUser());
        repositoryFacadeBuilder.scope(this.this$0.getScope$stream_chat_android_offline_release());
        repositoryFacadeBuilder.defaultConfig(this.this$0.getDefaultConfig());
        repositoryFacadeBuilder.setOfflineEnabled(this.this$0.getOfflineEnabled());
    }
}
