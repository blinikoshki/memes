package com.memes.plus.p040ui.create_post.catalogueselection;

import android.text.Editable;
import android.text.TextWatcher;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0000"}, mo26107d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.create_post.catalogueselection.ExportCatalogueSelectionActivity$onCreate$$inlined$addTextChangedListener$1 */
/* compiled from: TextView.kt */
public final class C4249xe440e279 implements TextWatcher {
    final /* synthetic */ ExportCatalogueSelectionActivity this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public C4249xe440e279(ExportCatalogueSelectionActivity exportCatalogueSelectionActivity) {
        this.this$0 = exportCatalogueSelectionActivity;
    }

    public void afterTextChanged(Editable editable) {
        ExportCatalogueSelectionActivity exportCatalogueSelectionActivity = this.this$0;
        String valueOf = String.valueOf(editable);
        Objects.requireNonNull(valueOf, "null cannot be cast to non-null type kotlin.CharSequence");
        exportCatalogueSelectionActivity.onSearchQueryChanged(StringsKt.trim((CharSequence) valueOf).toString());
    }
}
