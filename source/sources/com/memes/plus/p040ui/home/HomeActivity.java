package com.memes.plus.p040ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager2.widget.ViewPager2;
import com.memes.chat.events.viewmodel.ChatEventsViewModel;
import com.memes.chat.routing.ChatRouting;
import com.memes.chat.services.ChatService;
import com.memes.commons.util.ActivityStarter;
import com.memes.network.memes.MemesSession;
import com.memes.plus.App;
import com.memes.plus.C4199R;
import com.memes.plus.base.ActivityHandle;
import com.memes.plus.base.BaseActivity;
import com.memes.plus.base.bottom_navigation.BaseBottomNavigationFragment;
import com.memes.plus.base.bottom_navigation.BottomNavigationFragmentChangeListener;
import com.memes.plus.base.upgrades.BindingAware;
import com.memes.plus.base.upgrades.OnFragmentBackPressed;
import com.memes.plus.databinding.HomeActivityBinding;
import com.memes.plus.events.EventNotifier;
import com.memes.plus.events.PlayerState;
import com.memes.plus.firebase.PushMessage;
import com.memes.plus.p040ui.auth.auth_prompt.AuthPromptActivity;
import com.memes.plus.p040ui.explore.ExploreTabFragment;
import com.memes.plus.p040ui.home.bottomtabs.BottomTabsFragmentKeeper;
import com.memes.plus.p040ui.home.bottomtabs.HomeBottomTab;
import com.memes.plus.p040ui.home.bottomtabs.HomeBottomTabsFactory;
import com.memes.plus.p040ui.home.bottomtabs.HomeBottomTabsSelectionListener;
import com.memes.plus.p040ui.home.feeds.HomeFeedType;
import com.memes.plus.p040ui.home.feeds.HomeFeedsManager;
import com.memes.plus.p040ui.home.routing.HomeRouting;
import com.memes.plus.p040ui.posts.post.PostFragment;
import com.memes.plus.p040ui.profile.self_profile.SelfProfileFragment;
import com.memes.plus.p040ui.social_notifications.SocialNotificationsFragment;
import com.memes.plus.util.zoom.ImageZoomUtility;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tools.activityproxy.ActivityProxyBridge;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\n*\u0001\u0018\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020,H\u0002J\u0012\u0010-\u001a\u00020,2\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J\b\u00100\u001a\u00020,H\u0002J\b\u00101\u001a\u00020,H\u0002J\u000e\u00102\u001a\b\u0012\u0004\u0012\u00020403H\u0016J\u0012\u00105\u001a\u00020*2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\n\u00108\u001a\u0004\u0018\u00010/H\u0002J\b\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020:H\u0016J\b\u0010<\u001a\u00020:H\u0003J\b\u0010=\u001a\u00020*H\u0002J\b\u0010>\u001a\u00020,H\u0002J\b\u0010?\u001a\u00020,H\u0002J\b\u0010@\u001a\u00020,H\u0002J\b\u0010A\u001a\u00020,H\u0016J\u0010\u0010B\u001a\u00020,2\u0006\u0010C\u001a\u00020:H\u0016J\u0012\u0010D\u001a\u00020,2\b\u0010E\u001a\u0004\u0018\u00010FH\u0014J\u0018\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u0002042\u0006\u0010I\u001a\u00020*H\u0016J\b\u0010J\u001a\u00020,H\u0014J\b\u0010K\u001a\u00020,H\u0014J\b\u0010L\u001a\u00020,H\u0014J\b\u0010M\u001a\u00020,H\u0016J \u0010N\u001a\u00020,2\u0006\u0010.\u001a\u00020/2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020*H\u0016J\u0010\u0010R\u001a\u00020*2\u0006\u0010I\u001a\u00020*H\u0002J\u0010\u0010S\u001a\u00020*2\u0006\u0010I\u001a\u00020*H\u0002J\u0010\u0010T\u001a\u00020*2\u0006\u0010I\u001a\u00020*H\u0002J\b\u0010U\u001a\u00020,H\u0002J\u0010\u0010V\u001a\u00020*2\u0006\u0010I\u001a\u00020*H\u0002J\b\u0010W\u001a\u00020,H\u0002J\u0010\u0010X\u001a\u00020*2\u0006\u0010I\u001a\u00020*H\u0002J\b\u0010Y\u001a\u00020,H\u0002R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020 8BX\u0002¢\u0006\f\n\u0004\b#\u0010\f\u001a\u0004\b!\u0010\"R\u001b\u0010$\u001a\u00020%8BX\u0002¢\u0006\f\n\u0004\b(\u0010\f\u001a\u0004\b&\u0010'¨\u0006Z"}, mo26107d2 = {"Lcom/memes/plus/ui/home/HomeActivity;", "Lcom/memes/plus/base/BaseActivity;", "Lcom/memes/plus/ui/home/bottomtabs/HomeBottomTabsFactory;", "Lcom/memes/plus/ui/home/bottomtabs/HomeBottomTabsSelectionListener;", "Lcom/memes/plus/base/bottom_navigation/BottomNavigationFragmentChangeListener;", "Lcom/memes/plus/base/ActivityHandle;", "()V", "binding", "Lcom/memes/plus/databinding/HomeActivityBinding;", "getBinding", "()Lcom/memes/plus/databinding/HomeActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "bottomTabsFragmentKeeper", "Lcom/memes/plus/ui/home/bottomtabs/BottomTabsFragmentKeeper;", "getBottomTabsFragmentKeeper", "()Lcom/memes/plus/ui/home/bottomtabs/BottomTabsFragmentKeeper;", "bottomTabsFragmentKeeper$delegate", "chatEventsViewModel", "Lcom/memes/chat/events/viewmodel/ChatEventsViewModel;", "getChatEventsViewModel", "()Lcom/memes/chat/events/viewmodel/ChatEventsViewModel;", "chatEventsViewModel$delegate", "chatServiceConnection", "com/memes/plus/ui/home/HomeActivity$chatServiceConnection$1", "Lcom/memes/plus/ui/home/HomeActivity$chatServiceConnection$1;", "feedsManager", "Lcom/memes/plus/ui/home/feeds/HomeFeedsManager;", "getFeedsManager", "()Lcom/memes/plus/ui/home/feeds/HomeFeedsManager;", "feedsManager$delegate", "homeViewModel", "Lcom/memes/plus/ui/home/HomeViewModel;", "getHomeViewModel", "()Lcom/memes/plus/ui/home/HomeViewModel;", "homeViewModel$delegate", "imageZoomUtility", "Lcom/memes/plus/util/zoom/ImageZoomUtility;", "getImageZoomUtility", "()Lcom/memes/plus/util/zoom/ImageZoomUtility;", "imageZoomUtility$delegate", "beforeBinding", "", "bindChatService", "", "cleanupFragment", "fragment", "Landroidx/fragment/app/Fragment;", "clearBackStackFragments", "consumeIntent", "createTabs", "", "Lcom/memes/plus/ui/home/bottomtabs/HomeBottomTab;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "findCurrentFragment", "fragmentContainerId", "", "getDefaultTabId", "getFragmentContainerId", "handleBackPressed", "initBottomTabs", "initFeeds", "initObservers", "onBackPressed", "onBottomNavigationFragmentChanged", "bottomNavItemId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onHomeBottomTabTapped", "bottomTab", "reselected", "onResume", "onStart", "onStop", "popFragment", "replaceFragment", "fragmentTag", "", "addToBackStack", "showChatPage", "showEditorPage", "showExplorePage", "showFeedsContainer", "showFeedsPage", "showFragmentContainer", "showProfilePage", "unbindChatService", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.home.HomeActivity */
/* compiled from: HomeActivity.kt */
public final class HomeActivity extends BaseActivity implements HomeBottomTabsFactory, HomeBottomTabsSelectionListener, BottomNavigationFragmentChangeListener, ActivityHandle {
    private final Lazy binding$delegate = LazyKt.lazy(new HomeActivity$binding$2(this));
    private final Lazy bottomTabsFragmentKeeper$delegate = LazyKt.lazy(HomeActivity$bottomTabsFragmentKeeper$2.INSTANCE);
    private final Lazy chatEventsViewModel$delegate = LazyKt.lazy(new HomeActivity$chatEventsViewModel$2(this));
    private final HomeActivity$chatServiceConnection$1 chatServiceConnection = new HomeActivity$chatServiceConnection$1();
    private final Lazy feedsManager$delegate = LazyKt.lazy(new HomeActivity$feedsManager$2(this));
    private final Lazy homeViewModel$delegate = LazyKt.lazy(new HomeActivity$homeViewModel$2(this));
    private final Lazy imageZoomUtility$delegate = LazyKt.lazy(HomeActivity$imageZoomUtility$2.INSTANCE);

    /* access modifiers changed from: private */
    public final HomeActivityBinding getBinding() {
        return (HomeActivityBinding) this.binding$delegate.getValue();
    }

    private final BottomTabsFragmentKeeper getBottomTabsFragmentKeeper() {
        return (BottomTabsFragmentKeeper) this.bottomTabsFragmentKeeper$delegate.getValue();
    }

    private final ChatEventsViewModel getChatEventsViewModel() {
        return (ChatEventsViewModel) this.chatEventsViewModel$delegate.getValue();
    }

    private final HomeFeedsManager getFeedsManager() {
        return (HomeFeedsManager) this.feedsManager$delegate.getValue();
    }

    private final HomeViewModel getHomeViewModel() {
        return (HomeViewModel) this.homeViewModel$delegate.getValue();
    }

    private final ImageZoomUtility getImageZoomUtility() {
        return (ImageZoomUtility) this.imageZoomUtility$delegate.getValue();
    }

    public int getDefaultTabId() {
        return 0;
    }

    public boolean beforeBinding() {
        if (MemesSession.INSTANCE.isEmpty()) {
            ActivityStarter.Companion.mo57312of(AuthPromptActivity.Companion.getStartIntent(this)).finishAffinity().startFrom((Activity) this);
            return false;
        }
        getLifecycle().addObserver(getChatEventsViewModel());
        return super.beforeBinding();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HomeActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        initBottomTabs();
        initFeeds();
        initObservers();
        consumeIntent();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        bindChatService();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        getHomeViewModel().refreshProfileTabIcon();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InputMethodManager inputMethodManager;
        View currentFocus = getCurrentFocus();
        if (!(currentFocus == null || (inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(this, InputMethodManager.class)) == null)) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        if (motionEvent == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        Fragment findCurrentFragment = findCurrentFragment();
        View view = findCurrentFragment != null ? findCurrentFragment.getView() : null;
        if (view == null) {
            ImageZoomUtility imageZoomUtility = getImageZoomUtility();
            ViewPager2 viewPager2 = getBinding().postsViewPager;
            Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.postsViewPager");
            if (imageZoomUtility.dispatchTouchEvent(motionEvent, (View) viewPager2) || super.dispatchTouchEvent(motionEvent)) {
                return true;
            }
            return false;
        } else if (getImageZoomUtility().dispatchTouchEvent(motionEvent, view) || super.dispatchTouchEvent(motionEvent)) {
            return true;
        } else {
            return false;
        }
    }

    public void onBackPressed() {
        if (!handleBackPressed()) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        unbindChatService();
    }

    private final void initObservers() {
        registerViewModel(getHomeViewModel());
        LifecycleOwner lifecycleOwner = this;
        getHomeViewModel().profileTabIcon().observe(lifecycleOwner, new HomeActivity$initObservers$1(this));
        getChatEventsViewModel().chatBadgeCount().observe(lifecycleOwner, new HomeActivity$initObservers$2(this));
    }

    private final void consumeIntent() {
        PushMessage pushMessage = (PushMessage) getIntent().getParcelableExtra(HomeRouting.EXTRA_PUSH_MESSAGE);
        if (pushMessage != null) {
            ActivityHandle.DefaultImpls.replaceFragment$default(this, SocialNotificationsFragment.Companion.newInstance(), SocialNotificationsFragment.TAG, false, 4, (Object) null);
            CharSequence postId = pushMessage.getPostId();
            if (!(postId == null || StringsKt.isBlank(postId))) {
                ActivityHandle.DefaultImpls.replaceFragment$default(this, PostFragment.Companion.newInstance(pushMessage.getPostId()), PostFragment.TAG, false, 4, (Object) null);
            }
        }
    }

    private final void showFragmentContainer() {
        FrameLayout frameLayout = getBinding().fragmentContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.fragmentContainer");
        frameLayout.setVisibility(0);
        ViewPager2 viewPager2 = getBinding().postsViewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.postsViewPager");
        viewPager2.setVisibility(8);
    }

    private final void showFeedsContainer() {
        ViewPager2 viewPager2 = getBinding().postsViewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.postsViewPager");
        viewPager2.setVisibility(0);
        FrameLayout frameLayout = getBinding().fragmentContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.fragmentContainer");
        frameLayout.setVisibility(8);
    }

    private final void initFeeds() {
        getFeedsManager().setInvitesViewTapListener(new HomeActivity$initFeeds$1(this));
        getFeedsManager().setSocialNotificationButtonTapListener(new HomeActivity$initFeeds$2(this));
        Intent intent = getIntent();
        Object obj = null;
        Object serializableExtra = intent != null ? intent.getSerializableExtra(HomeRouting.EXTRA_CURRENT_FEED_TYPE) : null;
        if (serializableExtra instanceof HomeFeedType) {
            obj = serializableExtra;
        }
        HomeFeedType homeFeedType = (HomeFeedType) obj;
        if (homeFeedType == null) {
            homeFeedType = HomeFeedType.FOR_YOU;
        }
        getFeedsManager().setShownFeedType(homeFeedType);
    }

    private final void initBottomTabs() {
        getBinding().bottomTabsView.setBottomTabsTapListener(this);
        getBinding().bottomTabsView.setBottomTabsFactory(this);
    }

    public List<HomeBottomTab> createTabs() {
        HomeBottomTab homeBottomTab = new HomeBottomTab(2, "Memes Generator");
        homeBottomTab.setIconResource(C4199R.C4202drawable.ic_open_editor);
        homeBottomTab.setTintAllowed(false);
        Unit unit = Unit.INSTANCE;
        HomeBottomTab homeBottomTab2 = new HomeBottomTab(4, "Profile");
        homeBottomTab2.setIconResource(C4199R.C4202drawable.placeholder_profile);
        homeBottomTab2.setTintAllowed(false);
        homeBottomTab2.setIconRoundingAllowed(true);
        Unit unit2 = Unit.INSTANCE;
        return CollectionsKt.listOf(new HomeBottomTab(0, "Feed").setIconResource(C4199R.mipmap.home_feed), new HomeBottomTab(1, "Explore").setIconResource(C4199R.C4202drawable.ic_explore), homeBottomTab, new HomeBottomTab(3, "Chat").setIconResource(C4199R.C4202drawable.ic_chat), homeBottomTab2);
    }

    public boolean onHomeBottomTabTapped(HomeBottomTab homeBottomTab, boolean z) {
        Intrinsics.checkNotNullParameter(homeBottomTab, "bottomTab");
        int id = homeBottomTab.getId();
        if (id == 0) {
            return showFeedsPage(z);
        }
        if (id == 1) {
            return showExplorePage(z);
        }
        if (id == 2) {
            return showEditorPage(z);
        }
        if (id == 3) {
            return showChatPage(z);
        }
        if (id != 4) {
            return false;
        }
        return showProfilePage(z);
    }

    private final boolean showFeedsPage(boolean z) {
        App.Companion.trackingManager().onHomeNavItemTapped();
        EventNotifier.INSTANCE.notifyPostsPlayer(PlayerState.PLAY);
        showFeedsContainer();
        clearBackStackFragments();
        if (!z) {
            return true;
        }
        getFeedsManager().resetScroll();
        return true;
    }

    private final boolean showExplorePage(boolean z) {
        App.Companion.trackingManager().onExploreNavItemTapped();
        EventNotifier.INSTANCE.notifyPostsPlayer(PlayerState.PAUSE);
        showFragmentContainer();
        Fragment findCurrentFragment = findCurrentFragment();
        if (z) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            if (supportFragmentManager.getBackStackEntryCount() > 1) {
                getSupportFragmentManager().popBackStack(getBottomTabsFragmentKeeper().getExploreTabTag(), 0);
            }
            if (findCurrentFragment instanceof ExploreTabFragment) {
                ((ExploreTabFragment) findCurrentFragment).resetScroll();
                return true;
            }
        }
        ActivityHandle.DefaultImpls.replaceFragment$default(this, getBottomTabsFragmentKeeper().getExploreTabFragment(), getBottomTabsFragmentKeeper().getExploreTabTag(), false, 4, (Object) null);
        return true;
    }

    private final boolean showEditorPage(boolean z) {
        App.Companion.trackingManager().onEditorNavItemTapped();
        EventNotifier.INSTANCE.notifyPostsPlayer(PlayerState.PAUSE);
        ActivityProxyBridge.launchEditorEntryPage$default(ActivityProxyBridge.INSTANCE, this, (Function2) null, 2, (Object) null);
        return false;
    }

    private final boolean showChatPage(boolean z) {
        App.Companion.trackingManager().onChatNavItemTapped();
        EventNotifier.INSTANCE.notifyPostsPlayer(PlayerState.PAUSE);
        startActivity(ChatRouting.INSTANCE.getChatStartupIntent(this));
        return false;
    }

    private final boolean showProfilePage(boolean z) {
        App.Companion.trackingManager().onProfileNavItemTapped();
        EventNotifier.INSTANCE.notifyPostsPlayer(PlayerState.PAUSE);
        showFragmentContainer();
        Fragment findCurrentFragment = findCurrentFragment();
        if (z) {
            getSupportFragmentManager().popBackStack(getBottomTabsFragmentKeeper().getProfileTabTag(), 0);
            if (findCurrentFragment instanceof SelfProfileFragment) {
                ((SelfProfileFragment) findCurrentFragment).resetScroll();
                return true;
            }
        }
        ActivityHandle.DefaultImpls.replaceFragment$default(this, getBottomTabsFragmentKeeper().getProfileTabFragment(), getBottomTabsFragmentKeeper().getProfileTabTag(), false, 4, (Object) null);
        return true;
    }

    public void onBottomNavigationFragmentChanged(int i) {
        getBinding().bottomTabsView.setSelectedTabId(i, false);
    }

    private final int getFragmentContainerId() {
        FrameLayout frameLayout = getBinding().fragmentContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.fragmentContainer");
        return frameLayout.getId();
    }

    private final Fragment findCurrentFragment() {
        return getSupportFragmentManager().findFragmentById(getFragmentContainerId());
    }

    private final void cleanupFragment(Fragment fragment) {
        if (fragment != null && (fragment instanceof BindingAware)) {
            boolean z = true;
            if ((fragment instanceof BaseBottomNavigationFragment) && ((BaseBottomNavigationFragment) fragment).isBottomNavigationTabUpdateEnabled()) {
                z = false;
            }
            ((BindingAware) fragment).setShouldDestroyBinding(z);
        }
    }

    private final void clearBackStackFragments() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if (supportFragmentManager.getBackStackEntryCount() > 0) {
            for (Fragment next : supportFragmentManager.getFragments()) {
                if (next != null) {
                    cleanupFragment(next);
                }
            }
            FragmentManager.BackStackEntry backStackEntryAt = supportFragmentManager.getBackStackEntryAt(0);
            Intrinsics.checkNotNullExpressionValue(backStackEntryAt, "manager.getBackStackEntryAt(0)");
            supportFragmentManager.popBackStack(backStackEntryAt.getId(), 1);
        }
    }

    private final boolean handleBackPressed() {
        Fragment findCurrentFragment = findCurrentFragment();
        if ((findCurrentFragment instanceof OnFragmentBackPressed) && ((OnFragmentBackPressed) findCurrentFragment).onFragmentBackPressed()) {
            return true;
        }
        FrameLayout frameLayout = getBinding().fragmentContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.fragmentContainer");
        if (frameLayout.getVisibility() == 8) {
            return false;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        int backStackEntryCount = supportFragmentManager.getBackStackEntryCount();
        if (backStackEntryCount == 1) {
            getBinding().bottomTabsView.setSelectedTabId(0, true);
            return true;
        } else if (backStackEntryCount <= 1) {
            return false;
        } else {
            cleanupFragment(findCurrentFragment);
            getSupportFragmentManager().popBackStack();
            return true;
        }
    }

    public int fragmentContainerId() {
        FrameLayout frameLayout = getBinding().fragmentContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.fragmentContainer");
        return frameLayout.getId();
    }

    public void replaceFragment(Fragment fragment, String str, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(str, "fragmentTag");
        super.replaceFragment(fragment, str, z);
        showFragmentContainer();
    }

    public void popFragment() {
        Fragment findCurrentFragment = findCurrentFragment();
        if (!(findCurrentFragment instanceof OnFragmentBackPressed) || !((OnFragmentBackPressed) findCurrentFragment).onFragmentBackPressed()) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            int backStackEntryCount = supportFragmentManager.getBackStackEntryCount();
            if (backStackEntryCount == 1) {
                getBinding().bottomTabsView.setSelectedTabId(0, true);
            } else if (backStackEntryCount > 1) {
                cleanupFragment(findCurrentFragment);
                getSupportFragmentManager().popBackStack();
            }
        }
    }

    private final void bindChatService() {
        bindService(new Intent(this, ChatService.class), this.chatServiceConnection, 1);
    }

    private final void unbindChatService() {
        unbindService(this.chatServiceConnection);
    }
}
