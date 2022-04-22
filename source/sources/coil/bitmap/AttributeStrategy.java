package coil.bitmap;

import android.graphics.Bitmap;
import coil.collection.LinkedMultimap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo26107d2 = {"Lcoil/bitmap/AttributeStrategy;", "Lcoil/bitmap/BitmapPoolStrategy;", "()V", "entries", "Lcoil/collection/LinkedMultimap;", "Lcoil/bitmap/AttributeStrategy$Key;", "Landroid/graphics/Bitmap;", "get", "width", "", "height", "config", "Landroid/graphics/Bitmap$Config;", "put", "", "bitmap", "removeLast", "stringify", "", "toString", "Key", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: BitmapPoolStrategy.kt */
public final class AttributeStrategy implements BitmapPoolStrategy {
    private final LinkedMultimap<Key, Bitmap> entries = new LinkedMultimap<>();

    public void put(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        LinkedMultimap<Key, Bitmap> linkedMultimap = this.entries;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap.Config config = bitmap.getConfig();
        Intrinsics.checkNotNullExpressionValue(config, "bitmap.config");
        linkedMultimap.put(new Key(width, height, config), bitmap);
    }

    public Bitmap get(int i, int i2, Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return this.entries.removeLast(new Key(i, i2, config));
    }

    public Bitmap removeLast() {
        return this.entries.removeLast();
    }

    public String stringify(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap.Config config = bitmap.getConfig();
        Intrinsics.checkNotNullExpressionValue(config, "bitmap.config");
        return stringify(width, height, config);
    }

    public String stringify(int i, int i2, Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return '[' + i + " x " + i2 + "], " + config;
    }

    public String toString() {
        return "AttributeStrategy: entries=" + this.entries;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, mo26107d2 = {"Lcoil/bitmap/AttributeStrategy$Key;", "", "width", "", "height", "config", "Landroid/graphics/Bitmap$Config;", "(IILandroid/graphics/Bitmap$Config;)V", "getConfig", "()Landroid/graphics/Bitmap$Config;", "getHeight", "()I", "getWidth", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: BitmapPoolStrategy.kt */
    private static final class Key {
        private final Bitmap.Config config;
        private final int height;
        private final int width;

        public static /* synthetic */ Key copy$default(Key key, int i, int i2, Bitmap.Config config2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = key.width;
            }
            if ((i3 & 2) != 0) {
                i2 = key.height;
            }
            if ((i3 & 4) != 0) {
                config2 = key.config;
            }
            return key.copy(i, i2, config2);
        }

        public final int component1() {
            return this.width;
        }

        public final int component2() {
            return this.height;
        }

        public final Bitmap.Config component3() {
            return this.config;
        }

        public final Key copy(int i, int i2, Bitmap.Config config2) {
            Intrinsics.checkNotNullParameter(config2, "config");
            return new Key(i, i2, config2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return this.width == key.width && this.height == key.height && Intrinsics.areEqual((Object) this.config, (Object) key.config);
        }

        public int hashCode() {
            int i = ((this.width * 31) + this.height) * 31;
            Bitmap.Config config2 = this.config;
            return i + (config2 != null ? config2.hashCode() : 0);
        }

        public String toString() {
            return "Key(width=" + this.width + ", height=" + this.height + ", config=" + this.config + ")";
        }

        public Key(int i, int i2, Bitmap.Config config2) {
            Intrinsics.checkNotNullParameter(config2, "config");
            this.width = i;
            this.height = i2;
            this.config = config2;
        }

        public final int getWidth() {
            return this.width;
        }

        public final int getHeight() {
            return this.height;
        }

        public final Bitmap.Config getConfig() {
            return this.config;
        }
    }
}
