package p015io.getstream.chat.android.livedata.repository.domain.message.attachment;

import com.google.firebase.messaging.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BÉ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\u0010\u0019J\t\u00105\u001a\u00020\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0015\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0018HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010G\u001a\u00020\fHÆ\u0003Jó\u0001\u0010H\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0018HÆ\u0001J\u0013\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010L\u001a\u00020\fHÖ\u0001J\t\u0010M\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u001d\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010!\"\u0004\b$\u0010%R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001bR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001b¨\u0006N"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/message/attachment/AttachmentEntity;", "", "messageId", "", "authorName", "titleLink", "thumbUrl", "imageUrl", "assetUrl", "ogUrl", "mimeType", "fileSize", "", "title", "text", "type", "image", "url", "name", "fallback", "uploadFilePath", "uploadState", "Lio/getstream/chat/android/livedata/repository/domain/message/attachment/UploadStateEntity;", "extraData", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/getstream/chat/android/livedata/repository/domain/message/attachment/UploadStateEntity;Ljava/util/Map;)V", "getAssetUrl", "()Ljava/lang/String;", "getAuthorName", "getExtraData", "()Ljava/util/Map;", "getFallback", "getFileSize", "()I", "id", "getId", "setId", "(I)V", "getImage", "getImageUrl", "getMessageId", "getMimeType", "getName", "getOgUrl", "getText", "getThumbUrl", "getTitle", "getTitleLink", "getType", "getUploadFilePath", "getUploadState", "()Lio/getstream/chat/android/livedata/repository/domain/message/attachment/UploadStateEntity;", "getUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.message.attachment.AttachmentEntity */
/* compiled from: AttachmentEntity.kt */
public final class AttachmentEntity {
    private final String assetUrl;
    private final String authorName;
    private final Map<String, Object> extraData;
    private final String fallback;
    private final int fileSize;

    /* renamed from: id */
    private int f1468id = hashCode();
    private final String image;
    private final String imageUrl;
    private final String messageId;
    private final String mimeType;
    private final String name;
    private final String ogUrl;
    private final String text;
    private final String thumbUrl;
    private final String title;
    private final String titleLink;
    private final String type;
    private final String uploadFilePath;
    private final UploadStateEntity uploadState;
    private final String url;

    public static /* synthetic */ AttachmentEntity copy$default(AttachmentEntity attachmentEntity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, UploadStateEntity uploadStateEntity, Map map, int i2, Object obj) {
        AttachmentEntity attachmentEntity2 = attachmentEntity;
        int i3 = i2;
        return attachmentEntity.copy((i3 & 1) != 0 ? attachmentEntity2.messageId : str, (i3 & 2) != 0 ? attachmentEntity2.authorName : str2, (i3 & 4) != 0 ? attachmentEntity2.titleLink : str3, (i3 & 8) != 0 ? attachmentEntity2.thumbUrl : str4, (i3 & 16) != 0 ? attachmentEntity2.imageUrl : str5, (i3 & 32) != 0 ? attachmentEntity2.assetUrl : str6, (i3 & 64) != 0 ? attachmentEntity2.ogUrl : str7, (i3 & 128) != 0 ? attachmentEntity2.mimeType : str8, (i3 & 256) != 0 ? attachmentEntity2.fileSize : i, (i3 & 512) != 0 ? attachmentEntity2.title : str9, (i3 & 1024) != 0 ? attachmentEntity2.text : str10, (i3 & 2048) != 0 ? attachmentEntity2.type : str11, (i3 & 4096) != 0 ? attachmentEntity2.image : str12, (i3 & 8192) != 0 ? attachmentEntity2.url : str13, (i3 & 16384) != 0 ? attachmentEntity2.name : str14, (i3 & 32768) != 0 ? attachmentEntity2.fallback : str15, (i3 & 65536) != 0 ? attachmentEntity2.uploadFilePath : str16, (i3 & 131072) != 0 ? attachmentEntity2.uploadState : uploadStateEntity, (i3 & 262144) != 0 ? attachmentEntity2.extraData : map);
    }

    public final String component1() {
        return this.messageId;
    }

    public final String component10() {
        return this.title;
    }

    public final String component11() {
        return this.text;
    }

    public final String component12() {
        return this.type;
    }

    public final String component13() {
        return this.image;
    }

    public final String component14() {
        return this.url;
    }

    public final String component15() {
        return this.name;
    }

    public final String component16() {
        return this.fallback;
    }

    public final String component17() {
        return this.uploadFilePath;
    }

    public final UploadStateEntity component18() {
        return this.uploadState;
    }

    public final Map<String, Object> component19() {
        return this.extraData;
    }

    public final String component2() {
        return this.authorName;
    }

    public final String component3() {
        return this.titleLink;
    }

    public final String component4() {
        return this.thumbUrl;
    }

    public final String component5() {
        return this.imageUrl;
    }

    public final String component6() {
        return this.assetUrl;
    }

    public final String component7() {
        return this.ogUrl;
    }

    public final String component8() {
        return this.mimeType;
    }

    public final int component9() {
        return this.fileSize;
    }

    public final AttachmentEntity copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, UploadStateEntity uploadStateEntity, Map<String, ? extends Object> map) {
        String str17 = str;
        Intrinsics.checkNotNullParameter(str17, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        Intrinsics.checkNotNullParameter(map, "extraData");
        return new AttachmentEntity(str17, str2, str3, str4, str5, str6, str7, str8, i, str9, str10, str11, str12, str13, str14, str15, str16, uploadStateEntity, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AttachmentEntity)) {
            return false;
        }
        AttachmentEntity attachmentEntity = (AttachmentEntity) obj;
        return Intrinsics.areEqual((Object) this.messageId, (Object) attachmentEntity.messageId) && Intrinsics.areEqual((Object) this.authorName, (Object) attachmentEntity.authorName) && Intrinsics.areEqual((Object) this.titleLink, (Object) attachmentEntity.titleLink) && Intrinsics.areEqual((Object) this.thumbUrl, (Object) attachmentEntity.thumbUrl) && Intrinsics.areEqual((Object) this.imageUrl, (Object) attachmentEntity.imageUrl) && Intrinsics.areEqual((Object) this.assetUrl, (Object) attachmentEntity.assetUrl) && Intrinsics.areEqual((Object) this.ogUrl, (Object) attachmentEntity.ogUrl) && Intrinsics.areEqual((Object) this.mimeType, (Object) attachmentEntity.mimeType) && this.fileSize == attachmentEntity.fileSize && Intrinsics.areEqual((Object) this.title, (Object) attachmentEntity.title) && Intrinsics.areEqual((Object) this.text, (Object) attachmentEntity.text) && Intrinsics.areEqual((Object) this.type, (Object) attachmentEntity.type) && Intrinsics.areEqual((Object) this.image, (Object) attachmentEntity.image) && Intrinsics.areEqual((Object) this.url, (Object) attachmentEntity.url) && Intrinsics.areEqual((Object) this.name, (Object) attachmentEntity.name) && Intrinsics.areEqual((Object) this.fallback, (Object) attachmentEntity.fallback) && Intrinsics.areEqual((Object) this.uploadFilePath, (Object) attachmentEntity.uploadFilePath) && Intrinsics.areEqual((Object) this.uploadState, (Object) attachmentEntity.uploadState) && Intrinsics.areEqual((Object) this.extraData, (Object) attachmentEntity.extraData);
    }

    public int hashCode() {
        String str = this.messageId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.authorName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.titleLink;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.thumbUrl;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.imageUrl;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.assetUrl;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.ogUrl;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.mimeType;
        int hashCode8 = (((hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31) + this.fileSize) * 31;
        String str9 = this.title;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.text;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.type;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.image;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.url;
        int hashCode13 = (hashCode12 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.name;
        int hashCode14 = (hashCode13 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.fallback;
        int hashCode15 = (hashCode14 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.uploadFilePath;
        int hashCode16 = (hashCode15 + (str16 != null ? str16.hashCode() : 0)) * 31;
        UploadStateEntity uploadStateEntity = this.uploadState;
        int hashCode17 = (hashCode16 + (uploadStateEntity != null ? uploadStateEntity.hashCode() : 0)) * 31;
        Map<String, Object> map = this.extraData;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode17 + i;
    }

    public String toString() {
        return "AttachmentEntity(messageId=" + this.messageId + ", authorName=" + this.authorName + ", titleLink=" + this.titleLink + ", thumbUrl=" + this.thumbUrl + ", imageUrl=" + this.imageUrl + ", assetUrl=" + this.assetUrl + ", ogUrl=" + this.ogUrl + ", mimeType=" + this.mimeType + ", fileSize=" + this.fileSize + ", title=" + this.title + ", text=" + this.text + ", type=" + this.type + ", image=" + this.image + ", url=" + this.url + ", name=" + this.name + ", fallback=" + this.fallback + ", uploadFilePath=" + this.uploadFilePath + ", uploadState=" + this.uploadState + ", extraData=" + this.extraData + ")";
    }

    public AttachmentEntity(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, UploadStateEntity uploadStateEntity, Map<String, ? extends Object> map) {
        Map<String, ? extends Object> map2 = map;
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        Intrinsics.checkNotNullParameter(map2, "extraData");
        this.messageId = str;
        this.authorName = str2;
        this.titleLink = str3;
        this.thumbUrl = str4;
        this.imageUrl = str5;
        this.assetUrl = str6;
        this.ogUrl = str7;
        this.mimeType = str8;
        this.fileSize = i;
        this.title = str9;
        this.text = str10;
        this.type = str11;
        this.image = str12;
        this.url = str13;
        this.name = str14;
        this.fallback = str15;
        this.uploadFilePath = str16;
        this.uploadState = uploadStateEntity;
        this.extraData = map2;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getAuthorName() {
        return this.authorName;
    }

    public final String getTitleLink() {
        return this.titleLink;
    }

    public final String getThumbUrl() {
        return this.thumbUrl;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getAssetUrl() {
        return this.assetUrl;
    }

    public final String getOgUrl() {
        return this.ogUrl;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final int getFileSize() {
        return this.fileSize;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getText() {
        return this.text;
    }

    public final String getType() {
        return this.type;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getName() {
        return this.name;
    }

    public final String getFallback() {
        return this.fallback;
    }

    public final String getUploadFilePath() {
        return this.uploadFilePath;
    }

    public final UploadStateEntity getUploadState() {
        return this.uploadState;
    }

    public final Map<String, Object> getExtraData() {
        return this.extraData;
    }

    public final int getId() {
        return this.f1468id;
    }

    public final void setId(int i) {
        this.f1468id = i;
    }
}
