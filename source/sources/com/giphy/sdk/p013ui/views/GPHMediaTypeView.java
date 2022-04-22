package com.giphy.sdk.p013ui.views;

import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.giphy.sdk.p013ui.C1800R;
import com.giphy.sdk.p013ui.GPHContentType;
import com.giphy.sdk.p013ui.themes.Theme;
import com.giphy.sdk.p013ui.utils.IntExtensionsKt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001CB%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0010\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u000bH\u0002J,\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010:2\b\u0010<\u001a\u0004\u0018\u00010:H\u0002J\u000e\u0010=\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020?J\b\u0010@\u001a\u00020\u001bH\u0002J\u0010\u0010A\u001a\u00020\u001b2\b\b\u0002\u0010>\u001a\u00020?J\u0006\u0010B\u001a\u00020\u001bR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0013@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R,\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001b0\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR&\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001b0!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R$\u0010*\u001a\u00020)2\u0006\u0010\r\u001a\u00020)@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u00100\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\b1\u0010,R\u000e\u00102\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u00104¨\u0006D"}, mo26107d2 = {"Lcom/giphy/sdk/ui/views/GPHMediaTypeView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "theme", "Lcom/giphy/sdk/ui/themes/Theme;", "mediaConfigs", "", "Lcom/giphy/sdk/ui/GPHContentType;", "(Landroid/content/Context;Lcom/giphy/sdk/ui/themes/Theme;[Lcom/giphy/sdk/ui/GPHContentType;)V", "activeContraintSet", "Landroidx/constraintlayout/widget/ConstraintSet;", "categoriesContraintSet", "value", "gphContentType", "getGphContentType", "()Lcom/giphy/sdk/ui/GPHContentType;", "setGphContentType", "(Lcom/giphy/sdk/ui/GPHContentType;)V", "Lcom/giphy/sdk/ui/views/GPHMediaTypeView$LayoutType;", "layoutType", "getLayoutType", "()Lcom/giphy/sdk/ui/views/GPHMediaTypeView$LayoutType;", "setLayoutType", "(Lcom/giphy/sdk/ui/views/GPHMediaTypeView$LayoutType;)V", "layoutTypeListener", "Lkotlin/Function2;", "", "getLayoutTypeListener", "()Lkotlin/jvm/functions/Function2;", "setLayoutTypeListener", "(Lkotlin/jvm/functions/Function2;)V", "mediaConfigListener", "Lkotlin/Function1;", "getMediaConfigListener", "()Lkotlin/jvm/functions/Function1;", "setMediaConfigListener", "(Lkotlin/jvm/functions/Function1;)V", "getMediaConfigs", "()[Lcom/giphy/sdk/ui/GPHContentType;", "[Lcom/giphy/sdk/ui/GPHContentType;", "", "resultCount", "getResultCount", "()I", "setResultCount", "(I)V", "resultsContraintSet", "searchButtonMargin", "getSearchButtonMargin", "searchConstraintSet", "getTheme", "()Lcom/giphy/sdk/ui/themes/Theme;", "applyConstraints", "set", "chainView", "constraintSet", "view", "Landroid/view/View;", "prev", "next", "onSearchFocus", "inFocus", "", "setActiveMedia", "showCategories", "showSearchResults", "LayoutType", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GPHMediaTypeView */
/* compiled from: GPHMediaTypeView.kt */
public final class GPHMediaTypeView extends ConstraintLayout {
    private HashMap _$_findViewCache;
    private ConstraintSet activeContraintSet;
    private ConstraintSet categoriesContraintSet = new ConstraintSet();
    private GPHContentType gphContentType = GPHContentType.gif;
    private LayoutType layoutType = LayoutType.browse;
    private Function2<? super LayoutType, ? super LayoutType, Unit> layoutTypeListener = GPHMediaTypeView$layoutTypeListener$1.INSTANCE;
    private Function1<? super GPHContentType, Unit> mediaConfigListener = GPHMediaTypeView$mediaConfigListener$1.INSTANCE;
    private final GPHContentType[] mediaConfigs;
    private int resultCount;
    private ConstraintSet resultsContraintSet = new ConstraintSet();
    private final int searchButtonMargin = IntExtensionsKt.getDp(10);
    private ConstraintSet searchConstraintSet = new ConstraintSet();
    private final Theme theme;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, mo26107d2 = {"Lcom/giphy/sdk/ui/views/GPHMediaTypeView$LayoutType;", "", "(Ljava/lang/String;I)V", "browse", "searchFocus", "searchResults", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.views.GPHMediaTypeView$LayoutType */
    /* compiled from: GPHMediaTypeView.kt */
    public enum LayoutType {
        browse,
        searchFocus,
        searchResults
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.views.GPHMediaTypeView$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[GPHContentType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[GPHContentType.gif.ordinal()] = 1;
            iArr[GPHContentType.sticker.ordinal()] = 2;
            iArr[GPHContentType.text.ordinal()] = 3;
            iArr[GPHContentType.emoji.ordinal()] = 4;
            int[] iArr2 = new int[GPHContentType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[GPHContentType.gif.ordinal()] = 1;
            iArr2[GPHContentType.sticker.ordinal()] = 2;
            iArr2[GPHContentType.text.ordinal()] = 3;
            iArr2[GPHContentType.emoji.ordinal()] = 4;
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
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: android.view.View} */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GPHMediaTypeView(android.content.Context r13, com.giphy.sdk.p013ui.themes.Theme r14, com.giphy.sdk.p013ui.GPHContentType[] r15) {
        /*
            r12 = this;
            java.lang.String r0 = "theme"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r14, r0)
            java.lang.String r0 = "mediaConfigs"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r15, r0)
            r12.<init>(r13)
            r12.theme = r14
            r12.mediaConfigs = r15
            com.giphy.sdk.ui.views.GPHMediaTypeView$mediaConfigListener$1 r14 = com.giphy.sdk.p013ui.views.GPHMediaTypeView$mediaConfigListener$1.INSTANCE
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            r12.mediaConfigListener = r14
            com.giphy.sdk.ui.views.GPHMediaTypeView$layoutTypeListener$1 r14 = com.giphy.sdk.p013ui.views.GPHMediaTypeView$layoutTypeListener$1.INSTANCE
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r12.layoutTypeListener = r14
            r14 = 10
            int r14 = com.giphy.sdk.p013ui.utils.IntExtensionsKt.getDp(r14)
            r12.searchButtonMargin = r14
            com.giphy.sdk.ui.GPHContentType r14 = com.giphy.sdk.p013ui.GPHContentType.gif
            r12.gphContentType = r14
            com.giphy.sdk.ui.views.GPHMediaTypeView$LayoutType r14 = com.giphy.sdk.p013ui.views.GPHMediaTypeView.LayoutType.browse
            r12.layoutType = r14
            androidx.constraintlayout.widget.ConstraintSet r14 = new androidx.constraintlayout.widget.ConstraintSet
            r14.<init>()
            r12.categoriesContraintSet = r14
            androidx.constraintlayout.widget.ConstraintSet r14 = new androidx.constraintlayout.widget.ConstraintSet
            r14.<init>()
            r12.resultsContraintSet = r14
            androidx.constraintlayout.widget.ConstraintSet r14 = new androidx.constraintlayout.widget.ConstraintSet
            r14.<init>()
            r12.searchConstraintSet = r14
            android.view.LayoutInflater r14 = android.view.LayoutInflater.from(r13)
            int r0 = com.giphy.sdk.p013ui.C1800R.C1804layout.gph_media_type_view
            r1 = r12
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r2 = 1
            r14.inflate(r0, r1, r2)
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.List r14 = (java.util.List) r14
            int r0 = r15.length
            r3 = 0
            r4 = 0
        L_0x005a:
            r5 = 4
            r6 = 3
            if (r4 >= r0) goto L_0x00d7
            r7 = r15[r4]
            android.view.LayoutInflater r8 = android.view.LayoutInflater.from(r13)
            int r9 = com.giphy.sdk.p013ui.C1800R.C1804layout.gph_media_type_item
            android.view.View r8 = r8.inflate(r9, r1, r3)
            if (r8 == 0) goto L_0x00cf
            android.widget.TextView r8 = (android.widget.TextView) r8
            r8.setTag(r7)
            int[] r9 = com.giphy.sdk.p013ui.views.GPHMediaTypeView.WhenMappings.$EnumSwitchMapping$0
            int r10 = r7.ordinal()
            r9 = r9[r10]
            r10 = 2
            if (r9 == r2) goto L_0x0091
            if (r9 == r10) goto L_0x008e
            if (r9 == r6) goto L_0x008b
            if (r9 != r5) goto L_0x0085
            int r9 = com.giphy.sdk.p013ui.C1800R.string.gph_emoji
            goto L_0x0093
        L_0x0085:
            kotlin.NoWhenBranchMatchedException r13 = new kotlin.NoWhenBranchMatchedException
            r13.<init>()
            throw r13
        L_0x008b:
            int r9 = com.giphy.sdk.p013ui.C1800R.string.gph_text
            goto L_0x0093
        L_0x008e:
            int r9 = com.giphy.sdk.p013ui.C1800R.string.gph_stickers
            goto L_0x0093
        L_0x0091:
            int r9 = com.giphy.sdk.p013ui.C1800R.string.gph_gifs
        L_0x0093:
            r8.setText(r9)
            int[] r9 = com.giphy.sdk.p013ui.views.GPHMediaTypeView.WhenMappings.$EnumSwitchMapping$1
            int r7 = r7.ordinal()
            r7 = r9[r7]
            if (r7 == r2) goto L_0x00b5
            if (r7 == r10) goto L_0x00b2
            if (r7 == r6) goto L_0x00af
            if (r7 != r5) goto L_0x00a9
            int r5 = com.giphy.sdk.p013ui.C1800R.C1803id.gphItemTypeEmoji
            goto L_0x00b7
        L_0x00a9:
            kotlin.NoWhenBranchMatchedException r13 = new kotlin.NoWhenBranchMatchedException
            r13.<init>()
            throw r13
        L_0x00af:
            int r5 = com.giphy.sdk.p013ui.C1800R.C1803id.gphItemTypeText
            goto L_0x00b7
        L_0x00b2:
            int r5 = com.giphy.sdk.p013ui.C1800R.C1803id.gphItemTypeSticker
            goto L_0x00b7
        L_0x00b5:
            int r5 = com.giphy.sdk.p013ui.C1800R.C1803id.gphItemTypeGif
        L_0x00b7:
            r8.setId(r5)
            com.giphy.sdk.ui.views.GPHMediaTypeView$$special$$inlined$forEach$lambda$1 r5 = new com.giphy.sdk.ui.views.GPHMediaTypeView$$special$$inlined$forEach$lambda$1
            r5.<init>(r12, r13, r14)
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
            r8.setOnClickListener(r5)
            r14.add(r8)
            android.view.View r8 = (android.view.View) r8
            r12.addView(r8)
            int r4 = r4 + 1
            goto L_0x005a
        L_0x00cf:
            kotlin.TypeCastException r13 = new kotlin.TypeCastException
            java.lang.String r14 = "null cannot be cast to non-null type android.widget.TextView"
            r13.<init>(r14)
            throw r13
        L_0x00d7:
            androidx.constraintlayout.widget.ConstraintSet r13 = r12.categoriesContraintSet
            r15 = r12
            androidx.constraintlayout.widget.ConstraintLayout r15 = (androidx.constraintlayout.widget.ConstraintLayout) r15
            r13.clone((androidx.constraintlayout.widget.ConstraintLayout) r15)
            r13 = r14
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.Iterator r0 = r13.iterator()
            r1 = 0
        L_0x00e7:
            boolean r4 = r0.hasNext()
            r7 = 0
            if (r4 == 0) goto L_0x011d
            java.lang.Object r4 = r0.next()
            int r8 = r1 + 1
            if (r1 >= 0) goto L_0x00f9
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x00f9:
            android.view.View r4 = (android.view.View) r4
            androidx.constraintlayout.widget.ConstraintSet r9 = r12.categoriesContraintSet
            if (r1 != 0) goto L_0x0101
            r10 = r7
            goto L_0x0109
        L_0x0101:
            int r10 = r1 + -1
            java.lang.Object r10 = r14.get(r10)
            android.view.View r10 = (android.view.View) r10
        L_0x0109:
            int r11 = r14.size()
            int r11 = r11 - r2
            if (r1 != r11) goto L_0x0111
            goto L_0x0118
        L_0x0111:
            java.lang.Object r1 = r14.get(r8)
            r7 = r1
            android.view.View r7 = (android.view.View) r7
        L_0x0118:
            r12.chainView(r9, r4, r10, r7)
            r1 = r8
            goto L_0x00e7
        L_0x011d:
            androidx.constraintlayout.widget.ConstraintSet r14 = r12.categoriesContraintSet
            int r0 = com.giphy.sdk.p013ui.C1800R.C1803id.gphResultCount
            r1 = 8
            r14.setVisibility(r0, r1)
            androidx.constraintlayout.widget.ConstraintSet r14 = r12.categoriesContraintSet
            r12.activeContraintSet = r14
            androidx.constraintlayout.widget.ConstraintSet r0 = r12.searchConstraintSet
            r0.clone((androidx.constraintlayout.widget.ConstraintSet) r14)
            androidx.constraintlayout.widget.ConstraintSet r14 = r12.searchConstraintSet
            int r0 = com.giphy.sdk.p013ui.C1800R.C1803id.gphItemTypeEmoji
            r14.setVisibility(r0, r1)
            androidx.constraintlayout.widget.ConstraintSet r14 = r12.searchConstraintSet
            int r0 = com.giphy.sdk.p013ui.C1800R.C1803id.gphResultCount
            r14.setVisibility(r0, r1)
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.Collection r14 = (java.util.Collection) r14
            java.util.Iterator r13 = r13.iterator()
        L_0x0148:
            boolean r0 = r13.hasNext()
            if (r0 == 0) goto L_0x0166
            java.lang.Object r0 = r13.next()
            r1 = r0
            android.view.View r1 = (android.view.View) r1
            java.lang.Object r1 = r1.getTag()
            com.giphy.sdk.ui.GPHContentType r4 = com.giphy.sdk.p013ui.GPHContentType.emoji
            if (r1 == r4) goto L_0x015f
            r1 = 1
            goto L_0x0160
        L_0x015f:
            r1 = 0
        L_0x0160:
            if (r1 == 0) goto L_0x0148
            r14.add(r0)
            goto L_0x0148
        L_0x0166:
            java.util.List r14 = (java.util.List) r14
            r13 = r14
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.Iterator r0 = r13.iterator()
            r1 = 0
        L_0x0170:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x01a5
            java.lang.Object r4 = r0.next()
            int r8 = r1 + 1
            if (r1 >= 0) goto L_0x0181
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0181:
            android.view.View r4 = (android.view.View) r4
            androidx.constraintlayout.widget.ConstraintSet r9 = r12.searchConstraintSet
            if (r1 != 0) goto L_0x0189
            r10 = r7
            goto L_0x0191
        L_0x0189:
            int r10 = r1 + -1
            java.lang.Object r10 = r14.get(r10)
            android.view.View r10 = (android.view.View) r10
        L_0x0191:
            int r11 = r14.size()
            int r11 = r11 - r2
            if (r1 != r11) goto L_0x019a
            r1 = r7
            goto L_0x01a0
        L_0x019a:
            java.lang.Object r1 = r14.get(r8)
            android.view.View r1 = (android.view.View) r1
        L_0x01a0:
            r12.chainView(r9, r4, r10, r1)
            r1 = r8
            goto L_0x0170
        L_0x01a5:
            androidx.constraintlayout.widget.ConstraintSet r0 = r12.resultsContraintSet
            androidx.constraintlayout.widget.ConstraintSet r1 = r12.searchConstraintSet
            r0.clone((androidx.constraintlayout.widget.ConstraintSet) r1)
            java.util.Iterator r13 = r13.iterator()
            r0 = 0
        L_0x01b1:
            boolean r1 = r13.hasNext()
            if (r1 == 0) goto L_0x0224
            java.lang.Object r1 = r13.next()
            int r2 = r0 + 1
            if (r0 >= 0) goto L_0x01c2
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x01c2:
            android.view.View r1 = (android.view.View) r1
            androidx.constraintlayout.widget.ConstraintSet r4 = r12.resultsContraintSet
            int r8 = r1.getId()
            r4.clear(r8)
            if (r0 != 0) goto L_0x01d1
            r4 = r7
            goto L_0x01d9
        L_0x01d1:
            int r4 = r0 + -1
            java.lang.Object r4 = r14.get(r4)
            android.view.View r4 = (android.view.View) r4
        L_0x01d9:
            androidx.constraintlayout.widget.ConstraintSet r8 = r12.resultsContraintSet
            int r9 = r1.getId()
            r8.connect(r9, r6, r3, r6)
            androidx.constraintlayout.widget.ConstraintSet r8 = r12.resultsContraintSet
            int r9 = r1.getId()
            r8.connect(r9, r5, r3, r5)
            androidx.constraintlayout.widget.ConstraintSet r8 = r12.resultsContraintSet
            int r9 = r1.getId()
            if (r4 != 0) goto L_0x01f5
            r10 = 0
            goto L_0x01f9
        L_0x01f5:
            int r10 = r4.getId()
        L_0x01f9:
            r11 = 6
            if (r4 != 0) goto L_0x01fe
            r4 = 6
            goto L_0x01ff
        L_0x01fe:
            r4 = 7
        L_0x01ff:
            r8.connect(r9, r11, r10, r4)
            androidx.constraintlayout.widget.ConstraintSet r4 = r12.resultsContraintSet
            int r8 = r1.getId()
            r9 = -2
            r4.constrainHeight(r8, r9)
            androidx.constraintlayout.widget.ConstraintSet r4 = r12.resultsContraintSet
            int r8 = r1.getId()
            r4.constrainWidth(r8, r9)
            if (r0 <= 0) goto L_0x0222
            androidx.constraintlayout.widget.ConstraintSet r0 = r12.resultsContraintSet
            int r1 = r1.getId()
            int r4 = r12.searchButtonMargin
            r0.setMargin(r1, r11, r4)
        L_0x0222:
            r0 = r2
            goto L_0x01b1
        L_0x0224:
            androidx.constraintlayout.widget.ConstraintSet r13 = r12.resultsContraintSet
            int r14 = com.giphy.sdk.p013ui.C1800R.C1803id.gphResultCount
            r13.setVisibility(r14, r3)
            androidx.constraintlayout.widget.ConstraintSet r13 = r12.activeContraintSet
            if (r13 == 0) goto L_0x0232
            r13.applyTo(r15)
        L_0x0232:
            r12.setActiveMedia()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.giphy.sdk.p013ui.views.GPHMediaTypeView.<init>(android.content.Context, com.giphy.sdk.ui.themes.Theme, com.giphy.sdk.ui.GPHContentType[]):void");
    }

    public final GPHContentType[] getMediaConfigs() {
        return this.mediaConfigs;
    }

    public final Theme getTheme() {
        return this.theme;
    }

    public final Function1<GPHContentType, Unit> getMediaConfigListener() {
        return this.mediaConfigListener;
    }

    public final void setMediaConfigListener(Function1<? super GPHContentType, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "<set-?>");
        this.mediaConfigListener = function1;
    }

    public final Function2<LayoutType, LayoutType, Unit> getLayoutTypeListener() {
        return this.layoutTypeListener;
    }

    public final void setLayoutTypeListener(Function2<? super LayoutType, ? super LayoutType, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "<set-?>");
        this.layoutTypeListener = function2;
    }

    public final int getSearchButtonMargin() {
        return this.searchButtonMargin;
    }

    public final GPHContentType getGphContentType() {
        return this.gphContentType;
    }

    public final void setGphContentType(GPHContentType gPHContentType) {
        Intrinsics.checkParameterIsNotNull(gPHContentType, "value");
        this.gphContentType = gPHContentType;
        setActiveMedia();
    }

    public final int getResultCount() {
        return this.resultCount;
    }

    public final void setResultCount(int i) {
        this.resultCount = i;
        TextView textView = (TextView) _$_findCachedViewById(C1800R.C1803id.gphResultCount);
        Intrinsics.checkExpressionValueIsNotNull(textView, "gphResultCount");
        textView.setText(getContext().getString(C1800R.string.gph_results_count, new Object[]{Integer.valueOf(i)}));
    }

    public final LayoutType getLayoutType() {
        return this.layoutType;
    }

    private final void setLayoutType(LayoutType layoutType2) {
        LayoutType layoutType3 = this.layoutType;
        if (layoutType3 != layoutType2) {
            this.layoutTypeListener.invoke(layoutType3, layoutType2);
        }
        this.layoutType = layoutType2;
    }

    private final void chainView(ConstraintSet constraintSet, View view, View view2, View view3) {
        int i;
        int i2 = 0;
        constraintSet.connect(view.getId(), 3, 0, 3);
        constraintSet.connect(view.getId(), 4, 0, 4);
        int id = view.getId();
        if (view2 == null) {
            i = 0;
        } else {
            i = view2.getId();
        }
        int i3 = 6;
        constraintSet.connect(id, 6, i, view2 == null ? 6 : 7);
        int id2 = view.getId();
        if (view3 != null) {
            i2 = view3.getId();
        }
        if (view3 == null) {
            i3 = 7;
        }
        constraintSet.connect(id2, 7, i2, i3);
        constraintSet.constrainHeight(view.getId(), -2);
        constraintSet.constrainWidth(view.getId(), -2);
    }

    public static /* synthetic */ void showCategories$default(GPHMediaTypeView gPHMediaTypeView, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        gPHMediaTypeView.showCategories(z);
    }

    public final void showCategories(boolean z) {
        ConstraintSet constraintSet;
        if (z) {
            setLayoutType(LayoutType.searchFocus);
            constraintSet = this.searchConstraintSet;
        } else {
            setLayoutType(LayoutType.browse);
            constraintSet = this.categoriesContraintSet;
        }
        applyConstraints(constraintSet);
    }

    public final void showSearchResults() {
        applyConstraints(this.resultsContraintSet);
        setLayoutType(LayoutType.searchResults);
    }

    public final void onSearchFocus(boolean z) {
        if (z && Intrinsics.areEqual((Object) this.activeContraintSet, (Object) this.categoriesContraintSet)) {
            applyConstraints(this.searchConstraintSet);
            setLayoutType(LayoutType.searchFocus);
        }
        if (!z && Intrinsics.areEqual((Object) this.activeContraintSet, (Object) this.searchConstraintSet)) {
            applyConstraints(this.categoriesContraintSet);
            setLayoutType(LayoutType.browse);
        }
    }

    private final void applyConstraints(ConstraintSet constraintSet) {
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.setOrdering(0);
        transitionSet.addTransition(new Fade(2)).addTransition(new ChangeBounds()).addTransition(new Fade(1));
        transitionSet.setInterpolator(new AnticipateOvershootInterpolator(1.0f));
        transitionSet.setDuration(300);
        if (!Intrinsics.areEqual((Object) constraintSet, (Object) this.activeContraintSet)) {
            TransitionManager.beginDelayedTransition(this, transitionSet);
            this.activeContraintSet = constraintSet;
            constraintSet.applyTo(this);
        }
    }

    private final void setActiveMedia() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            boolean z = childAt instanceof TextView;
            TextView textView = (TextView) (!z ? null : childAt);
            if (textView != null) {
                textView.setTextColor(this.theme.getTextColor());
            }
            Intrinsics.checkExpressionValueIsNotNull(childAt, ViewHierarchyConstants.VIEW_KEY);
            if (childAt.getTag() == this.gphContentType) {
                if (!z) {
                    childAt = null;
                }
                TextView textView2 = (TextView) childAt;
                if (textView2 != null) {
                    textView2.setTextColor(this.theme.getActiveTextColor());
                }
            }
        }
    }
}
