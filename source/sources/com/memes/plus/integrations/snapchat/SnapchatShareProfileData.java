package com.memes.plus.integrations.snapchat;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo26107d2 = {"Lcom/memes/plus/integrations/snapchat/SnapchatShareProfileData;", "", "userProfileId", "", "userProfileScreenshotFile", "Ljava/io/File;", "(Ljava/lang/String;Ljava/io/File;)V", "getUserProfileId", "()Ljava/lang/String;", "getUserProfileScreenshotFile", "()Ljava/io/File;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: SnapchatShareProfileData.kt */
public final class SnapchatShareProfileData {
    private final String userProfileId;
    private final File userProfileScreenshotFile;

    public static /* synthetic */ SnapchatShareProfileData copy$default(SnapchatShareProfileData snapchatShareProfileData, String str, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            str = snapchatShareProfileData.userProfileId;
        }
        if ((i & 2) != 0) {
            file = snapchatShareProfileData.userProfileScreenshotFile;
        }
        return snapchatShareProfileData.copy(str, file);
    }

    public final String component1() {
        return this.userProfileId;
    }

    public final File component2() {
        return this.userProfileScreenshotFile;
    }

    public final SnapchatShareProfileData copy(String str, File file) {
        Intrinsics.checkNotNullParameter(str, "userProfileId");
        Intrinsics.checkNotNullParameter(file, "userProfileScreenshotFile");
        return new SnapchatShareProfileData(str, file);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SnapchatShareProfileData)) {
            return false;
        }
        SnapchatShareProfileData snapchatShareProfileData = (SnapchatShareProfileData) obj;
        return Intrinsics.areEqual((Object) this.userProfileId, (Object) snapchatShareProfileData.userProfileId) && Intrinsics.areEqual((Object) this.userProfileScreenshotFile, (Object) snapchatShareProfileData.userProfileScreenshotFile);
    }

    public int hashCode() {
        String str = this.userProfileId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        File file = this.userProfileScreenshotFile;
        if (file != null) {
            i = file.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "SnapchatShareProfileData(userProfileId=" + this.userProfileId + ", userProfileScreenshotFile=" + this.userProfileScreenshotFile + ")";
    }

    public SnapchatShareProfileData(String str, File file) {
        Intrinsics.checkNotNullParameter(str, "userProfileId");
        Intrinsics.checkNotNullParameter(file, "userProfileScreenshotFile");
        this.userProfileId = str;
        this.userProfileScreenshotFile = file;
    }

    public final String getUserProfileId() {
        return this.userProfileId;
    }

    public final File getUserProfileScreenshotFile() {
        return this.userProfileScreenshotFile;
    }
}
