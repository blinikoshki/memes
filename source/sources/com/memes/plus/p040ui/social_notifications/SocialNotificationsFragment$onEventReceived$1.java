package com.memes.plus.p040ui.social_notifications;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.social_notifications.SocialNotificationsFragment$onEventReceived$1 */
/* compiled from: SocialNotificationsFragment.kt */
final /* synthetic */ class SocialNotificationsFragment$onEventReceived$1 extends MutablePropertyReference0Impl {
    SocialNotificationsFragment$onEventReceived$1(SocialNotificationsFragment socialNotificationsFragment) {
        super(socialNotificationsFragment, SocialNotificationsFragment.class, "notificationsAdapter", "getNotificationsAdapter()Lcom/memes/plus/ui/social_notifications/SocialNotificationsAdapter;", 0);
    }

    public Object get() {
        return SocialNotificationsFragment.access$getNotificationsAdapter$p((SocialNotificationsFragment) this.receiver);
    }

    public void set(Object obj) {
        ((SocialNotificationsFragment) this.receiver).notificationsAdapter = (SocialNotificationsAdapter) obj;
    }
}
