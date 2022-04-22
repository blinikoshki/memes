package com.memes.plus.data.domain;

import com.memes.plus.data.api_response.ApiListResponse;
import com.memes.plus.data.api_response.ApiMessageResponse;
import com.memes.plus.data.api_response.ApiObjectResponse;
import com.memes.plus.data.session.AuthenticatedContentRequest;
import com.memes.plus.firebase.firebase_token.FirebaseTokenRequest;
import com.memes.plus.p040ui.explore_search.ExploreSearchRequest;
import com.memes.plus.p040ui.explore_search.people_search.PeopleSearchResult;
import com.memes.plus.p040ui.explore_search.people_search.suggestions.CatalogueSuggestedPerson;
import com.memes.plus.p040ui.explore_search.tag_search.TagSearchResult;
import com.memes.plus.p040ui.post_comments.CommentsRequest;
import com.memes.plus.p040ui.post_comments.CommentsResponse;
import com.memes.plus.p040ui.post_comments.PostComment;
import com.memes.plus.p040ui.post_comments.addComment.AddCommentRequest;
import com.memes.plus.p040ui.post_comments.commentLike.PostCommentLikeRequest;
import com.memes.plus.p040ui.post_comments.deleteComment.DeletePostCommentRequest;
import com.memes.plus.p040ui.post_comments.reply.CommentsShowAllRepliesData;
import com.memes.plus.p040ui.post_comments.reply.DeleteReplyRequest;
import com.memes.plus.p040ui.post_comments.reply.EditReplyRequest;
import com.memes.plus.p040ui.post_comments.reply.LikeReplyRequest;
import com.memes.plus.p040ui.post_comments.reply.Reply;
import com.memes.plus.p040ui.post_comments.reply.ReportReplyRequest;
import com.memes.plus.p040ui.post_comments.reportComment.ReportCommentRequest;
import com.memes.plus.p040ui.posts.Post;
import com.memes.plus.p040ui.posts.PostsRequest;
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
import com.memes.plus.p040ui.profile.edit_profile.notification_settings.NotificationSettingsRequest;
import com.memes.plus.p040ui.profile.self_profile.SelfProfile;
import com.memes.plus.p040ui.profile.user_profile.BlockUnblockUserRequest;
import com.memes.plus.p040ui.profile.user_profile.BlockUnblockUserResponse;
import com.memes.plus.p040ui.profile.user_profile.UserProfileRequest;
import com.memes.plus.p040ui.profile.user_profile.UserProfileResponse;
import com.memes.plus.p040ui.social_notifications.SocialNotification;
import com.memes.plus.p040ui.subscription.PurchaseRecord;
import com.memes.plus.p040ui.suggestions.SuggestedProfile;
import com.memes.plus.p040ui.tagged_posts.TaggedPostsRequest;
import com.memes.plus.p040ui.user_listing.ListedUser;
import com.memes.plus.p040ui.user_listing.followers.FollowersRequest;
import com.memes.plus.p040ui.user_listing.followings.FollowingsRequest;
import com.memes.plus.p040ui.user_listing.post_likes.PostLikeUsersRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import p015io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000Ä\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\b\b\u0001\u0010\u000b\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0002\u0010\rJ$\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00050\u00040\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u000fH'J\u001e\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u001e\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u0014H'J\u001e\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u0016H'J\u001e\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u0018H'J\u001e\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u001aH'J$\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u001dH'J$\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020!H'J$\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020#H'J$\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u001f0\u00040\u00032\b\b\u0001\u0010&\u001a\u00020'H'J$\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u001f0\u00040\u00032\b\b\u0001\u0010)\u001a\u00020*H'J$\u0010+\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u001dH'J$\u0010-\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u00040\u00032\b\b\u0001\u0010\u000b\u001a\u00020.H'J'\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u001f0\u00042\b\b\u0001\u0010\u000b\u001a\u000201H§@ø\u0001\u0000¢\u0006\u0002\u00102J$\u00103\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u001f0\u00040\u00032\b\b\u0001\u0010&\u001a\u00020'H'J$\u00104\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u001f0\u00040\u00032\b\b\u0001\u0010&\u001a\u00020'H'J$\u00105\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u001f0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u000206H'J$\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002080\u001f0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u000206H'J$\u00109\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u001f0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u000206H'J$\u0010:\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0\u001f0\u00040\u00032\b\b\u0001\u0010\u000b\u001a\u000206H'J$\u0010<\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0\u001f0\u00040\u00032\b\b\u0001\u0010\u000b\u001a\u000206H'J$\u0010>\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u001f0\u00040\u00032\b\b\u0001\u0010\u000b\u001a\u000206H'J$\u0010@\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u001f0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020AH'J$\u0010B\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u001f0\u00040\u00032\b\b\u0001\u0010&\u001a\u00020'H'J$\u0010C\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u001f0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020AH'J\u001e\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020AH'J\u001e\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020GH'J\u001e\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u000206H'J!\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00120\u00042\b\b\u0001\u0010J\u001a\u00020KH§@ø\u0001\u0000¢\u0006\u0002\u0010LJ$\u0010M\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u001e\u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020PH'J\u001e\u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020RH'J\u001e\u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020TH'J$\u0010U\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002080\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J$\u0010V\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020W0\u001f0\u00040\u00032\b\b\u0001\u0010\u000b\u001a\u00020XH'J$\u0010Y\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u001f0\u00040\u00032\b\b\u0001\u0010&\u001a\u00020ZH'J$\u0010[\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\\0\u001f0\u00040\u00032\b\b\u0001\u0010\u000b\u001a\u00020XH'J\u001e\u0010]\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020^H'J\u001e\u0010_\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020`H'J$\u0010a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00050\u00040\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u000fH'J$\u0010b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020c0\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020dH'J\u001e\u0010e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020fH'J\u001e\u0010g\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020hH'J\u001e\u0010i\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020jH'J$\u0010k\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020lH'J$\u0010m\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020nH'\u0002\u0004\n\u0002\b\u0019¨\u0006o"}, mo26107d2 = {"Lcom/memes/plus/data/domain/MemesClient;", "", "addPostComment", "Lio/reactivex/Single;", "Lretrofit2/Response;", "Lcom/memes/plus/data/api_response/ApiObjectResponse;", "Lcom/memes/plus/ui/post_comments/PostComment;", "body", "Lokhttp3/RequestBody;", "blockUnblockUser", "Lcom/memes/plus/ui/profile/user_profile/BlockUnblockUserResponse;", "request", "Lcom/memes/plus/ui/profile/user_profile/BlockUnblockUserRequest;", "(Lcom/memes/plus/ui/profile/user_profile/BlockUnblockUserRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changeNotificationStatus", "Lcom/memes/plus/ui/profile/edit_profile/notification_settings/NotificationSettingsRequest;", "postNotificationRequest", "createPost", "Lcom/memes/plus/data/api_response/ApiMessageResponse;", "deleteCommentReply", "Lcom/memes/plus/ui/post_comments/reply/DeleteReplyRequest;", "deletePost", "Lcom/memes/plus/ui/posts/post_basics/post_delete/PostDeleteRequest;", "deletePostComment", "Lcom/memes/plus/ui/post_comments/deleteComment/DeletePostCommentRequest;", "editPost", "Lcom/memes/plus/ui/posts/edit_post/EditPostRequest;", "fetchCommentsAllReplies", "Lcom/memes/plus/ui/post_comments/reply/CommentsShowAllRepliesData;", "Lcom/memes/plus/ui/post_comments/CommentsRequest;", "fetchFollowers", "Lcom/memes/plus/data/api_response/ApiListResponse;", "Lcom/memes/plus/ui/user_listing/ListedUser;", "Lcom/memes/plus/ui/user_listing/followers/FollowersRequest;", "fetchFollowings", "Lcom/memes/plus/ui/user_listing/followings/FollowingsRequest;", "fetchNewPosts", "Lcom/memes/plus/ui/posts/Post;", "postsRequest", "Lcom/memes/plus/ui/posts/PostsRequest;", "fetchPost", "postRequest", "Lcom/memes/plus/ui/posts/post/PostRequest;", "fetchPostComments", "Lcom/memes/plus/ui/post_comments/CommentsResponse;", "fetchPostLikeUsers", "Lcom/memes/plus/ui/user_listing/post_likes/PostLikeUsersRequest;", "fetchPostTaggedUsers", "Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUser;", "Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUsersRequest;", "(Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUsersRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchPosts", "fetchPostsForYou", "fetchSelfPosts", "Lcom/memes/plus/data/session/AuthenticatedContentRequest;", "fetchSelfProfile", "Lcom/memes/plus/ui/profile/self_profile/SelfProfile;", "fetchSelfSavedPosts", "fetchSocialNotifications", "Lcom/memes/plus/ui/social_notifications/SocialNotification;", "fetchSuggestedProfiles", "Lcom/memes/plus/ui/suggestions/SuggestedProfile;", "fetchSuggestedUsers", "Lcom/memes/plus/ui/explore_search/people_search/suggestions/CatalogueSuggestedPerson;", "fetchTaggedPosts", "Lcom/memes/plus/ui/profile/user_profile/UserProfileRequest;", "fetchTopPosts", "fetchUserPosts", "fetchUserProfile", "Lcom/memes/plus/ui/profile/user_profile/UserProfileResponse;", "likePostReply", "Lcom/memes/plus/ui/post_comments/reply/LikeReplyRequest;", "logout", "registerPurchaseToServer", "record", "Lcom/memes/plus/ui/subscription/PurchaseRecord;", "(Lcom/memes/plus/ui/subscription/PurchaseRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "replyOnComment", "Lcom/memes/plus/ui/post_comments/reply/Reply;", "reportPost", "Lcom/memes/plus/ui/posts/post_basics/post_report/PostReportRequest;", "reportPostComment", "Lcom/memes/plus/ui/post_comments/reportComment/ReportCommentRequest;", "reportPostReply", "Lcom/memes/plus/ui/post_comments/reply/ReportReplyRequest;", "saveProfile", "searchPeople", "Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResult;", "Lcom/memes/plus/ui/explore_search/ExploreSearchRequest;", "searchPostsByTag", "Lcom/memes/plus/ui/tagged_posts/TaggedPostsRequest;", "searchTags", "Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResult;", "toggleCommentLike", "Lcom/memes/plus/ui/post_comments/commentLike/PostCommentLikeRequest;", "toggleFollowUser", "Lcom/memes/plus/ui/posts/post_basics/follow_user/FollowUserRequest;", "toggleNotification", "togglePostLike", "Lcom/memes/plus/ui/posts/post_basics/post_like/PostLike;", "Lcom/memes/plus/ui/posts/post_basics/post_like/PostLikeRequest;", "togglePostNotificationsSubscription", "Lcom/memes/plus/ui/posts/post_basics/post_notifications/PostNotificationSubscriptionRequest;", "togglePostSave", "Lcom/memes/plus/ui/posts/post_basics/post_save/PostSaveRequest;", "updateFirebaseToken", "Lcom/memes/plus/firebase/firebase_token/FirebaseTokenRequest;", "updatePostComment", "Lcom/memes/plus/ui/post_comments/addComment/AddCommentRequest;", "updatePostReply", "Lcom/memes/plus/ui/post_comments/reply/EditReplyRequest;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MemesClient.kt */
public interface MemesClient {
    @POST("api/commentonpost")
    Single<Response<ApiObjectResponse<PostComment>>> addPostComment(@Body RequestBody requestBody);

    @POST("newapi/blockUnblockUser")
    Object blockUnblockUser(@Body BlockUnblockUserRequest blockUnblockUserRequest, Continuation<? super Response<BlockUnblockUserResponse>> continuation);

    @POST("api/changeNotification")
    Single<Response<ApiObjectResponse<NotificationSettingsRequest>>> changeNotificationStatus(@Body NotificationSettingsRequest notificationSettingsRequest);

    @POST("api/addMemePostTag")
    Single<Response<ApiMessageResponse>> createPost(@Body RequestBody requestBody);

    @POST("api/deleteCommentReply")
    Single<Response<ApiMessageResponse>> deleteCommentReply(@Body DeleteReplyRequest deleteReplyRequest);

    @POST("api/deletePost")
    Single<Response<ApiMessageResponse>> deletePost(@Body PostDeleteRequest postDeleteRequest);

    @POST("api/deletePostComment")
    Single<Response<ApiMessageResponse>> deletePostComment(@Body DeletePostCommentRequest deletePostCommentRequest);

    @POST("api/editMemePost")
    Single<Response<ApiMessageResponse>> editPost(@Body EditPostRequest editPostRequest);

    @POST("api/getReplies")
    Single<Response<ApiObjectResponse<CommentsShowAllRepliesData>>> fetchCommentsAllReplies(@Body CommentsRequest commentsRequest);

    @POST("api/getMyFollowers")
    Single<Response<ApiListResponse<ListedUser>>> fetchFollowers(@Body FollowersRequest followersRequest);

    @POST("api/getMyFollowing")
    Single<Response<ApiListResponse<ListedUser>>> fetchFollowings(@Body FollowingsRequest followingsRequest);

    @POST("api/getRecentPosts")
    Single<Response<ApiListResponse<Post>>> fetchNewPosts(@Body PostsRequest postsRequest);

    @POST("api/getSinglePostDetail")
    Single<Response<ApiListResponse<Post>>> fetchPost(@Body PostRequest postRequest);

    @POST("api/commentMemePostListing")
    Single<Response<ApiObjectResponse<CommentsResponse>>> fetchPostComments(@Body CommentsRequest commentsRequest);

    @POST("api/whoLikePost")
    Single<Response<ApiListResponse<ListedUser>>> fetchPostLikeUsers(@Body PostLikeUsersRequest postLikeUsersRequest);

    @POST("api/getTaggedUsers")
    Object fetchPostTaggedUsers(@Body PostTaggedUsersRequest postTaggedUsersRequest, Continuation<? super Response<ApiListResponse<PostTaggedUser>>> continuation);

    @POST("api/getFollowingPosts")
    Single<Response<ApiListResponse<Post>>> fetchPosts(@Body PostsRequest postsRequest);

    @POST("api/getForYouPosts")
    Single<Response<ApiListResponse<Post>>> fetchPostsForYou(@Body PostsRequest postsRequest);

    @POST("api/getLoginUserPosts")
    Single<Response<ApiListResponse<Post>>> fetchSelfPosts(@Body AuthenticatedContentRequest authenticatedContentRequest);

    @POST("api/getMyProfile")
    Single<Response<ApiListResponse<SelfProfile>>> fetchSelfProfile(@Body AuthenticatedContentRequest authenticatedContentRequest);

    @POST("api/getSavedPosts")
    Single<Response<ApiListResponse<Post>>> fetchSelfSavedPosts(@Body AuthenticatedContentRequest authenticatedContentRequest);

    @POST("api/userNotifications")
    Single<Response<ApiListResponse<SocialNotification>>> fetchSocialNotifications(@Body AuthenticatedContentRequest authenticatedContentRequest);

    @POST("api/suggestedUsers")
    Single<Response<ApiListResponse<SuggestedProfile>>> fetchSuggestedProfiles(@Body AuthenticatedContentRequest authenticatedContentRequest);

    @POST("api/suggestedUsers")
    Single<Response<ApiListResponse<CatalogueSuggestedPerson>>> fetchSuggestedUsers(@Body AuthenticatedContentRequest authenticatedContentRequest);

    @POST("api/getTaggedPosts")
    Single<Response<ApiListResponse<Post>>> fetchTaggedPosts(@Body UserProfileRequest userProfileRequest);

    @POST("api/searchTopPosts")
    Single<Response<ApiListResponse<Post>>> fetchTopPosts(@Body PostsRequest postsRequest);

    @POST("api/getUserProfile")
    Single<Response<ApiListResponse<Post>>> fetchUserPosts(@Body UserProfileRequest userProfileRequest);

    @POST("api/getUserProfile")
    Single<Response<UserProfileResponse>> fetchUserProfile(@Body UserProfileRequest userProfileRequest);

    @POST("newapi/likeReplies")
    Single<Response<ApiMessageResponse>> likePostReply(@Body LikeReplyRequest likeReplyRequest);

    @POST("api/logout")
    Single<Response<ApiMessageResponse>> logout(@Body AuthenticatedContentRequest authenticatedContentRequest);

    @POST("newapi/saveProUser")
    Object registerPurchaseToServer(@Body PurchaseRecord purchaseRecord, Continuation<? super Response<ApiMessageResponse>> continuation);

    @POST("api/replyOnComment")
    Single<Response<ApiObjectResponse<Reply>>> replyOnComment(@Body RequestBody requestBody);

    @POST("api/reportPost")
    Single<Response<ApiMessageResponse>> reportPost(@Body PostReportRequest postReportRequest);

    @POST("api/reportComment")
    Single<Response<ApiMessageResponse>> reportPostComment(@Body ReportCommentRequest reportCommentRequest);

    @POST("api/reportOnReply")
    Single<Response<ApiMessageResponse>> reportPostReply(@Body ReportReplyRequest reportReplyRequest);

    @POST("api/editProfile")
    Single<Response<ApiObjectResponse<SelfProfile>>> saveProfile(@Body RequestBody requestBody);

    @POST("api/searchByTypes")
    Single<Response<ApiListResponse<PeopleSearchResult>>> searchPeople(@Body ExploreSearchRequest exploreSearchRequest);

    @POST("api/getPostByTagName")
    Single<Response<ApiListResponse<Post>>> searchPostsByTag(@Body TaggedPostsRequest taggedPostsRequest);

    @POST("api/searchByTypes")
    Single<Response<ApiListResponse<TagSearchResult>>> searchTags(@Body ExploreSearchRequest exploreSearchRequest);

    @POST("/newapi/likeComments")
    Single<Response<ApiMessageResponse>> toggleCommentLike(@Body PostCommentLikeRequest postCommentLikeRequest);

    @POST("api/followUser")
    Single<Response<ApiMessageResponse>> toggleFollowUser(@Body FollowUserRequest followUserRequest);

    @POST("api/getMemeNotification")
    Single<Response<ApiObjectResponse<NotificationSettingsRequest>>> toggleNotification(@Body NotificationSettingsRequest notificationSettingsRequest);

    @POST("api/likeMemePost")
    Single<Response<ApiObjectResponse<PostLike>>> togglePostLike(@Body PostLikeRequest postLikeRequest);

    @POST("api/PostNotification")
    Single<Response<ApiMessageResponse>> togglePostNotificationsSubscription(@Body PostNotificationSubscriptionRequest postNotificationSubscriptionRequest);

    @POST("api/saveUnsavePost")
    Single<Response<ApiMessageResponse>> togglePostSave(@Body PostSaveRequest postSaveRequest);

    @POST("api/updateDeviceToken")
    Single<Response<ApiMessageResponse>> updateFirebaseToken(@Body FirebaseTokenRequest firebaseTokenRequest);

    @POST("api/updatePostComment")
    Single<Response<ApiObjectResponse<PostComment>>> updatePostComment(@Body AddCommentRequest addCommentRequest);

    @POST("api/editReplyOnComment")
    Single<Response<ApiObjectResponse<Reply>>> updatePostReply(@Body EditReplyRequest editReplyRequest);
}
