package com.memes.plus;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Lcom/memes/plus/ApiRouting;", "", "()V", "APP_INVITE_FRIENDS", "", "APP_INVITE_URL", "BASE_MEMES", "BASE_MESSAGING", "BASE_MESSAGING_FILE_UPLOAD", "CHAT_SERVER_URL", "COMMENT_IMAGE_PATH", "GIPHY_API_KEY", "GIPHY_CONTENT_ENDPOINT", "MEMES_CDN", "activeStoreUrl", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ApiRouting.kt */
public final class ApiRouting {
    public static final String APP_INVITE_FRIENDS = "https://memes.onelink.me/8OHE/InviteFriends";
    public static final String APP_INVITE_URL = "https://memes.onelink.me/8OHE/Invite";
    public static final String BASE_MEMES = "https://app.memes.com/";
    public static final String BASE_MESSAGING = "https://api.memes.com/";
    public static final String BASE_MESSAGING_FILE_UPLOAD = "https://memes2019.s3.us-west-2.amazonaws.com/";
    public static final String CHAT_SERVER_URL = "wss://msg.memes.com";
    public static final String COMMENT_IMAGE_PATH = "https://cdn.memes.com/comments/";
    public static final String GIPHY_API_KEY = "0lApGRwt2dAR4xjJIjCNdq9n3Q1t4Ygw";
    public static final String GIPHY_CONTENT_ENDPOINT = "https://media1.giphy.com/media/";
    public static final ApiRouting INSTANCE = new ApiRouting();
    public static final String MEMES_CDN = "https://cdn.memes.com/";

    public final String activeStoreUrl() {
        return "http://meme.dynastyapps.com/memeapp/";
    }

    private ApiRouting() {
    }
}
