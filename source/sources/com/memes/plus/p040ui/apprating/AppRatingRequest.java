package com.memes.plus.p040ui.apprating;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo26107d2 = {"Lcom/memes/plus/ui/apprating/AppRatingRequest;", "", "memerText", "", "profilePic", "(Ljava/lang/String;Ljava/lang/String;)V", "getMemerText", "()Ljava/lang/String;", "getProfilePic", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.apprating.AppRatingRequest */
/* compiled from: AppRatingRequest.kt */
public final class AppRatingRequest {
    private final String memerText;
    private final String profilePic;

    public static /* synthetic */ AppRatingRequest copy$default(AppRatingRequest appRatingRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appRatingRequest.memerText;
        }
        if ((i & 2) != 0) {
            str2 = appRatingRequest.profilePic;
        }
        return appRatingRequest.copy(str, str2);
    }

    public final String component1() {
        return this.memerText;
    }

    public final String component2() {
        return this.profilePic;
    }

    public final AppRatingRequest copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "memerText");
        return new AppRatingRequest(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppRatingRequest)) {
            return false;
        }
        AppRatingRequest appRatingRequest = (AppRatingRequest) obj;
        return Intrinsics.areEqual((Object) this.memerText, (Object) appRatingRequest.memerText) && Intrinsics.areEqual((Object) this.profilePic, (Object) appRatingRequest.profilePic);
    }

    public int hashCode() {
        String str = this.memerText;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.profilePic;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "AppRatingRequest(memerText=" + this.memerText + ", profilePic=" + this.profilePic + ")";
    }

    public AppRatingRequest(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "memerText");
        this.memerText = str;
        this.profilePic = str2;
    }

    public final String getMemerText() {
        return this.memerText;
    }

    public final String getProfilePic() {
        return this.profilePic;
    }
}
