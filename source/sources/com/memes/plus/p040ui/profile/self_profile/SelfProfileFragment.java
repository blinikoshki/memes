package com.memes.plus.p040ui.profile.self_profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import com.livinglifetechway.quickpermissions_kotlin.PermissionsManagerKt;
import com.livinglifetechway.quickpermissions_kotlin.util.QuickPermissionsOptions;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.commons.contentlayout.NestedContentLayout;
import com.memes.commons.enhancedtext.socialtext.SocialTextView;
import com.memes.commons.media.MediaType;
import com.memes.commons.util.ActivityStarter;
import com.memes.commons.util.ExtensionsKt;
import com.memes.network.memes.MemesSession;
import com.memes.plus.App;
import com.memes.plus.C4199R;
import com.memes.plus.base.ActivityHandle;
import com.memes.plus.base.bottom_navigation.BaseBottomNavigationFragment;
import com.memes.plus.base.upgrades.ResettableScroll;
import com.memes.plus.databinding.SelfProfileFragmentBinding;
import com.memes.plus.events.NotifiableEvent;
import com.memes.plus.events.PostDeletedEvent;
import com.memes.plus.events.PostSavedEvent;
import com.memes.plus.integrations.snapchat.SnapchatIntegrationViewModel;
import com.memes.plus.p040ui.media_viewer.MediaViewerActivity;
import com.memes.plus.p040ui.posts.Post;
import com.memes.plus.p040ui.posts.PostsStaggeredAdapter;
import com.memes.plus.p040ui.posts.PostsStaggeredAdapterListener;
import com.memes.plus.p040ui.posts.post_basics.post_delete.PostDeleteResult;
import com.memes.plus.p040ui.profile.edit_profile.EditProfileActivity;
import com.memes.plus.p040ui.profile.profile_posts.ProfilePostsFragment;
import com.memes.plus.p040ui.profile.self_profile.header.SelfProfileHeaderView;
import com.memes.plus.p040ui.user_listing.UserListingFragment;
import com.memes.plus.util.LocalIntents;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 H2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0001HB\u0005¢\u0006\u0002\u0010\bJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020(H\u0016J\u0012\u0010)\u001a\u00020\u001d2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0018\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0016J\b\u00100\u001a\u00020\u001dH\u0002J\u0010\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020\u001dH\u0016J\b\u00105\u001a\u00020\u001dH\u0016J\b\u00106\u001a\u00020\u001dH\u0016J\b\u00107\u001a\u00020\u001dH\u0016J\u0010\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020\u001dH\u0016J\b\u0010<\u001a\u00020\u001dH\u0002J\b\u0010=\u001a\u00020\u001dH\u0002J\u0018\u0010>\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020AH\u0016J\u0012\u0010B\u001a\u00020\u001d2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u0012\u0010E\u001a\u00020\u001d2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u0012\u0010F\u001a\u00020\u001d2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\b\u0010G\u001a\u00020\u001dH\u0016R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001a¨\u0006I"}, mo26107d2 = {"Lcom/memes/plus/ui/profile/self_profile/SelfProfileFragment;", "Lcom/memes/plus/base/bottom_navigation/BaseBottomNavigationFragment;", "Lcom/memes/plus/databinding/SelfProfileFragmentBinding;", "Lcom/memes/commons/contentlayout/ContentLayout$Callback;", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "Lcom/memes/plus/ui/posts/PostsStaggeredAdapterListener;", "Lcom/memes/plus/base/upgrades/ResettableScroll;", "Lcom/memes/plus/ui/profile/self_profile/header/SelfProfileHeaderView$Callback;", "()V", "editProfileContractLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "layoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "postsStaggeredAdapter", "Lcom/memes/plus/ui/posts/PostsStaggeredAdapter;", "snapchatIntegrationViewModel", "Lcom/memes/plus/integrations/snapchat/SnapchatIntegrationViewModel;", "getSnapchatIntegrationViewModel", "()Lcom/memes/plus/integrations/snapchat/SnapchatIntegrationViewModel;", "snapchatIntegrationViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/memes/plus/ui/profile/self_profile/SelfProfileViewModel;", "getViewModel", "()Lcom/memes/plus/ui/profile/self_profile/SelfProfileViewModel;", "viewModel$delegate", "afterViewCreated", "", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "loadProfile", "profile", "Lcom/memes/plus/ui/profile/self_profile/SelfProfile;", "onAttach", "context", "Landroid/content/Context;", "onBindingComplete", "savedInstanceState", "Landroid/os/Bundle;", "onContentLayoutErrorResolutionButtonTapped", "who", "", "why", "onEditProfileButtonTapped", "onEventReceived", "event", "Lcom/memes/plus/events/NotifiableEvent;", "onFollowerCountTapped", "onFollowingCountTapped", "onObserversRequested", "onProfileOptionsTapped", "onProfilePicTapped", "path", "", "onResume", "onShareProfileButtonTapped", "onShareProfileToSnapchatButtonTapped", "onStaggeredPostTapped", "position", "post", "Lcom/memes/plus/ui/posts/Post;", "onTabReselected", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabSelected", "onTabUnselected", "resetScroll", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.self_profile.SelfProfileFragment */
/* compiled from: SelfProfileFragment.kt */
public final class SelfProfileFragment extends BaseBottomNavigationFragment<SelfProfileFragmentBinding> implements ContentLayout.Callback, TabLayout.OnTabSelectedListener, PostsStaggeredAdapterListener, ResettableScroll, SelfProfileHeaderView.Callback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "SelfProfileFragment";
    private final ActivityResultLauncher<Intent> editProfileContractLauncher;
    private GridLayoutManager layoutManager;
    /* access modifiers changed from: private */
    public PostsStaggeredAdapter postsStaggeredAdapter;
    private final Lazy snapchatIntegrationViewModel$delegate = LazyKt.lazy(new SelfProfileFragment$snapchatIntegrationViewModel$2(this));
    private final Lazy viewModel$delegate = LazyKt.lazy(new SelfProfileFragment$viewModel$2(this));

    /* access modifiers changed from: private */
    public final SnapchatIntegrationViewModel getSnapchatIntegrationViewModel() {
        return (SnapchatIntegrationViewModel) this.snapchatIntegrationViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final SelfProfileViewModel getViewModel() {
        return (SelfProfileViewModel) this.viewModel$delegate.getValue();
    }

    public void onProfileOptionsTapped() {
    }

    public void onTabReselected(TabLayout.Tab tab) {
    }

    public void onTabUnselected(TabLayout.Tab tab) {
    }

    public SelfProfileFragment() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new SelfProfileFragment$editProfileContractLauncher$1(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul…rceRefresh = true)\n\t\t}\n\t}");
        this.editProfileContractLauncher = registerForActivityResult;
    }

    public static final /* synthetic */ PostsStaggeredAdapter access$getPostsStaggeredAdapter$p(SelfProfileFragment selfProfileFragment) {
        PostsStaggeredAdapter postsStaggeredAdapter2 = selfProfileFragment.postsStaggeredAdapter;
        if (postsStaggeredAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsStaggeredAdapter");
        }
        return postsStaggeredAdapter2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/ui/profile/self_profile/SelfProfileFragment$Companion;", "", "()V", "TAG", "", "newInstance", "Lcom/memes/plus/ui/profile/self_profile/SelfProfileFragment;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.profile.self_profile.SelfProfileFragment$Companion */
    /* compiled from: SelfProfileFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SelfProfileFragment newInstance() {
            return new SelfProfileFragment();
        }
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        enableEventBus();
        super.onAttach(context);
    }

    public SelfProfileFragmentBinding createBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        SelfProfileFragmentBinding inflate = SelfProfileFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "SelfProfileFragmentBindi…flater, container, false)");
        return inflate;
    }

    public void onBindingComplete(Bundle bundle) {
        ((SelfProfileFragmentBinding) getBinding()).fullPageContentLayout.setCallback(this);
        ((SelfProfileFragmentBinding) getBinding()).postsTabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
        this.layoutManager = new GridLayoutManager(getActivity(), 2);
        RecyclerView recyclerView = ((SelfProfileFragmentBinding) getBinding()).postsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "getBinding().postsRecyclerView");
        GridLayoutManager gridLayoutManager = this.layoutManager;
        if (gridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        recyclerView.setLayoutManager(gridLayoutManager);
        if (this.postsStaggeredAdapter == null) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            PostsStaggeredAdapter postsStaggeredAdapter2 = new PostsStaggeredAdapter(requireContext, this);
            this.postsStaggeredAdapter = postsStaggeredAdapter2;
            if (postsStaggeredAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("postsStaggeredAdapter");
            }
            postsStaggeredAdapter2.setConstantAspectRatio(1.0f);
        }
        RecyclerView recyclerView2 = ((SelfProfileFragmentBinding) getBinding()).postsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "getBinding().postsRecyclerView");
        PostsStaggeredAdapter postsStaggeredAdapter3 = this.postsStaggeredAdapter;
        if (postsStaggeredAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsStaggeredAdapter");
        }
        recyclerView2.setAdapter(postsStaggeredAdapter3);
        ((SelfProfileFragmentBinding) getBinding()).postsRecyclerView.setHasFixedSize(true);
        NestedScrollView nestedScrollView = ((SelfProfileFragmentBinding) getBinding()).nestedScrollView;
        Intrinsics.checkNotNullExpressionValue(nestedScrollView, "getBinding().nestedScrollView");
        nestedScrollView.setNestedScrollingEnabled(false);
        ((SelfProfileFragmentBinding) getBinding()).profileHeaderView.setTypefaces(ResourcesCompat.getFont(requireContext(), C4199R.font.sf_ui_display_bold), ResourcesCompat.getFont(requireContext(), C4199R.font.sf_ui_display_regular));
        ((SelfProfileFragmentBinding) getBinding()).profileHeaderView.setCallback(this);
        ((SelfProfileFragmentBinding) getBinding()).profileEditButton.setOnClickListener(new SelfProfileFragment$onBindingComplete$2(this));
        ((SelfProfileFragmentBinding) getBinding()).profileShareButton.setOnClickListener(new SelfProfileFragment$onBindingComplete$3(this));
        ((SelfProfileFragmentBinding) getBinding()).profileSnapchatShareButton.setOnClickListener(new SelfProfileFragment$onBindingComplete$4(this));
        ((SelfProfileFragmentBinding) getBinding()).profileBioLayout.setOnClickListener(new SelfProfileFragment$onBindingComplete$5(this));
        ((SelfProfileFragmentBinding) getBinding()).seeAllPostsButton.setOnClickListener(new SelfProfileFragment$onBindingComplete$6(this));
    }

    public void onObserversRequested() {
        getActivityHandle().registerViewModel(getViewModel());
        getViewModel().getProfileLiveData().observe(getViewLifecycleOwner(), new SelfProfileFragment$onObserversRequested$1(this));
        getViewModel().getPostsLiveData().observe(getViewLifecycleOwner(), new SelfProfileFragment$onObserversRequested$2(this));
        getViewModel().getFullPageContentLayoutLiveData().observe(getViewLifecycleOwner(), new SelfProfileFragment$onObserversRequested$3(this));
        getViewModel().getPostsContentLayoutLiveData().observe(getViewLifecycleOwner(), new SelfProfileFragment$onObserversRequested$4(this));
        getViewModel().getSeeAllPostsButtonVisibility().observe(getViewLifecycleOwner(), new SelfProfileFragment$onObserversRequested$5(this));
    }

    public void afterViewCreated() {
        PostsStaggeredAdapter postsStaggeredAdapter2 = this.postsStaggeredAdapter;
        if (postsStaggeredAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsStaggeredAdapter");
        }
        if (postsStaggeredAdapter2.hasNoPage()) {
            getViewModel().fetchProfile(true);
        }
    }

    public void onResume() {
        setSelectedBottomNavigationTab(4);
        super.onResume();
    }

    /* access modifiers changed from: private */
    public final void loadProfile(SelfProfile selfProfile) {
        if (selfProfile != null) {
            ((SelfProfileFragmentBinding) getBinding()).profileHeaderView.loadProfile(selfProfile);
            CharSequence userBio = selfProfile.getUserBio();
            if (userBio == null || StringsKt.isBlank(userBio)) {
                SocialTextView socialTextView = ((SelfProfileFragmentBinding) getBinding()).profileBioTextView;
                Intrinsics.checkNotNullExpressionValue(socialTextView, "getBinding().profileBioTextView");
                socialTextView.setText("Tell people about yourself.");
                SocialTextView socialTextView2 = ((SelfProfileFragmentBinding) getBinding()).profileBioTextView;
                Intrinsics.checkNotNullExpressionValue(socialTextView2, "getBinding().profileBioTextView");
                socialTextView2.setAlpha(0.5f);
                return;
            }
            SocialTextView socialTextView3 = ((SelfProfileFragmentBinding) getBinding()).profileBioTextView;
            Intrinsics.checkNotNullExpressionValue(socialTextView3, "getBinding().profileBioTextView");
            socialTextView3.setText(ExtensionsKt.encode(selfProfile.getUserBio()));
            SocialTextView socialTextView4 = ((SelfProfileFragmentBinding) getBinding()).profileBioTextView;
            Intrinsics.checkNotNullExpressionValue(socialTextView4, "getBinding().profileBioTextView");
            socialTextView4.setAlpha(1.0f);
        }
    }

    /* access modifiers changed from: private */
    public final void onEditProfileButtonTapped() {
        App.Companion.trackingManager().onEditProfileButtonTapped();
        EditProfileActivity.Companion companion = EditProfileActivity.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        this.editProfileContractLauncher.launch(companion.getStartIntent(requireContext));
    }

    /* access modifiers changed from: private */
    public final void onShareProfileButtonTapped() {
        String username;
        SelfProfile profile = getViewModel().getProfile();
        if (profile != null && (username = profile.getUsername()) != null) {
            LocalIntents localIntents = LocalIntents.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            Intent shareProfileIntent = localIntents.getShareProfileIntent(requireContext, username);
            if (shareProfileIntent != null) {
                startActivity(shareProfileIntent);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void onShareProfileToSnapchatButtonTapped() {
        SelfProfile profile = getViewModel().getProfile();
        String userId = profile != null ? profile.getUserId() : null;
        CharSequence charSequence = userId;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            PermissionsManagerKt.runWithPermissions$default((Fragment) this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, (QuickPermissionsOptions) null, (Function0) new SelfProfileFragment$onShareProfileToSnapchatButtonTapped$1(this, userId), 2, (Object) null);
        }
    }

    public void onEventReceived(NotifiableEvent notifiableEvent) {
        Intrinsics.checkNotNullParameter(notifiableEvent, "event");
        if (!notifiableEvent.consumedBy(virtualId())) {
            notifiableEvent.consume(virtualId());
            if (this.postsStaggeredAdapter != null) {
                if (notifiableEvent instanceof PostSavedEvent) {
                    PostSavedEvent postSavedEvent = (PostSavedEvent) notifiableEvent;
                    if (postSavedEvent.getPost().getSaved()) {
                        PostsStaggeredAdapter postsStaggeredAdapter2 = this.postsStaggeredAdapter;
                        if (postsStaggeredAdapter2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("postsStaggeredAdapter");
                        }
                        postsStaggeredAdapter2.addItemAt(0, postSavedEvent.getPost());
                        return;
                    }
                    PostsStaggeredAdapter postsStaggeredAdapter3 = this.postsStaggeredAdapter;
                    if (postsStaggeredAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("postsStaggeredAdapter");
                    }
                    postsStaggeredAdapter3.applyUpdate(new PostDeleteResult(postSavedEvent.getPost().getPostId(), (String) null));
                } else if (notifiableEvent instanceof PostDeletedEvent) {
                    PostsStaggeredAdapter postsStaggeredAdapter4 = this.postsStaggeredAdapter;
                    if (postsStaggeredAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("postsStaggeredAdapter");
                    }
                    postsStaggeredAdapter4.applyUpdate(new PostDeleteResult(((PostDeletedEvent) notifiableEvent).getPostId(), (String) null));
                } else {
                    super.onEventReceived(notifiableEvent);
                }
            }
        }
    }

    public void onTabSelected(TabLayout.Tab tab) {
        getViewModel().currentSelectedTabChanged(tab != null ? Integer.valueOf(tab.getPosition()) : null);
    }

    public void onStaggeredPostTapped(int i, Post post) {
        Intrinsics.checkNotNullParameter(post, "post");
        ActivityHandle activityHandle = getActivityHandle();
        ProfilePostsFragment.Companion companion = ProfilePostsFragment.Companion;
        TabLayout tabLayout = ((SelfProfileFragmentBinding) getBinding()).postsTabLayout;
        Intrinsics.checkNotNullExpressionValue(tabLayout, "getBinding().postsTabLayout");
        ActivityHandle.DefaultImpls.replaceFragment$default(activityHandle, companion.newInstance(tabLayout.getSelectedTabPosition(), i), ProfilePostsFragment.TAG, false, 4, (Object) null);
    }

    public void resetScroll() {
        ((SelfProfileFragmentBinding) getBinding()).nestedScrollView.scrollTo(0, 0);
    }

    public void onContentLayoutErrorResolutionButtonTapped(int i, int i2) {
        ContentLayout contentLayout = ((SelfProfileFragmentBinding) getBinding()).fullPageContentLayout;
        Intrinsics.checkNotNullExpressionValue(contentLayout, "getBinding().fullPageContentLayout");
        if (i == contentLayout.getId() && i2 == 1211) {
            getViewModel().fetchProfile(true);
            return;
        }
        NestedContentLayout nestedContentLayout = ((SelfProfileFragmentBinding) getBinding()).postsContentLayout;
        Intrinsics.checkNotNullExpressionValue(nestedContentLayout, "getBinding().postsContentLayout");
        if (i == nestedContentLayout.getId() && i2 == 1211) {
            getViewModel().fetchPosts();
        } else {
            super.onContentLayoutErrorResolutionButtonTapped(i, i2);
        }
    }

    public void onProfilePicTapped(String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        MediaViewerActivity.Companion companion = MediaViewerActivity.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ActivityStarter.Companion.mo57312of(companion.getStartIntent(requireContext, MediaType.NETWORK_PHOTO, str)).startFrom((Fragment) this);
    }

    public void onFollowingCountTapped() {
        String userId = MemesSession.INSTANCE.getUserId();
        CharSequence charSequence = userId;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            ActivityHandle.DefaultImpls.replaceFragment$default(getActivityHandle(), UserListingFragment.Companion.newFollowingUsersInstance(userId), UserListingFragment.TAG, false, 4, (Object) null);
        }
    }

    public void onFollowerCountTapped() {
        String userId = MemesSession.INSTANCE.getUserId();
        CharSequence charSequence = userId;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            ActivityHandle.DefaultImpls.replaceFragment$default(getActivityHandle(), UserListingFragment.Companion.newFollowerUsersInstance(userId), UserListingFragment.TAG, false, 4, (Object) null);
        }
    }
}
