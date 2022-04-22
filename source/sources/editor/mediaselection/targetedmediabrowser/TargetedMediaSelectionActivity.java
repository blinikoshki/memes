package editor.mediaselection.targetedmediabrowser;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;
import com.memes.commons.util.ExtensionsKt;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NMediaSelectionFragmentActivityBinding;
import com.memes.network.giphy.api.model.GiphyGif;
import com.memes.network.memes.api.model.stockmemes.StockMeme;
import com.memes.network.reddit.api.model.RedditPost;
import editor.core.NicoActivity;
import editor.mediaselection.MediaSelectionConfig;
import editor.mediaselection.MediaSelectionFragment;
import editor.mediaselection.giphygifs.GiphyGifsFragment;
import editor.mediaselection.giphygifs.OnGiphyGifSelectedListener;
import editor.mediaselection.redditposts.OnRedditPostSelectedListener;
import editor.mediaselection.redditposts.RedditPostsFragment;
import editor.mediaselection.stockmemes.OnStockMemeSelectedListener;
import editor.mediaselection.stockmemes.StockMemesFragment;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u0012\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0018\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\rH\u0016J\u0018\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020&2\u0006\u0010#\u001a\u00020\rH\u0016J\b\u0010'\u001a\u00020\u001bH\u0002J\u0018\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020*2\u0006\u0010#\u001a\u00020\rH\u0016R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R*\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015`\u0016X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0018j\b\u0012\u0004\u0012\u00020\u0014`\u0019X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, mo26107d2 = {"Leditor/mediaselection/targetedmediabrowser/TargetedMediaSelectionActivity;", "Leditor/core/NicoActivity;", "Leditor/mediaselection/stockmemes/OnStockMemeSelectedListener;", "Leditor/mediaselection/redditposts/OnRedditPostSelectedListener;", "Leditor/mediaselection/giphygifs/OnGiphyGifSelectedListener;", "()V", "binding", "Lcom/memes/editor/databinding/NMediaSelectionFragmentActivityBinding;", "getBinding", "()Lcom/memes/editor/databinding/NMediaSelectionFragmentActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "hadSelectedItems", "", "mediaSelectionConfig", "Leditor/mediaselection/MediaSelectionConfig;", "mediaSelectionTarget", "Leditor/mediaselection/targetedmediabrowser/MediaSelectionTarget;", "newlySelectedItems", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "selectedItemIds", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "loadConfig", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onGiphyGifSelected", "giphyGif", "Lcom/memes/network/giphy/api/model/GiphyGif;", "selected", "onRedditPostSelected", "redditPost", "Lcom/memes/network/reddit/api/model/RedditPost;", "onSelectionItemCountChanged", "onStockMemeSelected", "stockMeme", "Lcom/memes/network/memes/api/model/stockmemes/StockMeme;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TargetedMediaSelectionActivity.kt */
public final class TargetedMediaSelectionActivity extends NicoActivity implements OnStockMemeSelectedListener, OnRedditPostSelectedListener, OnGiphyGifSelectedListener {
    private final Lazy binding$delegate = LazyKt.lazy(new TargetedMediaSelectionActivity$binding$2(this));
    private boolean hadSelectedItems;
    private MediaSelectionConfig mediaSelectionConfig;
    private MediaSelectionTarget mediaSelectionTarget;
    /* access modifiers changed from: private */
    public final HashMap<String, Object> newlySelectedItems = new HashMap<>();
    /* access modifiers changed from: private */
    public final HashSet<String> selectedItemIds = new HashSet<>();

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MediaSelectionTarget.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[MediaSelectionTarget.GIPHY.ordinal()] = 1;
            iArr[MediaSelectionTarget.MEMES.ordinal()] = 2;
            iArr[MediaSelectionTarget.REDDIT.ordinal()] = 3;
        }
    }

    private final NMediaSelectionFragmentActivityBinding getBinding() {
        return (NMediaSelectionFragmentActivityBinding) this.binding$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        MediaSelectionFragment mediaSelectionFragment;
        super.onCreate(bundle);
        NMediaSelectionFragmentActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        loadConfig();
        getBinding().backImageView.setOnClickListener(new TargetedMediaSelectionActivity$onCreate$1(this));
        getBinding().doneTextView.setOnClickListener(new TargetedMediaSelectionActivity$onCreate$2(this));
        MediaSelectionTarget mediaSelectionTarget2 = this.mediaSelectionTarget;
        if (mediaSelectionTarget2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaSelectionTarget");
        }
        int i = WhenMappings.$EnumSwitchMapping$0[mediaSelectionTarget2.ordinal()];
        if (i == 1) {
            mediaSelectionFragment = new GiphyGifsFragment();
        } else if (i == 2) {
            mediaSelectionFragment = new StockMemesFragment();
        } else if (i == 3) {
            mediaSelectionFragment = new RedditPostsFragment();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        String tag = mediaSelectionFragment.tag();
        MediaSelectionConfig mediaSelectionConfig2 = this.mediaSelectionConfig;
        if (mediaSelectionConfig2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaSelectionConfig");
        }
        mediaSelectionFragment.setSelectedItemIds(mediaSelectionConfig2.getSelectedItemIds());
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        FragmentContainerView fragmentContainerView = getBinding().fragmentContainerView;
        Intrinsics.checkNotNullExpressionValue(fragmentContainerView, "binding.fragmentContainerView");
        beginTransaction.replace(fragmentContainerView.getId(), (Fragment) mediaSelectionFragment, tag).addToBackStack(tag).commit();
    }

    public void onBackPressed() {
        finish();
    }

    private final void loadConfig() {
        TargetedMediaSelectionConfig targetedMediaSelectionConfig;
        Intent intent = getIntent();
        if (intent == null || (targetedMediaSelectionConfig = (TargetedMediaSelectionConfig) intent.getParcelableExtra("intent_extra_media_selection_config")) == null) {
            throw new IllegalStateException("Selection config is missing.");
        }
        this.mediaSelectionTarget = targetedMediaSelectionConfig.getSelectionTarget();
        MediaSelectionConfig selectionConfig = targetedMediaSelectionConfig.getSelectionConfig();
        this.mediaSelectionConfig = selectionConfig;
        if (selectionConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaSelectionConfig");
        }
        if (selectionConfig.canSelectMoreItems()) {
            TextView textView = getBinding().titleTextView;
            MediaSelectionTarget mediaSelectionTarget2 = this.mediaSelectionTarget;
            if (mediaSelectionTarget2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaSelectionTarget");
            }
            textView.setText(mediaSelectionTarget2.getDisplayTextRes());
            this.selectedItemIds.clear();
            MediaSelectionConfig mediaSelectionConfig2 = this.mediaSelectionConfig;
            if (mediaSelectionConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaSelectionConfig");
            }
            Collection selectedItemIds2 = mediaSelectionConfig2.getSelectedItemIds();
            if (!(selectedItemIds2 == null || selectedItemIds2.isEmpty())) {
                this.hadSelectedItems = true;
                this.selectedItemIds.addAll(selectedItemIds2);
            } else {
                this.hadSelectedItems = false;
            }
            onSelectionItemCountChanged();
            return;
        }
        String string = getString(C4175R.string.error_media_selection_max_items_selected);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.error…ction_max_items_selected)");
        throw new IllegalStateException(string);
    }

    private final void onSelectionItemCountChanged() {
        int size = this.selectedItemIds.size();
        TextView textView = getBinding().selectionCountView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.selectionCountView");
        textView.setText(getResources().getQuantityString(C4175R.plurals.format_selected_items_count, size, new Object[]{Integer.valueOf(size)}));
        if (size > 0) {
            LinearLayout linearLayout = getBinding().selectionLayout;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.selectionLayout");
            linearLayout.setVisibility(0);
        } else if (!this.hadSelectedItems) {
            LinearLayout linearLayout2 = getBinding().selectionLayout;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.selectionLayout");
            linearLayout2.setVisibility(8);
        }
    }

    public boolean onGiphyGifSelected(GiphyGif giphyGif, boolean z) {
        Intrinsics.checkNotNullParameter(giphyGif, "giphyGif");
        String identifier = giphyGif.getIdentifier();
        if (this.selectedItemIds.contains(identifier) == z) {
            return z;
        }
        if (z) {
            MediaSelectionConfig mediaSelectionConfig2 = this.mediaSelectionConfig;
            if (mediaSelectionConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaSelectionConfig");
            }
            if (mediaSelectionConfig2.getSelectionCountLimit() == this.selectedItemIds.size()) {
                ExtensionsKt.toast((Context) this, C4175R.string.error_media_selection_max_items_selected);
                return false;
            }
            this.newlySelectedItems.put(identifier, giphyGif);
            this.selectedItemIds.add(identifier);
        } else {
            this.newlySelectedItems.remove(identifier);
            this.selectedItemIds.remove(identifier);
        }
        onSelectionItemCountChanged();
        return z;
    }

    public boolean onStockMemeSelected(StockMeme stockMeme, boolean z) {
        Intrinsics.checkNotNullParameter(stockMeme, "stockMeme");
        String identifier = stockMeme.getIdentifier();
        if (this.selectedItemIds.contains(identifier) == z) {
            return z;
        }
        if (z) {
            MediaSelectionConfig mediaSelectionConfig2 = this.mediaSelectionConfig;
            if (mediaSelectionConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaSelectionConfig");
            }
            if (mediaSelectionConfig2.getSelectionCountLimit() == this.selectedItemIds.size()) {
                ExtensionsKt.toast((Context) this, C4175R.string.error_media_selection_max_items_selected);
                return false;
            }
            this.newlySelectedItems.put(identifier, stockMeme);
            this.selectedItemIds.add(identifier);
        } else {
            this.newlySelectedItems.remove(identifier);
            this.selectedItemIds.remove(identifier);
        }
        onSelectionItemCountChanged();
        return z;
    }

    public boolean onRedditPostSelected(RedditPost redditPost, boolean z) {
        Intrinsics.checkNotNullParameter(redditPost, "redditPost");
        String identifier = redditPost.getIdentifier();
        if (this.selectedItemIds.contains(identifier) == z) {
            return z;
        }
        if (z) {
            MediaSelectionConfig mediaSelectionConfig2 = this.mediaSelectionConfig;
            if (mediaSelectionConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaSelectionConfig");
            }
            if (mediaSelectionConfig2.getSelectionCountLimit() == this.selectedItemIds.size()) {
                ExtensionsKt.toast((Context) this, C4175R.string.error_media_selection_max_items_selected);
                return false;
            }
            this.newlySelectedItems.put(identifier, redditPost);
            this.selectedItemIds.add(identifier);
        } else {
            this.newlySelectedItems.remove(identifier);
            this.selectedItemIds.remove(identifier);
        }
        onSelectionItemCountChanged();
        return z;
    }
}
