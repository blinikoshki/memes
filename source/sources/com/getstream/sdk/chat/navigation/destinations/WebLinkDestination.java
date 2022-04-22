package com.getstream.sdk.chat.navigation.destinations;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.getstream.sdk.chat.ChatUI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;

@InternalStreamChatApi
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lcom/getstream/sdk/chat/navigation/destinations/WebLinkDestination;", "Lcom/getstream/sdk/chat/navigation/destinations/ChatDestination;", "url", "", "context", "Landroid/content/Context;", "(Ljava/lang/String;Landroid/content/Context;)V", "navigate", "", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: WebLinkDestination.kt */
public final class WebLinkDestination extends ChatDestination {
    private final String url;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebLinkDestination(String str, Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(context, "context");
        String signFileUrl = ChatUI.Companion.instance().getUrlSigner().signFileUrl(str);
        this.url = signFileUrl == null ? "" : signFileUrl;
    }

    public void navigate() {
        start(new Intent("android.intent.action.VIEW", Uri.parse(this.url)));
    }
}
