package com.memes.plus.p040ui.create_post.captionsuggestions;

import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/ui/create_post/captionsuggestions/CaptionTagSuggestion;", "", "()V", "HashTagSuggestion", "PeopleSuggestion", "Lcom/memes/plus/ui/create_post/captionsuggestions/CaptionTagSuggestion$PeopleSuggestion;", "Lcom/memes/plus/ui/create_post/captionsuggestions/CaptionTagSuggestion$HashTagSuggestion;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.create_post.captionsuggestions.CaptionTagSuggestion */
/* compiled from: CaptionTagSuggestion.kt */
public abstract class CaptionTagSuggestion {
    private CaptionTagSuggestion() {
    }

    public /* synthetic */ CaptionTagSuggestion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, mo26107d2 = {"Lcom/memes/plus/ui/create_post/captionsuggestions/CaptionTagSuggestion$PeopleSuggestion;", "Lcom/memes/plus/ui/create_post/captionsuggestions/CaptionTagSuggestion;", "userName", "", "fullName", "profileImageThumbUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFullName", "()Ljava/lang/String;", "getProfileImageThumbUrl", "getUserName", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.create_post.captionsuggestions.CaptionTagSuggestion$PeopleSuggestion */
    /* compiled from: CaptionTagSuggestion.kt */
    public static final class PeopleSuggestion extends CaptionTagSuggestion {
        private final String fullName;
        private final String profileImageThumbUrl;
        private final String userName;

        public static /* synthetic */ PeopleSuggestion copy$default(PeopleSuggestion peopleSuggestion, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = peopleSuggestion.userName;
            }
            if ((i & 2) != 0) {
                str2 = peopleSuggestion.fullName;
            }
            if ((i & 4) != 0) {
                str3 = peopleSuggestion.profileImageThumbUrl;
            }
            return peopleSuggestion.copy(str, str2, str3);
        }

        public final String component1() {
            return this.userName;
        }

        public final String component2() {
            return this.fullName;
        }

        public final String component3() {
            return this.profileImageThumbUrl;
        }

        public final PeopleSuggestion copy(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_NAME);
            Intrinsics.checkNotNullParameter(str2, TagPeopleActivity.FULL_NAME);
            return new PeopleSuggestion(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PeopleSuggestion)) {
                return false;
            }
            PeopleSuggestion peopleSuggestion = (PeopleSuggestion) obj;
            return Intrinsics.areEqual((Object) this.userName, (Object) peopleSuggestion.userName) && Intrinsics.areEqual((Object) this.fullName, (Object) peopleSuggestion.fullName) && Intrinsics.areEqual((Object) this.profileImageThumbUrl, (Object) peopleSuggestion.profileImageThumbUrl);
        }

        public int hashCode() {
            String str = this.userName;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.fullName;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.profileImageThumbUrl;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "PeopleSuggestion(userName=" + this.userName + ", fullName=" + this.fullName + ", profileImageThumbUrl=" + this.profileImageThumbUrl + ")";
        }

        public final String getUserName() {
            return this.userName;
        }

        public final String getFullName() {
            return this.fullName;
        }

        public final String getProfileImageThumbUrl() {
            return this.profileImageThumbUrl;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PeopleSuggestion(String str, String str2, String str3) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_NAME);
            Intrinsics.checkNotNullParameter(str2, TagPeopleActivity.FULL_NAME);
            this.userName = str;
            this.fullName = str2;
            this.profileImageThumbUrl = str3;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, mo26107d2 = {"Lcom/memes/plus/ui/create_post/captionsuggestions/CaptionTagSuggestion$HashTagSuggestion;", "Lcom/memes/plus/ui/create_post/captionsuggestions/CaptionTagSuggestion;", "tagName", "", "totalPostsCount", "(Ljava/lang/String;Ljava/lang/String;)V", "getTagName", "()Ljava/lang/String;", "getTotalPostsCount", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.create_post.captionsuggestions.CaptionTagSuggestion$HashTagSuggestion */
    /* compiled from: CaptionTagSuggestion.kt */
    public static final class HashTagSuggestion extends CaptionTagSuggestion {
        private final String tagName;
        private final String totalPostsCount;

        public static /* synthetic */ HashTagSuggestion copy$default(HashTagSuggestion hashTagSuggestion, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = hashTagSuggestion.tagName;
            }
            if ((i & 2) != 0) {
                str2 = hashTagSuggestion.totalPostsCount;
            }
            return hashTagSuggestion.copy(str, str2);
        }

        public final String component1() {
            return this.tagName;
        }

        public final String component2() {
            return this.totalPostsCount;
        }

        public final HashTagSuggestion copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "tagName");
            return new HashTagSuggestion(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HashTagSuggestion)) {
                return false;
            }
            HashTagSuggestion hashTagSuggestion = (HashTagSuggestion) obj;
            return Intrinsics.areEqual((Object) this.tagName, (Object) hashTagSuggestion.tagName) && Intrinsics.areEqual((Object) this.totalPostsCount, (Object) hashTagSuggestion.totalPostsCount);
        }

        public int hashCode() {
            String str = this.tagName;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.totalPostsCount;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "HashTagSuggestion(tagName=" + this.tagName + ", totalPostsCount=" + this.totalPostsCount + ")";
        }

        public final String getTagName() {
            return this.tagName;
        }

        public final String getTotalPostsCount() {
            return this.totalPostsCount;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HashTagSuggestion(String str, String str2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "tagName");
            this.tagName = str;
            this.totalPostsCount = str2;
        }
    }
}
