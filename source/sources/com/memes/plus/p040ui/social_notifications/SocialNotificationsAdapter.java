package com.memes.plus.p040ui.social_notifications;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.memes.commons.recycleradapter.AdapterViewHolderPayload;
import com.memes.commons.recycleradapter.BaseRecyclerAdapter;
import com.memes.commons.recycleradapter.BaseViewHolder;
import com.memes.plus.C4199R;
import com.memes.plus.custom.UserAvatarView;
import com.memes.plus.databinding.SocialBasicNotificationItemBinding;
import com.memes.plus.databinding.SocialPostNotificationItemBinding;
import com.memes.plus.databinding.SocialUserFollowedNotificationItemBinding;
import com.memes.plus.events.PostDeletedEvent;
import com.memes.plus.events.UserFollowEvent;
import com.memes.plus.p040ui.posts.post_basics.follow_user.FollowUserResult;
import com.memes.plus.util.picasso.PicassoExtKt;
import com.squareup.picasso.Picasso;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u001b2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001:\u0004\u001a\u001b\u001c\u001dB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0010J&\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo26107d2 = {"Lcom/memes/plus/ui/social_notifications/SocialNotificationsAdapter;", "Lcom/memes/commons/recycleradapter/BaseRecyclerAdapter;", "Lcom/memes/plus/ui/social_notifications/SocialNotification;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "context", "Landroid/content/Context;", "adapterListener", "Lcom/memes/plus/ui/social_notifications/SocialNotificationsAdapterListener;", "(Landroid/content/Context;Lcom/memes/plus/ui/social_notifications/SocialNotificationsAdapterListener;)V", "applyUpdate", "", "result", "Lcom/memes/plus/ui/posts/post_basics/follow_user/FollowUserResult;", "consume", "event", "Lcom/memes/plus/events/PostDeletedEvent;", "Lcom/memes/plus/events/UserFollowEvent;", "createItemViewHolder", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemViewType", "position", "BasicNotificationViewHolder", "Companion", "PostNotificationViewHolder", "UserFollowedNotificationViewHolder", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.social_notifications.SocialNotificationsAdapter */
/* compiled from: SocialNotificationsAdapter.kt */
public final class SocialNotificationsAdapter extends BaseRecyclerAdapter<SocialNotification, BaseViewHolder<SocialNotification>> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PAYLOAD_AUTHOR_FOLLOWED_CHANGED = "payload_author_followed_changed";
    public static final int TYPE_BASIC = 563;
    public static final int TYPE_COMMENTED_ON_POST = 568;
    public static final int TYPE_LIKED_COMMENT = 567;
    public static final int TYPE_LIKED_POST = 566;
    public static final int TYPE_MENTIONED_IN_COMMENT = 569;
    public static final int TYPE_NEW_POST = 565;
    public static final int TYPE_TAGGED_IN_POST = 570;
    public static final int TYPE_USER_FOLLOWED = 564;
    /* access modifiers changed from: private */
    public final SocialNotificationsAdapterListener adapterListener;
    /* access modifiers changed from: private */
    public final Context context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SocialNotificationsAdapter(Context context2, SocialNotificationsAdapterListener socialNotificationsAdapterListener) {
        super(context2);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(socialNotificationsAdapterListener, "adapterListener");
        this.context = context2;
        this.adapterListener = socialNotificationsAdapterListener;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo26107d2 = {"Lcom/memes/plus/ui/social_notifications/SocialNotificationsAdapter$Companion;", "", "()V", "PAYLOAD_AUTHOR_FOLLOWED_CHANGED", "", "TYPE_BASIC", "", "TYPE_COMMENTED_ON_POST", "TYPE_LIKED_COMMENT", "TYPE_LIKED_POST", "TYPE_MENTIONED_IN_COMMENT", "TYPE_NEW_POST", "TYPE_TAGGED_IN_POST", "TYPE_USER_FOLLOWED", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.social_notifications.SocialNotificationsAdapter$Companion */
    /* compiled from: SocialNotificationsAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BaseViewHolder<SocialNotification> createItemViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        switch (i) {
            case TYPE_BASIC /*563*/:
                SocialBasicNotificationItemBinding inflate = SocialBasicNotificationItemBinding.inflate(layoutInflater, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "SocialBasicNotificationI…(inflater, parent, false)");
                return new BasicNotificationViewHolder(this, inflate);
            case TYPE_USER_FOLLOWED /*564*/:
                SocialUserFollowedNotificationItemBinding inflate2 = SocialUserFollowedNotificationItemBinding.inflate(layoutInflater, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate2, "SocialUserFollowedNotifi…(inflater, parent, false)");
                return new UserFollowedNotificationViewHolder(this, inflate2);
            case TYPE_NEW_POST /*565*/:
            case TYPE_LIKED_POST /*566*/:
            case TYPE_LIKED_COMMENT /*567*/:
            case TYPE_COMMENTED_ON_POST /*568*/:
            case TYPE_MENTIONED_IN_COMMENT /*569*/:
            case TYPE_TAGGED_IN_POST /*570*/:
                SocialPostNotificationItemBinding inflate3 = SocialPostNotificationItemBinding.inflate(layoutInflater, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate3, "SocialPostNotificationIt…(inflater, parent, false)");
                return new PostNotificationViewHolder(this, inflate3);
            default:
                throw new RuntimeException("Unknown view type: " + i);
        }
    }

    public final void applyUpdate(FollowUserResult followUserResult) {
        Intrinsics.checkNotNullParameter(followUserResult, "result");
        int i = 0;
        for (SocialNotification authorId : getItems()) {
            if (Intrinsics.areEqual((Object) authorId.getAuthorId(), (Object) followUserResult.getUserId())) {
                notifyItemChanged(i, new AdapterViewHolderPayload(PAYLOAD_AUTHOR_FOLLOWED_CHANGED, followUserResult));
            }
            i++;
        }
    }

    public final void consume(UserFollowEvent userFollowEvent) {
        Intrinsics.checkNotNullParameter(userFollowEvent, "event");
        applyUpdate(new FollowUserResult(userFollowEvent.getUserId(), userFollowEvent.getFollowed(), userFollowEvent.getFollowerCount()));
    }

    public final void consume(PostDeletedEvent postDeletedEvent) {
        Intrinsics.checkNotNullParameter(postDeletedEvent, "event");
        int i = 0;
        for (SocialNotification dataId : getItems()) {
            if (Intrinsics.areEqual((Object) dataId.getDataId(), (Object) postDeletedEvent.getPostId())) {
                removeItemAt(i);
            }
            i++;
        }
    }

    public int getItemViewType(int i) {
        SocialNotification socialNotification = (SocialNotification) getItemAt(i);
        String type = socialNotification != null ? socialNotification.getType() : null;
        if (type == null) {
            return super.getItemViewType(i);
        }
        switch (type.hashCode()) {
            case -2026051844:
                if (type.equals(SocialNotificationType.USER_FOLLOWED)) {
                    return TYPE_USER_FOLLOWED;
                }
                break;
            case -1548158150:
                if (type.equals(SocialNotificationType.TAGGED_IN_POST)) {
                    return TYPE_TAGGED_IN_POST;
                }
                break;
            case -770860482:
                if (type.equals(SocialNotificationType.COMMENTED_ON_POST)) {
                    return TYPE_COMMENTED_ON_POST;
                }
                break;
            case -540685729:
                if (type.equals(SocialNotificationType.NEW_POST)) {
                    return TYPE_NEW_POST;
                }
                break;
            case -532119187:
                if (type.equals(SocialNotificationType.LIKED_COMMENT)) {
                    return TYPE_LIKED_COMMENT;
                }
                break;
            case 1103602871:
                if (type.equals(SocialNotificationType.LIKED_POST)) {
                    return TYPE_LIKED_POST;
                }
                break;
            case 1303050422:
                if (type.equals(SocialNotificationType.MENTIONED_IN_COMMENT)) {
                    return TYPE_MENTIONED_IN_COMMENT;
                }
                break;
        }
        return TYPE_BASIC;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Lcom/memes/plus/ui/social_notifications/SocialNotificationsAdapter$BasicNotificationViewHolder;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "Lcom/memes/plus/ui/social_notifications/SocialNotification;", "binding", "Lcom/memes/plus/databinding/SocialBasicNotificationItemBinding;", "(Lcom/memes/plus/ui/social_notifications/SocialNotificationsAdapter;Lcom/memes/plus/databinding/SocialBasicNotificationItemBinding;)V", "notification", "setItem", "", "item", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.social_notifications.SocialNotificationsAdapter$BasicNotificationViewHolder */
    /* compiled from: SocialNotificationsAdapter.kt */
    public final class BasicNotificationViewHolder extends BaseViewHolder<SocialNotification> {
        private final SocialBasicNotificationItemBinding binding;
        /* access modifiers changed from: private */
        public SocialNotification notification;
        final /* synthetic */ SocialNotificationsAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public BasicNotificationViewHolder(com.memes.plus.p040ui.social_notifications.SocialNotificationsAdapter r2, com.memes.plus.databinding.SocialBasicNotificationItemBinding r3) {
            /*
                r1 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r1.this$0 = r2
                android.widget.LinearLayout r2 = r3.getRoot()
                java.lang.String r0 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
                android.view.View r2 = (android.view.View) r2
                r1.<init>(r2)
                r1.binding = r3
                android.widget.LinearLayout r2 = r3.getRoot()
                com.memes.plus.ui.social_notifications.SocialNotificationsAdapter$BasicNotificationViewHolder$1 r3 = new com.memes.plus.ui.social_notifications.SocialNotificationsAdapter$BasicNotificationViewHolder$1
                r3.<init>(r1)
                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
                r2.setOnClickListener(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.social_notifications.SocialNotificationsAdapter.BasicNotificationViewHolder.<init>(com.memes.plus.ui.social_notifications.SocialNotificationsAdapter, com.memes.plus.databinding.SocialBasicNotificationItemBinding):void");
        }

        public static final /* synthetic */ SocialNotification access$getNotification$p(BasicNotificationViewHolder basicNotificationViewHolder) {
            SocialNotification socialNotification = basicNotificationViewHolder.notification;
            if (socialNotification == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notification");
            }
            return socialNotification;
        }

        public void setItem(SocialNotification socialNotification) {
            Intrinsics.checkNotNullParameter(socialNotification, "item");
            this.notification = socialNotification;
            this.binding.notificationAuthorImageView.setProUser(socialNotification.isProUser());
            UserAvatarView userAvatarView = this.binding.notificationAuthorImageView;
            SocialNotification socialNotification2 = this.notification;
            if (socialNotification2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notification");
            }
            UserAvatarView.loadUrl$default(userAvatarView, socialNotification2.getAuthorProfilePicUrlThumb(), C4199R.C4202drawable.placeholder_profile, (Integer) null, 4, (Object) null);
            TextView textView = this.binding.notificationTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.notificationTextView");
            SocialNotification socialNotification3 = this.notification;
            if (socialNotification3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notification");
            }
            textView.setText(socialNotification3.getMessage());
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\bH\u0002J\u0016\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Lcom/memes/plus/ui/social_notifications/SocialNotificationsAdapter$UserFollowedNotificationViewHolder;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "Lcom/memes/plus/ui/social_notifications/SocialNotification;", "binding", "Lcom/memes/plus/databinding/SocialUserFollowedNotificationItemBinding;", "(Lcom/memes/plus/ui/social_notifications/SocialNotificationsAdapter;Lcom/memes/plus/databinding/SocialUserFollowedNotificationItemBinding;)V", "notification", "setItem", "", "item", "showAuthorFollowedInformation", "updateWithPayload", "payloads", "", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.social_notifications.SocialNotificationsAdapter$UserFollowedNotificationViewHolder */
    /* compiled from: SocialNotificationsAdapter.kt */
    public final class UserFollowedNotificationViewHolder extends BaseViewHolder<SocialNotification> {
        private final SocialUserFollowedNotificationItemBinding binding;
        /* access modifiers changed from: private */
        public SocialNotification notification;
        final /* synthetic */ SocialNotificationsAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public UserFollowedNotificationViewHolder(com.memes.plus.p040ui.social_notifications.SocialNotificationsAdapter r2, com.memes.plus.databinding.SocialUserFollowedNotificationItemBinding r3) {
            /*
                r1 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r1.this$0 = r2
                android.widget.LinearLayout r2 = r3.getRoot()
                java.lang.String r0 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
                android.view.View r2 = (android.view.View) r2
                r1.<init>(r2)
                r1.binding = r3
                android.widget.LinearLayout r2 = r3.getRoot()
                com.memes.plus.ui.social_notifications.SocialNotificationsAdapter$UserFollowedNotificationViewHolder$1 r0 = new com.memes.plus.ui.social_notifications.SocialNotificationsAdapter$UserFollowedNotificationViewHolder$1
                r0.<init>(r1)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r2.setOnClickListener(r0)
                android.widget.Button r2 = r3.authorToggleFollowButton
                com.memes.plus.ui.social_notifications.SocialNotificationsAdapter$UserFollowedNotificationViewHolder$2 r3 = new com.memes.plus.ui.social_notifications.SocialNotificationsAdapter$UserFollowedNotificationViewHolder$2
                r3.<init>(r1)
                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
                r2.setOnClickListener(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.social_notifications.SocialNotificationsAdapter.UserFollowedNotificationViewHolder.<init>(com.memes.plus.ui.social_notifications.SocialNotificationsAdapter, com.memes.plus.databinding.SocialUserFollowedNotificationItemBinding):void");
        }

        public static final /* synthetic */ SocialNotification access$getNotification$p(UserFollowedNotificationViewHolder userFollowedNotificationViewHolder) {
            SocialNotification socialNotification = userFollowedNotificationViewHolder.notification;
            if (socialNotification == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notification");
            }
            return socialNotification;
        }

        public void setItem(SocialNotification socialNotification) {
            Intrinsics.checkNotNullParameter(socialNotification, "item");
            this.notification = socialNotification;
            this.binding.notificationAuthorImageView.setProUser(socialNotification.isProUser());
            UserAvatarView userAvatarView = this.binding.notificationAuthorImageView;
            SocialNotification socialNotification2 = this.notification;
            if (socialNotification2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notification");
            }
            UserAvatarView.loadUrl$default(userAvatarView, socialNotification2.getAuthorProfilePicUrlThumb(), C4199R.C4202drawable.placeholder_profile, (Integer) null, 4, (Object) null);
            TextView textView = this.binding.notificationTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.notificationTextView");
            SocialNotification socialNotification3 = this.notification;
            if (socialNotification3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notification");
            }
            textView.setText(socialNotification3.getMessage());
            showAuthorFollowedInformation();
        }

        private final void showAuthorFollowedInformation() {
            SocialNotification socialNotification = this.notification;
            if (socialNotification == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notification");
            }
            if (socialNotification.getAuthorFollowed()) {
                Button button = this.binding.authorToggleFollowButton;
                Intrinsics.checkNotNullExpressionValue(button, "binding.authorToggleFollowButton");
                button.setBackgroundTintList(ContextCompat.getColorStateList(this.this$0.context, C4199R.C4201color.primary_background_lighter));
                this.binding.authorToggleFollowButton.setText(C4199R.string.following);
                return;
            }
            Button button2 = this.binding.authorToggleFollowButton;
            Intrinsics.checkNotNullExpressionValue(button2, "binding.authorToggleFollowButton");
            button2.setBackgroundTintList(ContextCompat.getColorStateList(this.this$0.context, C4199R.C4201color.colorRealAccent));
            this.binding.authorToggleFollowButton.setText(C4199R.string.follow);
        }

        public void updateWithPayload(List<Object> list) {
            Intrinsics.checkNotNullParameter(list, "payloads");
            for (Object next : list) {
                if (next instanceof AdapterViewHolderPayload) {
                    AdapterViewHolderPayload adapterViewHolderPayload = (AdapterViewHolderPayload) next;
                    if (Intrinsics.areEqual((Object) adapterViewHolderPayload.getKey(), (Object) SocialNotificationsAdapter.PAYLOAD_AUTHOR_FOLLOWED_CHANGED)) {
                        Object value = adapterViewHolderPayload.getValue();
                        Objects.requireNonNull(value, "null cannot be cast to non-null type com.memes.plus.ui.posts.post_basics.follow_user.FollowUserResult");
                        FollowUserResult followUserResult = (FollowUserResult) value;
                        SocialNotification socialNotification = this.notification;
                        if (socialNotification == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("notification");
                        }
                        socialNotification.setAuthorFollowed(followUserResult.getFollowed());
                        showAuthorFollowedInformation();
                        return;
                    }
                }
            }
            super.updateWithPayload(list);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Lcom/memes/plus/ui/social_notifications/SocialNotificationsAdapter$PostNotificationViewHolder;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "Lcom/memes/plus/ui/social_notifications/SocialNotification;", "binding", "Lcom/memes/plus/databinding/SocialPostNotificationItemBinding;", "(Lcom/memes/plus/ui/social_notifications/SocialNotificationsAdapter;Lcom/memes/plus/databinding/SocialPostNotificationItemBinding;)V", "notification", "setItem", "", "item", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.social_notifications.SocialNotificationsAdapter$PostNotificationViewHolder */
    /* compiled from: SocialNotificationsAdapter.kt */
    public final class PostNotificationViewHolder extends BaseViewHolder<SocialNotification> {
        private final SocialPostNotificationItemBinding binding;
        /* access modifiers changed from: private */
        public SocialNotification notification;
        final /* synthetic */ SocialNotificationsAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public PostNotificationViewHolder(com.memes.plus.p040ui.social_notifications.SocialNotificationsAdapter r2, com.memes.plus.databinding.SocialPostNotificationItemBinding r3) {
            /*
                r1 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r1.this$0 = r2
                android.widget.LinearLayout r2 = r3.getRoot()
                java.lang.String r0 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
                android.view.View r2 = (android.view.View) r2
                r1.<init>(r2)
                r1.binding = r3
                android.widget.LinearLayout r2 = r3.getRoot()
                com.memes.plus.ui.social_notifications.SocialNotificationsAdapter$PostNotificationViewHolder$1 r0 = new com.memes.plus.ui.social_notifications.SocialNotificationsAdapter$PostNotificationViewHolder$1
                r0.<init>(r1)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r2.setOnClickListener(r0)
                android.widget.ImageView r2 = r3.notificationContentImageView
                com.memes.plus.ui.social_notifications.SocialNotificationsAdapter$PostNotificationViewHolder$2 r3 = new com.memes.plus.ui.social_notifications.SocialNotificationsAdapter$PostNotificationViewHolder$2
                r3.<init>(r1)
                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
                r2.setOnClickListener(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.social_notifications.SocialNotificationsAdapter.PostNotificationViewHolder.<init>(com.memes.plus.ui.social_notifications.SocialNotificationsAdapter, com.memes.plus.databinding.SocialPostNotificationItemBinding):void");
        }

        public static final /* synthetic */ SocialNotification access$getNotification$p(PostNotificationViewHolder postNotificationViewHolder) {
            SocialNotification socialNotification = postNotificationViewHolder.notification;
            if (socialNotification == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notification");
            }
            return socialNotification;
        }

        public void setItem(SocialNotification socialNotification) {
            Intrinsics.checkNotNullParameter(socialNotification, "item");
            this.notification = socialNotification;
            this.binding.notificationAuthorImageView.setProUser(socialNotification.isProUser());
            UserAvatarView userAvatarView = this.binding.notificationAuthorImageView;
            SocialNotification socialNotification2 = this.notification;
            if (socialNotification2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notification");
            }
            UserAvatarView.loadUrl$default(userAvatarView, socialNotification2.getAuthorProfilePicUrlThumb(), C4199R.C4202drawable.placeholder_profile, (Integer) null, 4, (Object) null);
            TextView textView = this.binding.notificationTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.notificationTextView");
            SocialNotification socialNotification3 = this.notification;
            if (socialNotification3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notification");
            }
            textView.setText(socialNotification3.getMessage());
            Picasso picasso = Picasso.get();
            Intrinsics.checkNotNullExpressionValue(picasso, "Picasso.get()");
            SocialNotification socialNotification4 = this.notification;
            if (socialNotification4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notification");
            }
            Picasso log = PicassoExtKt.log(picasso, (Object) this, socialNotification4.getPostThumbUrl(), "binding.notificationContentImageView");
            SocialNotification socialNotification5 = this.notification;
            if (socialNotification5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notification");
            }
            log.load(socialNotification5.getPostThumbUrl()).placeholder((int) C4199R.C4201color.primary_background_lighter).error((int) C4199R.C4201color.primary_background_lighter).fit().into(this.binding.notificationContentImageView);
        }
    }
}
