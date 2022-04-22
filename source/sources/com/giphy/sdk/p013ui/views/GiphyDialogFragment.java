package com.giphy.sdk.p013ui.views;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.giphy.sdk.analytics.models.enums.ActionType;
import com.giphy.sdk.core.models.BottleData;
import com.giphy.sdk.core.models.Media;
import com.giphy.sdk.core.models.User;
import com.giphy.sdk.core.models.enums.MediaType;
import com.giphy.sdk.core.models.enums.RatingType;
import com.giphy.sdk.core.models.enums.RenditionType;
import com.giphy.sdk.p013ui.C1800R;
import com.giphy.sdk.p013ui.GPHContentType;
import com.giphy.sdk.p013ui.GPHSettings;
import com.giphy.sdk.p013ui.GiphyCoreUI;
import com.giphy.sdk.p013ui.pagination.GifsQuery;
import com.giphy.sdk.p013ui.themes.GridType;
import com.giphy.sdk.p013ui.themes.Theme;
import com.giphy.sdk.p013ui.utils.AvatarUtils;
import com.giphy.sdk.p013ui.utils.GifUtils;
import com.giphy.sdk.p013ui.utils.IntExtensionsKt;
import com.giphy.sdk.p013ui.views.GPHMediaTypeView;
import com.giphy.sdk.tracking.GifTrackingManager;
import com.giphy.sdk.tracking.MediaExtensionKt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000×\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b *\u0003SX\\\u0018\u0000 \u00012\u00020\u0001:\u0006\u0001\u0001\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020<H\u0002J\b\u0010@\u001a\u00020>H\u0002J\b\u0010A\u001a\u00020>H\u0002J\b\u0010B\u001a\u00020>H\u0002J\b\u0010C\u001a\u00020>H\u0002J\u0010\u0010D\u001a\u00020>2\u0006\u0010?\u001a\u00020<H\u0002J\u0010\u0010E\u001a\u00020>2\u0006\u0010?\u001a\u00020<H\u0002J\u0018\u0010F\u001a\u00020>2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020HH\u0002J\u0010\u0010J\u001a\u00020>2\u0006\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010K\u001a\u00020>H\u0002J\u0010\u0010L\u001a\u00020>2\u0006\u0010M\u001a\u00020NH\u0002J\b\u0010O\u001a\u00020>H\u0002J\b\u0010P\u001a\u00020QH\u0002J\r\u0010R\u001a\u00020SH\u0002¢\u0006\u0002\u0010TJ\b\u0010U\u001a\u00020QH\u0002J\b\u0010V\u001a\u00020QH\u0002J\r\u0010W\u001a\u00020XH\u0002¢\u0006\u0002\u0010YJ\b\u0010Z\u001a\u00020QH\u0002J\r\u0010[\u001a\u00020\\H\u0002¢\u0006\u0002\u0010]J\b\u0010^\u001a\u00020\u0015H\u0016J\b\u0010_\u001a\u00020QH\u0002J\u0012\u0010`\u001a\u00020>2\b\u00100\u001a\u0004\u0018\u000101H\u0002J\b\u0010a\u001a\u00020>H\u0002J\b\u0010b\u001a\u00020>H\u0002J\b\u0010c\u001a\u00020>H\u0002J\u0012\u0010d\u001a\u00020>2\b\u0010e\u001a\u0004\u0018\u00010fH\u0016J\u0012\u0010g\u001a\u00020h2\b\u0010e\u001a\u0004\u0018\u00010fH\u0016J&\u0010i\u001a\u0004\u0018\u00010\t2\u0006\u0010j\u001a\u00020k2\b\u0010l\u001a\u0004\u0018\u00010m2\b\u0010e\u001a\u0004\u0018\u00010fH\u0016J\b\u0010n\u001a\u00020>H\u0016J\b\u0010o\u001a\u00020>H\u0016J\u0012\u0010p\u001a\u00020>2\b\u0010q\u001a\u0004\u0018\u00010rH\u0016J\u001a\u0010s\u001a\u00020>2\u0006\u0010M\u001a\u00020N2\b\u0010t\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010u\u001a\u00020>2\u0006\u0010M\u001a\u00020NH\u0002J\u0010\u0010v\u001a\u00020>2\u0006\u0010w\u001a\u00020fH\u0016J\u001a\u0010x\u001a\u00020>2\u0006\u0010y\u001a\u00020\t2\b\u0010e\u001a\u0004\u0018\u00010fH\u0017J\u0012\u0010z\u001a\u00020>2\b\u0010M\u001a\u0004\u0018\u00010NH\u0002J\u0012\u0010{\u001a\u00020>2\b\u0010|\u001a\u0004\u0018\u000101H\u0002J\b\u0010}\u001a\u00020>H\u0002J\b\u0010~\u001a\u00020>H\u0002J\u0011\u0010\u001a\u00020>2\u0007\u0010\u0001\u001a\u00020*H\u0002J\t\u0010\u0001\u001a\u00020>H\u0002J\t\u0010\u0001\u001a\u00020>H\u0002J\t\u0010\u0001\u001a\u00020>H\u0002J\t\u0010\u0001\u001a\u00020>H\u0002J\t\u0010\u0001\u001a\u00020>H\u0002J\u0011\u0010\u0001\u001a\u00020>2\u0006\u0010M\u001a\u00020NH\u0002J\t\u0010\u0001\u001a\u00020>H\u0002J\t\u0010\u0001\u001a\u00020>H\u0002J\t\u0010\u0001\u001a\u00020>H\u0002J\t\u0010\u0001\u001a\u00020>H\u0002J\t\u0010\u0001\u001a\u00020>H\u0002J\u0013\u0010\u0001\u001a\u00020>2\b\u00100\u001a\u0004\u0018\u000101H\u0002J\u0012\u0010\u0001\u001a\u00020>2\u0007\u0010\u0001\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010:\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, mo26107d2 = {"Lcom/giphy/sdk/ui/views/GiphyDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "animOpen", "", "attributionAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "attributionView", "Landroid/view/View;", "baseView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "browseContentType", "Lcom/giphy/sdk/ui/GPHContentType;", "containerConstraints", "Landroidx/constraintlayout/widget/ConstraintSet;", "containerView", "Lcom/giphy/sdk/ui/views/GPHTouchInterceptor;", "contentType", "focusAnimator", "fragmentElevation", "", "fullBaseViewHeight", "gifDelivered", "gifResultsOverlay", "gifSelectionListener", "Lcom/giphy/sdk/ui/views/GiphyDialogFragment$GifSelectionListener;", "getGifSelectionListener", "()Lcom/giphy/sdk/ui/views/GiphyDialogFragment$GifSelectionListener;", "setGifSelectionListener", "(Lcom/giphy/sdk/ui/views/GiphyDialogFragment$GifSelectionListener;)V", "gifsRecyclerView", "Lcom/giphy/sdk/ui/views/GifsRecyclerView;", "giphyActionsView", "Lcom/giphy/sdk/ui/views/GPHMediaActionsView;", "giphySettings", "Lcom/giphy/sdk/ui/GPHSettings;", "isAttributionVisible", "isSearchFocused", "()Z", "keepModelData", "keyboardState", "Lcom/giphy/sdk/ui/views/GiphyDialogFragment$KeyboardState;", "mediaSelectorAnimator", "mediaSelectorHeight", "mediaSelectorView", "Lcom/giphy/sdk/ui/views/GPHMediaTypeView;", "openAnimator", "query", "", "resultsConstraints", "searchBar", "Lcom/giphy/sdk/ui/views/GiphySearchBar;", "searchBarConstrains", "searchBarContainer", "searchBarMargin", "searchDimOverlay", "showMediaScrollThreshold", "translateAnimator", "verticalDrag", "", "accumulateDrag", "", "drag", "addDimOverlay", "animateToClose", "animateToHalf", "animateToOpen", "applyDrag", "applyTranslateDrag", "changeLayoutType", "oldLayoutType", "Lcom/giphy/sdk/ui/views/GPHMediaTypeView$LayoutType;", "newLayoutType", "changeMediaType", "createConfirmationView", "deliverGif", "media", "Lcom/giphy/sdk/core/models/Media;", "focusSearch", "getAttributionAnimatorListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "getCloseAnimationListener", "com/giphy/sdk/ui/views/GiphyDialogFragment$getCloseAnimationListener$1", "()Lcom/giphy/sdk/ui/views/GiphyDialogFragment$getCloseAnimationListener$1;", "getFocusAnimationListener", "getMediaSelectorAnimatorListener", "getOpenAnimatorListener", "com/giphy/sdk/ui/views/GiphyDialogFragment$getOpenAnimatorListener$1", "()Lcom/giphy/sdk/ui/views/GiphyDialogFragment$getOpenAnimatorListener$1;", "getOpenTranslationListener", "getRecyclerScrollListener", "com/giphy/sdk/ui/views/GiphyDialogFragment$getRecyclerScrollListener$1", "()Lcom/giphy/sdk/ui/views/GiphyDialogFragment$getRecyclerScrollListener$1;", "getTheme", "getTranslationListener", "gifsQueryChangedFromSearchBar", "handleDragRelease", "hideAttribution", "hideMediaSelector", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onGifPressed", "anchor", "onGifSelected", "onSaveInstanceState", "outState", "onViewCreated", "view", "openGiphyApp", "queryUsername", "username", "releaseFocus", "setGridTypeFromContentType", "setKeyboardState", "state", "setupCarouselView", "setupEmojiView", "setupGifActionsView", "setupGifsRecycler", "setupWaterfallView", "showConfirmationScreen", "showMediaSelector", "transitionBackToSearchFocus", "transitionForwardToSearchFocus", "transitionFromFocusToBrowse", "transitionFromResultsToBrowse", "updateRecyclerViewQuery", "updateResultsCount", "resultsCount", "Companion", "GifSelectionListener", "KeyboardState", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GiphyDialogFragment */
/* compiled from: GiphyDialogFragment.kt */
public final class GiphyDialogFragment extends DialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_MEDIA_TYPE = "key_media_type";
    private static final String KEY_RESULT_COUNT = "key_result_count";
    private static final String KEY_SCREEN_CHANGE = "key_screen_change";
    private static final String KEY_SETTINGS = "gph_giphy_settings";
    private HashMap _$_findViewCache;
    private boolean animOpen = true;
    private final ValueAnimator attributionAnimator = ValueAnimator.ofFloat(new float[]{0.0f, 0.0f});
    /* access modifiers changed from: private */
    public View attributionView;
    /* access modifiers changed from: private */
    public ConstraintLayout baseView;
    private GPHContentType browseContentType = GPHContentType.gif;
    private final ConstraintSet containerConstraints = new ConstraintSet();
    private GPHTouchInterceptor containerView;
    private GPHContentType contentType = GPHContentType.gif;
    private ValueAnimator focusAnimator;
    private final int fragmentElevation = IntExtensionsKt.getPx(6);
    /* access modifiers changed from: private */
    public int fullBaseViewHeight;
    private boolean gifDelivered;
    /* access modifiers changed from: private */
    public View gifResultsOverlay;
    private GifSelectionListener gifSelectionListener;
    /* access modifiers changed from: private */
    public GifsRecyclerView gifsRecyclerView;
    /* access modifiers changed from: private */
    public GPHMediaActionsView giphyActionsView;
    /* access modifiers changed from: private */
    public GPHSettings giphySettings;
    /* access modifiers changed from: private */
    public boolean isAttributionVisible;
    private boolean keepModelData;
    /* access modifiers changed from: private */
    public KeyboardState keyboardState = KeyboardState.CLOSED;
    /* access modifiers changed from: private */
    public ValueAnimator mediaSelectorAnimator;
    private final int mediaSelectorHeight = IntExtensionsKt.getPx(46);
    /* access modifiers changed from: private */
    public GPHMediaTypeView mediaSelectorView;
    /* access modifiers changed from: private */
    public ValueAnimator openAnimator = ValueAnimator.ofFloat(new float[0]);
    /* access modifiers changed from: private */
    public String query;
    private final ConstraintSet resultsConstraints = new ConstraintSet();
    /* access modifiers changed from: private */
    public GiphySearchBar searchBar;
    private final ConstraintSet searchBarConstrains = new ConstraintSet();
    /* access modifiers changed from: private */
    public ConstraintLayout searchBarContainer;
    private int searchBarMargin;
    /* access modifiers changed from: private */
    public View searchDimOverlay;
    /* access modifiers changed from: private */
    public final int showMediaScrollThreshold = IntExtensionsKt.getPx(30);
    private ValueAnimator translateAnimator = ValueAnimator.ofFloat(new float[0]);
    /* access modifiers changed from: private */
    public float verticalDrag;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, mo26107d2 = {"Lcom/giphy/sdk/ui/views/GiphyDialogFragment$GifSelectionListener;", "", "onDismissed", "", "onGifSelected", "media", "Lcom/giphy/sdk/core/models/Media;", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.views.GiphyDialogFragment$GifSelectionListener */
    /* compiled from: GiphyDialogFragment.kt */
    public interface GifSelectionListener {
        void onDismissed();

        void onGifSelected(Media media);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, mo26107d2 = {"Lcom/giphy/sdk/ui/views/GiphyDialogFragment$KeyboardState;", "", "(Ljava/lang/String;I)V", "OPEN", "CLOSED", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.views.GiphyDialogFragment$KeyboardState */
    /* compiled from: GiphyDialogFragment.kt */
    public enum KeyboardState {
        OPEN,
        CLOSED
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.views.GiphyDialogFragment$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[GridType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[GridType.carousel.ordinal()] = 1;
            iArr[GridType.waterfall.ordinal()] = 2;
            iArr[GridType.emoji.ordinal()] = 3;
            int[] iArr2 = new int[GridType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[GridType.waterfall.ordinal()] = 1;
            iArr2[GridType.emoji.ordinal()] = 2;
            iArr2[GridType.carousel.ordinal()] = 3;
            int[] iArr3 = new int[GPHContentType.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[GPHContentType.sticker.ordinal()] = 1;
            iArr3[GPHContentType.text.ordinal()] = 2;
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public static final /* synthetic */ ConstraintLayout access$getBaseView$p(GiphyDialogFragment giphyDialogFragment) {
        ConstraintLayout constraintLayout = giphyDialogFragment.baseView;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseView");
        }
        return constraintLayout;
    }

    public static final /* synthetic */ GifsRecyclerView access$getGifsRecyclerView$p(GiphyDialogFragment giphyDialogFragment) {
        GifsRecyclerView gifsRecyclerView2 = giphyDialogFragment.gifsRecyclerView;
        if (gifsRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
        }
        return gifsRecyclerView2;
    }

    public static final /* synthetic */ GPHSettings access$getGiphySettings$p(GiphyDialogFragment giphyDialogFragment) {
        GPHSettings gPHSettings = giphyDialogFragment.giphySettings;
        if (gPHSettings == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
        }
        return gPHSettings;
    }

    public static final /* synthetic */ ConstraintLayout access$getSearchBarContainer$p(GiphyDialogFragment giphyDialogFragment) {
        ConstraintLayout constraintLayout = giphyDialogFragment.searchBarContainer;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        }
        return constraintLayout;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo26107d2 = {"Lcom/giphy/sdk/ui/views/GiphyDialogFragment$Companion;", "", "()V", "KEY_MEDIA_TYPE", "", "KEY_RESULT_COUNT", "KEY_SCREEN_CHANGE", "KEY_SETTINGS", "newInstance", "Lcom/giphy/sdk/ui/views/GiphyDialogFragment;", "settings", "Lcom/giphy/sdk/ui/GPHSettings;", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.views.GiphyDialogFragment$Companion */
    /* compiled from: GiphyDialogFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ GiphyDialogFragment newInstance$default(Companion companion, GPHSettings gPHSettings, int i, Object obj) {
            if ((i & 1) != 0) {
                gPHSettings = new GPHSettings((GridType) null, (Theme) null, (GPHContentType[]) null, false, false, false, (RatingType) null, (RenditionType) null, (RenditionType) null, FrameMetricsAggregator.EVERY_DURATION, (DefaultConstructorMarker) null);
            }
            return companion.newInstance(gPHSettings);
        }

        public final GiphyDialogFragment newInstance(GPHSettings gPHSettings) {
            Intrinsics.checkParameterIsNotNull(gPHSettings, "settings");
            GiphyDialogFragment giphyDialogFragment = new GiphyDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(GiphyDialogFragment.KEY_SETTINGS, gPHSettings);
            giphyDialogFragment.setArguments(bundle);
            return giphyDialogFragment;
        }
    }

    public final GifSelectionListener getGifSelectionListener() {
        return this.gifSelectionListener;
    }

    public final void setGifSelectionListener(GifSelectionListener gifSelectionListener2) {
        this.gifSelectionListener = gifSelectionListener2;
    }

    public int getTheme() {
        GPHSettings gPHSettings = this.giphySettings;
        if (gPHSettings == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
        }
        return gPHSettings.getGridType() == GridType.carousel ? C1800R.C1805style.GiphyDialogStyle : C1800R.C1805style.GiphyWaterfallDialogStyle;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StringBuilder sb = new StringBuilder();
        sb.append("onCreate ");
        sb.append(hashCode());
        sb.append(' ');
        sb.append(bundle != null ? Boolean.valueOf(bundle.getBoolean(KEY_SCREEN_CHANGE)) : null);
        Timber.m300d(sb.toString(), new Object[0]);
        Bundle arguments = getArguments();
        if (arguments == null) {
            Intrinsics.throwNpe();
        }
        Parcelable parcelable = arguments.getParcelable(KEY_SETTINGS);
        Intrinsics.checkExpressionValueIsNotNull(parcelable, "arguments!!.getParcelable(KEY_SETTINGS)");
        this.giphySettings = (GPHSettings) parcelable;
        GiphyCoreUI giphyCoreUI = GiphyCoreUI.INSTANCE;
        GPHSettings gPHSettings = this.giphySettings;
        if (gPHSettings == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
        }
        giphyCoreUI.setThemeUsed$ui_sdk_release(gPHSettings.getTheme());
        GPHSettings gPHSettings2 = this.giphySettings;
        if (gPHSettings2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
        }
        GPHContentType gPHContentType = (GPHContentType) ArraysKt.firstOrNull((T[]) gPHSettings2.getMediaTypeConfig());
        if (gPHContentType == null) {
            gPHContentType = GPHContentType.gif;
        }
        this.contentType = gPHContentType;
        if (gPHContentType == GPHContentType.emoji) {
            GPHSettings gPHSettings3 = this.giphySettings;
            if (gPHSettings3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
            }
            if (gPHSettings3.getMediaTypeConfig().length == 1) {
                GPHSettings gPHSettings4 = this.giphySettings;
                if (gPHSettings4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
                }
                gPHSettings4.setGridType(GridType.emoji);
            }
        }
        if (bundle != null && bundle.containsKey(KEY_MEDIA_TYPE)) {
            GPHContentType gPHContentType2 = (GPHContentType) bundle.getParcelable(KEY_MEDIA_TYPE);
            Intrinsics.checkExpressionValueIsNotNull(gPHContentType2, "savedInstanceState?.getParcelable(KEY_MEDIA_TYPE)");
            this.contentType = gPHContentType2;
        }
        GPHSettings gPHSettings5 = this.giphySettings;
        if (gPHSettings5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
        }
        if (gPHSettings5.getGridType() == GridType.emoji) {
            this.contentType = GPHContentType.emoji;
        }
        this.searchBarMargin = getResources().getDimensionPixelOffset(C1800R.dimen.gph_gif_border_size);
        this.translateAnimator.addUpdateListener(getTranslationListener());
        ValueAnimator valueAnimator = this.translateAnimator;
        Intrinsics.checkExpressionValueIsNotNull(valueAnimator, "translateAnimator");
        valueAnimator.setDuration(150);
        ValueAnimator valueAnimator2 = this.openAnimator;
        Intrinsics.checkExpressionValueIsNotNull(valueAnimator2, "openAnimator");
        valueAnimator2.setDuration(200);
        this.openAnimator.addUpdateListener(getOpenTranslationListener());
        this.openAnimator.addListener(getOpenAnimatorListener());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        Context context = getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
        this.containerView = new GPHTouchInterceptor(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        this.baseView = new ConstraintLayout(getContext());
        this.searchBarContainer = new ConstraintLayout(getContext());
        ConstraintLayout constraintLayout = this.baseView;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseView");
        }
        constraintLayout.setId(C1800R.C1803id.gifBaseView);
        ConstraintLayout constraintLayout2 = this.searchBarContainer;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        }
        constraintLayout2.setId(C1800R.C1803id.gifSearchBarContainer);
        ConstraintLayout constraintLayout3 = this.baseView;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseView");
        }
        Context context2 = constraintLayout3.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "baseView.context");
        GifsRecyclerView gifsRecyclerView2 = new GifsRecyclerView(context2, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        this.gifsRecyclerView = gifsRecyclerView2;
        gifsRecyclerView2.setId(C1800R.C1803id.gifRecyclerView);
        GifsRecyclerView gifsRecyclerView3 = this.gifsRecyclerView;
        if (gifsRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
        }
        GPHSettings gPHSettings = this.giphySettings;
        if (gPHSettings == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
        }
        gifsRecyclerView3.setBackgroundColor(gPHSettings.getTheme().getBackgroundColor());
        ConstraintLayout constraintLayout4 = this.searchBarContainer;
        if (constraintLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        }
        GPHSettings gPHSettings2 = this.giphySettings;
        if (gPHSettings2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
        }
        constraintLayout4.setBackgroundColor(gPHSettings2.getTheme().getBackgroundColor());
        GPHSettings gPHSettings3 = this.giphySettings;
        if (gPHSettings3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
        }
        int i = WhenMappings.$EnumSwitchMapping$0[gPHSettings3.getGridType().ordinal()];
        boolean z = true;
        if (i == 1) {
            setupCarouselView();
        } else if (i == 2) {
            setupWaterfallView();
        } else if (i == 3) {
            setupEmojiView();
        }
        GPHTouchInterceptor gPHTouchInterceptor = this.containerView;
        if (gPHTouchInterceptor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        }
        ConstraintLayout constraintLayout5 = this.baseView;
        if (constraintLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseView");
        }
        gPHTouchInterceptor.addView(constraintLayout5);
        GPHTouchInterceptor gPHTouchInterceptor2 = this.containerView;
        if (gPHTouchInterceptor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        }
        ConstraintLayout constraintLayout6 = this.searchBarContainer;
        if (constraintLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        }
        gPHTouchInterceptor2.setDragView(constraintLayout6);
        GPHTouchInterceptor gPHTouchInterceptor3 = this.containerView;
        if (gPHTouchInterceptor3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        }
        ConstraintLayout constraintLayout7 = this.baseView;
        if (constraintLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseView");
        }
        gPHTouchInterceptor3.setSlideView(constraintLayout7);
        ConstraintSet constraintSet = this.containerConstraints;
        ConstraintLayout constraintLayout8 = this.searchBarContainer;
        if (constraintLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        }
        constraintSet.constrainDefaultHeight(constraintLayout8.getId(), 1);
        View view = this.searchDimOverlay;
        if (view != null) {
            ConstraintLayout constraintLayout9 = this.searchBarContainer;
            if (constraintLayout9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
            }
            constraintLayout9.addView(view, 0, 0);
        }
        ConstraintLayout constraintLayout10 = this.baseView;
        if (constraintLayout10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseView");
        }
        ConstraintLayout constraintLayout11 = this.searchBarContainer;
        if (constraintLayout11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        }
        constraintLayout10.addView(constraintLayout11, -1, 0);
        ConstraintLayout constraintLayout12 = this.baseView;
        if (constraintLayout12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseView");
        }
        GifsRecyclerView gifsRecyclerView4 = this.gifsRecyclerView;
        if (gifsRecyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
        }
        constraintLayout12.addView(gifsRecyclerView4, -1, 0);
        View view2 = this.gifResultsOverlay;
        if (view2 != null) {
            ConstraintLayout constraintLayout13 = this.baseView;
            if (constraintLayout13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseView");
            }
            constraintLayout13.addView(view2, -1, -1);
        }
        ConstraintSet constraintSet2 = this.searchBarConstrains;
        ConstraintLayout constraintLayout14 = this.searchBarContainer;
        if (constraintLayout14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        }
        constraintSet2.applyTo(constraintLayout14);
        ConstraintSet constraintSet3 = this.containerConstraints;
        ConstraintLayout constraintLayout15 = this.baseView;
        if (constraintLayout15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseView");
        }
        constraintSet3.applyTo(constraintLayout15);
        ConstraintSet constraintSet4 = this.resultsConstraints;
        ConstraintLayout constraintLayout16 = this.baseView;
        if (constraintLayout16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseView");
        }
        constraintSet4.applyTo(constraintLayout16);
        GiphySearchBar giphySearchBar = this.searchBar;
        if (giphySearchBar != null) {
            GPHSettings gPHSettings4 = this.giphySettings;
            if (gPHSettings4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
            }
            if (gPHSettings4.getGridType() != GridType.waterfall) {
                z = false;
            }
            giphySearchBar.setHideKeyboardOnSearch(z);
        }
        GPHTouchInterceptor gPHTouchInterceptor4 = this.containerView;
        if (gPHTouchInterceptor4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        }
        return gPHTouchInterceptor4;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Window window;
        Window window2;
        Intrinsics.checkParameterIsNotNull(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        GiphySearchBar giphySearchBar = this.searchBar;
        if (giphySearchBar != null) {
            giphySearchBar.setGifQueryListener(new GiphyDialogFragment$onViewCreated$1(this));
        }
        GiphySearchBar giphySearchBar2 = this.searchBar;
        if (giphySearchBar2 != null) {
            giphySearchBar2.setOnSearchClickAction(new GiphyDialogFragment$onViewCreated$2(this));
        }
        GiphySearchBar giphySearchBar3 = this.searchBar;
        if (giphySearchBar3 != null) {
            giphySearchBar3.setShowBackButton(true);
        }
        GiphySearchBar giphySearchBar4 = this.searchBar;
        if (giphySearchBar4 != null) {
            giphySearchBar4.setOnBackClickAction(new GiphyDialogFragment$onViewCreated$3(this));
        }
        GPHTouchInterceptor gPHTouchInterceptor = this.containerView;
        if (gPHTouchInterceptor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        }
        GiphyDialogFragment giphyDialogFragment = this;
        gPHTouchInterceptor.setDragAccumulator(new GiphyDialogFragment$onViewCreated$4(giphyDialogFragment));
        GPHTouchInterceptor gPHTouchInterceptor2 = this.containerView;
        if (gPHTouchInterceptor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        }
        gPHTouchInterceptor2.setDragRelease(new GiphyDialogFragment$onViewCreated$5(giphyDialogFragment));
        GPHTouchInterceptor gPHTouchInterceptor3 = this.containerView;
        if (gPHTouchInterceptor3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        }
        gPHTouchInterceptor3.setTouchOutside(new GiphyDialogFragment$onViewCreated$6(giphyDialogFragment));
        GPHSettings gPHSettings = this.giphySettings;
        if (gPHSettings == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
        }
        if (gPHSettings.getGridType() == GridType.carousel) {
            Dialog dialog = getDialog();
            if (!(dialog == null || (window2 = dialog.getWindow()) == null)) {
                window2.setSoftInputMode(4);
            }
        } else {
            Dialog dialog2 = getDialog();
            if (!(dialog2 == null || (window = dialog2.getWindow()) == null)) {
                window.setSoftInputMode(19);
            }
        }
        view.addOnLayoutChangeListener(new GiphyDialogFragment$onViewCreated$7(this));
        View view2 = this.gifResultsOverlay;
        if (view2 != null) {
            view2.setAlpha(0.0f);
        }
        View view3 = this.searchDimOverlay;
        if (view3 != null) {
            view3.setAlpha(0.0f);
        }
        ConstraintLayout constraintLayout = this.baseView;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseView");
        }
        GPHSettings gPHSettings2 = this.giphySettings;
        if (gPHSettings2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
        }
        constraintLayout.setBackgroundColor(gPHSettings2.getTheme().getBackgroundColor());
        ConstraintLayout constraintLayout2 = this.baseView;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseView");
        }
        constraintLayout2.setVisibility(4);
        ConstraintLayout constraintLayout3 = this.baseView;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseView");
        }
        ViewCompat.setElevation(constraintLayout3, (float) this.fragmentElevation);
        GPHMediaTypeView gPHMediaTypeView = this.mediaSelectorView;
        if (gPHMediaTypeView != null) {
            gPHMediaTypeView.setResultCount(bundle != null ? bundle.getInt(KEY_RESULT_COUNT) : 0);
        }
        GPHTouchInterceptor gPHTouchInterceptor4 = this.containerView;
        if (gPHTouchInterceptor4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        }
        gPHTouchInterceptor4.setOnClickListener(new GiphyDialogFragment$onViewCreated$8(this));
    }

    public Dialog onCreateDialog(Bundle bundle) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Intrinsics.throwNpe();
        }
        GiphyDialogFragment$onCreateDialog$dialog$1 giphyDialogFragment$onCreateDialog$dialog$1 = new GiphyDialogFragment$onCreateDialog$dialog$1(this, activity, getTheme());
        giphyDialogFragment$onCreateDialog$dialog$1.setOnShowListener(new GiphyDialogFragment$onCreateDialog$1(this));
        return giphyDialogFragment$onCreateDialog$dialog$1;
    }

    /* access modifiers changed from: private */
    public final void gifsQueryChangedFromSearchBar(String str) {
        if (this.contentType == GPHContentType.emoji) {
            this.contentType = GPHContentType.gif;
            GifsRecyclerView gifsRecyclerView2 = this.gifsRecyclerView;
            if (gifsRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
            }
            gifsRecyclerView2.setMediaType(this.contentType.getMediaType());
            setGridTypeFromContentType();
        }
        CharSequence charSequence = str;
        boolean z = false;
        if (charSequence == null || charSequence.length() == 0) {
            if (this.keyboardState == KeyboardState.OPEN) {
                focusSearch();
            }
            GPHMediaTypeView gPHMediaTypeView = this.mediaSelectorView;
            if (gPHMediaTypeView != null) {
                if (this.keyboardState == KeyboardState.OPEN) {
                    z = true;
                }
                gPHMediaTypeView.showCategories(z);
            }
        }
        updateRecyclerViewQuery(str);
    }

    private final void updateRecyclerViewQuery(String str) {
        GifsQuery gifsQuery;
        this.query = str;
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            GifsRecyclerView gifsRecyclerView2 = this.gifsRecyclerView;
            if (gifsRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
            }
            if (this.contentType == GPHContentType.emoji) {
                gifsQuery = GifsQuery.Companion.emojiQuery();
            } else {
                GifsQuery.Companion companion = GifsQuery.Companion;
                MediaType mediaType = this.contentType.getMediaType();
                GPHSettings gPHSettings = this.giphySettings;
                if (gPHSettings == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
                }
                gifsQuery = companion.trendingQuery(mediaType, gPHSettings.getRating());
            }
            gifsRecyclerView2.setQuery(gifsQuery);
            return;
        }
        GifsRecyclerView gifsRecyclerView3 = this.gifsRecyclerView;
        if (gifsRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
        }
        GifsQuery.Companion companion2 = GifsQuery.Companion;
        MediaType mediaType2 = this.contentType.getMediaType();
        GPHSettings gPHSettings2 = this.giphySettings;
        if (gPHSettings2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
        }
        gifsRecyclerView3.setQuery(companion2.searchQuery(str, mediaType2, gPHSettings2.getRating()));
    }

    /* access modifiers changed from: private */
    public final void queryUsername(String str) {
        EditText editText;
        GiphySearchBar giphySearchBar = this.searchBar;
        if (giphySearchBar != null && (editText = (EditText) giphySearchBar._$_findCachedViewById(C1800R.C1803id.searchInput)) != null) {
            editText.setText('@' + str);
        }
    }

    /* access modifiers changed from: private */
    public final void setupGifsRecycler() {
        GifsQuery gifsQuery;
        setGridTypeFromContentType();
        GPHSettings gPHSettings = this.giphySettings;
        if (gPHSettings == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
        }
        if (gPHSettings.getGridType() == GridType.waterfall) {
            GifsRecyclerView gifsRecyclerView2 = this.gifsRecyclerView;
            if (gifsRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
            }
            GPHSettings gPHSettings2 = this.giphySettings;
            if (gPHSettings2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
            }
            gifsRecyclerView2.setRenditionType(gPHSettings2.getRenditionType());
        }
        GifsRecyclerView gifsRecyclerView3 = this.gifsRecyclerView;
        if (gifsRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
        }
        gifsRecyclerView3.setMediaType(this.contentType.getMediaType());
        GifsRecyclerView gifsRecyclerView4 = this.gifsRecyclerView;
        if (gifsRecyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
        }
        GPHSettings gPHSettings3 = this.giphySettings;
        if (gPHSettings3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
        }
        if (gPHSettings3.getGridType() == GridType.emoji) {
            gifsQuery = GifsQuery.Companion.emojiQuery();
        } else {
            GifsQuery.Companion companion = GifsQuery.Companion;
            MediaType mediaType = this.contentType.getMediaType();
            GPHSettings gPHSettings4 = this.giphySettings;
            if (gPHSettings4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
            }
            gifsQuery = companion.trendingQuery(mediaType, gPHSettings4.getRating());
        }
        gifsRecyclerView4.setQuery(gifsQuery);
        GifsRecyclerView gifsRecyclerView5 = this.gifsRecyclerView;
        if (gifsRecyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
        }
        gifsRecyclerView5.configure((Fragment) this);
        GifsRecyclerView gifsRecyclerView6 = this.gifsRecyclerView;
        if (gifsRecyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
        }
        GiphyDialogFragment giphyDialogFragment = this;
        gifsRecyclerView6.setOnResultsUpdateListener(new GiphyDialogFragment$setupGifsRecycler$1(giphyDialogFragment));
        GifsRecyclerView gifsRecyclerView7 = this.gifsRecyclerView;
        if (gifsRecyclerView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
        }
        gifsRecyclerView7.setOnGifSelectedListener(new GiphyDialogFragment$setupGifsRecycler$2(giphyDialogFragment));
        GifsRecyclerView gifsRecyclerView8 = this.gifsRecyclerView;
        if (gifsRecyclerView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
        }
        gifsRecyclerView8.setOnGifLongPressListener(new GiphyDialogFragment$setupGifsRecycler$3(giphyDialogFragment));
        GifsRecyclerView gifsRecyclerView9 = this.gifsRecyclerView;
        if (gifsRecyclerView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
        }
        gifsRecyclerView9.addOnScrollListener(getRecyclerScrollListener());
    }

    /* access modifiers changed from: private */
    public final void setupGifActionsView() {
        GPHMediaActionsView gPHMediaActionsView = new GPHMediaActionsView(getActivity(), new GPHActions[]{GPHActions.SearchMore, GPHActions.OpenGiphy});
        this.giphyActionsView = gPHMediaActionsView;
        if (gPHMediaActionsView != null) {
            gPHMediaActionsView.setOnShowMore(new GiphyDialogFragment$setupGifActionsView$1(this));
        }
    }

    private final GiphyDialogFragment$getRecyclerScrollListener$1 getRecyclerScrollListener() {
        return new GiphyDialogFragment$getRecyclerScrollListener$1(this);
    }

    private final void setupCarouselView() {
        EditText editText;
        int i;
        ConstraintLayout constraintLayout = this.baseView;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseView");
        }
        Context context = constraintLayout.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "baseView.context");
        GPHSettings gPHSettings = this.giphySettings;
        if (gPHSettings == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
        }
        GiphySearchBar giphySearchBar = new GiphySearchBar(context, gPHSettings.getTheme());
        this.searchBar = giphySearchBar;
        giphySearchBar.setId(C1800R.C1803id.gifSearchBar);
        ConstraintSet constraintSet = this.containerConstraints;
        ConstraintLayout constraintLayout2 = this.searchBarContainer;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        }
        constraintSet.connect(constraintLayout2.getId(), 4, 0, 4);
        ConstraintSet constraintSet2 = this.containerConstraints;
        ConstraintLayout constraintLayout3 = this.searchBarContainer;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        }
        constraintSet2.connect(constraintLayout3.getId(), 6, 0, 6);
        ConstraintSet constraintSet3 = this.containerConstraints;
        ConstraintLayout constraintLayout4 = this.searchBarContainer;
        if (constraintLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        }
        constraintSet3.connect(constraintLayout4.getId(), 7, 0, 7);
        ConstraintSet constraintSet4 = this.resultsConstraints;
        GifsRecyclerView gifsRecyclerView2 = this.gifsRecyclerView;
        if (gifsRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
        }
        int id = gifsRecyclerView2.getId();
        ConstraintLayout constraintLayout5 = this.searchBarContainer;
        if (constraintLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        }
        constraintSet4.connect(id, 4, constraintLayout5.getId(), 3);
        ConstraintSet constraintSet5 = this.resultsConstraints;
        GifsRecyclerView gifsRecyclerView3 = this.gifsRecyclerView;
        if (gifsRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
        }
        constraintSet5.connect(gifsRecyclerView3.getId(), 6, 0, 6);
        ConstraintSet constraintSet6 = this.resultsConstraints;
        GifsRecyclerView gifsRecyclerView4 = this.gifsRecyclerView;
        if (gifsRecyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
        }
        constraintSet6.connect(gifsRecyclerView4.getId(), 7, 0, 7);
        ConstraintSet constraintSet7 = this.resultsConstraints;
        GifsRecyclerView gifsRecyclerView5 = this.gifsRecyclerView;
        if (gifsRecyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
        }
        constraintSet7.constrainHeight(gifsRecyclerView5.getId(), getResources().getDimensionPixelSize(C1800R.dimen.gph_carrousel_height));
        GiphySearchBar giphySearchBar2 = this.searchBar;
        if (giphySearchBar2 != null) {
            this.searchBarConstrains.connect(giphySearchBar2.getId(), 3, 0, 3);
            this.searchBarConstrains.constrainHeight(giphySearchBar2.getId(), 1);
            this.searchBarConstrains.setMargin(giphySearchBar2.getId(), 3, this.searchBarMargin);
            this.searchBarConstrains.setMargin(giphySearchBar2.getId(), 4, this.searchBarMargin);
            this.searchBarConstrains.connect(giphySearchBar2.getId(), 4, 0, 4);
            this.searchBarConstrains.connect(giphySearchBar2.getId(), 6, 0, 6);
            this.searchBarConstrains.connect(giphySearchBar2.getId(), 7, 0, 7);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        ConstraintLayout constraintLayout6 = this.baseView;
        if (constraintLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseView");
        }
        constraintLayout6.setLayoutParams(layoutParams);
        GiphySearchBar giphySearchBar3 = this.searchBar;
        if (!(giphySearchBar3 == null || (editText = (EditText) giphySearchBar3._$_findCachedViewById(C1800R.C1803id.searchInput)) == null)) {
            int i2 = WhenMappings.$EnumSwitchMapping$2[this.contentType.ordinal()];
            if (i2 == 1) {
                i = C1800R.string.gph_search_giphy_stickers;
            } else if (i2 != 2) {
                i = C1800R.string.gph_search_giphy;
            } else {
                i = C1800R.string.gph_search_giphy_text;
            }
            editText.setHint(i);
        }
        ConstraintLayout constraintLayout7 = this.searchBarContainer;
        if (constraintLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        }
        constraintLayout7.addView(this.searchBar, -1, 0);
    }

    private final void setupWaterfallView() {
        ConstraintLayout constraintLayout = this.baseView;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseView");
        }
        Context context = constraintLayout.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "baseView.context");
        GPHSettings gPHSettings = this.giphySettings;
        if (gPHSettings == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
        }
        GiphySearchBar giphySearchBar = new GiphySearchBar(context, gPHSettings.getTheme());
        this.searchBar = giphySearchBar;
        if (giphySearchBar != null) {
            giphySearchBar.setId(C1800R.C1803id.gifSearchBar);
        }
        ConstraintSet constraintSet = this.containerConstraints;
        ConstraintLayout constraintLayout2 = this.searchBarContainer;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        }
        constraintSet.connect(constraintLayout2.getId(), 3, 0, 3);
        ConstraintSet constraintSet2 = this.containerConstraints;
        ConstraintLayout constraintLayout3 = this.searchBarContainer;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        }
        constraintSet2.connect(constraintLayout3.getId(), 6, 0, 6);
        ConstraintSet constraintSet3 = this.containerConstraints;
        ConstraintLayout constraintLayout4 = this.searchBarContainer;
        if (constraintLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        }
        constraintSet3.connect(constraintLayout4.getId(), 7, 0, 7);
        ConstraintSet constraintSet4 = this.resultsConstraints;
        GifsRecyclerView gifsRecyclerView2 = this.gifsRecyclerView;
        if (gifsRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
        }
        int id = gifsRecyclerView2.getId();
        ConstraintLayout constraintLayout5 = this.searchBarContainer;
        if (constraintLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        }
        constraintSet4.connect(id, 3, constraintLayout5.getId(), 4);
        ConstraintSet constraintSet5 = this.resultsConstraints;
        GifsRecyclerView gifsRecyclerView3 = this.gifsRecyclerView;
        if (gifsRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
        }
        constraintSet5.connect(gifsRecyclerView3.getId(), 4, 0, 4);
        ConstraintSet constraintSet6 = this.resultsConstraints;
        GifsRecyclerView gifsRecyclerView4 = this.gifsRecyclerView;
        if (gifsRecyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
        }
        constraintSet6.connect(gifsRecyclerView4.getId(), 6, 0, 6);
        ConstraintSet constraintSet7 = this.resultsConstraints;
        GifsRecyclerView gifsRecyclerView5 = this.gifsRecyclerView;
        if (gifsRecyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
        }
        constraintSet7.connect(gifsRecyclerView5.getId(), 7, 0, 7);
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(C1800R.C1802drawable.gph_drag_spot);
        imageView.setId(C1800R.C1803id.gifDragEdge);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        GPHSettings gPHSettings2 = this.giphySettings;
        if (gPHSettings2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
        }
        imageView.setColorFilter(gPHSettings2.getTheme().getHandleBarColor());
        this.searchBarConstrains.connect(imageView.getId(), 3, 0, 3);
        this.searchBarConstrains.connect(imageView.getId(), 6, 0, 6);
        this.searchBarConstrains.connect(imageView.getId(), 7, 0, 7);
        this.searchBarConstrains.setMargin(imageView.getId(), 3, this.searchBarMargin);
        this.searchBarConstrains.constrainHeight(imageView.getId(), 20);
        this.searchBarConstrains.constrainWidth(imageView.getId(), ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        GiphySearchBar giphySearchBar2 = this.searchBar;
        if (giphySearchBar2 != null) {
            this.searchBarConstrains.connect(giphySearchBar2.getId(), 3, imageView.getId(), 4);
            this.searchBarConstrains.constrainHeight(giphySearchBar2.getId(), 1);
            this.searchBarConstrains.connect(giphySearchBar2.getId(), 6, 0, 6);
            this.searchBarConstrains.connect(giphySearchBar2.getId(), 7, 0, 7);
            this.searchBarConstrains.setMargin(giphySearchBar2.getId(), 3, this.searchBarMargin);
            this.searchBarConstrains.setMargin(giphySearchBar2.getId(), 4, this.searchBarMargin);
        }
        ConstraintLayout constraintLayout6 = this.searchBarContainer;
        if (constraintLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        }
        constraintLayout6.addView(imageView, -2, -2);
        Context context2 = getContext();
        GPHSettings gPHSettings3 = this.giphySettings;
        if (gPHSettings3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
        }
        Theme theme = gPHSettings3.getTheme();
        GPHSettings gPHSettings4 = this.giphySettings;
        if (gPHSettings4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
        }
        GPHMediaTypeView gPHMediaTypeView = new GPHMediaTypeView(context2, theme, gPHSettings4.getMediaTypeConfig());
        this.mediaSelectorView = gPHMediaTypeView;
        if (gPHMediaTypeView != null) {
            gPHMediaTypeView.setId(C1800R.C1803id.gifMediaSelector);
        }
        GPHMediaTypeView gPHMediaTypeView2 = this.mediaSelectorView;
        if (gPHMediaTypeView2 != null) {
            gPHMediaTypeView2.setMediaConfigListener(new GiphyDialogFragment$setupWaterfallView$2(this));
        }
        GPHMediaTypeView gPHMediaTypeView3 = this.mediaSelectorView;
        if (gPHMediaTypeView3 != null) {
            gPHMediaTypeView3.setLayoutTypeListener(new GiphyDialogFragment$setupWaterfallView$3(this));
        }
        GPHMediaTypeView gPHMediaTypeView4 = this.mediaSelectorView;
        if (gPHMediaTypeView4 != null) {
            gPHMediaTypeView4.setGphContentType(this.contentType);
        }
        ConstraintSet constraintSet8 = this.searchBarConstrains;
        GPHMediaTypeView gPHMediaTypeView5 = this.mediaSelectorView;
        if (gPHMediaTypeView5 == null) {
            Intrinsics.throwNpe();
        }
        int id2 = gPHMediaTypeView5.getId();
        GiphySearchBar giphySearchBar3 = this.searchBar;
        if (giphySearchBar3 == null) {
            Intrinsics.throwNpe();
        }
        constraintSet8.connect(id2, 3, giphySearchBar3.getId(), 4);
        ConstraintSet constraintSet9 = this.searchBarConstrains;
        GPHMediaTypeView gPHMediaTypeView6 = this.mediaSelectorView;
        if (gPHMediaTypeView6 == null) {
            Intrinsics.throwNpe();
        }
        constraintSet9.connect(gPHMediaTypeView6.getId(), 6, 0, 6);
        ConstraintSet constraintSet10 = this.searchBarConstrains;
        GPHMediaTypeView gPHMediaTypeView7 = this.mediaSelectorView;
        if (gPHMediaTypeView7 == null) {
            Intrinsics.throwNpe();
        }
        constraintSet10.connect(gPHMediaTypeView7.getId(), 7, 0, 7);
        ConstraintSet constraintSet11 = this.searchBarConstrains;
        GPHMediaTypeView gPHMediaTypeView8 = this.mediaSelectorView;
        if (gPHMediaTypeView8 == null) {
            Intrinsics.throwNpe();
        }
        constraintSet11.connect(gPHMediaTypeView8.getId(), 4, 0, 4);
        ConstraintSet constraintSet12 = this.searchBarConstrains;
        GPHMediaTypeView gPHMediaTypeView9 = this.mediaSelectorView;
        if (gPHMediaTypeView9 == null) {
            Intrinsics.throwNpe();
        }
        constraintSet12.constrainWidth(gPHMediaTypeView9.getId(), 0);
        ConstraintSet constraintSet13 = this.searchBarConstrains;
        GPHMediaTypeView gPHMediaTypeView10 = this.mediaSelectorView;
        if (gPHMediaTypeView10 == null) {
            Intrinsics.throwNpe();
        }
        constraintSet13.constrainHeight(gPHMediaTypeView10.getId(), this.mediaSelectorHeight);
        ConstraintSet constraintSet14 = this.searchBarConstrains;
        GPHMediaTypeView gPHMediaTypeView11 = this.mediaSelectorView;
        if (gPHMediaTypeView11 == null) {
            Intrinsics.throwNpe();
        }
        constraintSet14.setMargin(gPHMediaTypeView11.getId(), 3, this.searchBarMargin / 2);
        ConstraintSet constraintSet15 = this.searchBarConstrains;
        GPHMediaTypeView gPHMediaTypeView12 = this.mediaSelectorView;
        if (gPHMediaTypeView12 == null) {
            Intrinsics.throwNpe();
        }
        constraintSet15.setMargin(gPHMediaTypeView12.getId(), 4, this.searchBarMargin / 2);
        ConstraintLayout constraintLayout7 = this.searchBarContainer;
        if (constraintLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        }
        constraintLayout7.addView(this.mediaSelectorView);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 0});
        this.mediaSelectorAnimator = ofInt;
        if (ofInt != null) {
            ofInt.addUpdateListener(getMediaSelectorAnimatorListener());
        }
        ValueAnimator valueAnimator = this.mediaSelectorAnimator;
        if (valueAnimator != null) {
            valueAnimator.setDuration(100);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 80;
        ConstraintLayout constraintLayout8 = this.baseView;
        if (constraintLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseView");
        }
        constraintLayout8.setLayoutParams(layoutParams);
        GPHSettings gPHSettings5 = this.giphySettings;
        if (gPHSettings5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
        }
        if (gPHSettings5.getDimBackground()) {
            addDimOverlay();
        }
        ConstraintLayout constraintLayout9 = this.searchBarContainer;
        if (constraintLayout9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        }
        constraintLayout9.addView(this.searchBar, -1, 0);
    }

    private final void setupEmojiView() {
        ConstraintSet constraintSet = this.containerConstraints;
        ConstraintLayout constraintLayout = this.searchBarContainer;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        }
        constraintSet.connect(constraintLayout.getId(), 3, 0, 3);
        ConstraintSet constraintSet2 = this.containerConstraints;
        ConstraintLayout constraintLayout2 = this.searchBarContainer;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        }
        constraintSet2.connect(constraintLayout2.getId(), 6, 0, 6);
        ConstraintSet constraintSet3 = this.containerConstraints;
        ConstraintLayout constraintLayout3 = this.searchBarContainer;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        }
        constraintSet3.connect(constraintLayout3.getId(), 7, 0, 7);
        ConstraintSet constraintSet4 = this.resultsConstraints;
        GifsRecyclerView gifsRecyclerView2 = this.gifsRecyclerView;
        if (gifsRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
        }
        int id = gifsRecyclerView2.getId();
        ConstraintLayout constraintLayout4 = this.searchBarContainer;
        if (constraintLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        }
        constraintSet4.connect(id, 3, constraintLayout4.getId(), 4);
        ConstraintSet constraintSet5 = this.resultsConstraints;
        GifsRecyclerView gifsRecyclerView3 = this.gifsRecyclerView;
        if (gifsRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
        }
        constraintSet5.connect(gifsRecyclerView3.getId(), 4, 0, 4);
        ConstraintSet constraintSet6 = this.resultsConstraints;
        GifsRecyclerView gifsRecyclerView4 = this.gifsRecyclerView;
        if (gifsRecyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
        }
        constraintSet6.connect(gifsRecyclerView4.getId(), 6, 0, 6);
        ConstraintSet constraintSet7 = this.resultsConstraints;
        GifsRecyclerView gifsRecyclerView5 = this.gifsRecyclerView;
        if (gifsRecyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
        }
        constraintSet7.connect(gifsRecyclerView5.getId(), 7, 0, 7);
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(C1800R.C1802drawable.gph_drag_spot);
        imageView.setId(C1800R.C1803id.gifDragEdge);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        GPHSettings gPHSettings = this.giphySettings;
        if (gPHSettings == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
        }
        imageView.setColorFilter(gPHSettings.getTheme().getHandleBarColor());
        this.searchBarConstrains.connect(imageView.getId(), 3, 0, 3);
        this.searchBarConstrains.connect(imageView.getId(), 6, 0, 6);
        this.searchBarConstrains.connect(imageView.getId(), 7, 0, 7);
        this.searchBarConstrains.connect(imageView.getId(), 4, 0, 4);
        this.searchBarConstrains.setMargin(imageView.getId(), 3, this.searchBarMargin * 2);
        this.searchBarConstrains.setMargin(imageView.getId(), 4, this.searchBarMargin * 2);
        this.searchBarConstrains.constrainHeight(imageView.getId(), 20);
        this.searchBarConstrains.constrainWidth(imageView.getId(), ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        ConstraintLayout constraintLayout5 = this.searchBarContainer;
        if (constraintLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        }
        constraintLayout5.addView(imageView, -2, -2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 80;
        ConstraintLayout constraintLayout6 = this.baseView;
        if (constraintLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseView");
        }
        constraintLayout6.setLayoutParams(layoutParams);
    }

    private final void addDimOverlay() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.focusAnimator = ofFloat;
        if (ofFloat != null) {
            ofFloat.addUpdateListener(getFocusAnimationListener());
        }
        ValueAnimator valueAnimator = this.focusAnimator;
        if (valueAnimator != null) {
            valueAnimator.setDuration(100);
        }
        View view = new View(getContext());
        this.searchDimOverlay = view;
        if (view != null) {
            view.setId(C1800R.C1803id.gifSearchOverlay);
        }
        View view2 = this.searchDimOverlay;
        if (view2 != null) {
            GPHSettings gPHSettings = this.giphySettings;
            if (gPHSettings == null) {
                Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
            }
            view2.setBackgroundColor(gPHSettings.getTheme().getDimOverlayColor());
        }
        ConstraintSet constraintSet = this.searchBarConstrains;
        View view3 = this.searchDimOverlay;
        if (view3 == null) {
            Intrinsics.throwNpe();
        }
        constraintSet.connect(view3.getId(), 6, 0, 6);
        ConstraintSet constraintSet2 = this.searchBarConstrains;
        View view4 = this.searchDimOverlay;
        if (view4 == null) {
            Intrinsics.throwNpe();
        }
        constraintSet2.connect(view4.getId(), 7, 0, 7);
        ConstraintSet constraintSet3 = this.searchBarConstrains;
        View view5 = this.searchDimOverlay;
        if (view5 == null) {
            Intrinsics.throwNpe();
        }
        constraintSet3.connect(view5.getId(), 3, 0, 3);
        ConstraintSet constraintSet4 = this.searchBarConstrains;
        View view6 = this.searchDimOverlay;
        if (view6 == null) {
            Intrinsics.throwNpe();
        }
        constraintSet4.connect(view6.getId(), 4, 0, 4);
        View view7 = new View(getContext());
        this.gifResultsOverlay = view7;
        if (view7 != null) {
            view7.setId(C1800R.C1803id.gifListOverlay);
        }
        View view8 = this.gifResultsOverlay;
        if (view8 != null) {
            GPHSettings gPHSettings2 = this.giphySettings;
            if (gPHSettings2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
            }
            view8.setBackgroundColor(gPHSettings2.getTheme().getDimOverlayColor());
        }
        ConstraintSet constraintSet5 = this.resultsConstraints;
        View view9 = this.gifResultsOverlay;
        if (view9 == null) {
            Intrinsics.throwNpe();
        }
        int id = view9.getId();
        ConstraintLayout constraintLayout = this.searchBarContainer;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        }
        constraintSet5.connect(id, 3, constraintLayout.getId(), 4);
        ConstraintSet constraintSet6 = this.resultsConstraints;
        View view10 = this.gifResultsOverlay;
        if (view10 == null) {
            Intrinsics.throwNpe();
        }
        constraintSet6.connect(view10.getId(), 4, 0, 4);
        ConstraintSet constraintSet7 = this.resultsConstraints;
        View view11 = this.gifResultsOverlay;
        if (view11 == null) {
            Intrinsics.throwNpe();
        }
        constraintSet7.connect(view11.getId(), 6, 0, 6);
        ConstraintSet constraintSet8 = this.resultsConstraints;
        View view12 = this.gifResultsOverlay;
        if (view12 == null) {
            Intrinsics.throwNpe();
        }
        constraintSet8.connect(view12.getId(), 7, 0, 7);
    }

    /* access modifiers changed from: private */
    public final void accumulateDrag(float f) {
        Timber.m300d("accumulateDrag " + f, new Object[0]);
        float f2 = this.verticalDrag + f;
        this.verticalDrag = f2;
        float max = Math.max(f2, 0.0f);
        this.verticalDrag = max;
        applyDrag(max);
    }

    /* access modifiers changed from: private */
    public final void applyTranslateDrag(float f) {
        this.verticalDrag = f;
        ConstraintLayout constraintLayout = this.baseView;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseView");
        }
        constraintLayout.setTranslationY(f);
    }

    /* access modifiers changed from: private */
    public final void applyDrag(float f) {
        if (this.fullBaseViewHeight == 0) {
            ConstraintLayout constraintLayout = this.baseView;
            if (constraintLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseView");
            }
            this.fullBaseViewHeight = constraintLayout.getHeight();
        }
        this.verticalDrag = f;
        ConstraintLayout constraintLayout2 = this.baseView;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseView");
        }
        ViewGroup.LayoutParams layoutParams = constraintLayout2.getLayoutParams();
        if (layoutParams != null) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = (int) this.verticalDrag;
            ConstraintLayout constraintLayout3 = this.baseView;
            if (constraintLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseView");
            }
            constraintLayout3.requestLayout();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    /* access modifiers changed from: private */
    public final void handleDragRelease() {
        float f = this.verticalDrag;
        int i = this.fullBaseViewHeight;
        if (f < ((float) i) * 0.25f) {
            animateToOpen();
        } else if (f >= ((float) i) * 0.25f && f < ((float) i) * 0.6f) {
            animateToHalf();
        } else if (f >= ((float) i) * 0.6f) {
            animateToClose();
        }
    }

    private final void animateToOpen() {
        Timber.m300d("animateToOpen", new Object[0]);
        this.translateAnimator.setFloatValues(new float[]{this.verticalDrag, 0.0f});
        this.translateAnimator.start();
    }

    private final void animateToHalf() {
        Timber.m300d("animateToHalf", new Object[0]);
        this.translateAnimator.setFloatValues(new float[]{this.verticalDrag, ((float) this.fullBaseViewHeight) * 0.25f});
        this.translateAnimator.start();
    }

    private final void animateToClose() {
        Timber.m300d("animateToClose", new Object[0]);
        this.translateAnimator.setFloatValues(new float[]{this.verticalDrag, (float) this.fullBaseViewHeight});
        this.translateAnimator.addListener(getCloseAnimationListener());
        this.translateAnimator.start();
    }

    private final ValueAnimator.AnimatorUpdateListener getTranslationListener() {
        return new GiphyDialogFragment$getTranslationListener$1(this);
    }

    private final ValueAnimator.AnimatorUpdateListener getOpenTranslationListener() {
        return new GiphyDialogFragment$getOpenTranslationListener$1(this);
    }

    private final GiphyDialogFragment$getOpenAnimatorListener$1 getOpenAnimatorListener() {
        return new GiphyDialogFragment$getOpenAnimatorListener$1(this);
    }

    private final GiphyDialogFragment$getCloseAnimationListener$1 getCloseAnimationListener() {
        return new GiphyDialogFragment$getCloseAnimationListener$1(this);
    }

    /* access modifiers changed from: private */
    public final void changeMediaType(GPHContentType gPHContentType) {
        this.contentType = gPHContentType;
        GifsRecyclerView gifsRecyclerView2 = this.gifsRecyclerView;
        if (gifsRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
        }
        gifsRecyclerView2.setMediaType(gPHContentType.getMediaType());
        setGridTypeFromContentType();
        updateRecyclerViewQuery(this.query);
    }

    private final void setGridTypeFromContentType() {
        if (this.contentType == GPHContentType.emoji) {
            GifsRecyclerView gifsRecyclerView2 = this.gifsRecyclerView;
            if (gifsRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
            }
            gifsRecyclerView2.setGridType(GridType.emoji);
            return;
        }
        GifsRecyclerView gifsRecyclerView3 = this.gifsRecyclerView;
        if (gifsRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
        }
        GPHSettings gPHSettings = this.giphySettings;
        if (gPHSettings == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
        }
        gifsRecyclerView3.setGridType(gPHSettings.getGridType());
    }

    /* access modifiers changed from: private */
    public final void updateResultsCount(int i) {
        GPHMediaTypeView gPHMediaTypeView;
        CharSequence charSequence = this.query;
        boolean z = false;
        if (!(charSequence == null || charSequence.length() == 0) && (gPHMediaTypeView = this.mediaSelectorView) != null) {
            gPHMediaTypeView.showSearchResults();
        }
        GPHMediaTypeView gPHMediaTypeView2 = this.mediaSelectorView;
        if (gPHMediaTypeView2 != null) {
            gPHMediaTypeView2.setResultCount(i);
        }
        CharSequence charSequence2 = this.query;
        if (charSequence2 == null || charSequence2.length() == 0) {
            z = true;
        }
        if (!z) {
            releaseFocus();
        }
    }

    /* access modifiers changed from: private */
    public final void setKeyboardState(KeyboardState keyboardState2) {
        this.keyboardState = keyboardState2;
        GiphySearchBar giphySearchBar = this.searchBar;
        if (giphySearchBar != null) {
            giphySearchBar.setKeyboardState(keyboardState2);
        }
        if (this.keyboardState == KeyboardState.OPEN) {
            focusSearch();
        } else {
            releaseFocus();
        }
    }

    private final void focusSearch() {
        ValueAnimator valueAnimator;
        Timber.m300d("focusSearch", new Object[0]);
        ValueAnimator valueAnimator2 = this.focusAnimator;
        if (!(valueAnimator2 == null || valueAnimator2.getAnimatedFraction() != 0.0f || (valueAnimator = this.focusAnimator) == null)) {
            valueAnimator.start();
        }
        animateToOpen();
        GPHMediaTypeView gPHMediaTypeView = this.mediaSelectorView;
        if (gPHMediaTypeView != null) {
            gPHMediaTypeView.onSearchFocus(true);
        }
    }

    private final void releaseFocus() {
        ValueAnimator valueAnimator;
        Timber.m300d("releaseFocus", new Object[0]);
        ValueAnimator valueAnimator2 = this.focusAnimator;
        if ((valueAnimator2 == null || valueAnimator2.getAnimatedFraction() != 0.0f) && (valueAnimator = this.focusAnimator) != null) {
            valueAnimator.reverse();
        }
        GPHMediaTypeView gPHMediaTypeView = this.mediaSelectorView;
        if (gPHMediaTypeView != null) {
            gPHMediaTypeView.onSearchFocus(false);
        }
    }

    /* access modifiers changed from: private */
    public final void changeLayoutType(GPHMediaTypeView.LayoutType layoutType, GPHMediaTypeView.LayoutType layoutType2) {
        if (layoutType == GPHMediaTypeView.LayoutType.browse && layoutType2 == GPHMediaTypeView.LayoutType.searchFocus) {
            transitionForwardToSearchFocus();
        } else if (layoutType == GPHMediaTypeView.LayoutType.searchResults && layoutType2 == GPHMediaTypeView.LayoutType.browse) {
            transitionFromResultsToBrowse();
        } else if (layoutType == GPHMediaTypeView.LayoutType.searchFocus && layoutType2 == GPHMediaTypeView.LayoutType.browse) {
            transitionFromFocusToBrowse();
        } else if (layoutType == GPHMediaTypeView.LayoutType.searchResults && layoutType2 == GPHMediaTypeView.LayoutType.searchFocus) {
            transitionBackToSearchFocus();
        }
    }

    private final void transitionForwardToSearchFocus() {
        GPHMediaTypeView gPHMediaTypeView;
        if (this.contentType == GPHContentType.emoji && (gPHMediaTypeView = this.mediaSelectorView) != null) {
            gPHMediaTypeView.setGphContentType(GPHContentType.gif);
        }
        this.browseContentType = this.contentType;
    }

    private final void transitionBackToSearchFocus() {
        GPHContentType gPHContentType = this.browseContentType;
        this.contentType = gPHContentType;
        GPHMediaTypeView gPHMediaTypeView = this.mediaSelectorView;
        if (gPHMediaTypeView != null) {
            gPHMediaTypeView.setGphContentType(gPHContentType == GPHContentType.emoji ? GPHContentType.gif : this.browseContentType);
        }
        setGridTypeFromContentType();
    }

    private final void transitionFromResultsToBrowse() {
        GPHContentType gPHContentType = this.browseContentType;
        this.contentType = gPHContentType;
        GPHMediaTypeView gPHMediaTypeView = this.mediaSelectorView;
        if (gPHMediaTypeView != null) {
            gPHMediaTypeView.setGphContentType(gPHContentType);
        }
        setGridTypeFromContentType();
    }

    private final void transitionFromFocusToBrowse() {
        GPHContentType gPHContentType = this.contentType;
        GPHContentType gPHContentType2 = this.browseContentType;
        boolean z = gPHContentType != gPHContentType2;
        this.contentType = gPHContentType2;
        GPHMediaTypeView gPHMediaTypeView = this.mediaSelectorView;
        if (gPHMediaTypeView != null) {
            gPHMediaTypeView.setGphContentType(gPHContentType2);
        }
        setGridTypeFromContentType();
        if (z) {
            updateRecyclerViewQuery("");
        }
    }

    /* access modifiers changed from: private */
    public final boolean isSearchFocused() {
        ValueAnimator valueAnimator = this.focusAnimator;
        return (valueAnimator != null ? valueAnimator.getAnimatedFraction() : 0.0f) > 0.0f;
    }

    private final ValueAnimator.AnimatorUpdateListener getFocusAnimationListener() {
        return new GiphyDialogFragment$getFocusAnimationListener$1(this);
    }

    /* access modifiers changed from: private */
    public final void onGifSelected(Media media) {
        GPHSettings gPHSettings = this.giphySettings;
        if (gPHSettings == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
        }
        if (gPHSettings.getShowConfirmationScreen()) {
            GPHSettings gPHSettings2 = this.giphySettings;
            if (gPHSettings2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
            }
            if (gPHSettings2.getGridType() != GridType.carousel) {
                showConfirmationScreen(media);
                return;
            }
        }
        deliverGif(media);
    }

    /* access modifiers changed from: private */
    public final void onGifPressed(Media media, View view) {
        GPHMediaActionsView gPHMediaActionsView = this.giphyActionsView;
        if (gPHMediaActionsView != null) {
            gPHMediaActionsView.setMedia(media);
        }
        GPHMediaActionsView gPHMediaActionsView2 = this.giphyActionsView;
        if (gPHMediaActionsView2 != null) {
            gPHMediaActionsView2.showAsDropDown(view);
        }
    }

    /* access modifiers changed from: private */
    public final void deliverGif(Media media) {
        GifsRecyclerView gifsRecyclerView2 = this.gifsRecyclerView;
        if (gifsRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
        }
        GifTrackingManager gifTrackingManager = gifsRecyclerView2.getGifTrackingManager();
        if (gifTrackingManager != null) {
            GifTrackingManager.trackMedia$default(gifTrackingManager, media, ActionType.SENT, (String) null, (String) null, 12, (Object) null);
        }
        media.setBottleData((BottleData) null);
        GifSelectionListener gifSelectionListener2 = this.gifSelectionListener;
        if (gifSelectionListener2 != null) {
            gifSelectionListener2.onGifSelected(media);
        }
        this.gifDelivered = true;
        dismiss();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        GifSelectionListener gifSelectionListener2;
        if (!this.gifDelivered && (gifSelectionListener2 = this.gifSelectionListener) != null) {
            gifSelectionListener2.onDismissed();
        }
        super.onDismiss(dialogInterface);
    }

    /* access modifiers changed from: private */
    public final void createConfirmationView() {
        LayoutInflater from = LayoutInflater.from(getContext());
        int i = C1800R.C1804layout.gph_attribution_view;
        ConstraintLayout constraintLayout = this.baseView;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseView");
        }
        View inflate = from.inflate(i, constraintLayout, false);
        this.attributionView = inflate;
        if (inflate != null) {
            ConstraintLayout constraintLayout2 = this.baseView;
            if (constraintLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseView");
            }
            inflate.setTranslationX((float) constraintLayout2.getWidth());
        }
        GPHSettings gPHSettings = this.giphySettings;
        if (gPHSettings == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
        }
        if (gPHSettings.getGridType() == GridType.carousel) {
            GPHTouchInterceptor gPHTouchInterceptor = this.containerView;
            if (gPHTouchInterceptor == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
            }
            gPHTouchInterceptor.addView(this.attributionView, -1, -1);
            View view = this.attributionView;
            if (view == null) {
                Intrinsics.throwNpe();
            }
            ViewCompat.setElevation(view, (float) this.fragmentElevation);
        } else {
            ConstraintLayout constraintLayout3 = this.baseView;
            if (constraintLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseView");
            }
            constraintLayout3.addView(this.attributionView, -1, -1);
        }
        ValueAnimator valueAnimator = this.attributionAnimator;
        float[] fArr = new float[2];
        ConstraintLayout constraintLayout4 = this.baseView;
        if (constraintLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseView");
        }
        fArr[0] = (float) constraintLayout4.getWidth();
        fArr[1] = 0.0f;
        valueAnimator.setFloatValues(fArr);
        ValueAnimator valueAnimator2 = this.attributionAnimator;
        Intrinsics.checkExpressionValueIsNotNull(valueAnimator2, "attributionAnimator");
        valueAnimator2.setDuration(200);
        this.attributionAnimator.addUpdateListener(getAttributionAnimatorListener());
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C1800R.C1803id.gphAttributionBack);
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new GiphyDialogFragment$createConfirmationView$1(this));
        }
        Button button = (Button) _$_findCachedViewById(C1800R.C1803id.gphSelectGifBtn);
        if (button != null) {
            button.setOnClickListener(new GiphyDialogFragment$createConfirmationView$2(this));
        }
        ConstraintLayout constraintLayout5 = (ConstraintLayout) _$_findCachedViewById(C1800R.C1803id.gphChannelView);
        if (constraintLayout5 != null) {
            constraintLayout5.setOnClickListener(new GiphyDialogFragment$createConfirmationView$3(this));
        }
        ConstraintLayout constraintLayout6 = (ConstraintLayout) _$_findCachedViewById(C1800R.C1803id.attributionContainer);
        GPHSettings gPHSettings2 = this.giphySettings;
        if (gPHSettings2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
        }
        constraintLayout6.setBackgroundColor(gPHSettings2.getTheme().getBackgroundColor());
        ImageView imageView = (ImageView) _$_findCachedViewById(C1800R.C1803id.gphBackArrow);
        GPHSettings gPHSettings3 = this.giphySettings;
        if (gPHSettings3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
        }
        imageView.setColorFilter(gPHSettings3.getTheme().getChannelColor());
        TextView textView = (TextView) _$_findCachedViewById(C1800R.C1803id.gphBackText);
        GPHSettings gPHSettings4 = this.giphySettings;
        if (gPHSettings4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
        }
        textView.setTextColor(gPHSettings4.getTheme().getChannelColor());
        TextView textView2 = (TextView) _$_findCachedViewById(C1800R.C1803id.channelName);
        GPHSettings gPHSettings5 = this.giphySettings;
        if (gPHSettings5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
        }
        textView2.setTextColor(gPHSettings5.getTheme().getChannelColor());
        TextView textView3 = (TextView) _$_findCachedViewById(C1800R.C1803id.giphyHandle);
        GPHSettings gPHSettings6 = this.giphySettings;
        if (gPHSettings6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
        }
        textView3.setTextColor(gPHSettings6.getTheme().getTextColor());
    }

    private final void showConfirmationScreen(Media media) {
        this.isAttributionVisible = true;
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C1800R.C1803id.gphChannelView);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "gphChannelView");
        int i = 8;
        constraintLayout.setVisibility(media.getUser() != null ? 0 : 8);
        User user = media.getUser();
        if (user != null) {
            ImageView imageView = (ImageView) _$_findCachedViewById(C1800R.C1803id.verifiedBadge);
            Intrinsics.checkExpressionValueIsNotNull(imageView, "verifiedBadge");
            if (user.getVerified()) {
                i = 0;
            }
            imageView.setVisibility(i);
            ((GifView) _$_findCachedViewById(C1800R.C1803id.channelAvatar)).loadAsset(AvatarUtils.INSTANCE.getDownsizedUrl(user.getAvatarUrl(), AvatarUtils.Dimension.Medium));
            TextView textView = (TextView) _$_findCachedViewById(C1800R.C1803id.channelName);
            Intrinsics.checkExpressionValueIsNotNull(textView, "channelName");
            textView.setText('@' + user.getUsername());
        }
        if (Intrinsics.areEqual((Object) MediaExtensionKt.isEmoji(media), (Object) true)) {
            ((Button) _$_findCachedViewById(C1800R.C1803id.gphSelectGifBtn)).setText(C1800R.string.gph_choose_emoji);
            ((GifView) _$_findCachedViewById(C1800R.C1803id.gphGifView)).setBackgroundVisible(false);
        } else if (media.isSticker()) {
            ((Button) _$_findCachedViewById(C1800R.C1803id.gphSelectGifBtn)).setText(C1800R.string.gph_choose_sticker);
            ((GifView) _$_findCachedViewById(C1800R.C1803id.gphGifView)).setBackgroundVisible(true);
        } else {
            ((Button) _$_findCachedViewById(C1800R.C1803id.gphSelectGifBtn)).setText(C1800R.string.gph_choose_gif);
            ((GifView) _$_findCachedViewById(C1800R.C1803id.gphGifView)).setBackgroundVisible(false);
        }
        GifView gifView = (GifView) _$_findCachedViewById(C1800R.C1803id.gphGifView);
        if (gifView != null) {
            GPHSettings gPHSettings = this.giphySettings;
            if (gPHSettings == null) {
                Intrinsics.throwUninitializedPropertyAccessException("giphySettings");
            }
            RenditionType confirmationRenditionType = gPHSettings.getConfirmationRenditionType();
            if (confirmationRenditionType == null) {
                confirmationRenditionType = RenditionType.original;
            }
            GifView.setMedia$default(gifView, media, confirmationRenditionType, (Integer) null, 4, (Object) null);
        }
        GiphySearchBar giphySearchBar = this.searchBar;
        if (giphySearchBar != null) {
            giphySearchBar.dismissKeyboard();
        }
        this.attributionAnimator.start();
        GifsRecyclerView gifsRecyclerView2 = this.gifsRecyclerView;
        if (gifsRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
        }
        GifTrackingManager gifTrackingManager = gifsRecyclerView2.getGifTrackingManager();
        if (gifTrackingManager != null) {
            gifTrackingManager.reset();
        }
    }

    /* access modifiers changed from: private */
    public final void hideAttribution() {
        this.isAttributionVisible = false;
        GifView gifView = (GifView) _$_findCachedViewById(C1800R.C1803id.gphGifView);
        if (gifView != null) {
            GifView.setMedia$default(gifView, (Media) null, (RenditionType) null, (Integer) 0, 2, (Object) null);
        }
        ValueAnimator valueAnimator = this.attributionAnimator;
        if (valueAnimator != null) {
            valueAnimator.reverse();
        }
        GifsRecyclerView gifsRecyclerView2 = this.gifsRecyclerView;
        if (gifsRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
        }
        GifTrackingManager gifTrackingManager = gifsRecyclerView2.getGifTrackingManager();
        if (gifTrackingManager != null) {
            gifTrackingManager.updateTracking();
        }
    }

    private final ValueAnimator.AnimatorUpdateListener getAttributionAnimatorListener() {
        return new GiphyDialogFragment$getAttributionAnimatorListener$1(this);
    }

    private final ValueAnimator.AnimatorUpdateListener getMediaSelectorAnimatorListener() {
        return new GiphyDialogFragment$getMediaSelectorAnimatorListener$1(this);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0012, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void showMediaSelector() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.animOpen     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            r0 = 1
            r1.animOpen = r0     // Catch:{ all -> 0x0013 }
            android.animation.ValueAnimator r0 = r1.mediaSelectorAnimator     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0011
            r0.start()     // Catch:{ all -> 0x0013 }
        L_0x0011:
            monitor-exit(r1)
            return
        L_0x0013:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.giphy.sdk.p013ui.views.GiphyDialogFragment.showMediaSelector():void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0012, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void hideMediaSelector() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.animOpen     // Catch:{ all -> 0x0013 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            r0 = 0
            r1.animOpen = r0     // Catch:{ all -> 0x0013 }
            android.animation.ValueAnimator r0 = r1.mediaSelectorAnimator     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0011
            r0.reverse()     // Catch:{ all -> 0x0013 }
        L_0x0011:
            monitor-exit(r1)
            return
        L_0x0013:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.giphy.sdk.p013ui.views.GiphyDialogFragment.hideMediaSelector():void");
    }

    /* access modifiers changed from: private */
    public final void openGiphyApp(Media media) {
        startActivity(GifUtils.INSTANCE.getViewGifIntent(media));
        dismiss();
    }

    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(bundle, "outState");
        int i = 0;
        Timber.m300d("onSaveInstanceState", new Object[0]);
        this.keepModelData = true;
        bundle.putBoolean(KEY_SCREEN_CHANGE, true);
        bundle.putParcelable(KEY_MEDIA_TYPE, this.contentType);
        GPHMediaTypeView gPHMediaTypeView = this.mediaSelectorView;
        if (gPHMediaTypeView != null) {
            i = gPHMediaTypeView.getResultCount();
        }
        bundle.putInt(KEY_RESULT_COUNT, i);
        super.onSaveInstanceState(bundle);
    }

    public void onDestroyView() {
        Timber.m300d("onDestroyView", new Object[0]);
        if (!this.keepModelData) {
            GifsRecyclerView gifsRecyclerView2 = this.gifsRecyclerView;
            if (gifsRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gifsRecyclerView");
            }
            GifTrackingManager gifTrackingManager = gifsRecyclerView2.getGifTrackingManager();
            if (gifTrackingManager != null) {
                gifTrackingManager.reset();
            }
        }
        this.openAnimator.cancel();
        this.attributionAnimator.cancel();
        this.attributionView = null;
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onDestroy() {
        this.gifSelectionListener = null;
        super.onDestroy();
    }
}
