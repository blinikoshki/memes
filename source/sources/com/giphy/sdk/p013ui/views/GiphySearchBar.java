package com.giphy.sdk.p013ui.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.giphy.sdk.p013ui.C1800R;
import com.giphy.sdk.p013ui.themes.DarkTheme;
import com.giphy.sdk.p013ui.themes.LightTheme;
import com.giphy.sdk.p013ui.themes.Theme;
import com.giphy.sdk.p013ui.utils.IntExtensionsKt;
import com.giphy.sdk.p013ui.views.GiphyDialogFragment;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\b\t*\u00019\u0018\u0000 @2\u00020\u0001:\u0001@B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u00104\u001a\u00020\u0012H\u0002J\b\u00105\u001a\u00020\u0012H\u0002J\b\u00106\u001a\u00020\u0012H\u0002J\u0006\u00107\u001a\u00020\u0012J\r\u00108\u001a\u000209H\u0002¢\u0006\u0002\u0010:J\u0018\u0010;\u001a\u00020\u00122\u0006\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nH\u0014J\b\u0010>\u001a\u00020\u0012H\u0002J\b\u0010?\u001a\u00020\u0012H\u0002R5\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010$\u001a\b\u0012\u0004\u0012\u00020\u00120%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R5\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0014\"\u0004\b,\u0010\u0016R$\u0010-\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0018@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001a\"\u0004\b/\u0010\u001cR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006A"}, mo26107d2 = {"Lcom/giphy/sdk/ui/views/GiphySearchBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "theme", "Lcom/giphy/sdk/ui/themes/Theme;", "(Landroid/content/Context;Lcom/giphy/sdk/ui/themes/Theme;)V", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gifQueryListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "query", "", "getGifQueryListener", "()Lkotlin/jvm/functions/Function1;", "setGifQueryListener", "(Lkotlin/jvm/functions/Function1;)V", "hideKeyboardOnSearch", "", "getHideKeyboardOnSearch", "()Z", "setHideKeyboardOnSearch", "(Z)V", "value", "Lcom/giphy/sdk/ui/views/GiphyDialogFragment$KeyboardState;", "keyboardState", "getKeyboardState", "()Lcom/giphy/sdk/ui/views/GiphyDialogFragment$KeyboardState;", "setKeyboardState", "(Lcom/giphy/sdk/ui/views/GiphyDialogFragment$KeyboardState;)V", "onBackClickAction", "Lkotlin/Function0;", "getOnBackClickAction", "()Lkotlin/jvm/functions/Function0;", "setOnBackClickAction", "(Lkotlin/jvm/functions/Function0;)V", "onSearchClickAction", "getOnSearchClickAction", "setOnSearchClickAction", "showBackButton", "getShowBackButton", "setShowBackButton", "getTheme", "()Lcom/giphy/sdk/ui/themes/Theme;", "setTheme", "(Lcom/giphy/sdk/ui/themes/Theme;)V", "applyClearBtnLogic", "applyDarkTheme", "applyLightTheme", "dismissKeyboard", "getTextWatcher", "com/giphy/sdk/ui/views/GiphySearchBar$getTextWatcher$1", "()Lcom/giphy/sdk/ui/views/GiphySearchBar$getTextWatcher$1;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setupActions", "setupUI", "Companion", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GiphySearchBar */
/* compiled from: GiphySearchBar.kt */
public final class GiphySearchBar extends ConstraintLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int SEARCH_BAR_ELEVATION = IntExtensionsKt.getPx(2);
    private HashMap _$_findViewCache;
    private Function1<? super String, Unit> gifQueryListener;
    private boolean hideKeyboardOnSearch;
    private GiphyDialogFragment.KeyboardState keyboardState;
    private Function0<Unit> onBackClickAction;
    private Function1<? super String, Unit> onSearchClickAction;
    private boolean showBackButton;
    private Theme theme;

    public GiphySearchBar(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public GiphySearchBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
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
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GiphySearchBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GiphySearchBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.theme = LightTheme.INSTANCE;
        this.onSearchClickAction = GiphySearchBar$onSearchClickAction$1.INSTANCE;
        this.onBackClickAction = GiphySearchBar$onBackClickAction$1.INSTANCE;
        this.gifQueryListener = GiphySearchBar$gifQueryListener$1.INSTANCE;
        this.keyboardState = GiphyDialogFragment.KeyboardState.OPEN;
        View.inflate(context, C1800R.C1804layout.gph_search_bar, this);
        setupActions();
        setupUI();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/giphy/sdk/ui/views/GiphySearchBar$Companion;", "", "()V", "SEARCH_BAR_ELEVATION", "", "getSEARCH_BAR_ELEVATION", "()I", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.views.GiphySearchBar$Companion */
    /* compiled from: GiphySearchBar.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getSEARCH_BAR_ELEVATION() {
            return GiphySearchBar.SEARCH_BAR_ELEVATION;
        }
    }

    public final Theme getTheme() {
        return this.theme;
    }

    public final void setTheme(Theme theme2) {
        Intrinsics.checkParameterIsNotNull(theme2, "<set-?>");
        this.theme = theme2;
    }

    public final Function1<String, Unit> getOnSearchClickAction() {
        return this.onSearchClickAction;
    }

    public final void setOnSearchClickAction(Function1<? super String, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "<set-?>");
        this.onSearchClickAction = function1;
    }

    public final Function0<Unit> getOnBackClickAction() {
        return this.onBackClickAction;
    }

    public final void setOnBackClickAction(Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "<set-?>");
        this.onBackClickAction = function0;
    }

    public final Function1<String, Unit> getGifQueryListener() {
        return this.gifQueryListener;
    }

    public final void setGifQueryListener(Function1<? super String, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "<set-?>");
        this.gifQueryListener = function1;
    }

    public final GiphyDialogFragment.KeyboardState getKeyboardState() {
        return this.keyboardState;
    }

    public final void setKeyboardState(GiphyDialogFragment.KeyboardState keyboardState2) {
        Intrinsics.checkParameterIsNotNull(keyboardState2, "value");
        this.keyboardState = keyboardState2;
        applyClearBtnLogic();
    }

    public final boolean getHideKeyboardOnSearch() {
        return this.hideKeyboardOnSearch;
    }

    public final void setHideKeyboardOnSearch(boolean z) {
        this.hideKeyboardOnSearch = z;
    }

    public final boolean getShowBackButton() {
        return this.showBackButton;
    }

    public final void setShowBackButton(boolean z) {
        this.showBackButton = z;
        ImageView imageView = (ImageView) _$_findCachedViewById(C1800R.C1803id.searchBackBtn);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "searchBackBtn");
        imageView.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GiphySearchBar(Context context, Theme theme2) {
        this(context, (AttributeSet) null, 0);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(theme2, "theme");
        this.theme = theme2;
        setupUI();
    }

    private final void setupActions() {
        ((ImageView) _$_findCachedViewById(C1800R.C1803id.searchBackBtn)).setOnClickListener(new GiphySearchBar$setupActions$1(this));
        ((ImageView) _$_findCachedViewById(C1800R.C1803id.clearSearchBtn)).setOnClickListener(new GiphySearchBar$setupActions$2(this));
        ((ImageView) _$_findCachedViewById(C1800R.C1803id.performSearchBtn)).setOnClickListener(new GiphySearchBar$setupActions$3(this));
        ((EditText) _$_findCachedViewById(C1800R.C1803id.searchInput)).addTextChangedListener(getTextWatcher());
        ((EditText) _$_findCachedViewById(C1800R.C1803id.searchInput)).setOnEditorActionListener(new GiphySearchBar$setupActions$4(this));
    }

    public final void dismissKeyboard() {
        Object systemService = getContext().getSystemService("input_method");
        if (systemService != null) {
            EditText editText = (EditText) _$_findCachedViewById(C1800R.C1803id.searchInput);
            Intrinsics.checkExpressionValueIsNotNull(editText, "searchInput");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(editText.getWindowToken(), 0);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    private final GiphySearchBar$getTextWatcher$1 getTextWatcher() {
        return new GiphySearchBar$getTextWatcher$1(this);
    }

    private final void setupUI() {
        setBackgroundResource(C1800R.C1801color.gph_white);
        Theme theme2 = this.theme;
        if (Intrinsics.areEqual((Object) theme2, (Object) DarkTheme.INSTANCE)) {
            applyDarkTheme();
        } else if (Intrinsics.areEqual((Object) theme2, (Object) LightTheme.INSTANCE)) {
            applyLightTheme();
        }
        ViewCompat.setElevation(this, (float) SEARCH_BAR_ELEVATION);
    }

    private final void applyDarkTheme() {
        ((ImageView) _$_findCachedViewById(C1800R.C1803id.performSearchBtn)).setImageResource(C1800R.C1802drawable.gph_ic_search_white);
        ((ImageView) _$_findCachedViewById(C1800R.C1803id.performSearchBtn)).setBackgroundResource(C1800R.C1802drawable.gph_search_btn_bg);
    }

    private final void applyLightTheme() {
        ((ImageView) _$_findCachedViewById(C1800R.C1803id.performSearchBtn)).setImageResource(C1800R.C1802drawable.gph_ic_search_pink);
        ImageView imageView = (ImageView) _$_findCachedViewById(C1800R.C1803id.performSearchBtn);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "performSearchBtn");
        imageView.setBackground((Drawable) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0029, code lost:
        if ((r0.length() > 0) != false) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void applyClearBtnLogic() {
        /*
            r5 = this;
            com.giphy.sdk.ui.views.GiphyDialogFragment$KeyboardState r0 = r5.keyboardState
            com.giphy.sdk.ui.views.GiphyDialogFragment$KeyboardState r1 = com.giphy.sdk.p013ui.views.GiphyDialogFragment.KeyboardState.OPEN
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x002c
            int r0 = com.giphy.sdk.p013ui.C1800R.C1803id.searchInput
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            java.lang.String r1 = "searchInput"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            android.text.Editable r0 = r0.getText()
            java.lang.String r1 = "searchInput.text"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0028
            r0 = 1
            goto L_0x0029
        L_0x0028:
            r0 = 0
        L_0x0029:
            if (r0 == 0) goto L_0x002c
            goto L_0x002d
        L_0x002c:
            r2 = 0
        L_0x002d:
            int r0 = com.giphy.sdk.p013ui.C1800R.C1803id.clearSearchBtn
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            java.lang.String r1 = "clearSearchBtn"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            r1 = 8
            if (r2 == 0) goto L_0x0040
            r4 = 0
            goto L_0x0042
        L_0x0040:
            r4 = 8
        L_0x0042:
            r0.setVisibility(r4)
            int r0 = com.giphy.sdk.p013ui.C1800R.C1803id.performSearchBtn
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            java.lang.String r4 = "performSearchBtn"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r4)
            if (r2 == 0) goto L_0x0056
            r3 = 8
        L_0x0056:
            r0.setVisibility(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.giphy.sdk.p013ui.views.GiphySearchBar.applyClearBtnLogic():void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getResources().getDimensionPixelSize(C1800R.dimen.gph_search_bar_height), 1073741824));
    }
}
