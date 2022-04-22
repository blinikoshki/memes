package org.junit.runners;

import java.lang.reflect.Method;
import java.util.Comparator;
import org.junit.internal.MethodSorter;

public enum MethodSorters {
    NAME_ASCENDING(MethodSorter.NAME_ASCENDING),
    JVM((String) null),
    DEFAULT(MethodSorter.DEFAULT);
    
    private final Comparator<Method> comparator;

    private MethodSorters(Comparator<Method> comparator2) {
        this.comparator = comparator2;
    }

    public Comparator<Method> getComparator() {
        return this.comparator;
    }
}
