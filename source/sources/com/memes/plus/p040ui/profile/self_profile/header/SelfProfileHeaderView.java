package com.memes.plus.p040ui.profile.self_profile.header;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.memes.commons.util.PrettyCounter;
import com.memes.plus.C4199R;
import com.memes.plus.custom.UserAvatarView;
import com.memes.plus.databinding.SelfProfileHeaderViewBinding;
import com.memes.plus.p040ui.auth.auth_prompt.MagicalTypefaceSpan;
import com.memes.plus.p040ui.profile.UserNameGradientTextView;
import com.memes.plus.p040ui.profile.self_profile.SelfProfile;
import com.memes.plus.util.picasso.PicassoExtKt;
import com.squareup.picasso.Picasso;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001#B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u001a\u0010\u001d\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0018H\u0014J\u0010\u0010!\u001a\u00020\u00182\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u001a\u0010\"\u001a\u00020\u00182\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eR\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, mo26107d2 = {"Lcom/memes/plus/ui/profile/self_profile/header/SelfProfileHeaderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/memes/plus/databinding/SelfProfileHeaderViewBinding;", "getBinding", "()Lcom/memes/plus/databinding/SelfProfileHeaderViewBinding;", "binding$delegate", "Lkotlin/Lazy;", "boldTypeface", "Landroid/graphics/Typeface;", "callback", "Lcom/memes/plus/ui/profile/self_profile/header/SelfProfileHeaderView$Callback;", "plainTypeface", "createStatString", "Landroid/text/Spannable;", "statCountStr", "", "statTitleSnippet", "loadCoverImage", "", "imagePath", "loadProfile", "profile", "Lcom/memes/plus/ui/profile/self_profile/SelfProfile;", "loadProfileImage", "isProUser", "", "onFinishInflate", "setCallback", "setTypefaces", "Callback", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.self_profile.header.SelfProfileHeaderView */
/* compiled from: SelfProfileHeaderView.kt */
public final class SelfProfileHeaderView extends ConstraintLayout {
    private final Lazy binding$delegate;
    private Typeface boldTypeface;
    /* access modifiers changed from: private */
    public Callback callback;
    private Typeface plainTypeface;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/ui/profile/self_profile/header/SelfProfileHeaderView$Callback;", "", "onFollowerCountTapped", "", "onFollowingCountTapped", "onProfileOptionsTapped", "onProfilePicTapped", "path", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.profile.self_profile.header.SelfProfileHeaderView$Callback */
    /* compiled from: SelfProfileHeaderView.kt */
    public interface Callback {
        void onFollowerCountTapped();

        void onFollowingCountTapped();

        void onProfileOptionsTapped();

        void onProfilePicTapped(String str);
    }

    private final SelfProfileHeaderViewBinding getBinding() {
        return (SelfProfileHeaderViewBinding) this.binding$delegate.getValue();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SelfProfileHeaderView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelfProfileHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.binding$delegate = LazyKt.lazy(new SelfProfileHeaderView$binding$2(this, context));
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        getBinding();
        super.onFinishInflate();
        getBinding().profileOptionsImageView.setOnClickListener(new SelfProfileHeaderView$onFinishInflate$1(this));
        getBinding().profileImageView.setOnClickListener((View.OnClickListener) null);
        getBinding().followingCountTextView.setOnClickListener(new SelfProfileHeaderView$onFinishInflate$2(this));
        getBinding().followerCountTextView.setOnClickListener(new SelfProfileHeaderView$onFinishInflate$3(this));
    }

    public final void setTypefaces(Typeface typeface, Typeface typeface2) {
        this.boldTypeface = typeface;
        this.plainTypeface = typeface2;
    }

    public final void setCallback(Callback callback2) {
        this.callback = callback2;
    }

    public final void loadProfile(SelfProfile selfProfile) {
        if (selfProfile != null) {
            ImageView imageView = getBinding().profileOptionsImageView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.profileOptionsImageView");
            imageView.setVisibility(8);
            TextView textView = getBinding().followingCountTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.followingCountTextView");
            String following = selfProfile.getFollowing();
            String string = getContext().getString(C4199R.string.following);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.following)");
            textView.setText(createStatString(following, string));
            TextView textView2 = getBinding().followerCountTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.followerCountTextView");
            String follower = selfProfile.getFollower();
            String string2 = getContext().getString(C4199R.string.followers);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.followers)");
            textView2.setText(createStatString(follower, string2));
            TextView textView3 = getBinding().postCountTextView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.postCountTextView");
            String totalPosts = selfProfile.getTotalPosts();
            String string3 = getContext().getString(C4199R.string.posts);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.string.posts)");
            textView3.setText(createStatString(totalPosts, string3));
            TextView textView4 = getBinding().likeCountTextView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.likeCountTextView");
            String totallikes = selfProfile.getTotallikes();
            String string4 = getContext().getString(C4199R.string.likes);
            Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.string.likes)");
            textView4.setText(createStatString(totallikes, string4));
            UserNameGradientTextView userNameGradientTextView = getBinding().usernameTextView;
            Intrinsics.checkNotNullExpressionValue(userNameGradientTextView, "binding.usernameTextView");
            userNameGradientTextView.setText(selfProfile.getUsername());
            getBinding().usernameTextView.setProUser(selfProfile.isProUser());
            loadProfileImage(selfProfile.getProfileImage(), selfProfile.isProUser());
            loadCoverImage(selfProfile.getCoverImage());
        }
    }

    private final void loadProfileImage(String str, boolean z) {
        getBinding().profileImageView.setProUser(z);
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            getBinding().profileImageView.loadDrawable(C4199R.C4202drawable.placeholder_profile);
            getBinding().profileImageView.setOnClickListener((View.OnClickListener) null);
            return;
        }
        UserAvatarView.loadUrl$default(getBinding().profileImageView, str, C4199R.C4202drawable.placeholder_profile, (Integer) null, 4, (Object) null);
        getBinding().profileImageView.setOnClickListener(new SelfProfileHeaderView$loadProfileImage$1(this, str));
    }

    private final void loadCoverImage(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            getBinding().coverImageView.setImageResource(0);
            return;
        }
        Picasso picasso = Picasso.get();
        Intrinsics.checkNotNullExpressionValue(picasso, "Picasso.get()");
        PicassoExtKt.log(picasso, (Object) this, str, "binding.coverImageView").load(str).placeholder((int) C4199R.C4201color.MemeBackgroundcolor).error((int) C4199R.C4201color.MemeBackgroundcolor).into(getBinding().coverImageView);
    }

    private final Spannable createStatString(String str, String str2) {
        String apply$default = PrettyCounter.apply$default(PrettyCounter.INSTANCE, str, false, 2, (Object) null);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Appendable append = spannableStringBuilder.append(apply$default);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        Intrinsics.checkNotNullExpressionValue(append.append(10), "append('\\n')");
        spannableStringBuilder.append(str2);
        SpannableString valueOf = SpannableString.valueOf(new SpannedString(spannableStringBuilder));
        Intrinsics.checkExpressionValueIsNotNull(valueOf, "SpannableString.valueOf(this)");
        Spannable spannable = valueOf;
        CharSequence charSequence = spannable;
        int indexOf$default = StringsKt.indexOf$default(charSequence, apply$default, 0, false, 6, (Object) null);
        int indexOf$default2 = StringsKt.indexOf$default(charSequence, str2, 0, false, 6, (Object) null);
        int length = str2.length() + indexOf$default2;
        spannable.setSpan(new MagicalTypefaceSpan(this.boldTypeface), indexOf$default, apply$default.length() + indexOf$default, 17);
        spannable.setSpan(new MagicalTypefaceSpan(this.plainTypeface), indexOf$default2, length, 17);
        spannable.setSpan(new RelativeSizeSpan(0.65f), indexOf$default2, length, 17);
        spannable.setSpan(new ForegroundColorSpan(Color.parseColor("#88FFFFFF")), indexOf$default2, length, 17);
        return spannable;
    }
}
