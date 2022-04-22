package com.memes.plus.integrations.screenshots;

import android.graphics.Bitmap;
import android.view.View;
import com.memes.commons.util.Bitmaps;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/integrations/screenshots/ProfileScreenshotItem;", "Lcom/memes/plus/integrations/screenshots/ScreenshotItem;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "obtainScreenshot", "", "targetFile", "Ljava/io/File;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ProfileScreenshotItem.kt */
public final class ProfileScreenshotItem implements ScreenshotItem {
    private final View itemView;

    public ProfileScreenshotItem(View view) {
        Intrinsics.checkNotNullParameter(view, "itemView");
        this.itemView = view;
    }

    public void obtainScreenshot(File file) {
        Intrinsics.checkNotNullParameter(file, "targetFile");
        this.itemView.setDrawingCacheEnabled(true);
        this.itemView.buildDrawingCache();
        Bitmap drawingCache = this.itemView.getDrawingCache();
        Bitmaps bitmaps = Bitmaps.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(drawingCache, "bitmap");
        bitmaps.saveToFile(drawingCache, file, Bitmap.CompressFormat.PNG, 90);
        this.itemView.setDrawingCacheEnabled(false);
        this.itemView.destroyDrawingCache();
    }
}
