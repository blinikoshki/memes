package com.memes.plus.p040ui.user_listing;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.facebook.internal.AnalyticsEvents;
import com.memes.commons.recycleradapter.AdapterViewHolderPayload;
import com.memes.commons.recycleradapter.BaseRecyclerAdapter;
import com.memes.commons.recycleradapter.BaseViewHolder;
import com.memes.network.memes.MemesSession;
import com.memes.plus.C4199R;
import com.memes.plus.custom.UserAvatarView;
import com.memes.plus.databinding.UserListingItemBinding;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001:\u0003\u0013\u0014\u0015B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ&\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo26107d2 = {"Lcom/memes/plus/ui/user_listing/UsersListingAdapter;", "Lcom/memes/commons/recycleradapter/BaseRecyclerAdapter;", "Lcom/memes/plus/ui/user_listing/ListedUser;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "context", "Landroid/content/Context;", "callback", "Lcom/memes/plus/ui/user_listing/UsersListingAdapter$Callback;", "(Landroid/content/Context;Lcom/memes/plus/ui/user_listing/UsersListingAdapter$Callback;)V", "createItemViewHolder", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "updateUser", "", "updatedUser", "Callback", "Companion", "UserViewHolder", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.user_listing.UsersListingAdapter */
/* compiled from: UsersListingAdapter.kt */
public final class UsersListingAdapter extends BaseRecyclerAdapter<ListedUser, BaseViewHolder<ListedUser>> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PAYLOAD_TOGGLE_FOLLOW = "payload_toggle_follow";
    /* access modifiers changed from: private */
    public final Callback callback;
    /* access modifiers changed from: private */
    public final Context context;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/ui/user_listing/UsersListingAdapter$Callback;", "", "onProfileImageTapped", "", "user", "Lcom/memes/plus/ui/user_listing/ListedUser;", "onToggleFollowButtonTapped", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.user_listing.UsersListingAdapter$Callback */
    /* compiled from: UsersListingAdapter.kt */
    public interface Callback {
        void onProfileImageTapped(ListedUser listedUser);

        void onToggleFollowButtonTapped(ListedUser listedUser);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UsersListingAdapter(Context context2, Callback callback2) {
        super(context2);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.context = context2;
        this.callback = callback2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/plus/ui/user_listing/UsersListingAdapter$Companion;", "", "()V", "PAYLOAD_TOGGLE_FOLLOW", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.user_listing.UsersListingAdapter$Companion */
    /* compiled from: UsersListingAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BaseViewHolder<ListedUser> createItemViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        UserListingItemBinding inflate = UserListingItemBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "UserListingItemBinding.i…(inflater, parent, false)");
        return new UserViewHolder(this, inflate);
    }

    public final void updateUser(ListedUser listedUser) {
        Intrinsics.checkNotNullParameter(listedUser, "updatedUser");
        int i = 0;
        for (ListedUser userId : getItems()) {
            if (Intrinsics.areEqual((Object) userId.getUserId(), (Object) listedUser.getUserId())) {
                notifyItemChanged(i, new AdapterViewHolderPayload(PAYLOAD_TOGGLE_FOLLOW, listedUser));
                return;
            }
            i++;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\u0016\u0010\u000e\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo26107d2 = {"Lcom/memes/plus/ui/user_listing/UsersListingAdapter$UserViewHolder;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "Lcom/memes/plus/ui/user_listing/ListedUser;", "binding", "Lcom/memes/plus/databinding/UserListingItemBinding;", "(Lcom/memes/plus/ui/user_listing/UsersListingAdapter;Lcom/memes/plus/databinding/UserListingItemBinding;)V", "getBinding", "()Lcom/memes/plus/databinding/UserListingItemBinding;", "user", "setItem", "", "item", "showFollowingStatus", "showProfileImage", "updateWithPayload", "payloads", "", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.user_listing.UsersListingAdapter$UserViewHolder */
    /* compiled from: UsersListingAdapter.kt */
    public class UserViewHolder extends BaseViewHolder<ListedUser> {
        private final UserListingItemBinding binding;
        final /* synthetic */ UsersListingAdapter this$0;
        /* access modifiers changed from: private */
        public ListedUser user;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public UserViewHolder(com.memes.plus.p040ui.user_listing.UsersListingAdapter r2, com.memes.plus.databinding.UserListingItemBinding r3) {
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
                com.memes.plus.custom.UserAvatarView r2 = r3.profilePicImageView
                com.memes.plus.ui.user_listing.UsersListingAdapter$UserViewHolder$1 r0 = new com.memes.plus.ui.user_listing.UsersListingAdapter$UserViewHolder$1
                r0.<init>(r1)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r2.setOnClickListener(r0)
                android.widget.TextView r2 = r3.fullNameTextview
                com.memes.plus.ui.user_listing.UsersListingAdapter$UserViewHolder$2 r0 = new com.memes.plus.ui.user_listing.UsersListingAdapter$UserViewHolder$2
                r0.<init>(r1)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r2.setOnClickListener(r0)
                android.widget.TextView r2 = r3.userNameTextview
                com.memes.plus.ui.user_listing.UsersListingAdapter$UserViewHolder$3 r0 = new com.memes.plus.ui.user_listing.UsersListingAdapter$UserViewHolder$3
                r0.<init>(r1)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r2.setOnClickListener(r0)
                android.widget.Button r2 = r3.followSwitchButton
                com.memes.plus.ui.user_listing.UsersListingAdapter$UserViewHolder$4 r0 = new com.memes.plus.ui.user_listing.UsersListingAdapter$UserViewHolder$4
                r0.<init>(r1)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r2.setOnClickListener(r0)
                android.widget.Button r2 = r3.removeButton
                com.memes.plus.ui.user_listing.UsersListingAdapter$UserViewHolder$5 r3 = new com.memes.plus.ui.user_listing.UsersListingAdapter$UserViewHolder$5
                r3.<init>(r1)
                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
                r2.setOnClickListener(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.user_listing.UsersListingAdapter.UserViewHolder.<init>(com.memes.plus.ui.user_listing.UsersListingAdapter, com.memes.plus.databinding.UserListingItemBinding):void");
        }

        public static final /* synthetic */ ListedUser access$getUser$p(UserViewHolder userViewHolder) {
            ListedUser listedUser = userViewHolder.user;
            if (listedUser == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
            }
            return listedUser;
        }

        public final UserListingItemBinding getBinding() {
            return this.binding;
        }

        public void setItem(ListedUser listedUser) {
            Intrinsics.checkNotNullParameter(listedUser, "item");
            this.user = listedUser;
            TextView textView = this.binding.userNameTextview;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.userNameTextview");
            ListedUser listedUser2 = this.user;
            if (listedUser2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
            }
            String username = listedUser2.getUsername();
            if (username == null) {
                username = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
            textView.setText(username);
            ListedUser listedUser3 = this.user;
            if (listedUser3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
            }
            CharSequence fullName = listedUser3.getFullName();
            if (fullName == null || fullName.length() == 0) {
                TextView textView2 = this.binding.fullNameTextview;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.fullNameTextview");
                textView2.setVisibility(8);
            } else {
                TextView textView3 = this.binding.fullNameTextview;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.fullNameTextview");
                ListedUser listedUser4 = this.user;
                if (listedUser4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("user");
                }
                textView3.setText(listedUser4.getFullName());
                TextView textView4 = this.binding.fullNameTextview;
                Intrinsics.checkNotNullExpressionValue(textView4, "binding.fullNameTextview");
                textView4.setVisibility(0);
            }
            showProfileImage();
            showFollowingStatus();
        }

        private final void showProfileImage() {
            UserAvatarView userAvatarView = this.binding.profilePicImageView;
            ListedUser listedUser = this.user;
            if (listedUser == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
            }
            userAvatarView.setProUser(listedUser.isProUser());
            ListedUser listedUser2 = this.user;
            if (listedUser2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
            }
            UserAvatarView.loadUrl$default(this.binding.profilePicImageView, listedUser2.getProfileImageThumbnailUrl(), C4199R.C4202drawable.placeholder_profile, (Integer) null, 4, (Object) null);
        }

        private final void showFollowingStatus() {
            MemesSession memesSession = MemesSession.INSTANCE;
            ListedUser listedUser = this.user;
            if (listedUser == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
            }
            if (memesSession.isOf(listedUser.getUserId())) {
                Button button = this.binding.followSwitchButton;
                Intrinsics.checkNotNullExpressionValue(button, "binding.followSwitchButton");
                button.setVisibility(8);
                return;
            }
            Button button2 = this.binding.followSwitchButton;
            Intrinsics.checkNotNullExpressionValue(button2, "binding.followSwitchButton");
            button2.setVisibility(0);
            ListedUser listedUser2 = this.user;
            if (listedUser2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
            }
            if (listedUser2.getIamfollowing()) {
                this.binding.followSwitchButton.setText(C4199R.string.following);
                Button button3 = this.binding.followSwitchButton;
                Intrinsics.checkNotNullExpressionValue(button3, "binding.followSwitchButton");
                button3.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this.this$0.context, C4199R.C4201color.darkbackgroundcolor)));
            } else {
                this.binding.followSwitchButton.setText(C4199R.string.follow);
                Button button4 = this.binding.followSwitchButton;
                Intrinsics.checkNotNullExpressionValue(button4, "binding.followSwitchButton");
                button4.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this.this$0.context, C4199R.C4201color.colorAccentDark)));
            }
            ListedUser listedUser3 = this.user;
            if (listedUser3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
            }
            if (listedUser3.getShouldShowCloseButton()) {
                Button button5 = this.binding.removeButton;
                Intrinsics.checkNotNullExpressionValue(button5, "binding.removeButton");
                button5.setVisibility(0);
                return;
            }
            Button button6 = this.binding.removeButton;
            Intrinsics.checkNotNullExpressionValue(button6, "binding.removeButton");
            button6.setVisibility(8);
        }

        public void updateWithPayload(List<Object> list) {
            Intrinsics.checkNotNullParameter(list, "payloads");
            for (Object next : list) {
                if (next instanceof AdapterViewHolderPayload) {
                    AdapterViewHolderPayload adapterViewHolderPayload = (AdapterViewHolderPayload) next;
                    if (Intrinsics.areEqual((Object) adapterViewHolderPayload.getKey(), (Object) UsersListingAdapter.PAYLOAD_TOGGLE_FOLLOW)) {
                        Object value = adapterViewHolderPayload.getValue();
                        Objects.requireNonNull(value, "null cannot be cast to non-null type com.memes.plus.ui.user_listing.ListedUser");
                        ListedUser listedUser = (ListedUser) value;
                        ListedUser listedUser2 = this.user;
                        if (listedUser2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("user");
                        }
                        listedUser2.setIamfollowing(listedUser.getIamfollowing());
                        showFollowingStatus();
                    }
                }
            }
        }
    }
}
