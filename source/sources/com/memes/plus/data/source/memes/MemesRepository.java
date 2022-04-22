package com.memes.plus.data.source.memes;

import com.facebook.share.internal.ShareConstants;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import p015io.reactivex.Single;
import p015io.reactivex.schedulers.Schedulers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000È\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060\u00052\u0006\u0010\b\u001a\u00020\fH\u0016J\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\b\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00060\u00052\u0006\u0010\b\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00060\u00052\u0006\u0010\b\u001a\u00020\u0015H\u0016J\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00060\u00052\u0006\u0010\b\u001a\u00020\u0017H\u0016J\u001c\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00060\u00052\u0006\u0010\b\u001a\u00020\u0019H\u0016J\u001c\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00060\u00052\u0006\u0010\b\u001a\u00020\u001bH\u0016J\u001c\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00060\u00052\u0006\u0010\b\u001a\u00020\u001dH\u0016J\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00060\u00052\u0006\u0010\b\u001a\u00020 H\u0016J\u001c\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00060\u00052\u0006\u0010\b\u001a\u00020\"H\u0016J\u001c\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00060\u00052\u0006\u0010\b\u001a\u00020%H\u0016J\u001c\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0\u00060\u00052\u0006\u0010\b\u001a\u00020(H\u0016J\u001c\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u00060\u00052\u0006\u0010\b\u001a\u00020(H\u0016J\u001c\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00060\u00052\u0006\u0010\b\u001a\u00020,H\u0016J\u001f\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00062\u0006\u0010\b\u001a\u00020/H@ø\u0001\u0000¢\u0006\u0002\u00100J$\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00060\u00052\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0016J\u001c\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00060\u00052\u0006\u00102\u001a\u000203H\u0016J\u0014\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002080\u00060\u0005H\u0016J\u001c\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00060\u00052\u0006\u00102\u001a\u000203H\u0016J\u001c\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00060\u00052\u0006\u00102\u001a\u000203H\u0016J\u001c\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0\u00060\u00052\u0006\u00102\u001a\u000203H\u0016J\u001c\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0\u00060\u00052\u0006\u0010\b\u001a\u00020?H\u0016J\u0014\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020A0\u00060\u0005H\u0016J\u001c\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00060\u00052\u0006\u00102\u001a\u000203H\u0016J\u001c\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00060\u00052\u0006\u0010\b\u001a\u00020DH\u0016J\u001c\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0\u00060\u00052\u0006\u0010\b\u001a\u00020DH\u0016J\u001c\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00060\u00052\u0006\u0010\b\u001a\u00020DH\u0016J\u001c\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00060\u00052\u0006\u0010\b\u001a\u00020IH\u0016J\u0014\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00060\u0005H\u0016J\u001f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00140\u00062\u0006\u0010L\u001a\u00020MH@ø\u0001\u0000¢\u0006\u0002\u0010NJ\u001c\u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00060\u00052\u0006\u0010\b\u001a\u00020PH\u0016J\u001c\u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00060\u00052\u0006\u0010\b\u001a\u00020RH\u0016J\u001c\u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00060\u00052\u0006\u0010\b\u001a\u00020TH\u0016J\u001c\u0010U\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002080\u00060\u00052\u0006\u0010\b\u001a\u00020VH\u0016J\u001c\u0010W\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020X0\u00060\u00052\u0006\u0010\b\u001a\u00020YH\u0016J$\u0010Z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00060\u00052\u0006\u0010[\u001a\u00020\\2\u0006\u00102\u001a\u000203H\u0016J\u001c\u0010]\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020^0\u00060\u00052\u0006\u0010\b\u001a\u00020YH\u0016J\u001c\u0010_\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00060\u00052\u0006\u0010\b\u001a\u00020`H\u0016J\u001c\u0010a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00060\u00052\u0006\u0010\b\u001a\u00020bH\u0016J\u001c\u0010c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00060\u00052\u0006\u0010\b\u001a\u00020\u0012H\u0016J\u001c\u0010d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020e0\u00060\u00052\u0006\u0010\b\u001a\u00020fH\u0016J\u001c\u0010g\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00060\u00052\u0006\u0010\b\u001a\u00020hH\u0016J\u001c\u0010i\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00060\u00052\u0006\u0010\b\u001a\u00020jH\u0016J\u001c\u0010k\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00060\u00052\u0006\u0010\b\u001a\u00020lH\u0016J\u001c\u0010m\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060\u00052\u0006\u0010\b\u001a\u00020oH\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006p"}, mo26107d2 = {"Lcom/memes/plus/data/source/memes/MemesRepository;", "Lcom/memes/plus/data/source/memes/MemesDataSource;", "memesDataSource", "(Lcom/memes/plus/data/source/memes/MemesDataSource;)V", "addPostComment", "Lio/reactivex/Single;", "Lcom/memes/plus/data/mapped_response/UniversalResult;", "Lcom/memes/plus/ui/post_comments/PostComment;", "request", "Lcom/memes/plus/ui/post_comments/addComment/AddCommentRequest;", "addReply", "Lcom/memes/plus/ui/post_comments/reply/Reply;", "Lcom/memes/plus/ui/post_comments/reply/AddReplyRequest;", "blockUnblockUser", "Lcom/memes/plus/ui/profile/user_profile/BlockUnblockUserResponse;", "Lcom/memes/plus/ui/profile/user_profile/BlockUnblockUserRequest;", "(Lcom/memes/plus/ui/profile/user_profile/BlockUnblockUserRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changeNotificationStatus", "Lcom/memes/plus/ui/profile/edit_profile/notification_settings/NotificationSettingsRequest;", "createPost", "", "Lcom/memes/plus/ui/create_post/CreatePostRequest;", "deletePost", "Lcom/memes/plus/ui/posts/post_basics/post_delete/PostDeleteRequest;", "deletePostComment", "Lcom/memes/plus/ui/post_comments/deleteComment/DeletePostCommentRequest;", "deleteReply", "Lcom/memes/plus/ui/post_comments/reply/DeleteReplyRequest;", "editPost", "Lcom/memes/plus/ui/posts/edit_post/EditPostRequest;", "fetchFollowers", "Lcom/memes/plus/ui/user_listing/ListedUser;", "Lcom/memes/plus/ui/user_listing/followers/FollowersRequest;", "fetchFollowings", "Lcom/memes/plus/ui/user_listing/followings/FollowingsRequest;", "fetchPost", "Lcom/memes/plus/ui/posts/Post;", "Lcom/memes/plus/ui/posts/post/PostRequest;", "fetchPostComments", "Lcom/memes/plus/ui/post_comments/CommentsResponse;", "Lcom/memes/plus/ui/post_comments/CommentsRequest;", "fetchPostCommentsReplies", "Lcom/memes/plus/ui/post_comments/reply/CommentsShowAllRepliesData;", "fetchPostLikeUsers", "Lcom/memes/plus/ui/user_listing/post_likes/PostLikeUsersRequest;", "fetchPostTaggedUsers", "Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUser;", "Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUsersRequest;", "(Lcom/memes/plus/ui/posts/post_tags_dialog/PostTaggedUsersRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchPosts", "page", "", "type", "Lcom/memes/plus/ui/home/feeds/HomeFeedType;", "fetchSelfPosts", "fetchSelfProfile", "Lcom/memes/plus/ui/profile/self_profile/SelfProfile;", "fetchSelfSavedPosts", "fetchSelfTaggedPosts", "fetchSocialNotifications", "Lcom/memes/plus/ui/social_notifications/SocialNotification;", "fetchSuggestedProfiles", "Lcom/memes/plus/ui/suggestions/SuggestedProfile;", "Lcom/memes/plus/ui/posts/suggestions/SuggestedUsersRequest;", "fetchSuggestedUsers", "Lcom/memes/plus/ui/explore_search/people_search/suggestions/CatalogueSuggestedPerson;", "fetchTopPosts", "fetchUserPosts", "Lcom/memes/plus/ui/profile/user_profile/UserProfileRequest;", "fetchUserProfile", "Lcom/memes/plus/ui/profile/user_profile/UserProfileResponse;", "fetchUserTaggedPosts", "likeReply", "Lcom/memes/plus/ui/post_comments/reply/LikeReplyRequest;", "logout", "registerPurchaseToServer", "record", "Lcom/memes/plus/ui/subscription/PurchaseRecord;", "(Lcom/memes/plus/ui/subscription/PurchaseRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportComment", "Lcom/memes/plus/ui/post_comments/reportComment/ReportCommentRequest;", "reportPost", "Lcom/memes/plus/ui/posts/post_basics/post_report/PostReportRequest;", "reportReply", "Lcom/memes/plus/ui/post_comments/reply/ReportReplyRequest;", "saveProfile", "Lcom/memes/plus/ui/profile/edit_profile/SaveProfileRequest;", "searchPeople", "Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResult;", "Lcom/memes/plus/ui/explore_search/ExploreSearchRequest;", "searchPostsByTag", "hashtag", "", "searchTags", "Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResult;", "toggleCommentLike", "Lcom/memes/plus/ui/post_comments/commentLike/PostCommentLikeRequest;", "toggleFollowUser", "Lcom/memes/plus/ui/posts/post_basics/follow_user/FollowUserRequest;", "toggleNotificationStatus", "togglePostLike", "Lcom/memes/plus/ui/posts/post_basics/post_like/PostLike;", "Lcom/memes/plus/ui/posts/post_basics/post_like/PostLikeRequest;", "togglePostNotificationsSubscription", "Lcom/memes/plus/ui/posts/post_basics/post_notifications/PostNotificationSubscriptionRequest;", "togglePostSave", "Lcom/memes/plus/ui/posts/post_basics/post_save/PostSaveRequest;", "updateFirebaseToken", "Lcom/memes/plus/firebase/firebase_token/FirebaseTokenRequest;", "updatePostComment", "updateReplyComment", "Lcom/memes/plus/ui/post_comments/reply/EditReplyRequest;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MemesRepository.kt */
public final class MemesRepository implements MemesDataSource {
    /* access modifiers changed from: private */
    public final MemesDataSource memesDataSource;

    public MemesRepository(MemesDataSource memesDataSource2) {
        Intrinsics.checkNotNullParameter(memesDataSource2, "memesDataSource");
        this.memesDataSource = memesDataSource2;
    }

    public Single<UniversalResult<Object>> updateFirebaseToken(FirebaseTokenRequest firebaseTokenRequest) {
        Intrinsics.checkNotNullParameter(firebaseTokenRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<Object>> subscribeOn = this.memesDataSource.updateFirebaseToken(firebaseTokenRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.updateFi…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<Post>> fetchPost(PostRequest postRequest) {
        Intrinsics.checkNotNullParameter(postRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<Post>> subscribeOn = this.memesDataSource.fetchPost(postRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.fetchPos…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<Post>> fetchPosts(int i, HomeFeedType homeFeedType) {
        Intrinsics.checkNotNullParameter(homeFeedType, "type");
        Single<UniversalResult<Post>> subscribeOn = this.memesDataSource.fetchPosts(i, homeFeedType).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.fetchPos…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<Post>> fetchTopPosts(int i) {
        Single<UniversalResult<Post>> subscribeOn = this.memesDataSource.fetchTopPosts(i).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.fetchTop…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<Post>> searchPostsByTag(String str, int i) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_HASHTAG);
        Single<UniversalResult<Post>> subscribeOn = this.memesDataSource.searchPostsByTag(str, i).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.searchPo…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<PeopleSearchResult>> searchPeople(ExploreSearchRequest exploreSearchRequest) {
        Intrinsics.checkNotNullParameter(exploreSearchRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<PeopleSearchResult>> subscribeOn = this.memesDataSource.searchPeople(exploreSearchRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.searchPe…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<CatalogueSuggestedPerson>> fetchSuggestedUsers() {
        Single<UniversalResult<CatalogueSuggestedPerson>> subscribeOn = this.memesDataSource.fetchSuggestedUsers().subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.fetchSug…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Object fetchPostTaggedUsers(PostTaggedUsersRequest postTaggedUsersRequest, Continuation<? super UniversalResult<PostTaggedUser>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MemesRepository$fetchPostTaggedUsers$2(this, postTaggedUsersRequest, (Continuation) null), continuation);
    }

    public Single<UniversalResult<TagSearchResult>> searchTags(ExploreSearchRequest exploreSearchRequest) {
        Intrinsics.checkNotNullParameter(exploreSearchRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<TagSearchResult>> subscribeOn = this.memesDataSource.searchTags(exploreSearchRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.searchTa…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<PostLike>> togglePostLike(PostLikeRequest postLikeRequest) {
        Intrinsics.checkNotNullParameter(postLikeRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<PostLike>> subscribeOn = this.memesDataSource.togglePostLike(postLikeRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.togglePo…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<ListedUser>> fetchPostLikeUsers(PostLikeUsersRequest postLikeUsersRequest) {
        Intrinsics.checkNotNullParameter(postLikeUsersRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<ListedUser>> subscribeOn = this.memesDataSource.fetchPostLikeUsers(postLikeUsersRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.fetchPos…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<Object>> togglePostSave(PostSaveRequest postSaveRequest) {
        Intrinsics.checkNotNullParameter(postSaveRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<Object>> subscribeOn = this.memesDataSource.togglePostSave(postSaveRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.togglePo…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<Object>> deletePost(PostDeleteRequest postDeleteRequest) {
        Intrinsics.checkNotNullParameter(postDeleteRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<Object>> subscribeOn = this.memesDataSource.deletePost(postDeleteRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.deletePo…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<SuggestedProfile>> fetchSuggestedProfiles(SuggestedUsersRequest suggestedUsersRequest) {
        Intrinsics.checkNotNullParameter(suggestedUsersRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<SuggestedProfile>> subscribeOn = this.memesDataSource.fetchSuggestedProfiles(suggestedUsersRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.fetchSug…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<Object>> reportPost(PostReportRequest postReportRequest) {
        Intrinsics.checkNotNullParameter(postReportRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<Object>> subscribeOn = this.memesDataSource.reportPost(postReportRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.reportPo…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<Object>> togglePostNotificationsSubscription(PostNotificationSubscriptionRequest postNotificationSubscriptionRequest) {
        Intrinsics.checkNotNullParameter(postNotificationSubscriptionRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<Object>> subscribeOn = this.memesDataSource.togglePostNotificationsSubscription(postNotificationSubscriptionRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.togglePo…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<Object>> createPost(CreatePostRequest createPostRequest) {
        Intrinsics.checkNotNullParameter(createPostRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<Object>> subscribeOn = this.memesDataSource.createPost(createPostRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.createPo…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<Object>> editPost(EditPostRequest editPostRequest) {
        Intrinsics.checkNotNullParameter(editPostRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<Object>> subscribeOn = this.memesDataSource.editPost(editPostRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.editPost…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<CommentsResponse>> fetchPostComments(CommentsRequest commentsRequest) {
        Intrinsics.checkNotNullParameter(commentsRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<CommentsResponse>> subscribeOn = this.memesDataSource.fetchPostComments(commentsRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.fetchPos…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<Object>> toggleCommentLike(PostCommentLikeRequest postCommentLikeRequest) {
        Intrinsics.checkNotNullParameter(postCommentLikeRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<Object>> subscribeOn = this.memesDataSource.toggleCommentLike(postCommentLikeRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.toggleCo…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<PostComment>> addPostComment(AddCommentRequest addCommentRequest) {
        Intrinsics.checkNotNullParameter(addCommentRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<PostComment>> subscribeOn = this.memesDataSource.addPostComment(addCommentRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.addPostC…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<Object>> deletePostComment(DeletePostCommentRequest deletePostCommentRequest) {
        Intrinsics.checkNotNullParameter(deletePostCommentRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<Object>> subscribeOn = this.memesDataSource.deletePostComment(deletePostCommentRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.deletePo…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<PostComment>> updatePostComment(AddCommentRequest addCommentRequest) {
        Intrinsics.checkNotNullParameter(addCommentRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<PostComment>> subscribeOn = this.memesDataSource.updatePostComment(addCommentRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.updatePo…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<Reply>> addReply(AddReplyRequest addReplyRequest) {
        Intrinsics.checkNotNullParameter(addReplyRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<Reply>> subscribeOn = this.memesDataSource.addReply(addReplyRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.addReply…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<Object>> deleteReply(DeleteReplyRequest deleteReplyRequest) {
        Intrinsics.checkNotNullParameter(deleteReplyRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<Object>> subscribeOn = this.memesDataSource.deleteReply(deleteReplyRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.deleteRe…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<Object>> likeReply(LikeReplyRequest likeReplyRequest) {
        Intrinsics.checkNotNullParameter(likeReplyRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<Object>> subscribeOn = this.memesDataSource.likeReply(likeReplyRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.likeRepl…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<Reply>> updateReplyComment(EditReplyRequest editReplyRequest) {
        Intrinsics.checkNotNullParameter(editReplyRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<Reply>> subscribeOn = this.memesDataSource.updateReplyComment(editReplyRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.updateRe…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<CommentsShowAllRepliesData>> fetchPostCommentsReplies(CommentsRequest commentsRequest) {
        Intrinsics.checkNotNullParameter(commentsRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<CommentsShowAllRepliesData>> subscribeOn = this.memesDataSource.fetchPostCommentsReplies(commentsRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.fetchPos…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<Object>> reportReply(ReportReplyRequest reportReplyRequest) {
        Intrinsics.checkNotNullParameter(reportReplyRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<Object>> subscribeOn = this.memesDataSource.reportReply(reportReplyRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.reportRe…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<Object>> reportComment(ReportCommentRequest reportCommentRequest) {
        Intrinsics.checkNotNullParameter(reportCommentRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<Object>> subscribeOn = this.memesDataSource.reportComment(reportCommentRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.reportCo…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<SocialNotification>> fetchSocialNotifications(int i) {
        Single<UniversalResult<SocialNotification>> subscribeOn = this.memesDataSource.fetchSocialNotifications(i).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.fetchSoc…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<Object>> toggleFollowUser(FollowUserRequest followUserRequest) {
        Intrinsics.checkNotNullParameter(followUserRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<Object>> subscribeOn = this.memesDataSource.toggleFollowUser(followUserRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.toggleFo…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<ListedUser>> fetchFollowers(FollowersRequest followersRequest) {
        Intrinsics.checkNotNullParameter(followersRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<ListedUser>> subscribeOn = this.memesDataSource.fetchFollowers(followersRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.fetchFol…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<ListedUser>> fetchFollowings(FollowingsRequest followingsRequest) {
        Intrinsics.checkNotNullParameter(followingsRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<ListedUser>> subscribeOn = this.memesDataSource.fetchFollowings(followingsRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.fetchFol…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<SelfProfile>> fetchSelfProfile() {
        Single<UniversalResult<SelfProfile>> subscribeOn = this.memesDataSource.fetchSelfProfile().subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.fetchSel…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<Post>> fetchSelfPosts(int i) {
        Single<UniversalResult<Post>> subscribeOn = this.memesDataSource.fetchSelfPosts(i).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.fetchSel…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<Post>> fetchSelfSavedPosts(int i) {
        Single<UniversalResult<Post>> subscribeOn = this.memesDataSource.fetchSelfSavedPosts(i).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.fetchSel…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<Post>> fetchSelfTaggedPosts(int i) {
        Single<UniversalResult<Post>> subscribeOn = this.memesDataSource.fetchSelfTaggedPosts(i).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.fetchSel…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<UserProfileResponse>> fetchUserProfile(UserProfileRequest userProfileRequest) {
        Intrinsics.checkNotNullParameter(userProfileRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<UserProfileResponse>> subscribeOn = this.memesDataSource.fetchUserProfile(userProfileRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.fetchUse…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<Post>> fetchUserPosts(UserProfileRequest userProfileRequest) {
        Intrinsics.checkNotNullParameter(userProfileRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<Post>> subscribeOn = this.memesDataSource.fetchUserPosts(userProfileRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.fetchUse…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<Post>> fetchUserTaggedPosts(UserProfileRequest userProfileRequest) {
        Intrinsics.checkNotNullParameter(userProfileRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<Post>> subscribeOn = this.memesDataSource.fetchUserTaggedPosts(userProfileRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.fetchUse…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<SelfProfile>> saveProfile(SaveProfileRequest saveProfileRequest) {
        Intrinsics.checkNotNullParameter(saveProfileRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<SelfProfile>> subscribeOn = this.memesDataSource.saveProfile(saveProfileRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.saveProf…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Object blockUnblockUser(BlockUnblockUserRequest blockUnblockUserRequest, Continuation<? super UniversalResult<BlockUnblockUserResponse>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MemesRepository$blockUnblockUser$2(this, blockUnblockUserRequest, (Continuation) null), continuation);
    }

    public Single<UniversalResult<NotificationSettingsRequest>> toggleNotificationStatus(NotificationSettingsRequest notificationSettingsRequest) {
        Intrinsics.checkNotNullParameter(notificationSettingsRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<NotificationSettingsRequest>> subscribeOn = this.memesDataSource.toggleNotificationStatus(notificationSettingsRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.toggleNo…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<NotificationSettingsRequest>> changeNotificationStatus(NotificationSettingsRequest notificationSettingsRequest) {
        Intrinsics.checkNotNullParameter(notificationSettingsRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Single<UniversalResult<NotificationSettingsRequest>> subscribeOn = this.memesDataSource.changeNotificationStatus(notificationSettingsRequest).subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.changeNo…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Single<UniversalResult<Object>> logout() {
        Single<UniversalResult<Object>> subscribeOn = this.memesDataSource.logout().subscribeOn(Schedulers.m170io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "memesDataSource.logout()…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public Object registerPurchaseToServer(PurchaseRecord purchaseRecord, Continuation<? super UniversalResult<Object>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MemesRepository$registerPurchaseToServer$2(this, purchaseRecord, (Continuation) null), continuation);
    }
}
