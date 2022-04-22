package p015io.getstream.chat.android.client.api.models;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty1;
import p015io.getstream.chat.android.client.extensions.StringExtensionsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0005'()*+B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0002J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013J\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015J&\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00180\u0017J\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013J\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015J&\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00180\u0017J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u0002J$\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0002J$\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00020\"0\nJ\u0018\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020%0$0\nJ:\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0006*\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00180\u00172\u0006\u0010&\u001a\u00020%H\u0002R%\u0010\u0004\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0005j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\nX\u000e¢\u0006\u0002\n\u0000R2\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0006*\b\u0012\u0004\u0012\u00028\u00000\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\f¨\u0006,"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/QuerySort;", "T", "", "()V", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "getComparator", "()Ljava/util/Comparator;", "sortSpecifications", "", "Lio/getstream/chat/android/client/api/models/QuerySort$SortSpecification;", "(Lio/getstream/chat/android/client/api/models/QuerySort$SortSpecification;)Ljava/util/Comparator;", "add", "sortSpecification", "asc", "fieldName", "", "javaClass", "Ljava/lang/Class;", "kClass", "Lkotlin/reflect/KClass;", "field", "Lkotlin/reflect/KProperty1;", "", "desc", "equals", "", "other", "getSortFeature", "Lio/getstream/chat/android/client/api/models/QuerySort$SortAttribute;", "hashCode", "", "toDto", "", "toList", "Lkotlin/Pair;", "Lio/getstream/chat/android/client/api/models/QuerySort$SortDirection;", "sortDirection", "Companion", "CompositeComparator", "SortAttribute", "SortDirection", "SortSpecification", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.QuerySort */
/* compiled from: QuerySort.kt */
public final class QuerySort<T> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int EQUAL_ON_COMPARISON = 0;
    public static final String KEY_DIRECTION = "direction";
    public static final String KEY_FIELD_NAME = "field";
    private List<SortSpecification<T>> sortSpecifications = CollectionsKt.emptyList();

    public final Comparator<? super T> getComparator() {
        Collection arrayList = new ArrayList();
        for (SortSpecification comparator : this.sortSpecifications) {
            Comparator comparator2 = getComparator(comparator);
            if (comparator2 != null) {
                arrayList.add(comparator2);
            }
        }
        return new CompositeComparator<>((List) arrayList);
    }

    private final Comparator<T> getComparator(SortSpecification<T> sortSpecification) {
        KProperty1 field;
        SortAttribute<T> sortAttribute = sortSpecification.getSortAttribute();
        if (!(sortAttribute instanceof SortAttribute.FieldSortAttribute)) {
            sortAttribute = null;
        }
        SortAttribute.FieldSortAttribute fieldSortAttribute = (SortAttribute.FieldSortAttribute) sortAttribute;
        if (fieldSortAttribute == null || (field = fieldSortAttribute.getField()) == null) {
            return null;
        }
        return comparator(field, sortSpecification.getSortDirection());
    }

    private final Comparator<T> comparator(KProperty1<T, ? extends Comparable<?>> kProperty1, SortDirection sortDirection) {
        return new QuerySort$comparator$$inlined$let$lambda$1<>(kProperty1, sortDirection);
    }

    private final QuerySort<T> add(SortSpecification<T> sortSpecification) {
        this.sortSpecifications = CollectionsKt.plus(this.sortSpecifications, sortSpecification);
        return this;
    }

    public final QuerySort<T> asc(KProperty1<T, ? extends Comparable<?>> kProperty1) {
        Intrinsics.checkNotNullParameter(kProperty1, KEY_FIELD_NAME);
        return add(new SortSpecification(new SortAttribute.FieldSortAttribute(kProperty1, StringExtensionsKt.camelCaseToSnakeCase(kProperty1.getName())), SortDirection.ASC));
    }

    public final QuerySort<T> desc(KProperty1<T, ? extends Comparable<?>> kProperty1) {
        Intrinsics.checkNotNullParameter(kProperty1, KEY_FIELD_NAME);
        return add(new SortSpecification(new SortAttribute.FieldSortAttribute(kProperty1, StringExtensionsKt.camelCaseToSnakeCase(kProperty1.getName())), SortDirection.DESC));
    }

    public final QuerySort<T> asc(String str, Class<T> cls) {
        Intrinsics.checkNotNullParameter(str, "fieldName");
        Intrinsics.checkNotNullParameter(cls, "javaClass");
        return add(new SortSpecification(getSortFeature(str, cls), SortDirection.ASC));
    }

    public final QuerySort<T> desc(String str, Class<T> cls) {
        Intrinsics.checkNotNullParameter(str, "fieldName");
        Intrinsics.checkNotNullParameter(cls, "javaClass");
        return add(new SortSpecification(getSortFeature(str, cls), SortDirection.DESC));
    }

    public final QuerySort<T> asc(String str) {
        Intrinsics.checkNotNullParameter(str, "fieldName");
        return add(new SortSpecification(new SortAttribute.FieldNameSortAttribute(str), SortDirection.ASC));
    }

    public final QuerySort<T> desc(String str) {
        Intrinsics.checkNotNullParameter(str, "fieldName");
        return add(new SortSpecification(new SortAttribute.FieldNameSortAttribute(str), SortDirection.DESC));
    }

    public final QuerySort<T> asc(String str, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(str, "fieldName");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        return add(new SortSpecification(getSortFeature(str, kClass), SortDirection.ASC));
    }

    public final QuerySort<T> desc(String str, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(str, "fieldName");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        return add(new SortSpecification(getSortFeature(str, kClass), SortDirection.DESC));
    }

    public final List<Map<String, Object>> toDto() {
        Iterable<SortSpecification> iterable = this.sortSpecifications;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (SortSpecification sortSpecification : iterable) {
            arrayList.add(MapsKt.toMap(CollectionsKt.listOf(TuplesKt.m181to(KEY_FIELD_NAME, sortSpecification.getSortAttribute().getName()), TuplesKt.m181to(KEY_DIRECTION, Integer.valueOf(sortSpecification.getSortDirection().getValue())))));
        }
        return (List) arrayList;
    }

    public final List<Pair<String, SortDirection>> toList() {
        Iterable<SortSpecification> iterable = this.sortSpecifications;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (SortSpecification sortSpecification : iterable) {
            arrayList.add(TuplesKt.m181to(sortSpecification.getSortAttribute().getName(), sortSpecification.getSortDirection()));
        }
        return (List) arrayList;
    }

    private final SortAttribute<T> getSortFeature(String str, Class<T> cls) {
        KClass createKotlinClass = Reflection.createKotlinClass(cls);
        Objects.requireNonNull(createKotlinClass, "null cannot be cast to non-null type kotlin.reflect.KClass<T>");
        return getSortFeature(str, createKotlinClass);
    }

    private final SortAttribute<T> getSortFeature(String str, KClass<T> kClass) {
        Object obj;
        Collection arrayList = new ArrayList();
        for (Object next : kClass.getMembers()) {
            if (next instanceof KProperty1) {
                arrayList.add(next);
            }
        }
        Iterator it = ((List) arrayList).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((KProperty1) obj).getName(), (Object) StringExtensionsKt.snakeToLowerCamelCase(str))) {
                break;
            }
        }
        KProperty1 kProperty1 = (KProperty1) obj;
        if (kProperty1 != null) {
            return new SortAttribute.FieldSortAttribute<>(kProperty1, str);
        }
        return new SortAttribute.FieldNameSortAttribute<>(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type io.getstream.chat.android.client.api.models.QuerySort<*>");
        if (!Intrinsics.areEqual((Object) this.sortSpecifications, (Object) ((QuerySort) obj).sortSpecifications)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.sortSpecifications.hashCode();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J)\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/QuerySort$SortSpecification;", "T", "", "sortAttribute", "Lio/getstream/chat/android/client/api/models/QuerySort$SortAttribute;", "sortDirection", "Lio/getstream/chat/android/client/api/models/QuerySort$SortDirection;", "(Lio/getstream/chat/android/client/api/models/QuerySort$SortAttribute;Lio/getstream/chat/android/client/api/models/QuerySort$SortDirection;)V", "getSortAttribute", "()Lio/getstream/chat/android/client/api/models/QuerySort$SortAttribute;", "getSortDirection", "()Lio/getstream/chat/android/client/api/models/QuerySort$SortDirection;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.api.models.QuerySort$SortSpecification */
    /* compiled from: QuerySort.kt */
    private static final class SortSpecification<T> {
        private final SortAttribute<T> sortAttribute;
        private final SortDirection sortDirection;

        public static /* synthetic */ SortSpecification copy$default(SortSpecification sortSpecification, SortAttribute<T> sortAttribute2, SortDirection sortDirection2, int i, Object obj) {
            if ((i & 1) != 0) {
                sortAttribute2 = sortSpecification.sortAttribute;
            }
            if ((i & 2) != 0) {
                sortDirection2 = sortSpecification.sortDirection;
            }
            return sortSpecification.copy(sortAttribute2, sortDirection2);
        }

        public final SortAttribute<T> component1() {
            return this.sortAttribute;
        }

        public final SortDirection component2() {
            return this.sortDirection;
        }

        public final SortSpecification<T> copy(SortAttribute<T> sortAttribute2, SortDirection sortDirection2) {
            Intrinsics.checkNotNullParameter(sortAttribute2, "sortAttribute");
            Intrinsics.checkNotNullParameter(sortDirection2, "sortDirection");
            return new SortSpecification<>(sortAttribute2, sortDirection2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SortSpecification)) {
                return false;
            }
            SortSpecification sortSpecification = (SortSpecification) obj;
            return Intrinsics.areEqual((Object) this.sortAttribute, (Object) sortSpecification.sortAttribute) && Intrinsics.areEqual((Object) this.sortDirection, (Object) sortSpecification.sortDirection);
        }

        public int hashCode() {
            SortAttribute<T> sortAttribute2 = this.sortAttribute;
            int i = 0;
            int hashCode = (sortAttribute2 != null ? sortAttribute2.hashCode() : 0) * 31;
            SortDirection sortDirection2 = this.sortDirection;
            if (sortDirection2 != null) {
                i = sortDirection2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "SortSpecification(sortAttribute=" + this.sortAttribute + ", sortDirection=" + this.sortDirection + ")";
        }

        public SortSpecification(SortAttribute<T> sortAttribute2, SortDirection sortDirection2) {
            Intrinsics.checkNotNullParameter(sortAttribute2, "sortAttribute");
            Intrinsics.checkNotNullParameter(sortDirection2, "sortDirection");
            this.sortAttribute = sortAttribute2;
            this.sortDirection = sortDirection2;
        }

        public final SortAttribute<T> getSortAttribute() {
            return this.sortAttribute;
        }

        public final SortDirection getSortDirection() {
            return this.sortDirection;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002:\u0002\b\tB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002\n\u000b¨\u0006\f"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/QuerySort$SortAttribute;", "T", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "FieldNameSortAttribute", "FieldSortAttribute", "Lio/getstream/chat/android/client/api/models/QuerySort$SortAttribute$FieldSortAttribute;", "Lio/getstream/chat/android/client/api/models/QuerySort$SortAttribute$FieldNameSortAttribute;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.api.models.QuerySort$SortAttribute */
    /* compiled from: QuerySort.kt */
    private static abstract class SortAttribute<T> {
        private final String name;

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/QuerySort$SortAttribute$FieldSortAttribute;", "T", "Lio/getstream/chat/android/client/api/models/QuerySort$SortAttribute;", "field", "Lkotlin/reflect/KProperty1;", "", "name", "", "(Lkotlin/reflect/KProperty1;Ljava/lang/String;)V", "getField", "()Lkotlin/reflect/KProperty1;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.client.api.models.QuerySort$SortAttribute$FieldSortAttribute */
        /* compiled from: QuerySort.kt */
        public static final class FieldSortAttribute<T> extends SortAttribute<T> {
            private final KProperty1<T, Comparable<?>> field;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public FieldSortAttribute(KProperty1<T, ? extends Comparable<?>> kProperty1, String str) {
                super(str, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(kProperty1, QuerySort.KEY_FIELD_NAME);
                Intrinsics.checkNotNullParameter(str, "name");
                this.field = kProperty1;
            }

            public final KProperty1<T, Comparable<?>> getField() {
                return this.field;
            }
        }

        private SortAttribute(String str) {
            this.name = str;
        }

        public /* synthetic */ SortAttribute(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        public final String getName() {
            return this.name;
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/QuerySort$SortAttribute$FieldNameSortAttribute;", "T", "Lio/getstream/chat/android/client/api/models/QuerySort$SortAttribute;", "fieldName", "", "(Ljava/lang/String;)V", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.client.api.models.QuerySort$SortAttribute$FieldNameSortAttribute */
        /* compiled from: QuerySort.kt */
        public static final class FieldNameSortAttribute<T> extends SortAttribute<T> {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public FieldNameSortAttribute(String str) {
                super(str, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "fieldName");
            }
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/QuerySort$SortDirection;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DESC", "ASC", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.api.models.QuerySort$SortDirection */
    /* compiled from: QuerySort.kt */
    public enum SortDirection {
        DESC(-1),
        ASC(1);
        
        private final int value;

        private SortDirection(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0001\u0010\u00012\u0012\u0012\u0004\u0012\u0002H\u00010\u0002j\b\u0012\u0004\u0012\u0002H\u0001`\u0003B#\u0012\u001c\u0010\u0004\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00010\u0002j\b\u0012\u0004\u0012\u00028\u0001`\u00030\u0005¢\u0006\u0002\u0010\u0006J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000bR$\u0010\u0004\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00010\u0002j\b\u0012\u0004\u0012\u00028\u0001`\u00030\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/QuerySort$CompositeComparator;", "T", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparators", "", "(Ljava/util/List;)V", "compare", "", "o1", "o2", "(Ljava/lang/Object;Ljava/lang/Object;)I", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.api.models.QuerySort$CompositeComparator */
    /* compiled from: QuerySort.kt */
    public static final class CompositeComparator<T> implements Comparator<T> {
        private final List<Comparator<T>> comparators;

        public CompositeComparator(List<? extends Comparator<T>> list) {
            Intrinsics.checkNotNullParameter(list, "comparators");
            this.comparators = list;
        }

        public int compare(T t, T t2) {
            int i = 0;
            for (Comparator comparator : this.comparators) {
                if (i == 0) {
                    i = comparator.compare(t, t2);
                }
            }
            return i;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\n\b\u0001\u0010\n\u0018\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0006H\bJ0\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\b\b\u0001\u0010\n*\u00020\u00012\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u000e0\rJ#\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\n\b\u0001\u0010\n\u0018\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0006H\bJ0\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\b\b\u0001\u0010\n*\u00020\u00012\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u000e0\rJ-\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\n\b\u0001\u0010\n\u0018\u0001*\u00020\u0001*\b\u0012\u0004\u0012\u0002H\n0\t2\u0006\u0010\u000b\u001a\u00020\u0006H\bJ-\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\n\b\u0001\u0010\n\u0018\u0001*\u00020\u0001*\b\u0012\u0004\u0012\u0002H\n0\t2\u0006\u0010\u000b\u001a\u00020\u0006H\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/QuerySort$Companion;", "", "()V", "EQUAL_ON_COMPARISON", "", "KEY_DIRECTION", "", "KEY_FIELD_NAME", "asc", "Lio/getstream/chat/android/client/api/models/QuerySort;", "T", "fieldName", "field", "Lkotlin/reflect/KProperty1;", "", "desc", "ascByName", "descByName", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.api.models.QuerySort$Companion */
    /* compiled from: QuerySort.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final /* synthetic */ <T> QuerySort<T> ascByName(QuerySort<T> querySort, String str) {
            Intrinsics.checkNotNullParameter(querySort, "$this$ascByName");
            Intrinsics.checkNotNullParameter(str, "fieldName");
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return querySort.asc(str, (KClass<T>) Reflection.getOrCreateKotlinClass(Object.class));
        }

        public final /* synthetic */ <T> QuerySort<T> descByName(QuerySort<T> querySort, String str) {
            Intrinsics.checkNotNullParameter(querySort, "$this$descByName");
            Intrinsics.checkNotNullParameter(str, "fieldName");
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return querySort.desc(str, (KClass<T>) Reflection.getOrCreateKotlinClass(Object.class));
        }

        public final /* synthetic */ <T> QuerySort<T> asc(String str) {
            Intrinsics.checkNotNullParameter(str, "fieldName");
            Companion companion = this;
            QuerySort querySort = new QuerySort();
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return querySort.asc(str, Reflection.getOrCreateKotlinClass(Object.class));
        }

        public final /* synthetic */ <T> QuerySort<T> desc(String str) {
            Intrinsics.checkNotNullParameter(str, "fieldName");
            Companion companion = this;
            QuerySort querySort = new QuerySort();
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return querySort.desc(str, Reflection.getOrCreateKotlinClass(Object.class));
        }

        public final <T> QuerySort<T> asc(KProperty1<T, ? extends Comparable<?>> kProperty1) {
            Intrinsics.checkNotNullParameter(kProperty1, QuerySort.KEY_FIELD_NAME);
            return new QuerySort().asc(kProperty1);
        }

        public final <T> QuerySort<T> desc(KProperty1<T, ? extends Comparable<?>> kProperty1) {
            Intrinsics.checkNotNullParameter(kProperty1, QuerySort.KEY_FIELD_NAME);
            return new QuerySort().desc(kProperty1);
        }
    }
}
