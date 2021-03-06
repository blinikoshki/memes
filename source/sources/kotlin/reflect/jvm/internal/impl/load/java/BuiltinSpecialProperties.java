package kotlin.reflect.jvm.internal.impl.load.java;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: BuiltinSpecialProperties.kt */
public final class BuiltinSpecialProperties {
    private static final Map<Name, List<Name>> GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP;
    public static final BuiltinSpecialProperties INSTANCE = new BuiltinSpecialProperties();
    private static final Map<FqName, Name> PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
    private static final Set<FqName> SPECIAL_FQ_NAMES;
    private static final Set<Name> SPECIAL_SHORT_NAMES;

    private BuiltinSpecialProperties() {
    }

    public final Map<FqName, Name> getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP() {
        return PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
    }

    static {
        Map<FqName, Name> mapOf = MapsKt.mapOf(TuplesKt.m181to(BuiltinSpecialPropertiesKt.childSafe(StandardNames.FqNames._enum, "name"), Name.identifier("name")), TuplesKt.m181to(BuiltinSpecialPropertiesKt.childSafe(StandardNames.FqNames._enum, "ordinal"), Name.identifier("ordinal")), TuplesKt.m181to(BuiltinSpecialPropertiesKt.child(StandardNames.FqNames.collection, "size"), Name.identifier("size")), TuplesKt.m181to(BuiltinSpecialPropertiesKt.child(StandardNames.FqNames.map, "size"), Name.identifier("size")), TuplesKt.m181to(BuiltinSpecialPropertiesKt.childSafe(StandardNames.FqNames.charSequence, "length"), Name.identifier("length")), TuplesKt.m181to(BuiltinSpecialPropertiesKt.child(StandardNames.FqNames.map, "keys"), Name.identifier("keySet")), TuplesKt.m181to(BuiltinSpecialPropertiesKt.child(StandardNames.FqNames.map, "values"), Name.identifier("values")), TuplesKt.m181to(BuiltinSpecialPropertiesKt.child(StandardNames.FqNames.map, RemoteConfigConstants.ResponseFieldKey.ENTRIES), Name.identifier("entrySet")));
        PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP = mapOf;
        Iterable<Map.Entry> entrySet = mapOf.entrySet();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entrySet, 10));
        for (Map.Entry entry : entrySet) {
            arrayList.add(new Pair(((FqName) entry.getKey()).shortName(), entry.getValue()));
        }
        Map<Name, List<Name>> linkedHashMap = new LinkedHashMap<>();
        for (Pair pair : (List) arrayList) {
            Name name = (Name) pair.getSecond();
            List<Name> list = linkedHashMap.get(name);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(name, list);
            }
            list.add((Name) pair.getFirst());
        }
        GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP = linkedHashMap;
        Set<FqName> keySet = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP.keySet();
        SPECIAL_FQ_NAMES = keySet;
        Iterable<FqName> iterable = keySet;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (FqName shortName : iterable) {
            arrayList2.add(shortName.shortName());
        }
        SPECIAL_SHORT_NAMES = CollectionsKt.toSet((List) arrayList2);
    }

    public final Set<FqName> getSPECIAL_FQ_NAMES() {
        return SPECIAL_FQ_NAMES;
    }

    public final Set<Name> getSPECIAL_SHORT_NAMES() {
        return SPECIAL_SHORT_NAMES;
    }

    public final List<Name> getPropertyNameCandidatesBySpecialGetterName(Name name) {
        Intrinsics.checkNotNullParameter(name, "name1");
        List<Name> list = GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP.get(name);
        return list == null ? CollectionsKt.emptyList() : list;
    }
}
