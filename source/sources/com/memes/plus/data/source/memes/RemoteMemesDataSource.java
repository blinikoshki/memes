package com.memes.plus.data.source.memes;

import com.facebook.AccessToken;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.memes.commons.util.ExtensionsKt;
import com.memes.commons.util.FileMimeDetector;
import com.memes.network.memes.MemesSession;
import com.memes.plus.data.api_response.ApiListResponse;
import com.memes.plus.data.domain.ApiServiceGenerator;
import com.memes.plus.data.domain.MemesClient;
import com.memes.plus.data.mapped_response.UniversalResult;
import com.memes.plus.data.session.AuthenticatedContentRequest;
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
import com.memes.plus.p040ui.posts.suggestions.SuggestedUsersRequest;
import com.memes.plus.p040ui.profile.edit_profile.SaveProfileRequest;
import com.memes.plus.p040ui.profile.edit_profile.notification_settings.NotificationSettingsRequest;
import com.memes.plus.p040ui.profile.self_profile.SelfProfile;
import com.memes.plus.p040ui.profile.user_profile.UserProfileRequest;
import com.memes.plus.p040ui.profile.user_profile.UserProfileResponse;
import com.memes.plus.p040ui.social_notifications.SocialNotification;
import com.memes.plus.p040ui.suggestions.SuggestedProfile;
import com.memes.plus.p040ui.tagged_posts.TaggedPostsRequest;
import com.memes.plus.p040ui.user_listing.ListedUser;
import com.memes.plus.p040ui.user_listing.followers.FollowersRequest;
import com.memes.plus.p040ui.user_listing.followings.FollowingsRequest;
import com.memes.plus.p040ui.user_listing.post_likes.PostLikeUsersRequest;
import com.memes.plus.util.NullProofMultipartBodyBuilder;
import java.io.File;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import p015io.reactivex.Single;
import retrofit2.Response;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000È\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u000bH\u0016J\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00052\u0006\u0010\u0007\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u0014H\u0016J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u0016H\u0016J\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u0018H\u0016J\u001c\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u001aH\u0016J\u001c\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u001cH\u0016J\u001c\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u001fH\u0016J\u001c\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00050\u00042\u0006\u0010\u0007\u001a\u00020!H\u0016J\u001c\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00050\u00042\u0006\u0010\u0007\u001a\u00020$H\u0016J\u001c\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u00050\u00042\u0006\u0010\u0007\u001a\u00020'H\u0016J\u001c\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\u00050\u00042\u0006\u0010\u0007\u001a\u00020'H\u0016J\u001c\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00050\u00042\u0006\u0010\u0007\u001a\u00020+H\u0016J\u001f\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u00052\u0006\u0010\u0007\u001a\u00020.H@ø\u0001\u0000¢\u0006\u0002\u0010/J$\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00050\u00042\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J\u001c\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00050\u00042\u0006\u00101\u001a\u000202H\u0016J\u0014\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002070\u00050\u0004H\u0016J\u001c\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00050\u00042\u0006\u00101\u001a\u000202H\u0016J\u001c\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00050\u00042\u0006\u00101\u001a\u000202H\u0016J\u001c\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0\u00050\u00042\u0006\u00101\u001a\u000202H\u0016J\u001c\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0\u00050\u00042\u0006\u0010\u0007\u001a\u00020>H\u0016J\u0014\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0\u00050\u0004H\u0016J\u001c\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00050\u00042\u0006\u00101\u001a\u000202H\u0016J\u001c\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00050\u00042\u0006\u0010\u0007\u001a\u00020CH\u0016J\u001c\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0\u00050\u00042\u0006\u0010\u0007\u001a\u00020CH\u0016J\u001c\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00050\u00042\u0006\u0010\u0007\u001a\u00020CH\u0016J\u001c\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u00042\u0006\u0010\u0007\u001a\u00020HH\u0016J\u0014\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u0004H\u0016J\u001f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00130\u00052\u0006\u0010K\u001a\u00020LH@ø\u0001\u0000¢\u0006\u0002\u0010MJ\u001c\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u00042\u0006\u0010\u0007\u001a\u00020OH\u0016J\u001c\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u00042\u0006\u0010\u0007\u001a\u00020QH\u0016J\u001c\u0010R\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u00042\u0006\u0010\u0007\u001a\u00020SH\u0016J\u001c\u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002070\u00050\u00042\u0006\u0010\u0007\u001a\u00020UH\u0016J\u001c\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020W0\u00050\u00042\u0006\u0010\u0007\u001a\u00020XH\u0016J$\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00050\u00042\u0006\u0010Z\u001a\u00020[2\u0006\u00101\u001a\u000202H\u0016J\u001c\u0010\\\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020]0\u00050\u00042\u0006\u0010\u0007\u001a\u00020XH\u0016J\u001c\u0010^\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u00042\u0006\u0010\u0007\u001a\u00020_H\u0016J\u001c\u0010`\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u00042\u0006\u0010\u0007\u001a\u00020aH\u0016J\u001c\u0010b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u0011H\u0016J\u001c\u0010c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0\u00050\u00042\u0006\u0010\u0007\u001a\u00020eH\u0016J\u001c\u0010f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u00042\u0006\u0010\u0007\u001a\u00020gH\u0016J\u001c\u0010h\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u00042\u0006\u0010\u0007\u001a\u00020iH\u0016J\u001c\u0010j\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u00042\u0006\u0010\u0007\u001a\u00020kH\u0016J\u001c\u0010l\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010m\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u00042\u0006\u0010\u0007\u001a\u00020nH\u0016\u0002\u0004\n\u0002\b\u0019¨\u0006o"}, mo26107d2 = {"Lcom/memes/plus/data/source/memes/RemoteMemesDataSource;", "Lcom/memes/plus/data/source/memes/MemesDataSource;", "()V", "addPostComment", "Lio/reactivex/Single;", "Lcom/memes/plus/data/mapped_response/UniversalResult;", "Lcom/memes/plus/ui/post_comments/PostComment;", "request", "Lcom/memes/plus/ui/post_comments/addComment/AddCommentRequest;", "addReply", "Lcom/memes/plus/ui/post_comments/reply/Reply;", "Lcom/memes/plus/ui/post_comments/reply/AddReplyRequest;", "blockUnblockUser", "Lcom/memes/plus/ui/profile/user_profile/BlockUnblockUserResponse;", "Lcom/memes/plus/ui/profile/user_profile/BlockUnblockUserRequest;", "(Lcom/memes/plus/ui/profile/user_profile/BlockUnblockUserRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changeNotificationStatus", "Lcom/memes/plus/ui/profile/edit_profile/notification_settings/NotificationSettingsRequest;", "createPost", "", "Lcom/memes/plus/ui/create_post/CreatePostRequest;", "deletePost", "Lcom/memes/plus/ui/posts/post_basics/post_delete/PostDeleteRequest;", "deletePostComment", "Lcom/memes/plus/ui/post_comments/deleteComment/DeletePostCommentRequest;", "deleteReply", "Lcom/memes/plus/ui/post_comments/reply/DeleteReplyRequest;", "editPost", "Lcom/memes/plus/ui/posts/edit_post/EditPostRequest;", "fetchFollowers", "Lcom/memes/plus/ui/user_listing/ListedUser;", "Lcom/memes/plus/ui/user_listing/followers/FollowersRequest;", "fetchFollowings", "Lcom/memes/plus/ui/user_listing/followings/FollowingsRequest;", "fetchPost", "Lcom/memes/plus/ui/posts/Post;", "Lcom/memes/plus/ui/posts/post/PostRequest;", "fetchPostComments", "Lcom/memes/plus/ui/post_comments/CommentsResponse;", "Lcom/memes/plus/ui/post_comments/CommentsRequest;", "fetchPostCommentsReplies", "Lcom/memes/plus/ui/post_comments/reply/CommentsShowAllRepliesData;", "fetchPostLikeUsers", "Lcom/memes/plus/ui/user_listing/post_likes/PostLikeUsersRequest;", "fetchPostTaggedUsers", "Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUser;", "Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUsersRequest;", "(Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUsersRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchPosts", "page", "", "type", "Lcom/memes/plus/ui/home/feeds/HomeFeedType;", "fetchSelfPosts", "fetchSelfProfile", "Lcom/memes/plus/ui/profile/self_profile/SelfProfile;", "fetchSelfSavedPosts", "fetchSelfTaggedPosts", "fetchSocialNotifications", "Lcom/memes/plus/ui/social_notifications/SocialNotification;", "fetchSuggestedProfiles", "Lcom/memes/plus/ui/suggestions/SuggestedProfile;", "Lcom/memes/plus/ui/posts/suggestions/SuggestedUsersRequest;", "fetchSuggestedUsers", "Lcom/memes/plus/ui/explore_search/people_search/suggestions/CatalogueSuggestedPerson;", "fetchTopPosts", "fetchUserPosts", "Lcom/memes/plus/ui/profile/user_profile/UserProfileRequest;", "fetchUserProfile", "Lcom/memes/plus/ui/profile/user_profile/UserProfileResponse;", "fetchUserTaggedPosts", "likeReply", "Lcom/memes/plus/ui/post_comments/reply/LikeReplyRequest;", "logout", "registerPurchaseToServer", "record", "Lcom/memes/plus/ui/subscription/PurchaseRecord;", "(Lcom/memes/plus/ui/subscription/PurchaseRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportComment", "Lcom/memes/plus/ui/post_comments/reportComment/ReportCommentRequest;", "reportPost", "Lcom/memes/plus/ui/posts/post_basics/post_report/PostReportRequest;", "reportReply", "Lcom/memes/plus/ui/post_comments/reply/ReportReplyRequest;", "saveProfile", "Lcom/memes/plus/ui/profile/edit_profile/SaveProfileRequest;", "searchPeople", "Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResult;", "Lcom/memes/plus/ui/explore_search/ExploreSearchRequest;", "searchPostsByTag", "hashtag", "", "searchTags", "Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResult;", "toggleCommentLike", "Lcom/memes/plus/ui/post_comments/commentLike/PostCommentLikeRequest;", "toggleFollowUser", "Lcom/memes/plus/ui/posts/post_basics/follow_user/FollowUserRequest;", "toggleNotificationStatus", "togglePostLike", "Lcom/memes/plus/ui/posts/post_basics/post_like/PostLike;", "Lcom/memes/plus/ui/posts/post_basics/post_like/PostLikeRequest;", "togglePostNotificationsSubscription", "Lcom/memes/plus/ui/posts/post_basics/post_notifications/PostNotificationSubscriptionRequest;", "togglePostSave", "Lcom/memes/plus/ui/posts/post_basics/post_save/PostSaveRequest;", "updateFirebaseToken", "Lcom/memes/plus/firebase/firebase_token/FirebaseTokenRequest;", "updatePostComment", "updateReplyComment", "Lcom/memes/plus/ui/post_comments/reply/EditReplyRequest;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: RemoteMemesDataSource.kt */
public final class RemoteMemesDataSource implements MemesDataSource {

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HomeFeedType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[HomeFeedType.FOR_YOU.ordinal()] = 1;
            iArr[HomeFeedType.FOLLOWING.ordinal()] = 2;
            iArr[HomeFeedType.NEW.ordinal()] = 3;
        }
    }

    public Single<UniversalResult<Object>> updateFirebaseToken(FirebaseTokenRequest firebaseTokenRequest) {
        Intrinsics.checkNotNullParameter(firebaseTokenRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        firebaseTokenRequest.setUserId(MemesSession.INSTANCE.getUserId());
        firebaseTokenRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().updateFirebaseToken(firebaseTokenRequest).map(RemoteMemesDataSource$updateFirebaseToken$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…cessMessageResponse(it) }");
        return map;
    }

    public Single<UniversalResult<Post>> fetchPost(PostRequest postRequest) {
        Intrinsics.checkNotNullParameter(postRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        postRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        postRequest.setUserId(MemesSession.INSTANCE.getUserId());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().fetchPost(postRequest).map(RemoteMemesDataSource$fetchPost$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…ull\n\t\t\t\t}\n\t\t\t\tresult\n\t\t\t}");
        return map;
    }

    public Single<UniversalResult<Post>> fetchPosts(int i, HomeFeedType homeFeedType) {
        Single<Response<ApiListResponse<Post>>> single;
        Intrinsics.checkNotNullParameter(homeFeedType, "type");
        Timber.m300d("~> fetchPosts() page=" + i + ", type=" + homeFeedType, new Object[0]);
        PostsRequest postsRequest = new PostsRequest();
        postsRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        postsRequest.setUserId(MemesSession.INSTANCE.getUserId());
        postsRequest.setPage(i);
        postsRequest.setPostType(homeFeedType);
        MemesClient memesClient = ApiServiceGenerator.INSTANCE.getMemesClient();
        HomeFeedType postType = postsRequest.getPostType();
        if (postType != null) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[postType.ordinal()];
            if (i2 == 1) {
                single = memesClient.fetchPostsForYou(postsRequest);
            } else if (i2 == 2) {
                single = memesClient.fetchPosts(postsRequest);
            } else if (i2 == 3) {
                single = memesClient.fetchNewPosts(postsRequest);
            }
            Single<R> map = single.map(new RemoteMemesDataSource$fetchPosts$1(i));
            Intrinsics.checkNotNullExpressionValue(map, "apiResponse.map { respon…dForComments() }\n\t\t\t}\n\t\t}");
            return map;
        }
        single = memesClient.fetchPosts(postsRequest);
        Single<R> map2 = single.map(new RemoteMemesDataSource$fetchPosts$1(i));
        Intrinsics.checkNotNullExpressionValue(map2, "apiResponse.map { respon…dForComments() }\n\t\t\t}\n\t\t}");
        return map2;
    }

    public Single<UniversalResult<Post>> fetchTopPosts(int i) {
        Timber.m300d("~> fetchTopPosts() page=" + i, new Object[0]);
        PostsRequest postsRequest = new PostsRequest();
        postsRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        postsRequest.setUserId(MemesSession.INSTANCE.getUserId());
        postsRequest.setPage(i);
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().fetchTopPosts(postsRequest).map(new RemoteMemesDataSource$fetchTopPosts$1(i));
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…orComments() }\n\t\t\t\t}\n\t\t\t}");
        return map;
    }

    public Single<UniversalResult<Post>> searchPostsByTag(String str, int i) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_HASHTAG);
        TaggedPostsRequest taggedPostsRequest = new TaggedPostsRequest();
        taggedPostsRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        taggedPostsRequest.setUserId(MemesSession.INSTANCE.getUserId());
        taggedPostsRequest.setPage(i);
        taggedPostsRequest.setHashtag(str);
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().searchPostsByTag(taggedPostsRequest).map(new RemoteMemesDataSource$searchPostsByTag$1(i));
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…orComments() }\n\t\t\t\t}\n\t\t\t}");
        return map;
    }

    public Single<UniversalResult<PeopleSearchResult>> searchPeople(ExploreSearchRequest exploreSearchRequest) {
        Intrinsics.checkNotNullParameter(exploreSearchRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        exploreSearchRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        exploreSearchRequest.setUserId(MemesSession.INSTANCE.getUserId());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().searchPeople(exploreSearchRequest).map(new RemoteMemesDataSource$searchPeople$1(exploreSearchRequest));
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…ponse(request.page, it) }");
        return map;
    }

    public Single<UniversalResult<CatalogueSuggestedPerson>> fetchSuggestedUsers() {
        AuthenticatedContentRequest authenticatedContentRequest = new AuthenticatedContentRequest();
        authenticatedContentRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        authenticatedContentRequest.setUserId(MemesSession.INSTANCE.getUserId());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().fetchSuggestedUsers(authenticatedContentRequest).map(new RemoteMemesDataSource$fetchSuggestedUsers$1(authenticatedContentRequest));
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…ponse(request.page, it) }");
        return map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object fetchPostTaggedUsers(com.memes.plus.p040ui.posts.post_tags_dialog.PostTaggedUsersRequest r5, kotlin.coroutines.Continuation<? super com.memes.plus.data.mapped_response.UniversalResult<com.memes.plus.p040ui.posts.post_tags_dialog.PostTaggedUser>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.memes.plus.data.source.memes.RemoteMemesDataSource$fetchPostTaggedUsers$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.memes.plus.data.source.memes.RemoteMemesDataSource$fetchPostTaggedUsers$1 r0 = (com.memes.plus.data.source.memes.RemoteMemesDataSource$fetchPostTaggedUsers$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.memes.plus.data.source.memes.RemoteMemesDataSource$fetchPostTaggedUsers$1 r0 = new com.memes.plus.data.source.memes.RemoteMemesDataSource$fetchPostTaggedUsers$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            com.memes.plus.ui.posts.post_tags_dialog.PostTaggedUsersRequest r5 = (com.memes.plus.p040ui.posts.post_tags_dialog.PostTaggedUsersRequest) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x005c
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            com.memes.network.memes.MemesSession r6 = com.memes.network.memes.MemesSession.INSTANCE
            java.lang.String r6 = r6.getUserId()
            r5.setUserId(r6)
            com.memes.network.memes.MemesSession r6 = com.memes.network.memes.MemesSession.INSTANCE
            java.lang.String r6 = r6.getToken()
            r5.setLoginToken(r6)
            com.memes.plus.data.domain.ApiServiceGenerator r6 = com.memes.plus.data.domain.ApiServiceGenerator.INSTANCE
            com.memes.plus.data.domain.MemesClient r6 = r6.getMemesClient()
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r6.fetchPostTaggedUsers(r5, r0)
            if (r6 != r1) goto L_0x005c
            return r1
        L_0x005c:
            retrofit2.Response r6 = (retrofit2.Response) r6
            com.memes.plus.data.source.memes.MemesCoreMapper r0 = com.memes.plus.data.source.memes.MemesCoreMapper.INSTANCE
            int r5 = r5.getPage()
            com.memes.plus.data.mapped_response.UniversalResult r5 = r0.processListResponse(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.data.source.memes.RemoteMemesDataSource.fetchPostTaggedUsers(com.memes.plus.ui.posts.post_tags_dialog.PostTaggedUsersRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Single<UniversalResult<TagSearchResult>> searchTags(ExploreSearchRequest exploreSearchRequest) {
        Intrinsics.checkNotNullParameter(exploreSearchRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        exploreSearchRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        exploreSearchRequest.setUserId(MemesSession.INSTANCE.getUserId());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().searchTags(exploreSearchRequest).map(new RemoteMemesDataSource$searchTags$1(exploreSearchRequest));
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…ponse(request.page, it) }");
        return map;
    }

    public Single<UniversalResult<PostLike>> togglePostLike(PostLikeRequest postLikeRequest) {
        Intrinsics.checkNotNullParameter(postLikeRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        postLikeRequest.setUserId(MemesSession.INSTANCE.getUserId());
        postLikeRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().togglePostLike(postLikeRequest).map(RemoteMemesDataSource$togglePostLike$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…ocessObjectResponse(it) }");
        return map;
    }

    public Single<UniversalResult<ListedUser>> fetchPostLikeUsers(PostLikeUsersRequest postLikeUsersRequest) {
        Intrinsics.checkNotNullParameter(postLikeUsersRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        postLikeUsersRequest.setUserId(MemesSession.INSTANCE.getUserId());
        postLikeUsersRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().fetchPostLikeUsers(postLikeUsersRequest).map(RemoteMemesDataSource$fetchPostLikeUsers$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…cessListResponse(0, it) }");
        return map;
    }

    public Single<UniversalResult<Object>> togglePostSave(PostSaveRequest postSaveRequest) {
        Intrinsics.checkNotNullParameter(postSaveRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        postSaveRequest.setUserId(MemesSession.INSTANCE.getUserId());
        postSaveRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().togglePostSave(postSaveRequest).map(RemoteMemesDataSource$togglePostSave$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…cessMessageResponse(it) }");
        return map;
    }

    public Single<UniversalResult<Object>> createPost(CreatePostRequest createPostRequest) {
        Intrinsics.checkNotNullParameter(createPostRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        NullProofMultipartBodyBuilder addFormDataPart = new NullProofMultipartBodyBuilder().asForm().addFormDataPart(AccessToken.USER_ID_KEY, MemesSession.INSTANCE.getUserId()).addFormDataPart("login_token", MemesSession.INSTANCE.getToken()).addFormDataPart("taggedUsers", createPostRequest.getTags()).addFormDataPart("repost", createPostRequest.getPostIdForRepost()).addFormDataPart("postText", createPostRequest.getText());
        StringBuilder sb = new StringBuilder();
        sb.append(createPostRequest.getFileWidth());
        sb.append('*');
        sb.append(createPostRequest.getFileHeight());
        NullProofMultipartBodyBuilder addFormDataPart2 = addFormDataPart.addFormDataPart(ViewHierarchyConstants.DIMENSION_KEY, sb.toString());
        String filePath = createPostRequest.getFilePath();
        if (!StringsKt.isBlank(filePath)) {
            File file = new File(filePath);
            if (file.exists()) {
                addFormDataPart2.addFormDataPart("file", file.getName(), RequestBody.Companion.create(MediaType.Companion.parse(FileMimeDetector.INSTANCE.detect(file)), file));
            }
        }
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().createPost(addFormDataPart2.build()).map(RemoteMemesDataSource$createPost$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…cessMessageResponse(it) }");
        return map;
    }

    public Single<UniversalResult<Object>> editPost(EditPostRequest editPostRequest) {
        Intrinsics.checkNotNullParameter(editPostRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        editPostRequest.setUserId(MemesSession.INSTANCE.getUserId());
        editPostRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().editPost(editPostRequest).map(RemoteMemesDataSource$editPost$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…cessMessageResponse(it) }");
        return map;
    }

    public Single<UniversalResult<SocialNotification>> fetchSocialNotifications(int i) {
        AuthenticatedContentRequest authenticatedContentRequest = new AuthenticatedContentRequest();
        authenticatedContentRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        authenticatedContentRequest.setUserId(MemesSession.INSTANCE.getUserId());
        authenticatedContentRequest.setPage(i);
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().fetchSocialNotifications(authenticatedContentRequest).map(new RemoteMemesDataSource$fetchSocialNotifications$1(i));
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…sListResponse(page, it) }");
        return map;
    }

    public Single<UniversalResult<Object>> toggleFollowUser(FollowUserRequest followUserRequest) {
        Intrinsics.checkNotNullParameter(followUserRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        followUserRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        followUserRequest.setUserId(MemesSession.INSTANCE.getUserId());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().toggleFollowUser(followUserRequest).map(RemoteMemesDataSource$toggleFollowUser$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…cessMessageResponse(it) }");
        return map;
    }

    public Single<UniversalResult<ListedUser>> fetchFollowers(FollowersRequest followersRequest) {
        Intrinsics.checkNotNullParameter(followersRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        followersRequest.setUserId(MemesSession.INSTANCE.getUserId());
        followersRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().fetchFollowers(followersRequest).map(new RemoteMemesDataSource$fetchFollowers$1(followersRequest));
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…ponse(request.page, it) }");
        return map;
    }

    public Single<UniversalResult<ListedUser>> fetchFollowings(FollowingsRequest followingsRequest) {
        Intrinsics.checkNotNullParameter(followingsRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        followingsRequest.setUserId(MemesSession.INSTANCE.getUserId());
        followingsRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().fetchFollowings(followingsRequest).map(new RemoteMemesDataSource$fetchFollowings$1(followingsRequest));
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…ponse(request.page, it) }");
        return map;
    }

    public Single<UniversalResult<Object>> deletePost(PostDeleteRequest postDeleteRequest) {
        Intrinsics.checkNotNullParameter(postDeleteRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        postDeleteRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        postDeleteRequest.setUserId(MemesSession.INSTANCE.getUserId());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().deletePost(postDeleteRequest).map(RemoteMemesDataSource$deletePost$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…cessMessageResponse(it) }");
        return map;
    }

    public Single<UniversalResult<SuggestedProfile>> fetchSuggestedProfiles(SuggestedUsersRequest suggestedUsersRequest) {
        Intrinsics.checkNotNullParameter(suggestedUsersRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        suggestedUsersRequest.setUserId(MemesSession.INSTANCE.getUserId());
        suggestedUsersRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().fetchSuggestedProfiles(suggestedUsersRequest).map(new RemoteMemesDataSource$fetchSuggestedProfiles$1(suggestedUsersRequest));
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…ponse(request.page, it) }");
        return map;
    }

    public Single<UniversalResult<Object>> reportPost(PostReportRequest postReportRequest) {
        Intrinsics.checkNotNullParameter(postReportRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        postReportRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        postReportRequest.setUserId(MemesSession.INSTANCE.getUserId());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().reportPost(postReportRequest).map(RemoteMemesDataSource$reportPost$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…cessMessageResponse(it) }");
        return map;
    }

    public Single<UniversalResult<Object>> togglePostNotificationsSubscription(PostNotificationSubscriptionRequest postNotificationSubscriptionRequest) {
        Intrinsics.checkNotNullParameter(postNotificationSubscriptionRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        postNotificationSubscriptionRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        postNotificationSubscriptionRequest.setUserId(MemesSession.INSTANCE.getUserId());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().togglePostNotificationsSubscription(postNotificationSubscriptionRequest).map(RemoteMemesDataSource$togglePostNotificationsSubscription$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…cessMessageResponse(it) }");
        return map;
    }

    public Single<UniversalResult<SelfProfile>> fetchSelfProfile() {
        AuthenticatedContentRequest authenticatedContentRequest = new AuthenticatedContentRequest();
        authenticatedContentRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        authenticatedContentRequest.setUserId(MemesSession.INSTANCE.getUserId());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().fetchSelfProfile(authenticatedContentRequest).map(RemoteMemesDataSource$fetchSelfProfile$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…cessListResponse(0, it) }");
        return map;
    }

    public Single<UniversalResult<Post>> fetchSelfPosts(int i) {
        AuthenticatedContentRequest authenticatedContentRequest = new AuthenticatedContentRequest();
        authenticatedContentRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        authenticatedContentRequest.setUserId(MemesSession.INSTANCE.getUserId());
        authenticatedContentRequest.setPage(i);
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().fetchSelfPosts(authenticatedContentRequest).map(new RemoteMemesDataSource$fetchSelfPosts$1(i));
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…orComments() }\n\t\t\t\t}\n\t\t\t}");
        return map;
    }

    public Single<UniversalResult<Post>> fetchSelfSavedPosts(int i) {
        AuthenticatedContentRequest authenticatedContentRequest = new AuthenticatedContentRequest();
        authenticatedContentRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        authenticatedContentRequest.setUserId(MemesSession.INSTANCE.getUserId());
        authenticatedContentRequest.setPage(i);
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().fetchSelfSavedPosts(authenticatedContentRequest).map(new RemoteMemesDataSource$fetchSelfSavedPosts$1(i));
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…orComments() }\n\t\t\t\t}\n\t\t\t}");
        return map;
    }

    public Single<UniversalResult<Post>> fetchSelfTaggedPosts(int i) {
        UserProfileRequest userProfileRequest = new UserProfileRequest();
        userProfileRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        userProfileRequest.setUserId(MemesSession.INSTANCE.getUserId());
        userProfileRequest.setPage(i);
        userProfileRequest.setTargetUserId2(MemesSession.INSTANCE.getUserId());
        userProfileRequest.setTargetUserId(MemesSession.INSTANCE.getUserId());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().fetchTaggedPosts(userProfileRequest).map(new RemoteMemesDataSource$fetchSelfTaggedPosts$1(i));
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…orComments() }\n\t\t\t\t}\n\t\t\t}");
        return map;
    }

    public Single<UniversalResult<UserProfileResponse>> fetchUserProfile(UserProfileRequest userProfileRequest) {
        Intrinsics.checkNotNullParameter(userProfileRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        userProfileRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        userProfileRequest.setUserId(MemesSession.INSTANCE.getUserId());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().fetchUserProfile(userProfileRequest).map(new RemoteMemesDataSource$fetchUserProfile$1(userProfileRequest));
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…Whole(request.page, it) }");
        return map;
    }

    public Single<UniversalResult<Post>> fetchUserPosts(UserProfileRequest userProfileRequest) {
        Intrinsics.checkNotNullParameter(userProfileRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        userProfileRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        userProfileRequest.setUserId(MemesSession.INSTANCE.getUserId());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().fetchUserPosts(userProfileRequest).map(new RemoteMemesDataSource$fetchUserPosts$1(userProfileRequest));
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…orComments() }\n\t\t\t\t}\n\t\t\t}");
        return map;
    }

    public Single<UniversalResult<Post>> fetchUserTaggedPosts(UserProfileRequest userProfileRequest) {
        Intrinsics.checkNotNullParameter(userProfileRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        userProfileRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        userProfileRequest.setUserId(MemesSession.INSTANCE.getUserId());
        userProfileRequest.setTargetUserId2(userProfileRequest.getTargetUserId());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().fetchTaggedPosts(userProfileRequest).map(new RemoteMemesDataSource$fetchUserTaggedPosts$1(userProfileRequest));
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…orComments() }\n\t\t\t\t}\n\t\t\t}");
        return map;
    }

    public Single<UniversalResult<Object>> toggleCommentLike(PostCommentLikeRequest postCommentLikeRequest) {
        Intrinsics.checkNotNullParameter(postCommentLikeRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        postCommentLikeRequest.setUserId(MemesSession.INSTANCE.getUserId());
        postCommentLikeRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().toggleCommentLike(postCommentLikeRequest).map(RemoteMemesDataSource$toggleCommentLike$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…cessMessageResponse(it) }");
        return map;
    }

    public Single<UniversalResult<CommentsResponse>> fetchPostComments(CommentsRequest commentsRequest) {
        Intrinsics.checkNotNullParameter(commentsRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        commentsRequest.setUserId(MemesSession.INSTANCE.getUserId());
        commentsRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().fetchPostComments(commentsRequest).map(new RemoteMemesDataSource$fetchPostComments$1(commentsRequest));
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…\n\t\t\t\tuniversalResult\n\t\t\t}");
        return map;
    }

    public Single<UniversalResult<PostComment>> addPostComment(AddCommentRequest addCommentRequest) {
        Intrinsics.checkNotNullParameter(addCommentRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        NullProofMultipartBodyBuilder addFormDataPart = new NullProofMultipartBodyBuilder().asForm().addFormDataPart("comment_type", addCommentRequest.getCommentType()).addFormDataPart("comment_text", ExtensionsKt.decode(addCommentRequest.getCommentText())).addFormDataPart("iLikeComment", addCommentRequest.getILikeComment()).addFormDataPart("login_token", MemesSession.INSTANCE.getToken()).addFormDataPart("mention_user", addCommentRequest.getMentionUser()).addFormDataPart(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID, addCommentRequest.getPostId()).addFormDataPart(AccessToken.USER_ID_KEY, MemesSession.INSTANCE.getUserId()).addFormDataPart("username", MemesSession.INSTANCE.getUserName()).addFormDataPart("sticker_id", addCommentRequest.getStickerId());
        String commentImage = addCommentRequest.getCommentImage();
        CharSequence charSequence = commentImage;
        boolean z = false;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            File file = new File(commentImage);
            if (file.exists()) {
                addFormDataPart.addFormDataPart("comment_image", file.getName(), RequestBody.Companion.create(MediaType.Companion.parse(FileMimeDetector.INSTANCE.detect(file)), file));
            }
        }
        String imageThumb = addCommentRequest.getImageThumb();
        CharSequence charSequence2 = imageThumb;
        if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
            z = true;
        }
        if (!z) {
            File file2 = new File(imageThumb);
            if (file2.exists()) {
                addFormDataPart.addFormDataPart("image_thumb", file2.getName(), RequestBody.Companion.create(MediaType.Companion.parse(FileMimeDetector.INSTANCE.detect(file2)), file2));
            }
        }
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().addPostComment(addFormDataPart.build()).map(RemoteMemesDataSource$addPostComment$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…ocessObjectResponse(it) }");
        return map;
    }

    public Single<UniversalResult<Object>> deletePostComment(DeletePostCommentRequest deletePostCommentRequest) {
        Intrinsics.checkNotNullParameter(deletePostCommentRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        deletePostCommentRequest.setUserId(MemesSession.INSTANCE.getUserId());
        deletePostCommentRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().deletePostComment(deletePostCommentRequest).map(RemoteMemesDataSource$deletePostComment$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator.getM…cessMessageResponse(it) }");
        return map;
    }

    public Single<UniversalResult<Object>> deleteReply(DeleteReplyRequest deleteReplyRequest) {
        Intrinsics.checkNotNullParameter(deleteReplyRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        deleteReplyRequest.setUserId(MemesSession.INSTANCE.getUserId());
        deleteReplyRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().deleteCommentReply(deleteReplyRequest).map(RemoteMemesDataSource$deleteReply$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator.getM…cessMessageResponse(it) }");
        return map;
    }

    public Single<UniversalResult<Object>> likeReply(LikeReplyRequest likeReplyRequest) {
        Intrinsics.checkNotNullParameter(likeReplyRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        likeReplyRequest.setUserId(MemesSession.INSTANCE.getUserId());
        likeReplyRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        likeReplyRequest.setDeviceToken(MemesSession.INSTANCE.getFirebaseToken());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().likePostReply(likeReplyRequest).map(RemoteMemesDataSource$likeReply$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator.getM…sMessageResponse(it)\n\t\t\t}");
        return map;
    }

    public Single<UniversalResult<Reply>> updateReplyComment(EditReplyRequest editReplyRequest) {
        Intrinsics.checkNotNullParameter(editReplyRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        editReplyRequest.setUserId(MemesSession.INSTANCE.getUserId());
        editReplyRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        editReplyRequest.setCommentText(ExtensionsKt.decode(editReplyRequest.getCommentText()));
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().updatePostReply(editReplyRequest).map(RemoteMemesDataSource$updateReplyComment$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator.getM…ocessObjectResponse(it) }");
        return map;
    }

    public Single<UniversalResult<Reply>> addReply(AddReplyRequest addReplyRequest) {
        Intrinsics.checkNotNullParameter(addReplyRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        NullProofMultipartBodyBuilder addFormDataPart = new NullProofMultipartBodyBuilder().asForm().addFormDataPart("replyType", addReplyRequest.getReplyType()).addFormDataPart(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID, addReplyRequest.getPostId()).addFormDataPart("comment_id", addReplyRequest.getCommentId()).addFormDataPart("sticker_id", addReplyRequest.getStickerId()).addFormDataPart("replyTo", addReplyRequest.getReplyTo()).addFormDataPart("comment_text", ExtensionsKt.decode(addReplyRequest.getCommentText())).addFormDataPart("mention_user", addReplyRequest.getMentionUser()).addFormDataPart("replyFrom", addReplyRequest.getReplyFrom()).addFormDataPart("username", addReplyRequest.getUserName()).addFormDataPart("iLikeReply", String.valueOf(addReplyRequest.getILikeReply())).addFormDataPart("createdDate", addReplyRequest.getCreatedDate()).addFormDataPart("login_token", MemesSession.INSTANCE.getToken()).addFormDataPart(AccessToken.USER_ID_KEY, MemesSession.INSTANCE.getUserId());
        String commentImage = addReplyRequest.getCommentImage();
        CharSequence charSequence = commentImage;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            File file = new File(commentImage);
            if (file.exists()) {
                addFormDataPart.addFormDataPart("comment_image", file.getName(), RequestBody.Companion.create(MediaType.Companion.parse(FileMimeDetector.INSTANCE.detect(file)), file));
            }
        }
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().replyOnComment(addFormDataPart.build()).map(RemoteMemesDataSource$addReply$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator.getM…ocessObjectResponse(it) }");
        return map;
    }

    public Single<UniversalResult<CommentsShowAllRepliesData>> fetchPostCommentsReplies(CommentsRequest commentsRequest) {
        Intrinsics.checkNotNullParameter(commentsRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        commentsRequest.setUserId(MemesSession.INSTANCE.getUserId());
        commentsRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().fetchCommentsAllReplies(commentsRequest).delay(500, TimeUnit.MILLISECONDS).map(RemoteMemesDataSource$fetchPostCommentsReplies$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…ocessObjectResponse(it) }");
        return map;
    }

    public Single<UniversalResult<PostComment>> updatePostComment(AddCommentRequest addCommentRequest) {
        Intrinsics.checkNotNullParameter(addCommentRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        addCommentRequest.setUserId(MemesSession.INSTANCE.getUserId());
        addCommentRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        addCommentRequest.setCommentText(ExtensionsKt.decode(addCommentRequest.getCommentText()));
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().updatePostComment(addCommentRequest).map(RemoteMemesDataSource$updatePostComment$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…ocessObjectResponse(it) }");
        return map;
    }

    public Single<UniversalResult<Object>> reportReply(ReportReplyRequest reportReplyRequest) {
        Intrinsics.checkNotNullParameter(reportReplyRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        reportReplyRequest.setUserId(MemesSession.INSTANCE.getUserId());
        reportReplyRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().reportPostReply(reportReplyRequest).map(RemoteMemesDataSource$reportReply$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator.getM…cessMessageResponse(it) }");
        return map;
    }

    public Single<UniversalResult<Object>> reportComment(ReportCommentRequest reportCommentRequest) {
        Intrinsics.checkNotNullParameter(reportCommentRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        reportCommentRequest.setUserId(MemesSession.INSTANCE.getUserId());
        reportCommentRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().reportPostComment(reportCommentRequest).map(RemoteMemesDataSource$reportComment$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator.getM…cessMessageResponse(it) }");
        return map;
    }

    public Single<UniversalResult<SelfProfile>> saveProfile(SaveProfileRequest saveProfileRequest) {
        Intrinsics.checkNotNullParameter(saveProfileRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        NullProofMultipartBodyBuilder addFormDataPart = new NullProofMultipartBodyBuilder().asForm().addFormDataPart(AccessToken.USER_ID_KEY, MemesSession.INSTANCE.getUserId()).addFormDataPart("login_token", MemesSession.INSTANCE.getToken()).addFormDataPart("full_name", saveProfileRequest.getName()).addFormDataPart("username", saveProfileRequest.getUserName()).addFormDataPart("user_location", saveProfileRequest.getLocation()).addFormDataPart("user_bio", saveProfileRequest.getBio()).addFormDataPart("age", saveProfileRequest.getAge());
        String profilePic = saveProfileRequest.getProfilePic();
        CharSequence charSequence = profilePic;
        boolean z = false;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            File file = new File(profilePic);
            if (file.exists()) {
                addFormDataPart.addFormDataPart("profileImage", file.getName(), RequestBody.Companion.create(MediaType.Companion.parse(FileMimeDetector.INSTANCE.detect(file)), file));
            }
        }
        String coverPic = saveProfileRequest.getCoverPic();
        CharSequence charSequence2 = coverPic;
        if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
            z = true;
        }
        if (!z) {
            File file2 = new File(coverPic);
            if (file2.exists()) {
                addFormDataPart.addFormDataPart("coverImage", file2.getName(), RequestBody.Companion.create(MediaType.Companion.parse(FileMimeDetector.INSTANCE.detect(file2)), file2));
            }
        }
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().saveProfile(addFormDataPart.build()).map(RemoteMemesDataSource$saveProfile$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…ocessObjectResponse(it) }");
        return map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object blockUnblockUser(com.memes.plus.p040ui.profile.user_profile.BlockUnblockUserRequest r7, kotlin.coroutines.Continuation<? super com.memes.plus.data.mapped_response.UniversalResult<com.memes.plus.p040ui.profile.user_profile.BlockUnblockUserResponse>> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.memes.plus.data.source.memes.RemoteMemesDataSource$blockUnblockUser$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.memes.plus.data.source.memes.RemoteMemesDataSource$blockUnblockUser$1 r0 = (com.memes.plus.data.source.memes.RemoteMemesDataSource$blockUnblockUser$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.memes.plus.data.source.memes.RemoteMemesDataSource$blockUnblockUser$1 r0 = new com.memes.plus.data.source.memes.RemoteMemesDataSource$blockUnblockUser$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0056
        L_0x002a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r8)
            com.memes.network.memes.MemesSession r8 = com.memes.network.memes.MemesSession.INSTANCE
            java.lang.String r8 = r8.getUserId()
            r7.setUserId(r8)
            com.memes.network.memes.MemesSession r8 = com.memes.network.memes.MemesSession.INSTANCE
            java.lang.String r8 = r8.getToken()
            r7.setLoginToken(r8)
            com.memes.plus.data.domain.ApiServiceGenerator r8 = com.memes.plus.data.domain.ApiServiceGenerator.INSTANCE
            com.memes.plus.data.domain.MemesClient r8 = r8.getMemesClient()
            r0.label = r3
            java.lang.Object r8 = r8.blockUnblockUser(r7, r0)
            if (r8 != r1) goto L_0x0056
            return r1
        L_0x0056:
            retrofit2.Response r8 = (retrofit2.Response) r8
            com.memes.plus.data.mapped_response.UniversalResult r7 = new com.memes.plus.data.mapped_response.UniversalResult
            int r1 = r8.code()
            java.lang.String r2 = r8.message()
            java.lang.String r0 = "response.message()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            java.lang.Object r3 = r8.body()
            r4 = 0
            r5 = 0
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.data.source.memes.RemoteMemesDataSource.blockUnblockUser(com.memes.plus.ui.profile.user_profile.BlockUnblockUserRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Single<UniversalResult<NotificationSettingsRequest>> toggleNotificationStatus(NotificationSettingsRequest notificationSettingsRequest) {
        Intrinsics.checkNotNullParameter(notificationSettingsRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        notificationSettingsRequest.setUserId(MemesSession.INSTANCE.getUserId());
        notificationSettingsRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().toggleNotification(notificationSettingsRequest).map(RemoteMemesDataSource$toggleNotificationStatus$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…ocessObjectResponse(it) }");
        return map;
    }

    public Single<UniversalResult<NotificationSettingsRequest>> changeNotificationStatus(NotificationSettingsRequest notificationSettingsRequest) {
        Intrinsics.checkNotNullParameter(notificationSettingsRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        notificationSettingsRequest.setUserId(MemesSession.INSTANCE.getUserId());
        notificationSettingsRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().changeNotificationStatus(notificationSettingsRequest).map(RemoteMemesDataSource$changeNotificationStatus$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…ocessObjectResponse(it) }");
        return map;
    }

    public Single<UniversalResult<Object>> logout() {
        AuthenticatedContentRequest authenticatedContentRequest = new AuthenticatedContentRequest();
        authenticatedContentRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        authenticatedContentRequest.setUserId(MemesSession.INSTANCE.getUserId());
        Single<R> map = ApiServiceGenerator.INSTANCE.getMemesClient().logout(authenticatedContentRequest).map(RemoteMemesDataSource$logout$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "ApiServiceGenerator\n\t\t\t.…cessMessageResponse(it) }");
        return map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object registerPurchaseToServer(com.memes.plus.p040ui.subscription.PurchaseRecord r5, kotlin.coroutines.Continuation<? super com.memes.plus.data.mapped_response.UniversalResult<java.lang.Object>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.memes.plus.data.source.memes.RemoteMemesDataSource$registerPurchaseToServer$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.memes.plus.data.source.memes.RemoteMemesDataSource$registerPurchaseToServer$1 r0 = (com.memes.plus.data.source.memes.RemoteMemesDataSource$registerPurchaseToServer$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.memes.plus.data.source.memes.RemoteMemesDataSource$registerPurchaseToServer$1 r0 = new com.memes.plus.data.source.memes.RemoteMemesDataSource$registerPurchaseToServer$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0056
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            com.memes.network.memes.MemesSession r6 = com.memes.network.memes.MemesSession.INSTANCE
            java.lang.String r6 = r6.getUserId()
            r5.setUserId(r6)
            com.memes.network.memes.MemesSession r6 = com.memes.network.memes.MemesSession.INSTANCE
            java.lang.String r6 = r6.getToken()
            r5.setLoginToken(r6)
            com.memes.plus.data.domain.ApiServiceGenerator r6 = com.memes.plus.data.domain.ApiServiceGenerator.INSTANCE
            com.memes.plus.data.domain.MemesClient r6 = r6.getMemesClient()
            r0.label = r3
            java.lang.Object r6 = r6.registerPurchaseToServer(r5, r0)
            if (r6 != r1) goto L_0x0056
            return r1
        L_0x0056:
            retrofit2.Response r6 = (retrofit2.Response) r6
            com.memes.plus.data.source.memes.MemesCoreMapper r5 = com.memes.plus.data.source.memes.MemesCoreMapper.INSTANCE
            com.memes.plus.data.mapped_response.UniversalResult r5 = r5.processMessageResponse(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.data.source.memes.RemoteMemesDataSource.registerPurchaseToServer(com.memes.plus.ui.subscription.PurchaseRecord, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
