package com.memes.network.chat.source.remote.model.fileupload;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Lcom/memes/network/chat/source/remote/model/fileupload/GenerateUploadUrlRequest;", "", "type", "", "(Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GenerateUploadUrlRequest.kt */
public final class GenerateUploadUrlRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @SerializedName("type")
    @Expose
    private final String type;

    public static /* synthetic */ GenerateUploadUrlRequest copy$default(GenerateUploadUrlRequest generateUploadUrlRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = generateUploadUrlRequest.type;
        }
        return generateUploadUrlRequest.copy(str);
    }

    public final String component1() {
        return this.type;
    }

    public final GenerateUploadUrlRequest copy(String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        return new GenerateUploadUrlRequest(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof GenerateUploadUrlRequest) && Intrinsics.areEqual((Object) this.type, (Object) ((GenerateUploadUrlRequest) obj).type);
        }
        return true;
    }

    public int hashCode() {
        String str = this.type;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "GenerateUploadUrlRequest(type=" + this.type + ")";
    }

    public GenerateUploadUrlRequest(String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/network/chat/source/remote/model/fileupload/GenerateUploadUrlRequest$Companion;", "", "()V", "ofGif", "Lcom/memes/network/chat/source/remote/model/fileupload/GenerateUploadUrlRequest;", "ofPhoto", "ofVideo", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: GenerateUploadUrlRequest.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GenerateUploadUrlRequest ofPhoto() {
            return new GenerateUploadUrlRequest("image");
        }

        public final GenerateUploadUrlRequest ofGif() {
            return new GenerateUploadUrlRequest("gif");
        }

        public final GenerateUploadUrlRequest ofVideo() {
            return new GenerateUploadUrlRequest("video");
        }
    }
}
