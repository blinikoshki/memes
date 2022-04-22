package p015io.getstream.chat.android.client.helpers;

import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import p015io.getstream.chat.android.client.models.Attachment;
import p015io.getstream.chat.android.client.utils.SystemTimeProvider;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Lio/getstream/chat/android/client/helpers/AttachmentHelper;", "", "systemTimeProvider", "Lio/getstream/chat/android/client/utils/SystemTimeProvider;", "(Lio/getstream/chat/android/client/utils/SystemTimeProvider;)V", "hasValidImageUrl", "", "attachment", "Lio/getstream/chat/android/client/models/Attachment;", "Companion", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.helpers.AttachmentHelper */
/* compiled from: AttachmentHelper.kt */
public final class AttachmentHelper {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String QUERY_KEY_NAME_EXPIRES = "Expires";
    private final SystemTimeProvider systemTimeProvider;

    public AttachmentHelper() {
        this((SystemTimeProvider) null, 1, (DefaultConstructorMarker) null);
    }

    public AttachmentHelper(SystemTimeProvider systemTimeProvider2) {
        Intrinsics.checkNotNullParameter(systemTimeProvider2, "systemTimeProvider");
        this.systemTimeProvider = systemTimeProvider2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AttachmentHelper(SystemTimeProvider systemTimeProvider2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new SystemTimeProvider() : systemTimeProvider2);
    }

    public final boolean hasValidImageUrl(Attachment attachment) {
        HttpUrl parse;
        Long longOrNull;
        Intrinsics.checkNotNullParameter(attachment, MessengerShareContentUtility.ATTACHMENT);
        String imageUrl = attachment.getImageUrl();
        if (imageUrl == null || (parse = HttpUrl.Companion.parse(imageUrl)) == null) {
            return false;
        }
        if (!parse.queryParameterNames().contains("Expires")) {
            return true;
        }
        String queryParameter = parse.queryParameter("Expires");
        if (queryParameter == null || (longOrNull = StringsKt.toLongOrNull(queryParameter)) == null || longOrNull.longValue() <= this.systemTimeProvider.provideCurrentTimeInSeconds()) {
            return false;
        }
        return true;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lio/getstream/chat/android/client/helpers/AttachmentHelper$Companion;", "", "()V", "QUERY_KEY_NAME_EXPIRES", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.helpers.AttachmentHelper$Companion */
    /* compiled from: AttachmentHelper.kt */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
