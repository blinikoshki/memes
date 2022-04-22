package com.memes.plus.p040ui.create_post;

import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import com.memes.plus.C4199R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "", "isChecked", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.create_post.ExportPostActivity$attachObservers$10 */
/* compiled from: ExportPostActivity.kt */
final class ExportPostActivity$attachObservers$10<T> implements Observer<Boolean> {
    final /* synthetic */ ExportPostActivity this$0;

    ExportPostActivity$attachObservers$10(ExportPostActivity exportPostActivity) {
        this.this$0 = exportPostActivity;
    }

    public final void onChanged(Boolean bool) {
        Intrinsics.checkNotNullExpressionValue(bool, "isChecked");
        if (bool.booleanValue()) {
            TextView textView = this.this$0.getBinding().savePostTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.savePostTextView");
            textView.setText(this.this$0.getResources().getString(C4199R.string.auto_save_when_sharing));
            this.this$0.getBinding().savePostTextView.setTextColor(ContextCompat.getColor(this.this$0, C4199R.C4201color.white));
            TextView textView2 = this.this$0.getBinding().autoSaveMessageTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.autoSaveMessageTextView");
            textView2.setVisibility(8);
            return;
        }
        TextView textView3 = this.this$0.getBinding().savePostTextView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.savePostTextView");
        textView3.setText(this.this$0.getResources().getString(C4199R.string.save_to_gallery));
        this.this$0.getBinding().savePostTextView.setTextColor(ContextCompat.getColor(this.this$0, C4199R.C4201color.colorText));
        TextView textView4 = this.this$0.getBinding().autoSaveMessageTextView;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.autoSaveMessageTextView");
        textView4.setVisibility(0);
    }
}
