package com.giphy.sdk.p013ui.views;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.giphy.sdk.p013ui.C1800R;
import com.giphy.sdk.p013ui.themes.GridType;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, mo26107d2 = {"com/giphy/sdk/ui/views/GiphyDialogFragment$getOpenAnimatorListener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GiphyDialogFragment$getOpenAnimatorListener$1 */
/* compiled from: GiphyDialogFragment.kt */
public final class GiphyDialogFragment$getOpenAnimatorListener$1 implements Animator.AnimatorListener {
    final /* synthetic */ GiphyDialogFragment this$0;

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }

    GiphyDialogFragment$getOpenAnimatorListener$1(GiphyDialogFragment giphyDialogFragment) {
        this.this$0 = giphyDialogFragment;
    }

    public void onAnimationEnd(Animator animator) {
        EditText editText;
        if (GiphyDialogFragment.access$getGiphySettings$p(this.this$0).getGridType() == GridType.waterfall || GiphyDialogFragment.access$getGiphySettings$p(this.this$0).getGridType() == GridType.emoji) {
            GiphyDialogFragment.access$getBaseView$p(this.this$0).setTranslationY(0.0f);
            ViewGroup.LayoutParams layoutParams = GiphyDialogFragment.access$getBaseView$p(this.this$0).getLayoutParams();
            if (layoutParams != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = (int) this.this$0.verticalDrag;
                GiphyDialogFragment.access$getBaseView$p(this.this$0).requestLayout();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
        } else {
            GiphySearchBar access$getSearchBar$p = this.this$0.searchBar;
            if (!(access$getSearchBar$p == null || (editText = (EditText) access$getSearchBar$p._$_findCachedViewById(C1800R.C1803id.searchInput)) == null)) {
                editText.requestFocus();
            }
            Context context = this.this$0.getContext();
            EditText editText2 = null;
            Object systemService = context != null ? context.getSystemService("input_method") : null;
            if (systemService != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                GiphySearchBar access$getSearchBar$p2 = this.this$0.searchBar;
                if (access$getSearchBar$p2 != null) {
                    editText2 = (EditText) access$getSearchBar$p2._$_findCachedViewById(C1800R.C1803id.searchInput);
                }
                inputMethodManager.showSoftInput(editText2, 1);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            }
        }
        if (GiphyDialogFragment.access$getGiphySettings$p(this.this$0).getShowConfirmationScreen() && GiphyDialogFragment.access$getGiphySettings$p(this.this$0).getGridType() != GridType.carousel) {
            this.this$0.createConfirmationView();
        }
    }

    public void onAnimationStart(Animator animator) {
        ValueAnimator access$getMediaSelectorAnimator$p;
        GiphyDialogFragment.access$getBaseView$p(this.this$0).setTranslationY((float) this.this$0.fullBaseViewHeight);
        GiphyDialogFragment.access$getBaseView$p(this.this$0).setVisibility(0);
        if (GiphyDialogFragment.access$getGiphySettings$p(this.this$0).getGridType() == GridType.waterfall && (access$getMediaSelectorAnimator$p = this.this$0.mediaSelectorAnimator) != null) {
            int[] iArr = new int[2];
            int height = GiphyDialogFragment.access$getSearchBarContainer$p(this.this$0).getHeight();
            GPHMediaTypeView access$getMediaSelectorView$p = this.this$0.mediaSelectorView;
            iArr[0] = height - (access$getMediaSelectorView$p != null ? access$getMediaSelectorView$p.getHeight() : 0);
            iArr[1] = GiphyDialogFragment.access$getSearchBarContainer$p(this.this$0).getHeight();
            access$getMediaSelectorAnimator$p.setIntValues(iArr);
        }
        this.this$0.setupGifsRecycler();
        this.this$0.setupGifActionsView();
    }
}
