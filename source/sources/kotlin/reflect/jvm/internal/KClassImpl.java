package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.ClassUtils;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u00052\u00020\u0006:\u0001bB\u0013\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\u0013\u0010Q\u001a\u00020&2\b\u0010R\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u0010S\u001a\b\u0012\u0004\u0012\u00020T0\u00142\u0006\u0010U\u001a\u00020VH\u0016J\u0012\u0010W\u001a\u0004\u0018\u00010X2\u0006\u0010Y\u001a\u00020ZH\u0016J\u0016\u0010[\u001a\b\u0012\u0004\u0012\u00020X0\u00142\u0006\u0010U\u001a\u00020VH\u0016J\b\u0010\\\u001a\u00020ZH\u0016J\u0012\u0010]\u001a\u00020&2\b\u0010^\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010_\u001a\u00020`H\u0002J\b\u0010a\u001a\u00020>H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00190\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0017R3\u0010\u001b\u001a$\u0012 \u0012\u001e \u001e*\u000e\u0018\u00010\u001dR\b\u0012\u0004\u0012\u00028\u00000\u00000\u001dR\b\u0012\u0004\u0012\u00028\u00000\u00000\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"8VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010'R\u0014\u0010(\u001a\u00020&8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010'R\u0014\u0010)\u001a\u00020&8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'R\u0014\u0010*\u001a\u00020&8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010'R\u0014\u0010+\u001a\u00020&8VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010'R\u0014\u0010,\u001a\u00020&8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010'R\u0014\u0010-\u001a\u00020&8VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010'R\u0014\u0010.\u001a\u00020&8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010'R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0014\u00101\u001a\u0002028@X\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u001e\u00105\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003060\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0017R\u001e\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u0017R\u0016\u0010:\u001a\u0004\u0018\u00018\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0016\u0010=\u001a\u0004\u0018\u00010>8VX\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\"\u0010A\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00040\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\u000eR\u0016\u0010C\u001a\u0004\u0018\u00010>8VX\u0004¢\u0006\u0006\u001a\u0004\bD\u0010@R\u0014\u0010E\u001a\u0002028@X\u0004¢\u0006\u0006\u001a\u0004\bF\u00104R\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\bI\u0010\u000eR\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\u000eR\u0016\u0010M\u001a\u0004\u0018\u00010N8VX\u0004¢\u0006\u0006\u001a\u0004\bO\u0010P¨\u0006c"}, mo26107d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "kotlin.jvm.PlatformType", "getData", "()Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "isAbstract", "", "()Z", "isCompanion", "isData", "isFinal", "isFun", "isInner", "isOpen", "isSealed", "getJClass", "()Ljava/lang/Class;", "memberScope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflection", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses", "simpleName", "getSimpleName", "staticScope", "getStaticScope$kotlin_reflection", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "index", "", "getProperties", "hashCode", "isInstance", "value", "reportUnresolvedClass", "", "toString", "Data", "kotlin-reflection"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: KClassImpl.kt */
public final class KClassImpl<T> extends KDeclarationContainerImpl implements KClass<T>, KClassifierImpl, KTypeParameterOwnerImpl {
    private final ReflectProperties.LazyVal<KClassImpl<T>.Data> data;
    private final Class<T> jClass;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 1})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KotlinClassHeader.Kind.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;
            iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;
            iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;
            iArr[KotlinClassHeader.Kind.SYNTHETIC_CLASS.ordinal()] = 4;
            iArr[KotlinClassHeader.Kind.UNKNOWN.ordinal()] = 5;
            iArr[KotlinClassHeader.Kind.CLASS.ordinal()] = 6;
        }
    }

    public Class<T> getJClass() {
        return this.jClass;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010N\u001a\u00020<2\n\u0010O\u001a\u0006\u0012\u0002\b\u00030PH\u0002R%\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR%\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR%\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\bR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0015R-\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\u00058FX\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\n\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\bR%\u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b\u001e\u0010\bR%\u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\"\u0010\n\u001a\u0004\b!\u0010\bR%\u0010#\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0002¢\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b$\u0010\bR\u001b\u0010&\u001a\u00020'8FX\u0002¢\u0006\f\n\u0004\b*\u0010\n\u001a\u0004\b(\u0010)R%\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0002¢\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b,\u0010\bR%\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0002¢\u0006\f\n\u0004\b0\u0010\n\u001a\u0004\b/\u0010\bR%\u00101\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003020\u00058FX\u0002¢\u0006\f\n\u0004\b4\u0010\n\u001a\u0004\b3\u0010\bR#\u00105\u001a\u0004\u0018\u00018\u00008FX\u0002¢\u0006\u0012\n\u0004\b9\u0010:\u0012\u0004\b6\u0010\u001a\u001a\u0004\b7\u00108R\u001d\u0010;\u001a\u0004\u0018\u00010<8FX\u0002¢\u0006\f\n\u0004\b?\u0010\n\u001a\u0004\b=\u0010>R)\u0010@\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u0000020\u00128FX\u0002¢\u0006\f\n\u0004\bB\u0010\n\u001a\u0004\bA\u0010\u0015R\u001d\u0010C\u001a\u0004\u0018\u00010<8FX\u0002¢\u0006\f\n\u0004\bE\u0010\n\u001a\u0004\bD\u0010>R!\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u00128FX\u0002¢\u0006\f\n\u0004\bI\u0010\n\u001a\u0004\bH\u0010\u0015R!\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u00128FX\u0002¢\u0006\f\n\u0004\bM\u0010\n\u001a\u0004\bL\u0010\u0015¨\u0006Q"}, mo26107d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "allMembers", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getAllMembers", "()Ljava/util/Collection;", "allMembers$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "allNonStaticMembers", "getAllNonStaticMembers", "allNonStaticMembers$delegate", "allStaticMembers", "getAllStaticMembers", "allStaticMembers$delegate", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors$annotations", "()V", "getConstructors", "constructors$delegate", "declaredMembers", "getDeclaredMembers", "declaredMembers$delegate", "declaredNonStaticMembers", "getDeclaredNonStaticMembers", "declaredNonStaticMembers$delegate", "declaredStaticMembers", "getDeclaredStaticMembers", "declaredStaticMembers$delegate", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor$delegate", "inheritedNonStaticMembers", "getInheritedNonStaticMembers", "inheritedNonStaticMembers$delegate", "inheritedStaticMembers", "getInheritedStaticMembers", "inheritedStaticMembers$delegate", "nestedClasses", "Lkotlin/reflect/KClass;", "getNestedClasses", "nestedClasses$delegate", "objectInstance", "getObjectInstance$annotations", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "qualifiedName$delegate", "sealedSubclasses", "getSealedSubclasses", "sealedSubclasses$delegate", "simpleName", "getSimpleName", "simpleName$delegate", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes$delegate", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters$delegate", "calculateLocalClassName", "jClass", "Ljava/lang/Class;", "kotlin-reflection"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: KClassImpl.kt */
    public final class Data extends KDeclarationContainerImpl.Data {
        static final /* synthetic */ KProperty[] $$delegatedProperties;
        private final ReflectProperties.LazySoftVal allMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$allMembers$2(this));
        private final ReflectProperties.LazySoftVal allNonStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$allNonStaticMembers$2(this));
        private final ReflectProperties.LazySoftVal allStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$allStaticMembers$2(this));
        private final ReflectProperties.LazySoftVal annotations$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$annotations$2(this));
        private final ReflectProperties.LazySoftVal constructors$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$constructors$2(this));
        private final ReflectProperties.LazySoftVal declaredMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$declaredMembers$2(this));
        private final ReflectProperties.LazySoftVal declaredNonStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$declaredNonStaticMembers$2(this));
        private final ReflectProperties.LazySoftVal declaredStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$declaredStaticMembers$2(this));
        private final ReflectProperties.LazySoftVal descriptor$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$descriptor$2(this));
        private final ReflectProperties.LazySoftVal inheritedNonStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$inheritedNonStaticMembers$2(this));
        private final ReflectProperties.LazySoftVal inheritedStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$inheritedStaticMembers$2(this));
        private final ReflectProperties.LazySoftVal nestedClasses$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$nestedClasses$2(this));
        private final ReflectProperties.LazyVal objectInstance$delegate = ReflectProperties.lazy(new KClassImpl$Data$objectInstance$2(this));
        private final ReflectProperties.LazySoftVal qualifiedName$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$qualifiedName$2(this));
        private final ReflectProperties.LazySoftVal sealedSubclasses$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$sealedSubclasses$2(this));
        private final ReflectProperties.LazySoftVal simpleName$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$simpleName$2(this));
        private final ReflectProperties.LazySoftVal supertypes$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$supertypes$2(this));
        private final ReflectProperties.LazySoftVal typeParameters$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$typeParameters$2(this));

        static {
            Class<Data> cls = Data.class;
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "annotations", "getAnnotations()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "simpleName", "getSimpleName()Ljava/lang/String;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "constructors", "getConstructors()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "typeParameters", "getTypeParameters()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "supertypes", "getSupertypes()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "allMembers", "getAllMembers()Ljava/util/Collection;"))};
        }

        /* access modifiers changed from: private */
        public final Collection<KCallableImpl<?>> getDeclaredStaticMembers() {
            return (Collection) this.declaredStaticMembers$delegate.getValue(this, $$delegatedProperties[11]);
        }

        /* access modifiers changed from: private */
        public final Collection<KCallableImpl<?>> getInheritedNonStaticMembers() {
            return (Collection) this.inheritedNonStaticMembers$delegate.getValue(this, $$delegatedProperties[12]);
        }

        /* access modifiers changed from: private */
        public final Collection<KCallableImpl<?>> getInheritedStaticMembers() {
            return (Collection) this.inheritedStaticMembers$delegate.getValue(this, $$delegatedProperties[13]);
        }

        public final Collection<KCallableImpl<?>> getAllMembers() {
            return (Collection) this.allMembers$delegate.getValue(this, $$delegatedProperties[17]);
        }

        public final Collection<KCallableImpl<?>> getAllNonStaticMembers() {
            return (Collection) this.allNonStaticMembers$delegate.getValue(this, $$delegatedProperties[14]);
        }

        public final Collection<KCallableImpl<?>> getAllStaticMembers() {
            return (Collection) this.allStaticMembers$delegate.getValue(this, $$delegatedProperties[15]);
        }

        public final List<Annotation> getAnnotations() {
            return (List) this.annotations$delegate.getValue(this, $$delegatedProperties[1]);
        }

        public final Collection<KFunction<T>> getConstructors() {
            return (Collection) this.constructors$delegate.getValue(this, $$delegatedProperties[4]);
        }

        public final Collection<KCallableImpl<?>> getDeclaredMembers() {
            return (Collection) this.declaredMembers$delegate.getValue(this, $$delegatedProperties[16]);
        }

        public final Collection<KCallableImpl<?>> getDeclaredNonStaticMembers() {
            return (Collection) this.declaredNonStaticMembers$delegate.getValue(this, $$delegatedProperties[10]);
        }

        public final ClassDescriptor getDescriptor() {
            return (ClassDescriptor) this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
        }

        public final Collection<KClass<?>> getNestedClasses() {
            return (Collection) this.nestedClasses$delegate.getValue(this, $$delegatedProperties[5]);
        }

        public final T getObjectInstance() {
            return this.objectInstance$delegate.getValue(this, $$delegatedProperties[6]);
        }

        public final String getQualifiedName() {
            return (String) this.qualifiedName$delegate.getValue(this, $$delegatedProperties[3]);
        }

        public final List<KClass<? extends T>> getSealedSubclasses() {
            return (List) this.sealedSubclasses$delegate.getValue(this, $$delegatedProperties[9]);
        }

        public final String getSimpleName() {
            return (String) this.simpleName$delegate.getValue(this, $$delegatedProperties[2]);
        }

        public final List<KType> getSupertypes() {
            return (List) this.supertypes$delegate.getValue(this, $$delegatedProperties[8]);
        }

        public final List<KTypeParameter> getTypeParameters() {
            return (List) this.typeParameters$delegate.getValue(this, $$delegatedProperties[7]);
        }

        public Data() {
            super();
        }

        /* access modifiers changed from: private */
        public final String calculateLocalClassName(Class<?> cls) {
            String simpleName = cls.getSimpleName();
            Method enclosingMethod = cls.getEnclosingMethod();
            if (enclosingMethod != null) {
                Intrinsics.checkNotNullExpressionValue(simpleName, "name");
                return StringsKt.substringAfter$default(simpleName, enclosingMethod.getName() + "$", (String) null, 2, (Object) null);
            }
            Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
            if (enclosingConstructor != null) {
                Intrinsics.checkNotNullExpressionValue(simpleName, "name");
                return StringsKt.substringAfter$default(simpleName, enclosingConstructor.getName() + "$", (String) null, 2, (Object) null);
            }
            Intrinsics.checkNotNullExpressionValue(simpleName, "name");
            return StringsKt.substringAfter$default(simpleName, '$', (String) null, 2, (Object) null);
        }
    }

    public KClassImpl(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "jClass");
        this.jClass = cls;
        ReflectProperties.LazyVal<KClassImpl<T>.Data> lazy = ReflectProperties.lazy(new KClassImpl$data$1(this));
        Intrinsics.checkNotNullExpressionValue(lazy, "ReflectProperties.lazy { Data() }");
        this.data = lazy;
    }

    public final ReflectProperties.LazyVal<KClassImpl<T>.Data> getData() {
        return this.data;
    }

    public ClassDescriptor getDescriptor() {
        return this.data.invoke().getDescriptor();
    }

    public List<Annotation> getAnnotations() {
        return this.data.invoke().getAnnotations();
    }

    /* access modifiers changed from: private */
    public final ClassId getClassId() {
        return RuntimeTypeMapper.INSTANCE.mapJvmClassToKotlinClassId(getJClass());
    }

    public final MemberScope getMemberScope$kotlin_reflection() {
        return getDescriptor().getDefaultType().getMemberScope();
    }

    public final MemberScope getStaticScope$kotlin_reflection() {
        MemberScope staticScope = getDescriptor().getStaticScope();
        Intrinsics.checkNotNullExpressionValue(staticScope, "descriptor.staticScope");
        return staticScope;
    }

    public Collection<KCallable<?>> getMembers() {
        return this.data.invoke().getAllMembers();
    }

    public Collection<ConstructorDescriptor> getConstructorDescriptors() {
        ClassDescriptor descriptor = getDescriptor();
        if (descriptor.getKind() == ClassKind.INTERFACE || descriptor.getKind() == ClassKind.OBJECT) {
            return CollectionsKt.emptyList();
        }
        Collection<ClassConstructorDescriptor> constructors = descriptor.getConstructors();
        Intrinsics.checkNotNullExpressionValue(constructors, "descriptor.constructors");
        return constructors;
    }

    public Collection<PropertyDescriptor> getProperties(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return CollectionsKt.plus(getMemberScope$kotlin_reflection().getContributedVariables(name, NoLookupLocation.FROM_REFLECTION), getStaticScope$kotlin_reflection().getContributedVariables(name, NoLookupLocation.FROM_REFLECTION));
    }

    public Collection<FunctionDescriptor> getFunctions(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return CollectionsKt.plus(getMemberScope$kotlin_reflection().getContributedFunctions(name, NoLookupLocation.FROM_REFLECTION), getStaticScope$kotlin_reflection().getContributedFunctions(name, NoLookupLocation.FROM_REFLECTION));
    }

    public PropertyDescriptor getLocalProperty(int i) {
        Class<?> declaringClass;
        if (!Intrinsics.areEqual((Object) getJClass().getSimpleName(), (Object) "DefaultImpls") || (declaringClass = getJClass().getDeclaringClass()) == null || !declaringClass.isInterface()) {
            ClassDescriptor descriptor = getDescriptor();
            if (!(descriptor instanceof DeserializedClassDescriptor)) {
                descriptor = null;
            }
            DeserializedClassDescriptor deserializedClassDescriptor = (DeserializedClassDescriptor) descriptor;
            if (deserializedClassDescriptor == null) {
                return null;
            }
            GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Property>> generatedExtension = JvmProtoBuf.classLocalVariable;
            Intrinsics.checkNotNullExpressionValue(generatedExtension, "JvmProtoBuf.classLocalVariable");
            ProtoBuf.Property property = (ProtoBuf.Property) ProtoBufUtilKt.getExtensionOrNull(deserializedClassDescriptor.getClassProto(), generatedExtension, i);
            if (property != null) {
                return (PropertyDescriptor) UtilKt.deserializeToDescriptor(getJClass(), property, deserializedClassDescriptor.getC().getNameResolver(), deserializedClassDescriptor.getC().getTypeTable(), deserializedClassDescriptor.getMetadataVersion(), KClassImpl$getLocalProperty$2$1$1.INSTANCE);
            }
            return null;
        }
        KClass<?> kotlinClass = JvmClassMappingKt.getKotlinClass(declaringClass);
        Objects.requireNonNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
        return ((KClassImpl) kotlinClass).getLocalProperty(i);
    }

    public String getSimpleName() {
        return this.data.invoke().getSimpleName();
    }

    public String getQualifiedName() {
        return this.data.invoke().getQualifiedName();
    }

    public Collection<KFunction<T>> getConstructors() {
        return this.data.invoke().getConstructors();
    }

    public Collection<KClass<?>> getNestedClasses() {
        return this.data.invoke().getNestedClasses();
    }

    public T getObjectInstance() {
        return this.data.invoke().getObjectInstance();
    }

    public boolean isInstance(Object obj) {
        Integer functionClassArity = ReflectClassUtilKt.getFunctionClassArity(getJClass());
        if (functionClassArity != null) {
            return TypeIntrinsics.isFunctionOfArity(obj, functionClassArity.intValue());
        }
        Class<?> wrapperByPrimitive = ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
        if (wrapperByPrimitive == null) {
            wrapperByPrimitive = getJClass();
        }
        return wrapperByPrimitive.isInstance(obj);
    }

    public List<KTypeParameter> getTypeParameters() {
        return this.data.invoke().getTypeParameters();
    }

    public List<KType> getSupertypes() {
        return this.data.invoke().getSupertypes();
    }

    public List<KClass<? extends T>> getSealedSubclasses() {
        return this.data.invoke().getSealedSubclasses();
    }

    public KVisibility getVisibility() {
        DescriptorVisibility visibility = getDescriptor().getVisibility();
        Intrinsics.checkNotNullExpressionValue(visibility, "descriptor.visibility");
        return UtilKt.toKVisibility(visibility);
    }

    public boolean isFinal() {
        return getDescriptor().getModality() == Modality.FINAL;
    }

    public boolean isOpen() {
        return getDescriptor().getModality() == Modality.OPEN;
    }

    public boolean isAbstract() {
        return getDescriptor().getModality() == Modality.ABSTRACT;
    }

    public boolean isSealed() {
        return getDescriptor().getModality() == Modality.SEALED;
    }

    public boolean isData() {
        return getDescriptor().isData();
    }

    public boolean isInner() {
        return getDescriptor().isInner();
    }

    public boolean isCompanion() {
        return getDescriptor().isCompanionObject();
    }

    public boolean isFun() {
        return getDescriptor().isFun();
    }

    public boolean equals(Object obj) {
        return (obj instanceof KClassImpl) && Intrinsics.areEqual((Object) JvmClassMappingKt.getJavaObjectType(this), (Object) JvmClassMappingKt.getJavaObjectType((KClass) obj));
    }

    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("class ");
        ClassId classId = getClassId();
        FqName packageFqName = classId.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
        if (packageFqName.isRoot()) {
            str = "";
        } else {
            str = packageFqName.asString() + ".";
        }
        String asString = classId.getRelativeClassName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "classId.relativeClassName.asString()");
        sb.append(str + StringsKt.replace$default(asString, (char) ClassUtils.PACKAGE_SEPARATOR_CHAR, '$', false, 4, (Object) null));
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r0 = r0.getClassHeader();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Void reportUnresolvedClass() {
        /*
            r4 = this;
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass$Factory r0 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass.Factory
            java.lang.Class r1 = r4.getJClass()
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass r0 = r0.create(r1)
            if (r0 == 0) goto L_0x0017
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader r0 = r0.getClassHeader()
            if (r0 == 0) goto L_0x0017
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader$Kind r0 = r0.getKind()
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 == 0) goto L_0x0099
            int[] r1 = kotlin.reflect.jvm.internal.KClassImpl.WhenMappings.$EnumSwitchMapping$0
            int r2 = r0.ordinal()
            r1 = r1[r2]
            switch(r1) {
                case 1: goto L_0x0077;
                case 2: goto L_0x0077;
                case 3: goto L_0x0077;
                case 4: goto L_0x0055;
                case 5: goto L_0x002b;
                case 6: goto L_0x0099;
                default: goto L_0x0025;
            }
        L_0x0025:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x002b:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r1 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unknown class: "
            r2.append(r3)
            java.lang.Class r3 = r4.getJClass()
            r2.append(r3)
            java.lang.String r3 = " (kind = "
            r2.append(r3)
            r2.append(r0)
            r0 = 41
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0055:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "This class is an internal synthetic class generated by the Kotlin compiler, such as an anonymous class for a lambda, a SAM wrapper, a callable reference, etc. It's not a Kotlin class or interface, so the reflection "
            r1.append(r2)
            java.lang.String r2 = "library has no idea what declarations does it have. Please use Java reflection to inspect this class: "
            r1.append(r2)
            java.lang.Class r2 = r4.getJClass()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x0077:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Packages and file facades are not yet supported in Kotlin reflection. "
            r1.append(r2)
            java.lang.String r2 = "Meanwhile please use Java reflection to inspect this class: "
            r1.append(r2)
            java.lang.Class r2 = r4.getJClass()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x0099:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r0 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unresolved class: "
            r1.append(r2)
            java.lang.Class r2 = r4.getJClass()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KClassImpl.reportUnresolvedClass():java.lang.Void");
    }
}
