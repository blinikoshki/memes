package p015io.getstream.chat.android.livedata.usecase;

import kotlin.Metadata;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.models.Reaction;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\tH§\u0002¨\u0006\n"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/usecase/SendReaction;", "", "invoke", "Lio/getstream/chat/android/client/call/Call;", "Lio/getstream/chat/android/client/models/Reaction;", "cid", "", "reaction", "enforceUnique", "", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.usecase.SendReaction */
/* compiled from: SendReactionImpl.kt */
public interface SendReaction {
    Call<Reaction> invoke(String str, Reaction reaction, boolean z);

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.livedata.usecase.SendReaction$DefaultImpls */
    /* compiled from: SendReactionImpl.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Call invoke$default(SendReaction sendReaction, String str, Reaction reaction, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    z = false;
                }
                return sendReaction.invoke(str, reaction, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
        }
    }
}
