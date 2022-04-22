package com.memes.plus.p040ui.user_listing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.share.internal.ShareConstants;
import com.memes.commons.pagination.Paginator;
import com.memes.commons.util.ExtensionsKt;
import com.memes.commons.util.SoftKeyboardUtil;
import com.memes.plus.C4199R;
import com.memes.plus.base.ActivityHandle;
import com.memes.plus.base.BaseFragment;
import com.memes.plus.databinding.UserListingFragmentBinding;
import com.memes.plus.p040ui.profile.ProfileFragmentProxy;
import com.memes.plus.p040ui.user_listing.UserListingTarget;
import com.memes.plus.p040ui.user_listing.UsersListingAdapter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001.B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0018H\u0016J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'H\u0002J\u001c\u0010(\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010,\u001a\u00020\u00182\b\u0010-\u001a\u0004\u0018\u00010'R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0015¨\u0006/"}, mo26107d2 = {"Lcom/memes/plus/ui/user_listing/UserListingFragment;", "Lcom/memes/plus/base/BaseFragment;", "Lcom/memes/plus/databinding/UserListingFragmentBinding;", "Lcom/memes/plus/ui/user_listing/UsersListingAdapter$Callback;", "()V", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLinearLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "linearLayoutManager$delegate", "Lkotlin/Lazy;", "paginator", "Lcom/memes/commons/pagination/Paginator;", "usersListingAdapter", "Lcom/memes/plus/ui/user_listing/UsersListingAdapter;", "getUsersListingAdapter", "()Lcom/memes/plus/ui/user_listing/UsersListingAdapter;", "usersListingAdapter$delegate", "viewModel", "Lcom/memes/plus/ui/user_listing/UserListingViewModel;", "getViewModel", "()Lcom/memes/plus/ui/user_listing/UserListingViewModel;", "viewModel$delegate", "afterViewCreated", "", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onBindingComplete", "savedInstanceState", "Landroid/os/Bundle;", "onObserversRequested", "onProfileImageTapped", "user", "Lcom/memes/plus/ui/user_listing/ListedUser;", "onSearchQueryChanged", "query", "", "onSearchRequested", "closeKeyboard", "", "onToggleFollowButtonTapped", "search", "keyword", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.user_listing.UserListingFragment */
/* compiled from: UserListingFragment.kt */
public final class UserListingFragment extends BaseFragment<UserListingFragmentBinding> implements UsersListingAdapter.Callback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_USER_LISTING_TARGET = "extra_user_listing_target";
    public static final String TAG = "UsersListingFragment";
    private final Lazy linearLayoutManager$delegate = LazyKt.lazy(new UserListingFragment$linearLayoutManager$2(this));
    private Paginator paginator;
    private final Lazy usersListingAdapter$delegate = LazyKt.lazy(new UserListingFragment$usersListingAdapter$2(this));
    private final Lazy viewModel$delegate = LazyKt.lazy(new UserListingFragment$viewModel$2(this));

    private final LinearLayoutManager getLinearLayoutManager() {
        return (LinearLayoutManager) this.linearLayoutManager$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final UsersListingAdapter getUsersListingAdapter() {
        return (UsersListingAdapter) this.usersListingAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final UserListingViewModel getViewModel() {
        return (UserListingViewModel) this.viewModel$delegate.getValue();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo26107d2 = {"Lcom/memes/plus/ui/user_listing/UserListingFragment$Companion;", "", "()V", "EXTRA_USER_LISTING_TARGET", "", "TAG", "newFollowerUsersInstance", "Lcom/memes/plus/ui/user_listing/UserListingFragment;", "targetUserId", "newFollowingUsersInstance", "newInstance", "bundle", "Landroid/os/Bundle;", "newPostLikeUsersInstance", "postId", "newSuggestionUsersInstance", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.user_listing.UserListingFragment$Companion */
    /* compiled from: UserListingFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UserListingFragment newPostLikeUsersInstance(String str) {
            Intrinsics.checkNotNullParameter(str, ShareConstants.RESULT_POST_ID);
            Bundle bundle = new Bundle();
            bundle.putParcelable(UserListingFragment.EXTRA_USER_LISTING_TARGET, new UserListingTarget.Likes(str));
            return newInstance(bundle);
        }

        public final UserListingFragment newSuggestionUsersInstance() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(UserListingFragment.EXTRA_USER_LISTING_TARGET, UserListingTarget.Suggestions.INSTANCE);
            return newInstance(bundle);
        }

        public final UserListingFragment newFollowerUsersInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "targetUserId");
            Bundle bundle = new Bundle();
            bundle.putParcelable(UserListingFragment.EXTRA_USER_LISTING_TARGET, new UserListingTarget.Followers(str));
            return newInstance(bundle);
        }

        public final UserListingFragment newFollowingUsersInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "targetUserId");
            Bundle bundle = new Bundle();
            bundle.putParcelable(UserListingFragment.EXTRA_USER_LISTING_TARGET, new UserListingTarget.Followings(str));
            return newInstance(bundle);
        }

        private final UserListingFragment newInstance(Bundle bundle) {
            UserListingFragment userListingFragment = new UserListingFragment();
            userListingFragment.setArguments(bundle);
            return userListingFragment;
        }
    }

    public UserListingFragmentBinding createBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        UserListingFragmentBinding inflate = UserListingFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "UserListingFragmentBindi…flater, container, false)");
        return inflate;
    }

    public void onBindingComplete(Bundle bundle) {
        ((UserListingFragmentBinding) getBinding()).contentLayout.setErrorIcon(C4199R.C4202drawable.user);
        ((UserListingFragmentBinding) getBinding()).contentLayout.setErrorTextSize(C4199R.dimen._14ssp);
        ((UserListingFragmentBinding) getBinding()).contentLayout.setErrorTextBoldStyle();
        ((UserListingFragmentBinding) getBinding()).contentLayout.setCallback(getViewModel());
        RecyclerView recyclerView = ((UserListingFragmentBinding) getBinding()).usersListRecyclerview;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "getBinding().usersListRecyclerview");
        recyclerView.setLayoutManager(getLinearLayoutManager());
        ((UserListingFragmentBinding) getBinding()).usersListRecyclerview.clearOnScrollListeners();
        RecyclerView recyclerView2 = ((UserListingFragmentBinding) getBinding()).usersListRecyclerview;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "getBinding().usersListRecyclerview");
        this.paginator = ExtensionsKt.addPaginator(recyclerView2, getLinearLayoutManager(), new UserListingFragment$onBindingComplete$1(this));
        RecyclerView recyclerView3 = ((UserListingFragmentBinding) getBinding()).usersListRecyclerview;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "getBinding().usersListRecyclerview");
        recyclerView3.setAdapter(getUsersListingAdapter());
        ((UserListingFragmentBinding) getBinding()).backNavigationImageview.setOnClickListener(new UserListingFragment$onBindingComplete$2(this));
        ((UserListingFragmentBinding) getBinding()).searchBoxLayout.searchInputCancelImageView.setOnClickListener(new UserListingFragment$onBindingComplete$3(this));
        EditText editText = ((UserListingFragmentBinding) getBinding()).searchBoxLayout.searchEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "getBinding().searchBoxLayout.searchEditText");
        editText.addTextChangedListener(new C4351xb603404(this));
        EditText editText2 = ((UserListingFragmentBinding) getBinding()).searchBoxLayout.searchEditText;
        Intrinsics.checkNotNullExpressionValue(editText2, "getBinding().searchBoxLayout.searchEditText");
        editText2.setImeOptions(6);
    }

    public void onObserversRequested() {
        getActivityHandle().registerViewModel(getViewModel());
        getViewModel().getUserListingTargetLiveData().observe(getViewLifecycleOwner(), new UserListingFragment$onObserversRequested$1(this));
        getViewModel().getListedUsersLiveData().observe(getViewLifecycleOwner(), new UserListingFragment$onObserversRequested$2(this));
        getViewModel().getFollowToggleLiveData().observe(getViewLifecycleOwner(), new UserListingFragment$onObserversRequested$3(this));
        getViewModel().getContentVisibilityLiveData().observe(getViewLifecycleOwner(), new UserListingFragment$onObserversRequested$4(this));
    }

    public void afterViewCreated() {
        Bundle arguments = getArguments();
        getViewModel().setUserListingTarget(arguments != null ? (UserListingTarget) arguments.getParcelable(EXTRA_USER_LISTING_TARGET) : null);
        if (getUsersListingAdapter().hasNoPage()) {
            getViewModel().fetchUserListing();
        }
    }

    public final void search(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            Paginator paginator2 = this.paginator;
            if (paginator2 != null) {
                paginator2.enableResettingState();
            }
        } else {
            Paginator paginator3 = this.paginator;
            if (paginator3 != null) {
                paginator3.disable();
            }
        }
        getViewModel().search(str);
    }

    /* access modifiers changed from: private */
    public final void onSearchQueryChanged(String str) {
        ImageView imageView = ((UserListingFragmentBinding) getBinding()).searchBoxLayout.searchInputCancelImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "getBinding().searchBoxLa…earchInputCancelImageView");
        CharSequence charSequence = str;
        imageView.setVisibility(((charSequence.length() == 0) || StringsKt.isBlank(charSequence)) ? 8 : 0);
        onSearchRequested(str, false);
    }

    static /* synthetic */ void onSearchRequested$default(UserListingFragment userListingFragment, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        userListingFragment.onSearchRequested(str, z);
    }

    private final void onSearchRequested(String str, boolean z) {
        if (z) {
            SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
            EditText editText = ((UserListingFragmentBinding) getBinding()).searchBoxLayout.searchEditText;
            Intrinsics.checkNotNullExpressionValue(editText, "getBinding().searchBoxLayout.searchEditText");
            softKeyboardUtil.hideKeyboard(editText);
        }
        search(str);
    }

    public void onProfileImageTapped(ListedUser listedUser) {
        Intrinsics.checkNotNullParameter(listedUser, "user");
        ActivityHandle.DefaultImpls.replaceFragment$default(getActivityHandle(), ProfileFragmentProxy.INSTANCE.newInstance(listedUser.getUserId(), listedUser.getUsername()), ProfileFragmentProxy.TAG, false, 4, (Object) null);
    }

    public void onToggleFollowButtonTapped(ListedUser listedUser) {
        Intrinsics.checkNotNullParameter(listedUser, "user");
        getViewModel().toggleFollowUser(listedUser);
    }
}
