package com.memes.plus.p040ui.posts.suggestions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.memes.commons.recycleradapter.AdapterViewHolderPayload;
import com.memes.commons.recycleradapter.BaseRecyclerAdapter;
import com.memes.commons.recycleradapter.BaseViewHolder;
import com.memes.plus.C4199R;
import com.memes.plus.custom.UserAvatarView;
import com.memes.plus.databinding.PostSuggestedProfileItemBinding;
import com.memes.plus.p040ui.suggestions.SuggestedProfile;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0003\u0013\u0014\u0015B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ$\u0010\t\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/suggestions/PostSuggestedProfilesAdapter;", "Lcom/memes/commons/recycleradapter/BaseRecyclerAdapter;", "Lcom/memes/plus/ui/suggestions/SuggestedProfile;", "Lcom/memes/plus/ui/posts/suggestions/PostSuggestedProfilesAdapter$SuggestedProfileViewHolder;", "context", "Landroid/content/Context;", "callback", "Lcom/memes/plus/ui/posts/suggestions/PostSuggestedProfilesAdapter$Callback;", "(Landroid/content/Context;Lcom/memes/plus/ui/posts/suggestions/PostSuggestedProfilesAdapter$Callback;)V", "createItemViewHolder", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "updateFollow", "", "updatedProfile", "Callback", "Companion", "SuggestedProfileViewHolder", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.suggestions.PostSuggestedProfilesAdapter */
/* compiled from: PostSuggestedProfilesAdapter.kt */
public final class PostSuggestedProfilesAdapter extends BaseRecyclerAdapter<SuggestedProfile, SuggestedProfileViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String PAYLOAD_FOLLOW_CHANGE = "payload_follow_change";
    /* access modifiers changed from: private */
    public final Callback callback;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/suggestions/PostSuggestedProfilesAdapter$Callback;", "", "onFollowSuggestedProfileTapped", "", "profile", "Lcom/memes/plus/ui/suggestions/SuggestedProfile;", "onSuggestedProfileTapped", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.suggestions.PostSuggestedProfilesAdapter$Callback */
    /* compiled from: PostSuggestedProfilesAdapter.kt */
    public interface Callback {
        void onFollowSuggestedProfileTapped(SuggestedProfile suggestedProfile);

        void onSuggestedProfileTapped(SuggestedProfile suggestedProfile);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PostSuggestedProfilesAdapter(Context context, Callback callback2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : callback2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PostSuggestedProfilesAdapter(Context context, Callback callback2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.callback = callback2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/suggestions/PostSuggestedProfilesAdapter$Companion;", "", "()V", "PAYLOAD_FOLLOW_CHANGE", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.suggestions.PostSuggestedProfilesAdapter$Companion */
    /* compiled from: PostSuggestedProfilesAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SuggestedProfileViewHolder createItemViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        PostSuggestedProfileItemBinding inflate = PostSuggestedProfileItemBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "PostSuggestedProfileItem…(inflater, parent, false)");
        return new SuggestedProfileViewHolder(this, inflate);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\bH\u0002J\u0016\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/suggestions/PostSuggestedProfilesAdapter$SuggestedProfileViewHolder;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "Lcom/memes/plus/ui/suggestions/SuggestedProfile;", "binding", "Lcom/memes/plus/databinding/PostSuggestedProfileItemBinding;", "(Lcom/memes/plus/ui/posts/suggestions/PostSuggestedProfilesAdapter;Lcom/memes/plus/databinding/PostSuggestedProfileItemBinding;)V", "profile", "setItem", "", "item", "showFollowStatus", "updateWithPayload", "payloads", "", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.suggestions.PostSuggestedProfilesAdapter$SuggestedProfileViewHolder */
    /* compiled from: PostSuggestedProfilesAdapter.kt */
    public final class SuggestedProfileViewHolder extends BaseViewHolder<SuggestedProfile> {
        private final PostSuggestedProfileItemBinding binding;
        /* access modifiers changed from: private */
        public SuggestedProfile profile;
        final /* synthetic */ PostSuggestedProfilesAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public SuggestedProfileViewHolder(com.memes.plus.p040ui.posts.suggestions.PostSuggestedProfilesAdapter r2, com.memes.plus.databinding.PostSuggestedProfileItemBinding r3) {
            /*
                r1 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r1.this$0 = r2
                androidx.cardview.widget.CardView r2 = r3.getRoot()
                java.lang.String r0 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
                android.view.View r2 = (android.view.View) r2
                r1.<init>(r2)
                r1.binding = r3
                androidx.cardview.widget.CardView r2 = r3.getRoot()
                com.memes.plus.ui.posts.suggestions.PostSuggestedProfilesAdapter$SuggestedProfileViewHolder$1 r0 = new com.memes.plus.ui.posts.suggestions.PostSuggestedProfilesAdapter$SuggestedProfileViewHolder$1
                r0.<init>(r1)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r2.setOnClickListener(r0)
                android.widget.Button r2 = r3.followButton
                com.memes.plus.ui.posts.suggestions.PostSuggestedProfilesAdapter$SuggestedProfileViewHolder$2 r3 = new com.memes.plus.ui.posts.suggestions.PostSuggestedProfilesAdapter$SuggestedProfileViewHolder$2
                r3.<init>(r1)
                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
                r2.setOnClickListener(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.posts.suggestions.PostSuggestedProfilesAdapter.SuggestedProfileViewHolder.<init>(com.memes.plus.ui.posts.suggestions.PostSuggestedProfilesAdapter, com.memes.plus.databinding.PostSuggestedProfileItemBinding):void");
        }

        public static final /* synthetic */ SuggestedProfile access$getProfile$p(SuggestedProfileViewHolder suggestedProfileViewHolder) {
            SuggestedProfile suggestedProfile = suggestedProfileViewHolder.profile;
            if (suggestedProfile == null) {
                Intrinsics.throwUninitializedPropertyAccessException(Scopes.PROFILE);
            }
            return suggestedProfile;
        }

        public void setItem(SuggestedProfile suggestedProfile) {
            Intrinsics.checkNotNullParameter(suggestedProfile, "item");
            this.profile = suggestedProfile;
            this.binding.profilePicImageView.setProUser(suggestedProfile.isProUser());
            SuggestedProfile suggestedProfile2 = this.profile;
            if (suggestedProfile2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(Scopes.PROFILE);
            }
            UserAvatarView.loadUrl$default(this.binding.profilePicImageView, suggestedProfile2.getProfileImageThumb(), C4199R.C4201color.primary_background_lighter, (Integer) null, 4, (Object) null);
            TextView textView = this.binding.userNameTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.userNameTextView");
            SuggestedProfile suggestedProfile3 = this.profile;
            if (suggestedProfile3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(Scopes.PROFILE);
            }
            textView.setText(suggestedProfile3.getUsername());
            showFollowStatus();
        }

        private final void showFollowStatus() {
            Button button = this.binding.followButton;
            SuggestedProfile suggestedProfile = this.profile;
            if (suggestedProfile == null) {
                Intrinsics.throwUninitializedPropertyAccessException(Scopes.PROFILE);
            }
            button.setText(suggestedProfile.getIamFollowing() ? C4199R.string.following : C4199R.string.follow);
            SuggestedProfile suggestedProfile2 = this.profile;
            if (suggestedProfile2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(Scopes.PROFILE);
            }
            if (suggestedProfile2.getIamFollowing()) {
                this.binding.followButton.setBackgroundColor(this.this$0.getColor(C4199R.C4201color.dim_gray));
            } else {
                this.binding.followButton.setBackgroundColor(this.this$0.getColor(C4199R.C4201color.colorAccentDark));
            }
        }

        public void updateWithPayload(List<Object> list) {
            Intrinsics.checkNotNullParameter(list, "payloads");
            for (Object next : list) {
                if (next instanceof AdapterViewHolderPayload) {
                    AdapterViewHolderPayload adapterViewHolderPayload = (AdapterViewHolderPayload) next;
                    if (Intrinsics.areEqual((Object) adapterViewHolderPayload.getKey(), (Object) "payload_follow_change")) {
                        Object value = adapterViewHolderPayload.getValue();
                        Objects.requireNonNull(value, "null cannot be cast to non-null type com.memes.plus.ui.suggestions.SuggestedProfile");
                        SuggestedProfile suggestedProfile = (SuggestedProfile) value;
                        SuggestedProfile suggestedProfile2 = this.profile;
                        if (suggestedProfile2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(Scopes.PROFILE);
                        }
                        suggestedProfile2.setIamFollowing(suggestedProfile.getIamFollowing());
                        showFollowStatus();
                    }
                }
            }
        }
    }

    public final void updateFollow(SuggestedProfile suggestedProfile) {
        Intrinsics.checkNotNullParameter(suggestedProfile, "updatedProfile");
        int i = 0;
        for (SuggestedProfile suggestedProfile2 : getItems()) {
            if (Intrinsics.areEqual((Object) suggestedProfile2.getUserId(), (Object) suggestedProfile.getUserId())) {
                notifyItemChanged(i, new AdapterViewHolderPayload("payload_follow_change", suggestedProfile2));
                return;
            }
            i++;
        }
    }
}
