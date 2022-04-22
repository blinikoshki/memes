package coil.memory;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import coil.size.Size;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0012J\b\u0010\b\u001a\u00020\tH&J\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH¦\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH&J\u0019\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000bH¦\u0002R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0013"}, mo26107d2 = {"Lcoil/memory/MemoryCache;", "", "maxSize", "", "getMaxSize", "()I", "size", "getSize", "clear", "", "get", "Landroid/graphics/Bitmap;", "key", "Lcoil/memory/MemoryCache$Key;", "remove", "", "set", "bitmap", "Key", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: MemoryCache.kt */
public interface MemoryCache {
    void clear();

    Bitmap get(Key key);

    int getMaxSize();

    int getSize();

    boolean remove(Key key);

    void set(Key key, Bitmap bitmap);

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00032\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0006\u0007¨\u0006\b"}, mo26107d2 = {"Lcoil/memory/MemoryCache$Key;", "Landroid/os/Parcelable;", "()V", "Companion", "Complex", "Simple", "Lcoil/memory/MemoryCache$Key$Simple;", "Lcoil/memory/MemoryCache$Key$Complex;", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: MemoryCache.kt */
    public static abstract class Key implements Parcelable {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        @JvmStatic
        public static final Key create(String str) {
            return Companion.create(str);
        }

        private Key() {
        }

        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\u0007¨\u0006\b"}, mo26107d2 = {"Lcoil/memory/MemoryCache$Key$Companion;", "", "()V", "invoke", "Lcoil/memory/MemoryCache$Key;", "value", "", "create", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
        /* compiled from: MemoryCache.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final Key create(String str) {
                Intrinsics.checkNotNullParameter(str, "value");
                return new Simple(str);
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, mo26107d2 = {"Lcoil/memory/MemoryCache$Key$Simple;", "Lcoil/memory/MemoryCache$Key;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
        /* compiled from: MemoryCache.kt */
        public static final class Simple extends Key {
            public static final Parcelable.Creator<Simple> CREATOR = new Creator();
            private final String value;

            @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 1})
            public static class Creator implements Parcelable.Creator<Simple> {
                public final Simple createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Simple(parcel.readString());
                }

                public final Simple[] newArray(int i) {
                    return new Simple[i];
                }
            }

            public static /* synthetic */ Simple copy$default(Simple simple, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = simple.value;
                }
                return simple.copy(str);
            }

            public final String component1() {
                return this.value;
            }

            public final Simple copy(String str) {
                Intrinsics.checkNotNullParameter(str, "value");
                return new Simple(str);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof Simple) && Intrinsics.areEqual((Object) this.value, (Object) ((Simple) obj).value);
                }
                return true;
            }

            public int hashCode() {
                String str = this.value;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "Simple(value=" + this.value + ")";
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.value);
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Simple(String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "value");
                this.value = str;
            }

            public final String getValue() {
                return this.value;
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0015\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tHÆ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006%"}, mo26107d2 = {"Lcoil/memory/MemoryCache$Key$Complex;", "Lcoil/memory/MemoryCache$Key;", "base", "", "transformations", "", "size", "Lcoil/size/Size;", "parameters", "", "(Ljava/lang/String;Ljava/util/List;Lcoil/size/Size;Ljava/util/Map;)V", "getBase", "()Ljava/lang/String;", "getParameters", "()Ljava/util/Map;", "getSize", "()Lcoil/size/Size;", "getTransformations", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
        /* compiled from: MemoryCache.kt */
        public static final class Complex extends Key {
            public static final Parcelable.Creator<Complex> CREATOR = new Creator();
            private final String base;
            private final Map<String, String> parameters;
            private final Size size;
            private final List<String> transformations;

            @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 1})
            public static class Creator implements Parcelable.Creator<Complex> {
                public final Complex createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    String readString = parcel.readString();
                    List createStringArrayList = parcel.createStringArrayList();
                    Size size = (Size) parcel.readParcelable(Complex.class.getClassLoader());
                    int readInt = parcel.readInt();
                    LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
                    while (readInt != 0) {
                        linkedHashMap.put(parcel.readString(), parcel.readString());
                        readInt--;
                    }
                    return new Complex(readString, createStringArrayList, size, linkedHashMap);
                }

                public final Complex[] newArray(int i) {
                    return new Complex[i];
                }
            }

            public static /* synthetic */ Complex copy$default(Complex complex, String str, List<String> list, Size size2, Map<String, String> map, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = complex.base;
                }
                if ((i & 2) != 0) {
                    list = complex.transformations;
                }
                if ((i & 4) != 0) {
                    size2 = complex.size;
                }
                if ((i & 8) != 0) {
                    map = complex.parameters;
                }
                return complex.copy(str, list, size2, map);
            }

            public final String component1() {
                return this.base;
            }

            public final List<String> component2() {
                return this.transformations;
            }

            public final Size component3() {
                return this.size;
            }

            public final Map<String, String> component4() {
                return this.parameters;
            }

            public final Complex copy(String str, List<String> list, Size size2, Map<String, String> map) {
                Intrinsics.checkNotNullParameter(str, TtmlNode.RUBY_BASE);
                Intrinsics.checkNotNullParameter(list, "transformations");
                Intrinsics.checkNotNullParameter(map, "parameters");
                return new Complex(str, list, size2, map);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Complex)) {
                    return false;
                }
                Complex complex = (Complex) obj;
                return Intrinsics.areEqual((Object) this.base, (Object) complex.base) && Intrinsics.areEqual((Object) this.transformations, (Object) complex.transformations) && Intrinsics.areEqual((Object) this.size, (Object) complex.size) && Intrinsics.areEqual((Object) this.parameters, (Object) complex.parameters);
            }

            public int hashCode() {
                String str = this.base;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                List<String> list = this.transformations;
                int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
                Size size2 = this.size;
                int hashCode3 = (hashCode2 + (size2 != null ? size2.hashCode() : 0)) * 31;
                Map<String, String> map = this.parameters;
                if (map != null) {
                    i = map.hashCode();
                }
                return hashCode3 + i;
            }

            public String toString() {
                return "Complex(base=" + this.base + ", transformations=" + this.transformations + ", size=" + this.size + ", parameters=" + this.parameters + ")";
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.base);
                parcel.writeStringList(this.transformations);
                parcel.writeParcelable(this.size, i);
                Map<String, String> map = this.parameters;
                parcel.writeInt(map.size());
                for (Map.Entry<String, String> next : map.entrySet()) {
                    parcel.writeString(next.getKey());
                    parcel.writeString(next.getValue());
                }
            }

            public final String getBase() {
                return this.base;
            }

            public final List<String> getTransformations() {
                return this.transformations;
            }

            public final Size getSize() {
                return this.size;
            }

            public final Map<String, String> getParameters() {
                return this.parameters;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Complex(String str, List<String> list, Size size2, Map<String, String> map) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, TtmlNode.RUBY_BASE);
                Intrinsics.checkNotNullParameter(list, "transformations");
                Intrinsics.checkNotNullParameter(map, "parameters");
                this.base = str;
                this.transformations = list;
                this.size = size2;
                this.parameters = map;
            }
        }
    }
}
