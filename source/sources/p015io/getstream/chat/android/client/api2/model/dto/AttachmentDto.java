package p015io.getstream.chat.android.client.api2.model.dto;

import com.squareup.moshi.JsonClass;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010$\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B­\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\u0010\u0015J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0014HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0007HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÑ\u0001\u00109\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0014HÆ\u0001J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\u0007HÖ\u0001J\t\u0010>\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017¨\u0006?"}, mo26107d2 = {"Lio/getstream/chat/android/client/api2/model/dto/AttachmentDto;", "", "asset_url", "", "author_name", "fallback", "file_size", "", "image", "image_url", "mime_type", "name", "og_scrape_url", "text", "thumb_url", "title", "title_link", "type", "url", "extraData", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getAsset_url", "()Ljava/lang/String;", "getAuthor_name", "getExtraData", "()Ljava/util/Map;", "getFallback", "getFile_size", "()I", "getImage", "getImage_url", "getMime_type", "getName", "getOg_scrape_url", "getText", "getThumb_url", "getTitle", "getTitle_link", "getType", "getUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api2.model.dto.AttachmentDto */
/* compiled from: AttachmentDto.kt */
public final class AttachmentDto {
    private final String asset_url;
    private final String author_name;
    private final Map<String, Object> extraData;
    private final String fallback;
    private final int file_size;
    private final String image;
    private final String image_url;
    private final String mime_type;
    private final String name;
    private final String og_scrape_url;
    private final String text;
    private final String thumb_url;
    private final String title;
    private final String title_link;
    private final String type;
    private final String url;

    public static /* synthetic */ AttachmentDto copy$default(AttachmentDto attachmentDto, String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map map, int i2, Object obj) {
        AttachmentDto attachmentDto2 = attachmentDto;
        int i3 = i2;
        return attachmentDto.copy((i3 & 1) != 0 ? attachmentDto2.asset_url : str, (i3 & 2) != 0 ? attachmentDto2.author_name : str2, (i3 & 4) != 0 ? attachmentDto2.fallback : str3, (i3 & 8) != 0 ? attachmentDto2.file_size : i, (i3 & 16) != 0 ? attachmentDto2.image : str4, (i3 & 32) != 0 ? attachmentDto2.image_url : str5, (i3 & 64) != 0 ? attachmentDto2.mime_type : str6, (i3 & 128) != 0 ? attachmentDto2.name : str7, (i3 & 256) != 0 ? attachmentDto2.og_scrape_url : str8, (i3 & 512) != 0 ? attachmentDto2.text : str9, (i3 & 1024) != 0 ? attachmentDto2.thumb_url : str10, (i3 & 2048) != 0 ? attachmentDto2.title : str11, (i3 & 4096) != 0 ? attachmentDto2.title_link : str12, (i3 & 8192) != 0 ? attachmentDto2.type : str13, (i3 & 16384) != 0 ? attachmentDto2.url : str14, (i3 & 32768) != 0 ? attachmentDto2.extraData : map);
    }

    public final String component1() {
        return this.asset_url;
    }

    public final String component10() {
        return this.text;
    }

    public final String component11() {
        return this.thumb_url;
    }

    public final String component12() {
        return this.title;
    }

    public final String component13() {
        return this.title_link;
    }

    public final String component14() {
        return this.type;
    }

    public final String component15() {
        return this.url;
    }

    public final Map<String, Object> component16() {
        return this.extraData;
    }

    public final String component2() {
        return this.author_name;
    }

    public final String component3() {
        return this.fallback;
    }

    public final int component4() {
        return this.file_size;
    }

    public final String component5() {
        return this.image;
    }

    public final String component6() {
        return this.image_url;
    }

    public final String component7() {
        return this.mime_type;
    }

    public final String component8() {
        return this.name;
    }

    public final String component9() {
        return this.og_scrape_url;
    }

    public final AttachmentDto copy(String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, ? extends Object> map) {
        String str15 = str;
        Intrinsics.checkNotNullParameter(map, "extraData");
        return new AttachmentDto(str, str2, str3, i, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AttachmentDto)) {
            return false;
        }
        AttachmentDto attachmentDto = (AttachmentDto) obj;
        return Intrinsics.areEqual((Object) this.asset_url, (Object) attachmentDto.asset_url) && Intrinsics.areEqual((Object) this.author_name, (Object) attachmentDto.author_name) && Intrinsics.areEqual((Object) this.fallback, (Object) attachmentDto.fallback) && this.file_size == attachmentDto.file_size && Intrinsics.areEqual((Object) this.image, (Object) attachmentDto.image) && Intrinsics.areEqual((Object) this.image_url, (Object) attachmentDto.image_url) && Intrinsics.areEqual((Object) this.mime_type, (Object) attachmentDto.mime_type) && Intrinsics.areEqual((Object) this.name, (Object) attachmentDto.name) && Intrinsics.areEqual((Object) this.og_scrape_url, (Object) attachmentDto.og_scrape_url) && Intrinsics.areEqual((Object) this.text, (Object) attachmentDto.text) && Intrinsics.areEqual((Object) this.thumb_url, (Object) attachmentDto.thumb_url) && Intrinsics.areEqual((Object) this.title, (Object) attachmentDto.title) && Intrinsics.areEqual((Object) this.title_link, (Object) attachmentDto.title_link) && Intrinsics.areEqual((Object) this.type, (Object) attachmentDto.type) && Intrinsics.areEqual((Object) this.url, (Object) attachmentDto.url) && Intrinsics.areEqual((Object) this.extraData, (Object) attachmentDto.extraData);
    }

    public int hashCode() {
        String str = this.asset_url;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.author_name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.fallback;
        int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.file_size) * 31;
        String str4 = this.image;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.image_url;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.mime_type;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.name;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.og_scrape_url;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.text;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.thumb_url;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.title;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.title_link;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.type;
        int hashCode13 = (hashCode12 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.url;
        int hashCode14 = (hashCode13 + (str14 != null ? str14.hashCode() : 0)) * 31;
        Map<String, Object> map = this.extraData;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode14 + i;
    }

    public String toString() {
        return "AttachmentDto(asset_url=" + this.asset_url + ", author_name=" + this.author_name + ", fallback=" + this.fallback + ", file_size=" + this.file_size + ", image=" + this.image + ", image_url=" + this.image_url + ", mime_type=" + this.mime_type + ", name=" + this.name + ", og_scrape_url=" + this.og_scrape_url + ", text=" + this.text + ", thumb_url=" + this.thumb_url + ", title=" + this.title + ", title_link=" + this.title_link + ", type=" + this.type + ", url=" + this.url + ", extraData=" + this.extraData + ")";
    }

    public AttachmentDto(String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, ? extends Object> map) {
        Map<String, ? extends Object> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "extraData");
        this.asset_url = str;
        this.author_name = str2;
        this.fallback = str3;
        this.file_size = i;
        this.image = str4;
        this.image_url = str5;
        this.mime_type = str6;
        this.name = str7;
        this.og_scrape_url = str8;
        this.text = str9;
        this.thumb_url = str10;
        this.title = str11;
        this.title_link = str12;
        this.type = str13;
        this.url = str14;
        this.extraData = map2;
    }

    public final String getAsset_url() {
        return this.asset_url;
    }

    public final String getAuthor_name() {
        return this.author_name;
    }

    public final String getFallback() {
        return this.fallback;
    }

    public final int getFile_size() {
        return this.file_size;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final String getMime_type() {
        return this.mime_type;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOg_scrape_url() {
        return this.og_scrape_url;
    }

    public final String getText() {
        return this.text;
    }

    public final String getThumb_url() {
        return this.thumb_url;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTitle_link() {
        return this.title_link;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Map<String, Object> getExtraData() {
        return this.extraData;
    }
}
