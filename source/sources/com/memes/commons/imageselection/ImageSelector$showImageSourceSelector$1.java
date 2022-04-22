package com.memes.commons.imageselection;

import android.content.DialogInterface;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo26107d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ImageSelector.kt */
final class ImageSelector$showImageSourceSelector$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ List $sources;
    final /* synthetic */ ImageSelector this$0;

    ImageSelector$showImageSourceSelector$1(ImageSelector imageSelector, List list) {
        this.this$0 = imageSelector;
        this.$sources = list;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.this$0.openImageSelector((ImageSource) this.$sources.get(i));
        dialogInterface.dismiss();
    }
}
