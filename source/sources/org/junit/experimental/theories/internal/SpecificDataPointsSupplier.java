package org.junit.experimental.theories.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.TestClass;

public class SpecificDataPointsSupplier extends AllMembersSupplier {
    public SpecificDataPointsSupplier(TestClass testClass) {
        super(testClass);
    }

    /* access modifiers changed from: protected */
    public Collection<Field> getSingleDataPointFields(ParameterSignature parameterSignature) {
        Collection<Field> singleDataPointFields = super.getSingleDataPointFields(parameterSignature);
        String value = ((FromDataPoints) parameterSignature.getAnnotation(FromDataPoints.class)).value();
        ArrayList arrayList = new ArrayList();
        for (Field next : singleDataPointFields) {
            if (Arrays.asList(((DataPoint) next.getAnnotation(DataPoint.class)).value()).contains(value)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public Collection<Field> getDataPointsFields(ParameterSignature parameterSignature) {
        Collection<Field> dataPointsFields = super.getDataPointsFields(parameterSignature);
        String value = ((FromDataPoints) parameterSignature.getAnnotation(FromDataPoints.class)).value();
        ArrayList arrayList = new ArrayList();
        for (Field next : dataPointsFields) {
            if (Arrays.asList(((DataPoints) next.getAnnotation(DataPoints.class)).value()).contains(value)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public Collection<FrameworkMethod> getSingleDataPointMethods(ParameterSignature parameterSignature) {
        Collection<FrameworkMethod> singleDataPointMethods = super.getSingleDataPointMethods(parameterSignature);
        String value = ((FromDataPoints) parameterSignature.getAnnotation(FromDataPoints.class)).value();
        ArrayList arrayList = new ArrayList();
        for (FrameworkMethod next : singleDataPointMethods) {
            if (Arrays.asList(((DataPoint) next.getAnnotation(DataPoint.class)).value()).contains(value)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public Collection<FrameworkMethod> getDataPointsMethods(ParameterSignature parameterSignature) {
        Collection<FrameworkMethod> dataPointsMethods = super.getDataPointsMethods(parameterSignature);
        String value = ((FromDataPoints) parameterSignature.getAnnotation(FromDataPoints.class)).value();
        ArrayList arrayList = new ArrayList();
        for (FrameworkMethod next : dataPointsMethods) {
            if (Arrays.asList(((DataPoints) next.getAnnotation(DataPoints.class)).value()).contains(value)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
