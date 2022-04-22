package com.memes.plus.p040ui.profile.user_profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.commons.contentlayout.NestedContentLayout;
import com.memes.commons.util.ExtensionsKt;
import com.memes.commons.util.PrettyCounter;
import com.memes.commons.viewmodel.BaseViewModelFactory;
import com.memes.plus.C4199R;
import com.memes.plus.base.ActivityHandle;
import com.memes.plus.base.BaseFragment;
import com.memes.plus.custom.UserAvatarView;
import com.memes.plus.databinding.UserProfileFragmentBinding;
import com.memes.plus.events.NotifiableEvent;
import com.memes.plus.events.UserFollowEvent;
import com.memes.plus.p040ui.posts.Post;
import com.memes.plus.p040ui.posts.PostsStaggeredAdapter;
import com.memes.plus.p040ui.posts.PostsStaggeredAdapterListener;
import com.memes.plus.p040ui.profile.ProfileOptionsDialog;
import com.memes.plus.p040ui.profile.UserNameGradientTextView;
import com.memes.plus.p040ui.profile.profile_posts.ProfilePostsFragment;
import com.memes.plus.util.LocalIntents;
import com.memes.plus.util.picasso.PicassoExtKt;
import com.squareup.picasso.Picasso;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 <2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001<B\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0002J\u001a\u0010\u001a\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u00020\u00122\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0012H\u0016J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0012H\u0016J\b\u0010,\u001a\u00020\u0012H\u0016J\u0018\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u000200H\u0016J\u0012\u00101\u001a\u00020\u00122\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0012\u00104\u001a\u00020\u00122\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0012\u00105\u001a\u00020\u00122\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00106\u001a\u00020\u0012H\u0002J\b\u00107\u001a\u00020\u0012H\u0002J\u0012\u00108\u001a\u00020\u00122\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\b\u0010;\u001a\u00020\u0012H\u0002R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000¨\u0006="}, mo26107d2 = {"Lcom/memes/plus/ui/profile/user_profile/UserProfileFragment;", "Lcom/memes/plus/base/BaseFragment;", "Lcom/memes/plus/databinding/UserProfileFragmentBinding;", "Lcom/memes/commons/contentlayout/ContentLayout$Callback;", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "Lcom/memes/plus/ui/posts/PostsStaggeredAdapterListener;", "Lcom/memes/plus/ui/profile/ProfileOptionsDialog$Callback;", "()V", "layoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "postsStaggeredAdapter", "Lcom/memes/plus/ui/posts/PostsStaggeredAdapter;", "targetUserId", "", "targetUserName", "viewModel", "Lcom/memes/plus/ui/profile/user_profile/UserProfileViewModel;", "afterViewCreated", "", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "loadCoverImage", "imagePath", "loadProfileImage", "isProUser", "", "onAttach", "context", "Landroid/content/Context;", "onBindingComplete", "savedInstanceState", "Landroid/os/Bundle;", "onBlockTapped", "onContentLayoutErrorResolutionButtonTapped", "who", "", "why", "onEventReceived", "event", "Lcom/memes/plus/events/NotifiableEvent;", "onObserversRequested", "onShareProfileTap", "onStaggeredPostTapped", "position", "post", "Lcom/memes/plus/ui/posts/Post;", "onTabReselected", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabSelected", "onTabUnselected", "showBlockedProfileUi", "showOptions", "showProfile", "userProfileResponse", "Lcom/memes/plus/ui/profile/user_profile/UserProfileResponse;", "showUnblockedProfileUi", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.user_profile.UserProfileFragment */
/* compiled from: UserProfileFragment.kt */
public final class UserProfileFragment extends BaseFragment<UserProfileFragmentBinding> implements ContentLayout.Callback, TabLayout.OnTabSelectedListener, PostsStaggeredAdapterListener, ProfileOptionsDialog.Callback {
    public static final String ARG_TARGET_USERNAME = "argument_target_username";
    public static final String ARG_TARGET_USER_ID = "argument_target_user_id";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "UserProfileFragment";
    private GridLayoutManager layoutManager;
    /* access modifiers changed from: private */
    public PostsStaggeredAdapter postsStaggeredAdapter;
    /* access modifiers changed from: private */
    public String targetUserId;
    /* access modifiers changed from: private */
    public String targetUserName;
    /* access modifiers changed from: private */
    public UserProfileViewModel viewModel;

    public void onTabReselected(TabLayout.Tab tab) {
    }

    public void onTabUnselected(TabLayout.Tab tab) {
    }

    public static final /* synthetic */ PostsStaggeredAdapter access$getPostsStaggeredAdapter$p(UserProfileFragment userProfileFragment) {
        PostsStaggeredAdapter postsStaggeredAdapter2 = userProfileFragment.postsStaggeredAdapter;
        if (postsStaggeredAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsStaggeredAdapter");
        }
        return postsStaggeredAdapter2;
    }

    public static final /* synthetic */ UserProfileViewModel access$getViewModel$p(UserProfileFragment userProfileFragment) {
        UserProfileViewModel userProfileViewModel = userProfileFragment.viewModel;
        if (userProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return userProfileViewModel;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/plus/ui/profile/user_profile/UserProfileFragment$Companion;", "", "()V", "ARG_TARGET_USERNAME", "", "ARG_TARGET_USER_ID", "TAG", "newInstance", "Lcom/memes/plus/ui/profile/user_profile/UserProfileFragment;", "targetUserId", "targetUserName", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.profile.user_profile.UserProfileFragment$Companion */
    /* compiled from: UserProfileFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UserProfileFragment newInstance(String str, String str2) {
            Bundle bundle = new Bundle();
            bundle.putString(UserProfileFragment.ARG_TARGET_USER_ID, str);
            bundle.putString(UserProfileFragment.ARG_TARGET_USERNAME, str2);
            UserProfileFragment userProfileFragment = new UserProfileFragment();
            userProfileFragment.setArguments(bundle);
            return userProfileFragment;
        }
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        enableEventBus();
        super.onAttach(context);
    }

    public UserProfileFragmentBinding createBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        UserProfileFragmentBinding inflate = UserProfileFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "UserProfileFragmentBindi…flater, container, false)");
        return inflate;
    }

    public void onBindingComplete(Bundle bundle) {
        ((UserProfileFragmentBinding) getBinding()).fullPageContentLayout.setCallback(this);
        ((UserProfileFragmentBinding) getBinding()).postsTabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
        this.layoutManager = new GridLayoutManager(getContext(), 2);
        RecyclerView recyclerView = ((UserProfileFragmentBinding) getBinding()).postsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "getBinding().postsRecyclerView");
        GridLayoutManager gridLayoutManager = this.layoutManager;
        if (gridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        recyclerView.setLayoutManager(gridLayoutManager);
        if (this.postsStaggeredAdapter == null) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            this.postsStaggeredAdapter = new PostsStaggeredAdapter(requireContext, this);
        }
        RecyclerView recyclerView2 = ((UserProfileFragmentBinding) getBinding()).postsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "getBinding().postsRecyclerView");
        PostsStaggeredAdapter postsStaggeredAdapter2 = this.postsStaggeredAdapter;
        if (postsStaggeredAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsStaggeredAdapter");
        }
        recyclerView2.setAdapter(postsStaggeredAdapter2);
        PostsStaggeredAdapter postsStaggeredAdapter3 = this.postsStaggeredAdapter;
        if (postsStaggeredAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsStaggeredAdapter");
        }
        postsStaggeredAdapter3.setConstantAspectRatio(1.0f);
        ((UserProfileFragmentBinding) getBinding()).postsRecyclerView.setHasFixedSize(true);
        ((UserProfileFragmentBinding) getBinding()).profileOptionsImageView.setOnClickListener(new UserProfileFragment$onBindingComplete$2(this));
        ((UserProfileFragmentBinding) getBinding()).profileFollowButton.setOnClickListener(new UserProfileFragment$onBindingComplete$3(this));
        ((UserProfileFragmentBinding) getBinding()).profileMessageButton.setOnClickListener(new UserProfileFragment$onBindingComplete$4(this));
        ((UserProfileFragmentBinding) getBinding()).seeAllPostsButton.setOnClickListener(new UserProfileFragment$onBindingComplete$5(this));
        ((UserProfileFragmentBinding) getBinding()).followerCountTextView.setOnClickListener(new UserProfileFragment$onBindingComplete$6(this));
        ((UserProfileFragmentBinding) getBinding()).followingCountTextView.setOnClickListener(new UserProfileFragment$onBindingComplete$7(this));
    }

    public void onObserversRequested() {
        Bundle arguments = getArguments();
        String str = null;
        this.targetUserId = arguments != null ? arguments.getString(ARG_TARGET_USER_ID) : null;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str = arguments2.getString(ARG_TARGET_USERNAME);
        }
        this.targetUserName = str;
        ViewModel viewModel2 = new ViewModelProvider((ViewModelStoreOwner) this, (ViewModelProvider.Factory) new BaseViewModelFactory(new UserProfileFragment$onObserversRequested$1(this))).get(UserProfileViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(this, …ator)).get(T::class.java)");
        this.viewModel = (UserProfileViewModel) viewModel2;
        ActivityHandle activityHandle = getActivityHandle();
        UserProfileViewModel userProfileViewModel = this.viewModel;
        if (userProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        activityHandle.registerViewModel(userProfileViewModel);
        UserProfileViewModel userProfileViewModel2 = this.viewModel;
        if (userProfileViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        userProfileViewModel2.getProfileLiveData().observe(getViewLifecycleOwner(), new UserProfileFragment$onObserversRequested$2(this));
        UserProfileViewModel userProfileViewModel3 = this.viewModel;
        if (userProfileViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        userProfileViewModel3.getPostsLiveData().observe(getViewLifecycleOwner(), new UserProfileFragment$onObserversRequested$3(this));
        UserProfileViewModel userProfileViewModel4 = this.viewModel;
        if (userProfileViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        userProfileViewModel4.getFullPageContentLayoutLiveData().observe(getViewLifecycleOwner(), new UserProfileFragment$onObserversRequested$4(this));
        UserProfileViewModel userProfileViewModel5 = this.viewModel;
        if (userProfileViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        userProfileViewModel5.getPostsContentLayoutLiveData().observe(getViewLifecycleOwner(), new UserProfileFragment$onObserversRequested$5(this));
        UserProfileViewModel userProfileViewModel6 = this.viewModel;
        if (userProfileViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        userProfileViewModel6.getSeeAllPostsButtonVisibility().observe(getViewLifecycleOwner(), new UserProfileFragment$onObserversRequested$6(this));
        UserProfileViewModel userProfileViewModel7 = this.viewModel;
        if (userProfileViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        userProfileViewModel7.getUserFollowLiveData().observe(getViewLifecycleOwner(), new UserProfileFragment$onObserversRequested$7(this));
        UserProfileViewModel userProfileViewModel8 = this.viewModel;
        if (userProfileViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        userProfileViewModel8.getBlockUnblockLiveData().observe(getViewLifecycleOwner(), new UserProfileFragment$onObserversRequested$8(this));
    }

    public void afterViewCreated() {
        PostsStaggeredAdapter postsStaggeredAdapter2 = this.postsStaggeredAdapter;
        if (postsStaggeredAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsStaggeredAdapter");
        }
        if (postsStaggeredAdapter2.hasNoPage()) {
            UserProfileViewModel userProfileViewModel = this.viewModel;
            if (userProfileViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            userProfileViewModel.fetchProfile(true);
        }
    }

    /* access modifiers changed from: private */
    public final void showOptions() {
        ProfileOptionsDialog profileOptionsDialog = new ProfileOptionsDialog(this);
        UserProfileViewModel userProfileViewModel = this.viewModel;
        if (userProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        profileOptionsDialog.setProfile(userProfileViewModel.getProfile());
        profileOptionsDialog.show(getChildFragmentManager(), ProfileOptionsDialog.TAG);
    }

    /* access modifiers changed from: private */
    public final void showProfile(UserProfileResponse userProfileResponse) {
        if ((userProfileResponse != null ? userProfileResponse.getUserProfile() : null) != null) {
            UserProfile userProfile = userProfileResponse.getUserProfile();
            CharSequence userBio = userProfile.getUserBio();
            if (userBio == null || StringsKt.isBlank(userBio)) {
                LinearLayout linearLayout = ((UserProfileFragmentBinding) getBinding()).profileBioLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "getBinding().profileBioLayout");
                linearLayout.setVisibility(8);
            } else {
                TextView textView = ((UserProfileFragmentBinding) getBinding()).profileBioTextView;
                Intrinsics.checkNotNullExpressionValue(textView, "getBinding().profileBioTextView");
                textView.setText(ExtensionsKt.encode(userProfile.getUserBio()));
                LinearLayout linearLayout2 = ((UserProfileFragmentBinding) getBinding()).profileBioLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "getBinding().profileBioLayout");
                linearLayout2.setVisibility(0);
            }
            TextView textView2 = ((UserProfileFragmentBinding) getBinding()).followerCountTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "getBinding().followerCountTextView");
            textView2.setText(PrettyCounter.INSTANCE.apply(userProfile.getFollower()));
            TextView textView3 = ((UserProfileFragmentBinding) getBinding()).tvPostcount;
            Intrinsics.checkNotNullExpressionValue(textView3, "getBinding().tvPostcount");
            textView3.setText(PrettyCounter.apply$default(PrettyCounter.INSTANCE, userProfile.getTotalPosts(), false, 2, (Object) null));
            TextView textView4 = ((UserProfileFragmentBinding) getBinding()).likesCountTextView;
            Intrinsics.checkNotNullExpressionValue(textView4, "getBinding().likesCountTextView");
            textView4.setText(PrettyCounter.apply$default(PrettyCounter.INSTANCE, userProfile.getTotallikes(), false, 2, (Object) null));
            TextView textView5 = ((UserProfileFragmentBinding) getBinding()).followingCountTextView;
            Intrinsics.checkNotNullExpressionValue(textView5, "getBinding().followingCountTextView");
            textView5.setText(PrettyCounter.apply$default(PrettyCounter.INSTANCE, userProfile.getFollowing(), false, 2, (Object) null));
            if (userProfile.getFollowed()) {
                ((UserProfileFragmentBinding) getBinding()).profileFollowButton.setText(C4199R.string.following);
            } else {
                ((UserProfileFragmentBinding) getBinding()).profileFollowButton.setText(C4199R.string.follow);
            }
            ((UserProfileFragmentBinding) getBinding()).tvUsername.setProUser(userProfile.isProUser());
            UserNameGradientTextView userNameGradientTextView = ((UserProfileFragmentBinding) getBinding()).tvUsername;
            Intrinsics.checkNotNullExpressionValue(userNameGradientTextView, "getBinding().tvUsername");
            userNameGradientTextView.setText(userProfile.getUsername());
            CollapsingToolbarLayout collapsingToolbarLayout = ((UserProfileFragmentBinding) getBinding()).toolbarLayout;
            Intrinsics.checkNotNullExpressionValue(collapsingToolbarLayout, "getBinding().toolbarLayout");
            collapsingToolbarLayout.setTitle(userProfile.getUsername());
            loadProfileImage(userProfile.getProfileImage(), userProfile.isProUser());
            loadCoverImage(userProfile.getCoverImage());
            if (userProfile.getBlocked()) {
                showBlockedProfileUi();
            } else {
                showUnblockedProfileUi();
            }
        }
    }

    private final void loadProfileImage(String str, boolean z) {
        ((UserProfileFragmentBinding) getBinding()).profileImage.setProUser(z);
        UserAvatarView.loadUrl$default(((UserProfileFragmentBinding) getBinding()).profileImage, str, C4199R.C4202drawable.placeholder_profile, (Integer) null, 4, (Object) null);
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            ((UserProfileFragmentBinding) getBinding()).profileImage.setOnClickListener(new UserProfileFragment$loadProfileImage$1(this, str));
        }
    }

    private final void loadCoverImage(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            Picasso picasso = Picasso.get();
            Intrinsics.checkNotNullExpressionValue(picasso, "Picasso.get()");
            PicassoExtKt.log(picasso, (Object) this, "drawable/background_gradient", "binding.backgroundImage").load((int) C4199R.C4201color.MemeBackgroundcolor).into(((UserProfileFragmentBinding) getBinding()).backgroundImage);
            return;
        }
        Picasso picasso2 = Picasso.get();
        Intrinsics.checkNotNullExpressionValue(picasso2, "Picasso.get()");
        PicassoExtKt.log(picasso2, (Object) this, str, "binding.backgroundImage").load(str).placeholder((int) C4199R.C4201color.MemeBackgroundcolor).error((int) C4199R.C4201color.MemeBackgroundcolor).into(((UserProfileFragmentBinding) getBinding()).backgroundImage);
    }

    /* access modifiers changed from: private */
    public final void showBlockedProfileUi() {
        AppCompatButton appCompatButton = ((UserProfileFragmentBinding) getBinding()).profileFollowButton;
        Intrinsics.checkNotNullExpressionValue(appCompatButton, "getBinding().profileFollowButton");
        appCompatButton.setEnabled(false);
        RecyclerView recyclerView = ((UserProfileFragmentBinding) getBinding()).postsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "getBinding().postsRecyclerView");
        recyclerView.setVisibility(8);
        TabLayout tabLayout = ((UserProfileFragmentBinding) getBinding()).postsTabLayout;
        Intrinsics.checkNotNullExpressionValue(tabLayout, "getBinding().postsTabLayout");
        tabLayout.setVisibility(8);
        Button button = ((UserProfileFragmentBinding) getBinding()).seeAllPostsButton;
        Intrinsics.checkNotNullExpressionValue(button, "getBinding().seeAllPostsButton");
        button.setVisibility(8);
        LinearLayout linearLayout = ((UserProfileFragmentBinding) getBinding()).profileBioLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "getBinding().profileBioLayout");
        linearLayout.setVisibility(8);
        TextView textView = ((UserProfileFragmentBinding) getBinding()).followerCountTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "getBinding().followerCountTextView");
        textView.setEnabled(false);
        TextView textView2 = ((UserProfileFragmentBinding) getBinding()).followingCountTextView;
        Intrinsics.checkNotNullExpressionValue(textView2, "getBinding().followingCountTextView");
        textView2.setEnabled(false);
        TextView textView3 = ((UserProfileFragmentBinding) getBinding()).followerCountTextView;
        Intrinsics.checkNotNullExpressionValue(textView3, "getBinding().followerCountTextView");
        textView3.setText("0");
        TextView textView4 = ((UserProfileFragmentBinding) getBinding()).followingCountTextView;
        Intrinsics.checkNotNullExpressionValue(textView4, "getBinding().followingCountTextView");
        textView4.setText("0");
        TextView textView5 = ((UserProfileFragmentBinding) getBinding()).tvPostcount;
        Intrinsics.checkNotNullExpressionValue(textView5, "getBinding().tvPostcount");
        textView5.setText("0");
        TextView textView6 = ((UserProfileFragmentBinding) getBinding()).likesCountTextView;
        Intrinsics.checkNotNullExpressionValue(textView6, "getBinding().likesCountTextView");
        textView6.setText("0");
    }

    private final void showUnblockedProfileUi() {
        AppCompatButton appCompatButton = ((UserProfileFragmentBinding) getBinding()).profileFollowButton;
        Intrinsics.checkNotNullExpressionValue(appCompatButton, "getBinding().profileFollowButton");
        appCompatButton.setEnabled(true);
        RecyclerView recyclerView = ((UserProfileFragmentBinding) getBinding()).postsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "getBinding().postsRecyclerView");
        recyclerView.setVisibility(0);
        TabLayout tabLayout = ((UserProfileFragmentBinding) getBinding()).postsTabLayout;
        Intrinsics.checkNotNullExpressionValue(tabLayout, "getBinding().postsTabLayout");
        tabLayout.setVisibility(0);
        Button button = ((UserProfileFragmentBinding) getBinding()).seeAllPostsButton;
        Intrinsics.checkNotNullExpressionValue(button, "getBinding().seeAllPostsButton");
        button.setVisibility(0);
        TextView textView = ((UserProfileFragmentBinding) getBinding()).followerCountTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "getBinding().followerCountTextView");
        textView.setEnabled(true);
        TextView textView2 = ((UserProfileFragmentBinding) getBinding()).followingCountTextView;
        Intrinsics.checkNotNullExpressionValue(textView2, "getBinding().followingCountTextView");
        textView2.setEnabled(true);
    }

    public void onTabSelected(TabLayout.Tab tab) {
        UserProfileViewModel userProfileViewModel = this.viewModel;
        if (userProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        userProfileViewModel.currentSelectedTabChanged(tab != null ? Integer.valueOf(tab.getPosition()) : null);
    }

    public void onStaggeredPostTapped(int i, Post post) {
        Intrinsics.checkNotNullParameter(post, "post");
        ActivityHandle activityHandle = getActivityHandle();
        ProfilePostsFragment.Companion companion = ProfilePostsFragment.Companion;
        String str = this.targetUserId;
        String str2 = this.targetUserName;
        TabLayout tabLayout = ((UserProfileFragmentBinding) getBinding()).postsTabLayout;
        Intrinsics.checkNotNullExpressionValue(tabLayout, "getBinding().postsTabLayout");
        ActivityHandle.DefaultImpls.replaceFragment$default(activityHandle, companion.newInstance(str, str2, tabLayout.getSelectedTabPosition(), i), ProfilePostsFragment.TAG, false, 4, (Object) null);
    }

    public void onContentLayoutErrorResolutionButtonTapped(int i, int i2) {
        ContentLayout contentLayout = ((UserProfileFragmentBinding) getBinding()).fullPageContentLayout;
        Intrinsics.checkNotNullExpressionValue(contentLayout, "getBinding().fullPageContentLayout");
        if (i == contentLayout.getId() && i2 == 1211) {
            UserProfileViewModel userProfileViewModel = this.viewModel;
            if (userProfileViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            userProfileViewModel.fetchProfile(true);
            return;
        }
        NestedContentLayout nestedContentLayout = ((UserProfileFragmentBinding) getBinding()).postsContentLayout;
        Intrinsics.checkNotNullExpressionValue(nestedContentLayout, "getBinding().postsContentLayout");
        if (i == nestedContentLayout.getId() && i2 == 1211) {
            UserProfileViewModel userProfileViewModel2 = this.viewModel;
            if (userProfileViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            userProfileViewModel2.fetchPosts();
            return;
        }
        super.onContentLayoutErrorResolutionButtonTapped(i, i2);
    }

    public void onEventReceived(NotifiableEvent notifiableEvent) {
        Intrinsics.checkNotNullParameter(notifiableEvent, "event");
        if (!notifiableEvent.consumedBy(virtualId())) {
            notifiableEvent.consume(virtualId());
            if (this.viewModel != null) {
                if (notifiableEvent instanceof UserFollowEvent) {
                    UserProfileViewModel userProfileViewModel = this.viewModel;
                    if (userProfileViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    userProfileViewModel.onUserFollowEventReceived((UserFollowEvent) notifiableEvent);
                    return;
                }
                super.onEventReceived(notifiableEvent);
            }
        }
    }

    public void onShareProfileTap() {
        UserNameGradientTextView userNameGradientTextView = ((UserProfileFragmentBinding) getBinding()).tvUsername;
        Intrinsics.checkNotNullExpressionValue(userNameGradientTextView, "getBinding().tvUsername");
        CharSequence text = userNameGradientTextView.getText();
        if (text != null) {
            LocalIntents localIntents = LocalIntents.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            Intent shareProfileIntent = localIntents.getShareProfileIntent(requireContext, text.toString());
            if (shareProfileIntent != null) {
                startActivity(shareProfileIntent);
            }
        }
    }

    public void onBlockTapped() {
        UserProfileViewModel userProfileViewModel = this.viewModel;
        if (userProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        userProfileViewModel.blockUnblockUser();
    }
}
