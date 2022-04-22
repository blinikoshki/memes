package p015io.getstream.chat.android.client.p049di;

import com.moczul.ok2curl.logger.Loggable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.logger.ChatLogger;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "log"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.di.BaseChatModule$clientBuilder$1 */
/* compiled from: BaseChatModule.kt */
final class BaseChatModule$clientBuilder$1 implements Loggable {
    final /* synthetic */ BaseChatModule this$0;

    BaseChatModule$clientBuilder$1(BaseChatModule baseChatModule) {
        this.this$0 = baseChatModule;
    }

    public final void log(String str) {
        ChatLogger logger = this.this$0.logger();
        Intrinsics.checkNotNullExpressionValue(str, "it");
        logger.logI("CURL", str);
    }
}
