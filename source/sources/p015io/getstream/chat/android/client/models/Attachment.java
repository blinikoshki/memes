package p015io.getstream.chat.android.client.models;

import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.models.CustomObject;
import p015io.getstream.chat.android.client.parser.IgnoreDeserialisation;
import p015io.getstream.chat.android.client.parser.IgnoreSerialisation;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\bC\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001:\u0001aBå\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0002\u0010\u001aJ\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0015\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00190\u0018HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u000bHÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jé\u0001\u0010[\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00190\u0018HÆ\u0001J\u0013\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010_\u001a\u00020\u000bHÖ\u0001J\t\u0010`\u001a\u00020\u0003HÖ\u0001R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR*\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00190\u00188\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R \u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001c\"\u0004\b,\u0010\u001eR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u001eR \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u0010\u001eR \u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001c\"\u0004\b2\u0010\u001eR \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001c\"\u0004\b6\u0010\u001eR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001c\"\u0004\b8\u0010\u001eR \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001c\"\u0004\b:\u0010\u001eR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001c\"\u0004\b<\u0010\u001eR \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001c\"\u0004\b>\u0010\u001eR \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR \u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u001c\"\u0004\bH\u0010\u001e¨\u0006b"}, mo26107d2 = {"Lio/getstream/chat/android/client/models/Attachment;", "Lio/getstream/chat/android/client/models/CustomObject;", "authorName", "", "titleLink", "thumbUrl", "imageUrl", "assetUrl", "ogUrl", "mimeType", "fileSize", "", "title", "text", "type", "image", "url", "name", "fallback", "upload", "Ljava/io/File;", "uploadState", "Lio/getstream/chat/android/client/models/Attachment$UploadState;", "extraData", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Lio/getstream/chat/android/client/models/Attachment$UploadState;Ljava/util/Map;)V", "getAssetUrl", "()Ljava/lang/String;", "setAssetUrl", "(Ljava/lang/String;)V", "getAuthorName", "setAuthorName", "getExtraData", "()Ljava/util/Map;", "setExtraData", "(Ljava/util/Map;)V", "getFallback", "setFallback", "getFileSize", "()I", "setFileSize", "(I)V", "getImage", "setImage", "getImageUrl", "setImageUrl", "getMimeType", "setMimeType", "getName", "setName", "getOgUrl", "setOgUrl", "getText", "setText", "getThumbUrl", "setThumbUrl", "getTitle", "setTitle", "getTitleLink", "setTitleLink", "getType", "setType", "getUpload", "()Ljava/io/File;", "setUpload", "(Ljava/io/File;)V", "getUploadState", "()Lio/getstream/chat/android/client/models/Attachment$UploadState;", "setUploadState", "(Lio/getstream/chat/android/client/models/Attachment$UploadState;)V", "getUrl", "setUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "UploadState", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.models.Attachment */
/* compiled from: Attachment.kt */
public final class Attachment implements CustomObject {
    @SerializedName("asset_url")
    private String assetUrl;
    @SerializedName("author_name")
    private String authorName;
    @IgnoreDeserialisation
    @IgnoreSerialisation
    private Map<String, Object> extraData;
    @SerializedName("fallback")
    private String fallback;
    @SerializedName("file_size")
    private int fileSize;
    @SerializedName("image")
    private String image;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("mime_type")
    private String mimeType;
    @SerializedName("name")
    private String name;
    @SerializedName("og_scrape_url")
    private String ogUrl;
    @SerializedName("text")
    private String text;
    @SerializedName("thumb_url")
    private String thumbUrl;
    @SerializedName("title")
    private String title;
    @SerializedName("title_link")
    private String titleLink;
    @SerializedName("type")
    private String type;
    @IgnoreDeserialisation
    @IgnoreSerialisation
    private File upload;
    @IgnoreDeserialisation
    @IgnoreSerialisation
    private UploadState uploadState;
    @SerializedName("url")
    private String url;

    public Attachment() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (File) null, (UploadState) null, (Map) null, 262143, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Attachment copy$default(Attachment attachment, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9, String str10, String str11, String str12, String str13, String str14, File file, UploadState uploadState2, Map map, int i2, Object obj) {
        Attachment attachment2 = attachment;
        int i3 = i2;
        return attachment.copy((i3 & 1) != 0 ? attachment2.authorName : str, (i3 & 2) != 0 ? attachment2.titleLink : str2, (i3 & 4) != 0 ? attachment2.thumbUrl : str3, (i3 & 8) != 0 ? attachment2.imageUrl : str4, (i3 & 16) != 0 ? attachment2.assetUrl : str5, (i3 & 32) != 0 ? attachment2.ogUrl : str6, (i3 & 64) != 0 ? attachment2.mimeType : str7, (i3 & 128) != 0 ? attachment2.fileSize : i, (i3 & 256) != 0 ? attachment2.title : str8, (i3 & 512) != 0 ? attachment2.text : str9, (i3 & 1024) != 0 ? attachment2.type : str10, (i3 & 2048) != 0 ? attachment2.image : str11, (i3 & 4096) != 0 ? attachment2.url : str12, (i3 & 8192) != 0 ? attachment2.name : str13, (i3 & 16384) != 0 ? attachment2.fallback : str14, (i3 & 32768) != 0 ? attachment2.upload : file, (i3 & 65536) != 0 ? attachment2.uploadState : uploadState2, (i3 & 131072) != 0 ? attachment.getExtraData() : map);
    }

    public final String component1() {
        return this.authorName;
    }

    public final String component10() {
        return this.text;
    }

    public final String component11() {
        return this.type;
    }

    public final String component12() {
        return this.image;
    }

    public final String component13() {
        return this.url;
    }

    public final String component14() {
        return this.name;
    }

    public final String component15() {
        return this.fallback;
    }

    public final File component16() {
        return this.upload;
    }

    public final UploadState component17() {
        return this.uploadState;
    }

    public final Map<String, Object> component18() {
        return getExtraData();
    }

    public final String component2() {
        return this.titleLink;
    }

    public final String component3() {
        return this.thumbUrl;
    }

    public final String component4() {
        return this.imageUrl;
    }

    public final String component5() {
        return this.assetUrl;
    }

    public final String component6() {
        return this.ogUrl;
    }

    public final String component7() {
        return this.mimeType;
    }

    public final int component8() {
        return this.fileSize;
    }

    public final String component9() {
        return this.title;
    }

    public final Attachment copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9, String str10, String str11, String str12, String str13, String str14, File file, UploadState uploadState2, Map<String, Object> map) {
        String str15 = str;
        Intrinsics.checkNotNullParameter(map, "extraData");
        return new Attachment(str, str2, str3, str4, str5, str6, str7, i, str8, str9, str10, str11, str12, str13, str14, file, uploadState2, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Attachment)) {
            return false;
        }
        Attachment attachment = (Attachment) obj;
        return Intrinsics.areEqual((Object) this.authorName, (Object) attachment.authorName) && Intrinsics.areEqual((Object) this.titleLink, (Object) attachment.titleLink) && Intrinsics.areEqual((Object) this.thumbUrl, (Object) attachment.thumbUrl) && Intrinsics.areEqual((Object) this.imageUrl, (Object) attachment.imageUrl) && Intrinsics.areEqual((Object) this.assetUrl, (Object) attachment.assetUrl) && Intrinsics.areEqual((Object) this.ogUrl, (Object) attachment.ogUrl) && Intrinsics.areEqual((Object) this.mimeType, (Object) attachment.mimeType) && this.fileSize == attachment.fileSize && Intrinsics.areEqual((Object) this.title, (Object) attachment.title) && Intrinsics.areEqual((Object) this.text, (Object) attachment.text) && Intrinsics.areEqual((Object) this.type, (Object) attachment.type) && Intrinsics.areEqual((Object) this.image, (Object) attachment.image) && Intrinsics.areEqual((Object) this.url, (Object) attachment.url) && Intrinsics.areEqual((Object) this.name, (Object) attachment.name) && Intrinsics.areEqual((Object) this.fallback, (Object) attachment.fallback) && Intrinsics.areEqual((Object) this.upload, (Object) attachment.upload) && Intrinsics.areEqual((Object) this.uploadState, (Object) attachment.uploadState) && Intrinsics.areEqual((Object) getExtraData(), (Object) attachment.getExtraData());
    }

    public int hashCode() {
        String str = this.authorName;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.titleLink;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.thumbUrl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.imageUrl;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.assetUrl;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.ogUrl;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.mimeType;
        int hashCode7 = (((hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31) + this.fileSize) * 31;
        String str8 = this.title;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.text;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.type;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.image;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.url;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.name;
        int hashCode13 = (hashCode12 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.fallback;
        int hashCode14 = (hashCode13 + (str14 != null ? str14.hashCode() : 0)) * 31;
        File file = this.upload;
        int hashCode15 = (hashCode14 + (file != null ? file.hashCode() : 0)) * 31;
        UploadState uploadState2 = this.uploadState;
        int hashCode16 = (hashCode15 + (uploadState2 != null ? uploadState2.hashCode() : 0)) * 31;
        Map<String, Object> extraData2 = getExtraData();
        if (extraData2 != null) {
            i = extraData2.hashCode();
        }
        return hashCode16 + i;
    }

    public String toString() {
        return "Attachment(authorName=" + this.authorName + ", titleLink=" + this.titleLink + ", thumbUrl=" + this.thumbUrl + ", imageUrl=" + this.imageUrl + ", assetUrl=" + this.assetUrl + ", ogUrl=" + this.ogUrl + ", mimeType=" + this.mimeType + ", fileSize=" + this.fileSize + ", title=" + this.title + ", text=" + this.text + ", type=" + this.type + ", image=" + this.image + ", url=" + this.url + ", name=" + this.name + ", fallback=" + this.fallback + ", upload=" + this.upload + ", uploadState=" + this.uploadState + ", extraData=" + getExtraData() + ")";
    }

    public Attachment(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9, String str10, String str11, String str12, String str13, String str14, File file, UploadState uploadState2, Map<String, Object> map) {
        Map<String, Object> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "extraData");
        this.authorName = str;
        this.titleLink = str2;
        this.thumbUrl = str3;
        this.imageUrl = str4;
        this.assetUrl = str5;
        this.ogUrl = str6;
        this.mimeType = str7;
        this.fileSize = i;
        this.title = str8;
        this.text = str9;
        this.type = str10;
        this.image = str11;
        this.url = str12;
        this.name = str13;
        this.fallback = str14;
        this.upload = file;
        this.uploadState = uploadState2;
        this.extraData = map2;
    }

    public <T> T getExtraValue(String str, T t) {
        Intrinsics.checkNotNullParameter(str, "key");
        return CustomObject.DefaultImpls.getExtraValue(this, str, t);
    }

    public void putExtraValue(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(obj, "value");
        CustomObject.DefaultImpls.putExtraValue(this, str, obj);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Attachment(java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, int r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.io.File r34, p015io.getstream.chat.android.client.models.Attachment.UploadState r35, java.util.Map r36, int r37, kotlin.jvm.internal.DefaultConstructorMarker r38) {
        /*
            r18 = this;
            r0 = r37
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x000b
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x000d
        L_0x000b:
            r1 = r19
        L_0x000d:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0015
            r3 = r2
            java.lang.String r3 = (java.lang.String) r3
            goto L_0x0017
        L_0x0015:
            r3 = r20
        L_0x0017:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001f
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0021
        L_0x001f:
            r4 = r21
        L_0x0021:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0029
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x002b
        L_0x0029:
            r5 = r22
        L_0x002b:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0033
            r6 = r2
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x0035
        L_0x0033:
            r6 = r23
        L_0x0035:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x003d
            r7 = r2
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x003f
        L_0x003d:
            r7 = r24
        L_0x003f:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0047
            r8 = r2
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x0049
        L_0x0047:
            r8 = r25
        L_0x0049:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x004f
            r9 = 0
            goto L_0x0051
        L_0x004f:
            r9 = r26
        L_0x0051:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0059
            r10 = r2
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x005b
        L_0x0059:
            r10 = r27
        L_0x005b:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0063
            r11 = r2
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x0065
        L_0x0063:
            r11 = r28
        L_0x0065:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x006d
            r12 = r2
            java.lang.String r12 = (java.lang.String) r12
            goto L_0x006f
        L_0x006d:
            r12 = r29
        L_0x006f:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0077
            r13 = r2
            java.lang.String r13 = (java.lang.String) r13
            goto L_0x0079
        L_0x0077:
            r13 = r30
        L_0x0079:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0081
            r14 = r2
            java.lang.String r14 = (java.lang.String) r14
            goto L_0x0083
        L_0x0081:
            r14 = r31
        L_0x0083:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x008b
            r15 = r2
            java.lang.String r15 = (java.lang.String) r15
            goto L_0x008d
        L_0x008b:
            r15 = r32
        L_0x008d:
            r38 = r15
            r15 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r15 == 0) goto L_0x0097
            r15 = r2
            java.lang.String r15 = (java.lang.String) r15
            goto L_0x0099
        L_0x0097:
            r15 = r33
        L_0x0099:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x00a5
            r16 = r2
            java.io.File r16 = (java.io.File) r16
            goto L_0x00a7
        L_0x00a5:
            r16 = r34
        L_0x00a7:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x00b0
            io.getstream.chat.android.client.models.Attachment$UploadState r2 = (p015io.getstream.chat.android.client.models.Attachment.UploadState) r2
            goto L_0x00b2
        L_0x00b0:
            r2 = r35
        L_0x00b2:
            r17 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 & r17
            if (r0 == 0) goto L_0x00c0
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            java.util.Map r0 = (java.util.Map) r0
            goto L_0x00c2
        L_0x00c0:
            r0 = r36
        L_0x00c2:
            r19 = r18
            r20 = r1
            r21 = r3
            r22 = r4
            r23 = r5
            r24 = r6
            r25 = r7
            r26 = r8
            r27 = r9
            r28 = r10
            r29 = r11
            r30 = r12
            r31 = r13
            r32 = r14
            r33 = r38
            r34 = r15
            r35 = r16
            r36 = r2
            r37 = r0
            r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.client.models.Attachment.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.io.File, io.getstream.chat.android.client.models.Attachment$UploadState, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getAuthorName() {
        return this.authorName;
    }

    public final void setAuthorName(String str) {
        this.authorName = str;
    }

    public final String getTitleLink() {
        return this.titleLink;
    }

    public final void setTitleLink(String str) {
        this.titleLink = str;
    }

    public final String getThumbUrl() {
        return this.thumbUrl;
    }

    public final void setThumbUrl(String str) {
        this.thumbUrl = str;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public final String getAssetUrl() {
        return this.assetUrl;
    }

    public final void setAssetUrl(String str) {
        this.assetUrl = str;
    }

    public final String getOgUrl() {
        return this.ogUrl;
    }

    public final void setOgUrl(String str) {
        this.ogUrl = str;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final void setMimeType(String str) {
        this.mimeType = str;
    }

    public final int getFileSize() {
        return this.fileSize;
    }

    public final void setFileSize(int i) {
        this.fileSize = i;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final String getImage() {
        return this.image;
    }

    public final void setImage(String str) {
        this.image = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getFallback() {
        return this.fallback;
    }

    public final void setFallback(String str) {
        this.fallback = str;
    }

    public final File getUpload() {
        return this.upload;
    }

    public final void setUpload(File file) {
        this.upload = file;
    }

    public final UploadState getUploadState() {
        return this.uploadState;
    }

    public final void setUploadState(UploadState uploadState2) {
        this.uploadState = uploadState2;
    }

    public Map<String, Object> getExtraData() {
        return this.extraData;
    }

    public void setExtraData(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.extraData = map;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, mo26107d2 = {"Lio/getstream/chat/android/client/models/Attachment$UploadState;", "", "()V", "Failed", "InProgress", "Success", "Lio/getstream/chat/android/client/models/Attachment$UploadState$InProgress;", "Lio/getstream/chat/android/client/models/Attachment$UploadState$Success;", "Lio/getstream/chat/android/client/models/Attachment$UploadState$Failed;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.models.Attachment$UploadState */
    /* compiled from: Attachment.kt */
    public static abstract class UploadState {

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lio/getstream/chat/android/client/models/Attachment$UploadState$InProgress;", "Lio/getstream/chat/android/client/models/Attachment$UploadState;", "()V", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.client.models.Attachment$UploadState$InProgress */
        /* compiled from: Attachment.kt */
        public static final class InProgress extends UploadState {
            public static final InProgress INSTANCE = new InProgress();

            private InProgress() {
                super((DefaultConstructorMarker) null);
            }
        }

        private UploadState() {
        }

        public /* synthetic */ UploadState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lio/getstream/chat/android/client/models/Attachment$UploadState$Success;", "Lio/getstream/chat/android/client/models/Attachment$UploadState;", "()V", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.client.models.Attachment$UploadState$Success */
        /* compiled from: Attachment.kt */
        public static final class Success extends UploadState {
            public static final Success INSTANCE = new Success();

            private Success() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lio/getstream/chat/android/client/models/Attachment$UploadState$Failed;", "Lio/getstream/chat/android/client/models/Attachment$UploadState;", "error", "Lio/getstream/chat/android/client/errors/ChatError;", "(Lio/getstream/chat/android/client/errors/ChatError;)V", "getError", "()Lio/getstream/chat/android/client/errors/ChatError;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.client.models.Attachment$UploadState$Failed */
        /* compiled from: Attachment.kt */
        public static final class Failed extends UploadState {
            private final ChatError error;

            public static /* synthetic */ Failed copy$default(Failed failed, ChatError chatError, int i, Object obj) {
                if ((i & 1) != 0) {
                    chatError = failed.error;
                }
                return failed.copy(chatError);
            }

            public final ChatError component1() {
                return this.error;
            }

            public final Failed copy(ChatError chatError) {
                Intrinsics.checkNotNullParameter(chatError, "error");
                return new Failed(chatError);
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof Failed) && Intrinsics.areEqual((Object) this.error, (Object) ((Failed) obj).error);
                }
                return true;
            }

            public int hashCode() {
                ChatError chatError = this.error;
                if (chatError != null) {
                    return chatError.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "Failed(error=" + this.error + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Failed(ChatError chatError) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(chatError, "error");
                this.error = chatError;
            }

            public final ChatError getError() {
                return this.error;
            }
        }
    }
}
