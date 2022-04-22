package com.memes.plus.p040ui.create_post;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.io.File;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "file", "Ljava/io/File;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.create_post.ExportPostActivity$attachObservers$1 */
/* compiled from: ExportPostActivity.kt */
final class ExportPostActivity$attachObservers$1<T> implements Observer<File> {
    final /* synthetic */ ExportPostActivity this$0;

    ExportPostActivity$attachObservers$1(ExportPostActivity exportPostActivity) {
        this.this$0 = exportPostActivity;
    }

    public final void onChanged(File file) {
        ((RequestBuilder) ((RequestBuilder) Glide.with((FragmentActivity) this.this$0).load(file).diskCacheStrategy(DiskCacheStrategy.NONE)).skipMemoryCache(true)).into(this.this$0.getBinding().memePreviewImageView);
    }
}
