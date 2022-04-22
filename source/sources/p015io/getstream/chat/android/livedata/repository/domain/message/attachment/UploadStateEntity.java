package p015io.getstream.chat.android.livedata.repository.domain.message.attachment;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/message/attachment/UploadStateEntity;", "", "statusCode", "", "errorMessage", "", "(ILjava/lang/String;)V", "getErrorMessage", "()Ljava/lang/String;", "getStatusCode", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.message.attachment.UploadStateEntity */
/* compiled from: AttachmentEntity.kt */
public final class UploadStateEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int UPLOAD_STATE_FAILED = 3;
    public static final int UPLOAD_STATE_IN_PROGRESS = 2;
    public static final int UPLOAD_STATE_SUCCESS = 1;
    private final String errorMessage;
    private final int statusCode;

    public static /* synthetic */ UploadStateEntity copy$default(UploadStateEntity uploadStateEntity, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = uploadStateEntity.statusCode;
        }
        if ((i2 & 2) != 0) {
            str = uploadStateEntity.errorMessage;
        }
        return uploadStateEntity.copy(i, str);
    }

    public final int component1() {
        return this.statusCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final UploadStateEntity copy(int i, String str) {
        return new UploadStateEntity(i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadStateEntity)) {
            return false;
        }
        UploadStateEntity uploadStateEntity = (UploadStateEntity) obj;
        return this.statusCode == uploadStateEntity.statusCode && Intrinsics.areEqual((Object) this.errorMessage, (Object) uploadStateEntity.errorMessage);
    }

    public int hashCode() {
        int i = this.statusCode * 31;
        String str = this.errorMessage;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "UploadStateEntity(statusCode=" + this.statusCode + ", errorMessage=" + this.errorMessage + ")";
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/message/attachment/UploadStateEntity$Companion;", "", "()V", "UPLOAD_STATE_FAILED", "", "UPLOAD_STATE_IN_PROGRESS", "UPLOAD_STATE_SUCCESS", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.livedata.repository.domain.message.attachment.UploadStateEntity$Companion */
    /* compiled from: AttachmentEntity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public UploadStateEntity(int i, String str) {
        this.statusCode = i;
        this.errorMessage = str;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }
}
