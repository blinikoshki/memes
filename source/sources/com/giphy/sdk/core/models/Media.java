package com.giphy.sdk.core.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.giphy.sdk.core.models.enums.MediaType;
import com.giphy.sdk.core.models.enums.RatingType;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\u001f\u0012\b\b\u0002\u0010\"\u001a\u00020\u001f\u0012\b\b\u0002\u0010#\u001a\u00020\u001f\u0012\b\b\u0002\u0010$\u001a\u00020\u001f\u0012\b\b\u0002\u0010%\u001a\u00020\u001f\u0012\b\b\u0002\u0010&\u001a\u00020\u001f\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012(\b\u0002\u0010)\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010*j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`+¢\u0006\u0002\u0010,J\t\u0010]\u001a\u00020^HÖ\u0001J\u0006\u0010_\u001a\u00020`J\u0019\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020^HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010.R\u001e\u0010'\u001a\u0004\u0018\u00010(8\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010.R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010.R\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00118\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010.\"\u0004\b;\u0010<R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u00106R\u0016\u0010\"\u001a\u00020\u001f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010BR\u0016\u0010!\u001a\u00020\u001f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010BR\u0016\u0010#\u001a\u00020\u001f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010BR\u0016\u0010\u001e\u001a\u00020\u001f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010BR\u0016\u0010%\u001a\u00020\u001f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010BR\u0016\u0010$\u001a\u00020\u001f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010BR\u0016\u0010 \u001a\u00020\u001f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010BR\u0016\u0010&\u001a\u00020\u001f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010BR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u0010.R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u0010.R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010.R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010.R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\bI\u00109R\u0013\u0010J\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bK\u0010.R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u0010.R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u00106R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u00106R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010.\"\u0004\bT\u0010<R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR:\u0010)\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010*j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\¨\u0006e"}, mo26107d2 = {"Lcom/giphy/sdk/core/models/Media;", "Landroid/os/Parcelable;", "id", "", "type", "Lcom/giphy/sdk/core/models/enums/MediaType;", "slug", "url", "bitlyGifUrl", "bitlyUrl", "embedUrl", "source", "title", "rating", "Lcom/giphy/sdk/core/models/enums/RatingType;", "contentUrl", "tags", "", "featuredTags", "user", "Lcom/giphy/sdk/core/models/User;", "images", "Lcom/giphy/sdk/core/models/Images;", "sourceTld", "sourcePostUrl", "updateDate", "Ljava/util/Date;", "createDate", "importDate", "trendingDate", "isHidden", "", "isRemoved", "isCommunity", "isAnonymous", "isFeatured", "isRealtime", "isIndexable", "isSticker", "bottleData", "Lcom/giphy/sdk/core/models/BottleData;", "userDictionary", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "(Ljava/lang/String;Lcom/giphy/sdk/core/models/enums/MediaType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/giphy/sdk/core/models/enums/RatingType;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/giphy/sdk/core/models/User;Lcom/giphy/sdk/core/models/Images;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;ZZZZZZZZLcom/giphy/sdk/core/models/BottleData;Ljava/util/HashMap;)V", "getBitlyGifUrl", "()Ljava/lang/String;", "getBitlyUrl", "getBottleData", "()Lcom/giphy/sdk/core/models/BottleData;", "setBottleData", "(Lcom/giphy/sdk/core/models/BottleData;)V", "getContentUrl", "getCreateDate", "()Ljava/util/Date;", "getEmbedUrl", "getFeaturedTags", "()Ljava/util/List;", "getId", "setId", "(Ljava/lang/String;)V", "getImages", "()Lcom/giphy/sdk/core/models/Images;", "setImages", "(Lcom/giphy/sdk/core/models/Images;)V", "getImportDate", "()Z", "getRating", "()Lcom/giphy/sdk/core/models/enums/RatingType;", "getSlug", "getSource", "getSourcePostUrl", "getSourceTld", "getTags", "tid", "getTid", "getTitle", "getTrendingDate", "getType", "()Lcom/giphy/sdk/core/models/enums/MediaType;", "setType", "(Lcom/giphy/sdk/core/models/enums/MediaType;)V", "getUpdateDate", "getUrl", "setUrl", "getUser", "()Lcom/giphy/sdk/core/models/User;", "setUser", "(Lcom/giphy/sdk/core/models/User;)V", "getUserDictionary", "()Ljava/util/HashMap;", "setUserDictionary", "(Ljava/util/HashMap;)V", "describeContents", "", "postProcess", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: Media.kt */
public final class Media implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @SerializedName("bitly_gif_url")
    private final String bitlyGifUrl;
    @SerializedName("bitly_url")
    private final String bitlyUrl;
    @SerializedName("bottle_data")
    private BottleData bottleData;
    @SerializedName("content_url")
    private final String contentUrl;
    @SerializedName("create_datetime")
    private final Date createDate;
    @SerializedName("embed_url")
    private final String embedUrl;
    @SerializedName("featured_tags")
    private final List<String> featuredTags;

    /* renamed from: id */
    private String f176id;
    private Images images;
    @SerializedName("import_datetime")
    private final Date importDate;
    @SerializedName("is_anonymous")
    private final boolean isAnonymous;
    @SerializedName("is_community")
    private final boolean isCommunity;
    @SerializedName("is_featured")
    private final boolean isFeatured;
    @SerializedName("is_hidden")
    private final boolean isHidden;
    @SerializedName("is_indexable")
    private final boolean isIndexable;
    @SerializedName("is_realtime")
    private final boolean isRealtime;
    @SerializedName("is_removed")
    private final boolean isRemoved;
    @SerializedName("is_sticker")
    private final boolean isSticker;
    private final RatingType rating;
    private final String slug;
    private final String source;
    @SerializedName("source_post_url")
    private final String sourcePostUrl;
    @SerializedName("source_tld")
    private final String sourceTld;
    private final List<String> tags;
    private final String title;
    @SerializedName("trending_datetime")
    private final Date trendingDate;
    private MediaType type;
    @SerializedName("update_datetime")
    private final Date updateDate;
    private String url;
    private User user;
    private HashMap<String, String> userDictionary;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkParameterIsNotNull(parcel2, "in");
            String readString = parcel.readString();
            HashMap hashMap = null;
            MediaType mediaType = parcel.readInt() != 0 ? (MediaType) Enum.valueOf(MediaType.class, parcel.readString()) : null;
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            RatingType ratingType = parcel.readInt() != 0 ? (RatingType) Enum.valueOf(RatingType.class, parcel.readString()) : null;
            String readString9 = parcel.readString();
            List createStringArrayList = parcel.createStringArrayList();
            List createStringArrayList2 = parcel.createStringArrayList();
            User user = parcel.readInt() != 0 ? (User) User.CREATOR.createFromParcel(parcel2) : null;
            Images images = (Images) Images.CREATOR.createFromParcel(parcel2);
            String readString10 = parcel.readString();
            String readString11 = parcel.readString();
            Date date = (Date) parcel.readSerializable();
            Date date2 = (Date) parcel.readSerializable();
            Date date3 = (Date) parcel.readSerializable();
            Date date4 = (Date) parcel.readSerializable();
            boolean z = parcel.readInt() != 0;
            boolean z2 = parcel.readInt() != 0;
            boolean z3 = parcel.readInt() != 0;
            boolean z4 = parcel.readInt() != 0;
            boolean z5 = parcel.readInt() != 0;
            boolean z6 = parcel.readInt() != 0;
            boolean z7 = parcel.readInt() != 0;
            boolean z8 = parcel.readInt() != 0;
            BottleData bottleData = parcel.readInt() != 0 ? (BottleData) BottleData.CREATOR.createFromParcel(parcel2) : null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                hashMap = new HashMap(readInt);
                while (readInt != 0) {
                    hashMap.put(parcel.readString(), parcel.readString());
                    readInt--;
                    Parcel parcel3 = parcel;
                    createStringArrayList = createStringArrayList;
                }
            }
            return new Media(readString, mediaType, readString2, readString3, readString4, readString5, readString6, readString7, readString8, ratingType, readString9, createStringArrayList, createStringArrayList2, user, images, readString10, readString11, date, date2, date3, date4, z, z2, z3, z4, z5, z6, z7, z8, bottleData, hashMap);
        }

        public final Object[] newArray(int i) {
            return new Media[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.f176id);
        MediaType mediaType = this.type;
        if (mediaType != null) {
            parcel.writeInt(1);
            parcel.writeString(mediaType.name());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.slug);
        parcel.writeString(this.url);
        parcel.writeString(this.bitlyGifUrl);
        parcel.writeString(this.bitlyUrl);
        parcel.writeString(this.embedUrl);
        parcel.writeString(this.source);
        parcel.writeString(this.title);
        RatingType ratingType = this.rating;
        if (ratingType != null) {
            parcel.writeInt(1);
            parcel.writeString(ratingType.name());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.contentUrl);
        parcel.writeStringList(this.tags);
        parcel.writeStringList(this.featuredTags);
        User user2 = this.user;
        if (user2 != null) {
            parcel.writeInt(1);
            user2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        this.images.writeToParcel(parcel, 0);
        parcel.writeString(this.sourceTld);
        parcel.writeString(this.sourcePostUrl);
        parcel.writeSerializable(this.updateDate);
        parcel.writeSerializable(this.createDate);
        parcel.writeSerializable(this.importDate);
        parcel.writeSerializable(this.trendingDate);
        parcel.writeInt(this.isHidden ? 1 : 0);
        parcel.writeInt(this.isRemoved ? 1 : 0);
        parcel.writeInt(this.isCommunity ? 1 : 0);
        parcel.writeInt(this.isAnonymous ? 1 : 0);
        parcel.writeInt(this.isFeatured ? 1 : 0);
        parcel.writeInt(this.isRealtime ? 1 : 0);
        parcel.writeInt(this.isIndexable ? 1 : 0);
        parcel.writeInt(this.isSticker ? 1 : 0);
        BottleData bottleData2 = this.bottleData;
        if (bottleData2 != null) {
            parcel.writeInt(1);
            bottleData2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        HashMap<String, String> hashMap = this.userDictionary;
        if (hashMap != null) {
            parcel.writeInt(1);
            parcel.writeInt(hashMap.size());
            for (Map.Entry<String, String> next : hashMap.entrySet()) {
                parcel.writeString(next.getKey());
                parcel.writeString(next.getValue());
            }
            return;
        }
        parcel.writeInt(0);
    }

    public Media(String str, MediaType mediaType, String str2, String str3, String str4, String str5, String str6, String str7, String str8, RatingType ratingType, String str9, List<String> list, List<String> list2, User user2, Images images2, String str10, String str11, Date date, Date date2, Date date3, Date date4, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, BottleData bottleData2, HashMap<String, String> hashMap) {
        Images images3 = images2;
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(images3, "images");
        this.f176id = str;
        this.type = mediaType;
        this.slug = str2;
        this.url = str3;
        this.bitlyGifUrl = str4;
        this.bitlyUrl = str5;
        this.embedUrl = str6;
        this.source = str7;
        this.title = str8;
        this.rating = ratingType;
        this.contentUrl = str9;
        this.tags = list;
        this.featuredTags = list2;
        this.user = user2;
        this.images = images3;
        this.sourceTld = str10;
        this.sourcePostUrl = str11;
        this.updateDate = date;
        this.createDate = date2;
        this.importDate = date3;
        this.trendingDate = date4;
        this.isHidden = z;
        this.isRemoved = z2;
        this.isCommunity = z3;
        this.isAnonymous = z4;
        this.isFeatured = z5;
        this.isRealtime = z6;
        this.isIndexable = z7;
        this.isSticker = z8;
        this.bottleData = bottleData2;
        this.userDictionary = hashMap;
    }

    public final String getId() {
        return this.f176id;
    }

    public final void setId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f176id = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Media(java.lang.String r36, com.giphy.sdk.core.models.enums.MediaType r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, com.giphy.sdk.core.models.enums.RatingType r45, java.lang.String r46, java.util.List r47, java.util.List r48, com.giphy.sdk.core.models.User r49, com.giphy.sdk.core.models.Images r50, java.lang.String r51, java.lang.String r52, java.util.Date r53, java.util.Date r54, java.util.Date r55, java.util.Date r56, boolean r57, boolean r58, boolean r59, boolean r60, boolean r61, boolean r62, boolean r63, boolean r64, com.giphy.sdk.core.models.BottleData r65, java.util.HashMap r66, int r67, kotlin.jvm.internal.DefaultConstructorMarker r68) {
        /*
            r35 = this;
            r0 = r67
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x000c
            r1 = r2
            com.giphy.sdk.core.models.enums.MediaType r1 = (com.giphy.sdk.core.models.enums.MediaType) r1
            r5 = r1
            goto L_0x000e
        L_0x000c:
            r5 = r37
        L_0x000e:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0017
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r6 = r1
            goto L_0x0019
        L_0x0017:
            r6 = r38
        L_0x0019:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0022
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r7 = r1
            goto L_0x0024
        L_0x0022:
            r7 = r39
        L_0x0024:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x002d
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r8 = r1
            goto L_0x002f
        L_0x002d:
            r8 = r40
        L_0x002f:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0038
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r9 = r1
            goto L_0x003a
        L_0x0038:
            r9 = r41
        L_0x003a:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0043
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r10 = r1
            goto L_0x0045
        L_0x0043:
            r10 = r42
        L_0x0045:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x004e
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r11 = r1
            goto L_0x0050
        L_0x004e:
            r11 = r43
        L_0x0050:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0059
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r12 = r1
            goto L_0x005b
        L_0x0059:
            r12 = r44
        L_0x005b:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0064
            r1 = r2
            com.giphy.sdk.core.models.enums.RatingType r1 = (com.giphy.sdk.core.models.enums.RatingType) r1
            r13 = r1
            goto L_0x0066
        L_0x0064:
            r13 = r45
        L_0x0066:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x006f
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r14 = r1
            goto L_0x0071
        L_0x006f:
            r14 = r46
        L_0x0071:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x007a
            r1 = r2
            java.util.List r1 = (java.util.List) r1
            r15 = r1
            goto L_0x007c
        L_0x007a:
            r15 = r47
        L_0x007c:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0086
            r1 = r2
            java.util.List r1 = (java.util.List) r1
            r16 = r1
            goto L_0x0088
        L_0x0086:
            r16 = r48
        L_0x0088:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0092
            r1 = r2
            com.giphy.sdk.core.models.User r1 = (com.giphy.sdk.core.models.User) r1
            r17 = r1
            goto L_0x0094
        L_0x0092:
            r17 = r49
        L_0x0094:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00a0
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r19 = r1
            goto L_0x00a2
        L_0x00a0:
            r19 = r51
        L_0x00a2:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00ad
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r20 = r1
            goto L_0x00af
        L_0x00ad:
            r20 = r52
        L_0x00af:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00ba
            r1 = r2
            java.util.Date r1 = (java.util.Date) r1
            r21 = r1
            goto L_0x00bc
        L_0x00ba:
            r21 = r53
        L_0x00bc:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00c7
            r1 = r2
            java.util.Date r1 = (java.util.Date) r1
            r22 = r1
            goto L_0x00c9
        L_0x00c7:
            r22 = r54
        L_0x00c9:
            r1 = 524288(0x80000, float:7.34684E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00d4
            r1 = r2
            java.util.Date r1 = (java.util.Date) r1
            r23 = r1
            goto L_0x00d6
        L_0x00d4:
            r23 = r55
        L_0x00d6:
            r1 = 1048576(0x100000, float:1.469368E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00e1
            r1 = r2
            java.util.Date r1 = (java.util.Date) r1
            r24 = r1
            goto L_0x00e3
        L_0x00e1:
            r24 = r56
        L_0x00e3:
            r1 = 2097152(0x200000, float:2.938736E-39)
            r1 = r1 & r0
            r3 = 0
            if (r1 == 0) goto L_0x00ec
            r25 = 0
            goto L_0x00ee
        L_0x00ec:
            r25 = r57
        L_0x00ee:
            r1 = 4194304(0x400000, float:5.877472E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00f6
            r26 = 0
            goto L_0x00f8
        L_0x00f6:
            r26 = r58
        L_0x00f8:
            r1 = 8388608(0x800000, float:1.17549435E-38)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0100
            r27 = 0
            goto L_0x0102
        L_0x0100:
            r27 = r59
        L_0x0102:
            r1 = 16777216(0x1000000, float:2.3509887E-38)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x010a
            r28 = 0
            goto L_0x010c
        L_0x010a:
            r28 = r60
        L_0x010c:
            r1 = 33554432(0x2000000, float:9.403955E-38)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0114
            r29 = 0
            goto L_0x0116
        L_0x0114:
            r29 = r61
        L_0x0116:
            r1 = 67108864(0x4000000, float:1.5046328E-36)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x011e
            r30 = 0
            goto L_0x0120
        L_0x011e:
            r30 = r62
        L_0x0120:
            r1 = 134217728(0x8000000, float:3.85186E-34)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0128
            r31 = 0
            goto L_0x012a
        L_0x0128:
            r31 = r63
        L_0x012a:
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0132
            r32 = 0
            goto L_0x0134
        L_0x0132:
            r32 = r64
        L_0x0134:
            r1 = 536870912(0x20000000, float:1.0842022E-19)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x013f
            r1 = r2
            com.giphy.sdk.core.models.BottleData r1 = (com.giphy.sdk.core.models.BottleData) r1
            r33 = r1
            goto L_0x0141
        L_0x013f:
            r33 = r65
        L_0x0141:
            r1 = 1073741824(0x40000000, float:2.0)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x014c
            r0 = r2
            java.util.HashMap r0 = (java.util.HashMap) r0
            r34 = r0
            goto L_0x014e
        L_0x014c:
            r34 = r66
        L_0x014e:
            r3 = r35
            r4 = r36
            r18 = r50
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.giphy.sdk.core.models.Media.<init>(java.lang.String, com.giphy.sdk.core.models.enums.MediaType, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.giphy.sdk.core.models.enums.RatingType, java.lang.String, java.util.List, java.util.List, com.giphy.sdk.core.models.User, com.giphy.sdk.core.models.Images, java.lang.String, java.lang.String, java.util.Date, java.util.Date, java.util.Date, java.util.Date, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, com.giphy.sdk.core.models.BottleData, java.util.HashMap, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final MediaType getType() {
        return this.type;
    }

    public final void setType(MediaType mediaType) {
        this.type = mediaType;
    }

    public final String getSlug() {
        return this.slug;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getBitlyGifUrl() {
        return this.bitlyGifUrl;
    }

    public final String getBitlyUrl() {
        return this.bitlyUrl;
    }

    public final String getEmbedUrl() {
        return this.embedUrl;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getTitle() {
        return this.title;
    }

    public final RatingType getRating() {
        return this.rating;
    }

    public final String getContentUrl() {
        return this.contentUrl;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final List<String> getFeaturedTags() {
        return this.featuredTags;
    }

    public final User getUser() {
        return this.user;
    }

    public final void setUser(User user2) {
        this.user = user2;
    }

    public final Images getImages() {
        return this.images;
    }

    public final void setImages(Images images2) {
        Intrinsics.checkParameterIsNotNull(images2, "<set-?>");
        this.images = images2;
    }

    public final String getSourceTld() {
        return this.sourceTld;
    }

    public final String getSourcePostUrl() {
        return this.sourcePostUrl;
    }

    public final Date getUpdateDate() {
        return this.updateDate;
    }

    public final Date getCreateDate() {
        return this.createDate;
    }

    public final Date getImportDate() {
        return this.importDate;
    }

    public final Date getTrendingDate() {
        return this.trendingDate;
    }

    public final boolean isHidden() {
        return this.isHidden;
    }

    public final boolean isRemoved() {
        return this.isRemoved;
    }

    public final boolean isCommunity() {
        return this.isCommunity;
    }

    public final boolean isAnonymous() {
        return this.isAnonymous;
    }

    public final boolean isFeatured() {
        return this.isFeatured;
    }

    public final boolean isRealtime() {
        return this.isRealtime;
    }

    public final boolean isIndexable() {
        return this.isIndexable;
    }

    public final boolean isSticker() {
        return this.isSticker;
    }

    public final BottleData getBottleData() {
        return this.bottleData;
    }

    public final void setBottleData(BottleData bottleData2) {
        this.bottleData = bottleData2;
    }

    public final HashMap<String, String> getUserDictionary() {
        return this.userDictionary;
    }

    public final void setUserDictionary(HashMap<String, String> hashMap) {
        this.userDictionary = hashMap;
    }

    public final String getTid() {
        BottleData bottleData2 = this.bottleData;
        if (bottleData2 == null) {
            return null;
        }
        if (bottleData2 == null) {
            Intrinsics.throwNpe();
        }
        return bottleData2.getTid();
    }

    public final void postProcess() {
        this.images.setMediaId(this.f176id);
        this.images.postProcess();
    }
}
