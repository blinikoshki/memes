package p015io.getstream.chat.android.client.parser2;

import com.squareup.moshi.Moshi;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo26107d2 = {"<anonymous>", "Lcom/squareup/moshi/Moshi;", "kotlin.jvm.PlatformType", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.parser2.MoshiChatParser$moshi$2 */
/* compiled from: MoshiChatParser.kt */
final class MoshiChatParser$moshi$2 extends Lambda implements Function0<Moshi> {
    final /* synthetic */ MoshiChatParser this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MoshiChatParser$moshi$2(MoshiChatParser moshiChatParser) {
        super(0);
        this.this$0 = moshiChatParser;
    }

    public final Moshi invoke() {
        Moshi.Builder builder = new Moshi.Builder();
        builder.add(Date.class, new DateAdapter());
        return builder.add((Object) DownstreamMessageDtoAdapter.INSTANCE).add((Object) UpstreamMessageDtoAdapter.INSTANCE).add((Object) AttachmentDtoAdapter.INSTANCE).add((Object) ReactionDtoAdapter.INSTANCE).add((Object) UserDtoAdapter.INSTANCE).build();
    }
}
