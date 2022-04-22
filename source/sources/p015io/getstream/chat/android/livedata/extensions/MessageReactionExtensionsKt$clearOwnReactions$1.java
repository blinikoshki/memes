package p015io.getstream.chat.android.livedata.extensions;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.models.Reaction;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "it", "Lio/getstream/chat/android/client/models/Reaction;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.extensions.MessageReactionExtensionsKt$clearOwnReactions$1 */
/* compiled from: MessageReactionExtensions.kt */
final class MessageReactionExtensionsKt$clearOwnReactions$1 extends Lambda implements Function1<Reaction, Boolean> {
    final /* synthetic */ String $userId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageReactionExtensionsKt$clearOwnReactions$1(String str) {
        super(1);
        this.$userId = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((Reaction) obj));
    }

    public final boolean invoke(Reaction reaction) {
        Intrinsics.checkNotNullParameter(reaction, "it");
        return Intrinsics.areEqual((Object) reaction.getUserId(), (Object) this.$userId);
    }
}
