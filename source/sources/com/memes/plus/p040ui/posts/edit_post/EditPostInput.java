package com.memes.plus.p040ui.posts.edit_post;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.memes.commons.media.MediaType;
import com.memes.plus.p040ui.posts.Post;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dBK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0007\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/edit_post/EditPostInput;", "Landroid/os/Parcelable;", "postId", "", "postUrl", "Landroid/net/Uri;", "postThumb", "contentType", "authorName", "authorProfileThumb", "postText", "(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthorName", "()Ljava/lang/String;", "getAuthorProfileThumb", "getContentType", "getPostId", "getPostText", "getPostThumb", "getPostUrl", "()Landroid/net/Uri;", "", "describeContents", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.edit_post.EditPostInput */
/* compiled from: EditPostInput.kt */
public final class EditPostInput implements Parcelable {
    public static final Parcelable.Creator<EditPostInput> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String authorName;
    private final String authorProfileThumb;
    private final String contentType;
    private final String postId;
    private final String postText;
    private final String postThumb;
    private final Uri postUrl;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.edit_post.EditPostInput$Creator */
    public static class Creator implements Parcelable.Creator<EditPostInput> {
        public final EditPostInput createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new EditPostInput(parcel.readString(), (Uri) parcel.readParcelable(EditPostInput.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final EditPostInput[] newArray(int i) {
            return new EditPostInput[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.postId);
        parcel.writeParcelable(this.postUrl, i);
        parcel.writeString(this.postThumb);
        parcel.writeString(this.contentType);
        parcel.writeString(this.authorName);
        parcel.writeString(this.authorProfileThumb);
        parcel.writeString(this.postText);
    }

    public EditPostInput(String str, Uri uri, String str2, String str3, String str4, String str5, String str6) {
        this.postId = str;
        this.postUrl = uri;
        this.postThumb = str2;
        this.contentType = str3;
        this.authorName = str4;
        this.authorProfileThumb = str5;
        this.postText = str6;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final Uri getPostUrl() {
        return this.postUrl;
    }

    public final String getPostThumb() {
        return this.postThumb;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final String getAuthorName() {
        return this.authorName;
    }

    public final String getAuthorProfileThumb() {
        return this.authorProfileThumb;
    }

    public final String getPostText() {
        return this.postText;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/edit_post/EditPostInput$Companion;", "", "()V", "from", "Lcom/memes/plus/ui/posts/edit_post/EditPostInput;", "post", "Lcom/memes/plus/ui/posts/Post;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.edit_post.EditPostInput$Companion */
    /* compiled from: EditPostInput.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EditPostInput from(Post post) {
            Intrinsics.checkNotNullParameter(post, "post");
            return new EditPostInput(post.getPostId(), post.mediaUrl(), post.getPostThumb(), post.getMediaType(), post.getUsername(), post.getProfileImageThumb(), post.getPostText());
        }
    }

    public String toString() {
        return "EditPostRequest(postId=" + this.postId + ",authorName=" + this.authorName + ", authorProfileThumb='" + this.authorProfileThumb + "')";
    }

    public final int contentType() {
        String str = this.contentType;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 49) {
                if (hashCode == 50 && str.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                    return MediaType.VIDEO;
                }
            } else if (str.equals("1")) {
                return MediaType.PHOTO;
            }
        }
        return 0;
    }
}
