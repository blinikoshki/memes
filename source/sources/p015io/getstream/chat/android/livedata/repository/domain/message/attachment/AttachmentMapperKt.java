package p015io.getstream.chat.android.livedata.repository.domain.message.attachment;

import com.google.firebase.messaging.Constants;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.models.Attachment;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0005*\u00020\u0006H\u0002\u001a\f\u0010\u0007\u001a\u00020\u0002*\u00020\u0001H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0005H\u0002¨\u0006\b"}, mo26107d2 = {"toEntity", "Lio/getstream/chat/android/livedata/repository/domain/message/attachment/AttachmentEntity;", "Lio/getstream/chat/android/client/models/Attachment;", "messageId", "", "Lio/getstream/chat/android/livedata/repository/domain/message/attachment/UploadStateEntity;", "Lio/getstream/chat/android/client/models/Attachment$UploadState;", "toModel", "stream-chat-android-offline_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.message.attachment.AttachmentMapperKt */
/* compiled from: AttachmentMapper.kt */
public final class AttachmentMapperKt {
    public static final AttachmentEntity toEntity(Attachment attachment, String str) {
        Intrinsics.checkNotNullParameter(attachment, "$this$toEntity");
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        String authorName = attachment.getAuthorName();
        String titleLink = attachment.getTitleLink();
        String thumbUrl = attachment.getThumbUrl();
        String imageUrl = attachment.getImageUrl();
        String assetUrl = attachment.getAssetUrl();
        String ogUrl = attachment.getOgUrl();
        String mimeType = attachment.getMimeType();
        int fileSize = attachment.getFileSize();
        String title = attachment.getTitle();
        String text = attachment.getText();
        String type = attachment.getType();
        String image = attachment.getImage();
        String url = attachment.getUrl();
        String name = attachment.getName();
        String fallback = attachment.getFallback();
        File upload = attachment.getUpload();
        UploadStateEntity uploadStateEntity = null;
        String absolutePath = upload != null ? upload.getAbsolutePath() : null;
        Attachment.UploadState uploadState = attachment.getUploadState();
        if (uploadState != null) {
            uploadStateEntity = toEntity(uploadState);
        }
        return new AttachmentEntity(str, authorName, titleLink, thumbUrl, imageUrl, assetUrl, ogUrl, mimeType, fileSize, title, text, type, image, url, name, fallback, absolutePath, uploadStateEntity, attachment.getExtraData());
    }

    public static final Attachment toModel(AttachmentEntity attachmentEntity) {
        Intrinsics.checkNotNullParameter(attachmentEntity, "$this$toModel");
        String authorName = attachmentEntity.getAuthorName();
        String titleLink = attachmentEntity.getTitleLink();
        String thumbUrl = attachmentEntity.getThumbUrl();
        String imageUrl = attachmentEntity.getImageUrl();
        String assetUrl = attachmentEntity.getAssetUrl();
        String ogUrl = attachmentEntity.getOgUrl();
        String mimeType = attachmentEntity.getMimeType();
        int fileSize = attachmentEntity.getFileSize();
        String title = attachmentEntity.getTitle();
        String text = attachmentEntity.getText();
        String type = attachmentEntity.getType();
        String image = attachmentEntity.getImage();
        String url = attachmentEntity.getUrl();
        String name = attachmentEntity.getName();
        String fallback = attachmentEntity.getFallback();
        String uploadFilePath = attachmentEntity.getUploadFilePath();
        File file = uploadFilePath != null ? new File(uploadFilePath) : null;
        UploadStateEntity uploadState = attachmentEntity.getUploadState();
        return new Attachment(authorName, titleLink, thumbUrl, imageUrl, assetUrl, ogUrl, mimeType, fileSize, title, text, type, image, url, name, fallback, file, uploadState != null ? toModel(uploadState) : null, MapsKt.toMutableMap(attachmentEntity.getExtraData()));
    }

    private static final UploadStateEntity toEntity(Attachment.UploadState uploadState) {
        Pair pair;
        String str = null;
        if (uploadState instanceof Attachment.UploadState.Success) {
            pair = TuplesKt.m181to(1, null);
        } else if (uploadState instanceof Attachment.UploadState.InProgress) {
            pair = TuplesKt.m181to(2, null);
        } else if (uploadState instanceof Attachment.UploadState.Failed) {
            Attachment.UploadState.Failed failed = (Attachment.UploadState.Failed) uploadState;
            String message = failed.getError().getMessage();
            if (message != null) {
                str = message;
            } else {
                Throwable cause = failed.getError().getCause();
                if (cause != null) {
                    str = cause.getLocalizedMessage();
                }
            }
            pair = TuplesKt.m181to(3, str);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return new UploadStateEntity(((Number) pair.component1()).intValue(), (String) pair.component2());
    }

    private static final Attachment.UploadState toModel(UploadStateEntity uploadStateEntity) {
        int statusCode = uploadStateEntity.getStatusCode();
        if (statusCode == 1) {
            return Attachment.UploadState.Success.INSTANCE;
        }
        if (statusCode == 2) {
            return Attachment.UploadState.InProgress.INSTANCE;
        }
        if (statusCode == 3) {
            return new Attachment.UploadState.Failed(new ChatError(uploadStateEntity.getErrorMessage(), (Throwable) null, 2, (DefaultConstructorMarker) null));
        }
        throw new IllegalStateException(("Integer value of " + uploadStateEntity.getStatusCode() + " can't be mapped to UploadState").toString());
    }
}
