package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.appsflyer.share.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.resolve.MemberComparator;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import kotlin.sequences.SequencesKt;

/* compiled from: DeserializedMemberScope.kt */
public abstract class DeserializedMemberScope extends MemberScopeImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final DeserializationContext f365c;
    private final NotNullLazyValue classNames$delegate;
    private final NullableLazyValue classifierNamesLazy$delegate;
    /* access modifiers changed from: private */
    public final Implementation impl;

    /* compiled from: DeserializedMemberScope.kt */
    private interface Implementation {
        void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> collection, DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1, LookupLocation lookupLocation);

        Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation);

        Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation);

        Set<Name> getFunctionNames();

        TypeAliasDescriptor getTypeAliasByName(Name name);

        Set<Name> getTypeAliasNames();

        Set<Name> getVariableNames();
    }

    /* access modifiers changed from: protected */
    public abstract void addEnumEntryDescriptors(Collection<DeclarationDescriptor> collection, Function1<? super Name, Boolean> function1);

    /* access modifiers changed from: protected */
    public void computeNonDeclaredFunctions(Name name, List<SimpleFunctionDescriptor> list) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(list, "functions");
    }

    /* access modifiers changed from: protected */
    public void computeNonDeclaredProperties(Name name, List<PropertyDescriptor> list) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(list, "descriptors");
    }

    /* access modifiers changed from: protected */
    public abstract ClassId createClassId(Name name);

    /* access modifiers changed from: protected */
    public abstract Set<Name> getNonDeclaredClassifierNames();

    /* access modifiers changed from: protected */
    public abstract Set<Name> getNonDeclaredFunctionNames();

    /* access modifiers changed from: protected */
    public abstract Set<Name> getNonDeclaredVariableNames();

    /* access modifiers changed from: protected */
    public boolean isDeclaredFunctionAvailable(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Intrinsics.checkNotNullParameter(simpleFunctionDescriptor, "function");
        return true;
    }

    /* access modifiers changed from: protected */
    public final DeserializationContext getC() {
        return this.f365c;
    }

    protected DeserializedMemberScope(DeserializationContext deserializationContext, List<ProtoBuf.Function> list, List<ProtoBuf.Property> list2, List<ProtoBuf.TypeAlias> list3, Function0<? extends Collection<Name>> function0) {
        Intrinsics.checkNotNullParameter(deserializationContext, Constants.URL_CAMPAIGN);
        Intrinsics.checkNotNullParameter(list, "functionList");
        Intrinsics.checkNotNullParameter(list2, "propertyList");
        Intrinsics.checkNotNullParameter(list3, "typeAliasList");
        Intrinsics.checkNotNullParameter(function0, "classNames");
        this.f365c = deserializationContext;
        this.impl = createImplementation(list, list2, list3);
        this.classNames$delegate = deserializationContext.getStorageManager().createLazyValue(new DeserializedMemberScope$classNames$2(function0));
        this.classifierNamesLazy$delegate = deserializationContext.getStorageManager().createNullableLazyValue(new DeserializedMemberScope$classifierNamesLazy$2(this));
    }

    static {
        Class<DeserializedMemberScope> cls = DeserializedMemberScope.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "classNames", "getClassNames$deserialization()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;"))};
    }

    public final Set<Name> getClassNames$deserialization() {
        return (Set) StorageKt.getValue(this.classNames$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final Set<Name> getClassifierNamesLazy() {
        return (Set) StorageKt.getValue(this.classifierNamesLazy$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[1]);
    }

    public Set<Name> getFunctionNames() {
        return this.impl.getFunctionNames();
    }

    public Set<Name> getVariableNames() {
        return this.impl.getVariableNames();
    }

    public Set<Name> getClassifierNames() {
        return getClassifierNamesLazy();
    }

    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        return this.impl.getContributedFunctions(name, lookupLocation);
    }

    private final TypeAliasDescriptor getTypeAliasByName(Name name) {
        return this.impl.getTypeAliasByName(name);
    }

    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        return this.impl.getContributedVariables(name, lookupLocation);
    }

    /* access modifiers changed from: protected */
    public final Collection<DeclarationDescriptor> computeDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        ArrayList arrayList = new ArrayList(0);
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getSINGLETON_CLASSIFIERS_MASK())) {
            addEnumEntryDescriptors(arrayList, function1);
        }
        Collection collection = arrayList;
        this.impl.addFunctionsAndPropertiesTo(collection, descriptorKindFilter, function1, lookupLocation);
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK())) {
            for (Name next : getClassNames$deserialization()) {
                if (function1.invoke(next).booleanValue()) {
                    CollectionsKt.addIfNotNull(collection, deserializeClass(next));
                }
            }
        }
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getTYPE_ALIASES_MASK())) {
            for (Name next2 : this.impl.getTypeAliasNames()) {
                if (function1.invoke(next2).booleanValue()) {
                    CollectionsKt.addIfNotNull(collection, this.impl.getTypeAliasByName(next2));
                }
            }
        }
        return CollectionsKt.compact(arrayList);
    }

    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        if (hasClass(name)) {
            return deserializeClass(name);
        }
        if (this.impl.getTypeAliasNames().contains(name)) {
            return getTypeAliasByName(name);
        }
        return null;
    }

    private final ClassDescriptor deserializeClass(Name name) {
        return this.f365c.getComponents().deserializeClass(createClassId(name));
    }

    /* access modifiers changed from: protected */
    public boolean hasClass(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getClassNames$deserialization().contains(name);
    }

    private final Implementation createImplementation(List<ProtoBuf.Function> list, List<ProtoBuf.Property> list2, List<ProtoBuf.TypeAlias> list3) {
        if (this.f365c.getComponents().getConfiguration().getPreserveDeclarationsOrdering()) {
            return new NoReorderImplementation(this, list, list2, list3);
        }
        return new OptimizedImplementation(this, list, list2, list3);
    }

    /* compiled from: DeserializedMemberScope.kt */
    private final class OptimizedImplementation implements Implementation {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
        private final NotNullLazyValue functionNames$delegate;
        /* access modifiers changed from: private */
        public final Map<Name, byte[]> functionProtosBytes;
        private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> functions;
        private final MemoizedFunctionToNotNull<Name, Collection<PropertyDescriptor>> properties;
        /* access modifiers changed from: private */
        public final Map<Name, byte[]> propertyProtosBytes;
        final /* synthetic */ DeserializedMemberScope this$0;
        private final MemoizedFunctionToNullable<Name, TypeAliasDescriptor> typeAliasByName;
        private final Map<Name, byte[]> typeAliasBytes;
        private final NotNullLazyValue variableNames$delegate;

        public OptimizedImplementation(DeserializedMemberScope deserializedMemberScope, List<ProtoBuf.Function> list, List<ProtoBuf.Property> list2, List<ProtoBuf.TypeAlias> list3) {
            Map<Name, byte[]> map;
            Intrinsics.checkNotNullParameter(deserializedMemberScope, "this$0");
            Intrinsics.checkNotNullParameter(list, "functionList");
            Intrinsics.checkNotNullParameter(list2, "propertyList");
            Intrinsics.checkNotNullParameter(list3, "typeAliasList");
            this.this$0 = deserializedMemberScope;
            Map linkedHashMap = new LinkedHashMap();
            for (Object next : list) {
                Name name = NameResolverUtilKt.getName(deserializedMemberScope.f365c.getNameResolver(), ((ProtoBuf.Function) ((MessageLite) next)).getName());
                Object obj = linkedHashMap.get(name);
                if (obj == null) {
                    obj = new ArrayList();
                    linkedHashMap.put(name, obj);
                }
                ((List) obj).add(next);
            }
            this.functionProtosBytes = packToByteArray(linkedHashMap);
            DeserializedMemberScope deserializedMemberScope2 = this.this$0;
            Map linkedHashMap2 = new LinkedHashMap();
            for (Object next2 : list2) {
                Name name2 = NameResolverUtilKt.getName(deserializedMemberScope2.f365c.getNameResolver(), ((ProtoBuf.Property) ((MessageLite) next2)).getName());
                Object obj2 = linkedHashMap2.get(name2);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap2.put(name2, obj2);
                }
                ((List) obj2).add(next2);
            }
            this.propertyProtosBytes = packToByteArray(linkedHashMap2);
            if (this.this$0.getC().getComponents().getConfiguration().getTypeAliasesAllowed()) {
                DeserializedMemberScope deserializedMemberScope3 = this.this$0;
                Map linkedHashMap3 = new LinkedHashMap();
                for (Object next3 : list3) {
                    Name name3 = NameResolverUtilKt.getName(deserializedMemberScope3.f365c.getNameResolver(), ((ProtoBuf.TypeAlias) ((MessageLite) next3)).getName());
                    Object obj3 = linkedHashMap3.get(name3);
                    if (obj3 == null) {
                        obj3 = new ArrayList();
                        linkedHashMap3.put(name3, obj3);
                    }
                    ((List) obj3).add(next3);
                }
                map = packToByteArray(linkedHashMap3);
            } else {
                map = MapsKt.emptyMap();
            }
            this.typeAliasBytes = map;
            this.functions = this.this$0.getC().getStorageManager().createMemoizedFunction(new DeserializedMemberScope$OptimizedImplementation$functions$1(this));
            this.properties = this.this$0.getC().getStorageManager().createMemoizedFunction(new DeserializedMemberScope$OptimizedImplementation$properties$1(this));
            this.typeAliasByName = this.this$0.getC().getStorageManager().createMemoizedFunctionWithNullableValues(new C2196x48b4056b(this));
            this.functionNames$delegate = this.this$0.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$OptimizedImplementation$functionNames$2(this, this.this$0));
            this.variableNames$delegate = this.this$0.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$OptimizedImplementation$variableNames$2(this, this.this$0));
        }

        static {
            Class<OptimizedImplementation> cls = OptimizedImplementation.class;
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "functionNames", "getFunctionNames()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        }

        public Set<Name> getFunctionNames() {
            return (Set) StorageKt.getValue(this.functionNames$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[0]);
        }

        public Set<Name> getVariableNames() {
            return (Set) StorageKt.getValue(this.variableNames$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[1]);
        }

        public Set<Name> getTypeAliasNames() {
            return this.typeAliasBytes.keySet();
        }

        /* access modifiers changed from: private */
        public final Collection<SimpleFunctionDescriptor> computeFunctions(Name name) {
            List list;
            Collection<ProtoBuf.Function> collection;
            Map<Name, byte[]> map = this.functionProtosBytes;
            Parser<ProtoBuf.Function> parser = ProtoBuf.Function.PARSER;
            Intrinsics.checkNotNullExpressionValue(parser, "PARSER");
            DeserializedMemberScope deserializedMemberScope = this.this$0;
            byte[] bArr = map.get(name);
            if (bArr == null) {
                list = null;
            } else {
                list = SequencesKt.toList(SequencesKt.generateSequence(new C2195xb5e458c1(parser, new ByteArrayInputStream(bArr), this.this$0)));
            }
            if (list == null) {
                collection = kotlin.collections.CollectionsKt.emptyList();
            } else {
                collection = list;
            }
            Collection arrayList = new ArrayList(collection.size());
            for (ProtoBuf.Function function : collection) {
                MemberDeserializer memberDeserializer = deserializedMemberScope.getC().getMemberDeserializer();
                Intrinsics.checkNotNullExpressionValue(function, "it");
                SimpleFunctionDescriptor loadFunction = memberDeserializer.loadFunction(function);
                if (!deserializedMemberScope.isDeclaredFunctionAvailable(loadFunction)) {
                    loadFunction = null;
                }
                if (loadFunction != null) {
                    arrayList.add(loadFunction);
                }
            }
            ArrayList arrayList2 = (ArrayList) arrayList;
            deserializedMemberScope.computeNonDeclaredFunctions(name, arrayList2);
            return CollectionsKt.compact(arrayList2);
        }

        /* access modifiers changed from: private */
        public final Collection<PropertyDescriptor> computeProperties(Name name) {
            List list;
            Collection<ProtoBuf.Property> collection;
            Map<Name, byte[]> map = this.propertyProtosBytes;
            Parser<ProtoBuf.Property> parser = ProtoBuf.Property.PARSER;
            Intrinsics.checkNotNullExpressionValue(parser, "PARSER");
            DeserializedMemberScope deserializedMemberScope = this.this$0;
            byte[] bArr = map.get(name);
            if (bArr == null) {
                list = null;
            } else {
                list = SequencesKt.toList(SequencesKt.generateSequence(new C2195xb5e458c1(parser, new ByteArrayInputStream(bArr), this.this$0)));
            }
            if (list == null) {
                collection = kotlin.collections.CollectionsKt.emptyList();
            } else {
                collection = list;
            }
            Collection arrayList = new ArrayList(collection.size());
            for (ProtoBuf.Property property : collection) {
                MemberDeserializer memberDeserializer = deserializedMemberScope.getC().getMemberDeserializer();
                Intrinsics.checkNotNullExpressionValue(property, "it");
                PropertyDescriptor loadProperty = memberDeserializer.loadProperty(property);
                if (loadProperty != null) {
                    arrayList.add(loadProperty);
                }
            }
            ArrayList arrayList2 = (ArrayList) arrayList;
            deserializedMemberScope.computeNonDeclaredProperties(name, arrayList2);
            return CollectionsKt.compact(arrayList2);
        }

        /* access modifiers changed from: private */
        public final TypeAliasDescriptor createTypeAlias(Name name) {
            ProtoBuf.TypeAlias parseDelimitedFrom;
            byte[] bArr = this.typeAliasBytes.get(name);
            if (bArr == null || (parseDelimitedFrom = ProtoBuf.TypeAlias.parseDelimitedFrom(new ByteArrayInputStream(bArr), this.this$0.getC().getComponents().getExtensionRegistryLite())) == null) {
                return null;
            }
            return this.this$0.getC().getMemberDeserializer().loadTypeAlias(parseDelimitedFrom);
        }

        public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
            if (!getFunctionNames().contains(name)) {
                return kotlin.collections.CollectionsKt.emptyList();
            }
            return this.functions.invoke(name);
        }

        public TypeAliasDescriptor getTypeAliasByName(Name name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return this.typeAliasByName.invoke(name);
        }

        public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
            if (!getVariableNames().contains(name)) {
                return kotlin.collections.CollectionsKt.emptyList();
            }
            return this.properties.invoke(name);
        }

        public void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> collection, DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1, LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(collection, "result");
            Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
            Intrinsics.checkNotNullParameter(function1, "nameFilter");
            Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
            if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK())) {
                ArrayList arrayList = new ArrayList();
                for (Name name : getVariableNames()) {
                    if (function1.invoke(name).booleanValue()) {
                        arrayList.addAll(getContributedVariables(name, lookupLocation));
                    }
                }
                MemberComparator.NameAndTypeMemberComparator nameAndTypeMemberComparator = MemberComparator.NameAndTypeMemberComparator.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(nameAndTypeMemberComparator, "INSTANCE");
                kotlin.collections.CollectionsKt.sortWith(arrayList, nameAndTypeMemberComparator);
                collection.addAll(arrayList);
            }
            if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK())) {
                ArrayList arrayList2 = new ArrayList();
                for (Name name2 : getFunctionNames()) {
                    if (function1.invoke(name2).booleanValue()) {
                        arrayList2.addAll(getContributedFunctions(name2, lookupLocation));
                    }
                }
                MemberComparator.NameAndTypeMemberComparator nameAndTypeMemberComparator2 = MemberComparator.NameAndTypeMemberComparator.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(nameAndTypeMemberComparator2, "INSTANCE");
                kotlin.collections.CollectionsKt.sortWith(arrayList2, nameAndTypeMemberComparator2);
                collection.addAll(arrayList2);
            }
        }

        private final Map<Name, byte[]> packToByteArray(Map<Name, ? extends Collection<? extends AbstractMessageLite>> map) {
            Map<Name, byte[]> linkedHashMap = new LinkedHashMap<>(MapsKt.mapCapacity(map.size()));
            for (Map.Entry entry : map.entrySet()) {
                Object key = entry.getKey();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Iterable<AbstractMessageLite> iterable = (Iterable) entry.getValue();
                Collection arrayList = new ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (AbstractMessageLite writeDelimitedTo : iterable) {
                    writeDelimitedTo.writeDelimitedTo(byteArrayOutputStream);
                    arrayList.add(Unit.INSTANCE);
                }
                List list = (List) arrayList;
                linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
            }
            return linkedHashMap;
        }
    }

    /* compiled from: DeserializedMemberScope.kt */
    private final class NoReorderImplementation implements Implementation {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
        private final NotNullLazyValue allFunctions$delegate;
        private final NotNullLazyValue allProperties$delegate;
        private final NotNullLazyValue allTypeAliases$delegate;
        private final NotNullLazyValue declaredFunctions$delegate;
        private final NotNullLazyValue declaredProperties$delegate;
        /* access modifiers changed from: private */
        public final List<ProtoBuf.Function> functionList;
        private final NotNullLazyValue functionNames$delegate;
        private final NotNullLazyValue functionsByName$delegate;
        private final NotNullLazyValue propertiesByName$delegate;
        /* access modifiers changed from: private */
        public final List<ProtoBuf.Property> propertyList;
        final /* synthetic */ DeserializedMemberScope this$0;
        private final List<ProtoBuf.TypeAlias> typeAliasList;
        private final NotNullLazyValue typeAliasesByName$delegate;
        private final NotNullLazyValue variableNames$delegate;

        public NoReorderImplementation(DeserializedMemberScope deserializedMemberScope, List<ProtoBuf.Function> list, List<ProtoBuf.Property> list2, List<ProtoBuf.TypeAlias> list3) {
            Intrinsics.checkNotNullParameter(deserializedMemberScope, "this$0");
            Intrinsics.checkNotNullParameter(list, "functionList");
            Intrinsics.checkNotNullParameter(list2, "propertyList");
            Intrinsics.checkNotNullParameter(list3, "typeAliasList");
            this.this$0 = deserializedMemberScope;
            this.functionList = list;
            this.propertyList = list2;
            this.typeAliasList = !deserializedMemberScope.getC().getComponents().getConfiguration().getTypeAliasesAllowed() ? kotlin.collections.CollectionsKt.emptyList() : list3;
            this.declaredFunctions$delegate = deserializedMemberScope.getC().getStorageManager().createLazyValue(new C2190x2e9e69e8(this));
            this.declaredProperties$delegate = deserializedMemberScope.getC().getStorageManager().createLazyValue(new C2191x7d574862(this));
            this.allTypeAliases$delegate = deserializedMemberScope.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$allTypeAliases$2(this));
            this.allFunctions$delegate = deserializedMemberScope.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$allFunctions$2(this));
            this.allProperties$delegate = deserializedMemberScope.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$allProperties$2(this));
            this.typeAliasesByName$delegate = deserializedMemberScope.getC().getStorageManager().createLazyValue(new C2194xb136a72d(this));
            this.functionsByName$delegate = deserializedMemberScope.getC().getStorageManager().createLazyValue(new C2192x615757a4(this));
            this.propertiesByName$delegate = deserializedMemberScope.getC().getStorageManager().createLazyValue(new C2193xd0ec09aa(this));
            this.functionNames$delegate = deserializedMemberScope.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$functionNames$2(this, deserializedMemberScope));
            this.variableNames$delegate = deserializedMemberScope.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$variableNames$2(this, deserializedMemberScope));
        }

        static {
            Class<NoReorderImplementation> cls = NoReorderImplementation.class;
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "declaredProperties", "getDeclaredProperties()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "allTypeAliases", "getAllTypeAliases()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "allFunctions", "getAllFunctions()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "allProperties", "getAllProperties()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "functionsByName", "getFunctionsByName()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "propertiesByName", "getPropertiesByName()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "functionNames", "getFunctionNames()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        }

        /* access modifiers changed from: private */
        public final List<SimpleFunctionDescriptor> getDeclaredFunctions() {
            return (List) StorageKt.getValue(this.declaredFunctions$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[0]);
        }

        /* access modifiers changed from: private */
        public final List<PropertyDescriptor> getDeclaredProperties() {
            return (List) StorageKt.getValue(this.declaredProperties$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[1]);
        }

        /* access modifiers changed from: private */
        public final List<TypeAliasDescriptor> getAllTypeAliases() {
            return (List) StorageKt.getValue(this.allTypeAliases$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[2]);
        }

        /* access modifiers changed from: private */
        public final List<SimpleFunctionDescriptor> getAllFunctions() {
            return (List) StorageKt.getValue(this.allFunctions$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[3]);
        }

        /* access modifiers changed from: private */
        public final List<PropertyDescriptor> getAllProperties() {
            return (List) StorageKt.getValue(this.allProperties$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[4]);
        }

        private final Map<Name, TypeAliasDescriptor> getTypeAliasesByName() {
            return (Map) StorageKt.getValue(this.typeAliasesByName$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[5]);
        }

        private final Map<Name, Collection<SimpleFunctionDescriptor>> getFunctionsByName() {
            return (Map) StorageKt.getValue(this.functionsByName$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[6]);
        }

        private final Map<Name, Collection<PropertyDescriptor>> getPropertiesByName() {
            return (Map) StorageKt.getValue(this.propertiesByName$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[7]);
        }

        public Set<Name> getFunctionNames() {
            return (Set) StorageKt.getValue(this.functionNames$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[8]);
        }

        public Set<Name> getVariableNames() {
            return (Set) StorageKt.getValue(this.variableNames$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[9]);
        }

        public Set<Name> getTypeAliasNames() {
            Collection linkedHashSet = new LinkedHashSet();
            DeserializedMemberScope deserializedMemberScope = this.this$0;
            for (MessageLite messageLite : this.typeAliasList) {
                linkedHashSet.add(NameResolverUtilKt.getName(deserializedMemberScope.f365c.getNameResolver(), ((ProtoBuf.TypeAlias) messageLite).getName()));
            }
            return (Set) linkedHashSet;
        }

        /* access modifiers changed from: private */
        public final List<SimpleFunctionDescriptor> computeFunctions() {
            List<ProtoBuf.Function> list = this.functionList;
            DeserializedMemberScope deserializedMemberScope = this.this$0;
            Collection arrayList = new ArrayList();
            for (MessageLite messageLite : list) {
                SimpleFunctionDescriptor loadFunction = deserializedMemberScope.f365c.getMemberDeserializer().loadFunction((ProtoBuf.Function) messageLite);
                if (!deserializedMemberScope.isDeclaredFunctionAvailable(loadFunction)) {
                    loadFunction = null;
                }
                MemberDescriptor memberDescriptor = loadFunction;
                if (memberDescriptor != null) {
                    arrayList.add(memberDescriptor);
                }
            }
            return (List) arrayList;
        }

        /* access modifiers changed from: private */
        public final List<PropertyDescriptor> computeProperties() {
            DeserializedMemberScope deserializedMemberScope = this.this$0;
            Collection arrayList = new ArrayList();
            for (MessageLite messageLite : this.propertyList) {
                MemberDescriptor loadProperty = deserializedMemberScope.f365c.getMemberDeserializer().loadProperty((ProtoBuf.Property) messageLite);
                if (loadProperty != null) {
                    arrayList.add(loadProperty);
                }
            }
            return (List) arrayList;
        }

        /* access modifiers changed from: private */
        public final List<TypeAliasDescriptor> computeTypeAliases() {
            DeserializedMemberScope deserializedMemberScope = this.this$0;
            Collection arrayList = new ArrayList();
            for (MessageLite messageLite : this.typeAliasList) {
                MemberDescriptor loadTypeAlias = deserializedMemberScope.f365c.getMemberDeserializer().loadTypeAlias((ProtoBuf.TypeAlias) messageLite);
                if (loadTypeAlias != null) {
                    arrayList.add(loadTypeAlias);
                }
            }
            return (List) arrayList;
        }

        /* access modifiers changed from: private */
        public final List<SimpleFunctionDescriptor> computeAllNonDeclaredFunctions() {
            Collection arrayList = new ArrayList();
            for (Name computeNonDeclaredFunctionsForName : this.this$0.getNonDeclaredFunctionNames()) {
                kotlin.collections.CollectionsKt.addAll(arrayList, computeNonDeclaredFunctionsForName(computeNonDeclaredFunctionsForName));
            }
            return (List) arrayList;
        }

        /* access modifiers changed from: private */
        public final List<PropertyDescriptor> computeAllNonDeclaredProperties() {
            Collection arrayList = new ArrayList();
            for (Name computeNonDeclaredPropertiesForName : this.this$0.getNonDeclaredVariableNames()) {
                kotlin.collections.CollectionsKt.addAll(arrayList, computeNonDeclaredPropertiesForName(computeNonDeclaredPropertiesForName));
            }
            return (List) arrayList;
        }

        private final List<SimpleFunctionDescriptor> computeNonDeclaredFunctionsForName(Name name) {
            List<SimpleFunctionDescriptor> declaredFunctions = getDeclaredFunctions();
            DeserializedMemberScope deserializedMemberScope = this.this$0;
            Collection arrayList = new ArrayList();
            for (Object next : declaredFunctions) {
                if (Intrinsics.areEqual((Object) ((DeclarationDescriptor) next).getName(), (Object) name)) {
                    arrayList.add(next);
                }
            }
            List list = (List) arrayList;
            int size = list.size();
            deserializedMemberScope.computeNonDeclaredFunctions(name, list);
            return list.subList(size, list.size());
        }

        private final List<PropertyDescriptor> computeNonDeclaredPropertiesForName(Name name) {
            List<PropertyDescriptor> declaredProperties = getDeclaredProperties();
            DeserializedMemberScope deserializedMemberScope = this.this$0;
            Collection arrayList = new ArrayList();
            for (Object next : declaredProperties) {
                if (Intrinsics.areEqual((Object) ((DeclarationDescriptor) next).getName(), (Object) name)) {
                    arrayList.add(next);
                }
            }
            List list = (List) arrayList;
            int size = list.size();
            deserializedMemberScope.computeNonDeclaredProperties(name, list);
            return list.subList(size, list.size());
        }

        public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
            if (!getFunctionNames().contains(name)) {
                return kotlin.collections.CollectionsKt.emptyList();
            }
            Collection<SimpleFunctionDescriptor> collection = getFunctionsByName().get(name);
            return collection != null ? collection : kotlin.collections.CollectionsKt.emptyList();
        }

        public TypeAliasDescriptor getTypeAliasByName(Name name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return getTypeAliasesByName().get(name);
        }

        public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
            if (!getVariableNames().contains(name)) {
                return kotlin.collections.CollectionsKt.emptyList();
            }
            Collection<PropertyDescriptor> collection = getPropertiesByName().get(name);
            return collection != null ? collection : kotlin.collections.CollectionsKt.emptyList();
        }

        public void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> collection, DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1, LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(collection, "result");
            Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
            Intrinsics.checkNotNullParameter(function1, "nameFilter");
            Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
            if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK())) {
                for (Object next : getAllProperties()) {
                    Name name = ((PropertyDescriptor) next).getName();
                    Intrinsics.checkNotNullExpressionValue(name, "it.name");
                    if (function1.invoke(name).booleanValue()) {
                        collection.add(next);
                    }
                }
            }
            if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK())) {
                for (Object next2 : getAllFunctions()) {
                    Name name2 = ((SimpleFunctionDescriptor) next2).getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "it.name");
                    if (function1.invoke(name2).booleanValue()) {
                        collection.add(next2);
                    }
                }
            }
        }
    }
}
