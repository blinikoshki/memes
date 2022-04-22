package com.getstream.sdk.chat.viewmodel.messages;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.models.Attachment;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Lio/getstream/chat/android/client/utils/Result;", "Lio/getstream/chat/android/client/models/Message;", "onResult"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListViewModel.kt */
final class MessageListViewModel$onEvent$2<T> implements Call.Callback<Message> {
    final /* synthetic */ Attachment $attachmentToBeDeleted;
    final /* synthetic */ MessageListViewModel this$0;

    MessageListViewModel$onEvent$2(MessageListViewModel messageListViewModel, Attachment attachment) {
        this.this$0 = messageListViewModel;
        this.$attachmentToBeDeleted = attachment;
    }

    public final void onResult(Result<Message> result) {
        Intrinsics.checkNotNullParameter(result, "it");
        if (result.isSuccess()) {
            Message data = result.data();
            CollectionsKt.removeAll(data.getAttachments(), new Function1<Attachment, Boolean>(this) {
                final /* synthetic */ MessageListViewModel$onEvent$2 this$0;

                {
                    this.this$0 = r1;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((Attachment) obj));
                }

                public final boolean invoke(Attachment attachment) {
                    Intrinsics.checkNotNullParameter(attachment, "it");
                    if (this.this$0.$attachmentToBeDeleted.getAssetUrl() != null) {
                        return Intrinsics.areEqual((Object) attachment.getAssetUrl(), (Object) this.this$0.$attachmentToBeDeleted.getAssetUrl());
                    }
                    return Intrinsics.areEqual((Object) attachment.getImageUrl(), (Object) this.this$0.$attachmentToBeDeleted.getImageUrl());
                }
            });
            this.this$0.domain.getUseCases().getEditMessage().invoke(data).enqueue();
        }
    }
}
