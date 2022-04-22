package p015io.getstream.chat.android.client.api2.mapping;

import java.io.File;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api2.model.dto.AttachmentDto;
import p015io.getstream.chat.android.client.models.Attachment;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0000¨\u0006\u0004"}, mo26107d2 = {"toDomain", "Lio/getstream/chat/android/client/models/Attachment;", "Lio/getstream/chat/android/client/api2/model/dto/AttachmentDto;", "toDto", "stream-chat-android-client_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api2.mapping.AttachmentMappingKt */
/* compiled from: AttachmentMapping.kt */
public final class AttachmentMappingKt {
    public static final AttachmentDto toDto(Attachment attachment) {
        Intrinsics.checkNotNullParameter(attachment, "$this$toDto");
        return new AttachmentDto(attachment.getAssetUrl(), attachment.getAuthorName(), attachment.getFallback(), attachment.getFileSize(), attachment.getImage(), attachment.getImageUrl(), attachment.getMimeType(), attachment.getName(), attachment.getOgUrl(), attachment.getText(), attachment.getThumbUrl(), attachment.getTitle(), attachment.getTitleLink(), attachment.getType(), attachment.getUrl(), attachment.getExtraData());
    }

    public static final Attachment toDomain(AttachmentDto attachmentDto) {
        Intrinsics.checkNotNullParameter(attachmentDto, "$this$toDomain");
        String asset_url = attachmentDto.getAsset_url();
        String author_name = attachmentDto.getAuthor_name();
        String fallback = attachmentDto.getFallback();
        int file_size = attachmentDto.getFile_size();
        String image = attachmentDto.getImage();
        String image_url = attachmentDto.getImage_url();
        String mime_type = attachmentDto.getMime_type();
        String name = attachmentDto.getName();
        String og_scrape_url = attachmentDto.getOg_scrape_url();
        String text = attachmentDto.getText();
        return new Attachment(author_name, attachmentDto.getTitle_link(), attachmentDto.getThumb_url(), image_url, asset_url, og_scrape_url, mime_type, file_size, attachmentDto.getTitle(), text, attachmentDto.getType(), image, attachmentDto.getUrl(), name, fallback, (File) null, (Attachment.UploadState) null, MapsKt.toMutableMap(attachmentDto.getExtraData()), 98304, (DefaultConstructorMarker) null);
    }
}
