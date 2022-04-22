package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MemberScope.kt */
public final class DescriptorKindFilter {
    public static final DescriptorKindFilter ALL;
    /* access modifiers changed from: private */
    public static final int ALL_KINDS_MASK;
    public static final DescriptorKindFilter CALLABLES;
    /* access modifiers changed from: private */
    public static final int CALLABLES_MASK;
    public static final DescriptorKindFilter CLASSIFIERS;
    /* access modifiers changed from: private */
    public static final int CLASSIFIERS_MASK;
    public static final Companion Companion;
    private static final List<Companion.MaskToName> DEBUG_MASK_BIT_NAMES;
    private static final List<Companion.MaskToName> DEBUG_PREDEFINED_FILTERS_MASK_NAMES;
    public static final DescriptorKindFilter FUNCTIONS;
    /* access modifiers changed from: private */
    public static final int FUNCTIONS_MASK;
    public static final DescriptorKindFilter NON_SINGLETON_CLASSIFIERS;
    /* access modifiers changed from: private */
    public static final int NON_SINGLETON_CLASSIFIERS_MASK;
    public static final DescriptorKindFilter PACKAGES;
    /* access modifiers changed from: private */
    public static final int PACKAGES_MASK;
    public static final DescriptorKindFilter SINGLETON_CLASSIFIERS;
    /* access modifiers changed from: private */
    public static final int SINGLETON_CLASSIFIERS_MASK;
    public static final DescriptorKindFilter TYPE_ALIASES;
    /* access modifiers changed from: private */
    public static final int TYPE_ALIASES_MASK;
    public static final DescriptorKindFilter VALUES;
    /* access modifiers changed from: private */
    public static final int VALUES_MASK;
    public static final DescriptorKindFilter VARIABLES;
    /* access modifiers changed from: private */
    public static final int VARIABLES_MASK;
    /* access modifiers changed from: private */
    public static int nextMaskValue = 1;
    private final List<DescriptorKindExclude> excludes;
    private final int kindMask;

    public DescriptorKindFilter(int i, List<? extends DescriptorKindExclude> list) {
        Intrinsics.checkNotNullParameter(list, "excludes");
        this.excludes = list;
        for (DescriptorKindExclude fullyExcludedDescriptorKinds : list) {
            i &= ~fullyExcludedDescriptorKinds.getFullyExcludedDescriptorKinds();
        }
        this.kindMask = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DescriptorKindFilter(int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<DescriptorKindExclude> getExcludes() {
        return this.excludes;
    }

    public final int getKindMask() {
        return this.kindMask;
    }

    public final boolean acceptsKinds(int i) {
        return (i & this.kindMask) != 0;
    }

    public final DescriptorKindFilter restrictedToKindsOrNull(int i) {
        int i2 = i & this.kindMask;
        if (i2 == 0) {
            return null;
        }
        return new DescriptorKindFilter(i2, this.excludes);
    }

    public String toString() {
        Object obj;
        boolean z;
        Iterator it = DEBUG_PREDEFINED_FILTERS_MASK_NAMES.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Companion.MaskToName) obj).getMask() == getKindMask()) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        Companion.MaskToName maskToName = (Companion.MaskToName) obj;
        String name = maskToName == null ? null : maskToName.getName();
        if (name == null) {
            Collection arrayList = new ArrayList();
            for (Companion.MaskToName maskToName2 : DEBUG_MASK_BIT_NAMES) {
                String name2 = acceptsKinds(maskToName2.getMask()) ? maskToName2.getName() : null;
                if (name2 != null) {
                    arrayList.add(name2);
                }
            }
            name = CollectionsKt.joinToString$default((List) arrayList, " | ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        return "DescriptorKindFilter(" + name + ", " + this.excludes + ')';
    }

    /* compiled from: MemberScope.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final int nextMask() {
            int access$getNextMaskValue$cp = DescriptorKindFilter.nextMaskValue;
            DescriptorKindFilter.nextMaskValue = DescriptorKindFilter.nextMaskValue << 1;
            return access$getNextMaskValue$cp;
        }

        public final int getNON_SINGLETON_CLASSIFIERS_MASK() {
            return DescriptorKindFilter.NON_SINGLETON_CLASSIFIERS_MASK;
        }

        public final int getSINGLETON_CLASSIFIERS_MASK() {
            return DescriptorKindFilter.SINGLETON_CLASSIFIERS_MASK;
        }

        public final int getTYPE_ALIASES_MASK() {
            return DescriptorKindFilter.TYPE_ALIASES_MASK;
        }

        public final int getPACKAGES_MASK() {
            return DescriptorKindFilter.PACKAGES_MASK;
        }

        public final int getFUNCTIONS_MASK() {
            return DescriptorKindFilter.FUNCTIONS_MASK;
        }

        public final int getVARIABLES_MASK() {
            return DescriptorKindFilter.VARIABLES_MASK;
        }

        public final int getALL_KINDS_MASK() {
            return DescriptorKindFilter.ALL_KINDS_MASK;
        }

        public final int getCLASSIFIERS_MASK() {
            return DescriptorKindFilter.CLASSIFIERS_MASK;
        }

        public final int getVALUES_MASK() {
            return DescriptorKindFilter.VALUES_MASK;
        }

        public final int getCALLABLES_MASK() {
            return DescriptorKindFilter.CALLABLES_MASK;
        }

        /* compiled from: MemberScope.kt */
        private static final class MaskToName {
            private final int mask;
            private final String name;

            public MaskToName(int i, String str) {
                Intrinsics.checkNotNullParameter(str, "name");
                this.mask = i;
                this.name = str;
            }

            public final int getMask() {
                return this.mask;
            }

            public final String getName() {
                return this.name;
            }
        }
    }

    static {
        Companion.MaskToName maskToName;
        Companion.MaskToName maskToName2;
        Class<DescriptorKindFilter> cls = DescriptorKindFilter.class;
        Companion companion = new Companion((DefaultConstructorMarker) null);
        Companion = companion;
        NON_SINGLETON_CLASSIFIERS_MASK = companion.nextMask();
        SINGLETON_CLASSIFIERS_MASK = companion.nextMask();
        TYPE_ALIASES_MASK = companion.nextMask();
        PACKAGES_MASK = companion.nextMask();
        FUNCTIONS_MASK = companion.nextMask();
        VARIABLES_MASK = companion.nextMask();
        ALL_KINDS_MASK = companion.nextMask() - 1;
        CLASSIFIERS_MASK = companion.getNON_SINGLETON_CLASSIFIERS_MASK() | companion.getSINGLETON_CLASSIFIERS_MASK() | companion.getTYPE_ALIASES_MASK();
        VALUES_MASK = companion.getSINGLETON_CLASSIFIERS_MASK() | companion.getFUNCTIONS_MASK() | companion.getVARIABLES_MASK();
        CALLABLES_MASK = companion.getFUNCTIONS_MASK() | companion.getVARIABLES_MASK();
        ALL = new DescriptorKindFilter(companion.getALL_KINDS_MASK(), (List) null, 2, (DefaultConstructorMarker) null);
        CALLABLES = new DescriptorKindFilter(companion.getCALLABLES_MASK(), (List) null, 2, (DefaultConstructorMarker) null);
        NON_SINGLETON_CLASSIFIERS = new DescriptorKindFilter(companion.getNON_SINGLETON_CLASSIFIERS_MASK(), (List) null, 2, (DefaultConstructorMarker) null);
        SINGLETON_CLASSIFIERS = new DescriptorKindFilter(companion.getSINGLETON_CLASSIFIERS_MASK(), (List) null, 2, (DefaultConstructorMarker) null);
        TYPE_ALIASES = new DescriptorKindFilter(companion.getTYPE_ALIASES_MASK(), (List) null, 2, (DefaultConstructorMarker) null);
        CLASSIFIERS = new DescriptorKindFilter(companion.getCLASSIFIERS_MASK(), (List) null, 2, (DefaultConstructorMarker) null);
        PACKAGES = new DescriptorKindFilter(companion.getPACKAGES_MASK(), (List) null, 2, (DefaultConstructorMarker) null);
        FUNCTIONS = new DescriptorKindFilter(companion.getFUNCTIONS_MASK(), (List) null, 2, (DefaultConstructorMarker) null);
        VARIABLES = new DescriptorKindFilter(companion.getVARIABLES_MASK(), (List) null, 2, (DefaultConstructorMarker) null);
        VALUES = new DescriptorKindFilter(companion.getVALUES_MASK(), (List) null, 2, (DefaultConstructorMarker) null);
        Field[] fields = cls.getFields();
        Intrinsics.checkNotNullExpressionValue(fields, "T::class.java.fields");
        Collection arrayList = new ArrayList();
        for (Object obj : (Object[]) fields) {
            if (Modifier.isStatic(((Field) obj).getModifiers())) {
                arrayList.add(obj);
            }
        }
        Collection arrayList2 = new ArrayList();
        for (Field field : (List) arrayList) {
            Object obj2 = field.get((Object) null);
            DescriptorKindFilter descriptorKindFilter = obj2 instanceof DescriptorKindFilter ? (DescriptorKindFilter) obj2 : null;
            if (descriptorKindFilter != null) {
                int kindMask2 = descriptorKindFilter.getKindMask();
                String name = field.getName();
                Intrinsics.checkNotNullExpressionValue(name, "field.name");
                maskToName2 = new Companion.MaskToName(kindMask2, name);
            } else {
                maskToName2 = null;
            }
            if (maskToName2 != null) {
                arrayList2.add(maskToName2);
            }
        }
        DEBUG_PREDEFINED_FILTERS_MASK_NAMES = (List) arrayList2;
        Field[] fields2 = cls.getFields();
        Intrinsics.checkNotNullExpressionValue(fields2, "T::class.java.fields");
        Collection arrayList3 = new ArrayList();
        for (Object obj3 : (Object[]) fields2) {
            if (Modifier.isStatic(((Field) obj3).getModifiers())) {
                arrayList3.add(obj3);
            }
        }
        Collection arrayList4 = new ArrayList();
        for (Object next : (List) arrayList3) {
            if (Intrinsics.areEqual((Object) ((Field) next).getType(), (Object) Integer.TYPE)) {
                arrayList4.add(next);
            }
        }
        Collection arrayList5 = new ArrayList();
        for (Field field2 : (List) arrayList4) {
            Object obj4 = field2.get((Object) null);
            Objects.requireNonNull(obj4, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj4).intValue();
            if (intValue == ((-intValue) & intValue)) {
                String name2 = field2.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "field.name");
                maskToName = new Companion.MaskToName(intValue, name2);
            } else {
                maskToName = null;
            }
            if (maskToName != null) {
                arrayList5.add(maskToName);
            }
        }
        DEBUG_MASK_BIT_NAMES = (List) arrayList5;
    }
}
