package com.memes.network.chat.source.remote.model.fileupload;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006\u001b"}, mo26107d2 = {"Lcom/memes/network/chat/source/remote/model/fileupload/GenerateUploadUrlResult;", "", "success", "", "message", "", "finalUrl", "uploadUrl", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFinalUrl", "()Ljava/lang/String;", "getMessage", "getSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUploadUrl", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/memes/network/chat/source/remote/model/fileupload/GenerateUploadUrlResult;", "equals", "other", "hashCode", "", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GenerateUploadUrlResult.kt */
public final class GenerateUploadUrlResult {
    @SerializedName("final_url")
    @Expose
    private final String finalUrl;
    @SerializedName("message")
    @Expose
    private final String message;
    @SerializedName("success")
    @Expose
    private final Boolean success;
    @SerializedName("upload_url")
    @Expose
    private final String uploadUrl;

    public static /* synthetic */ GenerateUploadUrlResult copy$default(GenerateUploadUrlResult generateUploadUrlResult, Boolean bool, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = generateUploadUrlResult.success;
        }
        if ((i & 2) != 0) {
            str = generateUploadUrlResult.message;
        }
        if ((i & 4) != 0) {
            str2 = generateUploadUrlResult.finalUrl;
        }
        if ((i & 8) != 0) {
            str3 = generateUploadUrlResult.uploadUrl;
        }
        return generateUploadUrlResult.copy(bool, str, str2, str3);
    }

    public final Boolean component1() {
        return this.success;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.finalUrl;
    }

    public final String component4() {
        return this.uploadUrl;
    }

    public final GenerateUploadUrlResult copy(Boolean bool, String str, String str2, String str3) {
        return new GenerateUploadUrlResult(bool, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GenerateUploadUrlResult)) {
            return false;
        }
        GenerateUploadUrlResult generateUploadUrlResult = (GenerateUploadUrlResult) obj;
        return Intrinsics.areEqual((Object) this.success, (Object) generateUploadUrlResult.success) && Intrinsics.areEqual((Object) this.message, (Object) generateUploadUrlResult.message) && Intrinsics.areEqual((Object) this.finalUrl, (Object) generateUploadUrlResult.finalUrl) && Intrinsics.areEqual((Object) this.uploadUrl, (Object) generateUploadUrlResult.uploadUrl);
    }

    public int hashCode() {
        Boolean bool = this.success;
        int i = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
        String str = this.message;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.finalUrl;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.uploadUrl;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "GenerateUploadUrlResult(success=" + this.success + ", message=" + this.message + ", finalUrl=" + this.finalUrl + ", uploadUrl=" + this.uploadUrl + ")";
    }

    public GenerateUploadUrlResult(Boolean bool, String str, String str2, String str3) {
        this.success = bool;
        this.message = str;
        this.finalUrl = str2;
        this.uploadUrl = str3;
    }

    public final Boolean getSuccess() {
        return this.success;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getFinalUrl() {
        return this.finalUrl;
    }

    public final String getUploadUrl() {
        return this.uploadUrl;
    }
}
