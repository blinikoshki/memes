package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.base.zae;
import com.google.android.gms.internal.base.zak;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class zad extends zab {
    private WeakReference<ImageView> zanh;

    public zad(ImageView imageView, Uri uri) {
        super(uri, 0);
        Asserts.checkNotNull(imageView);
        this.zanh = new WeakReference<>(imageView);
    }

    public final int hashCode() {
        return 0;
    }

    public zad(ImageView imageView, int i) {
        super((Uri) null, i);
        Asserts.checkNotNull(imageView);
        this.zanh = new WeakReference<>(imageView);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zad)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ImageView imageView = (ImageView) this.zanh.get();
        ImageView imageView2 = (ImageView) ((zad) obj).zanh.get();
        return (imageView2 == null || imageView == null || !Objects.equal(imageView2, imageView)) ? false : true;
    }

    /* access modifiers changed from: protected */
    public final void zaa(Drawable drawable, boolean z, boolean z2, boolean z3) {
        ImageView imageView = (ImageView) this.zanh.get();
        if (imageView != null) {
            int i = 0;
            boolean z4 = !z2 && !z3;
            if (z4 && (imageView instanceof zak)) {
                int zacf = zak.zacf();
                if (this.zanb != 0 && zacf == this.zanb) {
                    return;
                }
            }
            boolean zaa = zaa(z, z2);
            Uri uri = null;
            if (zaa) {
                Drawable drawable2 = imageView.getDrawable();
                if (drawable2 == null) {
                    drawable2 = null;
                } else if (drawable2 instanceof zae) {
                    drawable2 = ((zae) drawable2).zacd();
                }
                drawable = new zae(drawable2, drawable);
            }
            imageView.setImageDrawable(drawable);
            if (imageView instanceof zak) {
                if (z3) {
                    uri = this.zamz.uri;
                }
                zak.zaa(uri);
                if (z4) {
                    i = this.zanb;
                }
                zak.zai(i);
            }
            if (zaa) {
                ((zae) drawable).startTransition(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
            }
        }
    }
}
