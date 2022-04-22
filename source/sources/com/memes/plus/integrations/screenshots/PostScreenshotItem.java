package com.memes.plus.integrations.screenshots;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.exoplayer2.p024ui.PlayerView;
import com.memes.commons.util.Bitmaps;
import com.memes.plus.databinding.PostItemBinding;
import com.memes.plus.p040ui.posts.Post;
import com.memes.plus.p040ui.posts.post_basics.viewcount.PostViewCountView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Lcom/memes/plus/integrations/screenshots/PostScreenshotItem;", "Lcom/memes/plus/integrations/screenshots/ScreenshotItem;", "postBinding", "Lcom/memes/plus/databinding/PostItemBinding;", "post", "Lcom/memes/plus/ui/posts/Post;", "(Lcom/memes/plus/databinding/PostItemBinding;Lcom/memes/plus/ui/posts/Post;)V", "handlePreExecute", "", "handleRestore", "obtainScreenshot", "targetFile", "Ljava/io/File;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: PostScreenshotItem.kt */
public abstract class PostScreenshotItem implements ScreenshotItem {
    private final Post post;
    private final PostItemBinding postBinding;

    public abstract void handleRestore();

    public PostScreenshotItem(PostItemBinding postItemBinding, Post post2) {
        Intrinsics.checkNotNullParameter(postItemBinding, "postBinding");
        Intrinsics.checkNotNullParameter(post2, "post");
        this.postBinding = postItemBinding;
        this.post = post2;
    }

    public final void handlePreExecute() {
        StringBuilder sb;
        String str;
        ImageView imageView = this.postBinding.postOptionsImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "postBinding.postOptionsImageView");
        imageView.setVisibility(4);
        ImageView imageView2 = this.postBinding.postTaggedUsersIndicatorView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "postBinding.postTaggedUsersIndicatorView");
        imageView2.setVisibility(4);
        PostViewCountView postViewCountView = this.postBinding.postViewCountIndicatorView;
        Intrinsics.checkNotNullExpressionValue(postViewCountView, "postBinding.postViewCountIndicatorView");
        postViewCountView.setVisibility(4);
        Long createdDate = this.post.getCreatedDate();
        if (createdDate != null) {
            String format = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH).format(new Date(createdDate.longValue()));
            TextView textView = this.postBinding.postTimeTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "postBinding.postTimeTextView");
            textView.setText(format);
        }
        long totalComments = this.post.getTotalComments();
        if (totalComments > 0) {
            TextView textView2 = this.postBinding.commentsTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "postBinding.commentsTextView");
            if (totalComments == 1) {
                sb = new StringBuilder();
                sb.append(totalComments);
                str = " Comment";
            } else {
                sb = new StringBuilder();
                sb.append(totalComments);
                str = " Comments";
            }
            sb.append(str);
            textView2.setText(sb.toString());
            TextView textView3 = this.postBinding.commentsTextView;
            Intrinsics.checkNotNullExpressionValue(textView3, "postBinding.commentsTextView");
            textView3.setVisibility(0);
        } else {
            TextView textView4 = this.postBinding.commentsTextView;
            Intrinsics.checkNotNullExpressionValue(textView4, "postBinding.commentsTextView");
            textView4.setVisibility(8);
        }
        ImageView imageView3 = this.postBinding.postContentImageView;
        Intrinsics.checkNotNullExpressionValue(imageView3, "postBinding.postContentImageView");
        imageView3.setVisibility(0);
        PlayerView playerView = this.postBinding.postContentVideoView;
        Intrinsics.checkNotNullExpressionValue(playerView, "postBinding.postContentVideoView");
        playerView.setVisibility(8);
        this.postBinding.postMediaContentLayout.showContent();
    }

    public void obtainScreenshot(File file) {
        Intrinsics.checkNotNullParameter(file, "targetFile");
        handlePreExecute();
        LinearLayout linearLayout = this.postBinding.screenshotUiContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "postBinding.screenshotUiContainer");
        linearLayout.setDrawingCacheEnabled(true);
        linearLayout.buildDrawingCache();
        Bitmap drawingCache = linearLayout.getDrawingCache();
        Bitmaps bitmaps = Bitmaps.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(drawingCache, "itemBitmap");
        bitmaps.saveToFile(drawingCache, file, Bitmap.CompressFormat.PNG, 90);
        linearLayout.setDrawingCacheEnabled(false);
        linearLayout.destroyDrawingCache();
        handleRestore();
    }
}
