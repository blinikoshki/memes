package org.junit.experimental.theories;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParameterSignature {
    private static final Map<Class<?>, Class<?>> CONVERTABLE_TYPES_MAP = buildConvertableTypesMap();
    private final Annotation[] annotations;
    private final Class<?> type;

    private static Map<Class<?>, Class<?>> buildConvertableTypesMap() {
        HashMap hashMap = new HashMap();
        putSymmetrically(hashMap, Boolean.TYPE, Boolean.class);
        putSymmetrically(hashMap, Byte.TYPE, Byte.class);
        putSymmetrically(hashMap, Short.TYPE, Short.class);
        putSymmetrically(hashMap, Character.TYPE, Character.class);
        putSymmetrically(hashMap, Integer.TYPE, Integer.class);
        putSymmetrically(hashMap, Long.TYPE, Long.class);
        putSymmetrically(hashMap, Float.TYPE, Float.class);
        putSymmetrically(hashMap, Double.TYPE, Double.class);
        return Collections.unmodifiableMap(hashMap);
    }

    private static <T> void putSymmetrically(Map<T, T> map, T t, T t2) {
        map.put(t, t2);
        map.put(t2, t);
    }

    public static ArrayList<ParameterSignature> signatures(Method method) {
        return signatures(method.getParameterTypes(), method.getParameterAnnotations());
    }

    public static List<ParameterSignature> signatures(Constructor<?> constructor) {
        return signatures(constructor.getParameterTypes(), constructor.getParameterAnnotations());
    }

    private static ArrayList<ParameterSignature> signatures(Class<?>[] clsArr, Annotation[][] annotationArr) {
        ArrayList<ParameterSignature> arrayList = new ArrayList<>();
        for (int i = 0; i < clsArr.length; i++) {
            arrayList.add(new ParameterSignature(clsArr[i], annotationArr[i]));
        }
        return arrayList;
    }

    private ParameterSignature(Class<?> cls, Annotation[] annotationArr) {
        this.type = cls;
        this.annotations = annotationArr;
    }

    public boolean canAcceptValue(Object obj) {
        if (obj == null) {
            return !this.type.isPrimitive();
        }
        return canAcceptType(obj.getClass());
    }

    public boolean canAcceptType(Class<?> cls) {
        return this.type.isAssignableFrom(cls) || isAssignableViaTypeConversion(this.type, cls);
    }

    public boolean canPotentiallyAcceptType(Class<?> cls) {
        return cls.isAssignableFrom(this.type) || isAssignableViaTypeConversion(cls, this.type) || canAcceptType(cls);
    }

    private boolean isAssignableViaTypeConversion(Class<?> cls, Class<?> cls2) {
        Map<Class<?>, Class<?>> map = CONVERTABLE_TYPES_MAP;
        if (map.containsKey(cls2)) {
            return cls.isAssignableFrom(map.get(cls2));
        }
        return false;
    }

    public Class<?> getType() {
        return this.type;
    }

    public List<Annotation> getAnnotations() {
        return Arrays.asList(this.annotations);
    }

    public boolean hasAnnotation(Class<? extends Annotation> cls) {
        return getAnnotation(cls) != null;
    }

    public <T extends Annotation> T findDeepAnnotation(Class<T> cls) {
        return findDeepAnnotation(this.annotations, cls, 3);
    }

    private <T extends Annotation> T findDeepAnnotation(Annotation[] annotationArr, Class<T> cls, int i) {
        if (i == 0) {
            return null;
        }
        for (Annotation annotation : annotationArr) {
            if (cls.isInstance(annotation)) {
                return (Annotation) cls.cast(annotation);
            }
            T findDeepAnnotation = findDeepAnnotation(annotation.annotationType().getAnnotations(), cls, i - 1);
            if (findDeepAnnotation != null) {
                return (Annotation) cls.cast(findDeepAnnotation);
            }
        }
        return null;
    }

    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        for (Annotation next : getAnnotations()) {
            if (cls.isInstance(next)) {
                return (Annotation) cls.cast(next);
            }
        }
        return null;
    }
}
