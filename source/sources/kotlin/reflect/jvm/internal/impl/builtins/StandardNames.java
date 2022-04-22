package kotlin.reflect.jvm.internal.impl.builtins;

import com.facebook.imagepipeline.memory.BitmapPoolType;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: StandardNames.kt */
public final class StandardNames {
    public static final FqName ANNOTATION_PACKAGE_FQ_NAME;
    public static final FqName BUILT_INS_PACKAGE_FQ_NAME;
    public static final Set<FqName> BUILT_INS_PACKAGE_FQ_NAMES;
    public static final Name BUILT_INS_PACKAGE_NAME;
    public static final FqName COLLECTIONS_PACKAGE_FQ_NAME;
    public static final FqName CONTINUATION_INTERFACE_FQ_NAME_EXPERIMENTAL;
    public static final FqName CONTINUATION_INTERFACE_FQ_NAME_RELEASE;
    public static final FqName COROUTINES_INTRINSICS_PACKAGE_FQ_NAME_EXPERIMENTAL;
    public static final FqName COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL;
    public static final FqName COROUTINES_PACKAGE_FQ_NAME_RELEASE;
    public static final Name ENUM_VALUES;
    public static final Name ENUM_VALUE_OF;
    public static final StandardNames INSTANCE = new StandardNames();
    public static final FqName KOTLIN_REFLECT_FQ_NAME;
    public static final List<String> PREFIXES = CollectionsKt.listOf("KProperty", "KMutableProperty", "KFunction", "KSuspendFunction");
    public static final FqName RANGES_PACKAGE_FQ_NAME;
    public static final FqName RESULT_FQ_NAME = new FqName("kotlin.Result");
    public static final FqName TEXT_PACKAGE_FQ_NAME;

    private StandardNames() {
    }

    static {
        Name identifier = Name.identifier("values");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(\"values\")");
        ENUM_VALUES = identifier;
        Name identifier2 = Name.identifier("valueOf");
        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(\"valueOf\")");
        ENUM_VALUE_OF = identifier2;
        FqName fqName = new FqName("kotlin.coroutines");
        COROUTINES_PACKAGE_FQ_NAME_RELEASE = fqName;
        FqName child = fqName.child(Name.identifier(BitmapPoolType.EXPERIMENTAL));
        Intrinsics.checkNotNullExpressionValue(child, "COROUTINES_PACKAGE_FQ_NAME_RELEASE.child(Name.identifier(\"experimental\"))");
        COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL = child;
        FqName child2 = child.child(Name.identifier("intrinsics"));
        Intrinsics.checkNotNullExpressionValue(child2, "COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL.child(Name.identifier(\"intrinsics\"))");
        COROUTINES_INTRINSICS_PACKAGE_FQ_NAME_EXPERIMENTAL = child2;
        FqName child3 = child.child(Name.identifier("Continuation"));
        Intrinsics.checkNotNullExpressionValue(child3, "COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL.child(Name.identifier(\"Continuation\"))");
        CONTINUATION_INTERFACE_FQ_NAME_EXPERIMENTAL = child3;
        FqName child4 = fqName.child(Name.identifier("Continuation"));
        Intrinsics.checkNotNullExpressionValue(child4, "COROUTINES_PACKAGE_FQ_NAME_RELEASE.child(Name.identifier(\"Continuation\"))");
        CONTINUATION_INTERFACE_FQ_NAME_RELEASE = child4;
        FqName fqName2 = new FqName("kotlin.reflect");
        KOTLIN_REFLECT_FQ_NAME = fqName2;
        Name identifier3 = Name.identifier("kotlin");
        Intrinsics.checkNotNullExpressionValue(identifier3, "identifier(\"kotlin\")");
        BUILT_INS_PACKAGE_NAME = identifier3;
        FqName fqName3 = FqName.topLevel(identifier3);
        Intrinsics.checkNotNullExpressionValue(fqName3, "topLevel(BUILT_INS_PACKAGE_NAME)");
        BUILT_INS_PACKAGE_FQ_NAME = fqName3;
        FqName child5 = fqName3.child(Name.identifier("annotation"));
        Intrinsics.checkNotNullExpressionValue(child5, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"annotation\"))");
        ANNOTATION_PACKAGE_FQ_NAME = child5;
        FqName child6 = fqName3.child(Name.identifier("collections"));
        Intrinsics.checkNotNullExpressionValue(child6, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"collections\"))");
        COLLECTIONS_PACKAGE_FQ_NAME = child6;
        FqName child7 = fqName3.child(Name.identifier("ranges"));
        Intrinsics.checkNotNullExpressionValue(child7, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"ranges\"))");
        RANGES_PACKAGE_FQ_NAME = child7;
        FqName child8 = fqName3.child(Name.identifier("text"));
        Intrinsics.checkNotNullExpressionValue(child8, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"text\"))");
        TEXT_PACKAGE_FQ_NAME = child8;
        FqName child9 = fqName3.child(Name.identifier("internal"));
        Intrinsics.checkNotNullExpressionValue(child9, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"internal\"))");
        BUILT_INS_PACKAGE_FQ_NAMES = SetsKt.setOf(fqName3, child6, child7, child5, fqName2, child9, fqName);
    }

    /* compiled from: StandardNames.kt */
    public static final class FqNames {
        public static final FqNames INSTANCE;
        public static final FqNameUnsafe _boolean;
        public static final FqNameUnsafe _byte;
        public static final FqNameUnsafe _char;
        public static final FqNameUnsafe _double;
        public static final FqNameUnsafe _enum;
        public static final FqNameUnsafe _float;
        public static final FqNameUnsafe _int;
        public static final FqNameUnsafe _long;
        public static final FqNameUnsafe _short;
        public static final FqName annotation;
        public static final FqName annotationRetention;
        public static final FqName annotationTarget;
        public static final FqNameUnsafe any;
        public static final FqNameUnsafe array;
        public static final Map<FqNameUnsafe, PrimitiveType> arrayClassFqNameToPrimitiveType;
        public static final FqNameUnsafe charSequence;
        public static final FqNameUnsafe cloneable;
        public static final FqName collection;
        public static final FqName comparable;
        public static final FqName deprecated;
        public static final FqName deprecatedSinceKotlin;
        public static final FqName deprecationLevel;
        public static final FqName extensionFunctionType;
        public static final Map<FqNameUnsafe, PrimitiveType> fqNameToPrimitiveType;
        public static final FqNameUnsafe functionSupertype;
        public static final FqNameUnsafe intRange;
        public static final FqName iterable;
        public static final FqName iterator;
        public static final FqNameUnsafe kCallable = reflect("KCallable");
        public static final FqNameUnsafe kClass = reflect("KClass");
        public static final FqNameUnsafe kDeclarationContainer = reflect("KDeclarationContainer");
        public static final FqNameUnsafe kMutableProperty0 = reflect("KMutableProperty0");
        public static final FqNameUnsafe kMutableProperty1 = reflect("KMutableProperty1");
        public static final FqNameUnsafe kMutableProperty2 = reflect("KMutableProperty2");
        public static final FqNameUnsafe kMutablePropertyFqName = reflect("KMutableProperty");
        public static final ClassId kProperty;
        public static final FqNameUnsafe kProperty0 = reflect("KProperty0");
        public static final FqNameUnsafe kProperty1 = reflect("KProperty1");
        public static final FqNameUnsafe kProperty2 = reflect("KProperty2");
        public static final FqNameUnsafe kPropertyFqName;
        public static final FqName list;
        public static final FqName listIterator;
        public static final FqNameUnsafe longRange;
        public static final FqName map;
        public static final FqName mapEntry;
        public static final FqName mustBeDocumented;
        public static final FqName mutableCollection;
        public static final FqName mutableIterable;
        public static final FqName mutableIterator;
        public static final FqName mutableList;
        public static final FqName mutableListIterator;
        public static final FqName mutableMap;
        public static final FqName mutableMapEntry;
        public static final FqName mutableSet;
        public static final FqNameUnsafe nothing;
        public static final FqNameUnsafe number;
        public static final FqName parameterName;
        public static final Set<Name> primitiveArrayTypeShortNames;
        public static final Set<Name> primitiveTypeShortNames;
        public static final FqName publishedApi;
        public static final FqName repeatable;
        public static final FqName replaceWith;
        public static final FqName retention;
        public static final FqName set;
        public static final FqNameUnsafe string;
        public static final FqName suppress;
        public static final FqName target;
        public static final FqName throwable;
        public static final ClassId uByte;
        public static final FqName uByteArrayFqName;
        public static final FqName uByteFqName;
        public static final ClassId uInt;
        public static final FqName uIntArrayFqName;
        public static final FqName uIntFqName;
        public static final ClassId uLong;
        public static final FqName uLongArrayFqName;
        public static final FqName uLongFqName;
        public static final ClassId uShort;
        public static final FqName uShortArrayFqName;
        public static final FqName uShortFqName;
        public static final FqNameUnsafe unit;
        public static final FqName unsafeVariance;

        private FqNames() {
        }

        static {
            FqNames fqNames = new FqNames();
            INSTANCE = fqNames;
            any = fqNames.fqNameUnsafe("Any");
            nothing = fqNames.fqNameUnsafe("Nothing");
            cloneable = fqNames.fqNameUnsafe("Cloneable");
            suppress = fqNames.fqName("Suppress");
            unit = fqNames.fqNameUnsafe("Unit");
            charSequence = fqNames.fqNameUnsafe("CharSequence");
            string = fqNames.fqNameUnsafe("String");
            array = fqNames.fqNameUnsafe("Array");
            _boolean = fqNames.fqNameUnsafe("Boolean");
            _char = fqNames.fqNameUnsafe("Char");
            _byte = fqNames.fqNameUnsafe("Byte");
            _short = fqNames.fqNameUnsafe("Short");
            _int = fqNames.fqNameUnsafe("Int");
            _long = fqNames.fqNameUnsafe("Long");
            _float = fqNames.fqNameUnsafe("Float");
            _double = fqNames.fqNameUnsafe("Double");
            number = fqNames.fqNameUnsafe("Number");
            _enum = fqNames.fqNameUnsafe("Enum");
            functionSupertype = fqNames.fqNameUnsafe("Function");
            throwable = fqNames.fqName("Throwable");
            comparable = fqNames.fqName("Comparable");
            intRange = fqNames.rangesFqName("IntRange");
            longRange = fqNames.rangesFqName("LongRange");
            deprecated = fqNames.fqName("Deprecated");
            deprecatedSinceKotlin = fqNames.fqName("DeprecatedSinceKotlin");
            deprecationLevel = fqNames.fqName("DeprecationLevel");
            replaceWith = fqNames.fqName("ReplaceWith");
            extensionFunctionType = fqNames.fqName("ExtensionFunctionType");
            parameterName = fqNames.fqName("ParameterName");
            annotation = fqNames.fqName("Annotation");
            target = fqNames.annotationName("Target");
            annotationTarget = fqNames.annotationName("AnnotationTarget");
            annotationRetention = fqNames.annotationName("AnnotationRetention");
            retention = fqNames.annotationName("Retention");
            repeatable = fqNames.annotationName("Repeatable");
            mustBeDocumented = fqNames.annotationName("MustBeDocumented");
            unsafeVariance = fqNames.fqName("UnsafeVariance");
            publishedApi = fqNames.fqName("PublishedApi");
            iterator = fqNames.collectionsFqName("Iterator");
            iterable = fqNames.collectionsFqName("Iterable");
            collection = fqNames.collectionsFqName("Collection");
            list = fqNames.collectionsFqName("List");
            listIterator = fqNames.collectionsFqName("ListIterator");
            set = fqNames.collectionsFqName("Set");
            FqName collectionsFqName = fqNames.collectionsFqName("Map");
            map = collectionsFqName;
            FqName child = collectionsFqName.child(Name.identifier("Entry"));
            Intrinsics.checkNotNullExpressionValue(child, "map.child(Name.identifier(\"Entry\"))");
            mapEntry = child;
            mutableIterator = fqNames.collectionsFqName("MutableIterator");
            mutableIterable = fqNames.collectionsFqName("MutableIterable");
            mutableCollection = fqNames.collectionsFqName("MutableCollection");
            mutableList = fqNames.collectionsFqName("MutableList");
            FqNames fqNames2 = INSTANCE;
            mutableListIterator = fqNames2.collectionsFqName("MutableListIterator");
            mutableSet = fqNames2.collectionsFqName("MutableSet");
            FqName collectionsFqName2 = fqNames2.collectionsFqName("MutableMap");
            mutableMap = collectionsFqName2;
            FqName child2 = collectionsFqName2.child(Name.identifier("MutableEntry"));
            Intrinsics.checkNotNullExpressionValue(child2, "mutableMap.child(Name.identifier(\"MutableEntry\"))");
            mutableMapEntry = child2;
            FqNameUnsafe reflect = reflect("KProperty");
            kPropertyFqName = reflect;
            ClassId classId = ClassId.topLevel(reflect.toSafe());
            Intrinsics.checkNotNullExpressionValue(classId, "topLevel(kPropertyFqName.toSafe())");
            kProperty = classId;
            FqName fqName = fqNames2.fqName("UByte");
            uByteFqName = fqName;
            FqName fqName2 = fqNames2.fqName("UShort");
            uShortFqName = fqName2;
            FqName fqName3 = fqNames2.fqName("UInt");
            uIntFqName = fqName3;
            FqName fqName4 = fqNames2.fqName("ULong");
            uLongFqName = fqName4;
            ClassId classId2 = ClassId.topLevel(fqName);
            Intrinsics.checkNotNullExpressionValue(classId2, "topLevel(uByteFqName)");
            uByte = classId2;
            ClassId classId3 = ClassId.topLevel(fqName2);
            Intrinsics.checkNotNullExpressionValue(classId3, "topLevel(uShortFqName)");
            uShort = classId3;
            ClassId classId4 = ClassId.topLevel(fqName3);
            Intrinsics.checkNotNullExpressionValue(classId4, "topLevel(uIntFqName)");
            uInt = classId4;
            ClassId classId5 = ClassId.topLevel(fqName4);
            Intrinsics.checkNotNullExpressionValue(classId5, "topLevel(uLongFqName)");
            uLong = classId5;
            uByteArrayFqName = fqNames2.fqName("UByteArray");
            uShortArrayFqName = fqNames2.fqName("UShortArray");
            uIntArrayFqName = fqNames2.fqName("UIntArray");
            uLongArrayFqName = fqNames2.fqName("ULongArray");
            HashSet newHashSetWithExpectedSize = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.newHashSetWithExpectedSize(PrimitiveType.values().length);
            int i = 0;
            for (PrimitiveType typeName : PrimitiveType.values()) {
                newHashSetWithExpectedSize.add(typeName.getTypeName());
            }
            Collection collection2 = newHashSetWithExpectedSize;
            primitiveTypeShortNames = newHashSetWithExpectedSize;
            HashSet newHashSetWithExpectedSize2 = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.newHashSetWithExpectedSize(PrimitiveType.values().length);
            for (PrimitiveType arrayTypeName : PrimitiveType.values()) {
                newHashSetWithExpectedSize2.add(arrayTypeName.getArrayTypeName());
            }
            Collection collection3 = newHashSetWithExpectedSize2;
            primitiveArrayTypeShortNames = newHashSetWithExpectedSize2;
            HashMap newHashMapWithExpectedSize = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.newHashMapWithExpectedSize(PrimitiveType.values().length);
            PrimitiveType[] values = PrimitiveType.values();
            int length = values.length;
            int i2 = 0;
            while (i2 < length) {
                PrimitiveType primitiveType = values[i2];
                i2++;
                FqNames fqNames3 = INSTANCE;
                String asString = primitiveType.getTypeName().asString();
                Intrinsics.checkNotNullExpressionValue(asString, "primitiveType.typeName.asString()");
                newHashMapWithExpectedSize.put(fqNames3.fqNameUnsafe(asString), primitiveType);
            }
            fqNameToPrimitiveType = newHashMapWithExpectedSize;
            HashMap newHashMapWithExpectedSize2 = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.newHashMapWithExpectedSize(PrimitiveType.values().length);
            PrimitiveType[] values2 = PrimitiveType.values();
            int length2 = values2.length;
            while (i < length2) {
                PrimitiveType primitiveType2 = values2[i];
                i++;
                FqNames fqNames4 = INSTANCE;
                String asString2 = primitiveType2.getArrayTypeName().asString();
                Intrinsics.checkNotNullExpressionValue(asString2, "primitiveType.arrayTypeName.asString()");
                newHashMapWithExpectedSize2.put(fqNames4.fqNameUnsafe(asString2), primitiveType2);
            }
            arrayClassFqNameToPrimitiveType = newHashMapWithExpectedSize2;
        }

        private final FqNameUnsafe fqNameUnsafe(String str) {
            FqNameUnsafe unsafe = fqName(str).toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe, "fqName(simpleName).toUnsafe()");
            return unsafe;
        }

        private final FqName fqName(String str) {
            FqName child = StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(str));
            Intrinsics.checkNotNullExpressionValue(child, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(simpleName))");
            return child;
        }

        private final FqName collectionsFqName(String str) {
            FqName child = StandardNames.COLLECTIONS_PACKAGE_FQ_NAME.child(Name.identifier(str));
            Intrinsics.checkNotNullExpressionValue(child, "COLLECTIONS_PACKAGE_FQ_NAME.child(Name.identifier(simpleName))");
            return child;
        }

        private final FqNameUnsafe rangesFqName(String str) {
            FqNameUnsafe unsafe = StandardNames.RANGES_PACKAGE_FQ_NAME.child(Name.identifier(str)).toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe, "RANGES_PACKAGE_FQ_NAME.child(Name.identifier(simpleName)).toUnsafe()");
            return unsafe;
        }

        @JvmStatic
        public static final FqNameUnsafe reflect(String str) {
            Intrinsics.checkNotNullParameter(str, "simpleName");
            FqNameUnsafe unsafe = StandardNames.KOTLIN_REFLECT_FQ_NAME.child(Name.identifier(str)).toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe, "KOTLIN_REFLECT_FQ_NAME.child(Name.identifier(simpleName)).toUnsafe()");
            return unsafe;
        }

        private final FqName annotationName(String str) {
            FqName child = StandardNames.ANNOTATION_PACKAGE_FQ_NAME.child(Name.identifier(str));
            Intrinsics.checkNotNullExpressionValue(child, "ANNOTATION_PACKAGE_FQ_NAME.child(Name.identifier(simpleName))");
            return child;
        }
    }

    @JvmStatic
    public static final String getFunctionName(int i) {
        return Intrinsics.stringPlus("Function", Integer.valueOf(i));
    }

    @JvmStatic
    public static final ClassId getFunctionClassId(int i) {
        return new ClassId(BUILT_INS_PACKAGE_FQ_NAME, Name.identifier(getFunctionName(i)));
    }

    @JvmStatic
    public static final String getSuspendFunctionName(int i) {
        return Intrinsics.stringPlus(FunctionClassKind.SuspendFunction.getClassNamePrefix(), Integer.valueOf(i));
    }

    @JvmStatic
    public static final boolean isPrimitiveArray(FqNameUnsafe fqNameUnsafe) {
        Intrinsics.checkNotNullParameter(fqNameUnsafe, "arrayFqName");
        return FqNames.arrayClassFqNameToPrimitiveType.get(fqNameUnsafe) != null;
    }

    @JvmStatic
    public static final FqName getPrimitiveFqName(PrimitiveType primitiveType) {
        Intrinsics.checkNotNullParameter(primitiveType, "primitiveType");
        FqName child = BUILT_INS_PACKAGE_FQ_NAME.child(primitiveType.getTypeName());
        Intrinsics.checkNotNullExpressionValue(child, "BUILT_INS_PACKAGE_FQ_NAME.child(primitiveType.typeName)");
        return child;
    }
}
