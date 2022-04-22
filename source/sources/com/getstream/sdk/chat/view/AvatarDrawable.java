package com.getstream.sdk.chat.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001:\u0001%B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J&\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0014H\u0002J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0018H\u0016J\u0012\u0010\u001f\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\f\u0010\"\u001a\u00020\u001b*\u00020\u001bH\u0002J\u0014\u0010#\u001a\u00020\u0004*\u00020\u00042\u0006\u0010$\u001a\u00020\u001bH\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/AvatarDrawable;", "Landroid/graphics/drawable/Drawable;", "bitmaps", "", "Landroid/graphics/Bitmap;", "(Ljava/util/List;)V", "avatarBitmaps", "avatarItems", "Lcom/getstream/sdk/chat/view/AvatarDrawable$AvatarItem;", "paint", "Landroid/graphics/Paint;", "configureDoubleAvatar", "topAvatarBitmap", "bottomAvatarBitmap", "configureSingleAvatar", "avatarBitmap", "configureTripleAvatar", "topLeftAvatarBitmap", "topRightAvatarBitmap", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "reconfigureItems", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "reduce", "scaleCenterCrop", "size", "AvatarItem", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AvatarView.kt */
final class AvatarDrawable extends Drawable {
    private final List<Bitmap> avatarBitmaps;
    private List<AvatarItem> avatarItems = CollectionsKt.emptyList();
    private final Paint paint = new Paint(1);

    public int getOpacity() {
        return -3;
    }

    public AvatarDrawable(List<Bitmap> list) {
        Intrinsics.checkNotNullParameter(list, "bitmaps");
        this.avatarBitmaps = CollectionsKt.take(list, 3);
    }

    private final void reconfigureItems() {
        List<AvatarItem> list;
        int size = this.avatarBitmaps.size();
        if (size == 0) {
            list = CollectionsKt.emptyList();
        } else if (size == 1) {
            list = configureSingleAvatar(this.avatarBitmaps.get(0));
        } else if (size != 2) {
            list = configureTripleAvatar(this.avatarBitmaps.get(0), this.avatarBitmaps.get(1), this.avatarBitmaps.get(2));
        } else {
            list = configureDoubleAvatar(this.avatarBitmaps.get(0), this.avatarBitmaps.get(1));
        }
        this.avatarItems = list;
    }

    private final List<AvatarItem> configureSingleAvatar(Bitmap bitmap) {
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "bounds");
        return CollectionsKt.listOf(new AvatarItem(scaleCenterCrop(bitmap, bounds), new Rect(0, 0, getBounds().width(), getBounds().height())));
    }

    private final List<AvatarItem> configureDoubleAvatar(Bitmap bitmap, Bitmap bitmap2) {
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "bounds");
        Rect reduce = reduce(bounds);
        return CollectionsKt.listOf(new AvatarItem(scaleCenterCrop(bitmap, reduce), reduce), new AvatarItem(scaleCenterCrop(bitmap2, reduce), new Rect(getBounds().right - reduce.right, getBounds().bottom - reduce.bottom, getBounds().right, getBounds().bottom)));
    }

    private final List<AvatarItem> configureTripleAvatar(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "bounds");
        Rect reduce = reduce(bounds);
        return CollectionsKt.listOf(new AvatarItem(scaleCenterCrop(bitmap, reduce), reduce), new AvatarItem(scaleCenterCrop(bitmap2, reduce), new Rect(getBounds().right - reduce.right, 0, getBounds().right, reduce.bottom)), new AvatarItem(scaleCenterCrop(bitmap3, reduce), new Rect((getBounds().right / 2) - (reduce.right / 2), getBounds().bottom - reduce.bottom, (getBounds().right / 2) + (reduce.right / 2), getBounds().bottom)));
    }

    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        for (AvatarItem avatarItem : this.avatarItems) {
            canvas.drawBitmap(avatarItem.getBitmap(), getBounds(), avatarItem.getPosition(), this.paint);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/AvatarDrawable$AvatarItem;", "", "bitmap", "Landroid/graphics/Bitmap;", "position", "Landroid/graphics/Rect;", "(Landroid/graphics/Bitmap;Landroid/graphics/Rect;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getPosition", "()Landroid/graphics/Rect;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: AvatarView.kt */
    private static final class AvatarItem {
        private final Bitmap bitmap;
        private final Rect position;

        public static /* synthetic */ AvatarItem copy$default(AvatarItem avatarItem, Bitmap bitmap2, Rect rect, int i, Object obj) {
            if ((i & 1) != 0) {
                bitmap2 = avatarItem.bitmap;
            }
            if ((i & 2) != 0) {
                rect = avatarItem.position;
            }
            return avatarItem.copy(bitmap2, rect);
        }

        public final Bitmap component1() {
            return this.bitmap;
        }

        public final Rect component2() {
            return this.position;
        }

        public final AvatarItem copy(Bitmap bitmap2, Rect rect) {
            Intrinsics.checkNotNullParameter(bitmap2, "bitmap");
            Intrinsics.checkNotNullParameter(rect, "position");
            return new AvatarItem(bitmap2, rect);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AvatarItem)) {
                return false;
            }
            AvatarItem avatarItem = (AvatarItem) obj;
            return Intrinsics.areEqual((Object) this.bitmap, (Object) avatarItem.bitmap) && Intrinsics.areEqual((Object) this.position, (Object) avatarItem.position);
        }

        public int hashCode() {
            Bitmap bitmap2 = this.bitmap;
            int i = 0;
            int hashCode = (bitmap2 != null ? bitmap2.hashCode() : 0) * 31;
            Rect rect = this.position;
            if (rect != null) {
                i = rect.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "AvatarItem(bitmap=" + this.bitmap + ", position=" + this.position + ")";
        }

        public AvatarItem(Bitmap bitmap2, Rect rect) {
            Intrinsics.checkNotNullParameter(bitmap2, "bitmap");
            Intrinsics.checkNotNullParameter(rect, "position");
            this.bitmap = bitmap2;
            this.position = rect;
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final Rect getPosition() {
            return this.position;
        }
    }

    public void setAlpha(int i) {
        this.paint.setAlpha(i);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "bounds");
        super.onBoundsChange(rect);
        reconfigureItems();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    private final Rect reduce(Rect rect) {
        return new Rect(0, 0, (int) (((double) rect.width()) / 1.7d), (int) (((double) rect.height()) / 1.7d));
    }

    private final Bitmap scaleCenterCrop(Bitmap bitmap, Rect rect) {
        Bitmap extractThumbnail = ThumbnailUtils.extractThumbnail(bitmap, rect.width(), rect.height());
        Intrinsics.checkNotNullExpressionValue(extractThumbnail, "ThumbnailUtils.extractTh…e.width(), size.height())");
        return extractThumbnail;
    }
}
