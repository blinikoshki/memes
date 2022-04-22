package com.memes.plus.p040ui.posts;

import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.memes.commons.aspectratio.AspectRatioCalculator;
import com.memes.plus.p040ui.posts.commentpreviewbox.PostPreviewComment;
import com.memes.plus.util.BooleanIntPropertyConverter;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010f\u001a\u00020gJ\u0006\u0010h\u001a\u00020\u001bJ\b\u0010i\u001a\u0004\u0018\u00010\u0012J\b\u0010j\u001a\u0004\u0018\u00010kJ\b\u0010l\u001a\u0004\u0018\u00010kJ\u0006\u0010m\u001a\u00020\u0012J\u0006\u0010n\u001a\u00020\u0012J\u0006\u0010o\u001a\u00020\u0012J\u0010\u0010p\u001a\u00020q2\b\u00109\u001a\u0004\u0018\u00010\u0012J\u0006\u0010r\u001a\u00020qR&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\"8\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b'\u0010$R\u001e\u0010(\u001a\u00020\"8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u001e\u0010*\u001a\u00020\"8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&R \u0010-\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0014\"\u0004\b/\u0010\u0016R\u001e\u00100\u001a\u00020\"8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010$\"\u0004\b2\u0010&R \u00103\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0014\"\u0004\b5\u0010\u0016R \u00106\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0014\"\u0004\b8\u0010\u0016R\u0014\u00109\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R \u0010:\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0014\"\u0004\b<\u0010\u0016R \u0010=\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0014\"\u0004\b?\u0010\u0016R \u0010@\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0014\"\u0004\bB\u0010\u0016R \u0010C\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0014\"\u0004\bE\u0010\u0016R \u0010F\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001e\u0010L\u001a\u00020\"8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010$\"\u0004\bN\u0010&R \u0010O\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0014\"\u0004\bQ\u0010\u0016R\u001e\u0010R\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001e\u0010W\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010T\"\u0004\bY\u0010VR \u0010Z\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0014\"\u0004\b\\\u0010\u0016R \u0010]\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u0014\"\u0004\b_\u0010\u0016R \u0010`\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u0014\"\u0004\bb\u0010\u0016R\"\u0010c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\bd\u0010\u001d\"\u0004\be\u0010\u001f¨\u0006s"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/Post;", "", "()V", "comments", "", "Lcom/memes/plus/ui/posts/commentpreviewbox/PostPreviewComment;", "getComments", "()Ljava/util/List;", "setComments", "(Ljava/util/List;)V", "createdDate", "", "getCreatedDate", "()Ljava/lang/Long;", "setCreatedDate", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "followUserId", "", "getFollowUserId", "()Ljava/lang/String;", "setFollowUserId", "(Ljava/lang/String;)V", "hashtags", "getHashtags", "setHashtags", "height", "", "getHeight", "()Ljava/lang/Integer;", "setHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "iamfollowing", "", "getIamfollowing", "()Z", "setIamfollowing", "(Z)V", "isProUser", "isTagged", "setTagged", "liked", "getLiked", "setLiked", "mediaType", "getMediaType", "setMediaType", "notificationsEnabled", "getNotificationsEnabled", "setNotificationsEnabled", "postId", "getPostId", "setPostId", "postImage", "getPostImage", "setPostImage", "postText", "postThumb", "getPostThumb", "setPostThumb", "postThumbPath", "getPostThumbPath", "setPostThumbPath", "profileImage", "getProfileImage", "setProfileImage", "profileImageThumb", "getProfileImageThumb", "setProfileImageThumb", "rePost", "Lcom/memes/plus/ui/posts/Repost;", "getRePost", "()Lcom/memes/plus/ui/posts/Repost;", "setRePost", "(Lcom/memes/plus/ui/posts/Repost;)V", "saved", "getSaved", "setSaved", "shareLink", "getShareLink", "setShareLink", "totalComments", "getTotalComments", "()J", "setTotalComments", "(J)V", "totalLikes", "getTotalLikes", "setTotalLikes", "totalViews", "getTotalViews", "setTotalViews", "userId", "getUserId", "setUserId", "username", "getUsername", "setUsername", "width", "getWidth", "setWidth", "aspectRatio", "", "contentType", "getPostText", "mediaThumbUrl", "Landroid/net/Uri;", "mediaUrl", "requireAuthorUserId", "requireAuthorUserName", "requirePostId", "setPostText", "", "updatePostIdForComments", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.Post */
/* compiled from: Post.kt */
public class Post {
    @SerializedName("comments")
    @Expose
    private List<PostPreviewComment> comments;
    @SerializedName("createdDate")
    @Expose
    private Long createdDate;
    @SerializedName("followUserId")
    @Expose
    private String followUserId;
    @SerializedName("hashtags")
    @Expose
    private String hashtags;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("iamfollowing")
    @JsonAdapter(BooleanIntPropertyConverter.class)
    @Expose
    private boolean iamfollowing;
    @SerializedName("pro_user")
    private final boolean isProUser;
    @SerializedName("isTagged")
    @JsonAdapter(BooleanIntPropertyConverter.class)
    @Expose
    private boolean isTagged;
    @SerializedName("iLiked")
    @JsonAdapter(BooleanIntPropertyConverter.class)
    @Expose
    private boolean liked;
    @SerializedName("media_type")
    @Expose
    private String mediaType;
    @SerializedName("postNotification")
    @JsonAdapter(BooleanIntPropertyConverter.class)
    @Expose
    private boolean notificationsEnabled;
    @SerializedName("post_id")
    @Expose
    private String postId;
    @SerializedName("postImage")
    @Expose
    private String postImage;
    @SerializedName("postText")
    @Expose
    private String postText;
    @SerializedName("postThumb")
    @Expose
    private String postThumb;
    @SerializedName("postThumbPath")
    @Expose
    private String postThumbPath;
    @SerializedName("profileImage")
    @Expose
    private String profileImage;
    @SerializedName("profileImageThumb")
    @Expose
    private String profileImageThumb;
    @SerializedName("repost")
    @Expose
    private Repost rePost;
    @SerializedName("saved")
    @JsonAdapter(BooleanIntPropertyConverter.class)
    @Expose
    private boolean saved;
    @SerializedName("shareLink")
    @Expose
    private String shareLink;
    @SerializedName("totalComments")
    @Expose
    private long totalComments;
    @SerializedName("totalLikes")
    @Expose
    private long totalLikes;
    @SerializedName("views")
    @Expose
    private String totalViews;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("width")
    @Expose
    private Integer width;

    public final boolean getSaved() {
        return this.saved;
    }

    public final void setSaved(boolean z) {
        this.saved = z;
    }

    public final boolean getLiked() {
        return this.liked;
    }

    public final void setLiked(boolean z) {
        this.liked = z;
    }

    public final String getUsername() {
        return this.username;
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    public final boolean isProUser() {
        return this.isProUser;
    }

    public final String getProfileImage() {
        return this.profileImage;
    }

    public final void setProfileImage(String str) {
        this.profileImage = str;
    }

    public final String getProfileImageThumb() {
        return this.profileImageThumb;
    }

    public final void setProfileImageThumb(String str) {
        this.profileImageThumb = str;
    }

    public final Long getCreatedDate() {
        return this.createdDate;
    }

    public final void setCreatedDate(Long l) {
        this.createdDate = l;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final void setWidth(Integer num) {
        this.width = num;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final void setHeight(Integer num) {
        this.height = num;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final String getHashtags() {
        return this.hashtags;
    }

    public final void setHashtags(String str) {
        this.hashtags = str;
    }

    public final String getPostImage() {
        return this.postImage;
    }

    public final void setPostImage(String str) {
        this.postImage = str;
    }

    public final String getPostThumb() {
        return this.postThumb;
    }

    public final void setPostThumb(String str) {
        this.postThumb = str;
    }

    public final String getPostThumbPath() {
        return this.postThumbPath;
    }

    public final void setPostThumbPath(String str) {
        this.postThumbPath = str;
    }

    public final String getShareLink() {
        return this.shareLink;
    }

    public final void setShareLink(String str) {
        this.shareLink = str;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final void setPostId(String str) {
        this.postId = str;
    }

    public final String getMediaType() {
        return this.mediaType;
    }

    public final void setMediaType(String str) {
        this.mediaType = str;
    }

    public final String getFollowUserId() {
        return this.followUserId;
    }

    public final void setFollowUserId(String str) {
        this.followUserId = str;
    }

    public final boolean isTagged() {
        return this.isTagged;
    }

    public final void setTagged(boolean z) {
        this.isTagged = z;
    }

    public final boolean getIamfollowing() {
        return this.iamfollowing;
    }

    public final void setIamfollowing(boolean z) {
        this.iamfollowing = z;
    }

    public final List<PostPreviewComment> getComments() {
        return this.comments;
    }

    public final void setComments(List<PostPreviewComment> list) {
        this.comments = list;
    }

    public final long getTotalLikes() {
        return this.totalLikes;
    }

    public final void setTotalLikes(long j) {
        this.totalLikes = j;
    }

    public final long getTotalComments() {
        return this.totalComments;
    }

    public final void setTotalComments(long j) {
        this.totalComments = j;
    }

    public final String getTotalViews() {
        return this.totalViews;
    }

    public final void setTotalViews(String str) {
        this.totalViews = str;
    }

    public final Repost getRePost() {
        return this.rePost;
    }

    public final void setRePost(Repost repost) {
        this.rePost = repost;
    }

    public final boolean getNotificationsEnabled() {
        return this.notificationsEnabled;
    }

    public final void setNotificationsEnabled(boolean z) {
        this.notificationsEnabled = z;
    }

    public final String requireAuthorUserId() {
        String str = this.userId;
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final String requireAuthorUserName() {
        String str = this.username;
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final String requirePostId() {
        String str = this.postId;
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final int contentType() {
        String str = this.mediaType;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 49) {
                if (hashCode == 50 && str.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                    return 2;
                }
            } else if (str.equals("1")) {
                return 1;
            }
        }
        return 0;
    }

    public final Uri mediaUrl() {
        CharSequence charSequence = this.postImage;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            return Uri.parse(this.postImage);
        }
        return null;
    }

    public final Uri mediaThumbUrl() {
        CharSequence charSequence = this.postThumb;
        boolean z = false;
        String str = charSequence == null || StringsKt.isBlank(charSequence) ? this.postThumbPath : this.postThumb;
        CharSequence charSequence2 = str;
        if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
            z = true;
        }
        if (!z) {
            return Uri.parse(str);
        }
        return null;
    }

    public final float aspectRatio() {
        return AspectRatioCalculator.INSTANCE.calculate(this.width, this.height);
    }

    public final String getPostText() {
        String str;
        CharSequence charSequence = this.postText;
        if (!(charSequence == null || charSequence.length() == 0) && (str = this.postText) != null) {
            return StringsKt.replace$default(str, "​", "", false, 4, (Object) null);
        }
        return null;
    }

    public final void setPostText(String str) {
        this.postText = str;
    }

    public final void updatePostIdForComments() {
        List<PostPreviewComment> list = this.comments;
        if (list != null) {
            for (PostPreviewComment postId2 : list) {
                postId2.setPostId(this.postId);
            }
        }
    }
}
