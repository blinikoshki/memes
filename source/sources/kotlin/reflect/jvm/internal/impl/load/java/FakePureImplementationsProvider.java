package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: FakePureImplementationsProvider.kt */
public final class FakePureImplementationsProvider {
    public static final FakePureImplementationsProvider INSTANCE;
    private static final HashMap<FqName, FqName> pureImplementations = new HashMap<>();

    private FakePureImplementationsProvider() {
    }

    public final FqName getPurelyImplementedInterface(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "classFqName");
        return pureImplementations.get(fqName);
    }

    static {
        FakePureImplementationsProvider fakePureImplementationsProvider = new FakePureImplementationsProvider();
        INSTANCE = fakePureImplementationsProvider;
        fakePureImplementationsProvider.implementedWith(StandardNames.FqNames.mutableList, fakePureImplementationsProvider.fqNameListOf("java.util.ArrayList", "java.util.LinkedList"));
        fakePureImplementationsProvider.implementedWith(StandardNames.FqNames.mutableSet, fakePureImplementationsProvider.fqNameListOf("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        fakePureImplementationsProvider.implementedWith(StandardNames.FqNames.mutableMap, fakePureImplementationsProvider.fqNameListOf("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        fakePureImplementationsProvider.implementedWith(new FqName("java.util.function.Function"), fakePureImplementationsProvider.fqNameListOf("java.util.function.UnaryOperator"));
        fakePureImplementationsProvider.implementedWith(new FqName("java.util.function.BiFunction"), fakePureImplementationsProvider.fqNameListOf("java.util.function.BinaryOperator"));
    }

    private final void implementedWith(FqName fqName, List<FqName> list) {
        Map map = pureImplementations;
        for (Object next : list) {
            FqName fqName2 = (FqName) next;
            map.put(next, fqName);
        }
    }

    private final List<FqName> fqNameListOf(String... strArr) {
        Collection arrayList = new ArrayList(strArr.length);
        for (String fqName : strArr) {
            arrayList.add(new FqName(fqName));
        }
        return (List) arrayList;
    }
}
