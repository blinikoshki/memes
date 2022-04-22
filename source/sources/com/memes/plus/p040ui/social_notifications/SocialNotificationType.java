package com.memes.plus.p040ui.social_notifications;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/plus/ui/social_notifications/SocialNotificationType;", "", "()V", "COMMENTED_ON_POST", "", "LIKED_COMMENT", "LIKED_POST", "MENTIONED_IN_COMMENT", "NEW_POST", "TAGGED_IN_POST", "USER_FOLLOWED", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.social_notifications.SocialNotificationType */
/* compiled from: SocialNotificationType.kt */
public final class SocialNotificationType {
    public static final String COMMENTED_ON_POST = "CommentOnPost";
    public static final SocialNotificationType INSTANCE = new SocialNotificationType();
    public static final String LIKED_COMMENT = "LikeToComment";
    public static final String LIKED_POST = "likepost";
    public static final String MENTIONED_IN_COMMENT = "mentionOnComment";
    public static final String NEW_POST = "addNewpost";
    public static final String TAGGED_IN_POST = "tagpost";
    public static final String USER_FOLLOWED = "followuser";

    private SocialNotificationType() {
    }
}
