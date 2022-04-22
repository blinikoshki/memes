package com.memes.eventtracker.tracking;

import com.facebook.share.internal.ShareConstants;
import com.memes.eventtracker.specialevents.SpecialEvent;
import com.memes.eventtracker.specialevents.SubscriptionEvent;
import com.memes.eventtracker.specialevents.SubscriptionTrialEvent;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0010\b\n\u0002\bI\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J\"\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0011\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010\u0012\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u0007J\u0006\u0010\u0015\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0007J\u0006\u0010\u0017\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u0007J\u0006\u0010\u0019\u001a\u00020\u0007J\u0006\u0010\u001a\u001a\u00020\u0007J\u0006\u0010\u001b\u001a\u00020\u0007J\u0006\u0010\u001c\u001a\u00020\u0007J\u0006\u0010\u001d\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\u0007J\u0006\u0010\u001f\u001a\u00020\u0007J\u0006\u0010 \u001a\u00020\u0007J\u0006\u0010!\u001a\u00020\u0007J\u0006\u0010\"\u001a\u00020\u0007J\u0006\u0010#\u001a\u00020\u0007J\u0006\u0010$\u001a\u00020\u0007J\u0006\u0010%\u001a\u00020\u0007J\u0006\u0010&\u001a\u00020\u0007J\u0006\u0010'\u001a\u00020\u0007J\u0006\u0010(\u001a\u00020\u0007J\u0006\u0010)\u001a\u00020\u0007J\u0006\u0010*\u001a\u00020\u0007J\u0010\u0010+\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010-\u001a\u00020\u0007J\u0006\u0010.\u001a\u00020\u0007J\u0006\u0010/\u001a\u00020\u0007J\u0006\u00100\u001a\u00020\u0007J\u0006\u00101\u001a\u00020\u0007J\u000e\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u000204J\u000e\u00105\u001a\u00020\u00072\u0006\u00103\u001a\u000204J\u000e\u00106\u001a\u00020\u00072\u0006\u00103\u001a\u000204J\u0006\u00107\u001a\u00020\u0007J\u0016\u00108\u001a\u00020\u00072\u0006\u00103\u001a\u0002042\u0006\u00109\u001a\u000204J\u0006\u0010:\u001a\u00020\u0007J\u0006\u0010;\u001a\u00020\u0007J\u0006\u0010<\u001a\u00020\u0007J\u0016\u0010=\u001a\u00020\u00072\u0006\u00103\u001a\u0002042\u0006\u0010>\u001a\u000204J\u000e\u0010?\u001a\u00020\u00072\u0006\u00103\u001a\u000204J\u0006\u0010@\u001a\u00020\u0007J\u0006\u0010A\u001a\u00020\u0007J\u0006\u0010B\u001a\u00020\u0007J\u0006\u0010C\u001a\u00020\u0007J\u0006\u0010D\u001a\u00020\u0007J\u0006\u0010E\u001a\u00020\u0007J\u0006\u0010F\u001a\u00020\u0007J\u0006\u0010G\u001a\u00020\u0007J\u0006\u0010H\u001a\u00020\u0007J\u0010\u0010I\u001a\u00020\u00072\b\u0010J\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010K\u001a\u00020\u00072\b\u0010J\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010L\u001a\u00020\u00072\b\u0010M\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010N\u001a\u00020\u0007J\u0006\u0010O\u001a\u00020\u0007J\u0010\u0010P\u001a\u00020\u00072\b\u0010Q\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010R\u001a\u00020\u0007J\u0006\u0010S\u001a\u00020\u0007J\u001a\u0010T\u001a\u00020\u00072\b\u0010J\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u001a\u0010U\u001a\u00020\u00072\b\u0010J\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010V\u001a\u00020\u0007J\u001a\u0010W\u001a\u00020\u00072\b\u0010J\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010X\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u001a\u0010Y\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010Z\u001a\u0004\u0018\u00010\u000fJ\u001a\u0010[\u001a\u00020\u00072\b\u0010J\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\\\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010]\u001a\u00020\u0007J\u0006\u0010^\u001a\u00020\u0007J\u0006\u0010_\u001a\u00020\u0007J\u0010\u0010`\u001a\u00020\u00072\b\u0010Z\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010a\u001a\u00020\u00072\b\u0010Z\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010b\u001a\u00020\u00072\b\u0010Z\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010c\u001a\u00020\u0007J,\u0010d\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010e\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010f\u001a\u00020\u0007J\u0006\u0010g\u001a\u00020\u0007J\u0006\u0010h\u001a\u00020\u0007J\u0006\u0010i\u001a\u00020\u0007J\u0006\u0010j\u001a\u00020\u0007J\u0006\u0010k\u001a\u00020\u0007J\u0006\u0010l\u001a\u00020\u0007J\u0010\u0010m\u001a\u00020\u00072\b\u0010J\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010n\u001a\u00020\u0007J$\u0010o\u001a\u00020\u00072\b\u0010p\u001a\u0004\u0018\u00010\u000f2\b\u0010q\u001a\u0004\u0018\u00010\u000f2\b\u0010r\u001a\u0004\u0018\u00010\u000fJ$\u0010s\u001a\u00020\u00072\b\u0010p\u001a\u0004\u0018\u00010\u000f2\b\u0010q\u001a\u0004\u0018\u00010\u000f2\b\u0010r\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010t\u001a\u00020\u0007J\u0006\u0010u\u001a\u00020\u0007J\u0010\u0010v\u001a\u00020\u00072\b\u0010w\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010x\u001a\u00020\u00072\b\u0010J\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010y\u001a\u00020\u00072\b\u0010J\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010z\u001a\u00020\u0007J*\u0010{\u001a\u00020\u00072\u0006\u0010|\u001a\u00020\u000f2\u0018\b\u0002\u0010}\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010~H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006"}, mo26107d2 = {"Lcom/memes/eventtracker/tracking/EventTrackingManager;", "", "router", "Lcom/memes/eventtracker/tracking/EventRouter;", "(Lcom/memes/eventtracker/tracking/EventRouter;)V", "getRouter", "onBioFieldTapped", "", "onChangeAgeFieldTapped", "onChatNavItemTapped", "onClassicFontsTapped", "onCommentLiked", "hasPhoto", "", "postId", "", "commentId", "onCommentsPageOpened", "onContentBrowserGifsPageViewed", "onContentBrowserGifsTabTapped", "onContentBrowserMemesPageViewed", "onContentBrowserMemesTabTapped", "onContentBrowserPageClosed", "onContentBrowserPageViewed", "onContentBrowserPhotosPageViewed", "onContentBrowserPhotosTabTapped", "onContentBrowserRedditPageViewed", "onContentBrowserRedditTabTapped", "onContentBrowserVideosPageViewed", "onContentBrowserVideosTabTapped", "onCreatePostPageClosed", "onCreatePostPageSaveTapped", "onDefaultFontsTapped", "onEditCoverPicTapped", "onEditProfileButtonTapped", "onEditProfilePicTapped", "onEditorBackgroundColorTabTapped", "onEditorBordersTabTapped", "onEditorCornersTabTapped", "onEditorCropTabTapped", "onEditorEffectsTabTapped", "onEditorExitTapped", "onEditorFontsPageShown", "onEditorFrameSelected", "frameDescription", "onEditorFramesPageShown", "onEditorNavItemTapped", "onEditorSaveTapped", "onEditorStickersTabTapped", "onEditorTextAdjustmentTabTapped", "onEditorTextAlignedToCenter", "textIndex", "", "onEditorTextAlignedToLeft", "onEditorTextAlignedToRight", "onEditorTextColorTabTapped", "onEditorTextMarginAdjusted", "textMarginPercent", "onEditorTextOnlyFrameSelected", "onEditorTextOptionsClosed", "onEditorTextOptionsOpened", "onEditorTextSizeAdjusted", "textSizePercent", "onEditorTextTypingStart", "onEditorWatermarkTabTapped", "onExitEditProfileTapped", "onExploreGridUiViewed", "onExploreLinearUiViewed", "onExploreNavItemTapped", "onExplorePeopleTabTapped", "onExploreSearchBoxTapped", "onExploreSearchCanceled", "onExploreTagsTabTapped", "onFacebookUserSignedIn", "fromUserId", "onFacebookUserSignedUp", "onHashTagTapped", "hashtag", "onHomeNavItemTapped", "onLocationFieldTapped", "onLogoutButtonTapped", "userId", "onMovieFontsTapped", "onNameFieldTapped", "onNewPostCommentAdded", "onNewPostCreated", "onNotificationsNavItemTapped", "onPostLikeButtonTapped", "onPostOptionsIconTapped", "onPostProfilePicTapped", "targetUserId", "onPostSaveButtonTapped", "onPostShareButtonTapped", "onPremiumFontsTapped", "onProfileNavItemTapped", "onProfilePicChanged", "onProfilePostsTabTapped", "onProfileSavedPostsTabTapped", "onProfileTaggedPostsTapped", "onRateTapped", "onReplyLiked", "replyId", "onRestorePurchasesTapped", "onRetroFontsTapped", "onSaveProfileTapped", "onScriptFontsTapped", "onShareCreatedPostTapped", "onShareCreatedPostToFacebookTapped", "onShareCreatedPostToInstagramTapped", "onSnapchatUserSignedIn", "onSpecialFontsTapped", "onSubscriptionStarted", "orderId", "price", "currency", "onSubscriptionTrialStarted", "onSupportTapped", "onUploadPostTapped", "onUserMentionTapped", "userName", "onUserSignedIn", "onUserSignedUp", "onUsernameFieldTapped", "send", "eventId", "data", "", "eventtracker_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EventTrackingManager.kt */
public final class EventTrackingManager {
    private final EventRouter router;

    public final void onEditorBackgroundColorTabTapped() {
    }

    public EventTrackingManager(EventRouter eventRouter) {
        Intrinsics.checkNotNullParameter(eventRouter, "router");
        this.router = eventRouter;
    }

    public final EventRouter getRouter() {
        return this.router;
    }

    static /* synthetic */ void send$default(EventTrackingManager eventTrackingManager, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        eventTrackingManager.send(str, map);
    }

    private final void send(String str, Map<String, String> map) {
        this.router.send(new TrackableEvent(str, map));
    }

    public final void onUserSignedIn(String str) {
        Map hashMap = new HashMap();
        hashMap.put("event", "User signed in.");
        hashMap.put("event_author", str);
        hashMap.put(EventReservedParamId.PARAM_USER_ID, str);
        send(EventId.SIGN_IN_BASIC, hashMap);
    }

    public final void onFacebookUserSignedIn(String str) {
        Map hashMap = new HashMap();
        hashMap.put("event", "User signed in with facebook.");
        hashMap.put("event_author", str);
        hashMap.put(EventReservedParamId.PARAM_USER_ID, str);
        send("sign_in_facebook", hashMap);
    }

    public final void onSnapchatUserSignedIn(String str) {
        Map hashMap = new HashMap();
        hashMap.put("event", "User signed in with snapchat.");
        hashMap.put("event_author", str);
        hashMap.put(EventReservedParamId.PARAM_USER_ID, str);
        send("sign_in_facebook", hashMap);
    }

    public final void onUserSignedUp(String str) {
        Map hashMap = new HashMap();
        hashMap.put("event", "User signed up.");
        hashMap.put("event_author", str);
        hashMap.put(EventReservedParamId.PARAM_USER_ID, str);
        send(EventId.SIGN_UP_BASIC, hashMap);
    }

    public final void onFacebookUserSignedUp(String str) {
        Map hashMap = new HashMap();
        hashMap.put("event", "User signed up with facebook.");
        hashMap.put("event_author", str);
        hashMap.put(EventReservedParamId.PARAM_USER_ID, str);
        send(EventId.SIGN_UP_FACEBOOK, hashMap);
    }

    public final void onHomeNavItemTapped() {
        send$default(this, EventId.NAV_HOME, (Map) null, 2, (Object) null);
    }

    public final void onExploreNavItemTapped() {
        send$default(this, EventId.NAV_EXPLORE, (Map) null, 2, (Object) null);
    }

    public final void onEditorNavItemTapped() {
        send$default(this, EventId.NAV_EDITOR, (Map) null, 2, (Object) null);
    }

    public final void onChatNavItemTapped() {
        send$default(this, EventId.NAV_CHAT, (Map) null, 2, (Object) null);
    }

    public final void onProfileNavItemTapped() {
        send$default(this, EventId.NAV_PROFILE, (Map) null, 2, (Object) null);
    }

    public final void onNotificationsNavItemTapped() {
        send$default(this, EventId.NAV_NOTIFICATIONS, (Map) null, 2, (Object) null);
    }

    public final void onPostLikeButtonTapped(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("event_desc", "User tapped on 'like post' button.");
        hashMap.put("event_author", str);
        hashMap.put(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID, str2);
        send(EventId.TAP_POST_LIKE, hashMap);
    }

    public final void onPostProfilePicTapped(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("target_user", str2);
        hashMap.put(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID, str);
        send(EventId.TAP_POST_PROFILE_PIC, hashMap);
    }

    public final void onPostOptionsIconTapped(String str) {
        Map hashMap = new HashMap();
        hashMap.put(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID, str);
        send(EventId.TAP_POST_OPTIONS, hashMap);
    }

    public final void onPostSaveButtonTapped(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("event_desc", "User tapped on 'save post' button.");
        hashMap.put("event_author", str);
        hashMap.put(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID, str2);
        send(EventId.TAP_POST_SAVE, hashMap);
    }

    public final void onPostShareButtonTapped(String str) {
        Map hashMap = new HashMap();
        hashMap.put("event_desc", "User tapped on 'share post' button.");
        hashMap.put(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID, str);
        send(EventId.TAP_POST_SHARE, hashMap);
    }

    public final void onCommentsPageOpened(String str) {
        Map hashMap = new HashMap();
        hashMap.put(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID, str);
        send(EventId.COMMENTS_PAGE, hashMap);
    }

    public final void onNewPostCommentAdded(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("event", "User added a comment to a post.");
        hashMap.put("event_author", str);
        hashMap.put(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID, str2);
        send(EventId.NEW_POST_COMMENT, hashMap);
    }

    public final void onCommentLiked(boolean z, String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID, str);
        hashMap.put("comment_id", str2);
        send(z ? EventId.PHOTO_COMMENT_LIKED : EventId.COMMENT_LIKED, hashMap);
    }

    public final void onReplyLiked(boolean z, String str, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID, str);
        hashMap.put("comment_id", str2);
        hashMap.put("reply_id", str3);
        send(z ? EventId.PHOTO_REPLY_LIKED : EventId.REPLY_LIKED, hashMap);
    }

    public final void onExploreSearchBoxTapped() {
        send$default(this, EventId.TAP_EXPLORE_SEARCH, (Map) null, 2, (Object) null);
    }

    public final void onExploreSearchCanceled() {
        send$default(this, EventId.TAP_EXPLORE_CANCEL, (Map) null, 2, (Object) null);
    }

    public final void onExplorePeopleTabTapped() {
        send$default(this, EventId.TAP_EXPLORE_PEOPLE, (Map) null, 2, (Object) null);
    }

    public final void onExploreTagsTabTapped() {
        send$default(this, EventId.TAP_EXPLORE_TAGS, (Map) null, 2, (Object) null);
    }

    public final void onExploreLinearUiViewed() {
        send$default(this, EventId.TAP_EXPLORE_LINEAR, (Map) null, 2, (Object) null);
    }

    public final void onExploreGridUiViewed() {
        send$default(this, EventId.TAP_EXPLORE_GRID, (Map) null, 2, (Object) null);
    }

    public final void onHashTagTapped(String str) {
        Map hashMap = new HashMap();
        hashMap.put(ShareConstants.WEB_DIALOG_PARAM_HASHTAG, str);
        hashMap.put("event_desc", "User tapped on a hash tag.");
        send(EventId.TAP_HASH_TAG, hashMap);
    }

    public final void onUserMentionTapped(String str) {
        Map hashMap = new HashMap();
        hashMap.put("target_user_name", str);
        hashMap.put("event_desc", "User tapped on a user-mention or is going to see a user profile.");
        send(EventId.TAP_USER_MENTION, hashMap);
    }

    public final void onProfilePostsTabTapped(String str) {
        Map hashMap = new HashMap();
        hashMap.put("target_user", str);
        hashMap.put("event_desc", "User tapped on 'submitted posts' tab on Profile page.");
        send(EventId.TAP_PROFILE_POSTS, hashMap);
    }

    public final void onProfileSavedPostsTabTapped(String str) {
        Map hashMap = new HashMap();
        hashMap.put("target_user", str);
        hashMap.put("event_desc", "User tapped on 'saved posts' tab on Profile page.");
        send(EventId.TAP_PROFILE_SAVED_POSTS, hashMap);
    }

    public final void onProfileTaggedPostsTapped(String str) {
        Map hashMap = new HashMap();
        hashMap.put("target_user", str);
        hashMap.put("event_desc", "User tapped on 'tagged posts' tab on Profile page.");
        send(EventId.TAP_PROFILE_TAGGED_POSTS, hashMap);
    }

    public final void onEditProfileButtonTapped() {
        send$default(this, EventId.TAP_EDIT_PROFILE, (Map) null, 2, (Object) null);
    }

    public final void onExitEditProfileTapped() {
        send$default(this, EventId.EDIT_PROFILE_EXIT, (Map) null, 2, (Object) null);
    }

    public final void onProfilePicChanged() {
        send$default(this, EventId.CHANGED_PROFILE_PIC, (Map) null, 2, (Object) null);
    }

    public final void onEditProfilePicTapped() {
        send$default(this, EventId.TAP_CHANGE_PROFILE_PIC, (Map) null, 2, (Object) null);
    }

    public final void onEditCoverPicTapped() {
        send$default(this, EventId.TAP_CHANGE_COVER_PIC, (Map) null, 2, (Object) null);
    }

    public final void onSaveProfileTapped() {
        send$default(this, EventId.EDIT_PROFILE_SAVE, (Map) null, 2, (Object) null);
    }

    public final void onNameFieldTapped() {
        send$default(this, EventId.TAP_CHANGE_NAME, (Map) null, 2, (Object) null);
    }

    public final void onBioFieldTapped() {
        send$default(this, EventId.TAP_CHANGE_BIO, (Map) null, 2, (Object) null);
    }

    public final void onLogoutButtonTapped(String str) {
        Map hashMap = new HashMap();
        hashMap.put("event", "User is logging out.");
        hashMap.put(EventReservedParamId.PARAM_USER_ID, str);
        send(EventId.LOGOUT, hashMap);
    }

    public final void onUsernameFieldTapped() {
        send$default(this, EventId.TAP_CHANGE_USERNAME, (Map) null, 2, (Object) null);
    }

    public final void onLocationFieldTapped() {
        send$default(this, EventId.TAP_CHANGE_LOCATION, (Map) null, 2, (Object) null);
    }

    public final void onRestorePurchasesTapped() {
        send$default(this, EventId.RESTORE_PURCHASES, (Map) null, 2, (Object) null);
    }

    public final void onSupportTapped() {
        send$default(this, EventId.SUPPORT, (Map) null, 2, (Object) null);
    }

    public final void onRateTapped() {
        send$default(this, EventId.RATE, (Map) null, 2, (Object) null);
    }

    public final void onChangeAgeFieldTapped() {
        send$default(this, EventId.TAP_CHANGE_AGE, (Map) null, 2, (Object) null);
    }

    public final void onEditorSaveTapped() {
        send$default(this, EventId.TAP_SAVE_EDITOR_FRAME, (Map) null, 2, (Object) null);
    }

    public final void onEditorExitTapped() {
        send$default(this, EventId.TAP_EXIT_EDITOR, (Map) null, 2, (Object) null);
    }

    public final void onEditorTextOptionsOpened() {
        send$default(this, EventId.PAGE_EDITOR_TEXT_OPTIONS, (Map) null, 2, (Object) null);
    }

    public final void onEditorTextTypingStart(int i) {
        Map hashMap = new HashMap();
        hashMap.put("text_layout_index", String.valueOf(i));
        send(EventId.TAP_EDITOR_TEXT_TYPING, hashMap);
    }

    public final void onEditorTextColorTabTapped() {
        send$default(this, EventId.TAP_EDITOR_TEXT_COLORS, (Map) null, 2, (Object) null);
    }

    public final void onEditorTextAdjustmentTabTapped() {
        send$default(this, EventId.TAP_EDITOR_TEXT_ADJUST, (Map) null, 2, (Object) null);
    }

    public final void onEditorTextSizeAdjusted(int i, int i2) {
        Map hashMap = new HashMap();
        hashMap.put("text_layout_index", String.valueOf(i));
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append('%');
        hashMap.put("text_size", sb.toString());
        send(EventId.EDITOR_TEXT_SIZE_ADJUSTED, hashMap);
    }

    public final void onEditorTextMarginAdjusted(int i, int i2) {
        Map hashMap = new HashMap();
        hashMap.put("text_layout_index", String.valueOf(i));
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append('%');
        hashMap.put("text_margin", sb.toString());
        send(EventId.EDITOR_TEXT_MARGIN_ADJUSTED, hashMap);
    }

    public final void onEditorTextAlignedToLeft(int i) {
        Map hashMap = new HashMap();
        hashMap.put("text_layout_index", String.valueOf(i));
        send(EventId.EDITOR_TEXT_ALIGN_LEFT, hashMap);
    }

    public final void onEditorTextAlignedToCenter(int i) {
        Map hashMap = new HashMap();
        hashMap.put("text_layout_index", String.valueOf(i));
        send(EventId.EDITOR_TEXT_ALIGN_CENTER, hashMap);
    }

    public final void onEditorTextAlignedToRight(int i) {
        Map hashMap = new HashMap();
        hashMap.put("text_layout_index", String.valueOf(i));
        send(EventId.EDITOR_TEXT_ALIGN_RIGHT, hashMap);
    }

    public final void onEditorTextOptionsClosed() {
        send$default(this, EventId.EXIT_EDITOR_TEXT_OPTIONS, (Map) null, 2, (Object) null);
    }

    public final void onEditorFramesPageShown() {
        send$default(this, EventId.PAGE_EDITOR_FRAMES, (Map) null, 2, (Object) null);
    }

    public final void onEditorBordersTabTapped() {
        send$default(this, EventId.PAGE_EDITOR_BORDERS, (Map) null, 2, (Object) null);
    }

    public final void onEditorWatermarkTabTapped() {
        send$default(this, EventId.PAGE_EDITOR_WATERMARK, (Map) null, 2, (Object) null);
    }

    public final void onEditorCropTabTapped() {
        send$default(this, EventId.PAGE_EDITOR_CROP, (Map) null, 2, (Object) null);
    }

    public final void onEditorCornersTabTapped() {
        send$default(this, EventId.PAGE_EDITOR_CORNERS, (Map) null, 2, (Object) null);
    }

    public final void onEditorStickersTabTapped() {
        send$default(this, EventId.PAGE_EDITOR_STICKERS, (Map) null, 2, (Object) null);
    }

    public final void onEditorEffectsTabTapped() {
        send$default(this, EventId.PAGE_EDITOR_TOOLS, (Map) null, 2, (Object) null);
    }

    public final void onEditorFrameSelected(String str) {
        Map hashMap = new HashMap();
        hashMap.put("frame_description", str);
        send(EventId.TAP_EDITOR_FRAME, hashMap);
    }

    public final void onEditorTextOnlyFrameSelected() {
        send$default(this, EventId.TAP_EDITOR_FRAME_TEXT_ONLY, (Map) null, 2, (Object) null);
    }

    public final void onNewPostCreated(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("event_desc", "User created a new post.");
        hashMap.put("event_author", str);
        hashMap.put(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID, str2);
        send(EventId.NEW_POST, hashMap);
    }

    public final void onEditorFontsPageShown() {
        send$default(this, EventId.PAGE_FONTS, (Map) null, 2, (Object) null);
    }

    public final void onPremiumFontsTapped() {
        send$default(this, EventId.TAP_PREMIUM_FONTS, (Map) null, 2, (Object) null);
    }

    public final void onClassicFontsTapped() {
        send$default(this, EventId.TAP_CLASSIC_FONTS, (Map) null, 2, (Object) null);
    }

    public final void onSpecialFontsTapped() {
        send$default(this, EventId.TAP_SPECIAL_FONTS, (Map) null, 2, (Object) null);
    }

    public final void onMovieFontsTapped() {
        send$default(this, EventId.TAP_MOVIE_FONTS, (Map) null, 2, (Object) null);
    }

    public final void onScriptFontsTapped() {
        send$default(this, EventId.TAP_SCRIPT_FONTS, (Map) null, 2, (Object) null);
    }

    public final void onRetroFontsTapped() {
        send$default(this, EventId.TAP_RETRO_FONTS, (Map) null, 2, (Object) null);
    }

    public final void onDefaultFontsTapped() {
        send$default(this, EventId.TAP_DEFAULT_FONTS, (Map) null, 2, (Object) null);
    }

    public final void onContentBrowserPageViewed() {
        send$default(this, EventId.PAGE_CONTENT_BROWSER, (Map) null, 2, (Object) null);
    }

    public final void onContentBrowserPageClosed() {
        send$default(this, EventId.CLOSE_CONTENT_BROWSER, (Map) null, 2, (Object) null);
    }

    public final void onContentBrowserPhotosTabTapped() {
        send$default(this, EventId.TAP_CONTENT_BROWSER_PHOTOS, (Map) null, 2, (Object) null);
    }

    public final void onContentBrowserPhotosPageViewed() {
        send$default(this, EventId.PAGE_CONTENT_BROWSER_PHOTOS, (Map) null, 2, (Object) null);
    }

    public final void onContentBrowserVideosTabTapped() {
        send$default(this, EventId.TAP_CONTENT_BROWSER_VIDEOS, (Map) null, 2, (Object) null);
    }

    public final void onContentBrowserVideosPageViewed() {
        send$default(this, EventId.PAGE_CONTENT_BROWSER_VIDEOS, (Map) null, 2, (Object) null);
    }

    public final void onContentBrowserGifsTabTapped() {
        send$default(this, EventId.TAP_CONTENT_BROWSER_GIFS, (Map) null, 2, (Object) null);
    }

    public final void onContentBrowserGifsPageViewed() {
        send$default(this, EventId.PAGE_CONTENT_BROWSER_GIFS, (Map) null, 2, (Object) null);
    }

    public final void onContentBrowserMemesTabTapped() {
        send$default(this, EventId.TAP_CONTENT_BROWSER_MEMES, (Map) null, 2, (Object) null);
    }

    public final void onContentBrowserMemesPageViewed() {
        send$default(this, EventId.PAGE_CONTENT_BROWSER_MEMES, (Map) null, 2, (Object) null);
    }

    public final void onContentBrowserRedditTabTapped() {
        send$default(this, EventId.TAP_CONTENT_BROWSER_REDDIT, (Map) null, 2, (Object) null);
    }

    public final void onContentBrowserRedditPageViewed() {
        send$default(this, EventId.PAGE_CONTENT_BROWSER_REDDIT, (Map) null, 2, (Object) null);
    }

    public final void onCreatePostPageClosed() {
        send$default(this, EventId.EXIT_CREATE_POST, (Map) null, 2, (Object) null);
    }

    public final void onUploadPostTapped() {
        send$default(this, EventId.TAP_UPLOAD_POST, (Map) null, 2, (Object) null);
    }

    public final void onCreatePostPageSaveTapped() {
        send$default(this, EventId.TAP_SAVE_CREATED_POST, (Map) null, 2, (Object) null);
    }

    public final void onShareCreatedPostToInstagramTapped() {
        send$default(this, EventId.TAP_FACEBOOK_SHARE_CREATED_POST, (Map) null, 2, (Object) null);
    }

    public final void onShareCreatedPostToFacebookTapped() {
        send$default(this, EventId.TAP_INSTAGRAM_SHARE_CREATED_POST, (Map) null, 2, (Object) null);
    }

    public final void onShareCreatedPostTapped() {
        send$default(this, EventId.TAP_SHARE_CREATED_POST, (Map) null, 2, (Object) null);
    }

    public final void onSubscriptionTrialStarted(String str, String str2, String str3) {
        this.router.send((SpecialEvent) new SubscriptionTrialEvent(str, "0.00", str3));
    }

    public final void onSubscriptionStarted(String str, String str2, String str3) {
        this.router.send((SpecialEvent) new SubscriptionEvent(str, str2, str3));
    }
}
