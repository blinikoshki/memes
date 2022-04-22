package com.memes.plus.deeplinking;

import com.facebook.share.internal.ShareConstants;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/deeplinking/DeepLinkingRouting;", "", "()V", "BASE_URL", "", "getPostUrl", "postId", "getUserProfileUrl", "userId", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: DeepLinkingRouting.kt */
public final class DeepLinkingRouting {
    private static final String BASE_URL = "blackchat://memes/";
    public static final DeepLinkingRouting INSTANCE = new DeepLinkingRouting();

    private DeepLinkingRouting() {
    }

    public final String getUserProfileUrl(String str) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        return "blackchat://memes/myUserId/" + str;
    }

    public final String getPostUrl(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.RESULT_POST_ID);
        return BASE_URL + str;
    }
}
