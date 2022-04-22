package com.memes.plus.data.source.memes;

import com.memes.plus.data.mapped_response.UniversalResult;
import com.memes.plus.firebase.firebase_token.FirebaseTokenRequest;
import com.memes.plus.p040ui.create_post.CreatePostRequest;
import com.memes.plus.p040ui.explore_search.ExploreSearchRequest;
import com.memes.plus.p040ui.explore_search.people_search.PeopleSearchResult;
import com.memes.plus.p040ui.explore_search.people_search.suggestions.CatalogueSuggestedPerson;
import com.memes.plus.p040ui.explore_search.tag_search.TagSearchResult;
import com.memes.plus.p040ui.home.feeds.HomeFeedType;
import com.memes.plus.p040ui.post_comments.CommentsRequest;
import com.memes.plus.p040ui.post_comments.CommentsResponse;
import com.memes.plus.p040ui.post_comments.PostComment;
import com.memes.plus.p040ui.post_comments.addComment.AddCommentRequest;
import com.memes.plus.p040ui.post_comments.commentLike.PostCommentLikeRequest;
import com.memes.plus.p040ui.post_comments.deleteComment.DeletePostCommentRequest;
import com.memes.plus.p040ui.post_comments.reply.AddReplyRequest;
import com.memes.plus.p040ui.post_comments.reply.CommentsShowAllRepliesData;
import com.memes.plus.p040ui.post_comments.reply.DeleteReplyRequest;
import com.memes.plus.p040ui.post_comments.reply.EditReplyRequest;
import com.memes.plus.p040ui.post_comments.reply.LikeReplyRequest;
import com.memes.plus.p040ui.post_comments.reply.Reply;
import com.memes.plus.p040ui.post_comments.reply.ReportReplyRequest;
import com.memes.plus.p040ui.post_comments.reportComment.ReportCommentRequest;
import com.memes.plus.p040ui.posts.Post;
import com.memes.plus.p040ui.posts.edit_post.EditPostRequest;
import com.memes.plus.p040ui.posts.post.PostRequest;
import com.memes.plus.p040ui.posts.post_basics.follow_user.FollowUserRequest;
import com.memes.plus.p040ui.posts.post_basics.post_delete.PostDeleteRequest;
import com.memes.plus.p040ui.posts.post_basics.post_like.PostLike;
import com.memes.plus.p040ui.posts.post_basics.post_like.PostLikeRequest;
import com.memes.plus.p040ui.posts.post_basics.post_notifications.PostNotificationSubscriptionRequest;
import com.memes.plus.p040ui.posts.post_basics.post_report.PostReportRequest;
import com.memes.plus.p040ui.posts.post_basics.post_save.PostSaveRequest;
import com.memes.plus.p040ui.posts.post_tags_dialog.PostTaggedUser;
import com.memes.plus.p040ui.posts.post_tags_dialog.PostTaggedUsersRequest;
import com.memes.plus.p040ui.posts.suggestions.SuggestedUsersRequest;
import com.memes.plus.p040ui.profile.edit_profile.SaveProfileRequest;
import com.memes.plus.p040ui.profile.edit_profile.notification_settings.NotificationSettingsRequest;
import com.memes.plus.p040ui.profile.self_profile.SelfProfile;
import com.memes.plus.p040ui.profile.user_profile.BlockUnblockUserRequest;
import com.memes.plus.p040ui.profile.user_profile.BlockUnblockUserResponse;
import com.memes.plus.p040ui.profile.user_profile.UserProfileRequest;
import com.memes.plus.p040ui.profile.user_profile.UserProfileResponse;
import com.memes.plus.p040ui.social_notifications.SocialNotification;
import com.memes.plus.p040ui.subscription.PurchaseRecord;
import com.memes.plus.p040ui.suggestions.SuggestedProfile;
import com.memes.plus.p040ui.user_listing.ListedUser;
import com.memes.plus.p040ui.user_listing.followers.FollowersRequest;
import com.memes.plus.p040ui.user_listing.followings.FollowingsRequest;
import com.memes.plus.p040ui.user_listing.post_likes.PostLikeUsersRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import p015io.reactivex.Single;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000Â\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\u00032\u0006\u0010\u0006\u001a\u00020\nH&J\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0010H&J\u001c\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0012H&J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0014H&J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0016H&J\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0018H&J\u001c\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u001aH&J\u001c\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u001dH&J\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u001fH&J\u001c\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00040\u00032\u0006\u0010\u0006\u001a\u00020\"H&J\u001c\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00040\u00032\u0006\u0010\u0006\u001a\u00020%H&J\u001c\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0\u00040\u00032\u0006\u0010\u0006\u001a\u00020%H&J\u001c\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00040\u00032\u0006\u0010\u0006\u001a\u00020)H&J\u001f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00042\u0006\u0010\u0006\u001a\u00020,H¦@ø\u0001\u0000¢\u0006\u0002\u0010-J$\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00040\u00032\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H&J\u001c\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00040\u00032\u0006\u0010/\u001a\u000200H&J\u0014\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050\u00040\u0003H&J\u001c\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00040\u00032\u0006\u0010/\u001a\u000200H&J\u001c\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00040\u00032\u0006\u0010/\u001a\u000200H&J\u001c\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u00040\u00032\u0006\u0010/\u001a\u000200H&J\u001c\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0\u00040\u00032\u0006\u0010\u0006\u001a\u00020<H&J\u0014\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0\u00040\u0003H&J\u001c\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00040\u00032\u0006\u0010/\u001a\u000200H&J\u001c\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00040\u00032\u0006\u0010\u0006\u001a\u00020AH&J\u001c\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020C0\u00040\u00032\u0006\u0010\u0006\u001a\u00020AH&J\u001c\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00040\u00032\u0006\u0010\u0006\u001a\u00020AH&J\u001c\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\u0006\u0010\u0006\u001a\u00020FH&J\u0014\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u0003H&J\u001f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010I\u001a\u00020JH¦@ø\u0001\u0000¢\u0006\u0002\u0010KJ\u001c\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\u0006\u0010\u0006\u001a\u00020MH&J\u001c\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\u0006\u0010\u0006\u001a\u00020OH&J\u001c\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\u0006\u0010\u0006\u001a\u00020QH&J\u001c\u0010R\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050\u00040\u00032\u0006\u0010\u0006\u001a\u00020SH&J\u001c\u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020U0\u00040\u00032\u0006\u0010\u0006\u001a\u00020VH&J$\u0010W\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00040\u00032\u0006\u0010X\u001a\u00020Y2\u0006\u0010/\u001a\u000200H&J\u001c\u0010Z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020[0\u00040\u00032\u0006\u0010\u0006\u001a\u00020VH&J\u001c\u0010\\\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\u0006\u0010\u0006\u001a\u00020]H&J\u001c\u0010^\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\u0006\u0010\u0006\u001a\u00020_H&J\u001c\u0010`\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0010H&J\u001c\u0010a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020b0\u00040\u00032\u0006\u0010\u0006\u001a\u00020cH&J\u001c\u0010d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\u0006\u0010\u0006\u001a\u00020eH&J\u001c\u0010f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\u0006\u0010\u0006\u001a\u00020gH&J\u001c\u0010h\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\u0006\u0010\u0006\u001a\u00020iH&J\u001c\u0010j\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010k\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\u00032\u0006\u0010\u0006\u001a\u00020lH&\u0002\u0004\n\u0002\b\u0019¨\u0006m"}, mo26107d2 = {"Lcom/memes/plus/data/source/memes/MemesDataSource;", "", "addPostComment", "Lio/reactivex/Single;", "Lcom/memes/plus/data/mapped_response/UniversalResult;", "Lcom/memes/plus/ui/post_comments/PostComment;", "request", "Lcom/memes/plus/ui/post_comments/addComment/AddCommentRequest;", "addReply", "Lcom/memes/plus/ui/post_comments/reply/Reply;", "Lcom/memes/plus/ui/post_comments/reply/AddReplyRequest;", "blockUnblockUser", "Lcom/memes/plus/ui/profile/user_profile/BlockUnblockUserResponse;", "Lcom/memes/plus/ui/profile/user_profile/BlockUnblockUserRequest;", "(Lcom/memes/plus/ui/profile/user_profile/BlockUnblockUserRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changeNotificationStatus", "Lcom/memes/plus/ui/profile/edit_profile/notification_settings/NotificationSettingsRequest;", "createPost", "Lcom/memes/plus/ui/create_post/CreatePostRequest;", "deletePost", "Lcom/memes/plus/ui/posts/post_basics/post_delete/PostDeleteRequest;", "deletePostComment", "Lcom/memes/plus/ui/post_comments/deleteComment/DeletePostCommentRequest;", "deleteReply", "Lcom/memes/plus/ui/post_comments/reply/DeleteReplyRequest;", "editPost", "Lcom/memes/plus/ui/posts/edit_post/EditPostRequest;", "fetchFollowers", "Lcom/memes/plus/ui/user_listing/ListedUser;", "Lcom/memes/plus/ui/user_listing/followers/FollowersRequest;", "fetchFollowings", "Lcom/memes/plus/ui/user_listing/followings/FollowingsRequest;", "fetchPost", "Lcom/memes/plus/ui/posts/Post;", "Lcom/memes/plus/ui/posts/post/PostRequest;", "fetchPostComments", "Lcom/memes/plus/ui/post_comments/CommentsResponse;", "Lcom/memes/plus/ui/post_comments/CommentsRequest;", "fetchPostCommentsReplies", "Lcom/memes/plus/ui/post_comments/reply/CommentsShowAllRepliesData;", "fetchPostLikeUsers", "Lcom/memes/plus/ui/user_listing/post_likes/PostLikeUsersRequest;", "fetchPostTaggedUsers", "Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUser;", "Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUsersRequest;", "(Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUsersRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchPosts", "page", "", "type", "Lcom/memes/plus/ui/home/feeds/HomeFeedType;", "fetchSelfPosts", "fetchSelfProfile", "Lcom/memes/plus/ui/profile/self_profile/SelfProfile;", "fetchSelfSavedPosts", "fetchSelfTaggedPosts", "fetchSocialNotifications", "Lcom/memes/plus/ui/social_notifications/SocialNotification;", "fetchSuggestedProfiles", "Lcom/memes/plus/ui/suggestions/SuggestedProfile;", "Lcom/memes/plus/ui/posts/suggestions/SuggestedUsersRequest;", "fetchSuggestedUsers", "Lcom/memes/plus/ui/explore_search/people_search/suggestions/CatalogueSuggestedPerson;", "fetchTopPosts", "fetchUserPosts", "Lcom/memes/plus/ui/profile/user_profile/UserProfileRequest;", "fetchUserProfile", "Lcom/memes/plus/ui/profile/user_profile/UserProfileResponse;", "fetchUserTaggedPosts", "likeReply", "Lcom/memes/plus/ui/post_comments/reply/LikeReplyRequest;", "logout", "registerPurchaseToServer", "record", "Lcom/memes/plus/ui/subscription/PurchaseRecord;", "(Lcom/memes/plus/ui/subscription/PurchaseRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportComment", "Lcom/memes/plus/ui/post_comments/reportComment/ReportCommentRequest;", "reportPost", "Lcom/memes/plus/ui/posts/post_basics/post_report/PostReportRequest;", "reportReply", "Lcom/memes/plus/ui/post_comments/reply/ReportReplyRequest;", "saveProfile", "Lcom/memes/plus/ui/profile/edit_profile/SaveProfileRequest;", "searchPeople", "Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResult;", "Lcom/memes/plus/ui/explore_search/ExploreSearchRequest;", "searchPostsByTag", "hashtag", "", "searchTags", "Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResult;", "toggleCommentLike", "Lcom/memes/plus/ui/post_comments/commentLike/PostCommentLikeRequest;", "toggleFollowUser", "Lcom/memes/plus/ui/posts/post_basics/follow_user/FollowUserRequest;", "toggleNotificationStatus", "togglePostLike", "Lcom/memes/plus/ui/posts/post_basics/post_like/PostLike;", "Lcom/memes/plus/ui/posts/post_basics/post_like/PostLikeRequest;", "togglePostNotificationsSubscription", "Lcom/memes/plus/ui/posts/post_basics/post_notifications/PostNotificationSubscriptionRequest;", "togglePostSave", "Lcom/memes/plus/ui/posts/post_basics/post_save/PostSaveRequest;", "updateFirebaseToken", "Lcom/memes/plus/firebase/firebase_token/FirebaseTokenRequest;", "updatePostComment", "updateReplyComment", "Lcom/memes/plus/ui/post_comments/reply/EditReplyRequest;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MemesDataSource.kt */
public interface MemesDataSource {
    Single<UniversalResult<PostComment>> addPostComment(AddCommentRequest addCommentRequest);

    Single<UniversalResult<Reply>> addReply(AddReplyRequest addReplyRequest);

    Object blockUnblockUser(BlockUnblockUserRequest blockUnblockUserRequest, Continuation<? super UniversalResult<BlockUnblockUserResponse>> continuation);

    Single<UniversalResult<NotificationSettingsRequest>> changeNotificationStatus(NotificationSettingsRequest notificationSettingsRequest);

    Single<UniversalResult<Object>> createPost(CreatePostRequest createPostRequest);

    Single<UniversalResult<Object>> deletePost(PostDeleteRequest postDeleteRequest);

    Single<UniversalResult<Object>> deletePostComment(DeletePostCommentRequest deletePostCommentRequest);

    Single<UniversalResult<Object>> deleteReply(DeleteReplyRequest deleteReplyRequest);

    Single<UniversalResult<Object>> editPost(EditPostRequest editPostRequest);

    Single<UniversalResult<ListedUser>> fetchFollowers(FollowersRequest followersRequest);

    Single<UniversalResult<ListedUser>> fetchFollowings(FollowingsRequest followingsRequest);

    Single<UniversalResult<Post>> fetchPost(PostRequest postRequest);

    Single<UniversalResult<CommentsResponse>> fetchPostComments(CommentsRequest commentsRequest);

    Single<UniversalResult<CommentsShowAllRepliesData>> fetchPostCommentsReplies(CommentsRequest commentsRequest);

    Single<UniversalResult<ListedUser>> fetchPostLikeUsers(PostLikeUsersRequest postLikeUsersRequest);

    Object fetchPostTaggedUsers(PostTaggedUsersRequest postTaggedUsersRequest, Continuation<? super UniversalResult<PostTaggedUser>> continuation);

    Single<UniversalResult<Post>> fetchPosts(int i, HomeFeedType homeFeedType);

    Single<UniversalResult<Post>> fetchSelfPosts(int i);

    Single<UniversalResult<SelfProfile>> fetchSelfProfile();

    Single<UniversalResult<Post>> fetchSelfSavedPosts(int i);

    Single<UniversalResult<Post>> fetchSelfTaggedPosts(int i);

    Single<UniversalResult<SocialNotification>> fetchSocialNotifications(int i);

    Single<UniversalResult<SuggestedProfile>> fetchSuggestedProfiles(SuggestedUsersRequest suggestedUsersRequest);

    Single<UniversalResult<CatalogueSuggestedPerson>> fetchSuggestedUsers();

    Single<UniversalResult<Post>> fetchTopPosts(int i);

    Single<UniversalResult<Post>> fetchUserPosts(UserProfileRequest userProfileRequest);

    Single<UniversalResult<UserProfileResponse>> fetchUserProfile(UserProfileRequest userProfileRequest);

    Single<UniversalResult<Post>> fetchUserTaggedPosts(UserProfileRequest userProfileRequest);

    Single<UniversalResult<Object>> likeReply(LikeReplyRequest likeReplyRequest);

    Single<UniversalResult<Object>> logout();

    Object registerPurchaseToServer(PurchaseRecord purchaseRecord, Continuation<? super UniversalResult<Object>> continuation);

    Single<UniversalResult<Object>> reportComment(ReportCommentRequest reportCommentRequest);

    Single<UniversalResult<Object>> reportPost(PostReportRequest postReportRequest);

    Single<UniversalResult<Object>> reportReply(ReportReplyRequest reportReplyRequest);

    Single<UniversalResult<SelfProfile>> saveProfile(SaveProfileRequest saveProfileRequest);

    Single<UniversalResult<PeopleSearchResult>> searchPeople(ExploreSearchRequest exploreSearchRequest);

    Single<UniversalResult<Post>> searchPostsByTag(String str, int i);

    Single<UniversalResult<TagSearchResult>> searchTags(ExploreSearchRequest exploreSearchRequest);

    Single<UniversalResult<Object>> toggleCommentLike(PostCommentLikeRequest postCommentLikeRequest);

    Single<UniversalResult<Object>> toggleFollowUser(FollowUserRequest followUserRequest);

    Single<UniversalResult<NotificationSettingsRequest>> toggleNotificationStatus(NotificationSettingsRequest notificationSettingsRequest);

    Single<UniversalResult<PostLike>> togglePostLike(PostLikeRequest postLikeRequest);

    Single<UniversalResult<Object>> togglePostNotificationsSubscription(PostNotificationSubscriptionRequest postNotificationSubscriptionRequest);

    Single<UniversalResult<Object>> togglePostSave(PostSaveRequest postSaveRequest);

    Single<UniversalResult<Object>> updateFirebaseToken(FirebaseTokenRequest firebaseTokenRequest);

    Single<UniversalResult<PostComment>> updatePostComment(AddCommentRequest addCommentRequest);

    Single<UniversalResult<Reply>> updateReplyComment(EditReplyRequest editReplyRequest);
}
