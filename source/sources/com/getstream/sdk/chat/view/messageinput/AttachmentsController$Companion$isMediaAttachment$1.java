package com.getstream.sdk.chat.view.messageinput;

import com.getstream.sdk.chat.model.AttachmentMetaData;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "it", "Lcom/getstream/sdk/chat/model/AttachmentMetaData;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: AttachmentsController.kt */
final class AttachmentsController$Companion$isMediaAttachment$1 extends Lambda implements Function1<AttachmentMetaData, Boolean> {
    public static final AttachmentsController$Companion$isMediaAttachment$1 INSTANCE = new AttachmentsController$Companion$isMediaAttachment$1();

    AttachmentsController$Companion$isMediaAttachment$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((AttachmentMetaData) obj));
    }

    public final boolean invoke(AttachmentMetaData attachmentMetaData) {
        Intrinsics.checkNotNullParameter(attachmentMetaData, "it");
        return CollectionsKt.contains(AttachmentsController.listOfMediaTypes, attachmentMetaData.getType());
    }
}
