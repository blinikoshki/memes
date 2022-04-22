package com.memes.plus.p040ui.create_post.catalogueselection;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;
import com.memes.commons.util.SoftKeyboardUtil;
import com.memes.plus.base.BaseActivity;
import com.memes.plus.base.upgrades.Searchable;
import com.memes.plus.databinding.ExportCatalogueSelectionActivityBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001c\u0010\u0014\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo26107d2 = {"Lcom/memes/plus/ui/create_post/catalogueselection/ExportCatalogueSelectionActivity;", "Lcom/memes/plus/base/BaseActivity;", "()V", "binding", "Lcom/memes/plus/databinding/ExportCatalogueSelectionActivityBinding;", "getBinding", "()Lcom/memes/plus/databinding/ExportCatalogueSelectionActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "searchable", "Lcom/memes/plus/base/upgrades/Searchable;", "initHashTagSearchFunctionality", "", "initPeopleSearchFunctionality", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSearchQueryChanged", "query", "", "onSearchRequested", "closeKeyboard", "", "search", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.create_post.catalogueselection.ExportCatalogueSelectionActivity */
/* compiled from: ExportCatalogueSelectionActivity.kt */
public final class ExportCatalogueSelectionActivity extends BaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_SELECTION_TYPE = "intent_extra_selection_type";
    private final Lazy binding$delegate = LazyKt.lazy(new ExportCatalogueSelectionActivity$binding$2(this));
    private Searchable searchable;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.create_post.catalogueselection.ExportCatalogueSelectionActivity$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ExportCatalogueType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ExportCatalogueType.PEOPLE.ordinal()] = 1;
            iArr[ExportCatalogueType.HASHTAGS.ordinal()] = 2;
        }
    }

    /* access modifiers changed from: private */
    public final ExportCatalogueSelectionActivityBinding getBinding() {
        return (ExportCatalogueSelectionActivityBinding) this.binding$delegate.getValue();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/plus/ui/create_post/catalogueselection/ExportCatalogueSelectionActivity$Companion;", "", "()V", "EXTRA_SELECTION_TYPE", "", "getStartIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "selectionType", "Lcom/memes/plus/ui/create_post/catalogueselection/ExportCatalogueType;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.create_post.catalogueselection.ExportCatalogueSelectionActivity$Companion */
    /* compiled from: ExportCatalogueSelectionActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent getStartIntent(Context context, ExportCatalogueType exportCatalogueType) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(exportCatalogueType, "selectionType");
            Intent intent = new Intent(context, ExportCatalogueSelectionActivity.class);
            intent.putExtra(ExportCatalogueSelectionActivity.EXTRA_SELECTION_TYPE, exportCatalogueType);
            return intent;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ExportCatalogueSelectionActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView(binding.getRoot());
        getBinding().searchBoxLayout.searchInputCancelImageView.setOnClickListener(new ExportCatalogueSelectionActivity$onCreate$1(this));
        TextView textView = getBinding().searchBoxLayout.searchEditText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.searchBoxLayout.searchEditText");
        textView.addTextChangedListener(new C4249xe440e279(this));
        getBinding().searchBoxLayout.searchEditText.setOnEditorActionListener(new ExportCatalogueSelectionActivity$onCreate$3(this));
        SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
        EditText editText = getBinding().searchBoxLayout.searchEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.searchBoxLayout.searchEditText");
        softKeyboardUtil.showKeyboard(editText);
        Intent intent = getIntent();
        Object obj = null;
        Object serializableExtra = intent != null ? intent.getSerializableExtra(EXTRA_SELECTION_TYPE) : null;
        if (serializableExtra instanceof ExportCatalogueType) {
            obj = serializableExtra;
        }
        ExportCatalogueType exportCatalogueType = (ExportCatalogueType) obj;
        if (exportCatalogueType != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[exportCatalogueType.ordinal()];
            if (i == 1) {
                initPeopleSearchFunctionality();
                return;
            } else if (i == 2) {
                initHashTagSearchFunctionality();
                return;
            }
        }
        finish();
    }

    private final void initPeopleSearchFunctionality() {
        ExportPeopleSelectionFragment exportPeopleSelectionFragment = new ExportPeopleSelectionFragment();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        FragmentContainerView fragmentContainerView = getBinding().fragmentContainer;
        Intrinsics.checkNotNullExpressionValue(fragmentContainerView, "binding.fragmentContainer");
        beginTransaction.replace(fragmentContainerView.getId(), exportPeopleSelectionFragment).commitAllowingStateLoss();
        this.searchable = exportPeopleSelectionFragment;
    }

    private final void initHashTagSearchFunctionality() {
        ExportHashTagsSelectionFragment exportHashTagsSelectionFragment = new ExportHashTagsSelectionFragment();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        FragmentContainerView fragmentContainerView = getBinding().fragmentContainer;
        Intrinsics.checkNotNullExpressionValue(fragmentContainerView, "binding.fragmentContainer");
        beginTransaction.replace(fragmentContainerView.getId(), exportHashTagsSelectionFragment).commitAllowingStateLoss();
        this.searchable = exportHashTagsSelectionFragment;
    }

    /* access modifiers changed from: private */
    public final void onSearchQueryChanged(String str) {
        ImageView imageView = getBinding().searchBoxLayout.searchInputCancelImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.searchBoxLayout.searchInputCancelImageView");
        CharSequence charSequence = str;
        imageView.setVisibility(((charSequence.length() == 0) || StringsKt.isBlank(charSequence)) ? 8 : 0);
        onSearchRequested(str, false);
    }

    static /* synthetic */ void onSearchRequested$default(ExportCatalogueSelectionActivity exportCatalogueSelectionActivity, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        exportCatalogueSelectionActivity.onSearchRequested(str, z);
    }

    private final void onSearchRequested(String str, boolean z) {
        if (z) {
            SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
            EditText editText = getBinding().searchBoxLayout.searchEditText;
            Intrinsics.checkNotNullExpressionValue(editText, "binding.searchBoxLayout.searchEditText");
            softKeyboardUtil.hideKeyboard(editText);
        }
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            str = null;
        }
        search(str);
    }

    private final void search(String str) {
        Searchable searchable2 = this.searchable;
        if (searchable2 != null) {
            searchable2.search(str);
        }
    }
}
