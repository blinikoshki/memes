package com.memes.plus.p040ui.create_post.catalogueselection;

import android.view.View;
import android.widget.EditText;
import com.memes.commons.util.ExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.create_post.catalogueselection.ExportCatalogueSelectionActivity$onCreate$1 */
/* compiled from: ExportCatalogueSelectionActivity.kt */
final class ExportCatalogueSelectionActivity$onCreate$1 implements View.OnClickListener {
    final /* synthetic */ ExportCatalogueSelectionActivity this$0;

    ExportCatalogueSelectionActivity$onCreate$1(ExportCatalogueSelectionActivity exportCatalogueSelectionActivity) {
        this.this$0 = exportCatalogueSelectionActivity;
    }

    public final void onClick(View view) {
        EditText editText = this.this$0.getBinding().searchBoxLayout.searchEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.searchBoxLayout.searchEditText");
        ExtensionsKt.clearText(editText);
        ExportCatalogueSelectionActivity.onSearchRequested$default(this.this$0, (String) null, false, 2, (Object) null);
    }
}
