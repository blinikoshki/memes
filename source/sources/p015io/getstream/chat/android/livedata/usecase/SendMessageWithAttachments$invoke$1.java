package p015io.getstream.chat.android.livedata.usecase;

import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.models.Attachment;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "Lio/getstream/chat/android/client/models/Attachment;", "it", "Ljava/io/File;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.usecase.SendMessageWithAttachments$invoke$1 */
/* compiled from: SendMessageWithAttachmentsImpl.kt */
final class SendMessageWithAttachments$invoke$1 extends Lambda implements Function2<Attachment, File, Unit> {
    public static final SendMessageWithAttachments$invoke$1 INSTANCE = new SendMessageWithAttachments$invoke$1();

    SendMessageWithAttachments$invoke$1() {
        super(2);
    }

    public final void invoke(Attachment attachment, File file) {
        Intrinsics.checkNotNullParameter(attachment, "$receiver");
        Intrinsics.checkNotNullParameter(file, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Attachment) obj, (File) obj2);
        return Unit.INSTANCE;
    }
}
